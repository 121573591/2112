/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.cache2.FileOperator;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" J\n\n \n\n \n\n \n\t\n \n\n\b\n\n\b\n\n\n\b\n\n\b\r\n\b\n\b\n\n\b\t  E20:EFB5\b\b0\b00\t0\b\n0¢\b\fJ02\r0¢\bJ\r\t0\b¢\b\tJ0¢\bJ'020\b2\r020H¢\bJ02\r0H¢\bR08¢\f\n\b\bR\n08¢\f\n\b\n\b R\"\"0!8@X¢\n\b\"#\b$%\"\b&'R$08@X¢\n\b(\b)*\"\b+,R-0!8F¢\b-%R\t0\b8X¢\n\b\t.R\"00/8@X¢\n\b01\b23\"\b45R$08@X¢\n\b6\b7\"\b89R:08¢\f\n\b:\b;R\"08@X¢\n\b\b< \"\b=R$?0>8@X¢\n\b?@\bAB\"\bCD¨G"}, d2={"Lokhttp3/internal/cache2/Relay;", "", "Ljava/io/RandomAccessFile;", "file", "Lokio/Source;", "upstream", "", "upstreamPos", "Lokio/ByteString;", "metadata", "bufferMaxSize", "<init>", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "upstreamSize", "", "commit", "(J)V", "()Lokio/ByteString;", "newSource", "()Lokio/Source;", "prefix", "metadataSize", "writeHeader", "(Lokio/ByteString;JJ)V", "writeMetadata", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "J", "getBufferMaxSize", "()J", "", "complete", "Z", "getComplete", "()Z", "setComplete", "(Z)V", "Ljava/io/RandomAccessFile;", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "Lokio/ByteString;", "", "sourceCount", "I", "getSourceCount", "()I", "setSourceCount", "(I)V", "Lokio/Source;", "getUpstream", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "Ljava/lang/Thread;", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "Companion", "RelaySource", "okhttp"})
public final class Relay {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private RandomAccessFile file;
    @Nullable
    private Source upstream;
    private long upstreamPos;
    @NotNull
    private final ByteString metadata;
    private final long bufferMaxSize;
    @Nullable
    private Thread upstreamReader;
    @NotNull
    private final Buffer upstreamBuffer;
    private boolean complete;
    @NotNull
    private final Buffer buffer;
    private int sourceCount;
    private static final int SOURCE_UPSTREAM = 1;
    private static final int SOURCE_FILE = 2;
    @JvmField
    @NotNull
    public static final ByteString PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
    @JvmField
    @NotNull
    public static final ByteString PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
    private static final long FILE_HEADER_SIZE = 32L;

    private Relay(RandomAccessFile file, Source upstream, long upstreamPos, ByteString metadata, long bufferMaxSize) {
        this.file = file;
        this.upstream = upstream;
        this.upstreamPos = upstreamPos;
        this.metadata = metadata;
        this.bufferMaxSize = bufferMaxSize;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    public final void setUpstream(@Nullable Source source2) {
        this.upstream = source2;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final void setUpstreamPos(long l) {
        this.upstreamPos = l;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final void setComplete(boolean bl) {
        this.complete = bl;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final void setSourceCount(int n) {
        this.sourceCount = n;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    private final void writeHeader(ByteString prefix, long upstreamSize, long metadataSize) throws IOException {
        Buffer buffer;
        Buffer $this$writeHeader_u24lambda_u240 = buffer = new Buffer();
        boolean bl = false;
        $this$writeHeader_u24lambda_u240.write(prefix);
        $this$writeHeader_u24lambda_u240.writeLong(upstreamSize);
        $this$writeHeader_u24lambda_u240.writeLong(metadataSize);
        if (!($this$writeHeader_u24lambda_u240.size() == 32L)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        Buffer header = buffer;
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull((Object)randomAccessFile);
        FileChannel fileChannel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue((Object)fileChannel, (String)"file!!.channel");
        FileOperator fileOperator = new FileOperator(fileChannel);
        fileOperator.write(0L, header, 32L);
    }

    private final void writeMetadata(long upstreamSize) throws IOException {
        Buffer metadataBuffer = new Buffer();
        metadataBuffer.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull((Object)randomAccessFile);
        FileChannel fileChannel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue((Object)fileChannel, (String)"file!!.channel");
        FileOperator fileOperator = new FileOperator(fileChannel);
        fileOperator.write(32L + upstreamSize, metadataBuffer, this.metadata.size());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void commit(long upstreamSize) throws IOException {
        this.writeMetadata(upstreamSize);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull((Object)randomAccessFile);
        randomAccessFile.getChannel().force(false);
        this.writeHeader(PREFIX_CLEAN, upstreamSize, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.checkNotNull((Object)randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        Relay relay = this;
        synchronized (relay) {
            boolean bl = false;
            this.complete = true;
            Unit unit = Unit.INSTANCE;
        }
        Source source2 = this.upstream;
        if (source2 != null) {
            Util.closeQuietly(source2);
        }
        this.upstream = null;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    public final Source newSource() {
        Relay relay = this;
        synchronized (relay) {
            block4: {
                boolean bl = false;
                if (this.file != null) break block4;
                Source source2 = null;
                return source2;
            }
            int n = this.sourceCount;
            this.sourceCount = n + 1;
            int n2 = n;
        }
        return new RelaySource();
    }

    public /* synthetic */ Relay(RandomAccessFile file, Source upstream, long upstreamPos, ByteString metadata, long bufferMaxSize, DefaultConstructorMarker $constructor_marker) {
        this(file, upstream, upstreamPos, metadata, bufferMaxSize);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 4\n\n \n\b\n\n \n\n \n\n \n\t\n \n\n\b\t\n\b\n\b\b 20B\t\b¢\bJ-\r0\f20202\t0\b20\n¢\b\rJ0\f20¢\bR0\n8XT¢\n\bR0\b8X¢\n\bR0\b8X¢\n\bR08XT¢\n\bR08XT¢\n\b¨"}, d2={"Lokhttp3/internal/cache2/Relay$Companion;", "", "<init>", "()V", "Ljava/io/File;", "file", "Lokio/Source;", "upstream", "Lokio/ByteString;", "metadata", "", "bufferMaxSize", "Lokhttp3/internal/cache2/Relay;", "edit", "(Ljava/io/File;Lokio/Source;Lokio/ByteString;J)Lokhttp3/internal/cache2/Relay;", "read", "(Ljava/io/File;)Lokhttp3/internal/cache2/Relay;", "FILE_HEADER_SIZE", "J", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "", "SOURCE_FILE", "I", "SOURCE_UPSTREAM", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source upstream, @NotNull ByteString metadata, long bufferMaxSize) throws IOException {
            Intrinsics.checkNotNullParameter((Object)file, (String)"file");
            Intrinsics.checkNotNullParameter((Object)upstream, (String)"upstream");
            Intrinsics.checkNotNullParameter((Object)metadata, (String)"metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay result = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize, null);
            randomAccessFile.setLength(0L);
            result.writeHeader(PREFIX_DIRTY, -1L, -1L);
            return result;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            Intrinsics.checkNotNullParameter((Object)file, (String)"file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue((Object)fileChannel, (String)"randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(fileChannel);
            Buffer header = new Buffer();
            fileOperator.read(0L, header, 32L);
            ByteString prefix = header.readByteString(PREFIX_CLEAN.size());
            if (!Intrinsics.areEqual((Object)prefix, (Object)PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long upstreamSize = header.readLong();
            long metadataSize = header.readLong();
            Buffer metadataBuffer = new Buffer();
            fileOperator.read(32L + upstreamSize, metadataBuffer, metadataSize);
            ByteString metadata = metadataBuffer.readByteString();
            return new Relay(randomAccessFile, null, upstreamSize, metadata, 0L, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 2\n\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\b 20B¢\bJ0H¢\bJ0\t2\b02\n0\tH¢\b\fJ0\rH¢\bR08@X¢\n\bR0\t8@X¢\n\bR0\r8X¢\n\b¨"}, d2={"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "", "close", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokhttp3/internal/cache2/FileOperator;", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "J", "Lokio/Timeout;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nRelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Relay.kt\nokhttp3/internal/cache2/Relay$RelaySource\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,356:1\n563#2:357\n*S KotlinDebug\n*F\n+ 1 Relay.kt\nokhttp3/internal/cache2/Relay$RelaySource\n*L\n267#1:357\n*E\n"})
    public final class RelaySource
    implements Source {
        @NotNull
        private final Timeout timeout = new Timeout();
        @Nullable
        private FileOperator fileOperator;
        private long sourcePos;

        public RelaySource() {
            RandomAccessFile randomAccessFile = Relay.this.getFile();
            Intrinsics.checkNotNull((Object)randomAccessFile);
            FileChannel fileChannel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue((Object)fileChannel, (String)"file!!.channel");
            this.fileOperator = new FileOperator(fileChannel);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public long read(@NotNull Buffer sink2, long byteCount) throws IOException {
            Object object;
            long upstreamBytesRead;
            block21: {
                Relay bytesToRead2;
                Relay relay;
                long l;
                int n;
                Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
                if (!(this.fileOperator != null)) {
                    String string = "Check failed.";
                    throw new IllegalStateException(string.toString());
                }
                Relay relay2 = Relay.this;
                Relay relay3 = Relay.this;
                Relay relay4 = relay2;
                synchronized (relay4) {
                    int n2;
                    block20: {
                        long upstreamPos;
                        boolean bl = false;
                        while (this.sourcePos == (upstreamPos = relay3.getUpstreamPos())) {
                            if (relay3.getComplete()) {
                                return -1L;
                            }
                            if (relay3.getUpstreamReader() != null) {
                                this.timeout.waitUntilNotified(relay3);
                                continue;
                            }
                            relay3.setUpstreamReader(Thread.currentThread());
                            n2 = 1;
                            break block20;
                        }
                        long bufferPos22 = relay3.getUpstreamPos() - relay3.getBuffer().size();
                        if (this.sourcePos >= bufferPos22) {
                            long bytesToRead2 = Math.min((long)byteCount, (long)(relay3.getUpstreamPos() - this.sourcePos));
                            relay3.getBuffer().copyTo(sink2, this.sourcePos - bufferPos22, bytesToRead2);
                            this.sourcePos += bytesToRead2;
                            return bytesToRead2;
                        }
                        n2 = 2;
                    }
                    n = n2;
                }
                int source2 = n;
                if (source2 == 2) {
                    long bytesToRead3 = Math.min((long)byteCount, (long)(Relay.this.getUpstreamPos() - this.sourcePos));
                    FileOperator fileOperator = this.fileOperator;
                    Intrinsics.checkNotNull((Object)fileOperator);
                    fileOperator.read(32L + this.sourcePos, sink2, bytesToRead3);
                    this.sourcePos += bytesToRead3;
                    return bytesToRead3;
                }
                try {
                    Source source3 = Relay.this.getUpstream();
                    Intrinsics.checkNotNull((Object)source3);
                    upstreamBytesRead = source3.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (upstreamBytesRead != -1L) break block21;
                    Relay.this.commit(Relay.this.getUpstreamPos());
                    l = -1L;
                    Relay bufferPos22 = Relay.this;
                    relay = Relay.this;
                    bytesToRead2 = bufferPos22;
                }
                catch (Throwable throwable) {
                    relay3 = Relay.this;
                    relay4 = Relay.this;
                    Relay relay5 = relay3;
                    synchronized (relay5) {
                        boolean bl = false;
                        relay4.setUpstreamReader(null);
                        Relay $this$notifyAll$iv = relay4;
                        boolean $i$f$notifyAll = false;
                        Intrinsics.checkNotNull((Object)$this$notifyAll$iv, (String)"null cannot be cast to non-null type java.lang.Object");
                        $this$notifyAll$iv.notifyAll();
                        Unit unit = Unit.INSTANCE;
                        throw throwable;
                    }
                }
                synchronized (bytesToRead2) {
                    boolean $i$a$-synchronized-Relay$RelaySource$read$32 = false;
                    relay.setUpstreamReader(null);
                    Relay $this$notifyAll$iv = relay;
                    boolean $i$f$notifyAll = false;
                    Intrinsics.checkNotNull((Object)$this$notifyAll$iv, (String)"null cannot be cast to non-null type java.lang.Object");
                    ((Object)$this$notifyAll$iv).notifyAll();
                    Unit $i$a$-synchronized-Relay$RelaySource$read$32 = Unit.INSTANCE;
                    return l;
                }
            }
            long bytesRead = Math.min((long)upstreamBytesRead, (long)byteCount);
            Relay.this.getUpstreamBuffer().copyTo(sink2, 0L, bytesRead);
            this.sourcePos += bytesRead;
            FileOperator fileOperator = this.fileOperator;
            Intrinsics.checkNotNull((Object)fileOperator);
            fileOperator.write(32L + Relay.this.getUpstreamPos(), Relay.this.getUpstreamBuffer().clone(), upstreamBytesRead);
            Relay bufferPos22 = Relay.this;
            Relay relay = Relay.this;
            Relay bytesToRead2 = bufferPos22;
            synchronized (bytesToRead2) {
                boolean bl = false;
                relay.getBuffer().write(relay.getUpstreamBuffer(), upstreamBytesRead);
                if (relay.getBuffer().size() > relay.getBufferMaxSize()) {
                    relay.getBuffer().skip(relay.getBuffer().size() - relay.getBufferMaxSize());
                }
                relay.setUpstreamPos(relay.getUpstreamPos() + upstreamBytesRead);
                object = Unit.INSTANCE;
            }
            long bufferPos22 = bytesRead;
            bytesToRead2 = Relay.this;
            object = Relay.this;
            Relay relay6 = bytesToRead2;
            synchronized (relay6) {
                boolean bl = false;
                ((Relay)object).setUpstreamReader(null);
                Object $this$notifyAll$iv = object;
                boolean $i$f$notifyAll = false;
                Intrinsics.checkNotNull((Object)$this$notifyAll$iv, (String)"null cannot be cast to non-null type java.lang.Object");
                $this$notifyAll$iv.notifyAll();
                Unit unit = Unit.INSTANCE;
                return bufferPos22;
            }
        }

        @Override
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void close() throws IOException {
            block5: {
                if (this.fileOperator == null) {
                    return;
                }
                this.fileOperator = null;
                RandomAccessFile fileToClose = null;
                Relay relay = Relay.this;
                Relay relay2 = Relay.this;
                Relay relay3 = relay;
                synchronized (relay3) {
                    boolean bl = false;
                    int n = relay2.getSourceCount();
                    relay2.setSourceCount(n + -1);
                    if (relay2.getSourceCount() == 0) {
                        fileToClose = relay2.getFile();
                        relay2.setFile(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                RandomAccessFile randomAccessFile = fileToClose;
                if (randomAccessFile == null) break block5;
                Util.closeQuietly((Closeable)randomAccessFile);
            }
        }
    }
}


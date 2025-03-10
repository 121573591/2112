/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.net.Socket
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.TimeUnit
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.PushObserver;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ¸\n\n\n\n\b\n\n\b\n\n\b\n\n\b\n\b\n \n\n\b\n\t\n \n\n\b\n \n\n\b\b\n\n\b\n\n\b\n\n\b\b\n\n\b\n\n\b\n#\n\b\r\n\n\b\n\n\b\n\n\b\b\n\n\b\n\n\b\n%\n\b\t\n\n\b\n  º20:\b»º¼½B\b 0¢\bJ\r0¢\b\bJ\t0H¢\b\t\bJ)\t020\n2\f0\n2\b0\rH ¢\bJ02\b0\rH¢\bJ\r0¢\b\bJ020¢\bJ020¢\bJ-$0202\f\"\b0!0 2#0H¢\b$%J#$02\f\"\b0!0 2#0¢\b$&J\r'0¢\b'(J/002)02+0*2,02-0H ¢\b./J-302)02\f\"\b0!0 2-0H ¢\b12J%602)02\f\"\b0!0 H ¢\b45J:02)0270\nH ¢\b89J+;0202\f\"\b0!0 2#0¢\b;%J>02)0H ¢\b<=J@02)0H ¢\b?JB0H ¢\bA\bJE02D0C¢\bEFJH02G0\n¢\bHIJ#M02\b\bJ02\b\bL0KH¢\bMNJR02O0H ¢\bPQJ/V02)02S02\bU0T2,0¢\bVWJ-[02)02S02\fX\b0!0 H ¢\bYZJ\r\\0¢\b\\\bJ%\\02]02^02_0¢\b\\`J\ra0¢\ba\bJc02)02G0\nH ¢\bb9Je02)0270\nH ¢\bd9Ji02)02f0H ¢\bghRj08@X¢\n\bjkRl08@X¢\n\blkRm08 X¢\f\n\bmn\bopRr0q8 X¢\f\n\brs\btuRw\b00v8X¢\n\bwxRy08@X¢\n\bykRz08@X¢\n\bzkR{08@X¢\n\b{kR|08@X¢\n\b|kR}08@X¢\n\b}kR~08@X¢\n\b~nR&08 @ X¢\n\b\b(\"\bR 08 X¢\n\b\bR(08 @ X¢\n\b\b(\"\bR0C8¢\n\b\bR(0C8@X¢\n\b\b\"\bFR08X¢\b\n\bR08X¢\b\n\bR)0208@BX¢\n\bk\bR)0208@BX¢\n\bk\bR! 0R0 8¢\n\b ¡\b¢£R¤08X¢\b\n\b¤R ¦0¥8 X¢\n\b¦§\b¨©R,«000ª8 X¢\n\b«¬\b­®RL0K8X¢\n\bL¯R)°0208@BX¢\n\b°k\b±R)²0208@BX¢\n\b²k\b³Rµ0´8¢\n\bµ¶\b·¸R¹08X¢\b\n\b¹¨¾"}, d2={"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "", "awaitPong", "()V", "close", "Lokhttp3/internal/http2/ErrorCode;", "connectionCode", "streamCode", "Ljava/io/IOException;", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "e", "failConnection", "(Ljava/io/IOException;)V", "flush", "", "id", "Lokhttp3/internal/http2/Http2Stream;", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "", "nowNs", "", "isHealthy", "(J)Z", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "out", "newStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "openStreamCount", "()I", "streamId", "Lokio/BufferedSource;", "source", "byteCount", "inFinished", "pushDataLater$okhttp", "(ILokio/BufferedSource;IZ)V", "pushDataLater", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "errorCode", "pushResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "pushResetLater", "pushStream", "pushedStream$okhttp", "(I)Z", "pushedStream", "removeStream$okhttp", "removeStream", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "statusCode", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "sendConnectionPreface", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "start", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "read", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "outFinished", "Lokio/Buffer;", "buffer", "writeData", "(IZLokio/Buffer;J)V", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "writePing", "reply", "payload1", "payload2", "(ZII)V", "writePingAndAwaitPong", "writeSynReset$okhttp", "writeSynReset", "writeSynResetLater$okhttp", "writeSynResetLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "awaitPingsSent", "J", "awaitPongsReceived", "client", "Z", "getClient$okhttp", "()Z", "", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "", "currentPushRequests", "Ljava/util/Set;", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "I", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "(I)V", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "Lokhttp3/internal/concurrent/TaskQueue;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "", "streams", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"})
@SourceDebugExtension(value={"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n+ 2 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1006:1\n84#2,4:1007\n90#2,13:1014\n90#2,13:1027\n90#2,13:1069\n90#2,13:1082\n90#2,13:1095\n90#2,13:1108\n90#2,13:1121\n90#2,13:1134\n563#3:1011\n557#3:1013\n557#3:1040\n615#3,4:1041\n402#3,5:1045\n402#3,5:1053\n402#3,5:1059\n402#3,5:1064\n1#4:1012\n37#5,2:1050\n13309#6:1052\n13310#6:1058\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection\n*L\n152#1:1007,4\n340#1:1014,13\n361#1:1027,13\n506#1:1069,13\n554#1:1082,13\n893#1:1095,13\n911#1:1108,13\n938#1:1121,13\n952#1:1134,13\n183#1:1011\n319#1:1013\n402#1:1040\n446#1:1041,4\n448#1:1045,5\n461#1:1053,5\n467#1:1059,5\n472#1:1064,5\n455#1:1050,2\n460#1:1052\n460#1:1058\n*E\n"})
public final class Http2Connection
implements Closeable {
    @NotNull
    public static final Companion Companion;
    private final boolean client;
    @NotNull
    private final Listener listener;
    @NotNull
    private final Map<Integer, Http2Stream> streams;
    @NotNull
    private final String connectionName;
    private int lastGoodStreamId;
    private int nextStreamId;
    private boolean isShutdown;
    @NotNull
    private final TaskRunner taskRunner;
    @NotNull
    private final TaskQueue writerQueue;
    @NotNull
    private final TaskQueue pushQueue;
    @NotNull
    private final TaskQueue settingsListenerQueue;
    @NotNull
    private final PushObserver pushObserver;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private long degradedPingsSent;
    private long degradedPongsReceived;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private long degradedPongDeadlineNs;
    @NotNull
    private final Settings okHttpSettings;
    @NotNull
    private Settings peerSettings;
    private long readBytesTotal;
    private long readBytesAcknowledged;
    private long writeBytesTotal;
    private long writeBytesMaximum;
    @NotNull
    private final Socket socket;
    @NotNull
    private final Http2Writer writer;
    @NotNull
    private final ReaderRunnable readerRunnable;
    @NotNull
    private final Set<Integer> currentPushRequests;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 0x1000000;
    @NotNull
    private static final Settings DEFAULT_SETTINGS;
    public static final int INTERVAL_PING = 1;
    public static final int DEGRADED_PING = 2;
    public static final int AWAIT_PING = 3;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;

    /*
     * WARNING - void declaration
     */
    public Http2Connection(@NotNull Builder builder) {
        Settings settings;
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.streams = (Map)new LinkedHashMap();
        this.connectionName = builder.getConnectionName$okhttp();
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        this.taskRunner = builder.getTaskRunner$okhttp();
        this.writerQueue = this.taskRunner.newQueue();
        this.pushQueue = this.taskRunner.newQueue();
        this.settingsListenerQueue = this.taskRunner.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings2 = settings = new Settings();
        Http2Connection http2Connection = this;
        boolean bl2 = false;
        if (builder.getClient$okhttp()) {
            void $this$okHttpSettings_u24lambda_u240;
            $this$okHttpSettings_u24lambda_u240.set(7, 0x1000000);
        }
        http2Connection.okHttpSettings = settings;
        this.peerSettings = DEFAULT_SETTINGS;
        this.writeBytesMaximum = this.peerSettings.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), this.client);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.getSource$okhttp(), this.client));
        this.currentPushRequests = (Set)new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            void this_$iv;
            long pingIntervalNanos = TimeUnit.MILLISECONDS.toNanos((long)builder.getPingIntervalMillis$okhttp());
            TaskQueue bl2 = this.writerQueue;
            String name$iv = this.connectionName + " ping";
            boolean $i$f$schedule = false;
            this_$iv.schedule(new Task(name$iv, this, pingIntervalNanos){
                final /* synthetic */ Http2Connection this$0;
                final /* synthetic */ long $pingIntervalNanos$inlined;
                {
                    this.this$0 = http2Connection;
                    this.$pingIntervalNanos$inlined = l;
                    super($name, false, 2, null);
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 */
                public long runOnce() {
                    long l;
                    boolean bl;
                    boolean bl2 = false;
                    Http2Connection http2Connection = this.this$0;
                    synchronized (http2Connection) {
                        boolean bl3;
                        boolean bl4 = false;
                        if (Http2Connection.access$getIntervalPongsReceived$p(this.this$0) < Http2Connection.access$getIntervalPingsSent$p(this.this$0)) {
                            bl3 = true;
                        } else {
                            long l2 = Http2Connection.access$getIntervalPingsSent$p(this.this$0);
                            Http2Connection.access$setIntervalPingsSent$p(this.this$0, l2 + 1L);
                            bl3 = false;
                        }
                        bl = bl3;
                    }
                    boolean failDueToMissingPong = bl;
                    if (failDueToMissingPong) {
                        Http2Connection.access$failConnection(this.this$0, null);
                        l = -1L;
                    } else {
                        this.this$0.writePing(false, 1, 0);
                        l = this.$pingIntervalNanos$inlined;
                    }
                    return l;
                }
            }, pingIntervalNanos);
        }
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    @NotNull
    public final Listener getListener$okhttp() {
        return this.listener;
    }

    @NotNull
    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    @NotNull
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final void setLastGoodStreamId$okhttp(int n) {
        this.lastGoodStreamId = n;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final void setNextStreamId$okhttp(int n) {
        this.nextStreamId = n;
    }

    @NotNull
    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @NotNull
    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final void setPeerSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"<set-?>");
        this.peerSettings = settings;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    @NotNull
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @NotNull
    public final Http2Writer getWriter() {
        return this.writer;
    }

    @NotNull
    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    @Nullable
    public final synchronized Http2Stream getStream(int id) {
        return (Http2Stream)this.streams.get((Object)id);
    }

    @Nullable
    public final synchronized Http2Stream removeStream$okhttp(int streamId) {
        Http2Stream stream = (Http2Stream)this.streams.remove((Object)streamId);
        Http2Connection $this$notifyAll$iv = this;
        boolean $i$f$notifyAll = false;
        Intrinsics.checkNotNull((Object)$this$notifyAll$iv, (String)"null cannot be cast to non-null type java.lang.Object");
        ((Object)$this$notifyAll$iv).notifyAll();
        return stream;
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long read) {
        this.readBytesTotal += read;
        long readBytesToAcknowledge = this.readBytesTotal - this.readBytesAcknowledged;
        if (readBytesToAcknowledge >= (long)(this.okHttpSettings.getInitialWindowSize() / 2)) {
            this.writeWindowUpdateLater$okhttp(0, readBytesToAcknowledge);
            this.readBytesAcknowledged += readBytesToAcknowledge;
        }
    }

    @NotNull
    public final Http2Stream pushStream(int associatedStreamId, @NotNull List<Header> requestHeaders, boolean out) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, (String)"requestHeaders");
        if (!(!this.client)) {
            boolean bl = false;
            String string = "Client cannot push requests.";
            throw new IllegalStateException(string.toString());
        }
        return this.newStream(associatedStreamId, requestHeaders, out);
    }

    @NotNull
    public final Http2Stream newStream(@NotNull List<Header> requestHeaders, boolean out) throws IOException {
        Intrinsics.checkNotNullParameter(requestHeaders, (String)"requestHeaders");
        return this.newStream(0, requestHeaders, out);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Http2Stream newStream(int associatedStreamId, List<Header> requestHeaders, boolean out) throws IOException {
        boolean outFinished = !out;
        boolean inFinished = false;
        boolean flushHeaders = false;
        Http2Stream stream = null;
        int streamId = 0;
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            boolean bl = false;
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean $i$a$-synchronized-Http2Connection$newStream$1$22 = false;
                if (this.nextStreamId > 0x3FFFFFFF) {
                    this.shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                streamId = this.nextStreamId;
                this.nextStreamId += 2;
                stream = new Http2Stream(streamId, this, outFinished, inFinished, null);
                boolean bl2 = flushHeaders = !out || this.writeBytesTotal >= this.writeBytesMaximum || stream.getWriteBytesTotal() >= stream.getWriteBytesMaximum();
                if (stream.isOpen()) {
                    this.streams.put((Object)streamId, (Object)stream);
                }
                Unit $i$a$-synchronized-Http2Connection$newStream$1$22 = Unit.INSTANCE;
            }
            if (associatedStreamId == 0) {
                this.writer.headers(outFinished, streamId, requestHeaders);
            } else {
                if (!(!this.client)) {
                    boolean bl3 = false;
                    String string = "client streams shouldn't have associated stream IDs";
                    throw new IllegalArgumentException(string.toString());
                }
                this.writer.pushPromise(associatedStreamId, streamId, requestHeaders);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (flushHeaders) {
            this.writer.flush();
        }
        return stream;
    }

    public final void writeHeaders$okhttp(int streamId, boolean outFinished, @NotNull List<Header> alternating) throws IOException {
        Intrinsics.checkNotNullParameter(alternating, (String)"alternating");
        this.writer.headers(outFinished, streamId, alternating);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void writeData(int streamId, boolean outFinished, @Nullable Buffer buffer, long byteCount) throws IOException {
        if (byteCount == 0L) {
            this.writer.data(outFinished, streamId, buffer, 0);
            return;
        }
        long byteCount2 = 0L;
        byteCount2 = byteCount;
        while (byteCount2 > 0L) {
            int toWrite = 0;
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl = false;
                try {
                    while (this.writeBytesTotal >= this.writeBytesMaximum) {
                        if (!this.streams.containsKey((Object)streamId)) {
                            throw new IOException("stream closed");
                        }
                        Http2Connection $this$wait$iv = this;
                        boolean $i$f$wait = false;
                        Intrinsics.checkNotNull((Object)$this$wait$iv, (String)"null cannot be cast to non-null type java.lang.Object");
                        ((Object)$this$wait$iv).wait();
                    }
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
                toWrite = (int)Math.min((long)byteCount2, (long)(this.writeBytesMaximum - this.writeBytesTotal));
                toWrite = Math.min((int)toWrite, (int)this.writer.maxDataLength());
                this.writeBytesTotal += (long)toWrite;
                Unit unit = Unit.INSTANCE;
            }
            this.writer.data(outFinished && (byteCount2 -= (long)toWrite) == 0L, streamId, buffer, toWrite);
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void writeSynResetLater$okhttp(int streamId, @NotNull ErrorCode errorCode) {
        void $this$iv;
        Intrinsics.checkNotNullParameter((Object)((Object)errorCode), (String)"errorCode");
        TaskQueue taskQueue = this.writerQueue;
        String name$iv = this.connectionName + '[' + streamId + "] writeSynReset";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this, streamId, errorCode){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$errorCode$inlined = errorCode;
                super($name, $cancelable);
            }

            public long runOnce() {
                boolean bl = false;
                try {
                    this.this$0.writeSynReset$okhttp(this.$streamId$inlined, this.$errorCode$inlined);
                }
                catch (IOException e) {
                    Http2Connection.access$failConnection(this.this$0, e);
                }
                return -1L;
            }
        }, delayNanos$iv);
    }

    public final void writeSynReset$okhttp(int streamId, @NotNull ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)((Object)statusCode), (String)"statusCode");
        this.writer.rstStream(streamId, statusCode);
    }

    /*
     * WARNING - void declaration
     */
    public final void writeWindowUpdateLater$okhttp(int streamId, long unacknowledgedBytesRead) {
        void $this$iv;
        TaskQueue taskQueue = this.writerQueue;
        String name$iv = this.connectionName + '[' + streamId + "] windowUpdate";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this, streamId, unacknowledgedBytesRead){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ long $unacknowledgedBytesRead$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$unacknowledgedBytesRead$inlined = l;
                super($name, $cancelable);
            }

            public long runOnce() {
                boolean bl = false;
                try {
                    this.this$0.getWriter().windowUpdate(this.$streamId$inlined, this.$unacknowledgedBytesRead$inlined);
                }
                catch (IOException e) {
                    Http2Connection.access$failConnection(this.this$0, e);
                }
                return -1L;
            }
        }, delayNanos$iv);
    }

    public final void writePing(boolean reply, int payload1, int payload2) {
        try {
            this.writer.ping(reply, payload1, payload2);
        }
        catch (IOException e) {
            this.failConnection(e);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        this.writePing();
        this.awaitPong();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void writePing() throws InterruptedException {
        Http2Connection http2Connection = this;
        synchronized (http2Connection) {
            boolean bl = false;
            long l = this.awaitPingsSent;
            this.awaitPingsSent = l + 1L;
            long l2 = l;
        }
        this.writePing(false, 3, 1330343787);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            Http2Connection $this$wait$iv = this;
            boolean $i$f$wait = false;
            Intrinsics.checkNotNull((Object)$this$wait$iv, (String)"null cannot be cast to non-null type java.lang.Object");
            ((Object)$this$wait$iv).wait();
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void shutdown(@NotNull ErrorCode statusCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)((Object)statusCode), (String)"statusCode");
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            boolean bl = false;
            Ref.IntRef lastGoodStreamId = new Ref.IntRef();
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl2 = false;
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                lastGoodStreamId.element = this.lastGoodStreamId;
                Unit unit = Unit.INSTANCE;
            }
            this.writer.goAway(lastGoodStreamId.element, statusCode, Util.EMPTY_BYTE_ARRAY);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void close() {
        this.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void close$okhttp(@NotNull ErrorCode connectionCode, @NotNull ErrorCode streamCode, @Nullable IOException cause) {
        Intrinsics.checkNotNullParameter((Object)((Object)connectionCode), (String)"connectionCode");
        Intrinsics.checkNotNullParameter((Object)((Object)streamCode), (String)"streamCode");
        Http2Connection $this$assertThreadDoesntHoldLock$iv = this;
        boolean $i$f$assertThreadDoesntHoldLock = false;
        if (Util.assertionsEnabled && Thread.holdsLock((Object)$this$assertThreadDoesntHoldLock$iv)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv));
        }
        boolean $i$f$ignoreIoExceptions = false;
        try {
            boolean bl = false;
            this.shutdown(connectionCode);
        }
        catch (IOException iOException) {
        }
        Object[] streamsToClose = null;
        Http2Connection bl = this;
        synchronized (bl) {
            boolean $i$a$-synchronized-Http2Connection$close$32 = false;
            if (!this.streams.isEmpty()) {
                Collection $this$toTypedArray$iv = this.streams.values();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                streamsToClose = thisCollection$iv.toArray((Object[])new Http2Stream[0]);
                this.streams.clear();
            }
            Unit $i$a$-synchronized-Http2Connection$close$32 = Unit.INSTANCE;
        }
        Http2Stream[] http2StreamArray = (Http2Stream[])streamsToClose;
        if (http2StreamArray != null) {
            Http2Stream[] $this$forEach$iv = http2StreamArray;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                Http2Stream element$iv;
                Http2Stream stream = element$iv = $this$forEach$iv[i];
                boolean bl2 = false;
                boolean $i$f$ignoreIoExceptions2 = false;
                try {
                    boolean bl3 = false;
                    stream.close(streamCode, cause);
                    continue;
                }
                catch (IOException iOException) {
                }
            }
        }
        boolean $i$f$ignoreIoExceptions3 = false;
        try {
            boolean bl4 = false;
            this.writer.close();
        }
        catch (IOException iOException) {
        }
        $i$f$ignoreIoExceptions3 = false;
        try {
            boolean bl5 = false;
            this.socket.close();
        }
        catch (IOException iOException) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    private final void failConnection(IOException e) {
        this.close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, e);
    }

    /*
     * WARNING - void declaration
     */
    @JvmOverloads
    public final void start(boolean sendConnectionPreface, @NotNull TaskRunner taskRunner) throws IOException {
        void name$iv;
        void $this$iv;
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        if (sendConnectionPreface) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int windowSize = this.okHttpSettings.getInitialWindowSize();
            if (windowSize != 65535) {
                this.writer.windowUpdate(0, windowSize - 65535);
            }
        }
        TaskQueue windowSize = taskRunner.newQueue();
        String string = this.connectionName;
        Function0 block$iv = this.readerRunnable;
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task((String)name$iv, cancelable$iv, (Function0<Unit>)block$iv){
            final /* synthetic */ Function0<Unit> $block;
            {
                this.$block = $block;
                super($name, $cancelable);
            }

            public long runOnce() {
                this.$block.invoke();
                return -1L;
            }
        }, delayNanos$iv);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean bl, TaskRunner taskRunner, int n, Object object) throws IOException {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(bl, taskRunner);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setSettings(@NotNull Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            boolean bl = false;
            Http2Connection http2Connection = this;
            synchronized (http2Connection) {
                boolean bl2 = false;
                if (this.isShutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
                Unit unit = Unit.INSTANCE;
            }
            this.writer.settings(settings);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final synchronized boolean isHealthy(long nowNs) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void sendDegradedPingLater$okhttp() {
        void $this$iv;
        Object object = this;
        synchronized (object) {
            boolean bl = false;
            if (this.degradedPongsReceived < this.degradedPingsSent) {
                return;
            }
            long l = this.degradedPingsSent;
            this.degradedPingsSent = l + 1L;
            this.degradedPongDeadlineNs = System.nanoTime() + (long)1000000000;
            Unit $i$a$-synchronized-Http2Connection$sendDegradedPingLater$2 = Unit.INSTANCE;
        }
        object = this.writerQueue;
        String name$iv = this.connectionName + " ping";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this){
            final /* synthetic */ Http2Connection this$0;
            {
                this.this$0 = http2Connection;
                super($name, $cancelable);
            }

            public long runOnce() {
                boolean bl = false;
                this.this$0.writePing(false, 2, 0);
                return -1L;
            }
        }, delayNanos$iv);
    }

    public final boolean pushedStream$okhttp(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public final void pushRequestLater$okhttp(int streamId, @NotNull List<Header> requestHeaders) {
        void $this$iv;
        Intrinsics.checkNotNullParameter(requestHeaders, (String)"requestHeaders");
        Object object = this;
        synchronized (object) {
            boolean bl = false;
            if (this.currentPushRequests.contains((Object)streamId)) {
                this.writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            bl = this.currentPushRequests.add((Object)streamId);
        }
        object = this.pushQueue;
        String name$iv = this.connectionName + '[' + streamId + "] onRequest";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this, streamId, requestHeaders){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ List $requestHeaders$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$requestHeaders$inlined = list;
                super($name, $cancelable);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                block5: {
                    boolean bl = false;
                    boolean cancel = Http2Connection.access$getPushObserver$p(this.this$0).onRequest(this.$streamId$inlined, (List<Header>)this.$requestHeaders$inlined);
                    boolean $i$f$ignoreIoExceptions = false;
                    try {
                        boolean bl2 = false;
                        if (!cancel) break block5;
                        this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        Http2Connection http2Connection = this.this$0;
                        synchronized (http2Connection) {
                            boolean bl3 = false;
                            boolean bl4 = Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove((Object)this.$streamId$inlined);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return -1L;
            }
        }, delayNanos$iv);
    }

    /*
     * WARNING - void declaration
     */
    public final void pushHeadersLater$okhttp(int streamId, @NotNull List<Header> requestHeaders, boolean inFinished) {
        void $this$iv;
        Intrinsics.checkNotNullParameter(requestHeaders, (String)"requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        String name$iv = this.connectionName + '[' + streamId + "] onHeaders";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this, streamId, requestHeaders, inFinished){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ List $requestHeaders$inlined;
            final /* synthetic */ boolean $inFinished$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$requestHeaders$inlined = list;
                this.$inFinished$inlined = bl;
                super($name, $cancelable);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                block6: {
                    boolean bl = false;
                    boolean cancel = Http2Connection.access$getPushObserver$p(this.this$0).onHeaders(this.$streamId$inlined, (List<Header>)this.$requestHeaders$inlined, this.$inFinished$inlined);
                    boolean $i$f$ignoreIoExceptions = false;
                    try {
                        boolean bl2 = false;
                        if (cancel) {
                            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        }
                        if (!cancel && !this.$inFinished$inlined) break block6;
                        Http2Connection http2Connection = this.this$0;
                        synchronized (http2Connection) {
                            boolean bl3 = false;
                            boolean bl4 = Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove((Object)this.$streamId$inlined);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return -1L;
            }
        }, delayNanos$iv);
    }

    /*
     * WARNING - void declaration
     */
    public final void pushDataLater$okhttp(int streamId, @NotNull BufferedSource source2, int byteCount, boolean inFinished) throws IOException {
        void $this$iv;
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Buffer buffer = new Buffer();
        source2.require(byteCount);
        source2.read(buffer, byteCount);
        TaskQueue taskQueue = this.pushQueue;
        String name$iv = this.connectionName + '[' + streamId + "] onData";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this, streamId, buffer, byteCount, inFinished){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ Buffer $buffer$inlined;
            final /* synthetic */ int $byteCount$inlined;
            final /* synthetic */ boolean $inFinished$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$buffer$inlined = buffer;
                this.$byteCount$inlined = n2;
                this.$inFinished$inlined = bl;
                super($name, $cancelable);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                block6: {
                    boolean bl = false;
                    boolean $i$f$ignoreIoExceptions = false;
                    try {
                        boolean bl2 = false;
                        boolean cancel = Http2Connection.access$getPushObserver$p(this.this$0).onData(this.$streamId$inlined, this.$buffer$inlined, this.$byteCount$inlined, this.$inFinished$inlined);
                        if (cancel) {
                            this.this$0.getWriter().rstStream(this.$streamId$inlined, ErrorCode.CANCEL);
                        }
                        if (!cancel && !this.$inFinished$inlined) break block6;
                        Http2Connection http2Connection = this.this$0;
                        synchronized (http2Connection) {
                            boolean bl3 = false;
                            boolean bl4 = Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove((Object)this.$streamId$inlined);
                        }
                    }
                    catch (IOException iOException) {
                    }
                }
                return -1L;
            }
        }, delayNanos$iv);
    }

    /*
     * WARNING - void declaration
     */
    public final void pushResetLater$okhttp(int streamId, @NotNull ErrorCode errorCode) {
        void $this$iv;
        Intrinsics.checkNotNullParameter((Object)((Object)errorCode), (String)"errorCode");
        TaskQueue taskQueue = this.pushQueue;
        String name$iv = this.connectionName + '[' + streamId + "] onReset";
        long delayNanos$iv = 0L;
        boolean cancelable$iv = true;
        boolean $i$f$execute = false;
        $this$iv.schedule(new Task(name$iv, cancelable$iv, this, streamId, errorCode){
            final /* synthetic */ Http2Connection this$0;
            final /* synthetic */ int $streamId$inlined;
            final /* synthetic */ ErrorCode $errorCode$inlined;
            {
                this.this$0 = http2Connection;
                this.$streamId$inlined = n;
                this.$errorCode$inlined = errorCode;
                super($name, $cancelable);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long runOnce() {
                boolean bl = false;
                Http2Connection.access$getPushObserver$p(this.this$0).onReset(this.$streamId$inlined, this.$errorCode$inlined);
                Http2Connection http2Connection = this.this$0;
                synchronized (http2Connection) {
                    boolean bl2 = false;
                    Http2Connection.access$getCurrentPushRequests$p(this.this$0).remove((Object)this.$streamId$inlined);
                    Unit unit = Unit.INSTANCE;
                }
                return -1L;
            }
        }, delayNanos$iv);
    }

    @JvmOverloads
    public final void start(boolean sendConnectionPreface) throws IOException {
        Http2Connection.start$default(this, sendConnectionPreface, null, 2, null);
    }

    @JvmOverloads
    public final void start() throws IOException {
        Http2Connection.start$default(this, false, null, 3, null);
    }

    public static final /* synthetic */ long access$getIntervalPingsSent$p(Http2Connection $this) {
        return $this.intervalPingsSent;
    }

    public static final /* synthetic */ void access$setIntervalPingsSent$p(Http2Connection $this, long l) {
        $this.intervalPingsSent = l;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection $this) {
        return $this.currentPushRequests;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection $this) {
        return $this.pushObserver;
    }

    static {
        Settings settings;
        Companion = new Companion(null);
        Settings $this$DEFAULT_SETTINGS_u24lambda_u2435 = settings = new Settings();
        boolean bl = false;
        $this$DEFAULT_SETTINGS_u24lambda_u2435.set(7, 65535);
        $this$DEFAULT_SETTINGS_u24lambda_u2435.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" P\n\n \n\n \n\n\b\n\n\b\n\n\b\n\b\n\b\n\n\b\n\n \n\n \n\n \n\n\b/ 20B00¢\bJ\r\t0\b¢\b\t\nJ\f0 2\f0¢\b\f\rJ0 20¢\bJ0 20¢\bJ50 202\b\b02\b\b02\b\b0H¢\bR\"08 @ X¢\n\b\b\"\b !R\"\"08 @ X.¢\n\b\"#\b$%\"\b&'R\"\f08 @ X¢\n\b\f(\b)*\"\b+,R\"08 @ X¢\n\b-\b./\"\b01R\"08 @ X¢\n\b2\b34\"\b56R\"08 @ X.¢\n\b7\b89\"\b:;R\"08 @ X.¢\n\b<\b=>\"\b?@R\"08 @ X.¢\n\bA\bBC\"\bDER08 X¢\f\n\bF\bGH¨I"}, d2={"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "", "client", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/http2/Http2Connection;", "build", "()Lokhttp3/internal/http2/Http2Connection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "(Lokhttp3/internal/http2/Http2Connection$Listener;)Lokhttp3/internal/http2/Http2Connection$Builder;", "", "pingIntervalMillis", "(I)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "(Lokhttp3/internal/http2/PushObserver;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Ljava/net/Socket;", "socket", "", "peerName", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "sink", "(Ljava/net/Socket;Ljava/lang/String;Lokio/BufferedSource;Lokio/BufferedSink;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Z", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "I", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "okhttp"})
    public static final class Builder {
        private boolean client;
        @NotNull
        private final TaskRunner taskRunner;
        public Socket socket;
        public String connectionName;
        public BufferedSource source;
        public BufferedSink sink;
        @NotNull
        private Listener listener;
        @NotNull
        private PushObserver pushObserver;
        private int pingIntervalMillis;

        public Builder(boolean client, @NotNull TaskRunner taskRunner) {
            Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
            this.client = client;
            this.taskRunner = taskRunner;
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final void setClient$okhttp(boolean bl) {
            this.client = bl;
        }

        @NotNull
        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        @NotNull
        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"socket");
            return null;
        }

        public final void setSocket$okhttp(@NotNull Socket socket) {
            Intrinsics.checkNotNullParameter((Object)socket, (String)"<set-?>");
            this.socket = socket;
        }

        @NotNull
        public final String getConnectionName$okhttp() {
            String string = this.connectionName;
            if (string != null) {
                return string;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"connectionName");
            return null;
        }

        public final void setConnectionName$okhttp(@NotNull String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
            this.connectionName = string;
        }

        @NotNull
        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"source");
            return null;
        }

        public final void setSource$okhttp(@NotNull BufferedSource bufferedSource) {
            Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<set-?>");
            this.source = bufferedSource;
        }

        @NotNull
        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"sink");
            return null;
        }

        public final void setSink$okhttp(@NotNull BufferedSink bufferedSink) {
            Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"<set-?>");
            this.sink = bufferedSink;
        }

        @NotNull
        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final void setListener$okhttp(@NotNull Listener listener) {
            Intrinsics.checkNotNullParameter((Object)listener, (String)"<set-?>");
            this.listener = listener;
        }

        @NotNull
        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final void setPushObserver$okhttp(@NotNull PushObserver pushObserver) {
            Intrinsics.checkNotNullParameter((Object)pushObserver, (String)"<set-?>");
            this.pushObserver = pushObserver;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis$okhttp(int n) {
            this.pingIntervalMillis = n;
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource source2, @NotNull BufferedSink sink2) throws IOException {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
            Intrinsics.checkNotNullParameter((Object)peerName, (String)"peerName");
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
            Builder $this$socket_u24lambda_u240 = builder = this;
            boolean bl = false;
            $this$socket_u24lambda_u240.setSocket$okhttp(socket);
            $this$socket_u24lambda_u240.setConnectionName$okhttp($this$socket_u24lambda_u240.client ? Util.okHttpName + ' ' + peerName : "MockWebServer " + peerName);
            $this$socket_u24lambda_u240.setSource$okhttp(source2);
            $this$socket_u24lambda_u240.setSink$okhttp(sink2);
            return builder;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket, String string, BufferedSource bufferedSource, BufferedSink bufferedSink, int n, Object object) throws IOException {
            if ((n & 2) != 0) {
                string = Util.peerName(socket);
            }
            if ((n & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket));
            }
            if ((n & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket));
            }
            return builder.socket(socket, string, bufferedSource, bufferedSink);
        }

        @NotNull
        public final Builder listener(@NotNull Listener listener) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
            Builder $this$listener_u24lambda_u241 = builder = this;
            boolean bl = false;
            $this$listener_u24lambda_u241.listener = listener;
            return builder;
        }

        @NotNull
        public final Builder pushObserver(@NotNull PushObserver pushObserver) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)pushObserver, (String)"pushObserver");
            Builder $this$pushObserver_u24lambda_u242 = builder = this;
            boolean bl = false;
            $this$pushObserver_u24lambda_u242.pushObserver = pushObserver;
            return builder;
        }

        @NotNull
        public final Builder pingIntervalMillis(int pingIntervalMillis) {
            Builder builder;
            Builder $this$pingIntervalMillis_u24lambda_u243 = builder = this;
            boolean bl = false;
            $this$pingIntervalMillis_u24lambda_u243.pingIntervalMillis = pingIntervalMillis;
            return builder;
        }

        @NotNull
        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName, @NotNull BufferedSource source2) throws IOException {
            Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
            Intrinsics.checkNotNullParameter((Object)peerName, (String)"peerName");
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            return Builder.socket$default(this, socket, peerName, source2, null, 8, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket, @NotNull String peerName) throws IOException {
            Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
            Intrinsics.checkNotNullParameter((Object)peerName, (String)"peerName");
            return Builder.socket$default(this, socket, peerName, null, null, 12, null);
        }

        @JvmOverloads
        @NotNull
        public final Builder socket(@NotNull Socket socket) throws IOException {
            Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
            return Builder.socket$default(this, socket, null, null, null, 14, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\b\n\b\n\n\b\t\b 20B\t\b¢\bR08XT¢\n\bR\b08¢\f\n\b\b\t\b\nR\f08XT¢\n\b\fR\r08XT¢\n\b\rR08XT¢\n\bR08XT¢\n\b¨"}, d2={"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "<init>", "()V", "", "AWAIT_PING", "I", "Lokhttp3/internal/http2/Settings;", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Settings getDEFAULT_SETTINGS() {
            return DEFAULT_SETTINGS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" (\n\n \n\b\n\n \n\n \n\n\b\n\n\b\b&  20:B¢\bJ\t0\b2020H¢\b\t\nJ\r0\b2\f0H&¢\b\r¨"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "<init>", "()V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Companion", "okhttp"})
    public static abstract class Listener {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @JvmField
        @NotNull
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener(){

            public void onStream(@NotNull Http2Stream stream) throws IOException {
                Intrinsics.checkNotNullParameter((Object)stream, (String)"stream");
                stream.close(ErrorCode.REFUSED_STREAM, null);
            }
        };

        public abstract void onStream(@NotNull Http2Stream var1) throws IOException;

        public void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
            Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\b 20B\t\b¢\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "<init>", "()V", "Lokhttp3/internal/http2/Http2Connection$Listener;", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ^\n\n\n\n\n\n\b\n\b\n \n\n \n\n\b\n\t\n\b\n\n \n\n\b\n\n\b\n\n\b\n \n\n\b\b 202\b00B\b 0¢\bJ\b0H¢\b\b\tJ?020\n2\r0\f2020\f20\n20H¢\bJ02020¢\bJ/ 02020\n2020\nH¢\b !J'&02\"0\n2$0#2%0H¢\b&'J5,02020\n2(0\n2\f+\b0*0)H¢\b,-J.0H¢\b.\tJ'202/0200\n210\nH¢\b23J/7020\n240\n250\n260H¢\b78J-;020\n290\n2\f:\b0*0)H¢\b;<J=020\n2$0#H¢\b=>J02020H¢\bJ@020\n2?0H¢\b@AR08 X¢\f\n\bB\bCD¨E"}, d2={"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "Lokhttp3/internal/http2/Http2Reader;", "reader", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "ackSettings", "()V", "", "streamId", "", "origin", "Lokio/ByteString;", "protocol", "host", "port", "", "maxAge", "alternateService", "(ILjava/lang/String;Lokio/ByteString;Ljava/lang/String;IJ)V", "", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "applyAndAckSettings", "(ZLokhttp3/internal/http2/Settings;)V", "inFinished", "Lokio/BufferedSource;", "source", "length", "data", "(ZILokio/BufferedSource;I)V", "lastGoodStreamId", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Lokio/ByteString;)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "invoke", "ack", "payload1", "payload2", "ping", "(ZII)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "windowSizeIncrement", "windowUpdate", "(IJ)V", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHttp2Connection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n+ 2 TaskQueue.kt\nokhttp3/internal/concurrent/TaskQueue\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Util.kt\nokhttp3/internal/Util\n*L\n1#1,1006:1\n90#2,13:1007\n90#2,13:1020\n90#2,13:1035\n90#2,13:1049\n37#3,2:1033\n37#3,2:1062\n563#4:1048\n563#4:1064\n*S KotlinDebug\n*F\n+ 1 Http2Connection.kt\nokhttp3/internal/http2/Http2Connection$ReaderRunnable\n*L\n687#1:1007,13\n715#1:1020,13\n758#1:1035,13\n806#1:1049,13\n753#1:1033,2\n824#1:1062,2\n797#1:1048\n841#1:1064\n*E\n"})
    public final class ReaderRunnable
    implements Http2Reader.Handler,
    Function0<Unit> {
        @NotNull
        private final Http2Reader reader;

        public ReaderRunnable(Http2Reader reader) {
            Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
            this.reader = reader;
        }

        @NotNull
        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void invoke() {
            ErrorCode connectionErrorCode = ErrorCode.INTERNAL_ERROR;
            ErrorCode streamErrorCode = ErrorCode.INTERNAL_ERROR;
            IOException errorException = null;
            try {
                this.reader.readConnectionPreface(this);
                while (this.reader.nextFrame(false, this)) {
                }
                connectionErrorCode = ErrorCode.NO_ERROR;
                streamErrorCode = ErrorCode.CANCEL;
            }
            catch (IOException e) {
                errorException = e;
                connectionErrorCode = ErrorCode.PROTOCOL_ERROR;
                streamErrorCode = ErrorCode.PROTOCOL_ERROR;
            }
            finally {
                Http2Connection.this.close$okhttp(connectionErrorCode, streamErrorCode, errorException);
                Util.closeQuietly(this.reader);
            }
        }

        @Override
        public void data(boolean inFinished, int streamId, @NotNull BufferedSource source2, int length) throws IOException {
            Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
            if (Http2Connection.this.pushedStream$okhttp(streamId)) {
                Http2Connection.this.pushDataLater$okhttp(streamId, source2, length, inFinished);
                return;
            }
            Http2Stream dataStream = Http2Connection.this.getStream(streamId);
            if (dataStream == null) {
                Http2Connection.this.writeSynResetLater$okhttp(streamId, ErrorCode.PROTOCOL_ERROR);
                Http2Connection.this.updateConnectionFlowControl$okhttp(length);
                source2.skip(length);
                return;
            }
            dataStream.receiveData(source2, length);
            if (inFinished) {
                dataStream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        @Override
        public void headers(boolean inFinished, int streamId, int associatedStreamId, @NotNull List<Header> headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, (String)"headerBlock");
            if (Http2Connection.this.pushedStream$okhttp(streamId)) {
                Http2Connection.this.pushHeadersLater$okhttp(streamId, headerBlock, inFinished);
                return;
            }
            Http2Stream stream = null;
            Http2Connection http2Connection = Http2Connection.this;
            Http2Connection http2Connection2 = Http2Connection.this;
            Http2Connection http2Connection3 = http2Connection;
            synchronized (http2Connection3) {
                boolean bl = false;
                stream = http2Connection2.getStream(streamId);
                if (stream == null) {
                    void $this$iv;
                    if (http2Connection2.isShutdown) {
                        return;
                    }
                    if (streamId <= http2Connection2.getLastGoodStreamId$okhttp()) {
                        return;
                    }
                    if (streamId % 2 == http2Connection2.getNextStreamId$okhttp() % 2) {
                        return;
                    }
                    Headers headers = Util.toHeaders(headerBlock);
                    Http2Stream newStream = new Http2Stream(streamId, http2Connection2, false, inFinished, headers);
                    http2Connection2.setLastGoodStreamId$okhttp(streamId);
                    Integer n = streamId;
                    http2Connection2.getStreams$okhttp().put((Object)n, (Object)newStream);
                    TaskQueue taskQueue = http2Connection2.taskRunner.newQueue();
                    String name$iv = http2Connection2.getConnectionName$okhttp() + '[' + streamId + "] onStream";
                    long delayNanos$iv = 0L;
                    boolean cancelable$iv = true;
                    boolean $i$f$execute = false;
                    $this$iv.schedule(new Task(name$iv, cancelable$iv, http2Connection2, newStream){
                        final /* synthetic */ Http2Connection this$0;
                        final /* synthetic */ Http2Stream $newStream$inlined;
                        {
                            this.this$0 = http2Connection;
                            this.$newStream$inlined = http2Stream;
                            super($name, $cancelable);
                        }

                        public long runOnce() {
                            boolean bl = false;
                            try {
                                this.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
                            }
                            catch (IOException e) {
                                Platform.Companion.get().log("Http2Connection.Listener failure for " + this.this$0.getConnectionName$okhttp(), 4, e);
                                boolean $i$f$ignoreIoExceptions = false;
                                try {
                                    boolean bl2 = false;
                                    this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e);
                                }
                                catch (IOException iOException) {
                                }
                            }
                            return -1L;
                        }
                    }, delayNanos$iv);
                    return;
                }
                Unit unit = Unit.INSTANCE;
            }
            stream.receiveHeaders(Util.toHeaders(headerBlock), inFinished);
        }

        @Override
        public void rstStream(int streamId, @NotNull ErrorCode errorCode) {
            block1: {
                Http2Stream rstStream;
                Intrinsics.checkNotNullParameter((Object)((Object)errorCode), (String)"errorCode");
                if (Http2Connection.this.pushedStream$okhttp(streamId)) {
                    Http2Connection.this.pushResetLater$okhttp(streamId, errorCode);
                    return;
                }
                Http2Stream http2Stream = rstStream = Http2Connection.this.removeStream$okhttp(streamId);
                if (http2Stream == null) break block1;
                http2Stream.receiveRstStream(errorCode);
            }
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void settings(boolean clearPrevious, @NotNull Settings settings) {
            void $this$iv;
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            TaskQueue taskQueue = Http2Connection.this.writerQueue;
            String name$iv = Http2Connection.this.getConnectionName$okhttp() + " applyAndAckSettings";
            long delayNanos$iv = 0L;
            boolean cancelable$iv = true;
            boolean $i$f$execute = false;
            $this$iv.schedule(new Task(name$iv, cancelable$iv, this, clearPrevious, settings){
                final /* synthetic */ ReaderRunnable this$0;
                final /* synthetic */ boolean $clearPrevious$inlined;
                final /* synthetic */ Settings $settings$inlined;
                {
                    this.this$0 = readerRunnable;
                    this.$clearPrevious$inlined = bl;
                    this.$settings$inlined = settings;
                    super($name, $cancelable);
                }

                public long runOnce() {
                    boolean bl = false;
                    this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
                    return -1L;
                }
            }, delayNanos$iv);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        public final void applyAndAckSettings(boolean clearPrevious, @NotNull Settings settings) {
            Object object;
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            long delta = 0L;
            Http2Stream[] streamsToNotify = null;
            Ref.ObjectRef newPeerSettings = new Ref.ObjectRef();
            Http2Stream[] http2StreamArray = Http2Connection.this.getWriter();
            Http2Connection http2Connection = Http2Connection.this;
            Http2Stream[] http2StreamArray2 = http2StreamArray;
            synchronized (http2StreamArray2) {
                boolean $i$a$-synchronized-Http2Connection$ReaderRunnable$applyAndAckSettings$32 = false;
                object = http2Connection;
                synchronized (object) {
                    void $this$iv;
                    Http2Stream[] http2StreamArray3;
                    Settings settings2;
                    boolean $i$a$-synchronized-Http2Connection$ReaderRunnable$applyAndAckSettings$1$22 = false;
                    Settings previousPeerSettings = http2Connection.getPeerSettings();
                    Ref.ObjectRef objectRef = newPeerSettings;
                    if (clearPrevious) {
                        settings2 = settings;
                    } else {
                        void $this$applyAndAckSettings_u24lambda_u247_u24lambda_u246_u24lambda_u244;
                        Settings settings3;
                        Settings settings4 = settings3 = new Settings();
                        Ref.ObjectRef objectRef2 = objectRef;
                        boolean bl = false;
                        $this$applyAndAckSettings_u24lambda_u247_u24lambda_u246_u24lambda_u244.merge(previousPeerSettings);
                        $this$applyAndAckSettings_u24lambda_u247_u24lambda_u246_u24lambda_u244.merge(settings);
                        objectRef = objectRef2;
                        settings2 = settings3;
                    }
                    objectRef.element = settings2;
                    long peerInitialWindowSize = ((Settings)newPeerSettings.element).getInitialWindowSize();
                    delta = peerInitialWindowSize - (long)previousPeerSettings.getInitialWindowSize();
                    if (delta == 0L || http2Connection.getStreams$okhttp().isEmpty()) {
                        http2StreamArray3 = null;
                    } else {
                        Collection $this$toTypedArray$iv = http2Connection.getStreams$okhttp().values();
                        boolean $i$f$toTypedArray = false;
                        Collection thisCollection$iv = $this$toTypedArray$iv;
                        http2StreamArray3 = (Http2Stream[])thisCollection$iv.toArray((Object[])new Http2Stream[0]);
                    }
                    streamsToNotify = http2StreamArray3;
                    http2Connection.setPeerSettings((Settings)newPeerSettings.element);
                    TaskQueue $this$toTypedArray$iv = http2Connection.settingsListenerQueue;
                    String name$iv = http2Connection.getConnectionName$okhttp() + " onSettings";
                    long delayNanos$iv = 0L;
                    boolean cancelable$iv = true;
                    boolean $i$f$execute = false;
                    $this$iv.schedule(new Task(name$iv, cancelable$iv, http2Connection, newPeerSettings){
                        final /* synthetic */ Http2Connection this$0;
                        final /* synthetic */ Ref.ObjectRef $newPeerSettings$inlined;
                        {
                            this.this$0 = http2Connection;
                            this.$newPeerSettings$inlined = objectRef;
                            super($name, $cancelable);
                        }

                        public long runOnce() {
                            boolean bl = false;
                            this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings)this.$newPeerSettings$inlined.element);
                            return -1L;
                        }
                    }, delayNanos$iv);
                    Unit $i$a$-synchronized-Http2Connection$ReaderRunnable$applyAndAckSettings$1$22 = Unit.INSTANCE;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings)newPeerSettings.element);
                }
                catch (IOException e) {
                    http2Connection.failConnection(e);
                }
                Unit $i$a$-synchronized-Http2Connection$ReaderRunnable$applyAndAckSettings$32 = Unit.INSTANCE;
            }
            if (streamsToNotify != null) {
                for (Http2Stream stream : streamsToNotify) {
                    object = stream;
                    synchronized (object) {
                        boolean bl = false;
                        stream.addBytesToWriteWindow(delta);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        }

        @Override
        public void ackSettings() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * WARNING - void declaration
         */
        @Override
        public void ping(boolean ack, int payload1, int payload2) {
            if (ack) {
                Http2Connection http2Connection = Http2Connection.this;
                Http2Connection http2Connection2 = Http2Connection.this;
                Http2Connection http2Connection3 = http2Connection;
                synchronized (http2Connection3) {
                    Unit unit;
                    boolean bl = false;
                    switch (payload1) {
                        case 1: {
                            long l = http2Connection2.intervalPongsReceived;
                            http2Connection2.intervalPongsReceived = l + 1L;
                            unit = Long.valueOf((long)l);
                            break;
                        }
                        case 2: {
                            long l = http2Connection2.degradedPongsReceived;
                            http2Connection2.degradedPongsReceived = l + 1L;
                            unit = Long.valueOf((long)l);
                            break;
                        }
                        case 3: {
                            long l = http2Connection2.awaitPongsReceived;
                            http2Connection2.awaitPongsReceived = l + 1L;
                            Http2Connection $this$notifyAll$iv = http2Connection2;
                            boolean $i$f$notifyAll = false;
                            Intrinsics.checkNotNull((Object)$this$notifyAll$iv, (String)"null cannot be cast to non-null type java.lang.Object");
                            ((Object)$this$notifyAll$iv).notifyAll();
                            unit = Unit.INSTANCE;
                            break;
                        }
                        default: {
                            unit = Unit.INSTANCE;
                        }
                    }
                    Unit unit2 = unit;
                }
            } else {
                void name$iv;
                void $this$iv;
                TaskQueue taskQueue = Http2Connection.this.writerQueue;
                String string = Http2Connection.this.getConnectionName$okhttp() + " ping";
                Http2Connection http2Connection = Http2Connection.this;
                long delayNanos$iv = 0L;
                boolean cancelable$iv = true;
                boolean $i$f$execute = false;
                $this$iv.schedule(new Task((String)name$iv, cancelable$iv, http2Connection, payload1, payload2){
                    final /* synthetic */ Http2Connection this$0;
                    final /* synthetic */ int $payload1$inlined;
                    final /* synthetic */ int $payload2$inlined;
                    {
                        this.this$0 = http2Connection;
                        this.$payload1$inlined = n;
                        this.$payload2$inlined = n2;
                        super($name, $cancelable);
                    }

                    public long runOnce() {
                        boolean bl = false;
                        this.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
                        return -1L;
                    }
                }, delayNanos$iv);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void goAway(int lastGoodStreamId, @NotNull ErrorCode errorCode, @NotNull ByteString debugData) {
            Intrinsics.checkNotNullParameter((Object)((Object)errorCode), (String)"errorCode");
            Intrinsics.checkNotNullParameter((Object)debugData, (String)"debugData");
            if (debugData.size() > 0) {
                // empty if block
            }
            Object[] streamsCopy = null;
            Http2Stream[] http2StreamArray = Http2Connection.this;
            Http2Connection http2Connection = Http2Connection.this;
            Http2Stream[] http2StreamArray2 = http2StreamArray;
            synchronized (http2StreamArray2) {
                boolean $i$a$-synchronized-Http2Connection$ReaderRunnable$goAway$22 = false;
                Collection $this$toTypedArray$iv = http2Connection.getStreams$okhttp().values();
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                streamsCopy = thisCollection$iv.toArray((Object[])new Http2Stream[0]);
                http2Connection.isShutdown = true;
                Unit $i$a$-synchronized-Http2Connection$ReaderRunnable$goAway$22 = Unit.INSTANCE;
            }
            for (Http2Stream http2Stream : (Http2Stream[])streamsCopy) {
                if (http2Stream.getId() <= lastGoodStreamId || !http2Stream.isLocallyInitiated()) continue;
                http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                Http2Connection.this.removeStream$okhttp(http2Stream.getId());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void windowUpdate(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                Http2Connection http2Connection = Http2Connection.this;
                Http2Connection http2Connection2 = Http2Connection.this;
                Http2Connection http2Connection3 = http2Connection;
                synchronized (http2Connection3) {
                    boolean bl = false;
                    http2Connection2.writeBytesMaximum = http2Connection2.getWriteBytesMaximum() + windowSizeIncrement;
                    Http2Connection $this$notifyAll$iv = http2Connection2;
                    boolean $i$f$notifyAll = false;
                    Intrinsics.checkNotNull((Object)$this$notifyAll$iv, (String)"null cannot be cast to non-null type java.lang.Object");
                    ((Object)$this$notifyAll$iv).notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
            }
            Http2Stream stream = Http2Connection.this.getStream(streamId);
            if (stream != null) {
                Http2Stream http2Stream = stream;
                synchronized (http2Stream) {
                    boolean bl = false;
                    stream.addBytesToWriteWindow(windowSizeIncrement);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override
        public void priority(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        @Override
        public void pushPromise(int streamId, int promisedStreamId, @NotNull List<Header> requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, (String)"requestHeaders");
            Http2Connection.this.pushRequestLater$okhttp(promisedStreamId, requestHeaders);
        }

        @Override
        public void alternateService(int streamId, @NotNull String origin, @NotNull ByteString protocol, @NotNull String host, int port, long maxAge) {
            Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
            Intrinsics.checkNotNullParameter((Object)protocol, (String)"protocol");
            Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.zip.CRC32
 *  java.util.zip.Deflater
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.DeflaterSink;
import okio.RealBufferedSink;
import okio.Segment;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" R\n\n\n\b\n\n\b\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\n\n\b\n\n\b 20B0¢\bJ0H¢\bJ0\bH¢\b\t\nJ\f0H¢\b\fJ0\rH¢\bJ02020H¢\bJ02020H¢\bJ0H¢\bR08@X¢\n\bR08X¢\n\bR0\b8G¢\f\n\b\b\nR!0 8X¢\n\b!\"R0#8X¢\n\b$¨%"}, d2={"Lokio/GzipSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "", "close", "()V", "Ljava/util/zip/Deflater;", "-deprecated_deflater", "()Ljava/util/zip/Deflater;", "deflater", "flush", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Buffer;", "buffer", "", "byteCount", "updateCrc", "(Lokio/Buffer;J)V", "source", "write", "writeFooter", "", "closed", "Z", "Ljava/util/zip/CRC32;", "crc", "Ljava/util/zip/CRC32;", "Ljava/util/zip/Deflater;", "Lokio/DeflaterSink;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "Lokio/RealBufferedSink;", "okio"})
@SourceDebugExtension(value={"SMAP\nGzipSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n+ 2 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,153:1\n51#2:154\n1#3:155\n86#4:156\n*S KotlinDebug\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n*L\n63#1:154\n131#1:156\n*E\n"})
public final class GzipSink
implements Sink {
    @NotNull
    private final RealBufferedSink sink;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final DeflaterSink deflaterSink;
    private boolean closed;
    @NotNull
    private final CRC32 crc;

    public GzipSink(@NotNull Sink sink2) {
        Buffer buffer;
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        this.sink = new RealBufferedSink(sink2);
        this.deflater = new Deflater(-1, true);
        this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
        this.crc = new CRC32();
        RealBufferedSink this_$iv = this.sink;
        boolean $i$f$getBuffer = false;
        Buffer $this$_init__u24lambda_u240 = buffer = this_$iv.bufferField;
        boolean bl = false;
        $this$_init__u24lambda_u240.writeShort(8075);
        $this$_init__u24lambda_u240.writeByte(8);
        $this$_init__u24lambda_u240.writeByte(0);
        $this$_init__u24lambda_u240.writeInt(0);
        $this$_init__u24lambda_u240.writeByte(0);
        $this$_init__u24lambda_u240.writeByte(0);
    }

    @JvmName(name="deflater")
    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override
    public void write(@NotNull Buffer source2, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        if (!(byteCount >= 0L)) {
            boolean bl = false;
            String string = "byteCount < 0: " + byteCount;
            throw new IllegalArgumentException(string.toString());
        }
        if (byteCount == 0L) {
            return;
        }
        this.updateCrc(source2, byteCount);
        this.deflaterSink.write(source2, byteCount);
    }

    @Override
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override
    public void close() throws IOException {
        Throwable thrown;
        block9: {
            block8: {
                if (this.closed) {
                    return;
                }
                thrown = null;
                try {
                    this.deflaterSink.finishDeflate$okio();
                    this.writeFooter();
                }
                catch (Throwable e) {
                    thrown = e;
                }
                try {
                    this.deflater.end();
                }
                catch (Throwable e) {
                    if (thrown != null) break block8;
                    thrown = e;
                }
            }
            try {
                this.sink.close();
            }
            catch (Throwable e) {
                if (thrown != null) break block9;
                thrown = e;
            }
        }
        this.closed = true;
        Throwable throwable = thrown;
        if (throwable != null) {
            throw throwable;
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int)this.crc.getValue());
        this.sink.writeIntLe((int)this.deflater.getBytesRead());
    }

    private final void updateCrc(Buffer buffer, long byteCount) {
        int segmentLength;
        Segment segment = buffer.head;
        Intrinsics.checkNotNull((Object)segment);
        Segment head = segment;
        for (long remaining = byteCount; remaining > 0L; remaining -= (long)segmentLength) {
            int b$iv = head.limit - head.pos;
            boolean $i$f$minOf = false;
            segmentLength = (int)Math.min((long)remaining, (long)b$iv);
            this.crc.update(head.data, head.pos, segmentLength);
            Intrinsics.checkNotNull((Object)head.next);
        }
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="deflater", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_deflater")
    @NotNull
    public final Deflater -deprecated_deflater() {
        return this.deflater;
    }
}


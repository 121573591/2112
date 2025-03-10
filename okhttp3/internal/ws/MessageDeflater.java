/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.zip.Deflater
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.MessageDeflaterKt;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 8\n\n\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b 20B0¢\bJ0H¢\b\bJ02\n0\t¢\b\fJ0*0\t20\rH¢\bR0\t8X¢\n\bR08X¢\n\bR08X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "", "close", "()V", "Lokio/Buffer;", "buffer", "deflate", "(Lokio/Buffer;)V", "Lokio/ByteString;", "suffix", "endsWith", "(Lokio/Buffer;Lokio/ByteString;)Z", "deflatedBytes", "Lokio/Buffer;", "Ljava/util/zip/Deflater;", "deflater", "Ljava/util/zip/Deflater;", "Lokio/DeflaterSink;", "deflaterSink", "Lokio/DeflaterSink;", "Z", "okhttp"})
public final class MessageDeflater
implements Closeable {
    private final boolean noContextTakeover;
    @NotNull
    private final Buffer deflatedBytes;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final DeflaterSink deflaterSink;

    public MessageDeflater(boolean noContextTakeover) {
        this.noContextTakeover = noContextTakeover;
        this.deflatedBytes = new Buffer();
        this.deflater = new Deflater(-1, true);
        this.deflaterSink = new DeflaterSink((Sink)this.deflatedBytes, this.deflater);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void deflate(@NotNull Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        if (!(this.deflatedBytes.size() == 0L)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.size());
        this.deflaterSink.flush();
        if (this.endsWith(this.deflatedBytes, MessageDeflaterKt.access$getEMPTY_DEFLATE_BLOCK$p())) {
            long newSize = this.deflatedBytes.size() - (long)4;
            Closeable closeable = Buffer.readAndWriteUnsafe$default(this.deflatedBytes, null, 1, null);
            Throwable throwable = null;
            try {
                Buffer.UnsafeCursor cursor = (Buffer.UnsafeCursor)closeable;
                boolean bl = false;
                long l = cursor.resizeBuffer(newSize);
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
        } else {
            this.deflatedBytes.writeByte(0);
        }
        buffer.write(this.deflatedBytes, this.deflatedBytes.size());
    }

    public void close() throws IOException {
        this.deflaterSink.close();
    }

    private final boolean endsWith(Buffer $this$endsWith, ByteString suffix) {
        return $this$endsWith.rangeEquals($this$endsWith.size() - (long)suffix.size(), suffix);
    }
}


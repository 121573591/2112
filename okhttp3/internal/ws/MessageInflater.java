/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.zip.Inflater
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 0\n\n\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b 20B0¢\bJ0H¢\b\bJ02\n0\t¢\b\fR\r0\t8X¢\n\b\rR08X¢\n\bR08X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "", "close", "()V", "Lokio/Buffer;", "buffer", "inflate", "(Lokio/Buffer;)V", "deflatedBytes", "Lokio/Buffer;", "Ljava/util/zip/Inflater;", "inflater", "Ljava/util/zip/Inflater;", "Lokio/InflaterSource;", "inflaterSource", "Lokio/InflaterSource;", "Z", "okhttp"})
public final class MessageInflater
implements Closeable {
    private final boolean noContextTakeover;
    @NotNull
    private final Buffer deflatedBytes;
    @NotNull
    private final Inflater inflater;
    @NotNull
    private final InflaterSource inflaterSource;

    public MessageInflater(boolean noContextTakeover) {
        this.noContextTakeover = noContextTakeover;
        this.deflatedBytes = new Buffer();
        this.inflater = new Inflater(true);
        this.inflaterSource = new InflaterSource((Source)this.deflatedBytes, this.inflater);
    }

    public final void inflate(@NotNull Buffer buffer) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        if (!(this.deflatedBytes.size() == 0L)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.writeAll(buffer);
        this.deflatedBytes.writeInt(65535);
        long totalBytesToRead = this.inflater.getBytesRead() + this.deflatedBytes.size();
        do {
            this.inflaterSource.readOrInflate(buffer, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < totalBytesToRead);
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" ,\n\n\n\n \n\t\n \n\n\b\n\n\b\n\n\b\b  20B000¢\b\b\tJ\r020\n2\f0H¢\b\rJ0*0\n20H¢\bR08@X¢\n\bR08X¢\n\bR08X¢\n\b¨"}, d2={"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "size", "", "truncate", "<init>", "(Lokio/Source;JZ)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "newSize", "", "truncateToSize", "(Lokio/Buffer;J)V", "bytesReceived", "J", "Z", "okio"})
public final class FixedLengthSource
extends ForwardingSource {
    private final long size;
    private final boolean truncate;
    private long bytesReceived;

    public FixedLengthSource(@NotNull Source delegate, long size, boolean truncate) {
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        super(delegate);
        this.size = size;
        this.truncate = truncate;
    }

    @Override
    public long read(@NotNull Buffer sink2, long byteCount) {
        long l;
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        if (this.bytesReceived > this.size) {
            l = 0L;
        } else if (this.truncate) {
            long remaining = this.size - this.bytesReceived;
            if (remaining == 0L) {
                return -1L;
            }
            l = Math.min((long)byteCount, (long)remaining);
        } else {
            l = byteCount;
        }
        long toRead = l;
        long result = super.read(sink2, toRead);
        if (result != -1L) {
            this.bytesReceived += result;
        }
        if (this.bytesReceived < this.size && result == -1L || this.bytesReceived > this.size) {
            if (result > 0L && this.bytesReceived > this.size) {
                this.truncateToSize(sink2, sink2.size() - (this.bytesReceived - this.size));
            }
            throw new IOException("expected " + this.size + " bytes but got " + this.bytesReceived);
        }
        return result;
    }

    private final void truncateToSize(Buffer $this$truncateToSize, long newSize) {
        Buffer scratch = new Buffer();
        scratch.writeAll($this$truncateToSize);
        $this$truncateToSize.write(scratch, newSize);
        scratch.clear();
    }
}


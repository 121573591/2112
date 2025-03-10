/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" 2\n\n\n\b\n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\b& 20B0¢\bJ0H¢\bJ0H¢\b\b\tJ0\f20\n2\r0\fH¢\bJ0H¢\bJ0H¢\bR08¢\f\n\b\b\t¨"}, d2={"Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "<init>", "(Lokio/Source;)V", "", "close", "()V", "-deprecated_delegate", "()Lokio/Source;", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "toString", "()Ljava/lang/String;", "Lokio/Source;", "okio"})
public abstract class ForwardingSource
implements Source {
    @NotNull
    private final Source delegate;

    public ForwardingSource(@NotNull Source delegate) {
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        this.delegate = delegate;
    }

    @JvmName(name="delegate")
    @NotNull
    public final Source delegate() {
        return this.delegate;
    }

    @Override
    public long read(@NotNull Buffer sink2, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        return this.delegate.read(sink2, byteCount);
    }

    @Override
    @NotNull
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @Override
    public void close() throws IOException {
        this.delegate.close();
    }

    @NotNull
    public String toString() {
        return this.getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="delegate", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_delegate")
    @NotNull
    public final Source -deprecated_delegate() {
        return this.delegate;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 4\n\n\n\n \n\n\n\n\b\n\n \n\t\n\b\n\n\b\b 20B#0000¢\b\b\tJ\n0H¢\b\nJ\f0H¢\b\fJ020\r20H¢\bR08@X¢\n\bR#0008¢\f\n\b\b¨"}, d2={"Lokhttp3/internal/cache/FaultHidingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "Lkotlin/Function1;", "Ljava/io/IOException;", "", "onException", "<init>", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "close", "()V", "flush", "Lokio/Buffer;", "source", "", "byteCount", "write", "(Lokio/Buffer;J)V", "", "hasErrors", "Z", "Lkotlin/jvm/functions/Function1;", "getOnException", "()Lkotlin/jvm/functions/Function1;", "okhttp"})
public class FaultHidingSink
extends ForwardingSink {
    @NotNull
    private final Function1<IOException, Unit> onException;
    private boolean hasErrors;

    public FaultHidingSink(@NotNull Sink delegate, @NotNull Function1<? super IOException, Unit> onException) {
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        Intrinsics.checkNotNullParameter(onException, (String)"onException");
        super(delegate);
        this.onException = onException;
    }

    @NotNull
    public final Function1<IOException, Unit> getOnException() {
        return this.onException;
    }

    @Override
    public void write(@NotNull Buffer source2, long byteCount) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        if (this.hasErrors) {
            source2.skip(byteCount);
            return;
        }
        try {
            super.write(source2, byteCount);
        }
        catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke((Object)e);
        }
    }

    @Override
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        }
        catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke((Object)e);
        }
    }

    @Override
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        }
        catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke((Object)e);
        }
    }
}


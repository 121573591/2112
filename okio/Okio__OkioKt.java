/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BlackholeSink;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=5, xi=48, d1={" .\n\n\b\n\n\b\n\n\n \n\n\n\b\n\n\b0 H¢\b0*0 ¢\b0\b*0¢\b\tC8\"\b \f*\n0\nj`\"\b\r*8 28 80H\bø ¢\b\n\b20¨"}, d2={"Lokio/Sink;", "blackhole", "()Lokio/Sink;", "blackholeSink", "Lokio/BufferedSink;", "buffer", "(Lokio/Sink;)Lokio/BufferedSink;", "Lokio/Source;", "Lokio/BufferedSource;", "(Lokio/Source;)Lokio/BufferedSource;", "Ljava/io/Closeable;", "Lokio/Closeable;", "T", "R", "Lkotlin/Function1;", "block", "use", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, xs="okio/Okio")
final class Okio__OkioKt {
    @NotNull
    public static final BufferedSource buffer(@NotNull Source $this$buffer) {
        Intrinsics.checkNotNullParameter((Object)$this$buffer, (String)"<this>");
        return new RealBufferedSource($this$buffer);
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink $this$buffer) {
        Intrinsics.checkNotNullParameter((Object)$this$buffer, (String)"<this>");
        return new RealBufferedSink($this$buffer);
    }

    @JvmName(name="blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    public static final <T extends Closeable, R> R use(T $this$use, @NotNull Function1<? super T, ? extends R> block) {
        Throwable thrown;
        Object result;
        block16: {
            Intrinsics.checkNotNullParameter(block, (String)"block");
            boolean $i$f$use = false;
            result = null;
            thrown = null;
            result = block.invoke($this$use);
            InlineMarker.finallyStart((int)1);
            try {
                T t = $this$use;
                if (t != null) {
                    t.close();
                }
            }
            catch (Throwable t) {
                thrown = t;
            }
            InlineMarker.finallyEnd((int)1);
            break block16;
            catch (Throwable t) {
                block15: {
                    try {
                        thrown = t;
                    }
                    catch (Throwable throwable) {
                        InlineMarker.finallyStart((int)1);
                        try {
                            T t2 = $this$use;
                            if (t2 != null) {
                                t2.close();
                            }
                        }
                        catch (Throwable t3) {
                            thrown = t3;
                        }
                        InlineMarker.finallyEnd((int)1);
                        throw throwable;
                    }
                    InlineMarker.finallyStart((int)1);
                    try {
                        T t4 = $this$use;
                        if (t4 != null) {
                            t4.close();
                        }
                    }
                    catch (Throwable t5) {
                        if (thrown == null) {
                            thrown = t5;
                            break block15;
                        }
                        ExceptionsKt.addSuppressed((Throwable)thrown, (Throwable)t5);
                    }
                }
                InlineMarker.finallyEnd((int)1);
            }
        }
        Throwable throwable = thrown;
        if (throwable != null) {
            throw throwable;
        }
        Object object = result;
        Intrinsics.checkNotNull((Object)object);
        return (R)object;
    }
}


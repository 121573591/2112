/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\n \n\n\b\bæ  20:\bJ020H&¢\b¨\t"}, d2={"Lokhttp3/Interceptor;", "", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Companion", "Chain", "okhttp"})
public interface Interceptor {
    @NotNull
    public static final Companion Companion = okhttp3.Interceptor$Companion.$$INSTANCE;

    @NotNull
    public Response intercept(@NotNull Chain var1) throws IOException;

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 6\n\n \n\n\b\n\b\n\b\n\n\b\n\n \n\n\b\n\n\b\bf 20J0H&¢\bJ0H&¢\bJ\t0\bH&¢\b\t\nJ0\r2\f0H&¢\bJ0H&¢\bJ\f0H&¢\b\fJ0 2020H&¢\bJ0 2020H&¢\bJ0 2020H&¢\bJ0H&¢\b¨"}, d2={"Lokhttp3/Interceptor$Chain;", "", "Lokhttp3/Call;", "call", "()Lokhttp3/Call;", "", "connectTimeoutMillis", "()I", "Lokhttp3/Connection;", "connection", "()Lokhttp3/Connection;", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "proceed", "(Lokhttp3/Request;)Lokhttp3/Response;", "readTimeoutMillis", "()Lokhttp3/Request;", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "withConnectTimeout", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/Interceptor$Chain;", "withReadTimeout", "withWriteTimeout", "writeTimeoutMillis", "okhttp"})
    public static interface Chain {
        @NotNull
        public Request request();

        @NotNull
        public Response proceed(@NotNull Request var1) throws IOException;

        @Nullable
        public Connection connection();

        @NotNull
        public Call call();

        public int connectTimeoutMillis();

        @NotNull
        public Chain withConnectTimeout(int var1, @NotNull TimeUnit var2);

        public int readTimeoutMillis();

        @NotNull
        public Chain withReadTimeout(int var1, @NotNull TimeUnit var2);

        public int writeTimeoutMillis();

        @NotNull
        public Chain withWriteTimeout(int var1, @NotNull TimeUnit var2);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" *\n\n \n\b\n\n\n\n\b\n\n \n\n\b\b 20B\t\b¢\bJ8\f02#\b\n0¢\f\b\b\b\b\b(\b0\t0H\nø ¢\b\f\r\n\b20¨"}, d2={"Lokhttp3/Interceptor$Companion;", "", "<init>", "()V", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/ParameterName;", "name", "chain", "Lokhttp3/Response;", "block", "Lokhttp3/Interceptor;", "invoke", "(Lkotlin/jvm/functions/Function1;)Lokhttp3/Interceptor;", "okhttp"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        @NotNull
        public final Interceptor invoke(@NotNull Function1<? super Chain, Response> block) {
            Intrinsics.checkNotNullParameter(block, (String)"block");
            boolean $i$f$invoke = false;
            return new Interceptor(block){
                final /* synthetic */ Function1<Chain, Response> $block;
                {
                    this.$block = $block;
                }

                @NotNull
                public final Response intercept(@NotNull Chain it) {
                    Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                    return (Response)this.$block.invoke((Object)it);
                }
            };
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.RealInterceptorChain;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\b\n\n \n\n\b\bÆ 20B\t\b¢\bJ020H¢\b\b¨\t"}, d2={"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "okhttp"})
public final class ConnectInterceptor
implements Interceptor {
    @NotNull
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    private ConnectInterceptor() {
    }

    @Override
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        RealInterceptorChain realChain = (RealInterceptorChain)chain;
        Exchange exchange = realChain.getCall$okhttp().initExchange$okhttp((RealInterceptorChain)chain);
        RealInterceptorChain connectedChain = RealInterceptorChain.copy$okhttp$default(realChain, 0, exchange, null, 0, 0, 0, 61, null);
        return connectedChain.proceed(realChain.getRequest$okhttp());
    }
}


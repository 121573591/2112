/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.SocketTimeoutException
 *  java.security.cert.CertificateException
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.HttpMethod;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" R\n\n\n\n\b\n\n \n\n \n\n\b\n\n\b\n\n\b\n\n \n\n\b\n\n\b\n\b\n\b  '20:'B0¢\bJ!0\n202\t0\bH¢\b\fJ#0\n202\b0\rH¢\bJ020H¢\bJ02020H¢\bJ/0202020\n20H¢\bJ 02020\nH¢\b !J$0\"202#0\"H¢\b$%R08X¢\n\b&¨("}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/OkHttpClient;", "client", "<init>", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Response;", "userResponse", "", "method", "Lokhttp3/Request;", "buildRedirectRequest", "(Lokhttp3/Response;Ljava/lang/String;)Lokhttp3/Request;", "Lokhttp3/internal/connection/Exchange;", "exchange", "followUpRequest", "(Lokhttp3/Response;Lokhttp3/internal/connection/Exchange;)Lokhttp3/Request;", "Lokhttp3/Interceptor$Chain;", "chain", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Ljava/io/IOException;", "e", "", "requestSendStarted", "isRecoverable", "(Ljava/io/IOException;Z)Z", "Lokhttp3/internal/connection/RealCall;", "call", "userRequest", "recover", "(Ljava/io/IOException;Lokhttp3/internal/connection/RealCall;Lokhttp3/Request;Z)Z", "requestIsOneShot", "(Ljava/io/IOException;Lokhttp3/Request;)Z", "", "defaultDelay", "retryAfter", "(Lokhttp3/Response;I)I", "Lokhttp3/OkHttpClient;", "Companion", "okhttp"})
public final class RetryAndFollowUpInterceptor
implements Interceptor {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final OkHttpClient client;
    private static final int MAX_FOLLOW_UPS = 20;

    public RetryAndFollowUpInterceptor(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter((Object)client, (String)"client");
        this.client = client;
    }

    /*
     * Exception decompiling
     */
    @Override
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Unknown Source:65)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Unknown Source:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Unknown Source:39)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1424)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private final boolean recover(IOException e, RealCall call, Request userRequest, boolean requestSendStarted) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if (requestSendStarted && this.requestIsOneShot(e, userRequest)) {
            return false;
        }
        if (!this.isRecoverable(e, requestSendStarted)) {
            return false;
        }
        return call.retryAfterFailure();
    }

    private final boolean requestIsOneShot(IOException e, Request userRequest) {
        RequestBody requestBody = userRequest.body();
        return requestBody != null && requestBody.isOneShot() || e instanceof FileNotFoundException;
    }

    private final boolean isRecoverable(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        if (e instanceof InterruptedIOException) {
            return e instanceof SocketTimeoutException && !requestSendStarted;
        }
        if (e instanceof SSLHandshakeException && e.getCause() instanceof CertificateException) {
            return false;
        }
        return !(e instanceof SSLPeerUnverifiedException);
    }

    private final Request followUpRequest(Response userResponse, Exchange exchange) throws IOException {
        Object object = exchange;
        Route route = object != null && (object = ((Exchange)object).getConnection$okhttp()) != null ? ((RealConnection)object).route() : null;
        int responseCode = userResponse.code();
        String method = userResponse.request().method();
        switch (responseCode) {
            case 407: {
                Route route2 = route;
                Intrinsics.checkNotNull((Object)route2);
                Proxy selectedProxy = route2.proxy();
                if (selectedProxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, userResponse);
            }
            case 401: {
                return this.client.authenticator().authenticate(route, userResponse);
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: 
            case 307: 
            case 308: {
                return this.buildRedirectRequest(userResponse, method);
            }
            case 408: {
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                RequestBody requestBody = userResponse.request().body();
                if (requestBody != null && requestBody.isOneShot()) {
                    return null;
                }
                Response priorResponse = userResponse.priorResponse();
                if (priorResponse != null && priorResponse.code() == 408) {
                    return null;
                }
                if (this.retryAfter(userResponse, 0) > 0) {
                    return null;
                }
                return userResponse.request();
            }
            case 503: {
                Response priorResponse = userResponse.priorResponse();
                if (priorResponse != null && priorResponse.code() == 503) {
                    return null;
                }
                if (this.retryAfter(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.request();
                }
                return null;
            }
            case 421: {
                RequestBody requestBody = userResponse.request().body();
                if (requestBody != null && requestBody.isOneShot()) {
                    return null;
                }
                if (exchange == null || !exchange.isCoalescedConnection$okhttp()) {
                    return null;
                }
                exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
                return userResponse.request();
            }
        }
        return null;
    }

    private final Request buildRedirectRequest(Response userResponse, String method) {
        if (!this.client.followRedirects()) {
            return null;
        }
        String string = Response.header$default(userResponse, "Location", null, 2, null);
        if (string == null) {
            return null;
        }
        String location = string;
        HttpUrl httpUrl = userResponse.request().url().resolve(location);
        if (httpUrl == null) {
            return null;
        }
        HttpUrl url = httpUrl;
        boolean sameScheme = Intrinsics.areEqual((Object)url.scheme(), (Object)userResponse.request().url().scheme());
        if (!sameScheme && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder requestBuilder = userResponse.request().newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            boolean maintainBody;
            int responseCode = userResponse.code();
            boolean bl = maintainBody = HttpMethod.INSTANCE.redirectsWithBody(method) || responseCode == 308 || responseCode == 307;
            if (HttpMethod.INSTANCE.redirectsToGet(method) && responseCode != 308 && responseCode != 307) {
                requestBuilder.method("GET", null);
            } else {
                RequestBody requestBody = maintainBody ? userResponse.request().body() : null;
                requestBuilder.method(method, requestBody);
            }
            if (!maintainBody) {
                requestBuilder.removeHeader("Transfer-Encoding");
                requestBuilder.removeHeader("Content-Length");
                requestBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(userResponse.request().url(), url)) {
            requestBuilder.removeHeader("Authorization");
        }
        return requestBuilder.url(url).build();
    }

    private final int retryAfter(Response userResponse, int defaultDelay) {
        String string = Response.header$default(userResponse, "Retry-After", null, 2, null);
        if (string == null) {
            return defaultDelay;
        }
        String header = string;
        CharSequence charSequence = header;
        if (new Regex("\\d+").matches(charSequence)) {
            Integer n = Integer.valueOf((String)header);
            Intrinsics.checkNotNullExpressionValue((Object)n, (String)"valueOf(header)");
            return ((Number)n).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\b\n\b\b 20B\t\b¢\bR08XT¢\n\b¨"}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "<init>", "()V", "", "MAX_FOLLOW_UPS", "I", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


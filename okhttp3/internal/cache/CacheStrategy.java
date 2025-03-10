/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.concurrent.TimeUnit
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\n \n\n\b\f  20:B\b \b0\b0¢\bR08¢\f\n\b\b\b\t\nR08¢\f\n\b\b\f\r¨"}, d2={"Lokhttp3/internal/cache/CacheStrategy;", "", "Lokhttp3/Request;", "networkRequest", "Lokhttp3/Response;", "cacheResponse", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "Lokhttp3/Response;", "getCacheResponse", "()Lokhttp3/Response;", "Lokhttp3/Request;", "getNetworkRequest", "()Lokhttp3/Request;", "Companion", "Factory", "okhttp"})
public final class CacheStrategy {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Request networkRequest;
    @Nullable
    private final Response cacheResponse;

    public CacheStrategy(@Nullable Request networkRequest, @Nullable Response cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }

    @Nullable
    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    @Nullable
    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"  \n\n \n\b\n\n \n\n \n\n\b\b 20B\t\b¢\bJ\t0\b2020¢\b\t\n¨"}, d2={"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "<init>", "()V", "Lokhttp3/Response;", "response", "Lokhttp3/Request;", "request", "", "isCacheable", "(Lokhttp3/Response;Lokhttp3/Request;)Z", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isCacheable(@NotNull Response response, @NotNull Request request) {
            Intrinsics.checkNotNullParameter((Object)response, (String)"response");
            Intrinsics.checkNotNullParameter((Object)request, (String)"request");
            switch (response.code()) {
                case 200: 
                case 203: 
                case 204: 
                case 300: 
                case 301: 
                case 308: 
                case 404: 
                case 405: 
                case 410: 
                case 414: 
                case 501: {
                    break;
                }
                case 302: 
                case 307: {
                    if (Response.header$default(response, "Expires", null, 2, null) != null || response.cacheControl().maxAgeSeconds() != -1 || response.cacheControl().isPublic() || response.cacheControl().isPrivate()) break;
                    return false;
                }
                default: {
                    return false;
                }
            }
            return !response.cacheControl().noStore() && !request.cacheControl().noStore();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" D\n\n \n\t\n \n\n \n\n\b\n\n\b\n\n\b\n\b\n\b\n\n\b\n\n\b\r 20B!00\b0¢\b\b\tJ\n0H¢\b\nJ\r\r0\f¢\b\rJ0\fH¢\bJ0H¢\bJ020H¢\bJ0H¢\bR08@X¢\n\bR08X¢\n\bR08@X¢\n\bR08@X¢\n\bR 08@X¢\n\b R!08@X¢\n\b!R08X¢\n\b\"R#08@X¢\n\b#\"R08 X¢\f\n\b$\b%&R'08@X¢\n\b'\"R(08@X¢\n\b(R)08@X¢\n\b)¨*"}, d2={"Lokhttp3/internal/cache/CacheStrategy$Factory;", "", "", "nowMillis", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "cacheResponse", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "cacheResponseAge", "()J", "Lokhttp3/internal/cache/CacheStrategy;", "compute", "()Lokhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "", "hasConditions", "(Lokhttp3/Request;)Z", "isFreshnessLifetimeHeuristic", "()Z", "", "ageSeconds", "I", "Lokhttp3/Response;", "", "etag", "Ljava/lang/String;", "Ljava/util/Date;", "expires", "Ljava/util/Date;", "lastModified", "lastModifiedString", "J", "receivedResponseMillis", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "sentRequestMillis", "servedDate", "servedDateString", "okhttp"})
    public static final class Factory {
        private final long nowMillis;
        @NotNull
        private final Request request;
        @Nullable
        private final Response cacheResponse;
        @Nullable
        private Date servedDate;
        @Nullable
        private String servedDateString;
        @Nullable
        private Date lastModified;
        @Nullable
        private String lastModifiedString;
        @Nullable
        private Date expires;
        private long sentRequestMillis;
        private long receivedResponseMillis;
        @Nullable
        private String etag;
        private int ageSeconds;

        public Factory(long nowMillis, @NotNull Request request, @Nullable Response cacheResponse) {
            Intrinsics.checkNotNullParameter((Object)request, (String)"request");
            this.nowMillis = nowMillis;
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (this.cacheResponse != null) {
                this.sentRequestMillis = this.cacheResponse.sentRequestAtMillis();
                this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
                Headers headers = this.cacheResponse.headers();
                int n = headers.size();
                for (int i = 0; i < n; ++i) {
                    String fieldName = headers.name(i);
                    String value = headers.value(i);
                    if (StringsKt.equals((String)fieldName, (String)"Date", (boolean)true)) {
                        this.servedDate = DatesKt.toHttpDateOrNull(value);
                        this.servedDateString = value;
                        continue;
                    }
                    if (StringsKt.equals((String)fieldName, (String)"Expires", (boolean)true)) {
                        this.expires = DatesKt.toHttpDateOrNull(value);
                        continue;
                    }
                    if (StringsKt.equals((String)fieldName, (String)"Last-Modified", (boolean)true)) {
                        this.lastModified = DatesKt.toHttpDateOrNull(value);
                        this.lastModifiedString = value;
                        continue;
                    }
                    if (StringsKt.equals((String)fieldName, (String)"ETag", (boolean)true)) {
                        this.etag = value;
                        continue;
                    }
                    if (!StringsKt.equals((String)fieldName, (String)"Age", (boolean)true)) continue;
                    this.ageSeconds = Util.toNonNegativeInt(value, -1);
                }
            }
        }

        @NotNull
        public final Request getRequest$okhttp() {
            return this.request;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull((Object)response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        @NotNull
        public final CacheStrategy compute() {
            CacheStrategy candidate = this.computeCandidate();
            if (candidate.getNetworkRequest() != null && this.request.cacheControl().onlyIfCached()) {
                return new CacheStrategy(null, null);
            }
            return candidate;
        }

        private final CacheStrategy computeCandidate() {
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (this.request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!Companion.isCacheable(this.cacheResponse, this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl requestCaching = this.request.cacheControl();
            if (requestCaching.noCache() || this.hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl responseCaching = this.cacheResponse.cacheControl();
            long ageMillis = this.cacheResponseAge();
            long freshMillis = this.computeFreshnessLifetime();
            if (requestCaching.maxAgeSeconds() != -1) {
                freshMillis = Math.min((long)freshMillis, (long)TimeUnit.SECONDS.toMillis((long)requestCaching.maxAgeSeconds()));
            }
            long minFreshMillis = 0L;
            if (requestCaching.minFreshSeconds() != -1) {
                minFreshMillis = TimeUnit.SECONDS.toMillis((long)requestCaching.minFreshSeconds());
            }
            long maxStaleMillis = 0L;
            if (!responseCaching.mustRevalidate() && requestCaching.maxStaleSeconds() != -1) {
                maxStaleMillis = TimeUnit.SECONDS.toMillis((long)requestCaching.maxStaleSeconds());
            }
            if (!responseCaching.noCache() && ageMillis + minFreshMillis < freshMillis + maxStaleMillis) {
                long oneDayMillis;
                Response.Builder builder = this.cacheResponse.newBuilder();
                if (ageMillis + minFreshMillis >= freshMillis) {
                    builder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (ageMillis > (oneDayMillis = 86400000L) && this.isFreshnessLifetimeHeuristic()) {
                    builder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new CacheStrategy(null, builder.build());
            }
            String conditionName = null;
            String conditionValue = null;
            if (this.etag != null) {
                conditionName = "If-None-Match";
                conditionValue = this.etag;
            } else if (this.lastModified != null) {
                conditionName = "If-Modified-Since";
                conditionValue = this.lastModifiedString;
            } else if (this.servedDate != null) {
                conditionName = "If-Modified-Since";
                conditionValue = this.servedDateString;
            } else {
                return new CacheStrategy(this.request, null);
            }
            Headers.Builder conditionalRequestHeaders = this.request.headers().newBuilder();
            String string = conditionValue;
            Intrinsics.checkNotNull((Object)string);
            conditionalRequestHeaders.addLenient$okhttp(conditionName, string);
            Request conditionalRequest = this.request.newBuilder().headers(conditionalRequestHeaders.build()).build();
            return new CacheStrategy(conditionalRequest, this.cacheResponse);
        }

        private final long computeFreshnessLifetime() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull((Object)response);
            CacheControl responseCaching = response.cacheControl();
            if (responseCaching.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis((long)responseCaching.maxAgeSeconds());
            }
            Date expires = this.expires;
            if (expires != null) {
                Date date = this.servedDate;
                long servedMillis = date != null ? date.getTime() : this.receivedResponseMillis;
                long delta = expires.getTime() - servedMillis;
                return delta > 0L ? delta : 0L;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                Date date = this.servedDate;
                long servedMillis = date != null ? date.getTime() : this.sentRequestMillis;
                Date date2 = this.lastModified;
                Intrinsics.checkNotNull((Object)date2);
                long delta = servedMillis - date2.getTime();
                return delta > 0L ? delta / (long)10 : 0L;
            }
            return 0L;
        }

        private final long cacheResponseAge() {
            Date servedDate = this.servedDate;
            long apparentReceivedAge = servedDate != null ? Math.max((long)0L, (long)(this.receivedResponseMillis - servedDate.getTime())) : 0L;
            long receivedAge = this.ageSeconds != -1 ? Math.max((long)apparentReceivedAge, (long)TimeUnit.SECONDS.toMillis((long)this.ageSeconds)) : apparentReceivedAge;
            long responseDuration = this.receivedResponseMillis - this.sentRequestMillis;
            long residentDuration = this.nowMillis - this.receivedResponseMillis;
            return receivedAge + responseDuration + residentDuration;
        }

        private final boolean hasConditions(Request request) {
            return request.header("If-Modified-Since") != null || request.header("If-None-Match") != null;
        }
    }
}


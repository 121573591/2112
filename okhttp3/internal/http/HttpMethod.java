/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n \n\n\b\bÆ 20B\t\b¢\bJ020¢\b\bJ\t020H¢\b\t\bJ\n020¢\b\n\bJ020¢\b\bJ\f020H¢\b\f\b¨\r"}, d2={"Lokhttp3/internal/http/HttpMethod;", "", "<init>", "()V", "", "method", "", "invalidatesCache", "(Ljava/lang/String;)Z", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"})
public final class HttpMethod {
    @NotNull
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public final boolean invalidatesCache(@NotNull String method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return Intrinsics.areEqual((Object)method, (Object)"POST") || Intrinsics.areEqual((Object)method, (Object)"PATCH") || Intrinsics.areEqual((Object)method, (Object)"PUT") || Intrinsics.areEqual((Object)method, (Object)"DELETE") || Intrinsics.areEqual((Object)method, (Object)"MOVE");
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return Intrinsics.areEqual((Object)method, (Object)"POST") || Intrinsics.areEqual((Object)method, (Object)"PUT") || Intrinsics.areEqual((Object)method, (Object)"PATCH") || Intrinsics.areEqual((Object)method, (Object)"PROPPATCH") || Intrinsics.areEqual((Object)method, (Object)"REPORT");
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return !Intrinsics.areEqual((Object)method, (Object)"GET") && !Intrinsics.areEqual((Object)method, (Object)"HEAD");
    }

    public final boolean redirectsWithBody(@NotNull String method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return Intrinsics.areEqual((Object)method, (Object)"PROPFIND");
    }

    public final boolean redirectsToGet(@NotNull String method) {
        Intrinsics.checkNotNullParameter((Object)method, (String)"method");
        return !Intrinsics.areEqual((Object)method, (Object)"PROPFIND");
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashSet
 *  java.util.Set
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" *\n\n \n\b\n\n \n\n\b\n\n\b\n#\n\b 20B¢\bJ020¢\b\bJ\n02\t0¢\b\n\bJ\f020¢\b\f\rR\b008X¢\n\b¨"}, d2={"Lokhttp3/internal/connection/RouteDatabase;", "", "<init>", "()V", "Lokhttp3/Route;", "route", "", "connected", "(Lokhttp3/Route;)V", "failedRoute", "failed", "", "shouldPostpone", "(Lokhttp3/Route;)Z", "", "failedRoutes", "Ljava/util/Set;", "okhttp"})
public final class RouteDatabase {
    @NotNull
    private final Set<Route> failedRoutes = (Set)new LinkedHashSet();

    public final synchronized void failed(@NotNull Route failedRoute) {
        Intrinsics.checkNotNullParameter((Object)failedRoute, (String)"failedRoute");
        this.failedRoutes.add((Object)failedRoute);
    }

    public final synchronized void connected(@NotNull Route route) {
        Intrinsics.checkNotNullParameter((Object)route, (String)"route");
        this.failedRoutes.remove((Object)route);
    }

    public final synchronized boolean shouldPostpone(@NotNull Route route) {
        Intrinsics.checkNotNullParameter((Object)route, (String)"route");
        return this.failedRoutes.contains((Object)route);
    }
}


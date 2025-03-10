/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" z\n\n \n\n \n\n \n\n \n\n\b\n\n \n\n \n\n\b\n\b\n\b\n\n \n\n\b\n\n\b\n\n\b\n\n \n\n\b\n\n\b\n\n\b 20B'000\t0\b¢\b\nJ02\r0\f20¢\bJ702020202020H¢\bJ?0202020202020H¢\bJ\r 0¢\b !J#0\"H¢\b#$J'02&0%¢\b'(J,0+2*0)¢\b,-R08 X¢\f\n\b.\b/0R08X¢\n\b1R08X¢\n\b2R308@X¢\n\b34R\t0\b8X¢\n\b\t5R60\"8@X¢\n\b67R808@X¢\n\b84R908@X¢\n\b94R;0:8@X¢\n\b;<R>0=8@X¢\n\b>?¨@"}, d2={"Lokhttp3/internal/connection/ExchangeFinder;", "", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/EventListener;", "eventListener", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "find", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "Lokhttp3/internal/connection/RealConnection;", "findConnection", "(IIIIZ)Lokhttp3/internal/connection/RealConnection;", "doExtensiveHealthChecks", "findHealthyConnection", "(IIIIZZ)Lokhttp3/internal/connection/RealConnection;", "retryAfterFailure", "()Z", "Lokhttp3/Route;", "retryRoute", "()Lokhttp3/Route;", "Lokhttp3/HttpUrl;", "url", "sameHostAndPort", "(Lokhttp3/HttpUrl;)Z", "Ljava/io/IOException;", "e", "", "trackFailure", "(Ljava/io/IOException;)V", "Lokhttp3/Address;", "getAddress$okhttp", "()Lokhttp3/Address;", "Lokhttp3/internal/connection/RealCall;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionShutdownCount", "I", "Lokhttp3/EventListener;", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/internal/connection/RouteSelector;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "okhttp"})
public final class ExchangeFinder {
    @NotNull
    private final RealConnectionPool connectionPool;
    @NotNull
    private final Address address;
    @NotNull
    private final RealCall call;
    @NotNull
    private final EventListener eventListener;
    @Nullable
    private RouteSelector.Selection routeSelection;
    @Nullable
    private RouteSelector routeSelector;
    private int refusedStreamCount;
    private int connectionShutdownCount;
    private int otherFailureCount;
    @Nullable
    private Route nextRouteToTry;

    public ExchangeFinder(@NotNull RealConnectionPool connectionPool, @NotNull Address address, @NotNull RealCall call, @NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)connectionPool, (String)"connectionPool");
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    @NotNull
    public final Address getAddress$okhttp() {
        return this.address;
    }

    @NotNull
    public final ExchangeCodec find(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) {
        Intrinsics.checkNotNullParameter((Object)client, (String)"client");
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        try {
            RealConnection resultConnection = this.findHealthyConnection(chain.getConnectTimeoutMillis$okhttp(), chain.getReadTimeoutMillis$okhttp(), chain.getWriteTimeoutMillis$okhttp(), client.pingIntervalMillis(), client.retryOnConnectionFailure(), !Intrinsics.areEqual((Object)chain.getRequest$okhttp().method(), (Object)"GET"));
            return resultConnection.newCodec$okhttp(client, chain);
        }
        catch (RouteException e) {
            this.trackFailure(e.getLastConnectException());
            throw e;
        }
        catch (IOException e) {
            this.trackFailure(e);
            throw new RouteException(e);
        }
    }

    private final RealConnection findHealthyConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, boolean doExtensiveHealthChecks) throws IOException {
        while (true) {
            RealConnection candidate;
            if ((candidate = this.findConnection(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled)).isHealthy(doExtensiveHealthChecks)) {
                return candidate;
            }
            candidate.noNewExchanges$okhttp();
            if (this.nextRouteToTry != null) continue;
            RouteSelector.Selection selection = this.routeSelection;
            boolean routesLeft = selection != null ? selection.hasNext() : true;
            if (routesLeft) continue;
            RouteSelector routeSelector = this.routeSelector;
            boolean routesSelectionLeft = routeSelector != null ? routeSelector.hasNext() : true;
            if (!routesSelectionLeft) break;
        }
        throw new IOException("exhausted all routes");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final RealConnection findConnection(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled) throws IOException {
        block24: {
            block23: {
                if (this.call.isCanceled()) {
                    throw new IOException("Canceled");
                }
                callConnection = this.call.getConnection();
                if (callConnection != null) {
                    toClose = null;
                    var8_8 = callConnection;
                    synchronized (var8_8) {
                        $i$a$-synchronized-ExchangeFinder$findConnection$1 = false;
                        if (callConnection.getNoNewExchanges() || !this.sameHostAndPort(callConnection.route().address().url())) {
                            toClose = this.call.releaseConnectionNoEvents$okhttp();
                        }
                        $i$a$-synchronized-ExchangeFinder$findConnection$1 /* !! */  = Unit.INSTANCE;
                    }
                    if (this.call.getConnection() != null) {
                        if (!(toClose == null)) {
                            $i$a$-synchronized-ExchangeFinder$findConnection$1 /* !! */  = "Check failed.";
                            throw new IllegalStateException($i$a$-synchronized-ExchangeFinder$findConnection$1 /* !! */ .toString());
                        }
                        return callConnection;
                    }
                    v0 = toClose;
                    if (v0 != null) {
                        Util.closeQuietly(v0);
                    }
                    this.eventListener.connectionReleased(this.call, callConnection);
                }
                this.refusedStreamCount = 0;
                this.connectionShutdownCount = 0;
                this.otherFailureCount = 0;
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
                    v1 = this.call.getConnection();
                    Intrinsics.checkNotNull((Object)v1);
                    result = v1;
                    this.eventListener.connectionAcquired(this.call, result);
                    return result;
                }
                routes = null;
                route = null;
                if (this.nextRouteToTry == null) break block23;
                routes = null;
                v2 = this.nextRouteToTry;
                Intrinsics.checkNotNull((Object)v2);
                route = v2;
                this.nextRouteToTry = null;
                break block24;
            }
            if (this.routeSelection == null) ** GOTO lbl-1000
            v3 = this.routeSelection;
            Intrinsics.checkNotNull((Object)v3);
            if (v3.hasNext()) {
                routes = null;
                v4 = this.routeSelection;
                Intrinsics.checkNotNull((Object)v4);
                route = v4.next();
            } else lbl-1000:
            // 2 sources

            {
                if ((localRouteSelector = this.routeSelector) == null) {
                    this.routeSelector = localRouteSelector = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
                }
                this.routeSelection = localRouteSelection = localRouteSelector.next();
                routes = localRouteSelection.getRoutes();
                if (this.call.isCanceled()) {
                    throw new IOException("Canceled");
                }
                if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, false)) {
                    v5 = this.call.getConnection();
                    Intrinsics.checkNotNull((Object)v5);
                    result = v5;
                    this.eventListener.connectionAcquired(this.call, result);
                    return result;
                }
                route = localRouteSelection.next();
            }
        }
        newConnection = new RealConnection(this.connectionPool, route);
        this.call.setConnectionToCancel(newConnection);
        try {
            newConnection.connect(connectTimeout, readTimeout, writeTimeout, pingIntervalMillis, connectionRetryEnabled, this.call, this.eventListener);
        }
        finally {
            this.call.setConnectionToCancel(null);
        }
        this.call.getClient().getRouteDatabase().connected(newConnection.route());
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, routes, true)) {
            v6 = this.call.getConnection();
            Intrinsics.checkNotNull((Object)v6);
            result = v6;
            this.nextRouteToTry = route;
            Util.closeQuietly(newConnection.socket());
            this.eventListener.connectionAcquired(this.call, result);
            return result;
        }
        var10_12 = newConnection;
        synchronized (var10_12) {
            $i$a$-synchronized-ExchangeFinder$findConnection$2 = false;
            this.connectionPool.put(newConnection);
            this.call.acquireConnectionNoEvents(newConnection);
            var11_16 = Unit.INSTANCE;
        }
        this.eventListener.connectionAcquired(this.call, newConnection);
        return newConnection;
    }

    public final void trackFailure(@NotNull IOException e) {
        Intrinsics.checkNotNullParameter((Object)((Object)e), (String)"e");
        this.nextRouteToTry = null;
        if (e instanceof StreamResetException && ((StreamResetException)e).errorCode == ErrorCode.REFUSED_STREAM) {
            int n = this.refusedStreamCount;
            this.refusedStreamCount = n + 1;
        } else if (e instanceof ConnectionShutdownException) {
            int n = this.connectionShutdownCount;
            this.connectionShutdownCount = n + 1;
        } else {
            int n = this.otherFailureCount;
            this.otherFailureCount = n + 1;
        }
    }

    public final boolean retryAfterFailure() {
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = this.retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        boolean bl = selection != null ? selection.hasNext() : false;
        if (bl) {
            return true;
        }
        RouteSelector routeSelector = this.routeSelector;
        if (routeSelector == null) {
            return true;
        }
        RouteSelector localRouteSelector = routeSelector;
        return localRouteSelector.hasNext();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0) {
            return null;
        }
        RealConnection realConnection = this.call.getConnection();
        if (realConnection == null) {
            return null;
        }
        RealConnection realConnection2 = connection = realConnection;
        synchronized (realConnection2) {
            block8: {
                block7: {
                    boolean bl = false;
                    if (connection.getRouteFailureCount$okhttp() == 0) break block7;
                    Route route = null;
                    return route;
                }
                if (Util.canReuseConnectionFor(connection.route().address().url(), this.address.url())) break block8;
                Route route = null;
                return route;
            }
            Route route = connection.route();
            return route;
        }
    }

    public final boolean sameHostAndPort(@NotNull HttpUrl url) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        HttpUrl routeUrl = this.address.url();
        return url.port() == routeUrl.port() && Intrinsics.areEqual((Object)url.host(), (Object)routeUrl.host());
    }
}


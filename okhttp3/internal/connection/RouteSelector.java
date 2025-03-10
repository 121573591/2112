/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.SocketAddress
 *  java.net.SocketException
 *  java.net.URI
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.NoSuchElementException
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" j\n\n \n\n \n\n \n\n \n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n \n\n\b\n\b\n\b\n!\n\n\b  -20:-.B'000\t0\b¢\b\nJ\r0\fH¢\b\rJ0\fH¢\bJ0H¢\bJ0H¢\bJ020H¢\bJ!0202\b0H¢\bR08X¢\n\bR08X¢\n\bR\t0\b8X¢\n\b\t R#\b0\"0!8@X¢\n\b#$R&0%8@X¢\n\b&'R*\b0)0(8X¢\n\b*$R+\b00!8@X¢\n\b+$R08X¢\n\b,¨/"}, d2={"Lokhttp3/internal/connection/RouteSelector;", "", "Lokhttp3/Address;", "address", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "eventListener", "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "", "hasNext", "()Z", "hasNextProxy", "Lokhttp3/internal/connection/RouteSelector$Selection;", "next", "()Lokhttp3/internal/connection/RouteSelector$Selection;", "Ljava/net/Proxy;", "nextProxy", "()Ljava/net/Proxy;", "proxy", "", "resetNextInetSocketAddress", "(Ljava/net/Proxy;)V", "Lokhttp3/HttpUrl;", "url", "resetNextProxy", "(Lokhttp3/HttpUrl;Ljava/net/Proxy;)V", "Lokhttp3/Address;", "Lokhttp3/Call;", "Lokhttp3/EventListener;", "", "Ljava/net/InetSocketAddress;", "inetSocketAddresses", "Ljava/util/List;", "", "nextProxyIndex", "I", "", "Lokhttp3/Route;", "postponedRoutes", "proxies", "Lokhttp3/internal/connection/RouteDatabase;", "Companion", "Selection", "okhttp"})
public final class RouteSelector {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Address address;
    @NotNull
    private final RouteDatabase routeDatabase;
    @NotNull
    private final Call call;
    @NotNull
    private final EventListener eventListener;
    @NotNull
    private List<? extends Proxy> proxies;
    private int nextProxyIndex;
    @NotNull
    private List<? extends InetSocketAddress> inetSocketAddresses;
    @NotNull
    private final List<Route> postponedRoutes;

    public RouteSelector(@NotNull Address address, @NotNull RouteDatabase routeDatabase, @NotNull Call call, @NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)routeDatabase, (String)"routeDatabase");
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = (List)new ArrayList();
        this.resetNextProxy(this.address.url(), this.address.proxy());
    }

    public final boolean hasNext() {
        return this.hasNextProxy() || !((Collection)this.postponedRoutes).isEmpty();
    }

    @NotNull
    public final Selection next() throws IOException {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        List routes = (List)new ArrayList();
        while (this.hasNextProxy()) {
            Proxy proxy = this.nextProxy();
            for (InetSocketAddress inetSocketAddress : this.inetSocketAddresses) {
                Route route = new Route(this.address, proxy, inetSocketAddress);
                if (this.routeDatabase.shouldPostpone(route)) {
                    ((Collection)this.postponedRoutes).add((Object)route);
                    continue;
                }
                ((Collection)routes).add((Object)route);
            }
            if (!(!((Collection)routes).isEmpty())) continue;
        }
        if (routes.isEmpty()) {
            CollectionsKt.addAll((Collection)((Collection)routes), (Iterable)((Iterable)this.postponedRoutes));
            this.postponedRoutes.clear();
        }
        return new Selection((List<Route>)routes);
    }

    private final void resetNextProxy(HttpUrl url, Proxy proxy) {
        this.eventListener.proxySelectStart(this.call, url);
        this.proxies = RouteSelector.resetNextProxy$selectProxies(proxy, url, this);
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, url, this.proxies);
    }

    private final boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private final Proxy nextProxy() throws IOException {
        if (!this.hasNextProxy()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.proxies);
        }
        int n = this.nextProxyIndex;
        this.nextProxyIndex = n + 1;
        Proxy result = (Proxy)this.proxies.get(n);
        this.resetNextInetSocketAddress(result);
        return result;
    }

    private final void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        List mutableInetSocketAddresses;
        this.inetSocketAddresses = mutableInetSocketAddresses = (List)new ArrayList();
        String socketHost = null;
        int socketPort = 0;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            socketHost = this.address.url().host();
            socketPort = this.address.url().port();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                boolean $i$a$-require-RouteSelector$resetNextInetSocketAddress$22 = false;
                String $i$a$-require-RouteSelector$resetNextInetSocketAddress$22 = "Proxy.address() is not an InetSocketAddress: " + proxyAddress.getClass();
                throw new IllegalArgumentException($i$a$-require-RouteSelector$resetNextInetSocketAddress$22.toString());
            }
            Intrinsics.checkNotNullExpressionValue((Object)proxyAddress, (String)"proxyAddress");
            socketHost = Companion.getSocketHost((InetSocketAddress)proxyAddress);
            socketPort = ((InetSocketAddress)proxyAddress).getPort();
        }
        if (!(1 <= socketPort ? socketPort < 65536 : false)) {
            throw new SocketException("No route to " + socketHost + ':' + socketPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            ((Collection)mutableInetSocketAddresses).add((Object)InetSocketAddress.createUnresolved((String)socketHost, (int)socketPort));
        } else {
            List<InetAddress> list;
            if (Util.canParseAsIpAddress(socketHost)) {
                list = CollectionsKt.listOf((Object)InetAddress.getByName((String)socketHost));
            } else {
                this.eventListener.dnsStart(this.call, socketHost);
                List<InetAddress> result = this.address.dns().lookup(socketHost);
                if (result.isEmpty()) {
                    throw new UnknownHostException(this.address.dns() + " returned no addresses for " + socketHost);
                }
                this.eventListener.dnsEnd(this.call, socketHost, result);
                list = result;
            }
            List<InetAddress> addresses = list;
            for (InetAddress inetAddress : addresses) {
                ((Collection)mutableInetSocketAddresses).add((Object)new InetSocketAddress(inetAddress, socketPort));
            }
        }
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy $proxy, HttpUrl $url, RouteSelector this$0) {
        Proxy proxy = $proxy;
        if (proxy != null) {
            return CollectionsKt.listOf((Object)proxy);
        }
        URI uri = $url.uri();
        if (uri.getHost() == null) {
            Proxy[] proxyArray = new Proxy[]{Proxy.NO_PROXY};
            return Util.immutableListOf(proxyArray);
        }
        List proxiesOrNull = this$0.address.proxySelector().select(uri);
        Proxy[] proxyArray = (Proxy[])proxiesOrNull;
        if (proxyArray == null || proxyArray.isEmpty()) {
            proxyArray = new Proxy[]{Proxy.NO_PROXY};
            return Util.immutableListOf(proxyArray);
        }
        Intrinsics.checkNotNullExpressionValue((Object)proxiesOrNull, (String)"proxiesOrNull");
        return Util.toImmutableList(proxiesOrNull);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\n\b\b 20B\t\b¢\bR\b0*08F¢\b¨\t"}, d2={"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "<init>", "()V", "Ljava/net/InetSocketAddress;", "", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getSocketHost(@NotNull InetSocketAddress $this$socketHost) {
            Intrinsics.checkNotNullParameter((Object)$this$socketHost, (String)"<this>");
            InetAddress inetAddress = $this$socketHost.getAddress();
            if (inetAddress == null) {
                String string = $this$socketHost.getHostName();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"hostName");
                return string;
            }
            InetAddress address = inetAddress;
            String string = address.getHostAddress();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"address.hostAddress");
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" $\n\n \n \n\n\b\n\n\b\n\b\n\b 20B\f\b00¢\bJ\b0H¢\b\b\tJ\n0H¢\b\nR\r0\f8@X¢\n\b\rR\b008¢\f\n\b\b¨"}, d2={"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "", "Lokhttp3/Route;", "routes", "<init>", "(Ljava/util/List;)V", "", "hasNext", "()Z", "next", "()Lokhttp3/Route;", "", "nextRouteIndex", "I", "Ljava/util/List;", "getRoutes", "()Ljava/util/List;", "okhttp"})
    public static final class Selection {
        @NotNull
        private final List<Route> routes;
        private int nextRouteIndex;

        public Selection(@NotNull List<Route> routes) {
            Intrinsics.checkNotNullParameter(routes, (String)"routes");
            this.routes = routes;
        }

        @NotNull
        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        @NotNull
        public final Route next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            int n = this.nextRouteIndex;
            this.nextRouteIndex = n + 1;
            return (Route)this.routes.get(n);
        }
    }
}


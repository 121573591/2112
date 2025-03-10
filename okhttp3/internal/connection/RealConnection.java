/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.net.ConnectException
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.Socket
 *  java.net.SocketException
 *  java.net.UnknownServiceException
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionSpecSelector;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ð\n\n\n\n\n \n\n\b\n\n\b\n\n \n\n \n\n\b\n\b\n\b\n\n \n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\n \n \n\b\n\n \n\n\b\n\n \n\n\b\n\n \n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n\n\b\n!\n\n\b\n\n\t\n\b\n\n\b\n\n\b   2020: B00¢\b\bJ\r\n0\t¢\b\nJ02\r0\f20H¢\bJE0\t20202020202020¢\bJ'&0\t2 02!02#0\"H ¢\b$%J/'0\t20202020H¢\b'(J+0\t2*0)H¢\b+,J7-0\t2020202020H¢\b-.J110/2020200/2\r0\fH¢\b12J30/H¢\b34J/50\t2*0)202020H¢\b56J0H¢\b7J90\tH ¢\b8J'@02;0:2=\n00<H ¢\b>?JB02A0¢\bBCJI0F2 02E0DH ¢\bGHJO0L2K0JH ¢\bMNJQ0\tH ¢\bPJS0\tH ¢\bRJX0\t2U0T2W0VH¢\bXYJ\\0\t2[0ZH¢\b\\]J_0^H¢\b_`J0H¢\baJc02\fb\b00<H¢\bcdJf0eH¢\bfgJh0\t20H¢\bhiJj02\r0\fH¢\bjkJm0lH¢\bmnJ!s0\t20o2\bp0\"H ¢\bqrRt08@X¢\n\btuR#x\n\b0o0w0v8¢\f\n\bxy\bz{R08¢\f\n\b|\b}~R08@X¢\n\bR0T8@X¢\b\n\bR*08 @ X¢\n\b\b\"\bR08@X¢\b\bRQ08@X¢\n\bQR'S08@X¢\n\bS\b\"\bR_0^8@X¢\n\b_R0e8@X¢\b\n\bR08@X¢\n\buR08X¢\n\bR'08 @ X¢\n\bu\b\"\biR08@X¢\b\n\bRf0e8@X¢\n\bfR08@X¢\b\n\bR08@X¢\n\bu¨¡"}, d2={"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Route;", "route", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "", "cancel", "()V", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Handshake;", "handshake", "", "certificateSupportHost", "(Lokhttp3/HttpUrl;Lokhttp3/Handshake;)Z", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "eventListener", "connect", "(IIIIZLokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/OkHttpClient;", "client", "failedRoute", "Ljava/io/IOException;", "failure", "connectFailed$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/Route;Ljava/io/IOException;)V", "connectFailed", "connectSocket", "(IILokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectionSpecSelector", "connectTls", "(Lokhttp3/internal/connection/ConnectionSpecSelector;)V", "connectTunnel", "(IIILokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/Request;", "tunnelRequest", "createTunnel", "(IILokhttp3/Request;Lokhttp3/HttpUrl;)Lokhttp3/Request;", "createTunnelRequest", "()Lokhttp3/Request;", "establishProtocol", "(Lokhttp3/internal/connection/ConnectionSpecSelector;ILokhttp3/Call;Lokhttp3/EventListener;)V", "()Lokhttp3/Handshake;", "incrementSuccessCount$okhttp", "incrementSuccessCount", "Lokhttp3/Address;", "address", "", "routes", "isEligible$okhttp", "(Lokhttp3/Address;Ljava/util/List;)Z", "isEligible", "doExtensiveChecks", "isHealthy", "(Z)Z", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "newCodec$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "newCodec", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams$okhttp", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "noCoalescedConnections$okhttp", "noCoalescedConnections", "noNewExchanges$okhttp", "noNewExchanges", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "()Lokhttp3/Route;", "candidates", "routeMatchesAny", "(Ljava/util/List;)Z", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "startHttp2", "(I)V", "supportsUrl", "(Lokhttp3/HttpUrl;)Z", "", "toString", "()Ljava/lang/String;", "Lokhttp3/internal/connection/RealCall;", "e", "trackFailure$okhttp", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "trackFailure", "allocationLimit", "I", "", "Ljava/lang/ref/Reference;", "calls", "Ljava/util/List;", "getCalls", "()Ljava/util/List;", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "", "idleAtNs", "J", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed$okhttp", "()Z", "isMultiplexed", "Z", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "Lokhttp3/Route;", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "source", "Lokio/BufferedSource;", "successCount", "Companion", "okhttp"})
@SourceDebugExtension(value={"SMAP\nRealConnection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealConnection.kt\nokhttp3/internal/connection/RealConnection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,765:1\n1#2:766\n608#3,4:767\n608#3,4:774\n615#3,4:778\n1747#4,3:771\n*S KotlinDebug\n*F\n+ 1 RealConnection.kt\nokhttp3/internal/connection/RealConnection\n*L\n529#1:767,4\n582#1:774,4\n648#1:778,4\n574#1:771,3\n*E\n"})
public final class RealConnection
extends Http2Connection.Listener
implements Connection {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final RealConnectionPool connectionPool;
    @NotNull
    private final Route route;
    @Nullable
    private Socket rawSocket;
    @Nullable
    private Socket socket;
    @Nullable
    private Handshake handshake;
    @Nullable
    private Protocol protocol;
    @Nullable
    private Http2Connection http2Connection;
    @Nullable
    private BufferedSource source;
    @Nullable
    private BufferedSink sink;
    private boolean noNewExchanges;
    private boolean noCoalescedConnections;
    private int routeFailureCount;
    private int successCount;
    private int refusedStreamCount;
    private int allocationLimit;
    @NotNull
    private final List<Reference<RealCall>> calls;
    private long idleAtNs;
    @NotNull
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;

    public RealConnection(@NotNull RealConnectionPool connectionPool, @NotNull Route route) {
        Intrinsics.checkNotNullParameter((Object)connectionPool, (String)"connectionPool");
        Intrinsics.checkNotNullParameter((Object)route, (String)"route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = (List)new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    @NotNull
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final void setNoNewExchanges(boolean bl) {
        this.noNewExchanges = bl;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final void setRouteFailureCount$okhttp(int n) {
        this.routeFailureCount = n;
    }

    @NotNull
    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final void setIdleAtNs$okhttp(long l) {
        this.idleAtNs = l;
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        int n = this.successCount;
        this.successCount = n + 1;
    }

    public final void connect(int connectTimeout, int readTimeout, int writeTimeout, int pingIntervalMillis, boolean connectionRetryEnabled, @NotNull Call call, @NotNull EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        if (!(this.protocol == null)) {
            boolean $i$a$-check-RealConnection$connect$22 = false;
            String $i$a$-check-RealConnection$connect$22 = "already connected";
            throw new IllegalStateException($i$a$-check-RealConnection$connect$22.toString());
        }
        RouteException routeException = null;
        List<ConnectionSpec> connectionSpecs = this.route.address().connectionSpecs();
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
        if (this.route.address().sslSocketFactory() == null) {
            if (!connectionSpecs.contains((Object)ConnectionSpec.CLEARTEXT)) {
                throw new RouteException((IOException)new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String host = this.route.address().url().host();
            if (!Platform.Companion.get().isCleartextTrafficPermitted(host)) {
                throw new RouteException((IOException)new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
            }
        } else if (this.route.address().protocols().contains((Object)Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException((IOException)new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        while (true) {
            try {
                if (this.route.requiresTunnel()) {
                    this.connectTunnel(connectTimeout, readTimeout, writeTimeout, call, eventListener);
                    if (this.rawSocket == null) {
                        break;
                    }
                } else {
                    this.connectSocket(connectTimeout, readTimeout, call, eventListener);
                }
                this.establishProtocol(connectionSpecSelector, pingIntervalMillis, call, eventListener);
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), this.protocol);
            }
            catch (IOException e) {
                Socket socket = this.socket;
                if (socket != null) {
                    Util.closeQuietly(socket);
                }
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                this.http2Connection = null;
                this.allocationLimit = 1;
                eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                if (routeException == null) {
                    routeException = new RouteException(e);
                    continue;
                }
                routeException.addConnectException(e);
                if (connectionRetryEnabled && connectionSpecSelector.connectionFailed(e)) continue;
                throw routeException;
            }
            break;
        }
        if (this.route.requiresTunnel() && this.rawSocket == null) {
            throw new RouteException((IOException)((Object)new ProtocolException("Too many tunnel connections attempted: 21")));
        }
        this.idleAtNs = System.nanoTime();
    }

    private final void connectTunnel(int connectTimeout, int readTimeout, int writeTimeout, Call call, EventListener eventListener) throws IOException {
        Request tunnelRequest = this.createTunnelRequest();
        HttpUrl url = tunnelRequest.url();
        for (int i = 0; i < 21; ++i) {
            this.connectSocket(connectTimeout, readTimeout, call, eventListener);
            if (this.createTunnel(readTimeout, writeTimeout, tunnelRequest, url) == null) break;
            Socket socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
        }
    }

    private final void connectSocket(int connectTimeout, int readTimeout, Call call, EventListener eventListener) throws IOException {
        block7: {
            Socket rawSocket;
            Socket socket;
            Proxy proxy = this.route.proxy();
            Address address = this.route.address();
            Proxy.Type type = proxy.type();
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1: 
                case 2: {
                    Socket socket2 = address.socketFactory().createSocket();
                    socket = socket2;
                    Intrinsics.checkNotNull((Object)socket2);
                    break;
                }
                default: {
                    socket = new Socket(proxy);
                }
            }
            this.rawSocket = rawSocket = socket;
            eventListener.connectStart(call, this.route.socketAddress(), proxy);
            rawSocket.setSoTimeout(readTimeout);
            try {
                Platform.Companion.get().connectSocket(rawSocket, this.route.socketAddress(), connectTimeout);
            }
            catch (ConnectException e) {
                ConnectException connectException;
                ConnectException $this$connectSocket_u24lambda_u241 = connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
                boolean bl = false;
                $this$connectSocket_u24lambda_u241.initCause((Throwable)e);
                throw (Throwable)connectException;
            }
            try {
                this.source = Okio.buffer(Okio.source(rawSocket));
                this.sink = Okio.buffer(Okio.sink(rawSocket));
            }
            catch (NullPointerException npe) {
                if (!Intrinsics.areEqual((Object)npe.getMessage(), (Object)NPE_THROW_WITH_NULL)) break block7;
                throw new IOException((Throwable)npe);
            }
        }
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int pingIntervalMillis, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() == null) {
            if (this.route.address().protocols().contains((Object)Protocol.H2_PRIOR_KNOWLEDGE)) {
                this.socket = this.rawSocket;
                this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                this.startHttp2(pingIntervalMillis);
                return;
            }
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
            return;
        }
        eventListener.secureConnectStart(call);
        this.connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(call, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            this.startHttp2(pingIntervalMillis);
        }
    }

    private final void startHttp2(int pingIntervalMillis) throws IOException {
        Http2Connection http2Connection;
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        Socket socket2 = socket;
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSource source2 = bufferedSource;
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)bufferedSink);
        BufferedSink sink2 = bufferedSink;
        socket2.setSoTimeout(0);
        this.http2Connection = http2Connection = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket2, this.route.address().url().host(), source2, sink2).listener(this).pingIntervalMillis(pingIntervalMillis).build();
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(http2Connection, false, null, 3, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        Address address = this.route.address();
        SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        boolean success = false;
        SSLSocket sslSocket = null;
        try {
            SSLSocketFactory sSLSocketFactory = sslSocketFactory;
            Intrinsics.checkNotNull((Object)sSLSocketFactory);
            Socket socket = sSLSocketFactory.createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            Intrinsics.checkNotNull((Object)socket, (String)"null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            sslSocket = (SSLSocket)socket;
            ConnectionSpec connectionSpec = connectionSpecSelector.configureSecureSocket(sslSocket);
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sslSocket, address.url().host(), address.protocols());
            }
            sslSocket.startHandshake();
            SSLSession sslSocketSession = sslSocket.getSession();
            Intrinsics.checkNotNullExpressionValue((Object)sslSocketSession, (String)"sslSocketSession");
            Handshake unverifiedHandshake = Handshake.Companion.get(sslSocketSession);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            Intrinsics.checkNotNull((Object)hostnameVerifier);
            if (!hostnameVerifier.verify(address.url().host(), sslSocketSession)) {
                List<Certificate> peerCertificates2 = unverifiedHandshake.peerCertificates();
                if (!((Collection)peerCertificates2).isEmpty()) {
                    Object object = peerCertificates2.get(0);
                    Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate cert = (X509Certificate)object;
                    throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default((String)("\n              |Hostname " + address.url().host() + " not verified:\n              |    certificate: " + CertificatePinner.Companion.pin((Certificate)cert) + "\n              |    DN: " + cert.getSubjectDN().getName() + "\n              |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(cert) + "\n              "), null, (int)1, null));
                }
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull((Object)certificatePinner);
            CertificatePinner certificatePinner2 = certificatePinner;
            this.handshake = new Handshake(unverifiedHandshake.tlsVersion(), unverifiedHandshake.cipherSuite(), unverifiedHandshake.localCertificates(), (Function0<? extends List<? extends Certificate>>)((Function0)new Function0<List<? extends Certificate>>(certificatePinner2, unverifiedHandshake, address){
                final /* synthetic */ CertificatePinner $certificatePinner;
                final /* synthetic */ Handshake $unverifiedHandshake;
                final /* synthetic */ Address $address;
                {
                    this.$certificatePinner = $certificatePinner;
                    this.$unverifiedHandshake = $unverifiedHandshake;
                    this.$address = $address;
                    super(0);
                }

                @NotNull
                public final List<Certificate> invoke() {
                    CertificateChainCleaner certificateChainCleaner = this.$certificatePinner.getCertificateChainCleaner$okhttp();
                    Intrinsics.checkNotNull((Object)certificateChainCleaner);
                    return certificateChainCleaner.clean(this.$unverifiedHandshake.peerCertificates(), this.$address.url().host());
                }
            }));
            certificatePinner2.check$okhttp(address.url().host(), (Function0<? extends List<? extends X509Certificate>>)((Function0)new Function0<List<? extends X509Certificate>>(this){
                final /* synthetic */ RealConnection this$0;
                {
                    this.this$0 = $receiver;
                    super(0);
                }

                /*
                 * WARNING - void declaration
                 */
                @NotNull
                public final List<X509Certificate> invoke() {
                    void $this$mapTo$iv$iv;
                    Handshake handshake2 = RealConnection.access$getHandshake$p(this.this$0);
                    Intrinsics.checkNotNull((Object)handshake2);
                    Iterable $this$map$iv = (Iterable)handshake2.peerCertificates();
                    boolean $i$f$map = false;
                    Iterable iterable = $this$map$iv;
                    Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        Certificate certificate = (Certificate)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        boolean bl = false;
                        Intrinsics.checkNotNull((Object)it, (String)"null cannot be cast to non-null type java.security.cert.X509Certificate");
                        collection.add((Object)((X509Certificate)it));
                    }
                    return (List)destination$iv$iv;
                }
            }));
            String maybeProtocol = connectionSpec.supportsTlsExtensions() ? Platform.Companion.get().getSelectedProtocol(sslSocket) : null;
            this.socket = (Socket)sslSocket;
            this.source = Okio.buffer(Okio.source((Socket)sslSocket));
            this.sink = Okio.buffer(Okio.sink((Socket)sslSocket));
            String string = maybeProtocol;
            this.protocol = string != null ? Protocol.Companion.get(string) : Protocol.HTTP_1_1;
            success = true;
        }
        catch (Throwable throwable) {
            if (sslSocket != null) {
                Platform.Companion.get().afterHandshake(sslSocket);
            }
            SSLSocket sSLSocket = sslSocket;
            if (sSLSocket != null) {
                Util.closeQuietly((Socket)sSLSocket);
            }
            throw throwable;
        }
        Platform.Companion.get().afterHandshake(sslSocket);
    }

    private final Request createTunnel(int readTimeout, int writeTimeout, Request tunnelRequest, HttpUrl url) throws IOException {
        Response response;
        Request nextRequest = tunnelRequest;
        String requestLine = "CONNECT " + Util.toHostHeader(url, true) + " HTTP/1.1";
        block4: while (true) {
            BufferedSink sink2;
            BufferedSource source2;
            Intrinsics.checkNotNull((Object)this.source);
            Intrinsics.checkNotNull((Object)this.sink);
            Http1ExchangeCodec tunnelCodec = new Http1ExchangeCodec(null, this, source2, sink2);
            source2.timeout().timeout(readTimeout, TimeUnit.MILLISECONDS);
            sink2.timeout().timeout(writeTimeout, TimeUnit.MILLISECONDS);
            tunnelCodec.writeRequest(nextRequest.headers(), requestLine);
            tunnelCodec.finishRequest();
            Response.Builder builder = tunnelCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull((Object)builder);
            response = builder.request(nextRequest).build();
            tunnelCodec.skipConnectBody(response);
            switch (response.code()) {
                case 200: {
                    if (!source2.getBuffer().exhausted() || !sink2.getBuffer().exhausted()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return null;
                }
                case 407: {
                    if (this.route.address().proxyAuthenticator().authenticate(this.route, response) != null) continue block4;
                    throw new IOException("Failed to authenticate with proxy");
                    if (!StringsKt.equals((String)"close", (String)Response.header$default(response, "Connection", null, 2, null), (boolean)true)) continue block4;
                    return nextRequest;
                }
            }
            break;
        }
        throw new IOException("Unexpected response code for CONNECT: " + response.code());
    }

    private final Request createTunnelRequest() throws IOException {
        Request proxyConnectRequest = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", "okhttp/4.12.0").build();
        Response fakeAuthChallengeResponse = new Response.Builder().request(proxyConnectRequest).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request authenticatedRequest = this.route.address().proxyAuthenticator().authenticate(this.route, fakeAuthChallengeResponse);
        Request request = authenticatedRequest;
        if (request == null) {
            request = proxyConnectRequest;
        }
        return request;
    }

    public final boolean isEligible$okhttp(@NotNull Address address, @Nullable List<Route> routes) {
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        RealConnection $this$assertThreadHoldsLock$iv = this;
        boolean $i$f$assertThreadHoldsLock = false;
        if (Util.assertionsEnabled && !Thread.holdsLock((Object)$this$assertThreadHoldsLock$iv)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertThreadHoldsLock$iv));
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges) {
            return false;
        }
        if (!this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)address.url().host(), (Object)this.route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null) {
            return false;
        }
        if (routes == null || !this.routeMatchesAny(routes)) {
            return false;
        }
        if (address.hostnameVerifier() != OkHostnameVerifier.INSTANCE) {
            return false;
        }
        if (!this.supportsUrl(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull((Object)certificatePinner);
            String string = address.url().host();
            Handshake handshake2 = this.handshake();
            Intrinsics.checkNotNull((Object)handshake2);
            certificatePinner.check(string, handshake2.peerCertificates());
        }
        catch (SSLPeerUnverifiedException _) {
            return false;
        }
        return true;
    }

    private final boolean routeMatchesAny(List<Route> candidates) {
        boolean bl;
        block3: {
            Iterable $this$any$iv = (Iterable)candidates;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Route it = (Route)element$iv;
                    boolean bl2 = false;
                    boolean bl3 = it.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual((Object)this.route.socketAddress(), (Object)it.socketAddress());
                    if (!bl3) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean supportsUrl(HttpUrl url) {
        RealConnection $this$assertThreadHoldsLock$iv = this;
        boolean $i$f$assertThreadHoldsLock = false;
        if (Util.assertionsEnabled && !Thread.holdsLock((Object)$this$assertThreadHoldsLock$iv)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + $this$assertThreadHoldsLock$iv));
        }
        HttpUrl routeUrl = this.route.address().url();
        if (url.port() != routeUrl.port()) {
            return false;
        }
        if (Intrinsics.areEqual((Object)url.host(), (Object)routeUrl.host())) {
            return true;
        }
        if (this.noCoalescedConnections) return false;
        if (this.handshake == null) return false;
        Handshake handshake2 = this.handshake;
        Intrinsics.checkNotNull((Object)handshake2);
        if (!this.certificateSupportHost(url, handshake2)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean certificateSupportHost(HttpUrl url, Handshake handshake2) {
        List<Certificate> peerCertificates2 = handshake2.peerCertificates();
        if (((Collection)peerCertificates2).isEmpty()) return false;
        boolean bl = true;
        if (!bl) return false;
        String string = url.host();
        Object object = peerCertificates2.get(0);
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.security.cert.X509Certificate");
        if (!OkHostnameVerifier.INSTANCE.verify(string, (X509Certificate)object)) return false;
        return true;
    }

    @NotNull
    public final ExchangeCodec newCodec$okhttp(@NotNull OkHttpClient client, @NotNull RealInterceptorChain chain) throws SocketException {
        ExchangeCodec exchangeCodec;
        Intrinsics.checkNotNullParameter((Object)client, (String)"client");
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        Socket socket2 = socket;
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSource source2 = bufferedSource;
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)bufferedSink);
        BufferedSink sink2 = bufferedSink;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            exchangeCodec = new Http2ExchangeCodec(client, this, chain, http2Connection);
        } else {
            socket2.setSoTimeout(chain.readTimeoutMillis());
            source2.timeout().timeout(chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            sink2.timeout().timeout(chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            exchangeCodec = new Http1ExchangeCodec(client, this, source2, sink2);
        }
        return exchangeCodec;
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams$okhttp(@NotNull Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter((Object)exchange, (String)"exchange");
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        Socket socket2 = socket;
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSource source2 = bufferedSource;
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)bufferedSink);
        BufferedSink sink2 = bufferedSink;
        socket2.setSoTimeout(0);
        this.noNewExchanges$okhttp();
        return new RealWebSocket.Streams(source2, sink2, exchange){
            final /* synthetic */ Exchange $exchange;
            {
                this.$exchange = $exchange;
                super(true, $source, $sink);
            }

            public void close() {
                this.$exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    @Override
    @NotNull
    public Route route() {
        return this.route;
    }

    public final void cancel() {
        block0: {
            Socket socket = this.rawSocket;
            if (socket == null) break block0;
            Util.closeQuietly(socket);
        }
    }

    @Override
    @NotNull
    public Socket socket() {
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        return socket;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final boolean isHealthy(boolean doExtensiveChecks) {
        long l;
        RealConnection $this$assertThreadDoesntHoldLock$iv = this;
        boolean $i$f$assertThreadDoesntHoldLock = false;
        if (Util.assertionsEnabled && Thread.holdsLock((Object)$this$assertThreadDoesntHoldLock$iv)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv));
        }
        long nowNs = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull((Object)socket);
        Socket rawSocket = socket;
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull((Object)socket2);
        Socket socket3 = socket2;
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSource source2 = bufferedSource;
        if (rawSocket.isClosed() || socket3.isClosed() || socket3.isInputShutdown() || socket3.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(nowNs);
        }
        RealConnection realConnection = this;
        synchronized (realConnection) {
            boolean bl = false;
            l = nowNs - this.idleAtNs;
        }
        long idleDurationNs = l;
        if (idleDurationNs >= 10000000000L && doExtensiveChecks) {
            return Util.isHealthy(socket3, source2);
        }
        return true;
    }

    @Override
    public void onStream(@NotNull Http2Stream stream) throws IOException {
        Intrinsics.checkNotNullParameter((Object)stream, (String)"stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override
    public synchronized void onSettings(@NotNull Http2Connection connection, @NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    @Override
    @Nullable
    public Handshake handshake() {
        return this.handshake;
    }

    public final void connectFailed$okhttp(@NotNull OkHttpClient client, @NotNull Route failedRoute, @NotNull IOException failure) {
        Intrinsics.checkNotNullParameter((Object)client, (String)"client");
        Intrinsics.checkNotNullParameter((Object)failedRoute, (String)"failedRoute");
        Intrinsics.checkNotNullParameter((Object)((Object)failure), (String)"failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase().failed(failedRoute);
    }

    public final synchronized void trackFailure$okhttp(@NotNull RealCall call, @Nullable IOException e) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        if (e instanceof StreamResetException) {
            if (((StreamResetException)e).errorCode == ErrorCode.REFUSED_STREAM) {
                int n = this.refusedStreamCount;
                this.refusedStreamCount = n + 1;
                if (this.refusedStreamCount > 1) {
                    this.noNewExchanges = true;
                    n = this.routeFailureCount;
                    this.routeFailureCount = n + 1;
                }
            } else if (((StreamResetException)e).errorCode != ErrorCode.CANCEL || !call.isCanceled()) {
                this.noNewExchanges = true;
                int n = this.routeFailureCount;
                this.routeFailureCount = n + 1;
            }
        } else if (!this.isMultiplexed$okhttp() || e instanceof ConnectionShutdownException) {
            this.noNewExchanges = true;
            if (this.successCount == 0) {
                if (e != null) {
                    this.connectFailed$okhttp(call.getClient(), this.route, e);
                }
                int n = this.routeFailureCount;
                this.routeFailureCount = n + 1;
            }
        }
    }

    @Override
    @NotNull
    public Protocol protocol() {
        Protocol protocol = this.protocol;
        Intrinsics.checkNotNull((Object)((Object)protocol));
        return protocol;
    }

    @NotNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("Connection{").append(this.route.address().url().host()).append(':').append(this.route.address().url().port()).append(", proxy=").append((Object)this.route.proxy()).append(" hostAddress=").append((Object)this.route.socketAddress()).append(" cipherSuite=");
        Object object = this.handshake;
        if (object == null || (object = ((Handshake)object).cipherSuite()) == null) {
            object = "none";
        }
        return stringBuilder.append(object).append(" protocol=").append((Object)this.protocol).append('}').toString();
    }

    public static final /* synthetic */ Handshake access$getHandshake$p(RealConnection $this) {
        return $this.handshake;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" <\n\n \n\b\n\n \n\n \n\n \n\t\n \n\n\b\n\b\n\b\n\n\b\b 20B\t\b¢\bJ-\r0\f20202\t0\b20\n¢\b\rR0\n8 XT¢\n\bR08XT¢\n\bR08XT¢\n\b¨"}, d2={"Lokhttp3/internal/connection/RealConnection$Companion;", "", "<init>", "()V", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Route;", "route", "Ljava/net/Socket;", "socket", "", "idleAtNs", "Lokhttp3/internal/connection/RealConnection;", "newTestConnection", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;Ljava/net/Socket;J)Lokhttp3/internal/connection/RealConnection;", "IDLE_CONNECTION_HEALTHY_NS", "J", "", "MAX_TUNNEL_ATTEMPTS", "I", "", "NPE_THROW_WITH_NULL", "Ljava/lang/String;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RealConnection newTestConnection(@NotNull RealConnectionPool connectionPool, @NotNull Route route, @NotNull Socket socket, long idleAtNs) {
            Intrinsics.checkNotNullParameter((Object)connectionPool, (String)"connectionPool");
            Intrinsics.checkNotNullParameter((Object)route, (String)"route");
            Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
            RealConnection result = new RealConnection(connectionPool, route);
            result.socket = socket;
            result.setIdleAtNs$okhttp(idleAtNs);
            return result;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Proxy.Type.values().length];
            try {
                nArray[Proxy.Type.DIRECT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Proxy.Type.HTTP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}


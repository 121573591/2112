/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.security.GeneralSecurityException
 *  java.security.Security
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Android10Platform;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.Jdk8WithJettyBootPlatform;
import okhttp3.internal.platform.Jdk9Platform;
import okhttp3.internal.platform.OpenJSSEPlatform;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" z\n\n \n\b\n\n \n\n\b\n\n \n\n\b\n\n\b\n\n \n \n\n\n\b\n\n \n\n \n\b\n\b\n\n\n\b\n\n\b\n\n\b\n\n\b\t\b  ?20:?B¢\bJ020H¢\b\bJ\f02\n0\tH¢\b\f\rJ02\n0\tH¢\bJ40202\b02\r\t0¢\b0H¢\bJ'0202020H¢\b J\r!0¢\b!\"J#020H¢\b#$J&02%0H¢\b&'J)0(20H¢\b)*J-/02+02\b\b,02\n\b.0-H¢\b/0J!202+02\b10H¢\b23J504H¢\b56J8072\n0\tH¢\b89J:0\tH¢\b:;J<0H¢\b<\"J\n0\t2=07H¢\b\n>¨@"}, d2={"Lokhttp3/internal/platform/Platform;", "", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "", "hostname", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "getPrefix", "()Ljava/lang/String;", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "closer", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "message", "level", "", "t", "log", "(Ljava/lang/String;ILjava/lang/Throwable;)V", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/SSLSocketFactory;", "newSslSocketFactory", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "toString", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"})
public class Platform {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static volatile Platform platform = okhttp3.internal.platform.Platform$Companion.access$findPlatform(Companion);
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger = Logger.getLogger((String)OkHttpClient.class.getName());

    @NotNull
    public final String getPrefix() {
        return "OkHttp";
    }

    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS");
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"getInstance(\"TLS\")");
        return sSLContext;
    }

    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory factory2 = TrustManagerFactory.getInstance((String)TrustManagerFactory.getDefaultAlgorithm());
        factory2.init(null);
        Object[] objectArray = factory2.getTrustManagers();
        Intrinsics.checkNotNull((Object)objectArray);
        Object[] trustManagers = objectArray;
        if (!(trustManagers.length == 1 && trustManagers[0] instanceof X509TrustManager)) {
            boolean bl = false;
            StringBuilder stringBuilder = new StringBuilder().append("Unexpected default trust managers: ");
            String string = Arrays.toString((Object[])trustManagers);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(this)");
            String string2 = stringBuilder.append(string).toString();
            throw new IllegalStateException(string2.toString());
        }
        TrustManager trustManager = trustManagers[0];
        Intrinsics.checkNotNull((Object)trustManager, (String)"null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        return (X509TrustManager)trustManager;
    }

    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        X509TrustManager x509TrustManager;
        Intrinsics.checkNotNullParameter((Object)sslSocketFactory, (String)"sslSocketFactory");
        try {
            Class sslContextClass = Class.forName((String)"sun.security.ssl.SSLContextImpl");
            Intrinsics.checkNotNullExpressionValue((Object)sslContextClass, (String)"sslContextClass");
            Object t = Util.readFieldOrNull(sslSocketFactory, sslContextClass, "context");
            if (t == null) {
                return null;
            }
            Object context = t;
            x509TrustManager = Util.readFieldOrNull(context, X509TrustManager.class, "trustManager");
        }
        catch (ClassNotFoundException e) {
            x509TrustManager = null;
        }
        catch (RuntimeException e) {
            if (!Intrinsics.areEqual((Object)e.getClass().getName(), (Object)"java.lang.reflect.InaccessibleObjectException")) {
                throw e;
            }
            x509TrustManager = null;
        }
        return x509TrustManager;
    }

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<Protocol> protocols) {
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(protocols, (String)"protocols");
    }

    public void afterHandshake(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
    }

    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
        return null;
    }

    public void connectSocket(@NotNull Socket socket, @NotNull InetSocketAddress address, int connectTimeout) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        socket.connect((SocketAddress)address, connectTimeout);
    }

    public void log(@NotNull String message, int level, @Nullable Throwable t) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        Level logLevel = level == 5 ? Level.WARNING : Level.INFO;
        logger.log(logLevel, message, t);
    }

    public static /* synthetic */ void log$default(Platform platform, String string, int n, Throwable throwable, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((n2 & 2) != 0) {
            n = 4;
        }
        if ((n2 & 4) != 0) {
            throwable = null;
        }
        platform.log(string, n, throwable);
    }

    public boolean isCleartextTrafficPermitted(@NotNull String hostname) {
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        return true;
    }

    @Nullable
    public Object getStackTraceForCloseable(@NotNull String closer) {
        Intrinsics.checkNotNullParameter((Object)closer, (String)"closer");
        return logger.isLoggable(Level.FINE) ? new Throwable(closer) : null;
    }

    public void logCloseableLeak(@NotNull String message, @Nullable Object stackTrace) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        String logMessage = message;
        if (stackTrace == null) {
            logMessage = logMessage + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        this.log(logMessage, 5, (Throwable)((Object)stackTrace));
    }

    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        return new BasicCertificateChainCleaner(this.buildTrustRootIndex(trustManager));
    }

    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        Object[] objectArray = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"trustManager.acceptedIssuers");
        Object[] objectArray2 = objectArray;
        return new BasicTrustRootIndex((X509Certificate[])Arrays.copyOf((Object[])objectArray2, (int)objectArray2.length));
    }

    @NotNull
    public SSLSocketFactory newSslSocketFactory(@NotNull X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        try {
            SSLContext sSLContext;
            SSLContext $this$newSslSocketFactory_u24lambda_u241 = sSLContext = this.newSSLContext();
            boolean bl = false;
            TrustManager[] trustManagerArray = new TrustManager[]{trustManager};
            $this$newSslSocketFactory_u24lambda_u241.init(null, trustManagerArray, null);
            SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue((Object)sSLSocketFactory, (String)"newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return sSLSocketFactory;
        }
        catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + (Object)((Object)e), (Throwable)e);
        }
    }

    @NotNull
    public String toString() {
        String string = this.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"javaClass.simpleName");
        return string;
    }

    @JvmStatic
    @NotNull
    public static final Platform get() {
        return Companion.get();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" N\n\n \n\b\n \n\n \n\n\b\n\n\b\n\n\b\n\n\b\n\b\n\b\n\n\b\n\n\b\b 20B\t\b¢\bJ!\b\b002\f\b00¢\b\b\tJ0\n2\f\b00¢\b\fJ0\rH¢\bJ0\rH¢\bJ0\rH¢\bJ0\rH¢\bJ02\b\b0\r¢\bR08XT¢\n\bR08XT¢\n\bR08F¢\bR08BX¢\bR08BX¢\bR 08BX¢\b R#\n \"*0!0!8X¢\n\b#$R0\r8@X¢\n\b%¨&"}, d2={"Lokhttp3/internal/platform/Platform$Companion;", "", "<init>", "()V", "", "Lokhttp3/Protocol;", "protocols", "", "alpnProtocolNames", "(Ljava/util/List;)Ljava/util/List;", "", "concatLengthPrefixed", "(Ljava/util/List;)[B", "Lokhttp3/internal/platform/Platform;", "findAndroidPlatform", "()Lokhttp3/internal/platform/Platform;", "findJvmPlatform", "findPlatform", "get", "platform", "", "resetForTests", "(Lokhttp3/internal/platform/Platform;)V", "", "INFO", "I", "WARN", "", "isAndroid", "()Z", "isBouncyCastlePreferred", "isConscryptPreferred", "isOpenJSSEPreferred", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "Lokhttp3/internal/platform/Platform;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,286:1\n766#2:287\n857#2,2:288\n1549#2:290\n1620#2,3:291\n*S KotlinDebug\n*F\n+ 1 Platform.kt\nokhttp3/internal/platform/Platform$Companion\n*L\n193#1:287\n193#1:288,2\n193#1:290\n193#1:291,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Platform get() {
            return platform;
        }

        public final void resetForTests(@NotNull Platform platform) {
            Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
            Platform.platform = platform;
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int n, Object object) {
            if ((n & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final List<String> alpnProtocolNames(@NotNull List<? extends Protocol> protocols) {
            void $this$mapTo$iv$iv;
            Protocol it;
            Iterable $this$filterTo$iv$iv;
            Intrinsics.checkNotNullParameter(protocols, (String)"protocols");
            Iterable $this$filter$iv = (Iterable)protocols;
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = (Collection)new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                it = (Protocol)((Object)element$iv$iv);
                boolean bl = false;
                if (!(it != Protocol.HTTP_1_0)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            Iterable $this$map$iv = (Iterable)((List)destination$iv$iv);
            boolean $i$f$map = false;
            $this$filterTo$iv$iv = $this$map$iv;
            destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                it = (Protocol)((Object)item$iv$iv);
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add((Object)it.toString());
            }
            return (List)destination$iv$iv;
        }

        public final boolean isAndroid() {
            return Intrinsics.areEqual((Object)"Dalvik", (Object)System.getProperty((String)"java.vm.name"));
        }

        private final boolean isConscryptPreferred() {
            String preferredProvider = Security.getProviders()[0].getName();
            return Intrinsics.areEqual((Object)"Conscrypt", (Object)preferredProvider);
        }

        private final boolean isOpenJSSEPreferred() {
            String preferredProvider = Security.getProviders()[0].getName();
            return Intrinsics.areEqual((Object)"OpenJSSE", (Object)preferredProvider);
        }

        private final boolean isBouncyCastlePreferred() {
            String preferredProvider = Security.getProviders()[0].getName();
            return Intrinsics.areEqual((Object)"BC", (Object)preferredProvider);
        }

        private final Platform findPlatform() {
            return this.isAndroid() ? this.findAndroidPlatform() : this.findJvmPlatform();
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform platform = Android10Platform.Companion.buildIfSupported();
            if (platform == null) {
                Platform platform2 = AndroidPlatform.Companion.buildIfSupported();
                platform = platform2;
                Intrinsics.checkNotNull((Object)platform2);
            }
            return platform;
        }

        private final Platform findJvmPlatform() {
            OpenJSSEPlatform openJSSE;
            BouncyCastlePlatform bc;
            ConscryptPlatform conscrypt;
            if (this.isConscryptPreferred() && (conscrypt = ConscryptPlatform.Companion.buildIfSupported()) != null) {
                return conscrypt;
            }
            if (this.isBouncyCastlePreferred() && (bc = BouncyCastlePlatform.Companion.buildIfSupported()) != null) {
                return bc;
            }
            if (this.isOpenJSSEPreferred() && (openJSSE = OpenJSSEPlatform.Companion.buildIfSupported()) != null) {
                return openJSSE;
            }
            Jdk9Platform jdk9 = Jdk9Platform.Companion.buildIfSupported();
            if (jdk9 != null) {
                return jdk9;
            }
            Platform jdkWithJettyBoot = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (jdkWithJettyBoot != null) {
                return jdkWithJettyBoot;
            }
            return new Platform();
        }

        @NotNull
        public final byte[] concatLengthPrefixed(@NotNull List<? extends Protocol> protocols) {
            Intrinsics.checkNotNullParameter(protocols, (String)"protocols");
            Buffer result = new Buffer();
            for (String protocol : this.alpnProtocolNames(protocols)) {
                result.writeByte(protocol.length());
                result.writeUtf8(protocol);
            }
            return result.readByteArray();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final /* synthetic */ Platform access$findPlatform(Companion $this) {
            return $this.findPlatform();
        }
    }
}


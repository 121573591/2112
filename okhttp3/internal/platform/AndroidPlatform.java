/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.security.cert.TrustAnchor
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\b\n\n \n\n\b\n\n\b\n\n \n\n \n \n\n\n \n\n\b\n\n \n\n \n\b\n\b\n \n\b\n\n\b\n\n\b\n\n\b\n\n\b\b  520:56B¢\bJ020H¢\b\bJ\n0\t20H¢\b\nJ402\r0\f2\b02\r\t0¢\b0H¢\bJ'0202020H¢\bJ02\r0\fH¢\b J#0\"2!0H¢\b#$J&0%20H¢\b&'J!*02(02\b)0\"H¢\b*+J02-0,H¢\b.R00/8X¢\n\b01R3\b0208X¢\n\b34¨7"}, d2={"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "closer", "", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "message", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/internal/platform/android/CloseGuard;", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapters", "Ljava/util/List;", "Companion", "CustomTrustRootIndex", "okhttp"})
@SuppressSignatureCheck
@SourceDebugExtension(value={"SMAP\nAndroidPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidPlatform.kt\nokhttp3/internal/platform/AndroidPlatform\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,163:1\n766#2:164\n857#2,2:165\n1#3:167\n*S KotlinDebug\n*F\n+ 1 AndroidPlatform.kt\nokhttp3/internal/platform/AndroidPlatform\n*L\n52#1:164\n52#1:165,2\n*E\n"})
public final class AndroidPlatform
extends Platform {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final List<SocketAdapter> socketAdapters;
    @NotNull
    private final CloseGuard closeGuard;
    private static final boolean isSupported;

    /*
     * WARNING - void declaration
     */
    public AndroidPlatform() {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        SocketAdapter[] socketAdapterArray = new SocketAdapter[]{StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        socketAdapterArray = (SocketAdapter[])CollectionsKt.listOfNotNull((Object[])socketAdapterArray);
        AndroidPlatform androidPlatform = this;
        boolean $i$f$filter = false;
        void var3_4 = $this$filter$iv;
        Collection destination$iv$iv = (Collection)new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            SocketAdapter it = (SocketAdapter)element$iv$iv;
            boolean bl = false;
            if (!it.isSupported()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        androidPlatform.socketAdapters = (List)destination$iv$iv;
        this.closeGuard = CloseGuard.Companion.get();
    }

    @Override
    public void connectSocket(@NotNull Socket socket, @NotNull InetSocketAddress address, int connectTimeout) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        try {
            socket.connect((SocketAddress)address, connectTimeout);
        }
        catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", (Throwable)e);
            }
            throw e;
        }
    }

    @Override
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        Object object;
        block1: {
            Intrinsics.checkNotNullParameter((Object)sslSocketFactory, (String)"sslSocketFactory");
            Iterable iterable = (Iterable)this.socketAdapters;
            for (Object object2 : iterable) {
                SocketAdapter it = (SocketAdapter)object2;
                boolean bl = false;
                if (!it.matchesSocketFactory(sslSocketFactory)) continue;
                object = object2;
                break block1;
            }
            object = null;
        }
        SocketAdapter socketAdapter = (SocketAdapter)object;
        return socketAdapter != null ? socketAdapter.trustManager(sslSocketFactory) : null;
    }

    @Override
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<Protocol> protocols) {
        Object object;
        block2: {
            Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
            Intrinsics.checkNotNullParameter(protocols, (String)"protocols");
            Iterable iterable = (Iterable)this.socketAdapters;
            for (Object object2 : iterable) {
                SocketAdapter it = (SocketAdapter)object2;
                boolean bl = false;
                if (!it.matchesSocket(sslSocket)) continue;
                object = object2;
                break block2;
            }
            object = null;
        }
        SocketAdapter socketAdapter = (SocketAdapter)object;
        if (socketAdapter != null) {
            socketAdapter.configureTlsExtensions(sslSocket, hostname, protocols);
        }
    }

    @Override
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        Object object;
        block1: {
            Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
            Iterable iterable = (Iterable)this.socketAdapters;
            for (Object object2 : iterable) {
                SocketAdapter it = (SocketAdapter)object2;
                boolean bl = false;
                if (!it.matchesSocket(sslSocket)) continue;
                object = object2;
                break block1;
            }
            object = null;
        }
        SocketAdapter socketAdapter = (SocketAdapter)object;
        return socketAdapter != null ? socketAdapter.getSelectedProtocol(sslSocket) : null;
    }

    @Override
    @Nullable
    public Object getStackTraceForCloseable(@NotNull String closer) {
        Intrinsics.checkNotNullParameter((Object)closer, (String)"closer");
        return this.closeGuard.createAndOpen(closer);
    }

    @Override
    public void logCloseableLeak(@NotNull String message, @Nullable Object stackTrace) {
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        boolean reported = this.closeGuard.warnIfOpen(stackTrace);
        if (!reported) {
            Platform.log$default(this, message, 5, null, 4, null);
        }
    }

    @Override
    public boolean isCleartextTrafficPermitted(@NotNull String hostname) {
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        return Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname) : (Build.VERSION.SDK_INT >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true);
    }

    @Override
    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleaner = AndroidCertificateChainCleaner.Companion.buildIfSupported(trustManager);
        return androidCertificateChainCleaner != null ? (CertificateChainCleaner)androidCertificateChainCleaner : super.buildCertificateChainCleaner(trustManager);
    }

    @Override
    @NotNull
    public TrustRootIndex buildTrustRootIndex(@NotNull X509TrustManager trustManager) {
        TrustRootIndex trustRootIndex;
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        try {
            Class[] classArray = new Class[]{X509Certificate.class};
            Method method = trustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", classArray);
            method.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"method");
            trustRootIndex = new CustomTrustRootIndex(trustManager, method);
        }
        catch (NoSuchMethodException e) {
            trustRootIndex = super.buildTrustRootIndex(trustManager);
        }
        return trustRootIndex;
    }

    static {
        boolean bl;
        Companion = new Companion(null);
        if (!Platform.Companion.isAndroid()) {
            bl = false;
        } else if (Build.VERSION.SDK_INT >= 30) {
            bl = false;
        } else {
            if (!(Build.VERSION.SDK_INT >= 21)) {
                boolean bl2 = false;
                String string = "Expected Android API level 21+ but was " + Build.VERSION.SDK_INT;
                throw new IllegalStateException(string.toString());
            }
            bl = true;
        }
        isSupported = bl;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\n\n\b\b 20B\t\b¢\bJ0¢\bR\b08¢\f\n\b\b\t\b\b\n¨"}, d2={"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "<init>", "()V", "Lokhttp3/internal/platform/Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Platform;", "", "isSupported", "Z", "()Z", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isSupported() {
            return isSupported;
        }

        @Nullable
        public final Platform buildIfSupported() {
            return this.isSupported() ? (Platform)new AndroidPlatform() : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" <\n\n\n\n \n\n\b\t\n \n \n\n\b\n\n\b\n\b\n\b\n\n\b\b\b 20B00¢\bJ\b0HÂ¢\b\b\tJ\n0HÂ¢\b\nJ$\f0 2\b\b02\b\b0HÆ¢\b\f\rJ02\b0HÖ¢\bJ020H¢\bJ0HÖ¢\bJ0HÖ¢\bR08X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljava/lang/reflect/Method;", "findByIssuerAndSignatureMethod", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "()Ljavax/net/ssl/X509TrustManager;", "component2", "()Ljava/lang/reflect/Method;", "copy", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/security/cert/X509Certificate;", "cert", "findByIssuerAndSignature", "(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/reflect/Method;", "Ljavax/net/ssl/X509TrustManager;", "okhttp"})
    public static final class CustomTrustRootIndex
    implements TrustRootIndex {
        @NotNull
        private final X509TrustManager trustManager;
        @NotNull
        private final Method findByIssuerAndSignatureMethod;

        public CustomTrustRootIndex(@NotNull X509TrustManager trustManager, @NotNull Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
            Intrinsics.checkNotNullParameter((Object)findByIssuerAndSignatureMethod, (String)"findByIssuerAndSignatureMethod");
            this.trustManager = trustManager;
            this.findByIssuerAndSignatureMethod = findByIssuerAndSignatureMethod;
        }

        @Override
        @Nullable
        public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate cert) {
            X509Certificate x509Certificate;
            Intrinsics.checkNotNullParameter((Object)cert, (String)"cert");
            try {
                Object[] objectArray = new Object[]{cert};
                Object object = this.findByIssuerAndSignatureMethod.invoke((Object)this.trustManager, objectArray);
                Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type java.security.cert.TrustAnchor");
                TrustAnchor trustAnchor = (TrustAnchor)object;
                x509Certificate = trustAnchor.getTrustedCert();
            }
            catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", (Throwable)e);
            }
            catch (InvocationTargetException _) {
                x509Certificate = null;
            }
            return x509Certificate;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        @NotNull
        public final CustomTrustRootIndex copy(@NotNull X509TrustManager trustManager, @NotNull Method findByIssuerAndSignatureMethod) {
            Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
            Intrinsics.checkNotNullParameter((Object)findByIssuerAndSignatureMethod, (String)"findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(trustManager, findByIssuerAndSignatureMethod);
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int n, Object object) {
            if ((n & 1) != 0) {
                x509TrustManager = customTrustRootIndex.trustManager;
            }
            if ((n & 2) != 0) {
                method = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(x509TrustManager, method);
        }

        @NotNull
        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ')';
        }

        public int hashCode() {
            int result = this.trustManager.hashCode();
            result = result * 31 + this.findByIssuerAndSignatureMethod.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex)other;
            if (!Intrinsics.areEqual((Object)this.trustManager, (Object)customTrustRootIndex.trustManager)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.findByIssuerAndSignatureMethod, (Object)customTrustRootIndex.findByIssuerAndSignatureMethod);
        }
    }
}


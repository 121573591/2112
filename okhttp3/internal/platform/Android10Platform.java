/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
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

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
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
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" P\n\n\n\b\n\n \n\n\b\n\n \n\n \n \n\n \n\n\b\n\n\b\n\n\b\n\n\b\b  20:B¢\bJ020H¢\b\bJ/02\n0\t2\b\f02\f\b00\rH¢\bJ02\n0\tH¢\bJ02\f0H¢\bJ020H¢\bR\b00\r8X¢\n\b¨"}, d2={"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapters", "Ljava/util/List;", "Companion", "okhttp"})
@SuppressSignatureCheck
@SourceDebugExtension(value={"SMAP\nAndroid10Platform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Android10Platform.kt\nokhttp3/internal/platform/Android10Platform\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n766#2:73\n857#2,2:74\n1#3:76\n*S KotlinDebug\n*F\n+ 1 Android10Platform.kt\nokhttp3/internal/platform/Android10Platform\n*L\n43#1:73\n43#1:74,2\n*E\n"})
public final class Android10Platform
extends Platform {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<SocketAdapter> socketAdapters;
    private static final boolean isSupported = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;

    /*
     * WARNING - void declaration
     */
    public Android10Platform() {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        SocketAdapter[] socketAdapterArray = new SocketAdapter[]{Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        socketAdapterArray = (SocketAdapter[])CollectionsKt.listOfNotNull((Object[])socketAdapterArray);
        Android10Platform android10Platform = this;
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
        android10Platform.socketAdapters = (List)destination$iv$iv;
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

    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<? extends Protocol> protocols) {
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
    @SuppressLint(value={"NewApi"})
    public boolean isCleartextTrafficPermitted(@NotNull String hostname) {
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(hostname);
    }

    @Override
    @NotNull
    public CertificateChainCleaner buildCertificateChainCleaner(@NotNull X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleaner = AndroidCertificateChainCleaner.Companion.buildIfSupported(trustManager);
        return androidCertificateChainCleaner != null ? (CertificateChainCleaner)androidCertificateChainCleaner : super.buildCertificateChainCleaner(trustManager);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\n\n\b\b 20B\t\b¢\bJ0¢\bR\b08¢\f\n\b\b\t\b\b\n¨"}, d2={"Lokhttp3/internal/platform/Android10Platform$Companion;", "", "<init>", "()V", "Lokhttp3/internal/platform/Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Platform;", "", "isSupported", "Z", "()Z", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isSupported() {
            return isSupported;
        }

        @Nullable
        public final Platform buildIfSupported() {
            return this.isSupported() ? (Platform)new Android10Platform() : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


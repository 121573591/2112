/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.security.Provider
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.bouncycastle.jsse.BCSSLParameters
 *  org.bouncycastle.jsse.BCSSLSocket
 *  org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.platform;

import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Protocol;
import okhttp3.internal.platform.Platform;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" N\n\n\n\b\n\n \n\n \n \n\n\n \n\n\b\n\n\b\n\n\b\n\n\b\n\n\b  20:B\t\b¢\bJ4\r0\f202\b02\r\t0\t¢\b\n0\bH¢\b\rJ020H¢\bJ0H¢\bJ0H¢\bJ020H¢\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/platform/BouncyCastlePlatform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljava/security/Provider;", "provider", "Ljava/security/Provider;", "Companion", "okhttp"})
@SourceDebugExtension(value={"SMAP\nBouncyCastlePlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BouncyCastlePlatform.kt\nokhttp3/internal/platform/BouncyCastlePlatform\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,97:1\n37#2,2:98\n*S KotlinDebug\n*F\n+ 1 BouncyCastlePlatform.kt\nokhttp3/internal/platform/BouncyCastlePlatform\n*L\n65#1:98,2\n*E\n"})
public final class BouncyCastlePlatform
extends Platform {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Provider provider = (Provider)new BouncyCastleJsseProvider();
    private static final boolean isSupported;

    private BouncyCastlePlatform() {
    }

    @Override
    @NotNull
    public SSLContext newSSLContext() {
        SSLContext sSLContext = SSLContext.getInstance((String)"TLS", (Provider)this.provider);
        Intrinsics.checkNotNullExpressionValue((Object)sSLContext, (String)"getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override
    @NotNull
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory factory2 = TrustManagerFactory.getInstance((String)"PKIX", (String)"BCJSSE");
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

    @Override
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)sslSocketFactory, (String)"sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }

    @Override
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<Protocol> protocols) {
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(protocols, (String)"protocols");
        if (sslSocket instanceof BCSSLSocket) {
            BCSSLParameters sslParameters = ((BCSSLSocket)sslSocket).getParameters();
            List<String> names = Platform.Companion.alpnProtocolNames(protocols);
            Collection $this$toTypedArray$iv = (Collection)names;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            sslParameters.setApplicationProtocols((String[])thisCollection$iv.toArray((Object[])new String[0]));
            ((BCSSLSocket)sslSocket).setParameters(sslParameters);
        } else {
            super.configureTlsExtensions(sslSocket, hostname, protocols);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
        if (sslSocket instanceof BCSSLSocket) {
            void var2_2;
            String protocol;
            String string = protocol = ((BCSSLSocket)sslSocket).getApplicationProtocol();
            object = (string == null ? true : Intrinsics.areEqual((Object)string, (Object)"")) ? null : var2_2;
        } else {
            object = super.getSelectedProtocol(sslSocket);
        }
        return object;
    }

    public /* synthetic */ BouncyCastlePlatform(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    static {
        boolean bl;
        Companion = new Companion(null);
        try {
            Class.forName((String)"org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", (boolean)false, (ClassLoader)Companion.getClass().getClassLoader());
            bl = true;
        }
        catch (ClassNotFoundException _) {
            bl = false;
        }
        isSupported = bl;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\n\n\b\b 20B\t\b¢\bJ0¢\bR\b08¢\f\n\b\b\t\b\b\n¨"}, d2={"Lokhttp3/internal/platform/BouncyCastlePlatform$Companion;", "", "<init>", "()V", "Lokhttp3/internal/platform/BouncyCastlePlatform;", "buildIfSupported", "()Lokhttp3/internal/platform/BouncyCastlePlatform;", "", "isSupported", "Z", "()Z", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isSupported() {
            return isSupported;
        }

        @Nullable
        public final BouncyCastlePlatform buildIfSupported() {
            return this.isSupported() ? new BouncyCastlePlatform(null) : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


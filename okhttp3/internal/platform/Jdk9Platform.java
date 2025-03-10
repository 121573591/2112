/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.util.Collection
 *  java.util.List
 *  javax.net.ssl.SSLParameters
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.platform;

import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" <\n\n\n\b\n\n \n\n \n \n\n\n \n\n\b\n\n \n\n\b\b  20:B¢\bJ4\r0\f202\b02\r\t0\t¢\b\n0\bH¢\b\rJ020H¢\bJ020H¢\b¨"}, d2={"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "protocols", "", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"})
@SourceDebugExtension(value={"SMAP\nJdk9Platform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Jdk9Platform.kt\nokhttp3/internal/platform/Jdk9Platform\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,89:1\n37#2,2:90\n*S KotlinDebug\n*F\n+ 1 Jdk9Platform.kt\nokhttp3/internal/platform/Jdk9Platform\n*L\n36#1:90,2\n*E\n"})
public class Jdk9Platform
extends Platform {
    @NotNull
    public static final Companion Companion;
    private static final boolean isAvailable;

    @Override
    @SuppressSignatureCheck
    public void configureTlsExtensions(@NotNull SSLSocket sslSocket, @Nullable String hostname, @NotNull List<Protocol> protocols) {
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(protocols, (String)"protocols");
        SSLParameters sslParameters = sslSocket.getSSLParameters();
        List<String> names = Platform.Companion.alpnProtocolNames(protocols);
        Collection $this$toTypedArray$iv = (Collection)names;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        sslParameters.setApplicationProtocols((String[])thisCollection$iv.toArray((Object[])new String[0]));
        sslSocket.setSSLParameters(sslParameters);
    }

    @Override
    @SuppressSignatureCheck
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket sslSocket) {
        Intrinsics.checkNotNullParameter((Object)sslSocket, (String)"sslSocket");
        try {
            String protocol;
            String string = protocol = sslSocket.getApplicationProtocol();
            return (string == null ? true : Intrinsics.areEqual((Object)string, (Object)"")) ? null : protocol;
        }
        catch (UnsupportedOperationException e) {
            return null;
        }
    }

    @Override
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory sslSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)sslSocketFactory, (String)"sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }

    static {
        boolean bl;
        Integer majorVersion;
        String jdkVersion;
        Companion = new Companion(null);
        String string = jdkVersion = System.getProperty((String)"java.specification.version");
        Object object = majorVersion = string != null ? StringsKt.toIntOrNull((String)string) : null;
        if (majorVersion != null) {
            bl = majorVersion >= 9;
        } else {
            boolean bl2;
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
                bl2 = true;
            }
            catch (NoSuchMethodException nsme) {
                bl2 = false;
            }
            bl = bl2;
        }
        isAvailable = bl;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\n\n\b\b 20B\t\b¢\bJ0¢\bR\b08¢\f\n\b\b\t\b\b\n¨"}, d2={"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "<init>", "()V", "Lokhttp3/internal/platform/Jdk9Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Jdk9Platform;", "", "isAvailable", "Z", "()Z", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public final boolean isAvailable() {
            return isAvailable;
        }

        @Nullable
        public final Jdk9Platform buildIfSupported() {
            return this.isAvailable() ? new Jdk9Platform() : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


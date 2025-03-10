/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.http.X509TrustManagerExtensions
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Collection
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.X509TrustManager
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" >\n\n\n\n \n\n\b\n \n\n \n\n\b\n \n \n\n\b\n\b\n\b\b  20:B00¢\bJ+\r\b0\t0\b2\f\n\b0\t0\b2\f0H¢\b\rJ02\b0H¢\bJ0H¢\bR08X¢\n\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Landroid/net/http/X509TrustManagerExtensions;", "x509TrustManagerExtensions", "<init>", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljavax/net/ssl/X509TrustManager;", "Landroid/net/http/X509TrustManagerExtensions;", "Companion", "okhttp"})
@SuppressSignatureCheck
@SourceDebugExtension(value={"SMAP\nAndroidCertificateChainCleaner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidCertificateChainCleaner.kt\nokhttp3/internal/platform/android/AndroidCertificateChainCleaner\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n37#2,2:75\n1#3:77\n*S KotlinDebug\n*F\n+ 1 AndroidCertificateChainCleaner.kt\nokhttp3/internal/platform/android/AndroidCertificateChainCleaner\n*L\n43#1:75,2\n*E\n"})
public final class AndroidCertificateChainCleaner
extends CertificateChainCleaner {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final X509TrustManager trustManager;
    @NotNull
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    public AndroidCertificateChainCleaner(@NotNull X509TrustManager trustManager, @NotNull X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
        Intrinsics.checkNotNullParameter((Object)x509TrustManagerExtensions, (String)"x509TrustManagerExtensions");
        this.trustManager = trustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions;
    }

    @Override
    @SuppressSignatureCheck
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> chain, @NotNull String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        Collection $this$toTypedArray$iv = (Collection)chain;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        X509Certificate[] certificates = (X509Certificate[])thisCollection$iv.toArray((Object[])new X509Certificate[0]);
        try {
            List list = this.x509TrustManagerExtensions.checkServerTrusted(certificates, "RSA", hostname);
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return list;
        }
        catch (CertificateException ce) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException;
            SSLPeerUnverifiedException $this$clean_u24lambda_u240 = sSLPeerUnverifiedException = new SSLPeerUnverifiedException(ce.getMessage());
            boolean bl = false;
            $this$clean_u24lambda_u240.initCause((Throwable)ce);
            throw (Throwable)sSLPeerUnverifiedException;
        }
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof AndroidCertificateChainCleaner && ((AndroidCertificateChainCleaner)other).trustManager == this.trustManager;
    }

    public int hashCode() {
        return System.identityHashCode((Object)this.trustManager);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n \n\n\b\b 20B\t\b¢\bJ020H¢\b\b¨\t"}, d2={"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "<init>", "()V", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "buildIfSupported", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @SuppressSignatureCheck
        @Nullable
        public final AndroidCertificateChainCleaner buildIfSupported(@NotNull X509TrustManager trustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            Intrinsics.checkNotNullParameter((Object)trustManager, (String)"trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(trustManager);
            }
            catch (IllegalArgumentException iae) {
                x509TrustManagerExtensions = null;
            }
            X509TrustManagerExtensions extensions = x509TrustManagerExtensions;
            return extensions != null ? new AndroidCertificateChainCleaner(trustManager, extensions) : null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


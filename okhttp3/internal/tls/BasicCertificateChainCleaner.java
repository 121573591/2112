/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" @\n\n\n\n\b\n \n\n \n\n\b\n \n \n\n\b\n\b\n\b\n\n\b  20:B0¢\bJ+\b002\f\b\b002\n0\tH¢\b\fJ02\b0\rH¢\bJ0H¢\bJ02020H¢\bR08X¢\n\b¨"}, d2={"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustRootIndex", "<init>", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/security/cert/X509Certificate;", "toVerify", "signingCert", "verifySignature", "(Ljava/security/cert/X509Certificate;Ljava/security/cert/X509Certificate;)Z", "Lokhttp3/internal/tls/TrustRootIndex;", "Companion", "okhttp"})
public final class BasicCertificateChainCleaner
extends CertificateChainCleaner {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TrustRootIndex trustRootIndex;
    private static final int MAX_SIGNERS = 9;

    public BasicCertificateChainCleaner(@NotNull TrustRootIndex trustRootIndex) {
        Intrinsics.checkNotNullParameter((Object)trustRootIndex, (String)"trustRootIndex");
        this.trustRootIndex = trustRootIndex;
    }

    @Override
    @NotNull
    public List<Certificate> clean(@NotNull List<? extends Certificate> chain, @NotNull String hostname) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        Deque queue = (Deque)new ArrayDeque((Collection)chain);
        List result = (List)new ArrayList();
        Object object = queue.removeFirst();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"queue.removeFirst()");
        result.add(object);
        boolean foundTrustedCertificate = false;
        block0: for (int c = 0; c < 9; ++c) {
            Iterator i;
            Object object2 = result.get(result.size() - 1);
            Intrinsics.checkNotNull((Object)object2, (String)"null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate toVerify = (X509Certificate)object2;
            X509Certificate trustedCert = this.trustRootIndex.findByIssuerAndSignature(toVerify);
            if (trustedCert != null) {
                if (result.size() > 1 || !Intrinsics.areEqual((Object)toVerify, (Object)trustedCert)) {
                    result.add((Object)trustedCert);
                }
                if (this.verifySignature(trustedCert, trustedCert)) {
                    return result;
                }
                foundTrustedCertificate = true;
                continue;
            }
            Intrinsics.checkNotNullExpressionValue((Object)queue.iterator(), (String)"queue.iterator()");
            while (i.hasNext()) {
                Object object3 = i.next();
                Intrinsics.checkNotNull((Object)object3, (String)"null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate signingCert = (X509Certificate)object3;
                if (!this.verifySignature(toVerify, signingCert)) continue;
                i.remove();
                result.add((Object)signingCert);
                continue block0;
            }
            if (foundTrustedCertificate) {
                return result;
            }
            throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + toVerify);
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + result);
    }

    private final boolean verifySignature(X509Certificate toVerify, X509Certificate signingCert) {
        boolean bl;
        if (!Intrinsics.areEqual((Object)toVerify.getIssuerDN(), (Object)signingCert.getSubjectDN())) {
            return false;
        }
        try {
            toVerify.verify(signingCert.getPublicKey());
            bl = true;
        }
        catch (GeneralSecurityException verifyFailed) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        return other == this ? true : other instanceof BasicCertificateChainCleaner && Intrinsics.areEqual((Object)((BasicCertificateChainCleaner)other).trustRootIndex, (Object)this.trustRootIndex);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\b\n\b\b 20B\t\b¢\bR08XT¢\n\b¨"}, d2={"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "<init>", "()V", "", "MAX_SIGNERS", "I", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


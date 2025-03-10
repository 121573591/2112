/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.security.cert.X509Certificate
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.Map
 *  java.util.Set
 *  javax.security.auth.x500.X500Principal
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.tls.TrustRootIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" :\n\n\n\n\n\b\n \n \n\n\b\n\b\n\b\n$\n\n\"\n\b 20B\n\b00\"0¢\bJ\n0\t2\b\b0H¢\b\nJ\r02\f0H¢\b\rJ0H¢\bR&0\n\b0008X¢\n\b¨"}, d2={"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "", "Ljava/security/cert/X509Certificate;", "caCerts", "<init>", "([Ljava/security/cert/X509Certificate;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "cert", "findByIssuerAndSignature", "(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;", "", "hashCode", "()I", "", "Ljavax/security/auth/x500/X500Principal;", "", "subjectToCaCerts", "Ljava/util/Map;", "okhttp"})
@SourceDebugExtension(value={"SMAP\nBasicTrustRootIndex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasicTrustRootIndex.kt\nokhttp3/internal/tls/BasicTrustRootIndex\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n372#2,7:57\n288#3,2:64\n*S KotlinDebug\n*F\n+ 1 BasicTrustRootIndex.kt\nokhttp3/internal/tls/BasicTrustRootIndex\n*L\n28#1:57,7\n37#1:64,2\n*E\n"})
public final class BasicTrustRootIndex
implements TrustRootIndex {
    @NotNull
    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;

    /*
     * WARNING - void declaration
     */
    public BasicTrustRootIndex(X509Certificate ... caCerts) {
        Intrinsics.checkNotNullParameter((Object)caCerts, (String)"caCerts");
        Map map = (Map)new LinkedHashMap();
        for (X509Certificate caCert : caCerts) {
            Object object;
            X500Principal key$iv;
            void $this$getOrPut$iv;
            Map map2 = map;
            Intrinsics.checkNotNullExpressionValue((Object)caCert.getSubjectX500Principal(), (String)"caCert.subjectX500Principal");
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get((Object)key$iv);
            if (value$iv == null) {
                boolean bl = false;
                Set answer$iv = (Set)new LinkedHashSet();
                $this$getOrPut$iv.put((Object)key$iv, (Object)answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            ((Set)object).add((Object)caCert);
        }
        this.subjectToCaCerts = map;
    }

    @Override
    @Nullable
    public X509Certificate findByIssuerAndSignature(@NotNull X509Certificate cert) {
        Object object;
        block4: {
            Intrinsics.checkNotNullParameter((Object)cert, (String)"cert");
            X500Principal issuer = cert.getIssuerX500Principal();
            Set set = (Set)this.subjectToCaCerts.get((Object)issuer);
            if (set == null) {
                return null;
            }
            Set subjectCaCerts = set;
            Iterable $this$firstOrNull$iv = (Iterable)subjectCaCerts;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                boolean bl;
                X509Certificate it = (X509Certificate)element$iv;
                boolean bl2 = false;
                try {
                    cert.verify(it.getPublicKey());
                    bl = true;
                }
                catch (Exception _) {
                    bl = false;
                }
                if (!bl) continue;
                object = element$iv;
                break block4;
            }
            object = null;
        }
        return (X509Certificate)object;
    }

    public boolean equals(@Nullable Object other) {
        return other == this || other instanceof BasicTrustRootIndex && Intrinsics.areEqual(((BasicTrustRootIndex)other).subjectToCaCerts, this.subjectToCaCerts);
    }

    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}


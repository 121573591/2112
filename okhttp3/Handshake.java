/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Principal
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.CipherSuite;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" F\n\n \n\n \n\n \n \n\n \n\n\b\n\n\b\n\b\n\b\n\n\b\t\n\n\b\f  -20:-B;\b 00\f\b\b00\n\n\b000\t¢\b\fJ0H¢\b\rJ02\b0H¢\bJ0H¢\bJ\b\b00H¢\bJ0H¢\bJ\b00H¢\bJ0H¢\bJ0H¢\b !J#0\"H¢\b#$R08¢\f\n\b%\bR\b\b008¢\f\n\b\b&\b\bR08G¢\bR!\b008GX¢\f\n\b'(\bR08G¢\bR08¢\f\n\b)\b!R,0\"*08BX¢\b*+¨."}, d2={"Lokhttp3/Handshake;", "", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "localCertificates", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "-deprecated_cipherSuite", "()Lokhttp3/CipherSuite;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "-deprecated_localCertificates", "()Ljava/util/List;", "Ljava/security/Principal;", "-deprecated_localPrincipal", "()Ljava/security/Principal;", "localPrincipal", "-deprecated_peerCertificates", "peerCertificates", "-deprecated_peerPrincipal", "peerPrincipal", "-deprecated_tlsVersion", "()Lokhttp3/TlsVersion;", "", "toString", "()Ljava/lang/String;", "Lokhttp3/CipherSuite;", "Ljava/util/List;", "peerCertificates$delegate", "Lkotlin/Lazy;", "Lokhttp3/TlsVersion;", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Companion", "okhttp"})
@SourceDebugExtension(value={"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,200:1\n1549#2:201\n1620#2,3:202\n1549#2:205\n1620#2,3:206\n*S KotlinDebug\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake\n*L\n129#1:201\n129#1:202,3\n134#1:205\n134#1:206,3\n*E\n"})
public final class Handshake {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final TlsVersion tlsVersion;
    @NotNull
    private final CipherSuite cipherSuite;
    @NotNull
    private final List<Certificate> localCertificates;
    @NotNull
    private final Lazy peerCertificates$delegate;

    public Handshake(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> localCertificates, @NotNull Function0<? extends List<? extends Certificate>> peerCertificatesFn) {
        Intrinsics.checkNotNullParameter((Object)((Object)tlsVersion), (String)"tlsVersion");
        Intrinsics.checkNotNullParameter((Object)cipherSuite, (String)"cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, (String)"localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, (String)"peerCertificatesFn");
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = localCertificates;
        this.peerCertificates$delegate = LazyKt.lazy((Function0)((Function0)new Function0<List<? extends Certificate>>(peerCertificatesFn){
            final /* synthetic */ Function0<List<Certificate>> $peerCertificatesFn;
            {
                this.$peerCertificatesFn = $peerCertificatesFn;
                super(0);
            }

            @NotNull
            public final List<Certificate> invoke() {
                List list;
                try {
                    list = (List)this.$peerCertificatesFn.invoke();
                }
                catch (SSLPeerUnverifiedException spue) {
                    list = CollectionsKt.emptyList();
                }
                return list;
            }
        }));
    }

    @JvmName(name="tlsVersion")
    @NotNull
    public final TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    @JvmName(name="cipherSuite")
    @NotNull
    public final CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    @JvmName(name="localCertificates")
    @NotNull
    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    @JvmName(name="peerCertificates")
    @NotNull
    public final List<Certificate> peerCertificates() {
        Lazy lazy = this.peerCertificates$delegate;
        return (List)lazy.getValue();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="tlsVersion", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_tlsVersion")
    @NotNull
    public final TlsVersion -deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="cipherSuite", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_cipherSuite")
    @NotNull
    public final CipherSuite -deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="peerCertificates", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_peerCertificates")
    @NotNull
    public final List<Certificate> -deprecated_peerCertificates() {
        return this.peerCertificates();
    }

    @JvmName(name="peerPrincipal")
    @Nullable
    public final Principal peerPrincipal() {
        Object object = CollectionsKt.firstOrNull(this.peerCertificates());
        X509Certificate x509Certificate = object instanceof X509Certificate ? (X509Certificate)object : null;
        return (Principal)(x509Certificate != null ? x509Certificate.getSubjectX500Principal() : null);
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="peerPrincipal", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_peerPrincipal")
    @Nullable
    public final Principal -deprecated_peerPrincipal() {
        return this.peerPrincipal();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="localCertificates", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_localCertificates")
    @NotNull
    public final List<Certificate> -deprecated_localCertificates() {
        return this.localCertificates;
    }

    @JvmName(name="localPrincipal")
    @Nullable
    public final Principal localPrincipal() {
        Object object = CollectionsKt.firstOrNull(this.localCertificates);
        X509Certificate x509Certificate = object instanceof X509Certificate ? (X509Certificate)object : null;
        return (Principal)(x509Certificate != null ? x509Certificate.getSubjectX500Principal() : null);
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="localPrincipal", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_localPrincipal")
    @Nullable
    public final Principal -deprecated_localPrincipal() {
        return this.localPrincipal();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Handshake && ((Handshake)other).tlsVersion == this.tlsVersion && Intrinsics.areEqual((Object)((Handshake)other).cipherSuite, (Object)this.cipherSuite) && Intrinsics.areEqual(((Handshake)other).peerCertificates(), this.peerCertificates()) && Intrinsics.areEqual(((Handshake)other).localCertificates, this.localCertificates);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.tlsVersion.hashCode();
        result = 31 * result + this.cipherSuite.hashCode();
        result = 31 * result + this.peerCertificates().hashCode();
        result = 31 * result + this.localCertificates.hashCode();
        return result;
    }

    @NotNull
    public String toString() {
        Certificate it;
        Collection collection;
        Iterable $this$mapTo$iv$iv;
        Iterable $this$map$iv = (Iterable)this.peerCertificates();
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            Certificate certificate = (Certificate)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add((Object)this.getName(it));
        }
        String peerCertificatesString = ((List)destination$iv$iv).toString();
        $this$map$iv = (Iterable)this.localCertificates;
        collection = new StringBuilder().append("Handshake{tlsVersion=").append((Object)this.tlsVersion).append(" cipherSuite=").append((Object)this.cipherSuite).append(" peerCertificates=").append(peerCertificatesString).append(" localCertificates=");
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            it = (Certificate)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl = false;
            collection2.add((Object)this.getName(it));
        }
        return collection.append((Object)((List)destination$iv$iv)).append('}').toString();
    }

    private final String getName(Certificate $this$name) {
        String string;
        if ($this$name instanceof X509Certificate) {
            string = ((X509Certificate)$this$name).getSubjectDN().toString();
        } else {
            String string2 = $this$name.getType();
            string = string2;
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"type");
        }
        return string;
    }

    @JvmStatic
    @JvmName(name="get")
    @NotNull
    public static final Handshake get(@NotNull SSLSession $this$get) throws IOException {
        return Companion.get($this$get);
    }

    @JvmStatic
    @NotNull
    public static final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> peerCertificates2, @NotNull List<? extends Certificate> localCertificates) {
        return Companion.get(tlsVersion, cipherSuite, peerCertificates2, localCertificates);
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" :\n\n \n\b\n\n \n\n\b\n\n \n\n \n \n\n\b\n\n\b\b 20B\t\b¢\bJ\t020H¢\b\bJ;\t020\n2\r0\f2\f\b002\f\b00H¢\b\tJ0*0H¢\b\t\bJ#\b00*\f\b00H¢\b¨"}, d2={"Lokhttp3/Handshake$Companion;", "", "<init>", "()V", "Ljavax/net/ssl/SSLSession;", "sslSession", "Lokhttp3/Handshake;", "-deprecated_get", "(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;", "get", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "peerCertificates", "localCertificates", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Ljava/util/List;)Lokhttp3/Handshake;", "handshake", "", "toImmutableList", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nHandshake.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handshake.kt\nokhttp3/Handshake$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1#2:201\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @JvmName(name="get")
        @NotNull
        public final Handshake get(@NotNull SSLSession $this$handshake) throws IOException {
            List<Certificate> list;
            Intrinsics.checkNotNullParameter((Object)$this$handshake, (String)"<this>");
            String string = $this$handshake.getCipherSuite();
            if (string == null) {
                boolean $i$a$-checkNotNull-Handshake$Companion$handshake$cipherSuiteString$22 = false;
                String $i$a$-checkNotNull-Handshake$Companion$handshake$cipherSuiteString$22 = "cipherSuite == null";
                throw new IllegalStateException($i$a$-checkNotNull-Handshake$Companion$handshake$cipherSuiteString$22.toString());
            }
            String cipherSuiteString = string;
            String $i$a$-checkNotNull-Handshake$Companion$handshake$cipherSuiteString$22 = cipherSuiteString;
            if (Intrinsics.areEqual((Object)$i$a$-checkNotNull-Handshake$Companion$handshake$cipherSuiteString$22, (Object)"TLS_NULL_WITH_NULL_NULL") ? true : Intrinsics.areEqual((Object)$i$a$-checkNotNull-Handshake$Companion$handshake$cipherSuiteString$22, (Object)"SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuiteString);
            }
            CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(cipherSuiteString);
            String string2 = $this$handshake.getProtocol();
            if (string2 == null) {
                boolean $i$a$-checkNotNull-Handshake$Companion$handshake$tlsVersionString$22 = false;
                String $i$a$-checkNotNull-Handshake$Companion$handshake$tlsVersionString$22 = "tlsVersion == null";
                throw new IllegalStateException($i$a$-checkNotNull-Handshake$Companion$handshake$tlsVersionString$22.toString());
            }
            String tlsVersionString = string2;
            if (Intrinsics.areEqual((Object)"NONE", (Object)tlsVersionString)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersion = TlsVersion.Companion.forJavaName(tlsVersionString);
            try {
                list = this.toImmutableList($this$handshake.getPeerCertificates());
            }
            catch (SSLPeerUnverifiedException _) {
                list = CollectionsKt.emptyList();
            }
            List<Certificate> peerCertificatesCopy = list;
            return new Handshake(tlsVersion, cipherSuite, this.toImmutableList($this$handshake.getLocalCertificates()), (Function0<? extends List<? extends Certificate>>)((Function0)new Function0<List<? extends Certificate>>(peerCertificatesCopy){
                final /* synthetic */ List<Certificate> $peerCertificatesCopy;
                {
                    this.$peerCertificatesCopy = $peerCertificatesCopy;
                    super(0);
                }

                @NotNull
                public final List<Certificate> invoke() {
                    return this.$peerCertificatesCopy;
                }
            }));
        }

        private final List<Certificate> toImmutableList(Certificate[] $this$toImmutableList) {
            return $this$toImmutableList != null ? Util.immutableListOf(Arrays.copyOf((Object[])$this$toImmutableList, (int)$this$toImmutableList.length)) : CollectionsKt.emptyList();
        }

        @Deprecated(message="moved to extension function", replaceWith=@ReplaceWith(expression="sslSession.handshake()", imports={}), level=DeprecationLevel.ERROR)
        @JvmName(name="-deprecated_get")
        @NotNull
        public final Handshake -deprecated_get(@NotNull SSLSession sslSession) throws IOException {
            Intrinsics.checkNotNullParameter((Object)sslSession, (String)"sslSession");
            return this.get(sslSession);
        }

        @JvmStatic
        @NotNull
        public final Handshake get(@NotNull TlsVersion tlsVersion, @NotNull CipherSuite cipherSuite, @NotNull List<? extends Certificate> peerCertificates2, @NotNull List<? extends Certificate> localCertificates) {
            Intrinsics.checkNotNullParameter((Object)((Object)tlsVersion), (String)"tlsVersion");
            Intrinsics.checkNotNullParameter((Object)cipherSuite, (String)"cipherSuite");
            Intrinsics.checkNotNullParameter(peerCertificates2, (String)"peerCertificates");
            Intrinsics.checkNotNullParameter(localCertificates, (String)"localCertificates");
            List<? extends Certificate> peerCertificatesCopy = Util.toImmutableList(peerCertificates2);
            return new Handshake(tlsVersion, cipherSuite, Util.toImmutableList(localCertificates), (Function0<? extends List<? extends Certificate>>)((Function0)new Function0<List<? extends Certificate>>(peerCertificatesCopy){
                final /* synthetic */ List<Certificate> $peerCertificatesCopy;
                {
                    this.$peerCertificatesCopy = $peerCertificatesCopy;
                    super(0);
                }

                @NotNull
                public final List<Certificate> invoke() {
                    return this.$peerCertificatesCopy;
                }
            }));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


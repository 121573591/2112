/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Set
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" R\n\n \n\"\n\n \n\n\b\n\n \n\n \n\n \n\n\b\n\n\n\b\n\n\b\n\b\n\b  *20:+*,B#\b \f\b00\n\b0¢\b\bJ+02\n0\t2\n\b0\r0\f0H ¢\bJ+02\n0\t2\n\b00\"0H¢\bJ#02\n0\t2\f\b00\f¢\bJ02\b0H¢\bJ\b00\f2\n0\t¢\bJ0H¢\b J#0 20H ¢\b!\"R08 X¢\f\n\b$\b%&R\b008¢\f\n\b'\b()¨-"}, d2={"Lokhttp3/CertificatePinner;", "", "", "Lokhttp3/CertificatePinner$Pin;", "pins", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "", "hostname", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "", "check$okhttp", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "check", "", "Ljava/security/cert/Certificate;", "peerCertificates", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "(Ljava/lang/String;Ljava/util/List;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "findMatchingPins", "(Ljava/lang/String;)Ljava/util/List;", "", "hashCode", "()I", "withCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "Companion", "Builder", "Pin", "okhttp"})
@SourceDebugExtension(value={"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,370:1\n625#2,8:371\n*S KotlinDebug\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner\n*L\n216#1:371,8\n*E\n"})
public final class CertificatePinner {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Set<Pin> pins;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    @JvmField
    @NotNull
    public static final CertificatePinner DEFAULT = new Builder().build();

    public CertificatePinner(@NotNull Set<Pin> pins, @Nullable CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter(pins, (String)"pins");
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            certificateChainCleaner = null;
        }
        this((Set<Pin>)set, certificateChainCleaner);
    }

    @NotNull
    public final Set<Pin> getPins() {
        return this.pins;
    }

    @Nullable
    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final void check(@NotNull String hostname, @NotNull List<? extends Certificate> peerCertificates2) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        Intrinsics.checkNotNullParameter(peerCertificates2, (String)"peerCertificates");
        this.check$okhttp(hostname, (Function0<? extends List<? extends X509Certificate>>)((Function0)new Function0<List<? extends X509Certificate>>(this, peerCertificates2, hostname){
            final /* synthetic */ CertificatePinner this$0;
            final /* synthetic */ List<Certificate> $peerCertificates;
            final /* synthetic */ String $hostname;
            {
                this.this$0 = $receiver;
                this.$peerCertificates = $peerCertificates;
                this.$hostname = $hostname;
                super(0);
            }

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<X509Certificate> invoke() {
                void $this$mapTo$iv$iv;
                List<Certificate> list = this.this$0.getCertificateChainCleaner$okhttp();
                if (list == null || (list = list.clean(this.$peerCertificates, this.$hostname)) == null) {
                    list = this.$peerCertificates;
                }
                Iterable $this$map$iv = (Iterable)list;
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
    }

    public final void check$okhttp(@NotNull String hostname, @NotNull Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        Intrinsics.checkNotNullParameter(cleanedPeerCertificatesFn, (String)"cleanedPeerCertificatesFn");
        List<Pin> pins = this.findMatchingPins(hostname);
        if (pins.isEmpty()) {
            return;
        }
        List peerCertificates2 = (List)cleanedPeerCertificatesFn.invoke();
        for (X509Certificate peerCertificate : peerCertificates2) {
            ByteString sha1 = null;
            ByteString sha256 = null;
            for (Pin pin : pins) {
                String string = pin.getHashAlgorithm();
                if (Intrinsics.areEqual((Object)string, (Object)"sha256")) {
                    if (sha256 == null) {
                        sha256 = Companion.sha256Hash(peerCertificate);
                    }
                    if (!Intrinsics.areEqual((Object)pin.getHash(), (Object)sha256)) continue;
                    return;
                }
                if (Intrinsics.areEqual((Object)string, (Object)"sha1")) {
                    if (sha1 == null) {
                        sha1 = Companion.sha1Hash(peerCertificate);
                    }
                    if (!Intrinsics.areEqual((Object)pin.getHash(), (Object)sha1)) continue;
                    return;
                }
                throw new AssertionError((Object)("unsupported hashAlgorithm: " + pin.getHashAlgorithm()));
            }
        }
        StringBuilder $this$check_u24lambda_u240 = stringBuilder = new StringBuilder();
        boolean bl = false;
        $this$check_u24lambda_u240.append("Certificate pinning failure!");
        $this$check_u24lambda_u240.append("\n  Peer certificate chain:");
        for (X509Certificate element : peerCertificates2) {
            $this$check_u24lambda_u240.append("\n    ");
            $this$check_u24lambda_u240.append(Companion.pin((Certificate)element));
            $this$check_u24lambda_u240.append(": ");
            $this$check_u24lambda_u240.append(element.getSubjectDN().getName());
        }
        $this$check_u24lambda_u240.append("\n  Pinned certificates for ");
        $this$check_u24lambda_u240.append(hostname);
        $this$check_u24lambda_u240.append(":");
        for (Pin pin : pins) {
            $this$check_u24lambda_u240.append("\n    ");
            $this$check_u24lambda_u240.append((Object)pin);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        String message = string;
        throw new SSLPeerUnverifiedException(message);
    }

    @Deprecated(message="replaced with {@link #check(String, List)}.", replaceWith=@ReplaceWith(expression="check(hostname, peerCertificates.toList())", imports={}))
    public final void check(@NotNull String hostname, Certificate ... peerCertificates2) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        Intrinsics.checkNotNullParameter((Object)peerCertificates2, (String)"peerCertificates");
        this.check(hostname, (List<? extends Certificate>)ArraysKt.toList((Object[])peerCertificates2));
    }

    @NotNull
    public final List<Pin> findMatchingPins(@NotNull String hostname) {
        Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
        Iterable $this$filterList$iv = (Iterable)this.pins;
        boolean $i$f$filterList = false;
        List result$iv = CollectionsKt.emptyList();
        for (Object i$iv : $this$filterList$iv) {
            Pin $this$findMatchingPins_u24lambda_u241 = (Pin)i$iv;
            boolean bl = false;
            if (!$this$findMatchingPins_u24lambda_u241.matchesHostname(hostname)) continue;
            if (result$iv.isEmpty()) {
                result$iv = (List)new ArrayList();
            }
            List list = result$iv;
            Intrinsics.checkNotNull((Object)list, (String)"null cannot be cast to non-null type kotlin.collections.MutableList<T of okhttp3.internal.Util.filterList>");
            TypeIntrinsics.asMutableList((Object)list).add(i$iv);
        }
        return result$iv;
    }

    @NotNull
    public final CertificatePinner withCertificateChainCleaner$okhttp(@NotNull CertificateChainCleaner certificateChainCleaner) {
        Intrinsics.checkNotNullParameter((Object)certificateChainCleaner, (String)"certificateChainCleaner");
        return Intrinsics.areEqual((Object)this.certificateChainCleaner, (Object)certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof CertificatePinner && Intrinsics.areEqual(((CertificatePinner)other).pins, this.pins) && Intrinsics.areEqual((Object)((CertificatePinner)other).certificateChainCleaner, (Object)this.certificateChainCleaner);
    }

    public int hashCode() {
        int result = 37;
        result = 41 * result + this.pins.hashCode();
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        result = 41 * result + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
        return result;
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha1Hash(@NotNull X509Certificate $this$sha1Hash) {
        return Companion.sha1Hash($this$sha1Hash);
    }

    @JvmStatic
    @NotNull
    public static final ByteString sha256Hash(@NotNull X509Certificate $this$sha256Hash) {
        return Companion.sha256Hash($this$sha256Hash);
    }

    @JvmStatic
    @NotNull
    public static final String pin(@NotNull Certificate certificate) {
        return Companion.pin(certificate);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" .\n\n \n\b\n\n \n\n\b\n\n\b\n!\n\n\b 20B¢\bJ)\b0 202\n\b00\"0¢\b\b\tJ\r0\n¢\b\fR\b00\r8¢\f\n\b\b¨"}, d2={"Lokhttp3/CertificatePinner$Builder;", "", "<init>", "()V", "", "pattern", "", "pins", "add", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "Lokhttp3/CertificatePinner;", "build", "()Lokhttp3/CertificatePinner;", "", "Lokhttp3/CertificatePinner$Pin;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "okhttp"})
    public static final class Builder {
        @NotNull
        private final List<Pin> pins = (List)new ArrayList();

        @NotNull
        public final List<Pin> getPins() {
            return this.pins;
        }

        @NotNull
        public final Builder add(@NotNull String pattern, String ... pins) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)pattern, (String)"pattern");
            Intrinsics.checkNotNullParameter((Object)pins, (String)"pins");
            Builder $this$add_u24lambda_u240 = builder = this;
            boolean bl = false;
            for (String pin : pins) {
                $this$add_u24lambda_u240.pins.add((Object)new Pin(pattern, pin));
            }
            return builder;
        }

        @NotNull
        public final CertificatePinner build() {
            return new CertificatePinner(CollectionsKt.toSet((Iterable)((Iterable)this.pins)), null, 2, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" .\n\n \n\b\n\n \n\n\b\n\n\n\b\n\n\b\b 20B\t\b¢\bJ020H¢\b\bJ0\n*0\tH¢\b\fJ\r0\n*0\tH¢\b\r\fR08X¢\n\b¨"}, d2={"Lokhttp3/CertificatePinner$Companion;", "", "<init>", "()V", "Ljava/security/cert/Certificate;", "certificate", "", "pin", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Ljava/security/cert/X509Certificate;", "Lokio/ByteString;", "sha1Hash", "(Ljava/security/cert/X509Certificate;)Lokio/ByteString;", "sha256Hash", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nCertificatePinner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertificatePinner.kt\nokhttp3/CertificatePinner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,370:1\n1#2:371\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final ByteString sha1Hash(@NotNull X509Certificate $this$sha1Hash) {
            Intrinsics.checkNotNullParameter((Object)$this$sha1Hash, (String)"<this>");
            byte[] byArray = $this$sha1Hash.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"publicKey.encoded");
            return ByteString.Companion.of$default(ByteString.Companion, byArray, 0, 0, 3, null).sha1();
        }

        @JvmStatic
        @NotNull
        public final ByteString sha256Hash(@NotNull X509Certificate $this$sha256Hash) {
            Intrinsics.checkNotNullParameter((Object)$this$sha256Hash, (String)"<this>");
            byte[] byArray = $this$sha256Hash.getPublicKey().getEncoded();
            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"publicKey.encoded");
            return ByteString.Companion.of$default(ByteString.Companion, byArray, 0, 0, 3, null).sha256();
        }

        @JvmStatic
        @NotNull
        public final String pin(@NotNull Certificate certificate) {
            Intrinsics.checkNotNullParameter((Object)certificate, (String)"certificate");
            if (!(certificate instanceof X509Certificate)) {
                boolean bl = false;
                String string = "Certificate pinning requires X509 certificates";
                throw new IllegalArgumentException(string.toString());
            }
            return "sha256/" + this.sha256Hash((X509Certificate)certificate).base64();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 0\n\n \n\n\b\n\n\b\n\b\n\b\n\n\b\b\n\n\b\t 20B00¢\bJ\t0\b2\b0H¢\b\t\nJ\f0H¢\b\f\rJ0\b20¢\bJ0\b20¢\bJ0H¢\bR08¢\f\n\b\bR08¢\f\n\b\bR08¢\f\n\b\b¨ "}, d2={"Lokhttp3/CertificatePinner$Pin;", "", "", "pattern", "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/security/cert/X509Certificate;", "certificate", "matchesCertificate", "(Ljava/security/cert/X509Certificate;)Z", "hostname", "matchesHostname", "(Ljava/lang/String;)Z", "toString", "()Ljava/lang/String;", "Lokio/ByteString;", "hash", "Lokio/ByteString;", "getHash", "()Lokio/ByteString;", "hashAlgorithm", "Ljava/lang/String;", "getHashAlgorithm", "getPattern", "okhttp"})
    public static final class Pin {
        @NotNull
        private final String pattern;
        @NotNull
        private final String hashAlgorithm;
        @NotNull
        private final ByteString hash;

        public Pin(@NotNull String pattern, @NotNull String pin) {
            Intrinsics.checkNotNullParameter((Object)pattern, (String)"pattern");
            Intrinsics.checkNotNullParameter((Object)pin, (String)"pin");
            if (!(StringsKt.startsWith$default((String)pattern, (String)"*.", (boolean)false, (int)2, null) && StringsKt.indexOf$default((CharSequence)pattern, (String)"*", (int)1, (boolean)false, (int)4, null) == -1 || StringsKt.startsWith$default((String)pattern, (String)"**.", (boolean)false, (int)2, null) && StringsKt.indexOf$default((CharSequence)pattern, (String)"*", (int)2, (boolean)false, (int)4, null) == -1 || StringsKt.indexOf$default((CharSequence)pattern, (String)"*", (int)0, (boolean)false, (int)6, null) == -1)) {
                boolean bl = false;
                String string = "Unexpected pattern: " + pattern;
                throw new IllegalArgumentException(string.toString());
            }
            String string = HostnamesKt.toCanonicalHost(pattern);
            if (string == null) {
                throw new IllegalArgumentException("Invalid pattern: " + pattern);
            }
            this.pattern = string;
            if (StringsKt.startsWith$default((String)pin, (String)"sha1/", (boolean)false, (int)2, null)) {
                this.hashAlgorithm = "sha1";
                String string2 = pin.substring(5);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String).substring(startIndex)");
                ByteString byteString = ByteString.Companion.decodeBase64(string2);
                if (byteString == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + pin);
                }
                this.hash = byteString;
            } else if (StringsKt.startsWith$default((String)pin, (String)"sha256/", (boolean)false, (int)2, null)) {
                this.hashAlgorithm = "sha256";
                String string3 = pin.substring(7);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).substring(startIndex)");
                ByteString byteString = ByteString.Companion.decodeBase64(string3);
                if (byteString == null) {
                    throw new IllegalArgumentException("Invalid pin hash: " + pin);
                }
                this.hash = byteString;
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + pin);
            }
        }

        @NotNull
        public final String getPattern() {
            return this.pattern;
        }

        @NotNull
        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        @NotNull
        public final ByteString getHash() {
            return this.hash;
        }

        public final boolean matchesHostname(@NotNull String hostname) {
            boolean bl;
            Intrinsics.checkNotNullParameter((Object)hostname, (String)"hostname");
            if (StringsKt.startsWith$default((String)this.pattern, (String)"**.", (boolean)false, (int)2, null)) {
                int suffixLength = this.pattern.length() - 3;
                int prefixLength = hostname.length() - suffixLength;
                bl = StringsKt.regionMatches$default((String)hostname, (int)(hostname.length() - suffixLength), (String)this.pattern, (int)3, (int)suffixLength, (boolean)false, (int)16, null) && (prefixLength == 0 || hostname.charAt(prefixLength - 1) == '.');
            } else if (StringsKt.startsWith$default((String)this.pattern, (String)"*.", (boolean)false, (int)2, null)) {
                int suffixLength = this.pattern.length() - 1;
                int prefixLength = hostname.length() - suffixLength;
                bl = StringsKt.regionMatches$default((String)hostname, (int)(hostname.length() - suffixLength), (String)this.pattern, (int)1, (int)suffixLength, (boolean)false, (int)16, null) && StringsKt.lastIndexOf$default((CharSequence)hostname, (char)'.', (int)(prefixLength - 1), (boolean)false, (int)4, null) == -1;
            } else {
                bl = Intrinsics.areEqual((Object)hostname, (Object)this.pattern);
            }
            return bl;
        }

        public final boolean matchesCertificate(@NotNull X509Certificate certificate) {
            Intrinsics.checkNotNullParameter((Object)certificate, (String)"certificate");
            String string = this.hashAlgorithm;
            return Intrinsics.areEqual((Object)string, (Object)"sha256") ? Intrinsics.areEqual((Object)this.hash, (Object)Companion.sha256Hash(certificate)) : (Intrinsics.areEqual((Object)string, (Object)"sha1") ? Intrinsics.areEqual((Object)this.hash, (Object)Companion.sha1Hash(certificate)) : false);
        }

        @NotNull
        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.base64();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pin)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.pattern, (Object)((Pin)other).pattern)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.hashAlgorithm, (Object)((Pin)other).hashAlgorithm)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.hash, (Object)((Pin)other).hash);
        }

        public int hashCode() {
            int result = this.pattern.hashCode();
            result = 31 * result + this.hashAlgorithm.hashCode();
            result = 31 * result + this.hash.hashCode();
            return result;
        }
    }
}


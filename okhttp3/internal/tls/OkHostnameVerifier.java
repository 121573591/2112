/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateParsingException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.Locale
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLException
 *  javax.net.ssl.SSLSession
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 6\n\n\n\b\n\n \n \n\n\b\n\b\n\b\n\n\b\n\n\b\bÆ 20B\t\b¢\bJ\b\b0020¢\b\b\tJ%\f\b002020\nH¢\b\f\rJ02020¢\bJ02020H¢\bJ02020H¢\bJ#02\b02\b0H¢\bJ02020H¢\bJ0*0H¢\bJ0*0H¢\bR0\n8XT¢\n\b R!0\n8XT¢\n\b! ¨\""}, d2={"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "<init>", "()V", "Ljava/security/cert/X509Certificate;", "certificate", "", "", "allSubjectAltNames", "(Ljava/security/cert/X509Certificate;)Ljava/util/List;", "", "type", "getSubjectAltNames", "(Ljava/security/cert/X509Certificate;I)Ljava/util/List;", "host", "", "verify", "(Ljava/lang/String;Ljava/security/cert/X509Certificate;)Z", "Ljavax/net/ssl/SSLSession;", "session", "(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "hostname", "verifyHostname", "pattern", "(Ljava/lang/String;Ljava/lang/String;)Z", "ipAddress", "verifyIpAddress", "asciiToLowercase", "(Ljava/lang/String;)Ljava/lang/String;", "isAscii", "(Ljava/lang/String;)Z", "ALT_DNS_NAME", "I", "ALT_IPA_NAME", "okhttp"})
@SourceDebugExtension(value={"SMAP\nOkHostnameVerifier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,208:1\n1747#2,3:209\n1747#2,3:212\n*S KotlinDebug\n*F\n+ 1 OkHostnameVerifier.kt\nokhttp3/internal/tls/OkHostnameVerifier\n*L\n63#1:209,3\n71#1:212,3\n*E\n"})
public final class OkHostnameVerifier
implements HostnameVerifier {
    @NotNull
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;

    private OkHostnameVerifier() {
    }

    public boolean verify(@NotNull String host, @NotNull SSLSession session) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)session, (String)"session");
        if (!this.isAscii(host)) {
            bl = false;
        } else {
            boolean bl2;
            try {
                Certificate certificate = session.getPeerCertificates()[0];
                Intrinsics.checkNotNull((Object)certificate, (String)"null cannot be cast to non-null type java.security.cert.X509Certificate");
                bl2 = this.verify(host, (X509Certificate)certificate);
            }
            catch (SSLException _) {
                bl2 = false;
            }
            bl = bl2;
        }
        return bl;
    }

    public final boolean verify(@NotNull String host, @NotNull X509Certificate certificate) {
        Intrinsics.checkNotNullParameter((Object)host, (String)"host");
        Intrinsics.checkNotNullParameter((Object)certificate, (String)"certificate");
        return Util.canParseAsIpAddress(host) ? this.verifyIpAddress(host, certificate) : this.verifyHostname(host, certificate);
    }

    private final boolean verifyIpAddress(String ipAddress, X509Certificate certificate) {
        boolean bl;
        block3: {
            String canonicalIpAddress = HostnamesKt.toCanonicalHost(ipAddress);
            Iterable $this$any$iv = (Iterable)this.getSubjectAltNames(certificate, 7);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    String it = (String)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)canonicalIpAddress, (Object)HostnamesKt.toCanonicalHost(it))) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    private final boolean verifyHostname(String hostname, X509Certificate certificate) {
        boolean bl;
        block3: {
            String hostname2 = this.asciiToLowercase(hostname);
            Iterable $this$any$iv = (Iterable)this.getSubjectAltNames(certificate, 2);
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    String it = (String)element$iv;
                    boolean bl2 = false;
                    if (!INSTANCE.verifyHostname(hostname2, it)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    private final String asciiToLowercase(String $this$asciiToLowercase) {
        String string;
        if (this.isAscii($this$asciiToLowercase)) {
            String string2 = $this$asciiToLowercase;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
            String string3 = string2.toLowerCase(locale);
            string = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).toLowerCase(locale)");
        } else {
            string = $this$asciiToLowercase;
        }
        return string;
    }

    private final boolean isAscii(String $this$isAscii) {
        return $this$isAscii.length() == (int)Utf8.size$default($this$isAscii, 0, 0, 3, null);
    }

    private final boolean verifyHostname(String hostname, String pattern) {
        String hostname2 = hostname;
        String pattern2 = pattern;
        CharSequence charSequence = hostname2;
        if (charSequence == null || charSequence.length() == 0 || StringsKt.startsWith$default((String)hostname2, (String)".", (boolean)false, (int)2, null) || StringsKt.endsWith$default((String)hostname2, (String)"..", (boolean)false, (int)2, null)) {
            return false;
        }
        charSequence = pattern2;
        if (charSequence == null || charSequence.length() == 0 || StringsKt.startsWith$default((String)pattern2, (String)".", (boolean)false, (int)2, null) || StringsKt.endsWith$default((String)pattern2, (String)"..", (boolean)false, (int)2, null)) {
            return false;
        }
        if (!StringsKt.endsWith$default((String)hostname2, (String)".", (boolean)false, (int)2, null)) {
            hostname2 = hostname2 + '.';
        }
        if (!StringsKt.endsWith$default((String)pattern2, (String)".", (boolean)false, (int)2, null)) {
            pattern2 = pattern2 + '.';
        }
        if (!StringsKt.contains$default((CharSequence)(pattern2 = this.asciiToLowercase(pattern2)), (CharSequence)"*", (boolean)false, (int)2, null)) {
            return Intrinsics.areEqual((Object)hostname2, (Object)pattern2);
        }
        if (!StringsKt.startsWith$default((String)pattern2, (String)"*.", (boolean)false, (int)2, null) || StringsKt.indexOf$default((CharSequence)pattern2, (char)'*', (int)1, (boolean)false, (int)4, null) != -1) {
            return false;
        }
        if (hostname2.length() < pattern2.length()) {
            return false;
        }
        if (Intrinsics.areEqual((Object)"*.", (Object)pattern2)) {
            return false;
        }
        String string = pattern2.substring(1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"this as java.lang.String).substring(startIndex)");
        String suffix = string;
        if (!StringsKt.endsWith$default((String)hostname2, (String)suffix, (boolean)false, (int)2, null)) {
            return false;
        }
        int suffixStartIndexInHostname = hostname2.length() - suffix.length();
        return suffixStartIndexInHostname <= 0 || StringsKt.lastIndexOf$default((CharSequence)hostname2, (char)'.', (int)(suffixStartIndexInHostname - 1), (boolean)false, (int)4, null) == -1;
    }

    @NotNull
    public final List<String> allSubjectAltNames(@NotNull X509Certificate certificate) {
        Intrinsics.checkNotNullParameter((Object)certificate, (String)"certificate");
        List<String> altIpaNames = this.getSubjectAltNames(certificate, 7);
        List<String> altDnsNames = this.getSubjectAltNames(certificate, 2);
        return CollectionsKt.plus((Collection)((Collection)altIpaNames), (Iterable)((Iterable)altDnsNames));
    }

    private final List<String> getSubjectAltNames(X509Certificate certificate, int type) {
        try {
            Collection collection = certificate.getSubjectAlternativeNames();
            if (collection == null) {
                return CollectionsKt.emptyList();
            }
            Collection subjectAltNames = collection;
            List result = (List)new ArrayList();
            for (List subjectAltName : subjectAltNames) {
                Object altName;
                if (subjectAltName == null || subjectAltName.size() < 2 || !Intrinsics.areEqual((Object)subjectAltName.get(0), (Object)type) || subjectAltName.get(1) == null) continue;
                result.add((Object)((String)altName));
            }
            return result;
        }
        catch (CertificateParsingException _) {
            return CollectionsKt.emptyList();
        }
    }
}


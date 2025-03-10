/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Locale
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 0\n\n \n\n\b\n\t\n\b\n\n\b\r\n\b\n\b\n\n\b  -20:.-BQ\b0000\b0\n0\t0\t\f0\t\r0\t¢\bJ0H¢\bJ0\t2\b0H¢\bJ0H¢\bJ0H¢\bJ\r0\tH¢\bJ0\tH¢\bJ0\t20¢\b J0H¢\b!J\b0H¢\b\"J\f0\tH¢\b#J\n0\tH¢\b$J%0H¢\b%J%02&0\tH ¢\b'(J0H¢\b)R08¢\f\n\b*\bR08¢\f\n\b+\bR\r0\t8¢\f\n\b\r,\b\rR0\t8¢\f\n\b,\bR08¢\f\n\b*\bR\b08¢\f\n\b\b*\b\bR\f0\t8¢\f\n\b\f,\b\fR\n0\t8¢\f\n\b\n,\b\nR08¢\f\n\b*\b¨/"}, d2={"Lokhttp3/Cookie;", "", "", "name", "value", "", "expiresAt", "domain", "path", "", "secure", "httpOnly", "persistent", "hostOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "-deprecated_domain", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "-deprecated_expiresAt", "()J", "", "hashCode", "()I", "-deprecated_hostOnly", "()Z", "-deprecated_httpOnly", "Lokhttp3/HttpUrl;", "url", "matches", "(Lokhttp3/HttpUrl;)Z", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "(Z)Ljava/lang/String;", "-deprecated_value", "Ljava/lang/String;", "J", "Z", "Companion", "Builder", "okhttp"})
public final class Cookie {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    @NotNull
    private final String value;
    private final long expiresAt;
    @NotNull
    private final String domain;
    @NotNull
    private final String path;
    private final boolean secure;
    private final boolean httpOnly;
    private final boolean persistent;
    private final boolean hostOnly;
    private static final Pattern YEAR_PATTERN = Pattern.compile((String)"(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile((String)"(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile((String)"(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile((String)"(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    private Cookie(String name, String value, long expiresAt, String domain, String path, boolean secure, boolean httpOnly, boolean persistent, boolean hostOnly) {
        this.name = name;
        this.value = value;
        this.expiresAt = expiresAt;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.persistent = persistent;
        this.hostOnly = hostOnly;
    }

    @JvmName(name="name")
    @NotNull
    public final String name() {
        return this.name;
    }

    @JvmName(name="value")
    @NotNull
    public final String value() {
        return this.value;
    }

    @JvmName(name="expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @JvmName(name="domain")
    @NotNull
    public final String domain() {
        return this.domain;
    }

    @JvmName(name="path")
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName(name="secure")
    public final boolean secure() {
        return this.secure;
    }

    @JvmName(name="httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    @JvmName(name="persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name="hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean matches(@NotNull HttpUrl url) {
        boolean domainMatch;
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        boolean bl = domainMatch = this.hostOnly ? Intrinsics.areEqual((Object)url.host(), (Object)this.domain) : Cookie.Companion.domainMatch(url.host(), this.domain);
        if (!domainMatch) {
            return false;
        }
        if (!Cookie.Companion.pathMatch(url, this.path)) {
            return false;
        }
        return !this.secure || url.isHttps();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Cookie && Intrinsics.areEqual((Object)((Cookie)other).name, (Object)this.name) && Intrinsics.areEqual((Object)((Cookie)other).value, (Object)this.value) && ((Cookie)other).expiresAt == this.expiresAt && Intrinsics.areEqual((Object)((Cookie)other).domain, (Object)this.domain) && Intrinsics.areEqual((Object)((Cookie)other).path, (Object)this.path) && ((Cookie)other).secure == this.secure && ((Cookie)other).httpOnly == this.httpOnly && ((Cookie)other).persistent == this.persistent && ((Cookie)other).hostOnly == this.hostOnly;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.name.hashCode();
        result = 31 * result + this.value.hashCode();
        result = 31 * result + Long.hashCode((long)this.expiresAt);
        result = 31 * result + this.domain.hashCode();
        result = 31 * result + this.path.hashCode();
        result = 31 * result + Boolean.hashCode((boolean)this.secure);
        result = 31 * result + Boolean.hashCode((boolean)this.httpOnly);
        result = 31 * result + Boolean.hashCode((boolean)this.persistent);
        result = 31 * result + Boolean.hashCode((boolean)this.hostOnly);
        return result;
    }

    @NotNull
    public String toString() {
        return this.toString$okhttp(false);
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="name", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_name")
    @NotNull
    public final String -deprecated_name() {
        return this.name;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="value", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_value")
    @NotNull
    public final String -deprecated_value() {
        return this.value;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="persistent", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_persistent")
    public final boolean -deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="expiresAt", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_expiresAt")
    public final long -deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="hostOnly", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_hostOnly")
    public final boolean -deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="domain", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_domain")
    @NotNull
    public final String -deprecated_domain() {
        return this.domain;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="path", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_path")
    @NotNull
    public final String -deprecated_path() {
        return this.path;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="httpOnly", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_httpOnly")
    public final boolean -deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="secure", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_secure")
    public final boolean -deprecated_secure() {
        return this.secure;
    }

    @NotNull
    public final String toString$okhttp(boolean forObsoleteRfc2965) {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        boolean bl = false;
        $this$toString_u24lambda_u240.append(this.name);
        $this$toString_u24lambda_u240.append('=');
        $this$toString_u24lambda_u240.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                $this$toString_u24lambda_u240.append("; max-age=0");
            } else {
                $this$toString_u24lambda_u240.append("; expires=").append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            $this$toString_u24lambda_u240.append("; domain=");
            if (forObsoleteRfc2965) {
                $this$toString_u24lambda_u240.append(".");
            }
            $this$toString_u24lambda_u240.append(this.domain);
        }
        $this$toString_u24lambda_u240.append("; path=").append(this.path);
        if (this.secure) {
            $this$toString_u24lambda_u240.append("; secure");
        }
        if (this.httpOnly) {
            $this$toString_u24lambda_u240.append("; httponly");
        }
        String string = $this$toString_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString()");
        return string;
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
        return Companion.parse(url, setCookie);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
        return Companion.parseAll(url, headers);
    }

    public /* synthetic */ Cookie(String name, String value, long expiresAt, String domain, String path, boolean secure, boolean httpOnly, boolean persistent, boolean hostOnly, DefaultConstructorMarker $constructor_marker) {
        this(name, value, expiresAt, domain, path, secure, httpOnly, persistent, hostOnly);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ,\n\n \n\b\n\n\b\n\n\b\n\n\b\n\t\n\b 20B¢\bJ\r0¢\bJ\b0 2\b0¢\b\b\tJ\b0 2\b020\nH¢\b\b\fJ0 20\r¢\bJ0 2\b0¢\b\tJ\r0 ¢\bJ0 20¢\b\tJ0 20¢\b\tJ\r0 ¢\bJ0 20¢\b\tR\b08@X¢\n\b\bR0\r8@X¢\n\bR0\n8@X¢\n\bR0\n8@X¢\n\bR08@X¢\n\bR08@X¢\n\bR0\n8@X¢\n\bR0\n8@X¢\n\bR08@X¢\n\b¨"}, d2={"Lokhttp3/Cookie$Builder;", "", "<init>", "()V", "Lokhttp3/Cookie;", "build", "()Lokhttp3/Cookie;", "", "domain", "(Ljava/lang/String;)Lokhttp3/Cookie$Builder;", "", "hostOnly", "(Ljava/lang/String;Z)Lokhttp3/Cookie$Builder;", "", "expiresAt", "(J)Lokhttp3/Cookie$Builder;", "hostOnlyDomain", "httpOnly", "()Lokhttp3/Cookie$Builder;", "name", "path", "secure", "value", "Ljava/lang/String;", "J", "Z", "persistent", "okhttp"})
    @SourceDebugExtension(value={"SMAP\nCookie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cookie.kt\nokhttp3/Cookie$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,614:1\n1#2:615\n*E\n"})
    public static final class Builder {
        @Nullable
        private String name;
        @Nullable
        private String value;
        private long expiresAt = 253402300799999L;
        @Nullable
        private String domain;
        @NotNull
        private String path = "/";
        private boolean secure;
        private boolean httpOnly;
        private boolean persistent;
        private boolean hostOnly;

        @NotNull
        public final Builder name(@NotNull String name) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Builder $this$name_u24lambda_u241 = builder = this;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)StringsKt.trim((CharSequence)name).toString(), (Object)name)) {
                boolean bl2 = false;
                String string = "name is not trimmed";
                throw new IllegalArgumentException(string.toString());
            }
            $this$name_u24lambda_u241.name = name;
            return builder;
        }

        @NotNull
        public final Builder value(@NotNull String value) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)value, (String)"value");
            Builder $this$value_u24lambda_u243 = builder = this;
            boolean bl = false;
            if (!Intrinsics.areEqual((Object)StringsKt.trim((CharSequence)value).toString(), (Object)value)) {
                boolean bl2 = false;
                String string = "value is not trimmed";
                throw new IllegalArgumentException(string.toString());
            }
            $this$value_u24lambda_u243.value = value;
            return builder;
        }

        @NotNull
        public final Builder expiresAt(long expiresAt) {
            Builder builder;
            Builder $this$expiresAt_u24lambda_u244 = builder = this;
            boolean bl = false;
            long expiresAt2 = expiresAt;
            if (expiresAt2 <= 0L) {
                expiresAt2 = Long.MIN_VALUE;
            }
            if (expiresAt2 > 253402300799999L) {
                expiresAt2 = 253402300799999L;
            }
            $this$expiresAt_u24lambda_u244.expiresAt = expiresAt2;
            $this$expiresAt_u24lambda_u244.persistent = true;
            return builder;
        }

        @NotNull
        public final Builder domain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter((Object)domain, (String)"domain");
            return this.domain(domain, false);
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String domain) {
            Intrinsics.checkNotNullParameter((Object)domain, (String)"domain");
            return this.domain(domain, true);
        }

        private final Builder domain(String domain, boolean hostOnly) {
            String canonicalDomain;
            Builder builder;
            Builder $this$domain_u24lambda_u245 = builder = this;
            boolean bl = false;
            String string = HostnamesKt.toCanonicalHost(domain);
            if (string == null) {
                throw new IllegalArgumentException("unexpected domain: " + domain);
            }
            $this$domain_u24lambda_u245.domain = canonicalDomain = string;
            $this$domain_u24lambda_u245.hostOnly = hostOnly;
            return builder;
        }

        @NotNull
        public final Builder path(@NotNull String path) {
            Builder builder;
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            Builder $this$path_u24lambda_u247 = builder = this;
            boolean bl = false;
            if (!StringsKt.startsWith$default((String)path, (String)"/", (boolean)false, (int)2, null)) {
                boolean bl2 = false;
                String string = "path must start with '/'";
                throw new IllegalArgumentException(string.toString());
            }
            $this$path_u24lambda_u247.path = path;
            return builder;
        }

        @NotNull
        public final Builder secure() {
            Builder builder;
            Builder $this$secure_u24lambda_u248 = builder = this;
            boolean bl = false;
            $this$secure_u24lambda_u248.secure = true;
            return builder;
        }

        @NotNull
        public final Builder httpOnly() {
            Builder builder;
            Builder $this$httpOnly_u24lambda_u249 = builder = this;
            boolean bl = false;
            $this$httpOnly_u24lambda_u249.httpOnly = true;
            return builder;
        }

        @NotNull
        public final Cookie build() {
            String string = this.name;
            if (string == null) {
                throw new NullPointerException("builder.name == null");
            }
            String string2 = this.value;
            if (string2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            String string3 = this.domain;
            if (string3 == null) {
                throw new NullPointerException("builder.domain == null");
            }
            return new Cookie(string, string2, this.expiresAt, string3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" N\n\n \n\b\n\n \n\b\n\b\n\n\b\n\t\n \n\n\b\n\n\b\n\n \n \n\b\f\n\n\b\b 20B\t\b¢\bJ/020202\b02\n0\tH¢\b\fJ0\t2\r020H¢\bJ)0202020H ¢\bJ!02020H¢\bJ%\b002020H¢\bJ!02 0H¢\b!\"J'#02 0202\b0H¢\b#$J%02 0H¢\b%&J(0\t202'0H¢\b()R,\n +*0*0*8X¢\n\b,-R.\n +*0*0*8X¢\n\b.-R/\n +*0*0*8X¢\n\b/-R0\n +*0*0*8X¢\n\b0-¨1"}, d2={"Lokhttp3/Cookie$Companion;", "", "<init>", "()V", "", "input", "", "pos", "limit", "", "invert", "dateCharacterOffset", "(Ljava/lang/String;IIZ)I", "urlHost", "domain", "domainMatch", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "currentTimeMillis", "Lokhttp3/HttpUrl;", "url", "setCookie", "Lokhttp3/Cookie;", "parse$okhttp", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "parse", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "Lokhttp3/Headers;", "headers", "", "parseAll", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;)Ljava/util/List;", "s", "parseDomain", "(Ljava/lang/String;)Ljava/lang/String;", "parseExpires", "(Ljava/lang/String;II)J", "parseMaxAge", "(Ljava/lang/String;)J", "path", "pathMatch", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Z", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        private final boolean domainMatch(String urlHost, String domain) {
            if (Intrinsics.areEqual((Object)urlHost, (Object)domain)) {
                return true;
            }
            return StringsKt.endsWith$default((String)urlHost, (String)domain, (boolean)false, (int)2, null) && urlHost.charAt(urlHost.length() - domain.length() - 1) == '.' && !Util.canParseAsIpAddress(urlHost);
        }

        private final boolean pathMatch(HttpUrl url, String path) {
            String urlPath = url.encodedPath();
            if (Intrinsics.areEqual((Object)urlPath, (Object)path)) {
                return true;
            }
            if (StringsKt.startsWith$default((String)urlPath, (String)path, (boolean)false, (int)2, null)) {
                if (StringsKt.endsWith$default((String)path, (String)"/", (boolean)false, (int)2, null)) {
                    return true;
                }
                if (urlPath.charAt(path.length()) == '/') {
                    return true;
                }
            }
            return false;
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
            Intrinsics.checkNotNullParameter((Object)url, (String)"url");
            Intrinsics.checkNotNullParameter((Object)setCookie, (String)"setCookie");
            return this.parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        @Nullable
        public final Cookie parse$okhttp(long currentTimeMillis, @NotNull HttpUrl url, @NotNull String setCookie) {
            long deltaMilliseconds;
            Intrinsics.checkNotNullParameter((Object)url, (String)"url");
            Intrinsics.checkNotNullParameter((Object)setCookie, (String)"setCookie");
            int cookiePairEnd = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, null);
            int pairEqualsSign = Util.delimiterOffset$default(setCookie, '=', 0, cookiePairEnd, 2, null);
            if (pairEqualsSign == cookiePairEnd) {
                return null;
            }
            String cookieName = Util.trimSubstring$default(setCookie, 0, pairEqualsSign, 1, null);
            if (((CharSequence)cookieName).length() == 0 || Util.indexOfControlOrNonAscii(cookieName) != -1) {
                return null;
            }
            String cookieValue = Util.trimSubstring(setCookie, pairEqualsSign + 1, cookiePairEnd);
            if (Util.indexOfControlOrNonAscii(cookieValue) != -1) {
                return null;
            }
            long expiresAt = 253402300799999L;
            long deltaSeconds = -1L;
            String domain = null;
            String path = null;
            boolean secureOnly = false;
            boolean httpOnly = false;
            boolean hostOnly = true;
            boolean persistent = false;
            int pos = cookiePairEnd + 1;
            int limit = setCookie.length();
            while (pos < limit) {
                int attributePairEnd = Util.delimiterOffset(setCookie, ';', pos, limit);
                int attributeEqualsSign = Util.delimiterOffset(setCookie, '=', pos, attributePairEnd);
                String attributeName = Util.trimSubstring(setCookie, pos, attributeEqualsSign);
                String attributeValue = attributeEqualsSign < attributePairEnd ? Util.trimSubstring(setCookie, attributeEqualsSign + 1, attributePairEnd) : "";
                if (StringsKt.equals((String)attributeName, (String)"expires", (boolean)true)) {
                    try {
                        expiresAt = this.parseExpires(attributeValue, 0, attributeValue.length());
                        persistent = true;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {}
                } else if (StringsKt.equals((String)attributeName, (String)"max-age", (boolean)true)) {
                    try {
                        deltaSeconds = this.parseMaxAge(attributeValue);
                        persistent = true;
                    }
                    catch (NumberFormatException numberFormatException) {}
                } else if (StringsKt.equals((String)attributeName, (String)"domain", (boolean)true)) {
                    try {
                        domain = this.parseDomain(attributeValue);
                        hostOnly = false;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {}
                } else if (StringsKt.equals((String)attributeName, (String)"path", (boolean)true)) {
                    path = attributeValue;
                } else if (StringsKt.equals((String)attributeName, (String)"secure", (boolean)true)) {
                    secureOnly = true;
                } else if (StringsKt.equals((String)attributeName, (String)"httponly", (boolean)true)) {
                    httpOnly = true;
                }
                pos = attributePairEnd + 1;
            }
            if (deltaSeconds == Long.MIN_VALUE) {
                expiresAt = Long.MIN_VALUE;
            } else if (deltaSeconds != -1L && ((expiresAt = currentTimeMillis + (deltaMilliseconds = deltaSeconds <= 9223372036854775L ? deltaSeconds * (long)1000 : Long.MAX_VALUE)) < currentTimeMillis || expiresAt > 253402300799999L)) {
                expiresAt = 253402300799999L;
            }
            String urlHost = url.host();
            if (domain == null) {
                domain = urlHost;
            } else if (!this.domainMatch(urlHost, domain)) {
                return null;
            }
            if (urlHost.length() != domain.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(domain) == null) {
                return null;
            }
            if (path == null || !StringsKt.startsWith$default(path, (String)"/", (boolean)false, (int)2, null)) {
                String string;
                String encodedPath = url.encodedPath();
                int lastSlash = StringsKt.lastIndexOf$default((CharSequence)encodedPath, (char)'/', (int)0, (boolean)false, (int)6, null);
                if (lastSlash != 0) {
                    String string2 = encodedPath.substring(0, lastSlash);
                    string = string2;
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"this as java.lang.String…ing(startIndex, endIndex)");
                } else {
                    string = "/";
                }
                path = string;
            }
            return new Cookie(cookieName, cookieValue, expiresAt, domain, path, secureOnly, httpOnly, persistent, hostOnly, null);
        }

        private final long parseExpires(String s, int pos, int limit) {
            String monthString;
            int pos2 = pos;
            pos2 = this.dateCharacterOffset(s, pos2, limit, false);
            int hour = 0;
            hour = -1;
            int minute = 0;
            minute = -1;
            int second = 0;
            second = -1;
            int dayOfMonth = 0;
            dayOfMonth = -1;
            int month = 0;
            month = -1;
            int year = 0;
            year = -1;
            Matcher matcher = TIME_PATTERN.matcher((CharSequence)s);
            while (pos2 < limit) {
                int end = this.dateCharacterOffset(s, pos2 + 1, limit, true);
                matcher.region(pos2, end);
                if (hour == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                    String string = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                    hour = Integer.parseInt((String)string);
                    String string2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"matcher.group(2)");
                    minute = Integer.parseInt((String)string2);
                    String string3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"matcher.group(3)");
                    second = Integer.parseInt((String)string3);
                } else if (dayOfMonth == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                    String string = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                    dayOfMonth = Integer.parseInt((String)string);
                } else if (month == -1 && matcher.usePattern(MONTH_PATTERN).matches()) {
                    String string;
                    Intrinsics.checkNotNullExpressionValue((Object)matcher.group(1), (String)"matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
                    Intrinsics.checkNotNullExpressionValue((Object)string.toLowerCase(locale), (String)"this as java.lang.String).toLowerCase(locale)");
                    String string4 = MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"MONTH_PATTERN.pattern()");
                    month = StringsKt.indexOf$default((CharSequence)string4, (String)monthString, (int)0, (boolean)false, (int)6, null) / 4;
                } else if (year == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    String string = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"matcher.group(1)");
                    year = Integer.parseInt((String)string);
                }
                pos2 = this.dateCharacterOffset(s, end + 1, limit, false);
            }
            boolean bl = 70 <= year ? year < 100 : false;
            if (bl) {
                year += 1900;
            }
            boolean bl2 = 0 <= year ? year < 70 : false;
            if (bl2) {
                year += 2000;
            }
            if (!(year >= 1601)) {
                monthString = "Failed requirement.";
                throw new IllegalArgumentException(monthString.toString());
            }
            if (!(month != -1)) {
                monthString = "Failed requirement.";
                throw new IllegalArgumentException(monthString.toString());
            }
            if (!(1 <= dayOfMonth ? dayOfMonth < 32 : false)) {
                monthString = "Failed requirement.";
                throw new IllegalArgumentException(monthString.toString());
            }
            if (!(0 <= hour ? hour < 24 : false)) {
                monthString = "Failed requirement.";
                throw new IllegalArgumentException(monthString.toString());
            }
            if (!(0 <= minute ? minute < 60 : false)) {
                monthString = "Failed requirement.";
                throw new IllegalArgumentException(monthString.toString());
            }
            if (!(0 <= second ? second < 60 : false)) {
                monthString = "Failed requirement.";
                throw new IllegalArgumentException(monthString.toString());
            }
            GregorianCalendar $this$parseExpires_u24lambda_u240 = new GregorianCalendar(Util.UTC);
            boolean bl3 = false;
            $this$parseExpires_u24lambda_u240.setLenient(false);
            $this$parseExpires_u24lambda_u240.set(1, year);
            $this$parseExpires_u24lambda_u240.set(2, month - 1);
            $this$parseExpires_u24lambda_u240.set(5, dayOfMonth);
            $this$parseExpires_u24lambda_u240.set(11, hour);
            $this$parseExpires_u24lambda_u240.set(12, minute);
            $this$parseExpires_u24lambda_u240.set(13, second);
            $this$parseExpires_u24lambda_u240.set(14, 0);
            return $this$parseExpires_u24lambda_u240.getTimeInMillis();
        }

        /*
         * Unable to fully structure code
         */
        private final int dateCharacterOffset(String input, int pos, int limit, boolean invert) {
            for (i = pos; i < limit; ++i) {
                c = input.charAt(i);
                if (c < ' ' && c != '\t' || c >= '') ** GOTO lbl-1000
                if ('0' <= c ? c < ':' : false) ** GOTO lbl-1000
                if ('a' <= c ? c < '{' : false) ** GOTO lbl-1000
                v0 = 'A' <= c ? c < '[' : false;
                if (v0 || c == ':') lbl-1000:
                // 4 sources

                {
                    v1 = true;
                } else {
                    v1 = dateCharacter = false;
                }
                if (dateCharacter != (invert == false)) continue;
                return i;
            }
            return limit;
        }

        private final long parseMaxAge(String s) {
            try {
                long parsed = Long.parseLong((String)s);
                return parsed <= 0L ? Long.MIN_VALUE : parsed;
            }
            catch (NumberFormatException e) {
                CharSequence charSequence = s;
                if (new Regex("-?\\d+").matches(charSequence)) {
                    return StringsKt.startsWith$default((String)s, (String)"-", (boolean)false, (int)2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e;
            }
        }

        private final String parseDomain(String s) {
            if (!(!StringsKt.endsWith$default((String)s, (String)".", (boolean)false, (int)2, null))) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            String string = HostnamesKt.toCanonicalHost(StringsKt.removePrefix((String)s, (CharSequence)"."));
            if (string == null) {
                throw new IllegalArgumentException();
            }
            return string;
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
            List list;
            Intrinsics.checkNotNullParameter((Object)url, (String)"url");
            Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
            List<String> cookieStrings = headers.values("Set-Cookie");
            List cookies = null;
            int n = cookieStrings.size();
            for (int i = 0; i < n; ++i) {
                Cookie cookie;
                if (this.parse(url, (String)cookieStrings.get(i)) == null) continue;
                if (cookies == null) {
                    cookies = (List)new ArrayList();
                }
                cookies.add((Object)cookie);
            }
            if (cookies != null) {
                List list2 = Collections.unmodifiableList(cookies);
                list = list2;
                Intrinsics.checkNotNullExpressionValue((Object)list2, (String)"{\n        Collections.un…ableList(cookies)\n      }");
            } else {
                list = CollectionsKt.emptyList();
            }
            return list;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


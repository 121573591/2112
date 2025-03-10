/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 0\n\n \n\n\b\n$\n\b\n\n\b\n\n\b\n\b\n\b 20B\b00¢\bB%0\b000¢\b\tJ\b000H¢\b\nJ0\fH¢\b\rJ02\b0H¢\bJ0H¢\bJ0H¢\bJ0H¢\bJ0H¢\bJ0 20\f¢\bR%\b0008G¢\f\n\b\b\b\bR0\f8G¢\bR08G¢\bR08¢\f\n\b\b¨"}, d2={"Lokhttp3/Challenge;", "", "", "scheme", "realm", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "authParams", "(Ljava/lang/String;Ljava/util/Map;)V", "-deprecated_authParams", "()Ljava/util/Map;", "Ljava/nio/charset/Charset;", "-deprecated_charset", "()Ljava/nio/charset/Charset;", "charset", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "-deprecated_realm", "()Ljava/lang/String;", "-deprecated_scheme", "toString", "withCharset", "(Ljava/nio/charset/Charset;)Lokhttp3/Challenge;", "Ljava/util/Map;", "Ljava/lang/String;", "okhttp"})
public final class Challenge {
    @NotNull
    private final String scheme;
    @NotNull
    private final Map<String, String> authParams;

    public Challenge(@NotNull String scheme, @NotNull Map<String, String> authParams) {
        Intrinsics.checkNotNullParameter((Object)scheme, (String)"scheme");
        Intrinsics.checkNotNullParameter(authParams, (String)"authParams");
        this.scheme = scheme;
        Map newAuthParams = (Map)new LinkedHashMap();
        for (Map.Entry entry : authParams.entrySet()) {
            String string;
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            if (key != null) {
                String string2;
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
                String string3 = string2.toLowerCase(locale);
                string = string3;
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).toLowerCase(locale)");
            } else {
                string = null;
            }
            String newKey = string;
            newAuthParams.put(newKey, (Object)value);
        }
        Map map = Collections.unmodifiableMap((Map)newAuthParams);
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = map;
    }

    @JvmName(name="scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @JvmName(name="authParams")
    @NotNull
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName(name="realm")
    @Nullable
    public final String realm() {
        return (String)this.authParams.get((Object)"realm");
    }

    @JvmName(name="charset")
    @NotNull
    public final Charset charset() {
        String charset = (String)this.authParams.get((Object)"charset");
        if (charset != null) {
            try {
                Charset charset2 = Charset.forName((String)charset);
                Intrinsics.checkNotNullExpressionValue((Object)charset2, (String)"forName(charset)");
                return charset2;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        Charset charset3 = StandardCharsets.ISO_8859_1;
        Intrinsics.checkNotNullExpressionValue((Object)charset3, (String)"ISO_8859_1");
        return charset3;
    }

    public Challenge(@NotNull String scheme, @NotNull String realm) {
        Intrinsics.checkNotNullParameter((Object)scheme, (String)"scheme");
        Intrinsics.checkNotNullParameter((Object)realm, (String)"realm");
        Map map = Collections.singletonMap((Object)"realm", (Object)realm);
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"singletonMap(\"realm\", realm)");
        this(scheme, (Map<String, String>)map);
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset charset) {
        Map authParams;
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        Map map = authParams = MapsKt.toMutableMap(this.authParams);
        String string = "charset";
        String string2 = charset.name();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"charset.name()");
        String string3 = string2;
        map.put((Object)string, (Object)string3);
        return new Challenge(this.scheme, (Map<String, String>)authParams);
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="scheme", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_scheme")
    @NotNull
    public final String -deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="authParams", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_authParams")
    @NotNull
    public final Map<String, String> -deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="realm", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_realm")
    @Nullable
    public final String -deprecated_realm() {
        return this.realm();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="charset", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_charset")
    @NotNull
    public final Charset -deprecated_charset() {
        return this.charset();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof Challenge && Intrinsics.areEqual((Object)((Challenge)other).scheme, (Object)this.scheme) && Intrinsics.areEqual(((Challenge)other).authParams, this.authParams);
    }

    public int hashCode() {
        int result = 29;
        result = 31 * result + this.scheme.hashCode();
        result = 31 * result + this.authParams.hashCode();
        return result;
    }

    @NotNull
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}


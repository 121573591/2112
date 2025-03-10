/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.List
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \"\n\n \n\n \n \n\n\b\n\n\b\bf  \f20:\fJ\b0020H&¢\bJ%\n0\t202\f\b\b00H&¢\b\n¨\r"}, d2={"Lokhttp3/CookieJar;", "", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "cookies", "", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "Companion", "okhttp"})
public interface CookieJar {
    @NotNull
    public static final Companion Companion = okhttp3.CookieJar$Companion.$$INSTANCE;
    @JvmField
    @NotNull
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public void saveFromResponse(@NotNull HttpUrl var1, @NotNull List<Cookie> var2);

    @NotNull
    public List<Cookie> loadForRequest(@NotNull HttpUrl var1);

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n\b\b 20:B\t\b¢\bR08X¢\n\b¨¨\b"}, d2={"Lokhttp3/CookieJar$Companion;", "", "<init>", "()V", "Lokhttp3/CookieJar;", "NO_COOKIES", "Lokhttp3/CookieJar;", "NoCookies", "okhttp"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" &\n\n\n\b\n\n \n \n\n\b\n\n\b\b 20B¢\bJ\b\b0020H¢\b\b\tJ%\f0202\f\n\b00H¢\b\f\r¨"}, d2={"Lokhttp3/CookieJar$Companion$NoCookies;", "Lokhttp3/CookieJar;", "<init>", "()V", "Lokhttp3/HttpUrl;", "url", "", "Lokhttp3/Cookie;", "loadForRequest", "(Lokhttp3/HttpUrl;)Ljava/util/List;", "cookies", "", "saveFromResponse", "(Lokhttp3/HttpUrl;Ljava/util/List;)V", "okhttp"})
        private static final class NoCookies
        implements CookieJar {
            @Override
            public void saveFromResponse(@NotNull HttpUrl url, @NotNull List<Cookie> cookies) {
                Intrinsics.checkNotNullParameter((Object)url, (String)"url");
                Intrinsics.checkNotNullParameter(cookies, (String)"cookies");
            }

            @Override
            @NotNull
            public List<Cookie> loadForRequest(@NotNull HttpUrl url) {
                Intrinsics.checkNotNullParameter((Object)url, (String)"url");
                return CollectionsKt.emptyList();
            }
        }
    }
}


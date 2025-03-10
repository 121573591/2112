/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" (\n\n \n\n\b\n\n\b\n\n\b\n\t\n\b  20:B0¢\bJ\r0¢\b\bJ\r\n0\t¢\b\nR\r0\f8@X¢\n\b\rR08¢\f\n\b\b¨"}, d2={"Lokhttp3/internal/http1/HeadersReader;", "", "Lokio/BufferedSource;", "source", "<init>", "(Lokio/BufferedSource;)V", "Lokhttp3/Headers;", "readHeaders", "()Lokhttp3/Headers;", "", "readLine", "()Ljava/lang/String;", "", "headerLimit", "J", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "Companion", "okhttp"})
public final class HeadersReader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final BufferedSource source;
    private long headerLimit;
    private static final int HEADER_LIMIT = 262144;

    public HeadersReader(@NotNull BufferedSource source2) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        this.source = source2;
        this.headerLimit = 262144L;
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    @NotNull
    public final String readLine() {
        String line = this.source.readUtf8LineStrict(this.headerLimit);
        this.headerLimit -= (long)line.length();
        return line;
    }

    @NotNull
    public final Headers readHeaders() {
        String line;
        Headers.Builder result = new Headers.Builder();
        while (!(((CharSequence)(line = this.readLine())).length() == 0)) {
            result.addLenient$okhttp(line);
        }
        return result.build();
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\b\n\b\b 20B\t\b¢\bR08XT¢\n\b¨"}, d2={"Lokhttp3/internal/http1/HeadersReader$Companion;", "", "<init>", "()V", "", "HEADER_LIMIT", "I", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


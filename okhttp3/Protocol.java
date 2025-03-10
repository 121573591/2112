/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n\n\n\b\b  \t2\b0 0:\tB\b0¢\bJ0H¢\bR08X¢\n\b\bj\b\nj\bj\b\fj\b\rj\bj\b¨"}, d2={"Lokhttp3/Protocol;", "", "", "protocol", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "Companion", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "okhttp"})
public final class Protocol
extends Enum<Protocol> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String protocol;
    public static final /* enum */ Protocol HTTP_1_0;
    public static final /* enum */ Protocol HTTP_1_1;
    @Deprecated(message="OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.")
    public static final /* enum */ Protocol SPDY_3;
    public static final /* enum */ Protocol HTTP_2;
    public static final /* enum */ Protocol H2_PRIOR_KNOWLEDGE;
    public static final /* enum */ Protocol QUIC;
    private static final /* synthetic */ Protocol[] $VALUES;

    private Protocol(String protocol) {
        this.protocol = protocol;
    }

    @NotNull
    public String toString() {
        return this.protocol;
    }

    public static Protocol[] values() {
        return (Protocol[])$VALUES.clone();
    }

    public static Protocol valueOf(String value) {
        return (Protocol)Enum.valueOf(Protocol.class, (String)value);
    }

    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String protocol) throws IOException {
        return Companion.get(protocol);
    }

    static {
        HTTP_1_0 = new Protocol("http/1.0");
        HTTP_1_1 = new Protocol("http/1.1");
        SPDY_3 = new Protocol("spdy/3.1");
        HTTP_2 = new Protocol("h2");
        H2_PRIOR_KNOWLEDGE = new Protocol("h2_prior_knowledge");
        QUIC = new Protocol("quic");
        $VALUES = protocolArray = new Protocol[]{Protocol.HTTP_1_0, Protocol.HTTP_1_1, Protocol.SPDY_3, Protocol.HTTP_2, Protocol.H2_PRIOR_KNOWLEDGE, Protocol.QUIC};
        Companion = new Companion(null);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\b\n\n \n\n\b\b 20B\t\b¢\bJ020H¢\b\b¨\t"}, d2={"Lokhttp3/Protocol$Companion;", "", "<init>", "()V", "", "protocol", "Lokhttp3/Protocol;", "get", "(Ljava/lang/String;)Lokhttp3/Protocol;", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String protocol) throws IOException {
            Protocol protocol2;
            Intrinsics.checkNotNullParameter((Object)protocol, (String)"protocol");
            String string = protocol;
            if (Intrinsics.areEqual((Object)string, (Object)HTTP_1_0.protocol)) {
                protocol2 = HTTP_1_0;
            } else if (Intrinsics.areEqual((Object)string, (Object)HTTP_1_1.protocol)) {
                protocol2 = HTTP_1_1;
            } else if (Intrinsics.areEqual((Object)string, (Object)H2_PRIOR_KNOWLEDGE.protocol)) {
                protocol2 = H2_PRIOR_KNOWLEDGE;
            } else if (Intrinsics.areEqual((Object)string, (Object)HTTP_2.protocol)) {
                protocol2 = HTTP_2;
            } else if (Intrinsics.areEqual((Object)string, (Object)SPDY_3.protocol)) {
                protocol2 = SPDY_3;
            } else if (Intrinsics.areEqual((Object)string, (Object)QUIC.protocol)) {
                protocol2 = QUIC;
            } else {
                throw new IOException("Unexpected protocol: " + protocol);
            }
            return protocol2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}


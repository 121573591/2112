/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" 6\n\n \n\b\n\n\b\n\b\n\b\n\n \n\n\n\b\n\t\n\b\bÆ 20B\t\b¢\bJ020¢\bJ\n02\t0\b¢\b\nJ02\r0\f20¢\bJ02\t0\b¢\bR08 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR0\b8 XT¢\n\bR 08 XT¢\n\b !R\"0\b8 XT¢\n\b\"R#0\b8 XT¢\n\b#R$0\b8 XT¢\n\b$R%0\b8 XT¢\n\b%R&0\b8 XT¢\n\b&R'0\b8 XT¢\n\b'R(0\b8 XT¢\n\b(R)0\b8 XT¢\n\b)R*08 XT¢\n\b*!R+0\b8 XT¢\n\b+R,0\b8 XT¢\n\b,R-08 XT¢\n\b-!¨."}, d2={"Lokhttp3/internal/ws/WebSocketProtocol;", "", "<init>", "()V", "", "key", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "", "code", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "Lokio/Buffer$UnsafeCursor;", "cursor", "", "", "toggleMask", "(Lokio/Buffer$UnsafeCursor;[B)V", "validateCloseCode", "(I)V", "ACCEPT_MAGIC", "Ljava/lang/String;", "B0_FLAG_FIN", "I", "B0_FLAG_RSV1", "B0_FLAG_RSV2", "B0_FLAG_RSV3", "B0_MASK_OPCODE", "B1_FLAG_MASK", "B1_MASK_LENGTH", "CLOSE_CLIENT_GOING_AWAY", "", "CLOSE_MESSAGE_MAX", "J", "CLOSE_NO_STATUS_CODE", "OPCODE_BINARY", "OPCODE_CONTINUATION", "OPCODE_CONTROL_CLOSE", "OPCODE_CONTROL_PING", "OPCODE_CONTROL_PONG", "OPCODE_FLAG_CONTROL", "OPCODE_TEXT", "PAYLOAD_BYTE_MAX", "PAYLOAD_LONG", "PAYLOAD_SHORT", "PAYLOAD_SHORT_MAX", "okhttp"})
@SourceDebugExtension(value={"SMAP\nWebSocketProtocol.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebSocketProtocol.kt\nokhttp3/internal/ws/WebSocketProtocol\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n"})
public final class WebSocketProtocol {
    @NotNull
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_TEXT = 1;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final long PAYLOAD_BYTE_MAX = 125L;
    public static final long CLOSE_MESSAGE_MAX = 123L;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535L;
    public static final int PAYLOAD_LONG = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final int CLOSE_NO_STATUS_CODE = 1005;

    private WebSocketProtocol() {
    }

    public final void toggleMask(@NotNull Buffer.UnsafeCursor cursor, @NotNull byte[] key) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        int keyIndex = 0;
        int keyLength = key.length;
        do {
            byte[] buffer = cursor.data;
            int i = cursor.start;
            int end = cursor.end;
            if (buffer == null) continue;
            while (i < end) {
                byte bufferInt = buffer[i];
                byte keyInt = key[keyIndex %= keyLength];
                buffer[i] = (byte)(bufferInt ^ keyInt);
                ++i;
                ++keyIndex;
            }
        } while (cursor.next() != -1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public final String closeCodeExceptionMessage(int code) {
        String string;
        if (code < 1000 || code >= 5000) {
            string = "Code must be in range [1000,5000): " + code;
            return string;
        }
        if (!(1004 <= code ? code < 1007 : false)) {
            if (1015 > code) return null;
            if (code >= 3000) return null;
            boolean bl = true;
            if (!bl) return null;
        }
        string = "Code " + code + " is reserved and may not be used.";
        return string;
    }

    public final void validateCloseCode(int code) {
        String message = this.closeCodeExceptionMessage(code);
        if (!(message == null)) {
            boolean bl = false;
            String string = message;
            Intrinsics.checkNotNull((Object)string);
            String string2 = string;
            throw new IllegalArgumentException(string2.toString());
        }
    }

    @NotNull
    public final String acceptHeader(@NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return ByteString.Companion.encodeUtf8(key + ACCEPT_MAGIC).sha1().base64();
    }
}


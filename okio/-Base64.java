/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio._JvmPlatformKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={" \f\n\n\n\b0*0 H ¢\b0 *02\b\b0H ¢\b\" 08 X¢\n\b\b\b\f\b\t\n\" \r08 X¢\n\b\r\b\b\f\b\n¨"}, d2={"", "", "decodeBase64ToArray", "(Ljava/lang/String;)[B", "map", "encodeBase64", "([B[B)Ljava/lang/String;", "BASE64", "[B", "getBASE64", "()[B", "getBASE64$annotations", "()V", "BASE64_URL_SAFE", "getBASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "okio"})
@JvmName(name="-Base64")
public final class -Base64 {
    @NotNull
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    @NotNull
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String $this$decodeBase64ToArray) {
        char c;
        int limit;
        Intrinsics.checkNotNullParameter((Object)$this$decodeBase64ToArray, (String)"<this>");
        for (limit = $this$decodeBase64ToArray.length(); limit > 0 && ((c = $this$decodeBase64ToArray.charAt(limit - 1)) == '=' || c == '\n' || c == '\r' || c == ' ' || c == '\t'); --limit) {
        }
        byte[] out = new byte[(int)((long)limit * 6L / 8L)];
        int outCount = 0;
        int inCount = 0;
        int word = 0;
        int n = limit;
        for (int pos = 0; pos < n; ++pos) {
            char c2 = $this$decodeBase64ToArray.charAt(pos);
            int bits = 0;
            boolean bl = 'A' <= c2 ? c2 < '[' : false;
            if (bl) {
                bits = c2 - 65;
            } else {
                boolean bl2 = 'a' <= c2 ? c2 < '{' : false;
                if (bl2) {
                    bits = c2 - 71;
                } else {
                    boolean bl3 = '0' <= c2 ? c2 < ':' : false;
                    if (bl3) {
                        bits = c2 + 4;
                    } else if (c2 == '+' || c2 == '-') {
                        bits = 62;
                    } else if (c2 == '/' || c2 == '_') {
                        bits = 63;
                    } else {
                        if (c2 == '\n' || c2 == '\r' || c2 == ' ' || c2 == '\t') continue;
                        return null;
                    }
                }
            }
            word = word << 6 | bits;
            if (++inCount % 4 != 0) continue;
            out[outCount++] = (byte)(word >> 16);
            out[outCount++] = (byte)(word >> 8);
            out[outCount++] = (byte)word;
        }
        int lastWordChars = inCount % 4;
        switch (lastWordChars) {
            case 1: {
                return null;
            }
            case 2: {
                out[outCount++] = (byte)((word <<= 12) >> 16);
                break;
            }
            case 3: {
                out[outCount++] = (byte)((word <<= 6) >> 16);
                out[outCount++] = (byte)(word >> 8);
            }
        }
        if (outCount == out.length) {
            return out;
        }
        byte[] byArray = Arrays.copyOf((byte[])out, (int)outCount);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"copyOf(this, newSize)");
        return byArray;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] $this$encodeBase64, @NotNull byte[] map) {
        Intrinsics.checkNotNullParameter((Object)$this$encodeBase64, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)map, (String)"map");
        int length = ($this$encodeBase64.length + 2) / 3 * 4;
        byte[] out = new byte[length];
        int index = 0;
        int end = $this$encodeBase64.length - $this$encodeBase64.length % 3;
        int i = 0;
        while (i < end) {
            byte b0 = $this$encodeBase64[i++];
            byte b1 = $this$encodeBase64[i++];
            byte b2 = $this$encodeBase64[i++];
            out[index++] = map[(b0 & 0xFF) >> 2];
            out[index++] = map[(b0 & 3) << 4 | (b1 & 0xFF) >> 4];
            out[index++] = map[(b1 & 0xF) << 2 | (b2 & 0xFF) >> 6];
            out[index++] = map[b2 & 0x3F];
        }
        switch ($this$encodeBase64.length - end) {
            case 1: {
                byte b0 = $this$encodeBase64[i];
                out[index++] = map[(b0 & 0xFF) >> 2];
                out[index++] = map[(b0 & 3) << 4];
                out[index++] = 61;
                out[index] = 61;
                break;
            }
            case 2: {
                byte b0 = $this$encodeBase64[i++];
                byte b1 = $this$encodeBase64[i];
                out[index++] = map[(b0 & 0xFF) >> 2];
                out[index++] = map[(b0 & 3) << 4 | (b1 & 0xFF) >> 4];
                out[index++] = map[(b1 & 0xF) << 2];
                out[index] = 61;
            }
        }
        return _JvmPlatformKt.toUtf8String(out);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] byArray, byte[] byArray2, int n, Object object) {
        if ((n & 1) != 0) {
            byArray2 = BASE64;
        }
        return -Base64.encodeBase64(byArray, byArray2);
    }
}


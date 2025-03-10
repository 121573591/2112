/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.net.IDN
 *  java.net.InetAddress
 *  java.util.Arrays
 *  java.util.Locale
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={" &\n\n \n\b\n\b\n\n\b\n\n\b\n\n\b\t7\t0\b20 20202020H¢\b\t\n)\f020 2020H¢\b\f\r0 20H¢\b0\b*0 H¢\b0 *0 ¢\b¨"}, d2={"", "input", "", "pos", "limit", "", "address", "addressOffset", "", "decodeIpv4Suffix", "(Ljava/lang/String;II[BI)Z", "Ljava/net/InetAddress;", "decodeIpv6", "(Ljava/lang/String;II)Ljava/net/InetAddress;", "inet6AddressToAscii", "([B)Ljava/lang/String;", "containsInvalidHostnameAsciiCodes", "(Ljava/lang/String;)Z", "toCanonicalHost", "(Ljava/lang/String;)Ljava/lang/String;", "okhttp"})
public final class HostnamesKt {
    @Nullable
    public static final String toCanonicalHost(@NotNull String $this$toCanonicalHost) {
        Intrinsics.checkNotNullParameter((Object)$this$toCanonicalHost, (String)"<this>");
        String host = $this$toCanonicalHost;
        if (StringsKt.contains$default((CharSequence)host, (CharSequence)":", (boolean)false, (int)2, null)) {
            InetAddress inetAddress = StringsKt.startsWith$default((String)host, (String)"[", (boolean)false, (int)2, null) && StringsKt.endsWith$default((String)host, (String)"]", (boolean)false, (int)2, null) ? HostnamesKt.decodeIpv6(host, 1, host.length() - 1) : HostnamesKt.decodeIpv6(host, 0, host.length());
            if (inetAddress == null) {
                return null;
            }
            InetAddress inetAddress2 = inetAddress;
            byte[] address = inetAddress2.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue((Object)address, (String)"address");
                return HostnamesKt.inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return inetAddress2.getHostAddress();
            }
            throw new AssertionError((Object)("Invalid IPv6 address: '" + host + '\''));
        }
        try {
            String string = IDN.toASCII((String)host);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toASCII(host)");
            String string2 = string;
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"US");
            String string3 = string2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"this as java.lang.String).toLowerCase(locale)");
            String result = string3;
            if (((CharSequence)result).length() == 0) {
                return null;
            }
            return HostnamesKt.containsInvalidHostnameAsciiCodes(result) ? null : result;
        }
        catch (IllegalArgumentException _) {
            return null;
        }
    }

    private static final boolean containsInvalidHostnameAsciiCodes(String $this$containsInvalidHostnameAsciiCodes) {
        int n = $this$containsInvalidHostnameAsciiCodes.length();
        for (int i = 0; i < n; ++i) {
            char c = $this$containsInvalidHostnameAsciiCodes.charAt(i);
            if (Intrinsics.compare((int)c, (int)31) <= 0 || Intrinsics.compare((int)c, (int)127) >= 0) {
                return true;
            }
            if (StringsKt.indexOf$default((CharSequence)" #%/:?@[\\]", (char)c, (int)0, (boolean)false, (int)6, null) == -1) continue;
            return true;
        }
        return false;
    }

    private static final InetAddress decodeIpv6(String input, int pos, int limit) {
        byte[] address = new byte[16];
        int b = 0;
        int compress = -1;
        int groupOffset = -1;
        int i = pos;
        while (i < limit) {
            int hexDigit;
            if (b == address.length) {
                return null;
            }
            if (i + 2 <= limit && StringsKt.startsWith$default((String)input, (String)"::", (int)i, (boolean)false, (int)4, null)) {
                if (compress != -1) {
                    return null;
                }
                compress = b += 2;
                if ((i += 2) == limit) {
                    break;
                }
            } else if (b != 0 && !StringsKt.startsWith$default((String)input, (String)":", (int)i, (boolean)false, (int)4, null)) {
                if (StringsKt.startsWith$default((String)input, (String)".", (int)i, (boolean)false, (int)4, null)) {
                    if (!HostnamesKt.decodeIpv4Suffix(input, groupOffset, limit, address, b - 2)) {
                        return null;
                    }
                    b += 2;
                    break;
                }
                return null;
            }
            int value = 0;
            groupOffset = ++i;
            while (i < limit && (hexDigit = Util.parseHexDigit(input.charAt(i))) != -1) {
                value = (value << 4) + hexDigit;
                ++i;
            }
            int groupLength = i - groupOffset;
            if (groupLength == 0 || groupLength > 4) {
                return null;
            }
            address[b++] = (byte)(value >>> 8 & 0xFF);
            address[b++] = (byte)(value & 0xFF);
        }
        if (b != address.length) {
            if (compress == -1) {
                return null;
            }
            System.arraycopy((Object)address, (int)compress, (Object)address, (int)(address.length - (b - compress)), (int)(b - compress));
            Arrays.fill((byte[])address, (int)compress, (int)(compress + (address.length - b)), (byte)0);
        }
        return InetAddress.getByAddress((byte[])address);
    }

    private static final boolean decodeIpv4Suffix(String input, int pos, int limit, byte[] address, int addressOffset) {
        int b = addressOffset;
        int i = pos;
        while (i < limit) {
            char c;
            if (b == address.length) {
                return false;
            }
            if (b != addressOffset && input.charAt(i) != '.') {
                return false;
            }
            int value = 0;
            int groupOffset = ++i;
            while (i < limit && Intrinsics.compare((int)(c = input.charAt(i)), (int)48) >= 0 && Intrinsics.compare((int)c, (int)57) <= 0) {
                if (value == 0 && groupOffset != i) {
                    return false;
                }
                if ((value = value * 10 + c - 48) > 255) {
                    return false;
                }
                ++i;
            }
            int groupLength = i - groupOffset;
            if (groupLength == 0) {
                return false;
            }
            address[b++] = (byte)value;
        }
        return b == addressOffset + 4;
    }

    private static final String inet6AddressToAscii(byte[] address) {
        int i;
        int longestRunOffset = 0;
        longestRunOffset = -1;
        int longestRunLength = 0;
        boolean bl = false;
        for (i = 0; i < address.length; i += 2) {
            int currentRunOffset = i;
            while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                i += 2;
            }
            int currentRunLength = i - currentRunOffset;
            if (currentRunLength <= longestRunLength || currentRunLength < 4) continue;
            longestRunOffset = currentRunOffset;
            longestRunLength = currentRunLength;
        }
        Buffer result = new Buffer();
        i = 0;
        while (i < address.length) {
            if (i == longestRunOffset) {
                result.writeByte(58);
                if ((i += longestRunLength) != 16) continue;
                result.writeByte(58);
                continue;
            }
            if (i > 0) {
                result.writeByte(58);
            }
            int group = Util.and(address[i], 255) << 8 | Util.and(address[i + 1], 255);
            result.writeHexadecimalUnsignedLong(group);
            i += 2;
        }
        return result.readUtf8();
    }
}


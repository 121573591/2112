/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.charset.Charset
 */
package cn.hutool.core.net;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.CharsetUtil;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

public class URLDecoder
implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final byte ESCAPE_CHAR = 37;

    public static String decodeForPath(String str, Charset charset) {
        return URLDecoder.decode(str, charset, false);
    }

    public static String decode(String str, Charset charset) {
        return URLDecoder.decode(str, charset, true);
    }

    public static String decode(String str, Charset charset, boolean isPlusToSpace) {
        if (null == str || null == charset) {
            return str;
        }
        int length = str.length();
        if (0 == length) {
            return "";
        }
        StringBuilder result = new StringBuilder(length / 3);
        int begin = 0;
        for (int i = 0; i < length; ++i) {
            int c = str.charAt(i);
            if (37 == c || CharUtil.isHexChar((char)c)) continue;
            if (i > begin) {
                result.append(URLDecoder.decodeSub(str, begin, i, charset, isPlusToSpace));
            }
            if (43 == c && isPlusToSpace) {
                c = 32;
            }
            result.append((char)c);
            begin = i + 1;
        }
        if (begin < length) {
            result.append(URLDecoder.decodeSub(str, begin, length, charset, isPlusToSpace));
        }
        return result.toString();
    }

    public static byte[] decode(byte[] bytes) {
        return URLDecoder.decode(bytes, true);
    }

    public static byte[] decode(byte[] bytes, boolean isPlusToSpace) {
        if (bytes == null) {
            return null;
        }
        ByteArrayOutputStream buffer = new ByteArrayOutputStream(bytes.length);
        for (int i = 0; i < bytes.length; ++i) {
            int b = bytes[i];
            if (b == 43) {
                buffer.write(isPlusToSpace ? 32 : b);
                continue;
            }
            if (b == 37) {
                int l;
                int u;
                if (i + 1 < bytes.length && (u = CharUtil.digit16(bytes[i + 1])) >= 0 && i + 2 < bytes.length && (l = CharUtil.digit16(bytes[i + 2])) >= 0) {
                    buffer.write((int)((char)((u << 4) + l)));
                    i += 2;
                    continue;
                }
                buffer.write(b);
                continue;
            }
            buffer.write(b);
        }
        return buffer.toByteArray();
    }

    private static String decodeSub(String str, int begin, int end, Charset charset, boolean isPlusToSpace) {
        return new String(URLDecoder.decode(str.substring(begin, end).getBytes(CharsetUtil.CHARSET_ISO_8859_1), isPlusToSpace), charset);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Color
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.nio.charset.Charset
 */
package cn.hutool.core.util;

import cn.hutool.core.codec.Base16Codec;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import java.awt.Color;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class HexUtil {
    public static boolean isHexNumber(String value) {
        if (StrUtil.startWith((CharSequence)value, '-')) {
            return false;
        }
        int index = 0;
        if (value.startsWith("0x", index) || value.startsWith("0X", index)) {
            index += 2;
        } else if (value.startsWith("#", index)) {
            ++index;
        }
        try {
            new BigInteger(value.substring(index), 16);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static char[] encodeHex(byte[] data) {
        return HexUtil.encodeHex(data, true);
    }

    public static char[] encodeHex(String str, Charset charset) {
        return HexUtil.encodeHex(StrUtil.bytes((CharSequence)str, charset), true);
    }

    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return (toLowerCase ? Base16Codec.CODEC_LOWER : Base16Codec.CODEC_UPPER).encode(data);
    }

    public static String encodeHexStr(byte[] data) {
        return HexUtil.encodeHexStr(data, true);
    }

    public static String encodeHexStr(String data, Charset charset) {
        return HexUtil.encodeHexStr(StrUtil.bytes((CharSequence)data, charset), true);
    }

    public static String encodeHexStr(String data) {
        return HexUtil.encodeHexStr(data, CharsetUtil.CHARSET_UTF_8);
    }

    public static String encodeHexStr(byte[] data, boolean toLowerCase) {
        return new String(HexUtil.encodeHex(data, toLowerCase));
    }

    public static String decodeHexStr(String hexStr) {
        return HexUtil.decodeHexStr(hexStr, CharsetUtil.CHARSET_UTF_8);
    }

    public static String decodeHexStr(String hexStr, Charset charset) {
        if (StrUtil.isEmpty(hexStr)) {
            return hexStr;
        }
        return StrUtil.str(HexUtil.decodeHex(hexStr), charset);
    }

    public static String decodeHexStr(char[] hexData, Charset charset) {
        return StrUtil.str(HexUtil.decodeHex(hexData), charset);
    }

    public static byte[] decodeHex(String hexStr) {
        return HexUtil.decodeHex((CharSequence)hexStr);
    }

    public static byte[] decodeHex(char[] hexData) {
        return HexUtil.decodeHex(String.valueOf((char[])hexData));
    }

    public static byte[] decodeHex(CharSequence hexData) {
        return Base16Codec.CODEC_LOWER.decode(hexData);
    }

    public static String encodeColor(Color color) {
        return HexUtil.encodeColor(color, "#");
    }

    public static String encodeColor(Color color, String prefix) {
        StringBuilder builder = new StringBuilder(prefix);
        String colorHex = Integer.toHexString((int)color.getRed());
        if (1 == colorHex.length()) {
            builder.append('0');
        }
        builder.append(colorHex);
        colorHex = Integer.toHexString((int)color.getGreen());
        if (1 == colorHex.length()) {
            builder.append('0');
        }
        builder.append(colorHex);
        colorHex = Integer.toHexString((int)color.getBlue());
        if (1 == colorHex.length()) {
            builder.append('0');
        }
        builder.append(colorHex);
        return builder.toString();
    }

    public static Color decodeColor(String hexColor) {
        return Color.decode((String)hexColor);
    }

    public static String toUnicodeHex(int value) {
        StringBuilder builder = new StringBuilder(6);
        builder.append("\\u");
        String hex = HexUtil.toHex(value);
        int len = hex.length();
        if (len < 4) {
            builder.append((CharSequence)"0000", 0, 4 - len);
        }
        builder.append(hex);
        return builder.toString();
    }

    public static String toUnicodeHex(char ch) {
        return Base16Codec.CODEC_LOWER.toUnicodeHex(ch);
    }

    public static String toHex(int value) {
        return Integer.toHexString((int)value);
    }

    public static int hexToInt(String value) {
        return Integer.parseInt((String)value, (int)16);
    }

    public static String toHex(long value) {
        return Long.toHexString((long)value);
    }

    public static long hexToLong(String value) {
        return Long.parseLong((String)value, (int)16);
    }

    public static void appendHex(StringBuilder builder, byte b, boolean toLowerCase) {
        (toLowerCase ? Base16Codec.CODEC_LOWER : Base16Codec.CODEC_UPPER).appendHex(builder, b);
    }

    public static BigInteger toBigInteger(String hexStr) {
        if (null == hexStr) {
            return null;
        }
        return new BigInteger(hexStr, 16);
    }

    public static String format(String hexStr) {
        int length = hexStr.length();
        StringBuilder builder = StrUtil.builder(length + length / 2);
        builder.append(hexStr.charAt(0)).append(hexStr.charAt(1));
        for (int i = 2; i < length - 1; i += 2) {
            builder.append(' ').append(hexStr.charAt(i)).append(hexStr.charAt(i + 1));
        }
        return builder.toString();
    }
}


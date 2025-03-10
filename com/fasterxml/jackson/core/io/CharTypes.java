/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 */
package com.fasterxml.jackson.core.io;

import java.util.Arrays;

public final class CharTypes {
    protected static final char[] HC;
    protected static final char[] HClower;
    protected static final byte[] HB;
    protected static final byte[] HBlower;
    protected static final int[] sInputCodes;
    protected static final int[] sInputCodesUTF8;
    protected static final int[] sInputCodesJsNames;
    protected static final int[] sInputCodesUtf8JsNames;
    protected static final int[] sInputCodesComment;
    protected static final int[] sInputCodesWS;
    protected static final int[] sOutputEscapes128;
    protected static final int[] sHexValues;

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUTF8;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] getInputCodeWS() {
        return sInputCodesWS;
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    public static int[] get7BitOutputEscapes(int quoteChar) {
        if (quoteChar == 34) {
            return sOutputEscapes128;
        }
        return AltEscapes.instance.escapesFor(quoteChar);
    }

    public static int charToHex(int ch) {
        return sHexValues[ch & 0xFF];
    }

    public static char hexToChar(int ch) {
        return HC[ch];
    }

    public static void appendQuoted(StringBuilder sb, String content) {
        int[] escCodes = sOutputEscapes128;
        int escLen = escCodes.length;
        int len = content.length();
        for (int i = 0; i < len; ++i) {
            char c = content.charAt(i);
            if (c >= escLen || escCodes[c] == 0) {
                sb.append(c);
                continue;
            }
            sb.append('\\');
            int escCode = escCodes[c];
            if (escCode < 0) {
                sb.append('u');
                sb.append('0');
                sb.append('0');
                char value = c;
                sb.append(HC[value >> 4]);
                sb.append(HC[value & 0xF]);
                continue;
            }
            sb.append((char)escCode);
        }
    }

    @Deprecated
    public static char[] copyHexChars() {
        return CharTypes.copyHexChars(true);
    }

    public static char[] copyHexChars(boolean uppercase) {
        return uppercase ? (char[])HC.clone() : (char[])HClower.clone();
    }

    @Deprecated
    public static byte[] copyHexBytes() {
        return CharTypes.copyHexBytes(true);
    }

    public static byte[] copyHexBytes(boolean uppercase) {
        return uppercase ? (byte[])HB.clone() : (byte[])HBlower.clone();
    }

    static {
        int i;
        int i2;
        HC = "0123456789ABCDEF".toCharArray();
        HClower = "0123456789abcdef".toCharArray();
        int len = HC.length;
        HB = new byte[len];
        HBlower = new byte[len];
        for (i2 = 0; i2 < len; ++i2) {
            CharTypes.HB[i2] = (byte)HC[i2];
            CharTypes.HBlower[i2] = (byte)HClower[i2];
        }
        int[] table = new int[256];
        for (i2 = 0; i2 < 32; ++i2) {
            table[i2] = -1;
        }
        table[34] = 1;
        table[92] = 1;
        sInputCodes = table;
        table = new int[sInputCodes.length];
        System.arraycopy((Object)sInputCodes, (int)0, (Object)table, (int)0, (int)table.length);
        for (int c = 128; c < 256; ++c) {
            int code = (c & 0xE0) == 192 ? 2 : ((c & 0xF0) == 224 ? 3 : ((c & 0xF8) == 240 ? 4 : -1));
            table[c] = code;
        }
        sInputCodesUTF8 = table;
        table = new int[256];
        Arrays.fill((int[])table, (int)-1);
        for (i2 = 33; i2 < 256; ++i2) {
            if (!Character.isJavaIdentifierPart((char)((char)i2))) continue;
            table[i2] = 0;
        }
        table[64] = 0;
        table[35] = 0;
        table[42] = 0;
        table[45] = 0;
        table[43] = 0;
        sInputCodesJsNames = table;
        table = new int[256];
        System.arraycopy((Object)sInputCodesJsNames, (int)0, (Object)table, (int)0, (int)table.length);
        Arrays.fill((int[])table, (int)128, (int)128, (int)0);
        sInputCodesUtf8JsNames = table;
        int[] buf = new int[256];
        System.arraycopy((Object)sInputCodesUTF8, (int)128, (Object)buf, (int)128, (int)128);
        Arrays.fill((int[])buf, (int)0, (int)32, (int)-1);
        buf[9] = 0;
        buf[10] = 10;
        buf[13] = 13;
        buf[42] = 42;
        sInputCodesComment = buf;
        buf = new int[256];
        System.arraycopy((Object)sInputCodesUTF8, (int)128, (Object)buf, (int)128, (int)128);
        Arrays.fill((int[])buf, (int)0, (int)32, (int)-1);
        buf[32] = 1;
        buf[9] = 1;
        buf[10] = 10;
        buf[13] = 13;
        buf[47] = 47;
        buf[35] = 35;
        sInputCodesWS = buf;
        table = new int[128];
        for (i2 = 0; i2 < 32; ++i2) {
            table[i2] = -1;
        }
        table[34] = 34;
        table[92] = 92;
        table[8] = 98;
        table[9] = 116;
        table[12] = 102;
        table[10] = 110;
        table[13] = 114;
        sOutputEscapes128 = table;
        sHexValues = new int[256];
        Arrays.fill((int[])sHexValues, (int)-1);
        for (i = 0; i < 10; ++i) {
            CharTypes.sHexValues[48 + i] = i;
        }
        for (i = 0; i < 6; ++i) {
            CharTypes.sHexValues[97 + i] = 10 + i;
            CharTypes.sHexValues[65 + i] = 10 + i;
        }
    }

    private static class AltEscapes {
        public static final AltEscapes instance = new AltEscapes();
        private int[][] _altEscapes = new int[128][];

        private AltEscapes() {
        }

        public int[] escapesFor(int quoteChar) {
            int[] esc = this._altEscapes[quoteChar];
            if (esc == null) {
                esc = Arrays.copyOf((int[])sOutputEscapes128, (int)128);
                if (esc[quoteChar] == 0) {
                    esc[quoteChar] = -1;
                }
                this._altEscapes[quoteChar] = esc;
            }
            return esc;
        }
    }
}


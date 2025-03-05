/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.core.text;

public class ASCIIStrCache {
    private static final int ASCII_LENGTH = 128;
    private static final String[] CACHE = new String[128];

    public static String toString(char c) {
        return c < '' ? CACHE[c] : String.valueOf((char)c);
    }

    static {
        for (char c = '\u0000'; c < ''; c = (char)(c + '\u0001')) {
            ASCIIStrCache.CACHE[c] = String.valueOf((char)c);
        }
    }
}


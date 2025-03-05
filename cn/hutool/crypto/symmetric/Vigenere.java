/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.crypto.symmetric;

public class Vigenere {
    public static String encrypt(CharSequence data, CharSequence cipherKey) {
        int dataLen = data.length();
        int cipherKeyLen = cipherKey.length();
        char[] cipherArray = new char[dataLen];
        for (int i = 0; i < dataLen / cipherKeyLen + 1; ++i) {
            for (int t = 0; t < cipherKeyLen; ++t) {
                if (t + i * cipherKeyLen >= dataLen) continue;
                char dataChar = data.charAt(t + i * cipherKeyLen);
                char cipherKeyChar = cipherKey.charAt(t);
                cipherArray[t + i * cipherKeyLen] = (char)((dataChar + cipherKeyChar - 64) % 95 + 32);
            }
        }
        return String.valueOf((char[])cipherArray);
    }

    public static String decrypt(CharSequence data, CharSequence cipherKey) {
        int dataLen = data.length();
        int cipherKeyLen = cipherKey.length();
        char[] clearArray = new char[dataLen];
        for (int i = 0; i < dataLen; ++i) {
            for (int t = 0; t < cipherKeyLen; ++t) {
                char cipherKeyChar;
                if (t + i * cipherKeyLen >= dataLen) continue;
                char dataChar = data.charAt(t + i * cipherKeyLen);
                clearArray[t + i * cipherKeyLen] = dataChar - (cipherKeyChar = cipherKey.charAt(t)) >= 0 ? (char)((dataChar - cipherKeyChar) % 95 + 32) : (char)((dataChar - cipherKeyChar + 95) % 95 + 32);
            }
        }
        return String.valueOf((char[])clearArray);
    }
}


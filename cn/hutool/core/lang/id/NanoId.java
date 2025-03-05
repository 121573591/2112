/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.SecureRandom
 *  java.util.Random
 */
package cn.hutool.core.lang.id;

import cn.hutool.core.util.RandomUtil;
import java.security.SecureRandom;
import java.util.Random;

public class NanoId {
    private static final SecureRandom DEFAULT_NUMBER_GENERATOR = RandomUtil.getSecureRandom();
    private static final char[] DEFAULT_ALPHABET = "_-0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final int DEFAULT_SIZE = 21;

    public static String randomNanoId() {
        return NanoId.randomNanoId(21);
    }

    public static String randomNanoId(int size) {
        return NanoId.randomNanoId(null, null, size);
    }

    public static String randomNanoId(Random random, char[] alphabet, int size) {
        if (random == null) {
            random = DEFAULT_NUMBER_GENERATOR;
        }
        if (alphabet == null) {
            alphabet = DEFAULT_ALPHABET;
        }
        if (alphabet.length == 0 || alphabet.length >= 256) {
            throw new IllegalArgumentException("Alphabet must contain between 1 and 255 symbols.");
        }
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        int mask = (2 << (int)Math.floor((double)(Math.log((double)(alphabet.length - 1)) / Math.log((double)2.0)))) - 1;
        int step = (int)Math.ceil((double)(1.6 * (double)mask * (double)size / (double)alphabet.length));
        StringBuilder idBuilder = new StringBuilder();
        block0: while (true) {
            byte[] bytes = new byte[step];
            random.nextBytes(bytes);
            int i = 0;
            while (true) {
                if (i >= step) continue block0;
                int alphabetIndex = bytes[i] & mask;
                if (alphabetIndex < alphabet.length) {
                    idBuilder.append(alphabet[alphabetIndex]);
                    if (idBuilder.length() == size) {
                        return idBuilder.toString();
                    }
                }
                ++i;
            }
            break;
        }
    }
}


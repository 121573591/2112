/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.math.BigInteger
 */
package com.fasterxml.jackson.core.io.doubleparser;

import com.fasterxml.jackson.core.io.doubleparser.JavaBigIntegerFromByteArray;
import com.fasterxml.jackson.core.io.doubleparser.JavaBigIntegerFromCharArray;
import com.fasterxml.jackson.core.io.doubleparser.JavaBigIntegerFromCharSequence;
import java.math.BigInteger;

public class JavaBigIntegerParser {
    private static final JavaBigIntegerFromByteArray BYTE_ARRAY_PARSER = new JavaBigIntegerFromByteArray();
    private static final JavaBigIntegerFromCharArray CHAR_ARRAY_PARSER = new JavaBigIntegerFromCharArray();
    private static final JavaBigIntegerFromCharSequence CHAR_SEQUENCE_PARSER = new JavaBigIntegerFromCharSequence();

    private JavaBigIntegerParser() {
    }

    public static BigInteger parseBigInteger(CharSequence str) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(str, 0, str.length(), 10);
    }

    public static BigInteger parseBigInteger(CharSequence str, int radix) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(str, 0, str.length(), radix);
    }

    public static BigInteger parseBigInteger(CharSequence str, int offset, int length) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(str, offset, length, 10);
    }

    public static BigInteger parseBigInteger(CharSequence str, int offset, int length, int radix) {
        return CHAR_SEQUENCE_PARSER.parseBigIntegerString(str, offset, length, radix);
    }

    public static BigInteger parseBigInteger(byte[] str) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(str, 0, str.length, 10);
    }

    public static BigInteger parseBigInteger(byte[] str, int radix) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(str, 0, str.length, radix);
    }

    public static BigInteger parseBigInteger(byte[] str, int offset, int length) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(str, offset, length, 10);
    }

    public static BigInteger parseBigInteger(byte[] str, int offset, int length, int radix) {
        return BYTE_ARRAY_PARSER.parseBigIntegerString(str, offset, length, radix);
    }

    public static BigInteger parseBigInteger(char[] str) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(str, 0, str.length, 10);
    }

    public static BigInteger parseBigInteger(char[] str, int radix) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(str, 0, str.length, radix);
    }

    public static BigInteger parseBigInteger(char[] str, int offset, int length) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(str, offset, length, 10);
    }

    public static BigInteger parseBigInteger(char[] str, int offset, int length, int radix) {
        return CHAR_ARRAY_PARSER.parseBigIntegerString(str, offset, length, radix);
    }
}


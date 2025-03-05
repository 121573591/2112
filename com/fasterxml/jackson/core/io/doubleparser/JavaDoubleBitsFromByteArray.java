/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.charset.StandardCharsets
 */
package com.fasterxml.jackson.core.io.doubleparser;

import com.fasterxml.jackson.core.io.doubleparser.AbstractJavaFloatingPointBitsFromByteArray;
import com.fasterxml.jackson.core.io.doubleparser.FastDoubleMath;
import java.nio.charset.StandardCharsets;

final class JavaDoubleBitsFromByteArray
extends AbstractJavaFloatingPointBitsFromByteArray {
    @Override
    long nan() {
        return Double.doubleToRawLongBits((double)Double.NaN);
    }

    @Override
    long negativeInfinity() {
        return Double.doubleToRawLongBits((double)Double.NEGATIVE_INFINITY);
    }

    @Override
    long positiveInfinity() {
        return Double.doubleToRawLongBits((double)Double.POSITIVE_INFINITY);
    }

    @Override
    long valueOfFloatLiteral(byte[] str, int startIndex, int endIndex, boolean isNegative, long significand, int exponent, boolean isSignificandTruncated, int exponentOfTruncatedSignificand) {
        double d = FastDoubleMath.tryDecFloatToDoubleTruncated(isNegative, significand, exponent, isSignificandTruncated, exponentOfTruncatedSignificand);
        return Double.doubleToRawLongBits((double)(Double.isNaN((double)d) ? Double.parseDouble((String)new String(str, startIndex, endIndex - startIndex, StandardCharsets.ISO_8859_1)) : d));
    }

    @Override
    long valueOfHexLiteral(byte[] str, int startIndex, int endIndex, boolean isNegative, long significand, int exponent, boolean isSignificandTruncated, int exponentOfTruncatedSignificand) {
        double d = FastDoubleMath.tryHexFloatToDoubleTruncated(isNegative, significand, exponent, isSignificandTruncated, exponentOfTruncatedSignificand);
        return Double.doubleToRawLongBits((double)(Double.isNaN((double)d) ? Double.parseDouble((String)new String(str, startIndex, endIndex - startIndex, StandardCharsets.ISO_8859_1)) : d));
    }
}


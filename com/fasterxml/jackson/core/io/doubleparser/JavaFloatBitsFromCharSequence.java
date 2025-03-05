/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package com.fasterxml.jackson.core.io.doubleparser;

import com.fasterxml.jackson.core.io.doubleparser.AbstractJavaFloatingPointBitsFromCharSequence;
import com.fasterxml.jackson.core.io.doubleparser.FastFloatMath;

final class JavaFloatBitsFromCharSequence
extends AbstractJavaFloatingPointBitsFromCharSequence {
    @Override
    long nan() {
        return Float.floatToRawIntBits((float)Float.NaN);
    }

    @Override
    long negativeInfinity() {
        return Float.floatToRawIntBits((float)Float.NEGATIVE_INFINITY);
    }

    @Override
    long positiveInfinity() {
        return Float.floatToRawIntBits((float)Float.POSITIVE_INFINITY);
    }

    @Override
    long valueOfFloatLiteral(CharSequence str, int startIndex, int endIndex, boolean isNegative, long significand, int exponent, boolean isSignificandTruncated, int exponentOfTruncatedSignificand) {
        float d = FastFloatMath.tryDecFloatToFloatTruncated(isNegative, significand, exponent, isSignificandTruncated, exponentOfTruncatedSignificand);
        return Float.floatToRawIntBits((float)(Float.isNaN((float)d) ? Float.parseFloat((String)str.subSequence(startIndex, endIndex).toString()) : d));
    }

    @Override
    long valueOfHexLiteral(CharSequence str, int startIndex, int endIndex, boolean isNegative, long significand, int exponent, boolean isSignificandTruncated, int exponentOfTruncatedSignificand) {
        float d = FastFloatMath.tryHexFloatToFloatTruncated(isNegative, significand, exponent, isSignificandTruncated, exponentOfTruncatedSignificand);
        return Float.floatToRawIntBits((float)(Float.isNaN((float)d) ? Float.parseFloat((String)str.subSequence(startIndex, endIndex).toString()) : d));
    }
}


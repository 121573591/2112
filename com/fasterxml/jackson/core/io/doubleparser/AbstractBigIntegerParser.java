/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.NumberFormatException
 *  java.lang.Object
 */
package com.fasterxml.jackson.core.io.doubleparser;

import com.fasterxml.jackson.core.io.doubleparser.AbstractNumberParser;

abstract class AbstractBigIntegerParser
extends AbstractNumberParser {
    private static final int MAX_DECIMAL_DIGITS = 646456993;
    private static final int MAX_HEX_DIGITS = 0x20000000;
    static final int RECURSION_THRESHOLD = 400;

    AbstractBigIntegerParser() {
    }

    protected static boolean hasManyDigits(int length) {
        return length > 18;
    }

    protected static void checkHexBigIntegerBounds(int numDigits) {
        if (numDigits > 0x20000000) {
            throw new NumberFormatException("value exceeds limits");
        }
    }

    protected static void checkDecBigIntegerBounds(int numDigits) {
        if (numDigits > 646456993) {
            throw new NumberFormatException("value exceeds limits");
        }
    }
}


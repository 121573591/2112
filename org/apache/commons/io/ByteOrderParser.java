/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.ByteOrder
 */
package org.apache.commons.io;

import java.nio.ByteOrder;

public final class ByteOrderParser {
    private ByteOrderParser() {
    }

    public static ByteOrder parseByteOrder(String value) {
        if (ByteOrder.BIG_ENDIAN.toString().equals((Object)value)) {
            return ByteOrder.BIG_ENDIAN;
        }
        if (ByteOrder.LITTLE_ENDIAN.toString().equals((Object)value)) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        throw new IllegalArgumentException("Unsupported byte order setting: " + value + ", expected one of " + ByteOrder.LITTLE_ENDIAN + ", " + ByteOrder.BIG_ENDIAN);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.stream.IntStream
 */
package org.apache.commons.lang3.stream;

import java.util.stream.IntStream;

public class IntStreams {
    public static IntStream range(int endExclusive) {
        return IntStream.range((int)0, (int)endExclusive);
    }

    public static IntStream rangeClosed(int endInclusive) {
        return IntStream.rangeClosed((int)0, (int)endInclusive);
    }
}


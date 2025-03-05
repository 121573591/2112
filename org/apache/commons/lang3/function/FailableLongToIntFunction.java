/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.Throwable
 */
package org.apache.commons.lang3.function;

@FunctionalInterface
public interface FailableLongToIntFunction<E extends Throwable> {
    public static final FailableLongToIntFunction NOP = t -> 0;

    public static <E extends Throwable> FailableLongToIntFunction<E> nop() {
        return NOP;
    }

    public int applyAsInt(long var1) throws E;
}


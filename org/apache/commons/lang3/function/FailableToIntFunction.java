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
public interface FailableToIntFunction<T, E extends Throwable> {
    public static final FailableToIntFunction NOP = t -> 0;

    public static <T, E extends Throwable> FailableToIntFunction<T, E> nop() {
        return NOP;
    }

    public int applyAsInt(T var1) throws E;
}


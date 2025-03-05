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
public interface FailableToIntBiFunction<T, U, E extends Throwable> {
    public static final FailableToIntBiFunction NOP = (t, u) -> 0;

    public static <T, U, E extends Throwable> FailableToIntBiFunction<T, U, E> nop() {
        return NOP;
    }

    public int applyAsInt(T var1, U var2) throws E;
}


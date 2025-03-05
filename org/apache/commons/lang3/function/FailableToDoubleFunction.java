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
public interface FailableToDoubleFunction<T, E extends Throwable> {
    public static final FailableToDoubleFunction NOP = t -> 0.0;

    public static <T, E extends Throwable> FailableToDoubleFunction<T, E> nop() {
        return NOP;
    }

    public double applyAsDouble(T var1) throws E;
}


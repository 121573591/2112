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
public interface FailableLongFunction<R, E extends Throwable> {
    public static final FailableLongFunction NOP = t -> null;

    public static <R, E extends Throwable> FailableLongFunction<R, E> nop() {
        return NOP;
    }

    public R apply(long var1) throws E;
}


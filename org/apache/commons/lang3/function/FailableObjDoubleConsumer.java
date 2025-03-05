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
public interface FailableObjDoubleConsumer<T, E extends Throwable> {
    public static final FailableObjDoubleConsumer NOP = (t, u) -> {};

    public static <T, E extends Throwable> FailableObjDoubleConsumer<T, E> nop() {
        return NOP;
    }

    public void accept(T var1, double var2) throws E;
}


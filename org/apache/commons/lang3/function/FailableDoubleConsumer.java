/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Objects
 */
package org.apache.commons.lang3.function;

import java.util.Objects;

@FunctionalInterface
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = t -> {};

    public static <E extends Throwable> FailableDoubleConsumer<E> nop() {
        return NOP;
    }

    public void accept(double var1) throws E;

    default public FailableDoubleConsumer<E> andThen(FailableDoubleConsumer<E> after) {
        Objects.requireNonNull(after);
        return t -> {
            this.accept(t);
            after.accept(t);
        };
    }
}


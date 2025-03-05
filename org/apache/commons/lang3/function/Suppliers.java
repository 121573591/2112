/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.Supplier
 */
package org.apache.commons.lang3.function;

import java.util.function.Supplier;

public class Suppliers {
    private static Supplier NUL = () -> null;

    public static <T> T get(Supplier<T> supplier) {
        return (T)(supplier == null ? null : supplier.get());
    }

    public static <T> Supplier<T> nul() {
        return NUL;
    }
}


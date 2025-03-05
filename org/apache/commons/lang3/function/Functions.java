/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.function.Function
 */
package org.apache.commons.lang3.function;

import java.util.function.Function;

public final class Functions {
    public static <T, R> Function<T, R> function(Function<T, R> function) {
        return function;
    }

    private Functions() {
    }
}


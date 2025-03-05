/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 */
package org.apache.commons.io.function;

import java.io.IOException;

@FunctionalInterface
public interface IOSupplier<T> {
    public T get() throws IOException;
}


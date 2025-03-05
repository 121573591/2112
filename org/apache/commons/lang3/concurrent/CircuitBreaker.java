/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.apache.commons.lang3.concurrent;

public interface CircuitBreaker<T> {
    public boolean checkState();

    public void close();

    public boolean incrementAndCheckState(T var1);

    public boolean isClosed();

    public boolean isOpen();

    public void open();
}


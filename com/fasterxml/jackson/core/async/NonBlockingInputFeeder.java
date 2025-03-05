/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.fasterxml.jackson.core.async;

public interface NonBlockingInputFeeder {
    public boolean needMoreInput();

    public void endOfInput();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.fasterxml.jackson.databind.util.internal;

interface Linked<T extends Linked<T>> {
    public T getPrevious();

    public void setPrevious(T var1);

    public T getNext();

    public void setNext(T var1);
}


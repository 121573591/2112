/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.reflect.Array
 */
package org.openjdk.nashorn.internal.runtime.arrays;

import java.lang.reflect.Array;
import org.openjdk.nashorn.internal.runtime.arrays.JavaArrayIterator;

final class ReverseJavaArrayIterator
extends JavaArrayIterator {
    public ReverseJavaArrayIterator(Object array, boolean includeUndefined) {
        super(array, includeUndefined);
        this.index = Array.getLength((Object)array) - 1;
    }

    @Override
    public boolean isReverse() {
        return true;
    }

    @Override
    protected boolean indexInArray() {
        return this.index >= 0L;
    }

    @Override
    protected long bumpIndex() {
        return this.index--;
    }
}


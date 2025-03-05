/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 */
package org.openjdk.nashorn.internal.runtime.arrays;

import java.lang.reflect.Array;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

class JavaArrayIterator
extends ArrayLikeIterator<Object> {
    protected final Object array;
    protected final long length;

    protected JavaArrayIterator(Object array, boolean includeUndefined) {
        super(includeUndefined);
        assert (array.getClass().isArray()) : "expecting Java array object";
        this.array = array;
        this.length = Array.getLength((Object)array);
    }

    protected boolean indexInArray() {
        return this.index < this.length;
    }

    public Object next() {
        return Array.get((Object)this.array, (int)((int)this.bumpIndex()));
    }

    @Override
    public long getLength() {
        return this.length;
    }

    public boolean hasNext() {
        return this.indexInArray();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}


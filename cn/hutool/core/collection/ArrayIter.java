/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Array
 *  java.util.NoSuchElementException
 */
package cn.hutool.core.collection;

import cn.hutool.core.collection.IterableIter;
import cn.hutool.core.collection.ResettableIter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class ArrayIter<E>
implements IterableIter<E>,
ResettableIter<E>,
Serializable {
    private static final long serialVersionUID = 1L;
    private final Object array;
    private int startIndex;
    private int endIndex;
    private int index;

    public ArrayIter(E[] array) {
        this((Object)array);
    }

    public ArrayIter(Object array) {
        this(array, 0);
    }

    public ArrayIter(Object array, int startIndex) {
        this(array, startIndex, -1);
    }

    public ArrayIter(Object array, int startIndex, int endIndex) {
        this.endIndex = Array.getLength((Object)array);
        if (endIndex > 0 && endIndex < this.endIndex) {
            this.endIndex = endIndex;
        }
        if (startIndex >= 0 && startIndex < this.endIndex) {
            this.startIndex = startIndex;
        }
        this.array = array;
        this.index = this.startIndex;
    }

    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    public E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return (E)Array.get((Object)this.array, (int)this.index++);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    public Object getArray() {
        return this.array;
    }

    @Override
    public void reset() {
        this.index = this.startIndex;
    }
}


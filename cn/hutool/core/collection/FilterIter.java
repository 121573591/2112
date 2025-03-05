/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 */
package cn.hutool.core.collection;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Filter;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterIter<E>
implements Iterator<E> {
    private final Iterator<? extends E> iterator;
    private final Filter<? super E> filter;
    private E nextObject;
    private boolean nextObjectSet = false;

    public FilterIter(Iterator<? extends E> iterator, Filter<? super E> filter) {
        this.iterator = Assert.notNull(iterator);
        this.filter = filter;
    }

    public boolean hasNext() {
        return this.nextObjectSet || this.setNextObject();
    }

    public E next() {
        if (!this.nextObjectSet && !this.setNextObject()) {
            throw new NoSuchElementException();
        }
        this.nextObjectSet = false;
        return this.nextObject;
    }

    public void remove() {
        if (this.nextObjectSet) {
            throw new IllegalStateException("remove() cannot be called");
        }
        this.iterator.remove();
    }

    public Iterator<? extends E> getIterator() {
        return this.iterator;
    }

    public Filter<? super E> getFilter() {
        return this.filter;
    }

    private boolean setNextObject() {
        while (this.iterator.hasNext()) {
            Object object = this.iterator.next();
            if (null != this.filter && !this.filter.accept(object)) continue;
            this.nextObject = object;
            this.nextObjectSet = true;
            return true;
        }
        return false;
    }
}


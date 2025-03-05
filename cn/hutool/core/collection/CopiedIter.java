/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package cn.hutool.core.collection;

import cn.hutool.core.collection.IterableIter;
import cn.hutool.core.collection.ListUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class CopiedIter<E>
implements IterableIter<E>,
Serializable {
    private static final long serialVersionUID = 1L;
    private final Iterator<E> listIterator;

    public static <E> CopiedIter<E> copyOf(Iterator<E> iterator) {
        return new CopiedIter<E>(iterator);
    }

    public CopiedIter(Iterator<E> iterator) {
        ArrayList<E> eleList = ListUtil.toList(iterator);
        this.listIterator = eleList.iterator();
    }

    public boolean hasNext() {
        return this.listIterator.hasNext();
    }

    public E next() {
        return (E)this.listIterator.next();
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This is a read-only iterator.");
    }
}


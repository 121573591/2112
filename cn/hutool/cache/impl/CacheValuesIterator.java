/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.Iterator
 */
package cn.hutool.cache.impl;

import cn.hutool.cache.impl.CacheObj;
import cn.hutool.cache.impl.CacheObjIterator;
import java.io.Serializable;
import java.util.Iterator;

public class CacheValuesIterator<V>
implements Iterator<V>,
Serializable {
    private static final long serialVersionUID = 1L;
    private final CacheObjIterator<?, V> cacheObjIter;

    CacheValuesIterator(CacheObjIterator<?, V> iterator) {
        this.cacheObjIter = iterator;
    }

    public boolean hasNext() {
        return this.cacheObjIter.hasNext();
    }

    public V next() {
        return ((CacheObj)this.cacheObjIter.next()).getValue();
    }

    public void remove() {
        this.cacheObjIter.remove();
    }
}


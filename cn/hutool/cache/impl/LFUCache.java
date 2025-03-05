/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.HashMap
 *  java.util.Iterator
 */
package cn.hutool.cache.impl;

import cn.hutool.cache.impl.CacheObj;
import cn.hutool.cache.impl.StampedCache;
import java.util.HashMap;
import java.util.Iterator;

public class LFUCache<K, V>
extends StampedCache<K, V> {
    private static final long serialVersionUID = 1L;

    public LFUCache(int capacity) {
        this(capacity, 0L);
    }

    public LFUCache(int capacity, long timeout2) {
        if (Integer.MAX_VALUE == capacity) {
            --capacity;
        }
        this.capacity = capacity;
        this.timeout = timeout2;
        this.cacheMap = new HashMap(capacity + 1, 1.0f);
    }

    @Override
    protected int pruneCache() {
        int count = 0;
        CacheObj comin = null;
        Iterator values = this.cacheObjIter();
        while (values.hasNext()) {
            CacheObj co = (CacheObj)values.next();
            if (co.isExpired()) {
                values.remove();
                this.onRemove(co.key, co.obj);
                ++count;
                continue;
            }
            if (comin != null && co.accessCount.get() >= comin.accessCount.get()) continue;
            comin = co;
        }
        if (this.isFull() && comin != null) {
            long minAccessCount = comin.accessCount.get();
            values = this.cacheObjIter();
            while (values.hasNext()) {
                CacheObj co1 = (CacheObj)values.next();
                if (co1.accessCount.addAndGet(-minAccessCount) > 0L) continue;
                values.remove();
                this.onRemove(co1.key, co1.obj);
                ++count;
            }
        }
        return count;
    }
}


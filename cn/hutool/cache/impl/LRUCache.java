/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Iterator
 */
package cn.hutool.cache.impl;

import cn.hutool.cache.impl.CacheObj;
import cn.hutool.cache.impl.ReentrantCache;
import cn.hutool.core.lang.mutable.Mutable;
import cn.hutool.core.map.FixedLinkedHashMap;
import java.util.Iterator;

public class LRUCache<K, V>
extends ReentrantCache<K, V> {
    private static final long serialVersionUID = 1L;

    public LRUCache(int capacity) {
        this(capacity, 0L);
    }

    public LRUCache(int capacity, long timeout2) {
        if (Integer.MAX_VALUE == capacity) {
            --capacity;
        }
        this.capacity = capacity;
        this.timeout = timeout2;
        FixedLinkedHashMap fixedLinkedHashMap = new FixedLinkedHashMap(capacity);
        fixedLinkedHashMap.setRemoveListener(entry -> {
            if (null != this.listener) {
                this.listener.onRemove(((Mutable)entry.getKey()).get(), ((CacheObj)entry.getValue()).getValue());
            }
        });
        this.cacheMap = fixedLinkedHashMap;
    }

    @Override
    protected int pruneCache() {
        if (!this.isPruneExpiredActive()) {
            return 0;
        }
        int count = 0;
        Iterator values = this.cacheObjIter();
        while (values.hasNext()) {
            CacheObj co = (CacheObj)values.next();
            if (!co.isExpired()) continue;
            values.remove();
            this.onRemove(co.key, co.obj);
            ++count;
        }
        return count;
    }
}


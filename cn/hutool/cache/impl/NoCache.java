/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Iterator
 */
package cn.hutool.cache.impl;

import cn.hutool.cache.Cache;
import cn.hutool.cache.impl.CacheObj;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.lang.func.Func0;
import java.util.Iterator;

public class NoCache<K, V>
implements Cache<K, V> {
    private static final long serialVersionUID = 1L;

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public long timeout() {
        return 0L;
    }

    @Override
    public void put(K key, V object) {
    }

    @Override
    public void put(K key, V object, long timeout2) {
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V get(K key, boolean isUpdateLastAccess) {
        return null;
    }

    @Override
    public V get(K key, Func0<V> supplier) {
        return this.get(key, true, supplier);
    }

    @Override
    public V get(K key, boolean isUpdateLastAccess, Func0<V> supplier) {
        return this.get(key, isUpdateLastAccess, 0L, supplier);
    }

    @Override
    public V get(K key, boolean isUpdateLastAccess, long timeout2, Func0<V> supplier) {
        try {
            return null == supplier ? null : (V)supplier.call();
        }
        catch (Exception e) {
            throw ExceptionUtil.wrapRuntime(e);
        }
    }

    public Iterator<V> iterator() {
        return new Iterator<V>(){

            public boolean hasNext() {
                return false;
            }

            public V next() {
                return null;
            }
        };
    }

    @Override
    public Iterator<CacheObj<K, V>> cacheObjIterator() {
        return null;
    }

    @Override
    public int prune() {
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void remove(K key) {
    }

    @Override
    public void clear() {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}


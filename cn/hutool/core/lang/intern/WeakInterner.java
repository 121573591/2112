/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.ref.WeakReference
 */
package cn.hutool.core.lang.intern;

import cn.hutool.core.lang.intern.Interner;
import cn.hutool.core.map.WeakConcurrentMap;
import java.lang.ref.WeakReference;

public class WeakInterner<T>
implements Interner<T> {
    private final WeakConcurrentMap<T, WeakReference<T>> cache = new WeakConcurrentMap();

    @Override
    public T intern(T sample) {
        Object val;
        if (sample == null) {
            return null;
        }
        while ((val = ((WeakReference)this.cache.computeIfAbsent(sample, WeakReference::new)).get()) == null) {
        }
        return (T)val;
    }
}


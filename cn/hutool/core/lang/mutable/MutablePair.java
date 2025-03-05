/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.lang.mutable;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.lang.mutable.Mutable;

public class MutablePair<K, V>
extends Pair<K, V>
implements Mutable<Pair<K, V>> {
    private static final long serialVersionUID = 1L;

    public MutablePair(K key, V value) {
        super(key, value);
    }

    public MutablePair<K, V> setKey(K key) {
        this.key = key;
        return this;
    }

    public MutablePair<K, V> setValue(V value) {
        this.value = value;
        return this;
    }

    @Override
    public Pair<K, V> get() {
        return this;
    }

    @Override
    public void set(Pair<K, V> pair) {
        this.key = pair.getKey();
        this.value = pair.getValue();
    }
}


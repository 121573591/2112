/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 */
package cn.hutool.core.map;

import cn.hutool.core.map.MapWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TolerantMap<K, V>
extends MapWrapper<K, V> {
    private static final long serialVersionUID = -4158133823263496197L;
    private final V defaultValue;

    public TolerantMap(V defaultValue) {
        this((Map<K, V>)new HashMap(), defaultValue);
    }

    public TolerantMap(int initialCapacity, float loadFactor, V defaultValue) {
        this((Map<K, V>)new HashMap(initialCapacity, loadFactor), defaultValue);
    }

    public TolerantMap(int initialCapacity, V defaultValue) {
        this((Map<K, V>)new HashMap(initialCapacity), defaultValue);
    }

    public TolerantMap(Map<K, V> map, V defaultValue) {
        super(map);
        this.defaultValue = defaultValue;
    }

    public static <K, V> TolerantMap<K, V> of(Map<K, V> map, V defaultValue) {
        return new TolerantMap<K, V>(map, defaultValue);
    }

    @Override
    public V get(Object key) {
        return this.getOrDefault(key, this.defaultValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TolerantMap that = (TolerantMap)o;
        return this.getRaw().equals(that.getRaw()) && Objects.equals(this.defaultValue, that.defaultValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash((Object[])new Object[]{this.getRaw(), this.defaultValue});
    }

    @Override
    public String toString() {
        return "TolerantMap{map=" + this.getRaw() + ", defaultValue=" + this.defaultValue + '}';
    }
}


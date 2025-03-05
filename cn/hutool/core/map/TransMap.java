/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Map
 *  java.util.function.BiFunction
 *  java.util.function.Function
 *  java.util.function.Supplier
 */
package cn.hutool.core.map;

import cn.hutool.core.map.MapWrapper;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class TransMap<K, V>
extends MapWrapper<K, V> {
    private static final long serialVersionUID = 1L;

    public TransMap(Supplier<Map<K, V>> mapFactory) {
        super(mapFactory);
    }

    public TransMap(Map<K, V> emptyMap) {
        super(emptyMap);
    }

    @Override
    public V get(Object key) {
        return super.get(this.customKey(key));
    }

    @Override
    public V put(K key, V value) {
        return super.put(this.customKey(key), this.customValue(value));
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(this.customKey(key));
    }

    @Override
    public V remove(Object key) {
        return super.remove(this.customKey(key));
    }

    @Override
    public boolean remove(Object key, Object value) {
        return super.remove(this.customKey(key), this.customValue(value));
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return super.replace(this.customKey(key), this.customValue(oldValue), this.customValue(newValue));
    }

    @Override
    public V replace(K key, V value) {
        return super.replace(this.customKey(key), this.customValue(value));
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return super.getOrDefault(this.customKey(key), this.customValue(defaultValue));
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.computeIfPresent(this.customKey(key), (k, v) -> remappingFunction.apply(this.customKey(k), this.customValue(v)));
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return super.compute(this.customKey(key), (k, v) -> remappingFunction.apply(this.customKey(k), this.customValue(v)));
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return super.merge(this.customKey(key), this.customValue(value), (v1, v2) -> remappingFunction.apply(this.customValue(v1), this.customValue(v2)));
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return super.putIfAbsent(this.customKey(key), this.customValue(value));
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return super.computeIfAbsent(this.customKey(key), mappingFunction);
    }

    protected abstract K customKey(Object var1);

    protected abstract V customValue(Object var1);
}


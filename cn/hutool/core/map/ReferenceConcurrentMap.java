/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.ref.Reference
 *  java.lang.ref.ReferenceQueue
 *  java.lang.ref.SoftReference
 *  java.lang.ref.WeakReference
 *  java.util.AbstractMap$SimpleImmutableEntry
 *  java.util.Collection
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.ConcurrentMap
 *  java.util.function.BiConsumer
 *  java.util.function.BiFunction
 *  java.util.function.Function
 *  java.util.stream.Collectors
 */
package cn.hutool.core.map;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.func.Func0;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReferenceUtil;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReferenceConcurrentMap<K, V>
implements ConcurrentMap<K, V>,
Iterable<Map.Entry<K, V>>,
Serializable {
    final ConcurrentMap<Reference<K>, V> raw;
    private final ReferenceQueue<K> lastQueue;
    private final ReferenceUtil.ReferenceType keyType;
    private BiConsumer<Reference<? extends K>, V> purgeListener;

    public ReferenceConcurrentMap(ConcurrentMap<Reference<K>, V> raw, ReferenceUtil.ReferenceType referenceType) {
        this.raw = raw;
        this.keyType = referenceType;
        this.lastQueue = new ReferenceQueue();
    }

    public void setPurgeListener(BiConsumer<Reference<? extends K>, V> purgeListener) {
        this.purgeListener = purgeListener;
    }

    public int size() {
        this.purgeStaleKeys();
        return this.raw.size();
    }

    public boolean isEmpty() {
        return 0 == this.size();
    }

    public V get(Object key) {
        this.purgeStaleKeys();
        return (V)this.raw.get(this.ofKey(key, null));
    }

    public boolean containsKey(Object key) {
        this.purgeStaleKeys();
        return this.raw.containsKey(this.ofKey(key, null));
    }

    public boolean containsValue(Object value) {
        this.purgeStaleKeys();
        return this.raw.containsValue(value);
    }

    public V put(K key, V value) {
        this.purgeStaleKeys();
        return (V)this.raw.put(this.ofKey(key, this.lastQueue), value);
    }

    public V putIfAbsent(K key, V value) {
        this.purgeStaleKeys();
        return (V)this.raw.putIfAbsent(this.ofKey(key, this.lastQueue), value);
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    public V replace(K key, V value) {
        this.purgeStaleKeys();
        return (V)this.raw.replace(this.ofKey(key, this.lastQueue), value);
    }

    public boolean replace(K key, V oldValue, V newValue) {
        this.purgeStaleKeys();
        return this.raw.replace(this.ofKey(key, this.lastQueue), oldValue, newValue);
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        this.purgeStaleKeys();
        this.raw.replaceAll((kWeakKey, value) -> function.apply(kWeakKey.get(), value));
    }

    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        this.purgeStaleKeys();
        return (V)this.raw.computeIfAbsent(this.ofKey(key, this.lastQueue), kWeakKey -> mappingFunction.apply(key));
    }

    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        this.purgeStaleKeys();
        return (V)this.raw.computeIfPresent(this.ofKey(key, this.lastQueue), (kWeakKey, value) -> remappingFunction.apply(key, value));
    }

    public V computeIfAbsent(K key, Func0<? extends V> supplier) {
        return this.computeIfAbsent(key, keyParam -> supplier.callWithRuntimeException());
    }

    public V remove(Object key) {
        this.purgeStaleKeys();
        return (V)this.raw.remove(this.ofKey(key, null));
    }

    public boolean remove(Object key, Object value) {
        this.purgeStaleKeys();
        return this.raw.remove(this.ofKey(key, null), value);
    }

    public void clear() {
        this.raw.clear();
        while (this.lastQueue.poll() != null) {
        }
    }

    public Set<K> keySet() {
        Collection trans = CollUtil.trans(this.raw.keySet(), reference -> null == reference ? null : reference.get());
        return new HashSet(trans);
    }

    public Collection<V> values() {
        this.purgeStaleKeys();
        return this.raw.values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        this.purgeStaleKeys();
        return (Set)this.raw.entrySet().stream().map(entry -> new AbstractMap.SimpleImmutableEntry(((Reference)entry.getKey()).get(), entry.getValue())).collect(Collectors.toSet());
    }

    public void forEach(BiConsumer<? super K, ? super V> action) {
        this.purgeStaleKeys();
        this.raw.forEach((key, value) -> action.accept(key.get(), value));
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return this.entrySet().iterator();
    }

    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        this.purgeStaleKeys();
        return (V)this.raw.compute(this.ofKey(key, this.lastQueue), (kWeakKey, value) -> remappingFunction.apply(key, value));
    }

    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        this.purgeStaleKeys();
        return (V)this.raw.merge(this.ofKey(key, this.lastQueue), value, remappingFunction);
    }

    private void purgeStaleKeys() {
        Reference reference;
        while ((reference = this.lastQueue.poll()) != null) {
            Object value = this.raw.remove((Object)reference);
            if (null == this.purgeListener) continue;
            this.purgeListener.accept((Object)reference, value);
        }
    }

    private Reference<K> ofKey(K key, ReferenceQueue<? super K> queue) {
        switch (this.keyType) {
            case WEAK: {
                return new WeakKey<K>(key, queue);
            }
            case SOFT: {
                return new SoftKey<K>(key, queue);
            }
        }
        throw new IllegalArgumentException("Unsupported key type: " + (Object)((Object)this.keyType));
    }

    private static class SoftKey<K>
    extends SoftReference<K> {
        private final int hashCode;

        SoftKey(K key, ReferenceQueue<? super K> queue) {
            super(key, queue);
            this.hashCode = key.hashCode();
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (other instanceof SoftKey) {
                return ObjectUtil.equals(((SoftKey)((Object)other)).get(), this.get());
            }
            return false;
        }
    }

    private static class WeakKey<K>
    extends WeakReference<K> {
        private final int hashCode;

        WeakKey(K key, ReferenceQueue<? super K> queue) {
            super(key, queue);
            this.hashCode = key.hashCode();
        }

        public int hashCode() {
            return this.hashCode;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (other instanceof WeakKey) {
                return ObjectUtil.equals(((WeakKey)((Object)other)).get(), this.get());
            }
            return false;
        }
    }
}


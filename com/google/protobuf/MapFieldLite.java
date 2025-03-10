/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite<K, V>
extends LinkedHashMap<K, V> {
    private boolean isMutable = true;
    private static final MapFieldLite<?, ?> EMPTY_MAP_FIELD = new MapFieldLite();

    private MapFieldLite() {
    }

    private MapFieldLite(Map<K, V> mapData) {
        super(mapData);
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    public void mergeFrom(MapFieldLite<K, V> other) {
        this.ensureMutable();
        if (!other.isEmpty()) {
            this.putAll((Map<? extends K, ? extends V>)other);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return this.isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public void clear() {
        this.ensureMutable();
        super.clear();
    }

    public V put(K key, V value) {
        this.ensureMutable();
        Internal.checkNotNull(key);
        Internal.checkNotNull(value);
        return (V)super.put(key, value);
    }

    public V put(Map.Entry<K, V> entry) {
        return (V)this.put(entry.getKey(), entry.getValue());
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        this.ensureMutable();
        MapFieldLite.checkForNullKeysAndValues(m);
        super.putAll(m);
    }

    public V remove(Object key) {
        this.ensureMutable();
        return (V)super.remove(key);
    }

    private static void checkForNullKeysAndValues(Map<?, ?> m) {
        for (Object key : m.keySet()) {
            Internal.checkNotNull(key);
            Internal.checkNotNull(m.get(key));
        }
    }

    private static boolean equals(Object a, Object b) {
        if (a instanceof byte[] && b instanceof byte[]) {
            return Arrays.equals((byte[])((byte[])a), (byte[])((byte[])b));
        }
        return a.equals(b);
    }

    static <K, V> boolean equals(Map<K, V> a, Map<K, V> b) {
        if (a == b) {
            return true;
        }
        if (a.size() != b.size()) {
            return false;
        }
        for (Map.Entry entry : a.entrySet()) {
            if (!b.containsKey(entry.getKey())) {
                return false;
            }
            if (MapFieldLite.equals(entry.getValue(), b.get(entry.getKey()))) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        return object instanceof Map && MapFieldLite.equals(this, (Map)object);
    }

    private static int calculateHashCodeForObject(Object a) {
        if (a instanceof byte[]) {
            return Internal.hashCode((byte[])a);
        }
        if (a instanceof Internal.EnumLite) {
            throw new UnsupportedOperationException();
        }
        return a.hashCode();
    }

    static <K, V> int calculateHashCodeForMap(Map<K, V> a) {
        int result = 0;
        for (Map.Entry entry : a.entrySet()) {
            result += MapFieldLite.calculateHashCodeForObject(entry.getKey()) ^ MapFieldLite.calculateHashCodeForObject(entry.getValue());
        }
        return result;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(this);
    }

    private static Object copy(Object object) {
        if (object instanceof byte[]) {
            byte[] data = (byte[])object;
            return Arrays.copyOf((byte[])data, (int)data.length);
        }
        return object;
    }

    static <K, V> Map<K, V> copy(Map<K, V> map) {
        LinkedHashMap result = new LinkedHashMap(map.size() * 4 / 3 + 1);
        for (Map.Entry entry : map.entrySet()) {
            result.put(entry.getKey(), MapFieldLite.copy(entry.getValue()));
        }
        return result;
    }

    public MapFieldLite<K, V> mutableCopy() {
        return this.isEmpty() ? new MapFieldLite<K, V>() : new MapFieldLite<K, V>(this);
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    private void ensureMutable() {
        if (!this.isMutable()) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        EMPTY_MAP_FIELD.makeImmutable();
    }
}


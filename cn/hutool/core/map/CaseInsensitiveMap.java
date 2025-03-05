/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.function.Function
 */
package cn.hutool.core.map;

import cn.hutool.core.map.FuncKeyMap;
import cn.hutool.core.map.MapBuilder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CaseInsensitiveMap<K, V>
extends FuncKeyMap<K, V> {
    private static final long serialVersionUID = 4043263744224569870L;

    public CaseInsensitiveMap() {
        this(16);
    }

    public CaseInsensitiveMap(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public CaseInsensitiveMap(Map<? extends K, ? extends V> m) {
        this(0.75f, m);
    }

    public CaseInsensitiveMap(float loadFactor, Map<? extends K, ? extends V> m) {
        this(m.size(), loadFactor);
        this.putAll(m);
    }

    public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
        this(MapBuilder.create(new HashMap(initialCapacity, loadFactor)));
    }

    CaseInsensitiveMap(MapBuilder<K, V> emptyMapBuilder) {
        super(emptyMapBuilder.build(), (Function & Serializable)key -> {
            if (key instanceof CharSequence) {
                key = key.toString().toLowerCase();
            }
            return key;
        });
    }
}


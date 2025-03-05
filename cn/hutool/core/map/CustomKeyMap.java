/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Map
 */
package cn.hutool.core.map;

import cn.hutool.core.map.TransMap;
import java.util.Map;

public abstract class CustomKeyMap<K, V>
extends TransMap<K, V> {
    private static final long serialVersionUID = 4043263744224569870L;

    public CustomKeyMap(Map<K, V> emptyMap) {
        super(emptyMap);
    }

    @Override
    protected V customValue(Object value) {
        return (V)value;
    }
}


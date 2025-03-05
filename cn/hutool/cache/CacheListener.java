/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package cn.hutool.cache;

public interface CacheListener<K, V> {
    public void onRemove(K var1, V var2);
}


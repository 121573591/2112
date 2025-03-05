/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.lang.hash;

import cn.hutool.core.lang.hash.Hash;
import cn.hutool.core.lang.hash.Number128;

@FunctionalInterface
public interface Hash128<T>
extends Hash<T> {
    public Number128 hash128(T var1);

    @Override
    default public Number hash(T t) {
        return this.hash128(t);
    }
}


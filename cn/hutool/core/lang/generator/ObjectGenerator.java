/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.lang.generator;

import cn.hutool.core.lang.generator.Generator;
import cn.hutool.core.util.ReflectUtil;

public class ObjectGenerator<T>
implements Generator<T> {
    private final Class<T> clazz;

    public ObjectGenerator(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T next() {
        return ReflectUtil.newInstanceIfPossible(this.clazz);
    }
}


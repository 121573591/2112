/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.reflect.Type
 */
package cn.hutool.core.convert;

import java.lang.reflect.Type;

@FunctionalInterface
public interface TypeConverter {
    public Object convert(Type var1, Object var2);
}


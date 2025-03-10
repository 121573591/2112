/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.reflect.Modifier
 *  java.util.HashMap
 */
package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class SimpleAbstractTypeResolver
extends AbstractTypeResolver
implements Serializable {
    private static final long serialVersionUID = 1L;
    protected final HashMap<ClassKey, Class<?>> _mappings = new HashMap();

    public <T> SimpleAbstractTypeResolver addMapping(Class<T> superType, Class<? extends T> subType) {
        if (superType == subType) {
            throw new IllegalArgumentException("Cannot add mapping from class to itself");
        }
        if (!superType.isAssignableFrom(subType)) {
            throw new IllegalArgumentException("Cannot add mapping from class " + superType.getName() + " to " + subType.getName() + ", as latter is not a subtype of former");
        }
        if (!Modifier.isAbstract((int)superType.getModifiers())) {
            throw new IllegalArgumentException("Cannot add mapping from class " + superType.getName() + " since it is not abstract");
        }
        this._mappings.put((Object)new ClassKey(superType), subType);
        return this;
    }

    @Override
    public JavaType findTypeMapping(DeserializationConfig config, JavaType type) {
        Class<?> src = type.getRawClass();
        Class dst = (Class)this._mappings.get((Object)new ClassKey(src));
        if (dst == null) {
            return null;
        }
        return config.getTypeFactory().constructSpecializedType(type, dst);
    }

    @Override
    @Deprecated
    public JavaType resolveAbstractType(DeserializationConfig config, JavaType type) {
        return null;
    }

    @Override
    public JavaType resolveAbstractType(DeserializationConfig config, BeanDescription typeDesc) {
        return null;
    }
}


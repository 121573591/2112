/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 */
package com.fasterxml.jackson.core.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeReference<T>
implements Comparable<TypeReference<T>> {
    protected final Type _type;

    protected TypeReference() {
        Type superClass = this.getClass().getGenericSuperclass();
        if (superClass instanceof Class) {
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        this._type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
    }

    public Type getType() {
        return this._type;
    }

    public int compareTo(TypeReference<T> o) {
        return 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.reflect.Type
 *  java.util.Collection
 */
package cn.hutool.core.convert.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Converter;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.TypeUtil;
import java.lang.reflect.Type;
import java.util.Collection;

public class CollectionConverter
implements Converter<Collection<?>> {
    private final Type collectionType;
    private final Type elementType;

    public CollectionConverter() {
        this(Collection.class);
    }

    public CollectionConverter(Type collectionType) {
        this(collectionType, TypeUtil.getTypeArgument(collectionType));
    }

    public CollectionConverter(Class<?> collectionType) {
        this((Type)collectionType, TypeUtil.getTypeArgument(collectionType));
    }

    public CollectionConverter(Type collectionType, Type elementType) {
        this.collectionType = collectionType;
        this.elementType = elementType;
    }

    @Override
    public Collection<?> convert(Object value, Collection<?> defaultValue) throws IllegalArgumentException {
        Collection<?> result = this.convertInternal(value);
        return ObjectUtil.defaultIfNull(result, defaultValue);
    }

    protected Collection<?> convertInternal(Object value) {
        Collection<?> collection = CollUtil.create(TypeUtil.getClass(this.collectionType), TypeUtil.getClass(this.elementType));
        return CollUtil.addAll(collection, value, this.elementType);
    }
}


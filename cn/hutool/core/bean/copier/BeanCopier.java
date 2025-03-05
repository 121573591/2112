/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.reflect.Type
 *  java.util.Map
 */
package cn.hutool.core.bean.copier;

import cn.hutool.core.bean.copier.AbsCopier;
import cn.hutool.core.bean.copier.BeanToBeanCopier;
import cn.hutool.core.bean.copier.BeanToMapCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.bean.copier.MapToBeanCopier;
import cn.hutool.core.bean.copier.MapToMapCopier;
import cn.hutool.core.bean.copier.ValueProvider;
import cn.hutool.core.bean.copier.ValueProviderToBeanCopier;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.copier.Copier;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

public class BeanCopier<T>
implements Copier<T>,
Serializable {
    private static final long serialVersionUID = 1L;
    private final Copier<T> copier;

    public static <T> BeanCopier<T> create(Object source2, T target, CopyOptions copyOptions) {
        return BeanCopier.create(source2, target, (Type)target.getClass(), copyOptions);
    }

    public static <T> BeanCopier<T> create(Object source2, T target, Type destType, CopyOptions copyOptions) {
        return new BeanCopier<T>(source2, target, destType, copyOptions);
    }

    public BeanCopier(Object source2, T target, Type targetType, CopyOptions copyOptions) {
        Assert.notNull(source2, "Source bean must be not null!", new Object[0]);
        Assert.notNull(target, "Target bean must be not null!", new Object[0]);
        AbsCopier copier = source2 instanceof Map ? (target instanceof Map ? new MapToMapCopier((Map)source2, (Map)target, targetType, copyOptions) : new MapToBeanCopier<T>((Map)source2, target, targetType, copyOptions)) : (source2 instanceof ValueProvider ? new ValueProviderToBeanCopier<T>((ValueProvider)source2, target, targetType, copyOptions) : (target instanceof Map ? new BeanToMapCopier(source2, (Map)target, targetType, copyOptions) : new BeanToBeanCopier<Object, T>(source2, target, targetType, copyOptions)));
        this.copier = copier;
    }

    @Override
    public T copy() {
        return this.copier.copy();
    }
}


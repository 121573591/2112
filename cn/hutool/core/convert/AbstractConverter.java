/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 */
package cn.hutool.core.convert;

import cn.hutool.core.convert.Converter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.util.Map;

public abstract class AbstractConverter<T>
implements Converter<T>,
Serializable {
    private static final long serialVersionUID = 1L;

    public T convertQuietly(Object value, T defaultValue) {
        try {
            return this.convert(value, defaultValue);
        }
        catch (Exception e) {
            return defaultValue;
        }
    }

    @Override
    public T convert(Object value, T defaultValue) {
        Class targetType = this.getTargetType();
        if (null == targetType && null == defaultValue) {
            throw new NullPointerException(StrUtil.format("[type] and [defaultValue] are both null for Converter [{}], we can not know what type to convert !", this.getClass().getName()));
        }
        if (null == targetType) {
            targetType = defaultValue.getClass();
        }
        if (null == value) {
            return defaultValue;
        }
        if (null == defaultValue || targetType.isInstance(defaultValue)) {
            if (targetType.isInstance(value) && !Map.class.isAssignableFrom(targetType)) {
                return (T)targetType.cast(value);
            }
            T result = this.convertInternal(value);
            return null == result ? defaultValue : result;
        }
        throw new IllegalArgumentException(StrUtil.format("Default value [{}]({}) is not the instance of [{}]", defaultValue, defaultValue.getClass(), targetType));
    }

    protected abstract T convertInternal(Object var1);

    protected String convertToStr(Object value) {
        if (null == value) {
            return null;
        }
        if (value instanceof CharSequence) {
            return value.toString();
        }
        if (ArrayUtil.isArray(value)) {
            return ArrayUtil.toString(value);
        }
        if (CharUtil.isChar(value)) {
            return CharUtil.toString(((Character)value).charValue());
        }
        return value.toString();
    }

    public Class<T> getTargetType() {
        return ClassUtil.getTypeArgument(this.getClass());
    }
}


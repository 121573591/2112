/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package cn.hutool.setting;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.bean.copier.ValueProvider;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.getter.OptNullBasicTypeFromStringGetter;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import java.io.Serializable;
import java.lang.reflect.Type;

public abstract class AbsSetting
implements OptNullBasicTypeFromStringGetter<String>,
Serializable {
    private static final long serialVersionUID = 6200156302595905863L;
    private static final Log log = LogFactory.get();
    public static final String DEFAULT_DELIMITER = ",";
    public static final String DEFAULT_GROUP = "";

    @Override
    public String getStr(String key, String defaultValue) {
        return this.getStr(key, DEFAULT_GROUP, defaultValue);
    }

    public String getStr(String key, String group, String defaultValue) {
        String value = this.getByGroup(key, group);
        return ObjectUtil.defaultIfNull(value, defaultValue);
    }

    public String getStrNotEmpty(String key, String group, String defaultValue) {
        String value = this.getByGroup(key, group);
        return ObjectUtil.defaultIfEmpty(value, defaultValue);
    }

    public abstract String getByGroup(String var1, String var2);

    public String getWithLog(String key) {
        String value = this.getStr(key);
        if (value == null) {
            log.debug("No key define for [{}]!", new Object[]{key});
        }
        return value;
    }

    public String getByGroupWithLog(String key, String group) {
        String value = this.getByGroup(key, group);
        if (value == null) {
            log.debug("No key define for [{}] of group [{}] !", new Object[]{key, group});
        }
        return value;
    }

    public String[] getStrings(String key) {
        return this.getStrings(key, null);
    }

    public String[] getStringsWithDefault(String key, String[] defaultValue) {
        String[] value = this.getStrings(key, null);
        if (null == value) {
            value = defaultValue;
        }
        return value;
    }

    public String[] getStrings(String key, String group) {
        return this.getStrings(key, group, DEFAULT_DELIMITER);
    }

    public String[] getStrings(String key, String group, String delimiter) {
        String value = this.getByGroup(key, group);
        if (StrUtil.isBlank(value)) {
            return null;
        }
        return StrUtil.splitToArray((CharSequence)value, delimiter);
    }

    public Integer getInt(String key, String group) {
        return this.getInt(key, group, null);
    }

    public Integer getInt(String key, String group, Integer defaultValue) {
        return Convert.toInt(this.getByGroup(key, group), defaultValue);
    }

    public Boolean getBool(String key, String group) {
        return this.getBool(key, group, null);
    }

    public Boolean getBool(String key, String group, Boolean defaultValue) {
        return Convert.toBool(this.getByGroup(key, group), defaultValue);
    }

    public Long getLong(String key, String group) {
        return this.getLong(key, group, null);
    }

    public Long getLong(String key, String group, Long defaultValue) {
        return Convert.toLong(this.getByGroup(key, group), defaultValue);
    }

    public Character getChar(String key, String group) {
        String value = this.getByGroup(key, group);
        if (StrUtil.isBlank(value)) {
            return null;
        }
        return Character.valueOf((char)value.charAt(0));
    }

    public Double getDouble(String key, String group) {
        return this.getDouble(key, group, null);
    }

    public Double getDouble(String key, String group, Double defaultValue) {
        return Convert.toDouble(this.getByGroup(key, group), defaultValue);
    }

    public <T> T toBean(final String group, T bean) {
        return BeanUtil.fillBean(bean, new ValueProvider<String>(){

            @Override
            public Object value(String key, Type valueType) {
                return AbsSetting.this.getByGroup(key, group);
            }

            @Override
            public boolean containsKey(String key) {
                return null != AbsSetting.this.getByGroup(key, group);
            }
        }, CopyOptions.create());
    }

    public <T> T toBean(String group, Class<T> beanClass) {
        return this.toBean(group, ReflectUtil.newInstanceIfPossible(beanClass));
    }

    public <T> T toBean(T bean) {
        return this.toBean(null, bean);
    }

    public <T> T toBean(Class<T> beanClass) {
        return this.toBean((String)null, beanClass);
    }
}


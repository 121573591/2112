/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 */
package cn.hutool.core.bean.copier.provider;

import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.bean.copier.ValueProvider;
import cn.hutool.core.convert.Convert;
import java.lang.reflect.Type;

public class DynaBeanValueProvider
implements ValueProvider<String> {
    private final DynaBean dynaBean;
    private final boolean ignoreError;

    public DynaBeanValueProvider(DynaBean dynaBean, boolean ignoreError) {
        this.dynaBean = dynaBean;
        this.ignoreError = ignoreError;
    }

    @Override
    public Object value(String key, Type valueType) {
        Object value = this.dynaBean.get(key);
        return Convert.convertWithCheck(valueType, value, null, this.ignoreError);
    }

    @Override
    public boolean containsKey(String key) {
        return this.dynaBean.containsProp(key);
    }
}


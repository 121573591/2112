/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.function.Function
 */
package cn.hutool.core.bean.copier.provider;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.PropDesc;
import cn.hutool.core.bean.copier.ValueProvider;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.map.FuncKeyMap;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BeanValueProvider
implements ValueProvider<String> {
    private final Object source;
    private final boolean ignoreError;
    final Map<String, PropDesc> sourcePdMap;

    public BeanValueProvider(Object bean, boolean ignoreCase, boolean ignoreError) {
        this(bean, ignoreCase, ignoreError, null);
    }

    public BeanValueProvider(Object bean, boolean ignoreCase, boolean ignoreError, Editor<String> keyEditor) {
        this.source = bean;
        this.ignoreError = ignoreError;
        Map<String, PropDesc> sourcePdMap = BeanUtil.getBeanDesc(this.source.getClass()).getPropMap(ignoreCase);
        this.sourcePdMap = new FuncKeyMap<String, PropDesc>((Map<String, PropDesc>)new HashMap(sourcePdMap.size(), 1.0f), (Function<Object, String>)(Function & Serializable)key -> {
            if (ignoreCase && key instanceof CharSequence) {
                key = key.toString().toLowerCase();
            }
            if (null != keyEditor) {
                key = keyEditor.edit(key.toString());
            }
            return key.toString();
        });
        this.sourcePdMap.putAll(sourcePdMap);
    }

    @Override
    public Object value(String key, Type valueType) {
        PropDesc sourcePd = this.getPropDesc(key, valueType);
        Object result = null;
        if (null != sourcePd) {
            result = sourcePd.getValue(this.source, valueType, this.ignoreError);
        }
        return result;
    }

    @Override
    public boolean containsKey(String key) {
        PropDesc sourcePd = this.getPropDesc(key, null);
        return null != sourcePd && sourcePd.isReadable(false);
    }

    private PropDesc getPropDesc(String key, Type valueType) {
        PropDesc sourcePd = (PropDesc)this.sourcePdMap.get((Object)key);
        if (null == sourcePd && (null == valueType || Boolean.class == valueType || Boolean.TYPE == valueType)) {
            sourcePd = (PropDesc)this.sourcePdMap.get((Object)StrUtil.upperFirstAndAddPre(key, "is"));
        }
        return sourcePd;
    }
}


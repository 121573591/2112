/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.Map
 *  java.util.Set
 *  java.util.function.BiFunction
 *  java.util.function.BiPredicate
 */
package cn.hutool.core.bean.copier;

import cn.hutool.core.bean.PropDesc;
import cn.hutool.core.bean.copier.IJSONTypeConverter;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.TypeConverter;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.func.LambdaUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class CopyOptions
implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Class<?> editable;
    protected boolean ignoreNullValue;
    private BiPredicate<Field, Object> propertiesFilter;
    protected boolean ignoreError;
    protected boolean ignoreCase;
    private Editor<String> fieldNameEditor;
    protected BiFunction<String, Object, Object> fieldValueEditor;
    protected boolean transientSupport = true;
    protected boolean override = true;
    protected boolean autoTransCamelCase = true;
    private Set<String> ignoreKeySet;
    protected TypeConverter converter = (type, value) -> {
        if (null == value) {
            return null;
        }
        if (value instanceof IJSONTypeConverter) {
            return ((IJSONTypeConverter)value).toBean((Type)ObjectUtil.defaultIfNull(type, Object.class));
        }
        return Convert.convertWithCheck(type, value, null, this.ignoreError);
    };

    public static CopyOptions create() {
        return new CopyOptions();
    }

    public static CopyOptions create(Class<?> editable, boolean ignoreNullValue, String ... ignoreProperties) {
        return new CopyOptions(editable, ignoreNullValue, ignoreProperties);
    }

    public CopyOptions() {
    }

    public CopyOptions(Class<?> editable, boolean ignoreNullValue, String ... ignoreProperties) {
        this.propertiesFilter = (f, v) -> true;
        this.editable = editable;
        this.ignoreNullValue = ignoreNullValue;
        this.setIgnoreProperties(ignoreProperties);
    }

    public CopyOptions setEditable(Class<?> editable) {
        this.editable = editable;
        return this;
    }

    public CopyOptions setIgnoreNullValue(boolean ignoreNullVall) {
        this.ignoreNullValue = ignoreNullVall;
        return this;
    }

    public CopyOptions ignoreNullValue() {
        return this.setIgnoreNullValue(true);
    }

    public CopyOptions setPropertiesFilter(BiPredicate<Field, Object> propertiesFilter) {
        this.propertiesFilter = propertiesFilter;
        return this;
    }

    public CopyOptions setIgnoreProperties(String ... ignoreProperties) {
        this.ignoreKeySet = CollUtil.newHashSet(ignoreProperties);
        return this;
    }

    public <P, R> CopyOptions setIgnoreProperties(Func1<P, R> ... funcs) {
        this.ignoreKeySet = ArrayUtil.mapToSet(funcs, LambdaUtil::getFieldName);
        return this;
    }

    public CopyOptions setIgnoreError(boolean ignoreError) {
        this.ignoreError = ignoreError;
        return this;
    }

    public CopyOptions ignoreError() {
        return this.setIgnoreError(true);
    }

    public CopyOptions setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
        return this;
    }

    public CopyOptions ignoreCase() {
        return this.setIgnoreCase(true);
    }

    public CopyOptions setFieldMapping(Map<String, String> fieldMapping) {
        return this.setFieldNameEditor(key -> (String)fieldMapping.getOrDefault(key, key));
    }

    public CopyOptions setFieldNameEditor(Editor<String> fieldNameEditor) {
        this.fieldNameEditor = fieldNameEditor;
        return this;
    }

    public CopyOptions setFieldValueEditor(BiFunction<String, Object, Object> fieldValueEditor) {
        this.fieldValueEditor = fieldValueEditor;
        return this;
    }

    protected Object editFieldValue(String fieldName, Object fieldValue) {
        return null != this.fieldValueEditor ? this.fieldValueEditor.apply((Object)fieldName, fieldValue) : fieldValue;
    }

    public CopyOptions setTransientSupport(boolean transientSupport) {
        this.transientSupport = transientSupport;
        return this;
    }

    public CopyOptions setOverride(boolean override) {
        this.override = override;
        return this;
    }

    public CopyOptions setAutoTransCamelCase(boolean autoTransCamelCase) {
        this.autoTransCamelCase = autoTransCamelCase;
        return this;
    }

    public CopyOptions setConverter(TypeConverter converter) {
        this.converter = converter;
        return this;
    }

    protected Object convertField(Type targetType, Object fieldValue) {
        return null != this.converter ? this.converter.convert(targetType, fieldValue) : fieldValue;
    }

    protected String editFieldName(String fieldName) {
        return null != this.fieldNameEditor ? this.fieldNameEditor.edit(fieldName) : fieldName;
    }

    protected boolean testPropertyFilter(Field field, Object value) {
        return null == this.propertiesFilter || this.propertiesFilter.test((Object)field, value);
    }

    protected boolean testKeyFilter(Object key) {
        if (CollUtil.isEmpty(this.ignoreKeySet)) {
            return true;
        }
        if (this.ignoreCase) {
            for (String ignoreKey : this.ignoreKeySet) {
                if (!StrUtil.equalsIgnoreCase(key.toString(), ignoreKey)) continue;
                return false;
            }
        }
        return false == this.ignoreKeySet.contains(key);
    }

    protected PropDesc findPropDesc(Map<String, PropDesc> targetPropDescMap, String sKeyStr) {
        String camelCaseKey;
        PropDesc propDesc = (PropDesc)targetPropDescMap.get((Object)sKeyStr);
        if (null == propDesc && this.autoTransCamelCase && !StrUtil.equals(sKeyStr, camelCaseKey = StrUtil.toCamelCase(sKeyStr))) {
            propDesc = (PropDesc)targetPropDescMap.get((Object)camelCaseKey);
        }
        return propDesc;
    }
}


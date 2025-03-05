/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.beans.BeanInfo
 *  java.beans.IntrospectionException
 *  java.beans.Introspector
 *  java.beans.PropertyDescriptor
 *  java.beans.PropertyEditor
 *  java.beans.PropertyEditorManager
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.function.Consumer
 *  java.util.function.Supplier
 *  java.util.stream.Collectors
 */
package cn.hutool.core.bean;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanDescCache;
import cn.hutool.core.bean.BeanException;
import cn.hutool.core.bean.BeanInfoCache;
import cn.hutool.core.bean.BeanPath;
import cn.hutool.core.bean.DynaBean;
import cn.hutool.core.bean.PropDesc;
import cn.hutool.core.bean.copier.BeanCopier;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.bean.copier.ValueProvider;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Editor;
import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ModifierUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BeanUtil {
    public static boolean isReadableBean(Class<?> clazz) {
        return BeanUtil.hasGetter(clazz) || BeanUtil.hasPublicField(clazz);
    }

    public static boolean isBean(Class<?> clazz) {
        return BeanUtil.hasSetter(clazz) || BeanUtil.hasPublicField(clazz);
    }

    public static boolean hasSetter(Class<?> clazz) {
        if (ClassUtil.isNormalClass(clazz)) {
            for (Method method : clazz.getMethods()) {
                if (method.getParameterCount() != 1 || !method.getName().startsWith("set")) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean hasGetter(Class<?> clazz) {
        if (ClassUtil.isNormalClass(clazz)) {
            for (Method method : clazz.getMethods()) {
                String name;
                if (method.getParameterCount() != 0 || !(name = method.getName()).startsWith("get") && !name.startsWith("is") || "getClass".equals((Object)name)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean hasPublicField(Class<?> clazz) {
        if (ClassUtil.isNormalClass(clazz)) {
            for (Field field : clazz.getFields()) {
                if (!ModifierUtil.isPublic(field) || ModifierUtil.isStatic(field)) continue;
                return true;
            }
        }
        return false;
    }

    public static DynaBean createDynaBean(Object bean) {
        return new DynaBean(bean);
    }

    public static PropertyEditor findEditor(Class<?> type) {
        return PropertyEditorManager.findEditor(type);
    }

    public static BeanDesc getBeanDesc(Class<?> clazz) {
        return BeanDescCache.INSTANCE.getBeanDesc(clazz, () -> new BeanDesc(clazz));
    }

    public static void descForEach(Class<?> clazz, Consumer<? super PropDesc> action) {
        BeanUtil.getBeanDesc(clazz).getProps().forEach(action);
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) throws BeanException {
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
        }
        catch (IntrospectionException e) {
            throw new BeanException(e);
        }
        return ArrayUtil.filter(beanInfo.getPropertyDescriptors(), t -> false == "class".equals((Object)t.getName()));
    }

    public static Map<String, PropertyDescriptor> getPropertyDescriptorMap(Class<?> clazz, boolean ignoreCase) throws BeanException {
        return BeanInfoCache.INSTANCE.getPropertyDescriptorMap(clazz, ignoreCase, () -> BeanUtil.internalGetPropertyDescriptorMap(clazz, ignoreCase));
    }

    private static Map<String, PropertyDescriptor> internalGetPropertyDescriptorMap(Class<?> clazz, boolean ignoreCase) throws BeanException {
        PropertyDescriptor[] propertyDescriptors = BeanUtil.getPropertyDescriptors(clazz);
        CaseInsensitiveMap<String, PropertyDescriptor> map = ignoreCase ? new CaseInsensitiveMap<String, PropertyDescriptor>(propertyDescriptors.length, 1.0f) : new HashMap(propertyDescriptors.length, 1.0f);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            map.put(propertyDescriptor.getName(), propertyDescriptor);
        }
        return map;
    }

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String fieldName) throws BeanException {
        return BeanUtil.getPropertyDescriptor(clazz, fieldName, false);
    }

    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String fieldName, boolean ignoreCase) throws BeanException {
        Map<String, PropertyDescriptor> map = BeanUtil.getPropertyDescriptorMap(clazz, ignoreCase);
        return null == map ? null : (PropertyDescriptor)map.get((Object)fieldName);
    }

    public static Object getFieldValue(Object bean, String fieldNameOrIndex) {
        if (null == bean || null == fieldNameOrIndex) {
            return null;
        }
        if (bean instanceof Map) {
            return ((Map)bean).get((Object)fieldNameOrIndex);
        }
        if (bean instanceof Collection) {
            try {
                return CollUtil.get((Collection)bean, Integer.parseInt((String)fieldNameOrIndex));
            }
            catch (NumberFormatException e) {
                return CollUtil.map((Collection)bean, beanEle -> BeanUtil.getFieldValue(beanEle, fieldNameOrIndex), false);
            }
        }
        if (ArrayUtil.isArray(bean)) {
            try {
                return ArrayUtil.get(bean, Integer.parseInt((String)fieldNameOrIndex));
            }
            catch (NumberFormatException e) {
                return ArrayUtil.map(bean, Object.class, beanEle -> BeanUtil.getFieldValue(beanEle, fieldNameOrIndex));
            }
        }
        return ReflectUtil.getFieldValue(bean, fieldNameOrIndex);
    }

    public static Object setFieldValue(Object bean, String fieldNameOrIndex, Object value) {
        if (bean instanceof Map) {
            ((Map)bean).put((Object)fieldNameOrIndex, value);
        } else if (bean instanceof List) {
            ListUtil.setOrPadding((List)bean, Convert.toInt(fieldNameOrIndex), value);
        } else {
            if (ArrayUtil.isArray(bean)) {
                return ArrayUtil.setOrAppend(bean, (int)Convert.toInt(fieldNameOrIndex), value);
            }
            ReflectUtil.setFieldValue(bean, fieldNameOrIndex, value);
        }
        return bean;
    }

    public static <T> T getProperty(Object bean, String expression) {
        if (null == bean || StrUtil.isBlank(expression)) {
            return null;
        }
        return (T)BeanPath.create(expression).get(bean);
    }

    public static void setProperty(Object bean, String expression, Object value) {
        BeanPath.create(expression).set(bean, value);
    }

    @Deprecated
    public static <T> T mapToBean(Map<?, ?> map, Class<T> beanClass, boolean isIgnoreError) {
        return BeanUtil.fillBeanWithMap(map, ReflectUtil.newInstanceIfPossible(beanClass), isIgnoreError);
    }

    @Deprecated
    public static <T> T mapToBeanIgnoreCase(Map<?, ?> map, Class<T> beanClass, boolean isIgnoreError) {
        return BeanUtil.fillBeanWithMapIgnoreCase(map, ReflectUtil.newInstanceIfPossible(beanClass), isIgnoreError);
    }

    @Deprecated
    public static <T> T mapToBean(Map<?, ?> map, Class<T> beanClass, CopyOptions copyOptions) {
        return BeanUtil.fillBeanWithMap(map, ReflectUtil.newInstanceIfPossible(beanClass), copyOptions);
    }

    @Deprecated
    public static <T> T mapToBean(Map<?, ?> map, Class<T> beanClass, boolean isToCamelCase, CopyOptions copyOptions) {
        return BeanUtil.fillBeanWithMap(map, ReflectUtil.newInstanceIfPossible(beanClass), isToCamelCase, copyOptions);
    }

    public static <T> T fillBeanWithMap(Map<?, ?> map, T bean, boolean isIgnoreError) {
        return BeanUtil.fillBeanWithMap(map, bean, false, isIgnoreError);
    }

    @Deprecated
    public static <T> T fillBeanWithMap(Map<?, ?> map, T bean, boolean isToCamelCase, boolean isIgnoreError) {
        return BeanUtil.fillBeanWithMap(map, bean, isToCamelCase, CopyOptions.create().setIgnoreError(isIgnoreError));
    }

    public static <T> T fillBeanWithMapIgnoreCase(Map<?, ?> map, T bean, boolean isIgnoreError) {
        return BeanUtil.fillBeanWithMap(map, bean, CopyOptions.create().setIgnoreCase(true).setIgnoreError(isIgnoreError));
    }

    public static <T> T fillBeanWithMap(Map<?, ?> map, T bean, CopyOptions copyOptions) {
        if (MapUtil.isEmpty(map)) {
            return bean;
        }
        BeanUtil.copyProperties(map, bean, copyOptions);
        return bean;
    }

    @Deprecated
    public static <T> T fillBeanWithMap(Map<?, ?> map, T bean, boolean isToCamelCase, CopyOptions copyOptions) {
        if (MapUtil.isEmpty(map)) {
            return bean;
        }
        BeanUtil.copyProperties(map, bean, copyOptions);
        return bean;
    }

    public static <T> T toBean(Object source2, Class<T> clazz) {
        return BeanUtil.toBean(source2, clazz, null);
    }

    public static <T> T toBeanIgnoreError(Object source2, Class<T> clazz) {
        return BeanUtil.toBean(source2, clazz, CopyOptions.create().setIgnoreError(true));
    }

    public static <T> T toBeanIgnoreCase(Object source2, Class<T> clazz, boolean ignoreError) {
        return BeanUtil.toBean(source2, clazz, CopyOptions.create().setIgnoreCase(true).setIgnoreError(ignoreError));
    }

    public static <T> T toBean(Object source2, Class<T> clazz, CopyOptions options) {
        return BeanUtil.toBean(source2, () -> ReflectUtil.newInstanceIfPossible(clazz), options);
    }

    public static <T> T toBean(Object source2, Supplier<T> targetSupplier, CopyOptions options) {
        if (null == source2 || null == targetSupplier) {
            return null;
        }
        Object target = targetSupplier.get();
        BeanUtil.copyProperties(source2, target, options);
        return (T)target;
    }

    public static <T> T toBean(Class<T> beanClass, ValueProvider<String> valueProvider, CopyOptions copyOptions) {
        if (null == beanClass || null == valueProvider) {
            return null;
        }
        return BeanUtil.fillBean(ReflectUtil.newInstanceIfPossible(beanClass), valueProvider, copyOptions);
    }

    public static <T> T fillBean(T bean, ValueProvider<String> valueProvider, CopyOptions copyOptions) {
        if (null == valueProvider) {
            return bean;
        }
        return BeanCopier.create(valueProvider, bean, copyOptions).copy();
    }

    public static Map<String, Object> beanToMap(Object bean, String ... properties) {
        int mapSize = 16;
        Editor<String> keyEditor = null;
        if (ArrayUtil.isNotEmpty(properties)) {
            mapSize = properties.length;
            HashSet<String> propertiesSet = CollUtil.set(false, properties);
            keyEditor = property -> propertiesSet.contains(property) ? property : null;
        }
        return BeanUtil.beanToMap(bean, (Map<String, Object>)new LinkedHashMap(mapSize, 1.0f), false, keyEditor);
    }

    public static Map<String, Object> beanToMap(Object bean, boolean isToUnderlineCase, boolean ignoreNullValue) {
        if (null == bean) {
            return null;
        }
        return BeanUtil.beanToMap(bean, (Map<String, Object>)new LinkedHashMap(), isToUnderlineCase, ignoreNullValue);
    }

    public static Map<String, Object> beanToMap(Object bean, Map<String, Object> targetMap, boolean isToUnderlineCase, boolean ignoreNullValue) {
        if (null == bean) {
            return null;
        }
        return BeanUtil.beanToMap(bean, targetMap, ignoreNullValue, (String key) -> isToUnderlineCase ? StrUtil.toUnderlineCase(key) : key);
    }

    public static Map<String, Object> beanToMap(Object bean, Map<String, Object> targetMap, boolean ignoreNullValue, Editor<String> keyEditor) {
        if (null == bean) {
            return null;
        }
        return BeanCopier.create(bean, targetMap, CopyOptions.create().setIgnoreNullValue(ignoreNullValue).setFieldNameEditor(keyEditor)).copy();
    }

    public static Map<String, Object> beanToMap(Object bean, Map<String, Object> targetMap, CopyOptions copyOptions) {
        if (null == bean) {
            return null;
        }
        return BeanCopier.create(bean, targetMap, copyOptions).copy();
    }

    public static <T> T copyProperties(Object source2, Class<T> tClass, String ... ignoreProperties) {
        if (null == source2) {
            return null;
        }
        T target = ReflectUtil.newInstanceIfPossible(tClass);
        BeanUtil.copyProperties(source2, target, CopyOptions.create().setIgnoreProperties(ignoreProperties));
        return target;
    }

    public static void copyProperties(Object source2, Object target, String ... ignoreProperties) {
        BeanUtil.copyProperties(source2, target, CopyOptions.create().setIgnoreProperties(ignoreProperties));
    }

    public static void copyProperties(Object source2, Object target, boolean ignoreCase) {
        BeanCopier.create(source2, target, CopyOptions.create().setIgnoreCase(ignoreCase)).copy();
    }

    public static void copyProperties(Object source2, Object target, CopyOptions copyOptions) {
        if (null == source2) {
            return;
        }
        BeanCopier.create(source2, target, ObjectUtil.defaultIfNull(copyOptions, CopyOptions::create)).copy();
    }

    public static <T> List<T> copyToList(Collection<?> collection, Class<T> targetType, CopyOptions copyOptions) {
        if (null == collection) {
            return null;
        }
        if (collection.isEmpty()) {
            return new ArrayList(0);
        }
        if (ClassUtil.isBasicType(targetType) || String.class == targetType) {
            return Convert.toList(targetType, collection);
        }
        return (List)collection.stream().map(source2 -> {
            Object target = ReflectUtil.newInstanceIfPossible(targetType);
            BeanUtil.copyProperties(source2, target, copyOptions);
            return target;
        }).collect(Collectors.toList());
    }

    public static <T> List<T> copyToList(Collection<?> collection, Class<T> targetType) {
        return BeanUtil.copyToList(collection, targetType, CopyOptions.create());
    }

    public static boolean isMatchName(Object bean, String beanClassName, boolean isSimple) {
        if (null == bean || StrUtil.isBlank(beanClassName)) {
            return false;
        }
        return ClassUtil.getClassName(bean, isSimple).equals((Object)(isSimple ? StrUtil.upperFirst(beanClassName) : beanClassName));
    }

    public static <T> T edit(T bean, Editor<Field> editor) {
        Field[] fields;
        if (bean == null) {
            return null;
        }
        for (Field field : fields = ReflectUtil.getFields(bean.getClass())) {
            if (ModifierUtil.isStatic(field)) continue;
            editor.edit(field);
        }
        return bean;
    }

    public static <T> T trimStrFields(T bean, String ... ignoreFields) {
        return BeanUtil.edit(bean, field -> {
            String trimVal;
            String val;
            if (ignoreFields != null && ArrayUtil.containsIgnoreCase(ignoreFields, field.getName())) {
                return field;
            }
            if (String.class.equals((Object)field.getType()) && null != (val = (String)ReflectUtil.getFieldValue(bean, field)) && !val.equals((Object)(trimVal = StrUtil.trim(val)))) {
                ReflectUtil.setFieldValue(bean, field, (Object)trimVal);
            }
            return field;
        });
    }

    public static boolean isNotEmpty(Object bean, String ... ignoreFieldNames) {
        return false == BeanUtil.isEmpty(bean, ignoreFieldNames);
    }

    public static boolean isEmpty(Object bean, String ... ignoreFieldNames) {
        if (null != bean) {
            for (Field field : ReflectUtil.getFields(bean.getClass())) {
                if (ModifierUtil.isStatic(field) || ArrayUtil.contains(ignoreFieldNames, field.getName()) || null == ReflectUtil.getFieldValue(bean, field)) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean hasNullField(Object bean, String ... ignoreFieldNames) {
        if (null == bean) {
            return true;
        }
        for (Field field : ReflectUtil.getFields(bean.getClass())) {
            if (ModifierUtil.isStatic(field) || ArrayUtil.contains(ignoreFieldNames, field.getName()) || null != ReflectUtil.getFieldValue(bean, field)) continue;
            return true;
        }
        return false;
    }

    public static String getFieldName(String getterOrSetterName) {
        if (getterOrSetterName.startsWith("get") || getterOrSetterName.startsWith("set")) {
            return StrUtil.removePreAndLowerFirst((CharSequence)getterOrSetterName, 3);
        }
        if (getterOrSetterName.startsWith("is")) {
            return StrUtil.removePreAndLowerFirst((CharSequence)getterOrSetterName, 2);
        }
        throw new IllegalArgumentException("Invalid Getter or Setter name: " + getterOrSetterName);
    }

    public static boolean isCommonFieldsEqual(Object source2, Object target, String ... ignoreProperties) {
        if (null == source2 && null == target) {
            return true;
        }
        if (null == source2 || null == target) {
            return false;
        }
        Map<String, Object> sourceFieldsMap = BeanUtil.beanToMap(source2, new String[0]);
        Map<String, Object> targetFieldsMap = BeanUtil.beanToMap(target, new String[0]);
        Set sourceFields = sourceFieldsMap.keySet();
        sourceFields.removeAll((Collection)Arrays.asList((Object[])ignoreProperties));
        for (String field : sourceFields) {
            if (!sourceFieldsMap.containsKey((Object)field) || !targetFieldsMap.containsKey((Object)field) || !ObjectUtil.notEqual(sourceFieldsMap.get((Object)field), targetFieldsMap.get((Object)field))) continue;
            return false;
        }
        return true;
    }
}


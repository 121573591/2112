/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Array
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Type
 *  java.util.AbstractMap
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package cn.hutool.core.util;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.bean.NullWrapperBean;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.UniqueKeySet;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.exceptions.InvocationTargetRuntimeException;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.lang.reflect.MethodHandleUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.map.WeakConcurrentMap;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ModifierUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReflectUtil {
    private static final WeakConcurrentMap<Class<?>, Constructor<?>[]> CONSTRUCTORS_CACHE = new WeakConcurrentMap();
    private static final WeakConcurrentMap<Class<?>, Field[]> FIELDS_CACHE = new WeakConcurrentMap();
    private static final WeakConcurrentMap<Class<?>, Method[]> METHODS_CACHE = new WeakConcurrentMap();

    public static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?> ... parameterTypes) {
        Constructor<T>[] constructors;
        if (null == clazz) {
            return null;
        }
        for (Constructor<T> constructor : constructors = ReflectUtil.getConstructors(clazz)) {
            Class[] pts = constructor.getParameterTypes();
            if (!ClassUtil.isAllAssignableFrom(pts, parameterTypes)) continue;
            ReflectUtil.setAccessible(constructor);
            return constructor;
        }
        return null;
    }

    public static <T> Constructor<T>[] getConstructors(Class<T> beanClass) throws SecurityException {
        Assert.notNull(beanClass);
        return CONSTRUCTORS_CACHE.computeIfAbsent(beanClass, () -> ReflectUtil.getConstructorsDirectly(beanClass));
    }

    public static Constructor<?>[] getConstructorsDirectly(Class<?> beanClass) throws SecurityException {
        return beanClass.getDeclaredConstructors();
    }

    public static boolean hasField(Class<?> beanClass, String name) throws SecurityException {
        return null != ReflectUtil.getField(beanClass, name);
    }

    public static String getFieldName(Field field) {
        if (null == field) {
            return null;
        }
        Alias alias = (Alias)field.getAnnotation(Alias.class);
        if (null != alias) {
            return alias.value();
        }
        return field.getName();
    }

    public static Field getField(Class<?> beanClass, String name) throws SecurityException {
        Field[] fields = ReflectUtil.getFields(beanClass);
        return ArrayUtil.firstMatch(field -> name.equals((Object)ReflectUtil.getFieldName(field)), fields);
    }

    public static Map<String, Field> getFieldMap(Class<?> beanClass) {
        Field[] fields = ReflectUtil.getFields(beanClass);
        HashMap map = MapUtil.newHashMap(fields.length, true);
        for (Field field : fields) {
            map.put((Object)field.getName(), (Object)field);
        }
        return map;
    }

    public static Field[] getFields(Class<?> beanClass) throws SecurityException {
        Assert.notNull(beanClass);
        return FIELDS_CACHE.computeIfAbsent(beanClass, () -> ReflectUtil.getFieldsDirectly(beanClass, true));
    }

    public static Field[] getFields(Class<?> beanClass, Filter<Field> fieldFilter) throws SecurityException {
        return ArrayUtil.filter(ReflectUtil.getFields(beanClass), fieldFilter);
    }

    public static Field[] getFieldsDirectly(Class<?> beanClass, boolean withSuperClassFields) throws SecurityException {
        Assert.notNull(beanClass);
        Field[] allFields = null;
        Class searchType = beanClass;
        while (searchType != null) {
            Field[] declaredFields = searchType.getDeclaredFields();
            allFields = null == allFields ? declaredFields : ArrayUtil.append(allFields, declaredFields);
            searchType = withSuperClassFields ? searchType.getSuperclass() : null;
        }
        return allFields;
    }

    public static Object getFieldValue(Object obj, String fieldName) throws UtilException {
        if (null == obj || StrUtil.isBlank(fieldName)) {
            return null;
        }
        return ReflectUtil.getFieldValue(obj, ReflectUtil.getField(obj instanceof Class ? (Class)obj : obj.getClass(), fieldName));
    }

    public static Object getStaticFieldValue(Field field) throws UtilException {
        return ReflectUtil.getFieldValue(null, field);
    }

    public static Object getFieldValue(Object obj, Field field) throws UtilException {
        Object result;
        if (null == field) {
            return null;
        }
        if (obj instanceof Class) {
            obj = null;
        }
        ReflectUtil.setAccessible(field);
        try {
            result = field.get(obj);
        }
        catch (IllegalAccessException e) {
            throw new UtilException(e, "IllegalAccess for {}.{}", field.getDeclaringClass(), field.getName());
        }
        return result;
    }

    public static Object[] getFieldsValue(Object obj) {
        return ReflectUtil.getFieldsValue(obj, null);
    }

    public static Object[] getFieldsValue(Object obj, Filter<Field> filter) {
        Field[] fields;
        if (null != obj && null != (fields = ReflectUtil.getFields(obj instanceof Class ? (Class)obj : obj.getClass(), filter))) {
            return ArrayUtil.map(fields, Object.class, field -> ReflectUtil.getFieldValue(obj, field));
        }
        return null;
    }

    public static void setFieldValue(Object obj, String fieldName, Object value) throws UtilException {
        Assert.notNull(obj);
        Assert.notBlank(fieldName);
        Field field = ReflectUtil.getField(obj instanceof Class ? (Class)obj : obj.getClass(), fieldName);
        Assert.notNull(field, "Field [{}] is not exist in [{}]", fieldName, obj.getClass().getName());
        ReflectUtil.setFieldValue(obj, field, value);
    }

    public static void setFieldValue(Object obj, Field field, Object value) throws UtilException {
        Assert.notNull(field, "Field in [{}] not exist !", obj);
        Class fieldType = field.getType();
        if (null != value) {
            Object targetValue;
            if (!fieldType.isAssignableFrom(value.getClass()) && null != (targetValue = Convert.convert(fieldType, value))) {
                value = targetValue;
            }
        } else {
            value = ClassUtil.getDefaultValue(fieldType);
        }
        ReflectUtil.setAccessible(field);
        try {
            field.set(obj instanceof Class ? null : obj, value);
        }
        catch (IllegalAccessException e) {
            throw new UtilException(e, "IllegalAccess for {}.{}", obj, field.getName());
        }
    }

    public static boolean isOuterClassField(Field field) {
        return "this$0".equals((Object)field.getName());
    }

    public static Set<String> getPublicMethodNames(Class<?> clazz) {
        HashSet methodSet = new HashSet();
        Method[] methodArray = ReflectUtil.getPublicMethods(clazz);
        if (ArrayUtil.isNotEmpty(methodArray)) {
            for (Method method : methodArray) {
                methodSet.add((Object)method.getName());
            }
        }
        return methodSet;
    }

    public static Method[] getPublicMethods(Class<?> clazz) {
        return null == clazz ? null : clazz.getMethods();
    }

    public static List<Method> getPublicMethods(Class<?> clazz, Filter<Method> filter) {
        ArrayList methodList;
        if (null == clazz) {
            return null;
        }
        Method[] methods = ReflectUtil.getPublicMethods(clazz);
        if (null != filter) {
            methodList = new ArrayList();
            for (Method method : methods) {
                if (!filter.accept(method)) continue;
                methodList.add((Object)method);
            }
        } else {
            methodList = CollUtil.newArrayList(methods);
        }
        return methodList;
    }

    public static List<Method> getPublicMethods(Class<?> clazz, Method ... excludeMethods) {
        HashSet<Method> excludeMethodSet = CollUtil.newHashSet(excludeMethods);
        return ReflectUtil.getPublicMethods(clazz, (Method method) -> false == excludeMethodSet.contains(method));
    }

    public static List<Method> getPublicMethods(Class<?> clazz, String ... excludeMethodNames) {
        HashSet<String> excludeMethodNameSet = CollUtil.newHashSet(excludeMethodNames);
        return ReflectUtil.getPublicMethods(clazz, (Method method) -> false == excludeMethodNameSet.contains((Object)method.getName()));
    }

    public static Method getPublicMethod(Class<?> clazz, String methodName, Class<?> ... paramTypes) throws SecurityException {
        try {
            return clazz.getMethod(methodName, paramTypes);
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }

    public static Method getMethodOfObj(Object obj, String methodName, Object ... args) throws SecurityException {
        if (null == obj || StrUtil.isBlank(methodName)) {
            return null;
        }
        return ReflectUtil.getMethod(obj.getClass(), methodName, ClassUtil.getClasses(args));
    }

    public static Method getMethodIgnoreCase(Class<?> clazz, String methodName, Class<?> ... paramTypes) throws SecurityException {
        return ReflectUtil.getMethod(clazz, true, methodName, paramTypes);
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?> ... paramTypes) throws SecurityException {
        return ReflectUtil.getMethod(clazz, false, methodName, paramTypes);
    }

    public static Method getMethod(Class<?> clazz, boolean ignoreCase, String methodName, Class<?> ... paramTypes) throws SecurityException {
        if (null == clazz || StrUtil.isBlank(methodName)) {
            return null;
        }
        Method res = null;
        Method[] methods = ReflectUtil.getMethods(clazz);
        if (ArrayUtil.isNotEmpty(methods)) {
            for (Method method : methods) {
                if (!StrUtil.equals(methodName, method.getName(), ignoreCase) || !ClassUtil.isAllAssignableFrom(method.getParameterTypes(), paramTypes) || res != null && !res.getReturnType().isAssignableFrom(method.getReturnType())) continue;
                res = method;
            }
        }
        return res;
    }

    public static Method getMethodByName(Class<?> clazz, String methodName) throws SecurityException {
        return ReflectUtil.getMethodByName(clazz, false, methodName);
    }

    public static Method getMethodByNameIgnoreCase(Class<?> clazz, String methodName) throws SecurityException {
        return ReflectUtil.getMethodByName(clazz, true, methodName);
    }

    public static Method getMethodByName(Class<?> clazz, boolean ignoreCase, String methodName) throws SecurityException {
        if (null == clazz || StrUtil.isBlank(methodName)) {
            return null;
        }
        Method res = null;
        Method[] methods = ReflectUtil.getMethods(clazz);
        if (ArrayUtil.isNotEmpty(methods)) {
            for (Method method : methods) {
                if (!StrUtil.equals(methodName, method.getName(), ignoreCase) || res != null && !res.getReturnType().isAssignableFrom(method.getReturnType())) continue;
                res = method;
            }
        }
        return res;
    }

    public static Set<String> getMethodNames(Class<?> clazz) throws SecurityException {
        Method[] methods;
        HashSet methodSet = new HashSet();
        for (Method method : methods = ReflectUtil.getMethods(clazz)) {
            methodSet.add((Object)method.getName());
        }
        return methodSet;
    }

    public static Method[] getMethods(Class<?> clazz, Filter<Method> filter) throws SecurityException {
        if (null == clazz) {
            return null;
        }
        return ArrayUtil.filter(ReflectUtil.getMethods(clazz), filter);
    }

    public static Method[] getMethods(Class<?> beanClass) throws SecurityException {
        Assert.notNull(beanClass);
        return METHODS_CACHE.computeIfAbsent(beanClass, () -> ReflectUtil.getMethodsDirectly(beanClass, true, true));
    }

    public static Method[] getMethodsDirectly(Class<?> beanClass, boolean withSupers, boolean withMethodFromObject) throws SecurityException {
        Assert.notNull(beanClass);
        if (beanClass.isInterface()) {
            return withSupers ? beanClass.getMethods() : beanClass.getDeclaredMethods();
        }
        UniqueKeySet result = new UniqueKeySet(true, ReflectUtil::getUniqueKey);
        Class<?> searchType = beanClass;
        while (searchType != null && (withMethodFromObject || Object.class != searchType)) {
            result.addAllIfAbsent(Arrays.asList((Object[])searchType.getDeclaredMethods()));
            result.addAllIfAbsent(ReflectUtil.getDefaultMethodsFromInterface(searchType));
            searchType = withSupers && false == searchType.isInterface() ? searchType.getSuperclass() : null;
        }
        return (Method[])result.toArray(new Method[0]);
    }

    public static boolean isEqualsMethod(Method method) {
        if (method == null || 1 != method.getParameterCount() || !"equals".equals((Object)method.getName())) {
            return false;
        }
        return method.getParameterTypes()[0] == Object.class;
    }

    public static boolean isHashCodeMethod(Method method) {
        return method != null && "hashCode".equals((Object)method.getName()) && ReflectUtil.isEmptyParam(method);
    }

    public static boolean isToStringMethod(Method method) {
        return method != null && "toString".equals((Object)method.getName()) && ReflectUtil.isEmptyParam(method);
    }

    public static boolean isEmptyParam(Method method) {
        return method.getParameterCount() == 0;
    }

    public static boolean isGetterOrSetterIgnoreCase(Method method) {
        return ReflectUtil.isGetterOrSetter(method, true);
    }

    public static boolean isGetterOrSetter(Method method, boolean ignoreCase) {
        if (null == method) {
            return false;
        }
        int parameterCount = method.getParameterCount();
        if (parameterCount > 1) {
            return false;
        }
        String name = method.getName();
        if ("getClass".equals((Object)name)) {
            return false;
        }
        if (ignoreCase) {
            name = name.toLowerCase();
        }
        switch (parameterCount) {
            case 0: {
                return name.startsWith("get") || name.startsWith("is");
            }
            case 1: {
                return name.startsWith("set");
            }
        }
        return false;
    }

    public static <T> T newInstance(String clazz) throws UtilException {
        try {
            return (T)Class.forName((String)clazz).newInstance();
        }
        catch (Exception e) {
            throw new UtilException(e, "Instance class [{}] error!", clazz);
        }
    }

    public static <T> T newInstance(Class<T> clazz, Object ... params) throws UtilException {
        if (ArrayUtil.isEmpty(params)) {
            Constructor<T> constructor = ReflectUtil.getConstructor(clazz, new Class[0]);
            if (null == constructor) {
                throw new UtilException("No constructor for [{}]", clazz);
            }
            try {
                return (T)constructor.newInstance(new Object[0]);
            }
            catch (Exception e) {
                throw new UtilException(e, "Instance class [{}] error!", clazz);
            }
        }
        Class<?>[] paramTypes = ClassUtil.getClasses(params);
        Constructor<T> constructor = ReflectUtil.getConstructor(clazz, paramTypes);
        if (null == constructor) {
            throw new UtilException("No Constructor matched for parameter types: [{}]", new Object[]{paramTypes});
        }
        try {
            return (T)constructor.newInstance(params);
        }
        catch (Exception e) {
            throw new UtilException(e, "Instance class [{}] error!", clazz);
        }
    }

    public static <T> T newInstanceIfPossible(Class<T> type) {
        Assert.notNull(type);
        if (type.isPrimitive()) {
            return (T)ClassUtil.getPrimitiveDefaultValue(type);
        }
        if (type.isAssignableFrom(AbstractMap.class)) {
            type = HashMap.class;
        } else if (type.isAssignableFrom(List.class)) {
            type = ArrayList.class;
        } else if (type.isAssignableFrom(Set.class)) {
            type = HashSet.class;
        }
        try {
            return ReflectUtil.newInstance(type, new Object[0]);
        }
        catch (Exception exception) {
            Constructor<T>[] constructors;
            if (type.isEnum()) {
                return (T)type.getEnumConstants()[0];
            }
            if (type.isArray()) {
                return (T)Array.newInstance((Class)type.getComponentType(), (int)0);
            }
            for (Constructor<T> constructor : constructors = ReflectUtil.getConstructors(type)) {
                Class[] parameterTypes = constructor.getParameterTypes();
                if (0 == parameterTypes.length) continue;
                ReflectUtil.setAccessible(constructor);
                try {
                    return (T)constructor.newInstance(ClassUtil.getDefaultValues(parameterTypes));
                }
                catch (Exception exception2) {
                    // empty catch block
                }
            }
            return null;
        }
    }

    public static <T> T invokeStatic(Method method, Object ... args) throws UtilException {
        return ReflectUtil.invoke(null, method, args);
    }

    public static <T> T invokeWithCheck(Object obj, Method method, Object ... args) throws UtilException {
        Class[] types = method.getParameterTypes();
        if (null != args) {
            Assert.isTrue(args.length == types.length, "Params length [{}] is not fit for param length [{}] of method !", args.length, types.length);
            for (int i = 0; i < args.length; ++i) {
                Class type = types[i];
                if (!type.isPrimitive() || null != args[i]) continue;
                args[i] = ClassUtil.getDefaultValue(type);
            }
        }
        return ReflectUtil.invoke(obj, method, args);
    }

    public static <T> T invoke(Object obj, Method method, Object ... args) throws InvocationTargetRuntimeException, UtilException {
        try {
            return ReflectUtil.invokeRaw(obj, method, args);
        }
        catch (InvocationTargetException e) {
            throw new InvocationTargetRuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new UtilException(e);
        }
    }

    public static <T> T invokeRaw(Object obj, Method method, Object ... args) throws InvocationTargetException, IllegalAccessException {
        ReflectUtil.setAccessible(method);
        Class[] parameterTypes = method.getParameterTypes();
        Object[] actualArgs = new Object[parameterTypes.length];
        if (null != args) {
            for (int i = 0; i < actualArgs.length; ++i) {
                if (i >= args.length || null == args[i]) {
                    actualArgs[i] = ClassUtil.getDefaultValue(parameterTypes[i]);
                    continue;
                }
                if (args[i] instanceof NullWrapperBean) {
                    actualArgs[i] = null;
                    continue;
                }
                if (!parameterTypes[i].isAssignableFrom(args[i].getClass())) {
                    Object targetValue = Convert.convertWithCheck((Type)parameterTypes[i], args[i], null, true);
                    if (null != targetValue) {
                        actualArgs[i] = targetValue;
                        continue;
                    }
                    actualArgs[i] = args[i];
                    continue;
                }
                actualArgs[i] = args[i];
            }
        }
        if (method.isDefault()) {
            return MethodHandleUtil.invokeSpecial(obj, method, args);
        }
        return (T)method.invoke(ClassUtil.isStatic(method) ? null : obj, actualArgs);
    }

    public static <T> T invoke(Object obj, String methodName, Object ... args) throws UtilException {
        Assert.notNull(obj, "Object to get method must be not null!", new Object[0]);
        Assert.notBlank(methodName, "Method name must be not blank!", new Object[0]);
        Method method = ReflectUtil.getMethodOfObj(obj, methodName, args);
        if (null == method) {
            throw new UtilException("No such method: [{}] from [{}]", methodName, obj.getClass());
        }
        return ReflectUtil.invoke(obj, method, args);
    }

    public static <T extends AccessibleObject> T setAccessible(T accessibleObject) {
        if (null != accessibleObject && !accessibleObject.isAccessible()) {
            accessibleObject.setAccessible(true);
        }
        return accessibleObject;
    }

    public static void removeFinalModify(Field field) {
        ModifierUtil.removeFinalModify(field);
    }

    private static String getUniqueKey(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append(method.getReturnType().getName()).append('#');
        sb.append(method.getName());
        Class[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; ++i) {
            if (i == 0) {
                sb.append(':');
            } else {
                sb.append(',');
            }
            sb.append(parameters[i].getName());
        }
        return sb.toString();
    }

    private static List<Method> getDefaultMethodsFromInterface(Class<?> clazz) {
        ArrayList result = new ArrayList();
        for (Class ifc : clazz.getInterfaces()) {
            for (Method m : ifc.getMethods()) {
                if (ModifierUtil.isAbstract(m)) continue;
                result.add((Object)m);
            }
        }
        return result;
    }
}


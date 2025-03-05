/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Set
 *  java.util.function.Function
 *  java.util.stream.Collectors
 */
package cn.hutool.core.lang;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.func.Func0;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Singleton {
    private static final SafeConcurrentHashMap<String, Object> POOL = new SafeConcurrentHashMap();

    private Singleton() {
    }

    public static <T> T get(Class<T> clazz, Object ... params) {
        Assert.notNull(clazz, "Class must be not null !", new Object[0]);
        String key = Singleton.buildKey(clazz.getName(), params);
        return (T)Singleton.get(key, () -> ReflectUtil.newInstance(clazz, params));
    }

    public static <T> T get(String key, Func0<T> supplier) {
        return (T)POOL.computeIfAbsent(key, (Function<String, Object>)((Function)k -> supplier.callWithRuntimeException()));
    }

    public static <T> T get(String className, Object ... params) {
        Assert.notBlank(className, "Class name must be not blank !", new Object[0]);
        Class clazz = ClassUtil.loadClass(className);
        return Singleton.get(clazz, params);
    }

    public static void put(Object obj) {
        Assert.notNull(obj, "Bean object must be not null !", new Object[0]);
        Singleton.put(obj.getClass().getName(), obj);
    }

    public static void put(String key, Object obj) {
        POOL.put(key, obj);
    }

    public static boolean exists(Class<?> clazz, Object ... params) {
        if (null != clazz) {
            String key = Singleton.buildKey(clazz.getName(), params);
            return POOL.containsKey(key);
        }
        return false;
    }

    public static Set<Class<?>> getExistClass() {
        return (Set)POOL.values().stream().map(Object::getClass).collect(Collectors.toSet());
    }

    public static void remove(Class<?> clazz) {
        if (null != clazz) {
            Singleton.remove(clazz.getName());
        }
    }

    public static void remove(String key) {
        POOL.remove(key);
    }

    public static void destroy() {
        POOL.clear();
    }

    private static String buildKey(String className, Object ... params) {
        if (ArrayUtil.isEmpty(params)) {
            return className;
        }
        return StrUtil.format("{}#{}", className, ArrayUtil.join(params, (CharSequence)"_"));
    }
}


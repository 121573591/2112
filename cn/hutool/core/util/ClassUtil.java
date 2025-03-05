/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.SecurityException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.lang.reflect.Modifier
 *  java.lang.reflect.Type
 *  java.net.URI
 *  java.net.URL
 *  java.time.temporal.TemporalAccessor
 *  java.util.Date
 *  java.util.Enumeration
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Set
 */
package cn.hutool.core.util;

import cn.hutool.core.bean.NullWrapperBean;
import cn.hutool.core.convert.BasicType;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.ClassScanner;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.TypeUtil;
import cn.hutool.core.util.URLUtil;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ClassUtil {
    public static <T> Class<T> getClass(T obj) {
        return null == obj ? null : obj.getClass();
    }

    public static Class<?> getEnclosingClass(Class<?> clazz) {
        return null == clazz ? null : clazz.getEnclosingClass();
    }

    public static boolean isTopLevelClass(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return null == ClassUtil.getEnclosingClass(clazz);
    }

    public static String getClassName(Object obj, boolean isSimple) {
        if (null == obj) {
            return null;
        }
        Class clazz = obj.getClass();
        return ClassUtil.getClassName(clazz, isSimple);
    }

    public static String getClassName(Class<?> clazz, boolean isSimple) {
        if (null == clazz) {
            return null;
        }
        return isSimple ? clazz.getSimpleName() : clazz.getName();
    }

    public static String getShortClassName(String className) {
        List<String> packages = StrUtil.split((CharSequence)className, '.');
        if (null == packages || packages.size() < 2) {
            return className;
        }
        int size = packages.size();
        StringBuilder result = StrUtil.builder();
        result.append(((String)packages.get(0)).charAt(0));
        for (int i = 1; i < size - 1; ++i) {
            result.append('.').append(((String)packages.get(i)).charAt(0));
        }
        result.append('.').append((String)packages.get(size - 1));
        return result.toString();
    }

    public static Class<?>[] getClasses(Object ... objects) {
        Class[] classes = new Class[objects.length];
        for (int i = 0; i < objects.length; ++i) {
            Object obj = objects[i];
            classes[i] = obj instanceof NullWrapperBean ? ((NullWrapperBean)obj).getWrappedClass() : (null == obj ? Object.class : obj.getClass());
        }
        return classes;
    }

    public static boolean equals(Class<?> clazz, String className, boolean ignoreCase) {
        if (null == clazz || StrUtil.isBlank(className)) {
            return false;
        }
        if (ignoreCase) {
            return className.equalsIgnoreCase(clazz.getName()) || className.equalsIgnoreCase(clazz.getSimpleName());
        }
        return className.equals((Object)clazz.getName()) || className.equals((Object)clazz.getSimpleName());
    }

    public static Set<Class<?>> scanPackageByAnnotation(String packageName, Class<? extends Annotation> annotationClass) {
        return ClassScanner.scanPackageByAnnotation(packageName, annotationClass);
    }

    public static Set<Class<?>> scanPackageBySuper(String packageName, Class<?> superClass) {
        return ClassScanner.scanPackageBySuper(packageName, superClass);
    }

    public static Set<Class<?>> scanPackage() {
        return ClassScanner.scanPackage();
    }

    public static Set<Class<?>> scanPackage(String packageName) {
        return ClassScanner.scanPackage(packageName);
    }

    public static Set<Class<?>> scanPackage(String packageName, Filter<Class<?>> classFilter) {
        return ClassScanner.scanPackage(packageName, classFilter);
    }

    public static Set<String> getPublicMethodNames(Class<?> clazz) {
        return ReflectUtil.getPublicMethodNames(clazz);
    }

    public static Method[] getPublicMethods(Class<?> clazz) {
        return ReflectUtil.getPublicMethods(clazz);
    }

    public static List<Method> getPublicMethods(Class<?> clazz, Filter<Method> filter) {
        return ReflectUtil.getPublicMethods(clazz, filter);
    }

    public static List<Method> getPublicMethods(Class<?> clazz, Method ... excludeMethods) {
        return ReflectUtil.getPublicMethods(clazz, excludeMethods);
    }

    public static List<Method> getPublicMethods(Class<?> clazz, String ... excludeMethodNames) {
        return ReflectUtil.getPublicMethods(clazz, excludeMethodNames);
    }

    public static Method getPublicMethod(Class<?> clazz, String methodName, Class<?> ... paramTypes) throws SecurityException {
        return ReflectUtil.getPublicMethod(clazz, methodName, paramTypes);
    }

    public static Set<String> getDeclaredMethodNames(Class<?> clazz) {
        return ReflectUtil.getMethodNames(clazz);
    }

    public static Method[] getDeclaredMethods(Class<?> clazz) {
        return ReflectUtil.getMethods(clazz);
    }

    public static Method getDeclaredMethodOfObj(Object obj, String methodName, Object ... args) throws SecurityException {
        return ClassUtil.getDeclaredMethod(obj.getClass(), methodName, ClassUtil.getClasses(args));
    }

    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?> ... parameterTypes) throws SecurityException {
        return ReflectUtil.getMethod(clazz, methodName, parameterTypes);
    }

    public static Field getDeclaredField(Class<?> clazz, String fieldName) throws SecurityException {
        if (null == clazz || StrUtil.isBlank(fieldName)) {
            return null;
        }
        try {
            return clazz.getDeclaredField(fieldName);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
    }

    public static Field[] getDeclaredFields(Class<?> clazz) throws SecurityException {
        if (null == clazz) {
            return null;
        }
        return clazz.getDeclaredFields();
    }

    public static Set<String> getClassPathResources() {
        return ClassUtil.getClassPathResources(false);
    }

    public static Set<String> getClassPathResources(boolean isDecode) {
        return ClassUtil.getClassPaths("", isDecode);
    }

    public static Set<String> getClassPaths(String packageName) {
        return ClassUtil.getClassPaths(packageName, false);
    }

    public static Set<String> getClassPaths(String packageName, boolean isDecode) {
        Enumeration resources;
        String packagePath = packageName.replace((CharSequence)".", (CharSequence)"/");
        try {
            resources = ClassUtil.getClassLoader().getResources(packagePath);
        }
        catch (IOException e) {
            throw new UtilException(e, "Loading classPath [{}] error!", packagePath);
        }
        HashSet paths = new HashSet();
        while (resources.hasMoreElements()) {
            String path = ((URL)resources.nextElement()).getPath();
            paths.add((Object)(isDecode ? URLUtil.decode(path, CharsetUtil.systemCharsetName()) : path));
        }
        return paths;
    }

    public static String getClassPath() {
        return ClassUtil.getClassPath(false);
    }

    public static String getClassPath(boolean isEncoded) {
        URL classPathURL = ClassUtil.getClassPathURL();
        String url = isEncoded ? classPathURL.getPath() : URLUtil.getDecodedPath(classPathURL);
        return FileUtil.normalize(url);
    }

    public static URL getClassPathURL() {
        return ClassUtil.getResourceURL("");
    }

    public static URL getResourceURL(String resource) throws IORuntimeException {
        return ResourceUtil.getResource(resource);
    }

    public static List<URL> getResources(String resource) {
        return ResourceUtil.getResources(resource);
    }

    public static URL getResourceUrl(String resource, Class<?> baseClass) {
        return ResourceUtil.getResource(resource, baseClass);
    }

    public static String[] getJavaClassPaths() {
        return System.getProperty((String)"java.class.path").split(System.getProperty((String)"path.separator"));
    }

    public static ClassLoader getContextClassLoader() {
        return ClassLoaderUtil.getContextClassLoader();
    }

    public static ClassLoader getClassLoader() {
        return ClassLoaderUtil.getClassLoader();
    }

    public static boolean isAllAssignableFrom(Class<?>[] types1, Class<?>[] types2) {
        if (ArrayUtil.isEmpty(types1) && ArrayUtil.isEmpty(types2)) {
            return true;
        }
        if (null == types1 || null == types2) {
            return false;
        }
        if (types1.length != types2.length) {
            return false;
        }
        for (int i = 0; i < types1.length; ++i) {
            Class<?> type1 = types1[i];
            Class<?> type2 = types2[i];
            if (!(ClassUtil.isBasicType(type1) && ClassUtil.isBasicType(type2) ? BasicType.unWrap(type1) != BasicType.unWrap(type2) : false == type1.isAssignableFrom(type2))) continue;
            return false;
        }
        return true;
    }

    public static <T> Class<T> loadClass(String className, boolean isInitialized) {
        return ClassLoaderUtil.loadClass(className, isInitialized);
    }

    public static <T> Class<T> loadClass(String className) {
        return ClassUtil.loadClass(className, true);
    }

    public static <T> T invoke(String classNameWithMethodName, Object[] args) {
        return ClassUtil.invoke(classNameWithMethodName, false, args);
    }

    public static <T> T invoke(String classNameWithMethodName, boolean isSingleton, Object ... args) {
        if (StrUtil.isBlank(classNameWithMethodName)) {
            throw new UtilException("Blank classNameDotMethodName!");
        }
        int splitIndex = classNameWithMethodName.lastIndexOf(35);
        if (splitIndex <= 0) {
            splitIndex = classNameWithMethodName.lastIndexOf(46);
        }
        if (splitIndex <= 0) {
            throw new UtilException("Invalid classNameWithMethodName [{}]!", classNameWithMethodName);
        }
        String className = classNameWithMethodName.substring(0, splitIndex);
        String methodName = classNameWithMethodName.substring(splitIndex + 1);
        return ClassUtil.invoke(className, methodName, isSingleton, args);
    }

    public static <T> T invoke(String className, String methodName, Object[] args) {
        return ClassUtil.invoke(className, methodName, false, args);
    }

    public static <T> T invoke(String className, String methodName, boolean isSingleton, Object ... args) {
        Class<T> clazz = ClassUtil.loadClass(className);
        try {
            Method method = ClassUtil.getDeclaredMethod(clazz, methodName, ClassUtil.getClasses(args));
            if (null == method) {
                throw new NoSuchMethodException(StrUtil.format("No such method: [{}]", methodName));
            }
            if (ClassUtil.isStatic(method)) {
                return ReflectUtil.invoke(null, method, args);
            }
            return ReflectUtil.invoke(isSingleton ? Singleton.get(clazz, new Object[0]) : clazz.newInstance(), method, args);
        }
        catch (Exception e) {
            throw new UtilException(e);
        }
    }

    public static boolean isPrimitiveWrapper(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return BasicType.WRAPPER_PRIMITIVE_MAP.containsKey(clazz);
    }

    public static boolean isBasicType(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return clazz.isPrimitive() || ClassUtil.isPrimitiveWrapper(clazz);
    }

    public static boolean isSimpleTypeOrArray(Class<?> clazz) {
        if (null == clazz) {
            return false;
        }
        return ClassUtil.isSimpleValueType(clazz) || clazz.isArray() && ClassUtil.isSimpleValueType(clazz.getComponentType());
    }

    public static boolean isSimpleValueType(Class<?> clazz) {
        return ClassUtil.isBasicType(clazz) || clazz.isEnum() || CharSequence.class.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) || clazz.equals(URI.class) || clazz.equals(URL.class) || clazz.equals(Locale.class) || clazz.equals(Class.class) || TemporalAccessor.class.isAssignableFrom(clazz);
    }

    public static boolean isAssignable(Class<?> targetType, Class<?> sourceType) {
        if (null == targetType || null == sourceType) {
            return false;
        }
        if (targetType.isAssignableFrom(sourceType)) {
            return true;
        }
        if (targetType.isPrimitive()) {
            Class resolvedPrimitive = (Class)BasicType.WRAPPER_PRIMITIVE_MAP.get(sourceType);
            return targetType.equals((Object)resolvedPrimitive);
        }
        Class resolvedWrapper = (Class)BasicType.PRIMITIVE_WRAPPER_MAP.get(sourceType);
        return resolvedWrapper != null && targetType.isAssignableFrom(resolvedWrapper);
    }

    public static boolean isPublic(Class<?> clazz) {
        if (null == clazz) {
            throw new NullPointerException("Class to provided is null.");
        }
        return Modifier.isPublic((int)clazz.getModifiers());
    }

    public static boolean isPublic(Method method) {
        Assert.notNull(method, "Method to provided is null.", new Object[0]);
        return Modifier.isPublic((int)method.getModifiers());
    }

    public static boolean isNotPublic(Class<?> clazz) {
        return false == ClassUtil.isPublic(clazz);
    }

    public static boolean isNotPublic(Method method) {
        return false == ClassUtil.isPublic(method);
    }

    public static boolean isStatic(Method method) {
        Assert.notNull(method, "Method to provided is null.", new Object[0]);
        return Modifier.isStatic((int)method.getModifiers());
    }

    public static Method setAccessible(Method method) {
        if (null != method && !method.isAccessible()) {
            method.setAccessible(true);
        }
        return method;
    }

    public static boolean isAbstract(Class<?> clazz) {
        return Modifier.isAbstract((int)clazz.getModifiers());
    }

    public static boolean isNormalClass(Class<?> clazz) {
        return null != clazz && false == clazz.isInterface() && false == ClassUtil.isAbstract(clazz) && false == clazz.isEnum() && false == clazz.isArray() && false == clazz.isAnnotation() && false == clazz.isSynthetic() && false == clazz.isPrimitive();
    }

    public static boolean isEnum(Class<?> clazz) {
        return null != clazz && clazz.isEnum();
    }

    public static Class<?> getTypeArgument(Class<?> clazz) {
        return ClassUtil.getTypeArgument(clazz, 0);
    }

    public static Class<?> getTypeArgument(Class<?> clazz, int index) {
        Type argumentType = TypeUtil.getTypeArgument(clazz, index);
        return TypeUtil.getClass(argumentType);
    }

    public static String getPackage(Class<?> clazz) {
        if (clazz == null) {
            return "";
        }
        String className = clazz.getName();
        int packageEndIndex = className.lastIndexOf(".");
        if (packageEndIndex == -1) {
            return "";
        }
        return className.substring(0, packageEndIndex);
    }

    public static String getPackagePath(Class<?> clazz) {
        return ClassUtil.getPackage(clazz).replace('.', '/');
    }

    public static Object getDefaultValue(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return ClassUtil.getPrimitiveDefaultValue(clazz);
        }
        return null;
    }

    public static Object getPrimitiveDefaultValue(Class<?> clazz) {
        if (Long.TYPE == clazz) {
            return 0L;
        }
        if (Integer.TYPE == clazz) {
            return 0;
        }
        if (Short.TYPE == clazz) {
            return (short)0;
        }
        if (Character.TYPE == clazz) {
            return Character.valueOf((char)'\u0000');
        }
        if (Byte.TYPE == clazz) {
            return (byte)0;
        }
        if (Double.TYPE == clazz) {
            return 0.0;
        }
        if (Float.TYPE == clazz) {
            return Float.valueOf((float)0.0f);
        }
        if (Boolean.TYPE == clazz) {
            return false;
        }
        return null;
    }

    public static Object[] getDefaultValues(Class<?> ... classes) {
        Object[] values = new Object[classes.length];
        for (int i = 0; i < classes.length; ++i) {
            values[i] = ClassUtil.getDefaultValue(classes[i]);
        }
        return values;
    }

    public static boolean isJdkClass(Class<?> clazz) {
        Package objectPackage = clazz.getPackage();
        if (null == objectPackage) {
            return false;
        }
        String objectPackageName = objectPackage.getName();
        return objectPackageName.startsWith("java.") || objectPackageName.startsWith("javax.") || clazz.getClassLoader() == null;
    }

    public static URL getLocation(Class<?> clazz) {
        if (null == clazz) {
            return null;
        }
        return clazz.getProtectionDomain().getCodeSource().getLocation();
    }

    public static String getLocationPath(Class<?> clazz) {
        URL location = ClassUtil.getLocation(clazz);
        if (null == location) {
            return null;
        }
        return location.getPath();
    }

    public static boolean isAbstractOrInterface(Class<?> clazz) {
        return ClassUtil.isAbstract(clazz) || ClassUtil.isInterface(clazz);
    }

    public static boolean isInterface(Class<?> clazz) {
        return clazz.isInterface();
    }
}


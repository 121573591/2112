/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchMethodException
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Package
 *  java.lang.RuntimeException
 *  java.lang.SecurityException
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AccessibleObject
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Member
 *  java.lang.reflect.Method
 *  java.lang.reflect.Modifier
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.EnumMap
 *  java.util.EnumSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.util.ExceptionUtil;
import com.fasterxml.jackson.databind.util.Named;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ClassUtil {
    private static final Class<?> CLS_OBJECT = Object.class;
    private static final Annotation[] NO_ANNOTATIONS = new Annotation[0];
    private static final Ctor[] NO_CTORS = new Ctor[0];
    private static final Iterator<?> EMPTY_ITERATOR = Collections.emptyIterator();

    public static <T> Iterator<T> emptyIterator() {
        return EMPTY_ITERATOR;
    }

    public static List<JavaType> findSuperTypes(JavaType type, Class<?> endBefore, boolean addClassItself) {
        if (type == null || type.hasRawClass(endBefore) || type.hasRawClass(Object.class)) {
            return Collections.emptyList();
        }
        ArrayList result = new ArrayList(8);
        ClassUtil._addSuperTypes(type, endBefore, (Collection<JavaType>)result, addClassItself);
        return result;
    }

    public static List<Class<?>> findRawSuperTypes(Class<?> cls, Class<?> endBefore, boolean addClassItself) {
        if (cls == null || cls == endBefore || cls == Object.class) {
            return Collections.emptyList();
        }
        ArrayList result = new ArrayList(8);
        ClassUtil._addRawSuperTypes(cls, endBefore, result, addClassItself);
        return result;
    }

    public static List<Class<?>> findSuperClasses(Class<?> cls, Class<?> endBefore, boolean addClassItself) {
        ArrayList result = new ArrayList(8);
        if (cls != null && cls != endBefore) {
            if (addClassItself) {
                result.add(cls);
            }
            while ((cls = cls.getSuperclass()) != null && cls != endBefore) {
                result.add((Object)cls);
            }
        }
        return result;
    }

    @Deprecated
    public static List<Class<?>> findSuperTypes(Class<?> cls, Class<?> endBefore) {
        return ClassUtil.findSuperTypes(cls, endBefore, new ArrayList(8));
    }

    @Deprecated
    public static List<Class<?>> findSuperTypes(Class<?> cls, Class<?> endBefore, List<Class<?>> result) {
        ClassUtil._addRawSuperTypes(cls, endBefore, result, false);
        return result;
    }

    private static void _addSuperTypes(JavaType type, Class<?> endBefore, Collection<JavaType> result, boolean addClassItself) {
        if (type == null) {
            return;
        }
        Class<?> cls = type.getRawClass();
        if (cls == endBefore || cls == Object.class) {
            return;
        }
        if (addClassItself) {
            if (result.contains((Object)type)) {
                return;
            }
            result.add((Object)type);
        }
        for (JavaType intCls : type.getInterfaces()) {
            ClassUtil._addSuperTypes(intCls, endBefore, result, true);
        }
        ClassUtil._addSuperTypes(type.getSuperClass(), endBefore, result, true);
    }

    private static void _addRawSuperTypes(Class<?> cls, Class<?> endBefore, Collection<Class<?>> result, boolean addClassItself) {
        if (cls == endBefore || cls == null || cls == Object.class) {
            return;
        }
        if (addClassItself) {
            if (result.contains(cls)) {
                return;
            }
            result.add(cls);
        }
        for (Class<?> intCls : ClassUtil._interfaces(cls)) {
            ClassUtil._addRawSuperTypes(intCls, endBefore, result, true);
        }
        ClassUtil._addRawSuperTypes(cls.getSuperclass(), endBefore, result, true);
    }

    public static String canBeABeanType(Class<?> type) {
        if (type.isAnnotation()) {
            return "annotation";
        }
        if (type.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(type)) {
            return "enum";
        }
        if (type.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static String isLocalType(Class<?> type, boolean allowNonStatic) {
        try {
            boolean isStatic = Modifier.isStatic((int)type.getModifiers());
            if (!isStatic && ClassUtil.hasEnclosingMethod(type)) {
                return "local/anonymous";
            }
            if (!allowNonStatic && !isStatic && ClassUtil.getEnclosingClass(type) != null) {
                return "non-static member class";
            }
        }
        catch (SecurityException securityException) {
        }
        catch (NullPointerException nullPointerException) {
            // empty catch block
        }
        return null;
    }

    public static Class<?> getOuterClass(Class<?> type) {
        if (!Modifier.isStatic((int)type.getModifiers())) {
            try {
                if (ClassUtil.hasEnclosingMethod(type)) {
                    return null;
                }
                return ClassUtil.getEnclosingClass(type);
            }
            catch (SecurityException securityException) {
                // empty catch block
            }
        }
        return null;
    }

    public static boolean isProxyType(Class<?> type) {
        String name = type.getName();
        return name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.");
    }

    public static boolean isConcrete(Class<?> type) {
        int mod = type.getModifiers();
        return (mod & 0x600) == 0;
    }

    public static boolean isConcrete(Member member) {
        int mod = member.getModifiers();
        return (mod & 0x600) == 0;
    }

    public static boolean isCollectionMapOrArray(Class<?> type) {
        if (type.isArray()) {
            return true;
        }
        if (Collection.class.isAssignableFrom(type)) {
            return true;
        }
        return Map.class.isAssignableFrom(type);
    }

    public static boolean isBogusClass(Class<?> cls) {
        return cls == Void.class || cls == Void.TYPE || cls == NoClass.class;
    }

    public static boolean isRecordType(Class<?> cls) {
        Class parent = cls.getSuperclass();
        return parent != null && "java.lang.Record".equals((Object)parent.getName());
    }

    public static boolean isObjectOrPrimitive(Class<?> cls) {
        return cls == CLS_OBJECT || cls.isPrimitive();
    }

    public static boolean hasClass(Object inst, Class<?> raw) {
        return inst != null && inst.getClass() == raw;
    }

    public static void verifyMustOverride(Class<?> expType, Object instance, String method) {
        if (instance.getClass() != expType) {
            throw new IllegalStateException(String.format((String)"Sub-class %s (of class %s) must override method '%s'", (Object[])new Object[]{instance.getClass().getName(), expType.getName(), method}));
        }
    }

    @Deprecated
    public static boolean hasGetterSignature(Method m) {
        if (Modifier.isStatic((int)m.getModifiers())) {
            return false;
        }
        if (m.getParameterTypes().length != 0) {
            return false;
        }
        return Void.TYPE != m.getReturnType();
    }

    public static Throwable throwIfError(Throwable t) {
        if (t instanceof Error) {
            throw (Error)t;
        }
        return t;
    }

    public static Throwable throwIfRTE(Throwable t) {
        if (t instanceof RuntimeException) {
            throw (RuntimeException)t;
        }
        return t;
    }

    public static Throwable throwIfIOE(Throwable t) throws IOException {
        if (t instanceof IOException) {
            throw (IOException)t;
        }
        return t;
    }

    public static Throwable getRootCause(Throwable t) {
        while (t.getCause() != null) {
            t = t.getCause();
        }
        return t;
    }

    public static Throwable throwRootCauseIfIOE(Throwable t) throws IOException {
        return ClassUtil.throwIfIOE(ClassUtil.getRootCause(t));
    }

    public static void throwAsIAE(Throwable t) {
        ClassUtil.throwAsIAE(t, t.getMessage());
    }

    public static void throwAsIAE(Throwable t, String msg) {
        ClassUtil.throwIfRTE(t);
        ClassUtil.throwIfError(t);
        throw new IllegalArgumentException(msg, t);
    }

    public static <T> T throwAsMappingException(DeserializationContext ctxt, IOException e0) throws JsonMappingException {
        if (e0 instanceof JsonMappingException) {
            throw (JsonMappingException)e0;
        }
        throw JsonMappingException.from(ctxt, e0.getMessage()).withCause(e0);
    }

    public static void unwrapAndThrowAsIAE(Throwable t) {
        ClassUtil.throwAsIAE(ClassUtil.getRootCause(t));
    }

    public static void unwrapAndThrowAsIAE(Throwable t, String msg) {
        ClassUtil.throwAsIAE(ClassUtil.getRootCause(t), msg);
    }

    public static void closeOnFailAndThrowAsIOE(JsonGenerator g, Exception fail) throws IOException {
        g.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
        try {
            g.close();
        }
        catch (Exception e) {
            fail.addSuppressed((Throwable)e);
        }
        ClassUtil.throwIfIOE(fail);
        ClassUtil.throwIfRTE(fail);
        throw new RuntimeException((Throwable)fail);
    }

    public static void closeOnFailAndThrowAsIOE(JsonGenerator g, Closeable toClose, Exception fail) throws IOException {
        if (g != null) {
            g.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);
            try {
                g.close();
            }
            catch (Exception e) {
                fail.addSuppressed((Throwable)e);
            }
        }
        if (toClose != null) {
            try {
                toClose.close();
            }
            catch (Exception e) {
                fail.addSuppressed((Throwable)e);
            }
        }
        ClassUtil.throwIfIOE(fail);
        ClassUtil.throwIfRTE(fail);
        throw new RuntimeException((Throwable)fail);
    }

    public static <T> T createInstance(Class<T> cls, boolean canFixAccess) throws IllegalArgumentException {
        Constructor<T> ctor = ClassUtil.findConstructor(cls, canFixAccess);
        if (ctor == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return (T)ctor.newInstance(new Object[0]);
        }
        catch (Exception e) {
            ClassUtil.unwrapAndThrowAsIAE(e, "Failed to instantiate class " + cls.getName() + ", problem: " + e.getMessage());
            return null;
        }
    }

    public static <T> Constructor<T> findConstructor(Class<T> cls, boolean forceAccess) throws IllegalArgumentException {
        try {
            Constructor ctor = cls.getDeclaredConstructor(new Class[0]);
            if (forceAccess) {
                ClassUtil.checkAndFixAccess((Member)ctor, forceAccess);
            } else if (!Modifier.isPublic((int)ctor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
            return ctor;
        }
        catch (NoSuchMethodException ctor) {
        }
        catch (Exception e) {
            ClassUtil.unwrapAndThrowAsIAE(e, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e.getMessage());
        }
        return null;
    }

    public static Class<?> classOf(Object inst) {
        if (inst == null) {
            return null;
        }
        return inst.getClass();
    }

    public static Class<?> rawClass(JavaType t) {
        if (t == null) {
            return null;
        }
        return t.getRawClass();
    }

    public static <T> T nonNull(T valueOrNull, T defaultValue) {
        return valueOrNull == null ? defaultValue : valueOrNull;
    }

    public static String nullOrToString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static String nonNullString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String quotedOr(Object str, String forNull) {
        if (str == null) {
            return forNull;
        }
        return String.format((String)"\"%s\"", (Object[])new Object[]{str});
    }

    public static String getClassDescription(Object classOrInstance) {
        if (classOrInstance == null) {
            return "unknown";
        }
        Class cls = classOrInstance instanceof Class ? (Class)classOrInstance : classOrInstance.getClass();
        return ClassUtil.nameOf(cls);
    }

    public static String getTypeDescription(JavaType fullType) {
        if (fullType == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(80).append('`');
        sb.append(fullType.toCanonical());
        return sb.append('`').toString();
    }

    public static String classNameOf(Object inst) {
        if (inst == null) {
            return "[null]";
        }
        Class raw = inst instanceof Class ? (Class)inst : inst.getClass();
        return ClassUtil.nameOf(raw);
    }

    public static String nameOf(Class<?> cls) {
        String base;
        if (cls == null) {
            return "[null]";
        }
        int index = 0;
        while (cls.isArray()) {
            ++index;
            cls = cls.getComponentType();
        }
        String string = base = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (index > 0) {
            StringBuilder sb = new StringBuilder(base);
            do {
                sb.append("[]");
            } while (--index > 0);
            base = sb.toString();
        }
        return ClassUtil.backticked(base);
    }

    public static String nameOf(Named named) {
        if (named == null) {
            return "[null]";
        }
        return ClassUtil.apostrophed(named.getName());
    }

    public static String name(String name) {
        if (name == null) {
            return "[null]";
        }
        return ClassUtil.apostrophed(name);
    }

    public static String name(PropertyName name) {
        if (name == null) {
            return "[null]";
        }
        return ClassUtil.apostrophed(name.getSimpleName());
    }

    public static String backticked(String text) {
        if (text == null) {
            return "[null]";
        }
        return new StringBuilder(text.length() + 2).append('`').append(text).append('`').toString();
    }

    public static String apostrophed(String text) {
        if (text == null) {
            return "[null]";
        }
        return new StringBuilder(text.length() + 2).append('\'').append(text).append('\'').toString();
    }

    public static String exceptionMessage(Throwable t) {
        if (t instanceof JacksonException) {
            return ((JacksonException)((Object)t)).getOriginalMessage();
        }
        if (t instanceof InvocationTargetException && t.getCause() != null) {
            return t.getCause().getMessage();
        }
        return t.getMessage();
    }

    public static Object defaultValue(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Double.TYPE) {
            return 0.0;
        }
        if (cls == Float.TYPE) {
            return Float.valueOf((float)0.0f);
        }
        if (cls == Byte.TYPE) {
            return (byte)0;
        }
        if (cls == Short.TYPE) {
            return (short)0;
        }
        if (cls == Character.TYPE) {
            return Character.valueOf((char)'\u0000');
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static Class<?> wrapperType(Class<?> primitiveType) {
        if (primitiveType == Integer.TYPE) {
            return Integer.class;
        }
        if (primitiveType == Long.TYPE) {
            return Long.class;
        }
        if (primitiveType == Boolean.TYPE) {
            return Boolean.class;
        }
        if (primitiveType == Double.TYPE) {
            return Double.class;
        }
        if (primitiveType == Float.TYPE) {
            return Float.class;
        }
        if (primitiveType == Byte.TYPE) {
            return Byte.class;
        }
        if (primitiveType == Short.TYPE) {
            return Short.class;
        }
        if (primitiveType == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + primitiveType.getName() + " is not a primitive type");
    }

    public static Class<?> primitiveType(Class<?> type) {
        if (type.isPrimitive()) {
            return type;
        }
        if (type == Integer.class) {
            return Integer.TYPE;
        }
        if (type == Long.class) {
            return Long.TYPE;
        }
        if (type == Boolean.class) {
            return Boolean.TYPE;
        }
        if (type == Double.class) {
            return Double.TYPE;
        }
        if (type == Float.class) {
            return Float.TYPE;
        }
        if (type == Byte.class) {
            return Byte.TYPE;
        }
        if (type == Short.class) {
            return Short.TYPE;
        }
        if (type == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    @Deprecated
    public static void checkAndFixAccess(Member member) {
        ClassUtil.checkAndFixAccess(member, false);
    }

    public static void checkAndFixAccess(Member member, boolean evenIfAlreadyPublic) {
        AccessibleObject ao = (AccessibleObject)member;
        try {
            boolean isPublic;
            Class declaringClass = member.getDeclaringClass();
            boolean bl = isPublic = Modifier.isPublic((int)member.getModifiers()) && Modifier.isPublic((int)declaringClass.getModifiers());
            if (!isPublic || evenIfAlreadyPublic && !ClassUtil.isJDKClass(declaringClass)) {
                ao.setAccessible(true);
            }
        }
        catch (SecurityException se) {
            if (!ao.isAccessible()) {
                Class declClass = member.getDeclaringClass();
                throw new IllegalArgumentException("Cannot access " + member + " (from class " + declClass.getName() + "; failed to set access: " + se.getMessage());
            }
        }
        catch (RuntimeException se) {
            if ("InaccessibleObjectException".equals((Object)se.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format((String)"Failed to call `setAccess()` on %s '%s' (of class %s) due to `%s`, problem: %s", (Object[])new Object[]{member.getClass().getSimpleName(), member.getName(), ClassUtil.nameOf(member.getDeclaringClass()), se.getClass().getName(), se.getMessage()}), (Throwable)se);
            }
            throw se;
        }
    }

    public static boolean isEnumType(Class<?> rawType) {
        return Enum.class.isAssignableFrom(rawType);
    }

    public static Class<? extends Enum<?>> findEnumType(EnumSet<?> s) {
        if (!s.isEmpty()) {
            return ClassUtil.findEnumType((Enum)s.iterator().next());
        }
        return EnumTypeLocator.instance.enumTypeFor(s);
    }

    public static Class<? extends Enum<?>> findEnumType(EnumMap<?, ?> m) {
        if (!m.isEmpty()) {
            return ClassUtil.findEnumType((Enum)m.keySet().iterator().next());
        }
        return EnumTypeLocator.instance.enumTypeFor(m);
    }

    public static Class<? extends Enum<?>> findEnumType(Enum<?> en) {
        return en.getDeclaringClass();
    }

    public static Class<? extends Enum<?>> findEnumType(Class<?> cls) {
        if (cls.getSuperclass() != Enum.class) {
            cls = cls.getSuperclass();
        }
        return cls;
    }

    public static <T extends Annotation> Enum<?> findFirstAnnotatedEnumValue(Class<Enum<?>> enumClass, Class<T> annotationClass) {
        Field[] fields;
        for (Field field : fields = enumClass.getDeclaredFields()) {
            Annotation defaultValueAnnotation;
            if (!field.isEnumConstant() || (defaultValueAnnotation = field.getAnnotation(annotationClass)) == null) continue;
            String name = field.getName();
            for (Enum enumValue : (Enum[])enumClass.getEnumConstants()) {
                if (!name.equals((Object)enumValue.name())) continue;
                return enumValue;
            }
        }
        return null;
    }

    public static boolean isJacksonStdImpl(Object impl) {
        return impl == null || ClassUtil.isJacksonStdImpl(impl.getClass());
    }

    public static boolean isJacksonStdImpl(Class<?> implClass) {
        return implClass.getAnnotation(JacksonStdImpl.class) != null;
    }

    public static boolean isJDKClass(Class<?> rawType) {
        String clsName = rawType.getName();
        return clsName.startsWith("java.") || clsName.startsWith("javax.");
    }

    public static boolean isJDK17OrAbove() {
        try {
            return ClassUtil.getJDKMajorVersion() >= 17;
        }
        catch (Throwable t) {
            ExceptionUtil.rethrowIfFatal(t);
            System.err.println("Failed to determine JDK major version, assuming pre-JDK-17; problem: " + (Object)((Object)t));
            return false;
        }
    }

    public static int getJDKMajorVersion() {
        String version;
        try {
            version = System.getProperty((String)"java.version");
        }
        catch (SecurityException e) {
            throw new IllegalStateException("Could not access 'java.version': cannot determine JDK major version");
        }
        if (version.startsWith("1.")) {
            return 8;
        }
        int dotIndex = version.indexOf(".");
        String cleaned = dotIndex < 0 ? version : version.substring(0, dotIndex);
        try {
            return Integer.parseInt((String)cleaned);
        }
        catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid JDK version String '" + version + "' cannot determine JDK major version");
        }
    }

    public static boolean isNonStaticInnerClass(Class<?> cls) {
        return !Modifier.isStatic((int)cls.getModifiers()) && ClassUtil.getEnclosingClass(cls) != null;
    }

    @Deprecated
    public static String getPackageName(Class<?> cls) {
        Package pkg = cls.getPackage();
        return pkg == null ? null : pkg.getName();
    }

    public static boolean hasEnclosingMethod(Class<?> cls) {
        return !ClassUtil.isObjectOrPrimitive(cls) && cls.getEnclosingMethod() != null;
    }

    @Deprecated
    public static Field[] getDeclaredFields(Class<?> cls) {
        return cls.getDeclaredFields();
    }

    @Deprecated
    public static Method[] getDeclaredMethods(Class<?> cls) {
        return cls.getDeclaredMethods();
    }

    public static Annotation[] findClassAnnotations(Class<?> cls) {
        if (ClassUtil.isObjectOrPrimitive(cls)) {
            return NO_ANNOTATIONS;
        }
        return cls.getDeclaredAnnotations();
    }

    public static Method[] getClassMethods(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        }
        catch (NoClassDefFoundError ex) {
            Class contextClass;
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                return ClassUtil._failGetClassMethods(cls, ex);
            }
            try {
                contextClass = loader.loadClass(cls.getName());
            }
            catch (ClassNotFoundException e) {
                ex.addSuppressed((Throwable)e);
                return ClassUtil._failGetClassMethods(cls, ex);
            }
            try {
                return contextClass.getDeclaredMethods();
            }
            catch (Exception t) {
                return ClassUtil._failGetClassMethods(cls, t);
            }
        }
        catch (Exception t) {
            return ClassUtil._failGetClassMethods(cls, t);
        }
    }

    private static Method[] _failGetClassMethods(Class<?> cls, Throwable rootCause) throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format((String)"Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", (Object[])new Object[]{cls.getName(), rootCause.getClass().getName(), rootCause.getMessage()}), rootCause);
    }

    public static Ctor[] getConstructors(Class<?> cls) {
        if (cls.isInterface() || ClassUtil.isObjectOrPrimitive(cls)) {
            return NO_CTORS;
        }
        Constructor[] rawCtors = cls.getDeclaredConstructors();
        int len = rawCtors.length;
        Ctor[] result = new Ctor[len];
        for (int i = 0; i < len; ++i) {
            result[i] = new Ctor(rawCtors[i]);
        }
        return result;
    }

    public static Class<?> getDeclaringClass(Class<?> cls) {
        return ClassUtil.isObjectOrPrimitive(cls) ? null : cls.getDeclaringClass();
    }

    public static Type getGenericSuperclass(Class<?> cls) {
        return cls.getGenericSuperclass();
    }

    public static Type[] getGenericInterfaces(Class<?> cls) {
        return cls.getGenericInterfaces();
    }

    public static Class<?> getEnclosingClass(Class<?> cls) {
        return ClassUtil.isObjectOrPrimitive(cls) ? null : cls.getEnclosingClass();
    }

    private static Class<?>[] _interfaces(Class<?> cls) {
        return cls.getInterfaces();
    }

    public static final class Ctor {
        public final Constructor<?> _ctor;
        private transient Annotation[] _annotations;
        private transient Annotation[][] _paramAnnotations;
        private int _paramCount = -1;

        public Ctor(Constructor<?> ctor) {
            this._ctor = ctor;
        }

        public Constructor<?> getConstructor() {
            return this._ctor;
        }

        public int getParamCount() {
            int c = this._paramCount;
            if (c < 0) {
                this._paramCount = c = this._ctor.getParameterCount();
            }
            return c;
        }

        public Class<?> getDeclaringClass() {
            return this._ctor.getDeclaringClass();
        }

        public Annotation[] getDeclaredAnnotations() {
            Annotation[] result = this._annotations;
            if (result == null) {
                this._annotations = result = this._ctor.getDeclaredAnnotations();
            }
            return result;
        }

        public Annotation[][] getParameterAnnotations() {
            Annotation[][] result = this._paramAnnotations;
            if (result == null) {
                this._paramAnnotations = result = this._ctor.getParameterAnnotations();
            }
            return result;
        }
    }

    private static class EnumTypeLocator {
        static final EnumTypeLocator instance = new EnumTypeLocator();
        private final Field enumSetTypeField;
        private final Field enumMapTypeField;
        private final String failForEnumSet;
        private final String failForEnumMap;

        private EnumTypeLocator() {
            Field f = null;
            String msg = null;
            try {
                f = EnumTypeLocator.locateField(EnumSet.class, "elementType", Class.class);
            }
            catch (Exception e) {
                msg = e.toString();
            }
            this.enumSetTypeField = f;
            this.failForEnumSet = msg;
            f = null;
            msg = null;
            try {
                f = EnumTypeLocator.locateField(EnumMap.class, "keyType", Class.class);
            }
            catch (Exception e) {
                msg = e.toString();
            }
            this.enumMapTypeField = f;
            this.failForEnumMap = msg;
        }

        public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> set) {
            if (this.enumSetTypeField != null) {
                return (Class)this.get(set, this.enumSetTypeField);
            }
            throw new IllegalStateException("Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: " + this.failForEnumSet);
        }

        public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> set) {
            if (this.enumMapTypeField != null) {
                return (Class)this.get(set, this.enumMapTypeField);
            }
            throw new IllegalStateException("Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: " + this.failForEnumMap);
        }

        private Object get(Object bean, Field field) {
            try {
                return field.get(bean);
            }
            catch (Exception e) {
                throw new IllegalArgumentException((Throwable)e);
            }
        }

        private static Field locateField(Class<?> fromClass, String expectedName, Class<?> type) throws Exception {
            Field[] fields;
            for (Field f : fields = fromClass.getDeclaredFields()) {
                if (!expectedName.equals((Object)f.getName()) || f.getType() != type) continue;
                f.setAccessible(true);
                return f;
            }
            throw new IllegalStateException(String.format((String)"No field named '%s' in class '%s'", (Object[])new Object[]{expectedName, fromClass.getName()}));
        }
    }
}


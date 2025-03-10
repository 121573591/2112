/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Method
 *  java.lang.reflect.Modifier
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.CollectorBase;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnnotatedMethodCollector
extends CollectorBase {
    private final ClassIntrospector.MixInResolver _mixInResolver;
    private final boolean _collectAnnotations;

    AnnotatedMethodCollector(AnnotationIntrospector intr, ClassIntrospector.MixInResolver mixins, boolean collectAnnotations) {
        super(intr);
        this._mixInResolver = intr == null ? null : mixins;
        this._collectAnnotations = collectAnnotations;
    }

    public static AnnotatedMethodMap collectMethods(AnnotationIntrospector intr, TypeResolutionContext tc, ClassIntrospector.MixInResolver mixins, TypeFactory types, JavaType type, List<JavaType> superTypes, Class<?> primaryMixIn, boolean collectAnnotations) {
        return new AnnotatedMethodCollector(intr, mixins, collectAnnotations).collect(types, tc, type, superTypes, primaryMixIn);
    }

    AnnotatedMethodMap collect(TypeFactory typeFactory, TypeResolutionContext tc, JavaType mainType, List<JavaType> superTypes, Class<?> primaryMixIn) {
        Iterator mixin;
        LinkedHashMap methods = new LinkedHashMap();
        this._addMemberMethods(tc, mainType.getRawClass(), (Map<MemberKey, MethodBuilder>)methods, primaryMixIn);
        for (JavaType type : superTypes) {
            Class<?> mixin2 = this._mixInResolver == null ? null : this._mixInResolver.findMixInClassFor(type.getRawClass());
            this._addMemberMethods(new TypeResolutionContext.Basic(typeFactory, type.getBindings()), type.getRawClass(), (Map<MemberKey, MethodBuilder>)methods, mixin2);
        }
        boolean checkJavaLangObject = false;
        if (this._mixInResolver != null && (mixin = this._mixInResolver.findMixInClassFor(Object.class)) != null) {
            this._addMethodMixIns(tc, mainType.getRawClass(), (Map<MemberKey, MethodBuilder>)methods, (Class<?>)mixin);
            checkJavaLangObject = true;
        }
        if (checkJavaLangObject && this._intr != null && !methods.isEmpty()) {
            for (Map.Entry entry : methods.entrySet()) {
                MemberKey k = (MemberKey)entry.getKey();
                if (!"hashCode".equals((Object)k.getName()) || 0 != k.argCount()) continue;
                try {
                    Method m = Object.class.getDeclaredMethod(k.getName(), new Class[0]);
                    MethodBuilder b = (MethodBuilder)entry.getValue();
                    b.annotations = this.collectDefaultAnnotations(b.annotations, m.getDeclaredAnnotations());
                    b.method = m;
                }
                catch (Exception m) {}
            }
        }
        if (methods.isEmpty()) {
            return new AnnotatedMethodMap();
        }
        LinkedHashMap actual = new LinkedHashMap(methods.size());
        for (Map.Entry entry : methods.entrySet()) {
            AnnotatedMethod am = ((MethodBuilder)entry.getValue()).build();
            if (am == null) continue;
            actual.put(entry.getKey(), (Object)am);
        }
        return new AnnotatedMethodMap((Map<MemberKey, AnnotatedMethod>)actual);
    }

    private void _addMemberMethods(TypeResolutionContext tc, Class<?> cls, Map<MemberKey, MethodBuilder> methods, Class<?> mixInCls) {
        if (mixInCls != null) {
            this._addMethodMixIns(tc, cls, methods, mixInCls);
        }
        if (cls == null) {
            return;
        }
        for (Method m : ClassUtil.getClassMethods(cls)) {
            Method old;
            if (!AnnotatedMethodCollector._isIncludableMemberMethod(m)) continue;
            MemberKey key = new MemberKey(m);
            MethodBuilder b = (MethodBuilder)methods.get((Object)key);
            if (b == null) {
                AnnotationCollector c = this._intr == null ? AnnotationCollector.emptyCollector() : this.collectAnnotations(m.getDeclaredAnnotations());
                methods.put((Object)key, (Object)new MethodBuilder(tc, m, c));
                continue;
            }
            if (this._collectAnnotations) {
                b.annotations = this.collectDefaultAnnotations(b.annotations, m.getDeclaredAnnotations());
            }
            if ((old = b.method) == null) {
                b.method = m;
                continue;
            }
            if (!Modifier.isAbstract((int)old.getModifiers()) || Modifier.isAbstract((int)m.getModifiers())) continue;
            b.method = m;
            b.typeContext = tc;
        }
    }

    protected void _addMethodMixIns(TypeResolutionContext tc, Class<?> targetClass, Map<MemberKey, MethodBuilder> methods, Class<?> mixInCls) {
        if (this._intr == null) {
            return;
        }
        for (Class mixin : ClassUtil.findRawSuperTypes(mixInCls, targetClass, true)) {
            for (Method m : mixin.getDeclaredMethods()) {
                if (!AnnotatedMethodCollector._isIncludableMemberMethod(m)) continue;
                MemberKey key = new MemberKey(m);
                MethodBuilder b = (MethodBuilder)methods.get((Object)key);
                Annotation[] anns = m.getDeclaredAnnotations();
                if (b == null) {
                    methods.put((Object)key, (Object)new MethodBuilder(tc, null, this.collectAnnotations(anns)));
                    continue;
                }
                b.annotations = this.collectDefaultAnnotations(b.annotations, anns);
            }
        }
    }

    private static boolean _isIncludableMemberMethod(Method m) {
        if (Modifier.isStatic((int)m.getModifiers()) || m.isSynthetic() || m.isBridge()) {
            return false;
        }
        return m.getParameterCount() <= 2;
    }

    private static final class MethodBuilder {
        public TypeResolutionContext typeContext;
        public Method method;
        public AnnotationCollector annotations;

        public MethodBuilder(TypeResolutionContext tc, Method m, AnnotationCollector ann) {
            this.typeContext = tc;
            this.method = m;
            this.annotations = ann;
        }

        public AnnotatedMethod build() {
            if (this.method == null) {
                return null;
            }
            return new AnnotatedMethod(this.typeContext, this.method, this.annotations.asAnnotationMap(), null);
        }
    }
}


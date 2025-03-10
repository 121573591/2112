/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.Member
 *  java.lang.reflect.Type
 *  java.util.Objects
 */
package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Objects;

public final class AnnotatedConstructor
extends AnnotatedWithParams {
    private static final long serialVersionUID = 1L;
    protected final Constructor<?> _constructor;
    protected Serialization _serialization;

    public AnnotatedConstructor(TypeResolutionContext ctxt, Constructor<?> constructor, AnnotationMap classAnn, AnnotationMap[] paramAnn) {
        super(ctxt, classAnn, paramAnn);
        this._constructor = (Constructor)Objects.requireNonNull(constructor);
    }

    protected AnnotatedConstructor(Serialization ser) {
        super(null, null, null);
        this._constructor = null;
        this._serialization = ser;
    }

    @Override
    public AnnotatedConstructor withAnnotations(AnnotationMap ann) {
        return new AnnotatedConstructor(this._typeContext, this._constructor, ann, this._paramAnnotations);
    }

    public Constructor<?> getAnnotated() {
        return this._constructor;
    }

    @Override
    public int getModifiers() {
        return this._constructor.getModifiers();
    }

    @Override
    public String getName() {
        return this._constructor.getName();
    }

    @Override
    public JavaType getType() {
        return this._typeContext.resolveType((Type)this.getRawType());
    }

    @Override
    public Class<?> getRawType() {
        return this._constructor.getDeclaringClass();
    }

    @Override
    public int getParameterCount() {
        return this._constructor.getParameterCount();
    }

    @Override
    public Class<?> getRawParameterType(int index) {
        Class[] types = this._constructor.getParameterTypes();
        return index >= types.length ? null : types[index];
    }

    @Override
    public JavaType getParameterType(int index) {
        Type[] types = this._constructor.getGenericParameterTypes();
        if (index >= types.length) {
            return null;
        }
        return this._typeContext.resolveType(types[index]);
    }

    @Override
    @Deprecated
    public Type getGenericParameterType(int index) {
        Type[] types = this._constructor.getGenericParameterTypes();
        if (index >= types.length) {
            return null;
        }
        return types[index];
    }

    @Override
    public final Object call() throws Exception {
        return this._constructor.newInstance((Object[])null);
    }

    @Override
    public final Object call(Object[] args) throws Exception {
        return this._constructor.newInstance(args);
    }

    @Override
    public final Object call1(Object arg) throws Exception {
        return this._constructor.newInstance(new Object[]{arg});
    }

    @Override
    public Class<?> getDeclaringClass() {
        return this._constructor.getDeclaringClass();
    }

    @Override
    public Member getMember() {
        return this._constructor;
    }

    @Override
    public void setValue(Object pojo, Object value) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + this.getDeclaringClass().getName());
    }

    @Override
    public Object getValue(Object pojo) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + this.getDeclaringClass().getName());
    }

    @Override
    public String toString() {
        int argCount = this._constructor.getParameterCount();
        return String.format((String)"[constructor for %s (%d arg%s), annotations: %s", (Object[])new Object[]{ClassUtil.nameOf(this._constructor.getDeclaringClass()), argCount, argCount == 1 ? "" : "s", this._annotations});
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this._constructor);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, this.getClass())) {
            return false;
        }
        AnnotatedConstructor other = (AnnotatedConstructor)o;
        return Objects.equals(this._constructor, other._constructor);
    }

    Object writeReplace() {
        return new AnnotatedConstructor(new Serialization(this._constructor));
    }

    Object readResolve() {
        Class<?> clazz = this._serialization.clazz;
        try {
            Constructor ctor = clazz.getDeclaredConstructor(this._serialization.args);
            if (!ctor.isAccessible()) {
                ClassUtil.checkAndFixAccess((Member)ctor, false);
            }
            return new AnnotatedConstructor(null, ctor, null, null);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Could not find constructor with " + this._serialization.args.length + " args from Class '" + clazz.getName());
        }
    }

    private static final class Serialization
    implements Serializable {
        private static final long serialVersionUID = 1L;
        protected Class<?> clazz;
        protected Class<?>[] args;

        public Serialization(Constructor<?> ctor) {
            this.clazz = ctor.getDeclaringClass();
            this.args = ctor.getParameterTypes();
        }
    }
}


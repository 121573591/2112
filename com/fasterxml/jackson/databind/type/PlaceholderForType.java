/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 */
package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.IdentityEqualityType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class PlaceholderForType
extends IdentityEqualityType {
    private static final long serialVersionUID = 1L;
    protected final int _ordinal;
    protected JavaType _actualType;

    public PlaceholderForType(int ordinal) {
        super(Object.class, TypeBindings.emptyBindings(), TypeFactory.unknownType(), null, 1, null, null, false);
        this._ordinal = ordinal;
    }

    public JavaType actualType() {
        return this._actualType;
    }

    public void actualType(JavaType t) {
        this._actualType = t;
    }

    @Override
    protected String buildCanonicalName() {
        return this.toString();
    }

    @Override
    public StringBuilder getGenericSignature(StringBuilder sb) {
        return this.getErasedSignature(sb);
    }

    @Override
    public StringBuilder getErasedSignature(StringBuilder sb) {
        sb.append('$').append(this._ordinal + 1);
        return sb;
    }

    @Override
    public JavaType withTypeHandler(Object h) {
        return (JavaType)this._unsupported();
    }

    @Override
    public JavaType withContentTypeHandler(Object h) {
        return (JavaType)this._unsupported();
    }

    @Override
    public JavaType withValueHandler(Object h) {
        return (JavaType)this._unsupported();
    }

    @Override
    public JavaType withContentValueHandler(Object h) {
        return (JavaType)this._unsupported();
    }

    @Override
    public JavaType withContentType(JavaType contentType) {
        return (JavaType)this._unsupported();
    }

    @Override
    public JavaType withStaticTyping() {
        return (JavaType)this._unsupported();
    }

    @Override
    public JavaType refine(Class<?> rawType, TypeBindings bindings, JavaType superClass, JavaType[] superInterfaces) {
        return (JavaType)this._unsupported();
    }

    @Override
    public boolean isContainerType() {
        return false;
    }

    @Override
    public String toString() {
        return this.getErasedSignature(new StringBuilder()).toString();
    }

    private <T> T _unsupported() {
        throw new UnsupportedOperationException("Operation should not be attempted on " + this.getClass().getName());
    }
}


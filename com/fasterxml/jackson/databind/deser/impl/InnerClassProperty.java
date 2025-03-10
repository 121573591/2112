/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Constructor
 */
package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Constructor;

public final class InnerClassProperty
extends SettableBeanProperty.Delegating {
    private static final long serialVersionUID = 1L;
    protected final transient Constructor<?> _creator;
    protected AnnotatedConstructor _annotated;

    public InnerClassProperty(SettableBeanProperty delegate, Constructor<?> ctor) {
        super(delegate);
        this._creator = ctor;
    }

    protected InnerClassProperty(SettableBeanProperty src, AnnotatedConstructor ann) {
        super(src);
        this._annotated = ann;
        Constructor<?> constructor = this._creator = this._annotated == null ? null : this._annotated.getAnnotated();
        if (this._creator == null) {
            throw new IllegalArgumentException("Missing constructor (broken JDK (de)serialization?)");
        }
    }

    @Override
    protected SettableBeanProperty withDelegate(SettableBeanProperty d) {
        if (d == this.delegate) {
            return this;
        }
        return new InnerClassProperty(d, this._creator);
    }

    @Override
    public void deserializeAndSet(JsonParser p, DeserializationContext ctxt, Object bean) throws IOException {
        Object value;
        JsonToken t = p.currentToken();
        if (t == JsonToken.VALUE_NULL) {
            value = this._valueDeserializer.getNullValue(ctxt);
        } else if (this._valueTypeDeserializer != null) {
            value = this._valueDeserializer.deserializeWithType(p, ctxt, this._valueTypeDeserializer);
        } else {
            try {
                value = this._creator.newInstance(new Object[]{bean});
            }
            catch (Exception e) {
                ClassUtil.unwrapAndThrowAsIAE(e, String.format((String)"Failed to instantiate class %s, problem: %s", (Object[])new Object[]{this._creator.getDeclaringClass().getName(), e.getMessage()}));
                value = null;
            }
            this._valueDeserializer.deserialize(p, ctxt, value);
        }
        this.set(bean, value);
    }

    @Override
    public Object deserializeSetAndReturn(JsonParser p, DeserializationContext ctxt, Object instance) throws IOException {
        return this.setAndReturn(instance, this.deserialize(p, ctxt));
    }

    Object readResolve() {
        return new InnerClassProperty((SettableBeanProperty)this, this._annotated);
    }

    Object writeReplace() {
        if (this._annotated == null) {
            return new InnerClassProperty((SettableBeanProperty)this, new AnnotatedConstructor(null, this._creator, null, null));
        }
        return this;
    }
}


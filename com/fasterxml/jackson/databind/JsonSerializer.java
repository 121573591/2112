/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.Set
 */
package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public abstract class JsonSerializer<T>
implements JsonFormatVisitable {
    public JsonSerializer<T> unwrappingSerializer(NameTransformer unwrapper) {
        return this;
    }

    public JsonSerializer<T> replaceDelegatee(JsonSerializer<?> delegatee) {
        throw new UnsupportedOperationException();
    }

    public JsonSerializer<?> withFilterId(Object filterId) {
        return this;
    }

    public JsonSerializer<?> withIgnoredProperties(Set<String> ignoredProperties) {
        return this;
    }

    public abstract void serialize(T var1, JsonGenerator var2, SerializerProvider var3) throws IOException;

    public void serializeWithType(T value, JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        Class clz = this.handledType();
        if (clz == null) {
            clz = value.getClass();
        }
        serializers.reportBadDefinition(clz, String.format((String)"Type id handling not implemented for type %s (by serializer of type %s)", (Object[])new Object[]{clz.getName(), this.getClass().getName()}));
    }

    public Class<T> handledType() {
        return null;
    }

    @Deprecated
    public boolean isEmpty(T value) {
        return this.isEmpty(null, value);
    }

    public boolean isEmpty(SerializerProvider provider, T value) {
        return value == null;
    }

    public boolean usesObjectId() {
        return false;
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public JsonSerializer<?> getDelegatee() {
        return null;
    }

    public Iterator<PropertyWriter> properties() {
        return ClassUtil.emptyIterator();
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType type) throws JsonMappingException {
        visitor.expectAnyFormat(type);
    }

    public static abstract class None
    extends JsonSerializer<Object> {
    }
}


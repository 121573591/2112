/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.util.Arrays
 *  java.util.Objects
 */
package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.NullValueProvider;
import com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@JacksonStdImpl
public class ObjectArrayDeserializer
extends ContainerDeserializerBase<Object[]>
implements ContextualDeserializer {
    private static final long serialVersionUID = 1L;
    protected final boolean _untyped;
    protected final Class<?> _elementClass;
    protected JsonDeserializer<Object> _elementDeserializer;
    protected final TypeDeserializer _elementTypeDeserializer;
    protected final Object[] _emptyValue;

    public ObjectArrayDeserializer(JavaType arrayType0, JsonDeserializer<Object> elemDeser, TypeDeserializer elemTypeDeser) {
        super(arrayType0, null, null);
        ArrayType arrayType = (ArrayType)arrayType0;
        this._elementClass = arrayType.getContentType().getRawClass();
        this._untyped = this._elementClass == Object.class;
        this._elementDeserializer = elemDeser;
        this._elementTypeDeserializer = elemTypeDeser;
        this._emptyValue = arrayType.getEmptyArray();
    }

    protected ObjectArrayDeserializer(ObjectArrayDeserializer base, JsonDeserializer<Object> elemDeser, TypeDeserializer elemTypeDeser, NullValueProvider nuller, Boolean unwrapSingle) {
        super(base, nuller, unwrapSingle);
        this._elementClass = base._elementClass;
        this._untyped = base._untyped;
        this._emptyValue = base._emptyValue;
        this._elementDeserializer = elemDeser;
        this._elementTypeDeserializer = elemTypeDeser;
    }

    public ObjectArrayDeserializer withDeserializer(TypeDeserializer elemTypeDeser, JsonDeserializer<?> elemDeser) {
        return this.withResolved(elemTypeDeser, elemDeser, this._nullProvider, this._unwrapSingle);
    }

    public ObjectArrayDeserializer withResolved(TypeDeserializer elemTypeDeser, JsonDeserializer<?> elemDeser, NullValueProvider nuller, Boolean unwrapSingle) {
        if (Objects.equals((Object)unwrapSingle, (Object)this._unwrapSingle) && nuller == this._nullProvider && elemDeser == this._elementDeserializer && elemTypeDeser == this._elementTypeDeserializer) {
            return this;
        }
        return new ObjectArrayDeserializer(this, elemDeser, elemTypeDeser, nuller, unwrapSingle);
    }

    @Override
    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    @Override
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<Object> valueDeser = this._elementDeserializer;
        Boolean unwrapSingle = this.findFormatFeature(ctxt, property, this._containerType.getRawClass(), JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        valueDeser = this.findConvertingContentDeserializer(ctxt, property, valueDeser);
        JavaType vt = this._containerType.getContentType();
        valueDeser = valueDeser == null ? ctxt.findContextualValueDeserializer(vt, property) : ctxt.handleSecondaryContextualization(valueDeser, property, vt);
        TypeDeserializer elemTypeDeser = this._elementTypeDeserializer;
        if (elemTypeDeser != null) {
            elemTypeDeser = elemTypeDeser.forProperty(property);
        }
        NullValueProvider nuller = this.findContentNullProvider(ctxt, property, valueDeser);
        return this.withResolved(elemTypeDeser, valueDeser, nuller, unwrapSingle);
    }

    @Override
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    @Override
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override
    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return this._emptyValue;
    }

    @Override
    public Object[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            return this.handleNonArray(p, ctxt);
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        Object[] chunk = buffer.resetAndStart();
        int ix = 0;
        TypeDeserializer typeDeser = this._elementTypeDeserializer;
        try {
            JsonToken t;
            while ((t = p.nextToken()) != JsonToken.END_ARRAY) {
                Object value;
                if (t == JsonToken.VALUE_NULL) {
                    if (this._skipNullValues) continue;
                    value = this._nullProvider.getNullValue(ctxt);
                } else {
                    value = typeDeser == null ? this._elementDeserializer.deserialize(p, ctxt) : this._elementDeserializer.deserializeWithType(p, ctxt, typeDeser);
                }
                if (ix >= chunk.length) {
                    chunk = buffer.appendCompletedChunk(chunk);
                    ix = 0;
                }
                chunk[ix++] = value;
            }
        }
        catch (Exception e) {
            throw JsonMappingException.wrapWithPath((Throwable)e, (Object)chunk, buffer.bufferedSize() + ix);
        }
        Object[] result = this._untyped ? buffer.completeAndClearBuffer(chunk, ix) : buffer.completeAndClearBuffer(chunk, ix, this._elementClass);
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    public Object[] deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return (Object[])typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    @Override
    public Object[] deserialize(JsonParser p, DeserializationContext ctxt, Object[] intoValue) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            Object[] arr = this.handleNonArray(p, ctxt);
            if (arr == null) {
                return intoValue;
            }
            int offset = intoValue.length;
            Object[] result = Arrays.copyOf((Object[])intoValue, (int)(offset + arr.length));
            System.arraycopy((Object)arr, (int)0, (Object)result, (int)offset, (int)arr.length);
            return result;
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        int ix = intoValue.length;
        Object[] chunk = buffer.resetAndStart(intoValue, ix);
        TypeDeserializer typeDeser = this._elementTypeDeserializer;
        try {
            JsonToken t;
            while ((t = p.nextToken()) != JsonToken.END_ARRAY) {
                Object value;
                if (t == JsonToken.VALUE_NULL) {
                    if (this._skipNullValues) continue;
                    value = this._nullProvider.getNullValue(ctxt);
                } else {
                    value = typeDeser == null ? this._elementDeserializer.deserialize(p, ctxt) : this._elementDeserializer.deserializeWithType(p, ctxt, typeDeser);
                }
                if (ix >= chunk.length) {
                    chunk = buffer.appendCompletedChunk(chunk);
                    ix = 0;
                }
                chunk[ix++] = value;
            }
        }
        catch (Exception e) {
            throw JsonMappingException.wrapWithPath((Throwable)e, (Object)chunk, buffer.bufferedSize() + ix);
        }
        Object[] result = this._untyped ? buffer.completeAndClearBuffer(chunk, ix) : buffer.completeAndClearBuffer(chunk, ix, this._elementClass);
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    protected Byte[] deserializeFromBase64(JsonParser p, DeserializationContext ctxt) throws IOException {
        byte[] b = p.getBinaryValue(ctxt.getBase64Variant());
        Byte[] result = new Byte[b.length];
        int len = b.length;
        for (int i = 0; i < len; ++i) {
            result[i] = b[i];
        }
        return result;
    }

    protected Object[] handleNonArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object value;
        boolean canWrap;
        boolean bl = canWrap = this._unwrapSingle == Boolean.TRUE || this._unwrapSingle == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        if (!canWrap) {
            if (p.hasToken(JsonToken.VALUE_STRING)) {
                if (this._elementClass == Byte.class) {
                    return this.deserializeFromBase64(p, ctxt);
                }
                return (Object[])this._deserializeFromString(p, ctxt);
            }
            return (Object[])ctxt.handleUnexpectedToken(this._containerType, p);
        }
        if (p.hasToken(JsonToken.VALUE_NULL)) {
            if (this._skipNullValues) {
                return this._emptyValue;
            }
            value = this._nullProvider.getNullValue(ctxt);
        } else {
            if (p.hasToken(JsonToken.VALUE_STRING)) {
                CoercionAction act;
                String textValue = p.getText();
                if (textValue.isEmpty()) {
                    CoercionAction act2 = ctxt.findCoercionAction(this.logicalType(), this.handledType(), CoercionInputShape.EmptyString);
                    if (act2 != CoercionAction.Fail) {
                        return (Object[])this._deserializeFromEmptyString(p, ctxt, act2, this.handledType(), "empty String (\"\")");
                    }
                } else if (ObjectArrayDeserializer._isBlank(textValue) && (act = ctxt.findCoercionFromBlankString(this.logicalType(), this.handledType(), CoercionAction.Fail)) != CoercionAction.Fail) {
                    return (Object[])this._deserializeFromEmptyString(p, ctxt, act, this.handledType(), "blank String (all whitespace)");
                }
            }
            value = this._elementTypeDeserializer == null ? this._elementDeserializer.deserialize(p, ctxt) : this._elementDeserializer.deserializeWithType(p, ctxt, this._elementTypeDeserializer);
        }
        Object[] result = this._untyped ? new Object[1] : (Object[])Array.newInstance(this._elementClass, (int)1);
        result[0] = value;
        return result;
    }
}


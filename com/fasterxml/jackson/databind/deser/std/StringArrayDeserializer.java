/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Objects
 */
package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
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
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;
import java.util.Objects;

@JacksonStdImpl
public final class StringArrayDeserializer
extends StdDeserializer<String[]>
implements ContextualDeserializer {
    private static final long serialVersionUID = 2L;
    private static final String[] NO_STRINGS = new String[0];
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    protected JsonDeserializer<String> _elementDeserializer;
    protected final NullValueProvider _nullProvider;
    protected final Boolean _unwrapSingle;
    protected final boolean _skipNullValues;

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    protected StringArrayDeserializer(JsonDeserializer<?> deser, NullValueProvider nuller, Boolean unwrapSingle) {
        super(String[].class);
        this._elementDeserializer = deser;
        this._nullProvider = nuller;
        this._unwrapSingle = unwrapSingle;
        this._skipNullValues = NullsConstantProvider.isSkipper(nuller);
    }

    @Override
    public LogicalType logicalType() {
        return LogicalType.Array;
    }

    @Override
    public Boolean supportsUpdate(DeserializationConfig config) {
        return Boolean.TRUE;
    }

    @Override
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.CONSTANT;
    }

    @Override
    public Object getEmptyValue(DeserializationContext ctxt) throws JsonMappingException {
        return NO_STRINGS;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
        JsonDeserializer<Object> deser = this._elementDeserializer;
        deser = this.findConvertingContentDeserializer(ctxt, property, deser);
        JavaType type = ctxt.constructType(String.class);
        deser = deser == null ? ctxt.findContextualValueDeserializer(type, property) : ctxt.handleSecondaryContextualization(deser, property, type);
        Boolean unwrapSingle = this.findFormatFeature(ctxt, property, String[].class, JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        NullValueProvider nuller = this.findContentNullProvider(ctxt, property, deser);
        if (deser != null && this.isDefaultDeserializer(deser)) {
            deser = null;
        }
        if (this._elementDeserializer == deser && Objects.equals((Object)this._unwrapSingle, (Object)unwrapSingle) && this._nullProvider == nuller) {
            return this;
        }
        return new StringArrayDeserializer(deser, nuller, unwrapSingle);
    }

    @Override
    public String[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            return this.handleNonArray(p, ctxt);
        }
        if (this._elementDeserializer != null) {
            return this._deserializeCustom(p, ctxt, null);
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        Object[] chunk = buffer.resetAndStart();
        int ix = 0;
        try {
            while (true) {
                String value;
                if ((value = p.nextTextValue()) == null) {
                    JsonToken t = p.currentToken();
                    if (t == JsonToken.END_ARRAY) break;
                    if (t == JsonToken.VALUE_NULL) {
                        if (this._skipNullValues) continue;
                        value = (String)this._nullProvider.getNullValue(ctxt);
                    } else {
                        value = this._parseString(p, ctxt, this._nullProvider);
                    }
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
        String[] result = buffer.completeAndClearBuffer(chunk, ix, String.class);
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    protected final String[] _deserializeCustom(JsonParser p, DeserializationContext ctxt, String[] old) throws IOException {
        Object[] chunk;
        int ix;
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        if (old == null) {
            ix = 0;
            chunk = buffer.resetAndStart();
        } else {
            ix = old.length;
            chunk = buffer.resetAndStart(old, ix);
        }
        JsonDeserializer<String> deser = this._elementDeserializer;
        try {
            while (true) {
                String value;
                if (p.nextTextValue() == null) {
                    JsonToken t = p.currentToken();
                    if (t == JsonToken.END_ARRAY) break;
                    if (t == JsonToken.VALUE_NULL) {
                        if (this._skipNullValues) continue;
                        value = (String)this._nullProvider.getNullValue(ctxt);
                    } else {
                        value = deser.deserialize(p, ctxt);
                    }
                } else {
                    value = deser.deserialize(p, ctxt);
                }
                if (ix >= chunk.length) {
                    chunk = buffer.appendCompletedChunk(chunk);
                    ix = 0;
                }
                chunk[ix++] = value;
            }
        }
        catch (Exception e) {
            throw JsonMappingException.wrapWithPath((Throwable)e, String.class, ix);
        }
        String[] result = buffer.completeAndClearBuffer(chunk, ix, String.class);
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    @Override
    public Object deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(p, ctxt);
    }

    @Override
    public String[] deserialize(JsonParser p, DeserializationContext ctxt, String[] intoValue) throws IOException {
        if (!p.isExpectedStartArrayToken()) {
            String[] arr = this.handleNonArray(p, ctxt);
            if (arr == null) {
                return intoValue;
            }
            int offset = intoValue.length;
            String[] result = new String[offset + arr.length];
            System.arraycopy((Object)intoValue, (int)0, (Object)result, (int)0, (int)offset);
            System.arraycopy((Object)arr, (int)0, (Object)result, (int)offset, (int)arr.length);
            return result;
        }
        if (this._elementDeserializer != null) {
            return this._deserializeCustom(p, ctxt, intoValue);
        }
        ObjectBuffer buffer = ctxt.leaseObjectBuffer();
        int ix = intoValue.length;
        Object[] chunk = buffer.resetAndStart(intoValue, ix);
        try {
            while (true) {
                String value;
                if ((value = p.nextTextValue()) == null) {
                    JsonToken t = p.currentToken();
                    if (t == JsonToken.END_ARRAY) break;
                    if (t == JsonToken.VALUE_NULL) {
                        if (this._skipNullValues) {
                            return NO_STRINGS;
                        }
                        value = (String)this._nullProvider.getNullValue(ctxt);
                    } else {
                        value = this._parseString(p, ctxt, this._nullProvider);
                    }
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
        String[] result = buffer.completeAndClearBuffer(chunk, ix, String.class);
        ctxt.returnObjectBuffer(buffer);
        return result;
    }

    private final String[] handleNonArray(JsonParser p, DeserializationContext ctxt) throws IOException {
        boolean canWrap;
        boolean bl = canWrap = this._unwrapSingle == Boolean.TRUE || this._unwrapSingle == null && ctxt.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        if (canWrap) {
            String value;
            if (p.hasToken(JsonToken.VALUE_NULL)) {
                value = (String)this._nullProvider.getNullValue(ctxt);
            } else {
                if (p.hasToken(JsonToken.VALUE_STRING)) {
                    CoercionAction act;
                    String textValue = p.getText();
                    if (textValue.isEmpty()) {
                        CoercionAction act2 = ctxt.findCoercionAction(this.logicalType(), this.handledType(), CoercionInputShape.EmptyString);
                        if (act2 != CoercionAction.Fail) {
                            return (String[])this._deserializeFromEmptyString(p, ctxt, act2, this.handledType(), "empty String (\"\")");
                        }
                    } else if (StringArrayDeserializer._isBlank(textValue) && (act = ctxt.findCoercionFromBlankString(this.logicalType(), this.handledType(), CoercionAction.Fail)) != CoercionAction.Fail) {
                        return (String[])this._deserializeFromEmptyString(p, ctxt, act, this.handledType(), "blank String (all whitespace)");
                    }
                }
                value = this._parseString(p, ctxt, this._nullProvider);
            }
            return new String[]{value};
        }
        if (p.hasToken(JsonToken.VALUE_STRING)) {
            return (String[])this._deserializeFromString(p, ctxt);
        }
        return (String[])ctxt.handleUnexpectedToken(this._valueClass, p);
    }
}


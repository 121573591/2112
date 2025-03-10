/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

public class UnsupportedTypeDeserializer
extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1L;
    protected final JavaType _type;
    protected final String _message;

    public UnsupportedTypeDeserializer(JavaType t, String m) {
        super(t);
        this._type = t;
        this._message = m;
    }

    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        Object value;
        if (p.currentToken() == JsonToken.VALUE_EMBEDDED_OBJECT && ((value = p.getEmbeddedObject()) == null || this._type.getRawClass().isAssignableFrom(value.getClass()))) {
            return value;
        }
        ctxt.reportBadDefinition(this._type, this._message);
        return null;
    }
}


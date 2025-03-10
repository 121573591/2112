/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.IOException;

public class RawValue
implements JsonSerializable {
    protected Object _value;

    public RawValue(String v) {
        this._value = v;
    }

    public RawValue(SerializableString v) {
        this._value = v;
    }

    public RawValue(JsonSerializable v) {
        this._value = v;
    }

    protected RawValue(Object value, boolean bogus) {
        this._value = value;
    }

    public Object rawValue() {
        return this._value;
    }

    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (this._value instanceof JsonSerializable) {
            ((JsonSerializable)this._value).serialize(gen, serializers);
        } else {
            this._serialize(gen);
        }
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        if (this._value instanceof JsonSerializable) {
            ((JsonSerializable)this._value).serializeWithType(gen, serializers, typeSer);
        } else if (this._value instanceof SerializableString) {
            this.serialize(gen, serializers);
        }
    }

    public void serialize(JsonGenerator gen) throws IOException {
        if (this._value instanceof JsonSerializable) {
            gen.writeObject(this._value);
        } else {
            this._serialize(gen);
        }
    }

    protected void _serialize(JsonGenerator gen) throws IOException {
        if (this._value instanceof SerializableString) {
            gen.writeRawValue((SerializableString)this._value);
        } else {
            gen.writeRawValue(String.valueOf((Object)this._value));
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RawValue)) {
            return false;
        }
        RawValue other = (RawValue)o;
        if (this._value == other._value) {
            return true;
        }
        return this._value != null && this._value.equals(other._value);
    }

    public int hashCode() {
        return this._value == null ? 0 : this._value.hashCode();
    }

    public String toString() {
        return String.format((String)"[RawValue of type %s]", (Object[])new Object[]{ClassUtil.classNameOf(this._value)});
    }
}


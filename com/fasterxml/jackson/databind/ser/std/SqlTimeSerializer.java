/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.reflect.Type
 *  java.sql.Time
 */
package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Time;

@JacksonStdImpl
public class SqlTimeSerializer
extends StdScalarSerializer<Time> {
    public SqlTimeSerializer() {
        super(Time.class);
    }

    @Override
    public void serialize(Time value, JsonGenerator g, SerializerProvider provider) throws IOException {
        g.writeString(value.toString());
    }

    @Override
    @Deprecated
    public JsonNode getSchema(SerializerProvider provider, Type typeHint) {
        return this.createSchemaNode("string", true);
    }

    @Override
    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper visitor, JavaType typeHint) throws JsonMappingException {
        this.visitStringFormat(visitor, typeHint, JsonValueFormat.DATE_TIME);
    }
}


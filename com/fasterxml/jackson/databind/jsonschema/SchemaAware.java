/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.reflect.Type
 */
package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.lang.reflect.Type;

@Deprecated
public interface SchemaAware {
    public JsonNode getSchema(SerializerProvider var1, Type var2) throws JsonMappingException;

    public JsonNode getSchema(SerializerProvider var1, Type var2, boolean var3) throws JsonMappingException;
}


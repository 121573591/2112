/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 */
package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

public abstract class StdNodeBasedDeserializer<T>
extends StdDeserializer<T>
implements ResolvableDeserializer {
    private static final long serialVersionUID = 1L;
    protected JsonDeserializer<Object> _treeDeserializer;

    protected StdNodeBasedDeserializer(JavaType targetType) {
        super(targetType);
    }

    protected StdNodeBasedDeserializer(Class<T> targetType) {
        super(targetType);
    }

    protected StdNodeBasedDeserializer(StdNodeBasedDeserializer<?> src) {
        super(src);
        this._treeDeserializer = src._treeDeserializer;
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws JsonMappingException {
        this._treeDeserializer = ctxt.findRootValueDeserializer(ctxt.constructType(JsonNode.class));
    }

    public abstract T convert(JsonNode var1, DeserializationContext var2) throws IOException;

    public T convert(JsonNode root, DeserializationContext ctxt, T newValue) throws IOException {
        ctxt.handleBadMerge(this);
        return this.convert(root, ctxt);
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode n = (JsonNode)this._treeDeserializer.deserialize(jp, ctxt);
        return this.convert(n, ctxt);
    }

    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt, T newValue) throws IOException {
        JsonNode n = (JsonNode)this._treeDeserializer.deserialize(jp, ctxt);
        return this.convert(n, ctxt, newValue);
    }

    @Override
    public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer td) throws IOException {
        JsonNode n = (JsonNode)this._treeDeserializer.deserializeWithType(jp, ctxt, td);
        return this.convert(n, ctxt);
    }
}


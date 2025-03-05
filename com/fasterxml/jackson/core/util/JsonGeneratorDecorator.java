/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public interface JsonGeneratorDecorator {
    public JsonGenerator decorate(JsonFactory var1, JsonGenerator var2);
}


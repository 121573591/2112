/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 */
package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

@Deprecated
public class StdKeySerializer
extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator g, SerializerProvider provider) throws IOException {
        g.writeFieldName(value.toString());
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.protobuf;

import com.google.protobuf.CheckReturnValue;
import com.google.protobuf.ExtensionSchema;
import com.google.protobuf.ExtensionSchemaLite;

@CheckReturnValue
final class ExtensionSchemas {
    private static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();
    private static final ExtensionSchema<?> FULL_SCHEMA = ExtensionSchemas.loadSchemaForFullRuntime();

    ExtensionSchemas() {
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        try {
            Class clazz = Class.forName((String)"com.google.protobuf.ExtensionSchemaFull");
            return (ExtensionSchema)clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception e) {
            return null;
        }
    }

    static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    static ExtensionSchema<?> full() {
        if (FULL_SCHEMA == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return FULL_SCHEMA;
    }
}


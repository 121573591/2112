/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.protobuf;

import com.google.protobuf.CheckReturnValue;
import com.google.protobuf.NewInstanceSchema;
import com.google.protobuf.NewInstanceSchemaLite;

@CheckReturnValue
final class NewInstanceSchemas {
    private static final NewInstanceSchema FULL_SCHEMA = NewInstanceSchemas.loadSchemaForFullRuntime();
    private static final NewInstanceSchema LITE_SCHEMA = new NewInstanceSchemaLite();

    NewInstanceSchemas() {
    }

    static NewInstanceSchema full() {
        return FULL_SCHEMA;
    }

    static NewInstanceSchema lite() {
        return LITE_SCHEMA;
    }

    private static NewInstanceSchema loadSchemaForFullRuntime() {
        try {
            Class clazz = Class.forName((String)"com.google.protobuf.NewInstanceSchemaFull");
            return (NewInstanceSchema)clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception e) {
            return null;
        }
    }
}


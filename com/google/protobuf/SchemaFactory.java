/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.google.protobuf;

import com.google.protobuf.CheckReturnValue;
import com.google.protobuf.Schema;

@CheckReturnValue
interface SchemaFactory {
    public <T> Schema<T> createSchema(Class<T> var1);
}


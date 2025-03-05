/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package com.google.protobuf;

import com.google.protobuf.CheckReturnValue;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.NewInstanceSchema;

@CheckReturnValue
final class NewInstanceSchemaLite
implements NewInstanceSchema {
    NewInstanceSchemaLite() {
    }

    @Override
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageLite)defaultInstance).newMutableInstance();
    }
}


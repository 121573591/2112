/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;

public abstract class KeyDeserializer {
    public abstract Object deserializeKey(String var1, DeserializationContext var2) throws IOException;

    public static abstract class None
    extends KeyDeserializer {
    }
}


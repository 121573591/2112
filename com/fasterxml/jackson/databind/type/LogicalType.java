/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Map
 */
package com.fasterxml.jackson.databind.type;

import java.util.Collection;
import java.util.Map;

public enum LogicalType {
    Array,
    Collection,
    Map,
    POJO,
    Untyped,
    Integer,
    Float,
    Boolean,
    Enum,
    Textual,
    Binary,
    DateTime,
    OtherScalar;


    public static LogicalType fromClass(Class<?> raw, LogicalType defaultIfNotRecognized) {
        if (raw.isEnum()) {
            return Enum;
        }
        if (raw.isArray()) {
            if (raw == byte[].class) {
                return Binary;
            }
            return Array;
        }
        if (Collection.class.isAssignableFrom(raw)) {
            return Collection;
        }
        if (Map.class.isAssignableFrom(raw)) {
            return Map;
        }
        if (raw == String.class) {
            return Textual;
        }
        return defaultIfNotRecognized;
    }
}


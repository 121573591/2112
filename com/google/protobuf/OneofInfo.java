/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.reflect.Field
 */
package com.google.protobuf;

import com.google.protobuf.CheckReturnValue;
import java.lang.reflect.Field;

@CheckReturnValue
final class OneofInfo {
    private final int id;
    private final Field caseField;
    private final Field valueField;

    public OneofInfo(int id, Field caseField, Field valueField) {
        this.id = id;
        this.caseField = caseField;
        this.valueField = valueField;
    }

    public int getId() {
        return this.id;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public Field getValueField() {
        return this.valueField;
    }
}


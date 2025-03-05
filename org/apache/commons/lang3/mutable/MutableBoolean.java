/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package org.apache.commons.lang3.mutable;

import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.mutable.Mutable;

public class MutableBoolean
implements Mutable<Boolean>,
Serializable,
Comparable<MutableBoolean> {
    private static final long serialVersionUID = -4830728138360036487L;
    private boolean value;

    public MutableBoolean() {
    }

    public MutableBoolean(boolean value) {
        this.value = value;
    }

    public MutableBoolean(Boolean value) {
        this.value = value;
    }

    public boolean booleanValue() {
        return this.value;
    }

    public int compareTo(MutableBoolean other) {
        return BooleanUtils.compare(this.value, other.value);
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableBoolean) {
            return this.value == ((MutableBoolean)obj).booleanValue();
        }
        return false;
    }

    @Override
    public Boolean getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode();
    }

    public boolean isFalse() {
        return !this.value;
    }

    public boolean isTrue() {
        return this.value;
    }

    public void setFalse() {
        this.value = false;
    }

    public void setTrue() {
        this.value = true;
    }

    @Override
    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean toBoolean() {
        return this.booleanValue();
    }

    public String toString() {
        return String.valueOf((boolean)this.value);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Float
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.lang.mutable;

import cn.hutool.core.lang.mutable.Mutable;
import cn.hutool.core.util.NumberUtil;

public class MutableFloat
extends Number
implements Comparable<MutableFloat>,
Mutable<Number> {
    private static final long serialVersionUID = 1L;
    private float value;

    public MutableFloat() {
    }

    public MutableFloat(float value) {
        this.value = value;
    }

    public MutableFloat(Number value) {
        this(value.floatValue());
    }

    public MutableFloat(String value) throws NumberFormatException {
        this.value = Float.parseFloat((String)value);
    }

    @Override
    public Float get() {
        return Float.valueOf((float)this.value);
    }

    @Override
    public void set(float value) {
        this.value = value;
    }

    @Override
    public void set(Number value) {
        this.value = value.floatValue();
    }

    public MutableFloat increment() {
        this.value += 1.0f;
        return this;
    }

    public MutableFloat decrement() {
        this.value -= 1.0f;
        return this;
    }

    public MutableFloat add(float operand) {
        this.value += operand;
        return this;
    }

    public MutableFloat add(Number operand) {
        this.value += operand.floatValue();
        return this;
    }

    public MutableFloat subtract(float operand) {
        this.value -= operand;
        return this;
    }

    public MutableFloat subtract(Number operand) {
        this.value -= operand.floatValue();
        return this;
    }

    public int intValue() {
        return (int)this.value;
    }

    public long longValue() {
        return (long)this.value;
    }

    public float floatValue() {
        return this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableFloat) {
            return Float.floatToIntBits((float)((MutableFloat)obj).value) == Float.floatToIntBits((float)this.value);
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits((float)this.value);
    }

    public int compareTo(MutableFloat other) {
        return NumberUtil.compare(this.value, other.value);
    }

    public String toString() {
        return String.valueOf((float)this.value);
    }
}


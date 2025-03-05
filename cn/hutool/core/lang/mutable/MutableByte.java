/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Byte
 *  java.lang.Comparable
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.lang.mutable;

import cn.hutool.core.lang.mutable.Mutable;
import cn.hutool.core.util.NumberUtil;

public class MutableByte
extends Number
implements Comparable<MutableByte>,
Mutable<Number> {
    private static final long serialVersionUID = 1L;
    private byte value;

    public MutableByte() {
    }

    public MutableByte(byte value) {
        this.value = value;
    }

    public MutableByte(Number value) {
        this(value.byteValue());
    }

    public MutableByte(String value) throws NumberFormatException {
        this.value = Byte.parseByte((String)value);
    }

    @Override
    public Byte get() {
        return this.value;
    }

    @Override
    public void set(byte value) {
        this.value = value;
    }

    @Override
    public void set(Number value) {
        this.value = value.byteValue();
    }

    public MutableByte increment() {
        this.value = (byte)(this.value + 1);
        return this;
    }

    public MutableByte decrement() {
        this.value = (byte)(this.value - 1);
        return this;
    }

    public MutableByte add(byte operand) {
        this.value = (byte)(this.value + operand);
        return this;
    }

    public MutableByte add(Number operand) {
        this.value = (byte)(this.value + operand.byteValue());
        return this;
    }

    public MutableByte subtract(byte operand) {
        this.value = (byte)(this.value - operand);
        return this;
    }

    public MutableByte subtract(Number operand) {
        this.value = (byte)(this.value - operand.byteValue());
        return this;
    }

    public byte byteValue() {
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return this.value;
    }

    public float floatValue() {
        return this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableByte) {
            return this.value == ((MutableByte)obj).byteValue();
        }
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    public int compareTo(MutableByte other) {
        return NumberUtil.compare(this.value, other.value);
    }

    public String toString() {
        return String.valueOf((int)this.value);
    }
}


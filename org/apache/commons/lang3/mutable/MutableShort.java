/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Short
 *  java.lang.String
 */
package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.Mutable;

public class MutableShort
extends Number
implements Comparable<MutableShort>,
Mutable<Number> {
    private static final long serialVersionUID = -2135791679L;
    private short value;

    public MutableShort() {
    }

    public MutableShort(Number value) {
        this.value = value.shortValue();
    }

    public MutableShort(short value) {
        this.value = value;
    }

    public MutableShort(String value) {
        this.value = Short.parseShort((String)value);
    }

    public void add(Number operand) {
        this.value = (short)(this.value + operand.shortValue());
    }

    public void add(short operand) {
        this.value = (short)(this.value + operand);
    }

    public short addAndGet(Number operand) {
        this.value = (short)(this.value + operand.shortValue());
        return this.value;
    }

    public short addAndGet(short operand) {
        this.value = (short)(this.value + operand);
        return this.value;
    }

    public int compareTo(MutableShort other) {
        return NumberUtils.compare(this.value, other.value);
    }

    public void decrement() {
        this.value = (short)(this.value - 1);
    }

    public short decrementAndGet() {
        this.value = (short)(this.value - 1);
        return this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MutableShort) {
            return this.value == ((MutableShort)obj).shortValue();
        }
        return false;
    }

    public float floatValue() {
        return this.value;
    }

    public short getAndAdd(Number operand) {
        short last = this.value;
        this.value = (short)(this.value + operand.shortValue());
        return last;
    }

    public short getAndAdd(short operand) {
        short last = this.value;
        this.value = (short)(this.value + operand);
        return last;
    }

    public short getAndDecrement() {
        short last = this.value;
        this.value = (short)(this.value - 1);
        return last;
    }

    public short getAndIncrement() {
        short last = this.value;
        this.value = (short)(this.value + 1);
        return last;
    }

    @Override
    public Short getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short)(this.value + 1);
    }

    public short incrementAndGet() {
        this.value = (short)(this.value + 1);
        return this.value;
    }

    public int intValue() {
        return this.value;
    }

    public long longValue() {
        return this.value;
    }

    @Override
    public void setValue(Number value) {
        this.value = value.shortValue();
    }

    @Override
    public void setValue(short value) {
        this.value = value;
    }

    public short shortValue() {
        return this.value;
    }

    public void subtract(Number operand) {
        this.value = (short)(this.value - operand.shortValue());
    }

    public void subtract(short operand) {
        this.value = (short)(this.value - operand);
    }

    public Short toShort() {
        return this.shortValue();
    }

    public String toString() {
        return String.valueOf((int)this.value);
    }
}


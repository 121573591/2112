/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.math.BigDecimal
 *  java.math.BigInteger
 */
package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.NumericNode;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class DecimalNode
extends NumericNode {
    public static final DecimalNode ZERO = new DecimalNode(BigDecimal.ZERO);
    private static final BigDecimal MIN_INTEGER = BigDecimal.valueOf((long)Integer.MIN_VALUE);
    private static final BigDecimal MAX_INTEGER = BigDecimal.valueOf((long)Integer.MAX_VALUE);
    private static final BigDecimal MIN_LONG = BigDecimal.valueOf((long)Long.MIN_VALUE);
    private static final BigDecimal MAX_LONG = BigDecimal.valueOf((long)Long.MAX_VALUE);
    protected final BigDecimal _value;

    public DecimalNode(BigDecimal v) {
        this._value = v;
    }

    public static DecimalNode valueOf(BigDecimal d) {
        return new DecimalNode(d);
    }

    @Override
    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    @Override
    public JsonParser.NumberType numberType() {
        return JsonParser.NumberType.BIG_DECIMAL;
    }

    @Override
    public boolean isFloatingPointNumber() {
        return true;
    }

    @Override
    public boolean isBigDecimal() {
        return true;
    }

    @Override
    public boolean canConvertToInt() {
        return this._value.compareTo(MIN_INTEGER) >= 0 && this._value.compareTo(MAX_INTEGER) <= 0;
    }

    @Override
    public boolean canConvertToLong() {
        return this._value.compareTo(MIN_LONG) >= 0 && this._value.compareTo(MAX_LONG) <= 0;
    }

    @Override
    public boolean canConvertToExactIntegral() {
        return this._value.signum() == 0 || this._value.scale() <= 0 || this._value.stripTrailingZeros().scale() <= 0;
    }

    @Override
    public Number numberValue() {
        return this._value;
    }

    @Override
    public short shortValue() {
        return this._value.shortValue();
    }

    @Override
    public int intValue() {
        return this._value.intValue();
    }

    @Override
    public long longValue() {
        return this._value.longValue();
    }

    @Override
    public BigInteger bigIntegerValue() {
        return this._bigIntFromBigDec(this._value);
    }

    @Override
    public float floatValue() {
        return this._value.floatValue();
    }

    @Override
    public double doubleValue() {
        return this._value.doubleValue();
    }

    @Override
    public BigDecimal decimalValue() {
        return this._value;
    }

    @Override
    public String asText() {
        return this._value.toString();
    }

    @Override
    public final void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeNumber(this._value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof DecimalNode) {
            return ((DecimalNode)o)._value.compareTo(this._value) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Double.valueOf((double)this.doubleValue()).hashCode();
    }
}


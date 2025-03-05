/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.math.BigDecimal
 *  java.math.BigInteger
 */
package cn.hutool.core.getter;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface GroupedTypeGetter {
    public String getStrByGroup(String var1, String var2);

    public Integer getIntByGroup(String var1, String var2);

    public Short getShortByGroup(String var1, String var2);

    public Boolean getBoolByGroup(String var1, String var2);

    public Long getLongByGroup(String var1, String var2);

    public Character getCharByGroup(String var1, String var2);

    public Double getDoubleByGroup(String var1, String var2);

    public Byte getByteByGroup(String var1, String var2);

    public BigDecimal getBigDecimalByGroup(String var1, String var2);

    public BigInteger getBigIntegerByGroup(String var1, String var2);
}


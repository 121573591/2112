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

public interface ArrayTypeGetter {
    public String[] getObjs(String var1);

    public String[] getStrs(String var1);

    public Integer[] getInts(String var1);

    public Short[] getShorts(String var1);

    public Boolean[] getBools(String var1);

    public Long[] getLongs(String var1);

    public Character[] getChars(String var1);

    public Double[] getDoubles(String var1);

    public Byte[] getBytes(String var1);

    public BigInteger[] getBigIntegers(String var1);

    public BigDecimal[] getBigDecimals(String var1);
}


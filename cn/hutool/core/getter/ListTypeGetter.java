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
 *  java.util.List
 */
package cn.hutool.core.getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface ListTypeGetter {
    public List<Object> getObjList(String var1);

    public List<String> getStrList(String var1);

    public List<Integer> getIntList(String var1);

    public List<Short> getShortList(String var1);

    public List<Boolean> getBoolList(String var1);

    public List<Long> getLongList(String var1);

    public List<Character> getCharList(String var1);

    public List<Double> getDoubleList(String var1);

    public List<Byte> getByteList(String var1);

    public List<BigDecimal> getBigDecimalList(String var1);

    public List<BigInteger> getBigIntegerList(String var1);
}


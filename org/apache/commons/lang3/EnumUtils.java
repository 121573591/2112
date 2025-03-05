/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.SafeVarargs
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.EnumSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Objects
 *  java.util.function.Function
 *  java.util.stream.Collectors
 *  java.util.stream.Stream
 */
package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

public class EnumUtils {
    private static final String CANNOT_STORE_S_S_VALUES_IN_S_BITS = "Cannot store %s %s values in %s bits";
    private static final String ENUM_CLASS_MUST_BE_DEFINED = "EnumClass must be defined.";
    private static final String NULL_ELEMENTS_NOT_PERMITTED = "null elements not permitted";
    private static final String S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE = "%s does not seem to be an Enum type";

    private static <E extends Enum<E>> Class<E> asEnum(Class<E> enumClass) {
        Objects.requireNonNull(enumClass, (String)ENUM_CLASS_MUST_BE_DEFINED);
        Validate.isTrue(enumClass.isEnum(), S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE, enumClass);
        return enumClass;
    }

    private static <E extends Enum<E>> Class<E> checkBitVectorable(Class<E> enumClass) {
        Enum[] constants = (Enum[])EnumUtils.asEnum(enumClass).getEnumConstants();
        Validate.isTrue(constants.length <= 64, CANNOT_STORE_S_S_VALUES_IN_S_BITS, constants.length, enumClass.getSimpleName(), 64);
        return enumClass;
    }

    @SafeVarargs
    public static <E extends Enum<E>> long generateBitVector(Class<E> enumClass, E ... values) {
        Validate.noNullElements(values);
        return EnumUtils.generateBitVector(enumClass, Arrays.asList((Object[])values));
    }

    public static <E extends Enum<E>> long generateBitVector(Class<E> enumClass, Iterable<? extends E> values) {
        EnumUtils.checkBitVectorable(enumClass);
        Objects.requireNonNull(values, (String)"values");
        long total = 0L;
        for (Enum constant : values) {
            Objects.requireNonNull((Object)constant, (String)NULL_ELEMENTS_NOT_PERMITTED);
            total |= 1L << constant.ordinal();
        }
        return total;
    }

    @SafeVarargs
    public static <E extends Enum<E>> long[] generateBitVectors(Class<E> enumClass, E ... values) {
        EnumUtils.asEnum(enumClass);
        Validate.noNullElements(values);
        EnumSet condensed = EnumSet.noneOf(enumClass);
        Collections.addAll((Collection)condensed, (Object[])values);
        long[] result = new long[(((Enum[])enumClass.getEnumConstants()).length - 1) / 64 + 1];
        for (Enum value : condensed) {
            int n = value.ordinal() / 64;
            result[n] = result[n] | 1L << value.ordinal() % 64;
        }
        ArrayUtils.reverse(result);
        return result;
    }

    public static <E extends Enum<E>> long[] generateBitVectors(Class<E> enumClass, Iterable<? extends E> values) {
        EnumUtils.asEnum(enumClass);
        Objects.requireNonNull(values, (String)"values");
        EnumSet condensed = EnumSet.noneOf(enumClass);
        values.forEach(constant -> condensed.add((Object)((Enum)Objects.requireNonNull((Object)constant, (String)NULL_ELEMENTS_NOT_PERMITTED))));
        long[] result = new long[(((Enum[])enumClass.getEnumConstants()).length - 1) / 64 + 1];
        for (Enum value : condensed) {
            int n = value.ordinal() / 64;
            result[n] = result[n] | 1L << value.ordinal() % 64;
        }
        ArrayUtils.reverse(result);
        return result;
    }

    public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName) {
        return EnumUtils.getEnum(enumClass, enumName, null);
    }

    public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName, E defaultEnum) {
        if (enumName == null) {
            return defaultEnum;
        }
        try {
            return (E)Enum.valueOf(enumClass, (String)enumName);
        }
        catch (IllegalArgumentException ex) {
            return defaultEnum;
        }
    }

    public static <E extends Enum<E>> E getEnumIgnoreCase(Class<E> enumClass, String enumName) {
        return EnumUtils.getEnumIgnoreCase(enumClass, enumName, null);
    }

    public static <E extends Enum<E>> E getEnumIgnoreCase(Class<E> enumClass, String enumName, E defaultEnum) {
        return EnumUtils.getFirstEnumIgnoreCase(enumClass, enumName, Enum::name, defaultEnum);
    }

    public static <E extends Enum<E>> List<E> getEnumList(Class<E> enumClass) {
        return new ArrayList((Collection)Arrays.asList((Object[])((Enum[])enumClass.getEnumConstants())));
    }

    public static <E extends Enum<E>> Map<String, E> getEnumMap(Class<E> enumClass) {
        return EnumUtils.getEnumMap(enumClass, Enum::name);
    }

    public static <E extends Enum<E>, K> Map<K, E> getEnumMap(Class<E> enumClass, Function<E, K> keyFunction) {
        return (Map)Stream.of((Object[])((Enum[])enumClass.getEnumConstants())).collect(Collectors.toMap(arg_0 -> keyFunction.apply(arg_0), (Function)Function.identity()));
    }

    public static <E extends Enum<E>> E getEnumSystemProperty(Class<E> enumClass, String propName, E defaultEnum) {
        return enumClass == null || propName == null ? defaultEnum : EnumUtils.getEnum(enumClass, System.getProperty((String)propName), defaultEnum);
    }

    public static <E extends Enum<E>> E getFirstEnumIgnoreCase(Class<E> enumClass, String enumName, Function<E, String> stringFunction, E defaultEnum) {
        if (enumName == null || !enumClass.isEnum()) {
            return defaultEnum;
        }
        return (E)((Enum)Stream.of((Object[])((Enum[])enumClass.getEnumConstants())).filter(e -> enumName.equalsIgnoreCase((String)stringFunction.apply(e))).findFirst().orElse(defaultEnum));
    }

    public static <E extends Enum<E>> boolean isValidEnum(Class<E> enumClass, String enumName) {
        return EnumUtils.getEnum(enumClass, enumName) != null;
    }

    public static <E extends Enum<E>> boolean isValidEnumIgnoreCase(Class<E> enumClass, String enumName) {
        return EnumUtils.getEnumIgnoreCase(enumClass, enumName) != null;
    }

    public static <E extends Enum<E>> EnumSet<E> processBitVector(Class<E> enumClass, long value) {
        EnumUtils.checkBitVectorable(enumClass).getEnumConstants();
        return EnumUtils.processBitVectors(enumClass, value);
    }

    public static <E extends Enum<E>> EnumSet<E> processBitVectors(Class<E> enumClass, long ... values) {
        EnumSet results = EnumSet.noneOf(EnumUtils.asEnum(enumClass));
        long[] lvalues = ArrayUtils.clone((long[])Objects.requireNonNull((Object)values, (String)"values"));
        ArrayUtils.reverse(lvalues);
        for (Enum constant : (Enum[])enumClass.getEnumConstants()) {
            int block = constant.ordinal() / 64;
            if (block >= lvalues.length || (lvalues[block] & 1L << constant.ordinal() % 64) == 0L) continue;
            results.add((Object)constant);
        }
        return results;
    }
}


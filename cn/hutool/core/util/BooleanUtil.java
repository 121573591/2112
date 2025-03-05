/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.util.Set
 */
package cn.hutool.core.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Set;

public class BooleanUtil {
    private static final Set<String> TRUE_SET = CollUtil.newHashSet("true", "yes", "y", "t", "ok", "1", "on", "是", "对", "真", "對", "√");
    private static final Set<String> FALSE_SET = CollUtil.newHashSet("false", "no", "n", "f", "0", "off", "否", "错", "假", "錯", "×");

    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool != false ? Boolean.FALSE : Boolean.TRUE;
    }

    public static boolean isTrue(Boolean bool) {
        return Boolean.TRUE.equals((Object)bool);
    }

    public static boolean isFalse(Boolean bool) {
        return Boolean.FALSE.equals((Object)bool);
    }

    public static boolean negate(boolean bool) {
        return !bool;
    }

    public static boolean toBoolean(String valueStr) {
        if (StrUtil.isNotBlank(valueStr)) {
            valueStr = valueStr.trim().toLowerCase();
            return TRUE_SET.contains((Object)valueStr);
        }
        return false;
    }

    public static Boolean toBooleanObject(String valueStr) {
        if (StrUtil.isNotBlank(valueStr)) {
            if (TRUE_SET.contains((Object)(valueStr = valueStr.trim().toLowerCase()))) {
                return true;
            }
            if (FALSE_SET.contains((Object)valueStr)) {
                return false;
            }
        }
        return null;
    }

    public static int toInt(boolean value) {
        return value ? 1 : 0;
    }

    public static Integer toInteger(boolean value) {
        return BooleanUtil.toInt(value);
    }

    public static char toChar(boolean value) {
        return (char)BooleanUtil.toInt(value);
    }

    public static Character toCharacter(boolean value) {
        return Character.valueOf((char)BooleanUtil.toChar(value));
    }

    public static byte toByte(boolean value) {
        return (byte)BooleanUtil.toInt(value);
    }

    public static Byte toByteObj(boolean value) {
        return BooleanUtil.toByte(value);
    }

    public static long toLong(boolean value) {
        return BooleanUtil.toInt(value);
    }

    public static Long toLongObj(boolean value) {
        return BooleanUtil.toLong(value);
    }

    public static short toShort(boolean value) {
        return (short)BooleanUtil.toInt(value);
    }

    public static Short toShortObj(boolean value) {
        return BooleanUtil.toShort(value);
    }

    public static float toFloat(boolean value) {
        return BooleanUtil.toInt(value);
    }

    public static Float toFloatObj(boolean value) {
        return Float.valueOf((float)BooleanUtil.toFloat(value));
    }

    public static double toDouble(boolean value) {
        return BooleanUtil.toInt(value);
    }

    public static Double toDoubleObj(boolean value) {
        return BooleanUtil.toDouble(value);
    }

    public static String toStringTrueFalse(boolean bool) {
        return BooleanUtil.toString(bool, "true", "false");
    }

    public static String toStringOnOff(boolean bool) {
        return BooleanUtil.toString(bool, "on", "off");
    }

    public static String toStringYesNo(boolean bool) {
        return BooleanUtil.toString(bool, "yes", "no");
    }

    public static String toString(boolean bool, String trueString, String falseString) {
        return bool ? trueString : falseString;
    }

    public static String toString(Boolean bool, String trueString, String falseString, String nullString) {
        if (bool == null) {
            return nullString;
        }
        return bool != false ? trueString : falseString;
    }

    public static boolean and(boolean ... array) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        for (boolean element : array) {
            if (element) continue;
            return false;
        }
        return true;
    }

    public static Boolean andOfWrap(Boolean ... array) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        for (Boolean b : array) {
            if (!BooleanUtil.isFalse(b)) continue;
            return false;
        }
        return true;
    }

    public static boolean or(boolean ... array) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        for (boolean element : array) {
            if (!element) continue;
            return true;
        }
        return false;
    }

    public static Boolean orOfWrap(Boolean ... array) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        for (Boolean b : array) {
            if (!BooleanUtil.isTrue(b)) continue;
            return true;
        }
        return false;
    }

    public static boolean xor(boolean ... array) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty");
        }
        boolean result = false;
        for (boolean element : array) {
            result ^= element;
        }
        return result;
    }

    public static Boolean xorOfWrap(Boolean ... array) {
        if (ArrayUtil.isEmpty(array)) {
            throw new IllegalArgumentException("The Array must not be empty !");
        }
        boolean[] primitive = Convert.convert(boolean[].class, (Object)array);
        return BooleanUtil.xor(primitive);
    }

    public static boolean isBoolean(Class<?> clazz) {
        return clazz == Boolean.class || clazz == Boolean.TYPE;
    }
}


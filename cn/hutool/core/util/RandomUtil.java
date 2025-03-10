/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
 *  java.math.RoundingMode
 *  java.security.NoSuchAlgorithmException
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Random
 *  java.util.Set
 *  java.util.concurrent.ThreadLocalRandom
 */
package cn.hutool.core.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.WeightRandom;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {
    public static final String BASE_NUMBER = "0123456789";
    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String BASE_CHAR_NUMBER_LOWER = "abcdefghijklmnopqrstuvwxyz0123456789";
    public static final String BASE_CHAR_NUMBER = "abcdefghijklmnopqrstuvwxyz".toUpperCase() + "abcdefghijklmnopqrstuvwxyz0123456789";

    public static ThreadLocalRandom getRandom() {
        return ThreadLocalRandom.current();
    }

    public static SecureRandom createSecureRandom(byte[] seed) {
        return null == seed ? new SecureRandom() : new SecureRandom(seed);
    }

    public static SecureRandom getSecureRandom() {
        return RandomUtil.getSecureRandom(null);
    }

    public static SecureRandom getSecureRandom(byte[] seed) {
        return RandomUtil.createSecureRandom(seed);
    }

    public static SecureRandom getSHA1PRNGRandom(byte[] seed) {
        SecureRandom random;
        try {
            random = SecureRandom.getInstance((String)"SHA1PRNG");
        }
        catch (NoSuchAlgorithmException e) {
            throw new UtilException(e);
        }
        if (null != seed) {
            random.setSeed(seed);
        }
        return random;
    }

    public static SecureRandom getSecureRandomStrong() {
        try {
            return SecureRandom.getInstanceStrong();
        }
        catch (NoSuchAlgorithmException e) {
            throw new UtilException(e);
        }
    }

    public static Random getRandom(boolean isSecure) {
        return isSecure ? RandomUtil.getSecureRandom() : RandomUtil.getRandom();
    }

    public static boolean randomBoolean() {
        return 0 == RandomUtil.randomInt(2);
    }

    public static byte[] randomBytes(int length) {
        byte[] bytes = new byte[length];
        RandomUtil.getRandom().nextBytes(bytes);
        return bytes;
    }

    public static int randomInt() {
        return RandomUtil.getRandom().nextInt();
    }

    public static int randomInt(int limitExclude) {
        return RandomUtil.getRandom().nextInt(limitExclude);
    }

    public static int randomInt(int minInclude, int maxExclude) {
        return RandomUtil.randomInt(minInclude, maxExclude, true, false);
    }

    public static int randomInt(int min, int max, boolean includeMin, boolean includeMax) {
        if (!includeMin) {
            ++min;
        }
        if (includeMax) {
            ++max;
        }
        return RandomUtil.getRandom().nextInt(min, max);
    }

    public static int[] randomInts(int length) {
        int[] range = ArrayUtil.range(length);
        for (int i = 0; i < length; ++i) {
            int random = RandomUtil.randomInt(i, length);
            ArrayUtil.swap(range, i, random);
        }
        return range;
    }

    public static long randomLong() {
        return RandomUtil.getRandom().nextLong();
    }

    public static long randomLong(long limitExclude) {
        return RandomUtil.getRandom().nextLong(limitExclude);
    }

    public static long randomLong(long minInclude, long maxExclude) {
        return RandomUtil.randomLong(minInclude, maxExclude, true, false);
    }

    public static long randomLong(long min, long max, boolean includeMin, boolean includeMax) {
        if (!includeMin) {
            ++min;
        }
        if (includeMax) {
            ++max;
        }
        return RandomUtil.getRandom().nextLong(min, max);
    }

    public static float randomFloat() {
        return RandomUtil.getRandom().nextFloat();
    }

    public static float randomFloat(float limitExclude) {
        return RandomUtil.randomFloat(0.0f, limitExclude);
    }

    public static float randomFloat(float minInclude, float maxExclude) {
        if (minInclude == maxExclude) {
            return minInclude;
        }
        return minInclude + (maxExclude - minInclude) * RandomUtil.getRandom().nextFloat();
    }

    public static double randomDouble(double minInclude, double maxExclude) {
        return RandomUtil.getRandom().nextDouble(minInclude, maxExclude);
    }

    public static double randomDouble(double minInclude, double maxExclude, int scale, RoundingMode roundingMode) {
        return NumberUtil.round(RandomUtil.randomDouble(minInclude, maxExclude), scale, roundingMode).doubleValue();
    }

    public static double randomDouble() {
        return RandomUtil.getRandom().nextDouble();
    }

    public static double randomDouble(int scale, RoundingMode roundingMode) {
        return NumberUtil.round(RandomUtil.randomDouble(), scale, roundingMode).doubleValue();
    }

    public static double randomDouble(double limit) {
        return RandomUtil.getRandom().nextDouble(limit);
    }

    public static double randomDouble(double limit, int scale, RoundingMode roundingMode) {
        return NumberUtil.round(RandomUtil.randomDouble(limit), scale, roundingMode).doubleValue();
    }

    public static BigDecimal randomBigDecimal() {
        return NumberUtil.toBigDecimal((Number)Double.valueOf((double)RandomUtil.getRandom().nextDouble()));
    }

    public static BigDecimal randomBigDecimal(BigDecimal limit) {
        return NumberUtil.toBigDecimal((Number)Double.valueOf((double)RandomUtil.getRandom().nextDouble(limit.doubleValue())));
    }

    public static BigDecimal randomBigDecimal(BigDecimal minInclude, BigDecimal maxExclude) {
        return NumberUtil.toBigDecimal((Number)Double.valueOf((double)RandomUtil.getRandom().nextDouble(minInclude.doubleValue(), maxExclude.doubleValue())));
    }

    public static <T> T randomEle(List<T> list) {
        return RandomUtil.randomEle(list, list.size());
    }

    public static <T> T randomEle(List<T> list, int limit) {
        if (list.size() < limit) {
            limit = list.size();
        }
        return (T)list.get(RandomUtil.randomInt(limit));
    }

    public static <T> T randomEle(T[] array) {
        return RandomUtil.randomEle(array, array.length);
    }

    public static <T> T randomEle(T[] array, int limit) {
        if (array.length < limit) {
            limit = array.length;
        }
        return array[RandomUtil.randomInt(limit)];
    }

    public static <T> List<T> randomEles(List<T> list, int count) {
        ArrayList result = new ArrayList(count);
        int limit = list.size();
        while (result.size() < count) {
            result.add(RandomUtil.randomEle(list, limit));
        }
        return result;
    }

    public static <T> List<T> randomEleList(List<T> source2, int count) {
        if (count >= source2.size()) {
            return ListUtil.toList(source2);
        }
        int[] randomList = ArrayUtil.sub(RandomUtil.randomInts(source2.size()), 0, count);
        ArrayList result = new ArrayList();
        for (int e : randomList) {
            result.add(source2.get(e));
        }
        return result;
    }

    public static <T> Set<T> randomEleSet(Collection<T> collection, int count) {
        ArrayList<T> source2 = CollUtil.distinct(collection);
        if (count > source2.size()) {
            throw new IllegalArgumentException("Count is larger than collection distinct size !");
        }
        LinkedHashSet result = new LinkedHashSet(count);
        int limit = source2.size();
        while (result.size() < count) {
            result.add(RandomUtil.randomEle(source2, limit));
        }
        return result;
    }

    public static String randomString(int length) {
        return RandomUtil.randomString(BASE_CHAR_NUMBER, length);
    }

    public static String randomStringUpper(int length) {
        return RandomUtil.randomString(BASE_CHAR_NUMBER, length).toUpperCase();
    }

    public static String randomStringWithoutStr(int length, String elemData) {
        String baseStr = BASE_CHAR_NUMBER;
        baseStr = StrUtil.removeAll((CharSequence)baseStr, elemData.toLowerCase().toCharArray());
        return RandomUtil.randomString(baseStr, length);
    }

    public static String randomNumbers(int length) {
        return RandomUtil.randomString(BASE_NUMBER, length);
    }

    public static String randomString(String baseString, int length) {
        if (StrUtil.isEmpty(baseString)) {
            return "";
        }
        if (length < 1) {
            length = 1;
        }
        StringBuilder sb = new StringBuilder(length);
        int baseLength = baseString.length();
        for (int i = 0; i < length; ++i) {
            int number = RandomUtil.randomInt(baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }

    public static char randomChinese() {
        return (char)RandomUtil.randomInt(19968, 40959);
    }

    public static char randomNumber() {
        return RandomUtil.randomChar(BASE_NUMBER);
    }

    public static char randomChar() {
        return RandomUtil.randomChar(BASE_CHAR_NUMBER);
    }

    public static char randomChar(String baseString) {
        return baseString.charAt(RandomUtil.randomInt(baseString.length()));
    }

    public static <T> WeightRandom<T> weightRandom(WeightRandom.WeightObj<T>[] weightObjs) {
        return new WeightRandom<T>(weightObjs);
    }

    public static <T> WeightRandom<T> weightRandom(Iterable<WeightRandom.WeightObj<T>> weightObjs) {
        return new WeightRandom<T>(weightObjs);
    }

    public static DateTime randomDay(int min, int max) {
        return RandomUtil.randomDate(DateUtil.date(), DateField.DAY_OF_YEAR, min, max);
    }

    public static DateTime randomDate(Date baseDate, DateField dateField, int min, int max) {
        if (null == baseDate) {
            baseDate = DateUtil.date();
        }
        return DateUtil.offset(baseDate, dateField, RandomUtil.randomInt(min, max));
    }
}


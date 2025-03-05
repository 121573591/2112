/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.regex.Pattern
 */
package cn.hutool.core.util;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.map.SafeConcurrentHashMap;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Map;
import java.util.regex.Pattern;

public class CreditCodeUtil {
    public static final Pattern CREDIT_CODE_PATTERN = PatternPool.CREDIT_CODE;
    private static final int[] WEIGHT = new int[]{1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
    private static final char[] BASE_CODE_ARRAY = "0123456789ABCDEFGHJKLMNPQRTUWXY".toCharArray();
    private static final Map<Character, Integer> CODE_INDEX_MAP = new SafeConcurrentHashMap(BASE_CODE_ARRAY.length);

    public static boolean isCreditCodeSimple(CharSequence creditCode) {
        if (StrUtil.isBlank(creditCode)) {
            return false;
        }
        return ReUtil.isMatch(CREDIT_CODE_PATTERN, creditCode);
    }

    public static boolean isCreditCode(CharSequence creditCode) {
        if (!CreditCodeUtil.isCreditCodeSimple(creditCode)) {
            return false;
        }
        int parityBit = CreditCodeUtil.getParityBit(creditCode);
        if (parityBit < 0) {
            return false;
        }
        return creditCode.charAt(17) == BASE_CODE_ARRAY[parityBit];
    }

    public static String randomCreditCode() {
        int num;
        int i;
        StringBuilder buf = new StringBuilder(18);
        for (i = 0; i < 2; ++i) {
            num = RandomUtil.randomInt(BASE_CODE_ARRAY.length - 1);
            buf.append(Character.toUpperCase((char)BASE_CODE_ARRAY[num]));
        }
        for (i = 2; i < 8; ++i) {
            num = RandomUtil.randomInt(10);
            buf.append(BASE_CODE_ARRAY[num]);
        }
        for (i = 8; i < 17; ++i) {
            num = RandomUtil.randomInt(BASE_CODE_ARRAY.length - 1);
            buf.append(BASE_CODE_ARRAY[num]);
        }
        String code = buf.toString();
        return code + BASE_CODE_ARRAY[CreditCodeUtil.getParityBit(code)];
    }

    private static int getParityBit(CharSequence creditCode) {
        int sum = 0;
        for (int i = 0; i < 17; ++i) {
            Integer codeIndex = (Integer)CODE_INDEX_MAP.get((Object)Character.valueOf((char)creditCode.charAt(i)));
            if (null == codeIndex) {
                return -1;
            }
            sum += codeIndex * WEIGHT[i];
        }
        int result = 31 - sum % 31;
        return result == 31 ? 0 : result;
    }

    static {
        for (int i = 0; i < BASE_CODE_ARRAY.length; ++i) {
            CODE_INDEX_MAP.put((Object)Character.valueOf((char)BASE_CODE_ARRAY[i]), (Object)i);
        }
    }
}


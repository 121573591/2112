/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 */
package cn.hutool.core.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IdcardUtil {
    private static final int CHINA_ID_MIN_LENGTH = 15;
    private static final int CHINA_ID_MAX_LENGTH = 18;
    private static final int[] POWER = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final Map<String, String> CITY_CODES = new HashMap();
    private static final Map<Character, Integer> TW_FIRST_CODE = new HashMap();

    public static String convert15To18(String idCard) {
        int sYear;
        if (idCard.length() != 15) {
            return null;
        }
        if (ReUtil.isMatch(PatternPool.NUMBERS, (CharSequence)idCard)) {
            String birthday = idCard.substring(6, 12);
            DateTime birthDate = DateUtil.parse((CharSequence)birthday, "yyMMdd");
            sYear = DateUtil.year(birthDate);
            if (sYear > 2000) {
                sYear -= 100;
            }
        } else {
            return null;
        }
        StringBuilder idCard18 = StrUtil.builder().append((CharSequence)idCard, 0, 6).append(sYear).append(idCard.substring(8));
        char sVal = IdcardUtil.getCheckCode18(idCard18.toString());
        idCard18.append(sVal);
        return idCard18.toString();
    }

    public static String convert18To15(String idCard) {
        if (StrUtil.isNotBlank(idCard) && IdcardUtil.isValidCard18(idCard)) {
            return idCard.substring(0, 6) + idCard.substring(8, idCard.length() - 1);
        }
        return idCard;
    }

    public static boolean isValidCard(String idCard) {
        if (StrUtil.isBlank(idCard)) {
            return false;
        }
        int length = idCard.length();
        switch (length) {
            case 18: {
                return IdcardUtil.isValidCard18(idCard);
            }
            case 15: {
                return IdcardUtil.isValidCard15(idCard);
            }
            case 10: {
                String[] cardVal = IdcardUtil.isValidCard10(idCard);
                return null != cardVal && "true".equals((Object)cardVal[2]);
            }
        }
        return false;
    }

    public static boolean isValidCard18(String idcard) {
        return IdcardUtil.isValidCard18(idcard, true);
    }

    public static boolean isValidCard18(String idcard, boolean ignoreCase) {
        if (idcard == null) {
            return false;
        }
        if (18 != idcard.length()) {
            return false;
        }
        String proCode = idcard.substring(0, 2);
        if (null == CITY_CODES.get((Object)proCode)) {
            return false;
        }
        if (!Validator.isBirthday(idcard.substring(6, 14))) {
            return false;
        }
        String code17 = idcard.substring(0, 17);
        if (ReUtil.isMatch(PatternPool.NUMBERS, (CharSequence)code17)) {
            char val = IdcardUtil.getCheckCode18(code17);
            return CharUtil.equals(val, idcard.charAt(17), ignoreCase);
        }
        return false;
    }

    public static boolean isValidCard15(String idcard) {
        if (idcard == null) {
            return false;
        }
        if (15 != idcard.length()) {
            return false;
        }
        if (ReUtil.isMatch(PatternPool.NUMBERS, (CharSequence)idcard)) {
            String proCode = idcard.substring(0, 2);
            if (null == CITY_CODES.get((Object)proCode)) {
                return false;
            }
            return false != Validator.isBirthday("19" + idcard.substring(6, 12));
        }
        return false;
    }

    public static String[] isValidCard10(String idcard) {
        if (StrUtil.isBlank(idcard)) {
            return null;
        }
        String[] info = new String[3];
        String card = idcard.replaceAll("[()]", "");
        if (card.length() != 8 && card.length() != 9 && idcard.length() != 10) {
            return null;
        }
        if (idcard.matches("^[a-zA-Z][0-9]{9}$")) {
            info[0] = "台湾";
            char char2 = idcard.charAt(1);
            if ('1' == char2) {
                info[1] = "M";
            } else if ('2' == char2) {
                info[1] = "F";
            } else {
                info[1] = "N";
                info[2] = "false";
                return info;
            }
            info[2] = IdcardUtil.isValidTWCard(idcard) ? "true" : "false";
        } else if (idcard.matches("^[157][0-9]{6}\\(?[0-9A-Z]\\)?$")) {
            info[0] = "澳门";
            info[1] = "N";
            info[2] = "true";
        } else if (idcard.matches("^[A-Z]{1,2}[0-9]{6}\\(?[0-9A]\\)?$")) {
            info[0] = "香港";
            info[1] = "N";
            info[2] = IdcardUtil.isValidHKCard(idcard) ? "true" : "false";
        } else {
            return null;
        }
        return info;
    }

    public static boolean isValidTWCard(String idcard) {
        if (null == idcard || idcard.length() != 10) {
            return false;
        }
        Integer iStart = (Integer)TW_FIRST_CODE.get((Object)Character.valueOf((char)idcard.charAt(0)));
        if (null == iStart) {
            return false;
        }
        int sum = iStart / 10 + iStart % 10 * 9;
        String mid = idcard.substring(1, 9);
        char[] chars = mid.toCharArray();
        int iflag = 8;
        for (char c : chars) {
            sum += Integer.parseInt((String)String.valueOf((char)c)) * iflag;
            --iflag;
        }
        String end = idcard.substring(9, 10);
        return (sum % 10 == 0 ? 0 : 10 - sum % 10) == Integer.parseInt((String)end);
    }

    public static boolean isValidHKCard(String idcard) {
        int sum;
        String card = idcard.replaceAll("[()]", "");
        if (card.length() == 9) {
            sum = (Character.toUpperCase((char)card.charAt(0)) - 55) * 9 + (Character.toUpperCase((char)card.charAt(1)) - 55) * 8;
            card = card.substring(1, 9);
        } else {
            sum = 522 + (Character.toUpperCase((char)card.charAt(0)) - 55) * 8;
        }
        String mid = card.substring(1, 7);
        String end = card.substring(7, 8);
        char[] chars = mid.toCharArray();
        int iflag = 7;
        for (char c : chars) {
            sum += Integer.parseInt((String)String.valueOf((char)c)) * iflag;
            --iflag;
        }
        sum = "A".equalsIgnoreCase(end) ? (sum += 10) : (sum += Integer.parseInt((String)end));
        return sum % 11 == 0;
    }

    public static String getBirthByIdCard(String idcard) {
        return IdcardUtil.getBirth(idcard);
    }

    public static String getBirth(String idCard) {
        Assert.notBlank(idCard, "id card must be not blank!", new Object[0]);
        int len = idCard.length();
        if (len < 15) {
            return null;
        }
        if (len == 15) {
            idCard = IdcardUtil.convert15To18(idCard);
        }
        return ((String)Objects.requireNonNull((Object)idCard)).substring(6, 14);
    }

    public static DateTime getBirthDate(String idCard) {
        String birthByIdCard = IdcardUtil.getBirthByIdCard(idCard);
        return null == birthByIdCard ? null : DateUtil.parse((CharSequence)birthByIdCard, DatePattern.PURE_DATE_FORMAT);
    }

    public static int getAgeByIdCard(String idcard) {
        return IdcardUtil.getAgeByIdCard(idcard, DateUtil.date());
    }

    public static int getAgeByIdCard(String idcard, Date dateToCompare) {
        String birth = IdcardUtil.getBirthByIdCard(idcard);
        return DateUtil.age(DateUtil.parse((CharSequence)birth, "yyyyMMdd"), dateToCompare);
    }

    public static Short getYearByIdCard(String idcard) {
        int len = idcard.length();
        if (len < 15) {
            return null;
        }
        if (len == 15) {
            idcard = IdcardUtil.convert15To18(idcard);
        }
        return Short.valueOf((String)((String)Objects.requireNonNull((Object)idcard)).substring(6, 10));
    }

    public static Short getMonthByIdCard(String idcard) {
        int len = idcard.length();
        if (len < 15) {
            return null;
        }
        if (len == 15) {
            idcard = IdcardUtil.convert15To18(idcard);
        }
        return Short.valueOf((String)((String)Objects.requireNonNull((Object)idcard)).substring(10, 12));
    }

    public static Short getDayByIdCard(String idcard) {
        int len = idcard.length();
        if (len < 15) {
            return null;
        }
        if (len == 15) {
            idcard = IdcardUtil.convert15To18(idcard);
        }
        return Short.valueOf((String)((String)Objects.requireNonNull((Object)idcard)).substring(12, 14));
    }

    public static int getGenderByIdCard(String idcard) {
        char sCardChar;
        Assert.notBlank(idcard);
        int len = idcard.length();
        if (len != 15 && len != 18) {
            throw new IllegalArgumentException("ID Card length must be 15 or 18");
        }
        if (len == 15) {
            idcard = IdcardUtil.convert15To18(idcard);
        }
        return (sCardChar = ((String)Objects.requireNonNull((Object)idcard)).charAt(16)) % 2 != 0 ? 1 : 0;
    }

    public static String getProvinceCodeByIdCard(String idcard) {
        int len = idcard.length();
        if (len == 15 || len == 18) {
            return idcard.substring(0, 2);
        }
        return null;
    }

    public static String getProvinceByIdCard(String idcard) {
        String code = IdcardUtil.getProvinceCodeByIdCard(idcard);
        if (StrUtil.isNotBlank(code)) {
            return (String)CITY_CODES.get((Object)code);
        }
        return null;
    }

    public static String getCityCodeByIdCard(String idcard) {
        int len = idcard.length();
        if (len == 15 || len == 18) {
            return idcard.substring(0, 4);
        }
        return null;
    }

    public static String getDistrictCodeByIdCard(String idcard) {
        int len = idcard.length();
        if (len == 15 || len == 18) {
            return idcard.substring(0, 6);
        }
        return null;
    }

    public static String hide(String idcard, int startInclude, int endExclude) {
        return StrUtil.hide(idcard, startInclude, endExclude);
    }

    public static Idcard getIdcardInfo(String idcard) {
        return new Idcard(idcard);
    }

    private static char getCheckCode18(String code17) {
        int sum = IdcardUtil.getPowerSum(code17.toCharArray());
        return IdcardUtil.getCheckCode18(sum);
    }

    private static char getCheckCode18(int iSum) {
        switch (iSum % 11) {
            case 10: {
                return '2';
            }
            case 9: {
                return '3';
            }
            case 8: {
                return '4';
            }
            case 7: {
                return '5';
            }
            case 6: {
                return '6';
            }
            case 5: {
                return '7';
            }
            case 4: {
                return '8';
            }
            case 3: {
                return '9';
            }
            case 2: {
                return 'X';
            }
            case 1: {
                return '0';
            }
            case 0: {
                return '1';
            }
        }
        return ' ';
    }

    private static int getPowerSum(char[] iArr) {
        int iSum = 0;
        if (POWER.length == iArr.length) {
            for (int i = 0; i < iArr.length; ++i) {
                iSum += Integer.parseInt((String)String.valueOf((char)iArr[i])) * POWER[i];
            }
        }
        return iSum;
    }

    static {
        CITY_CODES.put((Object)"11", (Object)"北京");
        CITY_CODES.put((Object)"12", (Object)"天津");
        CITY_CODES.put((Object)"13", (Object)"河北");
        CITY_CODES.put((Object)"14", (Object)"山西");
        CITY_CODES.put((Object)"15", (Object)"内蒙古");
        CITY_CODES.put((Object)"21", (Object)"辽宁");
        CITY_CODES.put((Object)"22", (Object)"吉林");
        CITY_CODES.put((Object)"23", (Object)"黑龙江");
        CITY_CODES.put((Object)"31", (Object)"上海");
        CITY_CODES.put((Object)"32", (Object)"江苏");
        CITY_CODES.put((Object)"33", (Object)"浙江");
        CITY_CODES.put((Object)"34", (Object)"安徽");
        CITY_CODES.put((Object)"35", (Object)"福建");
        CITY_CODES.put((Object)"36", (Object)"江西");
        CITY_CODES.put((Object)"37", (Object)"山东");
        CITY_CODES.put((Object)"41", (Object)"河南");
        CITY_CODES.put((Object)"42", (Object)"湖北");
        CITY_CODES.put((Object)"43", (Object)"湖南");
        CITY_CODES.put((Object)"44", (Object)"广东");
        CITY_CODES.put((Object)"45", (Object)"广西");
        CITY_CODES.put((Object)"46", (Object)"海南");
        CITY_CODES.put((Object)"50", (Object)"重庆");
        CITY_CODES.put((Object)"51", (Object)"四川");
        CITY_CODES.put((Object)"52", (Object)"贵州");
        CITY_CODES.put((Object)"53", (Object)"云南");
        CITY_CODES.put((Object)"54", (Object)"西藏");
        CITY_CODES.put((Object)"61", (Object)"陕西");
        CITY_CODES.put((Object)"62", (Object)"甘肃");
        CITY_CODES.put((Object)"63", (Object)"青海");
        CITY_CODES.put((Object)"64", (Object)"宁夏");
        CITY_CODES.put((Object)"65", (Object)"新疆");
        CITY_CODES.put((Object)"71", (Object)"台湾");
        CITY_CODES.put((Object)"81", (Object)"香港");
        CITY_CODES.put((Object)"82", (Object)"澳门");
        CITY_CODES.put((Object)"83", (Object)"台湾");
        CITY_CODES.put((Object)"91", (Object)"国外");
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'A'), (Object)10);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'B'), (Object)11);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'C'), (Object)12);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'D'), (Object)13);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'E'), (Object)14);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'F'), (Object)15);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'G'), (Object)16);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'H'), (Object)17);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'J'), (Object)18);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'K'), (Object)19);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'L'), (Object)20);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'M'), (Object)21);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'N'), (Object)22);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'P'), (Object)23);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'Q'), (Object)24);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'R'), (Object)25);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'S'), (Object)26);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'T'), (Object)27);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'U'), (Object)28);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'V'), (Object)29);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'X'), (Object)30);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'Y'), (Object)31);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'W'), (Object)32);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'Z'), (Object)33);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'I'), (Object)34);
        TW_FIRST_CODE.put((Object)Character.valueOf((char)'O'), (Object)35);
    }

    public static class Idcard
    implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String provinceCode;
        private final String cityCode;
        private final DateTime birthDate;
        private final Integer gender;
        private final int age;

        public Idcard(String idcard) {
            this.provinceCode = IdcardUtil.getProvinceCodeByIdCard(idcard);
            this.cityCode = IdcardUtil.getCityCodeByIdCard(idcard);
            this.birthDate = IdcardUtil.getBirthDate(idcard);
            this.gender = IdcardUtil.getGenderByIdCard(idcard);
            this.age = IdcardUtil.getAgeByIdCard(idcard);
        }

        public String getProvinceCode() {
            return this.provinceCode;
        }

        public String getProvince() {
            return (String)CITY_CODES.get((Object)this.provinceCode);
        }

        public String getCityCode() {
            return this.cityCode;
        }

        public DateTime getBirthDate() {
            return this.birthDate;
        }

        public Integer getGender() {
            return this.gender;
        }

        public int getAge() {
            return this.age;
        }

        public String toString() {
            return "Idcard{provinceCode='" + this.provinceCode + '\'' + ", cityCode='" + this.cityCode + '\'' + ", birthDate=" + (Object)((Object)this.birthDate) + ", gender=" + this.gender + ", age=" + this.age + '}';
        }
    }
}


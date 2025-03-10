/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package cn.hutool.core.lang;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.util.CreditCodeUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static final Pattern GENERAL = PatternPool.GENERAL;
    public static final Pattern NUMBERS = PatternPool.NUMBERS;
    public static final Pattern GROUP_VAR = PatternPool.GROUP_VAR;
    public static final Pattern IPV4 = PatternPool.IPV4;
    public static final Pattern IPV6 = PatternPool.IPV6;
    public static final Pattern MONEY = PatternPool.MONEY;
    public static final Pattern EMAIL = PatternPool.EMAIL;
    public static final Pattern EMAIL_WITH_CHINESE = PatternPool.EMAIL_WITH_CHINESE;
    public static final Pattern MOBILE = PatternPool.MOBILE;
    public static final Pattern CITIZEN_ID = PatternPool.CITIZEN_ID;
    public static final Pattern ZIP_CODE = PatternPool.ZIP_CODE;
    public static final Pattern BIRTHDAY = PatternPool.BIRTHDAY;
    public static final Pattern URL = PatternPool.URL;
    public static final Pattern URL_HTTP = PatternPool.URL_HTTP;
    public static final Pattern GENERAL_WITH_CHINESE = PatternPool.GENERAL_WITH_CHINESE;
    public static final Pattern UUID = PatternPool.UUID;
    public static final Pattern UUID_SIMPLE = PatternPool.UUID_SIMPLE;
    public static final Pattern PLATE_NUMBER = PatternPool.PLATE_NUMBER;
    public static final Pattern CAR_VIN = PatternPool.CAR_VIN;
    public static final Pattern CAR_DRIVING_LICENCE = PatternPool.CAR_DRIVING_LICENCE;

    public static boolean isTrue(boolean value) {
        return value;
    }

    public static boolean isFalse(boolean value) {
        return false == value;
    }

    public static boolean validateTrue(boolean value, String errorMsgTemplate, Object ... params) throws ValidateException {
        if (Validator.isFalse(value)) {
            throw new ValidateException(errorMsgTemplate, params);
        }
        return true;
    }

    public static boolean validateFalse(boolean value, String errorMsgTemplate, Object ... params) throws ValidateException {
        if (Validator.isTrue(value)) {
            throw new ValidateException(errorMsgTemplate, params);
        }
        return false;
    }

    public static boolean isNull(Object value) {
        return null == value;
    }

    public static boolean isNotNull(Object value) {
        return null != value;
    }

    public static <T> T validateNull(T value, String errorMsgTemplate, Object ... params) throws ValidateException {
        if (Validator.isNotNull(value)) {
            throw new ValidateException(errorMsgTemplate, params);
        }
        return null;
    }

    public static <T> T validateNotNull(T value, String errorMsgTemplate, Object ... params) throws ValidateException {
        if (Validator.isNull(value)) {
            throw new ValidateException(errorMsgTemplate, params);
        }
        return value;
    }

    public static boolean isEmpty(Object value) {
        return null == value || value instanceof String && StrUtil.isEmpty((String)value);
    }

    public static boolean isNotEmpty(Object value) {
        return false == Validator.isEmpty(value);
    }

    public static <T> T validateEmpty(T value, String errorMsg) throws ValidateException {
        if (Validator.isNotEmpty(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static <T> T validateNotEmpty(T value, String errorMsg) throws ValidateException {
        if (Validator.isEmpty(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean equal(Object t1, Object t2) {
        return ObjectUtil.equal(t1, t2);
    }

    public static Object validateEqual(Object t1, Object t2, String errorMsg) throws ValidateException {
        if (!Validator.equal(t1, t2)) {
            throw new ValidateException(errorMsg);
        }
        return t1;
    }

    public static void validateNotEqual(Object t1, Object t2, String errorMsg) throws ValidateException {
        if (Validator.equal(t1, t2)) {
            throw new ValidateException(errorMsg);
        }
    }

    public static void validateNotEmptyAndEqual(Object t1, Object t2, String errorMsg) throws ValidateException {
        Validator.validateNotEmpty(t1, errorMsg);
        Validator.validateEqual(t1, t2, errorMsg);
    }

    public static void validateNotEmptyAndNotEqual(Object t1, Object t2, String errorMsg) throws ValidateException {
        Validator.validateNotEmpty(t1, errorMsg);
        Validator.validateNotEqual(t1, t2, errorMsg);
    }

    public static <T extends CharSequence> T validateMatchRegex(String regex, T value, String errorMsg) throws ValidateException {
        if (!Validator.isMatchRegex(regex, value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isMatchRegex(Pattern pattern, CharSequence value) {
        return ReUtil.isMatch(pattern, value);
    }

    public static boolean isMatchRegex(String regex, CharSequence value) {
        return ReUtil.isMatch(regex, value);
    }

    public static boolean isGeneral(CharSequence value) {
        return Validator.isMatchRegex(GENERAL, value);
    }

    public static <T extends CharSequence> T validateGeneral(T value, String errorMsg) throws ValidateException {
        if (!Validator.isGeneral(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isGeneral(CharSequence value, int min, int max) {
        if (min < 0) {
            min = 0;
        }
        String reg = "^\\w{" + min + "," + max + "}$";
        if (max <= 0) {
            reg = "^\\w{" + min + ",}$";
        }
        return Validator.isMatchRegex(reg, value);
    }

    public static <T extends CharSequence> T validateGeneral(T value, int min, int max, String errorMsg) throws ValidateException {
        if (!Validator.isGeneral(value, min, max)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isGeneral(CharSequence value, int min) {
        return Validator.isGeneral(value, min, 0);
    }

    public static <T extends CharSequence> T validateGeneral(T value, int min, String errorMsg) throws ValidateException {
        return Validator.validateGeneral(value, min, 0, errorMsg);
    }

    public static boolean isLetter(CharSequence value) {
        return StrUtil.isAllCharMatch(value, Character::isLetter);
    }

    public static <T extends CharSequence> T validateLetter(T value, String errorMsg) throws ValidateException {
        if (!Validator.isLetter(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isUpperCase(CharSequence value) {
        return StrUtil.isAllCharMatch(value, Character::isUpperCase);
    }

    public static <T extends CharSequence> T validateUpperCase(T value, String errorMsg) throws ValidateException {
        if (!Validator.isUpperCase(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isLowerCase(CharSequence value) {
        return StrUtil.isAllCharMatch(value, Character::isLowerCase);
    }

    public static <T extends CharSequence> T validateLowerCase(T value, String errorMsg) throws ValidateException {
        if (!Validator.isLowerCase(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isNumber(CharSequence value) {
        return NumberUtil.isNumber(value);
    }

    public static boolean hasNumber(CharSequence value) {
        return ReUtil.contains(PatternPool.NUMBERS, value);
    }

    public static String validateNumber(String value, String errorMsg) throws ValidateException {
        if (!Validator.isNumber(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isWord(CharSequence value) {
        return Validator.isMatchRegex(PatternPool.WORD, value);
    }

    public static <T extends CharSequence> T validateWord(T value, String errorMsg) throws ValidateException {
        if (!Validator.isWord(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isMoney(CharSequence value) {
        return Validator.isMatchRegex(MONEY, value);
    }

    public static <T extends CharSequence> T validateMoney(T value, String errorMsg) throws ValidateException {
        if (!Validator.isMoney(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isZipCode(CharSequence value) {
        return Validator.isMatchRegex(ZIP_CODE, value);
    }

    public static <T extends CharSequence> T validateZipCode(T value, String errorMsg) throws ValidateException {
        if (!Validator.isZipCode(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isEmail(CharSequence value) {
        return Validator.isMatchRegex(EMAIL, value);
    }

    public static boolean isEmail(CharSequence value, boolean includChinese) {
        if (includChinese) {
            return Validator.isMatchRegex(EMAIL_WITH_CHINESE, value);
        }
        return Validator.isEmail(value);
    }

    public static <T extends CharSequence> T validateEmail(T value, String errorMsg) throws ValidateException {
        if (!Validator.isEmail(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isMobile(CharSequence value) {
        return Validator.isMatchRegex(MOBILE, value);
    }

    public static <T extends CharSequence> T validateMobile(T value, String errorMsg) throws ValidateException {
        if (!Validator.isMobile(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isCitizenId(CharSequence value) {
        return IdcardUtil.isValidCard(String.valueOf((Object)value));
    }

    public static <T extends CharSequence> T validateCitizenIdNumber(T value, String errorMsg) throws ValidateException {
        if (!Validator.isCitizenId(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isBirthday(int year, int month, int day) {
        int thisYear = DateUtil.thisYear();
        if (year < 1900 || year > thisYear) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            return false;
        }
        if (month == 2) {
            return day < 29 || day == 29 && DateUtil.isLeapYear(year);
        }
        return true;
    }

    public static boolean isBirthday(CharSequence value) {
        Matcher matcher = BIRTHDAY.matcher(value);
        if (matcher.find()) {
            int year = Integer.parseInt((String)matcher.group(1));
            int month = Integer.parseInt((String)matcher.group(3));
            int day = Integer.parseInt((String)matcher.group(5));
            return Validator.isBirthday(year, month, day);
        }
        return false;
    }

    public static <T extends CharSequence> T validateBirthday(T value, String errorMsg) throws ValidateException {
        if (!Validator.isBirthday(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isIpv4(CharSequence value) {
        return Validator.isMatchRegex(IPV4, value);
    }

    public static <T extends CharSequence> T validateIpv4(T value, String errorMsg) throws ValidateException {
        if (!Validator.isIpv4(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isIpv6(CharSequence value) {
        return Validator.isMatchRegex(IPV6, value);
    }

    public static <T extends CharSequence> T validateIpv6(T value, String errorMsg) throws ValidateException {
        if (!Validator.isIpv6(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isMac(CharSequence value) {
        return Validator.isMatchRegex(PatternPool.MAC_ADDRESS, value);
    }

    public static <T extends CharSequence> T validateMac(T value, String errorMsg) throws ValidateException {
        if (!Validator.isMac(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isPlateNumber(CharSequence value) {
        return Validator.isMatchRegex(PLATE_NUMBER, value);
    }

    public static <T extends CharSequence> T validatePlateNumber(T value, String errorMsg) throws ValidateException {
        if (!Validator.isPlateNumber(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isUrl(CharSequence value) {
        if (StrUtil.isBlank(value)) {
            return false;
        }
        try {
            new URL(StrUtil.str(value));
        }
        catch (MalformedURLException e) {
            return false;
        }
        return true;
    }

    public static <T extends CharSequence> T validateUrl(T value, String errorMsg) throws ValidateException {
        if (!Validator.isUrl(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isChinese(CharSequence value) {
        return Validator.isMatchRegex(PatternPool.CHINESES, value);
    }

    public static boolean hasChinese(CharSequence value) {
        return ReUtil.contains("[⺀-⻿⼀-⿟㇀-㇯㐀-䶿一-鿿豈-﫿𠀀-𪛟𪜀-𫜿𫝀-𫠟𫠠-𬺯丽-𯨟]+", value);
    }

    public static <T extends CharSequence> T validateChinese(T value, String errorMsg) throws ValidateException {
        if (!Validator.isChinese(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isGeneralWithChinese(CharSequence value) {
        return Validator.isMatchRegex(GENERAL_WITH_CHINESE, value);
    }

    public static <T extends CharSequence> T validateGeneralWithChinese(T value, String errorMsg) throws ValidateException {
        if (!Validator.isGeneralWithChinese(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isUUID(CharSequence value) {
        return Validator.isMatchRegex(UUID, value) || Validator.isMatchRegex(UUID_SIMPLE, value);
    }

    public static <T extends CharSequence> T validateUUID(T value, String errorMsg) throws ValidateException {
        if (!Validator.isUUID(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isHex(CharSequence value) {
        return Validator.isMatchRegex(PatternPool.HEX, value);
    }

    public static <T extends CharSequence> T validateHex(T value, String errorMsg) throws ValidateException {
        if (!Validator.isHex(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isBetween(Number value, Number min, Number max) {
        Assert.notNull(value);
        Assert.notNull(min);
        Assert.notNull(max);
        double doubleValue = value.doubleValue();
        return doubleValue >= min.doubleValue() && doubleValue <= max.doubleValue();
    }

    public static void validateBetween(Number value, Number min, Number max, String errorMsg) throws ValidateException {
        if (!Validator.isBetween(value, min, max)) {
            throw new ValidateException(errorMsg);
        }
    }

    public static boolean isCreditCode(CharSequence creditCode) {
        return CreditCodeUtil.isCreditCode(creditCode);
    }

    public static boolean isCarVin(CharSequence value) {
        return Validator.isMatchRegex(CAR_VIN, value);
    }

    public static <T extends CharSequence> T validateCarVin(T value, String errorMsg) throws ValidateException {
        if (!Validator.isCarVin(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static boolean isCarDrivingLicence(CharSequence value) {
        return Validator.isMatchRegex(CAR_DRIVING_LICENCE, value);
    }

    public static boolean isChineseName(CharSequence value) {
        return Validator.isMatchRegex(PatternPool.CHINESE_NAME, value);
    }

    public static <T extends CharSequence> T validateCarDrivingLicence(T value, String errorMsg) throws ValidateException {
        if (!Validator.isCarDrivingLicence(value)) {
            throw new ValidateException(errorMsg);
        }
        return value;
    }

    public static void checkIndexLimit(int index, int size) {
        if (index > (size + 1) * 10) {
            throw new ValidateException("Index [{}] is too large for size: [{}]", index, size);
        }
    }
}


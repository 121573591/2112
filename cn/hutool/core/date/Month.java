/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.time.Month
 *  java.time.format.TextStyle
 *  java.util.Locale
 */
package cn.hutool.core.date;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import java.time.format.TextStyle;
import java.util.Locale;

public enum Month {
    JANUARY(0),
    FEBRUARY(1),
    MARCH(2),
    APRIL(3),
    MAY(4),
    JUNE(5),
    JULY(6),
    AUGUST(7),
    SEPTEMBER(8),
    OCTOBER(9),
    NOVEMBER(10),
    DECEMBER(11),
    UNDECIMBER(12);

    private static final String[] ALIASES;
    private static final Month[] ENUMS;
    private final int value;

    private Month(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public int getValueBaseOne() {
        Assert.isFalse(this == UNDECIMBER, "Unsupported UNDECIMBER Field", new Object[0]);
        return this.getValue() + 1;
    }

    public int getLastDay(boolean isLeapYear) {
        switch (this) {
            case FEBRUARY: {
                return isLeapYear ? 29 : 28;
            }
            case APRIL: 
            case JUNE: 
            case SEPTEMBER: 
            case NOVEMBER: {
                return 30;
            }
        }
        return 31;
    }

    public static Month of(int calendarMonthIntValue) {
        if (calendarMonthIntValue >= ENUMS.length || calendarMonthIntValue < 0) {
            return null;
        }
        return ENUMS[calendarMonthIntValue];
    }

    public static Month of(String name) throws IllegalArgumentException {
        Assert.notBlank(name);
        Month of = Month.of(ArrayUtil.indexOfIgnoreCase(ALIASES, name));
        if (null == of) {
            of = Month.valueOf(name.toUpperCase());
        }
        return of;
    }

    public static Month of(java.time.Month month) {
        return Month.of(month.ordinal());
    }

    public static int getLastDay(int month, boolean isLeapYear) {
        Month of = Month.of(month);
        Assert.notNull(of, "Invalid Month base 0: " + month, new Object[0]);
        return of.getLastDay(isLeapYear);
    }

    public java.time.Month toJdkMonth() {
        return java.time.Month.of((int)this.getValueBaseOne());
    }

    public String getDisplayName(TextStyle style) {
        return this.getDisplayName(style, Locale.getDefault());
    }

    public String getDisplayName(TextStyle style, Locale locale) {
        return this.toJdkMonth().getDisplayName(style, locale);
    }

    static {
        ALIASES = new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        ENUMS = Month.values();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.time.LocalDate
 *  java.time.temporal.TemporalAccessor
 *  java.util.Calendar
 *  java.util.Date
 */
package cn.hutool.core.date;

import cn.hutool.core.convert.NumberChineseFormatter;
import cn.hutool.core.date.CalendarUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.date.Zodiac;
import cn.hutool.core.date.chinese.ChineseMonth;
import cn.hutool.core.date.chinese.GanZhi;
import cn.hutool.core.date.chinese.LunarFestival;
import cn.hutool.core.date.chinese.LunarInfo;
import cn.hutool.core.date.chinese.SolarTerms;
import cn.hutool.core.util.StrUtil;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class ChineseDate {
    private final int year;
    private final int month;
    private final boolean isLeapMonth;
    private final int day;
    private final int gyear;
    private final int gmonthBase1;
    private final int gday;

    public ChineseDate(Date date) {
        this(LocalDateTimeUtil.ofDate((TemporalAccessor)date.toInstant()));
    }

    public ChineseDate(LocalDate localDate) {
        int month;
        int iYear;
        int daysOfYear;
        this.gyear = localDate.getYear();
        this.gmonthBase1 = localDate.getMonthValue();
        this.gday = localDate.getDayOfMonth();
        int offset = (int)(localDate.toEpochDay() - LunarInfo.BASE_DAY);
        for (iYear = 1900; iYear <= LunarInfo.MAX_YEAR && offset >= (daysOfYear = LunarInfo.yearDays(iYear)); offset -= daysOfYear, ++iYear) {
        }
        this.year = iYear;
        int leapMonth = LunarInfo.leapMonth(iYear);
        boolean hasLeapMonth = false;
        for (month = 1; month < 13; ++month) {
            int daysOfMonth;
            if (leapMonth > 0 && month == leapMonth + 1) {
                daysOfMonth = LunarInfo.leapDays(this.year);
                hasLeapMonth = true;
            } else {
                daysOfMonth = LunarInfo.monthDays(this.year, hasLeapMonth ? month - 1 : month);
            }
            if (offset < daysOfMonth) break;
            offset -= daysOfMonth;
        }
        boolean bl = this.isLeapMonth = leapMonth > 0 && month == leapMonth + 1;
        if (hasLeapMonth && !this.isLeapMonth) {
            --month;
        }
        this.month = month;
        this.day = offset + 1;
    }

    public ChineseDate(int chineseYear, int chineseMonth, int chineseDay) {
        this(chineseYear, chineseMonth, chineseDay, chineseMonth == LunarInfo.leapMonth(chineseYear));
    }

    public ChineseDate(int chineseYear, int chineseMonth, int chineseDay, boolean isLeapMonth) {
        if (chineseMonth != LunarInfo.leapMonth(chineseYear)) {
            isLeapMonth = false;
        }
        this.day = chineseDay;
        this.isLeapMonth = isLeapMonth;
        this.month = isLeapMonth ? chineseMonth + 1 : chineseMonth;
        this.year = chineseYear;
        DateTime dateTime = this.lunar2solar(chineseYear, chineseMonth, chineseDay, isLeapMonth);
        if (null != dateTime) {
            this.gday = dateTime.dayOfMonth();
            this.gmonthBase1 = dateTime.month() + 1;
            this.gyear = dateTime.year();
        } else {
            this.gday = -1;
            this.gmonthBase1 = -1;
            this.gyear = -1;
        }
    }

    public int getChineseYear() {
        return this.year;
    }

    public int getGregorianYear() {
        return this.gyear;
    }

    public int getMonth() {
        return this.month;
    }

    public int getGregorianMonthBase1() {
        return this.gmonthBase1;
    }

    public int getGregorianMonth() {
        return this.gmonthBase1 - 1;
    }

    public boolean isLeapMonth() {
        return this.isLeapMonth;
    }

    public String getChineseMonth() {
        return this.getChineseMonth(false);
    }

    public String getChineseMonthName() {
        return this.getChineseMonth(true);
    }

    public String getChineseMonth(boolean isTraditional) {
        return ChineseMonth.getChineseMonthName(this.isLeapMonth(), this.isLeapMonth() ? this.month - 1 : this.month, isTraditional);
    }

    public int getDay() {
        return this.day;
    }

    public int getGregorianDay() {
        return this.gday;
    }

    public String getChineseDay() {
        int n;
        String[] chineseTen = new String[]{"初", "十", "廿", "卅"};
        int n2 = n = this.day % 10 == 0 ? 9 : this.day % 10 - 1;
        if (this.day > 30) {
            return "";
        }
        switch (this.day) {
            case 10: {
                return "初十";
            }
            case 20: {
                return "二十";
            }
            case 30: {
                return "三十";
            }
        }
        return chineseTen[this.day / 10] + NumberChineseFormatter.format(n + 1, false);
    }

    public Date getGregorianDate() {
        return DateUtil.date(this.getGregorianCalendar());
    }

    public Calendar getGregorianCalendar() {
        Calendar calendar = CalendarUtil.calendar();
        calendar.set(this.gyear, this.getGregorianMonth(), this.gday, 0, 0, 0);
        return calendar;
    }

    public String getFestivals() {
        return StrUtil.join((CharSequence)",", LunarFestival.getFestivals(this.year, this.month, this.day));
    }

    public String getChineseZodiac() {
        return Zodiac.getChineseZodiac(this.year);
    }

    public String getCyclical() {
        return GanZhi.getGanzhiOfYear(this.year);
    }

    public String getCyclicalYMD() {
        if (this.gyear >= 1900 && this.gmonthBase1 > 0 && this.gday > 0) {
            return this.cyclicalm(this.gyear, this.gmonthBase1, this.gday);
        }
        return null;
    }

    public String getTerm() {
        return SolarTerms.getTerm(this.gyear, this.gmonthBase1, this.gday);
    }

    public String toStringNormal() {
        return String.format((String)"%04d-%02d-%02d", (Object[])new Object[]{this.year, this.isLeapMonth() ? this.month - 1 : this.month, this.day});
    }

    public String toString() {
        return String.format((String)"%s%s年 %s%s", (Object[])new Object[]{this.getCyclical(), this.getChineseZodiac(), this.getChineseMonthName(), this.getChineseDay()});
    }

    private String cyclicalm(int year, int month, int day) {
        return StrUtil.format("{}年{}月{}日", GanZhi.getGanzhiOfYear(this.year), GanZhi.getGanzhiOfMonth(year, month, day), GanZhi.getGanzhiOfDay(year, month, day));
    }

    private DateTime lunar2solar(int chineseYear, int chineseMonth, int chineseDay, boolean isLeapMonth) {
        int day;
        if (chineseYear == 2100 && chineseMonth == 12 && chineseDay > 1 || chineseYear == 1900 && chineseMonth == 1 && chineseDay < 31) {
            return null;
        }
        int _day = day = LunarInfo.monthDays(chineseYear, chineseMonth);
        if (isLeapMonth) {
            _day = LunarInfo.leapDays(chineseYear);
        }
        if (chineseYear < 1900 || chineseYear > 2100 || chineseDay > _day) {
            return null;
        }
        int offset = 0;
        for (int i = 1900; i < chineseYear; ++i) {
            offset += LunarInfo.yearDays(i);
        }
        boolean isAdd = false;
        for (int i = 1; i < chineseMonth; ++i) {
            int leap = LunarInfo.leapMonth(chineseYear);
            if (!isAdd && leap <= i && leap > 0) {
                offset += LunarInfo.leapDays(chineseYear);
                isAdd = true;
            }
            offset += LunarInfo.monthDays(chineseYear, i);
        }
        if (isLeapMonth) {
            offset += day;
        }
        return DateUtil.date((long)(offset + chineseDay - 31) * 86400000L - 2203804800000L);
    }
}


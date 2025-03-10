/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.text.ParsePosition
 *  java.time.Instant
 *  java.time.LocalDateTime
 *  java.time.ZoneId
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.LinkedHashSet
 *  java.util.Locale
 *  java.util.TimeZone
 */
package cn.hutool.core.date;

import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.convert.NumberChineseFormatter;
import cn.hutool.core.date.DateException;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateModifier;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.format.DateParser;
import cn.hutool.core.date.format.FastDateParser;
import cn.hutool.core.date.format.GlobalCustomFormat;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import java.text.ParsePosition;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarUtil {
    public static Calendar calendar() {
        return Calendar.getInstance();
    }

    public static Calendar calendar(Date date) {
        if (date instanceof DateTime) {
            return ((DateTime)date).toCalendar();
        }
        return CalendarUtil.calendar(date.getTime());
    }

    public static Calendar calendar(long millis) {
        return CalendarUtil.calendar(millis, TimeZone.getDefault());
    }

    public static Calendar calendar(long millis, TimeZone timeZone) {
        Calendar cal = Calendar.getInstance((TimeZone)timeZone);
        cal.setTimeInMillis(millis);
        return cal;
    }

    public static boolean isAM(Calendar calendar) {
        return 0 == calendar.get(9);
    }

    public static boolean isPM(Calendar calendar) {
        return 1 == calendar.get(9);
    }

    public static Calendar truncate(Calendar calendar, DateField dateField) {
        return DateModifier.modify(calendar, dateField.getValue(), DateModifier.ModifyType.TRUNCATE);
    }

    public static Calendar round(Calendar calendar, DateField dateField) {
        return DateModifier.modify(calendar, dateField.getValue(), DateModifier.ModifyType.ROUND);
    }

    public static Calendar ceiling(Calendar calendar, DateField dateField) {
        return DateModifier.modify(calendar, dateField.getValue(), DateModifier.ModifyType.CEILING);
    }

    public static Calendar ceiling(Calendar calendar, DateField dateField, boolean truncateMillisecond) {
        return DateModifier.modify(calendar, dateField.getValue(), DateModifier.ModifyType.CEILING, truncateMillisecond);
    }

    public static Calendar beginOfSecond(Calendar calendar) {
        return CalendarUtil.truncate(calendar, DateField.SECOND);
    }

    public static Calendar endOfSecond(Calendar calendar) {
        return CalendarUtil.ceiling(calendar, DateField.SECOND);
    }

    public static Calendar beginOfHour(Calendar calendar) {
        return CalendarUtil.truncate(calendar, DateField.HOUR_OF_DAY);
    }

    public static Calendar endOfHour(Calendar calendar) {
        return CalendarUtil.ceiling(calendar, DateField.HOUR_OF_DAY);
    }

    public static Calendar beginOfMinute(Calendar calendar) {
        return CalendarUtil.truncate(calendar, DateField.MINUTE);
    }

    public static Calendar endOfMinute(Calendar calendar) {
        return CalendarUtil.ceiling(calendar, DateField.MINUTE);
    }

    public static Calendar beginOfDay(Calendar calendar) {
        return CalendarUtil.truncate(calendar, DateField.DAY_OF_MONTH);
    }

    public static Calendar endOfDay(Calendar calendar) {
        return CalendarUtil.ceiling(calendar, DateField.DAY_OF_MONTH);
    }

    public static Calendar beginOfWeek(Calendar calendar) {
        return CalendarUtil.beginOfWeek(calendar, true);
    }

    public static Calendar beginOfWeek(Calendar calendar, boolean isMondayAsFirstDay) {
        calendar.setFirstDayOfWeek(isMondayAsFirstDay ? 2 : 1);
        return CalendarUtil.truncate(calendar, DateField.WEEK_OF_MONTH);
    }

    public static Calendar endOfWeek(Calendar calendar) {
        return CalendarUtil.endOfWeek(calendar, true);
    }

    public static Calendar endOfWeek(Calendar calendar, boolean isSundayAsLastDay) {
        calendar.setFirstDayOfWeek(isSundayAsLastDay ? 2 : 1);
        return CalendarUtil.ceiling(calendar, DateField.WEEK_OF_MONTH);
    }

    public static Calendar beginOfMonth(Calendar calendar) {
        return CalendarUtil.truncate(calendar, DateField.MONTH);
    }

    public static Calendar endOfMonth(Calendar calendar) {
        return CalendarUtil.ceiling(calendar, DateField.MONTH);
    }

    public static Calendar beginOfQuarter(Calendar calendar) {
        calendar.set(2, calendar.get(DateField.MONTH.getValue()) / 3 * 3);
        calendar.set(5, 1);
        return CalendarUtil.beginOfDay(calendar);
    }

    public static Calendar endOfQuarter(Calendar calendar) {
        int year = calendar.get(1);
        int month = calendar.get(DateField.MONTH.getValue()) / 3 * 3 + 2;
        Calendar resultCal = Calendar.getInstance((TimeZone)calendar.getTimeZone());
        resultCal.set(year, month, Month.of(month).getLastDay(DateUtil.isLeapYear(year)));
        return CalendarUtil.endOfDay(resultCal);
    }

    public static Calendar beginOfYear(Calendar calendar) {
        return CalendarUtil.truncate(calendar, DateField.YEAR);
    }

    public static Calendar endOfYear(Calendar calendar) {
        return CalendarUtil.ceiling(calendar, DateField.YEAR);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return cal1.get(6) == cal2.get(6) && cal1.get(1) == cal2.get(1) && cal1.get(0) == cal2.get(0);
    }

    public static boolean isSameWeek(Calendar cal1, Calendar cal2, boolean isMon) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        cal1 = (Calendar)cal1.clone();
        cal2 = (Calendar)cal2.clone();
        if (isMon) {
            cal1.setFirstDayOfWeek(2);
            cal1.set(7, 2);
            cal2.setFirstDayOfWeek(2);
            cal2.set(7, 2);
        } else {
            cal1.setFirstDayOfWeek(1);
            cal1.set(7, 1);
            cal2.setFirstDayOfWeek(1);
            cal2.set(7, 1);
        }
        return CalendarUtil.isSameDay(cal1, cal2);
    }

    public static boolean isSameMonth(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return cal1.get(1) == cal2.get(1) && cal1.get(2) == cal2.get(2) && cal1.get(0) == cal2.get(0);
    }

    public static boolean isSameInstant(Calendar date1, Calendar date2) {
        if (null == date1) {
            return null == date2;
        }
        if (null == date2) {
            return false;
        }
        return date1.getTimeInMillis() == date2.getTimeInMillis();
    }

    public static LinkedHashSet<String> yearAndQuarter(long startDate, long endDate) {
        LinkedHashSet quarters = new LinkedHashSet();
        Calendar cal = CalendarUtil.calendar(startDate);
        while (startDate <= endDate) {
            quarters.add((Object)CalendarUtil.yearAndQuarter(cal));
            cal.add(2, 3);
            startDate = cal.getTimeInMillis();
        }
        return quarters;
    }

    public static String yearAndQuarter(Calendar cal) {
        return StrUtil.builder().append(cal.get(1)).append(cal.get(2) / 3 + 1).toString();
    }

    public static int getBeginValue(Calendar calendar, DateField dateField) {
        return CalendarUtil.getBeginValue(calendar, dateField.getValue());
    }

    public static int getBeginValue(Calendar calendar, int dateField) {
        if (7 == dateField) {
            return calendar.getFirstDayOfWeek();
        }
        return calendar.getActualMinimum(dateField);
    }

    public static int getEndValue(Calendar calendar, DateField dateField) {
        return CalendarUtil.getEndValue(calendar, dateField.getValue());
    }

    public static int getEndValue(Calendar calendar, int dateField) {
        if (7 == dateField) {
            return (calendar.getFirstDayOfWeek() + 6) % 7;
        }
        return calendar.getActualMaximum(dateField);
    }

    public static Instant toInstant(Calendar calendar) {
        return null == calendar ? null : calendar.toInstant();
    }

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        return LocalDateTime.ofInstant((Instant)calendar.toInstant(), (ZoneId)calendar.getTimeZone().toZoneId());
    }

    public static int compare(Calendar calendar1, Calendar calendar2) {
        return CompareUtil.compare(calendar1, calendar2);
    }

    public static int age(Calendar birthday, Calendar dateToCompare) {
        return CalendarUtil.age(birthday.getTimeInMillis(), dateToCompare.getTimeInMillis());
    }

    public static String formatChineseDate(Calendar calendar, boolean withTime) {
        StringBuilder result = StrUtil.builder();
        String year = String.valueOf((int)calendar.get(1));
        int length = year.length();
        for (int i = 0; i < length; ++i) {
            result.append(NumberChineseFormatter.numberCharToChinese(year.charAt(i), false));
        }
        result.append('\u5e74');
        int month = calendar.get(2) + 1;
        result.append(NumberChineseFormatter.formatThousand(month, false));
        result.append('\u6708');
        int day = calendar.get(5);
        result.append(NumberChineseFormatter.formatThousand(day, false));
        result.append('\u65e5');
        String temp = result.toString().replace('\u96f6', '\u3007');
        result.delete(0, result.length());
        result.append(temp);
        if (withTime) {
            int hour = calendar.get(11);
            result.append(NumberChineseFormatter.formatThousand(hour, false));
            result.append('\u65f6');
            int minute = calendar.get(12);
            result.append(NumberChineseFormatter.formatThousand(minute, false));
            result.append('\u5206');
            int second = calendar.get(13);
            result.append(NumberChineseFormatter.formatThousand(second, false));
            result.append('\u79d2');
        }
        return result.toString();
    }

    protected static int age(long birthday, long dateToCompare) {
        if (birthday > dateToCompare) {
            throw new IllegalArgumentException("Birthday is after dateToCompare!");
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateToCompare);
        int year = cal.get(1);
        int month = cal.get(2);
        int dayOfMonth = cal.get(5);
        cal.setTimeInMillis(birthday);
        int age = year - cal.get(1);
        if (age == 0) {
            return 0;
        }
        int monthBirth = cal.get(2);
        if (month == monthBirth) {
            int dayOfMonthBirth = cal.get(5);
            if (dayOfMonth <= dayOfMonthBirth) {
                --age;
            }
        } else if (month < monthBirth) {
            --age;
        }
        return age;
    }

    public static Calendar parseByPatterns(String str, String ... parsePatterns) throws DateException {
        return CalendarUtil.parseByPatterns(str, null, parsePatterns);
    }

    public static Calendar parseByPatterns(String str, Locale locale, String ... parsePatterns) throws DateException {
        return CalendarUtil.parseByPatterns(str, locale, true, parsePatterns);
    }

    public static Calendar parseByPatterns(String str, Locale locale, boolean lenient, String ... parsePatterns) throws DateException {
        if (str == null || parsePatterns == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        TimeZone tz = TimeZone.getDefault();
        Locale lcl = ObjectUtil.defaultIfNull(locale, Locale.getDefault());
        ParsePosition pos = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance((TimeZone)tz, (Locale)lcl);
        calendar.setLenient(lenient);
        for (String parsePattern : parsePatterns) {
            if (GlobalCustomFormat.isCustomFormat(parsePattern)) {
                Date parse = GlobalCustomFormat.parse(str, parsePattern);
                if (null == parse) continue;
                calendar.setTime(parse);
                return calendar;
            }
            FastDateParser fdp = new FastDateParser(parsePattern, tz, lcl);
            calendar.clear();
            try {
                if (fdp.parse(str, pos, calendar) && pos.getIndex() == str.length()) {
                    return calendar;
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
            pos.setIndex(0);
        }
        throw new DateException("Unable to parse the date: {}", str);
    }

    public static Calendar parse(CharSequence str, boolean lenient, DateParser parser) {
        Calendar calendar = Calendar.getInstance((TimeZone)parser.getTimeZone(), (Locale)parser.getLocale());
        calendar.clear();
        calendar.setLenient(lenient);
        return parser.parse(StrUtil.str(str), new ParsePosition(0), calendar) ? calendar : null;
    }
}


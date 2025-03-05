/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Objects
 */
package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class CalendarUtils {
    public static final CalendarUtils INSTANCE = CalendarUtils.getInstance();
    private final Calendar calendar;
    private final Locale locale;

    public static CalendarUtils getInstance() {
        return new CalendarUtils(Calendar.getInstance());
    }

    static CalendarUtils getInstance(Locale locale) {
        return new CalendarUtils(Calendar.getInstance((Locale)locale), locale);
    }

    public CalendarUtils(Calendar calendar) {
        this(calendar, Locale.getDefault());
    }

    CalendarUtils(Calendar calendar, Locale locale) {
        this.calendar = (Calendar)Objects.requireNonNull((Object)calendar, (String)"calendar");
        this.locale = (Locale)Objects.requireNonNull((Object)locale, (String)"locale");
    }

    public int getDayOfMonth() {
        return this.calendar.get(5);
    }

    public int getDayOfYear() {
        return this.calendar.get(6);
    }

    public int getMonth() {
        return this.calendar.get(2);
    }

    String[] getMonthDisplayNames(int style) {
        Map displayNames = this.calendar.getDisplayNames(2, style, this.locale);
        if (displayNames == null) {
            return null;
        }
        String[] monthNames = new String[displayNames.size()];
        displayNames.forEach((k, v) -> {
            monthNames[v.intValue()] = k;
        });
        return monthNames;
    }

    String[] getStandaloneLongMonthNames() {
        return this.getMonthDisplayNames(32770);
    }

    String[] getStandaloneShortMonthNames() {
        return this.getMonthDisplayNames(32769);
    }

    public int getYear() {
        return this.calendar.get(1);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.text.ParseException
 *  java.text.ParsePosition
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public interface DateParser {
    public Locale getLocale();

    public String getPattern();

    public TimeZone getTimeZone();

    public Date parse(String var1) throws ParseException;

    public Date parse(String var1, ParsePosition var2);

    public boolean parse(String var1, ParsePosition var2, Calendar var3);

    public Object parseObject(String var1) throws ParseException;

    public Object parseObject(String var1, ParsePosition var2);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.text.FieldPosition
 *  java.util.Calendar
 *  java.util.Date
 *  java.util.Locale
 *  java.util.TimeZone
 */
package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public interface DatePrinter {
    public String format(Calendar var1);

    public <B extends Appendable> B format(Calendar var1, B var2);

    @Deprecated
    public StringBuffer format(Calendar var1, StringBuffer var2);

    public String format(Date var1);

    public <B extends Appendable> B format(Date var1, B var2);

    @Deprecated
    public StringBuffer format(Date var1, StringBuffer var2);

    public String format(long var1);

    public <B extends Appendable> B format(long var1, B var3);

    @Deprecated
    public StringBuffer format(long var1, StringBuffer var3);

    public StringBuffer format(Object var1, StringBuffer var2, FieldPosition var3);

    public Locale getLocale();

    public String getPattern();

    public TimeZone getTimeZone();
}


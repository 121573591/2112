/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Locale
 *  java.util.TimeZone
 */
package cn.hutool.core.date.format;

import java.util.Locale;
import java.util.TimeZone;

public interface DateBasic {
    public String getPattern();

    public TimeZone getTimeZone();

    public Locale getLocale();
}


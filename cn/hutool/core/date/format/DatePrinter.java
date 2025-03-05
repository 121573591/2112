/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Calendar
 *  java.util.Date
 */
package cn.hutool.core.date.format;

import cn.hutool.core.date.format.DateBasic;
import java.util.Calendar;
import java.util.Date;

public interface DatePrinter
extends DateBasic {
    public String format(long var1);

    public String format(Date var1);

    public String format(Calendar var1);

    public <B extends Appendable> B format(long var1, B var3);

    public <B extends Appendable> B format(Date var1, B var2);

    public <B extends Appendable> B format(Calendar var1, B var2);
}


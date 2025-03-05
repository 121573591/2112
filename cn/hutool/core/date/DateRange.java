/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Date
 */
package cn.hutool.core.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Range;
import java.util.Date;

public class DateRange
extends Range<DateTime> {
    private static final long serialVersionUID = 1L;

    public DateRange(Date start, Date end, DateField unit) {
        this(start, end, unit, 1);
    }

    public DateRange(Date start, Date end, DateField unit, int step) {
        this(start, end, unit, step, true, true);
    }

    public DateRange(Date start, Date end, DateField unit, int step, boolean isIncludeStart, boolean isIncludeEnd) {
        super(DateUtil.date(start), DateUtil.date(end), (current, end1, index) -> {
            DateTime dt = DateUtil.date(start).offsetNew(unit, (index + 1) * step);
            if (dt.isAfter((Date)end1)) {
                return null;
            }
            return dt;
        }, isIncludeStart, isIncludeEnd);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.TimeZone
 */
package org.apache.commons.lang3.time;

import java.util.TimeZone;
import org.apache.commons.lang3.ObjectUtils;

public class TimeZones {
    public static final String GMT_ID = "GMT";
    public static final TimeZone GMT = TimeZone.getTimeZone((String)"GMT");

    public static TimeZone toTimeZone(TimeZone timeZone) {
        return ObjectUtils.getIfNull(timeZone, TimeZone::getDefault);
    }

    private TimeZones() {
    }
}


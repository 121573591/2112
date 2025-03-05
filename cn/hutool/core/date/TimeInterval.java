/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.core.date;

import cn.hutool.core.date.GroupTimeInterval;

public class TimeInterval
extends GroupTimeInterval {
    private static final long serialVersionUID = 1L;
    private static final String DEFAULT_ID = "";

    public TimeInterval() {
        this(false);
    }

    public TimeInterval(boolean isNano) {
        super(isNano);
        this.start();
    }

    public long start() {
        return this.start(DEFAULT_ID);
    }

    public long intervalRestart() {
        return this.intervalRestart(DEFAULT_ID);
    }

    public TimeInterval restart() {
        this.start(DEFAULT_ID);
        return this;
    }

    public long interval() {
        return this.interval(DEFAULT_ID);
    }

    public String intervalPretty() {
        return this.intervalPretty(DEFAULT_ID);
    }

    public long intervalMs() {
        return this.intervalMs(DEFAULT_ID);
    }

    public long intervalSecond() {
        return this.intervalSecond(DEFAULT_ID);
    }

    public long intervalMinute() {
        return this.intervalMinute(DEFAULT_ID);
    }

    public long intervalHour() {
        return this.intervalHour(DEFAULT_ID);
    }

    public long intervalDay() {
        return this.intervalDay(DEFAULT_ID);
    }

    public long intervalWeek() {
        return this.intervalWeek(DEFAULT_ID);
    }
}


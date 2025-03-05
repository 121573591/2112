/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 */
package cn.hutool.cron.timingwheel;

import cn.hutool.cron.timingwheel.TimerTaskList;

public class TimerTask {
    private final long delayMs;
    private final Runnable task;
    protected TimerTaskList timerTaskList;
    protected TimerTask next;
    protected TimerTask prev;
    public String desc;

    public TimerTask(Runnable task, long delayMs) {
        this.delayMs = System.currentTimeMillis() + delayMs;
        this.task = task;
    }

    public Runnable getTask() {
        return this.task;
    }

    public long getDelayMs() {
        return this.delayMs;
    }

    public String toString() {
        return this.desc;
    }
}


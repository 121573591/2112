/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.cron.task;

import cn.hutool.cron.pattern.CronPattern;
import cn.hutool.cron.task.Task;

public class CronTask
implements Task {
    private final String id;
    private CronPattern pattern;
    private final Task task;

    public CronTask(String id, CronPattern pattern, Task task) {
        this.id = id;
        this.pattern = pattern;
        this.task = task;
    }

    @Override
    public void execute() {
        this.task.execute();
    }

    public String getId() {
        return this.id;
    }

    public CronPattern getPattern() {
        return this.pattern;
    }

    public CronTask setPattern(CronPattern pattern) {
        this.pattern = pattern;
        return this;
    }

    public Task getRaw() {
        return this.task;
    }
}


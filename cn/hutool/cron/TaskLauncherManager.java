/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayList
 *  java.util.List
 */
package cn.hutool.cron;

import cn.hutool.cron.Scheduler;
import cn.hutool.cron.TaskLauncher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskLauncherManager
implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Scheduler scheduler;
    protected final List<TaskLauncher> launchers = new ArrayList();

    public TaskLauncherManager(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected TaskLauncher spawnLauncher(long millis) {
        TaskLauncher launcher = new TaskLauncher(this.scheduler, millis);
        List<TaskLauncher> list = this.launchers;
        synchronized (list) {
            this.launchers.add((Object)launcher);
        }
        this.scheduler.threadExecutor.execute((Runnable)launcher);
        return launcher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void notifyLauncherCompleted(TaskLauncher launcher) {
        List<TaskLauncher> list = this.launchers;
        synchronized (list) {
            this.launchers.remove((Object)launcher);
        }
    }
}


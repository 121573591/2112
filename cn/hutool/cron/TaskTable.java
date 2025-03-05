/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReadWriteLock
 *  java.util.concurrent.locks.ReentrantReadWriteLock
 */
package cn.hutool.cron;

import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.CronException;
import cn.hutool.cron.Scheduler;
import cn.hutool.cron.pattern.CronPattern;
import cn.hutool.cron.task.CronTask;
import cn.hutool.cron.task.Task;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TaskTable
implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_CAPACITY = 10;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<String> ids;
    private final List<CronPattern> patterns;
    private final List<Task> tasks;
    private int size;

    public TaskTable() {
        this(10);
    }

    public TaskTable(int initialCapacity) {
        this.ids = new ArrayList(initialCapacity);
        this.patterns = new ArrayList(initialCapacity);
        this.tasks = new ArrayList(initialCapacity);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TaskTable add(String id, CronPattern pattern, Task task) {
        Lock writeLock = this.lock.writeLock();
        writeLock.lock();
        try {
            if (this.ids.contains((Object)id)) {
                throw new CronException("Id [{}] has been existed!", id);
            }
            this.ids.add((Object)id);
            this.patterns.add((Object)pattern);
            this.tasks.add((Object)task);
            ++this.size;
        }
        finally {
            writeLock.unlock();
        }
        return this;
    }

    public List<String> getIds() {
        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            List list = Collections.unmodifiableList(this.ids);
            return list;
        }
        finally {
            readLock.unlock();
        }
    }

    public List<CronPattern> getPatterns() {
        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            List list = Collections.unmodifiableList(this.patterns);
            return list;
        }
        finally {
            readLock.unlock();
        }
    }

    public List<Task> getTasks() {
        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            List list = Collections.unmodifiableList(this.tasks);
            return list;
        }
        finally {
            readLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean remove(String id) {
        Lock writeLock = this.lock.writeLock();
        writeLock.lock();
        try {
            int index = this.ids.indexOf((Object)id);
            if (index < 0) {
                boolean bl = false;
                return bl;
            }
            this.tasks.remove(index);
            this.patterns.remove(index);
            this.ids.remove(index);
            --this.size;
        }
        finally {
            writeLock.unlock();
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean updatePattern(String id, CronPattern pattern) {
        Lock writeLock = this.lock.writeLock();
        writeLock.lock();
        try {
            int index = this.ids.indexOf((Object)id);
            if (index > -1) {
                this.patterns.set(index, (Object)pattern);
                boolean bl = true;
                return bl;
            }
        }
        finally {
            writeLock.unlock();
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Task getTask(int index) {
        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            Task task = (Task)this.tasks.get(index);
            return task;
        }
        finally {
            readLock.unlock();
        }
    }

    public Task getTask(String id) {
        int index = this.ids.indexOf((Object)id);
        if (index > -1) {
            return this.getTask(index);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public CronPattern getPattern(int index) {
        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            CronPattern cronPattern = (CronPattern)this.patterns.get(index);
            return cronPattern;
        }
        finally {
            readLock.unlock();
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size < 1;
    }

    public CronPattern getPattern(String id) {
        int index = this.ids.indexOf((Object)id);
        if (index > -1) {
            return this.getPattern(index);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void executeTaskIfMatch(Scheduler scheduler, long millis) {
        Lock readLock = this.lock.readLock();
        readLock.lock();
        try {
            this.executeTaskIfMatchInternal(scheduler, millis);
        }
        finally {
            readLock.unlock();
        }
    }

    public String toString() {
        StringBuilder builder = StrUtil.builder();
        for (int i = 0; i < this.size; ++i) {
            builder.append(StrUtil.format("[{}] [{}] [{}]\n", this.ids.get(i), this.patterns.get(i), this.tasks.get(i)));
        }
        return builder.toString();
    }

    protected void executeTaskIfMatchInternal(Scheduler scheduler, long millis) {
        for (int i = 0; i < this.size; ++i) {
            if (!((CronPattern)this.patterns.get(i)).match(scheduler.config.timezone, millis, scheduler.config.matchSecond)) continue;
            scheduler.taskExecutorManager.spawnExecutor(new CronTask((String)this.ids.get(i), (CronPattern)this.patterns.get(i), (Task)this.tasks.get(i)));
        }
    }
}


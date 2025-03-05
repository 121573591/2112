/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.ThreadGroup
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package cn.hutool.core.thread;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
implements ThreadFactory {
    private final String prefix;
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final boolean isDaemon;
    private final Thread.UncaughtExceptionHandler handler;

    public NamedThreadFactory(String prefix, boolean isDaemon) {
        this(prefix, null, isDaemon);
    }

    public NamedThreadFactory(String prefix, ThreadGroup threadGroup, boolean isDaemon) {
        this(prefix, threadGroup, isDaemon, null);
    }

    public NamedThreadFactory(String prefix, ThreadGroup threadGroup, boolean isDaemon, Thread.UncaughtExceptionHandler handler) {
        String string = this.prefix = StrUtil.isBlank(prefix) ? "Hutool" : prefix;
        if (null == threadGroup) {
            threadGroup = ThreadUtil.currentThreadGroup();
        }
        this.group = threadGroup;
        this.isDaemon = isDaemon;
        this.handler = handler;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(this.group, r, StrUtil.format("{}{}", this.prefix, this.threadNumber.getAndIncrement()));
        if (!t.isDaemon()) {
            if (this.isDaemon) {
                t.setDaemon(true);
            }
        } else if (!this.isDaemon) {
            t.setDaemon(false);
        }
        if (null != this.handler) {
            t.setUncaughtExceptionHandler(this.handler);
        }
        if (5 != t.getPriority()) {
            t.setPriority(5);
        }
        return t;
    }
}


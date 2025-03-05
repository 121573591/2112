/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.atomic.AtomicInteger
 */
package org.java_websocket.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
implements ThreadFactory {
    private final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String threadPrefix;

    public NamedThreadFactory(String threadPrefix) {
        this.threadPrefix = threadPrefix;
    }

    public Thread newThread(Runnable runnable2) {
        Thread thread = this.defaultThreadFactory.newThread(runnable2);
        thread.setName(this.threadPrefix + "-" + this.threadNumber);
        return thread;
    }
}


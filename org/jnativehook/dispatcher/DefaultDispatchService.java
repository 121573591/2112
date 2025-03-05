/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package org.jnativehook.dispatcher;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultDispatchService
extends ThreadPoolExecutor {
    public DefaultDispatchService() {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(), new ThreadFactory(){

            public Thread newThread(Runnable runnable2) {
                Thread thread = new Thread(runnable2);
                thread.setName("JNativeHook Dispatch Thread");
                thread.setDaemon(true);
                return thread;
            }
        });
    }
}


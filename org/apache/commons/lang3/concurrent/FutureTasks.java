/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.Callable
 *  java.util.concurrent.FutureTask
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTasks {
    public static <V> FutureTask<V> run(Callable<V> callable) {
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    private FutureTasks() {
    }
}


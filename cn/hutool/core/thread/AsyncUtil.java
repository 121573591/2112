/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.util.concurrent.CompletableFuture
 *  java.util.concurrent.ExecutionException
 */
package cn.hutool.core.thread;

import cn.hutool.core.thread.ThreadException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncUtil {
    public static void waitAll(CompletableFuture<?> ... tasks) {
        try {
            CompletableFuture.allOf(tasks).get();
        }
        catch (InterruptedException | ExecutionException e) {
            throw new ThreadException(e);
        }
    }

    public static <T> T waitAny(CompletableFuture<?> ... tasks) {
        try {
            return (T)CompletableFuture.anyOf(tasks).get();
        }
        catch (InterruptedException | ExecutionException e) {
            throw new ThreadException(e);
        }
    }

    public static <T> T get(CompletableFuture<T> task) {
        try {
            return (T)task.get();
        }
        catch (InterruptedException | ExecutionException e) {
            throw new ThreadException(e);
        }
    }
}


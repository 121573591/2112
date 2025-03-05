/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.locks.ReentrantReadWriteLock
 *  java.util.concurrent.locks.StampedLock
 */
package cn.hutool.core.thread.lock;

import cn.hutool.core.thread.lock.NoLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class LockUtil {
    private static final NoLock NO_LOCK = new NoLock();

    public static StampedLock createStampLock() {
        return new StampedLock();
    }

    public static ReentrantReadWriteLock createReadWriteLock(boolean fair) {
        return new ReentrantReadWriteLock(fair);
    }

    public static NoLock getNoLock() {
        return NO_LOCK;
    }
}


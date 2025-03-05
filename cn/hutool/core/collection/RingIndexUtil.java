/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicLong
 */
package cn.hutool.core.collection;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RingIndexUtil {
    public static int ringNextIntByObj(Object object, AtomicInteger atomicInteger) {
        Assert.notNull(object);
        int modulo = CollUtil.size(object);
        return RingIndexUtil.ringNextInt(modulo, atomicInteger);
    }

    public static int ringNextInt(int modulo, AtomicInteger atomicInteger) {
        int next;
        int current;
        Assert.notNull(atomicInteger);
        Assert.isTrue(modulo > 0);
        if (modulo <= 1) {
            return 0;
        }
        while (!atomicInteger.compareAndSet(current = atomicInteger.get(), next = (current + 1) % modulo)) {
        }
        return next;
    }

    public static long ringNextLong(long modulo, AtomicLong atomicLong) {
        long next;
        long current;
        Assert.notNull(atomicLong);
        Assert.isTrue(modulo > 0L);
        if (modulo <= 1L) {
            return 0L;
        }
        while (!atomicLong.compareAndSet(current = atomicLong.get(), next = (current + 1L) % modulo)) {
        }
        return next;
    }
}


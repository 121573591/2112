/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.FunctionalInterface
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.UnsupportedOperationException
 *  java.util.Iterator
 *  java.util.NoSuchElementException
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 */
package cn.hutool.core.lang;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.thread.lock.NoLock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Range<T>
implements Iterable<T>,
Iterator<T>,
Serializable {
    private static final long serialVersionUID = 1L;
    private Lock lock = new ReentrantLock();
    private final T start;
    private final T end;
    private T next;
    private final Stepper<T> stepper;
    private int index = 0;
    private final boolean includeStart;
    private final boolean includeEnd;

    public Range(T start, Stepper<T> stepper) {
        this(start, null, (Stepper<Object>)stepper);
    }

    public Range(T start, T end, Stepper<T> stepper) {
        this(start, end, stepper, true, true);
    }

    public Range(T start, T end, Stepper<T> stepper, boolean isIncludeStart, boolean isIncludeEnd) {
        Assert.notNull(start, "First element must be not null!", new Object[0]);
        this.start = start;
        this.end = end;
        this.stepper = stepper;
        this.next = this.safeStep(this.start);
        this.includeStart = isIncludeStart;
        this.includeEnd = isIncludeEnd;
    }

    public Range<T> disableLock() {
        this.lock = new NoLock();
        return this;
    }

    public boolean hasNext() {
        this.lock.lock();
        try {
            if (0 == this.index && this.includeStart) {
                boolean bl = true;
                return bl;
            }
            if (null == this.next) {
                boolean bl = false;
                return bl;
            }
            if (!this.includeEnd && this.next.equals(this.end)) {
                boolean bl = false;
                return bl;
            }
        }
        finally {
            this.lock.unlock();
        }
        return true;
    }

    public T next() {
        this.lock.lock();
        try {
            if (!this.hasNext()) {
                throw new NoSuchElementException("Has no next range!");
            }
            T t = this.nextUncheck();
            return t;
        }
        finally {
            this.lock.unlock();
        }
    }

    private T nextUncheck() {
        T current;
        if (0 == this.index) {
            current = this.start;
            if (!this.includeStart) {
                ++this.index;
                return this.nextUncheck();
            }
        } else {
            current = this.next;
            this.next = this.safeStep(this.next);
        }
        ++this.index;
        return current;
    }

    private T safeStep(T base) {
        int index = this.index;
        T next = null;
        try {
            next = this.stepper.step(base, this.end, index);
        }
        catch (Exception exception) {
            // empty catch block
        }
        return next;
    }

    public void remove() {
        throw new UnsupportedOperationException("Can not remove ranged element!");
    }

    public Iterator<T> iterator() {
        return this;
    }

    public Range<T> reset() {
        this.lock.lock();
        try {
            this.index = 0;
            this.next = this.safeStep(this.start);
        }
        finally {
            this.lock.unlock();
        }
        return this;
    }

    @FunctionalInterface
    public static interface Stepper<T> {
        public T step(T var1, T var2, int var3);
    }
}


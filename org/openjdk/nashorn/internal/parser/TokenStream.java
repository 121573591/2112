/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 */
package org.openjdk.nashorn.internal.parser;

public class TokenStream {
    private static final int INITIAL_SIZE = 256;
    private long[] buffer = new long[256];
    private int count = 0;
    private int in = 0;
    private int out = 0;
    private int base = 0;

    private int next(int position) {
        int next = position + 1;
        if (next >= this.buffer.length) {
            next = 0;
        }
        return next;
    }

    private int index(int k) {
        int index = k - (this.base - this.out);
        if (index >= this.buffer.length) {
            index -= this.buffer.length;
        }
        return index;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.buffer.length;
    }

    public int count() {
        return this.count;
    }

    public int first() {
        return this.base;
    }

    public int last() {
        return this.base + this.count - 1;
    }

    public void removeLast() {
        if (this.count != 0) {
            --this.count;
            --this.in;
            if (this.in < 0) {
                this.in = this.buffer.length - 1;
            }
        }
    }

    public void put(long token) {
        if (this.count == this.buffer.length) {
            this.grow();
        }
        this.buffer[this.in] = token;
        ++this.count;
        this.in = this.next(this.in);
    }

    public long get(int k) {
        return this.buffer[this.index(k)];
    }

    public void commit(int k) {
        this.out = this.index(k);
        this.count -= k - this.base;
        this.base = k;
    }

    public void grow() {
        long[] newBuffer = new long[this.buffer.length * 2];
        if (this.in > this.out) {
            System.arraycopy((Object)this.buffer, (int)this.out, (Object)newBuffer, (int)0, (int)this.count);
        } else {
            int portion = this.buffer.length - this.out;
            System.arraycopy((Object)this.buffer, (int)this.out, (Object)newBuffer, (int)0, (int)portion);
            System.arraycopy((Object)this.buffer, (int)0, (Object)newBuffer, (int)portion, (int)(this.count - portion));
        }
        this.out = 0;
        this.in = this.count;
        this.buffer = newBuffer;
    }

    void reset() {
        this.base = 0;
        this.count = 0;
        this.out = 0;
        this.in = 0;
    }
}


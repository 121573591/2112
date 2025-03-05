/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Runnable
 */
package cn.hutool.core.thread;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.thread.SyncFinisher;
import java.io.Closeable;
import java.io.IOException;

public class ConcurrencyTester
implements Closeable {
    private final SyncFinisher sf;
    private final TimeInterval timeInterval;
    private long interval;

    public ConcurrencyTester(int threadSize) {
        this.sf = new SyncFinisher(threadSize);
        this.timeInterval = new TimeInterval();
    }

    public ConcurrencyTester test(Runnable runnable2) {
        this.sf.clearWorker();
        this.timeInterval.start();
        this.sf.addRepeatWorker(runnable2).setBeginAtSameTime(true).start();
        this.interval = this.timeInterval.interval();
        return this;
    }

    public ConcurrencyTester reset() {
        this.sf.clearWorker();
        this.timeInterval.restart();
        return this;
    }

    public long getInterval() {
        return this.interval;
    }

    public void close() throws IOException {
        this.sf.close();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.util.LinkedHashSet
 *  java.util.Set
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutorService
 */
package cn.hutool.core.thread;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.NamedThreadFactory;
import java.io.Closeable;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public class SyncFinisher
implements Closeable {
    private final Set<Worker> workers;
    private final int threadSize;
    private ExecutorService executorService;
    private boolean isBeginAtSameTime;
    private final CountDownLatch beginLatch = new CountDownLatch(1);
    private CountDownLatch endLatch;
    private Thread.UncaughtExceptionHandler exceptionHandler;

    public SyncFinisher(int threadSize) {
        this.threadSize = threadSize;
        this.workers = new LinkedHashSet();
    }

    public SyncFinisher setBeginAtSameTime(boolean isBeginAtSameTime) {
        this.isBeginAtSameTime = isBeginAtSameTime;
        return this;
    }

    public SyncFinisher setExceptionHandler(Thread.UncaughtExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
        return this;
    }

    public SyncFinisher addRepeatWorker(final Runnable runnable2) {
        for (int i = 0; i < this.threadSize; ++i) {
            this.addWorker(new Worker(){

                @Override
                public void work() {
                    runnable2.run();
                }
            });
        }
        return this;
    }

    public SyncFinisher addWorker(final Runnable runnable2) {
        return this.addWorker(new Worker(){

            @Override
            public void work() {
                runnable2.run();
            }
        });
    }

    public synchronized SyncFinisher addWorker(Worker worker) {
        this.workers.add((Object)worker);
        return this;
    }

    public void start() {
        this.start(true);
    }

    public void start(boolean sync) {
        this.endLatch = new CountDownLatch(this.workers.size());
        if (null == this.executorService || this.executorService.isShutdown()) {
            this.executorService = this.buildExecutor();
        }
        for (Worker worker : this.workers) {
            if (null != this.exceptionHandler) {
                this.executorService.execute((Runnable)worker);
                continue;
            }
            this.executorService.submit((Runnable)worker);
        }
        this.beginLatch.countDown();
        if (sync) {
            try {
                this.endLatch.await();
            }
            catch (InterruptedException e) {
                throw new UtilException(e);
            }
        }
    }

    public void stop() {
        if (null != this.executorService) {
            this.executorService.shutdown();
            this.executorService = null;
        }
        this.clearWorker();
    }

    public void stopNow() {
        if (null != this.executorService) {
            this.executorService.shutdownNow();
            this.executorService = null;
        }
        this.clearWorker();
    }

    public void clearWorker() {
        this.workers.clear();
    }

    public long count() {
        return this.endLatch.getCount();
    }

    public void close() throws IOException {
        this.stop();
    }

    private ExecutorService buildExecutor() {
        return ExecutorBuilder.create().setCorePoolSize(this.threadSize).setThreadFactory(new NamedThreadFactory("hutool-", null, false, this.exceptionHandler)).build();
    }

    public abstract class Worker
    implements Runnable {
        public void run() {
            if (SyncFinisher.this.isBeginAtSameTime) {
                try {
                    SyncFinisher.this.beginLatch.await();
                }
                catch (InterruptedException e) {
                    throw new UtilException(e);
                }
            }
            try {
                this.work();
            }
            finally {
                SyncFinisher.this.endLatch.countDown();
            }
        }

        public abstract void work();
    }
}


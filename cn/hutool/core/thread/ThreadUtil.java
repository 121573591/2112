/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.InheritableThreadLocal
 *  java.lang.InterruptedException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityManager
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.ThreadGroup
 *  java.lang.ThreadLocal
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CompletionService
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorCompletionService
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.RejectedExecutionHandler
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.function.Supplier
 */
package cn.hutool.core.thread;

import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.GlobalThreadPool;
import cn.hutool.core.thread.NamedThreadFactory;
import cn.hutool.core.thread.RejectPolicy;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.util.RuntimeUtil;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class ThreadUtil {
    public static ExecutorService newExecutor(int corePoolSize) {
        ExecutorBuilder builder = ExecutorBuilder.create();
        if (corePoolSize > 0) {
            builder.setCorePoolSize(corePoolSize);
        }
        return builder.build();
    }

    public static ExecutorService newExecutor() {
        return ExecutorBuilder.create().useSynchronousQueue().build();
    }

    public static ExecutorService newSingleExecutor() {
        return ExecutorBuilder.create().setCorePoolSize(1).setMaxPoolSize(1).setKeepAliveTime(0L).buildFinalizable();
    }

    public static ThreadPoolExecutor newExecutor(int corePoolSize, int maximumPoolSize) {
        return ExecutorBuilder.create().setCorePoolSize(corePoolSize).setMaxPoolSize(maximumPoolSize).build();
    }

    public static ExecutorService newExecutor(int corePoolSize, int maximumPoolSize, int maximumQueueSize) {
        return ExecutorBuilder.create().setCorePoolSize(corePoolSize).setMaxPoolSize(maximumPoolSize).setWorkQueue((BlockingQueue<Runnable>)new LinkedBlockingQueue(maximumQueueSize)).build();
    }

    public static ThreadPoolExecutor newExecutorByBlockingCoefficient(float blockingCoefficient) {
        if (blockingCoefficient >= 1.0f || blockingCoefficient < 0.0f) {
            throw new IllegalArgumentException("[blockingCoefficient] must between 0 and 1, or equals 0.");
        }
        int poolSize = (int)((float)RuntimeUtil.getProcessorCount() / (1.0f - blockingCoefficient));
        return ExecutorBuilder.create().setCorePoolSize(poolSize).setMaxPoolSize(poolSize).setKeepAliveTime(0L).build();
    }

    public static ExecutorService newFixedExecutor(int nThreads, String threadNamePrefix, boolean isBlocked) {
        return ThreadUtil.newFixedExecutor(nThreads, 1024, threadNamePrefix, isBlocked);
    }

    public static ExecutorService newFixedExecutor(int nThreads, int maximumQueueSize, String threadNamePrefix, boolean isBlocked) {
        return ThreadUtil.newFixedExecutor(nThreads, maximumQueueSize, threadNamePrefix, (isBlocked ? RejectPolicy.BLOCK : RejectPolicy.ABORT).getValue());
    }

    public static ExecutorService newFixedExecutor(int nThreads, int maximumQueueSize, String threadNamePrefix, RejectedExecutionHandler handler) {
        return ExecutorBuilder.create().setCorePoolSize(nThreads).setMaxPoolSize(nThreads).setWorkQueue((BlockingQueue<Runnable>)new LinkedBlockingQueue(maximumQueueSize)).setThreadFactory(ThreadUtil.createThreadFactory(threadNamePrefix)).setHandler(handler).build();
    }

    public static void execute(Runnable runnable2) {
        GlobalThreadPool.execute(runnable2);
    }

    public static Runnable execAsync(Runnable runnable2, boolean isDaemon) {
        Thread thread = new Thread(runnable2);
        thread.setDaemon(isDaemon);
        thread.start();
        return runnable2;
    }

    public static <T> Future<T> execAsync(Callable<T> task) {
        return GlobalThreadPool.submit(task);
    }

    public static Future<?> execAsync(Runnable runnable2) {
        return GlobalThreadPool.submit(runnable2);
    }

    public static <T> CompletionService<T> newCompletionService() {
        return new ExecutorCompletionService((Executor)GlobalThreadPool.getExecutor());
    }

    public static <T> CompletionService<T> newCompletionService(ExecutorService executor) {
        return new ExecutorCompletionService((Executor)executor);
    }

    public static CountDownLatch newCountDownLatch(int threadCount) {
        return new CountDownLatch(threadCount);
    }

    public static Thread newThread(Runnable runnable2, String name) {
        Thread t = ThreadUtil.newThread(runnable2, name, false);
        if (t.getPriority() != 5) {
            t.setPriority(5);
        }
        return t;
    }

    public static Thread newThread(Runnable runnable2, String name, boolean isDaemon) {
        Thread t = new Thread(null, runnable2, name);
        t.setDaemon(isDaemon);
        return t;
    }

    public static boolean sleep(Number timeout2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(timeout2.longValue());
        }
        catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    public static boolean sleep(Number millis) {
        if (millis == null) {
            return true;
        }
        return ThreadUtil.sleep(millis.longValue());
    }

    public static boolean sleep(long millis) {
        if (millis > 0L) {
            try {
                Thread.sleep((long)millis);
            }
            catch (InterruptedException e) {
                return false;
            }
        }
        return true;
    }

    public static boolean safeSleep(Number millis) {
        if (millis == null) {
            return true;
        }
        return ThreadUtil.safeSleep(millis.longValue());
    }

    public static boolean safeSleep(long millis) {
        long spendTime;
        for (long done = 0L; done >= 0L && done < millis; done += spendTime) {
            long before = System.currentTimeMillis();
            if (!ThreadUtil.sleep(millis - done)) {
                return false;
            }
            spendTime = System.currentTimeMillis() - before;
            if (spendTime <= 0L) break;
        }
        return true;
    }

    public static StackTraceElement[] getStackTrace() {
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement getStackTraceElement(int i) {
        StackTraceElement[] stackTrace = ThreadUtil.getStackTrace();
        if (i < 0) {
            i += stackTrace.length;
        }
        return stackTrace[i];
    }

    public static <T> ThreadLocal<T> createThreadLocal(boolean isInheritable) {
        if (isInheritable) {
            return new InheritableThreadLocal();
        }
        return new ThreadLocal();
    }

    public static <T> ThreadLocal<T> createThreadLocal(Supplier<? extends T> supplier) {
        return ThreadLocal.withInitial(supplier);
    }

    public static ThreadFactoryBuilder createThreadFactoryBuilder() {
        return ThreadFactoryBuilder.create();
    }

    public static ThreadFactory createThreadFactory(String threadNamePrefix) {
        return ThreadFactoryBuilder.create().setNamePrefix(threadNamePrefix).build();
    }

    public static void interrupt(Thread thread, boolean isJoin) {
        if (null != thread && !thread.isInterrupted()) {
            thread.interrupt();
            if (isJoin) {
                ThreadUtil.waitForDie(thread);
            }
        }
    }

    public static void waitForDie() {
        ThreadUtil.waitForDie(Thread.currentThread());
    }

    public static void waitForDie(Thread thread) {
        if (null == thread) {
            return;
        }
        boolean dead = false;
        do {
            try {
                thread.join();
                dead = true;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        } while (!dead);
    }

    public static Thread[] getThreads() {
        return ThreadUtil.getThreads(Thread.currentThread().getThreadGroup().getParent());
    }

    public static Thread[] getThreads(ThreadGroup group) {
        Thread[] slackList = new Thread[group.activeCount() * 2];
        int actualSize = group.enumerate(slackList);
        Thread[] result = new Thread[actualSize];
        System.arraycopy((Object)slackList, (int)0, (Object)result, (int)0, (int)actualSize);
        return result;
    }

    public static Thread getMainThread() {
        for (Thread thread : ThreadUtil.getThreads()) {
            if (thread.getId() != 1L) continue;
            return thread;
        }
        return null;
    }

    public static ThreadGroup currentThreadGroup() {
        SecurityManager s = System.getSecurityManager();
        return null != s ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    public static ThreadFactory newNamedThreadFactory(String prefix, boolean isDaemon) {
        return new NamedThreadFactory(prefix, isDaemon);
    }

    public static ThreadFactory newNamedThreadFactory(String prefix, ThreadGroup threadGroup, boolean isDaemon) {
        return new NamedThreadFactory(prefix, threadGroup, isDaemon);
    }

    public static ThreadFactory newNamedThreadFactory(String prefix, ThreadGroup threadGroup, boolean isDaemon, Thread.UncaughtExceptionHandler handler) {
        return new NamedThreadFactory(prefix, threadGroup, isDaemon, handler);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void sync(Object obj) {
        Object object = obj;
        synchronized (object) {
            try {
                obj.wait();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    public static ConcurrencyTester concurrencyTest(int threadSize, Runnable runnable2) {
        return new ConcurrencyTester(threadSize).test(runnable2);
    }

    public static ScheduledThreadPoolExecutor createScheduledExecutor(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    public static ScheduledThreadPoolExecutor schedule(ScheduledThreadPoolExecutor executor, Runnable command, long initialDelay, long period, boolean fixedRateOrFixedDelay) {
        return ThreadUtil.schedule(executor, command, initialDelay, period, TimeUnit.MILLISECONDS, fixedRateOrFixedDelay);
    }

    public static ScheduledThreadPoolExecutor schedule(ScheduledThreadPoolExecutor executor, Runnable command, long initialDelay, long period, TimeUnit timeUnit, boolean fixedRateOrFixedDelay) {
        if (null == executor) {
            executor = ThreadUtil.createScheduledExecutor(2);
        }
        if (fixedRateOrFixedDelay) {
            executor.scheduleAtFixedRate(command, initialDelay, period, timeUnit);
        } else {
            executor.scheduleWithFixedDelay(command, initialDelay, period, timeUnit);
        }
        return executor;
    }
}


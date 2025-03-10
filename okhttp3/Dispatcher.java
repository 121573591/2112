/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Call;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ^\n\n \n\n\b\n\n \n\n\n\b\t\n\n\b\n\n\b\n\n\b\n \n\n\b\n\b\n\b\n\n\b\n\n\b 20B\b0¢\bB¢\bJ\r\b0¢\b\bJ02\n0\tR0\nH ¢\b\f\rJ020\nH ¢\bJ0H¢\bJ\b0\tR0\n20H¢\bJ+0\"\b 2\f\b8 028 H¢\bJ020\nH ¢\bJ02\n0\tR0\nH ¢\b\rJ0H¢\b J#\b0\"0!¢\b#$J\r&0%¢\b&'J(\b0\"0!¢\b($J\r)0%¢\b)'R08G¢\bR*08@X¢\n\b*+R..0,2\b-0,8F@FX¢\n\b./\b01\"\b23R*40%240%8F@FX¢\n\b45\b6'\"\b78R*90%290%8F@FX¢\n\b95\b:'\"\b;8R=\f\b0\tR0\n0<8X¢\n\b=>R?\f\b0\tR0\n0<8X¢\n\b?>R@\b0\n0<8X¢\n\b@>¨A"}, d2={"Lokhttp3/Dispatcher;", "", "Ljava/util/concurrent/ExecutorService;", "executorService", "<init>", "(Ljava/util/concurrent/ExecutorService;)V", "()V", "", "cancelAll", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "call", "enqueue$okhttp", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "enqueue", "executed$okhttp", "(Lokhttp3/internal/connection/RealCall;)V", "executed", "-deprecated_executorService", "()Ljava/util/concurrent/ExecutorService;", "", "host", "findExistingCallWithHost", "(Ljava/lang/String;)Lokhttp3/internal/connection/RealCall$AsyncCall;", "T", "Ljava/util/Deque;", "calls", "finished", "(Ljava/util/Deque;Ljava/lang/Object;)V", "finished$okhttp", "", "promoteAndExecute", "()Z", "", "Lokhttp3/Call;", "queuedCalls", "()Ljava/util/List;", "", "queuedCallsCount", "()I", "runningCalls", "runningCallsCount", "executorServiceOrNull", "Ljava/util/concurrent/ExecutorService;", "Ljava/lang/Runnable;", "<set-?>", "idleCallback", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "maxRequests", "I", "getMaxRequests", "setMaxRequests", "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", "setMaxRequestsPerHost", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "Ljava/util/ArrayDeque;", "runningAsyncCalls", "runningSyncCalls", "okhttp"})
@SourceDebugExtension(value={"SMAP\nDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dispatcher.kt\nokhttp3/Dispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokhttp3/internal/Util\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,241:1\n1#2:242\n615#3,4:243\n1549#4:247\n1620#4,3:248\n1549#4:251\n1620#4,3:252\n*S KotlinDebug\n*F\n+ 1 Dispatcher.kt\nokhttp3/Dispatcher\n*L\n162#1:243,4\n222#1:247\n222#1:248,3\n227#1:251\n227#1:252,3\n*E\n"})
public final class Dispatcher {
    private int maxRequests;
    private int maxRequestsPerHost;
    @Nullable
    private Runnable idleCallback;
    @Nullable
    private ExecutorService executorServiceOrNull;
    @NotNull
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    @NotNull
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    @NotNull
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setMaxRequests(int maxRequests) {
        if (!(maxRequests >= 1)) {
            boolean $i$a$-require-Dispatcher$maxRequests$22 = false;
            String $i$a$-require-Dispatcher$maxRequests$22 = "max < 1: " + maxRequests;
            throw new IllegalArgumentException($i$a$-require-Dispatcher$maxRequests$22.toString());
        }
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            boolean bl = false;
            this.maxRequests = maxRequests;
            Unit unit = Unit.INSTANCE;
        }
        this.promoteAndExecute();
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void setMaxRequestsPerHost(int maxRequestsPerHost) {
        if (!(maxRequestsPerHost >= 1)) {
            boolean $i$a$-require-Dispatcher$maxRequestsPerHost$22 = false;
            String $i$a$-require-Dispatcher$maxRequestsPerHost$22 = "max < 1: " + maxRequestsPerHost;
            throw new IllegalArgumentException($i$a$-require-Dispatcher$maxRequestsPerHost$22.toString());
        }
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            boolean bl = false;
            this.maxRequestsPerHost = maxRequestsPerHost;
            Unit unit = Unit.INSTANCE;
        }
        this.promoteAndExecute();
    }

    @Nullable
    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized void setIdleCallback(@Nullable Runnable runnable2) {
        this.idleCallback = runnable2;
    }

    @JvmName(name="executorService")
    @NotNull
    public final synchronized ExecutorService executorService() {
        if (this.executorServiceOrNull == null) {
            this.executorServiceOrNull = (ExecutorService)new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), Util.threadFactory(Util.okHttpName + " Dispatcher", false));
        }
        ExecutorService executorService = this.executorServiceOrNull;
        Intrinsics.checkNotNull((Object)executorService);
        return executorService;
    }

    public Dispatcher(@NotNull ExecutorService executorService) {
        Intrinsics.checkNotNullParameter((Object)executorService, (String)"executorService");
        this();
        this.executorServiceOrNull = executorService;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void enqueue$okhttp(@NotNull RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            RealCall.AsyncCall existingCall;
            boolean bl = false;
            this.readyAsyncCalls.add((Object)call);
            if (!call.getCall().getForWebSocket() && (existingCall = this.findExistingCallWithHost(call.getHost())) != null) {
                call.reuseCallsPerHostFrom(existingCall);
            }
            Unit unit = Unit.INSTANCE;
        }
        this.promoteAndExecute();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String host) {
        for (RealCall.AsyncCall existingCall : this.runningAsyncCalls) {
            if (!Intrinsics.areEqual((Object)existingCall.getHost(), (Object)host)) continue;
            return existingCall;
        }
        for (RealCall.AsyncCall existingCall : this.readyAsyncCalls) {
            if (!Intrinsics.areEqual((Object)existingCall.getHost(), (Object)host)) continue;
            return existingCall;
        }
        return null;
    }

    public final synchronized void cancelAll() {
        for (Object call : this.readyAsyncCalls) {
            ((RealCall.AsyncCall)call).getCall().cancel();
        }
        for (Object call : this.runningAsyncCalls) {
            ((RealCall.AsyncCall)call).getCall().cancel();
        }
        for (Object call : this.runningSyncCalls) {
            ((RealCall)call).cancel();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final boolean promoteAndExecute() {
        Dispatcher $this$assertThreadDoesntHoldLock$iv = this;
        boolean $i$f$assertThreadDoesntHoldLock = false;
        if (Util.assertionsEnabled && Thread.holdsLock((Object)$this$assertThreadDoesntHoldLock$iv)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock$iv));
        }
        List executableCalls = (List)new ArrayList();
        boolean isRunning = false;
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            boolean bl = false;
            Iterator iterator = this.readyAsyncCalls.iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"readyAsyncCalls.iterator()");
            Iterator i = iterator;
            while (i.hasNext()) {
                RealCall.AsyncCall asyncCall = (RealCall.AsyncCall)i.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) break;
                if (asyncCall.getCallsPerHost().get() >= this.maxRequestsPerHost) continue;
                i.remove();
                asyncCall.getCallsPerHost().incrementAndGet();
                Intrinsics.checkNotNullExpressionValue((Object)asyncCall, (String)"asyncCall");
                executableCalls.add((Object)asyncCall);
                this.runningAsyncCalls.add((Object)asyncCall);
            }
            isRunning = this.runningCallsCount() > 0;
            Unit unit = Unit.INSTANCE;
        }
        int n = executableCalls.size();
        for (int i = 0; i < n; ++i) {
            RealCall.AsyncCall asyncCall = (RealCall.AsyncCall)executableCalls.get(i);
            asyncCall.executeOn(this.executorService());
        }
        return isRunning;
    }

    public final synchronized void executed$okhttp(@NotNull RealCall call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.runningSyncCalls.add((Object)call);
    }

    public final void finished$okhttp(@NotNull RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        call.getCallsPerHost().decrementAndGet();
        this.finished((Deque)this.runningAsyncCalls, call);
    }

    public final void finished$okhttp(@NotNull RealCall call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.finished((Deque)this.runningSyncCalls, call);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final <T> void finished(Deque<T> calls, T call) {
        Runnable idleCallback = null;
        Dispatcher dispatcher = this;
        synchronized (dispatcher) {
            boolean bl = false;
            if (!calls.remove(call)) {
                throw new AssertionError((Object)"Call wasn't in-flight!");
            }
            idleCallback = this.idleCallback;
            Unit unit = Unit.INSTANCE;
        }
        boolean isRunning = this.promoteAndExecute();
        if (!isRunning && idleCallback != null) {
            idleCallback.run();
        }
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final synchronized List<Call> queuedCalls() {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = (Iterable)this.readyAsyncCalls;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            RealCall.AsyncCall asyncCall = (RealCall.AsyncCall)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add((Object)it.getCall());
        }
        List list = Collections.unmodifiableList((List)((List)destination$iv$iv));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"unmodifiableList(readyAsyncCalls.map { it.call })");
        return list;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final synchronized List<Call> runningCalls() {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Iterable iterable = (Iterable)this.runningAsyncCalls;
        Collection collection = (Collection)this.runningSyncCalls;
        boolean $i$f$map = false;
        void var3_4 = $this$map$iv;
        Collection destination$iv$iv = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            RealCall.AsyncCall asyncCall = (RealCall.AsyncCall)item$iv$iv;
            Collection collection2 = destination$iv$iv;
            boolean bl = false;
            collection2.add((Object)it.getCall());
        }
        List list = Collections.unmodifiableList((List)CollectionsKt.plus((Collection)collection, (Iterable)((Iterable)((List)destination$iv$iv))));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"unmodifiableList(running…yncCalls.map { it.call })");
        return list;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="executorService", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_executorService")
    @NotNull
    public final ExecutorService -deprecated_executorService() {
        return this.executorService();
    }
}


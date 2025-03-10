/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.concurrent.TaskQueue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ,\n\n \n\n \n\n\b\n\n \n\n\b\n\t\n\b\b& 20B0\b\b0¢\bJ\r0\n2\t0\bH ¢\b\fJ0H&¢\bJ0H¢\bR08¢\f\n\b\bR08¢\f\n\b\bR\"08 @ X¢\n\b\b\"\bR$\t0\b8 @ X¢\n\b\t\b\"\b \f¨!"}, d2={"Lokhttp3/internal/concurrent/Task;", "", "", "name", "", "cancelable", "<init>", "(Ljava/lang/String;Z)V", "Lokhttp3/internal/concurrent/TaskQueue;", "queue", "", "initQueue$okhttp", "(Lokhttp3/internal/concurrent/TaskQueue;)V", "initQueue", "", "runOnce", "()J", "toString", "()Ljava/lang/String;", "Z", "getCancelable", "()Z", "Ljava/lang/String;", "getName", "nextExecuteNanoTime", "J", "getNextExecuteNanoTime$okhttp", "setNextExecuteNanoTime$okhttp", "(J)V", "Lokhttp3/internal/concurrent/TaskQueue;", "getQueue$okhttp", "()Lokhttp3/internal/concurrent/TaskQueue;", "setQueue$okhttp", "okhttp"})
@SourceDebugExtension(value={"SMAP\nTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Task.kt\nokhttp3/internal/concurrent/Task\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
public abstract class Task {
    @NotNull
    private final String name;
    private final boolean cancelable;
    @Nullable
    private TaskQueue queue;
    private long nextExecuteNanoTime;

    public Task(@NotNull String name, boolean cancelable) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.name = name;
        this.cancelable = cancelable;
        this.nextExecuteNanoTime = -1L;
    }

    public /* synthetic */ Task(String string, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = true;
        }
        this(string, bl);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    @Nullable
    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void setQueue$okhttp(@Nullable TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    public final void setNextExecuteNanoTime$okhttp(long l) {
        this.nextExecuteNanoTime = l;
    }

    public abstract long runOnce();

    public final void initQueue$okhttp(@NotNull TaskQueue queue) {
        Intrinsics.checkNotNullParameter((Object)queue, (String)"queue");
        if (this.queue == queue) {
            return;
        }
        if (!(this.queue == null)) {
            boolean bl = false;
            String string = "task is in multiple queues";
            throw new IllegalStateException(string.toString());
        }
        this.queue = queue;
    }

    @NotNull
    public String toString() {
        return this.name;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.locks.Condition
 *  java.util.concurrent.locks.Lock
 *  java.util.concurrent.locks.ReentrantLock
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" T\n\n \n\t\n\b\n\n\b\n\n\b\n\n\b\n\n\n\b\n\n\b\n\n\b\n\n\b\b\n\n\b 20B0¢\bJ\r0¢\b\bJ02\n0\t¢\b\fJ\n0\tH¢\b\rJ0H¢\bJ-0*0\t20\t00¢\bH\b¢\bR08 X¢\f\n\b\bR\"08 @ X¢\n\b\b !\"\b\"#R%0$8¢\f\n\b%&\b'(R$)0\t8 @ X¢\n\b)*\b+\"\b,\fR.0-8¢\f\n\b./\b01R08 X¢\f\n\b2\b34R\n0\t8G¢\f\n\b\n*\b\nR\"508 @ X¢\n\b5\b6!\"\b7#R08G¢\f\n\b8\bR\"908 @ X¢\n\b9\b:!\"\b;#¨<"}, d2={"Lokio/Pipe;", "", "", "maxBufferSize", "<init>", "(J)V", "", "cancel", "()V", "Lokio/Sink;", "sink", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", "source", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "forward", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "", "canceled", "Z", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "setFoldedSink$okio", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "J", "getMaxBufferSize$okio", "()J", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "okio"})
@SourceDebugExtension(value={"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Timeout.kt\nokio/Timeout\n*L\n1#1,257:1\n1#2:258\n268#3,26:259\n*S KotlinDebug\n*F\n+ 1 Pipe.kt\nokio/Pipe\n*L\n217#1:259,26\n*E\n"})
public final class Pipe {
    private final long maxBufferSize;
    @NotNull
    private final Buffer buffer;
    private boolean canceled;
    private boolean sinkClosed;
    private boolean sourceClosed;
    @Nullable
    private Sink foldedSink;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final Condition condition;
    @NotNull
    private final Sink sink;
    @NotNull
    private final Source source;

    public Pipe(long maxBufferSize) {
        this.maxBufferSize = maxBufferSize;
        this.buffer = new Buffer();
        this.lock = new ReentrantLock();
        Condition condition = this.lock.newCondition();
        Intrinsics.checkNotNullExpressionValue((Object)condition, (String)"newCondition(...)");
        this.condition = condition;
        if (!(this.maxBufferSize >= 1L)) {
            boolean bl = false;
            String string = "maxBufferSize < 1: " + this.maxBufferSize;
            throw new IllegalArgumentException(string.toString());
        }
        this.sink = new Sink(this){
            @NotNull
            private final Timeout timeout;
            final /* synthetic */ Pipe this$0;
            {
                this.this$0 = $receiver;
                this.timeout = new Timeout();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * WARNING - void declaration
             */
            public void write(@NotNull Buffer source2, long byteCount) {
                Object it;
                Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
                long byteCount2 = 0L;
                byteCount2 = byteCount;
                Sink delegate = null;
                Lock lock = (Lock)this.this$0.getLock();
                Pipe pipe = this.this$0;
                lock.lock();
                try {
                    boolean $i$a$-withLock-Pipe$sink$1$write$22 = false;
                    if (!(!pipe.getSinkClosed$okio())) {
                        boolean $i$a$-check-Pipe$sink$1$write$1$22 = false;
                        String $i$a$-check-Pipe$sink$1$write$1$22 = "closed";
                        throw new IllegalStateException($i$a$-check-Pipe$sink$1$write$1$22.toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (byteCount2 > 0L) {
                        Sink sink2 = pipe.getFoldedSink$okio();
                        if (sink2 != null) {
                            it = sink2;
                            boolean bl = false;
                            delegate = it;
                            break;
                        }
                        if (pipe.getSourceClosed$okio()) {
                            throw new IOException("source is closed");
                        }
                        long bufferSpaceAvailable = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (bufferSpaceAvailable == 0L) {
                            this.timeout.awaitSignal(pipe.getCondition());
                            if (!pipe.getCanceled$okio()) continue;
                            throw new IOException("canceled");
                        }
                        long bytesToWrite = Math.min((long)bufferSpaceAvailable, (long)byteCount2);
                        pipe.getBuffer$okio().write(source2, bytesToWrite);
                        byteCount2 -= bytesToWrite;
                        pipe.getCondition().signalAll();
                    }
                    Unit $i$a$-withLock-Pipe$sink$1$write$22 = Unit.INSTANCE;
                }
                finally {
                    lock.unlock();
                }
                lock = delegate;
                if (lock != null) {
                    void this_$iv$iv;
                    void this_$iv;
                    pipe = this.this$0;
                    Lock $this$forward$iv = lock;
                    boolean $i$f$forward = false;
                    it = $this$forward$iv.timeout();
                    Timeout other$iv$iv = this_$iv.sink().timeout();
                    boolean $i$f$intersectWith = false;
                    long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                    this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (this_$iv$iv.hasDeadline()) {
                        long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(Math.min((long)this_$iv$iv.deadlineNanoTime(), (long)other$iv$iv.deadlineNanoTime()));
                        }
                        try {
                            boolean bl = false;
                            Lock $this$write_u24lambda_u243 = $this$forward$iv;
                            boolean bl2 = false;
                            $this$write_u24lambda_u243.write(source2, byteCount2);
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                        }
                    }
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                    }
                    try {
                        boolean bl = false;
                        Lock $this$write_u24lambda_u243 = $this$forward$iv;
                        boolean bl3 = false;
                        $this$write_u24lambda_u243.write(source2, byteCount2);
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.clearDeadline();
                        }
                    }
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * WARNING - void declaration
             */
            public void flush() {
                Object it;
                Sink delegate = null;
                Object object = (Lock)this.this$0.getLock();
                Pipe pipe = this.this$0;
                object.lock();
                try {
                    boolean $i$a$-withLock-Pipe$sink$1$flush$22 = false;
                    if (!(!pipe.getSinkClosed$okio())) {
                        boolean $i$a$-check-Pipe$sink$1$flush$1$22 = false;
                        String $i$a$-check-Pipe$sink$1$flush$1$22 = "closed";
                        throw new IllegalStateException($i$a$-check-Pipe$sink$1$flush$1$22.toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink sink2 = pipe.getFoldedSink$okio();
                    if (sink2 != null) {
                        it = sink2;
                        boolean bl = false;
                        delegate = it;
                    } else if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0L) {
                        throw new IOException("source is closed");
                    }
                    Unit $i$a$-withLock-Pipe$sink$1$flush$22 = Unit.INSTANCE;
                }
                finally {
                    object.unlock();
                }
                object = delegate;
                if (object != null) {
                    void this_$iv$iv;
                    void this_$iv;
                    pipe = this.this$0;
                    Object $this$forward$iv = object;
                    boolean $i$f$forward = false;
                    it = $this$forward$iv.timeout();
                    Timeout other$iv$iv = this_$iv.sink().timeout();
                    boolean $i$f$intersectWith = false;
                    long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                    this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (this_$iv$iv.hasDeadline()) {
                        long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(Math.min((long)this_$iv$iv.deadlineNanoTime(), (long)other$iv$iv.deadlineNanoTime()));
                        }
                        try {
                            boolean bl = false;
                            Object $this$flush_u24lambda_u247 = $this$forward$iv;
                            boolean bl2 = false;
                            $this$flush_u24lambda_u247.flush();
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                        }
                    }
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                    }
                    try {
                        boolean bl = false;
                        Object $this$flush_u24lambda_u247 = $this$forward$iv;
                        boolean bl3 = false;
                        $this$flush_u24lambda_u247.flush();
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.clearDeadline();
                        }
                    }
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * WARNING - void declaration
             */
            public void close() {
                Sink delegate = null;
                Object object = (Lock)this.this$0.getLock();
                Pipe pipe = this.this$0;
                object.lock();
                try {
                    boolean bl = false;
                    if (pipe.getSinkClosed$okio()) {
                        return;
                    }
                    Sink sink2 = pipe.getFoldedSink$okio();
                    if (sink2 != null) {
                        Sink it = sink2;
                        boolean bl2 = false;
                        delegate = it;
                    } else {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0L) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                    }
                    Unit $i$a$-withLock-Pipe$sink$1$close$2 = Unit.INSTANCE;
                }
                finally {
                    object.unlock();
                }
                object = delegate;
                if (object != null) {
                    void this_$iv$iv;
                    void this_$iv;
                    pipe = this.this$0;
                    Object $this$forward$iv = object;
                    boolean $i$f$forward = false;
                    Timeout bl2 = $this$forward$iv.timeout();
                    Timeout other$iv$iv = this_$iv.sink().timeout();
                    boolean $i$f$intersectWith = false;
                    long originalTimeout$iv$iv = this_$iv$iv.timeoutNanos();
                    this_$iv$iv.timeout(Timeout.Companion.minTimeout(other$iv$iv.timeoutNanos(), this_$iv$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (this_$iv$iv.hasDeadline()) {
                        long originalDeadline$iv$iv = this_$iv$iv.deadlineNanoTime();
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.deadlineNanoTime(Math.min((long)this_$iv$iv.deadlineNanoTime(), (long)other$iv$iv.deadlineNanoTime()));
                        }
                        try {
                            boolean bl = false;
                            Object $this$close_u24lambda_u2410 = $this$forward$iv;
                            boolean bl3 = false;
                            $this$close_u24lambda_u2410.close();
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                            if (other$iv$iv.hasDeadline()) {
                                this_$iv$iv.deadlineNanoTime(originalDeadline$iv$iv);
                            }
                        }
                    }
                    if (other$iv$iv.hasDeadline()) {
                        this_$iv$iv.deadlineNanoTime(other$iv$iv.deadlineNanoTime());
                    }
                    try {
                        boolean bl = false;
                        Object $this$close_u24lambda_u2410 = $this$forward$iv;
                        boolean bl4 = false;
                        $this$close_u24lambda_u2410.close();
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        this_$iv$iv.timeout(originalTimeout$iv$iv, TimeUnit.NANOSECONDS);
                        if (other$iv$iv.hasDeadline()) {
                            this_$iv$iv.clearDeadline();
                        }
                    }
                }
            }

            @NotNull
            public Timeout timeout() {
                return this.timeout;
            }
        };
        this.source = new Source(this){
            @NotNull
            private final Timeout timeout;
            final /* synthetic */ Pipe this$0;
            {
                this.this$0 = $receiver;
                this.timeout = new Timeout();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long read(@NotNull Buffer sink2, long byteCount) {
                Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
                Lock lock = (Lock)this.this$0.getLock();
                Pipe pipe = this.this$0;
                lock.lock();
                try {
                    boolean bl = false;
                    if (!(!pipe.getSourceClosed$okio())) {
                        boolean bl2 = false;
                        String string = "closed";
                        throw new IllegalStateException(string.toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer$okio().size() == 0L) {
                        if (pipe.getSinkClosed$okio()) {
                            long l = -1L;
                            return l;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (!pipe.getCanceled$okio()) continue;
                        throw new IOException("canceled");
                    }
                    long result = pipe.getBuffer$okio().read(sink2, byteCount);
                    pipe.getCondition().signalAll();
                    long l = result;
                    return l;
                }
                finally {
                    lock.unlock();
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void close() {
                Lock lock = (Lock)this.this$0.getLock();
                Pipe pipe = this.this$0;
                lock.lock();
                try {
                    boolean bl = false;
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                    Unit unit = Unit.INSTANCE;
                }
                finally {
                    lock.unlock();
                }
            }

            @NotNull
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean bl) {
        this.canceled = bl;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean bl) {
        this.sinkClosed = bl;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean bl) {
        this.sourceClosed = bl;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink2) {
        this.foldedSink = sink2;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    @JvmName(name="sink")
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName(name="source")
    @NotNull
    public final Source source() {
        return this.source;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void fold(@NotNull Sink sink2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        while (true) {
            boolean closed = false;
            Buffer sinkBuffer = null;
            Lock lock = (Lock)this.lock;
            lock.lock();
            try {
                boolean bl = false;
                if (!(this.foldedSink == null)) {
                    boolean bl2 = false;
                    String string = "sink already folded";
                    throw new IllegalStateException(string.toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink2;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink2;
                    return;
                }
                closed = this.sinkClosed;
                sinkBuffer = new Buffer();
                sinkBuffer.write(this.buffer, this.buffer.size());
                this.condition.signalAll();
                Unit unit = Unit.INSTANCE;
            }
            finally {
                lock.unlock();
            }
            boolean success = false;
            try {
                sink2.write(sinkBuffer, sinkBuffer.size());
                if (closed) {
                    sink2.close();
                } else {
                    sink2.flush();
                }
                success = true;
            }
            catch (Throwable throwable) {
                Lock lock2 = (Lock)this.lock;
                lock2.lock();
                try {
                    boolean bl = false;
                    this.sourceClosed = true;
                    this.condition.signalAll();
                    Unit unit = Unit.INSTANCE;
                    throw throwable;
                }
                finally {
                    lock2.unlock();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final void forward(Sink $this$forward, Function1<? super Sink, Unit> block) {
        void this_$iv;
        boolean $i$f$forward = false;
        Timeout timeout2 = $this$forward.timeout();
        Timeout other$iv = this.sink().timeout();
        boolean $i$f$intersectWith = false;
        long originalTimeout$iv = this_$iv.timeoutNanos();
        this_$iv.timeout(Timeout.Companion.minTimeout(other$iv.timeoutNanos(), this_$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this_$iv.hasDeadline()) {
            long originalDeadline$iv = this_$iv.deadlineNanoTime();
            if (other$iv.hasDeadline()) {
                this_$iv.deadlineNanoTime(Math.min((long)this_$iv.deadlineNanoTime(), (long)other$iv.deadlineNanoTime()));
            }
            try {
                boolean bl = false;
                block.invoke((Object)$this$forward);
                Unit unit = Unit.INSTANCE;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                if (other$iv.hasDeadline()) {
                    this_$iv.deadlineNanoTime(originalDeadline$iv);
                }
                InlineMarker.finallyEnd((int)1);
            }
        }
        if (other$iv.hasDeadline()) {
            this_$iv.deadlineNanoTime(other$iv.deadlineNanoTime());
        }
        try {
            boolean bl = false;
            block.invoke((Object)$this$forward);
            Unit unit = Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
            if (other$iv.hasDeadline()) {
                this_$iv.clearDeadline();
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="sink", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_sink")
    @NotNull
    public final Sink -deprecated_sink() {
        return this.sink;
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="source", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_source")
    @NotNull
    public final Source -deprecated_source() {
        return this.source;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void cancel() {
        Lock lock = (Lock)this.lock;
        lock.lock();
        try {
            boolean bl = false;
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        }
        finally {
            lock.unlock();
        }
    }
}


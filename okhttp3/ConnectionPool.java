/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.TimeUnit
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" ,\n\n \n\b\n \n\t\n \n\n\b\n\n\b\n\n\b 20B!\b000¢\b\b\tB\t\b¢\b\b\nB\b \f0¢\b\b\rJ\r0¢\bJ\r0¢\b\nJ\r0¢\bR\f08 X¢\f\n\b\f\b¨"}, d2={"Lokhttp3/ConnectionPool;", "", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(IJLjava/util/concurrent/TimeUnit;)V", "()V", "Lokhttp3/internal/connection/RealConnectionPool;", "delegate", "(Lokhttp3/internal/connection/RealConnectionPool;)V", "connectionCount", "()I", "", "evictAll", "idleConnectionCount", "Lokhttp3/internal/connection/RealConnectionPool;", "getDelegate$okhttp", "()Lokhttp3/internal/connection/RealConnectionPool;", "okhttp"})
public final class ConnectionPool {
    @NotNull
    private final RealConnectionPool delegate;

    public ConnectionPool(@NotNull RealConnectionPool delegate) {
        Intrinsics.checkNotNullParameter((Object)delegate, (String)"delegate");
        this.delegate = delegate;
    }

    @NotNull
    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public ConnectionPool(int maxIdleConnections, long keepAliveDuration, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)timeUnit, (String)"timeUnit");
        this(new RealConnectionPool(TaskRunner.INSTANCE, maxIdleConnections, keepAliveDuration, timeUnit));
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }
}


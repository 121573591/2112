/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={" \n\n \n\n\b\n\n\b\bf 20J0H&¢\bJ0H&¢\b¨\b"}, d2={"Lokhttp3/internal/cache/CacheRequest;", "", "", "abort", "()V", "Lokio/Sink;", "body", "()Lokio/Sink;", "okhttp"})
public interface CacheRequest {
    @NotNull
    public Sink body() throws IOException;

    public void abort();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" F\n\n\n \n\n\b\n\n \n\n\b\n\n \n\t\n\b\n\n\b\n\n\b\n\b\n\b 20B\b00¢\bB\b 00¢\b\bJ\n0\tH¢\b\nJ02\r0\f20H¢\bJ02\r0\f20¢\bJ\r0¢\bJ0\tH¢\bJ0H¢\bR08@X¢\n\bR08@X¢\n\bR08X¢\n\bR08X¢\n\b ¨!"}, d2={"Lokio/InflaterSource;", "Lokio/Source;", "source", "Ljava/util/zip/Inflater;", "inflater", "<init>", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "", "close", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "readOrInflate", "", "refill", "()Z", "releaseBytesAfterInflate", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "bufferBytesHeldByInflater", "I", "closed", "Z", "Ljava/util/zip/Inflater;", "Lokio/BufferedSource;", "okio"})
@SourceDebugExtension(value={"SMAP\nInflaterSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InflaterSource.kt\nokio/InflaterSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,147:1\n1#2:148\n86#3:149\n*S KotlinDebug\n*F\n+ 1 InflaterSource.kt\nokio/InflaterSource\n*L\n73#1:149\n*E\n"})
public final class InflaterSource
implements Source {
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final Inflater inflater;
    private int bufferBytesHeldByInflater;
    private boolean closed;

    public InflaterSource(@NotNull BufferedSource source2, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)inflater, (String)"inflater");
        this.source = source2;
        this.inflater = inflater;
    }

    public InflaterSource(@NotNull Source source2, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        Intrinsics.checkNotNullParameter((Object)inflater, (String)"inflater");
        this(Okio.buffer(source2), inflater);
    }

    @Override
    public long read(@NotNull Buffer sink2, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        do {
            long bytesInflated;
            if ((bytesInflated = this.readOrInflate(sink2, byteCount)) > 0L) {
                return bytesInflated;
            }
            if (!this.inflater.finished() && !this.inflater.needsDictionary()) continue;
            return -1L;
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(@NotNull Buffer sink2, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        if (!(byteCount >= 0L)) {
            boolean $i$a$-require-InflaterSource$readOrInflate$22 = false;
            String $i$a$-require-InflaterSource$readOrInflate$22 = "byteCount < 0: " + byteCount;
            throw new IllegalArgumentException($i$a$-require-InflaterSource$readOrInflate$22.toString());
        }
        if (!(!this.closed)) {
            boolean $i$a$-check-InflaterSource$readOrInflate$32 = false;
            String $i$a$-check-InflaterSource$readOrInflate$32 = "closed";
            throw new IllegalStateException($i$a$-check-InflaterSource$readOrInflate$32.toString());
        }
        if (byteCount == 0L) {
            return 0L;
        }
        try {
            Segment tail = sink2.writableSegment$okio(1);
            int b$iv = 8192 - tail.limit;
            boolean $i$f$minOf = false;
            int toRead = (int)Math.min((long)byteCount, (long)b$iv);
            this.refill();
            int bytesInflated = this.inflater.inflate(tail.data, tail.limit, toRead);
            this.releaseBytesAfterInflate();
            if (bytesInflated > 0) {
                tail.limit += bytesInflated;
                sink2.setSize$okio(sink2.size() + (long)bytesInflated);
                return bytesInflated;
            }
            if (tail.pos == tail.limit) {
                sink2.head = tail.pop();
                SegmentPool.recycle(tail);
            }
            return 0L;
        }
        catch (DataFormatException e) {
            throw new IOException((Throwable)e);
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull((Object)segment);
        Segment head = segment;
        this.bufferBytesHeldByInflater = head.limit - head.pos;
        this.inflater.setInput(head.data, head.pos, this.bufferBytesHeldByInflater);
        return false;
    }

    private final void releaseBytesAfterInflate() {
        if (this.bufferBytesHeldByInflater == 0) {
            return;
        }
        int toRelease = this.bufferBytesHeldByInflater - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= toRelease;
        this.source.skip(toRelease);
    }

    @Override
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }
}


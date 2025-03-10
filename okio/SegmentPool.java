/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.concurrent.atomic.AtomicReference
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.Segment;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={" 0\n\n \n\b\n\n\n\b\n\n\b\n\b\n\b\t\n\n\b\bÀ 20B\t\b¢\bJ\n00H¢\bJ\n0\t2\b0H¢\b\nJ\f0H¢\b\f\rR08X¢\n\bR08X¢\n\bR08XD¢\f\n\b\bR08F¢\bR\"\f\n0008X¢\n\b¨"}, d2={"Lokio/SegmentPool;", "", "<init>", "()V", "Ljava/util/concurrent/atomic/AtomicReference;", "Lokio/Segment;", "firstRef", "()Ljava/util/concurrent/atomic/AtomicReference;", "segment", "", "recycle", "(Lokio/Segment;)V", "take", "()Lokio/Segment;", "", "HASH_BUCKET_COUNT", "I", "LOCK", "Lokio/Segment;", "MAX_SIZE", "getMAX_SIZE", "()I", "getByteCount", "byteCount", "", "hashBuckets", "[Ljava/util/concurrent/atomic/AtomicReference;", "okio"})
public final class SegmentPool {
    @NotNull
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;
    @NotNull
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);
    private static final int HASH_BUCKET_COUNT = Integer.highestOneBit((int)(Runtime.getRuntime().availableProcessors() * 2 - 1));
    @NotNull
    private static final AtomicReference<Segment>[] hashBuckets;

    private SegmentPool() {
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public final int getByteCount() {
        Segment segment = (Segment)this.firstRef().get();
        if (segment == null) {
            return 0;
        }
        Segment first = segment;
        return first.limit;
    }

    @JvmStatic
    @NotNull
    public static final Segment take() {
        AtomicReference<Segment> firstRef = INSTANCE.firstRef();
        Segment first = (Segment)firstRef.getAndSet((Object)LOCK);
        if (first == LOCK) {
            return new Segment();
        }
        if (first == null) {
            firstRef.set(null);
            return new Segment();
        }
        firstRef.set((Object)first.next);
        first.next = null;
        first.limit = 0;
        return first;
    }

    @JvmStatic
    public static final void recycle(@NotNull Segment segment) {
        Intrinsics.checkNotNullParameter((Object)segment, (String)"segment");
        if (!(segment.next == null && segment.prev == null)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        if (segment.shared) {
            return;
        }
        AtomicReference<Segment> firstRef = INSTANCE.firstRef();
        Segment first = (Segment)firstRef.getAndSet((Object)LOCK);
        if (first == LOCK) {
            return;
        }
        Segment segment2 = first;
        int firstLimit = segment2 != null ? segment2.limit : 0;
        if (firstLimit >= MAX_SIZE) {
            firstRef.set((Object)first);
            return;
        }
        segment.next = first;
        segment.pos = 0;
        segment.limit = firstLimit + 8192;
        firstRef.set((Object)segment);
    }

    private final AtomicReference<Segment> firstRef() {
        int hashBucket = (int)(Thread.currentThread().getId() & (long)HASH_BUCKET_COUNT - 1L);
        return hashBuckets[hashBucket];
    }

    static {
        int n = 0;
        int n2 = HASH_BUCKET_COUNT;
        AtomicReference[] atomicReferenceArray = new AtomicReference[n2];
        while (n < n2) {
            int n3 = n++;
            atomicReferenceArray[n3] = new AtomicReference();
        }
        hashBuckets = atomicReferenceArray;
    }
}


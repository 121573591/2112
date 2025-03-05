/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.nio.IntBuffer
 *  java.nio.ShortBuffer
 */
package com.aayushatharva.brotli4j.encoder;

import com.aayushatharva.brotli4j.encoder.PreparedDictionary;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class PreparedDictionaryGenerator {
    private static final int MAGIC = -558043680;
    private static final long HASH_MULTIPLIER = 2297779722762296275L;

    private PreparedDictionaryGenerator() {
    }

    public static PreparedDictionary generate(ByteBuffer src) {
        return PreparedDictionaryGenerator.generate(src, 17, 3, 40, 5);
    }

    public static PreparedDictionary generate(ByteBuffer src, int bucketBits, int slotBits, int hashBits, int blockBits) {
        int i;
        int i2;
        src.clear();
        if (blockBits > 12) {
            throw new IllegalArgumentException("blockBits is too big");
        }
        if (bucketBits >= 24) {
            throw new IllegalArgumentException("bucketBits is too big");
        }
        if (bucketBits - slotBits >= 16) {
            throw new IllegalArgumentException("slotBits is too small");
        }
        int bucketLimit = 1 << blockBits;
        int numBuckets = 1 << bucketBits;
        int numSlots = 1 << slotBits;
        int slotMask = numSlots - 1;
        int hashShift = 64 - bucketBits;
        long hashMask = -1L >>> 64 - hashBits;
        int sourceSize = src.capacity();
        if (sourceSize < 8) {
            throw new IllegalArgumentException("src is too short");
        }
        short[] num = new short[numBuckets];
        int[] bucketHeads = new int[numBuckets];
        int[] nextBucket = new int[sourceSize];
        long accumulator = 0L;
        for (i2 = 0; i2 < 7; ++i2) {
            accumulator |= ((long)src.get(i2) & 0xFFL) << 8 * i2;
        }
        accumulator <<= 8;
        i2 = 0;
        while (i2 + 7 < sourceSize) {
            long h = ((accumulator = accumulator >>> 8 | ((long)src.get(i2 + 7) & 0xFFL) << 56) & hashMask) * 2297779722762296275L;
            int key = (int)(h >>> hashShift);
            int count = num[key];
            nextBucket[i2] = count == 0 ? -1 : bucketHeads[key];
            bucketHeads[key] = i2;
            if (++count > bucketLimit) {
                count = bucketLimit;
            }
            num[key] = (short)count;
            ++i2;
        }
        int[] slotLimit = new int[numSlots];
        int[] slotSize = new int[numSlots];
        int totalItems = 0;
        block2: for (int i3 = 0; i3 < numSlots; ++i3) {
            boolean overflow = false;
            slotLimit[i3] = bucketLimit;
            while (true) {
                overflow = false;
                int limit = slotLimit[i3];
                int count = 0;
                for (int j = i3; j < numBuckets; j += numSlots) {
                    int size = num[j];
                    if (count >= 65535) {
                        overflow = true;
                        break;
                    }
                    if (size > limit) {
                        size = limit;
                    }
                    count += size;
                }
                if (!overflow) {
                    slotSize[i3] = count;
                    totalItems += count;
                    continue block2;
                }
                int n = i3;
                slotLimit[n] = slotLimit[n] - 1;
            }
        }
        int part0 = 24;
        int part1 = numSlots * 4;
        int part2 = numBuckets * 2;
        int part3 = totalItems * 4;
        int allocSize = part0 + part1 + part2 + part3 + sourceSize;
        ByteBuffer flat = ByteBuffer.allocateDirect((int)allocSize);
        ByteBuffer pointer = flat.slice();
        pointer.order(ByteOrder.nativeOrder());
        IntBuffer struct = pointer.asIntBuffer();
        pointer.position(pointer.position() + part0);
        IntBuffer slotOffsets = pointer.asIntBuffer();
        pointer.position(pointer.position() + part1);
        ShortBuffer heads = pointer.asShortBuffer();
        pointer.position(pointer.position() + part2);
        IntBuffer items = pointer.asIntBuffer();
        pointer.position(pointer.position() + part3);
        ByteBuffer sourceCopy = pointer.slice();
        struct.put(0, -558043680);
        struct.put(1, totalItems);
        struct.put(2, sourceSize);
        struct.put(3, hashBits);
        struct.put(4, bucketBits);
        struct.put(5, slotBits);
        totalItems = 0;
        for (i = 0; i < numSlots; ++i) {
            slotOffsets.put(i, totalItems);
            totalItems += slotSize[i];
            slotSize[i] = 0;
        }
        for (i = 0; i < numBuckets; ++i) {
            int count = num[i];
            int slot = i & slotMask;
            if (count > slotLimit[slot]) {
                count = slotLimit[slot];
            }
            if (count == 0) {
                heads.put(i, (short)-1);
                continue;
            }
            int cursor = slotSize[slot];
            heads.put(i, (short)cursor);
            cursor += slotOffsets.get(slot);
            int n = slot;
            slotSize[n] = slotSize[n] + count;
            int pos = bucketHeads[i];
            for (int j = 0; j < count; ++j) {
                items.put(cursor++, pos);
                pos = nextBucket[pos];
            }
            items.put(--cursor, items.get(cursor) | Integer.MIN_VALUE);
        }
        sourceCopy.put(src);
        return new PreparedDictionaryImpl(flat);
    }

    private static class PreparedDictionaryImpl
    implements PreparedDictionary {
        private final ByteBuffer data;

        private PreparedDictionaryImpl(ByteBuffer data) {
            this.data = data;
        }

        @Override
        public ByteBuffer getData() {
            return this.data;
        }
    }
}


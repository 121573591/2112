/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.locks.StampedLock
 */
package cn.hutool.core.text;

import cn.hutool.core.lang.hash.MurmurHash;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class Simhash {
    private final int bitNum = 64;
    private final int fracCount;
    private final int fracBitNum;
    private final int hammingThresh;
    private final List<Map<String, List<Long>>> storage;
    private final StampedLock lock = new StampedLock();

    public Simhash() {
        this(4, 3);
    }

    public Simhash(int fracCount, int hammingThresh) {
        this.fracCount = fracCount;
        this.fracBitNum = 64 / fracCount;
        this.hammingThresh = hammingThresh;
        this.storage = new ArrayList(fracCount);
        for (int i = 0; i < fracCount; ++i) {
            this.storage.add((Object)new HashMap());
        }
    }

    public long hash(Collection<? extends CharSequence> segList) {
        int bitNum = this.bitNum;
        int[] weight = new int[bitNum];
        for (CharSequence seg : segList) {
            long wordHash = MurmurHash.hash64(seg);
            for (int i = 0; i < bitNum; ++i) {
                if ((wordHash >> i & 1L) == 1L) {
                    int n = i;
                    weight[n] = weight[n] + 1;
                    continue;
                }
                int n = i;
                weight[n] = weight[n] - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitNum; ++i) {
            sb.append(weight[i] > 0 ? 1 : 0);
        }
        return new BigInteger(sb.toString(), 2).longValue();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean equals(Collection<? extends CharSequence> segList) {
        long simhash = this.hash(segList);
        List<String> fracList = this.splitSimhash(simhash);
        int hammingThresh = this.hammingThresh;
        long stamp = this.lock.readLock();
        try {
            for (int i = 0; i < this.fracCount; ++i) {
                String frac = (String)fracList.get(i);
                Map fracMap = (Map)this.storage.get(i);
                if (!fracMap.containsKey((Object)frac)) continue;
                for (Long simhash2 : (List)fracMap.get((Object)frac)) {
                    if (this.hamming(simhash, simhash2) >= hammingThresh) continue;
                    boolean bl = true;
                    return bl;
                }
            }
        }
        finally {
            this.lock.unlockRead(stamp);
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void store(Long simhash) {
        int fracCount = this.fracCount;
        List<Map<String, List<Long>>> storage = this.storage;
        List<String> lFrac = this.splitSimhash(simhash);
        long stamp = this.lock.writeLock();
        try {
            for (int i = 0; i < fracCount; ++i) {
                String frac = (String)lFrac.get(i);
                Map fracMap = (Map)storage.get(i);
                if (fracMap.containsKey((Object)frac)) {
                    ((List)fracMap.get((Object)frac)).add((Object)simhash);
                    continue;
                }
                ArrayList ls = new ArrayList();
                ls.add((Object)simhash);
                fracMap.put((Object)frac, (Object)ls);
            }
        }
        finally {
            this.lock.unlockWrite(stamp);
        }
    }

    private int hamming(Long s1, Long s2) {
        int bitNum = this.bitNum;
        int dis = 0;
        for (int i = 0; i < bitNum; ++i) {
            if ((s1 >> i & 1L) == (s2 >> i & 1L)) continue;
            ++dis;
        }
        return dis;
    }

    private List<String> splitSimhash(Long simhash) {
        int bitNum = this.bitNum;
        int fracBitNum = this.fracBitNum;
        ArrayList ls = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitNum; ++i) {
            sb.append(simhash >> i & 1L);
            if ((i + 1) % fracBitNum != 0) continue;
            ls.add((Object)sb.toString());
            sb.setLength(0);
        }
        return ls;
    }
}


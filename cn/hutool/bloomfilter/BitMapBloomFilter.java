/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.bloomfilter;

import cn.hutool.bloomfilter.BloomFilter;
import cn.hutool.bloomfilter.filter.DefaultFilter;
import cn.hutool.bloomfilter.filter.ELFFilter;
import cn.hutool.bloomfilter.filter.JSFilter;
import cn.hutool.bloomfilter.filter.PJWFilter;
import cn.hutool.bloomfilter.filter.SDBMFilter;
import cn.hutool.core.util.NumberUtil;

public class BitMapBloomFilter
implements BloomFilter {
    private static final long serialVersionUID = 1L;
    private BloomFilter[] filters;

    public BitMapBloomFilter(int m) {
        long mNum = NumberUtil.div(String.valueOf((int)m), String.valueOf((int)5)).longValue();
        long size = mNum * 1024L * 1024L * 8L;
        this.filters = new BloomFilter[]{new DefaultFilter(size), new ELFFilter(size), new JSFilter(size), new PJWFilter(size), new SDBMFilter(size)};
    }

    public BitMapBloomFilter(int m, BloomFilter ... filters) {
        this(m);
        this.filters = filters;
    }

    @Override
    public boolean add(String str) {
        boolean flag = false;
        for (BloomFilter filter : this.filters) {
            flag |= filter.add(str);
        }
        return flag;
    }

    @Override
    public boolean contains(String str) {
        for (BloomFilter filter : this.filters) {
            if (filter.contains(str)) continue;
            return false;
        }
        return true;
    }
}


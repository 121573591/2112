/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.bloomfilter;

import java.io.Serializable;

public interface BloomFilter
extends Serializable {
    public boolean contains(String var1);

    public boolean add(String var1);
}


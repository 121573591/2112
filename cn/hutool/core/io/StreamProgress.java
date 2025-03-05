/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package cn.hutool.core.io;

public interface StreamProgress {
    public void start();

    public void progress(long var1, long var3);

    public void finish();
}


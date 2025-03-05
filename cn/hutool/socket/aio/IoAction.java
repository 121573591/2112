/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package cn.hutool.socket.aio;

import cn.hutool.socket.aio.AioSession;

public interface IoAction<T> {
    public void accept(AioSession var1);

    public void doAction(AioSession var1, T var2);

    public void failed(Throwable var1, AioSession var2);
}


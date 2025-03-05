/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package cn.hutool.socket.aio;

import cn.hutool.log.StaticLog;
import cn.hutool.socket.aio.AioSession;
import cn.hutool.socket.aio.IoAction;
import java.nio.ByteBuffer;

public abstract class SimpleIoAction
implements IoAction<ByteBuffer> {
    @Override
    public void accept(AioSession session) {
    }

    @Override
    public void failed(Throwable exc, AioSession session) {
        StaticLog.error(exc);
    }
}


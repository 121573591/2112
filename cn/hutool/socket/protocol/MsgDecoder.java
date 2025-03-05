/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package cn.hutool.socket.protocol;

import cn.hutool.socket.aio.AioSession;
import java.nio.ByteBuffer;

public interface MsgDecoder<T> {
    public T decode(AioSession var1, ByteBuffer var2);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.servers.netty.frame.base;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

public abstract class BaseBinaryWebSocketFrame
extends BinaryWebSocketFrame {
    public BaseBinaryWebSocketFrame(ByteBuf byteBuf) {
        super(byteBuf);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.charset.StandardCharsets
 */
package tech.ordinaryroad.live.chat.client.websocket.msg;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import java.nio.charset.StandardCharsets;
import tech.ordinaryroad.live.chat.client.websocket.msg.base.IWebSocketMsg;

public class WebSocketMsg
extends BinaryWebSocketFrame
implements IWebSocketMsg {
    public WebSocketMsg() {
    }

    public WebSocketMsg(ByteBuf binaryData) {
        super(binaryData);
    }

    public WebSocketMsg(boolean finalFragment, int rsv, ByteBuf binaryData) {
        super(finalFragment, rsv, binaryData);
    }

    @Override
    public String toString() {
        return this.content().toString(StandardCharsets.UTF_8);
    }
}


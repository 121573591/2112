/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufAllocator
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.charset.StandardCharsets
 */
package tech.ordinaryroad.live.chat.client.tiktok.listener.impl;

import cn.hutool.core.util.StrUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import java.nio.charset.StandardCharsets;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokControlMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokDanmuMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokEnterRoomMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokGiftMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokLikeMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokSocialMsg;
import tech.ordinaryroad.live.chat.client.commons.base.exception.BaseException;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;
import tech.ordinaryroad.live.chat.client.tiktok.listener.ITiktokMsgListener;
import tech.ordinaryroad.live.chat.client.websocket.client.WebSocketLiveChatClient;
import tech.ordinaryroad.live.chat.client.websocket.config.WebSocketLiveChatClientConfig;

public class TiktokForwardMsgListener
implements ITiktokMsgListener {
    private final WebSocketLiveChatClient webSocketLiveChatClient;

    public TiktokForwardMsgListener(String webSocketUri) {
        if (StrUtil.isBlank(webSocketUri)) {
            throw new BaseException("转发地址不能为空");
        }
        this.webSocketLiveChatClient = new WebSocketLiveChatClient((WebSocketLiveChatClientConfig)((WebSocketLiveChatClientConfig.WebSocketLiveChatClientConfigBuilder)WebSocketLiveChatClientConfig.builder().websocketUri(webSocketUri)).build());
        this.webSocketLiveChatClient.connect();
    }

    @Override
    public void onDanmuMsg(TiktokDanmuMsg msg) {
        this.forward(msg);
    }

    @Override
    public void onGiftMsg(TiktokGiftMsg msg) {
        this.forward(msg);
    }

    @Override
    public void onEnterRoomMsg(TiktokEnterRoomMsg msg) {
        this.forward(msg);
    }

    @Override
    public void onLikeMsg(TiktokLikeMsg msg) {
        this.forward(msg);
    }

    @Override
    public void onLiveStatusMsg(TiktokControlMsg msg) {
        this.forward(msg);
    }

    @Override
    public void onSocialMsg(TiktokSocialMsg msg) {
        this.forward(msg);
    }

    private void forward(IMsg msg) {
        if (this.webSocketLiveChatClient == null) {
            return;
        }
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
        byteBuf.writeCharSequence((CharSequence)msg.toString(), StandardCharsets.UTF_8);
        this.webSocketLiveChatClient.send((Object)new BinaryWebSocketFrame(byteBuf));
    }

    public void destroyForwardClient() {
        this.webSocketLiveChatClient.destroy();
    }
}


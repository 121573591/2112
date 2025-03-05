/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelPipeline
 *  io.netty.channel.socket.SocketChannel
 *  java.lang.Exception
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.websocket.netty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import tech.ordinaryroad.live.chat.client.servers.netty.client.handler.BaseNettyClientChannelInitializer;
import tech.ordinaryroad.live.chat.client.websocket.client.WebSocketLiveChatClient;
import tech.ordinaryroad.live.chat.client.websocket.netty.handler.WebSocketBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.websocket.netty.handler.WebSocketCodecHandler;

public class WebSocketChannelInitializer
extends BaseNettyClientChannelInitializer<WebSocketLiveChatClient> {
    public WebSocketChannelInitializer(WebSocketLiveChatClient client) {
        super(client);
    }

    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ChannelHandler[]{new WebSocketCodecHandler()});
        pipeline.addLast(new ChannelHandler[]{new WebSocketBinaryFrameHandler(((WebSocketLiveChatClient)this.client).getMsgListeners(), (WebSocketLiveChatClient)this.client)});
    }
}


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
package tech.ordinaryroad.live.chat.client.kuaishou.netty.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import tech.ordinaryroad.live.chat.client.kuaishou.client.KuaishouLiveChatClient;
import tech.ordinaryroad.live.chat.client.kuaishou.netty.handler.KuaishouBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.kuaishou.netty.handler.KuaishouCodecHandler;
import tech.ordinaryroad.live.chat.client.servers.netty.client.handler.BaseNettyClientChannelInitializer;

public class KuaishouLiveChatClientChannelInitializer
extends BaseNettyClientChannelInitializer<KuaishouLiveChatClient> {
    public KuaishouLiveChatClientChannelInitializer(KuaishouLiveChatClient client) {
        super(client);
    }

    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new ChannelHandler[]{new KuaishouCodecHandler()});
        pipeline.addLast(new ChannelHandler[]{new KuaishouBinaryFrameHandler(((KuaishouLiveChatClient)this.client).getMsgListeners(), (KuaishouLiveChatClient)this.client)});
    }
}


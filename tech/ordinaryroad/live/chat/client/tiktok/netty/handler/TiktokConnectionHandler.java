/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandler$Sharable
 *  io.netty.util.concurrent.GenericFutureListener
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.function.Supplier
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package tech.ordinaryroad.live.chat.client.tiktok.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.ordinaryroad.live.chat.client.commons.base.listener.IBaseConnectionListener;
import tech.ordinaryroad.live.chat.client.servers.netty.client.handler.BaseNettyClientConnectionHandler;
import tech.ordinaryroad.live.chat.client.tiktok.client.TiktokLiveChatClient;
import tech.ordinaryroad.live.chat.client.tiktok.config.TiktokLiveChatClientConfig;

@ChannelHandler.Sharable
public class TiktokConnectionHandler
extends BaseNettyClientConnectionHandler<TiktokLiveChatClient, TiktokConnectionHandler> {
    private static final Logger log = LoggerFactory.getLogger(TiktokConnectionHandler.class);
    private static final byte[] HEARTBEAT_BYTES = new byte[]{58, 2, 104, 98};
    private final Object roomId;
    private String cookie;

    public TiktokConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, TiktokLiveChatClient client, IBaseConnectionListener<TiktokConnectionHandler> listener) {
        super(webSocketProtocolHandler, client, listener);
        this.roomId = ((TiktokLiveChatClientConfig)client.getConfig()).getRoomId();
        this.cookie = ((TiktokLiveChatClientConfig)client.getConfig()).getCookie();
    }

    public TiktokConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, TiktokLiveChatClient client) {
        this(webSocketProtocolHandler, client, (IBaseConnectionListener<TiktokConnectionHandler>)null);
    }

    public TiktokConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, long roomId, IBaseConnectionListener<TiktokConnectionHandler> listener, String cookie) {
        super(webSocketProtocolHandler, listener);
        this.roomId = roomId;
        this.cookie = cookie;
    }

    public TiktokConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, long roomId, IBaseConnectionListener<TiktokConnectionHandler> listener) {
        this(webSocketProtocolHandler, roomId, listener, null);
    }

    public TiktokConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, long roomId, String cookie) {
        this(webSocketProtocolHandler, roomId, null, cookie);
    }

    public TiktokConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, long roomId) {
        this(webSocketProtocolHandler, roomId, null, null);
    }

    @Override
    public void sendHeartbeat(Channel channel) {
        if (log.isDebugEnabled()) {
            log.debug("发送心跳包");
        }
        channel.writeAndFlush((Object)new BinaryWebSocketFrame(channel.alloc().buffer().writeBytes(HEARTBEAT_BYTES))).addListener((GenericFutureListener)((ChannelFutureListener)future -> {
            if (future.isSuccess()) {
                if (log.isDebugEnabled()) {
                    log.debug("心跳包发送完成");
                }
            } else {
                log.error("心跳包发送失败", future.cause());
            }
        }));
    }

    public Object getRoomId() {
        return this.client != null ? ((TiktokLiveChatClientConfig)((TiktokLiveChatClient)this.client).getConfig()).getRoomId() : this.roomId;
    }

    private String getCookie() {
        return this.client != null ? ((TiktokLiveChatClientConfig)((TiktokLiveChatClient)this.client).getConfig()).getCookie() : this.cookie;
    }
}


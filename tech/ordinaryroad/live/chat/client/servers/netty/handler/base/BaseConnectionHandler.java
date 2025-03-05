/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelInboundHandlerAdapter
 *  io.netty.channel.ChannelPromise
 *  io.netty.util.concurrent.ScheduledFuture
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  java.util.function.Supplier
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package tech.ordinaryroad.live.chat.client.servers.netty.handler.base;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.ordinaryroad.live.chat.client.commons.base.exception.BaseException;
import tech.ordinaryroad.live.chat.client.commons.base.listener.IBaseConnectionListener;
import tech.ordinaryroad.live.chat.client.servers.netty.handler.base.IBaseConnectionHandler;

public abstract class BaseConnectionHandler<ConnectionHandler extends BaseConnectionHandler<?>>
extends ChannelInboundHandlerAdapter
implements IBaseConnectionHandler {
    private static final Logger log = LoggerFactory.getLogger(BaseConnectionHandler.class);
    private final Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler;
    private ChannelPromise handshakePromise;
    private final IBaseConnectionListener<ConnectionHandler> listener;
    private ScheduledFuture<?> scheduledFuture = null;

    public BaseConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler, IBaseConnectionListener<ConnectionHandler> listener) {
        this.webSocketProtocolHandler = webSocketProtocolHandler;
        this.listener = listener;
    }

    public BaseConnectionHandler(Supplier<WebSocketClientProtocolHandler> webSocketProtocolHandler) {
        this(webSocketProtocolHandler, null);
    }

    public void handlerAdded(ChannelHandlerContext ctx) {
        this.handshakePromise = ctx.newPromise();
    }

    public void channelActive(ChannelHandlerContext ctx) {
        if (log.isDebugEnabled()) {
            log.debug("channelActive");
        }
    }

    public void channelInactive(ChannelHandlerContext ctx) {
        if (log.isDebugEnabled()) {
            log.debug("channelInactive");
        }
        this.heartbeatCancel();
        if (this.listener != null) {
            this.listener.onDisconnected(this);
        }
    }

    private void heartbeatStart(Channel channel) {
        this.scheduledFuture = this.getHeartbeatPeriod() > 0L ? channel.eventLoop().scheduleAtFixedRate(() -> this.sendHeartbeat(channel), this.getHeartbeatInitialDelay(), this.getHeartbeatPeriod(), TimeUnit.SECONDS) : channel.eventLoop().schedule(() -> this.sendHeartbeat(channel), this.getHeartbeatInitialDelay(), TimeUnit.SECONDS);
    }

    private void heartbeatCancel() {
        if (null != this.scheduledFuture && !this.scheduledFuture.isCancelled()) {
            this.scheduledFuture.cancel(true);
            this.scheduledFuture = null;
        }
    }

    public abstract long getHeartbeatPeriod();

    public abstract long getHeartbeatInitialDelay();

    private void handshakeSuccessfully(Channel channel) {
        if (log.isDebugEnabled()) {
            log.debug("握手完成!");
        }
        this.handshakePromise.setSuccess();
        this.heartbeatCancel();
        this.heartbeatStart(channel);
        if (this.listener != null) {
            this.listener.onConnected(this);
        }
    }

    private void handshakeFailed(ChannelHandlerContext ctx, WebSocketClientProtocolHandler.ClientHandshakeStateEvent evt) {
        log.error("握手失败！ {}", (Object)evt);
        this.handshakePromise.setFailure((Throwable)((Object)new BaseException(evt.name())));
        if (this.listener != null) {
            this.listener.onConnectFailed(this);
        }
    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("userEventTriggered {}", evt);
        }
        if (evt == WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_COMPLETE) {
            this.handshakeSuccessfully(ctx.channel());
        } else if (evt == WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_TIMEOUT) {
            this.handshakeFailed(ctx, (WebSocketClientProtocolHandler.ClientHandshakeStateEvent)((Object)evt));
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("exceptionCaught", cause);
        if (!this.handshakePromise.isDone()) {
            this.handshakePromise.setFailure(cause);
        }
        ctx.close();
    }

    public Supplier<WebSocketClientProtocolHandler> getWebSocketProtocolHandler() {
        return this.webSocketProtocolHandler;
    }

    public ChannelPromise getHandshakePromise() {
        return this.handshakePromise;
    }
}


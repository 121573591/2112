/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.nio.NioEventLoopGroup
 *  io.netty.channel.socket.SocketChannel
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.function.Consumer
 *  java.util.function.Supplier
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package tech.ordinaryroad.live.chat.client.kuaishou.client;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.JsonNode;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolConfig;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.api.KuaishouApis;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.msg.base.IKuaishouMsg;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.PayloadTypeOuterClass;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.room.RoomInitResult;
import tech.ordinaryroad.live.chat.client.commons.base.exception.BaseException;
import tech.ordinaryroad.live.chat.client.commons.base.listener.IBaseConnectionListener;
import tech.ordinaryroad.live.chat.client.commons.client.enums.ClientStatusEnums;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatCollUtil;
import tech.ordinaryroad.live.chat.client.kuaishou.config.KuaishouLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.kuaishou.listener.IKuaishouConnectionListener;
import tech.ordinaryroad.live.chat.client.kuaishou.listener.IKuaishouMsgListener;
import tech.ordinaryroad.live.chat.client.kuaishou.listener.impl.KuaishouForwardMsgListener;
import tech.ordinaryroad.live.chat.client.kuaishou.netty.handler.KuaishouBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.kuaishou.netty.handler.KuaishouConnectionHandler;
import tech.ordinaryroad.live.chat.client.kuaishou.netty.handler.KuaishouLiveChatClientChannelInitializer;
import tech.ordinaryroad.live.chat.client.servers.netty.client.base.BaseNettyClient;

public class KuaishouLiveChatClient
extends BaseNettyClient<KuaishouLiveChatClientConfig, RoomInitResult, PayloadTypeOuterClass.PayloadType, IKuaishouMsg, IKuaishouMsgListener, KuaishouConnectionHandler, KuaishouBinaryFrameHandler> {
    private static final Logger log = LoggerFactory.getLogger(KuaishouLiveChatClient.class);

    public KuaishouLiveChatClient(KuaishouLiveChatClientConfig config, List<IKuaishouMsgListener> msgListeners, IKuaishouConnectionListener connectionListener, EventLoopGroup workerGroup) {
        super(config, workerGroup, connectionListener);
        this.addMsgListeners(msgListeners);
        this.init();
    }

    public KuaishouLiveChatClient(KuaishouLiveChatClientConfig config, IKuaishouMsgListener msgListener, IKuaishouConnectionListener connectionListener, EventLoopGroup workerGroup) {
        super(config, workerGroup, connectionListener);
        this.addMsgListener(msgListener);
        this.init();
    }

    public KuaishouLiveChatClient(KuaishouLiveChatClientConfig config, IKuaishouMsgListener msgListener, IKuaishouConnectionListener connectionListener) {
        this(config, msgListener, connectionListener, (EventLoopGroup)new NioEventLoopGroup());
    }

    public KuaishouLiveChatClient(KuaishouLiveChatClientConfig config, IKuaishouMsgListener msgListener) {
        this(config, msgListener, null, (EventLoopGroup)new NioEventLoopGroup());
    }

    public KuaishouLiveChatClient(KuaishouLiveChatClientConfig config) {
        this(config, null);
    }

    @Override
    public void init() {
        if (StrUtil.isNotBlank(((KuaishouLiveChatClientConfig)this.getConfig()).getForwardWebsocketUri())) {
            KuaishouForwardMsgListener forwardMsgListener = new KuaishouForwardMsgListener(((KuaishouLiveChatClientConfig)this.getConfig()).getForwardWebsocketUri());
            this.addMsgListener(forwardMsgListener);
            this.addStatusChangeListener((evt, oldStatus, newStatus) -> {
                if (newStatus == ClientStatusEnums.DESTROYED) {
                    forwardMsgListener.destroyForwardClient();
                }
            });
        }
        super.init();
    }

    @Override
    protected String getWebSocketUriString() {
        String webSocketUriString = super.getWebSocketUriString();
        if (StrUtil.isNotBlank(webSocketUriString)) {
            return webSocketUriString;
        }
        return OrLiveChatCollUtil.getRandom(((RoomInitResult)this.roomInitResult).getWebsocketUrls());
    }

    @Override
    public KuaishouConnectionHandler initConnectionHandler(IBaseConnectionListener<KuaishouConnectionHandler> clientConnectionListener) {
        return new KuaishouConnectionHandler((Supplier<WebSocketClientProtocolHandler>)((Supplier)() -> new WebSocketClientProtocolHandler(WebSocketClientProtocolConfig.newBuilder().webSocketUri(this.getWebsocketUri()).version(WebSocketVersion.V13).subprotocol(null).allowExtensions(true).customHeaders(new DefaultHttpHeaders()).maxFramePayloadLength(((KuaishouLiveChatClientConfig)this.getConfig()).getMaxFramePayloadLength()).handshakeTimeoutMillis(((KuaishouLiveChatClientConfig)this.getConfig()).getHandshakeTimeoutMillis()).build())), this, clientConnectionListener);
    }

    @Override
    protected void initChannel(SocketChannel channel) {
        channel.pipeline().addLast(new ChannelHandler[]{new KuaishouLiveChatClientChannelInitializer(this)});
    }

    @Override
    public RoomInitResult initRoom() {
        return KuaishouApis.roomInit(((KuaishouLiveChatClientConfig)this.getConfig()).getRoomId(), ((KuaishouLiveChatClientConfig)this.getConfig()).getRoomInfoGetType(), ((KuaishouLiveChatClientConfig)this.getConfig()).getCookie(), (RoomInitResult)this.roomInitResult);
    }

    @Override
    public void sendDanmu(Object danmu, Runnable success, Consumer<Throwable> failed) {
        block12: {
            if (!this.checkCanSendDanmu()) {
                return;
            }
            if (danmu instanceof String) {
                String msg = (String)danmu;
                try {
                    boolean sendSuccess;
                    block11: {
                        if (log.isDebugEnabled()) {
                            log.debug("{} kuaishou发送弹幕 {}", ((KuaishouLiveChatClientConfig)this.getConfig()).getRoomId(), danmu);
                        }
                        sendSuccess = false;
                        try {
                            KuaishouApis.sendComment(((KuaishouLiveChatClientConfig)this.getConfig()).getCookie(), ((KuaishouLiveChatClientConfig)this.getConfig()).getRoomId(), KuaishouApis.SendCommentRequest.builder().liveStreamId(((RoomInitResult)this.roomInitResult).getLiveStreamId()).content(msg).build());
                            sendSuccess = true;
                        }
                        catch (Exception e) {
                            log.error("kuaishou弹幕发送失败", (Throwable)e);
                            if (failed == null) break block11;
                            failed.accept((Object)e);
                        }
                    }
                    if (!sendSuccess) {
                        return;
                    }
                    if (log.isDebugEnabled()) {
                        log.debug("kuaishou弹幕发送成功 {}", danmu);
                    }
                    if (success != null) {
                        success.run();
                    }
                    this.finishSendDanmu();
                }
                catch (Exception e) {
                    log.error("kuaishou弹幕发送失败", (Throwable)e);
                    if (failed != null) {
                        failed.accept((Object)e);
                    }
                    break block12;
                }
            }
            super.sendDanmu(danmu, success, failed);
        }
    }

    @Override
    public void clickLike(int count, Runnable success, Consumer<Throwable> failed) {
        boolean successfullyClicked;
        block7: {
            if (count <= 0) {
                throw new BaseException("点赞次数必须大于0");
            }
            successfullyClicked = false;
            try {
                JsonNode jsonNode = KuaishouApis.clickLike(((KuaishouLiveChatClientConfig)this.getConfig()).getCookie(), ((KuaishouLiveChatClientConfig)this.getConfig()).getRoomId(), ((RoomInitResult)this.roomInitResult).getLiveStreamId(), count);
                if (jsonNode.asBoolean()) {
                    successfullyClicked = true;
                }
            }
            catch (Exception e) {
                log.error("kuaishou为直播间点赞失败", (Throwable)e);
                if (failed == null) break block7;
                failed.accept((Object)e);
            }
        }
        if (!successfullyClicked) {
            return;
        }
        if (log.isDebugEnabled()) {
            log.debug("kuaishou为直播间点赞成功");
        }
        if (success != null) {
            success.run();
        }
    }
}


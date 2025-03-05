/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.EventLoopGroup
 *  io.netty.channel.nio.NioEventLoopGroup
 *  io.netty.channel.socket.SocketChannel
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.function.Supplier
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package tech.ordinaryroad.live.chat.client.tiktok.client;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolConfig;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.ordinaryroad.live.chat.client.codec.tiktok.api.TiktokApis;
import tech.ordinaryroad.live.chat.client.codec.tiktok.constant.TiktokCmdEnum;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.base.ITiktokMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Response;
import tech.ordinaryroad.live.chat.client.codec.tiktok.room.RoomInitResult;
import tech.ordinaryroad.live.chat.client.commons.base.listener.IBaseConnectionListener;
import tech.ordinaryroad.live.chat.client.commons.client.enums.ClientStatusEnums;
import tech.ordinaryroad.live.chat.client.commons.util.OrLiveChatHttpUtil;
import tech.ordinaryroad.live.chat.client.servers.netty.client.base.BaseNettyClient;
import tech.ordinaryroad.live.chat.client.tiktok.config.TiktokLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.tiktok.listener.ITiktokConnectionListener;
import tech.ordinaryroad.live.chat.client.tiktok.listener.ITiktokMsgListener;
import tech.ordinaryroad.live.chat.client.tiktok.listener.impl.TiktokForwardMsgListener;
import tech.ordinaryroad.live.chat.client.tiktok.netty.handler.TiktokBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.tiktok.netty.handler.TiktokConnectionHandler;
import tech.ordinaryroad.live.chat.client.tiktok.netty.handler.TiktokLiveChatClientChannelInitializer;

public class TiktokLiveChatClient
extends BaseNettyClient<TiktokLiveChatClientConfig, RoomInitResult, TiktokCmdEnum, ITiktokMsg, ITiktokMsgListener, TiktokConnectionHandler, TiktokBinaryFrameHandler> {
    private static final Logger log = LoggerFactory.getLogger(TiktokLiveChatClient.class);

    public TiktokLiveChatClient(TiktokLiveChatClientConfig config, List<ITiktokMsgListener> msgListeners, ITiktokConnectionListener connectionListener, EventLoopGroup workerGroup) {
        super(config, workerGroup, connectionListener);
        this.addMsgListeners(msgListeners);
        this.init();
    }

    public TiktokLiveChatClient(TiktokLiveChatClientConfig config, ITiktokMsgListener msgListener, ITiktokConnectionListener connectionListener, EventLoopGroup workerGroup) {
        super(config, workerGroup, connectionListener);
        this.addMsgListener(msgListener);
        this.init();
    }

    public TiktokLiveChatClient(TiktokLiveChatClientConfig config, ITiktokMsgListener msgListener, ITiktokConnectionListener connectionListener) {
        this(config, msgListener, connectionListener, (EventLoopGroup)new NioEventLoopGroup());
    }

    public TiktokLiveChatClient(TiktokLiveChatClientConfig config, ITiktokMsgListener msgListener) {
        this(config, msgListener, null, (EventLoopGroup)new NioEventLoopGroup());
    }

    public TiktokLiveChatClient(TiktokLiveChatClientConfig config) {
        this(config, null);
    }

    @Override
    public void init() {
        if (StrUtil.isNotBlank(((TiktokLiveChatClientConfig)this.getConfig()).getForwardWebsocketUri())) {
            TiktokForwardMsgListener forwardMsgListener = new TiktokForwardMsgListener(((TiktokLiveChatClientConfig)this.getConfig()).getForwardWebsocketUri());
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
    public TiktokConnectionHandler initConnectionHandler(IBaseConnectionListener<TiktokConnectionHandler> clientConnectionListener) {
        return new TiktokConnectionHandler((Supplier<WebSocketClientProtocolHandler>)((Supplier)() -> {
            DefaultHttpHeaders headers = new DefaultHttpHeaders();
            headers.add(Header.COOKIE.name(), (Object)("ttwid=" + ((RoomInitResult)this.roomInitResult).getTtwid() + "; " + ((TiktokLiveChatClientConfig)this.getConfig()).getCookie()));
            headers.add(Header.USER_AGENT.name(), (Object)((TiktokLiveChatClientConfig)this.getConfig()).getUserAgent());
            return new WebSocketClientProtocolHandler(WebSocketClientProtocolConfig.newBuilder().webSocketUri(this.getWebsocketUri()).version(WebSocketVersion.V13).subprotocol(null).allowExtensions(true).customHeaders(headers).maxFramePayloadLength(((TiktokLiveChatClientConfig)this.getConfig()).getMaxFramePayloadLength()).handshakeTimeoutMillis(((TiktokLiveChatClientConfig)this.getConfig()).getHandshakeTimeoutMillis()).build());
        }), this, clientConnectionListener);
    }

    @Override
    protected void initChannel(SocketChannel channel) {
        channel.pipeline().addLast(new ChannelHandler[]{new TiktokLiveChatClientChannelInitializer(this)});
    }

    @Override
    public RoomInitResult initRoom() {
        return TiktokApis.roomInit(((TiktokLiveChatClientConfig)this.getConfig()).getBrowserVersion(), String.valueOf((Object)((TiktokLiveChatClientConfig)this.getConfig()).getRoomId()), ((TiktokLiveChatClientConfig)this.getConfig()).getCookie(), (RoomInitResult)this.roomInitResult);
    }

    @Override
    protected String getWebSocketUriString() {
        String webSocketUriString = super.getWebSocketUriString();
        if (StrUtil.isNotBlank(webSocketUriString)) {
            return webSocketUriString;
        }
        Response webcastResponse = ((RoomInitResult)this.roomInitResult).getWebcastResponse();
        long realRoomId = ((RoomInitResult)this.roomInitResult).getRealRoomId();
        String pushServer = webcastResponse.getPushServer();
        LinkedHashMap pushServerParams = new LinkedHashMap();
        pushServerParams.put((Object)"aid", (Object)"1988");
        pushServerParams.put((Object)"app_language", (Object)"en");
        pushServerParams.put((Object)"app_name", (Object)"tiktok_web");
        pushServerParams.put((Object)"browser_language", (Object)"en-US");
        pushServerParams.put((Object)"browser_name", (Object)"Mozilla");
        pushServerParams.put((Object)"browser_online", (Object)"true");
        pushServerParams.put((Object)"browser_platform", (Object)"MacIntel");
        pushServerParams.put((Object)"browser_version", (Object)((TiktokLiveChatClientConfig)this.getConfig()).getBrowserVersion());
        pushServerParams.put((Object)"compress", (Object)"gzip");
        pushServerParams.put((Object)"cookie_enabled", (Object)"true");
        pushServerParams.put((Object)"cursor", (Object)webcastResponse.getCursor());
        pushServerParams.put((Object)"debug", (Object)"false");
        pushServerParams.put((Object)"device_platform", (Object)"web");
        pushServerParams.put((Object)"heartbeatDuration ", (Object)"0");
        pushServerParams.put((Object)"host", (Object)"https://webcast.tiktok.com");
        pushServerParams.put((Object)"identity", (Object)"audience");
        pushServerParams.put((Object)"imprp", (Object)webcastResponse.getRouteParamsOrThrow("imprp"));
        pushServerParams.put((Object)"internal_ext", (Object)webcastResponse.getInternalExt());
        pushServerParams.put((Object)"live_id", (Object)"12");
        pushServerParams.put((Object)"room_id", (Object)Long.toString((long)realRoomId));
        pushServerParams.put((Object)"screen_height", (Object)"800");
        pushServerParams.put((Object)"screen_width", (Object)"1280");
        pushServerParams.put((Object)"sup_ws_ds_opt", (Object)"1");
        pushServerParams.put((Object)"tz_name", (Object)"Asia/Shanghai");
        pushServerParams.put((Object)"update_version_code", (Object)((TiktokLiveChatClientConfig)this.getConfig()).getUpdateVersionCode());
        pushServerParams.put((Object)"version_code", (Object)((TiktokLiveChatClientConfig)this.getConfig()).getVersionCode());
        pushServerParams.put((Object)"webcast_sdk_version", (Object)((TiktokLiveChatClientConfig)this.getConfig()).getWebcastSdkVersion());
        pushServerParams.put((Object)"wrss", (Object)webcastResponse.getRouteParamsOrThrow("wrss"));
        String wss = StrUtil.format("{}?{}", pushServer, OrLiveChatHttpUtil.toParams(pushServerParams));
        log.debug("wss uri: {}", (Object)wss);
        return wss;
    }
}


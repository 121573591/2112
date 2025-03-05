/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package cn.pixellive.mc.game.live.tiktok;

import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveRoomConnectFailedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomConnectedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomDisconnectedEvent;
import tech.ordinaryroad.live.chat.client.tiktok.listener.ITiktokConnectionListener;
import tech.ordinaryroad.live.chat.client.tiktok.netty.handler.TiktokConnectionHandler;

public class TikTokConnectListener
implements ITiktokConnectionListener {
    public static final TikTokConnectListener INSTANCE = new TikTokConnectListener();

    private TikTokConnectListener() {
    }

    @Override
    public void onConnected(TiktokConnectionHandler tiktokConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectedEvent());
        System.out.println("成功连接到TikTok直播间");
    }

    @Override
    public void onConnectFailed(TiktokConnectionHandler tiktokConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectFailedEvent());
        System.out.println("连接TikTok直播间失败");
    }

    @Override
    public void onDisconnected(TiktokConnectionHandler tiktokConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomDisconnectedEvent());
        System.out.println("已断开与TikTok直播间的连接");
    }
}


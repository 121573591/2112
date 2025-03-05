/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package cn.pixellive.mc.game.live.bilibili;

import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveRoomConnectFailedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomConnectedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomDisconnectedEvent;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliConnectionListener;
import tech.ordinaryroad.live.chat.client.bilibili.netty.handler.BilibiliConnectionHandler;

public class BilibiliConnectListener
implements IBilibiliConnectionListener {
    public static final BilibiliConnectListener INSTANCE = new BilibiliConnectListener();

    private BilibiliConnectListener() {
    }

    @Override
    public void onConnected(BilibiliConnectionHandler bilibiliConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectedEvent());
        System.out.println("成功连接到B站直播间");
    }

    @Override
    public void onConnectFailed(BilibiliConnectionHandler bilibiliConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectFailedEvent());
        System.out.println("连接B站直播间失败");
    }

    @Override
    public void onDisconnected(BilibiliConnectionHandler bilibiliConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomDisconnectedEvent());
        System.out.println("已断开与B站直播间的连接");
    }
}


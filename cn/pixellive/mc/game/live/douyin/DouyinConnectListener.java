/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package cn.pixellive.mc.game.live.douyin;

import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveRoomConnectFailedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomConnectedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomDisconnectedEvent;
import tech.ordinaryroad.live.chat.client.douyin.listener.IDouyinConnectionListener;
import tech.ordinaryroad.live.chat.client.douyin.netty.handler.DouyinConnectionHandler;

public class DouyinConnectListener
implements IDouyinConnectionListener {
    public static final DouyinConnectListener INSTANCE = new DouyinConnectListener();

    @Override
    public void onConnected(DouyinConnectionHandler douyinConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectedEvent());
        System.out.println("成功连接到抖音直播间");
    }

    @Override
    public void onConnectFailed(DouyinConnectionHandler douyinConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectFailedEvent());
        System.out.println("连接抖音直播间失败");
    }

    @Override
    public void onDisconnected(DouyinConnectionHandler douyinConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomDisconnectedEvent());
        System.out.println("已断开与抖音直播间的连接");
    }
}


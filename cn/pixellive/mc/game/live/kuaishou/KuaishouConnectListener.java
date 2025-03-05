/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 */
package cn.pixellive.mc.game.live.kuaishou;

import cn.pixellive.mc.game.PixelLiveGameMod;
import cn.pixellive.mc.game.event.live.LiveRoomConnectFailedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomConnectedEvent;
import cn.pixellive.mc.game.event.live.LiveRoomDisconnectedEvent;
import tech.ordinaryroad.live.chat.client.kuaishou.listener.IKuaishouConnectionListener;
import tech.ordinaryroad.live.chat.client.kuaishou.netty.handler.KuaishouConnectionHandler;

public class KuaishouConnectListener
implements IKuaishouConnectionListener {
    public static final KuaishouConnectListener INSTANCE = new KuaishouConnectListener();

    @Override
    public void onConnected(KuaishouConnectionHandler kuaishouConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectedEvent());
        System.out.println("成功连接到快手直播间");
    }

    @Override
    public void onConnectFailed(KuaishouConnectionHandler kuaishouConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomConnectFailedEvent());
        System.out.println("连接快手直播间失败");
    }

    @Override
    public void onDisconnected(KuaishouConnectionHandler kuaishouConnectionHandler) {
        PixelLiveGameMod.你为什么要破解我的代码aaaaaO().post((Object)new LiveRoomDisconnectedEvent());
        System.out.println("已断开与快手直播间的连接");
    }
}


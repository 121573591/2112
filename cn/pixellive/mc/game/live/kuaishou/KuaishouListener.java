/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.minecraft.class_310
 *  net.minecraft.class_8710
 */
package cn.pixellive.mc.game.live.kuaishou;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaas;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.class_310;
import net.minecraft.class_8710;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.msg.KuaishouDanmuMsg;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.msg.KuaishouGiftMsg;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.msg.KuaishouLikeMsg;
import tech.ordinaryroad.live.chat.client.kuaishou.listener.IKuaishouMsgListener;

public class KuaishouListener
implements IKuaishouMsgListener {
    public static final KuaishouListener INSTANCE = new KuaishouListener();

    private boolean isInGame() {
        return class_310.method_1551().field_1724 != null;
    }

    private void sendPacketIfInGame(Object object) {
        if (this.isInGame()) {
            ClientPlayNetworking.send((class_8710)((class_8710)object));
        }
    }

    @Override
    public void onDanmuMsg(KuaishouDanmuMsg kuaishouDanmuMsg) {
        System.out.println(String.format((String)"收到快手弹幕: 用户 %s 说 %s", (Object[])new Object[]{kuaishouDanmuMsg.getUsername(), kuaishouDanmuMsg.getContent()}));
        aaaaad aaaaad2 = new aaaaad(kuaishouDanmuMsg.getUsername(), kuaishouDanmuMsg.getContent());
        this.sendPacketIfInGame(aaaaad2);
    }

    @Override
    public void onGiftMsg(KuaishouGiftMsg kuaishouGiftMsg) {
        System.out.println(String.format((String)"收到快手礼物: 用户 %s 赠送了 %d 个 %s (来自%s)", (Object[])new Object[]{kuaishouGiftMsg.getUsername(), kuaishouGiftMsg.getGiftCount(), kuaishouGiftMsg.getGiftName(), aaaacB.我草你怎么反编译我模组aaaaey.你为什么要破解我的代码aaaabA()}));
        if (kuaishouGiftMsg.getGiftCount() > 0) {
            aaaaak aaaaak2 = new aaaaak(kuaishouGiftMsg.getUsername(), kuaishouGiftMsg.getGiftName(), kuaishouGiftMsg.getGiftCount(), aaaacB.我草你怎么反编译我模组aaaaey.你为什么要破解我的代码aaaabA(), kuaishouGiftMsg.getUserAvatar());
            this.sendPacketIfInGame(aaaaak2);
        }
    }

    @Override
    public void onLikeMsg(KuaishouLikeMsg kuaishouLikeMsg) {
        System.out.println(String.format((String)"收到快手点赞: 用户 %s 点赞了 %d 次", (Object[])new Object[]{kuaishouLikeMsg.getUsername(), kuaishouLikeMsg.getClickCount()}));
        aaaaas aaaaas2 = new aaaaas(kuaishouLikeMsg.getUsername(), kuaishouLikeMsg.getClickCount());
        this.sendPacketIfInGame(aaaaas2);
    }
}


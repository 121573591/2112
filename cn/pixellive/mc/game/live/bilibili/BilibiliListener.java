/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
 *  net.minecraft.class_310
 *  net.minecraft.class_8710
 */
package cn.pixellive.mc.game.live.bilibili;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.class_310;
import net.minecraft.class_8710;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliMsgListener;
import tech.ordinaryroad.live.chat.client.bilibili.netty.handler.BilibiliBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.DanmuMsgMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.InteractWordMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.LikeInfoV3ClickMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.SendGiftMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.SuperChatMessageMsg;

public class BilibiliListener
implements IBilibiliMsgListener {
    public static final BilibiliListener INSTANCE = new BilibiliListener();

    private BilibiliListener() {
    }

    private boolean isInGame() {
        return class_310.method_1551().field_1724 != null;
    }

    private void sendPacketIfInGame(Object object) {
        try {
            if (this.isInGame() && object != null) {
                ClientPlayNetworking.send((class_8710)((class_8710)object));
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error("发送网络包时发生错误", (Throwable)exception);
        }
    }

    @Override
    public void onDanmuMsg(BilibiliBinaryFrameHandler bilibiliBinaryFrameHandler, DanmuMsgMsg danmuMsgMsg) {
        System.out.println(String.format((String)"收到B站弹幕: 用户 %s 说 %s", (Object[])new Object[]{danmuMsgMsg.getUsername(), danmuMsgMsg.getContent()}));
        aaaaad aaaaad2 = new aaaaad(danmuMsgMsg.getUsername(), danmuMsgMsg.getContent());
        this.sendPacketIfInGame(aaaaad2);
    }

    @Override
    public void onGiftMsg(BilibiliBinaryFrameHandler bilibiliBinaryFrameHandler, SendGiftMsg sendGiftMsg) {
        System.out.println(String.format((String)"收到B站礼物: 用户 %s 赠送了 %d 个 %s (来自%s)", (Object[])new Object[]{sendGiftMsg.getUsername(), sendGiftMsg.getGiftCount(), sendGiftMsg.getGiftName(), aaaacB.我草你怎么反编译我模组aaaaeA.你为什么要破解我的代码aaaabA()}));
        if (sendGiftMsg.getGiftCount() > 0) {
            aaaaak aaaaak2 = new aaaaak(sendGiftMsg.getUsername(), sendGiftMsg.getGiftName(), sendGiftMsg.getGiftCount(), aaaacB.我草你怎么反编译我模组aaaaeA.你为什么要破解我的代码aaaabA(), sendGiftMsg.getUserAvatar());
            this.sendPacketIfInGame(aaaaak2);
        }
    }

    @Override
    public void onSuperChatMsg(BilibiliBinaryFrameHandler bilibiliBinaryFrameHandler, SuperChatMessageMsg superChatMessageMsg) {
        System.out.println(String.format((String)"收到B站醒目留言: 用户 %s 说 %s", (Object[])new Object[]{superChatMessageMsg.getUsername(), superChatMessageMsg.getContent()}));
        aaaaad aaaaad2 = new aaaaad(superChatMessageMsg.getUsername(), superChatMessageMsg.getContent());
        this.sendPacketIfInGame(aaaaad2);
    }

    @Override
    public void onEnterRoomMsg(InteractWordMsg interactWordMsg) {
        System.out.println(String.format((String)"用户进入B站直播间: %s", (Object[])new Object[]{interactWordMsg.getUsername()}));
        aaaaaa aaaaaa2 = new aaaaaa(interactWordMsg.getUsername());
        this.sendPacketIfInGame(aaaaaa2);
    }

    @Override
    public void onLikeMsg(BilibiliBinaryFrameHandler bilibiliBinaryFrameHandler, LikeInfoV3ClickMsg likeInfoV3ClickMsg) {
        System.out.println(String.format((String)"收到B站点赞: 用户 %s 点赞了", (Object[])new Object[]{likeInfoV3ClickMsg.getUsername()}));
        aaaaas aaaaas2 = new aaaaas(likeInfoV3ClickMsg.getUsername(), 1);
        this.sendPacketIfInGame(aaaaas2);
    }
}


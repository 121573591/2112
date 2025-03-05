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
package cn.pixellive.mc.game.live.tiktok;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaas;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.class_310;
import net.minecraft.class_8710;
import tech.ordinaryroad.live.chat.client.codec.tiktok.constant.TiktokCmdEnum;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokControlMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokDanmuMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokEnterRoomMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokGiftMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokLikeMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.TiktokSocialMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ICmdMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;
import tech.ordinaryroad.live.chat.client.tiktok.listener.ITiktokMsgListener;
import tech.ordinaryroad.live.chat.client.tiktok.netty.handler.TiktokBinaryFrameHandler;

public class TikTokListener
implements ITiktokMsgListener {
    public static final TikTokListener INSTANCE = new TikTokListener();

    private boolean isInGame() {
        return class_310.method_1551().field_1724 != null;
    }

    private void sendPacketIfInGame(Object object) {
        if (this.isInGame()) {
            ClientPlayNetworking.send((class_8710)((class_8710)object));
        }
    }

    @Override
    public void onMsg(IMsg iMsg) {
        aaaaab.你为什么要破解我的代码aaaaaa().debug("收到{}消息 {}", (Object)iMsg.getClass(), (Object)iMsg);
    }

    @Override
    public void onCmdMsg(TiktokCmdEnum tiktokCmdEnum, ICmdMsg<TiktokCmdEnum> iCmdMsg) {
        aaaaab.你为什么要破解我的代码aaaaaa().debug("收到CMD消息{} {}", (Object)tiktokCmdEnum, iCmdMsg);
    }

    @Override
    public void onOtherCmdMsg(TiktokCmdEnum tiktokCmdEnum, ICmdMsg<TiktokCmdEnum> iCmdMsg) {
        aaaaab.你为什么要破解我的代码aaaaaa().debug("收到其他CMD消息 {}", (Object)tiktokCmdEnum);
    }

    @Override
    public void onUnknownCmd(String string, IMsg iMsg) {
        aaaaab.你为什么要破解我的代码aaaaaa().debug("收到未知CMD消息 {}", (Object)string);
    }

    @Override
    public void onDanmuMsg(TiktokBinaryFrameHandler tiktokBinaryFrameHandler, TiktokDanmuMsg tiktokDanmuMsg) {
        System.out.println(String.format((String)"收到TikTok弹幕: 用户 %s(%s) 说 %s", (Object[])new Object[]{tiktokDanmuMsg.getUsername(), tiktokDanmuMsg.getUid(), tiktokDanmuMsg.getContent()}));
        aaaaad aaaaad2 = new aaaaad(tiktokDanmuMsg.getUsername(), tiktokDanmuMsg.getContent());
        this.sendPacketIfInGame(aaaaad2);
    }

    @Override
    public void onGiftMsg(TiktokBinaryFrameHandler tiktokBinaryFrameHandler, TiktokGiftMsg tiktokGiftMsg) {
        if (tiktokGiftMsg.getGiftCount() > 0) {
            System.out.println(String.format((String)"收到TikTok礼物: 用户 %s(%s) 赠送了 %d 个 %s", (Object[])new Object[]{tiktokGiftMsg.getUsername(), tiktokGiftMsg.getUid(), tiktokGiftMsg.getGiftCount(), tiktokGiftMsg.getGiftName()}));
            aaaaak aaaaak2 = new aaaaak(tiktokGiftMsg.getUsername(), tiktokGiftMsg.getGiftName(), tiktokGiftMsg.getGiftCount(), aaaacB.我草你怎么反编译我模组aaaaez.你为什么要破解我的代码aaaabA(), tiktokGiftMsg.getUserAvatar());
            this.sendPacketIfInGame(aaaaak2);
        }
    }

    @Override
    public void onLikeMsg(TiktokBinaryFrameHandler tiktokBinaryFrameHandler, TiktokLikeMsg tiktokLikeMsg) {
        System.out.println(String.format((String)"收到TikTok点赞: 用户 %s(%s) 点赞了 %d 次", (Object[])new Object[]{tiktokLikeMsg.getUsername(), tiktokLikeMsg.getUid(), tiktokLikeMsg.getClickCount()}));
        aaaaas aaaaas2 = new aaaaas(tiktokLikeMsg.getUsername(), tiktokLikeMsg.getClickCount());
        this.sendPacketIfInGame(aaaaas2);
    }

    @Override
    public void onEnterRoomMsg(TiktokBinaryFrameHandler tiktokBinaryFrameHandler, TiktokEnterRoomMsg tiktokEnterRoomMsg) {
        System.out.println(String.format((String)"用户进入TikTok直播间: %s(%s)", (Object[])new Object[]{tiktokEnterRoomMsg.getUsername(), tiktokEnterRoomMsg.getUid()}));
        aaaaaa aaaaaa2 = new aaaaaa(tiktokEnterRoomMsg.getUsername());
        this.sendPacketIfInGame(aaaaaa2);
    }

    @Override
    public void onLiveStatusMsg(TiktokBinaryFrameHandler tiktokBinaryFrameHandler, TiktokControlMsg tiktokControlMsg) {
        System.out.println("TikTok直播状态变更为: " + (switch (tiktokControlMsg.getMsg().getStatus()) {
            case 1 -> "开始";
            case 2 -> "结束";
            default -> "未知状态:" + tiktokControlMsg.getMsg().getStatus();
        }));
    }

    @Override
    public void onSocialMsg(TiktokBinaryFrameHandler tiktokBinaryFrameHandler, TiktokSocialMsg tiktokSocialMsg) {
        System.out.println(String.format((String)"收到TikTok社交消息: 用户 %s(%s) %s", (Object[])new Object[]{tiktokSocialMsg.getUsername(), tiktokSocialMsg.getUid(), tiktokSocialMsg.getSocialAction()}));
    }
}


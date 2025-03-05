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
package cn.pixellive.mc.game.live.douyin;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaacB;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaaa;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaad;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaak;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaac.aaaaaa.aaaaas;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.class_310;
import net.minecraft.class_8710;
import tech.ordinaryroad.live.chat.client.codec.douyin.msg.DouyinControlMsg;
import tech.ordinaryroad.live.chat.client.codec.douyin.msg.DouyinDanmuMsg;
import tech.ordinaryroad.live.chat.client.codec.douyin.msg.DouyinEnterRoomMsg;
import tech.ordinaryroad.live.chat.client.codec.douyin.msg.DouyinGiftMsg;
import tech.ordinaryroad.live.chat.client.codec.douyin.msg.DouyinLikeMsg;
import tech.ordinaryroad.live.chat.client.commons.base.constant.LiveStatusAction;
import tech.ordinaryroad.live.chat.client.douyin.listener.IDouyinMsgListener;

public class DouyinListener
implements IDouyinMsgListener {
    public static final DouyinListener INSTANCE = new DouyinListener();

    private boolean isInGame() {
        return class_310.method_1551().field_1724 != null;
    }

    private void sendPacketIfInGame(Object object) {
        if (this.isInGame()) {
            ClientPlayNetworking.send((class_8710)((class_8710)object));
        }
    }

    @Override
    public void onDanmuMsg(DouyinDanmuMsg douyinDanmuMsg) {
        System.out.println(String.format((String)"收到抖音弹幕: 用户 %s 说 %s", (Object[])new Object[]{douyinDanmuMsg.getUsername(), douyinDanmuMsg.getContent()}));
        aaaaad aaaaad2 = new aaaaad(douyinDanmuMsg.getUsername(), douyinDanmuMsg.getContent());
        this.sendPacketIfInGame(aaaaad2);
    }

    @Override
    public void onGiftMsg(DouyinGiftMsg douyinGiftMsg) {
        System.out.println(String.format((String)"收到抖音礼物: 用户 %s 赠送了 %d 个 %s (来自%s)", (Object[])new Object[]{douyinGiftMsg.getUsername(), douyinGiftMsg.getGiftCount(), douyinGiftMsg.getGiftName(), aaaacB.我草你怎么反编译我模组aaaaex.你为什么要破解我的代码aaaabA()}));
        if (douyinGiftMsg.getGiftCount() > 0) {
            aaaaak aaaaak2 = new aaaaak(douyinGiftMsg.getUsername(), douyinGiftMsg.getGiftName(), douyinGiftMsg.getGiftCount(), aaaacB.我草你怎么反编译我模组aaaaex.你为什么要破解我的代码aaaabA(), douyinGiftMsg.getUserAvatar());
            this.sendPacketIfInGame(aaaaak2);
        }
    }

    @Override
    public void onLikeMsg(DouyinLikeMsg douyinLikeMsg) {
        System.out.println(String.format((String)"收到抖音点赞: 用户 %s 点赞了 %d 次", (Object[])new Object[]{douyinLikeMsg.getUsername(), douyinLikeMsg.getClickCount()}));
        aaaaas aaaaas2 = new aaaaas(douyinLikeMsg.getUsername(), douyinLikeMsg.getClickCount());
        this.sendPacketIfInGame(aaaaas2);
    }

    @Override
    public void onEnterRoomMsg(DouyinEnterRoomMsg douyinEnterRoomMsg) {
        System.out.println(String.format((String)"用户进入抖音直播间: %s", (Object[])new Object[]{douyinEnterRoomMsg.getUsername()}));
        aaaaaa aaaaaa2 = new aaaaaa(douyinEnterRoomMsg.getUsername());
        this.sendPacketIfInGame(aaaaaa2);
    }

    @Override
    public void onLiveStatusMsg(DouyinControlMsg douyinControlMsg) {
        LiveStatusAction liveStatusAction = douyinControlMsg.getLiveStatusAction();
        if (liveStatusAction != null) {
            switch (liveStatusAction) {
                case BEGIN: {
                    System.out.println("抖音直播状态变更为: 开始");
                    break;
                }
                case END: {
                    System.out.println("抖音直播状态变更为: 结束");
                }
            }
        }
    }
}


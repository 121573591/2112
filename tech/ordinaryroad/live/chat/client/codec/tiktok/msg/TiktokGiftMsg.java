/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.msg;

import cn.hutool.core.collection.CollUtil;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.base.ITiktokMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.GiftMessage;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IGiftMsg;

public class TiktokGiftMsg
implements ITiktokMsg,
IGiftMsg {
    private GiftMessage msg;
    private int calculatedGiftCount;

    public TiktokGiftMsg(GiftMessage msg) {
        this.msg = msg;
    }

    @Override
    public String getBadgeName() {
        return "";
    }

    @Override
    public byte getBadgeLevel() {
        return 0;
    }

    @Override
    public String getUid() {
        return Long.toString((long)this.msg.getUser().getId());
    }

    @Override
    public String getUsername() {
        return this.msg.getUser().getNickName();
    }

    @Override
    public String getUserAvatar() {
        return (String)CollUtil.getFirst(this.msg.getUser().getAvatarThumb().getUrlListListList());
    }

    @Override
    public String getGiftName() {
        return this.msg.getGift().getName();
    }

    @Override
    public String getGiftImg() {
        return (String)CollUtil.getFirst(this.msg.getGift().getImage().getUrlListListList());
    }

    @Override
    public String getGiftId() {
        return Long.toString((long)this.msg.getGiftId());
    }

    @Override
    public int getGiftCount() {
        return this.calculatedGiftCount;
    }

    @Override
    public int getGiftPrice() {
        return this.msg.getGift().getDiamondCount();
    }

    @Override
    public String getReceiveUid() {
        return Long.toString((long)this.msg.getToUser().getId());
    }

    @Override
    public String getReceiveUsername() {
        return this.msg.getToUser().getNickName();
    }

    public String toString() {
        return this.msg.toString();
    }

    public GiftMessage getMsg() {
        return this.msg;
    }

    public int getCalculatedGiftCount() {
        return this.calculatedGiftCount;
    }

    public void setMsg(GiftMessage msg) {
        this.msg = msg;
    }

    public void setCalculatedGiftCount(int calculatedGiftCount) {
        this.calculatedGiftCount = calculatedGiftCount;
    }

    public TiktokGiftMsg(GiftMessage msg, int calculatedGiftCount) {
        this.msg = msg;
        this.calculatedGiftCount = calculatedGiftCount;
    }

    public TiktokGiftMsg() {
    }
}


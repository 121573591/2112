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
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.LikeMessage;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ILikeMsg;

public class TiktokLikeMsg
implements ITiktokMsg,
ILikeMsg {
    private LikeMessage msg;

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
    public int getClickCount() {
        return (int)this.msg.getCount();
    }

    public String toString() {
        return this.msg.toString();
    }

    public LikeMessage getMsg() {
        return this.msg;
    }

    public void setMsg(LikeMessage msg) {
        this.msg = msg;
    }

    public TiktokLikeMsg(LikeMessage msg) {
        this.msg = msg;
    }

    public TiktokLikeMsg() {
    }
}


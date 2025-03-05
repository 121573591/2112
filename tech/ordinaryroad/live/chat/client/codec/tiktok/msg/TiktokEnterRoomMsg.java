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
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.MemberMessage;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IEnterRoomMsg;

public class TiktokEnterRoomMsg
implements ITiktokMsg,
IEnterRoomMsg {
    private MemberMessage msg;

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

    public String toString() {
        return this.msg.toString();
    }

    public MemberMessage getMsg() {
        return this.msg;
    }

    public void setMsg(MemberMessage msg) {
        this.msg = msg;
    }

    public TiktokEnterRoomMsg(MemberMessage msg) {
        this.msg = msg;
    }

    public TiktokEnterRoomMsg() {
    }
}


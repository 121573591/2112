/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.msg;

import tech.ordinaryroad.live.chat.client.codec.tiktok.constant.TiktokCmdEnum;
import tech.ordinaryroad.live.chat.client.codec.tiktok.msg.base.ITiktokCmdMsg;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Message;

public class TiktokCmdMsg
implements ITiktokCmdMsg {
    private Message msg;

    @Override
    public String getCmd() {
        if (this.msg == null) {
            return null;
        }
        return this.msg.getMethod();
    }

    @Override
    public void setCmd(String cmd) {
    }

    @Override
    public TiktokCmdEnum getCmdEnum() {
        if (this.msg == null) {
            return null;
        }
        return TiktokCmdEnum.getByName(this.msg.getMethod());
    }

    public Message getMsg() {
        return this.msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public TiktokCmdMsg(Message msg) {
        this.msg = msg;
    }

    public TiktokCmdMsg() {
    }
}


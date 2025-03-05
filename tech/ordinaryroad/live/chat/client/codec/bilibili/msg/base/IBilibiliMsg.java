/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.OperationEnum;
import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.ProtoverEnum;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;

public interface IBilibiliMsg
extends IMsg {
    @JsonIgnore
    public ProtoverEnum getProtoverEnum();

    @JsonIgnore
    public OperationEnum getOperationEnum();
}


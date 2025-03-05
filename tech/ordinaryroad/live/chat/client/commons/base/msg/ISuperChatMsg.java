/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.commons.base.msg;

import tech.ordinaryroad.live.chat.client.commons.base.msg.IDanmuMsg;

public interface ISuperChatMsg
extends IDanmuMsg {
    public int getDuration();

    @Override
    default public String getBadgeName() {
        return "";
    }

    @Override
    default public byte getBadgeLevel() {
        return 0;
    }
}


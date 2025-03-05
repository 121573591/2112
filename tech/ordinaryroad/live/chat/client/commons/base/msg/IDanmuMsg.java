/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.commons.base.msg;

import tech.ordinaryroad.live.chat.client.commons.base.msg.IMsg;

public interface IDanmuMsg
extends IMsg {
    public String getBadgeName();

    public byte getBadgeLevel();

    public String getUid();

    public String getUsername();

    default public String getUserAvatar() {
        return null;
    }

    public String getContent();
}


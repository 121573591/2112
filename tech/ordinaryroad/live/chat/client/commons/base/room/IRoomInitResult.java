/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.commons.base.room;

import tech.ordinaryroad.live.chat.client.commons.base.constant.RoomLiveStatusEnum;

public interface IRoomInitResult {
    public String getRoomTitle();

    default public String getRoomDescription() {
        return "";
    }

    public RoomLiveStatusEnum getRoomLiveStatus();
}


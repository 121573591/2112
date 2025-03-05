/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.commons.base.listener;

public interface IRoomStatsMsgListener<T, RoomStatsMsg> {
    default public void onRoomStatsMsg(T t, RoomStatsMsg msg) {
        this.onRoomStatsMsg(msg);
    }

    default public void onRoomStatsMsg(RoomStatsMsg msg) {
    }
}


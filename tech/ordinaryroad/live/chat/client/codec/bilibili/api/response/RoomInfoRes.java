/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.response;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Room_info;

public class RoomInfoRes {
    private Room_info room_info;

    public Room_info getRoom_info() {
        return this.room_info;
    }

    public void setRoom_info(Room_info room_info) {
        this.room_info = room_info;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RoomInfoRes)) {
            return false;
        }
        RoomInfoRes other = (RoomInfoRes)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Room_info this$room_info = this.getRoom_info();
        Room_info other$room_info = other.getRoom_info();
        return !(this$room_info == null ? other$room_info != null : !this$room_info.equals(other$room_info));
    }

    protected boolean canEqual(Object other) {
        return other instanceof RoomInfoRes;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Room_info $room_info = this.getRoom_info();
        result = result * 59 + ($room_info == null ? 43 : $room_info.hashCode());
        return result;
    }

    public String toString() {
        return "RoomInfoRes(room_info=" + this.getRoom_info() + ")";
    }

    public RoomInfoRes(Room_info room_info) {
        this.room_info = room_info;
    }

    public RoomInfoRes() {
    }
}


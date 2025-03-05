/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.constant;

public enum TiktokRoomStatusEnum {
    STOPPED(4),
    LIVING(2);

    private final int code;

    public static TiktokRoomStatusEnum getByCode(int code) {
        for (TiktokRoomStatusEnum value : TiktokRoomStatusEnum.values()) {
            if (value.getCode() != code) continue;
            return value;
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    private TiktokRoomStatusEnum(int code) {
        this.code = code;
    }
}


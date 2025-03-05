/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.constant;

public enum ProtoverEnum {
    NORMAL_NO_COMPRESSION(0),
    HEARTBEAT_AUTH_NO_COMPRESSION(1),
    NORMAL_ZLIB(2),
    NORMAL_BROTLI(3);

    private final int code;

    public static ProtoverEnum getByCode(int code) {
        for (ProtoverEnum value : ProtoverEnum.values()) {
            if (value.code != code) continue;
            return value;
        }
        return null;
    }

    public int getCode() {
        return this.code;
    }

    private ProtoverEnum(int code) {
        this.code = code;
    }
}


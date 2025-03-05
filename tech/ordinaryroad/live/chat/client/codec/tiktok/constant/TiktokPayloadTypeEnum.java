/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.constant;

import cn.hutool.core.util.StrUtil;

public enum TiktokPayloadTypeEnum {
    HB("hb"),
    MSG("msg"),
    ACK("ack");

    private final String code;

    public static TiktokPayloadTypeEnum getByCode(String code) {
        if (StrUtil.isBlank(code)) {
            return null;
        }
        for (TiktokPayloadTypeEnum value : TiktokPayloadTypeEnum.values()) {
            if (!value.getCode().equals((Object)code)) continue;
            return value;
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    private TiktokPayloadTypeEnum(String code) {
        this.code = code;
    }
}


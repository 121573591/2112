/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.constant;

import cn.hutool.core.util.StrUtil;

public enum DouyinPayloadTypeEnum {
    HB("hb"),
    MSG("msg"),
    ACK("ack");

    private final String code;

    public static DouyinPayloadTypeEnum getByCode(String code) {
        if (StrUtil.isBlank(code)) {
            return null;
        }
        for (DouyinPayloadTypeEnum value : DouyinPayloadTypeEnum.values()) {
            if (!value.getCode().equals((Object)code)) continue;
            return value;
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    private DouyinPayloadTypeEnum(String code) {
        this.code = code;
    }
}


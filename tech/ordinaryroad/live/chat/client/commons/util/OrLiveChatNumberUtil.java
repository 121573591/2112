/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.commons.util;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;

public class OrLiveChatNumberUtil
extends NumberUtil {
    public static long parseLong(Object object) {
        return NumberUtil.parseLong(StrUtil.toStringOrNull(object));
    }
}


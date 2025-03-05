/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ObjectUtil
 *  java.lang.Object
 *  java.lang.String
 */
package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.internal.ObjectUtil;

public final class RtspVersions {
    public static final HttpVersion RTSP_1_0 = new HttpVersion("RTSP", 1, 0, true);

    public static HttpVersion valueOf(String text) {
        ObjectUtil.checkNotNull((Object)text, (String)"text");
        text = text.trim().toUpperCase();
        if ("RTSP/1.0".equals((Object)text)) {
            return RTSP_1_0;
        }
        return new HttpVersion(text, true);
    }

    private RtspVersions() {
    }
}


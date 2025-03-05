/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Settings;

public interface Http2SettingsReceivedConsumer {
    public void consumeReceivedSettings(Http2Settings var1);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.DefaultHttp2SettingsAckFrame;
import io.netty.handler.codec.http2.Http2Frame;

public interface Http2SettingsAckFrame
extends Http2Frame {
    public static final Http2SettingsAckFrame INSTANCE = new DefaultHttp2SettingsAckFrame();

    @Override
    public String name();
}


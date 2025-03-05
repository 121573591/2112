/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Frame;
import io.netty.handler.codec.http2.Http2Settings;

public interface Http2SettingsFrame
extends Http2Frame {
    public Http2Settings settings();

    @Override
    public String name();
}


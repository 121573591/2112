/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.netty.handler.codec.spdy;

import io.netty.handler.codec.spdy.SpdyFrame;

public interface SpdyPingFrame
extends SpdyFrame {
    public int id();

    public SpdyPingFrame setId(int var1);
}


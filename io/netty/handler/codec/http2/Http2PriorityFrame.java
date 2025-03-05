/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2FrameStream;
import io.netty.handler.codec.http2.Http2StreamFrame;

public interface Http2PriorityFrame
extends Http2StreamFrame {
    public int streamDependency();

    public short weight();

    public boolean exclusive();

    @Override
    public Http2PriorityFrame stream(Http2FrameStream var1);
}


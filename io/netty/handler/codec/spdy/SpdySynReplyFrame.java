/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package io.netty.handler.codec.spdy;

import io.netty.handler.codec.spdy.SpdyHeadersFrame;

public interface SpdySynReplyFrame
extends SpdyHeadersFrame {
    @Override
    public SpdySynReplyFrame setStreamId(int var1);

    @Override
    public SpdySynReplyFrame setLast(boolean var1);

    @Override
    public SpdySynReplyFrame setInvalid();
}


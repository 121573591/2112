/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  java.lang.Object
 *  java.lang.Override
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public interface FullHttpResponse
extends HttpResponse,
FullHttpMessage {
    @Override
    public FullHttpResponse copy();

    @Override
    public FullHttpResponse duplicate();

    @Override
    public FullHttpResponse retainedDuplicate();

    @Override
    public FullHttpResponse replace(ByteBuf var1);

    @Override
    public FullHttpResponse retain(int var1);

    @Override
    public FullHttpResponse retain();

    @Override
    public FullHttpResponse touch();

    @Override
    public FullHttpResponse touch(Object var1);

    @Override
    public FullHttpResponse setProtocolVersion(HttpVersion var1);

    @Override
    public FullHttpResponse setStatus(HttpResponseStatus var1);
}


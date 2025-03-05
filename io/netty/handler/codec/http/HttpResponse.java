/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 */
package io.netty.handler.codec.http;

import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

public interface HttpResponse
extends HttpMessage {
    @Deprecated
    public HttpResponseStatus getStatus();

    public HttpResponseStatus status();

    public HttpResponse setStatus(HttpResponseStatus var1);

    @Override
    public HttpResponse setProtocolVersion(HttpVersion var1);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;

public final class WebSocketClientHandshakeException
extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1L;
    private final HttpResponse response;

    public WebSocketClientHandshakeException(String message) {
        this(message, (HttpResponse)null);
    }

    public WebSocketClientHandshakeException(String message, HttpResponse httpResponse) {
        super(message);
        this.response = httpResponse != null ? new DefaultHttpResponse(httpResponse.protocolVersion(), httpResponse.status(), httpResponse.headers()) : null;
    }

    public HttpResponse response() {
        return this.response;
    }
}


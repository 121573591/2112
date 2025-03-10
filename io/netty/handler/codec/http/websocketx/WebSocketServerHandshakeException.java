/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;

public final class WebSocketServerHandshakeException
extends WebSocketHandshakeException {
    private static final long serialVersionUID = 1L;
    private final HttpRequest request;

    public WebSocketServerHandshakeException(String message) {
        this(message, (HttpRequest)null);
    }

    public WebSocketServerHandshakeException(String message, HttpRequest httpRequest) {
        super(message);
        this.request = httpRequest != null ? new DefaultHttpRequest(httpRequest.protocolVersion(), httpRequest.method(), httpRequest.uri(), httpRequest.headers()) : null;
    }

    public HttpRequest request() {
        return this.request;
    }
}


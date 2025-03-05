/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 */
package io.netty.handler.codec.http2;

public final class Http2MultiplexActiveStreamsException
extends Exception {
    public Http2MultiplexActiveStreamsException(Throwable cause) {
        super(cause);
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.handler.codec.TooLongFrameException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

public final class TooLongHttpContentException
extends TooLongFrameException {
    private static final long serialVersionUID = 3238341182129476117L;

    public TooLongHttpContentException() {
    }

    public TooLongHttpContentException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooLongHttpContentException(String message) {
        super(message);
    }

    public TooLongHttpContentException(Throwable cause) {
        super(cause);
    }
}


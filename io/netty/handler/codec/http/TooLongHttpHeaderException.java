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

public final class TooLongHttpHeaderException
extends TooLongFrameException {
    private static final long serialVersionUID = -8295159138628369730L;

    public TooLongHttpHeaderException() {
    }

    public TooLongHttpHeaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooLongHttpHeaderException(String message) {
        super(message);
    }

    public TooLongHttpHeaderException(Throwable cause) {
        super(cause);
    }
}


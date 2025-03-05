/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream
extends InputStream {
    protected final ByteBuffer _b;

    public ByteBufferBackedInputStream(ByteBuffer buf) {
        this._b = buf;
    }

    public int available() {
        return this._b.remaining();
    }

    public int read() throws IOException {
        return this._b.hasRemaining() ? this._b.get() & 0xFF : -1;
    }

    public int read(byte[] bytes, int off, int len) throws IOException {
        if (!this._b.hasRemaining()) {
            return -1;
        }
        len = Math.min((int)len, (int)this._b.remaining());
        this._b.get(bytes, off, len);
        return len;
    }
}


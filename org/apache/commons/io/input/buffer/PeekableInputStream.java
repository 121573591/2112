/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package org.apache.commons.io.input.buffer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.apache.commons.io.input.buffer.CircularBufferInputStream;

public class PeekableInputStream
extends CircularBufferInputStream {
    public PeekableInputStream(InputStream inputStream2, int bufferSize) {
        super(inputStream2, bufferSize);
    }

    public PeekableInputStream(InputStream inputStream2) {
        super(inputStream2);
    }

    public boolean peek(byte[] sourceBuffer) throws IOException {
        Objects.requireNonNull((Object)sourceBuffer, (String)"sourceBuffer");
        return this.peek(sourceBuffer, 0, sourceBuffer.length);
    }

    public boolean peek(byte[] sourceBuffer, int offset, int length) throws IOException {
        Objects.requireNonNull((Object)sourceBuffer, (String)"sourceBuffer");
        if (sourceBuffer.length > this.bufferSize) {
            throw new IllegalArgumentException("Peek request size of " + sourceBuffer.length + " bytes exceeds buffer size of " + this.bufferSize + " bytes");
        }
        if (this.buffer.getCurrentNumberOfBytes() < sourceBuffer.length) {
            this.fillBuffer();
        }
        return this.buffer.peek(sourceBuffer, offset, length);
    }
}


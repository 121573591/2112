/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.nio.channels.Channels
 */
package com.aayushatharva.brotli4j.encoder;

import com.aayushatharva.brotli4j.encoder.Encoder;
import com.aayushatharva.brotli4j.encoder.EncoderJNI;
import com.aayushatharva.brotli4j.encoder.PreparedDictionary;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;

public class BrotliOutputStream
extends OutputStream {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Encoder encoder;

    public BrotliOutputStream(OutputStream destination, Encoder.Parameters params, int bufferSize) throws IOException {
        this.encoder = new Encoder(Channels.newChannel((OutputStream)destination), params, bufferSize);
    }

    public BrotliOutputStream(OutputStream destination, Encoder.Parameters params) throws IOException {
        this(destination, params, 16384);
    }

    public BrotliOutputStream(OutputStream destination) throws IOException {
        this(destination, new Encoder.Parameters());
    }

    public void attachDictionary(PreparedDictionary dictionary) throws IOException {
        this.encoder.attachDictionary(dictionary);
    }

    public void close() throws IOException {
        this.encoder.close();
    }

    public void flush() throws IOException {
        if (this.encoder.closed) {
            throw new IOException("write after close");
        }
        this.encoder.flush();
    }

    public void write(int b) throws IOException {
        if (this.encoder.closed) {
            throw new IOException("write after close");
        }
        while (!this.encoder.encode(EncoderJNI.Operation.PROCESS)) {
        }
        this.encoder.inputBuffer.put((byte)b);
    }

    public void write(byte[] b) throws IOException {
        this.write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        if (this.encoder.closed) {
            throw new IOException("write after close");
        }
        while (len > 0) {
            if (!this.encoder.encode(EncoderJNI.Operation.PROCESS)) continue;
            int limit = Math.min((int)len, (int)this.encoder.inputBuffer.remaining());
            this.encoder.inputBuffer.put(b, off, limit);
            off += limit;
            len -= limit;
        }
    }
}


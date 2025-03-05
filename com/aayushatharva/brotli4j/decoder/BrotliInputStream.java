/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.nio.ByteBuffer
 *  java.nio.channels.Channels
 */
package com.aayushatharva.brotli4j.decoder;

import com.aayushatharva.brotli4j.decoder.Decoder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

public class BrotliInputStream
extends InputStream {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Decoder decoder;

    public BrotliInputStream(InputStream source2, int bufferSize) throws IOException {
        this.decoder = new Decoder(Channels.newChannel((InputStream)source2), bufferSize);
    }

    public BrotliInputStream(InputStream source2) throws IOException {
        this(source2, 16384);
    }

    public void attachDictionary(ByteBuffer dictionary) throws IOException {
        this.decoder.attachDictionary(dictionary);
    }

    public void enableEagerOutput() {
        this.decoder.enableEagerOutput();
    }

    public void close() throws IOException {
        this.decoder.close();
    }

    public int available() {
        return this.decoder.buffer != null ? this.decoder.buffer.remaining() : 0;
    }

    public int read() throws IOException {
        int decoded;
        if (this.decoder.closed) {
            throw new IOException("read after close");
        }
        while ((decoded = this.decoder.decode()) == 0) {
        }
        if (decoded == -1) {
            return -1;
        }
        return this.decoder.buffer.get() & 0xFF;
    }

    public int read(byte[] b) throws IOException {
        return this.read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (this.decoder.closed) {
            throw new IOException("read after close");
        }
        if (this.decoder.decode() == -1) {
            return -1;
        }
        int result = 0;
        while (len > 0) {
            int limit = Math.min((int)len, (int)this.decoder.buffer.remaining());
            this.decoder.buffer.get(b, off, limit);
            off += limit;
            len -= limit;
            result += limit;
            if (this.decoder.decode() != -1) continue;
            break;
        }
        return result;
    }

    public long skip(long n) throws IOException {
        if (this.decoder.closed) {
            throw new IOException("read after close");
        }
        long result = 0L;
        while (n > 0L && this.decoder.decode() != -1) {
            int limit = (int)Math.min((long)n, (long)this.decoder.buffer.remaining());
            this.decoder.discard(limit);
            result += (long)limit;
            n -= (long)limit;
        }
        return result;
    }
}


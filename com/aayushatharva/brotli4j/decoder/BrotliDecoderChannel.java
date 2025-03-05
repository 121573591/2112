/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.nio.ByteBuffer
 *  java.nio.channels.ClosedChannelException
 *  java.nio.channels.ReadableByteChannel
 */
package com.aayushatharva.brotli4j.decoder;

import com.aayushatharva.brotli4j.decoder.Decoder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;

public class BrotliDecoderChannel
extends Decoder
implements ReadableByteChannel {
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private final Object mutex = new Object();

    public BrotliDecoderChannel(ReadableByteChannel source2) throws IOException {
        this(source2, 16384);
    }

    public BrotliDecoderChannel(ReadableByteChannel source2, int bufferSize) throws IOException {
        super(source2, bufferSize);
    }

    @Override
    public void attachDictionary(ByteBuffer dictionary) throws IOException {
        super.attachDictionary(dictionary);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isOpen() {
        Object object = this.mutex;
        synchronized (object) {
            return !this.closed;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() throws IOException {
        Object object = this.mutex;
        synchronized (object) {
            super.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read(ByteBuffer dst) throws IOException {
        Object object = this.mutex;
        synchronized (object) {
            if (this.closed) {
                throw new ClosedChannelException();
            }
            int result = 0;
            while (dst.hasRemaining()) {
                int outputSize = this.decode();
                if (outputSize <= 0) {
                    return result == 0 ? outputSize : result;
                }
                result += this.consume(dst);
            }
            return result;
        }
    }
}


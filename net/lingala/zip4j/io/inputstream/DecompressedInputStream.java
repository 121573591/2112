/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.PushbackInputStream
 *  java.lang.Object
 */
package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import net.lingala.zip4j.io.inputstream.CipherInputStream;

abstract class DecompressedInputStream
extends InputStream {
    private CipherInputStream<?> cipherInputStream;
    protected byte[] oneByteBuffer = new byte[1];

    public DecompressedInputStream(CipherInputStream<?> cipherInputStream) {
        this.cipherInputStream = cipherInputStream;
    }

    public int read() throws IOException {
        int readLen = this.read(this.oneByteBuffer);
        if (readLen == -1) {
            return -1;
        }
        return this.oneByteBuffer[0];
    }

    public int read(byte[] b) throws IOException {
        return this.read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return this.cipherInputStream.read(b, off, len);
    }

    public void close() throws IOException {
        this.cipherInputStream.close();
    }

    public void endOfEntryReached(InputStream inputStream2, int numberOfBytesPushedBack) throws IOException {
        this.cipherInputStream.endOfEntryReached(inputStream2, numberOfBytesPushedBack);
    }

    public int pushBackInputStreamIfNecessary(PushbackInputStream pushbackInputStream) throws IOException {
        return 0;
    }

    protected byte[] getLastReadRawDataCache() {
        return this.cipherInputStream.getLastReadRawDataCache();
    }
}


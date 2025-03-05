/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package org.apache.commons.io.output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.AbstractByteArrayOutputStream;

public final class UnsynchronizedByteArrayOutputStream
extends AbstractByteArrayOutputStream {
    public UnsynchronizedByteArrayOutputStream() {
        this(1024);
    }

    public UnsynchronizedByteArrayOutputStream(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Negative initial size: " + size);
        }
        this.needNewBuffer(size);
    }

    @Override
    public void write(byte[] b, int off, int len) {
        if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
            throw new IndexOutOfBoundsException(String.format((String)"offset=%,d, length=%,d", (Object[])new Object[]{off, len}));
        }
        if (len == 0) {
            return;
        }
        this.writeImpl(b, off, len);
    }

    @Override
    public void write(int b) {
        this.writeImpl(b);
    }

    @Override
    public int write(InputStream in) throws IOException {
        return this.writeImpl(in);
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public void reset() {
        this.resetImpl();
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
        this.writeToImpl(out);
    }

    public static InputStream toBufferedInputStream(InputStream input) throws IOException {
        return UnsynchronizedByteArrayOutputStream.toBufferedInputStream(input, 1024);
    }

    public static InputStream toBufferedInputStream(InputStream input, int size) throws IOException {
        try (UnsynchronizedByteArrayOutputStream output = new UnsynchronizedByteArrayOutputStream(size);){
            output.write(input);
            InputStream inputStream2 = output.toInputStream();
            return inputStream2;
        }
    }

    @Override
    public InputStream toInputStream() {
        return this.toInputStream(UnsynchronizedByteArrayInputStream::new);
    }

    @Override
    public byte[] toByteArray() {
        return this.toByteArrayImpl();
    }
}


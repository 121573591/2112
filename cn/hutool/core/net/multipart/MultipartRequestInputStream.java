/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.nio.charset.Charset
 */
package cn.hutool.core.net.multipart;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.net.multipart.UploadFileHeader;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class MultipartRequestInputStream
extends BufferedInputStream {
    protected byte[] boundary;
    protected UploadFileHeader lastHeader;

    public MultipartRequestInputStream(InputStream in) {
        super(in);
    }

    public byte readByte() throws IOException {
        int i = super.read();
        if (i == -1) {
            throw new IOException("End of HTTP request stream reached");
        }
        return (byte)i;
    }

    public void skipBytes(long i) throws IOException {
        long len = super.skip(i);
        if (len != i) {
            throw new IOException("Unable to skip data in HTTP request");
        }
    }

    public byte[] readBoundary() throws IOException {
        byte b;
        ByteArrayOutputStream boundaryOutput = new ByteArrayOutputStream(1024);
        while ((b = this.readByte()) <= 32) {
        }
        boundaryOutput.write((int)b);
        while ((b = this.readByte()) != 13) {
            boundaryOutput.write((int)b);
        }
        if (boundaryOutput.size() == 0) {
            throw new IOException("Problems with parsing request: invalid boundary");
        }
        this.skipBytes(1L);
        this.boundary = new byte[boundaryOutput.size() + 2];
        System.arraycopy((Object)boundaryOutput.toByteArray(), (int)0, (Object)this.boundary, (int)2, (int)(this.boundary.length - 2));
        this.boundary[0] = 13;
        this.boundary[1] = 10;
        return this.boundary;
    }

    public UploadFileHeader getLastHeader() {
        return this.lastHeader;
    }

    public UploadFileHeader readDataHeader(Charset encoding) throws IOException {
        String dataHeader = this.readDataHeaderString(encoding);
        this.lastHeader = dataHeader != null ? new UploadFileHeader(dataHeader) : null;
        return this.lastHeader;
    }

    protected String readDataHeaderString(Charset charset) throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        while (true) {
            byte b;
            if ((b = this.readByte()) != 13) {
                data.write((int)b);
                continue;
            }
            this.mark(4);
            this.skipBytes(1L);
            int i = this.read();
            if (i == -1) {
                return null;
            }
            if (i == 13) break;
            this.reset();
            data.write((int)b);
        }
        this.reset();
        this.skipBytes(3L);
        return charset == null ? data.toString() : data.toString(charset.name());
    }

    public String readString(Charset charset) throws IOException {
        FastByteArrayOutputStream out = new FastByteArrayOutputStream();
        this.copy(out);
        return out.toString(charset);
    }

    public long copy(OutputStream out) throws IOException {
        byte b;
        long count = 0L;
        while (!this.isBoundary(b = this.readByte())) {
            out.write((int)b);
            ++count;
        }
        return count;
    }

    public long copy(OutputStream out, long limit) throws IOException {
        byte b;
        long count = 0L;
        while (!this.isBoundary(b = this.readByte())) {
            out.write((int)b);
            if (++count <= limit) continue;
            break;
        }
        return count;
    }

    public long skipToBoundary() throws IOException {
        byte b;
        long count = 0L;
        do {
            b = this.readByte();
            ++count;
        } while (!this.isBoundary(b));
        return count;
    }

    public boolean isBoundary(byte b) throws IOException {
        int boundaryLen = this.boundary.length;
        this.mark(boundaryLen + 1);
        int bpos = 0;
        while (b == this.boundary[bpos]) {
            b = this.readByte();
            if (++bpos != boundaryLen) continue;
            return true;
        }
        this.reset();
        return false;
    }
}


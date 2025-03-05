/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.DataOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package org.tritonus.share.sampled.file;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.tritonus.share.sampled.file.TDataOutputStream;

public class TNonSeekableDataOutputStream
extends DataOutputStream
implements TDataOutputStream {
    public TNonSeekableDataOutputStream(OutputStream outputStream2) {
        super(outputStream2);
    }

    public boolean supportsSeek() {
        return false;
    }

    public void seek(long position) throws IOException {
        throw new IllegalArgumentException("TNonSeekableDataOutputStream: Call to seek not allowed.");
    }

    public long getFilePointer() throws IOException {
        throw new IllegalArgumentException("TNonSeekableDataOutputStream: Call to getFilePointer not allowed.");
    }

    public long length() throws IOException {
        throw new IllegalArgumentException("TNonSeekableDataOutputStream: Call to length not allowed.");
    }

    public void writeLittleEndian32(int value) throws IOException {
        this.writeByte(value & 0xFF);
        this.writeByte(value >> 8 & 0xFF);
        this.writeByte(value >> 16 & 0xFF);
        this.writeByte(value >> 24 & 0xFF);
    }

    public void writeLittleEndian16(short value) throws IOException {
        this.writeByte(value & 0xFF);
        this.writeByte(value >> 8 & 0xFF);
    }
}


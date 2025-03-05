/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.RandomAccessFile
 *  java.lang.Object
 */
package org.tritonus.share.sampled.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.tritonus.share.sampled.file.TDataOutputStream;

public class TSeekableDataOutputStream
extends RandomAccessFile
implements TDataOutputStream {
    public TSeekableDataOutputStream(File file) throws IOException {
        super(file, "rw");
    }

    public boolean supportsSeek() {
        return true;
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


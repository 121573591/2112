/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.DataOutput
 *  java.io.IOException
 *  java.lang.Object
 */
package org.tritonus.share.sampled.file;

import java.io.DataOutput;
import java.io.IOException;

public interface TDataOutputStream
extends DataOutput {
    public boolean supportsSeek();

    public void seek(long var1) throws IOException;

    public long getFilePointer() throws IOException;

    public long length() throws IOException;

    public void writeLittleEndian32(int var1) throws IOException;

    public void writeLittleEndian16(short var1) throws IOException;

    public void close() throws IOException;
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.io.copy;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.io.copy.IoCopier;
import cn.hutool.core.lang.Assert;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamCopier
extends IoCopier<InputStream, OutputStream> {
    public StreamCopier() {
        this(8192);
    }

    public StreamCopier(int bufferSize) {
        this(bufferSize, -1L);
    }

    public StreamCopier(int bufferSize, long count) {
        this(bufferSize, count, null);
    }

    public StreamCopier(int bufferSize, long count, StreamProgress progress) {
        super(bufferSize, count, progress);
    }

    @Override
    public long copy(InputStream source2, OutputStream target) {
        long size;
        Assert.notNull(source2, "InputStream is null !", new Object[0]);
        Assert.notNull(target, "OutputStream is null !", new Object[0]);
        StreamProgress progress = this.progress;
        if (null != progress) {
            progress.start();
        }
        try {
            size = this.doCopy(source2, target, new byte[this.bufferSize(this.count)], progress);
            target.flush();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        if (null != progress) {
            progress.finish();
        }
        return size;
    }

    private long doCopy(InputStream source2, OutputStream target, byte[] buffer, StreamProgress progress) throws IOException {
        int read;
        long numToRead = this.count > 0L ? this.count : Long.MAX_VALUE;
        long total = 0L;
        while (numToRead > 0L && (read = source2.read(buffer, 0, this.bufferSize(numToRead))) >= 0) {
            target.write(buffer, 0, read);
            if (this.flushEveryBuffer) {
                target.flush();
            }
            numToRead -= (long)read;
            total += (long)read;
            if (null == progress) continue;
            progress.progress(this.count, total);
        }
        return total;
    }
}


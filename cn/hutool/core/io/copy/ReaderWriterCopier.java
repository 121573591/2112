/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.Writer
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
import java.io.Reader;
import java.io.Writer;

public class ReaderWriterCopier
extends IoCopier<Reader, Writer> {
    public ReaderWriterCopier() {
        this(8192);
    }

    public ReaderWriterCopier(int bufferSize) {
        this(bufferSize, -1L);
    }

    public ReaderWriterCopier(int bufferSize, long count) {
        this(bufferSize, count, null);
    }

    public ReaderWriterCopier(int bufferSize, long count, StreamProgress progress) {
        super(bufferSize, count, progress);
    }

    @Override
    public long copy(Reader source2, Writer target) {
        long size;
        Assert.notNull(source2, "InputStream is null !", new Object[0]);
        Assert.notNull(target, "OutputStream is null !", new Object[0]);
        StreamProgress progress = this.progress;
        if (null != progress) {
            progress.start();
        }
        try {
            size = this.doCopy(source2, target, new char[this.bufferSize(this.count)], progress);
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

    private long doCopy(Reader source2, Writer target, char[] buffer, StreamProgress progress) throws IOException {
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


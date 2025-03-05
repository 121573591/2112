/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.nio.ByteBuffer
 *  java.nio.channels.ReadableByteChannel
 *  java.nio.channels.WritableByteChannel
 */
package cn.hutool.core.io.copy;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.io.copy.IoCopier;
import cn.hutool.core.lang.Assert;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class ChannelCopier
extends IoCopier<ReadableByteChannel, WritableByteChannel> {
    public ChannelCopier() {
        this(8192);
    }

    public ChannelCopier(int bufferSize) {
        this(bufferSize, -1L);
    }

    public ChannelCopier(int bufferSize, long count) {
        this(bufferSize, count, null);
    }

    public ChannelCopier(int bufferSize, long count, StreamProgress progress) {
        super(bufferSize, count, progress);
    }

    @Override
    public long copy(ReadableByteChannel source2, WritableByteChannel target) {
        long size;
        Assert.notNull(source2, "InputStream is null !", new Object[0]);
        Assert.notNull(target, "OutputStream is null !", new Object[0]);
        StreamProgress progress = this.progress;
        if (null != progress) {
            progress.start();
        }
        try {
            size = this.doCopy(source2, target, ByteBuffer.allocate((int)this.bufferSize(this.count)), progress);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        if (null != progress) {
            progress.finish();
        }
        return size;
    }

    private long doCopy(ReadableByteChannel source2, WritableByteChannel target, ByteBuffer buffer, StreamProgress progress) throws IOException {
        int read;
        long numToRead = this.count > 0L ? this.count : Long.MAX_VALUE;
        long total = 0L;
        while (numToRead > 0L && (read = source2.read(buffer)) >= 0) {
            buffer.flip();
            target.write(buffer);
            buffer.clear();
            numToRead -= (long)read;
            total += (long)read;
            if (null == progress) continue;
            progress.progress(this.count, total);
        }
        return total;
    }
}


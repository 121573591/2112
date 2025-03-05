/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.channels.SeekableByteChannel
 *  org.apache.commons.compress.archivers.sevenz.SevenZOutputFile
 *  org.apache.commons.compress.utils.SeekableInMemoryByteChannel
 */
package cn.hutool.extra.compress.archiver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.compress.archiver.Archiver;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.utils.SeekableInMemoryByteChannel;

public class SevenZArchiver
implements Archiver {
    private final SevenZOutputFile sevenZOutputFile;
    private SeekableByteChannel channel;
    private OutputStream out;

    public SevenZArchiver(File file) {
        try {
            this.sevenZOutputFile = new SevenZOutputFile(file);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public SevenZArchiver(OutputStream out) {
        this.out = out;
        this.channel = new SeekableInMemoryByteChannel();
        try {
            this.sevenZOutputFile = new SevenZOutputFile(this.channel);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public SevenZArchiver(SeekableByteChannel channel) {
        try {
            this.sevenZOutputFile = new SevenZOutputFile(channel);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public SevenZOutputFile getSevenZOutputFile() {
        return this.sevenZOutputFile;
    }

    @Override
    public SevenZArchiver add(File file, String path, Filter<File> filter) {
        try {
            this.addInternal(file, path, filter);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    @Override
    public SevenZArchiver finish() {
        try {
            this.sevenZOutputFile.finish();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    @Override
    public void close() {
        try {
            this.finish();
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (null != this.out && this.channel instanceof SeekableInMemoryByteChannel) {
            try {
                this.out.write(((SeekableInMemoryByteChannel)this.channel).array());
            }
            catch (IOException e) {
                throw new IORuntimeException(e);
            }
        }
        IoUtil.close((Closeable)this.sevenZOutputFile);
    }

    private void addInternal(File file, String path, Filter<File> filter) throws IOException {
        if (null != filter && !filter.accept(file)) {
            return;
        }
        SevenZOutputFile out = this.sevenZOutputFile;
        String entryName = StrUtil.isNotEmpty(path) ? StrUtil.addSuffixIfNot(path, "/") + file.getName() : file.getName();
        out.putArchiveEntry(out.createArchiveEntry(file, entryName));
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (ArrayUtil.isNotEmpty(files)) {
                for (File childFile : files) {
                    this.addInternal(childFile, entryName, filter);
                }
            }
        } else {
            if (file.isFile()) {
                out.write(FileUtil.readBytes(file));
            }
            out.closeArchiveEntry();
        }
    }
}


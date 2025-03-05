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
 *  java.nio.charset.Charset
 *  org.apache.commons.compress.archivers.ArchiveException
 *  org.apache.commons.compress.archivers.ArchiveOutputStream
 *  org.apache.commons.compress.archivers.ArchiveStreamFactory
 *  org.apache.commons.compress.archivers.ar.ArArchiveOutputStream
 *  org.apache.commons.compress.archivers.tar.TarArchiveOutputStream
 *  org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream
 */
package cn.hutool.extra.compress.archiver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.compress.CompressException;
import cn.hutool.extra.compress.archiver.Archiver;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.ar.ArArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

public class StreamArchiver
implements Archiver {
    private final ArchiveOutputStream out;

    public static StreamArchiver create(Charset charset, String archiverName, File file) {
        return new StreamArchiver(charset, archiverName, file);
    }

    public static StreamArchiver create(Charset charset, String archiverName, OutputStream out) {
        return new StreamArchiver(charset, archiverName, out);
    }

    public StreamArchiver(Charset charset, String archiverName, File file) {
        this(charset, archiverName, (OutputStream)FileUtil.getOutputStream(file));
    }

    public StreamArchiver(Charset charset, String archiverName, OutputStream targetStream) {
        if ("tgz".equalsIgnoreCase(archiverName) || "tar.gz".equalsIgnoreCase(archiverName)) {
            try {
                this.out = new TarArchiveOutputStream((OutputStream)new GzipCompressorOutputStream(targetStream));
            }
            catch (IOException e) {
                throw new IORuntimeException(e);
            }
        }
        ArchiveStreamFactory factory2 = new ArchiveStreamFactory(charset.name());
        try {
            this.out = factory2.createArchiveOutputStream(archiverName, targetStream);
        }
        catch (ArchiveException e) {
            throw new CompressException(e);
        }
        if (this.out instanceof TarArchiveOutputStream) {
            ((TarArchiveOutputStream)this.out).setLongFileMode(2);
        } else if (this.out instanceof ArArchiveOutputStream) {
            ((ArArchiveOutputStream)this.out).setLongFileMode(1);
        }
    }

    @Override
    public StreamArchiver add(File file, String path, Filter<File> filter) throws IORuntimeException {
        try {
            this.addInternal(file, path, filter);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    @Override
    public StreamArchiver finish() {
        try {
            this.out.finish();
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
        IoUtil.close((Closeable)this.out);
    }

    private void addInternal(File file, String path, Filter<File> filter) throws IOException {
        if (null != filter && !filter.accept(file)) {
            return;
        }
        ArchiveOutputStream out = this.out;
        String entryName = StrUtil.isNotEmpty(path) ? StrUtil.addSuffixIfNot(path, "/") + file.getName() : file.getName();
        out.putArchiveEntry(out.createArchiveEntry(file, entryName));
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (ArrayUtil.isNotEmpty(files)) {
                for (File childFile : files) {
                    this.addInternal(childFile, entryName, filter);
                }
            } else {
                out.closeArchiveEntry();
            }
        } else {
            if (file.isFile()) {
                FileUtil.writeToStream(file, (OutputStream)out);
            }
            out.closeArchiveEntry();
        }
    }
}


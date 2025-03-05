/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipOutputStream
 */
package cn.hutool.core.compress;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter
implements Closeable {
    private final ZipOutputStream out;

    public static ZipWriter of(File zipFile, Charset charset) {
        return new ZipWriter(zipFile, charset);
    }

    public static ZipWriter of(OutputStream out, Charset charset) {
        return new ZipWriter(out, charset);
    }

    public ZipWriter(File zipFile, Charset charset) {
        this.out = ZipWriter.getZipOutputStream(zipFile, charset);
    }

    public ZipWriter(OutputStream out, Charset charset) {
        this.out = ZipUtil.getZipOutputStream(out, charset);
    }

    public ZipWriter(ZipOutputStream out) {
        this.out = out;
    }

    public ZipWriter setLevel(int level) {
        this.out.setLevel(level);
        return this;
    }

    public ZipWriter setComment(String comment) {
        this.out.setComment(comment);
        return this;
    }

    public ZipOutputStream getOut() {
        return this.out;
    }

    public ZipWriter add(boolean withSrcDir, FileFilter filter, File ... files) throws IORuntimeException {
        for (File file : files) {
            String srcRootDir;
            try {
                srcRootDir = file.getCanonicalPath();
                if (!file.isDirectory() || withSrcDir) {
                    srcRootDir = file.getCanonicalFile().getParentFile().getCanonicalPath();
                }
            }
            catch (IOException e) {
                throw new IORuntimeException(e);
            }
            this._add(file, srcRootDir, filter);
        }
        return this;
    }

    public ZipWriter add(Resource ... resources) throws IORuntimeException {
        for (Resource resource : resources) {
            if (null == resource) continue;
            this.add(resource.getName(), resource.getStream());
        }
        return this;
    }

    public ZipWriter add(String path, InputStream in) throws IORuntimeException {
        path = StrUtil.nullToEmpty(path);
        if (null == in && StrUtil.isBlank(path = StrUtil.addSuffixIfNot(path, "/"))) {
            return this;
        }
        return this.putEntry(path, in);
    }

    public ZipWriter add(String[] paths, InputStream[] ins) throws IORuntimeException {
        if (ArrayUtil.isEmpty(paths) || ArrayUtil.isEmpty(ins)) {
            throw new IllegalArgumentException("Paths or ins is empty !");
        }
        if (paths.length != ins.length) {
            throw new IllegalArgumentException("Paths length is not equals to ins length !");
        }
        for (int i = 0; i < paths.length; ++i) {
            this.add(paths[i], ins[i]);
        }
        return this;
    }

    public void close() throws IORuntimeException {
        try {
            this.out.finish();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            IoUtil.close((Closeable)this.out);
        }
    }

    private static ZipOutputStream getZipOutputStream(File zipFile, Charset charset) {
        return ZipUtil.getZipOutputStream((OutputStream)FileUtil.getOutputStream(zipFile), charset);
    }

    private ZipWriter _add(File file, String srcRootDir, FileFilter filter) throws IORuntimeException {
        if (null == file || null != filter && !filter.accept(file)) {
            return this;
        }
        String subPath = FileUtil.subPath(srcRootDir, file);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (ArrayUtil.isEmpty(files)) {
                this.add(subPath, null);
            } else {
                for (File childFile : files) {
                    this._add(childFile, srcRootDir, filter);
                }
            }
        } else {
            this.putEntry(subPath, (InputStream)FileUtil.getInputStream(file));
        }
        return this;
    }

    private ZipWriter putEntry(String path, InputStream in) throws IORuntimeException {
        try {
            this.out.putNextEntry(new ZipEntry(path));
            if (null != in) {
                IoUtil.copy(in, (OutputStream)this.out);
            }
            this.out.closeEntry();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            IoUtil.close((Closeable)in);
        }
        IoUtil.flush((Flushable)this.out);
        return this;
    }
}


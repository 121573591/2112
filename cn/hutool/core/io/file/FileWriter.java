/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedOutputStream
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.OutputStreamWriter
 *  java.io.PrintWriter
 *  java.io.Writer
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.nio.file.Files
 *  java.nio.file.OpenOption
 *  java.nio.file.Path
 *  java.util.Map
 *  java.util.Map$Entry
 */
package cn.hutool.core.io.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileWrapper;
import cn.hutool.core.io.file.LineSeparator;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Map;

public class FileWriter
extends FileWrapper {
    private static final long serialVersionUID = 1L;

    public static FileWriter create(File file, Charset charset) {
        return new FileWriter(file, charset);
    }

    public static FileWriter create(File file) {
        return new FileWriter(file);
    }

    public FileWriter(File file, Charset charset) {
        super(file, charset);
        this.checkFile();
    }

    public FileWriter(File file, String charset) {
        this(file, CharsetUtil.charset(charset));
    }

    public FileWriter(String filePath, Charset charset) {
        this(FileUtil.file(filePath), charset);
    }

    public FileWriter(String filePath, String charset) {
        this(FileUtil.file(filePath), CharsetUtil.charset(charset));
    }

    public FileWriter(File file) {
        this(file, DEFAULT_CHARSET);
    }

    public FileWriter(String filePath) {
        this(filePath, DEFAULT_CHARSET);
    }

    public File write(String content, boolean isAppend) throws IORuntimeException {
        BufferedWriter writer = null;
        try {
            writer = this.getWriter(isAppend);
            writer.write(content);
            writer.flush();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            IoUtil.close((Closeable)writer);
        }
        return this.file;
    }

    public File write(String content) throws IORuntimeException {
        return this.write(content, false);
    }

    public File append(String content) throws IORuntimeException {
        return this.write(content, true);
    }

    public <T> File writeLines(Iterable<T> list) throws IORuntimeException {
        return this.writeLines(list, false);
    }

    public <T> File appendLines(Iterable<T> list) throws IORuntimeException {
        return this.writeLines(list, true);
    }

    public <T> File writeLines(Iterable<T> list, boolean isAppend) throws IORuntimeException {
        return this.writeLines(list, null, isAppend);
    }

    public <T> File writeLines(Iterable<T> list, LineSeparator lineSeparator, boolean isAppend) throws IORuntimeException {
        try (PrintWriter writer = this.getPrintWriter(isAppend);){
            boolean isFirst = true;
            for (Object t : list) {
                if (null == t) continue;
                if (isFirst) {
                    isFirst = false;
                    if (isAppend && FileUtil.isNotEmpty(this.file)) {
                        this.printNewLine(writer, lineSeparator);
                    }
                } else {
                    this.printNewLine(writer, lineSeparator);
                }
                writer.print(t);
                writer.flush();
            }
        }
        return this.file;
    }

    public File writeMap(Map<?, ?> map, String kvSeparator, boolean isAppend) throws IORuntimeException {
        return this.writeMap(map, null, kvSeparator, isAppend);
    }

    public File writeMap(Map<?, ?> map, LineSeparator lineSeparator, String kvSeparator, boolean isAppend) throws IORuntimeException {
        if (null == kvSeparator) {
            kvSeparator = " = ";
        }
        try (PrintWriter writer = this.getPrintWriter(isAppend);){
            for (Map.Entry entry : map.entrySet()) {
                if (null == entry) continue;
                writer.print(StrUtil.format("{}{}{}", entry.getKey(), kvSeparator, entry.getValue()));
                this.printNewLine(writer, lineSeparator);
                writer.flush();
            }
        }
        return this.file;
    }

    public File write(byte[] data, int off, int len) throws IORuntimeException {
        return this.write(data, off, len, false);
    }

    public File append(byte[] data, int off, int len) throws IORuntimeException {
        return this.write(data, off, len, true);
    }

    public File write(byte[] data, int off, int len, boolean isAppend) throws IORuntimeException {
        try (FileOutputStream out = new FileOutputStream(FileUtil.touch(this.file), isAppend);){
            out.write(data, off, len);
            out.flush();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this.file;
    }

    public File writeFromStream(InputStream in) throws IORuntimeException {
        return this.writeFromStream(in, true);
    }

    public File writeFromStream(InputStream in, boolean isCloseIn) throws IORuntimeException {
        OutputStream out = null;
        try {
            out = Files.newOutputStream((Path)FileUtil.touch(this.file).toPath(), (OpenOption[])new OpenOption[0]);
            IoUtil.copy(in, out);
        }
        catch (IOException e) {
            try {
                throw new IORuntimeException(e);
            }
            catch (Throwable throwable) {
                IoUtil.close(out);
                if (isCloseIn) {
                    IoUtil.close((Closeable)in);
                }
                throw throwable;
            }
        }
        IoUtil.close((Closeable)out);
        if (isCloseIn) {
            IoUtil.close((Closeable)in);
        }
        return this.file;
    }

    public BufferedOutputStream getOutputStream() throws IORuntimeException {
        try {
            return new BufferedOutputStream(Files.newOutputStream((Path)FileUtil.touch(this.file).toPath(), (OpenOption[])new OpenOption[0]));
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public BufferedWriter getWriter(boolean isAppend) throws IORuntimeException {
        try {
            return new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(FileUtil.touch(this.file), isAppend), this.charset));
        }
        catch (Exception e) {
            throw new IORuntimeException(e);
        }
    }

    public PrintWriter getPrintWriter(boolean isAppend) throws IORuntimeException {
        return new PrintWriter((Writer)this.getWriter(isAppend));
    }

    private void checkFile() throws IORuntimeException {
        Assert.notNull(this.file, "File to write content is null !", new Object[0]);
        if (this.file.exists() && !this.file.isFile()) {
            throw new IORuntimeException("File [{}] is not a file !", this.file.getAbsoluteFile());
        }
    }

    private void printNewLine(PrintWriter writer, LineSeparator lineSeparator) {
        if (null == lineSeparator) {
            writer.println();
        } else {
            writer.print(lineSeparator.getValue());
        }
    }
}


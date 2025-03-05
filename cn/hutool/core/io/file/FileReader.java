/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.BufferedReader
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package cn.hutool.core.io.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.LineHandler;
import cn.hutool.core.io.file.FileWrapper;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileReader
extends FileWrapper {
    private static final long serialVersionUID = 1L;

    public static FileReader create(File file, Charset charset) {
        return new FileReader(file, charset);
    }

    public static FileReader create(File file) {
        return new FileReader(file);
    }

    public FileReader(File file, Charset charset) {
        super(file, charset);
        this.checkFile();
    }

    public FileReader(File file, String charset) {
        this(file, CharsetUtil.charset(charset));
    }

    public FileReader(String filePath, Charset charset) {
        this(FileUtil.file(filePath), charset);
    }

    public FileReader(String filePath, String charset) {
        this(FileUtil.file(filePath), CharsetUtil.charset(charset));
    }

    public FileReader(File file) {
        this(file, DEFAULT_CHARSET);
    }

    public FileReader(String filePath) {
        this(filePath, DEFAULT_CHARSET);
    }

    public byte[] readBytes() throws IORuntimeException {
        long len = this.file.length();
        if (len >= Integer.MAX_VALUE) {
            throw new IORuntimeException("File is larger then max array size");
        }
        byte[] bytes = new byte[(int)len];
        FileInputStream in = null;
        try {
            in = new FileInputStream(this.file);
            int readLength = in.read(bytes);
            if ((long)readLength < len) {
                throw new IOException(StrUtil.format("File length is [{}] but read [{}]!", len, readLength));
            }
        }
        catch (Exception e) {
            try {
                throw new IORuntimeException(e);
            }
            catch (Throwable throwable) {
                IoUtil.close(in);
                throw throwable;
            }
        }
        IoUtil.close((Closeable)in);
        return bytes;
    }

    public String readString() throws IORuntimeException {
        return new String(this.readBytes(), this.charset);
    }

    public <T extends Collection<String>> T readLines(T collection) throws IORuntimeException {
        T t;
        BufferedReader reader = null;
        try {
            String line;
            reader = FileUtil.getReader(this.file, this.charset);
            while ((line = reader.readLine()) != null) {
                collection.add((Object)line);
            }
            t = collection;
        }
        catch (IOException e) {
            try {
                throw new IORuntimeException(e);
            }
            catch (Throwable throwable) {
                IoUtil.close(reader);
                throw throwable;
            }
        }
        IoUtil.close((Closeable)reader);
        return t;
    }

    public void readLines(LineHandler lineHandler) throws IORuntimeException {
        BufferedReader reader = null;
        try {
            reader = FileUtil.getReader(this.file, this.charset);
            IoUtil.readLines((Reader)reader, lineHandler);
        }
        catch (Throwable throwable) {
            IoUtil.close(reader);
            throw throwable;
        }
        IoUtil.close((Closeable)reader);
    }

    public List<String> readLines() throws IORuntimeException {
        return (List)this.readLines(new ArrayList());
    }

    public <T> T read(ReaderHandler<T> readerHandler) throws IORuntimeException {
        T result;
        BufferedReader reader = null;
        try {
            reader = FileUtil.getReader(this.file, this.charset);
            result = readerHandler.handle(reader);
        }
        catch (IOException e) {
            try {
                throw new IORuntimeException(e);
            }
            catch (Throwable throwable) {
                IoUtil.close(reader);
                throw throwable;
            }
        }
        IoUtil.close((Closeable)reader);
        return result;
    }

    public BufferedReader getReader() throws IORuntimeException {
        return IoUtil.getReader((InputStream)this.getInputStream(), this.charset);
    }

    public BufferedInputStream getInputStream() throws IORuntimeException {
        try {
            return new BufferedInputStream((InputStream)new FileInputStream(this.file));
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public long writeToStream(OutputStream out) throws IORuntimeException {
        return this.writeToStream(out, false);
    }

    /*
     * Exception decompiling
     */
    public long writeToStream(OutputStream out, boolean isCloseOut) throws IORuntimeException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Unknown Source:65)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Unknown Source:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Unknown Source:39)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1424)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void checkFile() throws IORuntimeException {
        if (!this.file.exists()) {
            throw new IORuntimeException("File not exist: " + this.file);
        }
        if (!this.file.isFile()) {
            throw new IORuntimeException("Not a file:" + this.file);
        }
    }

    public static interface ReaderHandler<T> {
        public T handle(BufferedReader var1) throws IOException;
    }
}


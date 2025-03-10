/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedWriter
 *  java.io.Closeable
 *  java.io.File
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.Serializable
 *  java.io.Writer
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.List
 *  java.util.Map
 */
package cn.hutool.core.text.csv;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ArrayIter;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvWriteConfig;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public final class CsvWriter
implements Closeable,
Flushable,
Serializable {
    private static final long serialVersionUID = 1L;
    private final Writer writer;
    private final CsvWriteConfig config;
    private boolean newline = true;
    private boolean isFirstLine = true;

    public CsvWriter(String filePath) {
        this(FileUtil.file(filePath));
    }

    public CsvWriter(File file) {
        this(file, CharsetUtil.CHARSET_UTF_8);
    }

    public CsvWriter(String filePath, Charset charset) {
        this(FileUtil.file(filePath), charset);
    }

    public CsvWriter(File file, Charset charset) {
        this(file, charset, false);
    }

    public CsvWriter(String filePath, Charset charset, boolean isAppend) {
        this(FileUtil.file(filePath), charset, isAppend);
    }

    public CsvWriter(File file, Charset charset, boolean isAppend) {
        this(file, charset, isAppend, null);
    }

    public CsvWriter(String filePath, Charset charset, boolean isAppend, CsvWriteConfig config) {
        this(FileUtil.file(filePath), charset, isAppend, config);
    }

    public CsvWriter(File file, Charset charset, boolean isAppend, CsvWriteConfig config) {
        this((Writer)FileUtil.getWriter(file, charset, isAppend), isAppend ? (config == null ? CsvWriteConfig.defaultConfig().setEndingLineBreak(true) : config.setEndingLineBreak(true)) : config);
    }

    public CsvWriter(Writer writer) {
        this(writer, null);
    }

    public CsvWriter(Writer writer, CsvWriteConfig config) {
        this.writer = writer instanceof BufferedWriter ? writer : new BufferedWriter(writer);
        this.config = ObjectUtil.defaultIfNull(config, CsvWriteConfig::defaultConfig);
    }

    public CsvWriter setAlwaysDelimitText(boolean alwaysDelimitText) {
        this.config.setAlwaysDelimitText(alwaysDelimitText);
        return this;
    }

    public CsvWriter setLineDelimiter(char[] lineDelimiter) {
        this.config.setLineDelimiter(lineDelimiter);
        return this;
    }

    public CsvWriter write(String[] ... lines) throws IORuntimeException {
        return this.write(new ArrayIter((E[])lines));
    }

    public CsvWriter write(Iterable<?> lines) throws IORuntimeException {
        if (CollUtil.isNotEmpty(lines)) {
            for (Object values : lines) {
                this.appendLine(Convert.toStrArray(values));
            }
            this.flush();
        }
        return this;
    }

    public CsvWriter write(CsvData csvData) {
        if (csvData != null) {
            List<String> header = csvData.getHeader();
            if (CollUtil.isNotEmpty(header)) {
                this.writeHeaderLine((String[])header.toArray((Object[])new String[0]));
            }
            this.write((Iterable<?>)csvData.getRows());
            this.flush();
        }
        return this;
    }

    public CsvWriter writeBeans(Iterable<?> beans) {
        if (CollUtil.isNotEmpty(beans)) {
            boolean isFirst = true;
            for (Object bean : beans) {
                Map<String, Object> map = BeanUtil.beanToMap(bean, new String[0]);
                if (isFirst) {
                    this.writeHeaderLine((String[])map.keySet().toArray((Object[])new String[0]));
                    isFirst = false;
                }
                this.writeLine(Convert.toStrArray(map.values()));
            }
            this.flush();
        }
        return this;
    }

    public CsvWriter writeHeaderLine(String ... fields) throws IORuntimeException {
        Map headerAlias = this.config.headerAlias;
        if (MapUtil.isNotEmpty(headerAlias)) {
            for (int i = 0; i < fields.length; ++i) {
                String alias = (String)headerAlias.get((Object)fields[i]);
                if (null == alias) continue;
                fields[i] = alias;
            }
        }
        return this.writeLine(fields);
    }

    public CsvWriter writeLine(String ... fields) throws IORuntimeException {
        if (ArrayUtil.isEmpty(fields)) {
            return this.writeLine();
        }
        this.appendLine(fields);
        return this;
    }

    public CsvWriter writeLine() throws IORuntimeException {
        try {
            this.writer.write(this.config.lineDelimiter);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        this.newline = true;
        return this;
    }

    public CsvWriter writeComment(String comment) {
        Assert.notNull(this.config.commentCharacter, "Comment is disable!", new Object[0]);
        try {
            if (this.isFirstLine) {
                this.isFirstLine = false;
            } else {
                this.writer.write(this.config.lineDelimiter);
            }
            this.writer.write((int)this.config.commentCharacter.charValue());
            this.writer.write(comment);
            this.newline = true;
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    public void close() {
        if (this.config.endingLineBreak) {
            this.writeLine();
        }
        IoUtil.close((Closeable)this.writer);
    }

    public void flush() throws IORuntimeException {
        try {
            this.writer.flush();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    private void appendLine(String ... fields) throws IORuntimeException {
        try {
            this.doAppendLine(fields);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    private void doAppendLine(String ... fields) throws IOException {
        if (null != fields) {
            if (this.isFirstLine) {
                this.isFirstLine = false;
            } else {
                this.writer.write(this.config.lineDelimiter);
            }
            for (String field : fields) {
                this.appendField(field);
            }
            this.newline = true;
        }
    }

    private void appendField(String value) throws IOException {
        boolean alwaysDelimitText = this.config.alwaysDelimitText;
        char textDelimiter = this.config.textDelimiter;
        char fieldSeparator = this.config.fieldSeparator;
        if (!this.newline) {
            this.writer.write((int)fieldSeparator);
        } else {
            this.newline = false;
        }
        if (null == value) {
            if (alwaysDelimitText) {
                this.writer.write(new char[]{textDelimiter, textDelimiter});
            }
            return;
        }
        char[] valueChars = value.toCharArray();
        boolean needsTextDelimiter = alwaysDelimitText;
        boolean containsTextDelimiter = false;
        for (char c : valueChars) {
            if (c == textDelimiter) {
                needsTextDelimiter = true;
                containsTextDelimiter = true;
                break;
            }
            if (c != fieldSeparator && c != '\n' && c != '\r') continue;
            needsTextDelimiter = true;
        }
        if (needsTextDelimiter) {
            this.writer.write((int)textDelimiter);
        }
        if (containsTextDelimiter) {
            for (char c : valueChars) {
                if (c == textDelimiter) {
                    this.writer.write((int)textDelimiter);
                }
                this.writer.write((int)c);
            }
        } else {
            this.writer.write(valueChars);
        }
        if (needsTextDelimiter) {
            this.writer.write((int)textDelimiter);
        }
    }
}


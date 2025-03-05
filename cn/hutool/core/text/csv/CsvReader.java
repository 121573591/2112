/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.Reader
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.nio.charset.Charset
 *  java.nio.file.Path
 *  java.util.Iterator
 *  java.util.Spliterator
 *  java.util.stream.Stream
 *  java.util.stream.StreamSupport
 */
package cn.hutool.core.text.csv;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.text.csv.CsvBaseReader;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReadConfig;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvRowHandler;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CsvReader
extends CsvBaseReader
implements Iterable<CsvRow>,
Closeable {
    private static final long serialVersionUID = 1L;
    private final Reader reader;

    public CsvReader() {
        this(null);
    }

    public CsvReader(CsvReadConfig config) {
        this((Reader)null, config);
    }

    public CsvReader(File file, CsvReadConfig config) {
        this(file, DEFAULT_CHARSET, config);
    }

    public CsvReader(Path path, CsvReadConfig config) {
        this(path, DEFAULT_CHARSET, config);
    }

    public CsvReader(File file, Charset charset, CsvReadConfig config) {
        this((Reader)FileUtil.getReader(file, charset), config);
    }

    public CsvReader(Path path, Charset charset, CsvReadConfig config) {
        this((Reader)FileUtil.getReader(path, charset), config);
    }

    public CsvReader(Reader reader, CsvReadConfig config) {
        super(config);
        this.reader = reader;
    }

    public CsvData read() throws IORuntimeException {
        return this.read(this.reader, false);
    }

    public void read(CsvRowHandler rowHandler) throws IORuntimeException {
        this.read(this.reader, false, rowHandler);
    }

    public Stream<CsvRow> stream() {
        return (Stream)StreamSupport.stream((Spliterator)this.spliterator(), (boolean)false).onClose(() -> {
            try {
                this.close();
            }
            catch (IOException e) {
                throw new IORuntimeException(e);
            }
        });
    }

    public Iterator<CsvRow> iterator() {
        return this.parse(this.reader);
    }

    public void close() throws IOException {
        IoUtil.close((Closeable)this.reader);
    }
}


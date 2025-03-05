/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.charset.Charset
 *  org.apache.commons.compress.archivers.ArchiveEntry
 *  org.apache.commons.compress.archivers.ArchiveException
 *  org.apache.commons.compress.archivers.ArchiveInputStream
 *  org.apache.commons.compress.archivers.ArchiveStreamFactory
 *  org.apache.commons.compress.archivers.tar.TarArchiveInputStream
 *  org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream
 */
package cn.hutool.extra.compress.extractor;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.compress.CompressException;
import cn.hutool.extra.compress.extractor.Extractor;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

public class StreamExtractor
implements Extractor {
    private final ArchiveInputStream in;

    public StreamExtractor(Charset charset, File file) {
        this(charset, null, file);
    }

    public StreamExtractor(Charset charset, String archiverName, File file) {
        this(charset, archiverName, (InputStream)FileUtil.getInputStream(file));
    }

    public StreamExtractor(Charset charset, InputStream in) {
        this(charset, null, in);
    }

    public StreamExtractor(Charset charset, String archiverName, InputStream in) {
        block7: {
            if (in instanceof ArchiveInputStream) {
                this.in = (ArchiveInputStream)in;
                return;
            }
            ArchiveStreamFactory factory2 = new ArchiveStreamFactory(charset.name());
            try {
                in = IoUtil.toBuffered(in);
                if (StrUtil.isBlank(archiverName)) {
                    this.in = factory2.createArchiveInputStream(in);
                    break block7;
                }
                if ("tgz".equalsIgnoreCase(archiverName) || "tar.gz".equalsIgnoreCase(archiverName)) {
                    try {
                        this.in = new TarArchiveInputStream((InputStream)new GzipCompressorInputStream(in));
                        break block7;
                    }
                    catch (IOException e) {
                        throw new IORuntimeException(e);
                    }
                }
                this.in = factory2.createArchiveInputStream(archiverName, in);
            }
            catch (ArchiveException e) {
                IoUtil.close((Closeable)in);
                throw new CompressException(e);
            }
        }
    }

    @Override
    public void extract(File targetDir, int stripComponents, Filter<ArchiveEntry> filter) {
        try {
            this.extractInternal(targetDir, stripComponents, filter);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        finally {
            this.close();
        }
    }

    private void extractInternal(File targetDir, int stripComponents, Filter<ArchiveEntry> filter) throws IOException {
        ArchiveEntry entry;
        Assert.isTrue(null != targetDir && (false == targetDir.exists() || targetDir.isDirectory()), "target must be dir.", new Object[0]);
        ArchiveInputStream in = this.in;
        while (null != (entry = in.getNextEntry())) {
            String entryName;
            if (null != filter && !filter.accept(entry) || !in.canReadEntryData(entry) || (entryName = this.stripName(entry.getName(), stripComponents)) == null) continue;
            File outItemFile = FileUtil.file(targetDir, entryName);
            if (entry.isDirectory()) {
                outItemFile.mkdirs();
                continue;
            }
            FileUtil.writeFromStream((InputStream)in, outItemFile, false);
        }
    }

    @Override
    public void close() {
        IoUtil.close((Closeable)this.in);
    }
}


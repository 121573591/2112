/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.util.zip.GZIPInputStream
 *  java.util.zip.GZIPOutputStream
 */
package cn.hutool.core.compress;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Gzip
implements Closeable {
    private InputStream source;
    private OutputStream target;

    public static Gzip of(InputStream source2, OutputStream target) {
        return new Gzip(source2, target);
    }

    public Gzip(InputStream source2, OutputStream target) {
        this.source = source2;
        this.target = target;
    }

    public OutputStream getTarget() {
        return this.target;
    }

    public Gzip gzip() {
        try {
            this.target = this.target instanceof GZIPOutputStream ? (GZIPOutputStream)this.target : new GZIPOutputStream(this.target);
            IoUtil.copy(this.source, this.target);
            ((GZIPOutputStream)this.target).finish();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    public Gzip unGzip() {
        try {
            this.source = this.source instanceof GZIPInputStream ? (GZIPInputStream)this.source : new GZIPInputStream(this.source);
            IoUtil.copy(this.source, this.target);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    public void close() {
        IoUtil.close((Closeable)this.target);
        IoUtil.close((Closeable)this.source);
    }
}


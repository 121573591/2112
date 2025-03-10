/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.FilterOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Object
 */
package org.apache.commons.io.output;

import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;

public class ProxyOutputStream
extends FilterOutputStream {
    public ProxyOutputStream(OutputStream proxy) {
        super(proxy);
    }

    public void write(int idx) throws IOException {
        try {
            this.beforeWrite(1);
            this.out.write(idx);
            this.afterWrite(1);
        }
        catch (IOException e) {
            this.handleIOException(e);
        }
    }

    public void write(byte[] bts) throws IOException {
        try {
            int len = IOUtils.length(bts);
            this.beforeWrite(len);
            this.out.write(bts);
            this.afterWrite(len);
        }
        catch (IOException e) {
            this.handleIOException(e);
        }
    }

    public void write(byte[] bts, int st, int end) throws IOException {
        try {
            this.beforeWrite(end);
            this.out.write(bts, st, end);
            this.afterWrite(end);
        }
        catch (IOException e) {
            this.handleIOException(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.out.flush();
        }
        catch (IOException e) {
            this.handleIOException(e);
        }
    }

    public void close() throws IOException {
        IOUtils.close((Closeable)this.out, this::handleIOException);
    }

    protected void beforeWrite(int n) throws IOException {
    }

    protected void afterWrite(int n) throws IOException {
    }

    protected void handleIOException(IOException e) throws IOException {
        throw e;
    }
}


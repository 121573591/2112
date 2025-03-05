/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpCookie
 *  java.nio.charset.Charset
 *  java.util.List
 *  java.util.Map$Entry
 */
package cn.hutool.http;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.io.resource.BytesResource;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpBase;
import cn.hutool.http.HttpConfig;
import cn.hutool.http.HttpConnection;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpInputStream;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.cookie.GlobalCookieManager;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class HttpResponse
extends HttpBase<HttpResponse>
implements Closeable {
    protected HttpConfig config;
    protected HttpConnection httpConnection;
    protected InputStream in;
    private volatile boolean isAsync;
    protected int status;
    private final boolean ignoreBody;
    private Charset charsetFromResponse;

    protected HttpResponse(HttpConnection httpConnection, HttpConfig config, Charset charset, boolean isAsync, boolean isIgnoreBody) {
        this.httpConnection = httpConnection;
        this.config = config;
        this.charset = charset;
        this.isAsync = isAsync;
        this.ignoreBody = isIgnoreBody;
        this.initWithDisconnect();
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isOk() {
        return this.status >= 200 && this.status < 300;
    }

    public HttpResponse sync() {
        return this.isAsync ? this.forceSync() : this;
    }

    public String contentEncoding() {
        return this.header(Header.CONTENT_ENCODING);
    }

    public long contentLength() {
        long contentLength = Convert.toLong(this.header(Header.CONTENT_LENGTH), -1L);
        if (contentLength > 0L && (this.isChunked() || StrUtil.isNotBlank(this.contentEncoding()))) {
            contentLength = -1L;
        }
        return contentLength;
    }

    public boolean isGzip() {
        String contentEncoding = this.contentEncoding();
        return "gzip".equalsIgnoreCase(contentEncoding);
    }

    public boolean isDeflate() {
        String contentEncoding = this.contentEncoding();
        return "deflate".equalsIgnoreCase(contentEncoding);
    }

    public boolean isChunked() {
        String transferEncoding = this.header(Header.TRANSFER_ENCODING);
        return "Chunked".equalsIgnoreCase(transferEncoding);
    }

    public String getCookieStr() {
        return this.header(Header.SET_COOKIE);
    }

    public List<HttpCookie> getCookies() {
        return GlobalCookieManager.getCookies(this.httpConnection);
    }

    public HttpCookie getCookie(String name) {
        List<HttpCookie> cookie = this.getCookies();
        if (null != cookie) {
            for (HttpCookie httpCookie : cookie) {
                if (!httpCookie.getName().equals((Object)name)) continue;
                return httpCookie;
            }
        }
        return null;
    }

    public String getCookieValue(String name) {
        HttpCookie cookie = this.getCookie(name);
        return null == cookie ? null : cookie.getValue();
    }

    public InputStream bodyStream() {
        if (this.isAsync) {
            return this.in;
        }
        return null == this.body ? null : this.body.getStream();
    }

    @Override
    public byte[] bodyBytes() {
        this.sync();
        return super.bodyBytes();
    }

    public HttpResponse body(byte[] bodyBytes) {
        this.sync();
        if (null != bodyBytes) {
            this.body = new BytesResource(bodyBytes);
        }
        return this;
    }

    public String body() throws HttpException {
        return HttpUtil.getString(this.bodyBytes(), this.charset, null == this.charsetFromResponse);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long writeBody(OutputStream out, boolean isCloseOut, StreamProgress streamProgress) {
        Assert.notNull(out, "[out] must be not null!", new Object[0]);
        long contentLength = this.contentLength();
        try {
            long l = HttpResponse.copyBody(this.bodyStream(), out, contentLength, streamProgress, this.config.ignoreEOFError);
            return l;
        }
        finally {
            IoUtil.close(this);
            if (isCloseOut) {
                IoUtil.close((Closeable)out);
            }
        }
    }

    public long writeBody(File targetFileOrDir, StreamProgress streamProgress) {
        Assert.notNull(targetFileOrDir, "[targetFileOrDir] must be not null!", new Object[0]);
        File outFile = this.completeFileNameFromHeader(targetFileOrDir);
        return this.writeBody((OutputStream)FileUtil.getOutputStream(outFile), true, streamProgress);
    }

    public long writeBody(File targetFileOrDir, String tempFileSuffix, StreamProgress streamProgress) {
        long length;
        Assert.notNull(targetFileOrDir, "[targetFileOrDir] must be not null!", new Object[0]);
        File outFile = this.completeFileNameFromHeader(targetFileOrDir);
        tempFileSuffix = StrUtil.isBlank(tempFileSuffix) ? ".temp" : StrUtil.addPrefixIfNot(tempFileSuffix, ".");
        String fileName = outFile.getName();
        String tempFileName = fileName + tempFileSuffix;
        outFile = new File(outFile.getParentFile(), tempFileName);
        try {
            length = this.writeBody(outFile, streamProgress);
            FileUtil.rename(outFile, fileName, true);
        }
        catch (Throwable e) {
            FileUtil.del(outFile);
            throw new HttpException(e);
        }
        return length;
    }

    public File writeBodyForFile(File targetFileOrDir, StreamProgress streamProgress) {
        Assert.notNull(targetFileOrDir, "[targetFileOrDir] must be not null!", new Object[0]);
        File outFile = this.completeFileNameFromHeader(targetFileOrDir);
        this.writeBody((OutputStream)FileUtil.getOutputStream(outFile), true, streamProgress);
        return outFile;
    }

    public long writeBody(File targetFileOrDir) {
        return this.writeBody(targetFileOrDir, null);
    }

    public long writeBody(String targetFileOrDir) {
        return this.writeBody(FileUtil.file(targetFileOrDir));
    }

    public void close() {
        IoUtil.close((Closeable)this.in);
        this.in = null;
        this.httpConnection.disconnectQuietly();
    }

    @Override
    public String toString() {
        StringBuilder sb = StrUtil.builder();
        sb.append("Response Headers: ").append("\r\n");
        for (Map.Entry entry : this.headers.entrySet()) {
            sb.append("    ").append((Object)entry).append("\r\n");
        }
        sb.append("Response Body: ").append("\r\n");
        sb.append("    ").append(this.body()).append("\r\n");
        return sb.toString();
    }

    public File completeFileNameFromHeader(File targetFileOrDir) {
        if (!targetFileOrDir.isDirectory()) {
            return targetFileOrDir;
        }
        String fileName = this.getFileNameFromDisposition(null);
        if (StrUtil.isBlank(fileName)) {
            String path = this.httpConnection.getUrl().getPath();
            fileName = StrUtil.subSuf(path, path.lastIndexOf(47) + 1);
            fileName = StrUtil.isBlank(fileName) ? URLUtil.encodeQuery(path, this.charset) : URLUtil.decode(fileName, this.charset);
        }
        return FileUtil.file(targetFileOrDir, fileName);
    }

    public String getFileNameFromDisposition(String paramName) {
        paramName = ObjUtil.defaultIfNull(paramName, "filename");
        String fileName = null;
        String disposition = this.header(Header.CONTENT_DISPOSITION);
        if (StrUtil.isNotBlank(disposition) && StrUtil.isBlank(fileName = ReUtil.get(paramName + "=\"(.*?)\"", (CharSequence)disposition, 1))) {
            fileName = StrUtil.subAfter((CharSequence)disposition, paramName + "=", true);
        }
        return fileName;
    }

    private HttpResponse initWithDisconnect() throws HttpException {
        try {
            this.init();
        }
        catch (HttpException e) {
            this.httpConnection.disconnectQuietly();
            throw e;
        }
        return this;
    }

    private HttpResponse init() throws HttpException {
        Charset charset;
        block5: {
            try {
                this.status = this.httpConnection.responseCode();
            }
            catch (IOException e) {
                if (e instanceof FileNotFoundException) break block5;
                throw new HttpException(e);
            }
        }
        try {
            this.headers = this.httpConnection.headers();
        }
        catch (IllegalArgumentException e) {
            // empty catch block
        }
        GlobalCookieManager.store(this.httpConnection);
        this.charsetFromResponse = charset = this.httpConnection.getCharset();
        if (null != charset) {
            this.charset = charset;
        }
        this.in = new HttpInputStream(this);
        return this.isAsync ? this : this.forceSync();
    }

    private HttpResponse forceSync() {
        block7: {
            try {
                this.readBody(this.in);
            }
            catch (IORuntimeException e) {
                if (e.getCause() instanceof FileNotFoundException) {
                    break block7;
                }
                throw new HttpException((Throwable)((Object)e));
            }
            finally {
                if (this.isAsync) {
                    this.isAsync = false;
                }
                this.close();
            }
        }
        return this;
    }

    private void readBody(InputStream in) throws IORuntimeException {
        if (this.ignoreBody) {
            return;
        }
        long contentLength = this.contentLength();
        FastByteArrayOutputStream out = new FastByteArrayOutputStream((int)contentLength);
        HttpResponse.copyBody(in, out, contentLength, null, this.config.ignoreEOFError);
        this.body = new BytesResource(out.toByteArray());
    }

    private static long copyBody(InputStream in, OutputStream out, long contentLength, StreamProgress streamProgress, boolean isIgnoreEOFError) {
        long copyLength;
        block3: {
            if (null == out) {
                throw new NullPointerException("[out] is null!");
            }
            copyLength = -1L;
            try {
                copyLength = IoUtil.copy(in, out, 8192, contentLength, streamProgress);
            }
            catch (IORuntimeException e) {
                if (isIgnoreEOFError && (e.getCause() instanceof EOFException || StrUtil.containsIgnoreCase(e.getMessage(), "Premature EOF"))) break block3;
                throw e;
            }
        }
        return copyLength;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.URL
 *  java.net.URLConnection
 *  java.nio.charset.Charset
 *  java.nio.charset.UnsupportedCharsetException
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.HttpsURLConnection
 *  javax.net.ssl.SSLSocketFactory
 */
package cn.hutool.http;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpGlobalConfig;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.hutool.http.ssl.DefaultSSLInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HttpConnection {
    private final URL url;
    private final Proxy proxy;
    private HttpURLConnection conn;

    public static HttpConnection create(String urlStr, Proxy proxy) {
        return HttpConnection.create(URLUtil.toUrlForHttp(urlStr), proxy);
    }

    public static HttpConnection create(URL url, Proxy proxy) {
        return new HttpConnection(url, proxy);
    }

    public HttpConnection(URL url, Proxy proxy) {
        this.url = url;
        this.proxy = proxy;
        this.initConn();
    }

    public HttpConnection initConn() {
        try {
            this.conn = this.openHttp();
        }
        catch (IOException e) {
            throw new HttpException(e);
        }
        this.conn.setDoInput(true);
        return this;
    }

    public Method getMethod() {
        return Method.valueOf(this.conn.getRequestMethod());
    }

    public HttpConnection setMethod(Method method) {
        if (Method.POST.equals((Object)method) || Method.PUT.equals((Object)method) || Method.PATCH.equals((Object)method) || Method.DELETE.equals((Object)method)) {
            this.conn.setUseCaches(false);
            if (Method.PATCH.equals((Object)method)) {
                try {
                    HttpGlobalConfig.allowPatch();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        try {
            this.conn.setRequestMethod(method.toString());
        }
        catch (ProtocolException e) {
            if (Method.PATCH.equals((Object)method)) {
                this.reflectSetMethod(method);
            }
            throw new HttpException(e);
        }
        return this;
    }

    public URL getUrl() {
        return this.url;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public HttpURLConnection getHttpURLConnection() {
        return this.conn;
    }

    public HttpConnection header(String header, String value, boolean isOverride) {
        if (null != this.conn) {
            if (isOverride) {
                this.conn.setRequestProperty(header, value);
            } else {
                this.conn.addRequestProperty(header, value);
            }
        }
        return this;
    }

    public HttpConnection header(Header header, String value, boolean isOverride) {
        return this.header(header.toString(), value, isOverride);
    }

    public HttpConnection header(Map<String, List<String>> headerMap, boolean isOverride) {
        if (MapUtil.isNotEmpty(headerMap)) {
            for (Map.Entry entry : headerMap.entrySet()) {
                String name = (String)entry.getKey();
                for (String value : (List)entry.getValue()) {
                    this.header(name, StrUtil.nullToEmpty(value), isOverride);
                }
            }
        }
        return this;
    }

    public String header(String name) {
        return this.conn.getHeaderField(name);
    }

    public String header(Header name) {
        return this.header(name.toString());
    }

    public Map<String, List<String>> headers() {
        return this.conn.getHeaderFields();
    }

    public HttpConnection setHttpsInfo(HostnameVerifier hostnameVerifier, SSLSocketFactory ssf) throws HttpException {
        HttpURLConnection conn = this.conn;
        if (conn instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConn = (HttpsURLConnection)conn;
            httpsConn.setHostnameVerifier((HostnameVerifier)ObjectUtil.defaultIfNull(hostnameVerifier, DefaultSSLInfo.TRUST_ANY_HOSTNAME_VERIFIER));
            httpsConn.setSSLSocketFactory(ObjectUtil.defaultIfNull(ssf, DefaultSSLInfo.DEFAULT_SSF));
        }
        return this;
    }

    public HttpConnection disableCache() {
        this.conn.setUseCaches(false);
        return this;
    }

    public HttpConnection setConnectTimeout(int timeout2) {
        if (timeout2 > 0 && null != this.conn) {
            this.conn.setConnectTimeout(timeout2);
        }
        return this;
    }

    public HttpConnection setReadTimeout(int timeout2) {
        if (timeout2 > 0 && null != this.conn) {
            this.conn.setReadTimeout(timeout2);
        }
        return this;
    }

    public HttpConnection setConnectionAndReadTimeout(int timeout2) {
        this.setConnectTimeout(timeout2);
        this.setReadTimeout(timeout2);
        return this;
    }

    public HttpConnection setCookie(String cookie) {
        if (cookie != null) {
            this.header(Header.COOKIE, cookie, true);
        }
        return this;
    }

    public HttpConnection setChunkedStreamingMode(int blockSize) {
        if (blockSize > 0) {
            this.conn.setChunkedStreamingMode(blockSize);
        }
        return this;
    }

    public HttpConnection setInstanceFollowRedirects(boolean isInstanceFollowRedirects) {
        this.conn.setInstanceFollowRedirects(isInstanceFollowRedirects);
        return this;
    }

    public HttpConnection connect() throws IOException {
        if (null != this.conn) {
            this.conn.connect();
        }
        return this;
    }

    public HttpConnection disconnectQuietly() {
        try {
            this.disconnect();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return this;
    }

    public HttpConnection disconnect() {
        if (null != this.conn) {
            this.conn.disconnect();
        }
        return this;
    }

    public InputStream getInputStream() throws IOException {
        if (null != this.conn) {
            return this.conn.getInputStream();
        }
        return null;
    }

    public InputStream getErrorStream() {
        if (null != this.conn) {
            return this.conn.getErrorStream();
        }
        return null;
    }

    public OutputStream getOutputStream() throws IOException {
        if (null == this.conn) {
            throw new IOException("HttpURLConnection has not been initialized.");
        }
        Method method = this.getMethod();
        this.conn.setDoOutput(true);
        OutputStream out = this.conn.getOutputStream();
        if (method == Method.GET && method != this.getMethod()) {
            this.reflectSetMethod(method);
        }
        return out;
    }

    public int responseCode() throws IOException {
        if (null != this.conn) {
            return this.conn.getResponseCode();
        }
        return 0;
    }

    public String getCharsetName() {
        return HttpUtil.getCharset(this.conn);
    }

    public Charset getCharset() {
        Charset charset = null;
        String charsetName = this.getCharsetName();
        if (StrUtil.isNotBlank(charsetName)) {
            try {
                charset = Charset.forName((String)charsetName);
            }
            catch (UnsupportedCharsetException unsupportedCharsetException) {
                // empty catch block
            }
        }
        return charset;
    }

    public String toString() {
        StringBuilder sb = StrUtil.builder();
        sb.append("Request URL: ").append((Object)this.url).append("\r\n");
        sb.append("Request Method: ").append((Object)this.getMethod()).append("\r\n");
        return sb.toString();
    }

    private HttpURLConnection openHttp() throws IOException {
        URLConnection conn = this.openConnection();
        if (!(conn instanceof HttpURLConnection)) {
            throw new HttpException("'{}' of URL [{}] is not a http connection, make sure URL is format for http.", conn.getClass().getName(), this.url);
        }
        return (HttpURLConnection)conn;
    }

    private URLConnection openConnection() throws IOException {
        return null == this.proxy ? this.url.openConnection() : this.url.openConnection(this.proxy);
    }

    private void reflectSetMethod(Method method) {
        ReflectUtil.setFieldValue((Object)this.conn, "method", (Object)method.name());
        Object delegate = ReflectUtil.getFieldValue((Object)this.conn, "delegate");
        if (null != delegate) {
            ReflectUtil.setFieldValue(delegate, "method", (Object)method.name());
        }
    }
}


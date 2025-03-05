/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.net.HttpURLConnection
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.regex.Pattern
 */
package cn.hutool.http;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.net.RFC3986;
import cn.hutool.core.net.url.UrlQuery;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpDownloader;
import cn.hutool.http.HttpGlobalConfig;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.Method;
import cn.hutool.http.cookie.GlobalCookieManager;
import cn.hutool.http.server.SimpleServer;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class HttpUtil {
    public static final Pattern CHARSET_PATTERN = Pattern.compile((String)"charset\\s*=\\s*([a-z0-9-]*)", (int)2);
    public static final Pattern META_CHARSET_PATTERN = Pattern.compile((String)"<meta[^>]*?charset\\s*=\\s*['\"]?([a-z0-9-]*)", (int)2);

    public static boolean isHttps(String url) {
        return StrUtil.startWithIgnoreCase(url, "https:");
    }

    public static boolean isHttp(String url) {
        return StrUtil.startWithIgnoreCase(url, "http:");
    }

    public static HttpRequest createRequest(Method method, String url) {
        return HttpRequest.of(url).method(method);
    }

    public static HttpRequest createGet(String url) {
        return HttpUtil.createGet(url, false);
    }

    public static HttpRequest createGet(String url, boolean isFollowRedirects) {
        return HttpRequest.get(url).setFollowRedirects(isFollowRedirects);
    }

    public static HttpRequest createPost(String url) {
        return HttpRequest.post(url);
    }

    public static String get(String urlString, Charset customCharset) {
        return ((HttpRequest)HttpRequest.get(urlString).charset(customCharset)).execute().body();
    }

    public static String get(String urlString) {
        return HttpUtil.get(urlString, HttpGlobalConfig.getTimeout());
    }

    public static String get(String urlString, int timeout2) {
        return HttpRequest.get(urlString).timeout(timeout2).execute().body();
    }

    public static String get(String urlString, Map<String, Object> paramMap) {
        return HttpRequest.get(urlString).form(paramMap).execute().body();
    }

    public static String get(String urlString, Map<String, Object> paramMap, int timeout2) {
        return HttpRequest.get(urlString).form(paramMap).timeout(timeout2).execute().body();
    }

    public static String post(String urlString, Map<String, Object> paramMap) {
        return HttpUtil.post(urlString, paramMap, HttpGlobalConfig.getTimeout());
    }

    public static String post(String urlString, Map<String, Object> paramMap, int timeout2) {
        return HttpRequest.post(urlString).form(paramMap).timeout(timeout2).execute().body();
    }

    public static String post(String urlString, String body) {
        return HttpUtil.post(urlString, body, HttpGlobalConfig.getTimeout());
    }

    public static String post(String urlString, String body, int timeout2) {
        return HttpRequest.post(urlString).timeout(timeout2).body(body).execute().body();
    }

    public static String downloadString(String url, String customCharsetName) {
        return HttpUtil.downloadString(url, CharsetUtil.charset(customCharsetName), null);
    }

    public static String downloadString(String url, Charset customCharset) {
        return HttpUtil.downloadString(url, customCharset, null);
    }

    public static String downloadString(String url, Charset customCharset, StreamProgress streamPress) {
        return HttpDownloader.downloadString(url, customCharset, streamPress);
    }

    public static long downloadFile(String url, String dest) {
        return HttpUtil.downloadFile(url, FileUtil.file(dest));
    }

    public static long downloadFile(String url, File destFile) {
        return HttpUtil.downloadFile(url, destFile, null);
    }

    public static long downloadFile(String url, File destFile, int timeout2) {
        return HttpUtil.downloadFile(url, destFile, timeout2, null);
    }

    public static long downloadFile(String url, File destFile, StreamProgress streamProgress) {
        return HttpUtil.downloadFile(url, destFile, -1, streamProgress);
    }

    public static long downloadFile(String url, File destFile, int timeout2, StreamProgress streamProgress) {
        return HttpDownloader.downloadFile(url, destFile, timeout2, streamProgress);
    }

    public static File downloadFileFromUrl(String url, String dest) {
        return HttpUtil.downloadFileFromUrl(url, FileUtil.file(dest));
    }

    public static File downloadFileFromUrl(String url, File destFile) {
        return HttpUtil.downloadFileFromUrl(url, destFile, null);
    }

    public static File downloadFileFromUrl(String url, File destFile, int timeout2) {
        return HttpUtil.downloadFileFromUrl(url, destFile, timeout2, null);
    }

    public static File downloadFileFromUrl(String url, File destFile, StreamProgress streamProgress) {
        return HttpUtil.downloadFileFromUrl(url, destFile, -1, streamProgress);
    }

    public static File downloadFileFromUrl(String url, File destFile, int timeout2, StreamProgress streamProgress) {
        return HttpDownloader.downloadForFile(url, destFile, timeout2, streamProgress);
    }

    public static long download(String url, OutputStream out, boolean isCloseOut) {
        return HttpUtil.download(url, out, isCloseOut, null);
    }

    public static long download(String url, OutputStream out, boolean isCloseOut, StreamProgress streamProgress) {
        return HttpDownloader.download(url, out, isCloseOut, streamProgress);
    }

    public static byte[] downloadBytes(String url) {
        return HttpDownloader.downloadBytes(url);
    }

    public static String toParams(Map<String, ?> paramMap) {
        return HttpUtil.toParams(paramMap, CharsetUtil.CHARSET_UTF_8);
    }

    @Deprecated
    public static String toParams(Map<String, Object> paramMap, String charsetName) {
        return HttpUtil.toParams(paramMap, CharsetUtil.charset(charsetName));
    }

    public static String toParams(Map<String, ?> paramMap, Charset charset) {
        return HttpUtil.toParams(paramMap, charset, false);
    }

    public static String toParams(Map<String, ?> paramMap, Charset charset, boolean isFormUrlEncoded) {
        return UrlQuery.of(paramMap, isFormUrlEncoded).build(charset);
    }

    public static String encodeParams(String urlWithParams, Charset charset) {
        String paramPart;
        if (StrUtil.isBlank(urlWithParams)) {
            return "";
        }
        String urlPart = null;
        int pathEndPos = urlWithParams.indexOf(63);
        if (pathEndPos > -1) {
            urlPart = StrUtil.subPre(urlWithParams, pathEndPos);
            paramPart = StrUtil.subSuf(urlWithParams, pathEndPos + 1);
            if (StrUtil.isBlank(paramPart)) {
                return urlPart;
            }
        } else {
            if (!StrUtil.contains((CharSequence)urlWithParams, '=')) {
                return urlWithParams;
            }
            paramPart = urlWithParams;
        }
        paramPart = HttpUtil.normalizeParams(paramPart, charset);
        return StrUtil.isBlank(urlPart) ? paramPart : urlPart + "?" + paramPart;
    }

    public static String normalizeParams(String paramPart, Charset charset) {
        int lastIndex;
        int i;
        if (StrUtil.isEmpty(paramPart)) {
            return paramPart;
        }
        StrBuilder builder = StrBuilder.create(paramPart.length() + 16);
        int len = paramPart.length();
        String name = null;
        int pos = 0;
        for (i = 0; i < len; ++i) {
            char c = paramPart.charAt(i);
            if (c == '=') {
                if (null != name) continue;
                name = pos == i ? "" : paramPart.substring(pos, i);
                pos = i + 1;
                continue;
            }
            if (c != '&') continue;
            if (pos != i) {
                if (null == name) {
                    name = paramPart.substring(pos, i);
                    builder.append(RFC3986.QUERY_PARAM_NAME.encode(name, charset, new char[0])).append('=');
                } else {
                    builder.append(RFC3986.QUERY_PARAM_NAME.encode(name, charset, new char[0])).append('=').append(RFC3986.QUERY_PARAM_VALUE.encode(paramPart.substring(pos, i), charset, new char[0])).append('&');
                }
                name = null;
            }
            pos = i + 1;
        }
        if (null != name) {
            builder.append(URLUtil.encodeQuery(name, charset)).append('=');
        }
        if (pos != i) {
            if (null == name && pos > 0) {
                builder.append('=');
            }
            builder.append(URLUtil.encodeQuery(paramPart.substring(pos, i), charset));
        }
        if ('&' == builder.charAt(lastIndex = builder.length() - 1)) {
            builder.delTo(lastIndex);
        }
        return builder.toString();
    }

    public static Map<String, String> decodeParamMap(String paramsStr, Charset charset) {
        Map<CharSequence, CharSequence> queryMap = UrlQuery.of(paramsStr, charset).getQueryMap();
        if (MapUtil.isEmpty(queryMap)) {
            return MapUtil.empty();
        }
        return Convert.toMap(String.class, String.class, queryMap);
    }

    public static Map<String, List<String>> decodeParams(String paramsStr, String charset) {
        return HttpUtil.decodeParams(paramsStr, charset, false);
    }

    public static Map<String, List<String>> decodeParams(String paramsStr, String charset, boolean isFormUrlEncoded) {
        return HttpUtil.decodeParams(paramsStr, CharsetUtil.charset(charset), isFormUrlEncoded);
    }

    public static Map<String, List<String>> decodeParams(String paramsStr, Charset charset) {
        return HttpUtil.decodeParams(paramsStr, charset, false);
    }

    public static Map<String, List<String>> decodeParams(String paramsStr, Charset charset, boolean isFormUrlEncoded) {
        Map<CharSequence, CharSequence> queryMap = UrlQuery.of(paramsStr, charset, true, isFormUrlEncoded).getQueryMap();
        if (MapUtil.isEmpty(queryMap)) {
            return MapUtil.empty();
        }
        LinkedHashMap params = new LinkedHashMap();
        queryMap.forEach((arg_0, arg_1) -> HttpUtil.lambda$decodeParams$1((Map)params, arg_0, arg_1));
        return params;
    }

    public static String urlWithForm(String url, Map<String, Object> form, Charset charset, boolean isEncodeParams) {
        return HttpUtil.urlWithForm(url, HttpUtil.toParams(form, charset), charset, isEncodeParams);
    }

    public static String urlWithFormUrlEncoded(String url, Map<String, Object> form, Charset charset) {
        return HttpUtil.urlWithForm(url, HttpUtil.toParams(form, charset, true), charset, true);
    }

    public static String urlWithForm(String url, String queryString, Charset charset, boolean isEncode) {
        if (StrUtil.isBlank(queryString)) {
            if (StrUtil.contains((CharSequence)url, '?')) {
                return isEncode ? HttpUtil.encodeParams(url, charset) : url;
            }
            return url;
        }
        StrBuilder urlBuilder = StrBuilder.create(url.length() + queryString.length() + 16);
        int qmIndex = url.indexOf(63);
        if (qmIndex > 0) {
            urlBuilder.append(isEncode ? HttpUtil.encodeParams(url, charset) : url);
            if (!StrUtil.endWith((CharSequence)url, '&')) {
                urlBuilder.append('&');
            }
        } else {
            urlBuilder.append(url);
            if (qmIndex < 0) {
                urlBuilder.append('?');
            }
        }
        urlBuilder.append(isEncode ? HttpUtil.encodeParams(queryString, charset) : queryString);
        return urlBuilder.toString();
    }

    public static String getCharset(HttpURLConnection conn) {
        if (conn == null) {
            return null;
        }
        return HttpUtil.getCharset(conn.getContentType());
    }

    public static String getCharset(String contentType) {
        if (StrUtil.isBlank(contentType)) {
            return null;
        }
        return ReUtil.get(CHARSET_PATTERN, (CharSequence)contentType, 1);
    }

    public static String getString(InputStream in, Charset charset, boolean isGetCharsetFromContent) {
        byte[] contentBytes = IoUtil.readBytes(in);
        return HttpUtil.getString(contentBytes, charset, isGetCharsetFromContent);
    }

    public static String getString(byte[] contentBytes, Charset charset, boolean isGetCharsetFromContent) {
        String charsetInContentStr;
        if (null == contentBytes) {
            return null;
        }
        if (null == charset) {
            charset = CharsetUtil.CHARSET_UTF_8;
        }
        String content = new String(contentBytes, charset);
        if (isGetCharsetFromContent && StrUtil.isNotBlank(charsetInContentStr = ReUtil.get(META_CHARSET_PATTERN, (CharSequence)content, 1))) {
            Charset charsetInContent;
            block7: {
                charsetInContent = null;
                try {
                    charsetInContent = Charset.forName((String)charsetInContentStr);
                }
                catch (Exception e) {
                    if (StrUtil.containsIgnoreCase(charsetInContentStr, "utf-8") || StrUtil.containsIgnoreCase(charsetInContentStr, "utf8")) {
                        charsetInContent = CharsetUtil.CHARSET_UTF_8;
                    }
                    if (!StrUtil.containsIgnoreCase(charsetInContentStr, "gbk")) break block7;
                    charsetInContent = CharsetUtil.CHARSET_GBK;
                }
            }
            if (null != charsetInContent && !charset.equals((Object)charsetInContent)) {
                content = new String(contentBytes, charsetInContent);
            }
        }
        return content;
    }

    public static String getMimeType(String filePath, String defaultValue) {
        return ObjectUtil.defaultIfNull(HttpUtil.getMimeType(filePath), defaultValue);
    }

    public static String getMimeType(String filePath) {
        return FileUtil.getMimeType(filePath);
    }

    public static String getContentTypeByRequestBody(String body) {
        ContentType contentType = ContentType.get(body);
        return null == contentType ? null : contentType.toString();
    }

    public static SimpleServer createServer(int port) {
        return new SimpleServer(port);
    }

    public static String buildBasicAuth(String username, String password, Charset charset) {
        String data = username.concat(":").concat(password);
        return "Basic " + Base64.encode((CharSequence)data, charset);
    }

    public static void closeCookie() {
        GlobalCookieManager.setCookieManager(null);
    }

    private static /* synthetic */ void lambda$decodeParams$1(Map params, CharSequence key, CharSequence value) {
        List values = (List)params.computeIfAbsent((Object)StrUtil.str(key), k -> new ArrayList(1));
        values.add((Object)StrUtil.str(value));
    }
}


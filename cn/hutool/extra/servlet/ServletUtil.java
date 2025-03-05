/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.BufferedReader
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.PrintWriter
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.nio.charset.Charset
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.ServletRequest
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package cn.hutool.extra.servlet;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.bean.copier.ValueProvider;
import cn.hutool.core.collection.ArrayIter;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.CaseInsensitiveMap;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.net.multipart.MultipartFormData;
import cn.hutool.core.net.multipart.UploadSetting;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";

    public static Map<String, String[]> getParams(ServletRequest request) {
        Map map = request.getParameterMap();
        return Collections.unmodifiableMap((Map)map);
    }

    public static Map<String, String> getParamMap(ServletRequest request) {
        HashMap params = new HashMap();
        for (Map.Entry entry : ServletUtil.getParams(request).entrySet()) {
            params.put(entry.getKey(), (Object)ArrayUtil.join((Object[])entry.getValue(), (CharSequence)","));
        }
        return params;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getBody(ServletRequest request) {
        try (BufferedReader reader = request.getReader();){
            String string = IoUtil.read((Reader)reader);
            return string;
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public static byte[] getBodyBytes(ServletRequest request) {
        try {
            return IoUtil.readBytes((InputStream)request.getInputStream());
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public static <T> T fillBean(final ServletRequest request, T bean, CopyOptions copyOptions) {
        final String beanName = StrUtil.lowerFirst(bean.getClass().getSimpleName());
        return BeanUtil.fillBean(bean, new ValueProvider<String>(){

            @Override
            public Object value(String key, Type valueType) {
                String[] values = request.getParameterValues(key);
                if (ArrayUtil.isEmpty(values) && ArrayUtil.isEmpty(values = request.getParameterValues(beanName + "." + key))) {
                    return null;
                }
                if (1 == values.length) {
                    return values[0];
                }
                return values;
            }

            @Override
            public boolean containsKey(String key) {
                return null != request.getParameter(key) || null != request.getParameter(beanName + "." + key);
            }
        }, copyOptions);
    }

    public static <T> T fillBean(ServletRequest request, T bean, boolean isIgnoreError) {
        return ServletUtil.fillBean(request, bean, CopyOptions.create().setIgnoreError(isIgnoreError));
    }

    public static <T> T toBean(ServletRequest request, Class<T> beanClass, boolean isIgnoreError) {
        return ServletUtil.fillBean(request, ReflectUtil.newInstanceIfPossible(beanClass), isIgnoreError);
    }

    public static String getClientIP(HttpServletRequest request, String ... otherHeaderNames) {
        String[] headers = new String[]{"X-Forwarded-For", "X-Real-IP", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
        if (ArrayUtil.isNotEmpty(otherHeaderNames)) {
            headers = ArrayUtil.addAll(headers, otherHeaderNames);
        }
        return ServletUtil.getClientIPByHeader(request, headers);
    }

    public static String getClientIPByHeader(HttpServletRequest request, String ... headerNames) {
        String ip;
        for (String header : headerNames) {
            ip = request.getHeader(header);
            if (NetUtil.isUnknown(ip)) continue;
            return NetUtil.getMultistageReverseProxyIp(ip);
        }
        ip = request.getRemoteAddr();
        return NetUtil.getMultistageReverseProxyIp(ip);
    }

    public static MultipartFormData getMultipart(ServletRequest request) throws IORuntimeException {
        return ServletUtil.getMultipart(request, new UploadSetting());
    }

    public static MultipartFormData getMultipart(ServletRequest request, UploadSetting uploadSetting) throws IORuntimeException {
        MultipartFormData formData = new MultipartFormData(uploadSetting);
        try {
            formData.parseRequestStream((InputStream)request.getInputStream(), CharsetUtil.charset(request.getCharacterEncoding()));
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return formData;
    }

    public static Map<String, String> getHeaderMap(HttpServletRequest request) {
        HashMap headerMap = new HashMap();
        Enumeration names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String)names.nextElement();
            headerMap.put((Object)name, (Object)request.getHeader(name));
        }
        return headerMap;
    }

    public static Map<String, List<String>> getHeadersMap(HttpServletRequest request) {
        LinkedHashMap headerMap = new LinkedHashMap();
        Enumeration names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String)names.nextElement();
            headerMap.put((Object)name, ListUtil.list(false, request.getHeaders(name)));
        }
        return headerMap;
    }

    public static Map<String, Collection<String>> getHeadersMap(HttpServletResponse response) {
        HashMap headerMap = new HashMap();
        Collection names = response.getHeaderNames();
        for (String name : names) {
            headerMap.put((Object)name, (Object)response.getHeaders(name));
        }
        return headerMap;
    }

    public static String getHeaderIgnoreCase(HttpServletRequest request, String nameIgnoreCase) {
        Enumeration names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = (String)names.nextElement();
            if (name == null || !name.equalsIgnoreCase(nameIgnoreCase)) continue;
            return request.getHeader(name);
        }
        return null;
    }

    public static String getHeader(HttpServletRequest request, String name, String charsetName) {
        return ServletUtil.getHeader(request, name, CharsetUtil.charset(charsetName));
    }

    public static String getHeader(HttpServletRequest request, String name, Charset charset) {
        String header = request.getHeader(name);
        if (null != header) {
            return CharsetUtil.convert(header, CharsetUtil.CHARSET_ISO_8859_1, charset);
        }
        return null;
    }

    public static boolean isIE(HttpServletRequest request) {
        String userAgent = ServletUtil.getHeaderIgnoreCase(request, "User-Agent");
        if (StrUtil.isNotBlank(userAgent)) {
            return (userAgent = userAgent.toUpperCase()).contains((CharSequence)"MSIE") || userAgent.contains((CharSequence)"TRIDENT");
        }
        return false;
    }

    public static boolean isGetMethod(HttpServletRequest request) {
        return METHOD_GET.equalsIgnoreCase(request.getMethod());
    }

    public static boolean isPostMethod(HttpServletRequest request) {
        return METHOD_POST.equalsIgnoreCase(request.getMethod());
    }

    public static boolean isMultipart(HttpServletRequest request) {
        if (!ServletUtil.isPostMethod(request)) {
            return false;
        }
        String contentType = request.getContentType();
        if (StrUtil.isBlank(contentType)) {
            return false;
        }
        return contentType.toLowerCase().startsWith("multipart/");
    }

    public static Cookie getCookie(HttpServletRequest httpServletRequest, String name) {
        return (Cookie)ServletUtil.readCookieMap(httpServletRequest).get((Object)name);
    }

    public static Map<String, Cookie> readCookieMap(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (ArrayUtil.isEmpty(cookies)) {
            return MapUtil.empty();
        }
        return IterUtil.toMap(new ArrayIter<Cookie>((E[])httpServletRequest.getCookies()), new CaseInsensitiveMap(), Cookie::getName);
    }

    public static void addCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }

    public static void addCookie(HttpServletResponse response, String name, String value) {
        response.addCookie(new Cookie(name, value));
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds, String path, String domain) {
        Cookie cookie = new Cookie(name, value);
        if (domain != null) {
            cookie.setDomain(domain);
        }
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setPath(path);
        ServletUtil.addCookie(response, cookie);
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAgeInSeconds) {
        ServletUtil.addCookie(response, name, value, maxAgeInSeconds, "/", null);
    }

    public static PrintWriter getWriter(HttpServletResponse response) throws IORuntimeException {
        try {
            return response.getWriter();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    public static void write(HttpServletResponse response, String text, String contentType) {
        response.setContentType(contentType);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(text);
            writer.flush();
        }
        catch (IOException e) {
            throw new UtilException(e);
        }
        finally {
            IoUtil.close((Closeable)writer);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void write(HttpServletResponse response, File file) {
        String fileName = file.getName();
        String contentType = ObjectUtil.defaultIfNull(FileUtil.getMimeType(fileName), "application/octet-stream");
        BufferedInputStream in = null;
        try {
            in = FileUtil.getInputStream(file);
            ServletUtil.write(response, (InputStream)in, contentType, fileName);
        }
        finally {
            IoUtil.close((Closeable)in);
        }
    }

    public static void write(HttpServletResponse response, InputStream in, String contentType, String fileName) {
        String charset = ObjectUtil.defaultIfNull(response.getCharacterEncoding(), "UTF-8");
        String encodeText = URLUtil.encodeAll(fileName, CharsetUtil.charset(charset));
        response.setHeader("Content-Disposition", StrUtil.format("attachment;filename=\"{}\";filename*={}''{}", encodeText, charset, encodeText));
        response.setContentType(contentType);
        ServletUtil.write(response, in);
    }

    public static void write(HttpServletResponse response, InputStream in, String contentType) {
        response.setContentType(contentType);
        ServletUtil.write(response, in);
    }

    public static void write(HttpServletResponse response, InputStream in) {
        ServletUtil.write(response, in, 8192);
    }

    public static void write(HttpServletResponse response, InputStream in, int bufferSize) {
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            IoUtil.copy(in, (OutputStream)out, bufferSize);
        }
        catch (IOException e) {
            throw new UtilException(e);
        }
        finally {
            IoUtil.close((Closeable)out);
            IoUtil.close((Closeable)in);
        }
    }

    public static void setHeader(HttpServletResponse response, String name, Object value) {
        if (value instanceof String) {
            response.setHeader(name, (String)value);
        } else if (Date.class.isAssignableFrom(value.getClass())) {
            response.setDateHeader(name, ((Date)value).getTime());
        } else if (value instanceof Integer || "int".equalsIgnoreCase(value.getClass().getSimpleName())) {
            response.setIntHeader(name, ((Integer)value).intValue());
        } else {
            response.setHeader(name, value.toString());
        }
    }
}


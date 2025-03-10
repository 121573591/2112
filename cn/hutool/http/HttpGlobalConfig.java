/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.reflect.Field
 *  java.net.CookieManager
 *  java.net.HttpURLConnection
 */
package cn.hutool.http;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.cookie.GlobalCookieManager;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.CookieManager;
import java.net.HttpURLConnection;

public class HttpGlobalConfig
implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int timeout = -1;
    private static boolean isAllowPatch = false;
    private static String boundary = "--------------------Hutool_" + RandomUtil.randomString(16);
    private static int maxRedirectCount = 0;
    private static boolean ignoreEOFError = true;
    private static boolean decodeUrl = false;

    public static int getTimeout() {
        return timeout;
    }

    public static synchronized void setTimeout(int customTimeout) {
        timeout = customTimeout;
    }

    public static String getBoundary() {
        return boundary;
    }

    public static synchronized void setBoundary(String customBoundary) {
        boundary = customBoundary;
    }

    public static int getMaxRedirectCount() {
        return maxRedirectCount;
    }

    public static synchronized void setMaxRedirectCount(int customMaxRedirectCount) {
        maxRedirectCount = customMaxRedirectCount;
    }

    public static boolean isIgnoreEOFError() {
        return ignoreEOFError;
    }

    public static synchronized void setIgnoreEOFError(boolean customIgnoreEOFError) {
        ignoreEOFError = customIgnoreEOFError;
    }

    public static boolean isDecodeUrl() {
        return decodeUrl;
    }

    public static synchronized void setDecodeUrl(boolean customDecodeUrl) {
        decodeUrl = customDecodeUrl;
    }

    public static CookieManager getCookieManager() {
        return GlobalCookieManager.getCookieManager();
    }

    public static synchronized void setCookieManager(CookieManager customCookieManager) {
        GlobalCookieManager.setCookieManager(customCookieManager);
    }

    public static synchronized void closeCookie() {
        GlobalCookieManager.setCookieManager(null);
    }

    public static synchronized void allowPatch() {
        if (isAllowPatch) {
            return;
        }
        Field methodsField = ReflectUtil.getField(HttpURLConnection.class, "methods");
        if (null == methodsField) {
            throw new HttpException("None static field [methods] with Java version: [{}]", System.getProperty((String)"java.version"));
        }
        ReflectUtil.removeFinalModify(methodsField);
        String[] methods = new String[]{"GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE", "TRACE", "PATCH"};
        ReflectUtil.setFieldValue(null, methodsField, (Object)methods);
        Object staticFieldValue = ReflectUtil.getStaticFieldValue(methodsField);
        if (!ArrayUtil.equals(methods, staticFieldValue)) {
            throw new HttpException("Inject value to field [methods] failed!");
        }
        isAllowPatch = true;
    }
}


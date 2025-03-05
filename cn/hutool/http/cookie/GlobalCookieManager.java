/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.CookieManager
 *  java.net.CookiePolicy
 *  java.net.CookieStore
 *  java.net.HttpCookie
 *  java.net.URI
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package cn.hutool.http.cookie;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpConnection;
import cn.hutool.http.cookie.ThreadLocalCookieStore;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalCookieManager {
    private static CookieManager cookieManager = new CookieManager((CookieStore)new ThreadLocalCookieStore(), CookiePolicy.ACCEPT_ALL);

    public static void setCookieManager(CookieManager customCookieManager) {
        cookieManager = customCookieManager;
    }

    public static CookieManager getCookieManager() {
        return cookieManager;
    }

    public static List<HttpCookie> getCookies(HttpConnection conn) {
        return cookieManager.getCookieStore().get(GlobalCookieManager.getURI(conn));
    }

    public static void add(HttpConnection conn) {
        Map cookieHeader;
        if (null == cookieManager) {
            return;
        }
        try {
            cookieHeader = cookieManager.get(GlobalCookieManager.getURI(conn), (Map)new HashMap(0));
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        conn.header((Map<String, List<String>>)cookieHeader, false);
    }

    public static void store(HttpConnection conn) {
        if (null == cookieManager) {
            return;
        }
        try {
            cookieManager.put(GlobalCookieManager.getURI(conn), conn.headers());
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    private static URI getURI(HttpConnection conn) {
        return URLUtil.toURI(conn.getUrl());
    }
}


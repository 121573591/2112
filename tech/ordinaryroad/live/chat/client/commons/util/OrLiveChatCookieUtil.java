/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpCookie
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.function.Supplier
 *  java.util.stream.Collectors
 */
package tech.ordinaryroad.live.chat.client.commons.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OrLiveChatCookieUtil {
    public static String toString(List<HttpCookie> cookies) {
        if (CollUtil.isEmpty(cookies)) {
            return "";
        }
        return (String)cookies.stream().map(httpCookie -> {
            httpCookie.setVersion(0);
            return httpCookie.toString();
        }).collect(Collectors.joining((CharSequence)"; "));
    }

    public static Map<String, String> parseCookieString(String cookies) {
        HashMap map = new HashMap();
        if (StrUtil.isNotBlank(cookies) && !StrUtil.isNullOrUndefined(cookies)) {
            try {
                String[] split;
                for (String s : split = cookies.split("; ")) {
                    String key = StrUtil.subBefore((CharSequence)s, '=', false);
                    String value = StrUtil.subAfter((CharSequence)s, '=', false);
                    map.put((Object)key, (Object)value);
                }
            }
            catch (Exception e) {
                throw new RuntimeException("cookie解析失败 " + cookies, (Throwable)e);
            }
        }
        return map;
    }

    public static String toCookieString(Map<String, String> cookies) {
        if (cookies.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry stringStringEntry : cookies.entrySet()) {
            String key = (String)stringStringEntry.getKey();
            String value = (String)stringStringEntry.getValue();
            sb.append(key).append("=").append(value).append("; ");
        }
        int length = sb.length();
        sb.delete(length - 2, length);
        return sb.toString();
    }

    public static String getCookieByName(Map<String, String> cookieMap, String name, Supplier<String> supplier) {
        String str = MapUtil.getStr(cookieMap, name);
        return str == null ? (String)supplier.get() : str;
    }

    public static String getCookieByName(String cookie, String name, Supplier<String> supplier) {
        String str = MapUtil.getStr(OrLiveChatCookieUtil.parseCookieString(cookie), name);
        return str == null ? (String)supplier.get() : str;
    }
}


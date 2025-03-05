/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.net.httpserver.Filter$Chain
 *  java.io.IOException
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 */
package cn.hutool.http.server.filter;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import com.sun.net.httpserver.Filter;
import java.io.IOException;

@FunctionalInterface
public interface HttpFilter {
    public void doFilter(HttpServerRequest var1, HttpServerResponse var2, Filter.Chain var3) throws IOException;
}


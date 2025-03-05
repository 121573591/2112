/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.StringUtil
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map$Entry
 */
package io.netty.handler.codec.http;

import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.util.internal.StringUtil;
import java.util.Map;

final class HttpMessageUtil {
    static StringBuilder appendRequest(StringBuilder buf, HttpRequest req) {
        HttpMessageUtil.appendCommon(buf, req);
        HttpMessageUtil.appendInitialLine(buf, req);
        HttpMessageUtil.appendHeaders(buf, req.headers());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    static StringBuilder appendResponse(StringBuilder buf, HttpResponse res) {
        HttpMessageUtil.appendCommon(buf, res);
        HttpMessageUtil.appendInitialLine(buf, res);
        HttpMessageUtil.appendHeaders(buf, res.headers());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    private static void appendCommon(StringBuilder buf, HttpMessage msg) {
        buf.append(StringUtil.simpleClassName((Object)msg));
        buf.append("(decodeResult: ");
        buf.append((Object)msg.decoderResult());
        buf.append(", version: ");
        buf.append((Object)msg.protocolVersion());
        buf.append(')');
        buf.append(StringUtil.NEWLINE);
    }

    static StringBuilder appendFullRequest(StringBuilder buf, FullHttpRequest req) {
        HttpMessageUtil.appendFullCommon(buf, req);
        HttpMessageUtil.appendInitialLine(buf, req);
        HttpMessageUtil.appendHeaders(buf, req.headers());
        HttpMessageUtil.appendHeaders(buf, req.trailingHeaders());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    static StringBuilder appendFullResponse(StringBuilder buf, FullHttpResponse res) {
        HttpMessageUtil.appendFullCommon(buf, res);
        HttpMessageUtil.appendInitialLine(buf, res);
        HttpMessageUtil.appendHeaders(buf, res.headers());
        HttpMessageUtil.appendHeaders(buf, res.trailingHeaders());
        HttpMessageUtil.removeLastNewLine(buf);
        return buf;
    }

    private static void appendFullCommon(StringBuilder buf, FullHttpMessage msg) {
        buf.append(StringUtil.simpleClassName((Object)msg));
        buf.append("(decodeResult: ");
        buf.append((Object)msg.decoderResult());
        buf.append(", version: ");
        buf.append((Object)msg.protocolVersion());
        buf.append(", content: ");
        buf.append((Object)msg.content());
        buf.append(')');
        buf.append(StringUtil.NEWLINE);
    }

    private static void appendInitialLine(StringBuilder buf, HttpRequest req) {
        buf.append((Object)req.method());
        buf.append(' ');
        buf.append(req.uri());
        buf.append(' ');
        buf.append((Object)req.protocolVersion());
        buf.append(StringUtil.NEWLINE);
    }

    private static void appendInitialLine(StringBuilder buf, HttpResponse res) {
        buf.append((Object)res.protocolVersion());
        buf.append(' ');
        buf.append((Object)res.status());
        buf.append(StringUtil.NEWLINE);
    }

    private static void appendHeaders(StringBuilder buf, HttpHeaders headers) {
        for (Map.Entry e : headers) {
            buf.append((String)e.getKey());
            buf.append(": ");
            buf.append((String)e.getValue());
            buf.append(StringUtil.NEWLINE);
        }
    }

    private static void removeLastNewLine(StringBuilder buf) {
        buf.setLength(buf.length() - StringUtil.NEWLINE.length());
    }

    private HttpMessageUtil() {
    }
}


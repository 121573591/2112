/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.AsciiString
 *  java.lang.Object
 *  java.lang.String
 */
package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.util.AsciiString;

public final class RtspHeaderNames {
    public static final AsciiString ACCEPT = HttpHeaderNames.ACCEPT;
    public static final AsciiString ACCEPT_ENCODING = HttpHeaderNames.ACCEPT_ENCODING;
    public static final AsciiString ACCEPT_LANGUAGE = HttpHeaderNames.ACCEPT_LANGUAGE;
    public static final AsciiString ALLOW = AsciiString.cached((String)"allow");
    public static final AsciiString AUTHORIZATION = HttpHeaderNames.AUTHORIZATION;
    public static final AsciiString BANDWIDTH = AsciiString.cached((String)"bandwidth");
    public static final AsciiString BLOCKSIZE = AsciiString.cached((String)"blocksize");
    public static final AsciiString CACHE_CONTROL = HttpHeaderNames.CACHE_CONTROL;
    public static final AsciiString CONFERENCE = AsciiString.cached((String)"conference");
    public static final AsciiString CONNECTION = HttpHeaderNames.CONNECTION;
    public static final AsciiString CONTENT_BASE = HttpHeaderNames.CONTENT_BASE;
    public static final AsciiString CONTENT_ENCODING = HttpHeaderNames.CONTENT_ENCODING;
    public static final AsciiString CONTENT_LANGUAGE = HttpHeaderNames.CONTENT_LANGUAGE;
    public static final AsciiString CONTENT_LENGTH = HttpHeaderNames.CONTENT_LENGTH;
    public static final AsciiString CONTENT_LOCATION = HttpHeaderNames.CONTENT_LOCATION;
    public static final AsciiString CONTENT_TYPE = HttpHeaderNames.CONTENT_TYPE;
    public static final AsciiString CSEQ = AsciiString.cached((String)"cseq");
    public static final AsciiString DATE = HttpHeaderNames.DATE;
    public static final AsciiString EXPIRES = HttpHeaderNames.EXPIRES;
    public static final AsciiString FROM = HttpHeaderNames.FROM;
    public static final AsciiString HOST = HttpHeaderNames.HOST;
    public static final AsciiString IF_MATCH = HttpHeaderNames.IF_MATCH;
    public static final AsciiString IF_MODIFIED_SINCE = HttpHeaderNames.IF_MODIFIED_SINCE;
    public static final AsciiString KEYMGMT = AsciiString.cached((String)"keymgmt");
    public static final AsciiString LAST_MODIFIED = HttpHeaderNames.LAST_MODIFIED;
    public static final AsciiString PROXY_AUTHENTICATE = HttpHeaderNames.PROXY_AUTHENTICATE;
    public static final AsciiString PROXY_REQUIRE = AsciiString.cached((String)"proxy-require");
    public static final AsciiString PUBLIC = AsciiString.cached((String)"public");
    public static final AsciiString RANGE = HttpHeaderNames.RANGE;
    public static final AsciiString REFERER = HttpHeaderNames.REFERER;
    public static final AsciiString REQUIRE = AsciiString.cached((String)"require");
    public static final AsciiString RETRT_AFTER = HttpHeaderNames.RETRY_AFTER;
    public static final AsciiString RTP_INFO = AsciiString.cached((String)"rtp-info");
    public static final AsciiString SCALE = AsciiString.cached((String)"scale");
    public static final AsciiString SESSION = AsciiString.cached((String)"session");
    public static final AsciiString SERVER = HttpHeaderNames.SERVER;
    public static final AsciiString SPEED = AsciiString.cached((String)"speed");
    public static final AsciiString TIMESTAMP = AsciiString.cached((String)"timestamp");
    public static final AsciiString TRANSPORT = AsciiString.cached((String)"transport");
    public static final AsciiString UNSUPPORTED = AsciiString.cached((String)"unsupported");
    public static final AsciiString USER_AGENT = HttpHeaderNames.USER_AGENT;
    public static final AsciiString VARY = HttpHeaderNames.VARY;
    public static final AsciiString VIA = HttpHeaderNames.VIA;
    public static final AsciiString WWW_AUTHENTICATE = HttpHeaderNames.WWW_AUTHENTICATE;

    private RtspHeaderNames() {
    }
}


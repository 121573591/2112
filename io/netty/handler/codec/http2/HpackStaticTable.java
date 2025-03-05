/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.AsciiString
 *  io.netty.util.internal.PlatformDependent
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 */
package io.netty.handler.codec.http2;

import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http2.HpackHeaderField;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.internal.PlatformDependent;
import java.util.Arrays;
import java.util.List;

final class HpackStaticTable {
    static final int NOT_FOUND = -1;
    private static final List<HpackHeaderField> STATIC_TABLE;
    private static final int HEADER_NAMES_TABLE_SIZE = 512;
    private static final int HEADER_NAMES_TABLE_SHIFT;
    private static final HeaderNameIndex[] HEADER_NAMES;
    private static final int HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SIZE = 64;
    private static final int HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT;
    private static final HeaderIndex[] HEADERS_WITH_NON_EMPTY_VALUES;
    static final int length;

    private static HpackHeaderField newEmptyHeaderField(AsciiString name) {
        return new HpackHeaderField((CharSequence)name, (CharSequence)AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newEmptyHeaderField(String name) {
        return new HpackHeaderField((CharSequence)AsciiString.cached((String)name), (CharSequence)AsciiString.EMPTY_STRING);
    }

    private static HpackHeaderField newHeaderField(AsciiString name, String value) {
        return new HpackHeaderField((CharSequence)name, (CharSequence)AsciiString.cached((String)value));
    }

    private static HpackHeaderField newPseudoHeaderMethodField(HttpMethod method) {
        return new HpackHeaderField((CharSequence)Http2Headers.PseudoHeaderName.METHOD.value(), (CharSequence)method.asciiName());
    }

    private static HpackHeaderField newPseudoHeaderField(Http2Headers.PseudoHeaderName name, AsciiString value) {
        return new HpackHeaderField((CharSequence)name.value(), (CharSequence)value);
    }

    private static HpackHeaderField newPseudoHeaderField(Http2Headers.PseudoHeaderName name, String value) {
        return new HpackHeaderField((CharSequence)name.value(), (CharSequence)AsciiString.cached((String)value));
    }

    private static HpackHeaderField newEmptyPseudoHeaderField(Http2Headers.PseudoHeaderName name) {
        return new HpackHeaderField((CharSequence)name.value(), (CharSequence)AsciiString.EMPTY_STRING);
    }

    static HpackHeaderField getEntry(int index) {
        return (HpackHeaderField)STATIC_TABLE.get(index - 1);
    }

    static int getIndex(CharSequence name) {
        HeaderNameIndex entry = HpackStaticTable.getEntry(name);
        return entry == null ? -1 : entry.index;
    }

    static int getIndexInsensitive(CharSequence name, CharSequence value) {
        if (value.length() == 0) {
            HeaderNameIndex entry = HpackStaticTable.getEntry(name);
            return entry == null || !entry.emptyValue ? -1 : entry.index;
        }
        int bucket = HpackStaticTable.headerBucket(value);
        HeaderIndex header = HEADERS_WITH_NON_EMPTY_VALUES[bucket];
        if (header == null) {
            return -1;
        }
        if (HpackUtil.equalsVariableTime(header.name, name) && HpackUtil.equalsVariableTime(header.value, value)) {
            return header.index;
        }
        return -1;
    }

    private static HeaderNameIndex getEntry(CharSequence name) {
        int bucket = HpackStaticTable.headerNameBucket(name);
        HeaderNameIndex entry = HEADER_NAMES[bucket];
        if (entry == null) {
            return null;
        }
        return HpackUtil.equalsVariableTime(entry.name, name) ? entry : null;
    }

    private static int headerNameBucket(CharSequence name) {
        return HpackStaticTable.bucket(name, HEADER_NAMES_TABLE_SHIFT, 511);
    }

    private static int headerBucket(CharSequence value) {
        return HpackStaticTable.bucket(value, HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT, 63);
    }

    private static int bucket(CharSequence s, int shift, int mask) {
        return AsciiString.hashCode((CharSequence)s) >> shift & mask;
    }

    private HpackStaticTable() {
    }

    static {
        Object tableEntry;
        int bucket;
        HpackHeaderField entry;
        int index;
        STATIC_TABLE = Arrays.asList((Object[])new HpackHeaderField[]{HpackStaticTable.newEmptyPseudoHeaderField(Http2Headers.PseudoHeaderName.AUTHORITY), HpackStaticTable.newPseudoHeaderMethodField(HttpMethod.GET), HpackStaticTable.newPseudoHeaderMethodField(HttpMethod.POST), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.PATH, "/"), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.PATH, "/index.html"), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.SCHEME, "http"), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.SCHEME, "https"), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.OK.codeAsText()), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.NO_CONTENT.codeAsText()), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.PARTIAL_CONTENT.codeAsText()), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.NOT_MODIFIED.codeAsText()), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.BAD_REQUEST.codeAsText()), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.NOT_FOUND.codeAsText()), HpackStaticTable.newPseudoHeaderField(Http2Headers.PseudoHeaderName.STATUS, HttpResponseStatus.INTERNAL_SERVER_ERROR.codeAsText()), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ACCEPT_CHARSET), HpackStaticTable.newHeaderField(HttpHeaderNames.ACCEPT_ENCODING, "gzip, deflate"), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ACCEPT_LANGUAGE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ACCEPT_RANGES), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ACCEPT), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.AGE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ALLOW), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.AUTHORIZATION), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CACHE_CONTROL), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_DISPOSITION), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_ENCODING), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_LANGUAGE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_LENGTH), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_LOCATION), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_RANGE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.CONTENT_TYPE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.COOKIE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.DATE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.ETAG), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.EXPECT), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.EXPIRES), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.FROM), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.HOST), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.IF_MATCH), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.IF_MODIFIED_SINCE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.IF_NONE_MATCH), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.IF_RANGE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.IF_UNMODIFIED_SINCE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.LAST_MODIFIED), HpackStaticTable.newEmptyHeaderField("link"), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.LOCATION), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.MAX_FORWARDS), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.PROXY_AUTHENTICATE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.PROXY_AUTHORIZATION), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.RANGE), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.REFERER), HpackStaticTable.newEmptyHeaderField("refresh"), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.RETRY_AFTER), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.SERVER), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.SET_COOKIE), HpackStaticTable.newEmptyHeaderField("strict-transport-security"), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.TRANSFER_ENCODING), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.USER_AGENT), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.VARY), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.VIA), HpackStaticTable.newEmptyHeaderField(HttpHeaderNames.WWW_AUTHENTICATE)});
        HEADER_NAMES_TABLE_SHIFT = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? 22 : 18;
        HEADER_NAMES = new HeaderNameIndex[512];
        for (index = STATIC_TABLE.size(); index > 0; --index) {
            entry = HpackStaticTable.getEntry(index);
            bucket = HpackStaticTable.headerNameBucket(entry.name);
            tableEntry = HEADER_NAMES[bucket];
            if (tableEntry != null && !HpackUtil.equalsVariableTime(((HeaderNameIndex)tableEntry).name, entry.name)) {
                throw new IllegalStateException("Hash bucket collision between " + ((HeaderNameIndex)tableEntry).name + " and " + entry.name);
            }
            HpackStaticTable.HEADER_NAMES[bucket] = new HeaderNameIndex(entry.name, index, entry.value.length() == 0);
        }
        HEADERS_WITH_NON_EMPTY_VALUES_TABLE_SHIFT = PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? 0 : 6;
        HEADERS_WITH_NON_EMPTY_VALUES = new HeaderIndex[64];
        for (index = STATIC_TABLE.size(); index > 0; --index) {
            entry = HpackStaticTable.getEntry(index);
            if (entry.value.length() <= 0) continue;
            bucket = HpackStaticTable.headerBucket(entry.value);
            tableEntry = HEADERS_WITH_NON_EMPTY_VALUES[bucket];
            if (tableEntry != null) {
                throw new IllegalStateException("Hash bucket collision between " + ((HeaderIndex)tableEntry).value + " and " + entry.value);
            }
            HpackStaticTable.HEADERS_WITH_NON_EMPTY_VALUES[bucket] = new HeaderIndex(entry.name, entry.value, index);
        }
        length = STATIC_TABLE.size();
    }

    private static final class HeaderIndex {
        final CharSequence name;
        final CharSequence value;
        final int index;

        HeaderIndex(CharSequence name, CharSequence value, int index) {
            this.name = name;
            this.value = value;
            this.index = index;
        }
    }

    private static final class HeaderNameIndex {
        final CharSequence name;
        final int index;
        final boolean emptyValue;

        HeaderNameIndex(CharSequence name, int index, boolean emptyValue) {
            this.name = name;
            this.index = index;
            this.emptyValue = emptyValue;
        }
    }
}


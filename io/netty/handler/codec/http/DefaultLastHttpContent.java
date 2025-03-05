/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.Unpooled
 *  io.netty.util.internal.ObjectUtil
 *  io.netty.util.internal.StringUtil
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map$Entry
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultHttpHeadersFactory;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpHeadersFactory;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Map;

public class DefaultLastHttpContent
extends DefaultHttpContent
implements LastHttpContent {
    private final HttpHeaders trailingHeaders;

    public DefaultLastHttpContent() {
        this(Unpooled.buffer((int)0));
    }

    public DefaultLastHttpContent(ByteBuf content) {
        this(content, DefaultHttpHeadersFactory.trailersFactory());
    }

    @Deprecated
    public DefaultLastHttpContent(ByteBuf content, boolean validateHeaders) {
        this(content, DefaultHttpHeadersFactory.trailersFactory().withValidation(validateHeaders));
    }

    public DefaultLastHttpContent(ByteBuf content, HttpHeadersFactory trailersFactory) {
        super(content);
        this.trailingHeaders = trailersFactory.newHeaders();
    }

    public DefaultLastHttpContent(ByteBuf content, HttpHeaders trailingHeaders) {
        super(content);
        this.trailingHeaders = (HttpHeaders)ObjectUtil.checkNotNull((Object)trailingHeaders, (String)"trailingHeaders");
    }

    @Override
    public LastHttpContent copy() {
        return this.replace(this.content().copy());
    }

    @Override
    public LastHttpContent duplicate() {
        return this.replace(this.content().duplicate());
    }

    @Override
    public LastHttpContent retainedDuplicate() {
        return this.replace(this.content().retainedDuplicate());
    }

    @Override
    public LastHttpContent replace(ByteBuf content) {
        return new DefaultLastHttpContent(content, this.trailingHeaders().copy());
    }

    @Override
    public LastHttpContent retain(int increment) {
        super.retain(increment);
        return this;
    }

    @Override
    public LastHttpContent retain() {
        super.retain();
        return this;
    }

    @Override
    public LastHttpContent touch() {
        super.touch();
        return this;
    }

    @Override
    public LastHttpContent touch(Object hint) {
        super.touch(hint);
        return this;
    }

    @Override
    public HttpHeaders trailingHeaders() {
        return this.trailingHeaders;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(super.toString());
        buf.append(StringUtil.NEWLINE);
        this.appendHeaders(buf);
        buf.setLength(buf.length() - StringUtil.NEWLINE.length());
        return buf.toString();
    }

    private void appendHeaders(StringBuilder buf) {
        for (Map.Entry e : this.trailingHeaders()) {
            buf.append((String)e.getKey());
            buf.append(": ");
            buf.append((String)e.getValue());
            buf.append(StringUtil.NEWLINE);
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.StringUtil
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.netty.handler.codec.spdy;

import io.netty.handler.codec.spdy.DefaultSpdyHeadersFrame;
import io.netty.handler.codec.spdy.SpdySynReplyFrame;
import io.netty.util.internal.StringUtil;

public class DefaultSpdySynReplyFrame
extends DefaultSpdyHeadersFrame
implements SpdySynReplyFrame {
    public DefaultSpdySynReplyFrame(int streamId) {
        super(streamId);
    }

    public DefaultSpdySynReplyFrame(int streamId, boolean validateHeaders) {
        super(streamId, validateHeaders);
    }

    @Override
    public SpdySynReplyFrame setStreamId(int streamId) {
        super.setStreamId(streamId);
        return this;
    }

    @Override
    public SpdySynReplyFrame setLast(boolean last) {
        super.setLast(last);
        return this;
    }

    @Override
    public SpdySynReplyFrame setInvalid() {
        super.setInvalid();
        return this;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder().append(StringUtil.simpleClassName((Object)this)).append("(last: ").append(this.isLast()).append(')').append(StringUtil.NEWLINE).append("--> Stream-ID = ").append(this.streamId()).append(StringUtil.NEWLINE).append("--> Headers:").append(StringUtil.NEWLINE);
        this.appendHeaders(buf);
        buf.setLength(buf.length() - StringUtil.NEWLINE.length());
        return buf.toString();
    }
}


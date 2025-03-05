/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufAllocator
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.handler.codec.MessageToMessageDecoder
 *  io.netty.handler.codec.TooLongFrameException
 *  io.netty.util.ReferenceCountUtil
 *  io.netty.util.internal.ObjectUtil
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpHeadersFactory;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeadersFactory;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.spdy.DefaultSpdyRstStreamFrame;
import io.netty.handler.codec.spdy.DefaultSpdySynReplyFrame;
import io.netty.handler.codec.spdy.SpdyCodecUtil;
import io.netty.handler.codec.spdy.SpdyDataFrame;
import io.netty.handler.codec.spdy.SpdyFrame;
import io.netty.handler.codec.spdy.SpdyHeaders;
import io.netty.handler.codec.spdy.SpdyHeadersFrame;
import io.netty.handler.codec.spdy.SpdyHttpHeaders;
import io.netty.handler.codec.spdy.SpdyRstStreamFrame;
import io.netty.handler.codec.spdy.SpdyStreamStatus;
import io.netty.handler.codec.spdy.SpdySynReplyFrame;
import io.netty.handler.codec.spdy.SpdySynStreamFrame;
import io.netty.handler.codec.spdy.SpdyVersion;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SpdyHttpDecoder
extends MessageToMessageDecoder<SpdyFrame> {
    private final int spdyVersion;
    private final int maxContentLength;
    private final Map<Integer, FullHttpMessage> messageMap;
    private final HttpHeadersFactory headersFactory;
    private final HttpHeadersFactory trailersFactory;

    public SpdyHttpDecoder(SpdyVersion version, int maxContentLength) {
        this(version, maxContentLength, (Map<Integer, FullHttpMessage>)new HashMap(), DefaultHttpHeadersFactory.headersFactory(), DefaultHttpHeadersFactory.trailersFactory());
    }

    @Deprecated
    public SpdyHttpDecoder(SpdyVersion version, int maxContentLength, boolean validateHeaders) {
        this(version, maxContentLength, (Map<Integer, FullHttpMessage>)new HashMap(), validateHeaders);
    }

    protected SpdyHttpDecoder(SpdyVersion version, int maxContentLength, Map<Integer, FullHttpMessage> messageMap) {
        this(version, maxContentLength, messageMap, DefaultHttpHeadersFactory.headersFactory(), DefaultHttpHeadersFactory.trailersFactory());
    }

    @Deprecated
    protected SpdyHttpDecoder(SpdyVersion version, int maxContentLength, Map<Integer, FullHttpMessage> messageMap, boolean validateHeaders) {
        this(version, maxContentLength, messageMap, DefaultHttpHeadersFactory.headersFactory().withValidation(validateHeaders), DefaultHttpHeadersFactory.trailersFactory().withValidation(validateHeaders));
    }

    protected SpdyHttpDecoder(SpdyVersion version, int maxContentLength, Map<Integer, FullHttpMessage> messageMap, HttpHeadersFactory headersFactory, HttpHeadersFactory trailersFactory) {
        this.spdyVersion = ((SpdyVersion)((Object)ObjectUtil.checkNotNull((Object)((Object)version), (String)"version"))).getVersion();
        this.maxContentLength = ObjectUtil.checkPositive((int)maxContentLength, (String)"maxContentLength");
        this.messageMap = messageMap;
        this.headersFactory = headersFactory;
        this.trailersFactory = trailersFactory;
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        for (Map.Entry entry : this.messageMap.entrySet()) {
            ReferenceCountUtil.safeRelease((Object)entry.getValue());
        }
        this.messageMap.clear();
        super.channelInactive(ctx);
    }

    protected FullHttpMessage putMessage(int streamId, FullHttpMessage message) {
        return (FullHttpMessage)this.messageMap.put((Object)streamId, (Object)message);
    }

    protected FullHttpMessage getMessage(int streamId) {
        return (FullHttpMessage)this.messageMap.get((Object)streamId);
    }

    protected FullHttpMessage removeMessage(int streamId) {
        return (FullHttpMessage)this.messageMap.remove((Object)streamId);
    }

    protected void decode(ChannelHandlerContext ctx, SpdyFrame msg, List<Object> out) throws Exception {
        block37: {
            if (msg instanceof SpdySynStreamFrame) {
                SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame)msg;
                int streamId = spdySynStreamFrame.streamId();
                if (SpdyCodecUtil.isServerId(streamId)) {
                    int associatedToStreamId = spdySynStreamFrame.associatedStreamId();
                    if (associatedToStreamId == 0) {
                        DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.INVALID_STREAM);
                        ctx.writeAndFlush((Object)spdyRstStreamFrame);
                        return;
                    }
                    if (spdySynStreamFrame.isLast()) {
                        DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                        ctx.writeAndFlush((Object)spdyRstStreamFrame);
                        return;
                    }
                    if (spdySynStreamFrame.isTruncated()) {
                        DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.INTERNAL_ERROR);
                        ctx.writeAndFlush((Object)spdyRstStreamFrame);
                        return;
                    }
                    try {
                        FullHttpRequest httpRequestWithEntity = SpdyHttpDecoder.createHttpRequest(spdySynStreamFrame, ctx.alloc());
                        httpRequestWithEntity.headers().setInt((CharSequence)SpdyHttpHeaders.Names.STREAM_ID, streamId);
                        httpRequestWithEntity.headers().setInt((CharSequence)SpdyHttpHeaders.Names.ASSOCIATED_TO_STREAM_ID, associatedToStreamId);
                        httpRequestWithEntity.headers().setInt((CharSequence)SpdyHttpHeaders.Names.PRIORITY, spdySynStreamFrame.priority());
                        out.add((Object)httpRequestWithEntity);
                    }
                    catch (Throwable ignored) {
                        DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                        ctx.writeAndFlush((Object)spdyRstStreamFrame);
                    }
                } else {
                    if (spdySynStreamFrame.isTruncated()) {
                        DefaultSpdySynReplyFrame spdySynReplyFrame = new DefaultSpdySynReplyFrame(streamId);
                        spdySynReplyFrame.setLast(true);
                        SpdyHeaders frameHeaders = spdySynReplyFrame.headers();
                        frameHeaders.setInt(SpdyHeaders.HttpNames.STATUS, HttpResponseStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.code());
                        frameHeaders.setObject(SpdyHeaders.HttpNames.VERSION, HttpVersion.HTTP_1_0);
                        ctx.writeAndFlush((Object)spdySynReplyFrame);
                        return;
                    }
                    try {
                        FullHttpRequest httpRequestWithEntity = SpdyHttpDecoder.createHttpRequest(spdySynStreamFrame, ctx.alloc());
                        httpRequestWithEntity.headers().setInt((CharSequence)SpdyHttpHeaders.Names.STREAM_ID, streamId);
                        if (spdySynStreamFrame.isLast()) {
                            out.add((Object)httpRequestWithEntity);
                            break block37;
                        }
                        this.putMessage(streamId, httpRequestWithEntity);
                    }
                    catch (Throwable t) {
                        DefaultSpdySynReplyFrame spdySynReplyFrame = new DefaultSpdySynReplyFrame(streamId);
                        spdySynReplyFrame.setLast(true);
                        SpdyHeaders frameHeaders = spdySynReplyFrame.headers();
                        frameHeaders.setInt(SpdyHeaders.HttpNames.STATUS, HttpResponseStatus.BAD_REQUEST.code());
                        frameHeaders.setObject(SpdyHeaders.HttpNames.VERSION, HttpVersion.HTTP_1_0);
                        ctx.writeAndFlush((Object)spdySynReplyFrame);
                    }
                }
            } else if (msg instanceof SpdySynReplyFrame) {
                SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame)msg;
                int streamId = spdySynReplyFrame.streamId();
                if (spdySynReplyFrame.isTruncated()) {
                    DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.INTERNAL_ERROR);
                    ctx.writeAndFlush((Object)spdyRstStreamFrame);
                    return;
                }
                try {
                    FullHttpResponse httpResponseWithEntity = this.createHttpResponse(spdySynReplyFrame, ctx.alloc());
                    httpResponseWithEntity.headers().setInt((CharSequence)SpdyHttpHeaders.Names.STREAM_ID, streamId);
                    if (spdySynReplyFrame.isLast()) {
                        HttpUtil.setContentLength(httpResponseWithEntity, 0L);
                        out.add((Object)httpResponseWithEntity);
                        break block37;
                    }
                    this.putMessage(streamId, httpResponseWithEntity);
                }
                catch (Throwable t) {
                    DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                    ctx.writeAndFlush((Object)spdyRstStreamFrame);
                }
            } else if (msg instanceof SpdyHeadersFrame) {
                SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame)msg;
                int streamId = spdyHeadersFrame.streamId();
                FullHttpMessage fullHttpMessage = this.getMessage(streamId);
                if (fullHttpMessage == null) {
                    if (SpdyCodecUtil.isServerId(streamId)) {
                        if (spdyHeadersFrame.isTruncated()) {
                            DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.INTERNAL_ERROR);
                            ctx.writeAndFlush((Object)spdyRstStreamFrame);
                            return;
                        }
                        try {
                            fullHttpMessage = this.createHttpResponse(spdyHeadersFrame, ctx.alloc());
                            fullHttpMessage.headers().setInt((CharSequence)SpdyHttpHeaders.Names.STREAM_ID, streamId);
                            if (spdyHeadersFrame.isLast()) {
                                HttpUtil.setContentLength(fullHttpMessage, 0L);
                                out.add((Object)fullHttpMessage);
                            } else {
                                this.putMessage(streamId, fullHttpMessage);
                            }
                        }
                        catch (Throwable t) {
                            DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                            ctx.writeAndFlush((Object)spdyRstStreamFrame);
                        }
                    }
                    return;
                }
                if (!spdyHeadersFrame.isTruncated()) {
                    Iterator t = spdyHeadersFrame.headers().iterator();
                    while (t.hasNext()) {
                        Map.Entry e = (Map.Entry)t.next();
                        fullHttpMessage.headers().add((CharSequence)e.getKey(), e.getValue());
                    }
                }
                if (spdyHeadersFrame.isLast()) {
                    HttpUtil.setContentLength(fullHttpMessage, fullHttpMessage.content().readableBytes());
                    this.removeMessage(streamId);
                    out.add((Object)fullHttpMessage);
                }
            } else if (msg instanceof SpdyDataFrame) {
                SpdyDataFrame spdyDataFrame = (SpdyDataFrame)msg;
                int streamId = spdyDataFrame.streamId();
                FullHttpMessage fullHttpMessage = this.getMessage(streamId);
                if (fullHttpMessage == null) {
                    return;
                }
                ByteBuf content = fullHttpMessage.content();
                if (content.readableBytes() > this.maxContentLength - spdyDataFrame.content().readableBytes()) {
                    this.removeMessage(streamId);
                    throw new TooLongFrameException("HTTP content length exceeded " + this.maxContentLength + " bytes.");
                }
                ByteBuf spdyDataFrameData = spdyDataFrame.content();
                int spdyDataFrameDataLen = spdyDataFrameData.readableBytes();
                content.writeBytes(spdyDataFrameData, spdyDataFrameData.readerIndex(), spdyDataFrameDataLen);
                if (spdyDataFrame.isLast()) {
                    HttpUtil.setContentLength(fullHttpMessage, content.readableBytes());
                    this.removeMessage(streamId);
                    out.add((Object)fullHttpMessage);
                }
            } else if (msg instanceof SpdyRstStreamFrame) {
                SpdyRstStreamFrame spdyRstStreamFrame = (SpdyRstStreamFrame)msg;
                int streamId = spdyRstStreamFrame.streamId();
                this.removeMessage(streamId);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static FullHttpRequest createHttpRequest(SpdyHeadersFrame requestFrame, ByteBufAllocator alloc) throws Exception {
        SpdyHeaders headers = requestFrame.headers();
        HttpMethod method = HttpMethod.valueOf(headers.getAsString((CharSequence)SpdyHeaders.HttpNames.METHOD));
        String url = headers.getAsString((CharSequence)SpdyHeaders.HttpNames.PATH);
        HttpVersion httpVersion = HttpVersion.valueOf(headers.getAsString((CharSequence)SpdyHeaders.HttpNames.VERSION));
        headers.remove(SpdyHeaders.HttpNames.METHOD);
        headers.remove(SpdyHeaders.HttpNames.PATH);
        headers.remove(SpdyHeaders.HttpNames.VERSION);
        boolean release = true;
        ByteBuf buffer = alloc.buffer();
        try {
            DefaultFullHttpRequest req = new DefaultFullHttpRequest(httpVersion, method, url, buffer);
            headers.remove(SpdyHeaders.HttpNames.SCHEME);
            CharSequence host = (CharSequence)headers.get(SpdyHeaders.HttpNames.HOST);
            headers.remove(SpdyHeaders.HttpNames.HOST);
            req.headers().set((CharSequence)HttpHeaderNames.HOST, (Object)host);
            Object object = requestFrame.headers().iterator();
            while (object.hasNext()) {
                Map.Entry e = (Map.Entry)object.next();
                req.headers().add((CharSequence)e.getKey(), e.getValue());
            }
            HttpUtil.setKeepAlive(req, true);
            req.headers().remove((CharSequence)HttpHeaderNames.TRANSFER_ENCODING);
            release = false;
            object = req;
            return object;
        }
        finally {
            if (release) {
                buffer.release();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FullHttpResponse createHttpResponse(SpdyHeadersFrame responseFrame, ByteBufAllocator alloc) throws Exception {
        SpdyHeaders headers = responseFrame.headers();
        HttpResponseStatus status = HttpResponseStatus.parseLine((CharSequence)headers.get(SpdyHeaders.HttpNames.STATUS));
        HttpVersion version = HttpVersion.valueOf(headers.getAsString((CharSequence)SpdyHeaders.HttpNames.VERSION));
        headers.remove(SpdyHeaders.HttpNames.STATUS);
        headers.remove(SpdyHeaders.HttpNames.VERSION);
        boolean release = true;
        ByteBuf buffer = alloc.buffer();
        try {
            DefaultFullHttpResponse res = new DefaultFullHttpResponse(version, status, buffer, this.headersFactory, this.trailersFactory);
            Object object = responseFrame.headers().iterator();
            while (object.hasNext()) {
                Map.Entry e = (Map.Entry)object.next();
                res.headers().add((CharSequence)e.getKey(), e.getValue());
            }
            HttpUtil.setKeepAlive(res, true);
            res.headers().remove((CharSequence)HttpHeaderNames.TRANSFER_ENCODING);
            res.headers().remove((CharSequence)HttpHeaderNames.TRAILER);
            release = false;
            object = res;
            return object;
        }
        finally {
            if (release) {
                buffer.release();
            }
        }
    }
}


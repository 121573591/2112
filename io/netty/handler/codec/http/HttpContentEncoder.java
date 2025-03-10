/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.netty.buffer.ByteBufHolder
 *  io.netty.buffer.Unpooled
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.embedded.EmbeddedChannel
 *  io.netty.handler.codec.DecoderResult
 *  io.netty.handler.codec.MessageToMessageCodec
 *  io.netty.util.ReferenceCountUtil
 *  io.netty.util.internal.ObjectUtil
 *  io.netty.util.internal.StringUtil
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.List
 *  java.util.Queue
 */
package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.ComposedLastHttpContent;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpContentDecoder;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public abstract class HttpContentEncoder
extends MessageToMessageCodec<HttpRequest, HttpObject> {
    private static final CharSequence ZERO_LENGTH_HEAD = "HEAD";
    private static final CharSequence ZERO_LENGTH_CONNECT = "CONNECT";
    private final Queue<CharSequence> acceptEncodingQueue = new ArrayDeque();
    private EmbeddedChannel encoder;
    private State state = State.AWAIT_HEADERS;

    public boolean acceptOutboundMessage(Object msg) throws Exception {
        return msg instanceof HttpContent || msg instanceof HttpResponse;
    }

    protected void decode(ChannelHandlerContext ctx, HttpRequest msg, List<Object> out) throws Exception {
        String acceptEncoding;
        List<String> acceptEncodingHeaders = msg.headers().getAll((CharSequence)HttpHeaderNames.ACCEPT_ENCODING);
        switch (acceptEncodingHeaders.size()) {
            case 0: {
                acceptEncoding = HttpContentDecoder.IDENTITY;
                break;
            }
            case 1: {
                acceptEncoding = (CharSequence)acceptEncodingHeaders.get(0);
                break;
            }
            default: {
                acceptEncoding = StringUtil.join((CharSequence)",", acceptEncodingHeaders);
            }
        }
        HttpMethod method = msg.method();
        if (HttpMethod.HEAD.equals(method)) {
            acceptEncoding = ZERO_LENGTH_HEAD;
        } else if (HttpMethod.CONNECT.equals(method)) {
            acceptEncoding = ZERO_LENGTH_CONNECT;
        }
        this.acceptEncodingQueue.add((Object)acceptEncoding);
        out.add(ReferenceCountUtil.retain((Object)msg));
    }

    protected void encode(ChannelHandlerContext ctx, HttpObject msg, List<Object> out) throws Exception {
        boolean isFull = msg instanceof HttpResponse && msg instanceof LastHttpContent;
        switch (this.state) {
            case AWAIT_HEADERS: {
                CharSequence acceptEncoding;
                HttpContentEncoder.ensureHeaders(msg);
                assert (this.encoder == null);
                HttpResponse res = (HttpResponse)msg;
                int code = res.status().code();
                HttpStatusClass codeClass = res.status().codeClass();
                if (codeClass == HttpStatusClass.INFORMATIONAL) {
                    acceptEncoding = null;
                } else {
                    acceptEncoding = (CharSequence)this.acceptEncodingQueue.poll();
                    if (acceptEncoding == null) {
                        throw new IllegalStateException("cannot send more responses than requests");
                    }
                }
                if (HttpContentEncoder.isPassthru(res.protocolVersion(), code, acceptEncoding)) {
                    if (isFull) {
                        out.add(ReferenceCountUtil.retain((Object)res));
                        break;
                    }
                    out.add(ReferenceCountUtil.retain((Object)res));
                    this.state = State.PASS_THROUGH;
                    break;
                }
                if (isFull && !((ByteBufHolder)res).content().isReadable()) {
                    out.add(ReferenceCountUtil.retain((Object)res));
                    break;
                }
                Result result = this.beginEncode(res, acceptEncoding.toString());
                if (result == null) {
                    if (isFull) {
                        out.add(ReferenceCountUtil.retain((Object)res));
                        break;
                    }
                    out.add(ReferenceCountUtil.retain((Object)res));
                    this.state = State.PASS_THROUGH;
                    break;
                }
                this.encoder = result.contentEncoder();
                res.headers().set((CharSequence)HttpHeaderNames.CONTENT_ENCODING, (Object)result.targetContentEncoding());
                if (isFull) {
                    DefaultHttpResponse newRes = new DefaultHttpResponse(res.protocolVersion(), res.status());
                    newRes.headers().set(res.headers());
                    out.add((Object)newRes);
                    HttpContentEncoder.ensureContent(res);
                    this.encodeFullResponse(newRes, (HttpContent)((Object)res), out);
                    break;
                }
                res.headers().remove((CharSequence)HttpHeaderNames.CONTENT_LENGTH);
                res.headers().set((CharSequence)HttpHeaderNames.TRANSFER_ENCODING, (Object)HttpHeaderValues.CHUNKED);
                out.add(ReferenceCountUtil.retain((Object)res));
                this.state = State.AWAIT_CONTENT;
                if (!(msg instanceof HttpContent)) break;
            }
            case AWAIT_CONTENT: {
                HttpContentEncoder.ensureContent(msg);
                if (this.encodeContent((HttpContent)msg, out)) {
                    this.state = State.AWAIT_HEADERS;
                    break;
                }
                if (!out.isEmpty()) break;
                out.add((Object)new DefaultHttpContent(Unpooled.EMPTY_BUFFER));
                break;
            }
            case PASS_THROUGH: {
                HttpContentEncoder.ensureContent(msg);
                out.add(ReferenceCountUtil.retain((Object)msg));
                if (!(msg instanceof LastHttpContent)) break;
                this.state = State.AWAIT_HEADERS;
            }
        }
    }

    private void encodeFullResponse(HttpResponse newRes, HttpContent content, List<Object> out) {
        int existingMessages = out.size();
        this.encodeContent(content, out);
        if (HttpUtil.isContentLengthSet(newRes)) {
            int messageSize = 0;
            for (int i = existingMessages; i < out.size(); ++i) {
                Object item = out.get(i);
                if (!(item instanceof HttpContent)) continue;
                messageSize += ((HttpContent)item).content().readableBytes();
            }
            HttpUtil.setContentLength(newRes, messageSize);
        } else {
            newRes.headers().set((CharSequence)HttpHeaderNames.TRANSFER_ENCODING, (Object)HttpHeaderValues.CHUNKED);
        }
    }

    private static boolean isPassthru(HttpVersion version, int code, CharSequence httpMethod) {
        return code < 200 || code == 204 || code == 304 || httpMethod == ZERO_LENGTH_HEAD || httpMethod == ZERO_LENGTH_CONNECT && code == 200 || version == HttpVersion.HTTP_1_0;
    }

    private static void ensureHeaders(HttpObject msg) {
        if (!(msg instanceof HttpResponse)) {
            throw new IllegalStateException("unexpected message type: " + msg.getClass().getName() + " (expected: " + HttpResponse.class.getSimpleName() + ')');
        }
    }

    private static void ensureContent(HttpObject msg) {
        if (!(msg instanceof HttpContent)) {
            throw new IllegalStateException("unexpected message type: " + msg.getClass().getName() + " (expected: " + HttpContent.class.getSimpleName() + ')');
        }
    }

    private boolean encodeContent(HttpContent c, List<Object> out) {
        ByteBuf content = c.content();
        this.encode(content, out);
        if (c instanceof LastHttpContent) {
            this.finishEncode(out);
            LastHttpContent last = (LastHttpContent)c;
            HttpHeaders headers = last.trailingHeaders();
            if (headers.isEmpty()) {
                out.add((Object)LastHttpContent.EMPTY_LAST_CONTENT);
            } else {
                out.add((Object)new ComposedLastHttpContent(headers, DecoderResult.SUCCESS));
            }
            return true;
        }
        return false;
    }

    protected abstract Result beginEncode(HttpResponse var1, String var2) throws Exception;

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        this.cleanupSafely(ctx);
        super.handlerRemoved(ctx);
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        this.cleanupSafely(ctx);
        super.channelInactive(ctx);
    }

    private void cleanup() {
        if (this.encoder != null) {
            this.encoder.finishAndReleaseAll();
            this.encoder = null;
        }
    }

    private void cleanupSafely(ChannelHandlerContext ctx) {
        try {
            this.cleanup();
        }
        catch (Throwable cause) {
            ctx.fireExceptionCaught(cause);
        }
    }

    private void encode(ByteBuf in, List<Object> out) {
        this.encoder.writeOutbound(new Object[]{in.retain()});
        this.fetchEncoderOutput(out);
    }

    private void finishEncode(List<Object> out) {
        if (this.encoder.finish()) {
            this.fetchEncoderOutput(out);
        }
        this.encoder = null;
    }

    private void fetchEncoderOutput(List<Object> out) {
        ByteBuf buf;
        while ((buf = (ByteBuf)this.encoder.readOutbound()) != null) {
            if (!buf.isReadable()) {
                buf.release();
                continue;
            }
            out.add((Object)new DefaultHttpContent(buf));
        }
    }

    public static final class Result {
        private final String targetContentEncoding;
        private final EmbeddedChannel contentEncoder;

        public Result(String targetContentEncoding, EmbeddedChannel contentEncoder) {
            this.targetContentEncoding = (String)ObjectUtil.checkNotNull((Object)targetContentEncoding, (String)"targetContentEncoding");
            this.contentEncoder = (EmbeddedChannel)ObjectUtil.checkNotNull((Object)contentEncoder, (String)"contentEncoder");
        }

        public String targetContentEncoding() {
            return this.targetContentEncoding;
        }

        public EmbeddedChannel contentEncoder() {
            return this.contentEncoder;
        }
    }

    private static enum State {
        PASS_THROUGH,
        AWAIT_HEADERS,
        AWAIT_CONTENT;

    }
}


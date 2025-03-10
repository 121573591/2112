/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandler
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelOption
 *  io.netty.channel.ChannelPipeline
 *  io.netty.util.AttributeKey
 *  io.netty.util.concurrent.EventExecutor
 *  io.netty.util.concurrent.Future
 *  io.netty.util.concurrent.GenericFutureListener
 *  io.netty.util.concurrent.Promise
 *  io.netty.util.internal.ObjectUtil
 *  io.netty.util.internal.StringUtil
 *  io.netty.util.internal.logging.InternalLogger
 *  io.netty.util.internal.logging.InternalLoggerFactory
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.channels.ClosedChannelException
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.concurrent.ConcurrentHashMap
 */
package io.netty.handler.codec.http2;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http2.Http2MultiplexCodec;
import io.netty.handler.codec.http2.Http2MultiplexHandler;
import io.netty.handler.codec.http2.Http2StreamChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Http2StreamChannelBootstrap {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2StreamChannelBootstrap.class);
    private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];
    private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> attrs = new ConcurrentHashMap();
    private final Channel channel;
    private volatile ChannelHandler handler;
    private volatile ChannelHandlerContext multiplexCtx;

    public Http2StreamChannelBootstrap(Channel channel) {
        this.channel = (Channel)ObjectUtil.checkNotNull((Object)channel, (String)"channel");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> Http2StreamChannelBootstrap option(ChannelOption<T> option, T value) {
        ObjectUtil.checkNotNull(option, (String)"option");
        Map<ChannelOption<?>, Object> map = this.options;
        synchronized (map) {
            if (value == null) {
                this.options.remove(option);
            } else {
                this.options.put(option, value);
            }
        }
        return this;
    }

    public <T> Http2StreamChannelBootstrap attr(AttributeKey<T> key, T value) {
        ObjectUtil.checkNotNull(key, (String)"key");
        if (value == null) {
            this.attrs.remove(key);
        } else {
            this.attrs.put(key, value);
        }
        return this;
    }

    public Http2StreamChannelBootstrap handler(ChannelHandler handler) {
        this.handler = (ChannelHandler)ObjectUtil.checkNotNull((Object)handler, (String)"handler");
        return this;
    }

    public Future<Http2StreamChannel> open() {
        return this.open((Promise<Http2StreamChannel>)this.channel.eventLoop().newPromise());
    }

    public Future<Http2StreamChannel> open(final Promise<Http2StreamChannel> promise) {
        try {
            ChannelHandlerContext ctx = this.findCtx();
            EventExecutor executor = ctx.executor();
            if (executor.inEventLoop()) {
                this.open0(ctx, promise);
            } else {
                final ChannelHandlerContext finalCtx = ctx;
                executor.execute(new Runnable(){

                    public void run() {
                        if (Http2StreamChannelBootstrap.this.channel.isActive()) {
                            Http2StreamChannelBootstrap.this.open0(finalCtx, (Promise<Http2StreamChannel>)promise);
                        } else {
                            promise.setFailure((Throwable)new ClosedChannelException());
                        }
                    }
                });
            }
        }
        catch (Throwable cause) {
            promise.setFailure(cause);
        }
        return promise;
    }

    private ChannelHandlerContext findCtx() throws ClosedChannelException {
        ChannelHandlerContext ctx = this.multiplexCtx;
        if (ctx != null && !ctx.isRemoved()) {
            return ctx;
        }
        ChannelPipeline pipeline = this.channel.pipeline();
        ctx = pipeline.context(Http2MultiplexCodec.class);
        if (ctx == null) {
            ctx = pipeline.context(Http2MultiplexHandler.class);
        }
        if (ctx == null) {
            if (this.channel.isActive()) {
                throw new IllegalStateException(StringUtil.simpleClassName(Http2MultiplexCodec.class) + " or " + StringUtil.simpleClassName(Http2MultiplexHandler.class) + " must be in the ChannelPipeline of Channel " + this.channel);
            }
            throw new ClosedChannelException();
        }
        this.multiplexCtx = ctx;
        return ctx;
    }

    @Deprecated
    public void open0(ChannelHandlerContext ctx, final Promise<Http2StreamChannel> promise) {
        Http2StreamChannel streamChannel;
        assert (ctx.executor().inEventLoop());
        if (!promise.setUncancellable()) {
            return;
        }
        try {
            streamChannel = ctx.handler() instanceof Http2MultiplexCodec ? ((Http2MultiplexCodec)ctx.handler()).newOutboundStream() : ((Http2MultiplexHandler)ctx.handler()).newOutboundStream();
        }
        catch (Exception e) {
            promise.setFailure((Throwable)e);
            return;
        }
        try {
            this.init(streamChannel);
        }
        catch (Exception e) {
            streamChannel.unsafe().closeForcibly();
            promise.setFailure((Throwable)e);
            return;
        }
        ChannelFuture future = ctx.channel().eventLoop().register((Channel)streamChannel);
        future.addListener((GenericFutureListener)new ChannelFutureListener(){

            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    promise.setSuccess((Object)streamChannel);
                } else if (future.isCancelled()) {
                    promise.cancel(false);
                } else {
                    if (streamChannel.isRegistered()) {
                        streamChannel.close();
                    } else {
                        streamChannel.unsafe().closeForcibly();
                    }
                    promise.setFailure(future.cause());
                }
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void init(Channel channel) {
        Map.Entry[] optionArray;
        ChannelPipeline p = channel.pipeline();
        ChannelHandler handler = this.handler;
        if (handler != null) {
            p.addLast(new ChannelHandler[]{handler});
        }
        Map<ChannelOption<?>, Object> map = this.options;
        synchronized (map) {
            optionArray = (Map.Entry[])this.options.entrySet().toArray((Object[])EMPTY_OPTION_ARRAY);
        }
        Http2StreamChannelBootstrap.setChannelOptions(channel, optionArray);
        Http2StreamChannelBootstrap.setAttributes(channel, (Map.Entry[])this.attrs.entrySet().toArray((Object[])EMPTY_ATTRIBUTE_ARRAY));
    }

    private static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] options) {
        for (Map.Entry<ChannelOption<?>, Object> e : options) {
            Http2StreamChannelBootstrap.setChannelOption(channel, (ChannelOption)e.getKey(), e.getValue());
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> option, Object value) {
        try {
            ChannelOption<?> opt = option;
            if (!channel.config().setOption(opt, value)) {
                logger.warn("Unknown channel option '{}' for channel '{}'", option, (Object)channel);
            }
        }
        catch (Throwable t) {
            logger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", new Object[]{option, value, channel, t});
        }
    }

    private static void setAttributes(Channel channel, Map.Entry<AttributeKey<?>, Object>[] options) {
        for (Map.Entry<AttributeKey<?>, Object> e : options) {
            AttributeKey key = (AttributeKey)e.getKey();
            channel.attr(key).set(e.getValue());
        }
    }
}


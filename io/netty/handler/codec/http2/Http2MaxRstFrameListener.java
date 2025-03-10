/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.util.internal.logging.InternalLogger
 *  io.netty.util.internal.logging.InternalLoggerFactory
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.System
 *  java.util.concurrent.TimeUnit
 */
package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2FrameListener;
import io.netty.handler.codec.http2.Http2FrameListenerDecorator;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.TimeUnit;

final class Http2MaxRstFrameListener
extends Http2FrameListenerDecorator {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2MaxRstFrameListener.class);
    private static final Http2Exception RST_FRAME_RATE_EXCEEDED = Http2Exception.newStatic(Http2Error.ENHANCE_YOUR_CALM, "Maximum number of RST frames reached", Http2Exception.ShutdownHint.HARD_SHUTDOWN, Http2MaxRstFrameListener.class, "onRstStreamRead(..)");
    private final long nanosPerWindow;
    private final int maxRstFramesPerWindow;
    private long lastRstFrameNano = System.nanoTime();
    private int receivedRstInWindow;

    Http2MaxRstFrameListener(Http2FrameListener listener, int maxRstFramesPerWindow, int secondsPerWindow) {
        super(listener);
        this.maxRstFramesPerWindow = maxRstFramesPerWindow;
        this.nanosPerWindow = TimeUnit.SECONDS.toNanos((long)secondsPerWindow);
    }

    @Override
    public void onRstStreamRead(ChannelHandlerContext ctx, int streamId, long errorCode) throws Http2Exception {
        long currentNano = System.nanoTime();
        if (currentNano - this.lastRstFrameNano >= this.nanosPerWindow) {
            this.lastRstFrameNano = currentNano;
            this.receivedRstInWindow = 1;
        } else {
            ++this.receivedRstInWindow;
            if (this.receivedRstInWindow > this.maxRstFramesPerWindow) {
                logger.debug("{} Maximum number {} of RST frames reached within {} seconds, closing connection with {} error", new Object[]{ctx.channel(), this.maxRstFramesPerWindow, TimeUnit.NANOSECONDS.toSeconds(this.nanosPerWindow), RST_FRAME_RATE_EXCEEDED.error(), RST_FRAME_RATE_EXCEEDED});
                throw RST_FRAME_RATE_EXCEEDED;
            }
        }
        super.onRstStreamRead(ctx, streamId, errorCode);
    }
}


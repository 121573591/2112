/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelDuplexHandler
 *  io.netty.channel.ChannelFuture
 *  io.netty.channel.ChannelFutureListener
 *  io.netty.channel.ChannelHandlerContext
 *  io.netty.channel.ChannelPromise
 *  io.netty.util.concurrent.GenericFutureListener
 *  io.netty.util.internal.ObjectUtil
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicInteger
 */
package io.netty.handler.codec.spdy;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.spdy.DefaultSpdyDataFrame;
import io.netty.handler.codec.spdy.DefaultSpdyGoAwayFrame;
import io.netty.handler.codec.spdy.DefaultSpdyRstStreamFrame;
import io.netty.handler.codec.spdy.DefaultSpdyWindowUpdateFrame;
import io.netty.handler.codec.spdy.SpdyCodecUtil;
import io.netty.handler.codec.spdy.SpdyDataFrame;
import io.netty.handler.codec.spdy.SpdyGoAwayFrame;
import io.netty.handler.codec.spdy.SpdyHeadersFrame;
import io.netty.handler.codec.spdy.SpdyPingFrame;
import io.netty.handler.codec.spdy.SpdyProtocolException;
import io.netty.handler.codec.spdy.SpdyRstStreamFrame;
import io.netty.handler.codec.spdy.SpdySession;
import io.netty.handler.codec.spdy.SpdySessionStatus;
import io.netty.handler.codec.spdy.SpdySettingsFrame;
import io.netty.handler.codec.spdy.SpdyStreamStatus;
import io.netty.handler.codec.spdy.SpdySynReplyFrame;
import io.netty.handler.codec.spdy.SpdySynStreamFrame;
import io.netty.handler.codec.spdy.SpdyVersion;
import io.netty.handler.codec.spdy.SpdyWindowUpdateFrame;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class SpdySessionHandler
extends ChannelDuplexHandler {
    private static final SpdyProtocolException PROTOCOL_EXCEPTION = SpdyProtocolException.newStatic(null, SpdySessionHandler.class, "handleOutboundMessage(...)");
    private static final SpdyProtocolException STREAM_CLOSED = SpdyProtocolException.newStatic("Stream closed", SpdySessionHandler.class, "removeStream(...)");
    private static final int DEFAULT_WINDOW_SIZE = 65536;
    private int initialSendWindowSize = 65536;
    private int initialReceiveWindowSize = 65536;
    private volatile int initialSessionReceiveWindowSize = 65536;
    private final SpdySession spdySession = new SpdySession(this.initialSendWindowSize, this.initialReceiveWindowSize);
    private int lastGoodStreamId;
    private static final int DEFAULT_MAX_CONCURRENT_STREAMS = Integer.MAX_VALUE;
    private int remoteConcurrentStreams = Integer.MAX_VALUE;
    private int localConcurrentStreams = Integer.MAX_VALUE;
    private final AtomicInteger pings = new AtomicInteger();
    private boolean sentGoAwayFrame;
    private boolean receivedGoAwayFrame;
    private ChannelFutureListener closeSessionFutureListener;
    private final boolean server;
    private final int minorVersion;

    public SpdySessionHandler(SpdyVersion version, boolean server) {
        this.minorVersion = ((SpdyVersion)((Object)ObjectUtil.checkNotNull((Object)((Object)version), (String)"version"))).getMinorVersion();
        this.server = server;
    }

    public void setSessionReceiveWindowSize(int sessionReceiveWindowSize) {
        ObjectUtil.checkPositiveOrZero((int)sessionReceiveWindowSize, (String)"sessionReceiveWindowSize");
        this.initialSessionReceiveWindowSize = sessionReceiveWindowSize;
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame)msg;
            int streamId = spdyDataFrame.streamId();
            int deltaWindowSize = -1 * spdyDataFrame.content().readableBytes();
            int newSessionWindowSize = this.spdySession.updateReceiveWindowSize(0, deltaWindowSize);
            if (newSessionWindowSize < 0) {
                this.issueSessionError(ctx, SpdySessionStatus.PROTOCOL_ERROR);
                return;
            }
            if (newSessionWindowSize <= this.initialSessionReceiveWindowSize / 2) {
                int sessionDeltaWindowSize = this.initialSessionReceiveWindowSize - newSessionWindowSize;
                this.spdySession.updateReceiveWindowSize(0, sessionDeltaWindowSize);
                DefaultSpdyWindowUpdateFrame spdyWindowUpdateFrame = new DefaultSpdyWindowUpdateFrame(0, sessionDeltaWindowSize);
                ctx.writeAndFlush((Object)spdyWindowUpdateFrame);
            }
            if (!this.spdySession.isActiveStream(streamId)) {
                spdyDataFrame.release();
                if (streamId <= this.lastGoodStreamId) {
                    this.issueStreamError(ctx, streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                } else if (!this.sentGoAwayFrame) {
                    this.issueStreamError(ctx, streamId, SpdyStreamStatus.INVALID_STREAM);
                }
                return;
            }
            if (this.spdySession.isRemoteSideClosed(streamId)) {
                spdyDataFrame.release();
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.STREAM_ALREADY_CLOSED);
                return;
            }
            if (!this.isRemoteInitiatedId(streamId) && !this.spdySession.hasReceivedReply(streamId)) {
                spdyDataFrame.release();
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                return;
            }
            int newWindowSize = this.spdySession.updateReceiveWindowSize(streamId, deltaWindowSize);
            if (newWindowSize < this.spdySession.getReceiveWindowSizeLowerBound(streamId)) {
                spdyDataFrame.release();
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.FLOW_CONTROL_ERROR);
                return;
            }
            if (newWindowSize < 0) {
                while (spdyDataFrame.content().readableBytes() > this.initialReceiveWindowSize) {
                    DefaultSpdyDataFrame partialDataFrame = new DefaultSpdyDataFrame(streamId, spdyDataFrame.content().readRetainedSlice(this.initialReceiveWindowSize));
                    ctx.writeAndFlush((Object)partialDataFrame);
                }
            }
            if (newWindowSize <= this.initialReceiveWindowSize / 2 && !spdyDataFrame.isLast()) {
                int streamDeltaWindowSize = this.initialReceiveWindowSize - newWindowSize;
                this.spdySession.updateReceiveWindowSize(streamId, streamDeltaWindowSize);
                DefaultSpdyWindowUpdateFrame spdyWindowUpdateFrame = new DefaultSpdyWindowUpdateFrame(streamId, streamDeltaWindowSize);
                ctx.writeAndFlush((Object)spdyWindowUpdateFrame);
            }
            if (spdyDataFrame.isLast()) {
                this.halfCloseStream(streamId, true, ctx.newSucceededFuture());
            }
        } else if (msg instanceof SpdySynStreamFrame) {
            boolean localSideClosed;
            boolean remoteSideClosed;
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame)msg;
            int streamId = spdySynStreamFrame.streamId();
            if (spdySynStreamFrame.isInvalid() || !this.isRemoteInitiatedId(streamId) || this.spdySession.isActiveStream(streamId)) {
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                return;
            }
            if (streamId <= this.lastGoodStreamId) {
                this.issueSessionError(ctx, SpdySessionStatus.PROTOCOL_ERROR);
                return;
            }
            byte priority = spdySynStreamFrame.priority();
            if (!this.acceptStream(streamId, priority, remoteSideClosed = spdySynStreamFrame.isLast(), localSideClosed = spdySynStreamFrame.isUnidirectional())) {
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.REFUSED_STREAM);
                return;
            }
        } else if (msg instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame)msg;
            int streamId = spdySynReplyFrame.streamId();
            if (spdySynReplyFrame.isInvalid() || this.isRemoteInitiatedId(streamId) || this.spdySession.isRemoteSideClosed(streamId)) {
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.INVALID_STREAM);
                return;
            }
            if (this.spdySession.hasReceivedReply(streamId)) {
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.STREAM_IN_USE);
                return;
            }
            this.spdySession.receivedReply(streamId);
            if (spdySynReplyFrame.isLast()) {
                this.halfCloseStream(streamId, true, ctx.newSucceededFuture());
            }
        } else if (msg instanceof SpdyRstStreamFrame) {
            SpdyRstStreamFrame spdyRstStreamFrame = (SpdyRstStreamFrame)msg;
            this.removeStream(spdyRstStreamFrame.streamId(), ctx.newSucceededFuture());
        } else if (msg instanceof SpdySettingsFrame) {
            SpdySettingsFrame spdySettingsFrame = (SpdySettingsFrame)msg;
            int settingsMinorVersion = spdySettingsFrame.getValue(0);
            if (settingsMinorVersion >= 0 && settingsMinorVersion != this.minorVersion) {
                this.issueSessionError(ctx, SpdySessionStatus.PROTOCOL_ERROR);
                return;
            }
            int newConcurrentStreams = spdySettingsFrame.getValue(4);
            if (newConcurrentStreams >= 0) {
                this.remoteConcurrentStreams = newConcurrentStreams;
            }
            if (spdySettingsFrame.isPersisted(7)) {
                spdySettingsFrame.removeValue(7);
            }
            spdySettingsFrame.setPersistValue(7, false);
            int newInitialWindowSize = spdySettingsFrame.getValue(7);
            if (newInitialWindowSize >= 0) {
                this.updateInitialSendWindowSize(newInitialWindowSize);
            }
        } else if (msg instanceof SpdyPingFrame) {
            SpdyPingFrame spdyPingFrame = (SpdyPingFrame)msg;
            if (this.isRemoteInitiatedId(spdyPingFrame.id())) {
                ctx.writeAndFlush((Object)spdyPingFrame);
                return;
            }
            if (this.pings.get() == 0) {
                return;
            }
            this.pings.getAndDecrement();
        } else if (msg instanceof SpdyGoAwayFrame) {
            this.receivedGoAwayFrame = true;
        } else if (msg instanceof SpdyHeadersFrame) {
            SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame)msg;
            int streamId = spdyHeadersFrame.streamId();
            if (spdyHeadersFrame.isInvalid()) {
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.PROTOCOL_ERROR);
                return;
            }
            if (this.spdySession.isRemoteSideClosed(streamId)) {
                this.issueStreamError(ctx, streamId, SpdyStreamStatus.INVALID_STREAM);
                return;
            }
            if (spdyHeadersFrame.isLast()) {
                this.halfCloseStream(streamId, true, ctx.newSucceededFuture());
            }
        } else if (msg instanceof SpdyWindowUpdateFrame) {
            SpdyWindowUpdateFrame spdyWindowUpdateFrame = (SpdyWindowUpdateFrame)msg;
            int streamId = spdyWindowUpdateFrame.streamId();
            int deltaWindowSize = spdyWindowUpdateFrame.deltaWindowSize();
            if (streamId != 0 && this.spdySession.isLocalSideClosed(streamId)) {
                return;
            }
            if (this.spdySession.getSendWindowSize(streamId) > Integer.MAX_VALUE - deltaWindowSize) {
                if (streamId == 0) {
                    this.issueSessionError(ctx, SpdySessionStatus.PROTOCOL_ERROR);
                } else {
                    this.issueStreamError(ctx, streamId, SpdyStreamStatus.FLOW_CONTROL_ERROR);
                }
                return;
            }
            this.updateSendWindowSize(ctx, streamId, deltaWindowSize);
        }
        ctx.fireChannelRead(msg);
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        for (Integer streamId : this.spdySession.activeStreams().keySet()) {
            this.removeStream(streamId, ctx.newSucceededFuture());
        }
        ctx.fireChannelInactive();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof SpdyProtocolException) {
            this.issueSessionError(ctx, SpdySessionStatus.PROTOCOL_ERROR);
        }
        ctx.fireExceptionCaught(cause);
    }

    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        this.sendGoAwayFrame(ctx, promise);
    }

    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof SpdyDataFrame || msg instanceof SpdySynStreamFrame || msg instanceof SpdySynReplyFrame || msg instanceof SpdyRstStreamFrame || msg instanceof SpdySettingsFrame || msg instanceof SpdyPingFrame || msg instanceof SpdyGoAwayFrame || msg instanceof SpdyHeadersFrame || msg instanceof SpdyWindowUpdateFrame) {
            this.handleOutboundMessage(ctx, msg, promise);
        } else {
            ctx.write(msg, promise);
        }
    }

    private void handleOutboundMessage(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof SpdyDataFrame) {
            SpdyDataFrame spdyDataFrame = (SpdyDataFrame)msg;
            int streamId = spdyDataFrame.streamId();
            if (this.spdySession.isLocalSideClosed(streamId)) {
                spdyDataFrame.release();
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
            int dataLength = spdyDataFrame.content().readableBytes();
            int sendWindowSize = this.spdySession.getSendWindowSize(streamId);
            int sessionSendWindowSize = this.spdySession.getSendWindowSize(0);
            if ((sendWindowSize = Math.min((int)sendWindowSize, (int)sessionSendWindowSize)) <= 0) {
                this.spdySession.putPendingWrite(streamId, new SpdySession.PendingWrite(spdyDataFrame, promise));
                return;
            }
            if (sendWindowSize < dataLength) {
                this.spdySession.updateSendWindowSize(streamId, -1 * sendWindowSize);
                this.spdySession.updateSendWindowSize(0, -1 * sendWindowSize);
                DefaultSpdyDataFrame partialDataFrame = new DefaultSpdyDataFrame(streamId, spdyDataFrame.content().readRetainedSlice(sendWindowSize));
                this.spdySession.putPendingWrite(streamId, new SpdySession.PendingWrite(spdyDataFrame, promise));
                final ChannelHandlerContext context = ctx;
                ctx.write((Object)partialDataFrame).addListener((GenericFutureListener)new ChannelFutureListener(){

                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            SpdySessionHandler.this.issueSessionError(context, SpdySessionStatus.INTERNAL_ERROR);
                        }
                    }
                });
                return;
            }
            this.spdySession.updateSendWindowSize(streamId, -1 * dataLength);
            this.spdySession.updateSendWindowSize(0, -1 * dataLength);
            final ChannelHandlerContext context = ctx;
            promise.addListener((GenericFutureListener)new ChannelFutureListener(){

                public void operationComplete(ChannelFuture future) throws Exception {
                    if (!future.isSuccess()) {
                        SpdySessionHandler.this.issueSessionError(context, SpdySessionStatus.INTERNAL_ERROR);
                    }
                }
            });
            if (spdyDataFrame.isLast()) {
                this.halfCloseStream(streamId, false, (ChannelFuture)promise);
            }
        } else if (msg instanceof SpdySynStreamFrame) {
            boolean localSideClosed;
            boolean remoteSideClosed;
            SpdySynStreamFrame spdySynStreamFrame = (SpdySynStreamFrame)msg;
            int streamId = spdySynStreamFrame.streamId();
            if (this.isRemoteInitiatedId(streamId)) {
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
            byte priority = spdySynStreamFrame.priority();
            if (!this.acceptStream(streamId, priority, remoteSideClosed = spdySynStreamFrame.isUnidirectional(), localSideClosed = spdySynStreamFrame.isLast())) {
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
        } else if (msg instanceof SpdySynReplyFrame) {
            SpdySynReplyFrame spdySynReplyFrame = (SpdySynReplyFrame)msg;
            int streamId = spdySynReplyFrame.streamId();
            if (!this.isRemoteInitiatedId(streamId) || this.spdySession.isLocalSideClosed(streamId)) {
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
            if (spdySynReplyFrame.isLast()) {
                this.halfCloseStream(streamId, false, (ChannelFuture)promise);
            }
        } else if (msg instanceof SpdyRstStreamFrame) {
            SpdyRstStreamFrame spdyRstStreamFrame = (SpdyRstStreamFrame)msg;
            this.removeStream(spdyRstStreamFrame.streamId(), (ChannelFuture)promise);
        } else if (msg instanceof SpdySettingsFrame) {
            SpdySettingsFrame spdySettingsFrame = (SpdySettingsFrame)msg;
            int settingsMinorVersion = spdySettingsFrame.getValue(0);
            if (settingsMinorVersion >= 0 && settingsMinorVersion != this.minorVersion) {
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
            int newConcurrentStreams = spdySettingsFrame.getValue(4);
            if (newConcurrentStreams >= 0) {
                this.localConcurrentStreams = newConcurrentStreams;
            }
            if (spdySettingsFrame.isPersisted(7)) {
                spdySettingsFrame.removeValue(7);
            }
            spdySettingsFrame.setPersistValue(7, false);
            int newInitialWindowSize = spdySettingsFrame.getValue(7);
            if (newInitialWindowSize >= 0) {
                this.updateInitialReceiveWindowSize(newInitialWindowSize);
            }
        } else if (msg instanceof SpdyPingFrame) {
            SpdyPingFrame spdyPingFrame = (SpdyPingFrame)msg;
            if (this.isRemoteInitiatedId(spdyPingFrame.id())) {
                ctx.fireExceptionCaught((Throwable)new IllegalArgumentException("invalid PING ID: " + spdyPingFrame.id()));
                return;
            }
            this.pings.getAndIncrement();
        } else {
            if (msg instanceof SpdyGoAwayFrame) {
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
            if (msg instanceof SpdyHeadersFrame) {
                SpdyHeadersFrame spdyHeadersFrame = (SpdyHeadersFrame)msg;
                int streamId = spdyHeadersFrame.streamId();
                if (this.spdySession.isLocalSideClosed(streamId)) {
                    promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                    return;
                }
                if (spdyHeadersFrame.isLast()) {
                    this.halfCloseStream(streamId, false, (ChannelFuture)promise);
                }
            } else if (msg instanceof SpdyWindowUpdateFrame) {
                promise.setFailure((Throwable)((Object)PROTOCOL_EXCEPTION));
                return;
            }
        }
        ctx.write(msg, promise);
    }

    private void issueSessionError(ChannelHandlerContext ctx, SpdySessionStatus status) {
        this.sendGoAwayFrame(ctx, status).addListener((GenericFutureListener)new ClosingChannelFutureListener(ctx, ctx.newPromise()));
    }

    private void issueStreamError(ChannelHandlerContext ctx, int streamId, SpdyStreamStatus status) {
        boolean fireChannelRead = !this.spdySession.isRemoteSideClosed(streamId);
        ChannelPromise promise = ctx.newPromise();
        this.removeStream(streamId, (ChannelFuture)promise);
        DefaultSpdyRstStreamFrame spdyRstStreamFrame = new DefaultSpdyRstStreamFrame(streamId, status);
        ctx.writeAndFlush((Object)spdyRstStreamFrame, promise);
        if (fireChannelRead) {
            ctx.fireChannelRead((Object)spdyRstStreamFrame);
        }
    }

    private boolean isRemoteInitiatedId(int id) {
        boolean serverId = SpdyCodecUtil.isServerId(id);
        return this.server && !serverId || !this.server && serverId;
    }

    private void updateInitialSendWindowSize(int newInitialWindowSize) {
        int deltaWindowSize = newInitialWindowSize - this.initialSendWindowSize;
        this.initialSendWindowSize = newInitialWindowSize;
        this.spdySession.updateAllSendWindowSizes(deltaWindowSize);
    }

    private void updateInitialReceiveWindowSize(int newInitialWindowSize) {
        int deltaWindowSize = newInitialWindowSize - this.initialReceiveWindowSize;
        this.initialReceiveWindowSize = newInitialWindowSize;
        this.spdySession.updateAllReceiveWindowSizes(deltaWindowSize);
    }

    private boolean acceptStream(int streamId, byte priority, boolean remoteSideClosed, boolean localSideClosed) {
        int maxConcurrentStreams;
        if (this.receivedGoAwayFrame || this.sentGoAwayFrame) {
            return false;
        }
        boolean remote = this.isRemoteInitiatedId(streamId);
        int n = maxConcurrentStreams = remote ? this.localConcurrentStreams : this.remoteConcurrentStreams;
        if (this.spdySession.numActiveStreams(remote) >= maxConcurrentStreams) {
            return false;
        }
        this.spdySession.acceptStream(streamId, priority, remoteSideClosed, localSideClosed, this.initialSendWindowSize, this.initialReceiveWindowSize, remote);
        if (remote) {
            this.lastGoodStreamId = streamId;
        }
        return true;
    }

    private void halfCloseStream(int streamId, boolean remote, ChannelFuture future) {
        if (remote) {
            this.spdySession.closeRemoteSide(streamId, this.isRemoteInitiatedId(streamId));
        } else {
            this.spdySession.closeLocalSide(streamId, this.isRemoteInitiatedId(streamId));
        }
        if (this.closeSessionFutureListener != null && this.spdySession.noActiveStreams()) {
            future.addListener((GenericFutureListener)this.closeSessionFutureListener);
        }
    }

    private void removeStream(int streamId, ChannelFuture future) {
        this.spdySession.removeStream(streamId, (Throwable)((Object)STREAM_CLOSED), this.isRemoteInitiatedId(streamId));
        if (this.closeSessionFutureListener != null && this.spdySession.noActiveStreams()) {
            future.addListener((GenericFutureListener)this.closeSessionFutureListener);
        }
    }

    private void updateSendWindowSize(final ChannelHandlerContext ctx, int streamId, int deltaWindowSize) {
        this.spdySession.updateSendWindowSize(streamId, deltaWindowSize);
        SpdySession.PendingWrite pendingWrite;
        while ((pendingWrite = this.spdySession.getPendingWrite(streamId)) != null) {
            SpdyDataFrame spdyDataFrame = pendingWrite.spdyDataFrame;
            int dataFrameSize = spdyDataFrame.content().readableBytes();
            int writeStreamId = spdyDataFrame.streamId();
            int sendWindowSize = this.spdySession.getSendWindowSize(writeStreamId);
            int sessionSendWindowSize = this.spdySession.getSendWindowSize(0);
            if ((sendWindowSize = Math.min((int)sendWindowSize, (int)sessionSendWindowSize)) <= 0) {
                return;
            }
            if (sendWindowSize < dataFrameSize) {
                this.spdySession.updateSendWindowSize(writeStreamId, -1 * sendWindowSize);
                this.spdySession.updateSendWindowSize(0, -1 * sendWindowSize);
                DefaultSpdyDataFrame partialDataFrame = new DefaultSpdyDataFrame(writeStreamId, spdyDataFrame.content().readRetainedSlice(sendWindowSize));
                ctx.writeAndFlush((Object)partialDataFrame).addListener((GenericFutureListener)new ChannelFutureListener(){

                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            SpdySessionHandler.this.issueSessionError(ctx, SpdySessionStatus.INTERNAL_ERROR);
                        }
                    }
                });
                continue;
            }
            this.spdySession.removePendingWrite(writeStreamId);
            this.spdySession.updateSendWindowSize(writeStreamId, -1 * dataFrameSize);
            this.spdySession.updateSendWindowSize(0, -1 * dataFrameSize);
            if (spdyDataFrame.isLast()) {
                this.halfCloseStream(writeStreamId, false, (ChannelFuture)pendingWrite.promise);
            }
            ctx.writeAndFlush((Object)spdyDataFrame, pendingWrite.promise).addListener((GenericFutureListener)new ChannelFutureListener(){

                public void operationComplete(ChannelFuture future) throws Exception {
                    if (!future.isSuccess()) {
                        SpdySessionHandler.this.issueSessionError(ctx, SpdySessionStatus.INTERNAL_ERROR);
                    }
                }
            });
        }
        return;
    }

    private void sendGoAwayFrame(ChannelHandlerContext ctx, ChannelPromise future) {
        if (!ctx.channel().isActive()) {
            ctx.close(future);
            return;
        }
        ChannelFuture f = this.sendGoAwayFrame(ctx, SpdySessionStatus.OK);
        if (this.spdySession.noActiveStreams()) {
            f.addListener((GenericFutureListener)new ClosingChannelFutureListener(ctx, future));
        } else {
            this.closeSessionFutureListener = new ClosingChannelFutureListener(ctx, future);
        }
    }

    private ChannelFuture sendGoAwayFrame(ChannelHandlerContext ctx, SpdySessionStatus status) {
        if (!this.sentGoAwayFrame) {
            this.sentGoAwayFrame = true;
            DefaultSpdyGoAwayFrame spdyGoAwayFrame = new DefaultSpdyGoAwayFrame(this.lastGoodStreamId, status);
            return ctx.writeAndFlush((Object)spdyGoAwayFrame);
        }
        return ctx.newSucceededFuture();
    }

    private static final class ClosingChannelFutureListener
    implements ChannelFutureListener {
        private final ChannelHandlerContext ctx;
        private final ChannelPromise promise;

        ClosingChannelFutureListener(ChannelHandlerContext ctx, ChannelPromise promise) {
            this.ctx = ctx;
            this.promise = promise;
        }

        public void operationComplete(ChannelFuture sentGoAwayFuture) throws Exception {
            this.ctx.close(this.promise);
        }
    }
}


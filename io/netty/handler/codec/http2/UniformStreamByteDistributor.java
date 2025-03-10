/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ObjectUtil
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayDeque
 *  java.util.Deque
 */
package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2Connection;
import io.netty.handler.codec.http2.Http2ConnectionAdapter;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Stream;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;
import java.util.Deque;

public final class UniformStreamByteDistributor
implements StreamByteDistributor {
    private final Http2Connection.PropertyKey stateKey;
    private final Deque<State> queue = new ArrayDeque(4);
    private int minAllocationChunk = 1024;
    private long totalStreamableBytes;

    public UniformStreamByteDistributor(Http2Connection connection) {
        this.stateKey = connection.newKey();
        Http2Stream connectionStream = connection.connectionStream();
        connectionStream.setProperty(this.stateKey, new State(connectionStream));
        connection.addListener(new Http2ConnectionAdapter(){

            @Override
            public void onStreamAdded(Http2Stream stream) {
                stream.setProperty(UniformStreamByteDistributor.this.stateKey, new State(stream));
            }

            @Override
            public void onStreamClosed(Http2Stream stream) {
                UniformStreamByteDistributor.this.state(stream).close();
            }
        });
    }

    public void minAllocationChunk(int minAllocationChunk) {
        ObjectUtil.checkPositive((int)minAllocationChunk, (String)"minAllocationChunk");
        this.minAllocationChunk = minAllocationChunk;
    }

    @Override
    public void updateStreamableBytes(StreamByteDistributor.StreamState streamState) {
        this.state(streamState.stream()).updateStreamableBytes(Http2CodecUtil.streamableBytes(streamState), streamState.hasFrame(), streamState.windowSize());
    }

    @Override
    public void updateDependencyTree(int childStreamId, int parentStreamId, short weight, boolean exclusive) {
    }

    @Override
    public boolean distribute(int maxBytes, StreamByteDistributor.Writer writer) throws Http2Exception {
        int size = this.queue.size();
        if (size == 0) {
            return this.totalStreamableBytes > 0L;
        }
        int chunkSize = Math.max((int)this.minAllocationChunk, (int)(maxBytes / size));
        State state = (State)this.queue.pollFirst();
        do {
            state.enqueued = false;
            if (state.windowNegative) continue;
            if (maxBytes == 0 && state.streamableBytes > 0) {
                this.queue.addFirst((Object)state);
                state.enqueued = true;
                break;
            }
            int chunk = Math.min((int)chunkSize, (int)Math.min((int)maxBytes, (int)state.streamableBytes));
            maxBytes -= chunk;
            state.write(chunk, writer);
        } while ((state = (State)this.queue.pollFirst()) != null);
        return this.totalStreamableBytes > 0L;
    }

    private State state(Http2Stream stream) {
        return (State)((Http2Stream)ObjectUtil.checkNotNull((Object)stream, (String)"stream")).getProperty(this.stateKey);
    }

    private final class State {
        final Http2Stream stream;
        int streamableBytes;
        boolean windowNegative;
        boolean enqueued;
        boolean writing;

        State(Http2Stream stream) {
            this.stream = stream;
        }

        void updateStreamableBytes(int newStreamableBytes, boolean hasFrame, int windowSize) {
            assert (hasFrame || newStreamableBytes == 0) : "hasFrame: " + hasFrame + " newStreamableBytes: " + newStreamableBytes;
            int delta = newStreamableBytes - this.streamableBytes;
            if (delta != 0) {
                this.streamableBytes = newStreamableBytes;
                UniformStreamByteDistributor.this.totalStreamableBytes = UniformStreamByteDistributor.this.totalStreamableBytes + (long)delta;
            }
            boolean bl = this.windowNegative = windowSize < 0;
            if (hasFrame && (windowSize > 0 || windowSize == 0 && !this.writing)) {
                this.addToQueue();
            }
        }

        void write(int numBytes, StreamByteDistributor.Writer writer) throws Http2Exception {
            this.writing = true;
            try {
                writer.write(this.stream, numBytes);
            }
            catch (Throwable t) {
                throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, t, "byte distribution write error", new Object[0]);
            }
            finally {
                this.writing = false;
            }
        }

        void addToQueue() {
            if (!this.enqueued) {
                this.enqueued = true;
                UniformStreamByteDistributor.this.queue.addLast((Object)this);
            }
        }

        void removeFromQueue() {
            if (this.enqueued) {
                this.enqueued = false;
                UniformStreamByteDistributor.this.queue.remove((Object)this);
            }
        }

        void close() {
            this.removeFromQueue();
            this.updateStreamableBytes(0, false, 0);
        }
    }
}


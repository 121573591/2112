/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.nio.ByteBuffer
 *  java.nio.channels.ByteChannel
 *  java.nio.channels.SocketChannel
 */
package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import org.java_websocket.WrappedByteChannel;

@Deprecated
public class AbstractWrappedByteChannel
implements WrappedByteChannel {
    private final ByteChannel channel;

    @Deprecated
    public AbstractWrappedByteChannel(ByteChannel towrap) {
        this.channel = towrap;
    }

    @Deprecated
    public AbstractWrappedByteChannel(WrappedByteChannel towrap) {
        this.channel = towrap;
    }

    public int read(ByteBuffer dst) throws IOException {
        return this.channel.read(dst);
    }

    public boolean isOpen() {
        return this.channel.isOpen();
    }

    public void close() throws IOException {
        this.channel.close();
    }

    public int write(ByteBuffer src) throws IOException {
        return this.channel.write(src);
    }

    @Override
    public boolean isNeedWrite() {
        return this.channel instanceof WrappedByteChannel && ((WrappedByteChannel)this.channel).isNeedWrite();
    }

    @Override
    public void writeMore() throws IOException {
        if (this.channel instanceof WrappedByteChannel) {
            ((WrappedByteChannel)this.channel).writeMore();
        }
    }

    @Override
    public boolean isNeedRead() {
        return this.channel instanceof WrappedByteChannel && ((WrappedByteChannel)this.channel).isNeedRead();
    }

    @Override
    public int readMore(ByteBuffer dst) throws IOException {
        return this.channel instanceof WrappedByteChannel ? ((WrappedByteChannel)this.channel).readMore(dst) : 0;
    }

    @Override
    public boolean isBlocking() {
        if (this.channel instanceof SocketChannel) {
            return ((SocketChannel)this.channel).isBlocking();
        }
        if (this.channel instanceof WrappedByteChannel) {
            return ((WrappedByteChannel)this.channel).isBlocking();
        }
        return false;
    }
}


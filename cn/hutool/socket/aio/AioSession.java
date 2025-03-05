/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.net.SocketAddress
 *  java.nio.ByteBuffer
 *  java.nio.channels.AsynchronousSocketChannel
 *  java.nio.channels.CompletionHandler
 *  java.util.concurrent.Future
 *  java.util.concurrent.TimeUnit
 */
package cn.hutool.socket.aio;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.socket.SocketConfig;
import cn.hutool.socket.SocketUtil;
import cn.hutool.socket.aio.IoAction;
import cn.hutool.socket.aio.ReadHandler;
import java.io.Closeable;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AioSession
implements Closeable {
    private static final ReadHandler READ_HANDLER = new ReadHandler();
    private final AsynchronousSocketChannel channel;
    private final IoAction<ByteBuffer> ioAction;
    private ByteBuffer readBuffer;
    private ByteBuffer writeBuffer;
    private final long readTimeout;
    private final long writeTimeout;

    public AioSession(AsynchronousSocketChannel channel, IoAction<ByteBuffer> ioAction, SocketConfig config) {
        this.channel = channel;
        this.ioAction = ioAction;
        this.readBuffer = ByteBuffer.allocate((int)config.getReadBufferSize());
        this.writeBuffer = ByteBuffer.allocate((int)config.getWriteBufferSize());
        this.readTimeout = config.getReadTimeout();
        this.writeTimeout = config.getWriteTimeout();
    }

    public AsynchronousSocketChannel getChannel() {
        return this.channel;
    }

    public ByteBuffer getReadBuffer() {
        return this.readBuffer;
    }

    public ByteBuffer getWriteBuffer() {
        return this.writeBuffer;
    }

    public IoAction<ByteBuffer> getIoAction() {
        return this.ioAction;
    }

    public SocketAddress getRemoteAddress() {
        return SocketUtil.getRemoteAddress(this.channel);
    }

    public AioSession read() {
        return this.read(READ_HANDLER);
    }

    public AioSession read(CompletionHandler<Integer, AioSession> handler) {
        if (this.isOpen()) {
            this.readBuffer.clear();
            this.channel.read(this.readBuffer, Math.max((long)this.readTimeout, (long)0L), TimeUnit.MILLISECONDS, (Object)this, handler);
        }
        return this;
    }

    public AioSession writeAndClose(ByteBuffer data) {
        this.write(data);
        return this.closeOut();
    }

    public Future<Integer> write(ByteBuffer data) {
        return this.channel.write(data);
    }

    public AioSession write(ByteBuffer data, CompletionHandler<Integer, AioSession> handler) {
        this.channel.write(data, Math.max((long)this.writeTimeout, (long)0L), TimeUnit.MILLISECONDS, (Object)this, handler);
        return this;
    }

    public boolean isOpen() {
        return null != this.channel && this.channel.isOpen();
    }

    public AioSession closeIn() {
        if (null != this.channel) {
            try {
                this.channel.shutdownInput();
            }
            catch (IOException e) {
                throw new IORuntimeException(e);
            }
        }
        return this;
    }

    public AioSession closeOut() {
        if (null != this.channel) {
            try {
                this.channel.shutdownOutput();
            }
            catch (IOException e) {
                throw new IORuntimeException(e);
            }
        }
        return this;
    }

    public void close() {
        IoUtil.close((Closeable)this.channel);
        this.readBuffer = null;
        this.writeBuffer = null;
    }

    protected void callbackRead() {
        this.readBuffer.flip();
        this.ioAction.doAction(this, this.readBuffer);
    }
}


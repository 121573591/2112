/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 *  java.net.InetSocketAddress
 *  java.net.SocketAddress
 *  java.net.SocketOption
 *  java.nio.ByteBuffer
 *  java.nio.channels.AsynchronousChannelGroup
 *  java.nio.channels.AsynchronousServerSocketChannel
 *  java.nio.channels.CompletionHandler
 *  java.util.concurrent.ThreadFactory
 */
package cn.hutool.socket.aio;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.socket.SocketConfig;
import cn.hutool.socket.aio.AcceptHandler;
import cn.hutool.socket.aio.IoAction;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ThreadFactory;

public class AioServer
implements Closeable {
    private static final Log log = LogFactory.get();
    private static final AcceptHandler ACCEPT_HANDLER = new AcceptHandler();
    private AsynchronousChannelGroup group;
    private AsynchronousServerSocketChannel channel;
    protected IoAction<ByteBuffer> ioAction;
    protected final SocketConfig config;

    public AioServer(int port) {
        this(new InetSocketAddress(port), new SocketConfig());
    }

    public AioServer(InetSocketAddress address, SocketConfig config) {
        this.config = config;
        this.init(address);
    }

    public AioServer init(InetSocketAddress address) {
        try {
            this.group = AsynchronousChannelGroup.withFixedThreadPool((int)this.config.getThreadPoolSize(), (ThreadFactory)ThreadFactoryBuilder.create().setNamePrefix("Hutool-socket-").build());
            this.channel = AsynchronousServerSocketChannel.open((AsynchronousChannelGroup)this.group).bind((SocketAddress)address);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return this;
    }

    public void start(boolean sync) {
        this.doStart(sync);
    }

    public <T> AioServer setOption(SocketOption<T> name, T value) throws IOException {
        this.channel.setOption(name, value);
        return this;
    }

    public IoAction<ByteBuffer> getIoAction() {
        return this.ioAction;
    }

    public AioServer setIoAction(IoAction<ByteBuffer> ioAction) {
        this.ioAction = ioAction;
        return this;
    }

    public AsynchronousServerSocketChannel getChannel() {
        return this.channel;
    }

    public AioServer accept() {
        this.channel.accept((Object)this, (CompletionHandler)ACCEPT_HANDLER);
        return this;
    }

    public boolean isOpen() {
        return null != this.channel && this.channel.isOpen();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() {
        IoUtil.close((Closeable)this.channel);
        if (null != this.group && !this.group.isShutdown()) {
            try {
                this.group.shutdownNow();
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        AioServer aioServer = this;
        synchronized (aioServer) {
            this.notify();
        }
    }

    private void doStart(boolean sync) {
        log.debug("Aio Server started, waiting for accept.", new Object[0]);
        this.accept();
        if (sync) {
            ThreadUtil.sync(this);
        }
    }
}


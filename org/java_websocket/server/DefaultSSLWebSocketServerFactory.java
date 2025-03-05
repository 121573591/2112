/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.channels.ByteChannel
 *  java.nio.channels.SelectionKey
 *  java.nio.channels.SocketChannel
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLEngine
 */
package org.java_websocket.server;

import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import org.java_websocket.SSLSocketChannel2;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketListener;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.drafts.Draft;

public class DefaultSSLWebSocketServerFactory
implements WebSocketServerFactory {
    protected SSLContext sslcontext;
    protected ExecutorService exec;

    public DefaultSSLWebSocketServerFactory(SSLContext sslContext) {
        this(sslContext, (ExecutorService)Executors.newSingleThreadScheduledExecutor());
    }

    public DefaultSSLWebSocketServerFactory(SSLContext sslContext, ExecutorService exec) {
        if (sslContext == null || exec == null) {
            throw new IllegalArgumentException();
        }
        this.sslcontext = sslContext;
        this.exec = exec;
    }

    @Override
    public ByteChannel wrapChannel(SocketChannel channel, SelectionKey key) throws IOException {
        SSLEngine e = this.sslcontext.createSSLEngine();
        ArrayList ciphers = new ArrayList((Collection)Arrays.asList((Object[])e.getEnabledCipherSuites()));
        ciphers.remove((Object)"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        e.setEnabledCipherSuites((String[])ciphers.toArray((Object[])new String[ciphers.size()]));
        e.setUseClientMode(false);
        return new SSLSocketChannel2(channel, e, this.exec, key);
    }

    @Override
    public WebSocketImpl createWebSocket(WebSocketAdapter a, Draft d) {
        return new WebSocketImpl((WebSocketListener)a, d);
    }

    @Override
    public WebSocketImpl createWebSocket(WebSocketAdapter a, List<Draft> d) {
        return new WebSocketImpl((WebSocketListener)a, d);
    }

    @Override
    public void close() {
        this.exec.shutdown();
    }
}


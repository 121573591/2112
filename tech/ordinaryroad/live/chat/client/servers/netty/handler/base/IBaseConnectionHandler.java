/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.Channel
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.servers.netty.handler.base;

import io.netty.channel.Channel;

public interface IBaseConnectionHandler {
    default public void sendHeartbeat(Channel channel) {
    }

    default public void sendAuthRequest(Channel channel) {
    }
}


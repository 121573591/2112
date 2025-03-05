/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.commons.base.listener;

public interface IBaseConnectionListener<T> {
    default public void onConnected(T t) {
    }

    default public void onConnectFailed(T t) {
    }

    default public void onDisconnected(T t) {
    }
}


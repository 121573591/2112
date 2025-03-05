/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.java_websocket.handshake;

import org.java_websocket.handshake.Handshakedata;

public interface HandshakeBuilder
extends Handshakedata {
    public void setContent(byte[] var1);

    public void put(String var1, String var2);
}


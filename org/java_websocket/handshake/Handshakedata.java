/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 */
package org.java_websocket.handshake;

import java.util.Iterator;

public interface Handshakedata {
    public Iterator<String> iterateHttpFields();

    public String getFieldValue(String var1);

    public boolean hasFieldValue(String var1);

    public byte[] getContent();
}


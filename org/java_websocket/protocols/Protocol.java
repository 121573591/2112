/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package org.java_websocket.protocols;

import java.util.regex.Pattern;
import org.java_websocket.protocols.IProtocol;

public class Protocol
implements IProtocol {
    private static final Pattern patternSpace = Pattern.compile((String)" ");
    private static final Pattern patternComma = Pattern.compile((String)",");
    private final String providedProtocol;

    public Protocol(String providedProtocol) {
        if (providedProtocol == null) {
            throw new IllegalArgumentException();
        }
        this.providedProtocol = providedProtocol;
    }

    @Override
    public boolean acceptProvidedProtocol(String inputProtocolHeader) {
        String[] headers;
        if ("".equals((Object)this.providedProtocol)) {
            return true;
        }
        String protocolHeader = patternSpace.matcher((CharSequence)inputProtocolHeader).replaceAll("");
        for (String header : headers = patternComma.split((CharSequence)protocolHeader)) {
            if (!this.providedProtocol.equals((Object)header)) continue;
            return true;
        }
        return false;
    }

    @Override
    public String getProvidedProtocol() {
        return this.providedProtocol;
    }

    @Override
    public IProtocol copyInstance() {
        return new Protocol(this.getProvidedProtocol());
    }

    @Override
    public String toString() {
        return this.getProvidedProtocol();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Protocol protocol = (Protocol)o;
        return this.providedProtocol.equals((Object)protocol.providedProtocol);
    }

    public int hashCode() {
        return this.providedProtocol.hashCode();
    }
}


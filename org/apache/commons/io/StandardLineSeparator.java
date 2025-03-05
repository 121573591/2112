/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.Objects
 */
package org.apache.commons.io;

import java.nio.charset.Charset;
import java.util.Objects;

public enum StandardLineSeparator {
    CR("\r"),
    CRLF("\r\n"),
    LF("\n");

    private final String lineSeparator;

    private StandardLineSeparator(String lineSeparator) {
        this.lineSeparator = (String)Objects.requireNonNull((Object)lineSeparator, (String)"lineSeparator");
    }

    public byte[] getBytes(Charset charset) {
        return this.lineSeparator.getBytes(charset);
    }

    public String getString() {
        return this.lineSeparator;
    }
}


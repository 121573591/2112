/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Object
 */
package org.apache.commons.io.input;

import java.io.InputStream;

public class ClosedInputStream
extends InputStream {
    public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();

    public int read() {
        return -1;
    }
}


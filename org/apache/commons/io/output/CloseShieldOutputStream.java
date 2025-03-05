/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 */
package org.apache.commons.io.output;

import java.io.OutputStream;
import org.apache.commons.io.output.ClosedOutputStream;
import org.apache.commons.io.output.ProxyOutputStream;

public class CloseShieldOutputStream
extends ProxyOutputStream {
    public static CloseShieldOutputStream wrap(OutputStream outputStream2) {
        return new CloseShieldOutputStream(outputStream2);
    }

    @Deprecated
    public CloseShieldOutputStream(OutputStream outputStream2) {
        super(outputStream2);
    }

    @Override
    public void close() {
        this.out = ClosedOutputStream.CLOSED_OUTPUT_STREAM;
    }
}


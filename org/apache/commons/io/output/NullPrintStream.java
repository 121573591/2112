/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.io.PrintStream
 *  java.lang.Object
 */
package org.apache.commons.io.output;

import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.commons.io.output.NullOutputStream;

public class NullPrintStream
extends PrintStream {
    public static final NullPrintStream NULL_PRINT_STREAM = new NullPrintStream();

    public NullPrintStream() {
        super((OutputStream)NullOutputStream.NULL_OUTPUT_STREAM);
    }
}


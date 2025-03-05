/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 */
package org.apache.commons.io.output;

import java.io.IOException;

public class NullAppendable
implements Appendable {
    public static final NullAppendable INSTANCE = new NullAppendable();

    private NullAppendable() {
    }

    public Appendable append(char c) throws IOException {
        return this;
    }

    public Appendable append(CharSequence csq) throws IOException {
        return this;
    }

    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        return this;
    }
}


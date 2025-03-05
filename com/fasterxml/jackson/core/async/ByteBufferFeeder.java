/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.nio.ByteBuffer
 */
package com.fasterxml.jackson.core.async;

import com.fasterxml.jackson.core.async.NonBlockingInputFeeder;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface ByteBufferFeeder
extends NonBlockingInputFeeder {
    public void feedInput(ByteBuffer var1) throws IOException;
}


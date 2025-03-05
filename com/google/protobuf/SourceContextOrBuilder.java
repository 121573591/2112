/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface SourceContextOrBuilder
extends MessageOrBuilder {
    public String getFileName();

    public ByteString getFileNameBytes();
}


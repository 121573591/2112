/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.util.List;

public interface ProtocolStringList
extends List<String> {
    public List<ByteString> asByteStringList();
}


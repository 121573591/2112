/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface HeadersListOrBuilder
extends MessageOrBuilder {
    public String getKey();

    public ByteString getKeyBytes();

    public String getValue();

    public ByteString getValueBytes();
}


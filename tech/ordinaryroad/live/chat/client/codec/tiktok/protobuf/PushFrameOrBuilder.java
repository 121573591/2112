/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.HeadersList;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.HeadersListOrBuilder;

public interface PushFrameOrBuilder
extends MessageOrBuilder {
    public long getSeqId();

    public long getLogId();

    public long getService();

    public long getMethod();

    public List<HeadersList> getHeadersListList();

    public HeadersList getHeadersList(int var1);

    public int getHeadersListCount();

    public List<? extends HeadersListOrBuilder> getHeadersListOrBuilderList();

    public HeadersListOrBuilder getHeadersListOrBuilder(int var1);

    public String getPayloadEncoding();

    public ByteString getPayloadEncodingBytes();

    public String getPayloadType();

    public ByteString getPayloadTypeBytes();

    public ByteString getPayload();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.HeadersList;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.HeadersListOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.SendMessageBody;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.SendMessageBodyOrBuilder;

public interface PreMessageOrBuilder
extends MessageOrBuilder {
    public int getCmd();

    public int getSequenceId();

    public String getSdkVersion();

    public ByteString getSdkVersionBytes();

    public String getToken();

    public ByteString getTokenBytes();

    public int getRefer();

    public int getInboxType();

    public String getBuildNumber();

    public ByteString getBuildNumberBytes();

    public boolean hasSendMessageBody();

    public SendMessageBody getSendMessageBody();

    public SendMessageBodyOrBuilder getSendMessageBodyOrBuilder();

    public String getAa();

    public ByteString getAaBytes();

    public String getDevicePlatform();

    public ByteString getDevicePlatformBytes();

    public List<HeadersList> getHeadersList();

    public HeadersList getHeaders(int var1);

    public int getHeadersCount();

    public List<? extends HeadersListOrBuilder> getHeadersOrBuilderList();

    public HeadersListOrBuilder getHeadersOrBuilder(int var1);

    public int getAuthType();

    public String getBiz();

    public ByteString getBizBytes();

    public String getAccess();

    public ByteString getAccessBytes();
}


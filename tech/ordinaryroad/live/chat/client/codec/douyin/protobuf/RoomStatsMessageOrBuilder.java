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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;

public interface RoomStatsMessageOrBuilder
extends MessageOrBuilder {
    public boolean hasCommon();

    public Common getCommon();

    public CommonOrBuilder getCommonOrBuilder();

    public String getDisplayShort();

    public ByteString getDisplayShortBytes();

    public String getDisplayMiddle();

    public ByteString getDisplayMiddleBytes();

    public String getDisplayLong();

    public ByteString getDisplayLongBytes();

    public long getDisplayValue();

    public long getDisplayVersion();

    public boolean getIncremental();

    public boolean getIsHidden();

    public long getTotal();

    public long getDisplayType();
}


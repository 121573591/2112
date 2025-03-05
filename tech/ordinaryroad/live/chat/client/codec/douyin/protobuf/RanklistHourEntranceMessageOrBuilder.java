/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.MessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntranceOrBuilder;

public interface RanklistHourEntranceMessageOrBuilder
extends MessageOrBuilder {
    public boolean hasCommon();

    public Common getCommon();

    public CommonOrBuilder getCommonOrBuilder();

    public boolean hasInfo();

    public RanklistHourEntrance getInfo();

    public RanklistHourEntranceOrBuilder getInfoOrBuilder();
}


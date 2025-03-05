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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomUserSeqMessageContributor;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomUserSeqMessageContributorOrBuilder;

public interface RoomUserSeqMessageOrBuilder
extends MessageOrBuilder {
    public boolean hasCommon();

    public Common getCommon();

    public CommonOrBuilder getCommonOrBuilder();

    public List<RoomUserSeqMessageContributor> getRanksListList();

    public RoomUserSeqMessageContributor getRanksList(int var1);

    public int getRanksListCount();

    public List<? extends RoomUserSeqMessageContributorOrBuilder> getRanksListOrBuilderList();

    public RoomUserSeqMessageContributorOrBuilder getRanksListOrBuilder(int var1);

    public long getTotal();

    public String getPopStr();

    public ByteString getPopStrBytes();

    public List<RoomUserSeqMessageContributor> getSeatsListList();

    public RoomUserSeqMessageContributor getSeatsList(int var1);

    public int getSeatsListCount();

    public List<? extends RoomUserSeqMessageContributorOrBuilder> getSeatsListOrBuilderList();

    public RoomUserSeqMessageContributorOrBuilder getSeatsListOrBuilder(int var1);

    public long getPopularity();

    public long getTotalUser();

    public String getTotalUserStr();

    public ByteString getTotalUserStrBytes();

    public String getTotalStr();

    public ByteString getTotalStrBytes();

    public String getOnlineUserForAnchor();

    public ByteString getOnlineUserForAnchorBytes();

    public String getTotalPvForAnchor();

    public ByteString getTotalPvForAnchorBytes();

    public String getUpRightStatsStr();

    public ByteString getUpRightStatsStrBytes();

    public String getUpRightStatsStrComplete();

    public ByteString getUpRightStatsStrCompleteBytes();
}


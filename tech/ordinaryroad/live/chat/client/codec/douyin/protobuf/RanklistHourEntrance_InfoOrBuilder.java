/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_Detail;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_DetailOrBuilder;

public interface RanklistHourEntrance_InfoOrBuilder
extends MessageOrBuilder {
    public List<RanklistHourEntrance_Detail> getDetailsList();

    public RanklistHourEntrance_Detail getDetails(int var1);

    public int getDetailsCount();

    public List<? extends RanklistHourEntrance_DetailOrBuilder> getDetailsOrBuilderList();

    public RanklistHourEntrance_DetailOrBuilder getDetailsOrBuilder(int var1);
}


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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_Info;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_InfoOrBuilder;

public interface RanklistHourEntranceOrBuilder
extends MessageOrBuilder {
    public List<RanklistHourEntrance_Info> getGlobalInfosList();

    public RanklistHourEntrance_Info getGlobalInfos(int var1);

    public int getGlobalInfosCount();

    public List<? extends RanklistHourEntrance_InfoOrBuilder> getGlobalInfosOrBuilderList();

    public RanklistHourEntrance_InfoOrBuilder getGlobalInfosOrBuilder(int var1);

    public List<RanklistHourEntrance_Info> getDefaultGlobalInfosList();

    public RanklistHourEntrance_Info getDefaultGlobalInfos(int var1);

    public int getDefaultGlobalInfosCount();

    public List<? extends RanklistHourEntrance_InfoOrBuilder> getDefaultGlobalInfosOrBuilderList();

    public RanklistHourEntrance_InfoOrBuilder getDefaultGlobalInfosOrBuilder(int var1);

    public List<RanklistHourEntrance_Info> getVerticalInfosList();

    public RanklistHourEntrance_Info getVerticalInfos(int var1);

    public int getVerticalInfosCount();

    public List<? extends RanklistHourEntrance_InfoOrBuilder> getVerticalInfosOrBuilderList();

    public RanklistHourEntrance_InfoOrBuilder getVerticalInfosOrBuilder(int var1);

    public List<RanklistHourEntrance_Info> getDefaultVerticalInfosList();

    public RanklistHourEntrance_Info getDefaultVerticalInfos(int var1);

    public int getDefaultVerticalInfosCount();

    public List<? extends RanklistHourEntrance_InfoOrBuilder> getDefaultVerticalInfosOrBuilderList();

    public RanklistHourEntrance_InfoOrBuilder getDefaultVerticalInfosOrBuilder(int var1);
}


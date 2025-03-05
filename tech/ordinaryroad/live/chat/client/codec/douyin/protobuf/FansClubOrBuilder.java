/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Map
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.MessageOrBuilder;
import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubData;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubDataOrBuilder;

public interface FansClubOrBuilder
extends MessageOrBuilder {
    public boolean hasData();

    public FansClubData getData();

    public FansClubDataOrBuilder getDataOrBuilder();

    public int getPreferDataCount();

    public boolean containsPreferData(int var1);

    @Deprecated
    public Map<Integer, FansClubData> getPreferData();

    public Map<Integer, FansClubData> getPreferDataMap();

    public FansClubData getPreferDataOrDefault(int var1, FansClubData var2);

    public FansClubData getPreferDataOrThrow(int var1);
}


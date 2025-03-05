/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface CategoryInfoOrBuilder
extends MessageOrBuilder {
    public int getId();

    public String getName();

    public ByteString getNameBytes();

    public List<Long> getPromotionIdsListList();

    public int getPromotionIdsListCount();

    public long getPromotionIdsList(int var1);

    public String getType();

    public ByteString getTypeBytes();

    public String getUniqueIndex();

    public ByteString getUniqueIndexBytes();
}


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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public interface RoomUserSeqMessageContributorOrBuilder
extends MessageOrBuilder {
    public long getScore();

    public boolean hasUser();

    public User getUser();

    public UserOrBuilder getUserOrBuilder();

    public long getRank();

    public long getDelta();

    public boolean getIsHidden();

    public String getScoreDescription();

    public ByteString getScoreDescriptionBytes();

    public String getExactlyScore();

    public ByteString getExactlyScoreBytes();
}


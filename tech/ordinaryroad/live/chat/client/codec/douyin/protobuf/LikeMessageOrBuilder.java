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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.DisplayControlInfo;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.DisplayControlInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.DoubleLikeDetail;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.DoubleLikeDetailOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PicoDisplayInfo;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PicoDisplayInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public interface LikeMessageOrBuilder
extends MessageOrBuilder {
    public boolean hasCommon();

    public Common getCommon();

    public CommonOrBuilder getCommonOrBuilder();

    public long getCount();

    public long getTotal();

    public long getColor();

    public boolean hasUser();

    public User getUser();

    public UserOrBuilder getUserOrBuilder();

    public String getIcon();

    public ByteString getIconBytes();

    public boolean hasDoubleLikeDetail();

    public DoubleLikeDetail getDoubleLikeDetail();

    public DoubleLikeDetailOrBuilder getDoubleLikeDetailOrBuilder();

    public boolean hasDisplayControlInfo();

    public DisplayControlInfo getDisplayControlInfo();

    public DisplayControlInfoOrBuilder getDisplayControlInfoOrBuilder();

    public long getLinkmicGuestUid();

    public String getScene();

    public ByteString getSceneBytes();

    public boolean hasPicoDisplayInfo();

    public PicoDisplayInfo getPicoDisplayInfo();

    public PicoDisplayInfoOrBuilder getPicoDisplayInfoOrBuilder();
}


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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.EffectConfig;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.EffectConfigOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommon;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Text;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public interface MemberMessageOrBuilder
extends MessageOrBuilder {
    public boolean hasCommon();

    public Common getCommon();

    public CommonOrBuilder getCommonOrBuilder();

    public boolean hasUser();

    public User getUser();

    public UserOrBuilder getUserOrBuilder();

    public long getMemberCount();

    public boolean hasOperator();

    public User getOperator();

    public UserOrBuilder getOperatorOrBuilder();

    public boolean getIsSetToAdmin();

    public boolean getIsTopUser();

    public long getRankScore();

    public long getTopUserNo();

    public long getEnterType();

    public long getAction();

    public String getActionDescription();

    public ByteString getActionDescriptionBytes();

    public long getUserId();

    public boolean hasEffectConfig();

    public EffectConfig getEffectConfig();

    public EffectConfigOrBuilder getEffectConfigOrBuilder();

    public String getPopStr();

    public ByteString getPopStrBytes();

    public boolean hasEnterEffectConfig();

    public EffectConfig getEnterEffectConfig();

    public EffectConfigOrBuilder getEnterEffectConfigOrBuilder();

    public boolean hasBackgroundImage();

    public Image getBackgroundImage();

    public ImageOrBuilder getBackgroundImageOrBuilder();

    public boolean hasBackgroundImageV2();

    public Image getBackgroundImageV2();

    public ImageOrBuilder getBackgroundImageV2OrBuilder();

    public boolean hasAnchorDisplayText();

    public Text getAnchorDisplayText();

    public TextOrBuilder getAnchorDisplayTextOrBuilder();

    public boolean hasPublicAreaCommon();

    public PublicAreaCommon getPublicAreaCommon();

    public PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder();

    public long getUserEnterTipType();

    public long getAnchorEnterTipType();
}


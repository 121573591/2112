/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Map
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Text;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextOrBuilder;

public interface EffectConfigOrBuilder
extends MessageOrBuilder {
    public long getType();

    public boolean hasIcon();

    public Image getIcon();

    public ImageOrBuilder getIconOrBuilder();

    public long getAvatarPos();

    public boolean hasText();

    public Text getText();

    public TextOrBuilder getTextOrBuilder();

    public boolean hasTextIcon();

    public Image getTextIcon();

    public ImageOrBuilder getTextIconOrBuilder();

    public int getStayTime();

    public long getAnimAssetId();

    public boolean hasBadge();

    public Image getBadge();

    public ImageOrBuilder getBadgeOrBuilder();

    public List<Long> getFlexSettingArrayListList();

    public int getFlexSettingArrayListCount();

    public long getFlexSettingArrayList(int var1);

    public boolean hasTextIconOverlay();

    public Image getTextIconOverlay();

    public ImageOrBuilder getTextIconOverlayOrBuilder();

    public boolean hasAnimatedBadge();

    public Image getAnimatedBadge();

    public ImageOrBuilder getAnimatedBadgeOrBuilder();

    public boolean getHasSweepLight();

    public List<Long> getTextFlexSettingArrayListList();

    public int getTextFlexSettingArrayListCount();

    public long getTextFlexSettingArrayList(int var1);

    public long getCenterAnimAssetId();

    public boolean hasDynamicImage();

    public Image getDynamicImage();

    public ImageOrBuilder getDynamicImageOrBuilder();

    public int getExtraMapCount();

    public boolean containsExtraMap(String var1);

    @Deprecated
    public Map<String, String> getExtraMap();

    public Map<String, String> getExtraMapMap();

    public String getExtraMapOrDefault(String var1, String var2);

    public String getExtraMapOrThrow(String var1);

    public long getMp4AnimAssetId();

    public long getPriority();

    public long getMaxWaitTime();

    public String getDressId();

    public ByteString getDressIdBytes();

    public long getAlignment();

    public long getAlignmentOffset();
}


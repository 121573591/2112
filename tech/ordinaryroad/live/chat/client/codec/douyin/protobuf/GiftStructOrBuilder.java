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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;

public interface GiftStructOrBuilder
extends MessageOrBuilder {
    public boolean hasImage();

    public Image getImage();

    public ImageOrBuilder getImageOrBuilder();

    public String getDescribe();

    public ByteString getDescribeBytes();

    public boolean getNotify();

    public long getDuration();

    public long getId();

    public boolean getForLinkmic();

    public boolean getDoodle();

    public boolean getForFansclub();

    public boolean getCombo();

    public int getType();

    public int getDiamondCount();

    public boolean getIsDisplayedOnPanel();

    public long getPrimaryEffectId();

    public boolean hasGiftLabelIcon();

    public Image getGiftLabelIcon();

    public ImageOrBuilder getGiftLabelIconOrBuilder();

    public String getName();

    public ByteString getNameBytes();

    public String getRegion();

    public ByteString getRegionBytes();

    public String getManual();

    public ByteString getManualBytes();

    public boolean getForCustom();

    public boolean hasIcon();

    public Image getIcon();

    public ImageOrBuilder getIconOrBuilder();

    public int getActionType();
}


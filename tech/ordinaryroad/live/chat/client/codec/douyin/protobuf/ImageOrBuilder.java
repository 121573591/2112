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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageContent;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageContentOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.NinePatchSetting;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.NinePatchSettingOrBuilder;

public interface ImageOrBuilder
extends MessageOrBuilder {
    public List<String> getUrlListListList();

    public int getUrlListListCount();

    public String getUrlListList(int var1);

    public ByteString getUrlListListBytes(int var1);

    public String getUri();

    public ByteString getUriBytes();

    public long getHeight();

    public long getWidth();

    public String getAvgColor();

    public ByteString getAvgColorBytes();

    public int getImageType();

    public String getOpenWebUrl();

    public ByteString getOpenWebUrlBytes();

    public boolean hasContent();

    public ImageContent getContent();

    public ImageContentOrBuilder getContentOrBuilder();

    public boolean getIsAnimated();

    public boolean hasFlexSettingList();

    public NinePatchSetting getFlexSettingList();

    public NinePatchSettingOrBuilder getFlexSettingListOrBuilder();

    public boolean hasTextSettingList();

    public NinePatchSetting getTextSettingList();

    public NinePatchSettingOrBuilder getTextSettingListOrBuilder();
}


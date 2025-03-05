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

public interface GradeIconOrBuilder
extends MessageOrBuilder {
    public boolean hasIcon();

    public Image getIcon();

    public ImageOrBuilder getIconOrBuilder();

    public long getIconDiamond();

    public long getLevel();

    public String getLevelStr();

    public ByteString getLevelStrBytes();
}


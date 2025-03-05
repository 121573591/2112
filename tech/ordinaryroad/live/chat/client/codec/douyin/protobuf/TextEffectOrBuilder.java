/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.MessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextEffectDetail;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextEffectDetailOrBuilder;

public interface TextEffectOrBuilder
extends MessageOrBuilder {
    public boolean hasPortrait();

    public TextEffectDetail getPortrait();

    public TextEffectDetailOrBuilder getPortraitOrBuilder();

    public boolean hasLandscape();

    public TextEffectDetail getLandscape();

    public TextEffectDetailOrBuilder getLandscapeOrBuilder();
}


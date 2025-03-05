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

public interface TextPieceUserOrBuilder
extends MessageOrBuilder {
    public boolean hasUser();

    public User getUser();

    public UserOrBuilder getUserOrBuilder();

    public boolean getWithColon();

    public boolean getSelfShowRealName();

    public int getLeftShowExtension();

    public String getLeftAdditionalContent();

    public ByteString getLeftAdditionalContentBytes();

    public String getRightAdditionalContent();

    public ByteString getRightAdditionalContentBytes();
}


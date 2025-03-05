/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf;

import com.google.protobuf.MessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.UserOrBuilder;

public interface TextPieceUserOrBuilder
extends MessageOrBuilder {
    public boolean hasUser();

    public User getUser();

    public UserOrBuilder getUserOrBuilder();
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommentTypeTag;

public interface LandscapeAreaCommonOrBuilder
extends MessageOrBuilder {
    public boolean getShowHead();

    public boolean getShowNickname();

    public boolean getShowFontColor();

    public List<String> getColorValueListList();

    public int getColorValueListCount();

    public String getColorValueList(int var1);

    public ByteString getColorValueListBytes(int var1);

    public List<CommentTypeTag> getCommentTypeTagsListList();

    public int getCommentTypeTagsListCount();

    public CommentTypeTag getCommentTypeTagsList(int var1);

    public List<Integer> getCommentTypeTagsListValueList();

    public int getCommentTypeTagsListValue(int var1);
}


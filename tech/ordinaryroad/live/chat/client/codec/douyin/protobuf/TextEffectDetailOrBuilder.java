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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Text;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextOrBuilder;

public interface TextEffectDetailOrBuilder
extends MessageOrBuilder {
    public boolean hasText();

    public Text getText();

    public TextOrBuilder getTextOrBuilder();

    public int getTextFontSize();

    public boolean hasBackground();

    public Image getBackground();

    public ImageOrBuilder getBackgroundOrBuilder();

    public int getStart();

    public int getDuration();

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public int getShadowDx();

    public int getShadowDy();

    public int getShadowRadius();

    public String getShadowColor();

    public ByteString getShadowColorBytes();

    public String getStrokeColor();

    public ByteString getStrokeColorBytes();

    public int getStrokeWidth();
}


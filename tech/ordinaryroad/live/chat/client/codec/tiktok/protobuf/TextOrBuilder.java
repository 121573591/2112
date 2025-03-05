/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.TextFormat;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.TextFormatOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.TextPiece;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.TextPieceOrBuilder;

public interface TextOrBuilder
extends MessageOrBuilder {
    public String getKey();

    public ByteString getKeyBytes();

    public String getDefaultPattern();

    public ByteString getDefaultPatternBytes();

    public boolean hasDefaultFormat();

    public TextFormat getDefaultFormat();

    public TextFormatOrBuilder getDefaultFormatOrBuilder();

    public List<TextPiece> getPiecesList();

    public TextPiece getPieces(int var1);

    public int getPiecesCount();

    public List<? extends TextPieceOrBuilder> getPiecesOrBuilderList();

    public TextPieceOrBuilder getPiecesOrBuilder(int var1);
}


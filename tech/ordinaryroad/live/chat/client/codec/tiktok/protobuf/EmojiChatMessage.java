/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.ByteBuffer
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.EmojiChatMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.PublicAreaCommon;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.PublicAreaCommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Text;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.TextOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Tiktok;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.UserOrBuilder;

public final class EmojiChatMessage
extends GeneratedMessageV3
implements EmojiChatMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int USER_FIELD_NUMBER = 2;
    private User user_;
    public static final int EMOJIID_FIELD_NUMBER = 3;
    private long emojiId_ = 0L;
    public static final int EMOJICONTENT_FIELD_NUMBER = 4;
    private Text emojiContent_;
    public static final int DEFAULTCONTENT_FIELD_NUMBER = 5;
    private volatile Object defaultContent_ = "";
    public static final int BACKGROUNDIMAGE_FIELD_NUMBER = 6;
    private Image backgroundImage_;
    public static final int FROMINTERCOM_FIELD_NUMBER = 7;
    private boolean fromIntercom_ = false;
    public static final int INTERCOMHIDEUSERCARD_FIELD_NUMBER = 8;
    private boolean intercomHideUserCard_ = false;
    public static final int PUBLIC_AREA_COMMON_FIELD_NUMBER = 9;
    private PublicAreaCommon publicAreaCommon_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final EmojiChatMessage DEFAULT_INSTANCE = new EmojiChatMessage();
    private static final Parser<EmojiChatMessage> PARSER = new AbstractParser<EmojiChatMessage>(){

        @Override
        public EmojiChatMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = EmojiChatMessage.newBuilder();
            try {
                builder.mergeFrom(input, extensionRegistry);
            }
            catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builder.buildPartial());
            }
            catch (UninitializedMessageException e) {
                throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
            }
            catch (IOException e) {
                throw new InvalidProtocolBufferException(e).setUnfinishedMessage(builder.buildPartial());
            }
            return builder.buildPartial();
        }
    };

    private EmojiChatMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private EmojiChatMessage() {
        this.defaultContent_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new EmojiChatMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Tiktok.internal_static_EmojiChatMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Tiktok.internal_static_EmojiChatMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(EmojiChatMessage.class, Builder.class);
    }

    @Override
    public boolean hasCommon() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public Common getCommon() {
        return this.common_ == null ? Common.getDefaultInstance() : this.common_;
    }

    @Override
    public CommonOrBuilder getCommonOrBuilder() {
        return this.common_ == null ? Common.getDefaultInstance() : this.common_;
    }

    @Override
    public boolean hasUser() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public User getUser() {
        return this.user_ == null ? User.getDefaultInstance() : this.user_;
    }

    @Override
    public UserOrBuilder getUserOrBuilder() {
        return this.user_ == null ? User.getDefaultInstance() : this.user_;
    }

    @Override
    public long getEmojiId() {
        return this.emojiId_;
    }

    @Override
    public boolean hasEmojiContent() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public Text getEmojiContent() {
        return this.emojiContent_ == null ? Text.getDefaultInstance() : this.emojiContent_;
    }

    @Override
    public TextOrBuilder getEmojiContentOrBuilder() {
        return this.emojiContent_ == null ? Text.getDefaultInstance() : this.emojiContent_;
    }

    @Override
    public String getDefaultContent() {
        Object ref = this.defaultContent_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.defaultContent_ = s;
        return s;
    }

    @Override
    public ByteString getDefaultContentBytes() {
        Object ref = this.defaultContent_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.defaultContent_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public boolean hasBackgroundImage() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override
    public Image getBackgroundImage() {
        return this.backgroundImage_ == null ? Image.getDefaultInstance() : this.backgroundImage_;
    }

    @Override
    public ImageOrBuilder getBackgroundImageOrBuilder() {
        return this.backgroundImage_ == null ? Image.getDefaultInstance() : this.backgroundImage_;
    }

    @Override
    public boolean getFromIntercom() {
        return this.fromIntercom_;
    }

    @Override
    public boolean getIntercomHideUserCard() {
        return this.intercomHideUserCard_;
    }

    @Override
    public boolean hasPublicAreaCommon() {
        return (this.bitField0_ & 0x10) != 0;
    }

    @Override
    public PublicAreaCommon getPublicAreaCommon() {
        return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
    }

    @Override
    public PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder() {
        return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
    }

    @Override
    public final boolean isInitialized() {
        byte isInitialized = this.memoizedIsInitialized;
        if (isInitialized == 1) {
            return true;
        }
        if (isInitialized == 0) {
            return false;
        }
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(CodedOutputStream output) throws IOException {
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(1, this.getCommon());
        }
        if ((this.bitField0_ & 2) != 0) {
            output.writeMessage(2, this.getUser());
        }
        if (this.emojiId_ != 0L) {
            output.writeUInt64(3, this.emojiId_);
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(4, this.getEmojiContent());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.defaultContent_)) {
            GeneratedMessageV3.writeString(output, 5, this.defaultContent_);
        }
        if ((this.bitField0_ & 8) != 0) {
            output.writeMessage(6, this.getBackgroundImage());
        }
        if (this.fromIntercom_) {
            output.writeBool(7, this.fromIntercom_);
        }
        if (this.intercomHideUserCard_) {
            output.writeBool(8, this.intercomHideUserCard_);
        }
        if ((this.bitField0_ & 0x10) != 0) {
            output.writeMessage(9, this.getPublicAreaCommon());
        }
        this.getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(1, this.getCommon());
        }
        if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getUser());
        }
        if (this.emojiId_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.emojiId_);
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(4, this.getEmojiContent());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.defaultContent_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.defaultContent_);
        }
        if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(6, this.getBackgroundImage());
        }
        if (this.fromIntercom_) {
            size += CodedOutputStream.computeBoolSize(7, this.fromIntercom_);
        }
        if (this.intercomHideUserCard_) {
            size += CodedOutputStream.computeBoolSize(8, this.intercomHideUserCard_);
        }
        if ((this.bitField0_ & 0x10) != 0) {
            size += CodedOutputStream.computeMessageSize(9, this.getPublicAreaCommon());
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EmojiChatMessage)) {
            return super.equals(obj);
        }
        EmojiChatMessage other = (EmojiChatMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (this.hasUser() != other.hasUser()) {
            return false;
        }
        if (this.hasUser() && !this.getUser().equals(other.getUser())) {
            return false;
        }
        if (this.getEmojiId() != other.getEmojiId()) {
            return false;
        }
        if (this.hasEmojiContent() != other.hasEmojiContent()) {
            return false;
        }
        if (this.hasEmojiContent() && !this.getEmojiContent().equals(other.getEmojiContent())) {
            return false;
        }
        if (!this.getDefaultContent().equals((Object)other.getDefaultContent())) {
            return false;
        }
        if (this.hasBackgroundImage() != other.hasBackgroundImage()) {
            return false;
        }
        if (this.hasBackgroundImage() && !this.getBackgroundImage().equals(other.getBackgroundImage())) {
            return false;
        }
        if (this.getFromIntercom() != other.getFromIntercom()) {
            return false;
        }
        if (this.getIntercomHideUserCard() != other.getIntercomHideUserCard()) {
            return false;
        }
        if (this.hasPublicAreaCommon() != other.hasPublicAreaCommon()) {
            return false;
        }
        if (this.hasPublicAreaCommon() && !this.getPublicAreaCommon().equals(other.getPublicAreaCommon())) {
            return false;
        }
        return this.getUnknownFields().equals(other.getUnknownFields());
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = 41;
        hash = 19 * hash + EmojiChatMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        if (this.hasUser()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUser().hashCode();
        }
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getEmojiId());
        if (this.hasEmojiContent()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getEmojiContent().hashCode();
        }
        hash = 37 * hash + 5;
        hash = 53 * hash + this.getDefaultContent().hashCode();
        if (this.hasBackgroundImage()) {
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getBackgroundImage().hashCode();
        }
        hash = 37 * hash + 7;
        hash = 53 * hash + Internal.hashBoolean(this.getFromIntercom());
        hash = 37 * hash + 8;
        hash = 53 * hash + Internal.hashBoolean(this.getIntercomHideUserCard());
        if (this.hasPublicAreaCommon()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getPublicAreaCommon().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static EmojiChatMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static EmojiChatMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static EmojiChatMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static EmojiChatMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static EmojiChatMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static EmojiChatMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static EmojiChatMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static EmojiChatMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static EmojiChatMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static EmojiChatMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static EmojiChatMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static EmojiChatMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return EmojiChatMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(EmojiChatMessage prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
        Builder builder = new Builder(parent);
        return builder;
    }

    public static EmojiChatMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<EmojiChatMessage> parser() {
        return PARSER;
    }

    public Parser<EmojiChatMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public EmojiChatMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements EmojiChatMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private User user_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userBuilder_;
        private long emojiId_;
        private Text emojiContent_;
        private SingleFieldBuilderV3<Text, Text.Builder, TextOrBuilder> emojiContentBuilder_;
        private Object defaultContent_ = "";
        private Image backgroundImage_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> backgroundImageBuilder_;
        private boolean fromIntercom_;
        private boolean intercomHideUserCard_;
        private PublicAreaCommon publicAreaCommon_;
        private SingleFieldBuilderV3<PublicAreaCommon, PublicAreaCommon.Builder, PublicAreaCommonOrBuilder> publicAreaCommonBuilder_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Tiktok.internal_static_EmojiChatMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Tiktok.internal_static_EmojiChatMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(EmojiChatMessage.class, Builder.class);
        }

        private Builder() {
            this.maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
            this.maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (alwaysUseFieldBuilders) {
                this.getCommonFieldBuilder();
                this.getUserFieldBuilder();
                this.getEmojiContentFieldBuilder();
                this.getBackgroundImageFieldBuilder();
                this.getPublicAreaCommonFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.common_ = null;
            if (this.commonBuilder_ != null) {
                this.commonBuilder_.dispose();
                this.commonBuilder_ = null;
            }
            this.user_ = null;
            if (this.userBuilder_ != null) {
                this.userBuilder_.dispose();
                this.userBuilder_ = null;
            }
            this.emojiId_ = 0L;
            this.emojiContent_ = null;
            if (this.emojiContentBuilder_ != null) {
                this.emojiContentBuilder_.dispose();
                this.emojiContentBuilder_ = null;
            }
            this.defaultContent_ = "";
            this.backgroundImage_ = null;
            if (this.backgroundImageBuilder_ != null) {
                this.backgroundImageBuilder_.dispose();
                this.backgroundImageBuilder_ = null;
            }
            this.fromIntercom_ = false;
            this.intercomHideUserCard_ = false;
            this.publicAreaCommon_ = null;
            if (this.publicAreaCommonBuilder_ != null) {
                this.publicAreaCommonBuilder_.dispose();
                this.publicAreaCommonBuilder_ = null;
            }
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Tiktok.internal_static_EmojiChatMessage_descriptor;
        }

        @Override
        public EmojiChatMessage getDefaultInstanceForType() {
            return EmojiChatMessage.getDefaultInstance();
        }

        @Override
        public EmojiChatMessage build() {
            EmojiChatMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public EmojiChatMessage buildPartial() {
            EmojiChatMessage result = new EmojiChatMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(EmojiChatMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.user_ = this.userBuilder_ == null ? this.user_ : this.userBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.emojiId_ = this.emojiId_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.emojiContent_ = this.emojiContentBuilder_ == null ? this.emojiContent_ : this.emojiContentBuilder_.build();
                to_bitField0_ |= 4;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.defaultContent_ = this.defaultContent_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.backgroundImage_ = this.backgroundImageBuilder_ == null ? this.backgroundImage_ : this.backgroundImageBuilder_.build();
                to_bitField0_ |= 8;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.fromIntercom_ = this.fromIntercom_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.intercomHideUserCard_ = this.intercomHideUserCard_;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.publicAreaCommon_ = this.publicAreaCommonBuilder_ == null ? this.publicAreaCommon_ : this.publicAreaCommonBuilder_.build();
                to_bitField0_ |= 0x10;
            }
            result.bitField0_ |= to_bitField0_;
        }

        @Override
        public Builder clone() {
            return (Builder)super.clone();
        }

        @Override
        public Builder setField(Descriptors.FieldDescriptor field, Object value) {
            return (Builder)super.setField(field, value);
        }

        @Override
        public Builder clearField(Descriptors.FieldDescriptor field) {
            return (Builder)super.clearField(field);
        }

        @Override
        public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
            return (Builder)super.clearOneof(oneof);
        }

        @Override
        public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            return (Builder)super.setRepeatedField(field, index, value);
        }

        @Override
        public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            return (Builder)super.addRepeatedField(field, value);
        }

        @Override
        public Builder mergeFrom(Message other) {
            if (other instanceof EmojiChatMessage) {
                return this.mergeFrom((EmojiChatMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(EmojiChatMessage other) {
            if (other == EmojiChatMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (other.hasUser()) {
                this.mergeUser(other.getUser());
            }
            if (other.getEmojiId() != 0L) {
                this.setEmojiId(other.getEmojiId());
            }
            if (other.hasEmojiContent()) {
                this.mergeEmojiContent(other.getEmojiContent());
            }
            if (!other.getDefaultContent().isEmpty()) {
                this.defaultContent_ = other.defaultContent_;
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            if (other.hasBackgroundImage()) {
                this.mergeBackgroundImage(other.getBackgroundImage());
            }
            if (other.getFromIntercom()) {
                this.setFromIntercom(other.getFromIntercom());
            }
            if (other.getIntercomHideUserCard()) {
                this.setIntercomHideUserCard(other.getIntercomHideUserCard());
            }
            if (other.hasPublicAreaCommon()) {
                this.mergePublicAreaCommon(other.getPublicAreaCommon());
            }
            this.mergeUnknownFields(other.getUnknownFields());
            this.onChanged();
            return this;
        }

        @Override
        public final boolean isInitialized() {
            return true;
        }

        @Override
        public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                boolean done = false;
                block17: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block17;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block17;
                        }
                        case 18: {
                            input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 2;
                            continue block17;
                        }
                        case 24: {
                            this.emojiId_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block17;
                        }
                        case 34: {
                            input.readMessage(this.getEmojiContentFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 8;
                            continue block17;
                        }
                        case 42: {
                            this.defaultContent_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x10;
                            continue block17;
                        }
                        case 50: {
                            input.readMessage(this.getBackgroundImageFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x20;
                            continue block17;
                        }
                        case 56: {
                            this.fromIntercom_ = input.readBool();
                            this.bitField0_ |= 0x40;
                            continue block17;
                        }
                        case 64: {
                            this.intercomHideUserCard_ = input.readBool();
                            this.bitField0_ |= 0x80;
                            continue block17;
                        }
                        case 74: {
                            input.readMessage(this.getPublicAreaCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x100;
                            continue block17;
                        }
                    }
                    if (super.parseUnknownField(input, extensionRegistry, tag)) continue;
                    done = true;
                }
            }
            catch (InvalidProtocolBufferException e) {
                throw e.unwrapIOException();
            }
            finally {
                this.onChanged();
            }
            return this;
        }

        @Override
        public boolean hasCommon() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public Common getCommon() {
            if (this.commonBuilder_ == null) {
                return this.common_ == null ? Common.getDefaultInstance() : this.common_;
            }
            return this.commonBuilder_.getMessage();
        }

        public Builder setCommon(Common value) {
            if (this.commonBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.common_ = value;
            } else {
                this.commonBuilder_.setMessage(value);
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder setCommon(Common.Builder builderForValue) {
            if (this.commonBuilder_ == null) {
                this.common_ = builderForValue.build();
            } else {
                this.commonBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder mergeCommon(Common value) {
            if (this.commonBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0 && this.common_ != null && this.common_ != Common.getDefaultInstance()) {
                    this.getCommonBuilder().mergeFrom(value);
                } else {
                    this.common_ = value;
                }
            } else {
                this.commonBuilder_.mergeFrom(value);
            }
            if (this.common_ != null) {
                this.bitField0_ |= 1;
                this.onChanged();
            }
            return this;
        }

        public Builder clearCommon() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.common_ = null;
            if (this.commonBuilder_ != null) {
                this.commonBuilder_.dispose();
                this.commonBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Common.Builder getCommonBuilder() {
            this.bitField0_ |= 1;
            this.onChanged();
            return this.getCommonFieldBuilder().getBuilder();
        }

        @Override
        public CommonOrBuilder getCommonOrBuilder() {
            if (this.commonBuilder_ != null) {
                return this.commonBuilder_.getMessageOrBuilder();
            }
            return this.common_ == null ? Common.getDefaultInstance() : this.common_;
        }

        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> getCommonFieldBuilder() {
            if (this.commonBuilder_ == null) {
                this.commonBuilder_ = new SingleFieldBuilderV3(this.getCommon(), this.getParentForChildren(), this.isClean());
                this.common_ = null;
            }
            return this.commonBuilder_;
        }

        @Override
        public boolean hasUser() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override
        public User getUser() {
            if (this.userBuilder_ == null) {
                return this.user_ == null ? User.getDefaultInstance() : this.user_;
            }
            return this.userBuilder_.getMessage();
        }

        public Builder setUser(User value) {
            if (this.userBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.user_ = value;
            } else {
                this.userBuilder_.setMessage(value);
            }
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder setUser(User.Builder builderForValue) {
            if (this.userBuilder_ == null) {
                this.user_ = builderForValue.build();
            } else {
                this.userBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder mergeUser(User value) {
            if (this.userBuilder_ == null) {
                if ((this.bitField0_ & 2) != 0 && this.user_ != null && this.user_ != User.getDefaultInstance()) {
                    this.getUserBuilder().mergeFrom(value);
                } else {
                    this.user_ = value;
                }
            } else {
                this.userBuilder_.mergeFrom(value);
            }
            if (this.user_ != null) {
                this.bitField0_ |= 2;
                this.onChanged();
            }
            return this;
        }

        public Builder clearUser() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.user_ = null;
            if (this.userBuilder_ != null) {
                this.userBuilder_.dispose();
                this.userBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public User.Builder getUserBuilder() {
            this.bitField0_ |= 2;
            this.onChanged();
            return this.getUserFieldBuilder().getBuilder();
        }

        @Override
        public UserOrBuilder getUserOrBuilder() {
            if (this.userBuilder_ != null) {
                return this.userBuilder_.getMessageOrBuilder();
            }
            return this.user_ == null ? User.getDefaultInstance() : this.user_;
        }

        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> getUserFieldBuilder() {
            if (this.userBuilder_ == null) {
                this.userBuilder_ = new SingleFieldBuilderV3(this.getUser(), this.getParentForChildren(), this.isClean());
                this.user_ = null;
            }
            return this.userBuilder_;
        }

        @Override
        public long getEmojiId() {
            return this.emojiId_;
        }

        public Builder setEmojiId(long value) {
            this.emojiId_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearEmojiId() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.emojiId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasEmojiContent() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override
        public Text getEmojiContent() {
            if (this.emojiContentBuilder_ == null) {
                return this.emojiContent_ == null ? Text.getDefaultInstance() : this.emojiContent_;
            }
            return this.emojiContentBuilder_.getMessage();
        }

        public Builder setEmojiContent(Text value) {
            if (this.emojiContentBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.emojiContent_ = value;
            } else {
                this.emojiContentBuilder_.setMessage(value);
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder setEmojiContent(Text.Builder builderForValue) {
            if (this.emojiContentBuilder_ == null) {
                this.emojiContent_ = builderForValue.build();
            } else {
                this.emojiContentBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder mergeEmojiContent(Text value) {
            if (this.emojiContentBuilder_ == null) {
                if ((this.bitField0_ & 8) != 0 && this.emojiContent_ != null && this.emojiContent_ != Text.getDefaultInstance()) {
                    this.getEmojiContentBuilder().mergeFrom(value);
                } else {
                    this.emojiContent_ = value;
                }
            } else {
                this.emojiContentBuilder_.mergeFrom(value);
            }
            if (this.emojiContent_ != null) {
                this.bitField0_ |= 8;
                this.onChanged();
            }
            return this;
        }

        public Builder clearEmojiContent() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.emojiContent_ = null;
            if (this.emojiContentBuilder_ != null) {
                this.emojiContentBuilder_.dispose();
                this.emojiContentBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Text.Builder getEmojiContentBuilder() {
            this.bitField0_ |= 8;
            this.onChanged();
            return this.getEmojiContentFieldBuilder().getBuilder();
        }

        @Override
        public TextOrBuilder getEmojiContentOrBuilder() {
            if (this.emojiContentBuilder_ != null) {
                return this.emojiContentBuilder_.getMessageOrBuilder();
            }
            return this.emojiContent_ == null ? Text.getDefaultInstance() : this.emojiContent_;
        }

        private SingleFieldBuilderV3<Text, Text.Builder, TextOrBuilder> getEmojiContentFieldBuilder() {
            if (this.emojiContentBuilder_ == null) {
                this.emojiContentBuilder_ = new SingleFieldBuilderV3(this.getEmojiContent(), this.getParentForChildren(), this.isClean());
                this.emojiContent_ = null;
            }
            return this.emojiContentBuilder_;
        }

        @Override
        public String getDefaultContent() {
            Object ref = this.defaultContent_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.defaultContent_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getDefaultContentBytes() {
            Object ref = this.defaultContent_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.defaultContent_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setDefaultContent(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.defaultContent_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearDefaultContent() {
            this.defaultContent_ = EmojiChatMessage.getDefaultInstance().getDefaultContent();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        public Builder setDefaultContentBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            EmojiChatMessage.checkByteStringIsUtf8(value);
            this.defaultContent_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasBackgroundImage() {
            return (this.bitField0_ & 0x20) != 0;
        }

        @Override
        public Image getBackgroundImage() {
            if (this.backgroundImageBuilder_ == null) {
                return this.backgroundImage_ == null ? Image.getDefaultInstance() : this.backgroundImage_;
            }
            return this.backgroundImageBuilder_.getMessage();
        }

        public Builder setBackgroundImage(Image value) {
            if (this.backgroundImageBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.backgroundImage_ = value;
            } else {
                this.backgroundImageBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder setBackgroundImage(Image.Builder builderForValue) {
            if (this.backgroundImageBuilder_ == null) {
                this.backgroundImage_ = builderForValue.build();
            } else {
                this.backgroundImageBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder mergeBackgroundImage(Image value) {
            if (this.backgroundImageBuilder_ == null) {
                if ((this.bitField0_ & 0x20) != 0 && this.backgroundImage_ != null && this.backgroundImage_ != Image.getDefaultInstance()) {
                    this.getBackgroundImageBuilder().mergeFrom(value);
                } else {
                    this.backgroundImage_ = value;
                }
            } else {
                this.backgroundImageBuilder_.mergeFrom(value);
            }
            if (this.backgroundImage_ != null) {
                this.bitField0_ |= 0x20;
                this.onChanged();
            }
            return this;
        }

        public Builder clearBackgroundImage() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.backgroundImage_ = null;
            if (this.backgroundImageBuilder_ != null) {
                this.backgroundImageBuilder_.dispose();
                this.backgroundImageBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getBackgroundImageBuilder() {
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this.getBackgroundImageFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getBackgroundImageOrBuilder() {
            if (this.backgroundImageBuilder_ != null) {
                return this.backgroundImageBuilder_.getMessageOrBuilder();
            }
            return this.backgroundImage_ == null ? Image.getDefaultInstance() : this.backgroundImage_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getBackgroundImageFieldBuilder() {
            if (this.backgroundImageBuilder_ == null) {
                this.backgroundImageBuilder_ = new SingleFieldBuilderV3(this.getBackgroundImage(), this.getParentForChildren(), this.isClean());
                this.backgroundImage_ = null;
            }
            return this.backgroundImageBuilder_;
        }

        @Override
        public boolean getFromIntercom() {
            return this.fromIntercom_;
        }

        public Builder setFromIntercom(boolean value) {
            this.fromIntercom_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearFromIntercom() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.fromIntercom_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getIntercomHideUserCard() {
            return this.intercomHideUserCard_;
        }

        public Builder setIntercomHideUserCard(boolean value) {
            this.intercomHideUserCard_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearIntercomHideUserCard() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.intercomHideUserCard_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasPublicAreaCommon() {
            return (this.bitField0_ & 0x100) != 0;
        }

        @Override
        public PublicAreaCommon getPublicAreaCommon() {
            if (this.publicAreaCommonBuilder_ == null) {
                return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
            }
            return this.publicAreaCommonBuilder_.getMessage();
        }

        public Builder setPublicAreaCommon(PublicAreaCommon value) {
            if (this.publicAreaCommonBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.publicAreaCommon_ = value;
            } else {
                this.publicAreaCommonBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder setPublicAreaCommon(PublicAreaCommon.Builder builderForValue) {
            if (this.publicAreaCommonBuilder_ == null) {
                this.publicAreaCommon_ = builderForValue.build();
            } else {
                this.publicAreaCommonBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder mergePublicAreaCommon(PublicAreaCommon value) {
            if (this.publicAreaCommonBuilder_ == null) {
                if ((this.bitField0_ & 0x100) != 0 && this.publicAreaCommon_ != null && this.publicAreaCommon_ != PublicAreaCommon.getDefaultInstance()) {
                    this.getPublicAreaCommonBuilder().mergeFrom(value);
                } else {
                    this.publicAreaCommon_ = value;
                }
            } else {
                this.publicAreaCommonBuilder_.mergeFrom(value);
            }
            if (this.publicAreaCommon_ != null) {
                this.bitField0_ |= 0x100;
                this.onChanged();
            }
            return this;
        }

        public Builder clearPublicAreaCommon() {
            this.bitField0_ &= 0xFFFFFEFF;
            this.publicAreaCommon_ = null;
            if (this.publicAreaCommonBuilder_ != null) {
                this.publicAreaCommonBuilder_.dispose();
                this.publicAreaCommonBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public PublicAreaCommon.Builder getPublicAreaCommonBuilder() {
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this.getPublicAreaCommonFieldBuilder().getBuilder();
        }

        @Override
        public PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder() {
            if (this.publicAreaCommonBuilder_ != null) {
                return this.publicAreaCommonBuilder_.getMessageOrBuilder();
            }
            return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
        }

        private SingleFieldBuilderV3<PublicAreaCommon, PublicAreaCommon.Builder, PublicAreaCommonOrBuilder> getPublicAreaCommonFieldBuilder() {
            if (this.publicAreaCommonBuilder_ == null) {
                this.publicAreaCommonBuilder_ = new SingleFieldBuilderV3(this.getPublicAreaCommon(), this.getParentForChildren(), this.isClean());
                this.publicAreaCommon_ = null;
            }
            return this.publicAreaCommonBuilder_;
        }

        @Override
        public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
            return (Builder)super.setUnknownFields(unknownFields);
        }

        @Override
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            return (Builder)super.mergeUnknownFields(unknownFields);
        }
    }
}


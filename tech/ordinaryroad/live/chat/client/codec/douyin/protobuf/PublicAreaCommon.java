/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.nio.ByteBuffer
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ChatReplyRespInfo;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ChatReplyRespInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.SuffixText;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.SuffixTextOrBuilder;

public final class PublicAreaCommon
extends GeneratedMessageV3
implements PublicAreaCommonOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int USERLABEL_FIELD_NUMBER = 1;
    private Image userLabel_;
    public static final int USERCONSUMEINROOM_FIELD_NUMBER = 2;
    private long userConsumeInRoom_ = 0L;
    public static final int USERSENDGIFTCNTINROOM_FIELD_NUMBER = 3;
    private long userSendGiftCntInRoom_ = 0L;
    public static final int INDIVIDUAL_PRIORITY_FIELD_NUMBER = 4;
    private long individualPriority_ = 0L;
    public static final int SUPPORT_PIN_FIELD_NUMBER = 6;
    private long supportPin_ = 0L;
    public static final int SUFFIX_TEXT_FIELD_NUMBER = 7;
    private SuffixText suffixText_;
    public static final int IM_ACTION_FIELD_NUMBER = 8;
    private int imAction_ = 0;
    public static final int FORBIDDEN_PROFILE_FIELD_NUMBER = 9;
    private boolean forbiddenProfile_ = false;
    public static final int REPLY_RESP_FIELD_NUMBER = 10;
    private ChatReplyRespInfo replyResp_;
    public static final int IS_FEATURED_FIELD_NUMBER = 12;
    private long isFeatured_ = 0L;
    public static final int NEED_FILTER_DISPLAY_FIELD_NUMBER = 13;
    private boolean needFilterDisplay_ = false;
    private byte memoizedIsInitialized = (byte)-1;
    private static final PublicAreaCommon DEFAULT_INSTANCE = new PublicAreaCommon();
    private static final Parser<PublicAreaCommon> PARSER = new AbstractParser<PublicAreaCommon>(){

        @Override
        public PublicAreaCommon parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = PublicAreaCommon.newBuilder();
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

    private PublicAreaCommon(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private PublicAreaCommon() {
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new PublicAreaCommon();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_PublicAreaCommon_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_PublicAreaCommon_fieldAccessorTable.ensureFieldAccessorsInitialized(PublicAreaCommon.class, Builder.class);
    }

    @Override
    public boolean hasUserLabel() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public Image getUserLabel() {
        return this.userLabel_ == null ? Image.getDefaultInstance() : this.userLabel_;
    }

    @Override
    public ImageOrBuilder getUserLabelOrBuilder() {
        return this.userLabel_ == null ? Image.getDefaultInstance() : this.userLabel_;
    }

    @Override
    public long getUserConsumeInRoom() {
        return this.userConsumeInRoom_;
    }

    @Override
    public long getUserSendGiftCntInRoom() {
        return this.userSendGiftCntInRoom_;
    }

    @Override
    public long getIndividualPriority() {
        return this.individualPriority_;
    }

    @Override
    public long getSupportPin() {
        return this.supportPin_;
    }

    @Override
    public boolean hasSuffixText() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public SuffixText getSuffixText() {
        return this.suffixText_ == null ? SuffixText.getDefaultInstance() : this.suffixText_;
    }

    @Override
    public SuffixTextOrBuilder getSuffixTextOrBuilder() {
        return this.suffixText_ == null ? SuffixText.getDefaultInstance() : this.suffixText_;
    }

    @Override
    public int getImAction() {
        return this.imAction_;
    }

    @Override
    public boolean getForbiddenProfile() {
        return this.forbiddenProfile_;
    }

    @Override
    public boolean hasReplyResp() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public ChatReplyRespInfo getReplyResp() {
        return this.replyResp_ == null ? ChatReplyRespInfo.getDefaultInstance() : this.replyResp_;
    }

    @Override
    public ChatReplyRespInfoOrBuilder getReplyRespOrBuilder() {
        return this.replyResp_ == null ? ChatReplyRespInfo.getDefaultInstance() : this.replyResp_;
    }

    @Override
    public long getIsFeatured() {
        return this.isFeatured_;
    }

    @Override
    public boolean getNeedFilterDisplay() {
        return this.needFilterDisplay_;
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
            output.writeMessage(1, this.getUserLabel());
        }
        if (this.userConsumeInRoom_ != 0L) {
            output.writeUInt64(2, this.userConsumeInRoom_);
        }
        if (this.userSendGiftCntInRoom_ != 0L) {
            output.writeUInt64(3, this.userSendGiftCntInRoom_);
        }
        if (this.individualPriority_ != 0L) {
            output.writeUInt64(4, this.individualPriority_);
        }
        if (this.supportPin_ != 0L) {
            output.writeUInt64(6, this.supportPin_);
        }
        if ((this.bitField0_ & 2) != 0) {
            output.writeMessage(7, this.getSuffixText());
        }
        if (this.imAction_ != 0) {
            output.writeInt32(8, this.imAction_);
        }
        if (this.forbiddenProfile_) {
            output.writeBool(9, this.forbiddenProfile_);
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(10, this.getReplyResp());
        }
        if (this.isFeatured_ != 0L) {
            output.writeUInt64(12, this.isFeatured_);
        }
        if (this.needFilterDisplay_) {
            output.writeBool(13, this.needFilterDisplay_);
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
            size += CodedOutputStream.computeMessageSize(1, this.getUserLabel());
        }
        if (this.userConsumeInRoom_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(2, this.userConsumeInRoom_);
        }
        if (this.userSendGiftCntInRoom_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.userSendGiftCntInRoom_);
        }
        if (this.individualPriority_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(4, this.individualPriority_);
        }
        if (this.supportPin_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(6, this.supportPin_);
        }
        if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getSuffixText());
        }
        if (this.imAction_ != 0) {
            size += CodedOutputStream.computeInt32Size(8, this.imAction_);
        }
        if (this.forbiddenProfile_) {
            size += CodedOutputStream.computeBoolSize(9, this.forbiddenProfile_);
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(10, this.getReplyResp());
        }
        if (this.isFeatured_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(12, this.isFeatured_);
        }
        if (this.needFilterDisplay_) {
            size += CodedOutputStream.computeBoolSize(13, this.needFilterDisplay_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PublicAreaCommon)) {
            return super.equals(obj);
        }
        PublicAreaCommon other = (PublicAreaCommon)obj;
        if (this.hasUserLabel() != other.hasUserLabel()) {
            return false;
        }
        if (this.hasUserLabel() && !this.getUserLabel().equals(other.getUserLabel())) {
            return false;
        }
        if (this.getUserConsumeInRoom() != other.getUserConsumeInRoom()) {
            return false;
        }
        if (this.getUserSendGiftCntInRoom() != other.getUserSendGiftCntInRoom()) {
            return false;
        }
        if (this.getIndividualPriority() != other.getIndividualPriority()) {
            return false;
        }
        if (this.getSupportPin() != other.getSupportPin()) {
            return false;
        }
        if (this.hasSuffixText() != other.hasSuffixText()) {
            return false;
        }
        if (this.hasSuffixText() && !this.getSuffixText().equals(other.getSuffixText())) {
            return false;
        }
        if (this.getImAction() != other.getImAction()) {
            return false;
        }
        if (this.getForbiddenProfile() != other.getForbiddenProfile()) {
            return false;
        }
        if (this.hasReplyResp() != other.hasReplyResp()) {
            return false;
        }
        if (this.hasReplyResp() && !this.getReplyResp().equals(other.getReplyResp())) {
            return false;
        }
        if (this.getIsFeatured() != other.getIsFeatured()) {
            return false;
        }
        if (this.getNeedFilterDisplay() != other.getNeedFilterDisplay()) {
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
        hash = 19 * hash + PublicAreaCommon.getDescriptor().hashCode();
        if (this.hasUserLabel()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getUserLabel().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + Internal.hashLong(this.getUserConsumeInRoom());
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getUserSendGiftCntInRoom());
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getIndividualPriority());
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashLong(this.getSupportPin());
        if (this.hasSuffixText()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getSuffixText().hashCode();
        }
        hash = 37 * hash + 8;
        hash = 53 * hash + this.getImAction();
        hash = 37 * hash + 9;
        hash = 53 * hash + Internal.hashBoolean(this.getForbiddenProfile());
        if (this.hasReplyResp()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getReplyResp().hashCode();
        }
        hash = 37 * hash + 12;
        hash = 53 * hash + Internal.hashLong(this.getIsFeatured());
        hash = 37 * hash + 13;
        hash = 53 * hash + Internal.hashBoolean(this.getNeedFilterDisplay());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static PublicAreaCommon parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PublicAreaCommon parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PublicAreaCommon parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PublicAreaCommon parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PublicAreaCommon parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PublicAreaCommon parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PublicAreaCommon parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static PublicAreaCommon parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static PublicAreaCommon parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static PublicAreaCommon parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static PublicAreaCommon parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static PublicAreaCommon parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return PublicAreaCommon.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PublicAreaCommon prototype) {
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

    public static PublicAreaCommon getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PublicAreaCommon> parser() {
        return PARSER;
    }

    public Parser<PublicAreaCommon> getParserForType() {
        return PARSER;
    }

    @Override
    public PublicAreaCommon getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements PublicAreaCommonOrBuilder {
        private int bitField0_;
        private Image userLabel_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> userLabelBuilder_;
        private long userConsumeInRoom_;
        private long userSendGiftCntInRoom_;
        private long individualPriority_;
        private long supportPin_;
        private SuffixText suffixText_;
        private SingleFieldBuilderV3<SuffixText, SuffixText.Builder, SuffixTextOrBuilder> suffixTextBuilder_;
        private int imAction_;
        private boolean forbiddenProfile_;
        private ChatReplyRespInfo replyResp_;
        private SingleFieldBuilderV3<ChatReplyRespInfo, ChatReplyRespInfo.Builder, ChatReplyRespInfoOrBuilder> replyRespBuilder_;
        private long isFeatured_;
        private boolean needFilterDisplay_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_PublicAreaCommon_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_PublicAreaCommon_fieldAccessorTable.ensureFieldAccessorsInitialized(PublicAreaCommon.class, Builder.class);
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
                this.getUserLabelFieldBuilder();
                this.getSuffixTextFieldBuilder();
                this.getReplyRespFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.userLabel_ = null;
            if (this.userLabelBuilder_ != null) {
                this.userLabelBuilder_.dispose();
                this.userLabelBuilder_ = null;
            }
            this.userConsumeInRoom_ = 0L;
            this.userSendGiftCntInRoom_ = 0L;
            this.individualPriority_ = 0L;
            this.supportPin_ = 0L;
            this.suffixText_ = null;
            if (this.suffixTextBuilder_ != null) {
                this.suffixTextBuilder_.dispose();
                this.suffixTextBuilder_ = null;
            }
            this.imAction_ = 0;
            this.forbiddenProfile_ = false;
            this.replyResp_ = null;
            if (this.replyRespBuilder_ != null) {
                this.replyRespBuilder_.dispose();
                this.replyRespBuilder_ = null;
            }
            this.isFeatured_ = 0L;
            this.needFilterDisplay_ = false;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_PublicAreaCommon_descriptor;
        }

        @Override
        public PublicAreaCommon getDefaultInstanceForType() {
            return PublicAreaCommon.getDefaultInstance();
        }

        @Override
        public PublicAreaCommon build() {
            PublicAreaCommon result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public PublicAreaCommon buildPartial() {
            PublicAreaCommon result = new PublicAreaCommon(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(PublicAreaCommon result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.userLabel_ = this.userLabelBuilder_ == null ? this.userLabel_ : this.userLabelBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.userConsumeInRoom_ = this.userConsumeInRoom_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.userSendGiftCntInRoom_ = this.userSendGiftCntInRoom_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.individualPriority_ = this.individualPriority_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.supportPin_ = this.supportPin_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.suffixText_ = this.suffixTextBuilder_ == null ? this.suffixText_ : this.suffixTextBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.imAction_ = this.imAction_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.forbiddenProfile_ = this.forbiddenProfile_;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.replyResp_ = this.replyRespBuilder_ == null ? this.replyResp_ : this.replyRespBuilder_.build();
                to_bitField0_ |= 4;
            }
            if ((from_bitField0_ & 0x200) != 0) {
                result.isFeatured_ = this.isFeatured_;
            }
            if ((from_bitField0_ & 0x400) != 0) {
                result.needFilterDisplay_ = this.needFilterDisplay_;
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
            if (other instanceof PublicAreaCommon) {
                return this.mergeFrom((PublicAreaCommon)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(PublicAreaCommon other) {
            if (other == PublicAreaCommon.getDefaultInstance()) {
                return this;
            }
            if (other.hasUserLabel()) {
                this.mergeUserLabel(other.getUserLabel());
            }
            if (other.getUserConsumeInRoom() != 0L) {
                this.setUserConsumeInRoom(other.getUserConsumeInRoom());
            }
            if (other.getUserSendGiftCntInRoom() != 0L) {
                this.setUserSendGiftCntInRoom(other.getUserSendGiftCntInRoom());
            }
            if (other.getIndividualPriority() != 0L) {
                this.setIndividualPriority(other.getIndividualPriority());
            }
            if (other.getSupportPin() != 0L) {
                this.setSupportPin(other.getSupportPin());
            }
            if (other.hasSuffixText()) {
                this.mergeSuffixText(other.getSuffixText());
            }
            if (other.getImAction() != 0) {
                this.setImAction(other.getImAction());
            }
            if (other.getForbiddenProfile()) {
                this.setForbiddenProfile(other.getForbiddenProfile());
            }
            if (other.hasReplyResp()) {
                this.mergeReplyResp(other.getReplyResp());
            }
            if (other.getIsFeatured() != 0L) {
                this.setIsFeatured(other.getIsFeatured());
            }
            if (other.getNeedFilterDisplay()) {
                this.setNeedFilterDisplay(other.getNeedFilterDisplay());
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
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        case 10: {
                            input.readMessage(this.getUserLabelFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block19;
                        }
                        case 16: {
                            this.userConsumeInRoom_ = input.readUInt64();
                            this.bitField0_ |= 2;
                            continue block19;
                        }
                        case 24: {
                            this.userSendGiftCntInRoom_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block19;
                        }
                        case 32: {
                            this.individualPriority_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block19;
                        }
                        case 48: {
                            this.supportPin_ = input.readUInt64();
                            this.bitField0_ |= 0x10;
                            continue block19;
                        }
                        case 58: {
                            input.readMessage(this.getSuffixTextFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x20;
                            continue block19;
                        }
                        case 64: {
                            this.imAction_ = input.readInt32();
                            this.bitField0_ |= 0x40;
                            continue block19;
                        }
                        case 72: {
                            this.forbiddenProfile_ = input.readBool();
                            this.bitField0_ |= 0x80;
                            continue block19;
                        }
                        case 82: {
                            input.readMessage(this.getReplyRespFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x100;
                            continue block19;
                        }
                        case 96: {
                            this.isFeatured_ = input.readUInt64();
                            this.bitField0_ |= 0x200;
                            continue block19;
                        }
                        case 104: {
                            this.needFilterDisplay_ = input.readBool();
                            this.bitField0_ |= 0x400;
                            continue block19;
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
        public boolean hasUserLabel() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public Image getUserLabel() {
            if (this.userLabelBuilder_ == null) {
                return this.userLabel_ == null ? Image.getDefaultInstance() : this.userLabel_;
            }
            return this.userLabelBuilder_.getMessage();
        }

        public Builder setUserLabel(Image value) {
            if (this.userLabelBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.userLabel_ = value;
            } else {
                this.userLabelBuilder_.setMessage(value);
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder setUserLabel(Image.Builder builderForValue) {
            if (this.userLabelBuilder_ == null) {
                this.userLabel_ = builderForValue.build();
            } else {
                this.userLabelBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder mergeUserLabel(Image value) {
            if (this.userLabelBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0 && this.userLabel_ != null && this.userLabel_ != Image.getDefaultInstance()) {
                    this.getUserLabelBuilder().mergeFrom(value);
                } else {
                    this.userLabel_ = value;
                }
            } else {
                this.userLabelBuilder_.mergeFrom(value);
            }
            if (this.userLabel_ != null) {
                this.bitField0_ |= 1;
                this.onChanged();
            }
            return this;
        }

        public Builder clearUserLabel() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.userLabel_ = null;
            if (this.userLabelBuilder_ != null) {
                this.userLabelBuilder_.dispose();
                this.userLabelBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getUserLabelBuilder() {
            this.bitField0_ |= 1;
            this.onChanged();
            return this.getUserLabelFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getUserLabelOrBuilder() {
            if (this.userLabelBuilder_ != null) {
                return this.userLabelBuilder_.getMessageOrBuilder();
            }
            return this.userLabel_ == null ? Image.getDefaultInstance() : this.userLabel_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getUserLabelFieldBuilder() {
            if (this.userLabelBuilder_ == null) {
                this.userLabelBuilder_ = new SingleFieldBuilderV3(this.getUserLabel(), this.getParentForChildren(), this.isClean());
                this.userLabel_ = null;
            }
            return this.userLabelBuilder_;
        }

        @Override
        public long getUserConsumeInRoom() {
            return this.userConsumeInRoom_;
        }

        public Builder setUserConsumeInRoom(long value) {
            this.userConsumeInRoom_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearUserConsumeInRoom() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.userConsumeInRoom_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getUserSendGiftCntInRoom() {
            return this.userSendGiftCntInRoom_;
        }

        public Builder setUserSendGiftCntInRoom(long value) {
            this.userSendGiftCntInRoom_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearUserSendGiftCntInRoom() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.userSendGiftCntInRoom_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getIndividualPriority() {
            return this.individualPriority_;
        }

        public Builder setIndividualPriority(long value) {
            this.individualPriority_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearIndividualPriority() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.individualPriority_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getSupportPin() {
            return this.supportPin_;
        }

        public Builder setSupportPin(long value) {
            this.supportPin_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearSupportPin() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.supportPin_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasSuffixText() {
            return (this.bitField0_ & 0x20) != 0;
        }

        @Override
        public SuffixText getSuffixText() {
            if (this.suffixTextBuilder_ == null) {
                return this.suffixText_ == null ? SuffixText.getDefaultInstance() : this.suffixText_;
            }
            return this.suffixTextBuilder_.getMessage();
        }

        public Builder setSuffixText(SuffixText value) {
            if (this.suffixTextBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.suffixText_ = value;
            } else {
                this.suffixTextBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder setSuffixText(SuffixText.Builder builderForValue) {
            if (this.suffixTextBuilder_ == null) {
                this.suffixText_ = builderForValue.build();
            } else {
                this.suffixTextBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder mergeSuffixText(SuffixText value) {
            if (this.suffixTextBuilder_ == null) {
                if ((this.bitField0_ & 0x20) != 0 && this.suffixText_ != null && this.suffixText_ != SuffixText.getDefaultInstance()) {
                    this.getSuffixTextBuilder().mergeFrom(value);
                } else {
                    this.suffixText_ = value;
                }
            } else {
                this.suffixTextBuilder_.mergeFrom(value);
            }
            if (this.suffixText_ != null) {
                this.bitField0_ |= 0x20;
                this.onChanged();
            }
            return this;
        }

        public Builder clearSuffixText() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.suffixText_ = null;
            if (this.suffixTextBuilder_ != null) {
                this.suffixTextBuilder_.dispose();
                this.suffixTextBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public SuffixText.Builder getSuffixTextBuilder() {
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this.getSuffixTextFieldBuilder().getBuilder();
        }

        @Override
        public SuffixTextOrBuilder getSuffixTextOrBuilder() {
            if (this.suffixTextBuilder_ != null) {
                return this.suffixTextBuilder_.getMessageOrBuilder();
            }
            return this.suffixText_ == null ? SuffixText.getDefaultInstance() : this.suffixText_;
        }

        private SingleFieldBuilderV3<SuffixText, SuffixText.Builder, SuffixTextOrBuilder> getSuffixTextFieldBuilder() {
            if (this.suffixTextBuilder_ == null) {
                this.suffixTextBuilder_ = new SingleFieldBuilderV3(this.getSuffixText(), this.getParentForChildren(), this.isClean());
                this.suffixText_ = null;
            }
            return this.suffixTextBuilder_;
        }

        @Override
        public int getImAction() {
            return this.imAction_;
        }

        public Builder setImAction(int value) {
            this.imAction_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearImAction() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.imAction_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getForbiddenProfile() {
            return this.forbiddenProfile_;
        }

        public Builder setForbiddenProfile(boolean value) {
            this.forbiddenProfile_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearForbiddenProfile() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.forbiddenProfile_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasReplyResp() {
            return (this.bitField0_ & 0x100) != 0;
        }

        @Override
        public ChatReplyRespInfo getReplyResp() {
            if (this.replyRespBuilder_ == null) {
                return this.replyResp_ == null ? ChatReplyRespInfo.getDefaultInstance() : this.replyResp_;
            }
            return this.replyRespBuilder_.getMessage();
        }

        public Builder setReplyResp(ChatReplyRespInfo value) {
            if (this.replyRespBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.replyResp_ = value;
            } else {
                this.replyRespBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder setReplyResp(ChatReplyRespInfo.Builder builderForValue) {
            if (this.replyRespBuilder_ == null) {
                this.replyResp_ = builderForValue.build();
            } else {
                this.replyRespBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder mergeReplyResp(ChatReplyRespInfo value) {
            if (this.replyRespBuilder_ == null) {
                if ((this.bitField0_ & 0x100) != 0 && this.replyResp_ != null && this.replyResp_ != ChatReplyRespInfo.getDefaultInstance()) {
                    this.getReplyRespBuilder().mergeFrom(value);
                } else {
                    this.replyResp_ = value;
                }
            } else {
                this.replyRespBuilder_.mergeFrom(value);
            }
            if (this.replyResp_ != null) {
                this.bitField0_ |= 0x100;
                this.onChanged();
            }
            return this;
        }

        public Builder clearReplyResp() {
            this.bitField0_ &= 0xFFFFFEFF;
            this.replyResp_ = null;
            if (this.replyRespBuilder_ != null) {
                this.replyRespBuilder_.dispose();
                this.replyRespBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public ChatReplyRespInfo.Builder getReplyRespBuilder() {
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this.getReplyRespFieldBuilder().getBuilder();
        }

        @Override
        public ChatReplyRespInfoOrBuilder getReplyRespOrBuilder() {
            if (this.replyRespBuilder_ != null) {
                return this.replyRespBuilder_.getMessageOrBuilder();
            }
            return this.replyResp_ == null ? ChatReplyRespInfo.getDefaultInstance() : this.replyResp_;
        }

        private SingleFieldBuilderV3<ChatReplyRespInfo, ChatReplyRespInfo.Builder, ChatReplyRespInfoOrBuilder> getReplyRespFieldBuilder() {
            if (this.replyRespBuilder_ == null) {
                this.replyRespBuilder_ = new SingleFieldBuilderV3(this.getReplyResp(), this.getParentForChildren(), this.isClean());
                this.replyResp_ = null;
            }
            return this.replyRespBuilder_;
        }

        @Override
        public long getIsFeatured() {
            return this.isFeatured_;
        }

        public Builder setIsFeatured(long value) {
            this.isFeatured_ = value;
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder clearIsFeatured() {
            this.bitField0_ &= 0xFFFFFDFF;
            this.isFeatured_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getNeedFilterDisplay() {
            return this.needFilterDisplay_;
        }

        public Builder setNeedFilterDisplay(boolean value) {
            this.needFilterDisplay_ = value;
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this;
        }

        public Builder clearNeedFilterDisplay() {
            this.bitField0_ &= 0xFFFFFBFF;
            this.needFilterDisplay_ = false;
            this.onChanged();
            return this;
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


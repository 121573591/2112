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
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.InRoomBannerMessageOrBuilder;

public final class InRoomBannerMessage
extends GeneratedMessageV3
implements InRoomBannerMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int EXTRA_FIELD_NUMBER = 2;
    private volatile Object extra_ = "";
    public static final int POSITION_FIELD_NUMBER = 3;
    private int position_ = 0;
    public static final int ACTION_TYPE_FIELD_NUMBER = 4;
    private int actionType_ = 0;
    public static final int CONTAINER_URL_FIELD_NUMBER = 5;
    private volatile Object containerUrl_ = "";
    public static final int LYNX_CONTAINER_URL_FIELD_NUMBER = 6;
    private volatile Object lynxContainerUrl_ = "";
    public static final int CONTAINER_TYPE_FIELD_NUMBER = 7;
    private int containerType_ = 0;
    public static final int OP_TYPE_FIELD_NUMBER = 8;
    private int opType_ = 0;
    private byte memoizedIsInitialized = (byte)-1;
    private static final InRoomBannerMessage DEFAULT_INSTANCE = new InRoomBannerMessage();
    private static final Parser<InRoomBannerMessage> PARSER = new AbstractParser<InRoomBannerMessage>(){

        @Override
        public InRoomBannerMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = InRoomBannerMessage.newBuilder();
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

    private InRoomBannerMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private InRoomBannerMessage() {
        this.extra_ = "";
        this.containerUrl_ = "";
        this.lynxContainerUrl_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new InRoomBannerMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_InRoomBannerMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_InRoomBannerMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(InRoomBannerMessage.class, Builder.class);
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
    public String getExtra() {
        Object ref = this.extra_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.extra_ = s;
        return s;
    }

    @Override
    public ByteString getExtraBytes() {
        Object ref = this.extra_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.extra_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public int getPosition() {
        return this.position_;
    }

    @Override
    public int getActionType() {
        return this.actionType_;
    }

    @Override
    public String getContainerUrl() {
        Object ref = this.containerUrl_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.containerUrl_ = s;
        return s;
    }

    @Override
    public ByteString getContainerUrlBytes() {
        Object ref = this.containerUrl_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.containerUrl_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getLynxContainerUrl() {
        Object ref = this.lynxContainerUrl_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.lynxContainerUrl_ = s;
        return s;
    }

    @Override
    public ByteString getLynxContainerUrlBytes() {
        Object ref = this.lynxContainerUrl_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.lynxContainerUrl_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public int getContainerType() {
        return this.containerType_;
    }

    @Override
    public int getOpType() {
        return this.opType_;
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
        if (!GeneratedMessageV3.isStringEmpty(this.extra_)) {
            GeneratedMessageV3.writeString(output, 2, this.extra_);
        }
        if (this.position_ != 0) {
            output.writeInt32(3, this.position_);
        }
        if (this.actionType_ != 0) {
            output.writeInt32(4, this.actionType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.containerUrl_)) {
            GeneratedMessageV3.writeString(output, 5, this.containerUrl_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.lynxContainerUrl_)) {
            GeneratedMessageV3.writeString(output, 6, this.lynxContainerUrl_);
        }
        if (this.containerType_ != 0) {
            output.writeInt32(7, this.containerType_);
        }
        if (this.opType_ != 0) {
            output.writeInt32(8, this.opType_);
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
        if (!GeneratedMessageV3.isStringEmpty(this.extra_)) {
            size += GeneratedMessageV3.computeStringSize(2, this.extra_);
        }
        if (this.position_ != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.position_);
        }
        if (this.actionType_ != 0) {
            size += CodedOutputStream.computeInt32Size(4, this.actionType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.containerUrl_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.containerUrl_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.lynxContainerUrl_)) {
            size += GeneratedMessageV3.computeStringSize(6, this.lynxContainerUrl_);
        }
        if (this.containerType_ != 0) {
            size += CodedOutputStream.computeInt32Size(7, this.containerType_);
        }
        if (this.opType_ != 0) {
            size += CodedOutputStream.computeInt32Size(8, this.opType_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InRoomBannerMessage)) {
            return super.equals(obj);
        }
        InRoomBannerMessage other = (InRoomBannerMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (!this.getExtra().equals((Object)other.getExtra())) {
            return false;
        }
        if (this.getPosition() != other.getPosition()) {
            return false;
        }
        if (this.getActionType() != other.getActionType()) {
            return false;
        }
        if (!this.getContainerUrl().equals((Object)other.getContainerUrl())) {
            return false;
        }
        if (!this.getLynxContainerUrl().equals((Object)other.getLynxContainerUrl())) {
            return false;
        }
        if (this.getContainerType() != other.getContainerType()) {
            return false;
        }
        if (this.getOpType() != other.getOpType()) {
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
        hash = 19 * hash + InRoomBannerMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getExtra().hashCode();
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getPosition();
        hash = 37 * hash + 4;
        hash = 53 * hash + this.getActionType();
        hash = 37 * hash + 5;
        hash = 53 * hash + this.getContainerUrl().hashCode();
        hash = 37 * hash + 6;
        hash = 53 * hash + this.getLynxContainerUrl().hashCode();
        hash = 37 * hash + 7;
        hash = 53 * hash + this.getContainerType();
        hash = 37 * hash + 8;
        hash = 53 * hash + this.getOpType();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static InRoomBannerMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static InRoomBannerMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static InRoomBannerMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static InRoomBannerMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static InRoomBannerMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static InRoomBannerMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static InRoomBannerMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static InRoomBannerMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static InRoomBannerMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static InRoomBannerMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static InRoomBannerMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static InRoomBannerMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return InRoomBannerMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(InRoomBannerMessage prototype) {
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

    public static InRoomBannerMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<InRoomBannerMessage> parser() {
        return PARSER;
    }

    public Parser<InRoomBannerMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public InRoomBannerMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements InRoomBannerMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private Object extra_ = "";
        private int position_;
        private int actionType_;
        private Object containerUrl_ = "";
        private Object lynxContainerUrl_ = "";
        private int containerType_;
        private int opType_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_InRoomBannerMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_InRoomBannerMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(InRoomBannerMessage.class, Builder.class);
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
            this.extra_ = "";
            this.position_ = 0;
            this.actionType_ = 0;
            this.containerUrl_ = "";
            this.lynxContainerUrl_ = "";
            this.containerType_ = 0;
            this.opType_ = 0;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_InRoomBannerMessage_descriptor;
        }

        @Override
        public InRoomBannerMessage getDefaultInstanceForType() {
            return InRoomBannerMessage.getDefaultInstance();
        }

        @Override
        public InRoomBannerMessage build() {
            InRoomBannerMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public InRoomBannerMessage buildPartial() {
            InRoomBannerMessage result = new InRoomBannerMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(InRoomBannerMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.extra_ = this.extra_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.position_ = this.position_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.actionType_ = this.actionType_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.containerUrl_ = this.containerUrl_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.lynxContainerUrl_ = this.lynxContainerUrl_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.containerType_ = this.containerType_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.opType_ = this.opType_;
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
            if (other instanceof InRoomBannerMessage) {
                return this.mergeFrom((InRoomBannerMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(InRoomBannerMessage other) {
            if (other == InRoomBannerMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (!other.getExtra().isEmpty()) {
                this.extra_ = other.extra_;
                this.bitField0_ |= 2;
                this.onChanged();
            }
            if (other.getPosition() != 0) {
                this.setPosition(other.getPosition());
            }
            if (other.getActionType() != 0) {
                this.setActionType(other.getActionType());
            }
            if (!other.getContainerUrl().isEmpty()) {
                this.containerUrl_ = other.containerUrl_;
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            if (!other.getLynxContainerUrl().isEmpty()) {
                this.lynxContainerUrl_ = other.lynxContainerUrl_;
                this.bitField0_ |= 0x20;
                this.onChanged();
            }
            if (other.getContainerType() != 0) {
                this.setContainerType(other.getContainerType());
            }
            if (other.getOpType() != 0) {
                this.setOpType(other.getOpType());
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
                block16: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block16;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block16;
                        }
                        case 18: {
                            this.extra_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 2;
                            continue block16;
                        }
                        case 24: {
                            this.position_ = input.readInt32();
                            this.bitField0_ |= 4;
                            continue block16;
                        }
                        case 32: {
                            this.actionType_ = input.readInt32();
                            this.bitField0_ |= 8;
                            continue block16;
                        }
                        case 42: {
                            this.containerUrl_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x10;
                            continue block16;
                        }
                        case 50: {
                            this.lynxContainerUrl_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x20;
                            continue block16;
                        }
                        case 56: {
                            this.containerType_ = input.readInt32();
                            this.bitField0_ |= 0x40;
                            continue block16;
                        }
                        case 64: {
                            this.opType_ = input.readInt32();
                            this.bitField0_ |= 0x80;
                            continue block16;
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
        public String getExtra() {
            Object ref = this.extra_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.extra_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getExtraBytes() {
            Object ref = this.extra_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.extra_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setExtra(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.extra_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearExtra() {
            this.extra_ = InRoomBannerMessage.getDefaultInstance().getExtra();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setExtraBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            InRoomBannerMessage.checkByteStringIsUtf8(value);
            this.extra_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        @Override
        public int getPosition() {
            return this.position_;
        }

        public Builder setPosition(int value) {
            this.position_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearPosition() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.position_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public int getActionType() {
            return this.actionType_;
        }

        public Builder setActionType(int value) {
            this.actionType_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearActionType() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.actionType_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public String getContainerUrl() {
            Object ref = this.containerUrl_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.containerUrl_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getContainerUrlBytes() {
            Object ref = this.containerUrl_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.containerUrl_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setContainerUrl(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.containerUrl_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearContainerUrl() {
            this.containerUrl_ = InRoomBannerMessage.getDefaultInstance().getContainerUrl();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        public Builder setContainerUrlBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            InRoomBannerMessage.checkByteStringIsUtf8(value);
            this.containerUrl_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        @Override
        public String getLynxContainerUrl() {
            Object ref = this.lynxContainerUrl_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.lynxContainerUrl_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getLynxContainerUrlBytes() {
            Object ref = this.lynxContainerUrl_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.lynxContainerUrl_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setLynxContainerUrl(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.lynxContainerUrl_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearLynxContainerUrl() {
            this.lynxContainerUrl_ = InRoomBannerMessage.getDefaultInstance().getLynxContainerUrl();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
            return this;
        }

        public Builder setLynxContainerUrlBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            InRoomBannerMessage.checkByteStringIsUtf8(value);
            this.lynxContainerUrl_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        @Override
        public int getContainerType() {
            return this.containerType_;
        }

        public Builder setContainerType(int value) {
            this.containerType_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearContainerType() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.containerType_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public int getOpType() {
            return this.opType_;
        }

        public Builder setOpType(int value) {
            this.opType_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearOpType() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.opType_ = 0;
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


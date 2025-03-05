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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Against;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.AgainstOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.MatchAgainstScoreMessageOrBuilder;

public final class MatchAgainstScoreMessage
extends GeneratedMessageV3
implements MatchAgainstScoreMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int AGAINST_FIELD_NUMBER = 2;
    private Against against_;
    public static final int MATCHSTATUS_FIELD_NUMBER = 3;
    private int matchStatus_ = 0;
    public static final int DISPLAYSTATUS_FIELD_NUMBER = 4;
    private int displayStatus_ = 0;
    private byte memoizedIsInitialized = (byte)-1;
    private static final MatchAgainstScoreMessage DEFAULT_INSTANCE = new MatchAgainstScoreMessage();
    private static final Parser<MatchAgainstScoreMessage> PARSER = new AbstractParser<MatchAgainstScoreMessage>(){

        @Override
        public MatchAgainstScoreMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = MatchAgainstScoreMessage.newBuilder();
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

    private MatchAgainstScoreMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private MatchAgainstScoreMessage() {
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new MatchAgainstScoreMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_MatchAgainstScoreMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_MatchAgainstScoreMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(MatchAgainstScoreMessage.class, Builder.class);
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
    public boolean hasAgainst() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public Against getAgainst() {
        return this.against_ == null ? Against.getDefaultInstance() : this.against_;
    }

    @Override
    public AgainstOrBuilder getAgainstOrBuilder() {
        return this.against_ == null ? Against.getDefaultInstance() : this.against_;
    }

    @Override
    public int getMatchStatus() {
        return this.matchStatus_;
    }

    @Override
    public int getDisplayStatus() {
        return this.displayStatus_;
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
            output.writeMessage(2, this.getAgainst());
        }
        if (this.matchStatus_ != 0) {
            output.writeUInt32(3, this.matchStatus_);
        }
        if (this.displayStatus_ != 0) {
            output.writeUInt32(4, this.displayStatus_);
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
            size += CodedOutputStream.computeMessageSize(2, this.getAgainst());
        }
        if (this.matchStatus_ != 0) {
            size += CodedOutputStream.computeUInt32Size(3, this.matchStatus_);
        }
        if (this.displayStatus_ != 0) {
            size += CodedOutputStream.computeUInt32Size(4, this.displayStatus_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MatchAgainstScoreMessage)) {
            return super.equals(obj);
        }
        MatchAgainstScoreMessage other = (MatchAgainstScoreMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (this.hasAgainst() != other.hasAgainst()) {
            return false;
        }
        if (this.hasAgainst() && !this.getAgainst().equals(other.getAgainst())) {
            return false;
        }
        if (this.getMatchStatus() != other.getMatchStatus()) {
            return false;
        }
        if (this.getDisplayStatus() != other.getDisplayStatus()) {
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
        hash = 19 * hash + MatchAgainstScoreMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        if (this.hasAgainst()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getAgainst().hashCode();
        }
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getMatchStatus();
        hash = 37 * hash + 4;
        hash = 53 * hash + this.getDisplayStatus();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static MatchAgainstScoreMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static MatchAgainstScoreMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static MatchAgainstScoreMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static MatchAgainstScoreMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static MatchAgainstScoreMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static MatchAgainstScoreMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static MatchAgainstScoreMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static MatchAgainstScoreMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static MatchAgainstScoreMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static MatchAgainstScoreMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static MatchAgainstScoreMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static MatchAgainstScoreMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return MatchAgainstScoreMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MatchAgainstScoreMessage prototype) {
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

    public static MatchAgainstScoreMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MatchAgainstScoreMessage> parser() {
        return PARSER;
    }

    public Parser<MatchAgainstScoreMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public MatchAgainstScoreMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements MatchAgainstScoreMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private Against against_;
        private SingleFieldBuilderV3<Against, Against.Builder, AgainstOrBuilder> againstBuilder_;
        private int matchStatus_;
        private int displayStatus_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_MatchAgainstScoreMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_MatchAgainstScoreMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(MatchAgainstScoreMessage.class, Builder.class);
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
                this.getAgainstFieldBuilder();
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
            this.against_ = null;
            if (this.againstBuilder_ != null) {
                this.againstBuilder_.dispose();
                this.againstBuilder_ = null;
            }
            this.matchStatus_ = 0;
            this.displayStatus_ = 0;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_MatchAgainstScoreMessage_descriptor;
        }

        @Override
        public MatchAgainstScoreMessage getDefaultInstanceForType() {
            return MatchAgainstScoreMessage.getDefaultInstance();
        }

        @Override
        public MatchAgainstScoreMessage build() {
            MatchAgainstScoreMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public MatchAgainstScoreMessage buildPartial() {
            MatchAgainstScoreMessage result = new MatchAgainstScoreMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(MatchAgainstScoreMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.against_ = this.againstBuilder_ == null ? this.against_ : this.againstBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.matchStatus_ = this.matchStatus_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.displayStatus_ = this.displayStatus_;
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
            if (other instanceof MatchAgainstScoreMessage) {
                return this.mergeFrom((MatchAgainstScoreMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(MatchAgainstScoreMessage other) {
            if (other == MatchAgainstScoreMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (other.hasAgainst()) {
                this.mergeAgainst(other.getAgainst());
            }
            if (other.getMatchStatus() != 0) {
                this.setMatchStatus(other.getMatchStatus());
            }
            if (other.getDisplayStatus() != 0) {
                this.setDisplayStatus(other.getDisplayStatus());
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
                block12: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block12;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block12;
                        }
                        case 18: {
                            input.readMessage(this.getAgainstFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 2;
                            continue block12;
                        }
                        case 24: {
                            this.matchStatus_ = input.readUInt32();
                            this.bitField0_ |= 4;
                            continue block12;
                        }
                        case 32: {
                            this.displayStatus_ = input.readUInt32();
                            this.bitField0_ |= 8;
                            continue block12;
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
        public boolean hasAgainst() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override
        public Against getAgainst() {
            if (this.againstBuilder_ == null) {
                return this.against_ == null ? Against.getDefaultInstance() : this.against_;
            }
            return this.againstBuilder_.getMessage();
        }

        public Builder setAgainst(Against value) {
            if (this.againstBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.against_ = value;
            } else {
                this.againstBuilder_.setMessage(value);
            }
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder setAgainst(Against.Builder builderForValue) {
            if (this.againstBuilder_ == null) {
                this.against_ = builderForValue.build();
            } else {
                this.againstBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder mergeAgainst(Against value) {
            if (this.againstBuilder_ == null) {
                if ((this.bitField0_ & 2) != 0 && this.against_ != null && this.against_ != Against.getDefaultInstance()) {
                    this.getAgainstBuilder().mergeFrom(value);
                } else {
                    this.against_ = value;
                }
            } else {
                this.againstBuilder_.mergeFrom(value);
            }
            if (this.against_ != null) {
                this.bitField0_ |= 2;
                this.onChanged();
            }
            return this;
        }

        public Builder clearAgainst() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.against_ = null;
            if (this.againstBuilder_ != null) {
                this.againstBuilder_.dispose();
                this.againstBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Against.Builder getAgainstBuilder() {
            this.bitField0_ |= 2;
            this.onChanged();
            return this.getAgainstFieldBuilder().getBuilder();
        }

        @Override
        public AgainstOrBuilder getAgainstOrBuilder() {
            if (this.againstBuilder_ != null) {
                return this.againstBuilder_.getMessageOrBuilder();
            }
            return this.against_ == null ? Against.getDefaultInstance() : this.against_;
        }

        private SingleFieldBuilderV3<Against, Against.Builder, AgainstOrBuilder> getAgainstFieldBuilder() {
            if (this.againstBuilder_ == null) {
                this.againstBuilder_ = new SingleFieldBuilderV3(this.getAgainst(), this.getParentForChildren(), this.isClean());
                this.against_ = null;
            }
            return this.againstBuilder_;
        }

        @Override
        public int getMatchStatus() {
            return this.matchStatus_;
        }

        public Builder setMatchStatus(int value) {
            this.matchStatus_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearMatchStatus() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.matchStatus_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public int getDisplayStatus() {
            return this.displayStatus_;
        }

        public Builder setDisplayStatus(int value) {
            this.displayStatus_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayStatus() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.displayStatus_ = 0;
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


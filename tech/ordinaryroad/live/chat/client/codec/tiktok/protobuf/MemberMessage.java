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
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.MemberMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Text;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.TextOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Tiktok;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.UserOrBuilder;

public final class MemberMessage
extends GeneratedMessageV3
implements MemberMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int USER_FIELD_NUMBER = 2;
    private User user_;
    public static final int MEMBERCOUNT_FIELD_NUMBER = 3;
    private long memberCount_ = 0L;
    public static final int ACTION_FIELD_NUMBER = 10;
    private long action_ = 0L;
    public static final int ANCHORDISPLAYTEXT_FIELD_NUMBER = 18;
    private Text anchorDisplayText_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final MemberMessage DEFAULT_INSTANCE = new MemberMessage();
    private static final Parser<MemberMessage> PARSER = new AbstractParser<MemberMessage>(){

        @Override
        public MemberMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = MemberMessage.newBuilder();
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

    private MemberMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private MemberMessage() {
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new MemberMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Tiktok.internal_static_MemberMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Tiktok.internal_static_MemberMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(MemberMessage.class, Builder.class);
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
    public long getMemberCount() {
        return this.memberCount_;
    }

    @Override
    public long getAction() {
        return this.action_;
    }

    @Override
    public boolean hasAnchorDisplayText() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public Text getAnchorDisplayText() {
        return this.anchorDisplayText_ == null ? Text.getDefaultInstance() : this.anchorDisplayText_;
    }

    @Override
    public TextOrBuilder getAnchorDisplayTextOrBuilder() {
        return this.anchorDisplayText_ == null ? Text.getDefaultInstance() : this.anchorDisplayText_;
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
        if (this.memberCount_ != 0L) {
            output.writeUInt64(3, this.memberCount_);
        }
        if (this.action_ != 0L) {
            output.writeUInt64(10, this.action_);
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(18, this.getAnchorDisplayText());
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
        if (this.memberCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.memberCount_);
        }
        if (this.action_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(10, this.action_);
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(18, this.getAnchorDisplayText());
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MemberMessage)) {
            return super.equals(obj);
        }
        MemberMessage other = (MemberMessage)obj;
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
        if (this.getMemberCount() != other.getMemberCount()) {
            return false;
        }
        if (this.getAction() != other.getAction()) {
            return false;
        }
        if (this.hasAnchorDisplayText() != other.hasAnchorDisplayText()) {
            return false;
        }
        if (this.hasAnchorDisplayText() && !this.getAnchorDisplayText().equals(other.getAnchorDisplayText())) {
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
        hash = 19 * hash + MemberMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        if (this.hasUser()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUser().hashCode();
        }
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getMemberCount());
        hash = 37 * hash + 10;
        hash = 53 * hash + Internal.hashLong(this.getAction());
        if (this.hasAnchorDisplayText()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getAnchorDisplayText().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static MemberMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static MemberMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static MemberMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static MemberMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static MemberMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static MemberMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static MemberMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static MemberMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static MemberMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static MemberMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static MemberMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static MemberMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return MemberMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MemberMessage prototype) {
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

    public static MemberMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MemberMessage> parser() {
        return PARSER;
    }

    public Parser<MemberMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public MemberMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements MemberMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private User user_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userBuilder_;
        private long memberCount_;
        private long action_;
        private Text anchorDisplayText_;
        private SingleFieldBuilderV3<Text, Text.Builder, TextOrBuilder> anchorDisplayTextBuilder_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Tiktok.internal_static_MemberMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Tiktok.internal_static_MemberMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(MemberMessage.class, Builder.class);
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
                this.getAnchorDisplayTextFieldBuilder();
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
            this.memberCount_ = 0L;
            this.action_ = 0L;
            this.anchorDisplayText_ = null;
            if (this.anchorDisplayTextBuilder_ != null) {
                this.anchorDisplayTextBuilder_.dispose();
                this.anchorDisplayTextBuilder_ = null;
            }
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Tiktok.internal_static_MemberMessage_descriptor;
        }

        @Override
        public MemberMessage getDefaultInstanceForType() {
            return MemberMessage.getDefaultInstance();
        }

        @Override
        public MemberMessage build() {
            MemberMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public MemberMessage buildPartial() {
            MemberMessage result = new MemberMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(MemberMessage result) {
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
                result.memberCount_ = this.memberCount_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.action_ = this.action_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.anchorDisplayText_ = this.anchorDisplayTextBuilder_ == null ? this.anchorDisplayText_ : this.anchorDisplayTextBuilder_.build();
                to_bitField0_ |= 4;
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
            if (other instanceof MemberMessage) {
                return this.mergeFrom((MemberMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(MemberMessage other) {
            if (other == MemberMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (other.hasUser()) {
                this.mergeUser(other.getUser());
            }
            if (other.getMemberCount() != 0L) {
                this.setMemberCount(other.getMemberCount());
            }
            if (other.getAction() != 0L) {
                this.setAction(other.getAction());
            }
            if (other.hasAnchorDisplayText()) {
                this.mergeAnchorDisplayText(other.getAnchorDisplayText());
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
                block13: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block13;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block13;
                        }
                        case 18: {
                            input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 2;
                            continue block13;
                        }
                        case 24: {
                            this.memberCount_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block13;
                        }
                        case 80: {
                            this.action_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block13;
                        }
                        case 146: {
                            input.readMessage(this.getAnchorDisplayTextFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x10;
                            continue block13;
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
        public long getMemberCount() {
            return this.memberCount_;
        }

        public Builder setMemberCount(long value) {
            this.memberCount_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearMemberCount() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.memberCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getAction() {
            return this.action_;
        }

        public Builder setAction(long value) {
            this.action_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearAction() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.action_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasAnchorDisplayText() {
            return (this.bitField0_ & 0x10) != 0;
        }

        @Override
        public Text getAnchorDisplayText() {
            if (this.anchorDisplayTextBuilder_ == null) {
                return this.anchorDisplayText_ == null ? Text.getDefaultInstance() : this.anchorDisplayText_;
            }
            return this.anchorDisplayTextBuilder_.getMessage();
        }

        public Builder setAnchorDisplayText(Text value) {
            if (this.anchorDisplayTextBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.anchorDisplayText_ = value;
            } else {
                this.anchorDisplayTextBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder setAnchorDisplayText(Text.Builder builderForValue) {
            if (this.anchorDisplayTextBuilder_ == null) {
                this.anchorDisplayText_ = builderForValue.build();
            } else {
                this.anchorDisplayTextBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder mergeAnchorDisplayText(Text value) {
            if (this.anchorDisplayTextBuilder_ == null) {
                if ((this.bitField0_ & 0x10) != 0 && this.anchorDisplayText_ != null && this.anchorDisplayText_ != Text.getDefaultInstance()) {
                    this.getAnchorDisplayTextBuilder().mergeFrom(value);
                } else {
                    this.anchorDisplayText_ = value;
                }
            } else {
                this.anchorDisplayTextBuilder_.mergeFrom(value);
            }
            if (this.anchorDisplayText_ != null) {
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            return this;
        }

        public Builder clearAnchorDisplayText() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.anchorDisplayText_ = null;
            if (this.anchorDisplayTextBuilder_ != null) {
                this.anchorDisplayTextBuilder_.dispose();
                this.anchorDisplayTextBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Text.Builder getAnchorDisplayTextBuilder() {
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this.getAnchorDisplayTextFieldBuilder().getBuilder();
        }

        @Override
        public TextOrBuilder getAnchorDisplayTextOrBuilder() {
            if (this.anchorDisplayTextBuilder_ != null) {
                return this.anchorDisplayTextBuilder_.getMessageOrBuilder();
            }
            return this.anchorDisplayText_ == null ? Text.getDefaultInstance() : this.anchorDisplayText_;
        }

        private SingleFieldBuilderV3<Text, Text.Builder, TextOrBuilder> getAnchorDisplayTextFieldBuilder() {
            if (this.anchorDisplayTextBuilder_ == null) {
                this.anchorDisplayTextBuilder_ = new SingleFieldBuilderV3(this.getAnchorDisplayText(), this.getParentForChildren(), this.isClean());
                this.anchorDisplayText_ = null;
            }
            return this.anchorDisplayTextBuilder_;
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


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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommon;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.SocialMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public final class SocialMessage
extends GeneratedMessageV3
implements SocialMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int USER_FIELD_NUMBER = 2;
    private User user_;
    public static final int SHARETYPE_FIELD_NUMBER = 3;
    private long shareType_ = 0L;
    public static final int ACTION_FIELD_NUMBER = 4;
    private long action_ = 0L;
    public static final int SHARETARGET_FIELD_NUMBER = 5;
    private volatile Object shareTarget_ = "";
    public static final int FOLLOWCOUNT_FIELD_NUMBER = 6;
    private long followCount_ = 0L;
    public static final int PUBLICAREACOMMON_FIELD_NUMBER = 7;
    private PublicAreaCommon publicAreaCommon_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final SocialMessage DEFAULT_INSTANCE = new SocialMessage();
    private static final Parser<SocialMessage> PARSER = new AbstractParser<SocialMessage>(){

        @Override
        public SocialMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = SocialMessage.newBuilder();
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

    private SocialMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private SocialMessage() {
        this.shareTarget_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new SocialMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_SocialMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_SocialMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialMessage.class, Builder.class);
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
    public long getShareType() {
        return this.shareType_;
    }

    @Override
    public long getAction() {
        return this.action_;
    }

    @Override
    public String getShareTarget() {
        Object ref = this.shareTarget_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.shareTarget_ = s;
        return s;
    }

    @Override
    public ByteString getShareTargetBytes() {
        Object ref = this.shareTarget_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.shareTarget_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getFollowCount() {
        return this.followCount_;
    }

    @Override
    public boolean hasPublicAreaCommon() {
        return (this.bitField0_ & 4) != 0;
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
        if (this.shareType_ != 0L) {
            output.writeUInt64(3, this.shareType_);
        }
        if (this.action_ != 0L) {
            output.writeUInt64(4, this.action_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.shareTarget_)) {
            GeneratedMessageV3.writeString(output, 5, this.shareTarget_);
        }
        if (this.followCount_ != 0L) {
            output.writeUInt64(6, this.followCount_);
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(7, this.getPublicAreaCommon());
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
        if (this.shareType_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.shareType_);
        }
        if (this.action_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(4, this.action_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.shareTarget_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.shareTarget_);
        }
        if (this.followCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(6, this.followCount_);
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getPublicAreaCommon());
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SocialMessage)) {
            return super.equals(obj);
        }
        SocialMessage other = (SocialMessage)obj;
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
        if (this.getShareType() != other.getShareType()) {
            return false;
        }
        if (this.getAction() != other.getAction()) {
            return false;
        }
        if (!this.getShareTarget().equals((Object)other.getShareTarget())) {
            return false;
        }
        if (this.getFollowCount() != other.getFollowCount()) {
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
        hash = 19 * hash + SocialMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        if (this.hasUser()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUser().hashCode();
        }
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getShareType());
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getAction());
        hash = 37 * hash + 5;
        hash = 53 * hash + this.getShareTarget().hashCode();
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashLong(this.getFollowCount());
        if (this.hasPublicAreaCommon()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getPublicAreaCommon().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static SocialMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static SocialMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static SocialMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static SocialMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static SocialMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static SocialMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static SocialMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static SocialMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static SocialMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static SocialMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static SocialMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static SocialMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return SocialMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SocialMessage prototype) {
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

    public static SocialMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SocialMessage> parser() {
        return PARSER;
    }

    public Parser<SocialMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public SocialMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements SocialMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private User user_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userBuilder_;
        private long shareType_;
        private long action_;
        private Object shareTarget_ = "";
        private long followCount_;
        private PublicAreaCommon publicAreaCommon_;
        private SingleFieldBuilderV3<PublicAreaCommon, PublicAreaCommon.Builder, PublicAreaCommonOrBuilder> publicAreaCommonBuilder_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_SocialMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_SocialMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialMessage.class, Builder.class);
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
            this.shareType_ = 0L;
            this.action_ = 0L;
            this.shareTarget_ = "";
            this.followCount_ = 0L;
            this.publicAreaCommon_ = null;
            if (this.publicAreaCommonBuilder_ != null) {
                this.publicAreaCommonBuilder_.dispose();
                this.publicAreaCommonBuilder_ = null;
            }
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_SocialMessage_descriptor;
        }

        @Override
        public SocialMessage getDefaultInstanceForType() {
            return SocialMessage.getDefaultInstance();
        }

        @Override
        public SocialMessage build() {
            SocialMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public SocialMessage buildPartial() {
            SocialMessage result = new SocialMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(SocialMessage result) {
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
                result.shareType_ = this.shareType_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.action_ = this.action_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.shareTarget_ = this.shareTarget_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.followCount_ = this.followCount_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.publicAreaCommon_ = this.publicAreaCommonBuilder_ == null ? this.publicAreaCommon_ : this.publicAreaCommonBuilder_.build();
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
            if (other instanceof SocialMessage) {
                return this.mergeFrom((SocialMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(SocialMessage other) {
            if (other == SocialMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (other.hasUser()) {
                this.mergeUser(other.getUser());
            }
            if (other.getShareType() != 0L) {
                this.setShareType(other.getShareType());
            }
            if (other.getAction() != 0L) {
                this.setAction(other.getAction());
            }
            if (!other.getShareTarget().isEmpty()) {
                this.shareTarget_ = other.shareTarget_;
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            if (other.getFollowCount() != 0L) {
                this.setFollowCount(other.getFollowCount());
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
                block15: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block15;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block15;
                        }
                        case 18: {
                            input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 2;
                            continue block15;
                        }
                        case 24: {
                            this.shareType_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block15;
                        }
                        case 32: {
                            this.action_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block15;
                        }
                        case 42: {
                            this.shareTarget_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x10;
                            continue block15;
                        }
                        case 48: {
                            this.followCount_ = input.readUInt64();
                            this.bitField0_ |= 0x20;
                            continue block15;
                        }
                        case 58: {
                            input.readMessage(this.getPublicAreaCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x40;
                            continue block15;
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
        public long getShareType() {
            return this.shareType_;
        }

        public Builder setShareType(long value) {
            this.shareType_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearShareType() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.shareType_ = 0L;
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
        public String getShareTarget() {
            Object ref = this.shareTarget_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.shareTarget_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getShareTargetBytes() {
            Object ref = this.shareTarget_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.shareTarget_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setShareTarget(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.shareTarget_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearShareTarget() {
            this.shareTarget_ = SocialMessage.getDefaultInstance().getShareTarget();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        public Builder setShareTargetBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            SocialMessage.checkByteStringIsUtf8(value);
            this.shareTarget_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        @Override
        public long getFollowCount() {
            return this.followCount_;
        }

        public Builder setFollowCount(long value) {
            this.followCount_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearFollowCount() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.followCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasPublicAreaCommon() {
            return (this.bitField0_ & 0x40) != 0;
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
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder setPublicAreaCommon(PublicAreaCommon.Builder builderForValue) {
            if (this.publicAreaCommonBuilder_ == null) {
                this.publicAreaCommon_ = builderForValue.build();
            } else {
                this.publicAreaCommonBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder mergePublicAreaCommon(PublicAreaCommon value) {
            if (this.publicAreaCommonBuilder_ == null) {
                if ((this.bitField0_ & 0x40) != 0 && this.publicAreaCommon_ != null && this.publicAreaCommon_ != PublicAreaCommon.getDefaultInstance()) {
                    this.getPublicAreaCommonBuilder().mergeFrom(value);
                } else {
                    this.publicAreaCommon_ = value;
                }
            } else {
                this.publicAreaCommonBuilder_.mergeFrom(value);
            }
            if (this.publicAreaCommon_ != null) {
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            return this;
        }

        public Builder clearPublicAreaCommon() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.publicAreaCommon_ = null;
            if (this.publicAreaCommonBuilder_ != null) {
                this.publicAreaCommonBuilder_.dispose();
                this.publicAreaCommonBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public PublicAreaCommon.Builder getPublicAreaCommonBuilder() {
            this.bitField0_ |= 0x40;
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


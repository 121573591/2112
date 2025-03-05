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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomUserSeqMessageContributorOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public final class RoomUserSeqMessageContributor
extends GeneratedMessageV3
implements RoomUserSeqMessageContributorOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int SCORE_FIELD_NUMBER = 1;
    private long score_ = 0L;
    public static final int USER_FIELD_NUMBER = 2;
    private User user_;
    public static final int RANK_FIELD_NUMBER = 3;
    private long rank_ = 0L;
    public static final int DELTA_FIELD_NUMBER = 4;
    private long delta_ = 0L;
    public static final int ISHIDDEN_FIELD_NUMBER = 5;
    private boolean isHidden_ = false;
    public static final int SCOREDESCRIPTION_FIELD_NUMBER = 6;
    private volatile Object scoreDescription_ = "";
    public static final int EXACTLYSCORE_FIELD_NUMBER = 7;
    private volatile Object exactlyScore_ = "";
    private byte memoizedIsInitialized = (byte)-1;
    private static final RoomUserSeqMessageContributor DEFAULT_INSTANCE = new RoomUserSeqMessageContributor();
    private static final Parser<RoomUserSeqMessageContributor> PARSER = new AbstractParser<RoomUserSeqMessageContributor>(){

        @Override
        public RoomUserSeqMessageContributor parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = RoomUserSeqMessageContributor.newBuilder();
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

    private RoomUserSeqMessageContributor(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RoomUserSeqMessageContributor() {
        this.scoreDescription_ = "";
        this.exactlyScore_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new RoomUserSeqMessageContributor();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_RoomUserSeqMessageContributor_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_RoomUserSeqMessageContributor_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomUserSeqMessageContributor.class, Builder.class);
    }

    @Override
    public long getScore() {
        return this.score_;
    }

    @Override
    public boolean hasUser() {
        return (this.bitField0_ & 1) != 0;
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
    public long getRank() {
        return this.rank_;
    }

    @Override
    public long getDelta() {
        return this.delta_;
    }

    @Override
    public boolean getIsHidden() {
        return this.isHidden_;
    }

    @Override
    public String getScoreDescription() {
        Object ref = this.scoreDescription_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.scoreDescription_ = s;
        return s;
    }

    @Override
    public ByteString getScoreDescriptionBytes() {
        Object ref = this.scoreDescription_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.scoreDescription_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getExactlyScore() {
        Object ref = this.exactlyScore_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.exactlyScore_ = s;
        return s;
    }

    @Override
    public ByteString getExactlyScoreBytes() {
        Object ref = this.exactlyScore_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.exactlyScore_ = b;
            return b;
        }
        return (ByteString)ref;
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
        if (this.score_ != 0L) {
            output.writeUInt64(1, this.score_);
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(2, this.getUser());
        }
        if (this.rank_ != 0L) {
            output.writeUInt64(3, this.rank_);
        }
        if (this.delta_ != 0L) {
            output.writeUInt64(4, this.delta_);
        }
        if (this.isHidden_) {
            output.writeBool(5, this.isHidden_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.scoreDescription_)) {
            GeneratedMessageV3.writeString(output, 6, this.scoreDescription_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.exactlyScore_)) {
            GeneratedMessageV3.writeString(output, 7, this.exactlyScore_);
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
        if (this.score_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(1, this.score_);
        }
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getUser());
        }
        if (this.rank_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.rank_);
        }
        if (this.delta_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(4, this.delta_);
        }
        if (this.isHidden_) {
            size += CodedOutputStream.computeBoolSize(5, this.isHidden_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.scoreDescription_)) {
            size += GeneratedMessageV3.computeStringSize(6, this.scoreDescription_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.exactlyScore_)) {
            size += GeneratedMessageV3.computeStringSize(7, this.exactlyScore_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoomUserSeqMessageContributor)) {
            return super.equals(obj);
        }
        RoomUserSeqMessageContributor other = (RoomUserSeqMessageContributor)obj;
        if (this.getScore() != other.getScore()) {
            return false;
        }
        if (this.hasUser() != other.hasUser()) {
            return false;
        }
        if (this.hasUser() && !this.getUser().equals(other.getUser())) {
            return false;
        }
        if (this.getRank() != other.getRank()) {
            return false;
        }
        if (this.getDelta() != other.getDelta()) {
            return false;
        }
        if (this.getIsHidden() != other.getIsHidden()) {
            return false;
        }
        if (!this.getScoreDescription().equals((Object)other.getScoreDescription())) {
            return false;
        }
        if (!this.getExactlyScore().equals((Object)other.getExactlyScore())) {
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
        hash = 19 * hash + RoomUserSeqMessageContributor.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + Internal.hashLong(this.getScore());
        if (this.hasUser()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUser().hashCode();
        }
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getRank());
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getDelta());
        hash = 37 * hash + 5;
        hash = 53 * hash + Internal.hashBoolean(this.getIsHidden());
        hash = 37 * hash + 6;
        hash = 53 * hash + this.getScoreDescription().hashCode();
        hash = 37 * hash + 7;
        hash = 53 * hash + this.getExactlyScore().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static RoomUserSeqMessageContributor parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomUserSeqMessageContributor parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomUserSeqMessageContributor parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomUserSeqMessageContributor parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomUserSeqMessageContributor parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomUserSeqMessageContributor parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomUserSeqMessageContributor parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomUserSeqMessageContributor parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomUserSeqMessageContributor parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static RoomUserSeqMessageContributor parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomUserSeqMessageContributor parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomUserSeqMessageContributor parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return RoomUserSeqMessageContributor.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RoomUserSeqMessageContributor prototype) {
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

    public static RoomUserSeqMessageContributor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RoomUserSeqMessageContributor> parser() {
        return PARSER;
    }

    public Parser<RoomUserSeqMessageContributor> getParserForType() {
        return PARSER;
    }

    @Override
    public RoomUserSeqMessageContributor getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements RoomUserSeqMessageContributorOrBuilder {
        private int bitField0_;
        private long score_;
        private User user_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userBuilder_;
        private long rank_;
        private long delta_;
        private boolean isHidden_;
        private Object scoreDescription_ = "";
        private Object exactlyScore_ = "";

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_RoomUserSeqMessageContributor_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_RoomUserSeqMessageContributor_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomUserSeqMessageContributor.class, Builder.class);
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
                this.getUserFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.score_ = 0L;
            this.user_ = null;
            if (this.userBuilder_ != null) {
                this.userBuilder_.dispose();
                this.userBuilder_ = null;
            }
            this.rank_ = 0L;
            this.delta_ = 0L;
            this.isHidden_ = false;
            this.scoreDescription_ = "";
            this.exactlyScore_ = "";
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_RoomUserSeqMessageContributor_descriptor;
        }

        @Override
        public RoomUserSeqMessageContributor getDefaultInstanceForType() {
            return RoomUserSeqMessageContributor.getDefaultInstance();
        }

        @Override
        public RoomUserSeqMessageContributor build() {
            RoomUserSeqMessageContributor result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RoomUserSeqMessageContributor buildPartial() {
            RoomUserSeqMessageContributor result = new RoomUserSeqMessageContributor(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(RoomUserSeqMessageContributor result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.score_ = this.score_;
            }
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 2) != 0) {
                result.user_ = this.userBuilder_ == null ? this.user_ : this.userBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.rank_ = this.rank_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.delta_ = this.delta_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.isHidden_ = this.isHidden_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.scoreDescription_ = this.scoreDescription_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.exactlyScore_ = this.exactlyScore_;
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
            if (other instanceof RoomUserSeqMessageContributor) {
                return this.mergeFrom((RoomUserSeqMessageContributor)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(RoomUserSeqMessageContributor other) {
            if (other == RoomUserSeqMessageContributor.getDefaultInstance()) {
                return this;
            }
            if (other.getScore() != 0L) {
                this.setScore(other.getScore());
            }
            if (other.hasUser()) {
                this.mergeUser(other.getUser());
            }
            if (other.getRank() != 0L) {
                this.setRank(other.getRank());
            }
            if (other.getDelta() != 0L) {
                this.setDelta(other.getDelta());
            }
            if (other.getIsHidden()) {
                this.setIsHidden(other.getIsHidden());
            }
            if (!other.getScoreDescription().isEmpty()) {
                this.scoreDescription_ = other.scoreDescription_;
                this.bitField0_ |= 0x20;
                this.onChanged();
            }
            if (!other.getExactlyScore().isEmpty()) {
                this.exactlyScore_ = other.exactlyScore_;
                this.bitField0_ |= 0x40;
                this.onChanged();
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
                        case 8: {
                            this.score_ = input.readUInt64();
                            this.bitField0_ |= 1;
                            continue block15;
                        }
                        case 18: {
                            input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 2;
                            continue block15;
                        }
                        case 24: {
                            this.rank_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block15;
                        }
                        case 32: {
                            this.delta_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block15;
                        }
                        case 40: {
                            this.isHidden_ = input.readBool();
                            this.bitField0_ |= 0x10;
                            continue block15;
                        }
                        case 50: {
                            this.scoreDescription_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x20;
                            continue block15;
                        }
                        case 58: {
                            this.exactlyScore_ = input.readStringRequireUtf8();
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
        public long getScore() {
            return this.score_;
        }

        public Builder setScore(long value) {
            this.score_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearScore() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.score_ = 0L;
            this.onChanged();
            return this;
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
        public long getRank() {
            return this.rank_;
        }

        public Builder setRank(long value) {
            this.rank_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearRank() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.rank_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getDelta() {
            return this.delta_;
        }

        public Builder setDelta(long value) {
            this.delta_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearDelta() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.delta_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getIsHidden() {
            return this.isHidden_;
        }

        public Builder setIsHidden(boolean value) {
            this.isHidden_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearIsHidden() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.isHidden_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public String getScoreDescription() {
            Object ref = this.scoreDescription_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.scoreDescription_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getScoreDescriptionBytes() {
            Object ref = this.scoreDescription_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.scoreDescription_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setScoreDescription(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.scoreDescription_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearScoreDescription() {
            this.scoreDescription_ = RoomUserSeqMessageContributor.getDefaultInstance().getScoreDescription();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
            return this;
        }

        public Builder setScoreDescriptionBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomUserSeqMessageContributor.checkByteStringIsUtf8(value);
            this.scoreDescription_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        @Override
        public String getExactlyScore() {
            Object ref = this.exactlyScore_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.exactlyScore_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getExactlyScoreBytes() {
            Object ref = this.exactlyScore_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.exactlyScore_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setExactlyScore(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.exactlyScore_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearExactlyScore() {
            this.exactlyScore_ = RoomUserSeqMessageContributor.getDefaultInstance().getExactlyScore();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
            return this;
        }

        public Builder setExactlyScoreBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomUserSeqMessageContributor.checkByteStringIsUtf8(value);
            this.exactlyScore_ = value;
            this.bitField0_ |= 0x40;
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


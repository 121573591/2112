/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.Collection
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.AbstractMessageLite;
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
import java.util.Collection;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.FansClubDataOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserBadge;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserBadgeOrBuilder;

public final class FansClubData
extends GeneratedMessageV3
implements FansClubDataOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int CLUBNAME_FIELD_NUMBER = 1;
    private volatile Object clubName_ = "";
    public static final int LEVEL_FIELD_NUMBER = 2;
    private int level_ = 0;
    public static final int USERFANSCLUBSTATUS_FIELD_NUMBER = 3;
    private int userFansClubStatus_ = 0;
    public static final int BADGE_FIELD_NUMBER = 4;
    private UserBadge badge_;
    public static final int AVAILABLEGIFTIDS_FIELD_NUMBER = 5;
    private Internal.LongList availableGiftIds_ = FansClubData.emptyLongList();
    private int availableGiftIdsMemoizedSerializedSize = -1;
    public static final int ANCHORID_FIELD_NUMBER = 6;
    private long anchorId_ = 0L;
    private byte memoizedIsInitialized = (byte)-1;
    private static final FansClubData DEFAULT_INSTANCE = new FansClubData();
    private static final Parser<FansClubData> PARSER = new AbstractParser<FansClubData>(){

        @Override
        public FansClubData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = FansClubData.newBuilder();
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

    private FansClubData(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private FansClubData() {
        this.clubName_ = "";
        this.availableGiftIds_ = FansClubData.emptyLongList();
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new FansClubData();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_FansClubData_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_FansClubData_fieldAccessorTable.ensureFieldAccessorsInitialized(FansClubData.class, Builder.class);
    }

    @Override
    public String getClubName() {
        Object ref = this.clubName_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.clubName_ = s;
        return s;
    }

    @Override
    public ByteString getClubNameBytes() {
        Object ref = this.clubName_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.clubName_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public int getLevel() {
        return this.level_;
    }

    @Override
    public int getUserFansClubStatus() {
        return this.userFansClubStatus_;
    }

    @Override
    public boolean hasBadge() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public UserBadge getBadge() {
        return this.badge_ == null ? UserBadge.getDefaultInstance() : this.badge_;
    }

    @Override
    public UserBadgeOrBuilder getBadgeOrBuilder() {
        return this.badge_ == null ? UserBadge.getDefaultInstance() : this.badge_;
    }

    @Override
    public List<Long> getAvailableGiftIdsList() {
        return this.availableGiftIds_;
    }

    @Override
    public int getAvailableGiftIdsCount() {
        return this.availableGiftIds_.size();
    }

    @Override
    public long getAvailableGiftIds(int index) {
        return this.availableGiftIds_.getLong(index);
    }

    @Override
    public long getAnchorId() {
        return this.anchorId_;
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
        this.getSerializedSize();
        if (!GeneratedMessageV3.isStringEmpty(this.clubName_)) {
            GeneratedMessageV3.writeString(output, 1, this.clubName_);
        }
        if (this.level_ != 0) {
            output.writeInt32(2, this.level_);
        }
        if (this.userFansClubStatus_ != 0) {
            output.writeInt32(3, this.userFansClubStatus_);
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(4, this.getBadge());
        }
        if (this.getAvailableGiftIdsList().size() > 0) {
            output.writeUInt32NoTag(42);
            output.writeUInt32NoTag(this.availableGiftIdsMemoizedSerializedSize);
        }
        for (int i = 0; i < this.availableGiftIds_.size(); ++i) {
            output.writeInt64NoTag(this.availableGiftIds_.getLong(i));
        }
        if (this.anchorId_ != 0L) {
            output.writeInt64(6, this.anchorId_);
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
        if (!GeneratedMessageV3.isStringEmpty(this.clubName_)) {
            size += GeneratedMessageV3.computeStringSize(1, this.clubName_);
        }
        if (this.level_ != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.level_);
        }
        if (this.userFansClubStatus_ != 0) {
            size += CodedOutputStream.computeInt32Size(3, this.userFansClubStatus_);
        }
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(4, this.getBadge());
        }
        int dataSize = 0;
        for (int i = 0; i < this.availableGiftIds_.size(); ++i) {
            dataSize += CodedOutputStream.computeInt64SizeNoTag(this.availableGiftIds_.getLong(i));
        }
        size += dataSize;
        if (!this.getAvailableGiftIdsList().isEmpty()) {
            ++size;
            size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        this.availableGiftIdsMemoizedSerializedSize = dataSize;
        if (this.anchorId_ != 0L) {
            size += CodedOutputStream.computeInt64Size(6, this.anchorId_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FansClubData)) {
            return super.equals(obj);
        }
        FansClubData other = (FansClubData)obj;
        if (!this.getClubName().equals((Object)other.getClubName())) {
            return false;
        }
        if (this.getLevel() != other.getLevel()) {
            return false;
        }
        if (this.getUserFansClubStatus() != other.getUserFansClubStatus()) {
            return false;
        }
        if (this.hasBadge() != other.hasBadge()) {
            return false;
        }
        if (this.hasBadge() && !this.getBadge().equals(other.getBadge())) {
            return false;
        }
        if (!this.getAvailableGiftIdsList().equals(other.getAvailableGiftIdsList())) {
            return false;
        }
        if (this.getAnchorId() != other.getAnchorId()) {
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
        hash = 19 * hash + FansClubData.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + this.getClubName().hashCode();
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getLevel();
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getUserFansClubStatus();
        if (this.hasBadge()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getBadge().hashCode();
        }
        if (this.getAvailableGiftIdsCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getAvailableGiftIdsList().hashCode();
        }
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashLong(this.getAnchorId());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static FansClubData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FansClubData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FansClubData parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FansClubData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FansClubData parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FansClubData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FansClubData parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FansClubData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static FansClubData parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static FansClubData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static FansClubData parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FansClubData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return FansClubData.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FansClubData prototype) {
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

    public static FansClubData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FansClubData> parser() {
        return PARSER;
    }

    public Parser<FansClubData> getParserForType() {
        return PARSER;
    }

    @Override
    public FansClubData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ Internal.LongList access$1300() {
        return FansClubData.emptyLongList();
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements FansClubDataOrBuilder {
        private int bitField0_;
        private Object clubName_ = "";
        private int level_;
        private int userFansClubStatus_;
        private UserBadge badge_;
        private SingleFieldBuilderV3<UserBadge, UserBadge.Builder, UserBadgeOrBuilder> badgeBuilder_;
        private Internal.LongList availableGiftIds_ = FansClubData.access$1300();
        private long anchorId_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_FansClubData_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_FansClubData_fieldAccessorTable.ensureFieldAccessorsInitialized(FansClubData.class, Builder.class);
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
                this.getBadgeFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.clubName_ = "";
            this.level_ = 0;
            this.userFansClubStatus_ = 0;
            this.badge_ = null;
            if (this.badgeBuilder_ != null) {
                this.badgeBuilder_.dispose();
                this.badgeBuilder_ = null;
            }
            this.availableGiftIds_ = FansClubData.emptyLongList();
            this.anchorId_ = 0L;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_FansClubData_descriptor;
        }

        @Override
        public FansClubData getDefaultInstanceForType() {
            return FansClubData.getDefaultInstance();
        }

        @Override
        public FansClubData build() {
            FansClubData result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public FansClubData buildPartial() {
            FansClubData result = new FansClubData(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(FansClubData result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.clubName_ = this.clubName_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.level_ = this.level_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.userFansClubStatus_ = this.userFansClubStatus_;
            }
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 8) != 0) {
                result.badge_ = this.badgeBuilder_ == null ? this.badge_ : this.badgeBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                this.availableGiftIds_.makeImmutable();
                result.availableGiftIds_ = this.availableGiftIds_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.anchorId_ = this.anchorId_;
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
            if (other instanceof FansClubData) {
                return this.mergeFrom((FansClubData)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(FansClubData other) {
            if (other == FansClubData.getDefaultInstance()) {
                return this;
            }
            if (!other.getClubName().isEmpty()) {
                this.clubName_ = other.clubName_;
                this.bitField0_ |= 1;
                this.onChanged();
            }
            if (other.getLevel() != 0) {
                this.setLevel(other.getLevel());
            }
            if (other.getUserFansClubStatus() != 0) {
                this.setUserFansClubStatus(other.getUserFansClubStatus());
            }
            if (other.hasBadge()) {
                this.mergeBadge(other.getBadge());
            }
            if (!other.availableGiftIds_.isEmpty()) {
                if (this.availableGiftIds_.isEmpty()) {
                    this.availableGiftIds_ = other.availableGiftIds_;
                    this.availableGiftIds_.makeImmutable();
                    this.bitField0_ |= 0x10;
                } else {
                    this.ensureAvailableGiftIdsIsMutable();
                    this.availableGiftIds_.addAll((Collection)other.availableGiftIds_);
                }
                this.onChanged();
            }
            if (other.getAnchorId() != 0L) {
                this.setAnchorId(other.getAnchorId());
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
                            this.clubName_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 1;
                            continue block15;
                        }
                        case 16: {
                            this.level_ = input.readInt32();
                            this.bitField0_ |= 2;
                            continue block15;
                        }
                        case 24: {
                            this.userFansClubStatus_ = input.readInt32();
                            this.bitField0_ |= 4;
                            continue block15;
                        }
                        case 34: {
                            input.readMessage(this.getBadgeFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 8;
                            continue block15;
                        }
                        case 40: {
                            long v = input.readInt64();
                            this.ensureAvailableGiftIdsIsMutable();
                            this.availableGiftIds_.addLong(v);
                            continue block15;
                        }
                        case 42: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            this.ensureAvailableGiftIdsIsMutable();
                            while (input.getBytesUntilLimit() > 0) {
                                this.availableGiftIds_.addLong(input.readInt64());
                            }
                            input.popLimit(limit);
                            continue block15;
                        }
                        case 48: {
                            this.anchorId_ = input.readInt64();
                            this.bitField0_ |= 0x20;
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
        public String getClubName() {
            Object ref = this.clubName_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.clubName_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getClubNameBytes() {
            Object ref = this.clubName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.clubName_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setClubName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.clubName_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearClubName() {
            this.clubName_ = FansClubData.getDefaultInstance().getClubName();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
            return this;
        }

        public Builder setClubNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            FansClubData.checkByteStringIsUtf8(value);
            this.clubName_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        @Override
        public int getLevel() {
            return this.level_;
        }

        public Builder setLevel(int value) {
            this.level_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearLevel() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.level_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public int getUserFansClubStatus() {
            return this.userFansClubStatus_;
        }

        public Builder setUserFansClubStatus(int value) {
            this.userFansClubStatus_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearUserFansClubStatus() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.userFansClubStatus_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasBadge() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override
        public UserBadge getBadge() {
            if (this.badgeBuilder_ == null) {
                return this.badge_ == null ? UserBadge.getDefaultInstance() : this.badge_;
            }
            return this.badgeBuilder_.getMessage();
        }

        public Builder setBadge(UserBadge value) {
            if (this.badgeBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.badge_ = value;
            } else {
                this.badgeBuilder_.setMessage(value);
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder setBadge(UserBadge.Builder builderForValue) {
            if (this.badgeBuilder_ == null) {
                this.badge_ = builderForValue.build();
            } else {
                this.badgeBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder mergeBadge(UserBadge value) {
            if (this.badgeBuilder_ == null) {
                if ((this.bitField0_ & 8) != 0 && this.badge_ != null && this.badge_ != UserBadge.getDefaultInstance()) {
                    this.getBadgeBuilder().mergeFrom(value);
                } else {
                    this.badge_ = value;
                }
            } else {
                this.badgeBuilder_.mergeFrom(value);
            }
            if (this.badge_ != null) {
                this.bitField0_ |= 8;
                this.onChanged();
            }
            return this;
        }

        public Builder clearBadge() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.badge_ = null;
            if (this.badgeBuilder_ != null) {
                this.badgeBuilder_.dispose();
                this.badgeBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public UserBadge.Builder getBadgeBuilder() {
            this.bitField0_ |= 8;
            this.onChanged();
            return this.getBadgeFieldBuilder().getBuilder();
        }

        @Override
        public UserBadgeOrBuilder getBadgeOrBuilder() {
            if (this.badgeBuilder_ != null) {
                return this.badgeBuilder_.getMessageOrBuilder();
            }
            return this.badge_ == null ? UserBadge.getDefaultInstance() : this.badge_;
        }

        private SingleFieldBuilderV3<UserBadge, UserBadge.Builder, UserBadgeOrBuilder> getBadgeFieldBuilder() {
            if (this.badgeBuilder_ == null) {
                this.badgeBuilder_ = new SingleFieldBuilderV3(this.getBadge(), this.getParentForChildren(), this.isClean());
                this.badge_ = null;
            }
            return this.badgeBuilder_;
        }

        private void ensureAvailableGiftIdsIsMutable() {
            if (!this.availableGiftIds_.isModifiable()) {
                this.availableGiftIds_ = (Internal.LongList)FansClubData.makeMutableCopy(this.availableGiftIds_);
            }
            this.bitField0_ |= 0x10;
        }

        @Override
        public List<Long> getAvailableGiftIdsList() {
            this.availableGiftIds_.makeImmutable();
            return this.availableGiftIds_;
        }

        @Override
        public int getAvailableGiftIdsCount() {
            return this.availableGiftIds_.size();
        }

        @Override
        public long getAvailableGiftIds(int index) {
            return this.availableGiftIds_.getLong(index);
        }

        public Builder setAvailableGiftIds(int index, long value) {
            this.ensureAvailableGiftIdsIsMutable();
            this.availableGiftIds_.setLong(index, value);
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder addAvailableGiftIds(long value) {
            this.ensureAvailableGiftIdsIsMutable();
            this.availableGiftIds_.addLong(value);
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder addAllAvailableGiftIds(Iterable<? extends Long> values) {
            this.ensureAvailableGiftIdsIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.availableGiftIds_);
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearAvailableGiftIds() {
            this.availableGiftIds_ = FansClubData.emptyLongList();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        @Override
        public long getAnchorId() {
            return this.anchorId_;
        }

        public Builder setAnchorId(long value) {
            this.anchorId_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearAnchorId() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.anchorId_ = 0L;
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


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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomStatsMessageOrBuilder;

public final class RoomStatsMessage
extends GeneratedMessageV3
implements RoomStatsMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int DISPLAYSHORT_FIELD_NUMBER = 2;
    private volatile Object displayShort_ = "";
    public static final int DISPLAYMIDDLE_FIELD_NUMBER = 3;
    private volatile Object displayMiddle_ = "";
    public static final int DISPLAYLONG_FIELD_NUMBER = 4;
    private volatile Object displayLong_ = "";
    public static final int DISPLAYVALUE_FIELD_NUMBER = 5;
    private long displayValue_ = 0L;
    public static final int DISPLAYVERSION_FIELD_NUMBER = 6;
    private long displayVersion_ = 0L;
    public static final int INCREMENTAL_FIELD_NUMBER = 7;
    private boolean incremental_ = false;
    public static final int ISHIDDEN_FIELD_NUMBER = 8;
    private boolean isHidden_ = false;
    public static final int TOTAL_FIELD_NUMBER = 9;
    private long total_ = 0L;
    public static final int DISPLAYTYPE_FIELD_NUMBER = 10;
    private long displayType_ = 0L;
    private byte memoizedIsInitialized = (byte)-1;
    private static final RoomStatsMessage DEFAULT_INSTANCE = new RoomStatsMessage();
    private static final Parser<RoomStatsMessage> PARSER = new AbstractParser<RoomStatsMessage>(){

        @Override
        public RoomStatsMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = RoomStatsMessage.newBuilder();
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

    private RoomStatsMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RoomStatsMessage() {
        this.displayShort_ = "";
        this.displayMiddle_ = "";
        this.displayLong_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new RoomStatsMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_RoomStatsMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_RoomStatsMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomStatsMessage.class, Builder.class);
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
    public String getDisplayShort() {
        Object ref = this.displayShort_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.displayShort_ = s;
        return s;
    }

    @Override
    public ByteString getDisplayShortBytes() {
        Object ref = this.displayShort_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.displayShort_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getDisplayMiddle() {
        Object ref = this.displayMiddle_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.displayMiddle_ = s;
        return s;
    }

    @Override
    public ByteString getDisplayMiddleBytes() {
        Object ref = this.displayMiddle_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.displayMiddle_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getDisplayLong() {
        Object ref = this.displayLong_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.displayLong_ = s;
        return s;
    }

    @Override
    public ByteString getDisplayLongBytes() {
        Object ref = this.displayLong_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.displayLong_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getDisplayValue() {
        return this.displayValue_;
    }

    @Override
    public long getDisplayVersion() {
        return this.displayVersion_;
    }

    @Override
    public boolean getIncremental() {
        return this.incremental_;
    }

    @Override
    public boolean getIsHidden() {
        return this.isHidden_;
    }

    @Override
    public long getTotal() {
        return this.total_;
    }

    @Override
    public long getDisplayType() {
        return this.displayType_;
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
        if (!GeneratedMessageV3.isStringEmpty(this.displayShort_)) {
            GeneratedMessageV3.writeString(output, 2, this.displayShort_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayMiddle_)) {
            GeneratedMessageV3.writeString(output, 3, this.displayMiddle_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayLong_)) {
            GeneratedMessageV3.writeString(output, 4, this.displayLong_);
        }
        if (this.displayValue_ != 0L) {
            output.writeInt64(5, this.displayValue_);
        }
        if (this.displayVersion_ != 0L) {
            output.writeInt64(6, this.displayVersion_);
        }
        if (this.incremental_) {
            output.writeBool(7, this.incremental_);
        }
        if (this.isHidden_) {
            output.writeBool(8, this.isHidden_);
        }
        if (this.total_ != 0L) {
            output.writeInt64(9, this.total_);
        }
        if (this.displayType_ != 0L) {
            output.writeInt64(10, this.displayType_);
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
        if (!GeneratedMessageV3.isStringEmpty(this.displayShort_)) {
            size += GeneratedMessageV3.computeStringSize(2, this.displayShort_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayMiddle_)) {
            size += GeneratedMessageV3.computeStringSize(3, this.displayMiddle_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayLong_)) {
            size += GeneratedMessageV3.computeStringSize(4, this.displayLong_);
        }
        if (this.displayValue_ != 0L) {
            size += CodedOutputStream.computeInt64Size(5, this.displayValue_);
        }
        if (this.displayVersion_ != 0L) {
            size += CodedOutputStream.computeInt64Size(6, this.displayVersion_);
        }
        if (this.incremental_) {
            size += CodedOutputStream.computeBoolSize(7, this.incremental_);
        }
        if (this.isHidden_) {
            size += CodedOutputStream.computeBoolSize(8, this.isHidden_);
        }
        if (this.total_ != 0L) {
            size += CodedOutputStream.computeInt64Size(9, this.total_);
        }
        if (this.displayType_ != 0L) {
            size += CodedOutputStream.computeInt64Size(10, this.displayType_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoomStatsMessage)) {
            return super.equals(obj);
        }
        RoomStatsMessage other = (RoomStatsMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (!this.getDisplayShort().equals((Object)other.getDisplayShort())) {
            return false;
        }
        if (!this.getDisplayMiddle().equals((Object)other.getDisplayMiddle())) {
            return false;
        }
        if (!this.getDisplayLong().equals((Object)other.getDisplayLong())) {
            return false;
        }
        if (this.getDisplayValue() != other.getDisplayValue()) {
            return false;
        }
        if (this.getDisplayVersion() != other.getDisplayVersion()) {
            return false;
        }
        if (this.getIncremental() != other.getIncremental()) {
            return false;
        }
        if (this.getIsHidden() != other.getIsHidden()) {
            return false;
        }
        if (this.getTotal() != other.getTotal()) {
            return false;
        }
        if (this.getDisplayType() != other.getDisplayType()) {
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
        hash = 19 * hash + RoomStatsMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getDisplayShort().hashCode();
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getDisplayMiddle().hashCode();
        hash = 37 * hash + 4;
        hash = 53 * hash + this.getDisplayLong().hashCode();
        hash = 37 * hash + 5;
        hash = 53 * hash + Internal.hashLong(this.getDisplayValue());
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashLong(this.getDisplayVersion());
        hash = 37 * hash + 7;
        hash = 53 * hash + Internal.hashBoolean(this.getIncremental());
        hash = 37 * hash + 8;
        hash = 53 * hash + Internal.hashBoolean(this.getIsHidden());
        hash = 37 * hash + 9;
        hash = 53 * hash + Internal.hashLong(this.getTotal());
        hash = 37 * hash + 10;
        hash = 53 * hash + Internal.hashLong(this.getDisplayType());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static RoomStatsMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomStatsMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomStatsMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomStatsMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomStatsMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomStatsMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomStatsMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomStatsMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomStatsMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static RoomStatsMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomStatsMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomStatsMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return RoomStatsMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RoomStatsMessage prototype) {
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

    public static RoomStatsMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RoomStatsMessage> parser() {
        return PARSER;
    }

    public Parser<RoomStatsMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public RoomStatsMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements RoomStatsMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private Object displayShort_ = "";
        private Object displayMiddle_ = "";
        private Object displayLong_ = "";
        private long displayValue_;
        private long displayVersion_;
        private boolean incremental_;
        private boolean isHidden_;
        private long total_;
        private long displayType_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_RoomStatsMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_RoomStatsMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomStatsMessage.class, Builder.class);
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
            this.displayShort_ = "";
            this.displayMiddle_ = "";
            this.displayLong_ = "";
            this.displayValue_ = 0L;
            this.displayVersion_ = 0L;
            this.incremental_ = false;
            this.isHidden_ = false;
            this.total_ = 0L;
            this.displayType_ = 0L;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_RoomStatsMessage_descriptor;
        }

        @Override
        public RoomStatsMessage getDefaultInstanceForType() {
            return RoomStatsMessage.getDefaultInstance();
        }

        @Override
        public RoomStatsMessage build() {
            RoomStatsMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RoomStatsMessage buildPartial() {
            RoomStatsMessage result = new RoomStatsMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(RoomStatsMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.displayShort_ = this.displayShort_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.displayMiddle_ = this.displayMiddle_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.displayLong_ = this.displayLong_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.displayValue_ = this.displayValue_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.displayVersion_ = this.displayVersion_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.incremental_ = this.incremental_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.isHidden_ = this.isHidden_;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.total_ = this.total_;
            }
            if ((from_bitField0_ & 0x200) != 0) {
                result.displayType_ = this.displayType_;
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
            if (other instanceof RoomStatsMessage) {
                return this.mergeFrom((RoomStatsMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(RoomStatsMessage other) {
            if (other == RoomStatsMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (!other.getDisplayShort().isEmpty()) {
                this.displayShort_ = other.displayShort_;
                this.bitField0_ |= 2;
                this.onChanged();
            }
            if (!other.getDisplayMiddle().isEmpty()) {
                this.displayMiddle_ = other.displayMiddle_;
                this.bitField0_ |= 4;
                this.onChanged();
            }
            if (!other.getDisplayLong().isEmpty()) {
                this.displayLong_ = other.displayLong_;
                this.bitField0_ |= 8;
                this.onChanged();
            }
            if (other.getDisplayValue() != 0L) {
                this.setDisplayValue(other.getDisplayValue());
            }
            if (other.getDisplayVersion() != 0L) {
                this.setDisplayVersion(other.getDisplayVersion());
            }
            if (other.getIncremental()) {
                this.setIncremental(other.getIncremental());
            }
            if (other.getIsHidden()) {
                this.setIsHidden(other.getIsHidden());
            }
            if (other.getTotal() != 0L) {
                this.setTotal(other.getTotal());
            }
            if (other.getDisplayType() != 0L) {
                this.setDisplayType(other.getDisplayType());
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
                block18: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block18;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block18;
                        }
                        case 18: {
                            this.displayShort_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 2;
                            continue block18;
                        }
                        case 26: {
                            this.displayMiddle_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 4;
                            continue block18;
                        }
                        case 34: {
                            this.displayLong_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 8;
                            continue block18;
                        }
                        case 40: {
                            this.displayValue_ = input.readInt64();
                            this.bitField0_ |= 0x10;
                            continue block18;
                        }
                        case 48: {
                            this.displayVersion_ = input.readInt64();
                            this.bitField0_ |= 0x20;
                            continue block18;
                        }
                        case 56: {
                            this.incremental_ = input.readBool();
                            this.bitField0_ |= 0x40;
                            continue block18;
                        }
                        case 64: {
                            this.isHidden_ = input.readBool();
                            this.bitField0_ |= 0x80;
                            continue block18;
                        }
                        case 72: {
                            this.total_ = input.readInt64();
                            this.bitField0_ |= 0x100;
                            continue block18;
                        }
                        case 80: {
                            this.displayType_ = input.readInt64();
                            this.bitField0_ |= 0x200;
                            continue block18;
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
        public String getDisplayShort() {
            Object ref = this.displayShort_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.displayShort_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getDisplayShortBytes() {
            Object ref = this.displayShort_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.displayShort_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setDisplayShort(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.displayShort_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayShort() {
            this.displayShort_ = RoomStatsMessage.getDefaultInstance().getDisplayShort();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setDisplayShortBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomStatsMessage.checkByteStringIsUtf8(value);
            this.displayShort_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        @Override
        public String getDisplayMiddle() {
            Object ref = this.displayMiddle_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.displayMiddle_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getDisplayMiddleBytes() {
            Object ref = this.displayMiddle_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.displayMiddle_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setDisplayMiddle(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.displayMiddle_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayMiddle() {
            this.displayMiddle_ = RoomStatsMessage.getDefaultInstance().getDisplayMiddle();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
            return this;
        }

        public Builder setDisplayMiddleBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomStatsMessage.checkByteStringIsUtf8(value);
            this.displayMiddle_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        @Override
        public String getDisplayLong() {
            Object ref = this.displayLong_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.displayLong_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getDisplayLongBytes() {
            Object ref = this.displayLong_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.displayLong_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setDisplayLong(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.displayLong_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayLong() {
            this.displayLong_ = RoomStatsMessage.getDefaultInstance().getDisplayLong();
            this.bitField0_ &= 0xFFFFFFF7;
            this.onChanged();
            return this;
        }

        public Builder setDisplayLongBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomStatsMessage.checkByteStringIsUtf8(value);
            this.displayLong_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        @Override
        public long getDisplayValue() {
            return this.displayValue_;
        }

        public Builder setDisplayValue(long value) {
            this.displayValue_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayValue() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.displayValue_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getDisplayVersion() {
            return this.displayVersion_;
        }

        public Builder setDisplayVersion(long value) {
            this.displayVersion_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayVersion() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.displayVersion_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getIncremental() {
            return this.incremental_;
        }

        public Builder setIncremental(boolean value) {
            this.incremental_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearIncremental() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.incremental_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getIsHidden() {
            return this.isHidden_;
        }

        public Builder setIsHidden(boolean value) {
            this.isHidden_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearIsHidden() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.isHidden_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public long getTotal() {
            return this.total_;
        }

        public Builder setTotal(long value) {
            this.total_ = value;
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder clearTotal() {
            this.bitField0_ &= 0xFFFFFEFF;
            this.total_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getDisplayType() {
            return this.displayType_;
        }

        public Builder setDisplayType(long value) {
            this.displayType_ = value;
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayType() {
            this.bitField0_ &= 0xFFFFFDFF;
            this.displayType_ = 0L;
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


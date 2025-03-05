/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomRankMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public final class RoomRankMessage
extends GeneratedMessageV3
implements RoomRankMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int RANKSLIST_FIELD_NUMBER = 2;
    private List<RoomRank> ranksList_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final RoomRankMessage DEFAULT_INSTANCE = new RoomRankMessage();
    private static final Parser<RoomRankMessage> PARSER = new AbstractParser<RoomRankMessage>(){

        @Override
        public RoomRankMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = RoomRankMessage.newBuilder();
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

    private RoomRankMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RoomRankMessage() {
        this.ranksList_ = Collections.emptyList();
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new RoomRankMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_RoomRankMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_RoomRankMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomRankMessage.class, Builder.class);
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
    public List<RoomRank> getRanksListList() {
        return this.ranksList_;
    }

    @Override
    public List<? extends RoomRankOrBuilder> getRanksListOrBuilderList() {
        return this.ranksList_;
    }

    @Override
    public int getRanksListCount() {
        return this.ranksList_.size();
    }

    @Override
    public RoomRank getRanksList(int index) {
        return (RoomRank)this.ranksList_.get(index);
    }

    @Override
    public RoomRankOrBuilder getRanksListOrBuilder(int index) {
        return (RoomRankOrBuilder)this.ranksList_.get(index);
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
        for (int i = 0; i < this.ranksList_.size(); ++i) {
            output.writeMessage(2, (MessageLite)this.ranksList_.get(i));
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
        for (int i = 0; i < this.ranksList_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(2, (MessageLite)this.ranksList_.get(i));
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoomRankMessage)) {
            return super.equals(obj);
        }
        RoomRankMessage other = (RoomRankMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (!this.getRanksListList().equals(other.getRanksListList())) {
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
        hash = 19 * hash + RoomRankMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        if (this.getRanksListCount() > 0) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getRanksListList().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static RoomRankMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomRankMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomRankMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomRankMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomRankMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomRankMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomRankMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomRankMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomRankMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static RoomRankMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomRankMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomRankMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return RoomRankMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RoomRankMessage prototype) {
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

    public static RoomRankMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RoomRankMessage> parser() {
        return PARSER;
    }

    public Parser<RoomRankMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public RoomRankMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements RoomRankMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private List<RoomRank> ranksList_ = Collections.emptyList();
        private RepeatedFieldBuilderV3<RoomRank, RoomRank.Builder, RoomRankOrBuilder> ranksListBuilder_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_RoomRankMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_RoomRankMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomRankMessage.class, Builder.class);
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
                this.getRanksListFieldBuilder();
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
            if (this.ranksListBuilder_ == null) {
                this.ranksList_ = Collections.emptyList();
            } else {
                this.ranksList_ = null;
                this.ranksListBuilder_.clear();
            }
            this.bitField0_ &= 0xFFFFFFFD;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_RoomRankMessage_descriptor;
        }

        @Override
        public RoomRankMessage getDefaultInstanceForType() {
            return RoomRankMessage.getDefaultInstance();
        }

        @Override
        public RoomRankMessage build() {
            RoomRankMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RoomRankMessage buildPartial() {
            RoomRankMessage result = new RoomRankMessage(this);
            this.buildPartialRepeatedFields(result);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(RoomRankMessage result) {
            if (this.ranksListBuilder_ == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.ranksList_ = Collections.unmodifiableList(this.ranksList_);
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                result.ranksList_ = this.ranksList_;
            } else {
                result.ranksList_ = this.ranksListBuilder_.build();
            }
        }

        private void buildPartial0(RoomRankMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
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
            if (other instanceof RoomRankMessage) {
                return this.mergeFrom((RoomRankMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(RoomRankMessage other) {
            if (other == RoomRankMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (this.ranksListBuilder_ == null) {
                if (!other.ranksList_.isEmpty()) {
                    if (this.ranksList_.isEmpty()) {
                        this.ranksList_ = other.ranksList_;
                        this.bitField0_ &= 0xFFFFFFFD;
                    } else {
                        this.ensureRanksListIsMutable();
                        this.ranksList_.addAll((Collection)other.ranksList_);
                    }
                    this.onChanged();
                }
            } else if (!other.ranksList_.isEmpty()) {
                if (this.ranksListBuilder_.isEmpty()) {
                    this.ranksListBuilder_.dispose();
                    this.ranksListBuilder_ = null;
                    this.ranksList_ = other.ranksList_;
                    this.bitField0_ &= 0xFFFFFFFD;
                    this.ranksListBuilder_ = alwaysUseFieldBuilders ? this.getRanksListFieldBuilder() : null;
                } else {
                    this.ranksListBuilder_.addAllMessages((Iterable<RoomRank>)other.ranksList_);
                }
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
                block10: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block10;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block10;
                        }
                        case 18: {
                            RoomRank m = input.readMessage(RoomRank.parser(), extensionRegistry);
                            if (this.ranksListBuilder_ == null) {
                                this.ensureRanksListIsMutable();
                                this.ranksList_.add((Object)m);
                                continue block10;
                            }
                            this.ranksListBuilder_.addMessage(m);
                            continue block10;
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

        private void ensureRanksListIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.ranksList_ = new ArrayList(this.ranksList_);
                this.bitField0_ |= 2;
            }
        }

        @Override
        public List<RoomRank> getRanksListList() {
            if (this.ranksListBuilder_ == null) {
                return Collections.unmodifiableList(this.ranksList_);
            }
            return this.ranksListBuilder_.getMessageList();
        }

        @Override
        public int getRanksListCount() {
            if (this.ranksListBuilder_ == null) {
                return this.ranksList_.size();
            }
            return this.ranksListBuilder_.getCount();
        }

        @Override
        public RoomRank getRanksList(int index) {
            if (this.ranksListBuilder_ == null) {
                return (RoomRank)this.ranksList_.get(index);
            }
            return this.ranksListBuilder_.getMessage(index);
        }

        public Builder setRanksList(int index, RoomRank value) {
            if (this.ranksListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureRanksListIsMutable();
                this.ranksList_.set(index, (Object)value);
                this.onChanged();
            } else {
                this.ranksListBuilder_.setMessage(index, value);
            }
            return this;
        }

        public Builder setRanksList(int index, RoomRank.Builder builderForValue) {
            if (this.ranksListBuilder_ == null) {
                this.ensureRanksListIsMutable();
                this.ranksList_.set(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.ranksListBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addRanksList(RoomRank value) {
            if (this.ranksListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureRanksListIsMutable();
                this.ranksList_.add((Object)value);
                this.onChanged();
            } else {
                this.ranksListBuilder_.addMessage(value);
            }
            return this;
        }

        public Builder addRanksList(int index, RoomRank value) {
            if (this.ranksListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureRanksListIsMutable();
                this.ranksList_.add(index, (Object)value);
                this.onChanged();
            } else {
                this.ranksListBuilder_.addMessage(index, value);
            }
            return this;
        }

        public Builder addRanksList(RoomRank.Builder builderForValue) {
            if (this.ranksListBuilder_ == null) {
                this.ensureRanksListIsMutable();
                this.ranksList_.add((Object)builderForValue.build());
                this.onChanged();
            } else {
                this.ranksListBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addRanksList(int index, RoomRank.Builder builderForValue) {
            if (this.ranksListBuilder_ == null) {
                this.ensureRanksListIsMutable();
                this.ranksList_.add(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.ranksListBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllRanksList(Iterable<? extends RoomRank> values) {
            if (this.ranksListBuilder_ == null) {
                this.ensureRanksListIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.ranksList_);
                this.onChanged();
            } else {
                this.ranksListBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearRanksList() {
            if (this.ranksListBuilder_ == null) {
                this.ranksList_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
            } else {
                this.ranksListBuilder_.clear();
            }
            return this;
        }

        public Builder removeRanksList(int index) {
            if (this.ranksListBuilder_ == null) {
                this.ensureRanksListIsMutable();
                this.ranksList_.remove(index);
                this.onChanged();
            } else {
                this.ranksListBuilder_.remove(index);
            }
            return this;
        }

        public RoomRank.Builder getRanksListBuilder(int index) {
            return this.getRanksListFieldBuilder().getBuilder(index);
        }

        @Override
        public RoomRankOrBuilder getRanksListOrBuilder(int index) {
            if (this.ranksListBuilder_ == null) {
                return (RoomRankOrBuilder)this.ranksList_.get(index);
            }
            return this.ranksListBuilder_.getMessageOrBuilder(index);
        }

        @Override
        public List<? extends RoomRankOrBuilder> getRanksListOrBuilderList() {
            if (this.ranksListBuilder_ != null) {
                return this.ranksListBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.ranksList_);
        }

        public RoomRank.Builder addRanksListBuilder() {
            return this.getRanksListFieldBuilder().addBuilder(RoomRank.getDefaultInstance());
        }

        public RoomRank.Builder addRanksListBuilder(int index) {
            return this.getRanksListFieldBuilder().addBuilder(index, RoomRank.getDefaultInstance());
        }

        public List<RoomRank.Builder> getRanksListBuilderList() {
            return this.getRanksListFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<RoomRank, RoomRank.Builder, RoomRankOrBuilder> getRanksListFieldBuilder() {
            if (this.ranksListBuilder_ == null) {
                this.ranksListBuilder_ = new RepeatedFieldBuilderV3(this.ranksList_, (this.bitField0_ & 2) != 0, this.getParentForChildren(), this.isClean());
                this.ranksList_ = null;
            }
            return this.ranksListBuilder_;
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

    public static final class RoomRank
    extends GeneratedMessageV3
    implements RoomRankOrBuilder {
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        public static final int USER_FIELD_NUMBER = 1;
        private User user_;
        public static final int SCORESTR_FIELD_NUMBER = 2;
        private volatile Object scoreStr_ = "";
        public static final int PROFILEHIDDEN_FIELD_NUMBER = 3;
        private boolean profileHidden_ = false;
        private byte memoizedIsInitialized = (byte)-1;
        private static final RoomRank DEFAULT_INSTANCE = new RoomRank();
        private static final Parser<RoomRank> PARSER = new AbstractParser<RoomRank>(){

            @Override
            public RoomRank parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = RoomRank.newBuilder();
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

        private RoomRank(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private RoomRank() {
            this.scoreStr_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoomRank();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_RoomRankMessage_RoomRank_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_RoomRankMessage_RoomRank_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomRank.class, Builder.class);
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
        public String getScoreStr() {
            Object ref = this.scoreStr_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.scoreStr_ = s;
            return s;
        }

        @Override
        public ByteString getScoreStrBytes() {
            Object ref = this.scoreStr_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.scoreStr_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public boolean getProfileHidden() {
            return this.profileHidden_;
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
                output.writeMessage(1, this.getUser());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.scoreStr_)) {
                GeneratedMessageV3.writeString(output, 2, this.scoreStr_);
            }
            if (this.profileHidden_) {
                output.writeBool(3, this.profileHidden_);
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
                size += CodedOutputStream.computeMessageSize(1, this.getUser());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.scoreStr_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.scoreStr_);
            }
            if (this.profileHidden_) {
                size += CodedOutputStream.computeBoolSize(3, this.profileHidden_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RoomRank)) {
                return super.equals(obj);
            }
            RoomRank other = (RoomRank)obj;
            if (this.hasUser() != other.hasUser()) {
                return false;
            }
            if (this.hasUser() && !this.getUser().equals(other.getUser())) {
                return false;
            }
            if (!this.getScoreStr().equals((Object)other.getScoreStr())) {
                return false;
            }
            if (this.getProfileHidden() != other.getProfileHidden()) {
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
            hash = 19 * hash + RoomRank.getDescriptor().hashCode();
            if (this.hasUser()) {
                hash = 37 * hash + 1;
                hash = 53 * hash + this.getUser().hashCode();
            }
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getScoreStr().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashBoolean(this.getProfileHidden());
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static RoomRank parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoomRank parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoomRank parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoomRank parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoomRank parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoomRank parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoomRank parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoomRank parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoomRank parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoomRank parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoomRank parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoomRank parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return RoomRank.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoomRank prototype) {
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

        public static RoomRank getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoomRank> parser() {
            return PARSER;
        }

        public Parser<RoomRank> getParserForType() {
            return PARSER;
        }

        @Override
        public RoomRank getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements RoomRankOrBuilder {
            private int bitField0_;
            private User user_;
            private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userBuilder_;
            private Object scoreStr_ = "";
            private boolean profileHidden_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Douyin.internal_static_RoomRankMessage_RoomRank_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Douyin.internal_static_RoomRankMessage_RoomRank_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomRank.class, Builder.class);
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
                this.user_ = null;
                if (this.userBuilder_ != null) {
                    this.userBuilder_.dispose();
                    this.userBuilder_ = null;
                }
                this.scoreStr_ = "";
                this.profileHidden_ = false;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return Douyin.internal_static_RoomRankMessage_RoomRank_descriptor;
            }

            @Override
            public RoomRank getDefaultInstanceForType() {
                return RoomRank.getDefaultInstance();
            }

            @Override
            public RoomRank build() {
                RoomRank result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public RoomRank buildPartial() {
                RoomRank result = new RoomRank(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(RoomRank result) {
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) != 0) {
                    result.user_ = this.userBuilder_ == null ? this.user_ : this.userBuilder_.build();
                    to_bitField0_ |= 1;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.scoreStr_ = this.scoreStr_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.profileHidden_ = this.profileHidden_;
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
                if (other instanceof RoomRank) {
                    return this.mergeFrom((RoomRank)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoomRank other) {
                if (other == RoomRank.getDefaultInstance()) {
                    return this;
                }
                if (other.hasUser()) {
                    this.mergeUser(other.getUser());
                }
                if (!other.getScoreStr().isEmpty()) {
                    this.scoreStr_ = other.scoreStr_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (other.getProfileHidden()) {
                    this.setProfileHidden(other.getProfileHidden());
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
                    block11: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block11;
                            }
                            case 10: {
                                input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 1;
                                continue block11;
                            }
                            case 18: {
                                this.scoreStr_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 24: {
                                this.profileHidden_ = input.readBool();
                                this.bitField0_ |= 4;
                                continue block11;
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
            public boolean hasUser() {
                return (this.bitField0_ & 1) != 0;
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
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder setUser(User.Builder builderForValue) {
                if (this.userBuilder_ == null) {
                    this.user_ = builderForValue.build();
                } else {
                    this.userBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder mergeUser(User value) {
                if (this.userBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0 && this.user_ != null && this.user_ != User.getDefaultInstance()) {
                        this.getUserBuilder().mergeFrom(value);
                    } else {
                        this.user_ = value;
                    }
                } else {
                    this.userBuilder_.mergeFrom(value);
                }
                if (this.user_ != null) {
                    this.bitField0_ |= 1;
                    this.onChanged();
                }
                return this;
            }

            public Builder clearUser() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.user_ = null;
                if (this.userBuilder_ != null) {
                    this.userBuilder_.dispose();
                    this.userBuilder_ = null;
                }
                this.onChanged();
                return this;
            }

            public User.Builder getUserBuilder() {
                this.bitField0_ |= 1;
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
            public String getScoreStr() {
                Object ref = this.scoreStr_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.scoreStr_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getScoreStrBytes() {
                Object ref = this.scoreStr_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.scoreStr_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setScoreStr(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.scoreStr_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearScoreStr() {
                this.scoreStr_ = RoomRank.getDefaultInstance().getScoreStr();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setScoreStrBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                RoomRank.checkByteStringIsUtf8(value);
                this.scoreStr_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public boolean getProfileHidden() {
                return this.profileHidden_;
            }

            public Builder setProfileHidden(boolean value) {
                this.profileHidden_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearProfileHidden() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.profileHidden_ = false;
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

    public static interface RoomRankOrBuilder
    extends MessageOrBuilder {
        public boolean hasUser();

        public User getUser();

        public UserOrBuilder getUserOrBuilder();

        public String getScoreStr();

        public ByteString getScoreStrBytes();

        public boolean getProfileHidden();
    }
}


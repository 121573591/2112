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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_DetailOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_Page;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RanklistHourEntrance_PageOrBuilder;

public final class RanklistHourEntrance_Detail
extends GeneratedMessageV3
implements RanklistHourEntrance_DetailOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int PAGES_FIELD_NUMBER = 1;
    private List<RanklistHourEntrance_Page> pages_;
    public static final int RANKLIST_TYPE_FIELD_NUMBER = 2;
    private int ranklistType_ = 0;
    public static final int TITLE_FIELD_NUMBER = 3;
    private volatile Object title_ = "";
    public static final int RANKLIST_EXTRA_FIELD_NUMBER = 4;
    private volatile Object ranklistExtra_ = "";
    public static final int ENTRANCE_EXTRA_FIELD_NUMBER = 5;
    private volatile Object entranceExtra_ = "";
    public static final int SCHEMA_FIELD_NUMBER = 6;
    private volatile Object schema_ = "";
    private byte memoizedIsInitialized = (byte)-1;
    private static final RanklistHourEntrance_Detail DEFAULT_INSTANCE = new RanklistHourEntrance_Detail();
    private static final Parser<RanklistHourEntrance_Detail> PARSER = new AbstractParser<RanklistHourEntrance_Detail>(){

        @Override
        public RanklistHourEntrance_Detail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = RanklistHourEntrance_Detail.newBuilder();
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

    private RanklistHourEntrance_Detail(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RanklistHourEntrance_Detail() {
        this.pages_ = Collections.emptyList();
        this.title_ = "";
        this.ranklistExtra_ = "";
        this.entranceExtra_ = "";
        this.schema_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new RanklistHourEntrance_Detail();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_RanklistHourEntrance_Detail_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_RanklistHourEntrance_Detail_fieldAccessorTable.ensureFieldAccessorsInitialized(RanklistHourEntrance_Detail.class, Builder.class);
    }

    @Override
    public List<RanklistHourEntrance_Page> getPagesList() {
        return this.pages_;
    }

    @Override
    public List<? extends RanklistHourEntrance_PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    @Override
    public int getPagesCount() {
        return this.pages_.size();
    }

    @Override
    public RanklistHourEntrance_Page getPages(int index) {
        return (RanklistHourEntrance_Page)this.pages_.get(index);
    }

    @Override
    public RanklistHourEntrance_PageOrBuilder getPagesOrBuilder(int index) {
        return (RanklistHourEntrance_PageOrBuilder)this.pages_.get(index);
    }

    @Override
    public int getRanklistType() {
        return this.ranklistType_;
    }

    @Override
    public String getTitle() {
        Object ref = this.title_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.title_ = s;
        return s;
    }

    @Override
    public ByteString getTitleBytes() {
        Object ref = this.title_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.title_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getRanklistExtra() {
        Object ref = this.ranklistExtra_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.ranklistExtra_ = s;
        return s;
    }

    @Override
    public ByteString getRanklistExtraBytes() {
        Object ref = this.ranklistExtra_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.ranklistExtra_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getEntranceExtra() {
        Object ref = this.entranceExtra_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.entranceExtra_ = s;
        return s;
    }

    @Override
    public ByteString getEntranceExtraBytes() {
        Object ref = this.entranceExtra_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.entranceExtra_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getSchema() {
        Object ref = this.schema_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.schema_ = s;
        return s;
    }

    @Override
    public ByteString getSchemaBytes() {
        Object ref = this.schema_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.schema_ = b;
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
        for (int i = 0; i < this.pages_.size(); ++i) {
            output.writeMessage(1, (MessageLite)this.pages_.get(i));
        }
        if (this.ranklistType_ != 0) {
            output.writeInt32(2, this.ranklistType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
            GeneratedMessageV3.writeString(output, 3, this.title_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.ranklistExtra_)) {
            GeneratedMessageV3.writeString(output, 4, this.ranklistExtra_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.entranceExtra_)) {
            GeneratedMessageV3.writeString(output, 5, this.entranceExtra_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.schema_)) {
            GeneratedMessageV3.writeString(output, 6, this.schema_);
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
        for (int i = 0; i < this.pages_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.pages_.get(i));
        }
        if (this.ranklistType_ != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.ranklistType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
            size += GeneratedMessageV3.computeStringSize(3, this.title_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.ranklistExtra_)) {
            size += GeneratedMessageV3.computeStringSize(4, this.ranklistExtra_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.entranceExtra_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.entranceExtra_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.schema_)) {
            size += GeneratedMessageV3.computeStringSize(6, this.schema_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RanklistHourEntrance_Detail)) {
            return super.equals(obj);
        }
        RanklistHourEntrance_Detail other = (RanklistHourEntrance_Detail)obj;
        if (!this.getPagesList().equals(other.getPagesList())) {
            return false;
        }
        if (this.getRanklistType() != other.getRanklistType()) {
            return false;
        }
        if (!this.getTitle().equals((Object)other.getTitle())) {
            return false;
        }
        if (!this.getRanklistExtra().equals((Object)other.getRanklistExtra())) {
            return false;
        }
        if (!this.getEntranceExtra().equals((Object)other.getEntranceExtra())) {
            return false;
        }
        if (!this.getSchema().equals((Object)other.getSchema())) {
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
        hash = 19 * hash + RanklistHourEntrance_Detail.getDescriptor().hashCode();
        if (this.getPagesCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getPagesList().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getRanklistType();
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getTitle().hashCode();
        hash = 37 * hash + 4;
        hash = 53 * hash + this.getRanklistExtra().hashCode();
        hash = 37 * hash + 5;
        hash = 53 * hash + this.getEntranceExtra().hashCode();
        hash = 37 * hash + 6;
        hash = 53 * hash + this.getSchema().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static RanklistHourEntrance_Detail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RanklistHourEntrance_Detail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RanklistHourEntrance_Detail parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RanklistHourEntrance_Detail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RanklistHourEntrance_Detail parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RanklistHourEntrance_Detail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RanklistHourEntrance_Detail parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RanklistHourEntrance_Detail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RanklistHourEntrance_Detail parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static RanklistHourEntrance_Detail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RanklistHourEntrance_Detail parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RanklistHourEntrance_Detail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return RanklistHourEntrance_Detail.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RanklistHourEntrance_Detail prototype) {
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

    public static RanklistHourEntrance_Detail getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RanklistHourEntrance_Detail> parser() {
        return PARSER;
    }

    public Parser<RanklistHourEntrance_Detail> getParserForType() {
        return PARSER;
    }

    @Override
    public RanklistHourEntrance_Detail getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements RanklistHourEntrance_DetailOrBuilder {
        private int bitField0_;
        private List<RanklistHourEntrance_Page> pages_ = Collections.emptyList();
        private RepeatedFieldBuilderV3<RanklistHourEntrance_Page, RanklistHourEntrance_Page.Builder, RanklistHourEntrance_PageOrBuilder> pagesBuilder_;
        private int ranklistType_;
        private Object title_ = "";
        private Object ranklistExtra_ = "";
        private Object entranceExtra_ = "";
        private Object schema_ = "";

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_RanklistHourEntrance_Detail_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_RanklistHourEntrance_Detail_fieldAccessorTable.ensureFieldAccessorsInitialized(RanklistHourEntrance_Detail.class, Builder.class);
        }

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            if (this.pagesBuilder_ == null) {
                this.pages_ = Collections.emptyList();
            } else {
                this.pages_ = null;
                this.pagesBuilder_.clear();
            }
            this.bitField0_ &= 0xFFFFFFFE;
            this.ranklistType_ = 0;
            this.title_ = "";
            this.ranklistExtra_ = "";
            this.entranceExtra_ = "";
            this.schema_ = "";
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_RanklistHourEntrance_Detail_descriptor;
        }

        @Override
        public RanklistHourEntrance_Detail getDefaultInstanceForType() {
            return RanklistHourEntrance_Detail.getDefaultInstance();
        }

        @Override
        public RanklistHourEntrance_Detail build() {
            RanklistHourEntrance_Detail result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RanklistHourEntrance_Detail buildPartial() {
            RanklistHourEntrance_Detail result = new RanklistHourEntrance_Detail(this);
            this.buildPartialRepeatedFields(result);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(RanklistHourEntrance_Detail result) {
            if (this.pagesBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.pages_ = Collections.unmodifiableList(this.pages_);
                    this.bitField0_ &= 0xFFFFFFFE;
                }
                result.pages_ = this.pages_;
            } else {
                result.pages_ = this.pagesBuilder_.build();
            }
        }

        private void buildPartial0(RanklistHourEntrance_Detail result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 2) != 0) {
                result.ranklistType_ = this.ranklistType_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.title_ = this.title_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.ranklistExtra_ = this.ranklistExtra_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.entranceExtra_ = this.entranceExtra_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.schema_ = this.schema_;
            }
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
            if (other instanceof RanklistHourEntrance_Detail) {
                return this.mergeFrom((RanklistHourEntrance_Detail)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(RanklistHourEntrance_Detail other) {
            if (other == RanklistHourEntrance_Detail.getDefaultInstance()) {
                return this;
            }
            if (this.pagesBuilder_ == null) {
                if (!other.pages_.isEmpty()) {
                    if (this.pages_.isEmpty()) {
                        this.pages_ = other.pages_;
                        this.bitField0_ &= 0xFFFFFFFE;
                    } else {
                        this.ensurePagesIsMutable();
                        this.pages_.addAll((Collection)other.pages_);
                    }
                    this.onChanged();
                }
            } else if (!other.pages_.isEmpty()) {
                if (this.pagesBuilder_.isEmpty()) {
                    this.pagesBuilder_.dispose();
                    this.pagesBuilder_ = null;
                    this.pages_ = other.pages_;
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.pagesBuilder_ = alwaysUseFieldBuilders ? this.getPagesFieldBuilder() : null;
                } else {
                    this.pagesBuilder_.addAllMessages((Iterable<RanklistHourEntrance_Page>)other.pages_);
                }
            }
            if (other.getRanklistType() != 0) {
                this.setRanklistType(other.getRanklistType());
            }
            if (!other.getTitle().isEmpty()) {
                this.title_ = other.title_;
                this.bitField0_ |= 4;
                this.onChanged();
            }
            if (!other.getRanklistExtra().isEmpty()) {
                this.ranklistExtra_ = other.ranklistExtra_;
                this.bitField0_ |= 8;
                this.onChanged();
            }
            if (!other.getEntranceExtra().isEmpty()) {
                this.entranceExtra_ = other.entranceExtra_;
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            if (!other.getSchema().isEmpty()) {
                this.schema_ = other.schema_;
                this.bitField0_ |= 0x20;
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
                block14: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block14;
                        }
                        case 10: {
                            RanklistHourEntrance_Page m = input.readMessage(RanklistHourEntrance_Page.parser(), extensionRegistry);
                            if (this.pagesBuilder_ == null) {
                                this.ensurePagesIsMutable();
                                this.pages_.add((Object)m);
                                continue block14;
                            }
                            this.pagesBuilder_.addMessage(m);
                            continue block14;
                        }
                        case 16: {
                            this.ranklistType_ = input.readInt32();
                            this.bitField0_ |= 2;
                            continue block14;
                        }
                        case 26: {
                            this.title_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 4;
                            continue block14;
                        }
                        case 34: {
                            this.ranklistExtra_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 8;
                            continue block14;
                        }
                        case 42: {
                            this.entranceExtra_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x10;
                            continue block14;
                        }
                        case 50: {
                            this.schema_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x20;
                            continue block14;
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

        private void ensurePagesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.pages_ = new ArrayList(this.pages_);
                this.bitField0_ |= 1;
            }
        }

        @Override
        public List<RanklistHourEntrance_Page> getPagesList() {
            if (this.pagesBuilder_ == null) {
                return Collections.unmodifiableList(this.pages_);
            }
            return this.pagesBuilder_.getMessageList();
        }

        @Override
        public int getPagesCount() {
            if (this.pagesBuilder_ == null) {
                return this.pages_.size();
            }
            return this.pagesBuilder_.getCount();
        }

        @Override
        public RanklistHourEntrance_Page getPages(int index) {
            if (this.pagesBuilder_ == null) {
                return (RanklistHourEntrance_Page)this.pages_.get(index);
            }
            return this.pagesBuilder_.getMessage(index);
        }

        public Builder setPages(int index, RanklistHourEntrance_Page value) {
            if (this.pagesBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePagesIsMutable();
                this.pages_.set(index, (Object)value);
                this.onChanged();
            } else {
                this.pagesBuilder_.setMessage(index, value);
            }
            return this;
        }

        public Builder setPages(int index, RanklistHourEntrance_Page.Builder builderForValue) {
            if (this.pagesBuilder_ == null) {
                this.ensurePagesIsMutable();
                this.pages_.set(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.pagesBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addPages(RanklistHourEntrance_Page value) {
            if (this.pagesBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePagesIsMutable();
                this.pages_.add((Object)value);
                this.onChanged();
            } else {
                this.pagesBuilder_.addMessage(value);
            }
            return this;
        }

        public Builder addPages(int index, RanklistHourEntrance_Page value) {
            if (this.pagesBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensurePagesIsMutable();
                this.pages_.add(index, (Object)value);
                this.onChanged();
            } else {
                this.pagesBuilder_.addMessage(index, value);
            }
            return this;
        }

        public Builder addPages(RanklistHourEntrance_Page.Builder builderForValue) {
            if (this.pagesBuilder_ == null) {
                this.ensurePagesIsMutable();
                this.pages_.add((Object)builderForValue.build());
                this.onChanged();
            } else {
                this.pagesBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addPages(int index, RanklistHourEntrance_Page.Builder builderForValue) {
            if (this.pagesBuilder_ == null) {
                this.ensurePagesIsMutable();
                this.pages_.add(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.pagesBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllPages(Iterable<? extends RanklistHourEntrance_Page> values) {
            if (this.pagesBuilder_ == null) {
                this.ensurePagesIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.pages_);
                this.onChanged();
            } else {
                this.pagesBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearPages() {
            if (this.pagesBuilder_ == null) {
                this.pages_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFFE;
                this.onChanged();
            } else {
                this.pagesBuilder_.clear();
            }
            return this;
        }

        public Builder removePages(int index) {
            if (this.pagesBuilder_ == null) {
                this.ensurePagesIsMutable();
                this.pages_.remove(index);
                this.onChanged();
            } else {
                this.pagesBuilder_.remove(index);
            }
            return this;
        }

        public RanklistHourEntrance_Page.Builder getPagesBuilder(int index) {
            return this.getPagesFieldBuilder().getBuilder(index);
        }

        @Override
        public RanklistHourEntrance_PageOrBuilder getPagesOrBuilder(int index) {
            if (this.pagesBuilder_ == null) {
                return (RanklistHourEntrance_PageOrBuilder)this.pages_.get(index);
            }
            return this.pagesBuilder_.getMessageOrBuilder(index);
        }

        @Override
        public List<? extends RanklistHourEntrance_PageOrBuilder> getPagesOrBuilderList() {
            if (this.pagesBuilder_ != null) {
                return this.pagesBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.pages_);
        }

        public RanklistHourEntrance_Page.Builder addPagesBuilder() {
            return this.getPagesFieldBuilder().addBuilder(RanklistHourEntrance_Page.getDefaultInstance());
        }

        public RanklistHourEntrance_Page.Builder addPagesBuilder(int index) {
            return this.getPagesFieldBuilder().addBuilder(index, RanklistHourEntrance_Page.getDefaultInstance());
        }

        public List<RanklistHourEntrance_Page.Builder> getPagesBuilderList() {
            return this.getPagesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<RanklistHourEntrance_Page, RanklistHourEntrance_Page.Builder, RanklistHourEntrance_PageOrBuilder> getPagesFieldBuilder() {
            if (this.pagesBuilder_ == null) {
                this.pagesBuilder_ = new RepeatedFieldBuilderV3(this.pages_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
                this.pages_ = null;
            }
            return this.pagesBuilder_;
        }

        @Override
        public int getRanklistType() {
            return this.ranklistType_;
        }

        public Builder setRanklistType(int value) {
            this.ranklistType_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearRanklistType() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.ranklistType_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public String getTitle() {
            Object ref = this.title_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.title_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getTitleBytes() {
            Object ref = this.title_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.title_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setTitle(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.title_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearTitle() {
            this.title_ = RanklistHourEntrance_Detail.getDefaultInstance().getTitle();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
            return this;
        }

        public Builder setTitleBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RanklistHourEntrance_Detail.checkByteStringIsUtf8(value);
            this.title_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        @Override
        public String getRanklistExtra() {
            Object ref = this.ranklistExtra_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.ranklistExtra_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getRanklistExtraBytes() {
            Object ref = this.ranklistExtra_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.ranklistExtra_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setRanklistExtra(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ranklistExtra_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearRanklistExtra() {
            this.ranklistExtra_ = RanklistHourEntrance_Detail.getDefaultInstance().getRanklistExtra();
            this.bitField0_ &= 0xFFFFFFF7;
            this.onChanged();
            return this;
        }

        public Builder setRanklistExtraBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RanklistHourEntrance_Detail.checkByteStringIsUtf8(value);
            this.ranklistExtra_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        @Override
        public String getEntranceExtra() {
            Object ref = this.entranceExtra_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.entranceExtra_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getEntranceExtraBytes() {
            Object ref = this.entranceExtra_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.entranceExtra_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setEntranceExtra(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.entranceExtra_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearEntranceExtra() {
            this.entranceExtra_ = RanklistHourEntrance_Detail.getDefaultInstance().getEntranceExtra();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        public Builder setEntranceExtraBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RanklistHourEntrance_Detail.checkByteStringIsUtf8(value);
            this.entranceExtra_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        @Override
        public String getSchema() {
            Object ref = this.schema_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.schema_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getSchemaBytes() {
            Object ref = this.schema_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.schema_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setSchema(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.schema_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearSchema() {
            this.schema_ = RanklistHourEntrance_Detail.getDefaultInstance().getSchema();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
            return this;
        }

        public Builder setSchemaBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RanklistHourEntrance_Detail.checkByteStringIsUtf8(value);
            this.schema_ = value;
            this.bitField0_ |= 0x20;
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


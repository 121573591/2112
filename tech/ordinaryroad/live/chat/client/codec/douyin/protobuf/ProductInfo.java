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
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ProductInfoOrBuilder;

public final class ProductInfo
extends GeneratedMessageV3
implements ProductInfoOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int PROMOTIONID_FIELD_NUMBER = 1;
    private long promotionId_ = 0L;
    public static final int INDEX_FIELD_NUMBER = 2;
    private int index_ = 0;
    public static final int TARGETFLASHUIDSLIST_FIELD_NUMBER = 3;
    private Internal.LongList targetFlashUidsList_ = ProductInfo.emptyLongList();
    private int targetFlashUidsListMemoizedSerializedSize = -1;
    public static final int EXPLAINTYPE_FIELD_NUMBER = 4;
    private long explainType_ = 0L;
    private byte memoizedIsInitialized = (byte)-1;
    private static final ProductInfo DEFAULT_INSTANCE = new ProductInfo();
    private static final Parser<ProductInfo> PARSER = new AbstractParser<ProductInfo>(){

        @Override
        public ProductInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = ProductInfo.newBuilder();
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

    private ProductInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ProductInfo() {
        this.targetFlashUidsList_ = ProductInfo.emptyLongList();
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new ProductInfo();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_ProductInfo_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_ProductInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ProductInfo.class, Builder.class);
    }

    @Override
    public long getPromotionId() {
        return this.promotionId_;
    }

    @Override
    public int getIndex() {
        return this.index_;
    }

    @Override
    public List<Long> getTargetFlashUidsListList() {
        return this.targetFlashUidsList_;
    }

    @Override
    public int getTargetFlashUidsListCount() {
        return this.targetFlashUidsList_.size();
    }

    @Override
    public long getTargetFlashUidsList(int index) {
        return this.targetFlashUidsList_.getLong(index);
    }

    @Override
    public long getExplainType() {
        return this.explainType_;
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
        if (this.promotionId_ != 0L) {
            output.writeInt64(1, this.promotionId_);
        }
        if (this.index_ != 0) {
            output.writeInt32(2, this.index_);
        }
        if (this.getTargetFlashUidsListList().size() > 0) {
            output.writeUInt32NoTag(26);
            output.writeUInt32NoTag(this.targetFlashUidsListMemoizedSerializedSize);
        }
        for (int i = 0; i < this.targetFlashUidsList_.size(); ++i) {
            output.writeInt64NoTag(this.targetFlashUidsList_.getLong(i));
        }
        if (this.explainType_ != 0L) {
            output.writeInt64(4, this.explainType_);
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
        if (this.promotionId_ != 0L) {
            size += CodedOutputStream.computeInt64Size(1, this.promotionId_);
        }
        if (this.index_ != 0) {
            size += CodedOutputStream.computeInt32Size(2, this.index_);
        }
        int dataSize = 0;
        for (int i = 0; i < this.targetFlashUidsList_.size(); ++i) {
            dataSize += CodedOutputStream.computeInt64SizeNoTag(this.targetFlashUidsList_.getLong(i));
        }
        size += dataSize;
        if (!this.getTargetFlashUidsListList().isEmpty()) {
            ++size;
            size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        this.targetFlashUidsListMemoizedSerializedSize = dataSize;
        if (this.explainType_ != 0L) {
            size += CodedOutputStream.computeInt64Size(4, this.explainType_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductInfo)) {
            return super.equals(obj);
        }
        ProductInfo other = (ProductInfo)obj;
        if (this.getPromotionId() != other.getPromotionId()) {
            return false;
        }
        if (this.getIndex() != other.getIndex()) {
            return false;
        }
        if (!this.getTargetFlashUidsListList().equals(other.getTargetFlashUidsListList())) {
            return false;
        }
        if (this.getExplainType() != other.getExplainType()) {
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
        hash = 19 * hash + ProductInfo.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + Internal.hashLong(this.getPromotionId());
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getIndex();
        if (this.getTargetFlashUidsListCount() > 0) {
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getTargetFlashUidsListList().hashCode();
        }
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getExplainType());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static ProductInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ProductInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ProductInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ProductInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ProductInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ProductInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ProductInfo parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static ProductInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static ProductInfo parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static ProductInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static ProductInfo parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static ProductInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return ProductInfo.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ProductInfo prototype) {
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

    public static ProductInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ProductInfo> parser() {
        return PARSER;
    }

    public Parser<ProductInfo> getParserForType() {
        return PARSER;
    }

    @Override
    public ProductInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ Internal.LongList access$800() {
        return ProductInfo.emptyLongList();
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements ProductInfoOrBuilder {
        private int bitField0_;
        private long promotionId_;
        private int index_;
        private Internal.LongList targetFlashUidsList_ = ProductInfo.access$800();
        private long explainType_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_ProductInfo_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_ProductInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ProductInfo.class, Builder.class);
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
            this.promotionId_ = 0L;
            this.index_ = 0;
            this.targetFlashUidsList_ = ProductInfo.emptyLongList();
            this.explainType_ = 0L;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_ProductInfo_descriptor;
        }

        @Override
        public ProductInfo getDefaultInstanceForType() {
            return ProductInfo.getDefaultInstance();
        }

        @Override
        public ProductInfo build() {
            ProductInfo result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public ProductInfo buildPartial() {
            ProductInfo result = new ProductInfo(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(ProductInfo result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.promotionId_ = this.promotionId_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.index_ = this.index_;
            }
            if ((from_bitField0_ & 4) != 0) {
                this.targetFlashUidsList_.makeImmutable();
                result.targetFlashUidsList_ = this.targetFlashUidsList_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.explainType_ = this.explainType_;
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
            if (other instanceof ProductInfo) {
                return this.mergeFrom((ProductInfo)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(ProductInfo other) {
            if (other == ProductInfo.getDefaultInstance()) {
                return this;
            }
            if (other.getPromotionId() != 0L) {
                this.setPromotionId(other.getPromotionId());
            }
            if (other.getIndex() != 0) {
                this.setIndex(other.getIndex());
            }
            if (!other.targetFlashUidsList_.isEmpty()) {
                if (this.targetFlashUidsList_.isEmpty()) {
                    this.targetFlashUidsList_ = other.targetFlashUidsList_;
                    this.targetFlashUidsList_.makeImmutable();
                    this.bitField0_ |= 4;
                } else {
                    this.ensureTargetFlashUidsListIsMutable();
                    this.targetFlashUidsList_.addAll((Collection)other.targetFlashUidsList_);
                }
                this.onChanged();
            }
            if (other.getExplainType() != 0L) {
                this.setExplainType(other.getExplainType());
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
                        case 8: {
                            this.promotionId_ = input.readInt64();
                            this.bitField0_ |= 1;
                            continue block13;
                        }
                        case 16: {
                            this.index_ = input.readInt32();
                            this.bitField0_ |= 2;
                            continue block13;
                        }
                        case 24: {
                            long v = input.readInt64();
                            this.ensureTargetFlashUidsListIsMutable();
                            this.targetFlashUidsList_.addLong(v);
                            continue block13;
                        }
                        case 26: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            this.ensureTargetFlashUidsListIsMutable();
                            while (input.getBytesUntilLimit() > 0) {
                                this.targetFlashUidsList_.addLong(input.readInt64());
                            }
                            input.popLimit(limit);
                            continue block13;
                        }
                        case 32: {
                            this.explainType_ = input.readInt64();
                            this.bitField0_ |= 8;
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
        public long getPromotionId() {
            return this.promotionId_;
        }

        public Builder setPromotionId(long value) {
            this.promotionId_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearPromotionId() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.promotionId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public int getIndex() {
            return this.index_;
        }

        public Builder setIndex(int value) {
            this.index_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearIndex() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.index_ = 0;
            this.onChanged();
            return this;
        }

        private void ensureTargetFlashUidsListIsMutable() {
            if (!this.targetFlashUidsList_.isModifiable()) {
                this.targetFlashUidsList_ = (Internal.LongList)ProductInfo.makeMutableCopy(this.targetFlashUidsList_);
            }
            this.bitField0_ |= 4;
        }

        @Override
        public List<Long> getTargetFlashUidsListList() {
            this.targetFlashUidsList_.makeImmutable();
            return this.targetFlashUidsList_;
        }

        @Override
        public int getTargetFlashUidsListCount() {
            return this.targetFlashUidsList_.size();
        }

        @Override
        public long getTargetFlashUidsList(int index) {
            return this.targetFlashUidsList_.getLong(index);
        }

        public Builder setTargetFlashUidsList(int index, long value) {
            this.ensureTargetFlashUidsListIsMutable();
            this.targetFlashUidsList_.setLong(index, value);
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder addTargetFlashUidsList(long value) {
            this.ensureTargetFlashUidsListIsMutable();
            this.targetFlashUidsList_.addLong(value);
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder addAllTargetFlashUidsList(Iterable<? extends Long> values) {
            this.ensureTargetFlashUidsListIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.targetFlashUidsList_);
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearTargetFlashUidsList() {
            this.targetFlashUidsList_ = ProductInfo.emptyLongList();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
            return this;
        }

        @Override
        public long getExplainType() {
            return this.explainType_;
        }

        public Builder setExplainType(long value) {
            this.explainType_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearExplainType() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.explainType_ = 0L;
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


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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.HeadersList;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.HeadersListOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PushFrameOrBuilder;

public final class PushFrame
extends GeneratedMessageV3
implements PushFrameOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int SEQID_FIELD_NUMBER = 1;
    private long seqId_ = 0L;
    public static final int LOGID_FIELD_NUMBER = 2;
    private long logId_ = 0L;
    public static final int SERVICE_FIELD_NUMBER = 3;
    private long service_ = 0L;
    public static final int METHOD_FIELD_NUMBER = 4;
    private long method_ = 0L;
    public static final int HEADERSLIST_FIELD_NUMBER = 5;
    private List<HeadersList> headersList_;
    public static final int PAYLOADENCODING_FIELD_NUMBER = 6;
    private volatile Object payloadEncoding_ = "";
    public static final int PAYLOADTYPE_FIELD_NUMBER = 7;
    private volatile Object payloadType_ = "";
    public static final int PAYLOAD_FIELD_NUMBER = 8;
    private ByteString payload_ = ByteString.EMPTY;
    private byte memoizedIsInitialized = (byte)-1;
    private static final PushFrame DEFAULT_INSTANCE = new PushFrame();
    private static final Parser<PushFrame> PARSER = new AbstractParser<PushFrame>(){

        @Override
        public PushFrame parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = PushFrame.newBuilder();
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

    private PushFrame(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private PushFrame() {
        this.headersList_ = Collections.emptyList();
        this.payloadEncoding_ = "";
        this.payloadType_ = "";
        this.payload_ = ByteString.EMPTY;
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new PushFrame();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_PushFrame_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_PushFrame_fieldAccessorTable.ensureFieldAccessorsInitialized(PushFrame.class, Builder.class);
    }

    @Override
    public long getSeqId() {
        return this.seqId_;
    }

    @Override
    public long getLogId() {
        return this.logId_;
    }

    @Override
    public long getService() {
        return this.service_;
    }

    @Override
    public long getMethod() {
        return this.method_;
    }

    @Override
    public List<HeadersList> getHeadersListList() {
        return this.headersList_;
    }

    @Override
    public List<? extends HeadersListOrBuilder> getHeadersListOrBuilderList() {
        return this.headersList_;
    }

    @Override
    public int getHeadersListCount() {
        return this.headersList_.size();
    }

    @Override
    public HeadersList getHeadersList(int index) {
        return (HeadersList)this.headersList_.get(index);
    }

    @Override
    public HeadersListOrBuilder getHeadersListOrBuilder(int index) {
        return (HeadersListOrBuilder)this.headersList_.get(index);
    }

    @Override
    public String getPayloadEncoding() {
        Object ref = this.payloadEncoding_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.payloadEncoding_ = s;
        return s;
    }

    @Override
    public ByteString getPayloadEncodingBytes() {
        Object ref = this.payloadEncoding_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.payloadEncoding_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getPayloadType() {
        Object ref = this.payloadType_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.payloadType_ = s;
        return s;
    }

    @Override
    public ByteString getPayloadTypeBytes() {
        Object ref = this.payloadType_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.payloadType_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public ByteString getPayload() {
        return this.payload_;
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
        if (this.seqId_ != 0L) {
            output.writeUInt64(1, this.seqId_);
        }
        if (this.logId_ != 0L) {
            output.writeUInt64(2, this.logId_);
        }
        if (this.service_ != 0L) {
            output.writeUInt64(3, this.service_);
        }
        if (this.method_ != 0L) {
            output.writeUInt64(4, this.method_);
        }
        for (int i = 0; i < this.headersList_.size(); ++i) {
            output.writeMessage(5, (MessageLite)this.headersList_.get(i));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.payloadEncoding_)) {
            GeneratedMessageV3.writeString(output, 6, this.payloadEncoding_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.payloadType_)) {
            GeneratedMessageV3.writeString(output, 7, this.payloadType_);
        }
        if (!this.payload_.isEmpty()) {
            output.writeBytes(8, this.payload_);
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
        if (this.seqId_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(1, this.seqId_);
        }
        if (this.logId_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(2, this.logId_);
        }
        if (this.service_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.service_);
        }
        if (this.method_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(4, this.method_);
        }
        for (int i = 0; i < this.headersList_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.headersList_.get(i));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.payloadEncoding_)) {
            size += GeneratedMessageV3.computeStringSize(6, this.payloadEncoding_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.payloadType_)) {
            size += GeneratedMessageV3.computeStringSize(7, this.payloadType_);
        }
        if (!this.payload_.isEmpty()) {
            size += CodedOutputStream.computeBytesSize(8, this.payload_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushFrame)) {
            return super.equals(obj);
        }
        PushFrame other = (PushFrame)obj;
        if (this.getSeqId() != other.getSeqId()) {
            return false;
        }
        if (this.getLogId() != other.getLogId()) {
            return false;
        }
        if (this.getService() != other.getService()) {
            return false;
        }
        if (this.getMethod() != other.getMethod()) {
            return false;
        }
        if (!this.getHeadersListList().equals(other.getHeadersListList())) {
            return false;
        }
        if (!this.getPayloadEncoding().equals((Object)other.getPayloadEncoding())) {
            return false;
        }
        if (!this.getPayloadType().equals((Object)other.getPayloadType())) {
            return false;
        }
        if (!this.getPayload().equals(other.getPayload())) {
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
        hash = 19 * hash + PushFrame.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + Internal.hashLong(this.getSeqId());
        hash = 37 * hash + 2;
        hash = 53 * hash + Internal.hashLong(this.getLogId());
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getService());
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getMethod());
        if (this.getHeadersListCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getHeadersListList().hashCode();
        }
        hash = 37 * hash + 6;
        hash = 53 * hash + this.getPayloadEncoding().hashCode();
        hash = 37 * hash + 7;
        hash = 53 * hash + this.getPayloadType().hashCode();
        hash = 37 * hash + 8;
        hash = 53 * hash + this.getPayload().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static PushFrame parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PushFrame parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PushFrame parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PushFrame parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PushFrame parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PushFrame parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PushFrame parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static PushFrame parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static PushFrame parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static PushFrame parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static PushFrame parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static PushFrame parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return PushFrame.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PushFrame prototype) {
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

    public static PushFrame getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PushFrame> parser() {
        return PARSER;
    }

    public Parser<PushFrame> getParserForType() {
        return PARSER;
    }

    @Override
    public PushFrame getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements PushFrameOrBuilder {
        private int bitField0_;
        private long seqId_;
        private long logId_;
        private long service_;
        private long method_;
        private List<HeadersList> headersList_ = Collections.emptyList();
        private RepeatedFieldBuilderV3<HeadersList, HeadersList.Builder, HeadersListOrBuilder> headersListBuilder_;
        private Object payloadEncoding_ = "";
        private Object payloadType_ = "";
        private ByteString payload_ = ByteString.EMPTY;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_PushFrame_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_PushFrame_fieldAccessorTable.ensureFieldAccessorsInitialized(PushFrame.class, Builder.class);
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
            this.seqId_ = 0L;
            this.logId_ = 0L;
            this.service_ = 0L;
            this.method_ = 0L;
            if (this.headersListBuilder_ == null) {
                this.headersList_ = Collections.emptyList();
            } else {
                this.headersList_ = null;
                this.headersListBuilder_.clear();
            }
            this.bitField0_ &= 0xFFFFFFEF;
            this.payloadEncoding_ = "";
            this.payloadType_ = "";
            this.payload_ = ByteString.EMPTY;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_PushFrame_descriptor;
        }

        @Override
        public PushFrame getDefaultInstanceForType() {
            return PushFrame.getDefaultInstance();
        }

        @Override
        public PushFrame build() {
            PushFrame result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public PushFrame buildPartial() {
            PushFrame result = new PushFrame(this);
            this.buildPartialRepeatedFields(result);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(PushFrame result) {
            if (this.headersListBuilder_ == null) {
                if ((this.bitField0_ & 0x10) != 0) {
                    this.headersList_ = Collections.unmodifiableList(this.headersList_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.headersList_ = this.headersList_;
            } else {
                result.headersList_ = this.headersListBuilder_.build();
            }
        }

        private void buildPartial0(PushFrame result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.seqId_ = this.seqId_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.logId_ = this.logId_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.service_ = this.service_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.method_ = this.method_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.payloadEncoding_ = this.payloadEncoding_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.payloadType_ = this.payloadType_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.payload_ = this.payload_;
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
            if (other instanceof PushFrame) {
                return this.mergeFrom((PushFrame)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(PushFrame other) {
            if (other == PushFrame.getDefaultInstance()) {
                return this;
            }
            if (other.getSeqId() != 0L) {
                this.setSeqId(other.getSeqId());
            }
            if (other.getLogId() != 0L) {
                this.setLogId(other.getLogId());
            }
            if (other.getService() != 0L) {
                this.setService(other.getService());
            }
            if (other.getMethod() != 0L) {
                this.setMethod(other.getMethod());
            }
            if (this.headersListBuilder_ == null) {
                if (!other.headersList_.isEmpty()) {
                    if (this.headersList_.isEmpty()) {
                        this.headersList_ = other.headersList_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureHeadersListIsMutable();
                        this.headersList_.addAll((Collection)other.headersList_);
                    }
                    this.onChanged();
                }
            } else if (!other.headersList_.isEmpty()) {
                if (this.headersListBuilder_.isEmpty()) {
                    this.headersListBuilder_.dispose();
                    this.headersListBuilder_ = null;
                    this.headersList_ = other.headersList_;
                    this.bitField0_ &= 0xFFFFFFEF;
                    this.headersListBuilder_ = alwaysUseFieldBuilders ? this.getHeadersListFieldBuilder() : null;
                } else {
                    this.headersListBuilder_.addAllMessages((Iterable<HeadersList>)other.headersList_);
                }
            }
            if (!other.getPayloadEncoding().isEmpty()) {
                this.payloadEncoding_ = other.payloadEncoding_;
                this.bitField0_ |= 0x20;
                this.onChanged();
            }
            if (!other.getPayloadType().isEmpty()) {
                this.payloadType_ = other.payloadType_;
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            if (other.getPayload() != ByteString.EMPTY) {
                this.setPayload(other.getPayload());
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
                        case 8: {
                            this.seqId_ = input.readUInt64();
                            this.bitField0_ |= 1;
                            continue block16;
                        }
                        case 16: {
                            this.logId_ = input.readUInt64();
                            this.bitField0_ |= 2;
                            continue block16;
                        }
                        case 24: {
                            this.service_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block16;
                        }
                        case 32: {
                            this.method_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block16;
                        }
                        case 42: {
                            HeadersList m = input.readMessage(HeadersList.parser(), extensionRegistry);
                            if (this.headersListBuilder_ == null) {
                                this.ensureHeadersListIsMutable();
                                this.headersList_.add((Object)m);
                                continue block16;
                            }
                            this.headersListBuilder_.addMessage(m);
                            continue block16;
                        }
                        case 50: {
                            this.payloadEncoding_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x20;
                            continue block16;
                        }
                        case 58: {
                            this.payloadType_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x40;
                            continue block16;
                        }
                        case 66: {
                            this.payload_ = input.readBytes();
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
        public long getSeqId() {
            return this.seqId_;
        }

        public Builder setSeqId(long value) {
            this.seqId_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearSeqId() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.seqId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getLogId() {
            return this.logId_;
        }

        public Builder setLogId(long value) {
            this.logId_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearLogId() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.logId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getService() {
            return this.service_;
        }

        public Builder setService(long value) {
            this.service_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearService() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.service_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getMethod() {
            return this.method_;
        }

        public Builder setMethod(long value) {
            this.method_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearMethod() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.method_ = 0L;
            this.onChanged();
            return this;
        }

        private void ensureHeadersListIsMutable() {
            if ((this.bitField0_ & 0x10) == 0) {
                this.headersList_ = new ArrayList(this.headersList_);
                this.bitField0_ |= 0x10;
            }
        }

        @Override
        public List<HeadersList> getHeadersListList() {
            if (this.headersListBuilder_ == null) {
                return Collections.unmodifiableList(this.headersList_);
            }
            return this.headersListBuilder_.getMessageList();
        }

        @Override
        public int getHeadersListCount() {
            if (this.headersListBuilder_ == null) {
                return this.headersList_.size();
            }
            return this.headersListBuilder_.getCount();
        }

        @Override
        public HeadersList getHeadersList(int index) {
            if (this.headersListBuilder_ == null) {
                return (HeadersList)this.headersList_.get(index);
            }
            return this.headersListBuilder_.getMessage(index);
        }

        public Builder setHeadersList(int index, HeadersList value) {
            if (this.headersListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureHeadersListIsMutable();
                this.headersList_.set(index, (Object)value);
                this.onChanged();
            } else {
                this.headersListBuilder_.setMessage(index, value);
            }
            return this;
        }

        public Builder setHeadersList(int index, HeadersList.Builder builderForValue) {
            if (this.headersListBuilder_ == null) {
                this.ensureHeadersListIsMutable();
                this.headersList_.set(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.headersListBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addHeadersList(HeadersList value) {
            if (this.headersListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureHeadersListIsMutable();
                this.headersList_.add((Object)value);
                this.onChanged();
            } else {
                this.headersListBuilder_.addMessage(value);
            }
            return this;
        }

        public Builder addHeadersList(int index, HeadersList value) {
            if (this.headersListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureHeadersListIsMutable();
                this.headersList_.add(index, (Object)value);
                this.onChanged();
            } else {
                this.headersListBuilder_.addMessage(index, value);
            }
            return this;
        }

        public Builder addHeadersList(HeadersList.Builder builderForValue) {
            if (this.headersListBuilder_ == null) {
                this.ensureHeadersListIsMutable();
                this.headersList_.add((Object)builderForValue.build());
                this.onChanged();
            } else {
                this.headersListBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addHeadersList(int index, HeadersList.Builder builderForValue) {
            if (this.headersListBuilder_ == null) {
                this.ensureHeadersListIsMutable();
                this.headersList_.add(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.headersListBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllHeadersList(Iterable<? extends HeadersList> values) {
            if (this.headersListBuilder_ == null) {
                this.ensureHeadersListIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.headersList_);
                this.onChanged();
            } else {
                this.headersListBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearHeadersList() {
            if (this.headersListBuilder_ == null) {
                this.headersList_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                this.onChanged();
            } else {
                this.headersListBuilder_.clear();
            }
            return this;
        }

        public Builder removeHeadersList(int index) {
            if (this.headersListBuilder_ == null) {
                this.ensureHeadersListIsMutable();
                this.headersList_.remove(index);
                this.onChanged();
            } else {
                this.headersListBuilder_.remove(index);
            }
            return this;
        }

        public HeadersList.Builder getHeadersListBuilder(int index) {
            return this.getHeadersListFieldBuilder().getBuilder(index);
        }

        @Override
        public HeadersListOrBuilder getHeadersListOrBuilder(int index) {
            if (this.headersListBuilder_ == null) {
                return (HeadersListOrBuilder)this.headersList_.get(index);
            }
            return this.headersListBuilder_.getMessageOrBuilder(index);
        }

        @Override
        public List<? extends HeadersListOrBuilder> getHeadersListOrBuilderList() {
            if (this.headersListBuilder_ != null) {
                return this.headersListBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.headersList_);
        }

        public HeadersList.Builder addHeadersListBuilder() {
            return this.getHeadersListFieldBuilder().addBuilder(HeadersList.getDefaultInstance());
        }

        public HeadersList.Builder addHeadersListBuilder(int index) {
            return this.getHeadersListFieldBuilder().addBuilder(index, HeadersList.getDefaultInstance());
        }

        public List<HeadersList.Builder> getHeadersListBuilderList() {
            return this.getHeadersListFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<HeadersList, HeadersList.Builder, HeadersListOrBuilder> getHeadersListFieldBuilder() {
            if (this.headersListBuilder_ == null) {
                this.headersListBuilder_ = new RepeatedFieldBuilderV3(this.headersList_, (this.bitField0_ & 0x10) != 0, this.getParentForChildren(), this.isClean());
                this.headersList_ = null;
            }
            return this.headersListBuilder_;
        }

        @Override
        public String getPayloadEncoding() {
            Object ref = this.payloadEncoding_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.payloadEncoding_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getPayloadEncodingBytes() {
            Object ref = this.payloadEncoding_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.payloadEncoding_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setPayloadEncoding(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.payloadEncoding_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearPayloadEncoding() {
            this.payloadEncoding_ = PushFrame.getDefaultInstance().getPayloadEncoding();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
            return this;
        }

        public Builder setPayloadEncodingBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PushFrame.checkByteStringIsUtf8(value);
            this.payloadEncoding_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        @Override
        public String getPayloadType() {
            Object ref = this.payloadType_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.payloadType_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getPayloadTypeBytes() {
            Object ref = this.payloadType_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.payloadType_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setPayloadType(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.payloadType_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearPayloadType() {
            this.payloadType_ = PushFrame.getDefaultInstance().getPayloadType();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
            return this;
        }

        public Builder setPayloadTypeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PushFrame.checkByteStringIsUtf8(value);
            this.payloadType_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        @Override
        public ByteString getPayload() {
            return this.payload_;
        }

        public Builder setPayload(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.payload_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearPayload() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.payload_ = PushFrame.getDefaultInstance().getPayload();
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


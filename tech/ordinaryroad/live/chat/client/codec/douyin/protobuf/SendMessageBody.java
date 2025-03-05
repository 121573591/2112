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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ExtList;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ExtListOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.SendMessageBodyOrBuilder;

public final class SendMessageBody
extends GeneratedMessageV3
implements SendMessageBodyOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int CONVERSATIONID_FIELD_NUMBER = 1;
    private volatile Object conversationId_ = "";
    public static final int CONVERSATIONTYPE_FIELD_NUMBER = 2;
    private int conversationType_ = 0;
    public static final int CONVERSATIONSHORTID_FIELD_NUMBER = 3;
    private long conversationShortId_ = 0L;
    public static final int CONTENT_FIELD_NUMBER = 4;
    private volatile Object content_ = "";
    public static final int EXT_FIELD_NUMBER = 5;
    private List<ExtList> ext_;
    public static final int MESSAGETYPE_FIELD_NUMBER = 6;
    private int messageType_ = 0;
    public static final int TICKET_FIELD_NUMBER = 7;
    private volatile Object ticket_ = "";
    public static final int CLIENTMESSAGEID_FIELD_NUMBER = 8;
    private volatile Object clientMessageId_ = "";
    private byte memoizedIsInitialized = (byte)-1;
    private static final SendMessageBody DEFAULT_INSTANCE = new SendMessageBody();
    private static final Parser<SendMessageBody> PARSER = new AbstractParser<SendMessageBody>(){

        @Override
        public SendMessageBody parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = SendMessageBody.newBuilder();
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

    private SendMessageBody(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private SendMessageBody() {
        this.conversationId_ = "";
        this.content_ = "";
        this.ext_ = Collections.emptyList();
        this.ticket_ = "";
        this.clientMessageId_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new SendMessageBody();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_SendMessageBody_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_SendMessageBody_fieldAccessorTable.ensureFieldAccessorsInitialized(SendMessageBody.class, Builder.class);
    }

    @Override
    public String getConversationId() {
        Object ref = this.conversationId_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.conversationId_ = s;
        return s;
    }

    @Override
    public ByteString getConversationIdBytes() {
        Object ref = this.conversationId_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.conversationId_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public int getConversationType() {
        return this.conversationType_;
    }

    @Override
    public long getConversationShortId() {
        return this.conversationShortId_;
    }

    @Override
    public String getContent() {
        Object ref = this.content_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.content_ = s;
        return s;
    }

    @Override
    public ByteString getContentBytes() {
        Object ref = this.content_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.content_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public List<ExtList> getExtList() {
        return this.ext_;
    }

    @Override
    public List<? extends ExtListOrBuilder> getExtOrBuilderList() {
        return this.ext_;
    }

    @Override
    public int getExtCount() {
        return this.ext_.size();
    }

    @Override
    public ExtList getExt(int index) {
        return (ExtList)this.ext_.get(index);
    }

    @Override
    public ExtListOrBuilder getExtOrBuilder(int index) {
        return (ExtListOrBuilder)this.ext_.get(index);
    }

    @Override
    public int getMessageType() {
        return this.messageType_;
    }

    @Override
    public String getTicket() {
        Object ref = this.ticket_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.ticket_ = s;
        return s;
    }

    @Override
    public ByteString getTicketBytes() {
        Object ref = this.ticket_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.ticket_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getClientMessageId() {
        Object ref = this.clientMessageId_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.clientMessageId_ = s;
        return s;
    }

    @Override
    public ByteString getClientMessageIdBytes() {
        Object ref = this.clientMessageId_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.clientMessageId_ = b;
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
        if (!GeneratedMessageV3.isStringEmpty(this.conversationId_)) {
            GeneratedMessageV3.writeString(output, 1, this.conversationId_);
        }
        if (this.conversationType_ != 0) {
            output.writeUInt32(2, this.conversationType_);
        }
        if (this.conversationShortId_ != 0L) {
            output.writeUInt64(3, this.conversationShortId_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
            GeneratedMessageV3.writeString(output, 4, this.content_);
        }
        for (int i = 0; i < this.ext_.size(); ++i) {
            output.writeMessage(5, (MessageLite)this.ext_.get(i));
        }
        if (this.messageType_ != 0) {
            output.writeUInt32(6, this.messageType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.ticket_)) {
            GeneratedMessageV3.writeString(output, 7, this.ticket_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.clientMessageId_)) {
            GeneratedMessageV3.writeString(output, 8, this.clientMessageId_);
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
        if (!GeneratedMessageV3.isStringEmpty(this.conversationId_)) {
            size += GeneratedMessageV3.computeStringSize(1, this.conversationId_);
        }
        if (this.conversationType_ != 0) {
            size += CodedOutputStream.computeUInt32Size(2, this.conversationType_);
        }
        if (this.conversationShortId_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.conversationShortId_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
            size += GeneratedMessageV3.computeStringSize(4, this.content_);
        }
        for (int i = 0; i < this.ext_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.ext_.get(i));
        }
        if (this.messageType_ != 0) {
            size += CodedOutputStream.computeUInt32Size(6, this.messageType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.ticket_)) {
            size += GeneratedMessageV3.computeStringSize(7, this.ticket_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.clientMessageId_)) {
            size += GeneratedMessageV3.computeStringSize(8, this.clientMessageId_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendMessageBody)) {
            return super.equals(obj);
        }
        SendMessageBody other = (SendMessageBody)obj;
        if (!this.getConversationId().equals((Object)other.getConversationId())) {
            return false;
        }
        if (this.getConversationType() != other.getConversationType()) {
            return false;
        }
        if (this.getConversationShortId() != other.getConversationShortId()) {
            return false;
        }
        if (!this.getContent().equals((Object)other.getContent())) {
            return false;
        }
        if (!this.getExtList().equals(other.getExtList())) {
            return false;
        }
        if (this.getMessageType() != other.getMessageType()) {
            return false;
        }
        if (!this.getTicket().equals((Object)other.getTicket())) {
            return false;
        }
        if (!this.getClientMessageId().equals((Object)other.getClientMessageId())) {
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
        hash = 19 * hash + SendMessageBody.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + this.getConversationId().hashCode();
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getConversationType();
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getConversationShortId());
        hash = 37 * hash + 4;
        hash = 53 * hash + this.getContent().hashCode();
        if (this.getExtCount() > 0) {
            hash = 37 * hash + 5;
            hash = 53 * hash + this.getExtList().hashCode();
        }
        hash = 37 * hash + 6;
        hash = 53 * hash + this.getMessageType();
        hash = 37 * hash + 7;
        hash = 53 * hash + this.getTicket().hashCode();
        hash = 37 * hash + 8;
        hash = 53 * hash + this.getClientMessageId().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static SendMessageBody parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static SendMessageBody parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static SendMessageBody parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static SendMessageBody parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static SendMessageBody parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static SendMessageBody parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static SendMessageBody parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static SendMessageBody parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static SendMessageBody parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static SendMessageBody parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static SendMessageBody parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static SendMessageBody parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return SendMessageBody.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SendMessageBody prototype) {
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

    public static SendMessageBody getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SendMessageBody> parser() {
        return PARSER;
    }

    public Parser<SendMessageBody> getParserForType() {
        return PARSER;
    }

    @Override
    public SendMessageBody getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements SendMessageBodyOrBuilder {
        private int bitField0_;
        private Object conversationId_ = "";
        private int conversationType_;
        private long conversationShortId_;
        private Object content_ = "";
        private List<ExtList> ext_ = Collections.emptyList();
        private RepeatedFieldBuilderV3<ExtList, ExtList.Builder, ExtListOrBuilder> extBuilder_;
        private int messageType_;
        private Object ticket_ = "";
        private Object clientMessageId_ = "";

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_SendMessageBody_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_SendMessageBody_fieldAccessorTable.ensureFieldAccessorsInitialized(SendMessageBody.class, Builder.class);
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
            this.conversationId_ = "";
            this.conversationType_ = 0;
            this.conversationShortId_ = 0L;
            this.content_ = "";
            if (this.extBuilder_ == null) {
                this.ext_ = Collections.emptyList();
            } else {
                this.ext_ = null;
                this.extBuilder_.clear();
            }
            this.bitField0_ &= 0xFFFFFFEF;
            this.messageType_ = 0;
            this.ticket_ = "";
            this.clientMessageId_ = "";
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_SendMessageBody_descriptor;
        }

        @Override
        public SendMessageBody getDefaultInstanceForType() {
            return SendMessageBody.getDefaultInstance();
        }

        @Override
        public SendMessageBody build() {
            SendMessageBody result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public SendMessageBody buildPartial() {
            SendMessageBody result = new SendMessageBody(this);
            this.buildPartialRepeatedFields(result);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(SendMessageBody result) {
            if (this.extBuilder_ == null) {
                if ((this.bitField0_ & 0x10) != 0) {
                    this.ext_ = Collections.unmodifiableList(this.ext_);
                    this.bitField0_ &= 0xFFFFFFEF;
                }
                result.ext_ = this.ext_;
            } else {
                result.ext_ = this.extBuilder_.build();
            }
        }

        private void buildPartial0(SendMessageBody result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.conversationId_ = this.conversationId_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.conversationType_ = this.conversationType_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.conversationShortId_ = this.conversationShortId_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.content_ = this.content_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.messageType_ = this.messageType_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.ticket_ = this.ticket_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.clientMessageId_ = this.clientMessageId_;
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
            if (other instanceof SendMessageBody) {
                return this.mergeFrom((SendMessageBody)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(SendMessageBody other) {
            if (other == SendMessageBody.getDefaultInstance()) {
                return this;
            }
            if (!other.getConversationId().isEmpty()) {
                this.conversationId_ = other.conversationId_;
                this.bitField0_ |= 1;
                this.onChanged();
            }
            if (other.getConversationType() != 0) {
                this.setConversationType(other.getConversationType());
            }
            if (other.getConversationShortId() != 0L) {
                this.setConversationShortId(other.getConversationShortId());
            }
            if (!other.getContent().isEmpty()) {
                this.content_ = other.content_;
                this.bitField0_ |= 8;
                this.onChanged();
            }
            if (this.extBuilder_ == null) {
                if (!other.ext_.isEmpty()) {
                    if (this.ext_.isEmpty()) {
                        this.ext_ = other.ext_;
                        this.bitField0_ &= 0xFFFFFFEF;
                    } else {
                        this.ensureExtIsMutable();
                        this.ext_.addAll((Collection)other.ext_);
                    }
                    this.onChanged();
                }
            } else if (!other.ext_.isEmpty()) {
                if (this.extBuilder_.isEmpty()) {
                    this.extBuilder_.dispose();
                    this.extBuilder_ = null;
                    this.ext_ = other.ext_;
                    this.bitField0_ &= 0xFFFFFFEF;
                    this.extBuilder_ = alwaysUseFieldBuilders ? this.getExtFieldBuilder() : null;
                } else {
                    this.extBuilder_.addAllMessages((Iterable<ExtList>)other.ext_);
                }
            }
            if (other.getMessageType() != 0) {
                this.setMessageType(other.getMessageType());
            }
            if (!other.getTicket().isEmpty()) {
                this.ticket_ = other.ticket_;
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            if (!other.getClientMessageId().isEmpty()) {
                this.clientMessageId_ = other.clientMessageId_;
                this.bitField0_ |= 0x80;
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
                block16: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block16;
                        }
                        case 10: {
                            this.conversationId_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 1;
                            continue block16;
                        }
                        case 16: {
                            this.conversationType_ = input.readUInt32();
                            this.bitField0_ |= 2;
                            continue block16;
                        }
                        case 24: {
                            this.conversationShortId_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block16;
                        }
                        case 34: {
                            this.content_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 8;
                            continue block16;
                        }
                        case 42: {
                            ExtList m = input.readMessage(ExtList.parser(), extensionRegistry);
                            if (this.extBuilder_ == null) {
                                this.ensureExtIsMutable();
                                this.ext_.add((Object)m);
                                continue block16;
                            }
                            this.extBuilder_.addMessage(m);
                            continue block16;
                        }
                        case 48: {
                            this.messageType_ = input.readUInt32();
                            this.bitField0_ |= 0x20;
                            continue block16;
                        }
                        case 58: {
                            this.ticket_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x40;
                            continue block16;
                        }
                        case 66: {
                            this.clientMessageId_ = input.readStringRequireUtf8();
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
        public String getConversationId() {
            Object ref = this.conversationId_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.conversationId_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getConversationIdBytes() {
            Object ref = this.conversationId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.conversationId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setConversationId(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.conversationId_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearConversationId() {
            this.conversationId_ = SendMessageBody.getDefaultInstance().getConversationId();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
            return this;
        }

        public Builder setConversationIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            SendMessageBody.checkByteStringIsUtf8(value);
            this.conversationId_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        @Override
        public int getConversationType() {
            return this.conversationType_;
        }

        public Builder setConversationType(int value) {
            this.conversationType_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearConversationType() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.conversationType_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public long getConversationShortId() {
            return this.conversationShortId_;
        }

        public Builder setConversationShortId(long value) {
            this.conversationShortId_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearConversationShortId() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.conversationShortId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public String getContent() {
            Object ref = this.content_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.content_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getContentBytes() {
            Object ref = this.content_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.content_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setContent(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.content_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearContent() {
            this.content_ = SendMessageBody.getDefaultInstance().getContent();
            this.bitField0_ &= 0xFFFFFFF7;
            this.onChanged();
            return this;
        }

        public Builder setContentBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            SendMessageBody.checkByteStringIsUtf8(value);
            this.content_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        private void ensureExtIsMutable() {
            if ((this.bitField0_ & 0x10) == 0) {
                this.ext_ = new ArrayList(this.ext_);
                this.bitField0_ |= 0x10;
            }
        }

        @Override
        public List<ExtList> getExtList() {
            if (this.extBuilder_ == null) {
                return Collections.unmodifiableList(this.ext_);
            }
            return this.extBuilder_.getMessageList();
        }

        @Override
        public int getExtCount() {
            if (this.extBuilder_ == null) {
                return this.ext_.size();
            }
            return this.extBuilder_.getCount();
        }

        @Override
        public ExtList getExt(int index) {
            if (this.extBuilder_ == null) {
                return (ExtList)this.ext_.get(index);
            }
            return this.extBuilder_.getMessage(index);
        }

        public Builder setExt(int index, ExtList value) {
            if (this.extBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureExtIsMutable();
                this.ext_.set(index, (Object)value);
                this.onChanged();
            } else {
                this.extBuilder_.setMessage(index, value);
            }
            return this;
        }

        public Builder setExt(int index, ExtList.Builder builderForValue) {
            if (this.extBuilder_ == null) {
                this.ensureExtIsMutable();
                this.ext_.set(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.extBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addExt(ExtList value) {
            if (this.extBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureExtIsMutable();
                this.ext_.add((Object)value);
                this.onChanged();
            } else {
                this.extBuilder_.addMessage(value);
            }
            return this;
        }

        public Builder addExt(int index, ExtList value) {
            if (this.extBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureExtIsMutable();
                this.ext_.add(index, (Object)value);
                this.onChanged();
            } else {
                this.extBuilder_.addMessage(index, value);
            }
            return this;
        }

        public Builder addExt(ExtList.Builder builderForValue) {
            if (this.extBuilder_ == null) {
                this.ensureExtIsMutable();
                this.ext_.add((Object)builderForValue.build());
                this.onChanged();
            } else {
                this.extBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addExt(int index, ExtList.Builder builderForValue) {
            if (this.extBuilder_ == null) {
                this.ensureExtIsMutable();
                this.ext_.add(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.extBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllExt(Iterable<? extends ExtList> values) {
            if (this.extBuilder_ == null) {
                this.ensureExtIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.ext_);
                this.onChanged();
            } else {
                this.extBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearExt() {
            if (this.extBuilder_ == null) {
                this.ext_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFEF;
                this.onChanged();
            } else {
                this.extBuilder_.clear();
            }
            return this;
        }

        public Builder removeExt(int index) {
            if (this.extBuilder_ == null) {
                this.ensureExtIsMutable();
                this.ext_.remove(index);
                this.onChanged();
            } else {
                this.extBuilder_.remove(index);
            }
            return this;
        }

        public ExtList.Builder getExtBuilder(int index) {
            return this.getExtFieldBuilder().getBuilder(index);
        }

        @Override
        public ExtListOrBuilder getExtOrBuilder(int index) {
            if (this.extBuilder_ == null) {
                return (ExtListOrBuilder)this.ext_.get(index);
            }
            return this.extBuilder_.getMessageOrBuilder(index);
        }

        @Override
        public List<? extends ExtListOrBuilder> getExtOrBuilderList() {
            if (this.extBuilder_ != null) {
                return this.extBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.ext_);
        }

        public ExtList.Builder addExtBuilder() {
            return this.getExtFieldBuilder().addBuilder(ExtList.getDefaultInstance());
        }

        public ExtList.Builder addExtBuilder(int index) {
            return this.getExtFieldBuilder().addBuilder(index, ExtList.getDefaultInstance());
        }

        public List<ExtList.Builder> getExtBuilderList() {
            return this.getExtFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<ExtList, ExtList.Builder, ExtListOrBuilder> getExtFieldBuilder() {
            if (this.extBuilder_ == null) {
                this.extBuilder_ = new RepeatedFieldBuilderV3(this.ext_, (this.bitField0_ & 0x10) != 0, this.getParentForChildren(), this.isClean());
                this.ext_ = null;
            }
            return this.extBuilder_;
        }

        @Override
        public int getMessageType() {
            return this.messageType_;
        }

        public Builder setMessageType(int value) {
            this.messageType_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearMessageType() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.messageType_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public String getTicket() {
            Object ref = this.ticket_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.ticket_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getTicketBytes() {
            Object ref = this.ticket_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.ticket_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setTicket(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ticket_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearTicket() {
            this.ticket_ = SendMessageBody.getDefaultInstance().getTicket();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
            return this;
        }

        public Builder setTicketBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            SendMessageBody.checkByteStringIsUtf8(value);
            this.ticket_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        @Override
        public String getClientMessageId() {
            Object ref = this.clientMessageId_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.clientMessageId_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getClientMessageIdBytes() {
            Object ref = this.clientMessageId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.clientMessageId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setClientMessageId(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.clientMessageId_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearClientMessageId() {
            this.clientMessageId_ = SendMessageBody.getDefaultInstance().getClientMessageId();
            this.bitField0_ &= 0xFFFFFF7F;
            this.onChanged();
            return this;
        }

        public Builder setClientMessageIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            SendMessageBody.checkByteStringIsUtf8(value);
            this.clientMessageId_ = value;
            this.bitField0_ |= 0x80;
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


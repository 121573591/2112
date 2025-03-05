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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.RoomRankMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Tiktok;

public final class RoomRankMessage
extends GeneratedMessageV3
implements RoomRankMessageOrBuilder {
    private static final long serialVersionUID = 0L;
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
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new RoomRankMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Tiktok.internal_static_RoomRankMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Tiktok.internal_static_RoomRankMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomRankMessage.class, Builder.class);
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
        this.getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
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
        return this.getUnknownFields().equals(other.getUnknownFields());
    }

    @Override
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hash = 41;
        hash = 19 * hash + RoomRankMessage.getDescriptor().hashCode();
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
        public static final Descriptors.Descriptor getDescriptor() {
            return Tiktok.internal_static_RoomRankMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Tiktok.internal_static_RoomRankMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomRankMessage.class, Builder.class);
        }

        private Builder() {
        }

        private Builder(GeneratedMessageV3.BuilderParent parent) {
            super(parent);
        }

        @Override
        public Builder clear() {
            super.clear();
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Tiktok.internal_static_RoomRankMessage_descriptor;
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
            this.onBuilt();
            return result;
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
                block8: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block8;
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
        public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
            return (Builder)super.setUnknownFields(unknownFields);
        }

        @Override
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            return (Builder)super.mergeUnknownFields(unknownFields);
        }
    }
}


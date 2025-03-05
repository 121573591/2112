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
package tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SCWebHeartbeatAckOuterClass {
    private static final Descriptors.Descriptor internal_static_SCWebHeartbeatAck_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SCWebHeartbeatAck_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private SCWebHeartbeatAckOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        SCWebHeartbeatAckOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nSCWebHeartbeatAck.proto\"?\nSCWebHeartbeatAck\n\ttimestamp (\nclientTimestamp (B<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_SCWebHeartbeatAck_descriptor = (Descriptors.Descriptor)SCWebHeartbeatAckOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_SCWebHeartbeatAck_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SCWebHeartbeatAck_descriptor, new String[]{"Timestamp", "ClientTimestamp"});
    }

    public static final class SCWebHeartbeatAck
    extends GeneratedMessageV3
    implements SCWebHeartbeatAckOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int TIMESTAMP_FIELD_NUMBER = 1;
        private long timestamp_ = 0L;
        public static final int CLIENTTIMESTAMP_FIELD_NUMBER = 2;
        private long clientTimestamp_ = 0L;
        private byte memoizedIsInitialized = (byte)-1;
        private static final SCWebHeartbeatAck DEFAULT_INSTANCE = new SCWebHeartbeatAck();
        private static final Parser<SCWebHeartbeatAck> PARSER = new AbstractParser<SCWebHeartbeatAck>(){

            @Override
            public SCWebHeartbeatAck parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = SCWebHeartbeatAck.newBuilder();
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

        private SCWebHeartbeatAck(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SCWebHeartbeatAck() {
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SCWebHeartbeatAck();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_SCWebHeartbeatAck_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_SCWebHeartbeatAck_fieldAccessorTable.ensureFieldAccessorsInitialized(SCWebHeartbeatAck.class, Builder.class);
        }

        @Override
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override
        public long getClientTimestamp() {
            return this.clientTimestamp_;
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
            if (this.timestamp_ != 0L) {
                output.writeUInt64(1, this.timestamp_);
            }
            if (this.clientTimestamp_ != 0L) {
                output.writeUInt64(2, this.clientTimestamp_);
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
            if (this.timestamp_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(1, this.timestamp_);
            }
            if (this.clientTimestamp_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(2, this.clientTimestamp_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SCWebHeartbeatAck)) {
                return super.equals(obj);
            }
            SCWebHeartbeatAck other = (SCWebHeartbeatAck)obj;
            if (this.getTimestamp() != other.getTimestamp()) {
                return false;
            }
            if (this.getClientTimestamp() != other.getClientTimestamp()) {
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
            hash = 19 * hash + SCWebHeartbeatAck.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getTimestamp());
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashLong(this.getClientTimestamp());
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static SCWebHeartbeatAck parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebHeartbeatAck parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebHeartbeatAck parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebHeartbeatAck parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebHeartbeatAck parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebHeartbeatAck parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebHeartbeatAck parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCWebHeartbeatAck parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCWebHeartbeatAck parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SCWebHeartbeatAck parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCWebHeartbeatAck parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCWebHeartbeatAck parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return SCWebHeartbeatAck.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SCWebHeartbeatAck prototype) {
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

        public static SCWebHeartbeatAck getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SCWebHeartbeatAck> parser() {
            return PARSER;
        }

        public Parser<SCWebHeartbeatAck> getParserForType() {
            return PARSER;
        }

        @Override
        public SCWebHeartbeatAck getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements SCWebHeartbeatAckOrBuilder {
            private int bitField0_;
            private long timestamp_;
            private long clientTimestamp_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_SCWebHeartbeatAck_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_SCWebHeartbeatAck_fieldAccessorTable.ensureFieldAccessorsInitialized(SCWebHeartbeatAck.class, Builder.class);
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
                this.timestamp_ = 0L;
                this.clientTimestamp_ = 0L;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_SCWebHeartbeatAck_descriptor;
            }

            @Override
            public SCWebHeartbeatAck getDefaultInstanceForType() {
                return SCWebHeartbeatAck.getDefaultInstance();
            }

            @Override
            public SCWebHeartbeatAck build() {
                SCWebHeartbeatAck result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SCWebHeartbeatAck buildPartial() {
                SCWebHeartbeatAck result = new SCWebHeartbeatAck(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(SCWebHeartbeatAck result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.timestamp_ = this.timestamp_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.clientTimestamp_ = this.clientTimestamp_;
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
                if (other instanceof SCWebHeartbeatAck) {
                    return this.mergeFrom((SCWebHeartbeatAck)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SCWebHeartbeatAck other) {
                if (other == SCWebHeartbeatAck.getDefaultInstance()) {
                    return this;
                }
                if (other.getTimestamp() != 0L) {
                    this.setTimestamp(other.getTimestamp());
                }
                if (other.getClientTimestamp() != 0L) {
                    this.setClientTimestamp(other.getClientTimestamp());
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
                            case 8: {
                                this.timestamp_ = input.readUInt64();
                                this.bitField0_ |= 1;
                                continue block10;
                            }
                            case 16: {
                                this.clientTimestamp_ = input.readUInt64();
                                this.bitField0_ |= 2;
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
            public long getTimestamp() {
                return this.timestamp_;
            }

            public Builder setTimestamp(long value) {
                this.timestamp_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.timestamp_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public long getClientTimestamp() {
                return this.clientTimestamp_;
            }

            public Builder setClientTimestamp(long value) {
                this.clientTimestamp_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearClientTimestamp() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.clientTimestamp_ = 0L;
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

    public static interface SCWebHeartbeatAckOrBuilder
    extends MessageOrBuilder {
        public long getTimestamp();

        public long getClientTimestamp();
    }
}


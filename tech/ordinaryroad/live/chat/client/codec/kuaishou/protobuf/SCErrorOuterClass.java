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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class SCErrorOuterClass {
    private static final Descriptors.Descriptor internal_static_SCError_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SCError_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private SCErrorOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        SCErrorOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\n\rSCError.proto\"5\nSCError\f\ncode (\r\nmsg (\t\nsubCode (\rB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_SCError_descriptor = (Descriptors.Descriptor)SCErrorOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_SCError_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SCError_descriptor, new String[]{"Code", "Msg", "SubCode"});
    }

    public static final class SCError
    extends GeneratedMessageV3
    implements SCErrorOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int CODE_FIELD_NUMBER = 1;
        private int code_ = 0;
        public static final int MSG_FIELD_NUMBER = 2;
        private volatile Object msg_ = "";
        public static final int SUBCODE_FIELD_NUMBER = 3;
        private int subCode_ = 0;
        private byte memoizedIsInitialized = (byte)-1;
        private static final SCError DEFAULT_INSTANCE = new SCError();
        private static final Parser<SCError> PARSER = new AbstractParser<SCError>(){

            @Override
            public SCError parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = SCError.newBuilder();
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

        private SCError(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SCError() {
            this.msg_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SCError();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_SCError_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_SCError_fieldAccessorTable.ensureFieldAccessorsInitialized(SCError.class, Builder.class);
        }

        @Override
        public int getCode() {
            return this.code_;
        }

        @Override
        public String getMsg() {
            Object ref = this.msg_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.msg_ = s;
            return s;
        }

        @Override
        public ByteString getMsgBytes() {
            Object ref = this.msg_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.msg_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public int getSubCode() {
            return this.subCode_;
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
            if (this.code_ != 0) {
                output.writeUInt32(1, this.code_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                GeneratedMessageV3.writeString(output, 2, this.msg_);
            }
            if (this.subCode_ != 0) {
                output.writeUInt32(3, this.subCode_);
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
            if (this.code_ != 0) {
                size += CodedOutputStream.computeUInt32Size(1, this.code_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.msg_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.msg_);
            }
            if (this.subCode_ != 0) {
                size += CodedOutputStream.computeUInt32Size(3, this.subCode_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SCError)) {
                return super.equals(obj);
            }
            SCError other = (SCError)obj;
            if (this.getCode() != other.getCode()) {
                return false;
            }
            if (!this.getMsg().equals((Object)other.getMsg())) {
                return false;
            }
            if (this.getSubCode() != other.getSubCode()) {
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
            hash = 19 * hash + SCError.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCode();
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getMsg().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getSubCode();
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static SCError parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCError parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCError parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCError parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCError parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCError parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCError parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCError parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCError parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SCError parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCError parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCError parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return SCError.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SCError prototype) {
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

        public static SCError getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SCError> parser() {
            return PARSER;
        }

        public Parser<SCError> getParserForType() {
            return PARSER;
        }

        @Override
        public SCError getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements SCErrorOrBuilder {
            private int bitField0_;
            private int code_;
            private Object msg_ = "";
            private int subCode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_SCError_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_SCError_fieldAccessorTable.ensureFieldAccessorsInitialized(SCError.class, Builder.class);
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
                this.code_ = 0;
                this.msg_ = "";
                this.subCode_ = 0;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_SCError_descriptor;
            }

            @Override
            public SCError getDefaultInstanceForType() {
                return SCError.getDefaultInstance();
            }

            @Override
            public SCError build() {
                SCError result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SCError buildPartial() {
                SCError result = new SCError(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(SCError result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.code_ = this.code_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.msg_ = this.msg_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.subCode_ = this.subCode_;
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
                if (other instanceof SCError) {
                    return this.mergeFrom((SCError)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SCError other) {
                if (other == SCError.getDefaultInstance()) {
                    return this;
                }
                if (other.getCode() != 0) {
                    this.setCode(other.getCode());
                }
                if (!other.getMsg().isEmpty()) {
                    this.msg_ = other.msg_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (other.getSubCode() != 0) {
                    this.setSubCode(other.getSubCode());
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
                            case 8: {
                                this.code_ = input.readUInt32();
                                this.bitField0_ |= 1;
                                continue block11;
                            }
                            case 18: {
                                this.msg_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 24: {
                                this.subCode_ = input.readUInt32();
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
            public int getCode() {
                return this.code_;
            }

            public Builder setCode(int value) {
                this.code_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearCode() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.code_ = 0;
                this.onChanged();
                return this;
            }

            @Override
            public String getMsg() {
                Object ref = this.msg_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.msg_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getMsgBytes() {
                Object ref = this.msg_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.msg_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setMsg(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.msg_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearMsg() {
                this.msg_ = SCError.getDefaultInstance().getMsg();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setMsgBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SCError.checkByteStringIsUtf8(value);
                this.msg_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public int getSubCode() {
                return this.subCode_;
            }

            public Builder setSubCode(int value) {
                this.subCode_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearSubCode() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.subCode_ = 0;
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

    public static interface SCErrorOrBuilder
    extends MessageOrBuilder {
        public int getCode();

        public String getMsg();

        public ByteString getMsgBytes();

        public int getSubCode();
    }
}


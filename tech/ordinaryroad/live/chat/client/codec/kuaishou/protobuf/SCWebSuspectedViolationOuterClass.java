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

public final class SCWebSuspectedViolationOuterClass {
    private static final Descriptors.Descriptor internal_static_SCWebSuspectedViolation_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SCWebSuspectedViolation_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private SCWebSuspectedViolationOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        SCWebSuspectedViolationOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nSCWebSuspectedViolation.proto\"5\nSCWebSuspectedViolation\nsuspectedViolation (\bB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_SCWebSuspectedViolation_descriptor = (Descriptors.Descriptor)SCWebSuspectedViolationOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_SCWebSuspectedViolation_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SCWebSuspectedViolation_descriptor, new String[]{"SuspectedViolation"});
    }

    public static final class SCWebSuspectedViolation
    extends GeneratedMessageV3
    implements SCWebSuspectedViolationOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int SUSPECTEDVIOLATION_FIELD_NUMBER = 1;
        private boolean suspectedViolation_ = false;
        private byte memoizedIsInitialized = (byte)-1;
        private static final SCWebSuspectedViolation DEFAULT_INSTANCE = new SCWebSuspectedViolation();
        private static final Parser<SCWebSuspectedViolation> PARSER = new AbstractParser<SCWebSuspectedViolation>(){

            @Override
            public SCWebSuspectedViolation parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = SCWebSuspectedViolation.newBuilder();
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

        private SCWebSuspectedViolation(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SCWebSuspectedViolation() {
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SCWebSuspectedViolation();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_SCWebSuspectedViolation_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_SCWebSuspectedViolation_fieldAccessorTable.ensureFieldAccessorsInitialized(SCWebSuspectedViolation.class, Builder.class);
        }

        @Override
        public boolean getSuspectedViolation() {
            return this.suspectedViolation_;
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
            if (this.suspectedViolation_) {
                output.writeBool(1, this.suspectedViolation_);
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
            if (this.suspectedViolation_) {
                size += CodedOutputStream.computeBoolSize(1, this.suspectedViolation_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SCWebSuspectedViolation)) {
                return super.equals(obj);
            }
            SCWebSuspectedViolation other = (SCWebSuspectedViolation)obj;
            if (this.getSuspectedViolation() != other.getSuspectedViolation()) {
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
            hash = 19 * hash + SCWebSuspectedViolation.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashBoolean(this.getSuspectedViolation());
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static SCWebSuspectedViolation parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebSuspectedViolation parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebSuspectedViolation parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebSuspectedViolation parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebSuspectedViolation parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebSuspectedViolation parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebSuspectedViolation parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCWebSuspectedViolation parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCWebSuspectedViolation parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SCWebSuspectedViolation parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCWebSuspectedViolation parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCWebSuspectedViolation parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return SCWebSuspectedViolation.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SCWebSuspectedViolation prototype) {
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

        public static SCWebSuspectedViolation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SCWebSuspectedViolation> parser() {
            return PARSER;
        }

        public Parser<SCWebSuspectedViolation> getParserForType() {
            return PARSER;
        }

        @Override
        public SCWebSuspectedViolation getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements SCWebSuspectedViolationOrBuilder {
            private int bitField0_;
            private boolean suspectedViolation_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_SCWebSuspectedViolation_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_SCWebSuspectedViolation_fieldAccessorTable.ensureFieldAccessorsInitialized(SCWebSuspectedViolation.class, Builder.class);
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
                this.suspectedViolation_ = false;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_SCWebSuspectedViolation_descriptor;
            }

            @Override
            public SCWebSuspectedViolation getDefaultInstanceForType() {
                return SCWebSuspectedViolation.getDefaultInstance();
            }

            @Override
            public SCWebSuspectedViolation build() {
                SCWebSuspectedViolation result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SCWebSuspectedViolation buildPartial() {
                SCWebSuspectedViolation result = new SCWebSuspectedViolation(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(SCWebSuspectedViolation result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.suspectedViolation_ = this.suspectedViolation_;
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
                if (other instanceof SCWebSuspectedViolation) {
                    return this.mergeFrom((SCWebSuspectedViolation)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SCWebSuspectedViolation other) {
                if (other == SCWebSuspectedViolation.getDefaultInstance()) {
                    return this;
                }
                if (other.getSuspectedViolation()) {
                    this.setSuspectedViolation(other.getSuspectedViolation());
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
                    block9: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block9;
                            }
                            case 8: {
                                this.suspectedViolation_ = input.readBool();
                                this.bitField0_ |= 1;
                                continue block9;
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
            public boolean getSuspectedViolation() {
                return this.suspectedViolation_;
            }

            public Builder setSuspectedViolation(boolean value) {
                this.suspectedViolation_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearSuspectedViolation() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.suspectedViolation_ = false;
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

    public static interface SCWebSuspectedViolationOrBuilder
    extends MessageOrBuilder {
        public boolean getSuspectedViolation();
    }
}


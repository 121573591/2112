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
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.WebUserPauseTypeOuterClass;

public final class CSWebUserPauseOuterClass {
    private static final Descriptors.Descriptor internal_static_CSWebUserPause_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CSWebUserPause_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private CSWebUserPauseOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        CSWebUserPauseOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nCSWebUserPause.protoWebUserPauseType.proto\"D\nCSWebUserPause\f\ntime ($\n\tpauseType (2.WebUserPauseTypeB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{WebUserPauseTypeOuterClass.getDescriptor()});
        internal_static_CSWebUserPause_descriptor = (Descriptors.Descriptor)CSWebUserPauseOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_CSWebUserPause_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CSWebUserPause_descriptor, new String[]{"Time", "PauseType"});
        WebUserPauseTypeOuterClass.getDescriptor();
    }

    public static final class CSWebUserPause
    extends GeneratedMessageV3
    implements CSWebUserPauseOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int TIME_FIELD_NUMBER = 1;
        private long time_ = 0L;
        public static final int PAUSETYPE_FIELD_NUMBER = 2;
        private int pauseType_ = 0;
        private byte memoizedIsInitialized = (byte)-1;
        private static final CSWebUserPause DEFAULT_INSTANCE = new CSWebUserPause();
        private static final Parser<CSWebUserPause> PARSER = new AbstractParser<CSWebUserPause>(){

            @Override
            public CSWebUserPause parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = CSWebUserPause.newBuilder();
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

        private CSWebUserPause(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private CSWebUserPause() {
            this.pauseType_ = 0;
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CSWebUserPause();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_CSWebUserPause_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_CSWebUserPause_fieldAccessorTable.ensureFieldAccessorsInitialized(CSWebUserPause.class, Builder.class);
        }

        @Override
        public long getTime() {
            return this.time_;
        }

        @Override
        public int getPauseTypeValue() {
            return this.pauseType_;
        }

        @Override
        public WebUserPauseTypeOuterClass.WebUserPauseType getPauseType() {
            WebUserPauseTypeOuterClass.WebUserPauseType result = WebUserPauseTypeOuterClass.WebUserPauseType.forNumber(this.pauseType_);
            return result == null ? WebUserPauseTypeOuterClass.WebUserPauseType.UNRECOGNIZED : result;
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
            if (this.time_ != 0L) {
                output.writeUInt64(1, this.time_);
            }
            if (this.pauseType_ != WebUserPauseTypeOuterClass.WebUserPauseType.UNKNOWN_USER_PAUSE_TYPE.getNumber()) {
                output.writeEnum(2, this.pauseType_);
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
            if (this.time_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(1, this.time_);
            }
            if (this.pauseType_ != WebUserPauseTypeOuterClass.WebUserPauseType.UNKNOWN_USER_PAUSE_TYPE.getNumber()) {
                size += CodedOutputStream.computeEnumSize(2, this.pauseType_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CSWebUserPause)) {
                return super.equals(obj);
            }
            CSWebUserPause other = (CSWebUserPause)obj;
            if (this.getTime() != other.getTime()) {
                return false;
            }
            if (this.pauseType_ != other.pauseType_) {
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
            hash = 19 * hash + CSWebUserPause.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getTime());
            hash = 37 * hash + 2;
            hash = 53 * hash + this.pauseType_;
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static CSWebUserPause parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CSWebUserPause parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CSWebUserPause parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CSWebUserPause parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CSWebUserPause parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CSWebUserPause parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CSWebUserPause parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CSWebUserPause parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CSWebUserPause parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CSWebUserPause parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CSWebUserPause parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CSWebUserPause parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return CSWebUserPause.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CSWebUserPause prototype) {
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

        public static CSWebUserPause getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CSWebUserPause> parser() {
            return PARSER;
        }

        public Parser<CSWebUserPause> getParserForType() {
            return PARSER;
        }

        @Override
        public CSWebUserPause getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements CSWebUserPauseOrBuilder {
            private int bitField0_;
            private long time_;
            private int pauseType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_CSWebUserPause_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_CSWebUserPause_fieldAccessorTable.ensureFieldAccessorsInitialized(CSWebUserPause.class, Builder.class);
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
                this.time_ = 0L;
                this.pauseType_ = 0;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_CSWebUserPause_descriptor;
            }

            @Override
            public CSWebUserPause getDefaultInstanceForType() {
                return CSWebUserPause.getDefaultInstance();
            }

            @Override
            public CSWebUserPause build() {
                CSWebUserPause result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public CSWebUserPause buildPartial() {
                CSWebUserPause result = new CSWebUserPause(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(CSWebUserPause result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.time_ = this.time_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.pauseType_ = this.pauseType_;
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
                if (other instanceof CSWebUserPause) {
                    return this.mergeFrom((CSWebUserPause)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CSWebUserPause other) {
                if (other == CSWebUserPause.getDefaultInstance()) {
                    return this;
                }
                if (other.getTime() != 0L) {
                    this.setTime(other.getTime());
                }
                if (other.pauseType_ != 0) {
                    this.setPauseTypeValue(other.getPauseTypeValue());
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
                                this.time_ = input.readUInt64();
                                this.bitField0_ |= 1;
                                continue block10;
                            }
                            case 16: {
                                this.pauseType_ = input.readEnum();
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
            public long getTime() {
                return this.time_;
            }

            public Builder setTime(long value) {
                this.time_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearTime() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.time_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public int getPauseTypeValue() {
                return this.pauseType_;
            }

            public Builder setPauseTypeValue(int value) {
                this.pauseType_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public WebUserPauseTypeOuterClass.WebUserPauseType getPauseType() {
                WebUserPauseTypeOuterClass.WebUserPauseType result = WebUserPauseTypeOuterClass.WebUserPauseType.forNumber(this.pauseType_);
                return result == null ? WebUserPauseTypeOuterClass.WebUserPauseType.UNRECOGNIZED : result;
            }

            public Builder setPauseType(WebUserPauseTypeOuterClass.WebUserPauseType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.pauseType_ = value.getNumber();
                this.onChanged();
                return this;
            }

            public Builder clearPauseType() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.pauseType_ = 0;
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

    public static interface CSWebUserPauseOrBuilder
    extends MessageOrBuilder {
        public long getTime();

        public int getPauseTypeValue();

        public WebUserPauseTypeOuterClass.WebUserPauseType getPauseType();
    }
}


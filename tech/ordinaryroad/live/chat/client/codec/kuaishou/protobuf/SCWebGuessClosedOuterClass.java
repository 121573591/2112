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

public final class SCWebGuessClosedOuterClass {
    private static final Descriptors.Descriptor internal_static_SCWebGuessClosed_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SCWebGuessClosed_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private SCWebGuessClosedOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        SCWebGuessClosedOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nSCWebGuessClosed.proto\"P\nSCWebGuessClosed\f\ntime (\nguessId (\t\ndisplayMaxDelayMillis (B<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_SCWebGuessClosed_descriptor = (Descriptors.Descriptor)SCWebGuessClosedOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_SCWebGuessClosed_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SCWebGuessClosed_descriptor, new String[]{"Time", "GuessId", "DisplayMaxDelayMillis"});
    }

    public static final class SCWebGuessClosed
    extends GeneratedMessageV3
    implements SCWebGuessClosedOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int TIME_FIELD_NUMBER = 1;
        private long time_ = 0L;
        public static final int GUESSID_FIELD_NUMBER = 2;
        private volatile Object guessId_ = "";
        public static final int DISPLAYMAXDELAYMILLIS_FIELD_NUMBER = 3;
        private long displayMaxDelayMillis_ = 0L;
        private byte memoizedIsInitialized = (byte)-1;
        private static final SCWebGuessClosed DEFAULT_INSTANCE = new SCWebGuessClosed();
        private static final Parser<SCWebGuessClosed> PARSER = new AbstractParser<SCWebGuessClosed>(){

            @Override
            public SCWebGuessClosed parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = SCWebGuessClosed.newBuilder();
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

        private SCWebGuessClosed(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SCWebGuessClosed() {
            this.guessId_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SCWebGuessClosed();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_SCWebGuessClosed_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_SCWebGuessClosed_fieldAccessorTable.ensureFieldAccessorsInitialized(SCWebGuessClosed.class, Builder.class);
        }

        @Override
        public long getTime() {
            return this.time_;
        }

        @Override
        public String getGuessId() {
            Object ref = this.guessId_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.guessId_ = s;
            return s;
        }

        @Override
        public ByteString getGuessIdBytes() {
            Object ref = this.guessId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.guessId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public long getDisplayMaxDelayMillis() {
            return this.displayMaxDelayMillis_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.guessId_)) {
                GeneratedMessageV3.writeString(output, 2, this.guessId_);
            }
            if (this.displayMaxDelayMillis_ != 0L) {
                output.writeUInt64(3, this.displayMaxDelayMillis_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.guessId_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.guessId_);
            }
            if (this.displayMaxDelayMillis_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(3, this.displayMaxDelayMillis_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SCWebGuessClosed)) {
                return super.equals(obj);
            }
            SCWebGuessClosed other = (SCWebGuessClosed)obj;
            if (this.getTime() != other.getTime()) {
                return false;
            }
            if (!this.getGuessId().equals((Object)other.getGuessId())) {
                return false;
            }
            if (this.getDisplayMaxDelayMillis() != other.getDisplayMaxDelayMillis()) {
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
            hash = 19 * hash + SCWebGuessClosed.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getTime());
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getGuessId().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getDisplayMaxDelayMillis());
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static SCWebGuessClosed parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebGuessClosed parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebGuessClosed parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebGuessClosed parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebGuessClosed parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SCWebGuessClosed parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SCWebGuessClosed parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCWebGuessClosed parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCWebGuessClosed parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SCWebGuessClosed parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SCWebGuessClosed parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SCWebGuessClosed parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return SCWebGuessClosed.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SCWebGuessClosed prototype) {
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

        public static SCWebGuessClosed getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SCWebGuessClosed> parser() {
            return PARSER;
        }

        public Parser<SCWebGuessClosed> getParserForType() {
            return PARSER;
        }

        @Override
        public SCWebGuessClosed getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements SCWebGuessClosedOrBuilder {
            private int bitField0_;
            private long time_;
            private Object guessId_ = "";
            private long displayMaxDelayMillis_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_SCWebGuessClosed_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_SCWebGuessClosed_fieldAccessorTable.ensureFieldAccessorsInitialized(SCWebGuessClosed.class, Builder.class);
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
                this.guessId_ = "";
                this.displayMaxDelayMillis_ = 0L;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_SCWebGuessClosed_descriptor;
            }

            @Override
            public SCWebGuessClosed getDefaultInstanceForType() {
                return SCWebGuessClosed.getDefaultInstance();
            }

            @Override
            public SCWebGuessClosed build() {
                SCWebGuessClosed result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SCWebGuessClosed buildPartial() {
                SCWebGuessClosed result = new SCWebGuessClosed(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(SCWebGuessClosed result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.time_ = this.time_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.guessId_ = this.guessId_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.displayMaxDelayMillis_ = this.displayMaxDelayMillis_;
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
                if (other instanceof SCWebGuessClosed) {
                    return this.mergeFrom((SCWebGuessClosed)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SCWebGuessClosed other) {
                if (other == SCWebGuessClosed.getDefaultInstance()) {
                    return this;
                }
                if (other.getTime() != 0L) {
                    this.setTime(other.getTime());
                }
                if (!other.getGuessId().isEmpty()) {
                    this.guessId_ = other.guessId_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (other.getDisplayMaxDelayMillis() != 0L) {
                    this.setDisplayMaxDelayMillis(other.getDisplayMaxDelayMillis());
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
                                this.time_ = input.readUInt64();
                                this.bitField0_ |= 1;
                                continue block11;
                            }
                            case 18: {
                                this.guessId_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 24: {
                                this.displayMaxDelayMillis_ = input.readUInt64();
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
            public String getGuessId() {
                Object ref = this.guessId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.guessId_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getGuessIdBytes() {
                Object ref = this.guessId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.guessId_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setGuessId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.guessId_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearGuessId() {
                this.guessId_ = SCWebGuessClosed.getDefaultInstance().getGuessId();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setGuessIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SCWebGuessClosed.checkByteStringIsUtf8(value);
                this.guessId_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public long getDisplayMaxDelayMillis() {
                return this.displayMaxDelayMillis_;
            }

            public Builder setDisplayMaxDelayMillis(long value) {
                this.displayMaxDelayMillis_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearDisplayMaxDelayMillis() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.displayMaxDelayMillis_ = 0L;
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

    public static interface SCWebGuessClosedOrBuilder
    extends MessageOrBuilder {
        public long getTime();

        public String getGuessId();

        public ByteString getGuessIdBytes();

        public long getDisplayMaxDelayMillis();
    }
}


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

public final class SimpleUserInfoOuterClass {
    private static final Descriptors.Descriptor internal_static_SimpleUserInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SimpleUserInfo_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private SimpleUserInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        SimpleUserInfoOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nSimpleUserInfo.proto\"H\nSimpleUserInfo\nprincipalId (\t\n\buserName (\t\nheadUrl (\tB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_SimpleUserInfo_descriptor = (Descriptors.Descriptor)SimpleUserInfoOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_SimpleUserInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SimpleUserInfo_descriptor, new String[]{"PrincipalId", "UserName", "HeadUrl"});
    }

    public static final class SimpleUserInfo
    extends GeneratedMessageV3
    implements SimpleUserInfoOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int PRINCIPALID_FIELD_NUMBER = 1;
        private volatile Object principalId_ = "";
        public static final int USERNAME_FIELD_NUMBER = 2;
        private volatile Object userName_ = "";
        public static final int HEADURL_FIELD_NUMBER = 3;
        private volatile Object headUrl_ = "";
        private byte memoizedIsInitialized = (byte)-1;
        private static final SimpleUserInfo DEFAULT_INSTANCE = new SimpleUserInfo();
        private static final Parser<SimpleUserInfo> PARSER = new AbstractParser<SimpleUserInfo>(){

            @Override
            public SimpleUserInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = SimpleUserInfo.newBuilder();
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

        private SimpleUserInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private SimpleUserInfo() {
            this.principalId_ = "";
            this.userName_ = "";
            this.headUrl_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SimpleUserInfo();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_SimpleUserInfo_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_SimpleUserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SimpleUserInfo.class, Builder.class);
        }

        @Override
        public String getPrincipalId() {
            Object ref = this.principalId_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.principalId_ = s;
            return s;
        }

        @Override
        public ByteString getPrincipalIdBytes() {
            Object ref = this.principalId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.principalId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public String getUserName() {
            Object ref = this.userName_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.userName_ = s;
            return s;
        }

        @Override
        public ByteString getUserNameBytes() {
            Object ref = this.userName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.userName_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public String getHeadUrl() {
            Object ref = this.headUrl_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.headUrl_ = s;
            return s;
        }

        @Override
        public ByteString getHeadUrlBytes() {
            Object ref = this.headUrl_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.headUrl_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.principalId_)) {
                GeneratedMessageV3.writeString(output, 1, this.principalId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userName_)) {
                GeneratedMessageV3.writeString(output, 2, this.userName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.headUrl_)) {
                GeneratedMessageV3.writeString(output, 3, this.headUrl_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.principalId_)) {
                size += GeneratedMessageV3.computeStringSize(1, this.principalId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userName_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.userName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.headUrl_)) {
                size += GeneratedMessageV3.computeStringSize(3, this.headUrl_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SimpleUserInfo)) {
                return super.equals(obj);
            }
            SimpleUserInfo other = (SimpleUserInfo)obj;
            if (!this.getPrincipalId().equals((Object)other.getPrincipalId())) {
                return false;
            }
            if (!this.getUserName().equals((Object)other.getUserName())) {
                return false;
            }
            if (!this.getHeadUrl().equals((Object)other.getHeadUrl())) {
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
            hash = 19 * hash + SimpleUserInfo.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getPrincipalId().hashCode();
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUserName().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getHeadUrl().hashCode();
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static SimpleUserInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SimpleUserInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SimpleUserInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SimpleUserInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SimpleUserInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SimpleUserInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SimpleUserInfo parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SimpleUserInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SimpleUserInfo parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SimpleUserInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SimpleUserInfo parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SimpleUserInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return SimpleUserInfo.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SimpleUserInfo prototype) {
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

        public static SimpleUserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SimpleUserInfo> parser() {
            return PARSER;
        }

        public Parser<SimpleUserInfo> getParserForType() {
            return PARSER;
        }

        @Override
        public SimpleUserInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements SimpleUserInfoOrBuilder {
            private int bitField0_;
            private Object principalId_ = "";
            private Object userName_ = "";
            private Object headUrl_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_SimpleUserInfo_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_SimpleUserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SimpleUserInfo.class, Builder.class);
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
                this.principalId_ = "";
                this.userName_ = "";
                this.headUrl_ = "";
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_SimpleUserInfo_descriptor;
            }

            @Override
            public SimpleUserInfo getDefaultInstanceForType() {
                return SimpleUserInfo.getDefaultInstance();
            }

            @Override
            public SimpleUserInfo build() {
                SimpleUserInfo result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public SimpleUserInfo buildPartial() {
                SimpleUserInfo result = new SimpleUserInfo(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(SimpleUserInfo result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.principalId_ = this.principalId_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.userName_ = this.userName_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.headUrl_ = this.headUrl_;
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
                if (other instanceof SimpleUserInfo) {
                    return this.mergeFrom((SimpleUserInfo)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SimpleUserInfo other) {
                if (other == SimpleUserInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getPrincipalId().isEmpty()) {
                    this.principalId_ = other.principalId_;
                    this.bitField0_ |= 1;
                    this.onChanged();
                }
                if (!other.getUserName().isEmpty()) {
                    this.userName_ = other.userName_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (!other.getHeadUrl().isEmpty()) {
                    this.headUrl_ = other.headUrl_;
                    this.bitField0_ |= 4;
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
                    block11: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block11;
                            }
                            case 10: {
                                this.principalId_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                                continue block11;
                            }
                            case 18: {
                                this.userName_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 26: {
                                this.headUrl_ = input.readStringRequireUtf8();
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
            public String getPrincipalId() {
                Object ref = this.principalId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.principalId_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getPrincipalIdBytes() {
                Object ref = this.principalId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.principalId_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setPrincipalId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.principalId_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearPrincipalId() {
                this.principalId_ = SimpleUserInfo.getDefaultInstance().getPrincipalId();
                this.bitField0_ &= 0xFFFFFFFE;
                this.onChanged();
                return this;
            }

            public Builder setPrincipalIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SimpleUserInfo.checkByteStringIsUtf8(value);
                this.principalId_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            @Override
            public String getUserName() {
                Object ref = this.userName_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.userName_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getUserNameBytes() {
                Object ref = this.userName_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.userName_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setUserName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.userName_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearUserName() {
                this.userName_ = SimpleUserInfo.getDefaultInstance().getUserName();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setUserNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SimpleUserInfo.checkByteStringIsUtf8(value);
                this.userName_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public String getHeadUrl() {
                Object ref = this.headUrl_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.headUrl_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getHeadUrlBytes() {
                Object ref = this.headUrl_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.headUrl_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setHeadUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.headUrl_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearHeadUrl() {
                this.headUrl_ = SimpleUserInfo.getDefaultInstance().getHeadUrl();
                this.bitField0_ &= 0xFFFFFFFB;
                this.onChanged();
                return this;
            }

            public Builder setHeadUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                SimpleUserInfo.checkByteStringIsUtf8(value);
                this.headUrl_ = value;
                this.bitField0_ |= 4;
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

    public static interface SimpleUserInfoOrBuilder
    extends MessageOrBuilder {
        public String getPrincipalId();

        public ByteString getPrincipalIdBytes();

        public String getUserName();

        public ByteString getUserNameBytes();

        public String getHeadUrl();

        public ByteString getHeadUrlBytes();
    }
}


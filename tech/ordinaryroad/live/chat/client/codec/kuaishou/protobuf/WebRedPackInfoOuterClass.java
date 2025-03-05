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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.SimpleUserInfoOuterClass;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.WebRedPackCoverTypeOuterClass;

public final class WebRedPackInfoOuterClass {
    private static final Descriptors.Descriptor internal_static_WebRedPackInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WebRedPackInfo_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private WebRedPackInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        WebRedPackInfoOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nWebRedPackInfo.protoSimpleUserInfo.protoWebRedPackCoverType.proto\"\nWebRedPackInfo\n\nid (\t\nauthor (2.SimpleUserInfo\nbalance (\n\bopenTime (\ncurrentTime (\n\tgrabToken (\t\nneedSendRequest (\b\nrequestDelayMillis\b (\nluckiestDelayMillis\t ('\n\tcoverType\n (2.WebRedPackCoverTypeB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{SimpleUserInfoOuterClass.getDescriptor(), WebRedPackCoverTypeOuterClass.getDescriptor()});
        internal_static_WebRedPackInfo_descriptor = (Descriptors.Descriptor)WebRedPackInfoOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_WebRedPackInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WebRedPackInfo_descriptor, new String[]{"Id", "Author", "Balance", "OpenTime", "CurrentTime", "GrabToken", "NeedSendRequest", "RequestDelayMillis", "LuckiestDelayMillis", "CoverType"});
        SimpleUserInfoOuterClass.getDescriptor();
        WebRedPackCoverTypeOuterClass.getDescriptor();
    }

    public static final class WebRedPackInfo
    extends GeneratedMessageV3
    implements WebRedPackInfoOrBuilder {
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private volatile Object id_ = "";
        public static final int AUTHOR_FIELD_NUMBER = 2;
        private SimpleUserInfoOuterClass.SimpleUserInfo author_;
        public static final int BALANCE_FIELD_NUMBER = 3;
        private long balance_ = 0L;
        public static final int OPENTIME_FIELD_NUMBER = 4;
        private long openTime_ = 0L;
        public static final int CURRENTTIME_FIELD_NUMBER = 5;
        private long currentTime_ = 0L;
        public static final int GRABTOKEN_FIELD_NUMBER = 6;
        private volatile Object grabToken_ = "";
        public static final int NEEDSENDREQUEST_FIELD_NUMBER = 7;
        private boolean needSendRequest_ = false;
        public static final int REQUESTDELAYMILLIS_FIELD_NUMBER = 8;
        private long requestDelayMillis_ = 0L;
        public static final int LUCKIESTDELAYMILLIS_FIELD_NUMBER = 9;
        private long luckiestDelayMillis_ = 0L;
        public static final int COVERTYPE_FIELD_NUMBER = 10;
        private int coverType_ = 0;
        private byte memoizedIsInitialized = (byte)-1;
        private static final WebRedPackInfo DEFAULT_INSTANCE = new WebRedPackInfo();
        private static final Parser<WebRedPackInfo> PARSER = new AbstractParser<WebRedPackInfo>(){

            @Override
            public WebRedPackInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = WebRedPackInfo.newBuilder();
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

        private WebRedPackInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private WebRedPackInfo() {
            this.id_ = "";
            this.grabToken_ = "";
            this.coverType_ = 0;
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WebRedPackInfo();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_WebRedPackInfo_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_WebRedPackInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WebRedPackInfo.class, Builder.class);
        }

        @Override
        public String getId() {
            Object ref = this.id_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.id_ = s;
            return s;
        }

        @Override
        public ByteString getIdBytes() {
            Object ref = this.id_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.id_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public boolean hasAuthor() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public SimpleUserInfoOuterClass.SimpleUserInfo getAuthor() {
            return this.author_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.author_;
        }

        @Override
        public SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder getAuthorOrBuilder() {
            return this.author_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.author_;
        }

        @Override
        public long getBalance() {
            return this.balance_;
        }

        @Override
        public long getOpenTime() {
            return this.openTime_;
        }

        @Override
        public long getCurrentTime() {
            return this.currentTime_;
        }

        @Override
        public String getGrabToken() {
            Object ref = this.grabToken_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.grabToken_ = s;
            return s;
        }

        @Override
        public ByteString getGrabTokenBytes() {
            Object ref = this.grabToken_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.grabToken_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public boolean getNeedSendRequest() {
            return this.needSendRequest_;
        }

        @Override
        public long getRequestDelayMillis() {
            return this.requestDelayMillis_;
        }

        @Override
        public long getLuckiestDelayMillis() {
            return this.luckiestDelayMillis_;
        }

        @Override
        public int getCoverTypeValue() {
            return this.coverType_;
        }

        @Override
        public WebRedPackCoverTypeOuterClass.WebRedPackCoverType getCoverType() {
            WebRedPackCoverTypeOuterClass.WebRedPackCoverType result = WebRedPackCoverTypeOuterClass.WebRedPackCoverType.forNumber(this.coverType_);
            return result == null ? WebRedPackCoverTypeOuterClass.WebRedPackCoverType.UNRECOGNIZED : result;
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
            if (!GeneratedMessageV3.isStringEmpty(this.id_)) {
                GeneratedMessageV3.writeString(output, 1, this.id_);
            }
            if ((this.bitField0_ & 1) != 0) {
                output.writeMessage(2, this.getAuthor());
            }
            if (this.balance_ != 0L) {
                output.writeUInt64(3, this.balance_);
            }
            if (this.openTime_ != 0L) {
                output.writeUInt64(4, this.openTime_);
            }
            if (this.currentTime_ != 0L) {
                output.writeUInt64(5, this.currentTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.grabToken_)) {
                GeneratedMessageV3.writeString(output, 6, this.grabToken_);
            }
            if (this.needSendRequest_) {
                output.writeBool(7, this.needSendRequest_);
            }
            if (this.requestDelayMillis_ != 0L) {
                output.writeUInt64(8, this.requestDelayMillis_);
            }
            if (this.luckiestDelayMillis_ != 0L) {
                output.writeUInt64(9, this.luckiestDelayMillis_);
            }
            if (this.coverType_ != WebRedPackCoverTypeOuterClass.WebRedPackCoverType.UNKNOWN_COVER_TYPE.getNumber()) {
                output.writeEnum(10, this.coverType_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.id_)) {
                size += GeneratedMessageV3.computeStringSize(1, this.id_);
            }
            if ((this.bitField0_ & 1) != 0) {
                size += CodedOutputStream.computeMessageSize(2, this.getAuthor());
            }
            if (this.balance_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(3, this.balance_);
            }
            if (this.openTime_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(4, this.openTime_);
            }
            if (this.currentTime_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(5, this.currentTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.grabToken_)) {
                size += GeneratedMessageV3.computeStringSize(6, this.grabToken_);
            }
            if (this.needSendRequest_) {
                size += CodedOutputStream.computeBoolSize(7, this.needSendRequest_);
            }
            if (this.requestDelayMillis_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(8, this.requestDelayMillis_);
            }
            if (this.luckiestDelayMillis_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(9, this.luckiestDelayMillis_);
            }
            if (this.coverType_ != WebRedPackCoverTypeOuterClass.WebRedPackCoverType.UNKNOWN_COVER_TYPE.getNumber()) {
                size += CodedOutputStream.computeEnumSize(10, this.coverType_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WebRedPackInfo)) {
                return super.equals(obj);
            }
            WebRedPackInfo other = (WebRedPackInfo)obj;
            if (!this.getId().equals((Object)other.getId())) {
                return false;
            }
            if (this.hasAuthor() != other.hasAuthor()) {
                return false;
            }
            if (this.hasAuthor() && !this.getAuthor().equals(other.getAuthor())) {
                return false;
            }
            if (this.getBalance() != other.getBalance()) {
                return false;
            }
            if (this.getOpenTime() != other.getOpenTime()) {
                return false;
            }
            if (this.getCurrentTime() != other.getCurrentTime()) {
                return false;
            }
            if (!this.getGrabToken().equals((Object)other.getGrabToken())) {
                return false;
            }
            if (this.getNeedSendRequest() != other.getNeedSendRequest()) {
                return false;
            }
            if (this.getRequestDelayMillis() != other.getRequestDelayMillis()) {
                return false;
            }
            if (this.getLuckiestDelayMillis() != other.getLuckiestDelayMillis()) {
                return false;
            }
            if (this.coverType_ != other.coverType_) {
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
            hash = 19 * hash + WebRedPackInfo.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getId().hashCode();
            if (this.hasAuthor()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.getAuthor().hashCode();
            }
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getBalance());
            hash = 37 * hash + 4;
            hash = 53 * hash + Internal.hashLong(this.getOpenTime());
            hash = 37 * hash + 5;
            hash = 53 * hash + Internal.hashLong(this.getCurrentTime());
            hash = 37 * hash + 6;
            hash = 53 * hash + this.getGrabToken().hashCode();
            hash = 37 * hash + 7;
            hash = 53 * hash + Internal.hashBoolean(this.getNeedSendRequest());
            hash = 37 * hash + 8;
            hash = 53 * hash + Internal.hashLong(this.getRequestDelayMillis());
            hash = 37 * hash + 9;
            hash = 53 * hash + Internal.hashLong(this.getLuckiestDelayMillis());
            hash = 37 * hash + 10;
            hash = 53 * hash + this.coverType_;
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static WebRedPackInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WebRedPackInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebRedPackInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WebRedPackInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebRedPackInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WebRedPackInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebRedPackInfo parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WebRedPackInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WebRedPackInfo parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WebRedPackInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WebRedPackInfo parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WebRedPackInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return WebRedPackInfo.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WebRedPackInfo prototype) {
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

        public static WebRedPackInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WebRedPackInfo> parser() {
            return PARSER;
        }

        public Parser<WebRedPackInfo> getParserForType() {
            return PARSER;
        }

        @Override
        public WebRedPackInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements WebRedPackInfoOrBuilder {
            private int bitField0_;
            private Object id_ = "";
            private SimpleUserInfoOuterClass.SimpleUserInfo author_;
            private SingleFieldBuilderV3<SimpleUserInfoOuterClass.SimpleUserInfo, SimpleUserInfoOuterClass.SimpleUserInfo.Builder, SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder> authorBuilder_;
            private long balance_;
            private long openTime_;
            private long currentTime_;
            private Object grabToken_ = "";
            private boolean needSendRequest_;
            private long requestDelayMillis_;
            private long luckiestDelayMillis_;
            private int coverType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_WebRedPackInfo_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_WebRedPackInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WebRedPackInfo.class, Builder.class);
            }

            private Builder() {
                this.maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                this.maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (alwaysUseFieldBuilders) {
                    this.getAuthorFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.id_ = "";
                this.author_ = null;
                if (this.authorBuilder_ != null) {
                    this.authorBuilder_.dispose();
                    this.authorBuilder_ = null;
                }
                this.balance_ = 0L;
                this.openTime_ = 0L;
                this.currentTime_ = 0L;
                this.grabToken_ = "";
                this.needSendRequest_ = false;
                this.requestDelayMillis_ = 0L;
                this.luckiestDelayMillis_ = 0L;
                this.coverType_ = 0;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_WebRedPackInfo_descriptor;
            }

            @Override
            public WebRedPackInfo getDefaultInstanceForType() {
                return WebRedPackInfo.getDefaultInstance();
            }

            @Override
            public WebRedPackInfo build() {
                WebRedPackInfo result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public WebRedPackInfo buildPartial() {
                WebRedPackInfo result = new WebRedPackInfo(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(WebRedPackInfo result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.id_ = this.id_;
                }
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 2) != 0) {
                    result.author_ = this.authorBuilder_ == null ? this.author_ : this.authorBuilder_.build();
                    to_bitField0_ |= 1;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.balance_ = this.balance_;
                }
                if ((from_bitField0_ & 8) != 0) {
                    result.openTime_ = this.openTime_;
                }
                if ((from_bitField0_ & 0x10) != 0) {
                    result.currentTime_ = this.currentTime_;
                }
                if ((from_bitField0_ & 0x20) != 0) {
                    result.grabToken_ = this.grabToken_;
                }
                if ((from_bitField0_ & 0x40) != 0) {
                    result.needSendRequest_ = this.needSendRequest_;
                }
                if ((from_bitField0_ & 0x80) != 0) {
                    result.requestDelayMillis_ = this.requestDelayMillis_;
                }
                if ((from_bitField0_ & 0x100) != 0) {
                    result.luckiestDelayMillis_ = this.luckiestDelayMillis_;
                }
                if ((from_bitField0_ & 0x200) != 0) {
                    result.coverType_ = this.coverType_;
                }
                result.bitField0_ |= to_bitField0_;
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
                if (other instanceof WebRedPackInfo) {
                    return this.mergeFrom((WebRedPackInfo)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebRedPackInfo other) {
                if (other == WebRedPackInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getId().isEmpty()) {
                    this.id_ = other.id_;
                    this.bitField0_ |= 1;
                    this.onChanged();
                }
                if (other.hasAuthor()) {
                    this.mergeAuthor(other.getAuthor());
                }
                if (other.getBalance() != 0L) {
                    this.setBalance(other.getBalance());
                }
                if (other.getOpenTime() != 0L) {
                    this.setOpenTime(other.getOpenTime());
                }
                if (other.getCurrentTime() != 0L) {
                    this.setCurrentTime(other.getCurrentTime());
                }
                if (!other.getGrabToken().isEmpty()) {
                    this.grabToken_ = other.grabToken_;
                    this.bitField0_ |= 0x20;
                    this.onChanged();
                }
                if (other.getNeedSendRequest()) {
                    this.setNeedSendRequest(other.getNeedSendRequest());
                }
                if (other.getRequestDelayMillis() != 0L) {
                    this.setRequestDelayMillis(other.getRequestDelayMillis());
                }
                if (other.getLuckiestDelayMillis() != 0L) {
                    this.setLuckiestDelayMillis(other.getLuckiestDelayMillis());
                }
                if (other.coverType_ != 0) {
                    this.setCoverTypeValue(other.getCoverTypeValue());
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
                    block18: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block18;
                            }
                            case 10: {
                                this.id_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                                continue block18;
                            }
                            case 18: {
                                input.readMessage(this.getAuthorFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 2;
                                continue block18;
                            }
                            case 24: {
                                this.balance_ = input.readUInt64();
                                this.bitField0_ |= 4;
                                continue block18;
                            }
                            case 32: {
                                this.openTime_ = input.readUInt64();
                                this.bitField0_ |= 8;
                                continue block18;
                            }
                            case 40: {
                                this.currentTime_ = input.readUInt64();
                                this.bitField0_ |= 0x10;
                                continue block18;
                            }
                            case 50: {
                                this.grabToken_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 0x20;
                                continue block18;
                            }
                            case 56: {
                                this.needSendRequest_ = input.readBool();
                                this.bitField0_ |= 0x40;
                                continue block18;
                            }
                            case 64: {
                                this.requestDelayMillis_ = input.readUInt64();
                                this.bitField0_ |= 0x80;
                                continue block18;
                            }
                            case 72: {
                                this.luckiestDelayMillis_ = input.readUInt64();
                                this.bitField0_ |= 0x100;
                                continue block18;
                            }
                            case 80: {
                                this.coverType_ = input.readEnum();
                                this.bitField0_ |= 0x200;
                                continue block18;
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
            public String getId() {
                Object ref = this.id_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.id_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getIdBytes() {
                Object ref = this.id_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.id_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.id_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = WebRedPackInfo.getDefaultInstance().getId();
                this.bitField0_ &= 0xFFFFFFFE;
                this.onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                WebRedPackInfo.checkByteStringIsUtf8(value);
                this.id_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            @Override
            public boolean hasAuthor() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override
            public SimpleUserInfoOuterClass.SimpleUserInfo getAuthor() {
                if (this.authorBuilder_ == null) {
                    return this.author_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.author_;
                }
                return this.authorBuilder_.getMessage();
            }

            public Builder setAuthor(SimpleUserInfoOuterClass.SimpleUserInfo value) {
                if (this.authorBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.author_ = value;
                } else {
                    this.authorBuilder_.setMessage(value);
                }
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder setAuthor(SimpleUserInfoOuterClass.SimpleUserInfo.Builder builderForValue) {
                if (this.authorBuilder_ == null) {
                    this.author_ = builderForValue.build();
                } else {
                    this.authorBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder mergeAuthor(SimpleUserInfoOuterClass.SimpleUserInfo value) {
                if (this.authorBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0 && this.author_ != null && this.author_ != SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance()) {
                        this.getAuthorBuilder().mergeFrom(value);
                    } else {
                        this.author_ = value;
                    }
                } else {
                    this.authorBuilder_.mergeFrom(value);
                }
                if (this.author_ != null) {
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                return this;
            }

            public Builder clearAuthor() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.author_ = null;
                if (this.authorBuilder_ != null) {
                    this.authorBuilder_.dispose();
                    this.authorBuilder_ = null;
                }
                this.onChanged();
                return this;
            }

            public SimpleUserInfoOuterClass.SimpleUserInfo.Builder getAuthorBuilder() {
                this.bitField0_ |= 2;
                this.onChanged();
                return this.getAuthorFieldBuilder().getBuilder();
            }

            @Override
            public SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder getAuthorOrBuilder() {
                if (this.authorBuilder_ != null) {
                    return this.authorBuilder_.getMessageOrBuilder();
                }
                return this.author_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.author_;
            }

            private SingleFieldBuilderV3<SimpleUserInfoOuterClass.SimpleUserInfo, SimpleUserInfoOuterClass.SimpleUserInfo.Builder, SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder> getAuthorFieldBuilder() {
                if (this.authorBuilder_ == null) {
                    this.authorBuilder_ = new SingleFieldBuilderV3(this.getAuthor(), this.getParentForChildren(), this.isClean());
                    this.author_ = null;
                }
                return this.authorBuilder_;
            }

            @Override
            public long getBalance() {
                return this.balance_;
            }

            public Builder setBalance(long value) {
                this.balance_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearBalance() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.balance_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public long getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(long value) {
                this.openTime_ = value;
                this.bitField0_ |= 8;
                this.onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.openTime_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public long getCurrentTime() {
                return this.currentTime_;
            }

            public Builder setCurrentTime(long value) {
                this.currentTime_ = value;
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this;
            }

            public Builder clearCurrentTime() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.currentTime_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public String getGrabToken() {
                Object ref = this.grabToken_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.grabToken_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getGrabTokenBytes() {
                Object ref = this.grabToken_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.grabToken_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setGrabToken(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.grabToken_ = value;
                this.bitField0_ |= 0x20;
                this.onChanged();
                return this;
            }

            public Builder clearGrabToken() {
                this.grabToken_ = WebRedPackInfo.getDefaultInstance().getGrabToken();
                this.bitField0_ &= 0xFFFFFFDF;
                this.onChanged();
                return this;
            }

            public Builder setGrabTokenBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                WebRedPackInfo.checkByteStringIsUtf8(value);
                this.grabToken_ = value;
                this.bitField0_ |= 0x20;
                this.onChanged();
                return this;
            }

            @Override
            public boolean getNeedSendRequest() {
                return this.needSendRequest_;
            }

            public Builder setNeedSendRequest(boolean value) {
                this.needSendRequest_ = value;
                this.bitField0_ |= 0x40;
                this.onChanged();
                return this;
            }

            public Builder clearNeedSendRequest() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.needSendRequest_ = false;
                this.onChanged();
                return this;
            }

            @Override
            public long getRequestDelayMillis() {
                return this.requestDelayMillis_;
            }

            public Builder setRequestDelayMillis(long value) {
                this.requestDelayMillis_ = value;
                this.bitField0_ |= 0x80;
                this.onChanged();
                return this;
            }

            public Builder clearRequestDelayMillis() {
                this.bitField0_ &= 0xFFFFFF7F;
                this.requestDelayMillis_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public long getLuckiestDelayMillis() {
                return this.luckiestDelayMillis_;
            }

            public Builder setLuckiestDelayMillis(long value) {
                this.luckiestDelayMillis_ = value;
                this.bitField0_ |= 0x100;
                this.onChanged();
                return this;
            }

            public Builder clearLuckiestDelayMillis() {
                this.bitField0_ &= 0xFFFFFEFF;
                this.luckiestDelayMillis_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public int getCoverTypeValue() {
                return this.coverType_;
            }

            public Builder setCoverTypeValue(int value) {
                this.coverType_ = value;
                this.bitField0_ |= 0x200;
                this.onChanged();
                return this;
            }

            @Override
            public WebRedPackCoverTypeOuterClass.WebRedPackCoverType getCoverType() {
                WebRedPackCoverTypeOuterClass.WebRedPackCoverType result = WebRedPackCoverTypeOuterClass.WebRedPackCoverType.forNumber(this.coverType_);
                return result == null ? WebRedPackCoverTypeOuterClass.WebRedPackCoverType.UNRECOGNIZED : result;
            }

            public Builder setCoverType(WebRedPackCoverTypeOuterClass.WebRedPackCoverType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 0x200;
                this.coverType_ = value.getNumber();
                this.onChanged();
                return this;
            }

            public Builder clearCoverType() {
                this.bitField0_ &= 0xFFFFFDFF;
                this.coverType_ = 0;
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

    public static interface WebRedPackInfoOrBuilder
    extends MessageOrBuilder {
        public String getId();

        public ByteString getIdBytes();

        public boolean hasAuthor();

        public SimpleUserInfoOuterClass.SimpleUserInfo getAuthor();

        public SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder getAuthorOrBuilder();

        public long getBalance();

        public long getOpenTime();

        public long getCurrentTime();

        public String getGrabToken();

        public ByteString getGrabTokenBytes();

        public boolean getNeedSendRequest();

        public long getRequestDelayMillis();

        public long getLuckiestDelayMillis();

        public int getCoverTypeValue();

        public WebRedPackCoverTypeOuterClass.WebRedPackCoverType getCoverType();
    }
}


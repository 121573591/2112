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
package tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
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
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.PicUrlOuterClass;

public final class UserInfoOuterClass {
    private static final Descriptors.Descriptor internal_static_UserInfo_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UserInfo_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private UserInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        UserInfoOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nUserInfo.proto\fPicUrl.proto\"À\n\bUserInfo\nuserId (\n\buserName (\t\n\nuserGender (\t\n\buserText (\t\n\bheadUrls (2.PicUrl\n\bverified (\b\nsUserId (\t\n\rhttpsHeadUrls\b (2.PicUrl\nkwaiId\t (\tB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{PicUrlOuterClass.getDescriptor()});
        internal_static_UserInfo_descriptor = (Descriptors.Descriptor)UserInfoOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_UserInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UserInfo_descriptor, new String[]{"UserId", "UserName", "UserGender", "UserText", "HeadUrls", "Verified", "SUserId", "HttpsHeadUrls", "KwaiId"});
        PicUrlOuterClass.getDescriptor();
    }

    public static final class UserInfo
    extends GeneratedMessageV3
    implements UserInfoOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int USERID_FIELD_NUMBER = 1;
        private long userId_ = 0L;
        public static final int USERNAME_FIELD_NUMBER = 2;
        private volatile Object userName_ = "";
        public static final int USERGENDER_FIELD_NUMBER = 3;
        private volatile Object userGender_ = "";
        public static final int USERTEXT_FIELD_NUMBER = 4;
        private volatile Object userText_ = "";
        public static final int HEADURLS_FIELD_NUMBER = 5;
        private List<PicUrlOuterClass.PicUrl> headUrls_;
        public static final int VERIFIED_FIELD_NUMBER = 6;
        private boolean verified_ = false;
        public static final int SUSERID_FIELD_NUMBER = 7;
        private volatile Object sUserId_ = "";
        public static final int HTTPSHEADURLS_FIELD_NUMBER = 8;
        private List<PicUrlOuterClass.PicUrl> httpsHeadUrls_;
        public static final int KWAIID_FIELD_NUMBER = 9;
        private volatile Object kwaiId_ = "";
        private byte memoizedIsInitialized = (byte)-1;
        private static final UserInfo DEFAULT_INSTANCE = new UserInfo();
        private static final Parser<UserInfo> PARSER = new AbstractParser<UserInfo>(){

            @Override
            public UserInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = UserInfo.newBuilder();
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

        private UserInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private UserInfo() {
            this.userName_ = "";
            this.userGender_ = "";
            this.userText_ = "";
            this.headUrls_ = Collections.emptyList();
            this.sUserId_ = "";
            this.httpsHeadUrls_ = Collections.emptyList();
            this.kwaiId_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UserInfo();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_UserInfo_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_UserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UserInfo.class, Builder.class);
        }

        @Override
        public long getUserId() {
            return this.userId_;
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
        public String getUserGender() {
            Object ref = this.userGender_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.userGender_ = s;
            return s;
        }

        @Override
        public ByteString getUserGenderBytes() {
            Object ref = this.userGender_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.userGender_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public String getUserText() {
            Object ref = this.userText_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.userText_ = s;
            return s;
        }

        @Override
        public ByteString getUserTextBytes() {
            Object ref = this.userText_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.userText_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public List<PicUrlOuterClass.PicUrl> getHeadUrlsList() {
            return this.headUrls_;
        }

        @Override
        public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getHeadUrlsOrBuilderList() {
            return this.headUrls_;
        }

        @Override
        public int getHeadUrlsCount() {
            return this.headUrls_.size();
        }

        @Override
        public PicUrlOuterClass.PicUrl getHeadUrls(int index) {
            return (PicUrlOuterClass.PicUrl)this.headUrls_.get(index);
        }

        @Override
        public PicUrlOuterClass.PicUrlOrBuilder getHeadUrlsOrBuilder(int index) {
            return (PicUrlOuterClass.PicUrlOrBuilder)this.headUrls_.get(index);
        }

        @Override
        public boolean getVerified() {
            return this.verified_;
        }

        @Override
        public String getSUserId() {
            Object ref = this.sUserId_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.sUserId_ = s;
            return s;
        }

        @Override
        public ByteString getSUserIdBytes() {
            Object ref = this.sUserId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.sUserId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public List<PicUrlOuterClass.PicUrl> getHttpsHeadUrlsList() {
            return this.httpsHeadUrls_;
        }

        @Override
        public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getHttpsHeadUrlsOrBuilderList() {
            return this.httpsHeadUrls_;
        }

        @Override
        public int getHttpsHeadUrlsCount() {
            return this.httpsHeadUrls_.size();
        }

        @Override
        public PicUrlOuterClass.PicUrl getHttpsHeadUrls(int index) {
            return (PicUrlOuterClass.PicUrl)this.httpsHeadUrls_.get(index);
        }

        @Override
        public PicUrlOuterClass.PicUrlOrBuilder getHttpsHeadUrlsOrBuilder(int index) {
            return (PicUrlOuterClass.PicUrlOrBuilder)this.httpsHeadUrls_.get(index);
        }

        @Override
        public String getKwaiId() {
            Object ref = this.kwaiId_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.kwaiId_ = s;
            return s;
        }

        @Override
        public ByteString getKwaiIdBytes() {
            Object ref = this.kwaiId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.kwaiId_ = b;
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
            int i;
            if (this.userId_ != 0L) {
                output.writeUInt64(1, this.userId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userName_)) {
                GeneratedMessageV3.writeString(output, 2, this.userName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userGender_)) {
                GeneratedMessageV3.writeString(output, 3, this.userGender_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userText_)) {
                GeneratedMessageV3.writeString(output, 4, this.userText_);
            }
            for (i = 0; i < this.headUrls_.size(); ++i) {
                output.writeMessage(5, (MessageLite)this.headUrls_.get(i));
            }
            if (this.verified_) {
                output.writeBool(6, this.verified_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sUserId_)) {
                GeneratedMessageV3.writeString(output, 7, this.sUserId_);
            }
            for (i = 0; i < this.httpsHeadUrls_.size(); ++i) {
                output.writeMessage(8, (MessageLite)this.httpsHeadUrls_.get(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.kwaiId_)) {
                GeneratedMessageV3.writeString(output, 9, this.kwaiId_);
            }
            this.getUnknownFields().writeTo(output);
        }

        @Override
        public int getSerializedSize() {
            int i;
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            size = 0;
            if (this.userId_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(1, this.userId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userName_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.userName_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userGender_)) {
                size += GeneratedMessageV3.computeStringSize(3, this.userGender_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.userText_)) {
                size += GeneratedMessageV3.computeStringSize(4, this.userText_);
            }
            for (i = 0; i < this.headUrls_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(5, (MessageLite)this.headUrls_.get(i));
            }
            if (this.verified_) {
                size += CodedOutputStream.computeBoolSize(6, this.verified_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.sUserId_)) {
                size += GeneratedMessageV3.computeStringSize(7, this.sUserId_);
            }
            for (i = 0; i < this.httpsHeadUrls_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(8, (MessageLite)this.httpsHeadUrls_.get(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.kwaiId_)) {
                size += GeneratedMessageV3.computeStringSize(9, this.kwaiId_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserInfo)) {
                return super.equals(obj);
            }
            UserInfo other = (UserInfo)obj;
            if (this.getUserId() != other.getUserId()) {
                return false;
            }
            if (!this.getUserName().equals((Object)other.getUserName())) {
                return false;
            }
            if (!this.getUserGender().equals((Object)other.getUserGender())) {
                return false;
            }
            if (!this.getUserText().equals((Object)other.getUserText())) {
                return false;
            }
            if (!this.getHeadUrlsList().equals(other.getHeadUrlsList())) {
                return false;
            }
            if (this.getVerified() != other.getVerified()) {
                return false;
            }
            if (!this.getSUserId().equals((Object)other.getSUserId())) {
                return false;
            }
            if (!this.getHttpsHeadUrlsList().equals(other.getHttpsHeadUrlsList())) {
                return false;
            }
            if (!this.getKwaiId().equals((Object)other.getKwaiId())) {
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
            hash = 19 * hash + UserInfo.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getUserId());
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUserName().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getUserGender().hashCode();
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getUserText().hashCode();
            if (this.getHeadUrlsCount() > 0) {
                hash = 37 * hash + 5;
                hash = 53 * hash + this.getHeadUrlsList().hashCode();
            }
            hash = 37 * hash + 6;
            hash = 53 * hash + Internal.hashBoolean(this.getVerified());
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getSUserId().hashCode();
            if (this.getHttpsHeadUrlsCount() > 0) {
                hash = 37 * hash + 8;
                hash = 53 * hash + this.getHttpsHeadUrlsList().hashCode();
            }
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getKwaiId().hashCode();
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static UserInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UserInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UserInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UserInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UserInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UserInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UserInfo parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UserInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UserInfo parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UserInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UserInfo parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UserInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return UserInfo.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserInfo prototype) {
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

        public static UserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserInfo> parser() {
            return PARSER;
        }

        public Parser<UserInfo> getParserForType() {
            return PARSER;
        }

        @Override
        public UserInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements UserInfoOrBuilder {
            private int bitField0_;
            private long userId_;
            private Object userName_ = "";
            private Object userGender_ = "";
            private Object userText_ = "";
            private List<PicUrlOuterClass.PicUrl> headUrls_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PicUrlOuterClass.PicUrl, PicUrlOuterClass.PicUrl.Builder, PicUrlOuterClass.PicUrlOrBuilder> headUrlsBuilder_;
            private boolean verified_;
            private Object sUserId_ = "";
            private List<PicUrlOuterClass.PicUrl> httpsHeadUrls_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PicUrlOuterClass.PicUrl, PicUrlOuterClass.PicUrl.Builder, PicUrlOuterClass.PicUrlOrBuilder> httpsHeadUrlsBuilder_;
            private Object kwaiId_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_UserInfo_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_UserInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(UserInfo.class, Builder.class);
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
                this.userId_ = 0L;
                this.userName_ = "";
                this.userGender_ = "";
                this.userText_ = "";
                if (this.headUrlsBuilder_ == null) {
                    this.headUrls_ = Collections.emptyList();
                } else {
                    this.headUrls_ = null;
                    this.headUrlsBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFEF;
                this.verified_ = false;
                this.sUserId_ = "";
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.httpsHeadUrls_ = Collections.emptyList();
                } else {
                    this.httpsHeadUrls_ = null;
                    this.httpsHeadUrlsBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFF7F;
                this.kwaiId_ = "";
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_UserInfo_descriptor;
            }

            @Override
            public UserInfo getDefaultInstanceForType() {
                return UserInfo.getDefaultInstance();
            }

            @Override
            public UserInfo build() {
                UserInfo result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public UserInfo buildPartial() {
                UserInfo result = new UserInfo(this);
                this.buildPartialRepeatedFields(result);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartialRepeatedFields(UserInfo result) {
                if (this.headUrlsBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) != 0) {
                        this.headUrls_ = Collections.unmodifiableList(this.headUrls_);
                        this.bitField0_ &= 0xFFFFFFEF;
                    }
                    result.headUrls_ = this.headUrls_;
                } else {
                    result.headUrls_ = this.headUrlsBuilder_.build();
                }
                if (this.httpsHeadUrlsBuilder_ == null) {
                    if ((this.bitField0_ & 0x80) != 0) {
                        this.httpsHeadUrls_ = Collections.unmodifiableList(this.httpsHeadUrls_);
                        this.bitField0_ &= 0xFFFFFF7F;
                    }
                    result.httpsHeadUrls_ = this.httpsHeadUrls_;
                } else {
                    result.httpsHeadUrls_ = this.httpsHeadUrlsBuilder_.build();
                }
            }

            private void buildPartial0(UserInfo result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.userId_ = this.userId_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.userName_ = this.userName_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.userGender_ = this.userGender_;
                }
                if ((from_bitField0_ & 8) != 0) {
                    result.userText_ = this.userText_;
                }
                if ((from_bitField0_ & 0x20) != 0) {
                    result.verified_ = this.verified_;
                }
                if ((from_bitField0_ & 0x40) != 0) {
                    result.sUserId_ = this.sUserId_;
                }
                if ((from_bitField0_ & 0x100) != 0) {
                    result.kwaiId_ = this.kwaiId_;
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
                if (other instanceof UserInfo) {
                    return this.mergeFrom((UserInfo)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UserInfo other) {
                if (other == UserInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUserId() != 0L) {
                    this.setUserId(other.getUserId());
                }
                if (!other.getUserName().isEmpty()) {
                    this.userName_ = other.userName_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (!other.getUserGender().isEmpty()) {
                    this.userGender_ = other.userGender_;
                    this.bitField0_ |= 4;
                    this.onChanged();
                }
                if (!other.getUserText().isEmpty()) {
                    this.userText_ = other.userText_;
                    this.bitField0_ |= 8;
                    this.onChanged();
                }
                if (this.headUrlsBuilder_ == null) {
                    if (!other.headUrls_.isEmpty()) {
                        if (this.headUrls_.isEmpty()) {
                            this.headUrls_ = other.headUrls_;
                            this.bitField0_ &= 0xFFFFFFEF;
                        } else {
                            this.ensureHeadUrlsIsMutable();
                            this.headUrls_.addAll((Collection)other.headUrls_);
                        }
                        this.onChanged();
                    }
                } else if (!other.headUrls_.isEmpty()) {
                    if (this.headUrlsBuilder_.isEmpty()) {
                        this.headUrlsBuilder_.dispose();
                        this.headUrlsBuilder_ = null;
                        this.headUrls_ = other.headUrls_;
                        this.bitField0_ &= 0xFFFFFFEF;
                        this.headUrlsBuilder_ = alwaysUseFieldBuilders ? this.getHeadUrlsFieldBuilder() : null;
                    } else {
                        this.headUrlsBuilder_.addAllMessages((Iterable<PicUrlOuterClass.PicUrl>)other.headUrls_);
                    }
                }
                if (other.getVerified()) {
                    this.setVerified(other.getVerified());
                }
                if (!other.getSUserId().isEmpty()) {
                    this.sUserId_ = other.sUserId_;
                    this.bitField0_ |= 0x40;
                    this.onChanged();
                }
                if (this.httpsHeadUrlsBuilder_ == null) {
                    if (!other.httpsHeadUrls_.isEmpty()) {
                        if (this.httpsHeadUrls_.isEmpty()) {
                            this.httpsHeadUrls_ = other.httpsHeadUrls_;
                            this.bitField0_ &= 0xFFFFFF7F;
                        } else {
                            this.ensureHttpsHeadUrlsIsMutable();
                            this.httpsHeadUrls_.addAll((Collection)other.httpsHeadUrls_);
                        }
                        this.onChanged();
                    }
                } else if (!other.httpsHeadUrls_.isEmpty()) {
                    if (this.httpsHeadUrlsBuilder_.isEmpty()) {
                        this.httpsHeadUrlsBuilder_.dispose();
                        this.httpsHeadUrlsBuilder_ = null;
                        this.httpsHeadUrls_ = other.httpsHeadUrls_;
                        this.bitField0_ &= 0xFFFFFF7F;
                        this.httpsHeadUrlsBuilder_ = alwaysUseFieldBuilders ? this.getHttpsHeadUrlsFieldBuilder() : null;
                    } else {
                        this.httpsHeadUrlsBuilder_.addAllMessages((Iterable<PicUrlOuterClass.PicUrl>)other.httpsHeadUrls_);
                    }
                }
                if (!other.getKwaiId().isEmpty()) {
                    this.kwaiId_ = other.kwaiId_;
                    this.bitField0_ |= 0x100;
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
                    block17: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block17;
                            }
                            case 8: {
                                this.userId_ = input.readUInt64();
                                this.bitField0_ |= 1;
                                continue block17;
                            }
                            case 18: {
                                this.userName_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block17;
                            }
                            case 26: {
                                this.userGender_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 4;
                                continue block17;
                            }
                            case 34: {
                                this.userText_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 8;
                                continue block17;
                            }
                            case 42: {
                                PicUrlOuterClass.PicUrl m = input.readMessage(PicUrlOuterClass.PicUrl.parser(), extensionRegistry);
                                if (this.headUrlsBuilder_ == null) {
                                    this.ensureHeadUrlsIsMutable();
                                    this.headUrls_.add((Object)m);
                                    continue block17;
                                }
                                this.headUrlsBuilder_.addMessage(m);
                                continue block17;
                            }
                            case 48: {
                                this.verified_ = input.readBool();
                                this.bitField0_ |= 0x20;
                                continue block17;
                            }
                            case 58: {
                                this.sUserId_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 0x40;
                                continue block17;
                            }
                            case 66: {
                                PicUrlOuterClass.PicUrl m = input.readMessage(PicUrlOuterClass.PicUrl.parser(), extensionRegistry);
                                if (this.httpsHeadUrlsBuilder_ == null) {
                                    this.ensureHttpsHeadUrlsIsMutable();
                                    this.httpsHeadUrls_.add((Object)m);
                                    continue block17;
                                }
                                this.httpsHeadUrlsBuilder_.addMessage(m);
                                continue block17;
                            }
                            case 74: {
                                this.kwaiId_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 0x100;
                                continue block17;
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
            public long getUserId() {
                return this.userId_;
            }

            public Builder setUserId(long value) {
                this.userId_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearUserId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.userId_ = 0L;
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
                this.userName_ = UserInfo.getDefaultInstance().getUserName();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setUserNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                UserInfo.checkByteStringIsUtf8(value);
                this.userName_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public String getUserGender() {
                Object ref = this.userGender_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.userGender_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getUserGenderBytes() {
                Object ref = this.userGender_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.userGender_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setUserGender(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.userGender_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearUserGender() {
                this.userGender_ = UserInfo.getDefaultInstance().getUserGender();
                this.bitField0_ &= 0xFFFFFFFB;
                this.onChanged();
                return this;
            }

            public Builder setUserGenderBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                UserInfo.checkByteStringIsUtf8(value);
                this.userGender_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            @Override
            public String getUserText() {
                Object ref = this.userText_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.userText_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getUserTextBytes() {
                Object ref = this.userText_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.userText_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setUserText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.userText_ = value;
                this.bitField0_ |= 8;
                this.onChanged();
                return this;
            }

            public Builder clearUserText() {
                this.userText_ = UserInfo.getDefaultInstance().getUserText();
                this.bitField0_ &= 0xFFFFFFF7;
                this.onChanged();
                return this;
            }

            public Builder setUserTextBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                UserInfo.checkByteStringIsUtf8(value);
                this.userText_ = value;
                this.bitField0_ |= 8;
                this.onChanged();
                return this;
            }

            private void ensureHeadUrlsIsMutable() {
                if ((this.bitField0_ & 0x10) == 0) {
                    this.headUrls_ = new ArrayList(this.headUrls_);
                    this.bitField0_ |= 0x10;
                }
            }

            @Override
            public List<PicUrlOuterClass.PicUrl> getHeadUrlsList() {
                if (this.headUrlsBuilder_ == null) {
                    return Collections.unmodifiableList(this.headUrls_);
                }
                return this.headUrlsBuilder_.getMessageList();
            }

            @Override
            public int getHeadUrlsCount() {
                if (this.headUrlsBuilder_ == null) {
                    return this.headUrls_.size();
                }
                return this.headUrlsBuilder_.getCount();
            }

            @Override
            public PicUrlOuterClass.PicUrl getHeadUrls(int index) {
                if (this.headUrlsBuilder_ == null) {
                    return (PicUrlOuterClass.PicUrl)this.headUrls_.get(index);
                }
                return this.headUrlsBuilder_.getMessage(index);
            }

            public Builder setHeadUrls(int index, PicUrlOuterClass.PicUrl value) {
                if (this.headUrlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.set(index, (Object)value);
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setHeadUrls(int index, PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.headUrlsBuilder_ == null) {
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.set(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHeadUrls(PicUrlOuterClass.PicUrl value) {
                if (this.headUrlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.add((Object)value);
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addHeadUrls(int index, PicUrlOuterClass.PicUrl value) {
                if (this.headUrlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.add(index, (Object)value);
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addHeadUrls(PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.headUrlsBuilder_ == null) {
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.add((Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHeadUrls(int index, PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.headUrlsBuilder_ == null) {
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.add(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHeadUrls(Iterable<? extends PicUrlOuterClass.PicUrl> values) {
                if (this.headUrlsBuilder_ == null) {
                    this.ensureHeadUrlsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.headUrls_);
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHeadUrls() {
                if (this.headUrlsBuilder_ == null) {
                    this.headUrls_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFEF;
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.clear();
                }
                return this;
            }

            public Builder removeHeadUrls(int index) {
                if (this.headUrlsBuilder_ == null) {
                    this.ensureHeadUrlsIsMutable();
                    this.headUrls_.remove(index);
                    this.onChanged();
                } else {
                    this.headUrlsBuilder_.remove(index);
                }
                return this;
            }

            public PicUrlOuterClass.PicUrl.Builder getHeadUrlsBuilder(int index) {
                return this.getHeadUrlsFieldBuilder().getBuilder(index);
            }

            @Override
            public PicUrlOuterClass.PicUrlOrBuilder getHeadUrlsOrBuilder(int index) {
                if (this.headUrlsBuilder_ == null) {
                    return (PicUrlOuterClass.PicUrlOrBuilder)this.headUrls_.get(index);
                }
                return this.headUrlsBuilder_.getMessageOrBuilder(index);
            }

            @Override
            public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getHeadUrlsOrBuilderList() {
                if (this.headUrlsBuilder_ != null) {
                    return this.headUrlsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.headUrls_);
            }

            public PicUrlOuterClass.PicUrl.Builder addHeadUrlsBuilder() {
                return this.getHeadUrlsFieldBuilder().addBuilder(PicUrlOuterClass.PicUrl.getDefaultInstance());
            }

            public PicUrlOuterClass.PicUrl.Builder addHeadUrlsBuilder(int index) {
                return this.getHeadUrlsFieldBuilder().addBuilder(index, PicUrlOuterClass.PicUrl.getDefaultInstance());
            }

            public List<PicUrlOuterClass.PicUrl.Builder> getHeadUrlsBuilderList() {
                return this.getHeadUrlsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PicUrlOuterClass.PicUrl, PicUrlOuterClass.PicUrl.Builder, PicUrlOuterClass.PicUrlOrBuilder> getHeadUrlsFieldBuilder() {
                if (this.headUrlsBuilder_ == null) {
                    this.headUrlsBuilder_ = new RepeatedFieldBuilderV3(this.headUrls_, (this.bitField0_ & 0x10) != 0, this.getParentForChildren(), this.isClean());
                    this.headUrls_ = null;
                }
                return this.headUrlsBuilder_;
            }

            @Override
            public boolean getVerified() {
                return this.verified_;
            }

            public Builder setVerified(boolean value) {
                this.verified_ = value;
                this.bitField0_ |= 0x20;
                this.onChanged();
                return this;
            }

            public Builder clearVerified() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.verified_ = false;
                this.onChanged();
                return this;
            }

            @Override
            public String getSUserId() {
                Object ref = this.sUserId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.sUserId_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getSUserIdBytes() {
                Object ref = this.sUserId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.sUserId_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setSUserId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.sUserId_ = value;
                this.bitField0_ |= 0x40;
                this.onChanged();
                return this;
            }

            public Builder clearSUserId() {
                this.sUserId_ = UserInfo.getDefaultInstance().getSUserId();
                this.bitField0_ &= 0xFFFFFFBF;
                this.onChanged();
                return this;
            }

            public Builder setSUserIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                UserInfo.checkByteStringIsUtf8(value);
                this.sUserId_ = value;
                this.bitField0_ |= 0x40;
                this.onChanged();
                return this;
            }

            private void ensureHttpsHeadUrlsIsMutable() {
                if ((this.bitField0_ & 0x80) == 0) {
                    this.httpsHeadUrls_ = new ArrayList(this.httpsHeadUrls_);
                    this.bitField0_ |= 0x80;
                }
            }

            @Override
            public List<PicUrlOuterClass.PicUrl> getHttpsHeadUrlsList() {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    return Collections.unmodifiableList(this.httpsHeadUrls_);
                }
                return this.httpsHeadUrlsBuilder_.getMessageList();
            }

            @Override
            public int getHttpsHeadUrlsCount() {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    return this.httpsHeadUrls_.size();
                }
                return this.httpsHeadUrlsBuilder_.getCount();
            }

            @Override
            public PicUrlOuterClass.PicUrl getHttpsHeadUrls(int index) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    return (PicUrlOuterClass.PicUrl)this.httpsHeadUrls_.get(index);
                }
                return this.httpsHeadUrlsBuilder_.getMessage(index);
            }

            public Builder setHttpsHeadUrls(int index, PicUrlOuterClass.PicUrl value) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.set(index, (Object)value);
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setHttpsHeadUrls(int index, PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.set(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHttpsHeadUrls(PicUrlOuterClass.PicUrl value) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.add((Object)value);
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addHttpsHeadUrls(int index, PicUrlOuterClass.PicUrl value) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.add(index, (Object)value);
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addHttpsHeadUrls(PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.add((Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHttpsHeadUrls(int index, PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.add(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHttpsHeadUrls(Iterable<? extends PicUrlOuterClass.PicUrl> values) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.ensureHttpsHeadUrlsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.httpsHeadUrls_);
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHttpsHeadUrls() {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.httpsHeadUrls_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFF7F;
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.clear();
                }
                return this;
            }

            public Builder removeHttpsHeadUrls(int index) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.ensureHttpsHeadUrlsIsMutable();
                    this.httpsHeadUrls_.remove(index);
                    this.onChanged();
                } else {
                    this.httpsHeadUrlsBuilder_.remove(index);
                }
                return this;
            }

            public PicUrlOuterClass.PicUrl.Builder getHttpsHeadUrlsBuilder(int index) {
                return this.getHttpsHeadUrlsFieldBuilder().getBuilder(index);
            }

            @Override
            public PicUrlOuterClass.PicUrlOrBuilder getHttpsHeadUrlsOrBuilder(int index) {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    return (PicUrlOuterClass.PicUrlOrBuilder)this.httpsHeadUrls_.get(index);
                }
                return this.httpsHeadUrlsBuilder_.getMessageOrBuilder(index);
            }

            @Override
            public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getHttpsHeadUrlsOrBuilderList() {
                if (this.httpsHeadUrlsBuilder_ != null) {
                    return this.httpsHeadUrlsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.httpsHeadUrls_);
            }

            public PicUrlOuterClass.PicUrl.Builder addHttpsHeadUrlsBuilder() {
                return this.getHttpsHeadUrlsFieldBuilder().addBuilder(PicUrlOuterClass.PicUrl.getDefaultInstance());
            }

            public PicUrlOuterClass.PicUrl.Builder addHttpsHeadUrlsBuilder(int index) {
                return this.getHttpsHeadUrlsFieldBuilder().addBuilder(index, PicUrlOuterClass.PicUrl.getDefaultInstance());
            }

            public List<PicUrlOuterClass.PicUrl.Builder> getHttpsHeadUrlsBuilderList() {
                return this.getHttpsHeadUrlsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PicUrlOuterClass.PicUrl, PicUrlOuterClass.PicUrl.Builder, PicUrlOuterClass.PicUrlOrBuilder> getHttpsHeadUrlsFieldBuilder() {
                if (this.httpsHeadUrlsBuilder_ == null) {
                    this.httpsHeadUrlsBuilder_ = new RepeatedFieldBuilderV3(this.httpsHeadUrls_, (this.bitField0_ & 0x80) != 0, this.getParentForChildren(), this.isClean());
                    this.httpsHeadUrls_ = null;
                }
                return this.httpsHeadUrlsBuilder_;
            }

            @Override
            public String getKwaiId() {
                Object ref = this.kwaiId_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.kwaiId_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getKwaiIdBytes() {
                Object ref = this.kwaiId_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.kwaiId_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setKwaiId(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.kwaiId_ = value;
                this.bitField0_ |= 0x100;
                this.onChanged();
                return this;
            }

            public Builder clearKwaiId() {
                this.kwaiId_ = UserInfo.getDefaultInstance().getKwaiId();
                this.bitField0_ &= 0xFFFFFEFF;
                this.onChanged();
                return this;
            }

            public Builder setKwaiIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                UserInfo.checkByteStringIsUtf8(value);
                this.kwaiId_ = value;
                this.bitField0_ |= 0x100;
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

    public static interface UserInfoOrBuilder
    extends MessageOrBuilder {
        public long getUserId();

        public String getUserName();

        public ByteString getUserNameBytes();

        public String getUserGender();

        public ByteString getUserGenderBytes();

        public String getUserText();

        public ByteString getUserTextBytes();

        public List<PicUrlOuterClass.PicUrl> getHeadUrlsList();

        public PicUrlOuterClass.PicUrl getHeadUrls(int var1);

        public int getHeadUrlsCount();

        public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getHeadUrlsOrBuilderList();

        public PicUrlOuterClass.PicUrlOrBuilder getHeadUrlsOrBuilder(int var1);

        public boolean getVerified();

        public String getSUserId();

        public ByteString getSUserIdBytes();

        public List<PicUrlOuterClass.PicUrl> getHttpsHeadUrlsList();

        public PicUrlOuterClass.PicUrl getHttpsHeadUrls(int var1);

        public int getHttpsHeadUrlsCount();

        public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getHttpsHeadUrlsOrBuilderList();

        public PicUrlOuterClass.PicUrlOrBuilder getHttpsHeadUrlsOrBuilder(int var1);

        public String getKwaiId();

        public ByteString getKwaiIdBytes();
    }
}


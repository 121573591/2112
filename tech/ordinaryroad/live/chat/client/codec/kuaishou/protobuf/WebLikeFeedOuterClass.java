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
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.LiveAudienceStateOuterClass;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.SimpleUserInfoOuterClass;

public final class WebLikeFeedOuterClass {
    private static final Descriptors.Descriptor internal_static_WebLikeFeed_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WebLikeFeed_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private WebLikeFeedOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        WebLikeFeedOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nWebLikeFeed.protoSimpleUserInfo.protoLiveAudienceState.proto\"\nWebLikeFeed\n\nid (\t\nuser (2.SimpleUserInfo\n\bsortRank (\n\ndeviceHash (\t-\nliveAudienceState (2.LiveAudienceStateB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{SimpleUserInfoOuterClass.getDescriptor(), LiveAudienceStateOuterClass.getDescriptor()});
        internal_static_WebLikeFeed_descriptor = (Descriptors.Descriptor)WebLikeFeedOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_WebLikeFeed_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WebLikeFeed_descriptor, new String[]{"Id", "User", "SortRank", "DeviceHash", "LiveAudienceState"});
        SimpleUserInfoOuterClass.getDescriptor();
        LiveAudienceStateOuterClass.getDescriptor();
    }

    public static final class WebLikeFeed
    extends GeneratedMessageV3
    implements WebLikeFeedOrBuilder {
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private volatile Object id_ = "";
        public static final int USER_FIELD_NUMBER = 2;
        private SimpleUserInfoOuterClass.SimpleUserInfo user_;
        public static final int SORTRANK_FIELD_NUMBER = 3;
        private long sortRank_ = 0L;
        public static final int DEVICEHASH_FIELD_NUMBER = 4;
        private volatile Object deviceHash_ = "";
        public static final int LIVEAUDIENCESTATE_FIELD_NUMBER = 5;
        private LiveAudienceStateOuterClass.LiveAudienceState liveAudienceState_;
        private byte memoizedIsInitialized = (byte)-1;
        private static final WebLikeFeed DEFAULT_INSTANCE = new WebLikeFeed();
        private static final Parser<WebLikeFeed> PARSER = new AbstractParser<WebLikeFeed>(){

            @Override
            public WebLikeFeed parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = WebLikeFeed.newBuilder();
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

        private WebLikeFeed(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private WebLikeFeed() {
            this.id_ = "";
            this.deviceHash_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WebLikeFeed();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_WebLikeFeed_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_WebLikeFeed_fieldAccessorTable.ensureFieldAccessorsInitialized(WebLikeFeed.class, Builder.class);
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
        public boolean hasUser() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public SimpleUserInfoOuterClass.SimpleUserInfo getUser() {
            return this.user_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.user_;
        }

        @Override
        public SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder getUserOrBuilder() {
            return this.user_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.user_;
        }

        @Override
        public long getSortRank() {
            return this.sortRank_;
        }

        @Override
        public String getDeviceHash() {
            Object ref = this.deviceHash_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.deviceHash_ = s;
            return s;
        }

        @Override
        public ByteString getDeviceHashBytes() {
            Object ref = this.deviceHash_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.deviceHash_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public boolean hasLiveAudienceState() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override
        public LiveAudienceStateOuterClass.LiveAudienceState getLiveAudienceState() {
            return this.liveAudienceState_ == null ? LiveAudienceStateOuterClass.LiveAudienceState.getDefaultInstance() : this.liveAudienceState_;
        }

        @Override
        public LiveAudienceStateOuterClass.LiveAudienceStateOrBuilder getLiveAudienceStateOrBuilder() {
            return this.liveAudienceState_ == null ? LiveAudienceStateOuterClass.LiveAudienceState.getDefaultInstance() : this.liveAudienceState_;
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
                output.writeMessage(2, this.getUser());
            }
            if (this.sortRank_ != 0L) {
                output.writeUInt64(3, this.sortRank_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceHash_)) {
                GeneratedMessageV3.writeString(output, 4, this.deviceHash_);
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeMessage(5, this.getLiveAudienceState());
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
                size += CodedOutputStream.computeMessageSize(2, this.getUser());
            }
            if (this.sortRank_ != 0L) {
                size += CodedOutputStream.computeUInt64Size(3, this.sortRank_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.deviceHash_)) {
                size += GeneratedMessageV3.computeStringSize(4, this.deviceHash_);
            }
            if ((this.bitField0_ & 2) != 0) {
                size += CodedOutputStream.computeMessageSize(5, this.getLiveAudienceState());
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WebLikeFeed)) {
                return super.equals(obj);
            }
            WebLikeFeed other = (WebLikeFeed)obj;
            if (!this.getId().equals((Object)other.getId())) {
                return false;
            }
            if (this.hasUser() != other.hasUser()) {
                return false;
            }
            if (this.hasUser() && !this.getUser().equals(other.getUser())) {
                return false;
            }
            if (this.getSortRank() != other.getSortRank()) {
                return false;
            }
            if (!this.getDeviceHash().equals((Object)other.getDeviceHash())) {
                return false;
            }
            if (this.hasLiveAudienceState() != other.hasLiveAudienceState()) {
                return false;
            }
            if (this.hasLiveAudienceState() && !this.getLiveAudienceState().equals(other.getLiveAudienceState())) {
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
            hash = 19 * hash + WebLikeFeed.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getId().hashCode();
            if (this.hasUser()) {
                hash = 37 * hash + 2;
                hash = 53 * hash + this.getUser().hashCode();
            }
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashLong(this.getSortRank());
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getDeviceHash().hashCode();
            if (this.hasLiveAudienceState()) {
                hash = 37 * hash + 5;
                hash = 53 * hash + this.getLiveAudienceState().hashCode();
            }
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static WebLikeFeed parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WebLikeFeed parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebLikeFeed parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WebLikeFeed parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebLikeFeed parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WebLikeFeed parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WebLikeFeed parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WebLikeFeed parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WebLikeFeed parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WebLikeFeed parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WebLikeFeed parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WebLikeFeed parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return WebLikeFeed.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WebLikeFeed prototype) {
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

        public static WebLikeFeed getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WebLikeFeed> parser() {
            return PARSER;
        }

        public Parser<WebLikeFeed> getParserForType() {
            return PARSER;
        }

        @Override
        public WebLikeFeed getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements WebLikeFeedOrBuilder {
            private int bitField0_;
            private Object id_ = "";
            private SimpleUserInfoOuterClass.SimpleUserInfo user_;
            private SingleFieldBuilderV3<SimpleUserInfoOuterClass.SimpleUserInfo, SimpleUserInfoOuterClass.SimpleUserInfo.Builder, SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder> userBuilder_;
            private long sortRank_;
            private Object deviceHash_ = "";
            private LiveAudienceStateOuterClass.LiveAudienceState liveAudienceState_;
            private SingleFieldBuilderV3<LiveAudienceStateOuterClass.LiveAudienceState, LiveAudienceStateOuterClass.LiveAudienceState.Builder, LiveAudienceStateOuterClass.LiveAudienceStateOrBuilder> liveAudienceStateBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_WebLikeFeed_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_WebLikeFeed_fieldAccessorTable.ensureFieldAccessorsInitialized(WebLikeFeed.class, Builder.class);
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
                    this.getUserFieldBuilder();
                    this.getLiveAudienceStateFieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.id_ = "";
                this.user_ = null;
                if (this.userBuilder_ != null) {
                    this.userBuilder_.dispose();
                    this.userBuilder_ = null;
                }
                this.sortRank_ = 0L;
                this.deviceHash_ = "";
                this.liveAudienceState_ = null;
                if (this.liveAudienceStateBuilder_ != null) {
                    this.liveAudienceStateBuilder_.dispose();
                    this.liveAudienceStateBuilder_ = null;
                }
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_WebLikeFeed_descriptor;
            }

            @Override
            public WebLikeFeed getDefaultInstanceForType() {
                return WebLikeFeed.getDefaultInstance();
            }

            @Override
            public WebLikeFeed build() {
                WebLikeFeed result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public WebLikeFeed buildPartial() {
                WebLikeFeed result = new WebLikeFeed(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(WebLikeFeed result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.id_ = this.id_;
                }
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 2) != 0) {
                    result.user_ = this.userBuilder_ == null ? this.user_ : this.userBuilder_.build();
                    to_bitField0_ |= 1;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.sortRank_ = this.sortRank_;
                }
                if ((from_bitField0_ & 8) != 0) {
                    result.deviceHash_ = this.deviceHash_;
                }
                if ((from_bitField0_ & 0x10) != 0) {
                    result.liveAudienceState_ = this.liveAudienceStateBuilder_ == null ? this.liveAudienceState_ : this.liveAudienceStateBuilder_.build();
                    to_bitField0_ |= 2;
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
                if (other instanceof WebLikeFeed) {
                    return this.mergeFrom((WebLikeFeed)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WebLikeFeed other) {
                if (other == WebLikeFeed.getDefaultInstance()) {
                    return this;
                }
                if (!other.getId().isEmpty()) {
                    this.id_ = other.id_;
                    this.bitField0_ |= 1;
                    this.onChanged();
                }
                if (other.hasUser()) {
                    this.mergeUser(other.getUser());
                }
                if (other.getSortRank() != 0L) {
                    this.setSortRank(other.getSortRank());
                }
                if (!other.getDeviceHash().isEmpty()) {
                    this.deviceHash_ = other.deviceHash_;
                    this.bitField0_ |= 8;
                    this.onChanged();
                }
                if (other.hasLiveAudienceState()) {
                    this.mergeLiveAudienceState(other.getLiveAudienceState());
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
                    block13: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block13;
                            }
                            case 10: {
                                this.id_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                                continue block13;
                            }
                            case 18: {
                                input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 2;
                                continue block13;
                            }
                            case 24: {
                                this.sortRank_ = input.readUInt64();
                                this.bitField0_ |= 4;
                                continue block13;
                            }
                            case 34: {
                                this.deviceHash_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 8;
                                continue block13;
                            }
                            case 42: {
                                input.readMessage(this.getLiveAudienceStateFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 0x10;
                                continue block13;
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
                this.id_ = WebLikeFeed.getDefaultInstance().getId();
                this.bitField0_ &= 0xFFFFFFFE;
                this.onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                WebLikeFeed.checkByteStringIsUtf8(value);
                this.id_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            @Override
            public boolean hasUser() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override
            public SimpleUserInfoOuterClass.SimpleUserInfo getUser() {
                if (this.userBuilder_ == null) {
                    return this.user_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.user_;
                }
                return this.userBuilder_.getMessage();
            }

            public Builder setUser(SimpleUserInfoOuterClass.SimpleUserInfo value) {
                if (this.userBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.user_ = value;
                } else {
                    this.userBuilder_.setMessage(value);
                }
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder setUser(SimpleUserInfoOuterClass.SimpleUserInfo.Builder builderForValue) {
                if (this.userBuilder_ == null) {
                    this.user_ = builderForValue.build();
                } else {
                    this.userBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder mergeUser(SimpleUserInfoOuterClass.SimpleUserInfo value) {
                if (this.userBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0 && this.user_ != null && this.user_ != SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance()) {
                        this.getUserBuilder().mergeFrom(value);
                    } else {
                        this.user_ = value;
                    }
                } else {
                    this.userBuilder_.mergeFrom(value);
                }
                if (this.user_ != null) {
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                return this;
            }

            public Builder clearUser() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.user_ = null;
                if (this.userBuilder_ != null) {
                    this.userBuilder_.dispose();
                    this.userBuilder_ = null;
                }
                this.onChanged();
                return this;
            }

            public SimpleUserInfoOuterClass.SimpleUserInfo.Builder getUserBuilder() {
                this.bitField0_ |= 2;
                this.onChanged();
                return this.getUserFieldBuilder().getBuilder();
            }

            @Override
            public SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder getUserOrBuilder() {
                if (this.userBuilder_ != null) {
                    return this.userBuilder_.getMessageOrBuilder();
                }
                return this.user_ == null ? SimpleUserInfoOuterClass.SimpleUserInfo.getDefaultInstance() : this.user_;
            }

            private SingleFieldBuilderV3<SimpleUserInfoOuterClass.SimpleUserInfo, SimpleUserInfoOuterClass.SimpleUserInfo.Builder, SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder> getUserFieldBuilder() {
                if (this.userBuilder_ == null) {
                    this.userBuilder_ = new SingleFieldBuilderV3(this.getUser(), this.getParentForChildren(), this.isClean());
                    this.user_ = null;
                }
                return this.userBuilder_;
            }

            @Override
            public long getSortRank() {
                return this.sortRank_;
            }

            public Builder setSortRank(long value) {
                this.sortRank_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearSortRank() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.sortRank_ = 0L;
                this.onChanged();
                return this;
            }

            @Override
            public String getDeviceHash() {
                Object ref = this.deviceHash_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.deviceHash_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getDeviceHashBytes() {
                Object ref = this.deviceHash_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.deviceHash_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setDeviceHash(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.deviceHash_ = value;
                this.bitField0_ |= 8;
                this.onChanged();
                return this;
            }

            public Builder clearDeviceHash() {
                this.deviceHash_ = WebLikeFeed.getDefaultInstance().getDeviceHash();
                this.bitField0_ &= 0xFFFFFFF7;
                this.onChanged();
                return this;
            }

            public Builder setDeviceHashBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                WebLikeFeed.checkByteStringIsUtf8(value);
                this.deviceHash_ = value;
                this.bitField0_ |= 8;
                this.onChanged();
                return this;
            }

            @Override
            public boolean hasLiveAudienceState() {
                return (this.bitField0_ & 0x10) != 0;
            }

            @Override
            public LiveAudienceStateOuterClass.LiveAudienceState getLiveAudienceState() {
                if (this.liveAudienceStateBuilder_ == null) {
                    return this.liveAudienceState_ == null ? LiveAudienceStateOuterClass.LiveAudienceState.getDefaultInstance() : this.liveAudienceState_;
                }
                return this.liveAudienceStateBuilder_.getMessage();
            }

            public Builder setLiveAudienceState(LiveAudienceStateOuterClass.LiveAudienceState value) {
                if (this.liveAudienceStateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.liveAudienceState_ = value;
                } else {
                    this.liveAudienceStateBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this;
            }

            public Builder setLiveAudienceState(LiveAudienceStateOuterClass.LiveAudienceState.Builder builderForValue) {
                if (this.liveAudienceStateBuilder_ == null) {
                    this.liveAudienceState_ = builderForValue.build();
                } else {
                    this.liveAudienceStateBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this;
            }

            public Builder mergeLiveAudienceState(LiveAudienceStateOuterClass.LiveAudienceState value) {
                if (this.liveAudienceStateBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) != 0 && this.liveAudienceState_ != null && this.liveAudienceState_ != LiveAudienceStateOuterClass.LiveAudienceState.getDefaultInstance()) {
                        this.getLiveAudienceStateBuilder().mergeFrom(value);
                    } else {
                        this.liveAudienceState_ = value;
                    }
                } else {
                    this.liveAudienceStateBuilder_.mergeFrom(value);
                }
                if (this.liveAudienceState_ != null) {
                    this.bitField0_ |= 0x10;
                    this.onChanged();
                }
                return this;
            }

            public Builder clearLiveAudienceState() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.liveAudienceState_ = null;
                if (this.liveAudienceStateBuilder_ != null) {
                    this.liveAudienceStateBuilder_.dispose();
                    this.liveAudienceStateBuilder_ = null;
                }
                this.onChanged();
                return this;
            }

            public LiveAudienceStateOuterClass.LiveAudienceState.Builder getLiveAudienceStateBuilder() {
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this.getLiveAudienceStateFieldBuilder().getBuilder();
            }

            @Override
            public LiveAudienceStateOuterClass.LiveAudienceStateOrBuilder getLiveAudienceStateOrBuilder() {
                if (this.liveAudienceStateBuilder_ != null) {
                    return this.liveAudienceStateBuilder_.getMessageOrBuilder();
                }
                return this.liveAudienceState_ == null ? LiveAudienceStateOuterClass.LiveAudienceState.getDefaultInstance() : this.liveAudienceState_;
            }

            private SingleFieldBuilderV3<LiveAudienceStateOuterClass.LiveAudienceState, LiveAudienceStateOuterClass.LiveAudienceState.Builder, LiveAudienceStateOuterClass.LiveAudienceStateOrBuilder> getLiveAudienceStateFieldBuilder() {
                if (this.liveAudienceStateBuilder_ == null) {
                    this.liveAudienceStateBuilder_ = new SingleFieldBuilderV3(this.getLiveAudienceState(), this.getParentForChildren(), this.isClean());
                    this.liveAudienceState_ = null;
                }
                return this.liveAudienceStateBuilder_;
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

    public static interface WebLikeFeedOrBuilder
    extends MessageOrBuilder {
        public String getId();

        public ByteString getIdBytes();

        public boolean hasUser();

        public SimpleUserInfoOuterClass.SimpleUserInfo getUser();

        public SimpleUserInfoOuterClass.SimpleUserInfoOrBuilder getUserOrBuilder();

        public long getSortRank();

        public String getDeviceHash();

        public ByteString getDeviceHashBytes();

        public boolean hasLiveAudienceState();

        public LiveAudienceStateOuterClass.LiveAudienceState getLiveAudienceState();

        public LiveAudienceStateOuterClass.LiveAudienceStateOrBuilder getLiveAudienceStateOrBuilder();
    }
}


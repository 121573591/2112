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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.FollowInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Tiktok;

public final class FollowInfo
extends GeneratedMessageV3
implements FollowInfoOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int FOLLOWINGCOUNT_FIELD_NUMBER = 1;
    private long followingCount_ = 0L;
    public static final int FOLLOWERCOUNT_FIELD_NUMBER = 2;
    private long followerCount_ = 0L;
    private byte memoizedIsInitialized = (byte)-1;
    private static final FollowInfo DEFAULT_INSTANCE = new FollowInfo();
    private static final Parser<FollowInfo> PARSER = new AbstractParser<FollowInfo>(){

        @Override
        public FollowInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = FollowInfo.newBuilder();
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

    private FollowInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private FollowInfo() {
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new FollowInfo();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Tiktok.internal_static_FollowInfo_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Tiktok.internal_static_FollowInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FollowInfo.class, Builder.class);
    }

    @Override
    public long getFollowingCount() {
        return this.followingCount_;
    }

    @Override
    public long getFollowerCount() {
        return this.followerCount_;
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
        if (this.followingCount_ != 0L) {
            output.writeUInt64(1, this.followingCount_);
        }
        if (this.followerCount_ != 0L) {
            output.writeUInt64(2, this.followerCount_);
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
        if (this.followingCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(1, this.followingCount_);
        }
        if (this.followerCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(2, this.followerCount_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FollowInfo)) {
            return super.equals(obj);
        }
        FollowInfo other = (FollowInfo)obj;
        if (this.getFollowingCount() != other.getFollowingCount()) {
            return false;
        }
        if (this.getFollowerCount() != other.getFollowerCount()) {
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
        hash = 19 * hash + FollowInfo.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + Internal.hashLong(this.getFollowingCount());
        hash = 37 * hash + 2;
        hash = 53 * hash + Internal.hashLong(this.getFollowerCount());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static FollowInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FollowInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FollowInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FollowInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FollowInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static FollowInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static FollowInfo parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FollowInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static FollowInfo parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static FollowInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static FollowInfo parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static FollowInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return FollowInfo.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FollowInfo prototype) {
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

    public static FollowInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FollowInfo> parser() {
        return PARSER;
    }

    public Parser<FollowInfo> getParserForType() {
        return PARSER;
    }

    @Override
    public FollowInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements FollowInfoOrBuilder {
        private int bitField0_;
        private long followingCount_;
        private long followerCount_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Tiktok.internal_static_FollowInfo_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Tiktok.internal_static_FollowInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FollowInfo.class, Builder.class);
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
            this.followingCount_ = 0L;
            this.followerCount_ = 0L;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Tiktok.internal_static_FollowInfo_descriptor;
        }

        @Override
        public FollowInfo getDefaultInstanceForType() {
            return FollowInfo.getDefaultInstance();
        }

        @Override
        public FollowInfo build() {
            FollowInfo result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public FollowInfo buildPartial() {
            FollowInfo result = new FollowInfo(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(FollowInfo result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.followingCount_ = this.followingCount_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.followerCount_ = this.followerCount_;
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
            if (other instanceof FollowInfo) {
                return this.mergeFrom((FollowInfo)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(FollowInfo other) {
            if (other == FollowInfo.getDefaultInstance()) {
                return this;
            }
            if (other.getFollowingCount() != 0L) {
                this.setFollowingCount(other.getFollowingCount());
            }
            if (other.getFollowerCount() != 0L) {
                this.setFollowerCount(other.getFollowerCount());
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
                            this.followingCount_ = input.readUInt64();
                            this.bitField0_ |= 1;
                            continue block10;
                        }
                        case 16: {
                            this.followerCount_ = input.readUInt64();
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
        public long getFollowingCount() {
            return this.followingCount_;
        }

        public Builder setFollowingCount(long value) {
            this.followingCount_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearFollowingCount() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.followingCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getFollowerCount() {
            return this.followerCount_;
        }

        public Builder setFollowerCount(long value) {
            this.followerCount_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearFollowerCount() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.followerCount_ = 0L;
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


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
 *  java.util.Collection
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.NinePatchSettingOrBuilder;

public final class NinePatchSetting
extends GeneratedMessageV3
implements NinePatchSettingOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int SETTINGLISTLIST_FIELD_NUMBER = 1;
    private LazyStringArrayList settingListList_ = LazyStringArrayList.emptyList();
    private byte memoizedIsInitialized = (byte)-1;
    private static final NinePatchSetting DEFAULT_INSTANCE = new NinePatchSetting();
    private static final Parser<NinePatchSetting> PARSER = new AbstractParser<NinePatchSetting>(){

        @Override
        public NinePatchSetting parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = NinePatchSetting.newBuilder();
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

    private NinePatchSetting(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private NinePatchSetting() {
        this.settingListList_ = LazyStringArrayList.emptyList();
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new NinePatchSetting();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_NinePatchSetting_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_NinePatchSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(NinePatchSetting.class, Builder.class);
    }

    public ProtocolStringList getSettingListListList() {
        return this.settingListList_;
    }

    @Override
    public int getSettingListListCount() {
        return this.settingListList_.size();
    }

    @Override
    public String getSettingListList(int index) {
        return this.settingListList_.get(index);
    }

    @Override
    public ByteString getSettingListListBytes(int index) {
        return this.settingListList_.getByteString(index);
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
        for (int i = 0; i < this.settingListList_.size(); ++i) {
            GeneratedMessageV3.writeString(output, 1, this.settingListList_.getRaw(i));
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
        int dataSize = 0;
        for (int i = 0; i < this.settingListList_.size(); ++i) {
            dataSize += NinePatchSetting.computeStringSizeNoTag(this.settingListList_.getRaw(i));
        }
        size += dataSize;
        size += 1 * this.getSettingListListList().size();
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NinePatchSetting)) {
            return super.equals(obj);
        }
        NinePatchSetting other = (NinePatchSetting)obj;
        if (!this.getSettingListListList().equals(other.getSettingListListList())) {
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
        hash = 19 * hash + NinePatchSetting.getDescriptor().hashCode();
        if (this.getSettingListListCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getSettingListListList().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static NinePatchSetting parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static NinePatchSetting parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static NinePatchSetting parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static NinePatchSetting parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static NinePatchSetting parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static NinePatchSetting parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static NinePatchSetting parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static NinePatchSetting parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static NinePatchSetting parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static NinePatchSetting parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static NinePatchSetting parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static NinePatchSetting parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return NinePatchSetting.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(NinePatchSetting prototype) {
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

    public static NinePatchSetting getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<NinePatchSetting> parser() {
        return PARSER;
    }

    public Parser<NinePatchSetting> getParserForType() {
        return PARSER;
    }

    @Override
    public NinePatchSetting getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements NinePatchSettingOrBuilder {
        private int bitField0_;
        private LazyStringArrayList settingListList_ = LazyStringArrayList.emptyList();

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_NinePatchSetting_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_NinePatchSetting_fieldAccessorTable.ensureFieldAccessorsInitialized(NinePatchSetting.class, Builder.class);
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
            this.settingListList_ = LazyStringArrayList.emptyList();
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_NinePatchSetting_descriptor;
        }

        @Override
        public NinePatchSetting getDefaultInstanceForType() {
            return NinePatchSetting.getDefaultInstance();
        }

        @Override
        public NinePatchSetting build() {
            NinePatchSetting result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public NinePatchSetting buildPartial() {
            NinePatchSetting result = new NinePatchSetting(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(NinePatchSetting result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                this.settingListList_.makeImmutable();
                result.settingListList_ = this.settingListList_;
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
            if (other instanceof NinePatchSetting) {
                return this.mergeFrom((NinePatchSetting)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(NinePatchSetting other) {
            if (other == NinePatchSetting.getDefaultInstance()) {
                return this;
            }
            if (!other.settingListList_.isEmpty()) {
                if (this.settingListList_.isEmpty()) {
                    this.settingListList_ = other.settingListList_;
                    this.bitField0_ |= 1;
                } else {
                    this.ensureSettingListListIsMutable();
                    this.settingListList_.addAll((Collection<? extends String>)other.settingListList_);
                }
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
                block9: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block9;
                        }
                        case 10: {
                            String s = input.readStringRequireUtf8();
                            this.ensureSettingListListIsMutable();
                            this.settingListList_.add(s);
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

        private void ensureSettingListListIsMutable() {
            if (!this.settingListList_.isModifiable()) {
                this.settingListList_ = new LazyStringArrayList(this.settingListList_);
            }
            this.bitField0_ |= 1;
        }

        public ProtocolStringList getSettingListListList() {
            this.settingListList_.makeImmutable();
            return this.settingListList_;
        }

        @Override
        public int getSettingListListCount() {
            return this.settingListList_.size();
        }

        @Override
        public String getSettingListList(int index) {
            return this.settingListList_.get(index);
        }

        @Override
        public ByteString getSettingListListBytes(int index) {
            return this.settingListList_.getByteString(index);
        }

        public Builder setSettingListList(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureSettingListListIsMutable();
            this.settingListList_.set(index, value);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder addSettingListList(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureSettingListListIsMutable();
            this.settingListList_.add(value);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder addAllSettingListList(Iterable<String> values) {
            this.ensureSettingListListIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.settingListList_);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearSettingListList() {
            this.settingListList_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
            return this;
        }

        public Builder addSettingListListBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            NinePatchSetting.checkByteStringIsUtf8(value);
            this.ensureSettingListListIsMutable();
            this.settingListList_.add(value);
            this.bitField0_ |= 1;
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


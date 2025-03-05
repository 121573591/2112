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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageContent;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageContentOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.NinePatchSetting;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.NinePatchSettingOrBuilder;

public final class Image
extends GeneratedMessageV3
implements ImageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int URLLISTLIST_FIELD_NUMBER = 1;
    private LazyStringArrayList urlListList_ = LazyStringArrayList.emptyList();
    public static final int URI_FIELD_NUMBER = 2;
    private volatile Object uri_ = "";
    public static final int HEIGHT_FIELD_NUMBER = 3;
    private long height_ = 0L;
    public static final int WIDTH_FIELD_NUMBER = 4;
    private long width_ = 0L;
    public static final int AVGCOLOR_FIELD_NUMBER = 5;
    private volatile Object avgColor_ = "";
    public static final int IMAGETYPE_FIELD_NUMBER = 6;
    private int imageType_ = 0;
    public static final int OPENWEBURL_FIELD_NUMBER = 7;
    private volatile Object openWebUrl_ = "";
    public static final int CONTENT_FIELD_NUMBER = 8;
    private ImageContent content_;
    public static final int ISANIMATED_FIELD_NUMBER = 9;
    private boolean isAnimated_ = false;
    public static final int FLEXSETTINGLIST_FIELD_NUMBER = 10;
    private NinePatchSetting flexSettingList_;
    public static final int TEXTSETTINGLIST_FIELD_NUMBER = 11;
    private NinePatchSetting textSettingList_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final Image DEFAULT_INSTANCE = new Image();
    private static final Parser<Image> PARSER = new AbstractParser<Image>(){

        @Override
        public Image parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = Image.newBuilder();
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

    private Image(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private Image() {
        this.urlListList_ = LazyStringArrayList.emptyList();
        this.uri_ = "";
        this.avgColor_ = "";
        this.openWebUrl_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new Image();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_Image_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_Image_fieldAccessorTable.ensureFieldAccessorsInitialized(Image.class, Builder.class);
    }

    public ProtocolStringList getUrlListListList() {
        return this.urlListList_;
    }

    @Override
    public int getUrlListListCount() {
        return this.urlListList_.size();
    }

    @Override
    public String getUrlListList(int index) {
        return this.urlListList_.get(index);
    }

    @Override
    public ByteString getUrlListListBytes(int index) {
        return this.urlListList_.getByteString(index);
    }

    @Override
    public String getUri() {
        Object ref = this.uri_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.uri_ = s;
        return s;
    }

    @Override
    public ByteString getUriBytes() {
        Object ref = this.uri_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.uri_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getHeight() {
        return this.height_;
    }

    @Override
    public long getWidth() {
        return this.width_;
    }

    @Override
    public String getAvgColor() {
        Object ref = this.avgColor_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.avgColor_ = s;
        return s;
    }

    @Override
    public ByteString getAvgColorBytes() {
        Object ref = this.avgColor_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.avgColor_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public int getImageType() {
        return this.imageType_;
    }

    @Override
    public String getOpenWebUrl() {
        Object ref = this.openWebUrl_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.openWebUrl_ = s;
        return s;
    }

    @Override
    public ByteString getOpenWebUrlBytes() {
        Object ref = this.openWebUrl_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.openWebUrl_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public boolean hasContent() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public ImageContent getContent() {
        return this.content_ == null ? ImageContent.getDefaultInstance() : this.content_;
    }

    @Override
    public ImageContentOrBuilder getContentOrBuilder() {
        return this.content_ == null ? ImageContent.getDefaultInstance() : this.content_;
    }

    @Override
    public boolean getIsAnimated() {
        return this.isAnimated_;
    }

    @Override
    public boolean hasFlexSettingList() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public NinePatchSetting getFlexSettingList() {
        return this.flexSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.flexSettingList_;
    }

    @Override
    public NinePatchSettingOrBuilder getFlexSettingListOrBuilder() {
        return this.flexSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.flexSettingList_;
    }

    @Override
    public boolean hasTextSettingList() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public NinePatchSetting getTextSettingList() {
        return this.textSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.textSettingList_;
    }

    @Override
    public NinePatchSettingOrBuilder getTextSettingListOrBuilder() {
        return this.textSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.textSettingList_;
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
        for (int i = 0; i < this.urlListList_.size(); ++i) {
            GeneratedMessageV3.writeString(output, 1, this.urlListList_.getRaw(i));
        }
        if (!GeneratedMessageV3.isStringEmpty(this.uri_)) {
            GeneratedMessageV3.writeString(output, 2, this.uri_);
        }
        if (this.height_ != 0L) {
            output.writeUInt64(3, this.height_);
        }
        if (this.width_ != 0L) {
            output.writeUInt64(4, this.width_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.avgColor_)) {
            GeneratedMessageV3.writeString(output, 5, this.avgColor_);
        }
        if (this.imageType_ != 0) {
            output.writeUInt32(6, this.imageType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.openWebUrl_)) {
            GeneratedMessageV3.writeString(output, 7, this.openWebUrl_);
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(8, this.getContent());
        }
        if (this.isAnimated_) {
            output.writeBool(9, this.isAnimated_);
        }
        if ((this.bitField0_ & 2) != 0) {
            output.writeMessage(10, this.getFlexSettingList());
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(11, this.getTextSettingList());
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
        for (int i = 0; i < this.urlListList_.size(); ++i) {
            dataSize += Image.computeStringSizeNoTag(this.urlListList_.getRaw(i));
        }
        size += dataSize;
        size += 1 * this.getUrlListListList().size();
        if (!GeneratedMessageV3.isStringEmpty(this.uri_)) {
            size += GeneratedMessageV3.computeStringSize(2, this.uri_);
        }
        if (this.height_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.height_);
        }
        if (this.width_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(4, this.width_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.avgColor_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.avgColor_);
        }
        if (this.imageType_ != 0) {
            size += CodedOutputStream.computeUInt32Size(6, this.imageType_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.openWebUrl_)) {
            size += GeneratedMessageV3.computeStringSize(7, this.openWebUrl_);
        }
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(8, this.getContent());
        }
        if (this.isAnimated_) {
            size += CodedOutputStream.computeBoolSize(9, this.isAnimated_);
        }
        if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(10, this.getFlexSettingList());
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(11, this.getTextSettingList());
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Image)) {
            return super.equals(obj);
        }
        Image other = (Image)obj;
        if (!this.getUrlListListList().equals(other.getUrlListListList())) {
            return false;
        }
        if (!this.getUri().equals((Object)other.getUri())) {
            return false;
        }
        if (this.getHeight() != other.getHeight()) {
            return false;
        }
        if (this.getWidth() != other.getWidth()) {
            return false;
        }
        if (!this.getAvgColor().equals((Object)other.getAvgColor())) {
            return false;
        }
        if (this.getImageType() != other.getImageType()) {
            return false;
        }
        if (!this.getOpenWebUrl().equals((Object)other.getOpenWebUrl())) {
            return false;
        }
        if (this.hasContent() != other.hasContent()) {
            return false;
        }
        if (this.hasContent() && !this.getContent().equals(other.getContent())) {
            return false;
        }
        if (this.getIsAnimated() != other.getIsAnimated()) {
            return false;
        }
        if (this.hasFlexSettingList() != other.hasFlexSettingList()) {
            return false;
        }
        if (this.hasFlexSettingList() && !this.getFlexSettingList().equals(other.getFlexSettingList())) {
            return false;
        }
        if (this.hasTextSettingList() != other.hasTextSettingList()) {
            return false;
        }
        if (this.hasTextSettingList() && !this.getTextSettingList().equals(other.getTextSettingList())) {
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
        hash = 19 * hash + Image.getDescriptor().hashCode();
        if (this.getUrlListListCount() > 0) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getUrlListListList().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getUri().hashCode();
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getHeight());
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getWidth());
        hash = 37 * hash + 5;
        hash = 53 * hash + this.getAvgColor().hashCode();
        hash = 37 * hash + 6;
        hash = 53 * hash + this.getImageType();
        hash = 37 * hash + 7;
        hash = 53 * hash + this.getOpenWebUrl().hashCode();
        if (this.hasContent()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getContent().hashCode();
        }
        hash = 37 * hash + 9;
        hash = 53 * hash + Internal.hashBoolean(this.getIsAnimated());
        if (this.hasFlexSettingList()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getFlexSettingList().hashCode();
        }
        if (this.hasTextSettingList()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getTextSettingList().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static Image parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Image parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Image parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Image parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Image parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static Image parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static Image parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Image parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Image parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static Image parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static Image parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static Image parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return Image.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(Image prototype) {
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

    public static Image getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Image> parser() {
        return PARSER;
    }

    public Parser<Image> getParserForType() {
        return PARSER;
    }

    @Override
    public Image getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements ImageOrBuilder {
        private int bitField0_;
        private LazyStringArrayList urlListList_ = LazyStringArrayList.emptyList();
        private Object uri_ = "";
        private long height_;
        private long width_;
        private Object avgColor_ = "";
        private int imageType_;
        private Object openWebUrl_ = "";
        private ImageContent content_;
        private SingleFieldBuilderV3<ImageContent, ImageContent.Builder, ImageContentOrBuilder> contentBuilder_;
        private boolean isAnimated_;
        private NinePatchSetting flexSettingList_;
        private SingleFieldBuilderV3<NinePatchSetting, NinePatchSetting.Builder, NinePatchSettingOrBuilder> flexSettingListBuilder_;
        private NinePatchSetting textSettingList_;
        private SingleFieldBuilderV3<NinePatchSetting, NinePatchSetting.Builder, NinePatchSettingOrBuilder> textSettingListBuilder_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_Image_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_Image_fieldAccessorTable.ensureFieldAccessorsInitialized(Image.class, Builder.class);
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
                this.getContentFieldBuilder();
                this.getFlexSettingListFieldBuilder();
                this.getTextSettingListFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.urlListList_ = LazyStringArrayList.emptyList();
            this.uri_ = "";
            this.height_ = 0L;
            this.width_ = 0L;
            this.avgColor_ = "";
            this.imageType_ = 0;
            this.openWebUrl_ = "";
            this.content_ = null;
            if (this.contentBuilder_ != null) {
                this.contentBuilder_.dispose();
                this.contentBuilder_ = null;
            }
            this.isAnimated_ = false;
            this.flexSettingList_ = null;
            if (this.flexSettingListBuilder_ != null) {
                this.flexSettingListBuilder_.dispose();
                this.flexSettingListBuilder_ = null;
            }
            this.textSettingList_ = null;
            if (this.textSettingListBuilder_ != null) {
                this.textSettingListBuilder_.dispose();
                this.textSettingListBuilder_ = null;
            }
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_Image_descriptor;
        }

        @Override
        public Image getDefaultInstanceForType() {
            return Image.getDefaultInstance();
        }

        @Override
        public Image build() {
            Image result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public Image buildPartial() {
            Image result = new Image(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(Image result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                this.urlListList_.makeImmutable();
                result.urlListList_ = this.urlListList_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.uri_ = this.uri_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.height_ = this.height_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.width_ = this.width_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.avgColor_ = this.avgColor_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.imageType_ = this.imageType_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.openWebUrl_ = this.openWebUrl_;
            }
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 0x80) != 0) {
                result.content_ = this.contentBuilder_ == null ? this.content_ : this.contentBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.isAnimated_ = this.isAnimated_;
            }
            if ((from_bitField0_ & 0x200) != 0) {
                result.flexSettingList_ = this.flexSettingListBuilder_ == null ? this.flexSettingList_ : this.flexSettingListBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 0x400) != 0) {
                result.textSettingList_ = this.textSettingListBuilder_ == null ? this.textSettingList_ : this.textSettingListBuilder_.build();
                to_bitField0_ |= 4;
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
            if (other instanceof Image) {
                return this.mergeFrom((Image)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(Image other) {
            if (other == Image.getDefaultInstance()) {
                return this;
            }
            if (!other.urlListList_.isEmpty()) {
                if (this.urlListList_.isEmpty()) {
                    this.urlListList_ = other.urlListList_;
                    this.bitField0_ |= 1;
                } else {
                    this.ensureUrlListListIsMutable();
                    this.urlListList_.addAll((Collection<? extends String>)other.urlListList_);
                }
                this.onChanged();
            }
            if (!other.getUri().isEmpty()) {
                this.uri_ = other.uri_;
                this.bitField0_ |= 2;
                this.onChanged();
            }
            if (other.getHeight() != 0L) {
                this.setHeight(other.getHeight());
            }
            if (other.getWidth() != 0L) {
                this.setWidth(other.getWidth());
            }
            if (!other.getAvgColor().isEmpty()) {
                this.avgColor_ = other.avgColor_;
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            if (other.getImageType() != 0) {
                this.setImageType(other.getImageType());
            }
            if (!other.getOpenWebUrl().isEmpty()) {
                this.openWebUrl_ = other.openWebUrl_;
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            if (other.hasContent()) {
                this.mergeContent(other.getContent());
            }
            if (other.getIsAnimated()) {
                this.setIsAnimated(other.getIsAnimated());
            }
            if (other.hasFlexSettingList()) {
                this.mergeFlexSettingList(other.getFlexSettingList());
            }
            if (other.hasTextSettingList()) {
                this.mergeTextSettingList(other.getTextSettingList());
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
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        case 10: {
                            String s = input.readStringRequireUtf8();
                            this.ensureUrlListListIsMutable();
                            this.urlListList_.add(s);
                            continue block19;
                        }
                        case 18: {
                            this.uri_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 2;
                            continue block19;
                        }
                        case 24: {
                            this.height_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block19;
                        }
                        case 32: {
                            this.width_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block19;
                        }
                        case 42: {
                            this.avgColor_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x10;
                            continue block19;
                        }
                        case 48: {
                            this.imageType_ = input.readUInt32();
                            this.bitField0_ |= 0x20;
                            continue block19;
                        }
                        case 58: {
                            this.openWebUrl_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x40;
                            continue block19;
                        }
                        case 66: {
                            input.readMessage(this.getContentFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x80;
                            continue block19;
                        }
                        case 72: {
                            this.isAnimated_ = input.readBool();
                            this.bitField0_ |= 0x100;
                            continue block19;
                        }
                        case 82: {
                            input.readMessage(this.getFlexSettingListFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x200;
                            continue block19;
                        }
                        case 90: {
                            input.readMessage(this.getTextSettingListFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x400;
                            continue block19;
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

        private void ensureUrlListListIsMutable() {
            if (!this.urlListList_.isModifiable()) {
                this.urlListList_ = new LazyStringArrayList(this.urlListList_);
            }
            this.bitField0_ |= 1;
        }

        public ProtocolStringList getUrlListListList() {
            this.urlListList_.makeImmutable();
            return this.urlListList_;
        }

        @Override
        public int getUrlListListCount() {
            return this.urlListList_.size();
        }

        @Override
        public String getUrlListList(int index) {
            return this.urlListList_.get(index);
        }

        @Override
        public ByteString getUrlListListBytes(int index) {
            return this.urlListList_.getByteString(index);
        }

        public Builder setUrlListList(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureUrlListListIsMutable();
            this.urlListList_.set(index, value);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder addUrlListList(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.ensureUrlListListIsMutable();
            this.urlListList_.add(value);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder addAllUrlListList(Iterable<String> values) {
            this.ensureUrlListListIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.urlListList_);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearUrlListList() {
            this.urlListList_ = LazyStringArrayList.emptyList();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
            return this;
        }

        public Builder addUrlListListBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            Image.checkByteStringIsUtf8(value);
            this.ensureUrlListListIsMutable();
            this.urlListList_.add(value);
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        @Override
        public String getUri() {
            Object ref = this.uri_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.uri_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getUriBytes() {
            Object ref = this.uri_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.uri_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setUri(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.uri_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearUri() {
            this.uri_ = Image.getDefaultInstance().getUri();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setUriBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            Image.checkByteStringIsUtf8(value);
            this.uri_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        @Override
        public long getHeight() {
            return this.height_;
        }

        public Builder setHeight(long value) {
            this.height_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearHeight() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.height_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getWidth() {
            return this.width_;
        }

        public Builder setWidth(long value) {
            this.width_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearWidth() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.width_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public String getAvgColor() {
            Object ref = this.avgColor_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.avgColor_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getAvgColorBytes() {
            Object ref = this.avgColor_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.avgColor_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setAvgColor(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.avgColor_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearAvgColor() {
            this.avgColor_ = Image.getDefaultInstance().getAvgColor();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        public Builder setAvgColorBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            Image.checkByteStringIsUtf8(value);
            this.avgColor_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        @Override
        public int getImageType() {
            return this.imageType_;
        }

        public Builder setImageType(int value) {
            this.imageType_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearImageType() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.imageType_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public String getOpenWebUrl() {
            Object ref = this.openWebUrl_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.openWebUrl_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getOpenWebUrlBytes() {
            Object ref = this.openWebUrl_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.openWebUrl_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setOpenWebUrl(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.openWebUrl_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearOpenWebUrl() {
            this.openWebUrl_ = Image.getDefaultInstance().getOpenWebUrl();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
            return this;
        }

        public Builder setOpenWebUrlBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            Image.checkByteStringIsUtf8(value);
            this.openWebUrl_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasContent() {
            return (this.bitField0_ & 0x80) != 0;
        }

        @Override
        public ImageContent getContent() {
            if (this.contentBuilder_ == null) {
                return this.content_ == null ? ImageContent.getDefaultInstance() : this.content_;
            }
            return this.contentBuilder_.getMessage();
        }

        public Builder setContent(ImageContent value) {
            if (this.contentBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.content_ = value;
            } else {
                this.contentBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder setContent(ImageContent.Builder builderForValue) {
            if (this.contentBuilder_ == null) {
                this.content_ = builderForValue.build();
            } else {
                this.contentBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder mergeContent(ImageContent value) {
            if (this.contentBuilder_ == null) {
                if ((this.bitField0_ & 0x80) != 0 && this.content_ != null && this.content_ != ImageContent.getDefaultInstance()) {
                    this.getContentBuilder().mergeFrom(value);
                } else {
                    this.content_ = value;
                }
            } else {
                this.contentBuilder_.mergeFrom(value);
            }
            if (this.content_ != null) {
                this.bitField0_ |= 0x80;
                this.onChanged();
            }
            return this;
        }

        public Builder clearContent() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.content_ = null;
            if (this.contentBuilder_ != null) {
                this.contentBuilder_.dispose();
                this.contentBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public ImageContent.Builder getContentBuilder() {
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this.getContentFieldBuilder().getBuilder();
        }

        @Override
        public ImageContentOrBuilder getContentOrBuilder() {
            if (this.contentBuilder_ != null) {
                return this.contentBuilder_.getMessageOrBuilder();
            }
            return this.content_ == null ? ImageContent.getDefaultInstance() : this.content_;
        }

        private SingleFieldBuilderV3<ImageContent, ImageContent.Builder, ImageContentOrBuilder> getContentFieldBuilder() {
            if (this.contentBuilder_ == null) {
                this.contentBuilder_ = new SingleFieldBuilderV3(this.getContent(), this.getParentForChildren(), this.isClean());
                this.content_ = null;
            }
            return this.contentBuilder_;
        }

        @Override
        public boolean getIsAnimated() {
            return this.isAnimated_;
        }

        public Builder setIsAnimated(boolean value) {
            this.isAnimated_ = value;
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder clearIsAnimated() {
            this.bitField0_ &= 0xFFFFFEFF;
            this.isAnimated_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasFlexSettingList() {
            return (this.bitField0_ & 0x200) != 0;
        }

        @Override
        public NinePatchSetting getFlexSettingList() {
            if (this.flexSettingListBuilder_ == null) {
                return this.flexSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.flexSettingList_;
            }
            return this.flexSettingListBuilder_.getMessage();
        }

        public Builder setFlexSettingList(NinePatchSetting value) {
            if (this.flexSettingListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.flexSettingList_ = value;
            } else {
                this.flexSettingListBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder setFlexSettingList(NinePatchSetting.Builder builderForValue) {
            if (this.flexSettingListBuilder_ == null) {
                this.flexSettingList_ = builderForValue.build();
            } else {
                this.flexSettingListBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder mergeFlexSettingList(NinePatchSetting value) {
            if (this.flexSettingListBuilder_ == null) {
                if ((this.bitField0_ & 0x200) != 0 && this.flexSettingList_ != null && this.flexSettingList_ != NinePatchSetting.getDefaultInstance()) {
                    this.getFlexSettingListBuilder().mergeFrom(value);
                } else {
                    this.flexSettingList_ = value;
                }
            } else {
                this.flexSettingListBuilder_.mergeFrom(value);
            }
            if (this.flexSettingList_ != null) {
                this.bitField0_ |= 0x200;
                this.onChanged();
            }
            return this;
        }

        public Builder clearFlexSettingList() {
            this.bitField0_ &= 0xFFFFFDFF;
            this.flexSettingList_ = null;
            if (this.flexSettingListBuilder_ != null) {
                this.flexSettingListBuilder_.dispose();
                this.flexSettingListBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public NinePatchSetting.Builder getFlexSettingListBuilder() {
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this.getFlexSettingListFieldBuilder().getBuilder();
        }

        @Override
        public NinePatchSettingOrBuilder getFlexSettingListOrBuilder() {
            if (this.flexSettingListBuilder_ != null) {
                return this.flexSettingListBuilder_.getMessageOrBuilder();
            }
            return this.flexSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.flexSettingList_;
        }

        private SingleFieldBuilderV3<NinePatchSetting, NinePatchSetting.Builder, NinePatchSettingOrBuilder> getFlexSettingListFieldBuilder() {
            if (this.flexSettingListBuilder_ == null) {
                this.flexSettingListBuilder_ = new SingleFieldBuilderV3(this.getFlexSettingList(), this.getParentForChildren(), this.isClean());
                this.flexSettingList_ = null;
            }
            return this.flexSettingListBuilder_;
        }

        @Override
        public boolean hasTextSettingList() {
            return (this.bitField0_ & 0x400) != 0;
        }

        @Override
        public NinePatchSetting getTextSettingList() {
            if (this.textSettingListBuilder_ == null) {
                return this.textSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.textSettingList_;
            }
            return this.textSettingListBuilder_.getMessage();
        }

        public Builder setTextSettingList(NinePatchSetting value) {
            if (this.textSettingListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.textSettingList_ = value;
            } else {
                this.textSettingListBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this;
        }

        public Builder setTextSettingList(NinePatchSetting.Builder builderForValue) {
            if (this.textSettingListBuilder_ == null) {
                this.textSettingList_ = builderForValue.build();
            } else {
                this.textSettingListBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this;
        }

        public Builder mergeTextSettingList(NinePatchSetting value) {
            if (this.textSettingListBuilder_ == null) {
                if ((this.bitField0_ & 0x400) != 0 && this.textSettingList_ != null && this.textSettingList_ != NinePatchSetting.getDefaultInstance()) {
                    this.getTextSettingListBuilder().mergeFrom(value);
                } else {
                    this.textSettingList_ = value;
                }
            } else {
                this.textSettingListBuilder_.mergeFrom(value);
            }
            if (this.textSettingList_ != null) {
                this.bitField0_ |= 0x400;
                this.onChanged();
            }
            return this;
        }

        public Builder clearTextSettingList() {
            this.bitField0_ &= 0xFFFFFBFF;
            this.textSettingList_ = null;
            if (this.textSettingListBuilder_ != null) {
                this.textSettingListBuilder_.dispose();
                this.textSettingListBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public NinePatchSetting.Builder getTextSettingListBuilder() {
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this.getTextSettingListFieldBuilder().getBuilder();
        }

        @Override
        public NinePatchSettingOrBuilder getTextSettingListOrBuilder() {
            if (this.textSettingListBuilder_ != null) {
                return this.textSettingListBuilder_.getMessageOrBuilder();
            }
            return this.textSettingList_ == null ? NinePatchSetting.getDefaultInstance() : this.textSettingList_;
        }

        private SingleFieldBuilderV3<NinePatchSetting, NinePatchSetting.Builder, NinePatchSettingOrBuilder> getTextSettingListFieldBuilder() {
            if (this.textSettingListBuilder_ == null) {
                this.textSettingListBuilder_ = new SingleFieldBuilderV3(this.getTextSettingList(), this.getParentForChildren(), this.isClean());
                this.textSettingList_ = null;
            }
            return this.textSettingListBuilder_;
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


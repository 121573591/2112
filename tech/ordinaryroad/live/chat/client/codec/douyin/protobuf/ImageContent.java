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
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageContentOrBuilder;

public final class ImageContent
extends GeneratedMessageV3
implements ImageContentOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_ = "";
    public static final int FONTCOLOR_FIELD_NUMBER = 2;
    private volatile Object fontColor_ = "";
    public static final int LEVEL_FIELD_NUMBER = 3;
    private long level_ = 0L;
    public static final int ALTERNATIVETEXT_FIELD_NUMBER = 4;
    private volatile Object alternativeText_ = "";
    private byte memoizedIsInitialized = (byte)-1;
    private static final ImageContent DEFAULT_INSTANCE = new ImageContent();
    private static final Parser<ImageContent> PARSER = new AbstractParser<ImageContent>(){

        @Override
        public ImageContent parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = ImageContent.newBuilder();
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

    private ImageContent(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private ImageContent() {
        this.name_ = "";
        this.fontColor_ = "";
        this.alternativeText_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new ImageContent();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_ImageContent_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_ImageContent_fieldAccessorTable.ensureFieldAccessorsInitialized(ImageContent.class, Builder.class);
    }

    @Override
    public String getName() {
        Object ref = this.name_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.name_ = s;
        return s;
    }

    @Override
    public ByteString getNameBytes() {
        Object ref = this.name_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.name_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getFontColor() {
        Object ref = this.fontColor_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.fontColor_ = s;
        return s;
    }

    @Override
    public ByteString getFontColorBytes() {
        Object ref = this.fontColor_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.fontColor_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getLevel() {
        return this.level_;
    }

    @Override
    public String getAlternativeText() {
        Object ref = this.alternativeText_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.alternativeText_ = s;
        return s;
    }

    @Override
    public ByteString getAlternativeTextBytes() {
        Object ref = this.alternativeText_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.alternativeText_ = b;
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
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(output, 1, this.name_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.fontColor_)) {
            GeneratedMessageV3.writeString(output, 2, this.fontColor_);
        }
        if (this.level_ != 0L) {
            output.writeUInt64(3, this.level_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.alternativeText_)) {
            GeneratedMessageV3.writeString(output, 4, this.alternativeText_);
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
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            size += GeneratedMessageV3.computeStringSize(1, this.name_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.fontColor_)) {
            size += GeneratedMessageV3.computeStringSize(2, this.fontColor_);
        }
        if (this.level_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.level_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.alternativeText_)) {
            size += GeneratedMessageV3.computeStringSize(4, this.alternativeText_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageContent)) {
            return super.equals(obj);
        }
        ImageContent other = (ImageContent)obj;
        if (!this.getName().equals((Object)other.getName())) {
            return false;
        }
        if (!this.getFontColor().equals((Object)other.getFontColor())) {
            return false;
        }
        if (this.getLevel() != other.getLevel()) {
            return false;
        }
        if (!this.getAlternativeText().equals((Object)other.getAlternativeText())) {
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
        hash = 19 * hash + ImageContent.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + this.getName().hashCode();
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getFontColor().hashCode();
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getLevel());
        hash = 37 * hash + 4;
        hash = 53 * hash + this.getAlternativeText().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static ImageContent parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ImageContent parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ImageContent parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ImageContent parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ImageContent parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static ImageContent parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static ImageContent parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static ImageContent parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static ImageContent parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static ImageContent parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static ImageContent parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static ImageContent parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return ImageContent.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ImageContent prototype) {
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

    public static ImageContent getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ImageContent> parser() {
        return PARSER;
    }

    public Parser<ImageContent> getParserForType() {
        return PARSER;
    }

    @Override
    public ImageContent getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements ImageContentOrBuilder {
        private int bitField0_;
        private Object name_ = "";
        private Object fontColor_ = "";
        private long level_;
        private Object alternativeText_ = "";

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_ImageContent_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_ImageContent_fieldAccessorTable.ensureFieldAccessorsInitialized(ImageContent.class, Builder.class);
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
            this.name_ = "";
            this.fontColor_ = "";
            this.level_ = 0L;
            this.alternativeText_ = "";
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_ImageContent_descriptor;
        }

        @Override
        public ImageContent getDefaultInstanceForType() {
            return ImageContent.getDefaultInstance();
        }

        @Override
        public ImageContent build() {
            ImageContent result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public ImageContent buildPartial() {
            ImageContent result = new ImageContent(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(ImageContent result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.name_ = this.name_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.fontColor_ = this.fontColor_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.level_ = this.level_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.alternativeText_ = this.alternativeText_;
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
            if (other instanceof ImageContent) {
                return this.mergeFrom((ImageContent)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(ImageContent other) {
            if (other == ImageContent.getDefaultInstance()) {
                return this;
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                this.bitField0_ |= 1;
                this.onChanged();
            }
            if (!other.getFontColor().isEmpty()) {
                this.fontColor_ = other.fontColor_;
                this.bitField0_ |= 2;
                this.onChanged();
            }
            if (other.getLevel() != 0L) {
                this.setLevel(other.getLevel());
            }
            if (!other.getAlternativeText().isEmpty()) {
                this.alternativeText_ = other.alternativeText_;
                this.bitField0_ |= 8;
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
                block12: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block12;
                        }
                        case 10: {
                            this.name_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 1;
                            continue block12;
                        }
                        case 18: {
                            this.fontColor_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 2;
                            continue block12;
                        }
                        case 24: {
                            this.level_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block12;
                        }
                        case 34: {
                            this.alternativeText_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 8;
                            continue block12;
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
        public String getName() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.name_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.name_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.name_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ImageContent.getDefaultInstance().getName();
            this.bitField0_ &= 0xFFFFFFFE;
            this.onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ImageContent.checkByteStringIsUtf8(value);
            this.name_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        @Override
        public String getFontColor() {
            Object ref = this.fontColor_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.fontColor_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getFontColorBytes() {
            Object ref = this.fontColor_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.fontColor_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setFontColor(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.fontColor_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearFontColor() {
            this.fontColor_ = ImageContent.getDefaultInstance().getFontColor();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setFontColorBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ImageContent.checkByteStringIsUtf8(value);
            this.fontColor_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        @Override
        public long getLevel() {
            return this.level_;
        }

        public Builder setLevel(long value) {
            this.level_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearLevel() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.level_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public String getAlternativeText() {
            Object ref = this.alternativeText_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.alternativeText_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getAlternativeTextBytes() {
            Object ref = this.alternativeText_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.alternativeText_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setAlternativeText(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.alternativeText_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearAlternativeText() {
            this.alternativeText_ = ImageContent.getDefaultInstance().getAlternativeText();
            this.bitField0_ &= 0xFFFFFFF7;
            this.onChanged();
            return this;
        }

        public Builder setAlternativeTextBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            ImageContent.checkByteStringIsUtf8(value);
            this.alternativeText_ = value;
            this.bitField0_ |= 8;
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


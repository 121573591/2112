/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Float
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextPieceImageOrBuilder;

public final class TextPieceImage
extends GeneratedMessageV3
implements TextPieceImageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int IMAGE_FIELD_NUMBER = 1;
    private Image image_;
    public static final int SCALINGRATE_FIELD_NUMBER = 2;
    private float scalingRate_ = 0.0f;
    private byte memoizedIsInitialized = (byte)-1;
    private static final TextPieceImage DEFAULT_INSTANCE = new TextPieceImage();
    private static final Parser<TextPieceImage> PARSER = new AbstractParser<TextPieceImage>(){

        @Override
        public TextPieceImage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = TextPieceImage.newBuilder();
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

    private TextPieceImage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private TextPieceImage() {
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new TextPieceImage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_TextPieceImage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_TextPieceImage_fieldAccessorTable.ensureFieldAccessorsInitialized(TextPieceImage.class, Builder.class);
    }

    @Override
    public boolean hasImage() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public Image getImage() {
        return this.image_ == null ? Image.getDefaultInstance() : this.image_;
    }

    @Override
    public ImageOrBuilder getImageOrBuilder() {
        return this.image_ == null ? Image.getDefaultInstance() : this.image_;
    }

    @Override
    public float getScalingRate() {
        return this.scalingRate_;
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
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(1, this.getImage());
        }
        if (Float.floatToRawIntBits((float)this.scalingRate_) != 0) {
            output.writeFloat(2, this.scalingRate_);
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
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(1, this.getImage());
        }
        if (Float.floatToRawIntBits((float)this.scalingRate_) != 0) {
            size += CodedOutputStream.computeFloatSize(2, this.scalingRate_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextPieceImage)) {
            return super.equals(obj);
        }
        TextPieceImage other = (TextPieceImage)obj;
        if (this.hasImage() != other.hasImage()) {
            return false;
        }
        if (this.hasImage() && !this.getImage().equals(other.getImage())) {
            return false;
        }
        if (Float.floatToIntBits((float)this.getScalingRate()) != Float.floatToIntBits((float)other.getScalingRate())) {
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
        hash = 19 * hash + TextPieceImage.getDescriptor().hashCode();
        if (this.hasImage()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getImage().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + Float.floatToIntBits((float)this.getScalingRate());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static TextPieceImage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static TextPieceImage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static TextPieceImage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static TextPieceImage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static TextPieceImage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static TextPieceImage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static TextPieceImage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static TextPieceImage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static TextPieceImage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static TextPieceImage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static TextPieceImage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static TextPieceImage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return TextPieceImage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TextPieceImage prototype) {
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

    public static TextPieceImage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TextPieceImage> parser() {
        return PARSER;
    }

    public Parser<TextPieceImage> getParserForType() {
        return PARSER;
    }

    @Override
    public TextPieceImage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements TextPieceImageOrBuilder {
        private int bitField0_;
        private Image image_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> imageBuilder_;
        private float scalingRate_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_TextPieceImage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_TextPieceImage_fieldAccessorTable.ensureFieldAccessorsInitialized(TextPieceImage.class, Builder.class);
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
                this.getImageFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.image_ = null;
            if (this.imageBuilder_ != null) {
                this.imageBuilder_.dispose();
                this.imageBuilder_ = null;
            }
            this.scalingRate_ = 0.0f;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_TextPieceImage_descriptor;
        }

        @Override
        public TextPieceImage getDefaultInstanceForType() {
            return TextPieceImage.getDefaultInstance();
        }

        @Override
        public TextPieceImage build() {
            TextPieceImage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public TextPieceImage buildPartial() {
            TextPieceImage result = new TextPieceImage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(TextPieceImage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.image_ = this.imageBuilder_ == null ? this.image_ : this.imageBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.scalingRate_ = this.scalingRate_;
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
            if (other instanceof TextPieceImage) {
                return this.mergeFrom((TextPieceImage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(TextPieceImage other) {
            if (other == TextPieceImage.getDefaultInstance()) {
                return this;
            }
            if (other.hasImage()) {
                this.mergeImage(other.getImage());
            }
            if (other.getScalingRate() != 0.0f) {
                this.setScalingRate(other.getScalingRate());
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
                        case 10: {
                            input.readMessage(this.getImageFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block10;
                        }
                        case 21: {
                            this.scalingRate_ = input.readFloat();
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
        public boolean hasImage() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public Image getImage() {
            if (this.imageBuilder_ == null) {
                return this.image_ == null ? Image.getDefaultInstance() : this.image_;
            }
            return this.imageBuilder_.getMessage();
        }

        public Builder setImage(Image value) {
            if (this.imageBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.image_ = value;
            } else {
                this.imageBuilder_.setMessage(value);
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder setImage(Image.Builder builderForValue) {
            if (this.imageBuilder_ == null) {
                this.image_ = builderForValue.build();
            } else {
                this.imageBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder mergeImage(Image value) {
            if (this.imageBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0 && this.image_ != null && this.image_ != Image.getDefaultInstance()) {
                    this.getImageBuilder().mergeFrom(value);
                } else {
                    this.image_ = value;
                }
            } else {
                this.imageBuilder_.mergeFrom(value);
            }
            if (this.image_ != null) {
                this.bitField0_ |= 1;
                this.onChanged();
            }
            return this;
        }

        public Builder clearImage() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.image_ = null;
            if (this.imageBuilder_ != null) {
                this.imageBuilder_.dispose();
                this.imageBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getImageBuilder() {
            this.bitField0_ |= 1;
            this.onChanged();
            return this.getImageFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getImageOrBuilder() {
            if (this.imageBuilder_ != null) {
                return this.imageBuilder_.getMessageOrBuilder();
            }
            return this.image_ == null ? Image.getDefaultInstance() : this.image_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getImageFieldBuilder() {
            if (this.imageBuilder_ == null) {
                this.imageBuilder_ = new SingleFieldBuilderV3(this.getImage(), this.getParentForChildren(), this.isClean());
                this.image_ = null;
            }
            return this.imageBuilder_;
        }

        @Override
        public float getScalingRate() {
            return this.scalingRate_;
        }

        public Builder setScalingRate(float value) {
            this.scalingRate_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearScalingRate() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.scalingRate_ = 0.0f;
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


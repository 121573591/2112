/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.Map
 *  java.util.Map$Entry
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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldBuilder;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserBadgeOrBuilder;

public final class UserBadge
extends GeneratedMessageV3
implements UserBadgeOrBuilder {
    private static final long serialVersionUID = 0L;
    public static final int ICONS_FIELD_NUMBER = 1;
    private MapField<Integer, Image> icons_;
    public static final int TITLE_FIELD_NUMBER = 2;
    private volatile Object title_ = "";
    private byte memoizedIsInitialized = (byte)-1;
    private static final UserBadge DEFAULT_INSTANCE = new UserBadge();
    private static final Parser<UserBadge> PARSER = new AbstractParser<UserBadge>(){

        @Override
        public UserBadge parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = UserBadge.newBuilder();
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

    private UserBadge(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private UserBadge() {
        this.title_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new UserBadge();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_UserBadge_descriptor;
    }

    @Override
    protected MapFieldReflectionAccessor internalGetMapFieldReflection(int number) {
        switch (number) {
            case 1: {
                return this.internalGetIcons();
            }
        }
        throw new RuntimeException("Invalid map field number: " + number);
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_UserBadge_fieldAccessorTable.ensureFieldAccessorsInitialized(UserBadge.class, Builder.class);
    }

    private MapField<Integer, Image> internalGetIcons() {
        if (this.icons_ == null) {
            return MapField.emptyMapField(IconsDefaultEntryHolder.defaultEntry);
        }
        return this.icons_;
    }

    @Override
    public int getIconsCount() {
        return this.internalGetIcons().getMap().size();
    }

    @Override
    public boolean containsIcons(int key) {
        return this.internalGetIcons().getMap().containsKey((Object)key);
    }

    @Override
    @Deprecated
    public Map<Integer, Image> getIcons() {
        return this.getIconsMap();
    }

    @Override
    public Map<Integer, Image> getIconsMap() {
        return this.internalGetIcons().getMap();
    }

    @Override
    public Image getIconsOrDefault(int key, Image defaultValue) {
        Map<Integer, Image> map = this.internalGetIcons().getMap();
        return map.containsKey((Object)key) ? (Image)map.get((Object)key) : defaultValue;
    }

    @Override
    public Image getIconsOrThrow(int key) {
        Map<Integer, Image> map = this.internalGetIcons().getMap();
        if (!map.containsKey((Object)key)) {
            throw new IllegalArgumentException();
        }
        return (Image)map.get((Object)key);
    }

    @Override
    public String getTitle() {
        Object ref = this.title_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.title_ = s;
        return s;
    }

    @Override
    public ByteString getTitleBytes() {
        Object ref = this.title_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.title_ = b;
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
        GeneratedMessageV3.serializeIntegerMapTo(output, this.internalGetIcons(), IconsDefaultEntryHolder.defaultEntry, 1);
        if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
            GeneratedMessageV3.writeString(output, 2, this.title_);
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
        for (Map.Entry entry : this.internalGetIcons().getMap().entrySet()) {
            Message icons__ = ((MapEntry.Builder)IconsDefaultEntryHolder.defaultEntry.newBuilderForType()).setKey((Integer)entry.getKey()).setValue((Image)entry.getValue()).build();
            size += CodedOutputStream.computeMessageSize(1, icons__);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
            size += GeneratedMessageV3.computeStringSize(2, this.title_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserBadge)) {
            return super.equals(obj);
        }
        UserBadge other = (UserBadge)obj;
        if (!this.internalGetIcons().equals(other.internalGetIcons())) {
            return false;
        }
        if (!this.getTitle().equals((Object)other.getTitle())) {
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
        hash = 19 * hash + UserBadge.getDescriptor().hashCode();
        if (!this.internalGetIcons().getMap().isEmpty()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.internalGetIcons().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getTitle().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static UserBadge parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static UserBadge parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static UserBadge parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static UserBadge parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static UserBadge parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static UserBadge parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static UserBadge parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static UserBadge parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static UserBadge parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static UserBadge parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static UserBadge parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static UserBadge parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return UserBadge.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UserBadge prototype) {
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

    public static UserBadge getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<UserBadge> parser() {
        return PARSER;
    }

    public Parser<UserBadge> getParserForType() {
        return PARSER;
    }

    @Override
    public UserBadge getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements UserBadgeOrBuilder {
        private int bitField0_;
        private static final IconsConverter iconsConverter = new IconsConverter();
        private MapFieldBuilder<Integer, ImageOrBuilder, Image, Image.Builder> icons_;
        private Object title_ = "";

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_UserBadge_descriptor;
        }

        @Override
        protected MapFieldReflectionAccessor internalGetMapFieldReflection(int number) {
            switch (number) {
                case 1: {
                    return this.internalGetIcons();
                }
            }
            throw new RuntimeException("Invalid map field number: " + number);
        }

        @Override
        protected MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int number) {
            switch (number) {
                case 1: {
                    return this.internalGetMutableIcons();
                }
            }
            throw new RuntimeException("Invalid map field number: " + number);
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_UserBadge_fieldAccessorTable.ensureFieldAccessorsInitialized(UserBadge.class, Builder.class);
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
            this.internalGetMutableIcons().clear();
            this.title_ = "";
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_UserBadge_descriptor;
        }

        @Override
        public UserBadge getDefaultInstanceForType() {
            return UserBadge.getDefaultInstance();
        }

        @Override
        public UserBadge build() {
            UserBadge result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public UserBadge buildPartial() {
            UserBadge result = new UserBadge(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(UserBadge result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.icons_ = this.internalGetIcons().build(IconsDefaultEntryHolder.defaultEntry);
            }
            if ((from_bitField0_ & 2) != 0) {
                result.title_ = this.title_;
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
            if (other instanceof UserBadge) {
                return this.mergeFrom((UserBadge)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(UserBadge other) {
            if (other == UserBadge.getDefaultInstance()) {
                return this;
            }
            this.internalGetMutableIcons().mergeFrom(other.internalGetIcons());
            this.bitField0_ |= 1;
            if (!other.getTitle().isEmpty()) {
                this.title_ = other.title_;
                this.bitField0_ |= 2;
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
                block10: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block10;
                        }
                        case 10: {
                            MapEntry<Integer, Image> icons__ = input.readMessage(IconsDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                            this.internalGetMutableIcons().ensureBuilderMap().put((Object)icons__.getKey(), (Object)icons__.getValue());
                            this.bitField0_ |= 1;
                            continue block10;
                        }
                        case 18: {
                            this.title_ = input.readStringRequireUtf8();
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

        private MapFieldBuilder<Integer, ImageOrBuilder, Image, Image.Builder> internalGetIcons() {
            if (this.icons_ == null) {
                return new MapFieldBuilder<Integer, ImageOrBuilder, Image, Image.Builder>(iconsConverter);
            }
            return this.icons_;
        }

        private MapFieldBuilder<Integer, ImageOrBuilder, Image, Image.Builder> internalGetMutableIcons() {
            if (this.icons_ == null) {
                this.icons_ = new MapFieldBuilder(iconsConverter);
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this.icons_;
        }

        @Override
        public int getIconsCount() {
            return this.internalGetIcons().ensureBuilderMap().size();
        }

        @Override
        public boolean containsIcons(int key) {
            return this.internalGetIcons().ensureBuilderMap().containsKey((Object)key);
        }

        @Override
        @Deprecated
        public Map<Integer, Image> getIcons() {
            return this.getIconsMap();
        }

        @Override
        public Map<Integer, Image> getIconsMap() {
            return this.internalGetIcons().getImmutableMap();
        }

        @Override
        public Image getIconsOrDefault(int key, Image defaultValue) {
            Map<Integer, ImageOrBuilder> map = this.internalGetMutableIcons().ensureBuilderMap();
            return map.containsKey((Object)key) ? iconsConverter.build((ImageOrBuilder)map.get((Object)key)) : defaultValue;
        }

        @Override
        public Image getIconsOrThrow(int key) {
            Map<Integer, ImageOrBuilder> map = this.internalGetMutableIcons().ensureBuilderMap();
            if (!map.containsKey((Object)key)) {
                throw new IllegalArgumentException();
            }
            return iconsConverter.build((ImageOrBuilder)map.get((Object)key));
        }

        public Builder clearIcons() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.internalGetMutableIcons().clear();
            return this;
        }

        public Builder removeIcons(int key) {
            this.internalGetMutableIcons().ensureBuilderMap().remove((Object)key);
            return this;
        }

        @Deprecated
        public Map<Integer, Image> getMutableIcons() {
            this.bitField0_ |= 1;
            return this.internalGetMutableIcons().ensureMessageMap();
        }

        public Builder putIcons(int key, Image value) {
            if (value == null) {
                throw new NullPointerException("map value");
            }
            this.internalGetMutableIcons().ensureBuilderMap().put((Object)key, (Object)value);
            this.bitField0_ |= 1;
            return this;
        }

        public Builder putAllIcons(Map<Integer, Image> values) {
            for (Map.Entry e : values.entrySet()) {
                if (e.getKey() != null && e.getValue() != null) continue;
                throw new NullPointerException();
            }
            this.internalGetMutableIcons().ensureBuilderMap().putAll(values);
            this.bitField0_ |= 1;
            return this;
        }

        public Image.Builder putIconsBuilderIfAbsent(int key) {
            Map<Integer, ImageOrBuilder> builderMap = this.internalGetMutableIcons().ensureBuilderMap();
            ImageOrBuilder entry = (ImageOrBuilder)builderMap.get((Object)key);
            if (entry == null) {
                entry = Image.newBuilder();
                builderMap.put((Object)key, (Object)entry);
            }
            if (entry instanceof Image) {
                entry = ((Image)entry).toBuilder();
                builderMap.put((Object)key, (Object)entry);
            }
            return (Image.Builder)entry;
        }

        @Override
        public String getTitle() {
            Object ref = this.title_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.title_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getTitleBytes() {
            Object ref = this.title_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.title_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setTitle(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.title_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearTitle() {
            this.title_ = UserBadge.getDefaultInstance().getTitle();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setTitleBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            UserBadge.checkByteStringIsUtf8(value);
            this.title_ = value;
            this.bitField0_ |= 2;
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

        private static final class IconsConverter
        implements MapFieldBuilder.Converter<Integer, ImageOrBuilder, Image> {
            private IconsConverter() {
            }

            @Override
            public Image build(ImageOrBuilder val) {
                if (val instanceof Image) {
                    return (Image)val;
                }
                return ((Image.Builder)val).build();
            }

            @Override
            public MapEntry<Integer, Image> defaultEntry() {
                return IconsDefaultEntryHolder.defaultEntry;
            }
        }
    }

    private static final class IconsDefaultEntryHolder {
        static final MapEntry<Integer, Image> defaultEntry = MapEntry.newDefaultInstance(Douyin.internal_static_UserBadge_IconsEntry_descriptor, WireFormat.FieldType.INT32, 0, WireFormat.FieldType.MESSAGE, Image.getDefaultInstance());

        private IconsDefaultEntryHolder() {
        }
    }
}


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

public final class GzoneNameplateOuterClass {
    private static final Descriptors.Descriptor internal_static_GzoneNameplate_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GzoneNameplate_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private GzoneNameplateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        GzoneNameplateOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nGzoneNameplate.proto\fPicUrl.proto\"A\nGzoneNameplate\n\nid (\f\nname (\t\nurls (2.PicUrlB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{PicUrlOuterClass.getDescriptor()});
        internal_static_GzoneNameplate_descriptor = (Descriptors.Descriptor)GzoneNameplateOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_GzoneNameplate_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GzoneNameplate_descriptor, new String[]{"Id", "Name", "Urls"});
        PicUrlOuterClass.getDescriptor();
    }

    public static final class GzoneNameplate
    extends GeneratedMessageV3
    implements GzoneNameplateOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int ID_FIELD_NUMBER = 1;
        private long id_ = 0L;
        public static final int NAME_FIELD_NUMBER = 2;
        private volatile Object name_ = "";
        public static final int URLS_FIELD_NUMBER = 3;
        private List<PicUrlOuterClass.PicUrl> urls_;
        private byte memoizedIsInitialized = (byte)-1;
        private static final GzoneNameplate DEFAULT_INSTANCE = new GzoneNameplate();
        private static final Parser<GzoneNameplate> PARSER = new AbstractParser<GzoneNameplate>(){

            @Override
            public GzoneNameplate parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = GzoneNameplate.newBuilder();
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

        private GzoneNameplate(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private GzoneNameplate() {
            this.name_ = "";
            this.urls_ = Collections.emptyList();
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GzoneNameplate();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_GzoneNameplate_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_GzoneNameplate_fieldAccessorTable.ensureFieldAccessorsInitialized(GzoneNameplate.class, Builder.class);
        }

        @Override
        public long getId() {
            return this.id_;
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
        public List<PicUrlOuterClass.PicUrl> getUrlsList() {
            return this.urls_;
        }

        @Override
        public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getUrlsOrBuilderList() {
            return this.urls_;
        }

        @Override
        public int getUrlsCount() {
            return this.urls_.size();
        }

        @Override
        public PicUrlOuterClass.PicUrl getUrls(int index) {
            return (PicUrlOuterClass.PicUrl)this.urls_.get(index);
        }

        @Override
        public PicUrlOuterClass.PicUrlOrBuilder getUrlsOrBuilder(int index) {
            return (PicUrlOuterClass.PicUrlOrBuilder)this.urls_.get(index);
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
            if (this.id_ != 0L) {
                output.writeInt64(1, this.id_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                GeneratedMessageV3.writeString(output, 2, this.name_);
            }
            for (int i = 0; i < this.urls_.size(); ++i) {
                output.writeMessage(3, (MessageLite)this.urls_.get(i));
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
            if (this.id_ != 0L) {
                size += CodedOutputStream.computeInt64Size(1, this.id_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            for (int i = 0; i < this.urls_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(3, (MessageLite)this.urls_.get(i));
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GzoneNameplate)) {
                return super.equals(obj);
            }
            GzoneNameplate other = (GzoneNameplate)obj;
            if (this.getId() != other.getId()) {
                return false;
            }
            if (!this.getName().equals((Object)other.getName())) {
                return false;
            }
            if (!this.getUrlsList().equals(other.getUrlsList())) {
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
            hash = 19 * hash + GzoneNameplate.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashLong(this.getId());
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getName().hashCode();
            if (this.getUrlsCount() > 0) {
                hash = 37 * hash + 3;
                hash = 53 * hash + this.getUrlsList().hashCode();
            }
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static GzoneNameplate parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GzoneNameplate parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GzoneNameplate parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GzoneNameplate parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GzoneNameplate parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GzoneNameplate parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GzoneNameplate parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GzoneNameplate parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GzoneNameplate parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GzoneNameplate parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GzoneNameplate parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GzoneNameplate parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return GzoneNameplate.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GzoneNameplate prototype) {
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

        public static GzoneNameplate getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GzoneNameplate> parser() {
            return PARSER;
        }

        public Parser<GzoneNameplate> getParserForType() {
            return PARSER;
        }

        @Override
        public GzoneNameplate getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements GzoneNameplateOrBuilder {
            private int bitField0_;
            private long id_;
            private Object name_ = "";
            private List<PicUrlOuterClass.PicUrl> urls_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PicUrlOuterClass.PicUrl, PicUrlOuterClass.PicUrl.Builder, PicUrlOuterClass.PicUrlOrBuilder> urlsBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_GzoneNameplate_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_GzoneNameplate_fieldAccessorTable.ensureFieldAccessorsInitialized(GzoneNameplate.class, Builder.class);
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
                this.id_ = 0L;
                this.name_ = "";
                if (this.urlsBuilder_ == null) {
                    this.urls_ = Collections.emptyList();
                } else {
                    this.urls_ = null;
                    this.urlsBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFB;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_GzoneNameplate_descriptor;
            }

            @Override
            public GzoneNameplate getDefaultInstanceForType() {
                return GzoneNameplate.getDefaultInstance();
            }

            @Override
            public GzoneNameplate build() {
                GzoneNameplate result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public GzoneNameplate buildPartial() {
                GzoneNameplate result = new GzoneNameplate(this);
                this.buildPartialRepeatedFields(result);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartialRepeatedFields(GzoneNameplate result) {
                if (this.urlsBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.urls_ = Collections.unmodifiableList(this.urls_);
                        this.bitField0_ &= 0xFFFFFFFB;
                    }
                    result.urls_ = this.urls_;
                } else {
                    result.urls_ = this.urlsBuilder_.build();
                }
            }

            private void buildPartial0(GzoneNameplate result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.id_ = this.id_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.name_ = this.name_;
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
                if (other instanceof GzoneNameplate) {
                    return this.mergeFrom((GzoneNameplate)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GzoneNameplate other) {
                if (other == GzoneNameplate.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0L) {
                    this.setId(other.getId());
                }
                if (!other.getName().isEmpty()) {
                    this.name_ = other.name_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (this.urlsBuilder_ == null) {
                    if (!other.urls_.isEmpty()) {
                        if (this.urls_.isEmpty()) {
                            this.urls_ = other.urls_;
                            this.bitField0_ &= 0xFFFFFFFB;
                        } else {
                            this.ensureUrlsIsMutable();
                            this.urls_.addAll((Collection)other.urls_);
                        }
                        this.onChanged();
                    }
                } else if (!other.urls_.isEmpty()) {
                    if (this.urlsBuilder_.isEmpty()) {
                        this.urlsBuilder_.dispose();
                        this.urlsBuilder_ = null;
                        this.urls_ = other.urls_;
                        this.bitField0_ &= 0xFFFFFFFB;
                        this.urlsBuilder_ = alwaysUseFieldBuilders ? this.getUrlsFieldBuilder() : null;
                    } else {
                        this.urlsBuilder_.addAllMessages((Iterable<PicUrlOuterClass.PicUrl>)other.urls_);
                    }
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
                            case 8: {
                                this.id_ = input.readInt64();
                                this.bitField0_ |= 1;
                                continue block11;
                            }
                            case 18: {
                                this.name_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 26: {
                                PicUrlOuterClass.PicUrl m = input.readMessage(PicUrlOuterClass.PicUrl.parser(), extensionRegistry);
                                if (this.urlsBuilder_ == null) {
                                    this.ensureUrlsIsMutable();
                                    this.urls_.add((Object)m);
                                    continue block11;
                                }
                                this.urlsBuilder_.addMessage(m);
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
            public long getId() {
                return this.id_;
            }

            public Builder setId(long value) {
                this.id_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearId() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.id_ = 0L;
                this.onChanged();
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
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = GzoneNameplate.getDefaultInstance().getName();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GzoneNameplate.checkByteStringIsUtf8(value);
                this.name_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            private void ensureUrlsIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.urls_ = new ArrayList(this.urls_);
                    this.bitField0_ |= 4;
                }
            }

            @Override
            public List<PicUrlOuterClass.PicUrl> getUrlsList() {
                if (this.urlsBuilder_ == null) {
                    return Collections.unmodifiableList(this.urls_);
                }
                return this.urlsBuilder_.getMessageList();
            }

            @Override
            public int getUrlsCount() {
                if (this.urlsBuilder_ == null) {
                    return this.urls_.size();
                }
                return this.urlsBuilder_.getCount();
            }

            @Override
            public PicUrlOuterClass.PicUrl getUrls(int index) {
                if (this.urlsBuilder_ == null) {
                    return (PicUrlOuterClass.PicUrl)this.urls_.get(index);
                }
                return this.urlsBuilder_.getMessage(index);
            }

            public Builder setUrls(int index, PicUrlOuterClass.PicUrl value) {
                if (this.urlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureUrlsIsMutable();
                    this.urls_.set(index, (Object)value);
                    this.onChanged();
                } else {
                    this.urlsBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUrls(int index, PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.urlsBuilder_ == null) {
                    this.ensureUrlsIsMutable();
                    this.urls_.set(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.urlsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUrls(PicUrlOuterClass.PicUrl value) {
                if (this.urlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureUrlsIsMutable();
                    this.urls_.add((Object)value);
                    this.onChanged();
                } else {
                    this.urlsBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUrls(int index, PicUrlOuterClass.PicUrl value) {
                if (this.urlsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureUrlsIsMutable();
                    this.urls_.add(index, (Object)value);
                    this.onChanged();
                } else {
                    this.urlsBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUrls(PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.urlsBuilder_ == null) {
                    this.ensureUrlsIsMutable();
                    this.urls_.add((Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.urlsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUrls(int index, PicUrlOuterClass.PicUrl.Builder builderForValue) {
                if (this.urlsBuilder_ == null) {
                    this.ensureUrlsIsMutable();
                    this.urls_.add(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.urlsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUrls(Iterable<? extends PicUrlOuterClass.PicUrl> values) {
                if (this.urlsBuilder_ == null) {
                    this.ensureUrlsIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.urls_);
                    this.onChanged();
                } else {
                    this.urlsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUrls() {
                if (this.urlsBuilder_ == null) {
                    this.urls_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFB;
                    this.onChanged();
                } else {
                    this.urlsBuilder_.clear();
                }
                return this;
            }

            public Builder removeUrls(int index) {
                if (this.urlsBuilder_ == null) {
                    this.ensureUrlsIsMutable();
                    this.urls_.remove(index);
                    this.onChanged();
                } else {
                    this.urlsBuilder_.remove(index);
                }
                return this;
            }

            public PicUrlOuterClass.PicUrl.Builder getUrlsBuilder(int index) {
                return this.getUrlsFieldBuilder().getBuilder(index);
            }

            @Override
            public PicUrlOuterClass.PicUrlOrBuilder getUrlsOrBuilder(int index) {
                if (this.urlsBuilder_ == null) {
                    return (PicUrlOuterClass.PicUrlOrBuilder)this.urls_.get(index);
                }
                return this.urlsBuilder_.getMessageOrBuilder(index);
            }

            @Override
            public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getUrlsOrBuilderList() {
                if (this.urlsBuilder_ != null) {
                    return this.urlsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.urls_);
            }

            public PicUrlOuterClass.PicUrl.Builder addUrlsBuilder() {
                return this.getUrlsFieldBuilder().addBuilder(PicUrlOuterClass.PicUrl.getDefaultInstance());
            }

            public PicUrlOuterClass.PicUrl.Builder addUrlsBuilder(int index) {
                return this.getUrlsFieldBuilder().addBuilder(index, PicUrlOuterClass.PicUrl.getDefaultInstance());
            }

            public List<PicUrlOuterClass.PicUrl.Builder> getUrlsBuilderList() {
                return this.getUrlsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PicUrlOuterClass.PicUrl, PicUrlOuterClass.PicUrl.Builder, PicUrlOuterClass.PicUrlOrBuilder> getUrlsFieldBuilder() {
                if (this.urlsBuilder_ == null) {
                    this.urlsBuilder_ = new RepeatedFieldBuilderV3(this.urls_, (this.bitField0_ & 4) != 0, this.getParentForChildren(), this.isClean());
                    this.urls_ = null;
                }
                return this.urlsBuilder_;
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

    public static interface GzoneNameplateOrBuilder
    extends MessageOrBuilder {
        public long getId();

        public String getName();

        public ByteString getNameBytes();

        public List<PicUrlOuterClass.PicUrl> getUrlsList();

        public PicUrlOuterClass.PicUrl getUrls(int var1);

        public int getUrlsCount();

        public List<? extends PicUrlOuterClass.PicUrlOrBuilder> getUrlsOrBuilderList();

        public PicUrlOuterClass.PicUrlOrBuilder getUrlsOrBuilder(int var1);
    }
}


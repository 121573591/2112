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
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.LiveCdnNodeViewOuterClass;

public final class AuditAudienceMaskOuterClass {
    private static final Descriptors.Descriptor internal_static_AuditAudienceMask_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AuditAudienceMask_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private AuditAudienceMaskOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        AuditAudienceMaskOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nAuditAudienceMask.protoLiveCdnNodeView.proto\"]\nAuditAudienceMask)\niconCdnNodeView (2.LiveCdnNodeView\r\ntitle (\t\ndetail (\tB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{LiveCdnNodeViewOuterClass.getDescriptor()});
        internal_static_AuditAudienceMask_descriptor = (Descriptors.Descriptor)AuditAudienceMaskOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_AuditAudienceMask_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AuditAudienceMask_descriptor, new String[]{"IconCdnNodeView", "Title", "Detail"});
        LiveCdnNodeViewOuterClass.getDescriptor();
    }

    public static final class AuditAudienceMask
    extends GeneratedMessageV3
    implements AuditAudienceMaskOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int ICONCDNNODEVIEW_FIELD_NUMBER = 1;
        private List<LiveCdnNodeViewOuterClass.LiveCdnNodeView> iconCdnNodeView_;
        public static final int TITLE_FIELD_NUMBER = 2;
        private volatile Object title_ = "";
        public static final int DETAIL_FIELD_NUMBER = 3;
        private volatile Object detail_ = "";
        private byte memoizedIsInitialized = (byte)-1;
        private static final AuditAudienceMask DEFAULT_INSTANCE = new AuditAudienceMask();
        private static final Parser<AuditAudienceMask> PARSER = new AbstractParser<AuditAudienceMask>(){

            @Override
            public AuditAudienceMask parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = AuditAudienceMask.newBuilder();
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

        private AuditAudienceMask(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private AuditAudienceMask() {
            this.iconCdnNodeView_ = Collections.emptyList();
            this.title_ = "";
            this.detail_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AuditAudienceMask();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_AuditAudienceMask_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_AuditAudienceMask_fieldAccessorTable.ensureFieldAccessorsInitialized(AuditAudienceMask.class, Builder.class);
        }

        @Override
        public List<LiveCdnNodeViewOuterClass.LiveCdnNodeView> getIconCdnNodeViewList() {
            return this.iconCdnNodeView_;
        }

        @Override
        public List<? extends LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder> getIconCdnNodeViewOrBuilderList() {
            return this.iconCdnNodeView_;
        }

        @Override
        public int getIconCdnNodeViewCount() {
            return this.iconCdnNodeView_.size();
        }

        @Override
        public LiveCdnNodeViewOuterClass.LiveCdnNodeView getIconCdnNodeView(int index) {
            return (LiveCdnNodeViewOuterClass.LiveCdnNodeView)this.iconCdnNodeView_.get(index);
        }

        @Override
        public LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder getIconCdnNodeViewOrBuilder(int index) {
            return (LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder)this.iconCdnNodeView_.get(index);
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
        public String getDetail() {
            Object ref = this.detail_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.detail_ = s;
            return s;
        }

        @Override
        public ByteString getDetailBytes() {
            Object ref = this.detail_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.detail_ = b;
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
            for (int i = 0; i < this.iconCdnNodeView_.size(); ++i) {
                output.writeMessage(1, (MessageLite)this.iconCdnNodeView_.get(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
                GeneratedMessageV3.writeString(output, 2, this.title_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.detail_)) {
                GeneratedMessageV3.writeString(output, 3, this.detail_);
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
            for (int i = 0; i < this.iconCdnNodeView_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(1, (MessageLite)this.iconCdnNodeView_.get(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.title_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.title_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.detail_)) {
                size += GeneratedMessageV3.computeStringSize(3, this.detail_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuditAudienceMask)) {
                return super.equals(obj);
            }
            AuditAudienceMask other = (AuditAudienceMask)obj;
            if (!this.getIconCdnNodeViewList().equals(other.getIconCdnNodeViewList())) {
                return false;
            }
            if (!this.getTitle().equals((Object)other.getTitle())) {
                return false;
            }
            if (!this.getDetail().equals((Object)other.getDetail())) {
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
            hash = 19 * hash + AuditAudienceMask.getDescriptor().hashCode();
            if (this.getIconCdnNodeViewCount() > 0) {
                hash = 37 * hash + 1;
                hash = 53 * hash + this.getIconCdnNodeViewList().hashCode();
            }
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getTitle().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + this.getDetail().hashCode();
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static AuditAudienceMask parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AuditAudienceMask parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuditAudienceMask parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AuditAudienceMask parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuditAudienceMask parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AuditAudienceMask parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AuditAudienceMask parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AuditAudienceMask parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AuditAudienceMask parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AuditAudienceMask parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AuditAudienceMask parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AuditAudienceMask parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return AuditAudienceMask.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AuditAudienceMask prototype) {
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

        public static AuditAudienceMask getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AuditAudienceMask> parser() {
            return PARSER;
        }

        public Parser<AuditAudienceMask> getParserForType() {
            return PARSER;
        }

        @Override
        public AuditAudienceMask getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements AuditAudienceMaskOrBuilder {
            private int bitField0_;
            private List<LiveCdnNodeViewOuterClass.LiveCdnNodeView> iconCdnNodeView_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<LiveCdnNodeViewOuterClass.LiveCdnNodeView, LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder, LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder> iconCdnNodeViewBuilder_;
            private Object title_ = "";
            private Object detail_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_AuditAudienceMask_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_AuditAudienceMask_fieldAccessorTable.ensureFieldAccessorsInitialized(AuditAudienceMask.class, Builder.class);
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
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.iconCdnNodeView_ = Collections.emptyList();
                } else {
                    this.iconCdnNodeView_ = null;
                    this.iconCdnNodeViewBuilder_.clear();
                }
                this.bitField0_ &= 0xFFFFFFFE;
                this.title_ = "";
                this.detail_ = "";
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_AuditAudienceMask_descriptor;
            }

            @Override
            public AuditAudienceMask getDefaultInstanceForType() {
                return AuditAudienceMask.getDefaultInstance();
            }

            @Override
            public AuditAudienceMask build() {
                AuditAudienceMask result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public AuditAudienceMask buildPartial() {
                AuditAudienceMask result = new AuditAudienceMask(this);
                this.buildPartialRepeatedFields(result);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartialRepeatedFields(AuditAudienceMask result) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.iconCdnNodeView_ = Collections.unmodifiableList(this.iconCdnNodeView_);
                        this.bitField0_ &= 0xFFFFFFFE;
                    }
                    result.iconCdnNodeView_ = this.iconCdnNodeView_;
                } else {
                    result.iconCdnNodeView_ = this.iconCdnNodeViewBuilder_.build();
                }
            }

            private void buildPartial0(AuditAudienceMask result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 2) != 0) {
                    result.title_ = this.title_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.detail_ = this.detail_;
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
                if (other instanceof AuditAudienceMask) {
                    return this.mergeFrom((AuditAudienceMask)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AuditAudienceMask other) {
                if (other == AuditAudienceMask.getDefaultInstance()) {
                    return this;
                }
                if (this.iconCdnNodeViewBuilder_ == null) {
                    if (!other.iconCdnNodeView_.isEmpty()) {
                        if (this.iconCdnNodeView_.isEmpty()) {
                            this.iconCdnNodeView_ = other.iconCdnNodeView_;
                            this.bitField0_ &= 0xFFFFFFFE;
                        } else {
                            this.ensureIconCdnNodeViewIsMutable();
                            this.iconCdnNodeView_.addAll((Collection)other.iconCdnNodeView_);
                        }
                        this.onChanged();
                    }
                } else if (!other.iconCdnNodeView_.isEmpty()) {
                    if (this.iconCdnNodeViewBuilder_.isEmpty()) {
                        this.iconCdnNodeViewBuilder_.dispose();
                        this.iconCdnNodeViewBuilder_ = null;
                        this.iconCdnNodeView_ = other.iconCdnNodeView_;
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.iconCdnNodeViewBuilder_ = alwaysUseFieldBuilders ? this.getIconCdnNodeViewFieldBuilder() : null;
                    } else {
                        this.iconCdnNodeViewBuilder_.addAllMessages((Iterable<LiveCdnNodeViewOuterClass.LiveCdnNodeView>)other.iconCdnNodeView_);
                    }
                }
                if (!other.getTitle().isEmpty()) {
                    this.title_ = other.title_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (!other.getDetail().isEmpty()) {
                    this.detail_ = other.detail_;
                    this.bitField0_ |= 4;
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
                    block11: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block11;
                            }
                            case 10: {
                                LiveCdnNodeViewOuterClass.LiveCdnNodeView m = input.readMessage(LiveCdnNodeViewOuterClass.LiveCdnNodeView.parser(), extensionRegistry);
                                if (this.iconCdnNodeViewBuilder_ == null) {
                                    this.ensureIconCdnNodeViewIsMutable();
                                    this.iconCdnNodeView_.add((Object)m);
                                    continue block11;
                                }
                                this.iconCdnNodeViewBuilder_.addMessage(m);
                                continue block11;
                            }
                            case 18: {
                                this.title_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 26: {
                                this.detail_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 4;
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

            private void ensureIconCdnNodeViewIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.iconCdnNodeView_ = new ArrayList(this.iconCdnNodeView_);
                    this.bitField0_ |= 1;
                }
            }

            @Override
            public List<LiveCdnNodeViewOuterClass.LiveCdnNodeView> getIconCdnNodeViewList() {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    return Collections.unmodifiableList(this.iconCdnNodeView_);
                }
                return this.iconCdnNodeViewBuilder_.getMessageList();
            }

            @Override
            public int getIconCdnNodeViewCount() {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    return this.iconCdnNodeView_.size();
                }
                return this.iconCdnNodeViewBuilder_.getCount();
            }

            @Override
            public LiveCdnNodeViewOuterClass.LiveCdnNodeView getIconCdnNodeView(int index) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    return (LiveCdnNodeViewOuterClass.LiveCdnNodeView)this.iconCdnNodeView_.get(index);
                }
                return this.iconCdnNodeViewBuilder_.getMessage(index);
            }

            public Builder setIconCdnNodeView(int index, LiveCdnNodeViewOuterClass.LiveCdnNodeView value) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.set(index, (Object)value);
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setIconCdnNodeView(int index, LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder builderForValue) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.set(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addIconCdnNodeView(LiveCdnNodeViewOuterClass.LiveCdnNodeView value) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.add((Object)value);
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addIconCdnNodeView(int index, LiveCdnNodeViewOuterClass.LiveCdnNodeView value) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.add(index, (Object)value);
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addIconCdnNodeView(LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder builderForValue) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.add((Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addIconCdnNodeView(int index, LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder builderForValue) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.add(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllIconCdnNodeView(Iterable<? extends LiveCdnNodeViewOuterClass.LiveCdnNodeView> values) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.ensureIconCdnNodeViewIsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.iconCdnNodeView_);
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearIconCdnNodeView() {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.iconCdnNodeView_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.clear();
                }
                return this;
            }

            public Builder removeIconCdnNodeView(int index) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.ensureIconCdnNodeViewIsMutable();
                    this.iconCdnNodeView_.remove(index);
                    this.onChanged();
                } else {
                    this.iconCdnNodeViewBuilder_.remove(index);
                }
                return this;
            }

            public LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder getIconCdnNodeViewBuilder(int index) {
                return this.getIconCdnNodeViewFieldBuilder().getBuilder(index);
            }

            @Override
            public LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder getIconCdnNodeViewOrBuilder(int index) {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    return (LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder)this.iconCdnNodeView_.get(index);
                }
                return this.iconCdnNodeViewBuilder_.getMessageOrBuilder(index);
            }

            @Override
            public List<? extends LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder> getIconCdnNodeViewOrBuilderList() {
                if (this.iconCdnNodeViewBuilder_ != null) {
                    return this.iconCdnNodeViewBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.iconCdnNodeView_);
            }

            public LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder addIconCdnNodeViewBuilder() {
                return this.getIconCdnNodeViewFieldBuilder().addBuilder(LiveCdnNodeViewOuterClass.LiveCdnNodeView.getDefaultInstance());
            }

            public LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder addIconCdnNodeViewBuilder(int index) {
                return this.getIconCdnNodeViewFieldBuilder().addBuilder(index, LiveCdnNodeViewOuterClass.LiveCdnNodeView.getDefaultInstance());
            }

            public List<LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder> getIconCdnNodeViewBuilderList() {
                return this.getIconCdnNodeViewFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LiveCdnNodeViewOuterClass.LiveCdnNodeView, LiveCdnNodeViewOuterClass.LiveCdnNodeView.Builder, LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder> getIconCdnNodeViewFieldBuilder() {
                if (this.iconCdnNodeViewBuilder_ == null) {
                    this.iconCdnNodeViewBuilder_ = new RepeatedFieldBuilderV3(this.iconCdnNodeView_, (this.bitField0_ & 1) != 0, this.getParentForChildren(), this.isClean());
                    this.iconCdnNodeView_ = null;
                }
                return this.iconCdnNodeViewBuilder_;
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
                this.title_ = AuditAudienceMask.getDefaultInstance().getTitle();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setTitleBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AuditAudienceMask.checkByteStringIsUtf8(value);
                this.title_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public String getDetail() {
                Object ref = this.detail_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.detail_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getDetailBytes() {
                Object ref = this.detail_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.detail_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setDetail(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.detail_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearDetail() {
                this.detail_ = AuditAudienceMask.getDefaultInstance().getDetail();
                this.bitField0_ &= 0xFFFFFFFB;
                this.onChanged();
                return this;
            }

            public Builder setDetailBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AuditAudienceMask.checkByteStringIsUtf8(value);
                this.detail_ = value;
                this.bitField0_ |= 4;
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

    public static interface AuditAudienceMaskOrBuilder
    extends MessageOrBuilder {
        public List<LiveCdnNodeViewOuterClass.LiveCdnNodeView> getIconCdnNodeViewList();

        public LiveCdnNodeViewOuterClass.LiveCdnNodeView getIconCdnNodeView(int var1);

        public int getIconCdnNodeViewCount();

        public List<? extends LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder> getIconCdnNodeViewOrBuilderList();

        public LiveCdnNodeViewOuterClass.LiveCdnNodeViewOrBuilder getIconCdnNodeViewOrBuilder(int var1);

        public String getTitle();

        public ByteString getTitleBytes();

        public String getDetail();

        public ByteString getDetailBytes();
    }
}


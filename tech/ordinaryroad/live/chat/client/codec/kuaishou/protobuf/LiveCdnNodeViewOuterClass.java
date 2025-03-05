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
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class LiveCdnNodeViewOuterClass {
    private static final Descriptors.Descriptor internal_static_LiveCdnNodeView_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LiveCdnNodeView_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private LiveCdnNodeViewOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        LiveCdnNodeViewOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nLiveCdnNodeView.proto\"@\nLiveCdnNodeView\ncdn (\t\nurl (\t\nfreeTraffic (\bB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
        internal_static_LiveCdnNodeView_descriptor = (Descriptors.Descriptor)LiveCdnNodeViewOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_LiveCdnNodeView_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LiveCdnNodeView_descriptor, new String[]{"Cdn", "Url", "FreeTraffic"});
    }

    public static final class LiveCdnNodeView
    extends GeneratedMessageV3
    implements LiveCdnNodeViewOrBuilder {
        private static final long serialVersionUID = 0L;
        public static final int CDN_FIELD_NUMBER = 1;
        private volatile Object cdn_ = "";
        public static final int URL_FIELD_NUMBER = 2;
        private volatile Object url_ = "";
        public static final int FREETRAFFIC_FIELD_NUMBER = 3;
        private boolean freeTraffic_ = false;
        private byte memoizedIsInitialized = (byte)-1;
        private static final LiveCdnNodeView DEFAULT_INSTANCE = new LiveCdnNodeView();
        private static final Parser<LiveCdnNodeView> PARSER = new AbstractParser<LiveCdnNodeView>(){

            @Override
            public LiveCdnNodeView parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = LiveCdnNodeView.newBuilder();
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

        private LiveCdnNodeView(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private LiveCdnNodeView() {
            this.cdn_ = "";
            this.url_ = "";
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LiveCdnNodeView();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_LiveCdnNodeView_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_LiveCdnNodeView_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveCdnNodeView.class, Builder.class);
        }

        @Override
        public String getCdn() {
            Object ref = this.cdn_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.cdn_ = s;
            return s;
        }

        @Override
        public ByteString getCdnBytes() {
            Object ref = this.cdn_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.cdn_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public String getUrl() {
            Object ref = this.url_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.url_ = s;
            return s;
        }

        @Override
        public ByteString getUrlBytes() {
            Object ref = this.url_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.url_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public boolean getFreeTraffic() {
            return this.freeTraffic_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.cdn_)) {
                GeneratedMessageV3.writeString(output, 1, this.cdn_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.url_)) {
                GeneratedMessageV3.writeString(output, 2, this.url_);
            }
            if (this.freeTraffic_) {
                output.writeBool(3, this.freeTraffic_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.cdn_)) {
                size += GeneratedMessageV3.computeStringSize(1, this.cdn_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.url_)) {
                size += GeneratedMessageV3.computeStringSize(2, this.url_);
            }
            if (this.freeTraffic_) {
                size += CodedOutputStream.computeBoolSize(3, this.freeTraffic_);
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiveCdnNodeView)) {
                return super.equals(obj);
            }
            LiveCdnNodeView other = (LiveCdnNodeView)obj;
            if (!this.getCdn().equals((Object)other.getCdn())) {
                return false;
            }
            if (!this.getUrl().equals((Object)other.getUrl())) {
                return false;
            }
            if (this.getFreeTraffic() != other.getFreeTraffic()) {
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
            hash = 19 * hash + LiveCdnNodeView.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCdn().hashCode();
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getUrl().hashCode();
            hash = 37 * hash + 3;
            hash = 53 * hash + Internal.hashBoolean(this.getFreeTraffic());
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static LiveCdnNodeView parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LiveCdnNodeView parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LiveCdnNodeView parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LiveCdnNodeView parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LiveCdnNodeView parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LiveCdnNodeView parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LiveCdnNodeView parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LiveCdnNodeView parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LiveCdnNodeView parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LiveCdnNodeView parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LiveCdnNodeView parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LiveCdnNodeView parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return LiveCdnNodeView.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LiveCdnNodeView prototype) {
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

        public static LiveCdnNodeView getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LiveCdnNodeView> parser() {
            return PARSER;
        }

        public Parser<LiveCdnNodeView> getParserForType() {
            return PARSER;
        }

        @Override
        public LiveCdnNodeView getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements LiveCdnNodeViewOrBuilder {
            private int bitField0_;
            private Object cdn_ = "";
            private Object url_ = "";
            private boolean freeTraffic_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_LiveCdnNodeView_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_LiveCdnNodeView_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveCdnNodeView.class, Builder.class);
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
                this.cdn_ = "";
                this.url_ = "";
                this.freeTraffic_ = false;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_LiveCdnNodeView_descriptor;
            }

            @Override
            public LiveCdnNodeView getDefaultInstanceForType() {
                return LiveCdnNodeView.getDefaultInstance();
            }

            @Override
            public LiveCdnNodeView build() {
                LiveCdnNodeView result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public LiveCdnNodeView buildPartial() {
                LiveCdnNodeView result = new LiveCdnNodeView(this);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartial0(LiveCdnNodeView result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.cdn_ = this.cdn_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.url_ = this.url_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.freeTraffic_ = this.freeTraffic_;
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
                if (other instanceof LiveCdnNodeView) {
                    return this.mergeFrom((LiveCdnNodeView)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LiveCdnNodeView other) {
                if (other == LiveCdnNodeView.getDefaultInstance()) {
                    return this;
                }
                if (!other.getCdn().isEmpty()) {
                    this.cdn_ = other.cdn_;
                    this.bitField0_ |= 1;
                    this.onChanged();
                }
                if (!other.getUrl().isEmpty()) {
                    this.url_ = other.url_;
                    this.bitField0_ |= 2;
                    this.onChanged();
                }
                if (other.getFreeTraffic()) {
                    this.setFreeTraffic(other.getFreeTraffic());
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
                                this.cdn_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 1;
                                continue block11;
                            }
                            case 18: {
                                this.url_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 2;
                                continue block11;
                            }
                            case 24: {
                                this.freeTraffic_ = input.readBool();
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

            @Override
            public String getCdn() {
                Object ref = this.cdn_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.cdn_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getCdnBytes() {
                Object ref = this.cdn_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.cdn_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setCdn(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.cdn_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearCdn() {
                this.cdn_ = LiveCdnNodeView.getDefaultInstance().getCdn();
                this.bitField0_ &= 0xFFFFFFFE;
                this.onChanged();
                return this;
            }

            public Builder setCdnBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                LiveCdnNodeView.checkByteStringIsUtf8(value);
                this.cdn_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            @Override
            public String getUrl() {
                Object ref = this.url_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.url_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getUrlBytes() {
                Object ref = this.url_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.url_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.url_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = LiveCdnNodeView.getDefaultInstance().getUrl();
                this.bitField0_ &= 0xFFFFFFFD;
                this.onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                LiveCdnNodeView.checkByteStringIsUtf8(value);
                this.url_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            @Override
            public boolean getFreeTraffic() {
                return this.freeTraffic_;
            }

            public Builder setFreeTraffic(boolean value) {
                this.freeTraffic_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            public Builder clearFreeTraffic() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.freeTraffic_ = false;
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

    public static interface LiveCdnNodeViewOrBuilder
    extends MessageOrBuilder {
        public String getCdn();

        public ByteString getCdnBytes();

        public String getUrl();

        public ByteString getUrlBytes();

        public boolean getFreeTraffic();
    }
}


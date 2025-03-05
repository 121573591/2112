/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldReflectionAccessor;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.RoomMsgTypeEnum;

public final class RoomMessage
extends GeneratedMessageV3
implements RoomMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int CONTENT_FIELD_NUMBER = 2;
    private volatile Object content_ = "";
    public static final int SUPPROTLANDSCAPE_FIELD_NUMBER = 3;
    private boolean supprotLandscape_ = false;
    public static final int ROOMMESSAGETYPE_FIELD_NUMBER = 4;
    private int roommessagetype_ = 0;
    public static final int SYSTEMTOPMSG_FIELD_NUMBER = 5;
    private boolean systemTopMsg_ = false;
    public static final int FORCEDGUARANTEE_FIELD_NUMBER = 6;
    private boolean forcedGuarantee_ = false;
    public static final int BIZSCENE_FIELD_NUMBER = 20;
    private volatile Object bizScene_ = "";
    public static final int BURIEDPOINTMAP_FIELD_NUMBER = 30;
    private MapField<String, String> buriedPointMap_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final RoomMessage DEFAULT_INSTANCE = new RoomMessage();
    private static final Parser<RoomMessage> PARSER = new AbstractParser<RoomMessage>(){

        @Override
        public RoomMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = RoomMessage.newBuilder();
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

    private RoomMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RoomMessage() {
        this.content_ = "";
        this.roommessagetype_ = 0;
        this.bizScene_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new RoomMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_RoomMessage_descriptor;
    }

    @Override
    protected MapFieldReflectionAccessor internalGetMapFieldReflection(int number) {
        switch (number) {
            case 30: {
                return this.internalGetBuriedPointMap();
            }
        }
        throw new RuntimeException("Invalid map field number: " + number);
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_RoomMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomMessage.class, Builder.class);
    }

    @Override
    public boolean hasCommon() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public Common getCommon() {
        return this.common_ == null ? Common.getDefaultInstance() : this.common_;
    }

    @Override
    public CommonOrBuilder getCommonOrBuilder() {
        return this.common_ == null ? Common.getDefaultInstance() : this.common_;
    }

    @Override
    public String getContent() {
        Object ref = this.content_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.content_ = s;
        return s;
    }

    @Override
    public ByteString getContentBytes() {
        Object ref = this.content_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.content_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public boolean getSupprotLandscape() {
        return this.supprotLandscape_;
    }

    @Override
    public int getRoommessagetypeValue() {
        return this.roommessagetype_;
    }

    @Override
    public RoomMsgTypeEnum getRoommessagetype() {
        RoomMsgTypeEnum result = RoomMsgTypeEnum.forNumber(this.roommessagetype_);
        return result == null ? RoomMsgTypeEnum.UNRECOGNIZED : result;
    }

    @Override
    public boolean getSystemTopMsg() {
        return this.systemTopMsg_;
    }

    @Override
    public boolean getForcedGuarantee() {
        return this.forcedGuarantee_;
    }

    @Override
    public String getBizScene() {
        Object ref = this.bizScene_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.bizScene_ = s;
        return s;
    }

    @Override
    public ByteString getBizSceneBytes() {
        Object ref = this.bizScene_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.bizScene_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    private MapField<String, String> internalGetBuriedPointMap() {
        if (this.buriedPointMap_ == null) {
            return MapField.emptyMapField(BuriedPointMapDefaultEntryHolder.defaultEntry);
        }
        return this.buriedPointMap_;
    }

    @Override
    public int getBuriedPointMapCount() {
        return this.internalGetBuriedPointMap().getMap().size();
    }

    @Override
    public boolean containsBuriedPointMap(String key) {
        if (key == null) {
            throw new NullPointerException("map key");
        }
        return this.internalGetBuriedPointMap().getMap().containsKey((Object)key);
    }

    @Override
    @Deprecated
    public Map<String, String> getBuriedPointMap() {
        return this.getBuriedPointMapMap();
    }

    @Override
    public Map<String, String> getBuriedPointMapMap() {
        return this.internalGetBuriedPointMap().getMap();
    }

    @Override
    public String getBuriedPointMapOrDefault(String key, String defaultValue) {
        if (key == null) {
            throw new NullPointerException("map key");
        }
        Map<String, String> map = this.internalGetBuriedPointMap().getMap();
        return map.containsKey((Object)key) ? (String)map.get((Object)key) : defaultValue;
    }

    @Override
    public String getBuriedPointMapOrThrow(String key) {
        if (key == null) {
            throw new NullPointerException("map key");
        }
        Map<String, String> map = this.internalGetBuriedPointMap().getMap();
        if (!map.containsKey((Object)key)) {
            throw new IllegalArgumentException();
        }
        return (String)map.get((Object)key);
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
            output.writeMessage(1, this.getCommon());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
            GeneratedMessageV3.writeString(output, 2, this.content_);
        }
        if (this.supprotLandscape_) {
            output.writeBool(3, this.supprotLandscape_);
        }
        if (this.roommessagetype_ != RoomMsgTypeEnum.DEFAULTROOMMSG.getNumber()) {
            output.writeEnum(4, this.roommessagetype_);
        }
        if (this.systemTopMsg_) {
            output.writeBool(5, this.systemTopMsg_);
        }
        if (this.forcedGuarantee_) {
            output.writeBool(6, this.forcedGuarantee_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.bizScene_)) {
            GeneratedMessageV3.writeString(output, 20, this.bizScene_);
        }
        GeneratedMessageV3.serializeStringMapTo(output, this.internalGetBuriedPointMap(), BuriedPointMapDefaultEntryHolder.defaultEntry, 30);
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
            size += CodedOutputStream.computeMessageSize(1, this.getCommon());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.content_)) {
            size += GeneratedMessageV3.computeStringSize(2, this.content_);
        }
        if (this.supprotLandscape_) {
            size += CodedOutputStream.computeBoolSize(3, this.supprotLandscape_);
        }
        if (this.roommessagetype_ != RoomMsgTypeEnum.DEFAULTROOMMSG.getNumber()) {
            size += CodedOutputStream.computeEnumSize(4, this.roommessagetype_);
        }
        if (this.systemTopMsg_) {
            size += CodedOutputStream.computeBoolSize(5, this.systemTopMsg_);
        }
        if (this.forcedGuarantee_) {
            size += CodedOutputStream.computeBoolSize(6, this.forcedGuarantee_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.bizScene_)) {
            size += GeneratedMessageV3.computeStringSize(20, this.bizScene_);
        }
        for (Map.Entry entry : this.internalGetBuriedPointMap().getMap().entrySet()) {
            Message buriedPointMap__ = ((MapEntry.Builder)BuriedPointMapDefaultEntryHolder.defaultEntry.newBuilderForType()).setKey((String)entry.getKey()).setValue((String)entry.getValue()).build();
            size += CodedOutputStream.computeMessageSize(30, buriedPointMap__);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RoomMessage)) {
            return super.equals(obj);
        }
        RoomMessage other = (RoomMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (!this.getContent().equals((Object)other.getContent())) {
            return false;
        }
        if (this.getSupprotLandscape() != other.getSupprotLandscape()) {
            return false;
        }
        if (this.roommessagetype_ != other.roommessagetype_) {
            return false;
        }
        if (this.getSystemTopMsg() != other.getSystemTopMsg()) {
            return false;
        }
        if (this.getForcedGuarantee() != other.getForcedGuarantee()) {
            return false;
        }
        if (!this.getBizScene().equals((Object)other.getBizScene())) {
            return false;
        }
        if (!this.internalGetBuriedPointMap().equals(other.internalGetBuriedPointMap())) {
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
        hash = 19 * hash + RoomMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + this.getContent().hashCode();
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashBoolean(this.getSupprotLandscape());
        hash = 37 * hash + 4;
        hash = 53 * hash + this.roommessagetype_;
        hash = 37 * hash + 5;
        hash = 53 * hash + Internal.hashBoolean(this.getSystemTopMsg());
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashBoolean(this.getForcedGuarantee());
        hash = 37 * hash + 20;
        hash = 53 * hash + this.getBizScene().hashCode();
        if (!this.internalGetBuriedPointMap().getMap().isEmpty()) {
            hash = 37 * hash + 30;
            hash = 53 * hash + this.internalGetBuriedPointMap().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static RoomMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RoomMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RoomMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static RoomMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RoomMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static RoomMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return RoomMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RoomMessage prototype) {
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

    public static RoomMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RoomMessage> parser() {
        return PARSER;
    }

    public Parser<RoomMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public RoomMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements RoomMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private Object content_ = "";
        private boolean supprotLandscape_;
        private int roommessagetype_ = 0;
        private boolean systemTopMsg_;
        private boolean forcedGuarantee_;
        private Object bizScene_ = "";
        private MapField<String, String> buriedPointMap_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_RoomMessage_descriptor;
        }

        @Override
        protected MapFieldReflectionAccessor internalGetMapFieldReflection(int number) {
            switch (number) {
                case 30: {
                    return this.internalGetBuriedPointMap();
                }
            }
            throw new RuntimeException("Invalid map field number: " + number);
        }

        @Override
        protected MapFieldReflectionAccessor internalGetMutableMapFieldReflection(int number) {
            switch (number) {
                case 30: {
                    return this.internalGetMutableBuriedPointMap();
                }
            }
            throw new RuntimeException("Invalid map field number: " + number);
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_RoomMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(RoomMessage.class, Builder.class);
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
                this.getCommonFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.common_ = null;
            if (this.commonBuilder_ != null) {
                this.commonBuilder_.dispose();
                this.commonBuilder_ = null;
            }
            this.content_ = "";
            this.supprotLandscape_ = false;
            this.roommessagetype_ = 0;
            this.systemTopMsg_ = false;
            this.forcedGuarantee_ = false;
            this.bizScene_ = "";
            this.internalGetMutableBuriedPointMap().clear();
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_RoomMessage_descriptor;
        }

        @Override
        public RoomMessage getDefaultInstanceForType() {
            return RoomMessage.getDefaultInstance();
        }

        @Override
        public RoomMessage build() {
            RoomMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RoomMessage buildPartial() {
            RoomMessage result = new RoomMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(RoomMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.content_ = this.content_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.supprotLandscape_ = this.supprotLandscape_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.roommessagetype_ = this.roommessagetype_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.systemTopMsg_ = this.systemTopMsg_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.forcedGuarantee_ = this.forcedGuarantee_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.bizScene_ = this.bizScene_;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.buriedPointMap_ = this.internalGetBuriedPointMap();
                result.buriedPointMap_.makeImmutable();
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
            if (other instanceof RoomMessage) {
                return this.mergeFrom((RoomMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(RoomMessage other) {
            if (other == RoomMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (!other.getContent().isEmpty()) {
                this.content_ = other.content_;
                this.bitField0_ |= 2;
                this.onChanged();
            }
            if (other.getSupprotLandscape()) {
                this.setSupprotLandscape(other.getSupprotLandscape());
            }
            if (other.roommessagetype_ != 0) {
                this.setRoommessagetypeValue(other.getRoommessagetypeValue());
            }
            if (other.getSystemTopMsg()) {
                this.setSystemTopMsg(other.getSystemTopMsg());
            }
            if (other.getForcedGuarantee()) {
                this.setForcedGuarantee(other.getForcedGuarantee());
            }
            if (!other.getBizScene().isEmpty()) {
                this.bizScene_ = other.bizScene_;
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            this.internalGetMutableBuriedPointMap().mergeFrom(other.internalGetBuriedPointMap());
            this.bitField0_ |= 0x80;
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
                block16: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block16;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block16;
                        }
                        case 18: {
                            this.content_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 2;
                            continue block16;
                        }
                        case 24: {
                            this.supprotLandscape_ = input.readBool();
                            this.bitField0_ |= 4;
                            continue block16;
                        }
                        case 32: {
                            this.roommessagetype_ = input.readEnum();
                            this.bitField0_ |= 8;
                            continue block16;
                        }
                        case 40: {
                            this.systemTopMsg_ = input.readBool();
                            this.bitField0_ |= 0x10;
                            continue block16;
                        }
                        case 48: {
                            this.forcedGuarantee_ = input.readBool();
                            this.bitField0_ |= 0x20;
                            continue block16;
                        }
                        case 162: {
                            this.bizScene_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x40;
                            continue block16;
                        }
                        case 242: {
                            MapEntry<String, String> buriedPointMap__ = input.readMessage(BuriedPointMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                            this.internalGetMutableBuriedPointMap().getMutableMap().put((Object)buriedPointMap__.getKey(), (Object)buriedPointMap__.getValue());
                            this.bitField0_ |= 0x80;
                            continue block16;
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
        public boolean hasCommon() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public Common getCommon() {
            if (this.commonBuilder_ == null) {
                return this.common_ == null ? Common.getDefaultInstance() : this.common_;
            }
            return this.commonBuilder_.getMessage();
        }

        public Builder setCommon(Common value) {
            if (this.commonBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.common_ = value;
            } else {
                this.commonBuilder_.setMessage(value);
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder setCommon(Common.Builder builderForValue) {
            if (this.commonBuilder_ == null) {
                this.common_ = builderForValue.build();
            } else {
                this.commonBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder mergeCommon(Common value) {
            if (this.commonBuilder_ == null) {
                if ((this.bitField0_ & 1) != 0 && this.common_ != null && this.common_ != Common.getDefaultInstance()) {
                    this.getCommonBuilder().mergeFrom(value);
                } else {
                    this.common_ = value;
                }
            } else {
                this.commonBuilder_.mergeFrom(value);
            }
            if (this.common_ != null) {
                this.bitField0_ |= 1;
                this.onChanged();
            }
            return this;
        }

        public Builder clearCommon() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.common_ = null;
            if (this.commonBuilder_ != null) {
                this.commonBuilder_.dispose();
                this.commonBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Common.Builder getCommonBuilder() {
            this.bitField0_ |= 1;
            this.onChanged();
            return this.getCommonFieldBuilder().getBuilder();
        }

        @Override
        public CommonOrBuilder getCommonOrBuilder() {
            if (this.commonBuilder_ != null) {
                return this.commonBuilder_.getMessageOrBuilder();
            }
            return this.common_ == null ? Common.getDefaultInstance() : this.common_;
        }

        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> getCommonFieldBuilder() {
            if (this.commonBuilder_ == null) {
                this.commonBuilder_ = new SingleFieldBuilderV3(this.getCommon(), this.getParentForChildren(), this.isClean());
                this.common_ = null;
            }
            return this.commonBuilder_;
        }

        @Override
        public String getContent() {
            Object ref = this.content_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.content_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getContentBytes() {
            Object ref = this.content_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.content_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setContent(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.content_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearContent() {
            this.content_ = RoomMessage.getDefaultInstance().getContent();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setContentBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomMessage.checkByteStringIsUtf8(value);
            this.content_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getSupprotLandscape() {
            return this.supprotLandscape_;
        }

        public Builder setSupprotLandscape(boolean value) {
            this.supprotLandscape_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearSupprotLandscape() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.supprotLandscape_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public int getRoommessagetypeValue() {
            return this.roommessagetype_;
        }

        public Builder setRoommessagetypeValue(int value) {
            this.roommessagetype_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        @Override
        public RoomMsgTypeEnum getRoommessagetype() {
            RoomMsgTypeEnum result = RoomMsgTypeEnum.forNumber(this.roommessagetype_);
            return result == null ? RoomMsgTypeEnum.UNRECOGNIZED : result;
        }

        public Builder setRoommessagetype(RoomMsgTypeEnum value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.bitField0_ |= 8;
            this.roommessagetype_ = value.getNumber();
            this.onChanged();
            return this;
        }

        public Builder clearRoommessagetype() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.roommessagetype_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getSystemTopMsg() {
            return this.systemTopMsg_;
        }

        public Builder setSystemTopMsg(boolean value) {
            this.systemTopMsg_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearSystemTopMsg() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.systemTopMsg_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getForcedGuarantee() {
            return this.forcedGuarantee_;
        }

        public Builder setForcedGuarantee(boolean value) {
            this.forcedGuarantee_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearForcedGuarantee() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.forcedGuarantee_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public String getBizScene() {
            Object ref = this.bizScene_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.bizScene_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getBizSceneBytes() {
            Object ref = this.bizScene_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.bizScene_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setBizScene(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.bizScene_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder clearBizScene() {
            this.bizScene_ = RoomMessage.getDefaultInstance().getBizScene();
            this.bitField0_ &= 0xFFFFFFBF;
            this.onChanged();
            return this;
        }

        public Builder setBizSceneBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            RoomMessage.checkByteStringIsUtf8(value);
            this.bizScene_ = value;
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        private MapField<String, String> internalGetBuriedPointMap() {
            if (this.buriedPointMap_ == null) {
                return MapField.emptyMapField(BuriedPointMapDefaultEntryHolder.defaultEntry);
            }
            return this.buriedPointMap_;
        }

        private MapField<String, String> internalGetMutableBuriedPointMap() {
            if (this.buriedPointMap_ == null) {
                this.buriedPointMap_ = MapField.newMapField(BuriedPointMapDefaultEntryHolder.defaultEntry);
            }
            if (!this.buriedPointMap_.isMutable()) {
                this.buriedPointMap_ = this.buriedPointMap_.copy();
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this.buriedPointMap_;
        }

        @Override
        public int getBuriedPointMapCount() {
            return this.internalGetBuriedPointMap().getMap().size();
        }

        @Override
        public boolean containsBuriedPointMap(String key) {
            if (key == null) {
                throw new NullPointerException("map key");
            }
            return this.internalGetBuriedPointMap().getMap().containsKey((Object)key);
        }

        @Override
        @Deprecated
        public Map<String, String> getBuriedPointMap() {
            return this.getBuriedPointMapMap();
        }

        @Override
        public Map<String, String> getBuriedPointMapMap() {
            return this.internalGetBuriedPointMap().getMap();
        }

        @Override
        public String getBuriedPointMapOrDefault(String key, String defaultValue) {
            if (key == null) {
                throw new NullPointerException("map key");
            }
            Map<String, String> map = this.internalGetBuriedPointMap().getMap();
            return map.containsKey((Object)key) ? (String)map.get((Object)key) : defaultValue;
        }

        @Override
        public String getBuriedPointMapOrThrow(String key) {
            if (key == null) {
                throw new NullPointerException("map key");
            }
            Map<String, String> map = this.internalGetBuriedPointMap().getMap();
            if (!map.containsKey((Object)key)) {
                throw new IllegalArgumentException();
            }
            return (String)map.get((Object)key);
        }

        public Builder clearBuriedPointMap() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.internalGetMutableBuriedPointMap().getMutableMap().clear();
            return this;
        }

        public Builder removeBuriedPointMap(String key) {
            if (key == null) {
                throw new NullPointerException("map key");
            }
            this.internalGetMutableBuriedPointMap().getMutableMap().remove((Object)key);
            return this;
        }

        @Deprecated
        public Map<String, String> getMutableBuriedPointMap() {
            this.bitField0_ |= 0x80;
            return this.internalGetMutableBuriedPointMap().getMutableMap();
        }

        public Builder putBuriedPointMap(String key, String value) {
            if (key == null) {
                throw new NullPointerException("map key");
            }
            if (value == null) {
                throw new NullPointerException("map value");
            }
            this.internalGetMutableBuriedPointMap().getMutableMap().put((Object)key, (Object)value);
            this.bitField0_ |= 0x80;
            return this;
        }

        public Builder putAllBuriedPointMap(Map<String, String> values) {
            this.internalGetMutableBuriedPointMap().getMutableMap().putAll(values);
            this.bitField0_ |= 0x80;
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

    private static final class BuriedPointMapDefaultEntryHolder {
        static final MapEntry<String, String> defaultEntry = MapEntry.newDefaultInstance(Douyin.internal_static_RoomMessage_BuriedPointMapEntry_descriptor, WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private BuriedPointMapDefaultEntryHolder() {
        }
    }
}


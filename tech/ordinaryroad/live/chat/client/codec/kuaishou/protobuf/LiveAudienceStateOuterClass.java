/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.GzoneNameplateOuterClass;
import tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf.LiveFansGroupStateOuterClass;

public final class LiveAudienceStateOuterClass {
    private static final Descriptors.Descriptor internal_static_LiveAudienceState_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LiveAudienceState_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_LiveAudienceState_LiveAudienceState_11_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LiveAudienceState_LiveAudienceState_11_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_fieldAccessorTable;
    private static Descriptors.FileDescriptor descriptor;

    private LiveAudienceStateOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        LiveAudienceStateOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nLiveAudienceState.protoGzoneNameplate.protoLiveFansGroupState.proto\"Ò\nLiveAudienceState\n\risFromFansTop (\b\r\nisKoi (\b7\n\rassistantType (2 .LiveAudienceState.AssistantType\nfansGroupIntimacyLevel (\r\"\n\tnameplate (2.GzoneNameplate/\nliveFansGroupState (2.LiveFansGroupState\nwealthGrade (\r\n\bbadgeKey\b (\tE\nliveAudienceState_11 (2'.LiveAudienceState.LiveAudienceState_11¶\nLiveAudienceState_11^\nliveAudienceState_11_1 (2>.LiveAudienceState.LiveAudienceState_11.LiveAudienceState_11_1>\nLiveAudienceState_11_1\n\tbadgeIcon (\t\n\tbadgeName (\t\"B\n\rAssistantType\nUNKNOWN_ASSISTANT_TYPE \t\nSUPER\n\nJUNIORB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[]{GzoneNameplateOuterClass.getDescriptor(), LiveFansGroupStateOuterClass.getDescriptor()});
        internal_static_LiveAudienceState_descriptor = (Descriptors.Descriptor)LiveAudienceStateOuterClass.getDescriptor().getMessageTypes().get(0);
        internal_static_LiveAudienceState_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LiveAudienceState_descriptor, new String[]{"IsFromFansTop", "IsKoi", "AssistantType", "FansGroupIntimacyLevel", "Nameplate", "LiveFansGroupState", "WealthGrade", "BadgeKey", "LiveAudienceState11"});
        internal_static_LiveAudienceState_LiveAudienceState_11_descriptor = (Descriptors.Descriptor)internal_static_LiveAudienceState_descriptor.getNestedTypes().get(0);
        internal_static_LiveAudienceState_LiveAudienceState_11_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LiveAudienceState_LiveAudienceState_11_descriptor, new String[]{"LiveAudienceState111"});
        internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_descriptor = (Descriptors.Descriptor)internal_static_LiveAudienceState_LiveAudienceState_11_descriptor.getNestedTypes().get(0);
        internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_descriptor, new String[]{"BadgeIcon", "BadgeName"});
        GzoneNameplateOuterClass.getDescriptor();
        LiveFansGroupStateOuterClass.getDescriptor();
    }

    public static final class LiveAudienceState
    extends GeneratedMessageV3
    implements LiveAudienceStateOrBuilder {
        private static final long serialVersionUID = 0L;
        private int bitField0_;
        public static final int ISFROMFANSTOP_FIELD_NUMBER = 1;
        private boolean isFromFansTop_ = false;
        public static final int ISKOI_FIELD_NUMBER = 2;
        private boolean isKoi_ = false;
        public static final int ASSISTANTTYPE_FIELD_NUMBER = 3;
        private int assistantType_ = 0;
        public static final int FANSGROUPINTIMACYLEVEL_FIELD_NUMBER = 4;
        private int fansGroupIntimacyLevel_ = 0;
        public static final int NAMEPLATE_FIELD_NUMBER = 5;
        private GzoneNameplateOuterClass.GzoneNameplate nameplate_;
        public static final int LIVEFANSGROUPSTATE_FIELD_NUMBER = 6;
        private LiveFansGroupStateOuterClass.LiveFansGroupState liveFansGroupState_;
        public static final int WEALTHGRADE_FIELD_NUMBER = 7;
        private int wealthGrade_ = 0;
        public static final int BADGEKEY_FIELD_NUMBER = 8;
        private volatile Object badgeKey_ = "";
        public static final int LIVEAUDIENCESTATE_11_FIELD_NUMBER = 11;
        private List<LiveAudienceState_11> liveAudienceState11_;
        private byte memoizedIsInitialized = (byte)-1;
        private static final LiveAudienceState DEFAULT_INSTANCE = new LiveAudienceState();
        private static final Parser<LiveAudienceState> PARSER = new AbstractParser<LiveAudienceState>(){

            @Override
            public LiveAudienceState parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                Builder builder = LiveAudienceState.newBuilder();
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

        private LiveAudienceState(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
        }

        private LiveAudienceState() {
            this.assistantType_ = 0;
            this.badgeKey_ = "";
            this.liveAudienceState11_ = Collections.emptyList();
        }

        @Override
        protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LiveAudienceState();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return internal_static_LiveAudienceState_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return internal_static_LiveAudienceState_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveAudienceState.class, Builder.class);
        }

        @Override
        public boolean getIsFromFansTop() {
            return this.isFromFansTop_;
        }

        @Override
        public boolean getIsKoi() {
            return this.isKoi_;
        }

        @Override
        public int getAssistantTypeValue() {
            return this.assistantType_;
        }

        @Override
        public AssistantType getAssistantType() {
            AssistantType result = AssistantType.forNumber(this.assistantType_);
            return result == null ? AssistantType.UNRECOGNIZED : result;
        }

        @Override
        public int getFansGroupIntimacyLevel() {
            return this.fansGroupIntimacyLevel_;
        }

        @Override
        public boolean hasNameplate() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override
        public GzoneNameplateOuterClass.GzoneNameplate getNameplate() {
            return this.nameplate_ == null ? GzoneNameplateOuterClass.GzoneNameplate.getDefaultInstance() : this.nameplate_;
        }

        @Override
        public GzoneNameplateOuterClass.GzoneNameplateOrBuilder getNameplateOrBuilder() {
            return this.nameplate_ == null ? GzoneNameplateOuterClass.GzoneNameplate.getDefaultInstance() : this.nameplate_;
        }

        @Override
        public boolean hasLiveFansGroupState() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override
        public LiveFansGroupStateOuterClass.LiveFansGroupState getLiveFansGroupState() {
            return this.liveFansGroupState_ == null ? LiveFansGroupStateOuterClass.LiveFansGroupState.getDefaultInstance() : this.liveFansGroupState_;
        }

        @Override
        public LiveFansGroupStateOuterClass.LiveFansGroupStateOrBuilder getLiveFansGroupStateOrBuilder() {
            return this.liveFansGroupState_ == null ? LiveFansGroupStateOuterClass.LiveFansGroupState.getDefaultInstance() : this.liveFansGroupState_;
        }

        @Override
        public int getWealthGrade() {
            return this.wealthGrade_;
        }

        @Override
        public String getBadgeKey() {
            Object ref = this.badgeKey_;
            if (ref instanceof String) {
                return (String)ref;
            }
            ByteString bs = (ByteString)ref;
            String s = bs.toStringUtf8();
            this.badgeKey_ = s;
            return s;
        }

        @Override
        public ByteString getBadgeKeyBytes() {
            Object ref = this.badgeKey_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.badgeKey_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        @Override
        public List<LiveAudienceState_11> getLiveAudienceState11List() {
            return this.liveAudienceState11_;
        }

        @Override
        public List<? extends LiveAudienceState_11OrBuilder> getLiveAudienceState11OrBuilderList() {
            return this.liveAudienceState11_;
        }

        @Override
        public int getLiveAudienceState11Count() {
            return this.liveAudienceState11_.size();
        }

        @Override
        public LiveAudienceState_11 getLiveAudienceState11(int index) {
            return (LiveAudienceState_11)this.liveAudienceState11_.get(index);
        }

        @Override
        public LiveAudienceState_11OrBuilder getLiveAudienceState11OrBuilder(int index) {
            return (LiveAudienceState_11OrBuilder)this.liveAudienceState11_.get(index);
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
            if (this.isFromFansTop_) {
                output.writeBool(1, this.isFromFansTop_);
            }
            if (this.isKoi_) {
                output.writeBool(2, this.isKoi_);
            }
            if (this.assistantType_ != AssistantType.UNKNOWN_ASSISTANT_TYPE.getNumber()) {
                output.writeEnum(3, this.assistantType_);
            }
            if (this.fansGroupIntimacyLevel_ != 0) {
                output.writeUInt32(4, this.fansGroupIntimacyLevel_);
            }
            if ((this.bitField0_ & 1) != 0) {
                output.writeMessage(5, this.getNameplate());
            }
            if ((this.bitField0_ & 2) != 0) {
                output.writeMessage(6, this.getLiveFansGroupState());
            }
            if (this.wealthGrade_ != 0) {
                output.writeUInt32(7, this.wealthGrade_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.badgeKey_)) {
                GeneratedMessageV3.writeString(output, 8, this.badgeKey_);
            }
            for (int i = 0; i < this.liveAudienceState11_.size(); ++i) {
                output.writeMessage(11, (MessageLite)this.liveAudienceState11_.get(i));
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
            if (this.isFromFansTop_) {
                size += CodedOutputStream.computeBoolSize(1, this.isFromFansTop_);
            }
            if (this.isKoi_) {
                size += CodedOutputStream.computeBoolSize(2, this.isKoi_);
            }
            if (this.assistantType_ != AssistantType.UNKNOWN_ASSISTANT_TYPE.getNumber()) {
                size += CodedOutputStream.computeEnumSize(3, this.assistantType_);
            }
            if (this.fansGroupIntimacyLevel_ != 0) {
                size += CodedOutputStream.computeUInt32Size(4, this.fansGroupIntimacyLevel_);
            }
            if ((this.bitField0_ & 1) != 0) {
                size += CodedOutputStream.computeMessageSize(5, this.getNameplate());
            }
            if ((this.bitField0_ & 2) != 0) {
                size += CodedOutputStream.computeMessageSize(6, this.getLiveFansGroupState());
            }
            if (this.wealthGrade_ != 0) {
                size += CodedOutputStream.computeUInt32Size(7, this.wealthGrade_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.badgeKey_)) {
                size += GeneratedMessageV3.computeStringSize(8, this.badgeKey_);
            }
            for (int i = 0; i < this.liveAudienceState11_.size(); ++i) {
                size += CodedOutputStream.computeMessageSize(11, (MessageLite)this.liveAudienceState11_.get(i));
            }
            this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
            return size;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LiveAudienceState)) {
                return super.equals(obj);
            }
            LiveAudienceState other = (LiveAudienceState)obj;
            if (this.getIsFromFansTop() != other.getIsFromFansTop()) {
                return false;
            }
            if (this.getIsKoi() != other.getIsKoi()) {
                return false;
            }
            if (this.assistantType_ != other.assistantType_) {
                return false;
            }
            if (this.getFansGroupIntimacyLevel() != other.getFansGroupIntimacyLevel()) {
                return false;
            }
            if (this.hasNameplate() != other.hasNameplate()) {
                return false;
            }
            if (this.hasNameplate() && !this.getNameplate().equals(other.getNameplate())) {
                return false;
            }
            if (this.hasLiveFansGroupState() != other.hasLiveFansGroupState()) {
                return false;
            }
            if (this.hasLiveFansGroupState() && !this.getLiveFansGroupState().equals(other.getLiveFansGroupState())) {
                return false;
            }
            if (this.getWealthGrade() != other.getWealthGrade()) {
                return false;
            }
            if (!this.getBadgeKey().equals((Object)other.getBadgeKey())) {
                return false;
            }
            if (!this.getLiveAudienceState11List().equals(other.getLiveAudienceState11List())) {
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
            hash = 19 * hash + LiveAudienceState.getDescriptor().hashCode();
            hash = 37 * hash + 1;
            hash = 53 * hash + Internal.hashBoolean(this.getIsFromFansTop());
            hash = 37 * hash + 2;
            hash = 53 * hash + Internal.hashBoolean(this.getIsKoi());
            hash = 37 * hash + 3;
            hash = 53 * hash + this.assistantType_;
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getFansGroupIntimacyLevel();
            if (this.hasNameplate()) {
                hash = 37 * hash + 5;
                hash = 53 * hash + this.getNameplate().hashCode();
            }
            if (this.hasLiveFansGroupState()) {
                hash = 37 * hash + 6;
                hash = 53 * hash + this.getLiveFansGroupState().hashCode();
            }
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getWealthGrade();
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getBadgeKey().hashCode();
            if (this.getLiveAudienceState11Count() > 0) {
                hash = 37 * hash + 11;
                hash = 53 * hash + this.getLiveAudienceState11List().hashCode();
            }
            this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
            return hash;
        }

        public static LiveAudienceState parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LiveAudienceState parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LiveAudienceState parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LiveAudienceState parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LiveAudienceState parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LiveAudienceState parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LiveAudienceState parseFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LiveAudienceState parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LiveAudienceState parseDelimitedFrom(InputStream input) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LiveAudienceState parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LiveAudienceState parseFrom(CodedInputStream input) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LiveAudienceState parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override
        public Builder newBuilderForType() {
            return LiveAudienceState.newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LiveAudienceState prototype) {
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

        public static LiveAudienceState getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LiveAudienceState> parser() {
            return PARSER;
        }

        public Parser<LiveAudienceState> getParserForType() {
            return PARSER;
        }

        @Override
        public LiveAudienceState getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public static final class Builder
        extends GeneratedMessageV3.Builder<Builder>
        implements LiveAudienceStateOrBuilder {
            private int bitField0_;
            private boolean isFromFansTop_;
            private boolean isKoi_;
            private int assistantType_ = 0;
            private int fansGroupIntimacyLevel_;
            private GzoneNameplateOuterClass.GzoneNameplate nameplate_;
            private SingleFieldBuilderV3<GzoneNameplateOuterClass.GzoneNameplate, GzoneNameplateOuterClass.GzoneNameplate.Builder, GzoneNameplateOuterClass.GzoneNameplateOrBuilder> nameplateBuilder_;
            private LiveFansGroupStateOuterClass.LiveFansGroupState liveFansGroupState_;
            private SingleFieldBuilderV3<LiveFansGroupStateOuterClass.LiveFansGroupState, LiveFansGroupStateOuterClass.LiveFansGroupState.Builder, LiveFansGroupStateOuterClass.LiveFansGroupStateOrBuilder> liveFansGroupStateBuilder_;
            private int wealthGrade_;
            private Object badgeKey_ = "";
            private List<LiveAudienceState_11> liveAudienceState11_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<LiveAudienceState_11, LiveAudienceState_11.Builder, LiveAudienceState_11OrBuilder> liveAudienceState11Builder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_LiveAudienceState_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_LiveAudienceState_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveAudienceState.class, Builder.class);
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
                    this.getNameplateFieldBuilder();
                    this.getLiveFansGroupStateFieldBuilder();
                    this.getLiveAudienceState11FieldBuilder();
                }
            }

            @Override
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.isFromFansTop_ = false;
                this.isKoi_ = false;
                this.assistantType_ = 0;
                this.fansGroupIntimacyLevel_ = 0;
                this.nameplate_ = null;
                if (this.nameplateBuilder_ != null) {
                    this.nameplateBuilder_.dispose();
                    this.nameplateBuilder_ = null;
                }
                this.liveFansGroupState_ = null;
                if (this.liveFansGroupStateBuilder_ != null) {
                    this.liveFansGroupStateBuilder_.dispose();
                    this.liveFansGroupStateBuilder_ = null;
                }
                this.wealthGrade_ = 0;
                this.badgeKey_ = "";
                if (this.liveAudienceState11Builder_ == null) {
                    this.liveAudienceState11_ = Collections.emptyList();
                } else {
                    this.liveAudienceState11_ = null;
                    this.liveAudienceState11Builder_.clear();
                }
                this.bitField0_ &= 0xFFFFFEFF;
                return this;
            }

            @Override
            public Descriptors.Descriptor getDescriptorForType() {
                return internal_static_LiveAudienceState_descriptor;
            }

            @Override
            public LiveAudienceState getDefaultInstanceForType() {
                return LiveAudienceState.getDefaultInstance();
            }

            @Override
            public LiveAudienceState build() {
                LiveAudienceState result = this.buildPartial();
                if (!result.isInitialized()) {
                    throw Builder.newUninitializedMessageException(result);
                }
                return result;
            }

            @Override
            public LiveAudienceState buildPartial() {
                LiveAudienceState result = new LiveAudienceState(this);
                this.buildPartialRepeatedFields(result);
                if (this.bitField0_ != 0) {
                    this.buildPartial0(result);
                }
                this.onBuilt();
                return result;
            }

            private void buildPartialRepeatedFields(LiveAudienceState result) {
                if (this.liveAudienceState11Builder_ == null) {
                    if ((this.bitField0_ & 0x100) != 0) {
                        this.liveAudienceState11_ = Collections.unmodifiableList(this.liveAudienceState11_);
                        this.bitField0_ &= 0xFFFFFEFF;
                    }
                    result.liveAudienceState11_ = this.liveAudienceState11_;
                } else {
                    result.liveAudienceState11_ = this.liveAudienceState11Builder_.build();
                }
            }

            private void buildPartial0(LiveAudienceState result) {
                int from_bitField0_ = this.bitField0_;
                if ((from_bitField0_ & 1) != 0) {
                    result.isFromFansTop_ = this.isFromFansTop_;
                }
                if ((from_bitField0_ & 2) != 0) {
                    result.isKoi_ = this.isKoi_;
                }
                if ((from_bitField0_ & 4) != 0) {
                    result.assistantType_ = this.assistantType_;
                }
                if ((from_bitField0_ & 8) != 0) {
                    result.fansGroupIntimacyLevel_ = this.fansGroupIntimacyLevel_;
                }
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 0x10) != 0) {
                    result.nameplate_ = this.nameplateBuilder_ == null ? this.nameplate_ : this.nameplateBuilder_.build();
                    to_bitField0_ |= 1;
                }
                if ((from_bitField0_ & 0x20) != 0) {
                    result.liveFansGroupState_ = this.liveFansGroupStateBuilder_ == null ? this.liveFansGroupState_ : this.liveFansGroupStateBuilder_.build();
                    to_bitField0_ |= 2;
                }
                if ((from_bitField0_ & 0x40) != 0) {
                    result.wealthGrade_ = this.wealthGrade_;
                }
                if ((from_bitField0_ & 0x80) != 0) {
                    result.badgeKey_ = this.badgeKey_;
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
                if (other instanceof LiveAudienceState) {
                    return this.mergeFrom((LiveAudienceState)other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LiveAudienceState other) {
                if (other == LiveAudienceState.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFromFansTop()) {
                    this.setIsFromFansTop(other.getIsFromFansTop());
                }
                if (other.getIsKoi()) {
                    this.setIsKoi(other.getIsKoi());
                }
                if (other.assistantType_ != 0) {
                    this.setAssistantTypeValue(other.getAssistantTypeValue());
                }
                if (other.getFansGroupIntimacyLevel() != 0) {
                    this.setFansGroupIntimacyLevel(other.getFansGroupIntimacyLevel());
                }
                if (other.hasNameplate()) {
                    this.mergeNameplate(other.getNameplate());
                }
                if (other.hasLiveFansGroupState()) {
                    this.mergeLiveFansGroupState(other.getLiveFansGroupState());
                }
                if (other.getWealthGrade() != 0) {
                    this.setWealthGrade(other.getWealthGrade());
                }
                if (!other.getBadgeKey().isEmpty()) {
                    this.badgeKey_ = other.badgeKey_;
                    this.bitField0_ |= 0x80;
                    this.onChanged();
                }
                if (this.liveAudienceState11Builder_ == null) {
                    if (!other.liveAudienceState11_.isEmpty()) {
                        if (this.liveAudienceState11_.isEmpty()) {
                            this.liveAudienceState11_ = other.liveAudienceState11_;
                            this.bitField0_ &= 0xFFFFFEFF;
                        } else {
                            this.ensureLiveAudienceState11IsMutable();
                            this.liveAudienceState11_.addAll((Collection)other.liveAudienceState11_);
                        }
                        this.onChanged();
                    }
                } else if (!other.liveAudienceState11_.isEmpty()) {
                    if (this.liveAudienceState11Builder_.isEmpty()) {
                        this.liveAudienceState11Builder_.dispose();
                        this.liveAudienceState11Builder_ = null;
                        this.liveAudienceState11_ = other.liveAudienceState11_;
                        this.bitField0_ &= 0xFFFFFEFF;
                        this.liveAudienceState11Builder_ = alwaysUseFieldBuilders ? this.getLiveAudienceState11FieldBuilder() : null;
                    } else {
                        this.liveAudienceState11Builder_.addAllMessages((Iterable<LiveAudienceState_11>)other.liveAudienceState11_);
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
                    block17: while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0: {
                                done = true;
                                continue block17;
                            }
                            case 8: {
                                this.isFromFansTop_ = input.readBool();
                                this.bitField0_ |= 1;
                                continue block17;
                            }
                            case 16: {
                                this.isKoi_ = input.readBool();
                                this.bitField0_ |= 2;
                                continue block17;
                            }
                            case 24: {
                                this.assistantType_ = input.readEnum();
                                this.bitField0_ |= 4;
                                continue block17;
                            }
                            case 32: {
                                this.fansGroupIntimacyLevel_ = input.readUInt32();
                                this.bitField0_ |= 8;
                                continue block17;
                            }
                            case 42: {
                                input.readMessage(this.getNameplateFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 0x10;
                                continue block17;
                            }
                            case 50: {
                                input.readMessage(this.getLiveFansGroupStateFieldBuilder().getBuilder(), extensionRegistry);
                                this.bitField0_ |= 0x20;
                                continue block17;
                            }
                            case 56: {
                                this.wealthGrade_ = input.readUInt32();
                                this.bitField0_ |= 0x40;
                                continue block17;
                            }
                            case 66: {
                                this.badgeKey_ = input.readStringRequireUtf8();
                                this.bitField0_ |= 0x80;
                                continue block17;
                            }
                            case 90: {
                                LiveAudienceState_11 m = input.readMessage(LiveAudienceState_11.parser(), extensionRegistry);
                                if (this.liveAudienceState11Builder_ == null) {
                                    this.ensureLiveAudienceState11IsMutable();
                                    this.liveAudienceState11_.add((Object)m);
                                    continue block17;
                                }
                                this.liveAudienceState11Builder_.addMessage(m);
                                continue block17;
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
            public boolean getIsFromFansTop() {
                return this.isFromFansTop_;
            }

            public Builder setIsFromFansTop(boolean value) {
                this.isFromFansTop_ = value;
                this.bitField0_ |= 1;
                this.onChanged();
                return this;
            }

            public Builder clearIsFromFansTop() {
                this.bitField0_ &= 0xFFFFFFFE;
                this.isFromFansTop_ = false;
                this.onChanged();
                return this;
            }

            @Override
            public boolean getIsKoi() {
                return this.isKoi_;
            }

            public Builder setIsKoi(boolean value) {
                this.isKoi_ = value;
                this.bitField0_ |= 2;
                this.onChanged();
                return this;
            }

            public Builder clearIsKoi() {
                this.bitField0_ &= 0xFFFFFFFD;
                this.isKoi_ = false;
                this.onChanged();
                return this;
            }

            @Override
            public int getAssistantTypeValue() {
                return this.assistantType_;
            }

            public Builder setAssistantTypeValue(int value) {
                this.assistantType_ = value;
                this.bitField0_ |= 4;
                this.onChanged();
                return this;
            }

            @Override
            public AssistantType getAssistantType() {
                AssistantType result = AssistantType.forNumber(this.assistantType_);
                return result == null ? AssistantType.UNRECOGNIZED : result;
            }

            public Builder setAssistantType(AssistantType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.assistantType_ = value.getNumber();
                this.onChanged();
                return this;
            }

            public Builder clearAssistantType() {
                this.bitField0_ &= 0xFFFFFFFB;
                this.assistantType_ = 0;
                this.onChanged();
                return this;
            }

            @Override
            public int getFansGroupIntimacyLevel() {
                return this.fansGroupIntimacyLevel_;
            }

            public Builder setFansGroupIntimacyLevel(int value) {
                this.fansGroupIntimacyLevel_ = value;
                this.bitField0_ |= 8;
                this.onChanged();
                return this;
            }

            public Builder clearFansGroupIntimacyLevel() {
                this.bitField0_ &= 0xFFFFFFF7;
                this.fansGroupIntimacyLevel_ = 0;
                this.onChanged();
                return this;
            }

            @Override
            public boolean hasNameplate() {
                return (this.bitField0_ & 0x10) != 0;
            }

            @Override
            public GzoneNameplateOuterClass.GzoneNameplate getNameplate() {
                if (this.nameplateBuilder_ == null) {
                    return this.nameplate_ == null ? GzoneNameplateOuterClass.GzoneNameplate.getDefaultInstance() : this.nameplate_;
                }
                return this.nameplateBuilder_.getMessage();
            }

            public Builder setNameplate(GzoneNameplateOuterClass.GzoneNameplate value) {
                if (this.nameplateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.nameplate_ = value;
                } else {
                    this.nameplateBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this;
            }

            public Builder setNameplate(GzoneNameplateOuterClass.GzoneNameplate.Builder builderForValue) {
                if (this.nameplateBuilder_ == null) {
                    this.nameplate_ = builderForValue.build();
                } else {
                    this.nameplateBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this;
            }

            public Builder mergeNameplate(GzoneNameplateOuterClass.GzoneNameplate value) {
                if (this.nameplateBuilder_ == null) {
                    if ((this.bitField0_ & 0x10) != 0 && this.nameplate_ != null && this.nameplate_ != GzoneNameplateOuterClass.GzoneNameplate.getDefaultInstance()) {
                        this.getNameplateBuilder().mergeFrom(value);
                    } else {
                        this.nameplate_ = value;
                    }
                } else {
                    this.nameplateBuilder_.mergeFrom(value);
                }
                if (this.nameplate_ != null) {
                    this.bitField0_ |= 0x10;
                    this.onChanged();
                }
                return this;
            }

            public Builder clearNameplate() {
                this.bitField0_ &= 0xFFFFFFEF;
                this.nameplate_ = null;
                if (this.nameplateBuilder_ != null) {
                    this.nameplateBuilder_.dispose();
                    this.nameplateBuilder_ = null;
                }
                this.onChanged();
                return this;
            }

            public GzoneNameplateOuterClass.GzoneNameplate.Builder getNameplateBuilder() {
                this.bitField0_ |= 0x10;
                this.onChanged();
                return this.getNameplateFieldBuilder().getBuilder();
            }

            @Override
            public GzoneNameplateOuterClass.GzoneNameplateOrBuilder getNameplateOrBuilder() {
                if (this.nameplateBuilder_ != null) {
                    return this.nameplateBuilder_.getMessageOrBuilder();
                }
                return this.nameplate_ == null ? GzoneNameplateOuterClass.GzoneNameplate.getDefaultInstance() : this.nameplate_;
            }

            private SingleFieldBuilderV3<GzoneNameplateOuterClass.GzoneNameplate, GzoneNameplateOuterClass.GzoneNameplate.Builder, GzoneNameplateOuterClass.GzoneNameplateOrBuilder> getNameplateFieldBuilder() {
                if (this.nameplateBuilder_ == null) {
                    this.nameplateBuilder_ = new SingleFieldBuilderV3(this.getNameplate(), this.getParentForChildren(), this.isClean());
                    this.nameplate_ = null;
                }
                return this.nameplateBuilder_;
            }

            @Override
            public boolean hasLiveFansGroupState() {
                return (this.bitField0_ & 0x20) != 0;
            }

            @Override
            public LiveFansGroupStateOuterClass.LiveFansGroupState getLiveFansGroupState() {
                if (this.liveFansGroupStateBuilder_ == null) {
                    return this.liveFansGroupState_ == null ? LiveFansGroupStateOuterClass.LiveFansGroupState.getDefaultInstance() : this.liveFansGroupState_;
                }
                return this.liveFansGroupStateBuilder_.getMessage();
            }

            public Builder setLiveFansGroupState(LiveFansGroupStateOuterClass.LiveFansGroupState value) {
                if (this.liveFansGroupStateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.liveFansGroupState_ = value;
                } else {
                    this.liveFansGroupStateBuilder_.setMessage(value);
                }
                this.bitField0_ |= 0x20;
                this.onChanged();
                return this;
            }

            public Builder setLiveFansGroupState(LiveFansGroupStateOuterClass.LiveFansGroupState.Builder builderForValue) {
                if (this.liveFansGroupStateBuilder_ == null) {
                    this.liveFansGroupState_ = builderForValue.build();
                } else {
                    this.liveFansGroupStateBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 0x20;
                this.onChanged();
                return this;
            }

            public Builder mergeLiveFansGroupState(LiveFansGroupStateOuterClass.LiveFansGroupState value) {
                if (this.liveFansGroupStateBuilder_ == null) {
                    if ((this.bitField0_ & 0x20) != 0 && this.liveFansGroupState_ != null && this.liveFansGroupState_ != LiveFansGroupStateOuterClass.LiveFansGroupState.getDefaultInstance()) {
                        this.getLiveFansGroupStateBuilder().mergeFrom(value);
                    } else {
                        this.liveFansGroupState_ = value;
                    }
                } else {
                    this.liveFansGroupStateBuilder_.mergeFrom(value);
                }
                if (this.liveFansGroupState_ != null) {
                    this.bitField0_ |= 0x20;
                    this.onChanged();
                }
                return this;
            }

            public Builder clearLiveFansGroupState() {
                this.bitField0_ &= 0xFFFFFFDF;
                this.liveFansGroupState_ = null;
                if (this.liveFansGroupStateBuilder_ != null) {
                    this.liveFansGroupStateBuilder_.dispose();
                    this.liveFansGroupStateBuilder_ = null;
                }
                this.onChanged();
                return this;
            }

            public LiveFansGroupStateOuterClass.LiveFansGroupState.Builder getLiveFansGroupStateBuilder() {
                this.bitField0_ |= 0x20;
                this.onChanged();
                return this.getLiveFansGroupStateFieldBuilder().getBuilder();
            }

            @Override
            public LiveFansGroupStateOuterClass.LiveFansGroupStateOrBuilder getLiveFansGroupStateOrBuilder() {
                if (this.liveFansGroupStateBuilder_ != null) {
                    return this.liveFansGroupStateBuilder_.getMessageOrBuilder();
                }
                return this.liveFansGroupState_ == null ? LiveFansGroupStateOuterClass.LiveFansGroupState.getDefaultInstance() : this.liveFansGroupState_;
            }

            private SingleFieldBuilderV3<LiveFansGroupStateOuterClass.LiveFansGroupState, LiveFansGroupStateOuterClass.LiveFansGroupState.Builder, LiveFansGroupStateOuterClass.LiveFansGroupStateOrBuilder> getLiveFansGroupStateFieldBuilder() {
                if (this.liveFansGroupStateBuilder_ == null) {
                    this.liveFansGroupStateBuilder_ = new SingleFieldBuilderV3(this.getLiveFansGroupState(), this.getParentForChildren(), this.isClean());
                    this.liveFansGroupState_ = null;
                }
                return this.liveFansGroupStateBuilder_;
            }

            @Override
            public int getWealthGrade() {
                return this.wealthGrade_;
            }

            public Builder setWealthGrade(int value) {
                this.wealthGrade_ = value;
                this.bitField0_ |= 0x40;
                this.onChanged();
                return this;
            }

            public Builder clearWealthGrade() {
                this.bitField0_ &= 0xFFFFFFBF;
                this.wealthGrade_ = 0;
                this.onChanged();
                return this;
            }

            @Override
            public String getBadgeKey() {
                Object ref = this.badgeKey_;
                if (!(ref instanceof String)) {
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.badgeKey_ = s;
                    return s;
                }
                return (String)ref;
            }

            @Override
            public ByteString getBadgeKeyBytes() {
                Object ref = this.badgeKey_;
                if (ref instanceof String) {
                    ByteString b = ByteString.copyFromUtf8((String)ref);
                    this.badgeKey_ = b;
                    return b;
                }
                return (ByteString)ref;
            }

            public Builder setBadgeKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.badgeKey_ = value;
                this.bitField0_ |= 0x80;
                this.onChanged();
                return this;
            }

            public Builder clearBadgeKey() {
                this.badgeKey_ = LiveAudienceState.getDefaultInstance().getBadgeKey();
                this.bitField0_ &= 0xFFFFFF7F;
                this.onChanged();
                return this;
            }

            public Builder setBadgeKeyBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                LiveAudienceState.checkByteStringIsUtf8(value);
                this.badgeKey_ = value;
                this.bitField0_ |= 0x80;
                this.onChanged();
                return this;
            }

            private void ensureLiveAudienceState11IsMutable() {
                if ((this.bitField0_ & 0x100) == 0) {
                    this.liveAudienceState11_ = new ArrayList(this.liveAudienceState11_);
                    this.bitField0_ |= 0x100;
                }
            }

            @Override
            public List<LiveAudienceState_11> getLiveAudienceState11List() {
                if (this.liveAudienceState11Builder_ == null) {
                    return Collections.unmodifiableList(this.liveAudienceState11_);
                }
                return this.liveAudienceState11Builder_.getMessageList();
            }

            @Override
            public int getLiveAudienceState11Count() {
                if (this.liveAudienceState11Builder_ == null) {
                    return this.liveAudienceState11_.size();
                }
                return this.liveAudienceState11Builder_.getCount();
            }

            @Override
            public LiveAudienceState_11 getLiveAudienceState11(int index) {
                if (this.liveAudienceState11Builder_ == null) {
                    return (LiveAudienceState_11)this.liveAudienceState11_.get(index);
                }
                return this.liveAudienceState11Builder_.getMessage(index);
            }

            public Builder setLiveAudienceState11(int index, LiveAudienceState_11 value) {
                if (this.liveAudienceState11Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.set(index, (Object)value);
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setLiveAudienceState11(int index, LiveAudienceState_11.Builder builderForValue) {
                if (this.liveAudienceState11Builder_ == null) {
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.set(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLiveAudienceState11(LiveAudienceState_11 value) {
                if (this.liveAudienceState11Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.add((Object)value);
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.addMessage(value);
                }
                return this;
            }

            public Builder addLiveAudienceState11(int index, LiveAudienceState_11 value) {
                if (this.liveAudienceState11Builder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.add(index, (Object)value);
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addLiveAudienceState11(LiveAudienceState_11.Builder builderForValue) {
                if (this.liveAudienceState11Builder_ == null) {
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.add((Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLiveAudienceState11(int index, LiveAudienceState_11.Builder builderForValue) {
                if (this.liveAudienceState11Builder_ == null) {
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.add(index, (Object)builderForValue.build());
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLiveAudienceState11(Iterable<? extends LiveAudienceState_11> values) {
                if (this.liveAudienceState11Builder_ == null) {
                    this.ensureLiveAudienceState11IsMutable();
                    AbstractMessageLite.Builder.addAll(values, this.liveAudienceState11_);
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLiveAudienceState11() {
                if (this.liveAudienceState11Builder_ == null) {
                    this.liveAudienceState11_ = Collections.emptyList();
                    this.bitField0_ &= 0xFFFFFEFF;
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.clear();
                }
                return this;
            }

            public Builder removeLiveAudienceState11(int index) {
                if (this.liveAudienceState11Builder_ == null) {
                    this.ensureLiveAudienceState11IsMutable();
                    this.liveAudienceState11_.remove(index);
                    this.onChanged();
                } else {
                    this.liveAudienceState11Builder_.remove(index);
                }
                return this;
            }

            public LiveAudienceState_11.Builder getLiveAudienceState11Builder(int index) {
                return this.getLiveAudienceState11FieldBuilder().getBuilder(index);
            }

            @Override
            public LiveAudienceState_11OrBuilder getLiveAudienceState11OrBuilder(int index) {
                if (this.liveAudienceState11Builder_ == null) {
                    return (LiveAudienceState_11OrBuilder)this.liveAudienceState11_.get(index);
                }
                return this.liveAudienceState11Builder_.getMessageOrBuilder(index);
            }

            @Override
            public List<? extends LiveAudienceState_11OrBuilder> getLiveAudienceState11OrBuilderList() {
                if (this.liveAudienceState11Builder_ != null) {
                    return this.liveAudienceState11Builder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.liveAudienceState11_);
            }

            public LiveAudienceState_11.Builder addLiveAudienceState11Builder() {
                return this.getLiveAudienceState11FieldBuilder().addBuilder(LiveAudienceState_11.getDefaultInstance());
            }

            public LiveAudienceState_11.Builder addLiveAudienceState11Builder(int index) {
                return this.getLiveAudienceState11FieldBuilder().addBuilder(index, LiveAudienceState_11.getDefaultInstance());
            }

            public List<LiveAudienceState_11.Builder> getLiveAudienceState11BuilderList() {
                return this.getLiveAudienceState11FieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LiveAudienceState_11, LiveAudienceState_11.Builder, LiveAudienceState_11OrBuilder> getLiveAudienceState11FieldBuilder() {
                if (this.liveAudienceState11Builder_ == null) {
                    this.liveAudienceState11Builder_ = new RepeatedFieldBuilderV3(this.liveAudienceState11_, (this.bitField0_ & 0x100) != 0, this.getParentForChildren(), this.isClean());
                    this.liveAudienceState11_ = null;
                }
                return this.liveAudienceState11Builder_;
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

        public static enum AssistantType implements ProtocolMessageEnum
        {
            UNKNOWN_ASSISTANT_TYPE(0),
            SUPER(1),
            JUNIOR(2),
            UNRECOGNIZED(-1);

            public static final int UNKNOWN_ASSISTANT_TYPE_VALUE = 0;
            public static final int SUPER_VALUE = 1;
            public static final int JUNIOR_VALUE = 2;
            private static final Internal.EnumLiteMap<AssistantType> internalValueMap;
            private static final AssistantType[] VALUES;
            private final int value;

            @Override
            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                }
                return this.value;
            }

            @Deprecated
            public static AssistantType valueOf(int value) {
                return AssistantType.forNumber(value);
            }

            public static AssistantType forNumber(int value) {
                switch (value) {
                    case 0: {
                        return UNKNOWN_ASSISTANT_TYPE;
                    }
                    case 1: {
                        return SUPER;
                    }
                    case 2: {
                        return JUNIOR;
                    }
                }
                return null;
            }

            public static Internal.EnumLiteMap<AssistantType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
                }
                return (Descriptors.EnumValueDescriptor)AssistantType.getDescriptor().getValues().get(this.ordinal());
            }

            @Override
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return AssistantType.getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return (Descriptors.EnumDescriptor)LiveAudienceState.getDescriptor().getEnumTypes().get(0);
            }

            public static AssistantType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != AssistantType.getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[desc.getIndex()];
            }

            private AssistantType(int value) {
                this.value = value;
            }

            static {
                internalValueMap = new Internal.EnumLiteMap<AssistantType>(){

                    @Override
                    public AssistantType findValueByNumber(int number) {
                        return AssistantType.forNumber(number);
                    }
                };
                VALUES = AssistantType.values();
            }
        }

        public static final class LiveAudienceState_11
        extends GeneratedMessageV3
        implements LiveAudienceState_11OrBuilder {
            private static final long serialVersionUID = 0L;
            private int bitField0_;
            public static final int LIVEAUDIENCESTATE_11_1_FIELD_NUMBER = 1;
            private LiveAudienceState_11_1 liveAudienceState111_;
            private byte memoizedIsInitialized = (byte)-1;
            private static final LiveAudienceState_11 DEFAULT_INSTANCE = new LiveAudienceState_11();
            private static final Parser<LiveAudienceState_11> PARSER = new AbstractParser<LiveAudienceState_11>(){

                @Override
                public LiveAudienceState_11 parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    Builder builder = LiveAudienceState_11.newBuilder();
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

            private LiveAudienceState_11(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
            }

            private LiveAudienceState_11() {
            }

            @Override
            protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new LiveAudienceState_11();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return internal_static_LiveAudienceState_LiveAudienceState_11_descriptor;
            }

            @Override
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return internal_static_LiveAudienceState_LiveAudienceState_11_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveAudienceState_11.class, Builder.class);
            }

            @Override
            public boolean hasLiveAudienceState111() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override
            public LiveAudienceState_11_1 getLiveAudienceState111() {
                return this.liveAudienceState111_ == null ? LiveAudienceState_11_1.getDefaultInstance() : this.liveAudienceState111_;
            }

            @Override
            public LiveAudienceState_11_1OrBuilder getLiveAudienceState111OrBuilder() {
                return this.liveAudienceState111_ == null ? LiveAudienceState_11_1.getDefaultInstance() : this.liveAudienceState111_;
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
                    output.writeMessage(1, this.getLiveAudienceState111());
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
                    size += CodedOutputStream.computeMessageSize(1, this.getLiveAudienceState111());
                }
                this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
                return size;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LiveAudienceState_11)) {
                    return super.equals(obj);
                }
                LiveAudienceState_11 other = (LiveAudienceState_11)obj;
                if (this.hasLiveAudienceState111() != other.hasLiveAudienceState111()) {
                    return false;
                }
                if (this.hasLiveAudienceState111() && !this.getLiveAudienceState111().equals(other.getLiveAudienceState111())) {
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
                hash = 19 * hash + LiveAudienceState_11.getDescriptor().hashCode();
                if (this.hasLiveAudienceState111()) {
                    hash = 37 * hash + 1;
                    hash = 53 * hash + this.getLiveAudienceState111().hashCode();
                }
                this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
                return hash;
            }

            public static LiveAudienceState_11 parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static LiveAudienceState_11 parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static LiveAudienceState_11 parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static LiveAudienceState_11 parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static LiveAudienceState_11 parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static LiveAudienceState_11 parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static LiveAudienceState_11 parseFrom(InputStream input) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static LiveAudienceState_11 parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static LiveAudienceState_11 parseDelimitedFrom(InputStream input) throws IOException {
                return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static LiveAudienceState_11 parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static LiveAudienceState_11 parseFrom(CodedInputStream input) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static LiveAudienceState_11 parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override
            public Builder newBuilderForType() {
                return LiveAudienceState_11.newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(LiveAudienceState_11 prototype) {
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

            public static LiveAudienceState_11 getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<LiveAudienceState_11> parser() {
                return PARSER;
            }

            public Parser<LiveAudienceState_11> getParserForType() {
                return PARSER;
            }

            @Override
            public LiveAudienceState_11 getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            public static final class LiveAudienceState_11_1
            extends GeneratedMessageV3
            implements LiveAudienceState_11_1OrBuilder {
                private static final long serialVersionUID = 0L;
                public static final int BADGEICON_FIELD_NUMBER = 2;
                private volatile Object badgeIcon_ = "";
                public static final int BADGENAME_FIELD_NUMBER = 4;
                private volatile Object badgeName_ = "";
                private byte memoizedIsInitialized = (byte)-1;
                private static final LiveAudienceState_11_1 DEFAULT_INSTANCE = new LiveAudienceState_11_1();
                private static final Parser<LiveAudienceState_11_1> PARSER = new AbstractParser<LiveAudienceState_11_1>(){

                    @Override
                    public LiveAudienceState_11_1 parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                        Builder builder = LiveAudienceState_11_1.newBuilder();
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

                private LiveAudienceState_11_1(GeneratedMessageV3.Builder<?> builder) {
                    super(builder);
                }

                private LiveAudienceState_11_1() {
                    this.badgeIcon_ = "";
                    this.badgeName_ = "";
                }

                @Override
                protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                    return new LiveAudienceState_11_1();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_descriptor;
                }

                @Override
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveAudienceState_11_1.class, Builder.class);
                }

                @Override
                public String getBadgeIcon() {
                    Object ref = this.badgeIcon_;
                    if (ref instanceof String) {
                        return (String)ref;
                    }
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.badgeIcon_ = s;
                    return s;
                }

                @Override
                public ByteString getBadgeIconBytes() {
                    Object ref = this.badgeIcon_;
                    if (ref instanceof String) {
                        ByteString b = ByteString.copyFromUtf8((String)ref);
                        this.badgeIcon_ = b;
                        return b;
                    }
                    return (ByteString)ref;
                }

                @Override
                public String getBadgeName() {
                    Object ref = this.badgeName_;
                    if (ref instanceof String) {
                        return (String)ref;
                    }
                    ByteString bs = (ByteString)ref;
                    String s = bs.toStringUtf8();
                    this.badgeName_ = s;
                    return s;
                }

                @Override
                public ByteString getBadgeNameBytes() {
                    Object ref = this.badgeName_;
                    if (ref instanceof String) {
                        ByteString b = ByteString.copyFromUtf8((String)ref);
                        this.badgeName_ = b;
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
                    if (!GeneratedMessageV3.isStringEmpty(this.badgeIcon_)) {
                        GeneratedMessageV3.writeString(output, 2, this.badgeIcon_);
                    }
                    if (!GeneratedMessageV3.isStringEmpty(this.badgeName_)) {
                        GeneratedMessageV3.writeString(output, 4, this.badgeName_);
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
                    if (!GeneratedMessageV3.isStringEmpty(this.badgeIcon_)) {
                        size += GeneratedMessageV3.computeStringSize(2, this.badgeIcon_);
                    }
                    if (!GeneratedMessageV3.isStringEmpty(this.badgeName_)) {
                        size += GeneratedMessageV3.computeStringSize(4, this.badgeName_);
                    }
                    this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
                    return size;
                }

                @Override
                public boolean equals(Object obj) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof LiveAudienceState_11_1)) {
                        return super.equals(obj);
                    }
                    LiveAudienceState_11_1 other = (LiveAudienceState_11_1)obj;
                    if (!this.getBadgeIcon().equals((Object)other.getBadgeIcon())) {
                        return false;
                    }
                    if (!this.getBadgeName().equals((Object)other.getBadgeName())) {
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
                    hash = 19 * hash + LiveAudienceState_11_1.getDescriptor().hashCode();
                    hash = 37 * hash + 2;
                    hash = 53 * hash + this.getBadgeIcon().hashCode();
                    hash = 37 * hash + 4;
                    hash = 53 * hash + this.getBadgeName().hashCode();
                    this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
                    return hash;
                }

                public static LiveAudienceState_11_1 parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data);
                }

                public static LiveAudienceState_11_1 parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data, extensionRegistry);
                }

                public static LiveAudienceState_11_1 parseFrom(ByteString data) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data);
                }

                public static LiveAudienceState_11_1 parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data, extensionRegistry);
                }

                public static LiveAudienceState_11_1 parseFrom(byte[] data) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data);
                }

                public static LiveAudienceState_11_1 parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return PARSER.parseFrom(data, extensionRegistry);
                }

                public static LiveAudienceState_11_1 parseFrom(InputStream input) throws IOException {
                    return GeneratedMessageV3.parseWithIOException(PARSER, input);
                }

                public static LiveAudienceState_11_1 parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
                }

                public static LiveAudienceState_11_1 parseDelimitedFrom(InputStream input) throws IOException {
                    return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
                }

                public static LiveAudienceState_11_1 parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
                }

                public static LiveAudienceState_11_1 parseFrom(CodedInputStream input) throws IOException {
                    return GeneratedMessageV3.parseWithIOException(PARSER, input);
                }

                public static LiveAudienceState_11_1 parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
                }

                @Override
                public Builder newBuilderForType() {
                    return LiveAudienceState_11_1.newBuilder();
                }

                public static Builder newBuilder() {
                    return DEFAULT_INSTANCE.toBuilder();
                }

                public static Builder newBuilder(LiveAudienceState_11_1 prototype) {
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

                public static LiveAudienceState_11_1 getDefaultInstance() {
                    return DEFAULT_INSTANCE;
                }

                public static Parser<LiveAudienceState_11_1> parser() {
                    return PARSER;
                }

                public Parser<LiveAudienceState_11_1> getParserForType() {
                    return PARSER;
                }

                @Override
                public LiveAudienceState_11_1 getDefaultInstanceForType() {
                    return DEFAULT_INSTANCE;
                }

                public static final class Builder
                extends GeneratedMessageV3.Builder<Builder>
                implements LiveAudienceState_11_1OrBuilder {
                    private int bitField0_;
                    private Object badgeIcon_ = "";
                    private Object badgeName_ = "";

                    public static final Descriptors.Descriptor getDescriptor() {
                        return internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_descriptor;
                    }

                    @Override
                    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                        return internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveAudienceState_11_1.class, Builder.class);
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
                        this.badgeIcon_ = "";
                        this.badgeName_ = "";
                        return this;
                    }

                    @Override
                    public Descriptors.Descriptor getDescriptorForType() {
                        return internal_static_LiveAudienceState_LiveAudienceState_11_LiveAudienceState_11_1_descriptor;
                    }

                    @Override
                    public LiveAudienceState_11_1 getDefaultInstanceForType() {
                        return LiveAudienceState_11_1.getDefaultInstance();
                    }

                    @Override
                    public LiveAudienceState_11_1 build() {
                        LiveAudienceState_11_1 result = this.buildPartial();
                        if (!result.isInitialized()) {
                            throw Builder.newUninitializedMessageException(result);
                        }
                        return result;
                    }

                    @Override
                    public LiveAudienceState_11_1 buildPartial() {
                        LiveAudienceState_11_1 result = new LiveAudienceState_11_1(this);
                        if (this.bitField0_ != 0) {
                            this.buildPartial0(result);
                        }
                        this.onBuilt();
                        return result;
                    }

                    private void buildPartial0(LiveAudienceState_11_1 result) {
                        int from_bitField0_ = this.bitField0_;
                        if ((from_bitField0_ & 1) != 0) {
                            result.badgeIcon_ = this.badgeIcon_;
                        }
                        if ((from_bitField0_ & 2) != 0) {
                            result.badgeName_ = this.badgeName_;
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
                        if (other instanceof LiveAudienceState_11_1) {
                            return this.mergeFrom((LiveAudienceState_11_1)other);
                        }
                        super.mergeFrom(other);
                        return this;
                    }

                    public Builder mergeFrom(LiveAudienceState_11_1 other) {
                        if (other == LiveAudienceState_11_1.getDefaultInstance()) {
                            return this;
                        }
                        if (!other.getBadgeIcon().isEmpty()) {
                            this.badgeIcon_ = other.badgeIcon_;
                            this.bitField0_ |= 1;
                            this.onChanged();
                        }
                        if (!other.getBadgeName().isEmpty()) {
                            this.badgeName_ = other.badgeName_;
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
                                    case 18: {
                                        this.badgeIcon_ = input.readStringRequireUtf8();
                                        this.bitField0_ |= 1;
                                        continue block10;
                                    }
                                    case 34: {
                                        this.badgeName_ = input.readStringRequireUtf8();
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
                    public String getBadgeIcon() {
                        Object ref = this.badgeIcon_;
                        if (!(ref instanceof String)) {
                            ByteString bs = (ByteString)ref;
                            String s = bs.toStringUtf8();
                            this.badgeIcon_ = s;
                            return s;
                        }
                        return (String)ref;
                    }

                    @Override
                    public ByteString getBadgeIconBytes() {
                        Object ref = this.badgeIcon_;
                        if (ref instanceof String) {
                            ByteString b = ByteString.copyFromUtf8((String)ref);
                            this.badgeIcon_ = b;
                            return b;
                        }
                        return (ByteString)ref;
                    }

                    public Builder setBadgeIcon(String value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.badgeIcon_ = value;
                        this.bitField0_ |= 1;
                        this.onChanged();
                        return this;
                    }

                    public Builder clearBadgeIcon() {
                        this.badgeIcon_ = LiveAudienceState_11_1.getDefaultInstance().getBadgeIcon();
                        this.bitField0_ &= 0xFFFFFFFE;
                        this.onChanged();
                        return this;
                    }

                    public Builder setBadgeIconBytes(ByteString value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        LiveAudienceState_11_1.checkByteStringIsUtf8(value);
                        this.badgeIcon_ = value;
                        this.bitField0_ |= 1;
                        this.onChanged();
                        return this;
                    }

                    @Override
                    public String getBadgeName() {
                        Object ref = this.badgeName_;
                        if (!(ref instanceof String)) {
                            ByteString bs = (ByteString)ref;
                            String s = bs.toStringUtf8();
                            this.badgeName_ = s;
                            return s;
                        }
                        return (String)ref;
                    }

                    @Override
                    public ByteString getBadgeNameBytes() {
                        Object ref = this.badgeName_;
                        if (ref instanceof String) {
                            ByteString b = ByteString.copyFromUtf8((String)ref);
                            this.badgeName_ = b;
                            return b;
                        }
                        return (ByteString)ref;
                    }

                    public Builder setBadgeName(String value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.badgeName_ = value;
                        this.bitField0_ |= 2;
                        this.onChanged();
                        return this;
                    }

                    public Builder clearBadgeName() {
                        this.badgeName_ = LiveAudienceState_11_1.getDefaultInstance().getBadgeName();
                        this.bitField0_ &= 0xFFFFFFFD;
                        this.onChanged();
                        return this;
                    }

                    public Builder setBadgeNameBytes(ByteString value) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        LiveAudienceState_11_1.checkByteStringIsUtf8(value);
                        this.badgeName_ = value;
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
                }
            }

            public static final class Builder
            extends GeneratedMessageV3.Builder<Builder>
            implements LiveAudienceState_11OrBuilder {
                private int bitField0_;
                private LiveAudienceState_11_1 liveAudienceState111_;
                private SingleFieldBuilderV3<LiveAudienceState_11_1, LiveAudienceState_11_1.Builder, LiveAudienceState_11_1OrBuilder> liveAudienceState111Builder_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return internal_static_LiveAudienceState_LiveAudienceState_11_descriptor;
                }

                @Override
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return internal_static_LiveAudienceState_LiveAudienceState_11_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveAudienceState_11.class, Builder.class);
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
                        this.getLiveAudienceState111FieldBuilder();
                    }
                }

                @Override
                public Builder clear() {
                    super.clear();
                    this.bitField0_ = 0;
                    this.liveAudienceState111_ = null;
                    if (this.liveAudienceState111Builder_ != null) {
                        this.liveAudienceState111Builder_.dispose();
                        this.liveAudienceState111Builder_ = null;
                    }
                    return this;
                }

                @Override
                public Descriptors.Descriptor getDescriptorForType() {
                    return internal_static_LiveAudienceState_LiveAudienceState_11_descriptor;
                }

                @Override
                public LiveAudienceState_11 getDefaultInstanceForType() {
                    return LiveAudienceState_11.getDefaultInstance();
                }

                @Override
                public LiveAudienceState_11 build() {
                    LiveAudienceState_11 result = this.buildPartial();
                    if (!result.isInitialized()) {
                        throw Builder.newUninitializedMessageException(result);
                    }
                    return result;
                }

                @Override
                public LiveAudienceState_11 buildPartial() {
                    LiveAudienceState_11 result = new LiveAudienceState_11(this);
                    if (this.bitField0_ != 0) {
                        this.buildPartial0(result);
                    }
                    this.onBuilt();
                    return result;
                }

                private void buildPartial0(LiveAudienceState_11 result) {
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) != 0) {
                        result.liveAudienceState111_ = this.liveAudienceState111Builder_ == null ? this.liveAudienceState111_ : this.liveAudienceState111Builder_.build();
                        to_bitField0_ |= 1;
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
                    if (other instanceof LiveAudienceState_11) {
                        return this.mergeFrom((LiveAudienceState_11)other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(LiveAudienceState_11 other) {
                    if (other == LiveAudienceState_11.getDefaultInstance()) {
                        return this;
                    }
                    if (other.hasLiveAudienceState111()) {
                        this.mergeLiveAudienceState111(other.getLiveAudienceState111());
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
                                    input.readMessage(this.getLiveAudienceState111FieldBuilder().getBuilder(), extensionRegistry);
                                    this.bitField0_ |= 1;
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

                @Override
                public boolean hasLiveAudienceState111() {
                    return (this.bitField0_ & 1) != 0;
                }

                @Override
                public LiveAudienceState_11_1 getLiveAudienceState111() {
                    if (this.liveAudienceState111Builder_ == null) {
                        return this.liveAudienceState111_ == null ? LiveAudienceState_11_1.getDefaultInstance() : this.liveAudienceState111_;
                    }
                    return this.liveAudienceState111Builder_.getMessage();
                }

                public Builder setLiveAudienceState111(LiveAudienceState_11_1 value) {
                    if (this.liveAudienceState111Builder_ == null) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        this.liveAudienceState111_ = value;
                    } else {
                        this.liveAudienceState111Builder_.setMessage(value);
                    }
                    this.bitField0_ |= 1;
                    this.onChanged();
                    return this;
                }

                public Builder setLiveAudienceState111(LiveAudienceState_11_1.Builder builderForValue) {
                    if (this.liveAudienceState111Builder_ == null) {
                        this.liveAudienceState111_ = builderForValue.build();
                    } else {
                        this.liveAudienceState111Builder_.setMessage(builderForValue.build());
                    }
                    this.bitField0_ |= 1;
                    this.onChanged();
                    return this;
                }

                public Builder mergeLiveAudienceState111(LiveAudienceState_11_1 value) {
                    if (this.liveAudienceState111Builder_ == null) {
                        if ((this.bitField0_ & 1) != 0 && this.liveAudienceState111_ != null && this.liveAudienceState111_ != LiveAudienceState_11_1.getDefaultInstance()) {
                            this.getLiveAudienceState111Builder().mergeFrom(value);
                        } else {
                            this.liveAudienceState111_ = value;
                        }
                    } else {
                        this.liveAudienceState111Builder_.mergeFrom(value);
                    }
                    if (this.liveAudienceState111_ != null) {
                        this.bitField0_ |= 1;
                        this.onChanged();
                    }
                    return this;
                }

                public Builder clearLiveAudienceState111() {
                    this.bitField0_ &= 0xFFFFFFFE;
                    this.liveAudienceState111_ = null;
                    if (this.liveAudienceState111Builder_ != null) {
                        this.liveAudienceState111Builder_.dispose();
                        this.liveAudienceState111Builder_ = null;
                    }
                    this.onChanged();
                    return this;
                }

                public LiveAudienceState_11_1.Builder getLiveAudienceState111Builder() {
                    this.bitField0_ |= 1;
                    this.onChanged();
                    return this.getLiveAudienceState111FieldBuilder().getBuilder();
                }

                @Override
                public LiveAudienceState_11_1OrBuilder getLiveAudienceState111OrBuilder() {
                    if (this.liveAudienceState111Builder_ != null) {
                        return this.liveAudienceState111Builder_.getMessageOrBuilder();
                    }
                    return this.liveAudienceState111_ == null ? LiveAudienceState_11_1.getDefaultInstance() : this.liveAudienceState111_;
                }

                private SingleFieldBuilderV3<LiveAudienceState_11_1, LiveAudienceState_11_1.Builder, LiveAudienceState_11_1OrBuilder> getLiveAudienceState111FieldBuilder() {
                    if (this.liveAudienceState111Builder_ == null) {
                        this.liveAudienceState111Builder_ = new SingleFieldBuilderV3(this.getLiveAudienceState111(), this.getParentForChildren(), this.isClean());
                        this.liveAudienceState111_ = null;
                    }
                    return this.liveAudienceState111Builder_;
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

            public static interface LiveAudienceState_11_1OrBuilder
            extends MessageOrBuilder {
                public String getBadgeIcon();

                public ByteString getBadgeIconBytes();

                public String getBadgeName();

                public ByteString getBadgeNameBytes();
            }
        }

        public static interface LiveAudienceState_11OrBuilder
        extends MessageOrBuilder {
            public boolean hasLiveAudienceState111();

            public LiveAudienceState_11.LiveAudienceState_11_1 getLiveAudienceState111();

            public LiveAudienceState_11.LiveAudienceState_11_1OrBuilder getLiveAudienceState111OrBuilder();
        }
    }

    public static interface LiveAudienceStateOrBuilder
    extends MessageOrBuilder {
        public boolean getIsFromFansTop();

        public boolean getIsKoi();

        public int getAssistantTypeValue();

        public LiveAudienceState.AssistantType getAssistantType();

        public int getFansGroupIntimacyLevel();

        public boolean hasNameplate();

        public GzoneNameplateOuterClass.GzoneNameplate getNameplate();

        public GzoneNameplateOuterClass.GzoneNameplateOrBuilder getNameplateOrBuilder();

        public boolean hasLiveFansGroupState();

        public LiveFansGroupStateOuterClass.LiveFansGroupState getLiveFansGroupState();

        public LiveFansGroupStateOuterClass.LiveFansGroupStateOrBuilder getLiveFansGroupStateOrBuilder();

        public int getWealthGrade();

        public String getBadgeKey();

        public ByteString getBadgeKeyBytes();

        public List<LiveAudienceState.LiveAudienceState_11> getLiveAudienceState11List();

        public LiveAudienceState.LiveAudienceState_11 getLiveAudienceState11(int var1);

        public int getLiveAudienceState11Count();

        public List<? extends LiveAudienceState.LiveAudienceState_11OrBuilder> getLiveAudienceState11OrBuilderList();

        public LiveAudienceState.LiveAudienceState_11OrBuilder getLiveAudienceState11OrBuilder(int var1);
    }
}


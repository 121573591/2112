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
package tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf;

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
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
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
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.FollowInfo;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.FollowInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.PayGrade;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.PayGradeOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Tiktok;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.UserOrBuilder;

public final class User
extends GeneratedMessageV3
implements UserOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private long id_ = 0L;
    public static final int NICKNAME_FIELD_NUMBER = 3;
    private volatile Object nickName_ = "";
    public static final int AVATARTHUMB_FIELD_NUMBER = 9;
    private Image avatarThumb_;
    public static final int AVATARMEDIUM_FIELD_NUMBER = 10;
    private Image avatarMedium_;
    public static final int AVATARLARGE_FIELD_NUMBER = 11;
    private Image avatarLarge_;
    public static final int BADGEIMAGELIST_FIELD_NUMBER = 21;
    private List<Image> badgeImageList_;
    public static final int FOLLOWINFO_FIELD_NUMBER = 22;
    private FollowInfo followInfo_;
    public static final int PAYGRADE_FIELD_NUMBER = 23;
    private PayGrade payGrade_;
    public static final int DISPLAYID_FIELD_NUMBER = 38;
    private volatile Object displayId_ = "";
    public static final int SECUID_FIELD_NUMBER = 46;
    private volatile Object secUid_ = "";
    public static final int IDSTR_FIELD_NUMBER = 1028;
    private volatile Object idStr_ = "";
    private byte memoizedIsInitialized = (byte)-1;
    private static final User DEFAULT_INSTANCE = new User();
    private static final Parser<User> PARSER = new AbstractParser<User>(){

        @Override
        public User parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = User.newBuilder();
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

    private User(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private User() {
        this.nickName_ = "";
        this.badgeImageList_ = Collections.emptyList();
        this.displayId_ = "";
        this.secUid_ = "";
        this.idStr_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new User();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Tiktok.internal_static_User_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Tiktok.internal_static_User_fieldAccessorTable.ensureFieldAccessorsInitialized(User.class, Builder.class);
    }

    @Override
    public long getId() {
        return this.id_;
    }

    @Override
    public String getNickName() {
        Object ref = this.nickName_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.nickName_ = s;
        return s;
    }

    @Override
    public ByteString getNickNameBytes() {
        Object ref = this.nickName_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.nickName_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public boolean hasAvatarThumb() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public Image getAvatarThumb() {
        return this.avatarThumb_ == null ? Image.getDefaultInstance() : this.avatarThumb_;
    }

    @Override
    public ImageOrBuilder getAvatarThumbOrBuilder() {
        return this.avatarThumb_ == null ? Image.getDefaultInstance() : this.avatarThumb_;
    }

    @Override
    public boolean hasAvatarMedium() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public Image getAvatarMedium() {
        return this.avatarMedium_ == null ? Image.getDefaultInstance() : this.avatarMedium_;
    }

    @Override
    public ImageOrBuilder getAvatarMediumOrBuilder() {
        return this.avatarMedium_ == null ? Image.getDefaultInstance() : this.avatarMedium_;
    }

    @Override
    public boolean hasAvatarLarge() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public Image getAvatarLarge() {
        return this.avatarLarge_ == null ? Image.getDefaultInstance() : this.avatarLarge_;
    }

    @Override
    public ImageOrBuilder getAvatarLargeOrBuilder() {
        return this.avatarLarge_ == null ? Image.getDefaultInstance() : this.avatarLarge_;
    }

    @Override
    public List<Image> getBadgeImageListList() {
        return this.badgeImageList_;
    }

    @Override
    public List<? extends ImageOrBuilder> getBadgeImageListOrBuilderList() {
        return this.badgeImageList_;
    }

    @Override
    public int getBadgeImageListCount() {
        return this.badgeImageList_.size();
    }

    @Override
    public Image getBadgeImageList(int index) {
        return (Image)this.badgeImageList_.get(index);
    }

    @Override
    public ImageOrBuilder getBadgeImageListOrBuilder(int index) {
        return (ImageOrBuilder)this.badgeImageList_.get(index);
    }

    @Override
    public boolean hasFollowInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override
    public FollowInfo getFollowInfo() {
        return this.followInfo_ == null ? FollowInfo.getDefaultInstance() : this.followInfo_;
    }

    @Override
    public FollowInfoOrBuilder getFollowInfoOrBuilder() {
        return this.followInfo_ == null ? FollowInfo.getDefaultInstance() : this.followInfo_;
    }

    @Override
    public boolean hasPayGrade() {
        return (this.bitField0_ & 0x10) != 0;
    }

    @Override
    public PayGrade getPayGrade() {
        return this.payGrade_ == null ? PayGrade.getDefaultInstance() : this.payGrade_;
    }

    @Override
    public PayGradeOrBuilder getPayGradeOrBuilder() {
        return this.payGrade_ == null ? PayGrade.getDefaultInstance() : this.payGrade_;
    }

    @Override
    public String getDisplayId() {
        Object ref = this.displayId_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.displayId_ = s;
        return s;
    }

    @Override
    public ByteString getDisplayIdBytes() {
        Object ref = this.displayId_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.displayId_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getSecUid() {
        Object ref = this.secUid_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.secUid_ = s;
        return s;
    }

    @Override
    public ByteString getSecUidBytes() {
        Object ref = this.secUid_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.secUid_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getIdStr() {
        Object ref = this.idStr_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.idStr_ = s;
        return s;
    }

    @Override
    public ByteString getIdStrBytes() {
        Object ref = this.idStr_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.idStr_ = b;
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
        if (this.id_ != 0L) {
            output.writeUInt64(1, this.id_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nickName_)) {
            GeneratedMessageV3.writeString(output, 3, this.nickName_);
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(9, this.getAvatarThumb());
        }
        if ((this.bitField0_ & 2) != 0) {
            output.writeMessage(10, this.getAvatarMedium());
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(11, this.getAvatarLarge());
        }
        for (int i = 0; i < this.badgeImageList_.size(); ++i) {
            output.writeMessage(21, (MessageLite)this.badgeImageList_.get(i));
        }
        if ((this.bitField0_ & 8) != 0) {
            output.writeMessage(22, this.getFollowInfo());
        }
        if ((this.bitField0_ & 0x10) != 0) {
            output.writeMessage(23, this.getPayGrade());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayId_)) {
            GeneratedMessageV3.writeString(output, 38, this.displayId_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.secUid_)) {
            GeneratedMessageV3.writeString(output, 46, this.secUid_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.idStr_)) {
            GeneratedMessageV3.writeString(output, 1028, this.idStr_);
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
            size += CodedOutputStream.computeUInt64Size(1, this.id_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nickName_)) {
            size += GeneratedMessageV3.computeStringSize(3, this.nickName_);
        }
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(9, this.getAvatarThumb());
        }
        if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(10, this.getAvatarMedium());
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(11, this.getAvatarLarge());
        }
        for (int i = 0; i < this.badgeImageList_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(21, (MessageLite)this.badgeImageList_.get(i));
        }
        if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(22, this.getFollowInfo());
        }
        if ((this.bitField0_ & 0x10) != 0) {
            size += CodedOutputStream.computeMessageSize(23, this.getPayGrade());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayId_)) {
            size += GeneratedMessageV3.computeStringSize(38, this.displayId_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.secUid_)) {
            size += GeneratedMessageV3.computeStringSize(46, this.secUid_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.idStr_)) {
            size += GeneratedMessageV3.computeStringSize(1028, this.idStr_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) {
            return super.equals(obj);
        }
        User other = (User)obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        if (!this.getNickName().equals((Object)other.getNickName())) {
            return false;
        }
        if (this.hasAvatarThumb() != other.hasAvatarThumb()) {
            return false;
        }
        if (this.hasAvatarThumb() && !this.getAvatarThumb().equals(other.getAvatarThumb())) {
            return false;
        }
        if (this.hasAvatarMedium() != other.hasAvatarMedium()) {
            return false;
        }
        if (this.hasAvatarMedium() && !this.getAvatarMedium().equals(other.getAvatarMedium())) {
            return false;
        }
        if (this.hasAvatarLarge() != other.hasAvatarLarge()) {
            return false;
        }
        if (this.hasAvatarLarge() && !this.getAvatarLarge().equals(other.getAvatarLarge())) {
            return false;
        }
        if (!this.getBadgeImageListList().equals(other.getBadgeImageListList())) {
            return false;
        }
        if (this.hasFollowInfo() != other.hasFollowInfo()) {
            return false;
        }
        if (this.hasFollowInfo() && !this.getFollowInfo().equals(other.getFollowInfo())) {
            return false;
        }
        if (this.hasPayGrade() != other.hasPayGrade()) {
            return false;
        }
        if (this.hasPayGrade() && !this.getPayGrade().equals(other.getPayGrade())) {
            return false;
        }
        if (!this.getDisplayId().equals((Object)other.getDisplayId())) {
            return false;
        }
        if (!this.getSecUid().equals((Object)other.getSecUid())) {
            return false;
        }
        if (!this.getIdStr().equals((Object)other.getIdStr())) {
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
        hash = 19 * hash + User.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + Internal.hashLong(this.getId());
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getNickName().hashCode();
        if (this.hasAvatarThumb()) {
            hash = 37 * hash + 9;
            hash = 53 * hash + this.getAvatarThumb().hashCode();
        }
        if (this.hasAvatarMedium()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getAvatarMedium().hashCode();
        }
        if (this.hasAvatarLarge()) {
            hash = 37 * hash + 11;
            hash = 53 * hash + this.getAvatarLarge().hashCode();
        }
        if (this.getBadgeImageListCount() > 0) {
            hash = 37 * hash + 21;
            hash = 53 * hash + this.getBadgeImageListList().hashCode();
        }
        if (this.hasFollowInfo()) {
            hash = 37 * hash + 22;
            hash = 53 * hash + this.getFollowInfo().hashCode();
        }
        if (this.hasPayGrade()) {
            hash = 37 * hash + 23;
            hash = 53 * hash + this.getPayGrade().hashCode();
        }
        hash = 37 * hash + 38;
        hash = 53 * hash + this.getDisplayId().hashCode();
        hash = 37 * hash + 46;
        hash = 53 * hash + this.getSecUid().hashCode();
        hash = 37 * hash + 1028;
        hash = 53 * hash + this.getIdStr().hashCode();
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static User parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static User parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static User parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static User parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static User parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static User parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static User parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static User parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static User parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static User parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static User parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static User parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return User.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(User prototype) {
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

    public static User getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<User> parser() {
        return PARSER;
    }

    public Parser<User> getParserForType() {
        return PARSER;
    }

    @Override
    public User getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements UserOrBuilder {
        private int bitField0_;
        private long id_;
        private Object nickName_ = "";
        private Image avatarThumb_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> avatarThumbBuilder_;
        private Image avatarMedium_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> avatarMediumBuilder_;
        private Image avatarLarge_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> avatarLargeBuilder_;
        private List<Image> badgeImageList_ = Collections.emptyList();
        private RepeatedFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> badgeImageListBuilder_;
        private FollowInfo followInfo_;
        private SingleFieldBuilderV3<FollowInfo, FollowInfo.Builder, FollowInfoOrBuilder> followInfoBuilder_;
        private PayGrade payGrade_;
        private SingleFieldBuilderV3<PayGrade, PayGrade.Builder, PayGradeOrBuilder> payGradeBuilder_;
        private Object displayId_ = "";
        private Object secUid_ = "";
        private Object idStr_ = "";

        public static final Descriptors.Descriptor getDescriptor() {
            return Tiktok.internal_static_User_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Tiktok.internal_static_User_fieldAccessorTable.ensureFieldAccessorsInitialized(User.class, Builder.class);
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
                this.getAvatarThumbFieldBuilder();
                this.getAvatarMediumFieldBuilder();
                this.getAvatarLargeFieldBuilder();
                this.getBadgeImageListFieldBuilder();
                this.getFollowInfoFieldBuilder();
                this.getPayGradeFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.id_ = 0L;
            this.nickName_ = "";
            this.avatarThumb_ = null;
            if (this.avatarThumbBuilder_ != null) {
                this.avatarThumbBuilder_.dispose();
                this.avatarThumbBuilder_ = null;
            }
            this.avatarMedium_ = null;
            if (this.avatarMediumBuilder_ != null) {
                this.avatarMediumBuilder_.dispose();
                this.avatarMediumBuilder_ = null;
            }
            this.avatarLarge_ = null;
            if (this.avatarLargeBuilder_ != null) {
                this.avatarLargeBuilder_.dispose();
                this.avatarLargeBuilder_ = null;
            }
            if (this.badgeImageListBuilder_ == null) {
                this.badgeImageList_ = Collections.emptyList();
            } else {
                this.badgeImageList_ = null;
                this.badgeImageListBuilder_.clear();
            }
            this.bitField0_ &= 0xFFFFFFDF;
            this.followInfo_ = null;
            if (this.followInfoBuilder_ != null) {
                this.followInfoBuilder_.dispose();
                this.followInfoBuilder_ = null;
            }
            this.payGrade_ = null;
            if (this.payGradeBuilder_ != null) {
                this.payGradeBuilder_.dispose();
                this.payGradeBuilder_ = null;
            }
            this.displayId_ = "";
            this.secUid_ = "";
            this.idStr_ = "";
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Tiktok.internal_static_User_descriptor;
        }

        @Override
        public User getDefaultInstanceForType() {
            return User.getDefaultInstance();
        }

        @Override
        public User build() {
            User result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public User buildPartial() {
            User result = new User(this);
            this.buildPartialRepeatedFields(result);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(User result) {
            if (this.badgeImageListBuilder_ == null) {
                if ((this.bitField0_ & 0x20) != 0) {
                    this.badgeImageList_ = Collections.unmodifiableList(this.badgeImageList_);
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                result.badgeImageList_ = this.badgeImageList_;
            } else {
                result.badgeImageList_ = this.badgeImageListBuilder_.build();
            }
        }

        private void buildPartial0(User result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.id_ = this.id_;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.nickName_ = this.nickName_;
            }
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 4) != 0) {
                result.avatarThumb_ = this.avatarThumbBuilder_ == null ? this.avatarThumb_ : this.avatarThumbBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.avatarMedium_ = this.avatarMediumBuilder_ == null ? this.avatarMedium_ : this.avatarMediumBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.avatarLarge_ = this.avatarLargeBuilder_ == null ? this.avatarLarge_ : this.avatarLargeBuilder_.build();
                to_bitField0_ |= 4;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.followInfo_ = this.followInfoBuilder_ == null ? this.followInfo_ : this.followInfoBuilder_.build();
                to_bitField0_ |= 8;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.payGrade_ = this.payGradeBuilder_ == null ? this.payGrade_ : this.payGradeBuilder_.build();
                to_bitField0_ |= 0x10;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.displayId_ = this.displayId_;
            }
            if ((from_bitField0_ & 0x200) != 0) {
                result.secUid_ = this.secUid_;
            }
            if ((from_bitField0_ & 0x400) != 0) {
                result.idStr_ = this.idStr_;
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
            if (other instanceof User) {
                return this.mergeFrom((User)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(User other) {
            if (other == User.getDefaultInstance()) {
                return this;
            }
            if (other.getId() != 0L) {
                this.setId(other.getId());
            }
            if (!other.getNickName().isEmpty()) {
                this.nickName_ = other.nickName_;
                this.bitField0_ |= 2;
                this.onChanged();
            }
            if (other.hasAvatarThumb()) {
                this.mergeAvatarThumb(other.getAvatarThumb());
            }
            if (other.hasAvatarMedium()) {
                this.mergeAvatarMedium(other.getAvatarMedium());
            }
            if (other.hasAvatarLarge()) {
                this.mergeAvatarLarge(other.getAvatarLarge());
            }
            if (this.badgeImageListBuilder_ == null) {
                if (!other.badgeImageList_.isEmpty()) {
                    if (this.badgeImageList_.isEmpty()) {
                        this.badgeImageList_ = other.badgeImageList_;
                        this.bitField0_ &= 0xFFFFFFDF;
                    } else {
                        this.ensureBadgeImageListIsMutable();
                        this.badgeImageList_.addAll((Collection)other.badgeImageList_);
                    }
                    this.onChanged();
                }
            } else if (!other.badgeImageList_.isEmpty()) {
                if (this.badgeImageListBuilder_.isEmpty()) {
                    this.badgeImageListBuilder_.dispose();
                    this.badgeImageListBuilder_ = null;
                    this.badgeImageList_ = other.badgeImageList_;
                    this.bitField0_ &= 0xFFFFFFDF;
                    this.badgeImageListBuilder_ = alwaysUseFieldBuilders ? this.getBadgeImageListFieldBuilder() : null;
                } else {
                    this.badgeImageListBuilder_.addAllMessages((Iterable<Image>)other.badgeImageList_);
                }
            }
            if (other.hasFollowInfo()) {
                this.mergeFollowInfo(other.getFollowInfo());
            }
            if (other.hasPayGrade()) {
                this.mergePayGrade(other.getPayGrade());
            }
            if (!other.getDisplayId().isEmpty()) {
                this.displayId_ = other.displayId_;
                this.bitField0_ |= 0x100;
                this.onChanged();
            }
            if (!other.getSecUid().isEmpty()) {
                this.secUid_ = other.secUid_;
                this.bitField0_ |= 0x200;
                this.onChanged();
            }
            if (!other.getIdStr().isEmpty()) {
                this.idStr_ = other.idStr_;
                this.bitField0_ |= 0x400;
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
                block19: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block19;
                        }
                        case 8: {
                            this.id_ = input.readUInt64();
                            this.bitField0_ |= 1;
                            continue block19;
                        }
                        case 26: {
                            this.nickName_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 2;
                            continue block19;
                        }
                        case 74: {
                            input.readMessage(this.getAvatarThumbFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 4;
                            continue block19;
                        }
                        case 82: {
                            input.readMessage(this.getAvatarMediumFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 8;
                            continue block19;
                        }
                        case 90: {
                            input.readMessage(this.getAvatarLargeFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x10;
                            continue block19;
                        }
                        case 170: {
                            Image m = input.readMessage(Image.parser(), extensionRegistry);
                            if (this.badgeImageListBuilder_ == null) {
                                this.ensureBadgeImageListIsMutable();
                                this.badgeImageList_.add((Object)m);
                                continue block19;
                            }
                            this.badgeImageListBuilder_.addMessage(m);
                            continue block19;
                        }
                        case 178: {
                            input.readMessage(this.getFollowInfoFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x40;
                            continue block19;
                        }
                        case 186: {
                            input.readMessage(this.getPayGradeFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x80;
                            continue block19;
                        }
                        case 306: {
                            this.displayId_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x100;
                            continue block19;
                        }
                        case 370: {
                            this.secUid_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x200;
                            continue block19;
                        }
                        case 8226: {
                            this.idStr_ = input.readStringRequireUtf8();
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
        public String getNickName() {
            Object ref = this.nickName_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.nickName_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getNickNameBytes() {
            Object ref = this.nickName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.nickName_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setNickName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.nickName_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearNickName() {
            this.nickName_ = User.getDefaultInstance().getNickName();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
            return this;
        }

        public Builder setNickNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            User.checkByteStringIsUtf8(value);
            this.nickName_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasAvatarThumb() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override
        public Image getAvatarThumb() {
            if (this.avatarThumbBuilder_ == null) {
                return this.avatarThumb_ == null ? Image.getDefaultInstance() : this.avatarThumb_;
            }
            return this.avatarThumbBuilder_.getMessage();
        }

        public Builder setAvatarThumb(Image value) {
            if (this.avatarThumbBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.avatarThumb_ = value;
            } else {
                this.avatarThumbBuilder_.setMessage(value);
            }
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder setAvatarThumb(Image.Builder builderForValue) {
            if (this.avatarThumbBuilder_ == null) {
                this.avatarThumb_ = builderForValue.build();
            } else {
                this.avatarThumbBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder mergeAvatarThumb(Image value) {
            if (this.avatarThumbBuilder_ == null) {
                if ((this.bitField0_ & 4) != 0 && this.avatarThumb_ != null && this.avatarThumb_ != Image.getDefaultInstance()) {
                    this.getAvatarThumbBuilder().mergeFrom(value);
                } else {
                    this.avatarThumb_ = value;
                }
            } else {
                this.avatarThumbBuilder_.mergeFrom(value);
            }
            if (this.avatarThumb_ != null) {
                this.bitField0_ |= 4;
                this.onChanged();
            }
            return this;
        }

        public Builder clearAvatarThumb() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.avatarThumb_ = null;
            if (this.avatarThumbBuilder_ != null) {
                this.avatarThumbBuilder_.dispose();
                this.avatarThumbBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getAvatarThumbBuilder() {
            this.bitField0_ |= 4;
            this.onChanged();
            return this.getAvatarThumbFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getAvatarThumbOrBuilder() {
            if (this.avatarThumbBuilder_ != null) {
                return this.avatarThumbBuilder_.getMessageOrBuilder();
            }
            return this.avatarThumb_ == null ? Image.getDefaultInstance() : this.avatarThumb_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getAvatarThumbFieldBuilder() {
            if (this.avatarThumbBuilder_ == null) {
                this.avatarThumbBuilder_ = new SingleFieldBuilderV3(this.getAvatarThumb(), this.getParentForChildren(), this.isClean());
                this.avatarThumb_ = null;
            }
            return this.avatarThumbBuilder_;
        }

        @Override
        public boolean hasAvatarMedium() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override
        public Image getAvatarMedium() {
            if (this.avatarMediumBuilder_ == null) {
                return this.avatarMedium_ == null ? Image.getDefaultInstance() : this.avatarMedium_;
            }
            return this.avatarMediumBuilder_.getMessage();
        }

        public Builder setAvatarMedium(Image value) {
            if (this.avatarMediumBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.avatarMedium_ = value;
            } else {
                this.avatarMediumBuilder_.setMessage(value);
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder setAvatarMedium(Image.Builder builderForValue) {
            if (this.avatarMediumBuilder_ == null) {
                this.avatarMedium_ = builderForValue.build();
            } else {
                this.avatarMediumBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder mergeAvatarMedium(Image value) {
            if (this.avatarMediumBuilder_ == null) {
                if ((this.bitField0_ & 8) != 0 && this.avatarMedium_ != null && this.avatarMedium_ != Image.getDefaultInstance()) {
                    this.getAvatarMediumBuilder().mergeFrom(value);
                } else {
                    this.avatarMedium_ = value;
                }
            } else {
                this.avatarMediumBuilder_.mergeFrom(value);
            }
            if (this.avatarMedium_ != null) {
                this.bitField0_ |= 8;
                this.onChanged();
            }
            return this;
        }

        public Builder clearAvatarMedium() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.avatarMedium_ = null;
            if (this.avatarMediumBuilder_ != null) {
                this.avatarMediumBuilder_.dispose();
                this.avatarMediumBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getAvatarMediumBuilder() {
            this.bitField0_ |= 8;
            this.onChanged();
            return this.getAvatarMediumFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getAvatarMediumOrBuilder() {
            if (this.avatarMediumBuilder_ != null) {
                return this.avatarMediumBuilder_.getMessageOrBuilder();
            }
            return this.avatarMedium_ == null ? Image.getDefaultInstance() : this.avatarMedium_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getAvatarMediumFieldBuilder() {
            if (this.avatarMediumBuilder_ == null) {
                this.avatarMediumBuilder_ = new SingleFieldBuilderV3(this.getAvatarMedium(), this.getParentForChildren(), this.isClean());
                this.avatarMedium_ = null;
            }
            return this.avatarMediumBuilder_;
        }

        @Override
        public boolean hasAvatarLarge() {
            return (this.bitField0_ & 0x10) != 0;
        }

        @Override
        public Image getAvatarLarge() {
            if (this.avatarLargeBuilder_ == null) {
                return this.avatarLarge_ == null ? Image.getDefaultInstance() : this.avatarLarge_;
            }
            return this.avatarLargeBuilder_.getMessage();
        }

        public Builder setAvatarLarge(Image value) {
            if (this.avatarLargeBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.avatarLarge_ = value;
            } else {
                this.avatarLargeBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder setAvatarLarge(Image.Builder builderForValue) {
            if (this.avatarLargeBuilder_ == null) {
                this.avatarLarge_ = builderForValue.build();
            } else {
                this.avatarLargeBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder mergeAvatarLarge(Image value) {
            if (this.avatarLargeBuilder_ == null) {
                if ((this.bitField0_ & 0x10) != 0 && this.avatarLarge_ != null && this.avatarLarge_ != Image.getDefaultInstance()) {
                    this.getAvatarLargeBuilder().mergeFrom(value);
                } else {
                    this.avatarLarge_ = value;
                }
            } else {
                this.avatarLargeBuilder_.mergeFrom(value);
            }
            if (this.avatarLarge_ != null) {
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            return this;
        }

        public Builder clearAvatarLarge() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.avatarLarge_ = null;
            if (this.avatarLargeBuilder_ != null) {
                this.avatarLargeBuilder_.dispose();
                this.avatarLargeBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getAvatarLargeBuilder() {
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this.getAvatarLargeFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getAvatarLargeOrBuilder() {
            if (this.avatarLargeBuilder_ != null) {
                return this.avatarLargeBuilder_.getMessageOrBuilder();
            }
            return this.avatarLarge_ == null ? Image.getDefaultInstance() : this.avatarLarge_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getAvatarLargeFieldBuilder() {
            if (this.avatarLargeBuilder_ == null) {
                this.avatarLargeBuilder_ = new SingleFieldBuilderV3(this.getAvatarLarge(), this.getParentForChildren(), this.isClean());
                this.avatarLarge_ = null;
            }
            return this.avatarLargeBuilder_;
        }

        private void ensureBadgeImageListIsMutable() {
            if ((this.bitField0_ & 0x20) == 0) {
                this.badgeImageList_ = new ArrayList(this.badgeImageList_);
                this.bitField0_ |= 0x20;
            }
        }

        @Override
        public List<Image> getBadgeImageListList() {
            if (this.badgeImageListBuilder_ == null) {
                return Collections.unmodifiableList(this.badgeImageList_);
            }
            return this.badgeImageListBuilder_.getMessageList();
        }

        @Override
        public int getBadgeImageListCount() {
            if (this.badgeImageListBuilder_ == null) {
                return this.badgeImageList_.size();
            }
            return this.badgeImageListBuilder_.getCount();
        }

        @Override
        public Image getBadgeImageList(int index) {
            if (this.badgeImageListBuilder_ == null) {
                return (Image)this.badgeImageList_.get(index);
            }
            return this.badgeImageListBuilder_.getMessage(index);
        }

        public Builder setBadgeImageList(int index, Image value) {
            if (this.badgeImageListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.set(index, (Object)value);
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.setMessage(index, value);
            }
            return this;
        }

        public Builder setBadgeImageList(int index, Image.Builder builderForValue) {
            if (this.badgeImageListBuilder_ == null) {
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.set(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addBadgeImageList(Image value) {
            if (this.badgeImageListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.add((Object)value);
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.addMessage(value);
            }
            return this;
        }

        public Builder addBadgeImageList(int index, Image value) {
            if (this.badgeImageListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.add(index, (Object)value);
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.addMessage(index, value);
            }
            return this;
        }

        public Builder addBadgeImageList(Image.Builder builderForValue) {
            if (this.badgeImageListBuilder_ == null) {
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.add((Object)builderForValue.build());
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addBadgeImageList(int index, Image.Builder builderForValue) {
            if (this.badgeImageListBuilder_ == null) {
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.add(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllBadgeImageList(Iterable<? extends Image> values) {
            if (this.badgeImageListBuilder_ == null) {
                this.ensureBadgeImageListIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.badgeImageList_);
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearBadgeImageList() {
            if (this.badgeImageListBuilder_ == null) {
                this.badgeImageList_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFFFDF;
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.clear();
            }
            return this;
        }

        public Builder removeBadgeImageList(int index) {
            if (this.badgeImageListBuilder_ == null) {
                this.ensureBadgeImageListIsMutable();
                this.badgeImageList_.remove(index);
                this.onChanged();
            } else {
                this.badgeImageListBuilder_.remove(index);
            }
            return this;
        }

        public Image.Builder getBadgeImageListBuilder(int index) {
            return this.getBadgeImageListFieldBuilder().getBuilder(index);
        }

        @Override
        public ImageOrBuilder getBadgeImageListOrBuilder(int index) {
            if (this.badgeImageListBuilder_ == null) {
                return (ImageOrBuilder)this.badgeImageList_.get(index);
            }
            return this.badgeImageListBuilder_.getMessageOrBuilder(index);
        }

        @Override
        public List<? extends ImageOrBuilder> getBadgeImageListOrBuilderList() {
            if (this.badgeImageListBuilder_ != null) {
                return this.badgeImageListBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.badgeImageList_);
        }

        public Image.Builder addBadgeImageListBuilder() {
            return this.getBadgeImageListFieldBuilder().addBuilder(Image.getDefaultInstance());
        }

        public Image.Builder addBadgeImageListBuilder(int index) {
            return this.getBadgeImageListFieldBuilder().addBuilder(index, Image.getDefaultInstance());
        }

        public List<Image.Builder> getBadgeImageListBuilderList() {
            return this.getBadgeImageListFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getBadgeImageListFieldBuilder() {
            if (this.badgeImageListBuilder_ == null) {
                this.badgeImageListBuilder_ = new RepeatedFieldBuilderV3(this.badgeImageList_, (this.bitField0_ & 0x20) != 0, this.getParentForChildren(), this.isClean());
                this.badgeImageList_ = null;
            }
            return this.badgeImageListBuilder_;
        }

        @Override
        public boolean hasFollowInfo() {
            return (this.bitField0_ & 0x40) != 0;
        }

        @Override
        public FollowInfo getFollowInfo() {
            if (this.followInfoBuilder_ == null) {
                return this.followInfo_ == null ? FollowInfo.getDefaultInstance() : this.followInfo_;
            }
            return this.followInfoBuilder_.getMessage();
        }

        public Builder setFollowInfo(FollowInfo value) {
            if (this.followInfoBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.followInfo_ = value;
            } else {
                this.followInfoBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder setFollowInfo(FollowInfo.Builder builderForValue) {
            if (this.followInfoBuilder_ == null) {
                this.followInfo_ = builderForValue.build();
            } else {
                this.followInfoBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder mergeFollowInfo(FollowInfo value) {
            if (this.followInfoBuilder_ == null) {
                if ((this.bitField0_ & 0x40) != 0 && this.followInfo_ != null && this.followInfo_ != FollowInfo.getDefaultInstance()) {
                    this.getFollowInfoBuilder().mergeFrom(value);
                } else {
                    this.followInfo_ = value;
                }
            } else {
                this.followInfoBuilder_.mergeFrom(value);
            }
            if (this.followInfo_ != null) {
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            return this;
        }

        public Builder clearFollowInfo() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.followInfo_ = null;
            if (this.followInfoBuilder_ != null) {
                this.followInfoBuilder_.dispose();
                this.followInfoBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public FollowInfo.Builder getFollowInfoBuilder() {
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this.getFollowInfoFieldBuilder().getBuilder();
        }

        @Override
        public FollowInfoOrBuilder getFollowInfoOrBuilder() {
            if (this.followInfoBuilder_ != null) {
                return this.followInfoBuilder_.getMessageOrBuilder();
            }
            return this.followInfo_ == null ? FollowInfo.getDefaultInstance() : this.followInfo_;
        }

        private SingleFieldBuilderV3<FollowInfo, FollowInfo.Builder, FollowInfoOrBuilder> getFollowInfoFieldBuilder() {
            if (this.followInfoBuilder_ == null) {
                this.followInfoBuilder_ = new SingleFieldBuilderV3(this.getFollowInfo(), this.getParentForChildren(), this.isClean());
                this.followInfo_ = null;
            }
            return this.followInfoBuilder_;
        }

        @Override
        public boolean hasPayGrade() {
            return (this.bitField0_ & 0x80) != 0;
        }

        @Override
        public PayGrade getPayGrade() {
            if (this.payGradeBuilder_ == null) {
                return this.payGrade_ == null ? PayGrade.getDefaultInstance() : this.payGrade_;
            }
            return this.payGradeBuilder_.getMessage();
        }

        public Builder setPayGrade(PayGrade value) {
            if (this.payGradeBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.payGrade_ = value;
            } else {
                this.payGradeBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder setPayGrade(PayGrade.Builder builderForValue) {
            if (this.payGradeBuilder_ == null) {
                this.payGrade_ = builderForValue.build();
            } else {
                this.payGradeBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder mergePayGrade(PayGrade value) {
            if (this.payGradeBuilder_ == null) {
                if ((this.bitField0_ & 0x80) != 0 && this.payGrade_ != null && this.payGrade_ != PayGrade.getDefaultInstance()) {
                    this.getPayGradeBuilder().mergeFrom(value);
                } else {
                    this.payGrade_ = value;
                }
            } else {
                this.payGradeBuilder_.mergeFrom(value);
            }
            if (this.payGrade_ != null) {
                this.bitField0_ |= 0x80;
                this.onChanged();
            }
            return this;
        }

        public Builder clearPayGrade() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.payGrade_ = null;
            if (this.payGradeBuilder_ != null) {
                this.payGradeBuilder_.dispose();
                this.payGradeBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public PayGrade.Builder getPayGradeBuilder() {
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this.getPayGradeFieldBuilder().getBuilder();
        }

        @Override
        public PayGradeOrBuilder getPayGradeOrBuilder() {
            if (this.payGradeBuilder_ != null) {
                return this.payGradeBuilder_.getMessageOrBuilder();
            }
            return this.payGrade_ == null ? PayGrade.getDefaultInstance() : this.payGrade_;
        }

        private SingleFieldBuilderV3<PayGrade, PayGrade.Builder, PayGradeOrBuilder> getPayGradeFieldBuilder() {
            if (this.payGradeBuilder_ == null) {
                this.payGradeBuilder_ = new SingleFieldBuilderV3(this.getPayGrade(), this.getParentForChildren(), this.isClean());
                this.payGrade_ = null;
            }
            return this.payGradeBuilder_;
        }

        @Override
        public String getDisplayId() {
            Object ref = this.displayId_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.displayId_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getDisplayIdBytes() {
            Object ref = this.displayId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.displayId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setDisplayId(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.displayId_ = value;
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayId() {
            this.displayId_ = User.getDefaultInstance().getDisplayId();
            this.bitField0_ &= 0xFFFFFEFF;
            this.onChanged();
            return this;
        }

        public Builder setDisplayIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            User.checkByteStringIsUtf8(value);
            this.displayId_ = value;
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        @Override
        public String getSecUid() {
            Object ref = this.secUid_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.secUid_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getSecUidBytes() {
            Object ref = this.secUid_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.secUid_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setSecUid(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.secUid_ = value;
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder clearSecUid() {
            this.secUid_ = User.getDefaultInstance().getSecUid();
            this.bitField0_ &= 0xFFFFFDFF;
            this.onChanged();
            return this;
        }

        public Builder setSecUidBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            User.checkByteStringIsUtf8(value);
            this.secUid_ = value;
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        @Override
        public String getIdStr() {
            Object ref = this.idStr_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.idStr_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getIdStrBytes() {
            Object ref = this.idStr_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.idStr_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setIdStr(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.idStr_ = value;
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this;
        }

        public Builder clearIdStr() {
            this.idStr_ = User.getDefaultInstance().getIdStr();
            this.bitField0_ &= 0xFFFFFBFF;
            this.onChanged();
            return this;
        }

        public Builder setIdStrBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            User.checkByteStringIsUtf8(value);
            this.idStr_ = value;
            this.bitField0_ |= 0x400;
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


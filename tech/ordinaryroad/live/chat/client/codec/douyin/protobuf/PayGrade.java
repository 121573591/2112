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
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeBuffInfo;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeBuffInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeIcon;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeIconOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PayGradeOrBuilder;

public final class PayGrade
extends GeneratedMessageV3
implements PayGradeOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int TOTALDIAMONDCOUNT_FIELD_NUMBER = 1;
    private long totalDiamondCount_ = 0L;
    public static final int DIAMONDICON_FIELD_NUMBER = 2;
    private Image diamondIcon_;
    public static final int NAME_FIELD_NUMBER = 3;
    private volatile Object name_ = "";
    public static final int ICON_FIELD_NUMBER = 4;
    private Image icon_;
    public static final int NEXTNAME_FIELD_NUMBER = 5;
    private volatile Object nextName_ = "";
    public static final int LEVEL_FIELD_NUMBER = 6;
    private long level_ = 0L;
    public static final int NEXTICON_FIELD_NUMBER = 7;
    private Image nextIcon_;
    public static final int NEXTDIAMOND_FIELD_NUMBER = 8;
    private long nextDiamond_ = 0L;
    public static final int NOWDIAMOND_FIELD_NUMBER = 9;
    private long nowDiamond_ = 0L;
    public static final int THISGRADEMINDIAMOND_FIELD_NUMBER = 10;
    private long thisGradeMinDiamond_ = 0L;
    public static final int THISGRADEMAXDIAMOND_FIELD_NUMBER = 11;
    private long thisGradeMaxDiamond_ = 0L;
    public static final int PAYDIAMONDBAK_FIELD_NUMBER = 12;
    private long payDiamondBak_ = 0L;
    public static final int GRADEDESCRIBE_FIELD_NUMBER = 13;
    private volatile Object gradeDescribe_ = "";
    public static final int GRADEICONLIST_FIELD_NUMBER = 14;
    private List<GradeIcon> gradeIconList_;
    public static final int SCREENCHATTYPE_FIELD_NUMBER = 15;
    private long screenChatType_ = 0L;
    public static final int IMICON_FIELD_NUMBER = 16;
    private Image imIcon_;
    public static final int IMICONWITHLEVEL_FIELD_NUMBER = 17;
    private Image imIconWithLevel_;
    public static final int LIVEICON_FIELD_NUMBER = 18;
    private Image liveIcon_;
    public static final int NEWIMICONWITHLEVEL_FIELD_NUMBER = 19;
    private Image newImIconWithLevel_;
    public static final int NEWLIVEICON_FIELD_NUMBER = 20;
    private Image newLiveIcon_;
    public static final int UPGRADENEEDCONSUME_FIELD_NUMBER = 21;
    private long upgradeNeedConsume_ = 0L;
    public static final int NEXTPRIVILEGES_FIELD_NUMBER = 22;
    private volatile Object nextPrivileges_ = "";
    public static final int BACKGROUND_FIELD_NUMBER = 23;
    private Image background_;
    public static final int BACKGROUNDBACK_FIELD_NUMBER = 24;
    private Image backgroundBack_;
    public static final int SCORE_FIELD_NUMBER = 25;
    private long score_ = 0L;
    public static final int BUFFINFO_FIELD_NUMBER = 26;
    private GradeBuffInfo buffInfo_;
    public static final int GRADEBANNER_FIELD_NUMBER = 1001;
    private volatile Object gradeBanner_ = "";
    public static final int PROFILEDIALOGBG_FIELD_NUMBER = 1002;
    private Image profileDialogBg_;
    public static final int PROFILEDIALOGBGBACK_FIELD_NUMBER = 1003;
    private Image profileDialogBgBack_;
    private byte memoizedIsInitialized = (byte)-1;
    private static final PayGrade DEFAULT_INSTANCE = new PayGrade();
    private static final Parser<PayGrade> PARSER = new AbstractParser<PayGrade>(){

        @Override
        public PayGrade parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = PayGrade.newBuilder();
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

    private PayGrade(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private PayGrade() {
        this.name_ = "";
        this.nextName_ = "";
        this.gradeDescribe_ = "";
        this.gradeIconList_ = Collections.emptyList();
        this.nextPrivileges_ = "";
        this.gradeBanner_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new PayGrade();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_PayGrade_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_PayGrade_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGrade.class, Builder.class);
    }

    @Override
    public long getTotalDiamondCount() {
        return this.totalDiamondCount_;
    }

    @Override
    public boolean hasDiamondIcon() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override
    public Image getDiamondIcon() {
        return this.diamondIcon_ == null ? Image.getDefaultInstance() : this.diamondIcon_;
    }

    @Override
    public ImageOrBuilder getDiamondIconOrBuilder() {
        return this.diamondIcon_ == null ? Image.getDefaultInstance() : this.diamondIcon_;
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
    public boolean hasIcon() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public Image getIcon() {
        return this.icon_ == null ? Image.getDefaultInstance() : this.icon_;
    }

    @Override
    public ImageOrBuilder getIconOrBuilder() {
        return this.icon_ == null ? Image.getDefaultInstance() : this.icon_;
    }

    @Override
    public String getNextName() {
        Object ref = this.nextName_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.nextName_ = s;
        return s;
    }

    @Override
    public ByteString getNextNameBytes() {
        Object ref = this.nextName_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.nextName_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getLevel() {
        return this.level_;
    }

    @Override
    public boolean hasNextIcon() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public Image getNextIcon() {
        return this.nextIcon_ == null ? Image.getDefaultInstance() : this.nextIcon_;
    }

    @Override
    public ImageOrBuilder getNextIconOrBuilder() {
        return this.nextIcon_ == null ? Image.getDefaultInstance() : this.nextIcon_;
    }

    @Override
    public long getNextDiamond() {
        return this.nextDiamond_;
    }

    @Override
    public long getNowDiamond() {
        return this.nowDiamond_;
    }

    @Override
    public long getThisGradeMinDiamond() {
        return this.thisGradeMinDiamond_;
    }

    @Override
    public long getThisGradeMaxDiamond() {
        return this.thisGradeMaxDiamond_;
    }

    @Override
    public long getPayDiamondBak() {
        return this.payDiamondBak_;
    }

    @Override
    public String getGradeDescribe() {
        Object ref = this.gradeDescribe_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.gradeDescribe_ = s;
        return s;
    }

    @Override
    public ByteString getGradeDescribeBytes() {
        Object ref = this.gradeDescribe_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.gradeDescribe_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public List<GradeIcon> getGradeIconListList() {
        return this.gradeIconList_;
    }

    @Override
    public List<? extends GradeIconOrBuilder> getGradeIconListOrBuilderList() {
        return this.gradeIconList_;
    }

    @Override
    public int getGradeIconListCount() {
        return this.gradeIconList_.size();
    }

    @Override
    public GradeIcon getGradeIconList(int index) {
        return (GradeIcon)this.gradeIconList_.get(index);
    }

    @Override
    public GradeIconOrBuilder getGradeIconListOrBuilder(int index) {
        return (GradeIconOrBuilder)this.gradeIconList_.get(index);
    }

    @Override
    public long getScreenChatType() {
        return this.screenChatType_;
    }

    @Override
    public boolean hasImIcon() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override
    public Image getImIcon() {
        return this.imIcon_ == null ? Image.getDefaultInstance() : this.imIcon_;
    }

    @Override
    public ImageOrBuilder getImIconOrBuilder() {
        return this.imIcon_ == null ? Image.getDefaultInstance() : this.imIcon_;
    }

    @Override
    public boolean hasImIconWithLevel() {
        return (this.bitField0_ & 0x10) != 0;
    }

    @Override
    public Image getImIconWithLevel() {
        return this.imIconWithLevel_ == null ? Image.getDefaultInstance() : this.imIconWithLevel_;
    }

    @Override
    public ImageOrBuilder getImIconWithLevelOrBuilder() {
        return this.imIconWithLevel_ == null ? Image.getDefaultInstance() : this.imIconWithLevel_;
    }

    @Override
    public boolean hasLiveIcon() {
        return (this.bitField0_ & 0x20) != 0;
    }

    @Override
    public Image getLiveIcon() {
        return this.liveIcon_ == null ? Image.getDefaultInstance() : this.liveIcon_;
    }

    @Override
    public ImageOrBuilder getLiveIconOrBuilder() {
        return this.liveIcon_ == null ? Image.getDefaultInstance() : this.liveIcon_;
    }

    @Override
    public boolean hasNewImIconWithLevel() {
        return (this.bitField0_ & 0x40) != 0;
    }

    @Override
    public Image getNewImIconWithLevel() {
        return this.newImIconWithLevel_ == null ? Image.getDefaultInstance() : this.newImIconWithLevel_;
    }

    @Override
    public ImageOrBuilder getNewImIconWithLevelOrBuilder() {
        return this.newImIconWithLevel_ == null ? Image.getDefaultInstance() : this.newImIconWithLevel_;
    }

    @Override
    public boolean hasNewLiveIcon() {
        return (this.bitField0_ & 0x80) != 0;
    }

    @Override
    public Image getNewLiveIcon() {
        return this.newLiveIcon_ == null ? Image.getDefaultInstance() : this.newLiveIcon_;
    }

    @Override
    public ImageOrBuilder getNewLiveIconOrBuilder() {
        return this.newLiveIcon_ == null ? Image.getDefaultInstance() : this.newLiveIcon_;
    }

    @Override
    public long getUpgradeNeedConsume() {
        return this.upgradeNeedConsume_;
    }

    @Override
    public String getNextPrivileges() {
        Object ref = this.nextPrivileges_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.nextPrivileges_ = s;
        return s;
    }

    @Override
    public ByteString getNextPrivilegesBytes() {
        Object ref = this.nextPrivileges_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.nextPrivileges_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public boolean hasBackground() {
        return (this.bitField0_ & 0x100) != 0;
    }

    @Override
    public Image getBackground() {
        return this.background_ == null ? Image.getDefaultInstance() : this.background_;
    }

    @Override
    public ImageOrBuilder getBackgroundOrBuilder() {
        return this.background_ == null ? Image.getDefaultInstance() : this.background_;
    }

    @Override
    public boolean hasBackgroundBack() {
        return (this.bitField0_ & 0x200) != 0;
    }

    @Override
    public Image getBackgroundBack() {
        return this.backgroundBack_ == null ? Image.getDefaultInstance() : this.backgroundBack_;
    }

    @Override
    public ImageOrBuilder getBackgroundBackOrBuilder() {
        return this.backgroundBack_ == null ? Image.getDefaultInstance() : this.backgroundBack_;
    }

    @Override
    public long getScore() {
        return this.score_;
    }

    @Override
    public boolean hasBuffInfo() {
        return (this.bitField0_ & 0x400) != 0;
    }

    @Override
    public GradeBuffInfo getBuffInfo() {
        return this.buffInfo_ == null ? GradeBuffInfo.getDefaultInstance() : this.buffInfo_;
    }

    @Override
    public GradeBuffInfoOrBuilder getBuffInfoOrBuilder() {
        return this.buffInfo_ == null ? GradeBuffInfo.getDefaultInstance() : this.buffInfo_;
    }

    @Override
    public String getGradeBanner() {
        Object ref = this.gradeBanner_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.gradeBanner_ = s;
        return s;
    }

    @Override
    public ByteString getGradeBannerBytes() {
        Object ref = this.gradeBanner_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.gradeBanner_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public boolean hasProfileDialogBg() {
        return (this.bitField0_ & 0x800) != 0;
    }

    @Override
    public Image getProfileDialogBg() {
        return this.profileDialogBg_ == null ? Image.getDefaultInstance() : this.profileDialogBg_;
    }

    @Override
    public ImageOrBuilder getProfileDialogBgOrBuilder() {
        return this.profileDialogBg_ == null ? Image.getDefaultInstance() : this.profileDialogBg_;
    }

    @Override
    public boolean hasProfileDialogBgBack() {
        return (this.bitField0_ & 0x1000) != 0;
    }

    @Override
    public Image getProfileDialogBgBack() {
        return this.profileDialogBgBack_ == null ? Image.getDefaultInstance() : this.profileDialogBgBack_;
    }

    @Override
    public ImageOrBuilder getProfileDialogBgBackOrBuilder() {
        return this.profileDialogBgBack_ == null ? Image.getDefaultInstance() : this.profileDialogBgBack_;
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
        if (this.totalDiamondCount_ != 0L) {
            output.writeInt64(1, this.totalDiamondCount_);
        }
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(2, this.getDiamondIcon());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(output, 3, this.name_);
        }
        if ((this.bitField0_ & 2) != 0) {
            output.writeMessage(4, this.getIcon());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nextName_)) {
            GeneratedMessageV3.writeString(output, 5, this.nextName_);
        }
        if (this.level_ != 0L) {
            output.writeInt64(6, this.level_);
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(7, this.getNextIcon());
        }
        if (this.nextDiamond_ != 0L) {
            output.writeInt64(8, this.nextDiamond_);
        }
        if (this.nowDiamond_ != 0L) {
            output.writeInt64(9, this.nowDiamond_);
        }
        if (this.thisGradeMinDiamond_ != 0L) {
            output.writeInt64(10, this.thisGradeMinDiamond_);
        }
        if (this.thisGradeMaxDiamond_ != 0L) {
            output.writeInt64(11, this.thisGradeMaxDiamond_);
        }
        if (this.payDiamondBak_ != 0L) {
            output.writeInt64(12, this.payDiamondBak_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.gradeDescribe_)) {
            GeneratedMessageV3.writeString(output, 13, this.gradeDescribe_);
        }
        for (int i = 0; i < this.gradeIconList_.size(); ++i) {
            output.writeMessage(14, (MessageLite)this.gradeIconList_.get(i));
        }
        if (this.screenChatType_ != 0L) {
            output.writeInt64(15, this.screenChatType_);
        }
        if ((this.bitField0_ & 8) != 0) {
            output.writeMessage(16, this.getImIcon());
        }
        if ((this.bitField0_ & 0x10) != 0) {
            output.writeMessage(17, this.getImIconWithLevel());
        }
        if ((this.bitField0_ & 0x20) != 0) {
            output.writeMessage(18, this.getLiveIcon());
        }
        if ((this.bitField0_ & 0x40) != 0) {
            output.writeMessage(19, this.getNewImIconWithLevel());
        }
        if ((this.bitField0_ & 0x80) != 0) {
            output.writeMessage(20, this.getNewLiveIcon());
        }
        if (this.upgradeNeedConsume_ != 0L) {
            output.writeInt64(21, this.upgradeNeedConsume_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nextPrivileges_)) {
            GeneratedMessageV3.writeString(output, 22, this.nextPrivileges_);
        }
        if ((this.bitField0_ & 0x100) != 0) {
            output.writeMessage(23, this.getBackground());
        }
        if ((this.bitField0_ & 0x200) != 0) {
            output.writeMessage(24, this.getBackgroundBack());
        }
        if (this.score_ != 0L) {
            output.writeInt64(25, this.score_);
        }
        if ((this.bitField0_ & 0x400) != 0) {
            output.writeMessage(26, this.getBuffInfo());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.gradeBanner_)) {
            GeneratedMessageV3.writeString(output, 1001, this.gradeBanner_);
        }
        if ((this.bitField0_ & 0x800) != 0) {
            output.writeMessage(1002, this.getProfileDialogBg());
        }
        if ((this.bitField0_ & 0x1000) != 0) {
            output.writeMessage(1003, this.getProfileDialogBgBack());
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
        if (this.totalDiamondCount_ != 0L) {
            size += CodedOutputStream.computeInt64Size(1, this.totalDiamondCount_);
        }
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(2, this.getDiamondIcon());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            size += GeneratedMessageV3.computeStringSize(3, this.name_);
        }
        if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(4, this.getIcon());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nextName_)) {
            size += GeneratedMessageV3.computeStringSize(5, this.nextName_);
        }
        if (this.level_ != 0L) {
            size += CodedOutputStream.computeInt64Size(6, this.level_);
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getNextIcon());
        }
        if (this.nextDiamond_ != 0L) {
            size += CodedOutputStream.computeInt64Size(8, this.nextDiamond_);
        }
        if (this.nowDiamond_ != 0L) {
            size += CodedOutputStream.computeInt64Size(9, this.nowDiamond_);
        }
        if (this.thisGradeMinDiamond_ != 0L) {
            size += CodedOutputStream.computeInt64Size(10, this.thisGradeMinDiamond_);
        }
        if (this.thisGradeMaxDiamond_ != 0L) {
            size += CodedOutputStream.computeInt64Size(11, this.thisGradeMaxDiamond_);
        }
        if (this.payDiamondBak_ != 0L) {
            size += CodedOutputStream.computeInt64Size(12, this.payDiamondBak_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.gradeDescribe_)) {
            size += GeneratedMessageV3.computeStringSize(13, this.gradeDescribe_);
        }
        for (int i = 0; i < this.gradeIconList_.size(); ++i) {
            size += CodedOutputStream.computeMessageSize(14, (MessageLite)this.gradeIconList_.get(i));
        }
        if (this.screenChatType_ != 0L) {
            size += CodedOutputStream.computeInt64Size(15, this.screenChatType_);
        }
        if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(16, this.getImIcon());
        }
        if ((this.bitField0_ & 0x10) != 0) {
            size += CodedOutputStream.computeMessageSize(17, this.getImIconWithLevel());
        }
        if ((this.bitField0_ & 0x20) != 0) {
            size += CodedOutputStream.computeMessageSize(18, this.getLiveIcon());
        }
        if ((this.bitField0_ & 0x40) != 0) {
            size += CodedOutputStream.computeMessageSize(19, this.getNewImIconWithLevel());
        }
        if ((this.bitField0_ & 0x80) != 0) {
            size += CodedOutputStream.computeMessageSize(20, this.getNewLiveIcon());
        }
        if (this.upgradeNeedConsume_ != 0L) {
            size += CodedOutputStream.computeInt64Size(21, this.upgradeNeedConsume_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.nextPrivileges_)) {
            size += GeneratedMessageV3.computeStringSize(22, this.nextPrivileges_);
        }
        if ((this.bitField0_ & 0x100) != 0) {
            size += CodedOutputStream.computeMessageSize(23, this.getBackground());
        }
        if ((this.bitField0_ & 0x200) != 0) {
            size += CodedOutputStream.computeMessageSize(24, this.getBackgroundBack());
        }
        if (this.score_ != 0L) {
            size += CodedOutputStream.computeInt64Size(25, this.score_);
        }
        if ((this.bitField0_ & 0x400) != 0) {
            size += CodedOutputStream.computeMessageSize(26, this.getBuffInfo());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.gradeBanner_)) {
            size += GeneratedMessageV3.computeStringSize(1001, this.gradeBanner_);
        }
        if ((this.bitField0_ & 0x800) != 0) {
            size += CodedOutputStream.computeMessageSize(1002, this.getProfileDialogBg());
        }
        if ((this.bitField0_ & 0x1000) != 0) {
            size += CodedOutputStream.computeMessageSize(1003, this.getProfileDialogBgBack());
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayGrade)) {
            return super.equals(obj);
        }
        PayGrade other = (PayGrade)obj;
        if (this.getTotalDiamondCount() != other.getTotalDiamondCount()) {
            return false;
        }
        if (this.hasDiamondIcon() != other.hasDiamondIcon()) {
            return false;
        }
        if (this.hasDiamondIcon() && !this.getDiamondIcon().equals(other.getDiamondIcon())) {
            return false;
        }
        if (!this.getName().equals((Object)other.getName())) {
            return false;
        }
        if (this.hasIcon() != other.hasIcon()) {
            return false;
        }
        if (this.hasIcon() && !this.getIcon().equals(other.getIcon())) {
            return false;
        }
        if (!this.getNextName().equals((Object)other.getNextName())) {
            return false;
        }
        if (this.getLevel() != other.getLevel()) {
            return false;
        }
        if (this.hasNextIcon() != other.hasNextIcon()) {
            return false;
        }
        if (this.hasNextIcon() && !this.getNextIcon().equals(other.getNextIcon())) {
            return false;
        }
        if (this.getNextDiamond() != other.getNextDiamond()) {
            return false;
        }
        if (this.getNowDiamond() != other.getNowDiamond()) {
            return false;
        }
        if (this.getThisGradeMinDiamond() != other.getThisGradeMinDiamond()) {
            return false;
        }
        if (this.getThisGradeMaxDiamond() != other.getThisGradeMaxDiamond()) {
            return false;
        }
        if (this.getPayDiamondBak() != other.getPayDiamondBak()) {
            return false;
        }
        if (!this.getGradeDescribe().equals((Object)other.getGradeDescribe())) {
            return false;
        }
        if (!this.getGradeIconListList().equals(other.getGradeIconListList())) {
            return false;
        }
        if (this.getScreenChatType() != other.getScreenChatType()) {
            return false;
        }
        if (this.hasImIcon() != other.hasImIcon()) {
            return false;
        }
        if (this.hasImIcon() && !this.getImIcon().equals(other.getImIcon())) {
            return false;
        }
        if (this.hasImIconWithLevel() != other.hasImIconWithLevel()) {
            return false;
        }
        if (this.hasImIconWithLevel() && !this.getImIconWithLevel().equals(other.getImIconWithLevel())) {
            return false;
        }
        if (this.hasLiveIcon() != other.hasLiveIcon()) {
            return false;
        }
        if (this.hasLiveIcon() && !this.getLiveIcon().equals(other.getLiveIcon())) {
            return false;
        }
        if (this.hasNewImIconWithLevel() != other.hasNewImIconWithLevel()) {
            return false;
        }
        if (this.hasNewImIconWithLevel() && !this.getNewImIconWithLevel().equals(other.getNewImIconWithLevel())) {
            return false;
        }
        if (this.hasNewLiveIcon() != other.hasNewLiveIcon()) {
            return false;
        }
        if (this.hasNewLiveIcon() && !this.getNewLiveIcon().equals(other.getNewLiveIcon())) {
            return false;
        }
        if (this.getUpgradeNeedConsume() != other.getUpgradeNeedConsume()) {
            return false;
        }
        if (!this.getNextPrivileges().equals((Object)other.getNextPrivileges())) {
            return false;
        }
        if (this.hasBackground() != other.hasBackground()) {
            return false;
        }
        if (this.hasBackground() && !this.getBackground().equals(other.getBackground())) {
            return false;
        }
        if (this.hasBackgroundBack() != other.hasBackgroundBack()) {
            return false;
        }
        if (this.hasBackgroundBack() && !this.getBackgroundBack().equals(other.getBackgroundBack())) {
            return false;
        }
        if (this.getScore() != other.getScore()) {
            return false;
        }
        if (this.hasBuffInfo() != other.hasBuffInfo()) {
            return false;
        }
        if (this.hasBuffInfo() && !this.getBuffInfo().equals(other.getBuffInfo())) {
            return false;
        }
        if (!this.getGradeBanner().equals((Object)other.getGradeBanner())) {
            return false;
        }
        if (this.hasProfileDialogBg() != other.hasProfileDialogBg()) {
            return false;
        }
        if (this.hasProfileDialogBg() && !this.getProfileDialogBg().equals(other.getProfileDialogBg())) {
            return false;
        }
        if (this.hasProfileDialogBgBack() != other.hasProfileDialogBgBack()) {
            return false;
        }
        if (this.hasProfileDialogBgBack() && !this.getProfileDialogBgBack().equals(other.getProfileDialogBgBack())) {
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
        hash = 19 * hash + PayGrade.getDescriptor().hashCode();
        hash = 37 * hash + 1;
        hash = 53 * hash + Internal.hashLong(this.getTotalDiamondCount());
        if (this.hasDiamondIcon()) {
            hash = 37 * hash + 2;
            hash = 53 * hash + this.getDiamondIcon().hashCode();
        }
        hash = 37 * hash + 3;
        hash = 53 * hash + this.getName().hashCode();
        if (this.hasIcon()) {
            hash = 37 * hash + 4;
            hash = 53 * hash + this.getIcon().hashCode();
        }
        hash = 37 * hash + 5;
        hash = 53 * hash + this.getNextName().hashCode();
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashLong(this.getLevel());
        if (this.hasNextIcon()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getNextIcon().hashCode();
        }
        hash = 37 * hash + 8;
        hash = 53 * hash + Internal.hashLong(this.getNextDiamond());
        hash = 37 * hash + 9;
        hash = 53 * hash + Internal.hashLong(this.getNowDiamond());
        hash = 37 * hash + 10;
        hash = 53 * hash + Internal.hashLong(this.getThisGradeMinDiamond());
        hash = 37 * hash + 11;
        hash = 53 * hash + Internal.hashLong(this.getThisGradeMaxDiamond());
        hash = 37 * hash + 12;
        hash = 53 * hash + Internal.hashLong(this.getPayDiamondBak());
        hash = 37 * hash + 13;
        hash = 53 * hash + this.getGradeDescribe().hashCode();
        if (this.getGradeIconListCount() > 0) {
            hash = 37 * hash + 14;
            hash = 53 * hash + this.getGradeIconListList().hashCode();
        }
        hash = 37 * hash + 15;
        hash = 53 * hash + Internal.hashLong(this.getScreenChatType());
        if (this.hasImIcon()) {
            hash = 37 * hash + 16;
            hash = 53 * hash + this.getImIcon().hashCode();
        }
        if (this.hasImIconWithLevel()) {
            hash = 37 * hash + 17;
            hash = 53 * hash + this.getImIconWithLevel().hashCode();
        }
        if (this.hasLiveIcon()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getLiveIcon().hashCode();
        }
        if (this.hasNewImIconWithLevel()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getNewImIconWithLevel().hashCode();
        }
        if (this.hasNewLiveIcon()) {
            hash = 37 * hash + 20;
            hash = 53 * hash + this.getNewLiveIcon().hashCode();
        }
        hash = 37 * hash + 21;
        hash = 53 * hash + Internal.hashLong(this.getUpgradeNeedConsume());
        hash = 37 * hash + 22;
        hash = 53 * hash + this.getNextPrivileges().hashCode();
        if (this.hasBackground()) {
            hash = 37 * hash + 23;
            hash = 53 * hash + this.getBackground().hashCode();
        }
        if (this.hasBackgroundBack()) {
            hash = 37 * hash + 24;
            hash = 53 * hash + this.getBackgroundBack().hashCode();
        }
        hash = 37 * hash + 25;
        hash = 53 * hash + Internal.hashLong(this.getScore());
        if (this.hasBuffInfo()) {
            hash = 37 * hash + 26;
            hash = 53 * hash + this.getBuffInfo().hashCode();
        }
        hash = 37 * hash + 1001;
        hash = 53 * hash + this.getGradeBanner().hashCode();
        if (this.hasProfileDialogBg()) {
            hash = 37 * hash + 1002;
            hash = 53 * hash + this.getProfileDialogBg().hashCode();
        }
        if (this.hasProfileDialogBgBack()) {
            hash = 37 * hash + 1003;
            hash = 53 * hash + this.getProfileDialogBgBack().hashCode();
        }
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static PayGrade parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PayGrade parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PayGrade parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PayGrade parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PayGrade parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static PayGrade parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static PayGrade parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static PayGrade parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static PayGrade parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static PayGrade parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static PayGrade parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static PayGrade parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return PayGrade.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PayGrade prototype) {
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

    public static PayGrade getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PayGrade> parser() {
        return PARSER;
    }

    public Parser<PayGrade> getParserForType() {
        return PARSER;
    }

    @Override
    public PayGrade getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements PayGradeOrBuilder {
        private int bitField0_;
        private long totalDiamondCount_;
        private Image diamondIcon_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> diamondIconBuilder_;
        private Object name_ = "";
        private Image icon_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> iconBuilder_;
        private Object nextName_ = "";
        private long level_;
        private Image nextIcon_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> nextIconBuilder_;
        private long nextDiamond_;
        private long nowDiamond_;
        private long thisGradeMinDiamond_;
        private long thisGradeMaxDiamond_;
        private long payDiamondBak_;
        private Object gradeDescribe_ = "";
        private List<GradeIcon> gradeIconList_ = Collections.emptyList();
        private RepeatedFieldBuilderV3<GradeIcon, GradeIcon.Builder, GradeIconOrBuilder> gradeIconListBuilder_;
        private long screenChatType_;
        private Image imIcon_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> imIconBuilder_;
        private Image imIconWithLevel_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> imIconWithLevelBuilder_;
        private Image liveIcon_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> liveIconBuilder_;
        private Image newImIconWithLevel_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> newImIconWithLevelBuilder_;
        private Image newLiveIcon_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> newLiveIconBuilder_;
        private long upgradeNeedConsume_;
        private Object nextPrivileges_ = "";
        private Image background_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> backgroundBuilder_;
        private Image backgroundBack_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> backgroundBackBuilder_;
        private long score_;
        private GradeBuffInfo buffInfo_;
        private SingleFieldBuilderV3<GradeBuffInfo, GradeBuffInfo.Builder, GradeBuffInfoOrBuilder> buffInfoBuilder_;
        private Object gradeBanner_ = "";
        private Image profileDialogBg_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> profileDialogBgBuilder_;
        private Image profileDialogBgBack_;
        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> profileDialogBgBackBuilder_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_PayGrade_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_PayGrade_fieldAccessorTable.ensureFieldAccessorsInitialized(PayGrade.class, Builder.class);
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
                this.getDiamondIconFieldBuilder();
                this.getIconFieldBuilder();
                this.getNextIconFieldBuilder();
                this.getGradeIconListFieldBuilder();
                this.getImIconFieldBuilder();
                this.getImIconWithLevelFieldBuilder();
                this.getLiveIconFieldBuilder();
                this.getNewImIconWithLevelFieldBuilder();
                this.getNewLiveIconFieldBuilder();
                this.getBackgroundFieldBuilder();
                this.getBackgroundBackFieldBuilder();
                this.getBuffInfoFieldBuilder();
                this.getProfileDialogBgFieldBuilder();
                this.getProfileDialogBgBackFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.totalDiamondCount_ = 0L;
            this.diamondIcon_ = null;
            if (this.diamondIconBuilder_ != null) {
                this.diamondIconBuilder_.dispose();
                this.diamondIconBuilder_ = null;
            }
            this.name_ = "";
            this.icon_ = null;
            if (this.iconBuilder_ != null) {
                this.iconBuilder_.dispose();
                this.iconBuilder_ = null;
            }
            this.nextName_ = "";
            this.level_ = 0L;
            this.nextIcon_ = null;
            if (this.nextIconBuilder_ != null) {
                this.nextIconBuilder_.dispose();
                this.nextIconBuilder_ = null;
            }
            this.nextDiamond_ = 0L;
            this.nowDiamond_ = 0L;
            this.thisGradeMinDiamond_ = 0L;
            this.thisGradeMaxDiamond_ = 0L;
            this.payDiamondBak_ = 0L;
            this.gradeDescribe_ = "";
            if (this.gradeIconListBuilder_ == null) {
                this.gradeIconList_ = Collections.emptyList();
            } else {
                this.gradeIconList_ = null;
                this.gradeIconListBuilder_.clear();
            }
            this.bitField0_ &= 0xFFFFDFFF;
            this.screenChatType_ = 0L;
            this.imIcon_ = null;
            if (this.imIconBuilder_ != null) {
                this.imIconBuilder_.dispose();
                this.imIconBuilder_ = null;
            }
            this.imIconWithLevel_ = null;
            if (this.imIconWithLevelBuilder_ != null) {
                this.imIconWithLevelBuilder_.dispose();
                this.imIconWithLevelBuilder_ = null;
            }
            this.liveIcon_ = null;
            if (this.liveIconBuilder_ != null) {
                this.liveIconBuilder_.dispose();
                this.liveIconBuilder_ = null;
            }
            this.newImIconWithLevel_ = null;
            if (this.newImIconWithLevelBuilder_ != null) {
                this.newImIconWithLevelBuilder_.dispose();
                this.newImIconWithLevelBuilder_ = null;
            }
            this.newLiveIcon_ = null;
            if (this.newLiveIconBuilder_ != null) {
                this.newLiveIconBuilder_.dispose();
                this.newLiveIconBuilder_ = null;
            }
            this.upgradeNeedConsume_ = 0L;
            this.nextPrivileges_ = "";
            this.background_ = null;
            if (this.backgroundBuilder_ != null) {
                this.backgroundBuilder_.dispose();
                this.backgroundBuilder_ = null;
            }
            this.backgroundBack_ = null;
            if (this.backgroundBackBuilder_ != null) {
                this.backgroundBackBuilder_.dispose();
                this.backgroundBackBuilder_ = null;
            }
            this.score_ = 0L;
            this.buffInfo_ = null;
            if (this.buffInfoBuilder_ != null) {
                this.buffInfoBuilder_.dispose();
                this.buffInfoBuilder_ = null;
            }
            this.gradeBanner_ = "";
            this.profileDialogBg_ = null;
            if (this.profileDialogBgBuilder_ != null) {
                this.profileDialogBgBuilder_.dispose();
                this.profileDialogBgBuilder_ = null;
            }
            this.profileDialogBgBack_ = null;
            if (this.profileDialogBgBackBuilder_ != null) {
                this.profileDialogBgBackBuilder_.dispose();
                this.profileDialogBgBackBuilder_ = null;
            }
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_PayGrade_descriptor;
        }

        @Override
        public PayGrade getDefaultInstanceForType() {
            return PayGrade.getDefaultInstance();
        }

        @Override
        public PayGrade build() {
            PayGrade result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public PayGrade buildPartial() {
            PayGrade result = new PayGrade(this);
            this.buildPartialRepeatedFields(result);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartialRepeatedFields(PayGrade result) {
            if (this.gradeIconListBuilder_ == null) {
                if ((this.bitField0_ & 0x2000) != 0) {
                    this.gradeIconList_ = Collections.unmodifiableList(this.gradeIconList_);
                    this.bitField0_ &= 0xFFFFDFFF;
                }
                result.gradeIconList_ = this.gradeIconList_;
            } else {
                result.gradeIconList_ = this.gradeIconListBuilder_.build();
            }
        }

        private void buildPartial0(PayGrade result) {
            int from_bitField0_ = this.bitField0_;
            if ((from_bitField0_ & 1) != 0) {
                result.totalDiamondCount_ = this.totalDiamondCount_;
            }
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 2) != 0) {
                result.diamondIcon_ = this.diamondIconBuilder_ == null ? this.diamondIcon_ : this.diamondIconBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.name_ = this.name_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.icon_ = this.iconBuilder_ == null ? this.icon_ : this.iconBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.nextName_ = this.nextName_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.level_ = this.level_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.nextIcon_ = this.nextIconBuilder_ == null ? this.nextIcon_ : this.nextIconBuilder_.build();
                to_bitField0_ |= 4;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.nextDiamond_ = this.nextDiamond_;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.nowDiamond_ = this.nowDiamond_;
            }
            if ((from_bitField0_ & 0x200) != 0) {
                result.thisGradeMinDiamond_ = this.thisGradeMinDiamond_;
            }
            if ((from_bitField0_ & 0x400) != 0) {
                result.thisGradeMaxDiamond_ = this.thisGradeMaxDiamond_;
            }
            if ((from_bitField0_ & 0x800) != 0) {
                result.payDiamondBak_ = this.payDiamondBak_;
            }
            if ((from_bitField0_ & 0x1000) != 0) {
                result.gradeDescribe_ = this.gradeDescribe_;
            }
            if ((from_bitField0_ & 0x4000) != 0) {
                result.screenChatType_ = this.screenChatType_;
            }
            if ((from_bitField0_ & 0x8000) != 0) {
                result.imIcon_ = this.imIconBuilder_ == null ? this.imIcon_ : this.imIconBuilder_.build();
                to_bitField0_ |= 8;
            }
            if ((from_bitField0_ & 0x10000) != 0) {
                result.imIconWithLevel_ = this.imIconWithLevelBuilder_ == null ? this.imIconWithLevel_ : this.imIconWithLevelBuilder_.build();
                to_bitField0_ |= 0x10;
            }
            if ((from_bitField0_ & 0x20000) != 0) {
                result.liveIcon_ = this.liveIconBuilder_ == null ? this.liveIcon_ : this.liveIconBuilder_.build();
                to_bitField0_ |= 0x20;
            }
            if ((from_bitField0_ & 0x40000) != 0) {
                result.newImIconWithLevel_ = this.newImIconWithLevelBuilder_ == null ? this.newImIconWithLevel_ : this.newImIconWithLevelBuilder_.build();
                to_bitField0_ |= 0x40;
            }
            if ((from_bitField0_ & 0x80000) != 0) {
                result.newLiveIcon_ = this.newLiveIconBuilder_ == null ? this.newLiveIcon_ : this.newLiveIconBuilder_.build();
                to_bitField0_ |= 0x80;
            }
            if ((from_bitField0_ & 0x100000) != 0) {
                result.upgradeNeedConsume_ = this.upgradeNeedConsume_;
            }
            if ((from_bitField0_ & 0x200000) != 0) {
                result.nextPrivileges_ = this.nextPrivileges_;
            }
            if ((from_bitField0_ & 0x400000) != 0) {
                result.background_ = this.backgroundBuilder_ == null ? this.background_ : this.backgroundBuilder_.build();
                to_bitField0_ |= 0x100;
            }
            if ((from_bitField0_ & 0x800000) != 0) {
                result.backgroundBack_ = this.backgroundBackBuilder_ == null ? this.backgroundBack_ : this.backgroundBackBuilder_.build();
                to_bitField0_ |= 0x200;
            }
            if ((from_bitField0_ & 0x1000000) != 0) {
                result.score_ = this.score_;
            }
            if ((from_bitField0_ & 0x2000000) != 0) {
                result.buffInfo_ = this.buffInfoBuilder_ == null ? this.buffInfo_ : this.buffInfoBuilder_.build();
                to_bitField0_ |= 0x400;
            }
            if ((from_bitField0_ & 0x4000000) != 0) {
                result.gradeBanner_ = this.gradeBanner_;
            }
            if ((from_bitField0_ & 0x8000000) != 0) {
                result.profileDialogBg_ = this.profileDialogBgBuilder_ == null ? this.profileDialogBg_ : this.profileDialogBgBuilder_.build();
                to_bitField0_ |= 0x800;
            }
            if ((from_bitField0_ & 0x10000000) != 0) {
                result.profileDialogBgBack_ = this.profileDialogBgBackBuilder_ == null ? this.profileDialogBgBack_ : this.profileDialogBgBackBuilder_.build();
                to_bitField0_ |= 0x1000;
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
            if (other instanceof PayGrade) {
                return this.mergeFrom((PayGrade)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(PayGrade other) {
            if (other == PayGrade.getDefaultInstance()) {
                return this;
            }
            if (other.getTotalDiamondCount() != 0L) {
                this.setTotalDiamondCount(other.getTotalDiamondCount());
            }
            if (other.hasDiamondIcon()) {
                this.mergeDiamondIcon(other.getDiamondIcon());
            }
            if (!other.getName().isEmpty()) {
                this.name_ = other.name_;
                this.bitField0_ |= 4;
                this.onChanged();
            }
            if (other.hasIcon()) {
                this.mergeIcon(other.getIcon());
            }
            if (!other.getNextName().isEmpty()) {
                this.nextName_ = other.nextName_;
                this.bitField0_ |= 0x10;
                this.onChanged();
            }
            if (other.getLevel() != 0L) {
                this.setLevel(other.getLevel());
            }
            if (other.hasNextIcon()) {
                this.mergeNextIcon(other.getNextIcon());
            }
            if (other.getNextDiamond() != 0L) {
                this.setNextDiamond(other.getNextDiamond());
            }
            if (other.getNowDiamond() != 0L) {
                this.setNowDiamond(other.getNowDiamond());
            }
            if (other.getThisGradeMinDiamond() != 0L) {
                this.setThisGradeMinDiamond(other.getThisGradeMinDiamond());
            }
            if (other.getThisGradeMaxDiamond() != 0L) {
                this.setThisGradeMaxDiamond(other.getThisGradeMaxDiamond());
            }
            if (other.getPayDiamondBak() != 0L) {
                this.setPayDiamondBak(other.getPayDiamondBak());
            }
            if (!other.getGradeDescribe().isEmpty()) {
                this.gradeDescribe_ = other.gradeDescribe_;
                this.bitField0_ |= 0x1000;
                this.onChanged();
            }
            if (this.gradeIconListBuilder_ == null) {
                if (!other.gradeIconList_.isEmpty()) {
                    if (this.gradeIconList_.isEmpty()) {
                        this.gradeIconList_ = other.gradeIconList_;
                        this.bitField0_ &= 0xFFFFDFFF;
                    } else {
                        this.ensureGradeIconListIsMutable();
                        this.gradeIconList_.addAll((Collection)other.gradeIconList_);
                    }
                    this.onChanged();
                }
            } else if (!other.gradeIconList_.isEmpty()) {
                if (this.gradeIconListBuilder_.isEmpty()) {
                    this.gradeIconListBuilder_.dispose();
                    this.gradeIconListBuilder_ = null;
                    this.gradeIconList_ = other.gradeIconList_;
                    this.bitField0_ &= 0xFFFFDFFF;
                    this.gradeIconListBuilder_ = alwaysUseFieldBuilders ? this.getGradeIconListFieldBuilder() : null;
                } else {
                    this.gradeIconListBuilder_.addAllMessages((Iterable<GradeIcon>)other.gradeIconList_);
                }
            }
            if (other.getScreenChatType() != 0L) {
                this.setScreenChatType(other.getScreenChatType());
            }
            if (other.hasImIcon()) {
                this.mergeImIcon(other.getImIcon());
            }
            if (other.hasImIconWithLevel()) {
                this.mergeImIconWithLevel(other.getImIconWithLevel());
            }
            if (other.hasLiveIcon()) {
                this.mergeLiveIcon(other.getLiveIcon());
            }
            if (other.hasNewImIconWithLevel()) {
                this.mergeNewImIconWithLevel(other.getNewImIconWithLevel());
            }
            if (other.hasNewLiveIcon()) {
                this.mergeNewLiveIcon(other.getNewLiveIcon());
            }
            if (other.getUpgradeNeedConsume() != 0L) {
                this.setUpgradeNeedConsume(other.getUpgradeNeedConsume());
            }
            if (!other.getNextPrivileges().isEmpty()) {
                this.nextPrivileges_ = other.nextPrivileges_;
                this.bitField0_ |= 0x200000;
                this.onChanged();
            }
            if (other.hasBackground()) {
                this.mergeBackground(other.getBackground());
            }
            if (other.hasBackgroundBack()) {
                this.mergeBackgroundBack(other.getBackgroundBack());
            }
            if (other.getScore() != 0L) {
                this.setScore(other.getScore());
            }
            if (other.hasBuffInfo()) {
                this.mergeBuffInfo(other.getBuffInfo());
            }
            if (!other.getGradeBanner().isEmpty()) {
                this.gradeBanner_ = other.gradeBanner_;
                this.bitField0_ |= 0x4000000;
                this.onChanged();
            }
            if (other.hasProfileDialogBg()) {
                this.mergeProfileDialogBg(other.getProfileDialogBg());
            }
            if (other.hasProfileDialogBgBack()) {
                this.mergeProfileDialogBgBack(other.getProfileDialogBgBack());
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
                block37: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block37;
                        }
                        case 8: {
                            this.totalDiamondCount_ = input.readInt64();
                            this.bitField0_ |= 1;
                            continue block37;
                        }
                        case 18: {
                            input.readMessage(this.getDiamondIconFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 2;
                            continue block37;
                        }
                        case 26: {
                            this.name_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 4;
                            continue block37;
                        }
                        case 34: {
                            input.readMessage(this.getIconFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 8;
                            continue block37;
                        }
                        case 42: {
                            this.nextName_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x10;
                            continue block37;
                        }
                        case 48: {
                            this.level_ = input.readInt64();
                            this.bitField0_ |= 0x20;
                            continue block37;
                        }
                        case 58: {
                            input.readMessage(this.getNextIconFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x40;
                            continue block37;
                        }
                        case 64: {
                            this.nextDiamond_ = input.readInt64();
                            this.bitField0_ |= 0x80;
                            continue block37;
                        }
                        case 72: {
                            this.nowDiamond_ = input.readInt64();
                            this.bitField0_ |= 0x100;
                            continue block37;
                        }
                        case 80: {
                            this.thisGradeMinDiamond_ = input.readInt64();
                            this.bitField0_ |= 0x200;
                            continue block37;
                        }
                        case 88: {
                            this.thisGradeMaxDiamond_ = input.readInt64();
                            this.bitField0_ |= 0x400;
                            continue block37;
                        }
                        case 96: {
                            this.payDiamondBak_ = input.readInt64();
                            this.bitField0_ |= 0x800;
                            continue block37;
                        }
                        case 106: {
                            this.gradeDescribe_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x1000;
                            continue block37;
                        }
                        case 114: {
                            GradeIcon m = input.readMessage(GradeIcon.parser(), extensionRegistry);
                            if (this.gradeIconListBuilder_ == null) {
                                this.ensureGradeIconListIsMutable();
                                this.gradeIconList_.add((Object)m);
                                continue block37;
                            }
                            this.gradeIconListBuilder_.addMessage(m);
                            continue block37;
                        }
                        case 120: {
                            this.screenChatType_ = input.readInt64();
                            this.bitField0_ |= 0x4000;
                            continue block37;
                        }
                        case 130: {
                            input.readMessage(this.getImIconFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x8000;
                            continue block37;
                        }
                        case 138: {
                            input.readMessage(this.getImIconWithLevelFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x10000;
                            continue block37;
                        }
                        case 146: {
                            input.readMessage(this.getLiveIconFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x20000;
                            continue block37;
                        }
                        case 154: {
                            input.readMessage(this.getNewImIconWithLevelFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x40000;
                            continue block37;
                        }
                        case 162: {
                            input.readMessage(this.getNewLiveIconFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x80000;
                            continue block37;
                        }
                        case 168: {
                            this.upgradeNeedConsume_ = input.readInt64();
                            this.bitField0_ |= 0x100000;
                            continue block37;
                        }
                        case 178: {
                            this.nextPrivileges_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x200000;
                            continue block37;
                        }
                        case 186: {
                            input.readMessage(this.getBackgroundFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x400000;
                            continue block37;
                        }
                        case 194: {
                            input.readMessage(this.getBackgroundBackFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x800000;
                            continue block37;
                        }
                        case 200: {
                            this.score_ = input.readInt64();
                            this.bitField0_ |= 0x1000000;
                            continue block37;
                        }
                        case 210: {
                            input.readMessage(this.getBuffInfoFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x2000000;
                            continue block37;
                        }
                        case 8010: {
                            this.gradeBanner_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x4000000;
                            continue block37;
                        }
                        case 8018: {
                            input.readMessage(this.getProfileDialogBgFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x8000000;
                            continue block37;
                        }
                        case 8026: {
                            input.readMessage(this.getProfileDialogBgBackFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x10000000;
                            continue block37;
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
        public long getTotalDiamondCount() {
            return this.totalDiamondCount_;
        }

        public Builder setTotalDiamondCount(long value) {
            this.totalDiamondCount_ = value;
            this.bitField0_ |= 1;
            this.onChanged();
            return this;
        }

        public Builder clearTotalDiamondCount() {
            this.bitField0_ &= 0xFFFFFFFE;
            this.totalDiamondCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasDiamondIcon() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override
        public Image getDiamondIcon() {
            if (this.diamondIconBuilder_ == null) {
                return this.diamondIcon_ == null ? Image.getDefaultInstance() : this.diamondIcon_;
            }
            return this.diamondIconBuilder_.getMessage();
        }

        public Builder setDiamondIcon(Image value) {
            if (this.diamondIconBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.diamondIcon_ = value;
            } else {
                this.diamondIconBuilder_.setMessage(value);
            }
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder setDiamondIcon(Image.Builder builderForValue) {
            if (this.diamondIconBuilder_ == null) {
                this.diamondIcon_ = builderForValue.build();
            } else {
                this.diamondIconBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder mergeDiamondIcon(Image value) {
            if (this.diamondIconBuilder_ == null) {
                if ((this.bitField0_ & 2) != 0 && this.diamondIcon_ != null && this.diamondIcon_ != Image.getDefaultInstance()) {
                    this.getDiamondIconBuilder().mergeFrom(value);
                } else {
                    this.diamondIcon_ = value;
                }
            } else {
                this.diamondIconBuilder_.mergeFrom(value);
            }
            if (this.diamondIcon_ != null) {
                this.bitField0_ |= 2;
                this.onChanged();
            }
            return this;
        }

        public Builder clearDiamondIcon() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.diamondIcon_ = null;
            if (this.diamondIconBuilder_ != null) {
                this.diamondIconBuilder_.dispose();
                this.diamondIconBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getDiamondIconBuilder() {
            this.bitField0_ |= 2;
            this.onChanged();
            return this.getDiamondIconFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getDiamondIconOrBuilder() {
            if (this.diamondIconBuilder_ != null) {
                return this.diamondIconBuilder_.getMessageOrBuilder();
            }
            return this.diamondIcon_ == null ? Image.getDefaultInstance() : this.diamondIcon_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getDiamondIconFieldBuilder() {
            if (this.diamondIconBuilder_ == null) {
                this.diamondIconBuilder_ = new SingleFieldBuilderV3(this.getDiamondIcon(), this.getParentForChildren(), this.isClean());
                this.diamondIcon_ = null;
            }
            return this.diamondIconBuilder_;
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
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = PayGrade.getDefaultInstance().getName();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PayGrade.checkByteStringIsUtf8(value);
            this.name_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasIcon() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override
        public Image getIcon() {
            if (this.iconBuilder_ == null) {
                return this.icon_ == null ? Image.getDefaultInstance() : this.icon_;
            }
            return this.iconBuilder_.getMessage();
        }

        public Builder setIcon(Image value) {
            if (this.iconBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.icon_ = value;
            } else {
                this.iconBuilder_.setMessage(value);
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder setIcon(Image.Builder builderForValue) {
            if (this.iconBuilder_ == null) {
                this.icon_ = builderForValue.build();
            } else {
                this.iconBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder mergeIcon(Image value) {
            if (this.iconBuilder_ == null) {
                if ((this.bitField0_ & 8) != 0 && this.icon_ != null && this.icon_ != Image.getDefaultInstance()) {
                    this.getIconBuilder().mergeFrom(value);
                } else {
                    this.icon_ = value;
                }
            } else {
                this.iconBuilder_.mergeFrom(value);
            }
            if (this.icon_ != null) {
                this.bitField0_ |= 8;
                this.onChanged();
            }
            return this;
        }

        public Builder clearIcon() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.icon_ = null;
            if (this.iconBuilder_ != null) {
                this.iconBuilder_.dispose();
                this.iconBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getIconBuilder() {
            this.bitField0_ |= 8;
            this.onChanged();
            return this.getIconFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getIconOrBuilder() {
            if (this.iconBuilder_ != null) {
                return this.iconBuilder_.getMessageOrBuilder();
            }
            return this.icon_ == null ? Image.getDefaultInstance() : this.icon_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getIconFieldBuilder() {
            if (this.iconBuilder_ == null) {
                this.iconBuilder_ = new SingleFieldBuilderV3(this.getIcon(), this.getParentForChildren(), this.isClean());
                this.icon_ = null;
            }
            return this.iconBuilder_;
        }

        @Override
        public String getNextName() {
            Object ref = this.nextName_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.nextName_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getNextNameBytes() {
            Object ref = this.nextName_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.nextName_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setNextName(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.nextName_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearNextName() {
            this.nextName_ = PayGrade.getDefaultInstance().getNextName();
            this.bitField0_ &= 0xFFFFFFEF;
            this.onChanged();
            return this;
        }

        public Builder setNextNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PayGrade.checkByteStringIsUtf8(value);
            this.nextName_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        @Override
        public long getLevel() {
            return this.level_;
        }

        public Builder setLevel(long value) {
            this.level_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearLevel() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.level_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasNextIcon() {
            return (this.bitField0_ & 0x40) != 0;
        }

        @Override
        public Image getNextIcon() {
            if (this.nextIconBuilder_ == null) {
                return this.nextIcon_ == null ? Image.getDefaultInstance() : this.nextIcon_;
            }
            return this.nextIconBuilder_.getMessage();
        }

        public Builder setNextIcon(Image value) {
            if (this.nextIconBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.nextIcon_ = value;
            } else {
                this.nextIconBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder setNextIcon(Image.Builder builderForValue) {
            if (this.nextIconBuilder_ == null) {
                this.nextIcon_ = builderForValue.build();
            } else {
                this.nextIconBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder mergeNextIcon(Image value) {
            if (this.nextIconBuilder_ == null) {
                if ((this.bitField0_ & 0x40) != 0 && this.nextIcon_ != null && this.nextIcon_ != Image.getDefaultInstance()) {
                    this.getNextIconBuilder().mergeFrom(value);
                } else {
                    this.nextIcon_ = value;
                }
            } else {
                this.nextIconBuilder_.mergeFrom(value);
            }
            if (this.nextIcon_ != null) {
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            return this;
        }

        public Builder clearNextIcon() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.nextIcon_ = null;
            if (this.nextIconBuilder_ != null) {
                this.nextIconBuilder_.dispose();
                this.nextIconBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getNextIconBuilder() {
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this.getNextIconFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getNextIconOrBuilder() {
            if (this.nextIconBuilder_ != null) {
                return this.nextIconBuilder_.getMessageOrBuilder();
            }
            return this.nextIcon_ == null ? Image.getDefaultInstance() : this.nextIcon_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getNextIconFieldBuilder() {
            if (this.nextIconBuilder_ == null) {
                this.nextIconBuilder_ = new SingleFieldBuilderV3(this.getNextIcon(), this.getParentForChildren(), this.isClean());
                this.nextIcon_ = null;
            }
            return this.nextIconBuilder_;
        }

        @Override
        public long getNextDiamond() {
            return this.nextDiamond_;
        }

        public Builder setNextDiamond(long value) {
            this.nextDiamond_ = value;
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder clearNextDiamond() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.nextDiamond_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getNowDiamond() {
            return this.nowDiamond_;
        }

        public Builder setNowDiamond(long value) {
            this.nowDiamond_ = value;
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder clearNowDiamond() {
            this.bitField0_ &= 0xFFFFFEFF;
            this.nowDiamond_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getThisGradeMinDiamond() {
            return this.thisGradeMinDiamond_;
        }

        public Builder setThisGradeMinDiamond(long value) {
            this.thisGradeMinDiamond_ = value;
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder clearThisGradeMinDiamond() {
            this.bitField0_ &= 0xFFFFFDFF;
            this.thisGradeMinDiamond_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getThisGradeMaxDiamond() {
            return this.thisGradeMaxDiamond_;
        }

        public Builder setThisGradeMaxDiamond(long value) {
            this.thisGradeMaxDiamond_ = value;
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this;
        }

        public Builder clearThisGradeMaxDiamond() {
            this.bitField0_ &= 0xFFFFFBFF;
            this.thisGradeMaxDiamond_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getPayDiamondBak() {
            return this.payDiamondBak_;
        }

        public Builder setPayDiamondBak(long value) {
            this.payDiamondBak_ = value;
            this.bitField0_ |= 0x800;
            this.onChanged();
            return this;
        }

        public Builder clearPayDiamondBak() {
            this.bitField0_ &= 0xFFFFF7FF;
            this.payDiamondBak_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public String getGradeDescribe() {
            Object ref = this.gradeDescribe_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.gradeDescribe_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getGradeDescribeBytes() {
            Object ref = this.gradeDescribe_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.gradeDescribe_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setGradeDescribe(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.gradeDescribe_ = value;
            this.bitField0_ |= 0x1000;
            this.onChanged();
            return this;
        }

        public Builder clearGradeDescribe() {
            this.gradeDescribe_ = PayGrade.getDefaultInstance().getGradeDescribe();
            this.bitField0_ &= 0xFFFFEFFF;
            this.onChanged();
            return this;
        }

        public Builder setGradeDescribeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PayGrade.checkByteStringIsUtf8(value);
            this.gradeDescribe_ = value;
            this.bitField0_ |= 0x1000;
            this.onChanged();
            return this;
        }

        private void ensureGradeIconListIsMutable() {
            if ((this.bitField0_ & 0x2000) == 0) {
                this.gradeIconList_ = new ArrayList(this.gradeIconList_);
                this.bitField0_ |= 0x2000;
            }
        }

        @Override
        public List<GradeIcon> getGradeIconListList() {
            if (this.gradeIconListBuilder_ == null) {
                return Collections.unmodifiableList(this.gradeIconList_);
            }
            return this.gradeIconListBuilder_.getMessageList();
        }

        @Override
        public int getGradeIconListCount() {
            if (this.gradeIconListBuilder_ == null) {
                return this.gradeIconList_.size();
            }
            return this.gradeIconListBuilder_.getCount();
        }

        @Override
        public GradeIcon getGradeIconList(int index) {
            if (this.gradeIconListBuilder_ == null) {
                return (GradeIcon)this.gradeIconList_.get(index);
            }
            return this.gradeIconListBuilder_.getMessage(index);
        }

        public Builder setGradeIconList(int index, GradeIcon value) {
            if (this.gradeIconListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.set(index, (Object)value);
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.setMessage(index, value);
            }
            return this;
        }

        public Builder setGradeIconList(int index, GradeIcon.Builder builderForValue) {
            if (this.gradeIconListBuilder_ == null) {
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.set(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addGradeIconList(GradeIcon value) {
            if (this.gradeIconListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.add((Object)value);
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.addMessage(value);
            }
            return this;
        }

        public Builder addGradeIconList(int index, GradeIcon value) {
            if (this.gradeIconListBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.add(index, (Object)value);
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.addMessage(index, value);
            }
            return this;
        }

        public Builder addGradeIconList(GradeIcon.Builder builderForValue) {
            if (this.gradeIconListBuilder_ == null) {
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.add((Object)builderForValue.build());
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        public Builder addGradeIconList(int index, GradeIcon.Builder builderForValue) {
            if (this.gradeIconListBuilder_ == null) {
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.add(index, (Object)builderForValue.build());
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        public Builder addAllGradeIconList(Iterable<? extends GradeIcon> values) {
            if (this.gradeIconListBuilder_ == null) {
                this.ensureGradeIconListIsMutable();
                AbstractMessageLite.Builder.addAll(values, this.gradeIconList_);
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.addAllMessages(values);
            }
            return this;
        }

        public Builder clearGradeIconList() {
            if (this.gradeIconListBuilder_ == null) {
                this.gradeIconList_ = Collections.emptyList();
                this.bitField0_ &= 0xFFFFDFFF;
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.clear();
            }
            return this;
        }

        public Builder removeGradeIconList(int index) {
            if (this.gradeIconListBuilder_ == null) {
                this.ensureGradeIconListIsMutable();
                this.gradeIconList_.remove(index);
                this.onChanged();
            } else {
                this.gradeIconListBuilder_.remove(index);
            }
            return this;
        }

        public GradeIcon.Builder getGradeIconListBuilder(int index) {
            return this.getGradeIconListFieldBuilder().getBuilder(index);
        }

        @Override
        public GradeIconOrBuilder getGradeIconListOrBuilder(int index) {
            if (this.gradeIconListBuilder_ == null) {
                return (GradeIconOrBuilder)this.gradeIconList_.get(index);
            }
            return this.gradeIconListBuilder_.getMessageOrBuilder(index);
        }

        @Override
        public List<? extends GradeIconOrBuilder> getGradeIconListOrBuilderList() {
            if (this.gradeIconListBuilder_ != null) {
                return this.gradeIconListBuilder_.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gradeIconList_);
        }

        public GradeIcon.Builder addGradeIconListBuilder() {
            return this.getGradeIconListFieldBuilder().addBuilder(GradeIcon.getDefaultInstance());
        }

        public GradeIcon.Builder addGradeIconListBuilder(int index) {
            return this.getGradeIconListFieldBuilder().addBuilder(index, GradeIcon.getDefaultInstance());
        }

        public List<GradeIcon.Builder> getGradeIconListBuilderList() {
            return this.getGradeIconListFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilderV3<GradeIcon, GradeIcon.Builder, GradeIconOrBuilder> getGradeIconListFieldBuilder() {
            if (this.gradeIconListBuilder_ == null) {
                this.gradeIconListBuilder_ = new RepeatedFieldBuilderV3(this.gradeIconList_, (this.bitField0_ & 0x2000) != 0, this.getParentForChildren(), this.isClean());
                this.gradeIconList_ = null;
            }
            return this.gradeIconListBuilder_;
        }

        @Override
        public long getScreenChatType() {
            return this.screenChatType_;
        }

        public Builder setScreenChatType(long value) {
            this.screenChatType_ = value;
            this.bitField0_ |= 0x4000;
            this.onChanged();
            return this;
        }

        public Builder clearScreenChatType() {
            this.bitField0_ &= 0xFFFFBFFF;
            this.screenChatType_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasImIcon() {
            return (this.bitField0_ & 0x8000) != 0;
        }

        @Override
        public Image getImIcon() {
            if (this.imIconBuilder_ == null) {
                return this.imIcon_ == null ? Image.getDefaultInstance() : this.imIcon_;
            }
            return this.imIconBuilder_.getMessage();
        }

        public Builder setImIcon(Image value) {
            if (this.imIconBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.imIcon_ = value;
            } else {
                this.imIconBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x8000;
            this.onChanged();
            return this;
        }

        public Builder setImIcon(Image.Builder builderForValue) {
            if (this.imIconBuilder_ == null) {
                this.imIcon_ = builderForValue.build();
            } else {
                this.imIconBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x8000;
            this.onChanged();
            return this;
        }

        public Builder mergeImIcon(Image value) {
            if (this.imIconBuilder_ == null) {
                if ((this.bitField0_ & 0x8000) != 0 && this.imIcon_ != null && this.imIcon_ != Image.getDefaultInstance()) {
                    this.getImIconBuilder().mergeFrom(value);
                } else {
                    this.imIcon_ = value;
                }
            } else {
                this.imIconBuilder_.mergeFrom(value);
            }
            if (this.imIcon_ != null) {
                this.bitField0_ |= 0x8000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearImIcon() {
            this.bitField0_ &= 0xFFFF7FFF;
            this.imIcon_ = null;
            if (this.imIconBuilder_ != null) {
                this.imIconBuilder_.dispose();
                this.imIconBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getImIconBuilder() {
            this.bitField0_ |= 0x8000;
            this.onChanged();
            return this.getImIconFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getImIconOrBuilder() {
            if (this.imIconBuilder_ != null) {
                return this.imIconBuilder_.getMessageOrBuilder();
            }
            return this.imIcon_ == null ? Image.getDefaultInstance() : this.imIcon_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getImIconFieldBuilder() {
            if (this.imIconBuilder_ == null) {
                this.imIconBuilder_ = new SingleFieldBuilderV3(this.getImIcon(), this.getParentForChildren(), this.isClean());
                this.imIcon_ = null;
            }
            return this.imIconBuilder_;
        }

        @Override
        public boolean hasImIconWithLevel() {
            return (this.bitField0_ & 0x10000) != 0;
        }

        @Override
        public Image getImIconWithLevel() {
            if (this.imIconWithLevelBuilder_ == null) {
                return this.imIconWithLevel_ == null ? Image.getDefaultInstance() : this.imIconWithLevel_;
            }
            return this.imIconWithLevelBuilder_.getMessage();
        }

        public Builder setImIconWithLevel(Image value) {
            if (this.imIconWithLevelBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.imIconWithLevel_ = value;
            } else {
                this.imIconWithLevelBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x10000;
            this.onChanged();
            return this;
        }

        public Builder setImIconWithLevel(Image.Builder builderForValue) {
            if (this.imIconWithLevelBuilder_ == null) {
                this.imIconWithLevel_ = builderForValue.build();
            } else {
                this.imIconWithLevelBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x10000;
            this.onChanged();
            return this;
        }

        public Builder mergeImIconWithLevel(Image value) {
            if (this.imIconWithLevelBuilder_ == null) {
                if ((this.bitField0_ & 0x10000) != 0 && this.imIconWithLevel_ != null && this.imIconWithLevel_ != Image.getDefaultInstance()) {
                    this.getImIconWithLevelBuilder().mergeFrom(value);
                } else {
                    this.imIconWithLevel_ = value;
                }
            } else {
                this.imIconWithLevelBuilder_.mergeFrom(value);
            }
            if (this.imIconWithLevel_ != null) {
                this.bitField0_ |= 0x10000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearImIconWithLevel() {
            this.bitField0_ &= 0xFFFEFFFF;
            this.imIconWithLevel_ = null;
            if (this.imIconWithLevelBuilder_ != null) {
                this.imIconWithLevelBuilder_.dispose();
                this.imIconWithLevelBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getImIconWithLevelBuilder() {
            this.bitField0_ |= 0x10000;
            this.onChanged();
            return this.getImIconWithLevelFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getImIconWithLevelOrBuilder() {
            if (this.imIconWithLevelBuilder_ != null) {
                return this.imIconWithLevelBuilder_.getMessageOrBuilder();
            }
            return this.imIconWithLevel_ == null ? Image.getDefaultInstance() : this.imIconWithLevel_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getImIconWithLevelFieldBuilder() {
            if (this.imIconWithLevelBuilder_ == null) {
                this.imIconWithLevelBuilder_ = new SingleFieldBuilderV3(this.getImIconWithLevel(), this.getParentForChildren(), this.isClean());
                this.imIconWithLevel_ = null;
            }
            return this.imIconWithLevelBuilder_;
        }

        @Override
        public boolean hasLiveIcon() {
            return (this.bitField0_ & 0x20000) != 0;
        }

        @Override
        public Image getLiveIcon() {
            if (this.liveIconBuilder_ == null) {
                return this.liveIcon_ == null ? Image.getDefaultInstance() : this.liveIcon_;
            }
            return this.liveIconBuilder_.getMessage();
        }

        public Builder setLiveIcon(Image value) {
            if (this.liveIconBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.liveIcon_ = value;
            } else {
                this.liveIconBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x20000;
            this.onChanged();
            return this;
        }

        public Builder setLiveIcon(Image.Builder builderForValue) {
            if (this.liveIconBuilder_ == null) {
                this.liveIcon_ = builderForValue.build();
            } else {
                this.liveIconBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x20000;
            this.onChanged();
            return this;
        }

        public Builder mergeLiveIcon(Image value) {
            if (this.liveIconBuilder_ == null) {
                if ((this.bitField0_ & 0x20000) != 0 && this.liveIcon_ != null && this.liveIcon_ != Image.getDefaultInstance()) {
                    this.getLiveIconBuilder().mergeFrom(value);
                } else {
                    this.liveIcon_ = value;
                }
            } else {
                this.liveIconBuilder_.mergeFrom(value);
            }
            if (this.liveIcon_ != null) {
                this.bitField0_ |= 0x20000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearLiveIcon() {
            this.bitField0_ &= 0xFFFDFFFF;
            this.liveIcon_ = null;
            if (this.liveIconBuilder_ != null) {
                this.liveIconBuilder_.dispose();
                this.liveIconBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getLiveIconBuilder() {
            this.bitField0_ |= 0x20000;
            this.onChanged();
            return this.getLiveIconFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getLiveIconOrBuilder() {
            if (this.liveIconBuilder_ != null) {
                return this.liveIconBuilder_.getMessageOrBuilder();
            }
            return this.liveIcon_ == null ? Image.getDefaultInstance() : this.liveIcon_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getLiveIconFieldBuilder() {
            if (this.liveIconBuilder_ == null) {
                this.liveIconBuilder_ = new SingleFieldBuilderV3(this.getLiveIcon(), this.getParentForChildren(), this.isClean());
                this.liveIcon_ = null;
            }
            return this.liveIconBuilder_;
        }

        @Override
        public boolean hasNewImIconWithLevel() {
            return (this.bitField0_ & 0x40000) != 0;
        }

        @Override
        public Image getNewImIconWithLevel() {
            if (this.newImIconWithLevelBuilder_ == null) {
                return this.newImIconWithLevel_ == null ? Image.getDefaultInstance() : this.newImIconWithLevel_;
            }
            return this.newImIconWithLevelBuilder_.getMessage();
        }

        public Builder setNewImIconWithLevel(Image value) {
            if (this.newImIconWithLevelBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.newImIconWithLevel_ = value;
            } else {
                this.newImIconWithLevelBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x40000;
            this.onChanged();
            return this;
        }

        public Builder setNewImIconWithLevel(Image.Builder builderForValue) {
            if (this.newImIconWithLevelBuilder_ == null) {
                this.newImIconWithLevel_ = builderForValue.build();
            } else {
                this.newImIconWithLevelBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x40000;
            this.onChanged();
            return this;
        }

        public Builder mergeNewImIconWithLevel(Image value) {
            if (this.newImIconWithLevelBuilder_ == null) {
                if ((this.bitField0_ & 0x40000) != 0 && this.newImIconWithLevel_ != null && this.newImIconWithLevel_ != Image.getDefaultInstance()) {
                    this.getNewImIconWithLevelBuilder().mergeFrom(value);
                } else {
                    this.newImIconWithLevel_ = value;
                }
            } else {
                this.newImIconWithLevelBuilder_.mergeFrom(value);
            }
            if (this.newImIconWithLevel_ != null) {
                this.bitField0_ |= 0x40000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearNewImIconWithLevel() {
            this.bitField0_ &= 0xFFFBFFFF;
            this.newImIconWithLevel_ = null;
            if (this.newImIconWithLevelBuilder_ != null) {
                this.newImIconWithLevelBuilder_.dispose();
                this.newImIconWithLevelBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getNewImIconWithLevelBuilder() {
            this.bitField0_ |= 0x40000;
            this.onChanged();
            return this.getNewImIconWithLevelFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getNewImIconWithLevelOrBuilder() {
            if (this.newImIconWithLevelBuilder_ != null) {
                return this.newImIconWithLevelBuilder_.getMessageOrBuilder();
            }
            return this.newImIconWithLevel_ == null ? Image.getDefaultInstance() : this.newImIconWithLevel_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getNewImIconWithLevelFieldBuilder() {
            if (this.newImIconWithLevelBuilder_ == null) {
                this.newImIconWithLevelBuilder_ = new SingleFieldBuilderV3(this.getNewImIconWithLevel(), this.getParentForChildren(), this.isClean());
                this.newImIconWithLevel_ = null;
            }
            return this.newImIconWithLevelBuilder_;
        }

        @Override
        public boolean hasNewLiveIcon() {
            return (this.bitField0_ & 0x80000) != 0;
        }

        @Override
        public Image getNewLiveIcon() {
            if (this.newLiveIconBuilder_ == null) {
                return this.newLiveIcon_ == null ? Image.getDefaultInstance() : this.newLiveIcon_;
            }
            return this.newLiveIconBuilder_.getMessage();
        }

        public Builder setNewLiveIcon(Image value) {
            if (this.newLiveIconBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.newLiveIcon_ = value;
            } else {
                this.newLiveIconBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x80000;
            this.onChanged();
            return this;
        }

        public Builder setNewLiveIcon(Image.Builder builderForValue) {
            if (this.newLiveIconBuilder_ == null) {
                this.newLiveIcon_ = builderForValue.build();
            } else {
                this.newLiveIconBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x80000;
            this.onChanged();
            return this;
        }

        public Builder mergeNewLiveIcon(Image value) {
            if (this.newLiveIconBuilder_ == null) {
                if ((this.bitField0_ & 0x80000) != 0 && this.newLiveIcon_ != null && this.newLiveIcon_ != Image.getDefaultInstance()) {
                    this.getNewLiveIconBuilder().mergeFrom(value);
                } else {
                    this.newLiveIcon_ = value;
                }
            } else {
                this.newLiveIconBuilder_.mergeFrom(value);
            }
            if (this.newLiveIcon_ != null) {
                this.bitField0_ |= 0x80000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearNewLiveIcon() {
            this.bitField0_ &= 0xFFF7FFFF;
            this.newLiveIcon_ = null;
            if (this.newLiveIconBuilder_ != null) {
                this.newLiveIconBuilder_.dispose();
                this.newLiveIconBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getNewLiveIconBuilder() {
            this.bitField0_ |= 0x80000;
            this.onChanged();
            return this.getNewLiveIconFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getNewLiveIconOrBuilder() {
            if (this.newLiveIconBuilder_ != null) {
                return this.newLiveIconBuilder_.getMessageOrBuilder();
            }
            return this.newLiveIcon_ == null ? Image.getDefaultInstance() : this.newLiveIcon_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getNewLiveIconFieldBuilder() {
            if (this.newLiveIconBuilder_ == null) {
                this.newLiveIconBuilder_ = new SingleFieldBuilderV3(this.getNewLiveIcon(), this.getParentForChildren(), this.isClean());
                this.newLiveIcon_ = null;
            }
            return this.newLiveIconBuilder_;
        }

        @Override
        public long getUpgradeNeedConsume() {
            return this.upgradeNeedConsume_;
        }

        public Builder setUpgradeNeedConsume(long value) {
            this.upgradeNeedConsume_ = value;
            this.bitField0_ |= 0x100000;
            this.onChanged();
            return this;
        }

        public Builder clearUpgradeNeedConsume() {
            this.bitField0_ &= 0xFFEFFFFF;
            this.upgradeNeedConsume_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public String getNextPrivileges() {
            Object ref = this.nextPrivileges_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.nextPrivileges_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getNextPrivilegesBytes() {
            Object ref = this.nextPrivileges_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.nextPrivileges_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setNextPrivileges(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.nextPrivileges_ = value;
            this.bitField0_ |= 0x200000;
            this.onChanged();
            return this;
        }

        public Builder clearNextPrivileges() {
            this.nextPrivileges_ = PayGrade.getDefaultInstance().getNextPrivileges();
            this.bitField0_ &= 0xFFDFFFFF;
            this.onChanged();
            return this;
        }

        public Builder setNextPrivilegesBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PayGrade.checkByteStringIsUtf8(value);
            this.nextPrivileges_ = value;
            this.bitField0_ |= 0x200000;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasBackground() {
            return (this.bitField0_ & 0x400000) != 0;
        }

        @Override
        public Image getBackground() {
            if (this.backgroundBuilder_ == null) {
                return this.background_ == null ? Image.getDefaultInstance() : this.background_;
            }
            return this.backgroundBuilder_.getMessage();
        }

        public Builder setBackground(Image value) {
            if (this.backgroundBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.background_ = value;
            } else {
                this.backgroundBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x400000;
            this.onChanged();
            return this;
        }

        public Builder setBackground(Image.Builder builderForValue) {
            if (this.backgroundBuilder_ == null) {
                this.background_ = builderForValue.build();
            } else {
                this.backgroundBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x400000;
            this.onChanged();
            return this;
        }

        public Builder mergeBackground(Image value) {
            if (this.backgroundBuilder_ == null) {
                if ((this.bitField0_ & 0x400000) != 0 && this.background_ != null && this.background_ != Image.getDefaultInstance()) {
                    this.getBackgroundBuilder().mergeFrom(value);
                } else {
                    this.background_ = value;
                }
            } else {
                this.backgroundBuilder_.mergeFrom(value);
            }
            if (this.background_ != null) {
                this.bitField0_ |= 0x400000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearBackground() {
            this.bitField0_ &= 0xFFBFFFFF;
            this.background_ = null;
            if (this.backgroundBuilder_ != null) {
                this.backgroundBuilder_.dispose();
                this.backgroundBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getBackgroundBuilder() {
            this.bitField0_ |= 0x400000;
            this.onChanged();
            return this.getBackgroundFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getBackgroundOrBuilder() {
            if (this.backgroundBuilder_ != null) {
                return this.backgroundBuilder_.getMessageOrBuilder();
            }
            return this.background_ == null ? Image.getDefaultInstance() : this.background_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getBackgroundFieldBuilder() {
            if (this.backgroundBuilder_ == null) {
                this.backgroundBuilder_ = new SingleFieldBuilderV3(this.getBackground(), this.getParentForChildren(), this.isClean());
                this.background_ = null;
            }
            return this.backgroundBuilder_;
        }

        @Override
        public boolean hasBackgroundBack() {
            return (this.bitField0_ & 0x800000) != 0;
        }

        @Override
        public Image getBackgroundBack() {
            if (this.backgroundBackBuilder_ == null) {
                return this.backgroundBack_ == null ? Image.getDefaultInstance() : this.backgroundBack_;
            }
            return this.backgroundBackBuilder_.getMessage();
        }

        public Builder setBackgroundBack(Image value) {
            if (this.backgroundBackBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.backgroundBack_ = value;
            } else {
                this.backgroundBackBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x800000;
            this.onChanged();
            return this;
        }

        public Builder setBackgroundBack(Image.Builder builderForValue) {
            if (this.backgroundBackBuilder_ == null) {
                this.backgroundBack_ = builderForValue.build();
            } else {
                this.backgroundBackBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x800000;
            this.onChanged();
            return this;
        }

        public Builder mergeBackgroundBack(Image value) {
            if (this.backgroundBackBuilder_ == null) {
                if ((this.bitField0_ & 0x800000) != 0 && this.backgroundBack_ != null && this.backgroundBack_ != Image.getDefaultInstance()) {
                    this.getBackgroundBackBuilder().mergeFrom(value);
                } else {
                    this.backgroundBack_ = value;
                }
            } else {
                this.backgroundBackBuilder_.mergeFrom(value);
            }
            if (this.backgroundBack_ != null) {
                this.bitField0_ |= 0x800000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearBackgroundBack() {
            this.bitField0_ &= 0xFF7FFFFF;
            this.backgroundBack_ = null;
            if (this.backgroundBackBuilder_ != null) {
                this.backgroundBackBuilder_.dispose();
                this.backgroundBackBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getBackgroundBackBuilder() {
            this.bitField0_ |= 0x800000;
            this.onChanged();
            return this.getBackgroundBackFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getBackgroundBackOrBuilder() {
            if (this.backgroundBackBuilder_ != null) {
                return this.backgroundBackBuilder_.getMessageOrBuilder();
            }
            return this.backgroundBack_ == null ? Image.getDefaultInstance() : this.backgroundBack_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getBackgroundBackFieldBuilder() {
            if (this.backgroundBackBuilder_ == null) {
                this.backgroundBackBuilder_ = new SingleFieldBuilderV3(this.getBackgroundBack(), this.getParentForChildren(), this.isClean());
                this.backgroundBack_ = null;
            }
            return this.backgroundBackBuilder_;
        }

        @Override
        public long getScore() {
            return this.score_;
        }

        public Builder setScore(long value) {
            this.score_ = value;
            this.bitField0_ |= 0x1000000;
            this.onChanged();
            return this;
        }

        public Builder clearScore() {
            this.bitField0_ &= 0xFEFFFFFF;
            this.score_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasBuffInfo() {
            return (this.bitField0_ & 0x2000000) != 0;
        }

        @Override
        public GradeBuffInfo getBuffInfo() {
            if (this.buffInfoBuilder_ == null) {
                return this.buffInfo_ == null ? GradeBuffInfo.getDefaultInstance() : this.buffInfo_;
            }
            return this.buffInfoBuilder_.getMessage();
        }

        public Builder setBuffInfo(GradeBuffInfo value) {
            if (this.buffInfoBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.buffInfo_ = value;
            } else {
                this.buffInfoBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x2000000;
            this.onChanged();
            return this;
        }

        public Builder setBuffInfo(GradeBuffInfo.Builder builderForValue) {
            if (this.buffInfoBuilder_ == null) {
                this.buffInfo_ = builderForValue.build();
            } else {
                this.buffInfoBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x2000000;
            this.onChanged();
            return this;
        }

        public Builder mergeBuffInfo(GradeBuffInfo value) {
            if (this.buffInfoBuilder_ == null) {
                if ((this.bitField0_ & 0x2000000) != 0 && this.buffInfo_ != null && this.buffInfo_ != GradeBuffInfo.getDefaultInstance()) {
                    this.getBuffInfoBuilder().mergeFrom(value);
                } else {
                    this.buffInfo_ = value;
                }
            } else {
                this.buffInfoBuilder_.mergeFrom(value);
            }
            if (this.buffInfo_ != null) {
                this.bitField0_ |= 0x2000000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearBuffInfo() {
            this.bitField0_ &= 0xFDFFFFFF;
            this.buffInfo_ = null;
            if (this.buffInfoBuilder_ != null) {
                this.buffInfoBuilder_.dispose();
                this.buffInfoBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public GradeBuffInfo.Builder getBuffInfoBuilder() {
            this.bitField0_ |= 0x2000000;
            this.onChanged();
            return this.getBuffInfoFieldBuilder().getBuilder();
        }

        @Override
        public GradeBuffInfoOrBuilder getBuffInfoOrBuilder() {
            if (this.buffInfoBuilder_ != null) {
                return this.buffInfoBuilder_.getMessageOrBuilder();
            }
            return this.buffInfo_ == null ? GradeBuffInfo.getDefaultInstance() : this.buffInfo_;
        }

        private SingleFieldBuilderV3<GradeBuffInfo, GradeBuffInfo.Builder, GradeBuffInfoOrBuilder> getBuffInfoFieldBuilder() {
            if (this.buffInfoBuilder_ == null) {
                this.buffInfoBuilder_ = new SingleFieldBuilderV3(this.getBuffInfo(), this.getParentForChildren(), this.isClean());
                this.buffInfo_ = null;
            }
            return this.buffInfoBuilder_;
        }

        @Override
        public String getGradeBanner() {
            Object ref = this.gradeBanner_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.gradeBanner_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getGradeBannerBytes() {
            Object ref = this.gradeBanner_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.gradeBanner_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setGradeBanner(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.gradeBanner_ = value;
            this.bitField0_ |= 0x4000000;
            this.onChanged();
            return this;
        }

        public Builder clearGradeBanner() {
            this.gradeBanner_ = PayGrade.getDefaultInstance().getGradeBanner();
            this.bitField0_ &= 0xFBFFFFFF;
            this.onChanged();
            return this;
        }

        public Builder setGradeBannerBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            PayGrade.checkByteStringIsUtf8(value);
            this.gradeBanner_ = value;
            this.bitField0_ |= 0x4000000;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasProfileDialogBg() {
            return (this.bitField0_ & 0x8000000) != 0;
        }

        @Override
        public Image getProfileDialogBg() {
            if (this.profileDialogBgBuilder_ == null) {
                return this.profileDialogBg_ == null ? Image.getDefaultInstance() : this.profileDialogBg_;
            }
            return this.profileDialogBgBuilder_.getMessage();
        }

        public Builder setProfileDialogBg(Image value) {
            if (this.profileDialogBgBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.profileDialogBg_ = value;
            } else {
                this.profileDialogBgBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x8000000;
            this.onChanged();
            return this;
        }

        public Builder setProfileDialogBg(Image.Builder builderForValue) {
            if (this.profileDialogBgBuilder_ == null) {
                this.profileDialogBg_ = builderForValue.build();
            } else {
                this.profileDialogBgBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x8000000;
            this.onChanged();
            return this;
        }

        public Builder mergeProfileDialogBg(Image value) {
            if (this.profileDialogBgBuilder_ == null) {
                if ((this.bitField0_ & 0x8000000) != 0 && this.profileDialogBg_ != null && this.profileDialogBg_ != Image.getDefaultInstance()) {
                    this.getProfileDialogBgBuilder().mergeFrom(value);
                } else {
                    this.profileDialogBg_ = value;
                }
            } else {
                this.profileDialogBgBuilder_.mergeFrom(value);
            }
            if (this.profileDialogBg_ != null) {
                this.bitField0_ |= 0x8000000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearProfileDialogBg() {
            this.bitField0_ &= 0xF7FFFFFF;
            this.profileDialogBg_ = null;
            if (this.profileDialogBgBuilder_ != null) {
                this.profileDialogBgBuilder_.dispose();
                this.profileDialogBgBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getProfileDialogBgBuilder() {
            this.bitField0_ |= 0x8000000;
            this.onChanged();
            return this.getProfileDialogBgFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getProfileDialogBgOrBuilder() {
            if (this.profileDialogBgBuilder_ != null) {
                return this.profileDialogBgBuilder_.getMessageOrBuilder();
            }
            return this.profileDialogBg_ == null ? Image.getDefaultInstance() : this.profileDialogBg_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getProfileDialogBgFieldBuilder() {
            if (this.profileDialogBgBuilder_ == null) {
                this.profileDialogBgBuilder_ = new SingleFieldBuilderV3(this.getProfileDialogBg(), this.getParentForChildren(), this.isClean());
                this.profileDialogBg_ = null;
            }
            return this.profileDialogBgBuilder_;
        }

        @Override
        public boolean hasProfileDialogBgBack() {
            return (this.bitField0_ & 0x10000000) != 0;
        }

        @Override
        public Image getProfileDialogBgBack() {
            if (this.profileDialogBgBackBuilder_ == null) {
                return this.profileDialogBgBack_ == null ? Image.getDefaultInstance() : this.profileDialogBgBack_;
            }
            return this.profileDialogBgBackBuilder_.getMessage();
        }

        public Builder setProfileDialogBgBack(Image value) {
            if (this.profileDialogBgBackBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.profileDialogBgBack_ = value;
            } else {
                this.profileDialogBgBackBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x10000000;
            this.onChanged();
            return this;
        }

        public Builder setProfileDialogBgBack(Image.Builder builderForValue) {
            if (this.profileDialogBgBackBuilder_ == null) {
                this.profileDialogBgBack_ = builderForValue.build();
            } else {
                this.profileDialogBgBackBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x10000000;
            this.onChanged();
            return this;
        }

        public Builder mergeProfileDialogBgBack(Image value) {
            if (this.profileDialogBgBackBuilder_ == null) {
                if ((this.bitField0_ & 0x10000000) != 0 && this.profileDialogBgBack_ != null && this.profileDialogBgBack_ != Image.getDefaultInstance()) {
                    this.getProfileDialogBgBackBuilder().mergeFrom(value);
                } else {
                    this.profileDialogBgBack_ = value;
                }
            } else {
                this.profileDialogBgBackBuilder_.mergeFrom(value);
            }
            if (this.profileDialogBgBack_ != null) {
                this.bitField0_ |= 0x10000000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearProfileDialogBgBack() {
            this.bitField0_ &= 0xEFFFFFFF;
            this.profileDialogBgBack_ = null;
            if (this.profileDialogBgBackBuilder_ != null) {
                this.profileDialogBgBackBuilder_.dispose();
                this.profileDialogBgBackBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Image.Builder getProfileDialogBgBackBuilder() {
            this.bitField0_ |= 0x10000000;
            this.onChanged();
            return this.getProfileDialogBgBackFieldBuilder().getBuilder();
        }

        @Override
        public ImageOrBuilder getProfileDialogBgBackOrBuilder() {
            if (this.profileDialogBgBackBuilder_ != null) {
                return this.profileDialogBgBackBuilder_.getMessageOrBuilder();
            }
            return this.profileDialogBgBack_ == null ? Image.getDefaultInstance() : this.profileDialogBgBack_;
        }

        private SingleFieldBuilderV3<Image, Image.Builder, ImageOrBuilder> getProfileDialogBgBackFieldBuilder() {
            if (this.profileDialogBgBackBuilder_ == null) {
                this.profileDialogBgBackBuilder_ = new SingleFieldBuilderV3(this.getProfileDialogBgBack(), this.getParentForChildren(), this.isClean());
                this.profileDialogBgBack_ = null;
            }
            return this.profileDialogBgBackBuilder_;
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


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Iterable
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.nio.ByteBuffer
 *  java.util.Collection
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
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Common;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.CommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Douyin;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GiftIMPriority;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GiftIMPriorityOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GiftMessageOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GiftStruct;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GiftStructOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommon;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.PublicAreaCommonOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Text;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextEffect;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextEffectOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.TextOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.User;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.UserOrBuilder;

public final class GiftMessage
extends GeneratedMessageV3
implements GiftMessageOrBuilder {
    private static final long serialVersionUID = 0L;
    private int bitField0_;
    public static final int COMMON_FIELD_NUMBER = 1;
    private Common common_;
    public static final int GIFTID_FIELD_NUMBER = 2;
    private long giftId_ = 0L;
    public static final int FANTICKETCOUNT_FIELD_NUMBER = 3;
    private long fanTicketCount_ = 0L;
    public static final int GROUPCOUNT_FIELD_NUMBER = 4;
    private long groupCount_ = 0L;
    public static final int REPEATCOUNT_FIELD_NUMBER = 5;
    private long repeatCount_ = 0L;
    public static final int COMBOCOUNT_FIELD_NUMBER = 6;
    private long comboCount_ = 0L;
    public static final int USER_FIELD_NUMBER = 7;
    private User user_;
    public static final int TOUSER_FIELD_NUMBER = 8;
    private User toUser_;
    public static final int REPEATEND_FIELD_NUMBER = 9;
    private int repeatEnd_ = 0;
    public static final int TEXTEFFECT_FIELD_NUMBER = 10;
    private TextEffect textEffect_;
    public static final int GROUPID_FIELD_NUMBER = 11;
    private long groupId_ = 0L;
    public static final int INCOMETASKGIFTS_FIELD_NUMBER = 12;
    private long incomeTaskgifts_ = 0L;
    public static final int ROOMFANTICKETCOUNT_FIELD_NUMBER = 13;
    private long roomFanTicketCount_ = 0L;
    public static final int PRIORITY_FIELD_NUMBER = 14;
    private GiftIMPriority priority_;
    public static final int GIFT_FIELD_NUMBER = 15;
    private GiftStruct gift_;
    public static final int LOGID_FIELD_NUMBER = 16;
    private volatile Object logId_ = "";
    public static final int SENDTYPE_FIELD_NUMBER = 17;
    private long sendType_ = 0L;
    public static final int PUBLICAREACOMMON_FIELD_NUMBER = 18;
    private PublicAreaCommon publicAreaCommon_;
    public static final int TRAYDISPLAYTEXT_FIELD_NUMBER = 19;
    private Text trayDisplayText_;
    public static final int BANNEDDISPLAYEFFECTS_FIELD_NUMBER = 20;
    private long bannedDisplayEffects_ = 0L;
    public static final int DISPLAYFORSELF_FIELD_NUMBER = 25;
    private boolean displayForSelf_ = false;
    public static final int INTERACTGIFTINFO_FIELD_NUMBER = 26;
    private volatile Object interactGiftInfo_ = "";
    public static final int DIYITEMINFO_FIELD_NUMBER = 27;
    private volatile Object diyItemInfo_ = "";
    public static final int MINASSETSETLIST_FIELD_NUMBER = 28;
    private Internal.LongList minAssetSetList_ = GiftMessage.emptyLongList();
    private int minAssetSetListMemoizedSerializedSize = -1;
    public static final int TOTALCOUNT_FIELD_NUMBER = 29;
    private long totalCount_ = 0L;
    public static final int CLIENTGIFTSOURCE_FIELD_NUMBER = 30;
    private int clientGiftSource_ = 0;
    public static final int TOUSERIDSLIST_FIELD_NUMBER = 32;
    private Internal.LongList toUserIdsList_ = GiftMessage.emptyLongList();
    private int toUserIdsListMemoizedSerializedSize = -1;
    public static final int SENDTIME_FIELD_NUMBER = 33;
    private long sendTime_ = 0L;
    public static final int FORCEDISPLAYEFFECTS_FIELD_NUMBER = 34;
    private long forceDisplayEffects_ = 0L;
    public static final int TRACEID_FIELD_NUMBER = 35;
    private volatile Object traceId_ = "";
    public static final int EFFECTDISPLAYTS_FIELD_NUMBER = 36;
    private long effectDisplayTs_ = 0L;
    private byte memoizedIsInitialized = (byte)-1;
    private static final GiftMessage DEFAULT_INSTANCE = new GiftMessage();
    private static final Parser<GiftMessage> PARSER = new AbstractParser<GiftMessage>(){

        @Override
        public GiftMessage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            Builder builder = GiftMessage.newBuilder();
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

    private GiftMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private GiftMessage() {
        this.logId_ = "";
        this.interactGiftInfo_ = "";
        this.diyItemInfo_ = "";
        this.minAssetSetList_ = GiftMessage.emptyLongList();
        this.toUserIdsList_ = GiftMessage.emptyLongList();
        this.traceId_ = "";
    }

    @Override
    protected Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
        return new GiftMessage();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Douyin.internal_static_GiftMessage_descriptor;
    }

    @Override
    protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return Douyin.internal_static_GiftMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftMessage.class, Builder.class);
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
    public long getGiftId() {
        return this.giftId_;
    }

    @Override
    public long getFanTicketCount() {
        return this.fanTicketCount_;
    }

    @Override
    public long getGroupCount() {
        return this.groupCount_;
    }

    @Override
    public long getRepeatCount() {
        return this.repeatCount_;
    }

    @Override
    public long getComboCount() {
        return this.comboCount_;
    }

    @Override
    public boolean hasUser() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override
    public User getUser() {
        return this.user_ == null ? User.getDefaultInstance() : this.user_;
    }

    @Override
    public UserOrBuilder getUserOrBuilder() {
        return this.user_ == null ? User.getDefaultInstance() : this.user_;
    }

    @Override
    public boolean hasToUser() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override
    public User getToUser() {
        return this.toUser_ == null ? User.getDefaultInstance() : this.toUser_;
    }

    @Override
    public UserOrBuilder getToUserOrBuilder() {
        return this.toUser_ == null ? User.getDefaultInstance() : this.toUser_;
    }

    @Override
    public int getRepeatEnd() {
        return this.repeatEnd_;
    }

    @Override
    public boolean hasTextEffect() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override
    public TextEffect getTextEffect() {
        return this.textEffect_ == null ? TextEffect.getDefaultInstance() : this.textEffect_;
    }

    @Override
    public TextEffectOrBuilder getTextEffectOrBuilder() {
        return this.textEffect_ == null ? TextEffect.getDefaultInstance() : this.textEffect_;
    }

    @Override
    public long getGroupId() {
        return this.groupId_;
    }

    @Override
    public long getIncomeTaskgifts() {
        return this.incomeTaskgifts_;
    }

    @Override
    public long getRoomFanTicketCount() {
        return this.roomFanTicketCount_;
    }

    @Override
    public boolean hasPriority() {
        return (this.bitField0_ & 0x10) != 0;
    }

    @Override
    public GiftIMPriority getPriority() {
        return this.priority_ == null ? GiftIMPriority.getDefaultInstance() : this.priority_;
    }

    @Override
    public GiftIMPriorityOrBuilder getPriorityOrBuilder() {
        return this.priority_ == null ? GiftIMPriority.getDefaultInstance() : this.priority_;
    }

    @Override
    public boolean hasGift() {
        return (this.bitField0_ & 0x20) != 0;
    }

    @Override
    public GiftStruct getGift() {
        return this.gift_ == null ? GiftStruct.getDefaultInstance() : this.gift_;
    }

    @Override
    public GiftStructOrBuilder getGiftOrBuilder() {
        return this.gift_ == null ? GiftStruct.getDefaultInstance() : this.gift_;
    }

    @Override
    public String getLogId() {
        Object ref = this.logId_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.logId_ = s;
        return s;
    }

    @Override
    public ByteString getLogIdBytes() {
        Object ref = this.logId_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.logId_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getSendType() {
        return this.sendType_;
    }

    @Override
    public boolean hasPublicAreaCommon() {
        return (this.bitField0_ & 0x40) != 0;
    }

    @Override
    public PublicAreaCommon getPublicAreaCommon() {
        return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
    }

    @Override
    public PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder() {
        return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
    }

    @Override
    public boolean hasTrayDisplayText() {
        return (this.bitField0_ & 0x80) != 0;
    }

    @Override
    public Text getTrayDisplayText() {
        return this.trayDisplayText_ == null ? Text.getDefaultInstance() : this.trayDisplayText_;
    }

    @Override
    public TextOrBuilder getTrayDisplayTextOrBuilder() {
        return this.trayDisplayText_ == null ? Text.getDefaultInstance() : this.trayDisplayText_;
    }

    @Override
    public long getBannedDisplayEffects() {
        return this.bannedDisplayEffects_;
    }

    @Override
    public boolean getDisplayForSelf() {
        return this.displayForSelf_;
    }

    @Override
    public String getInteractGiftInfo() {
        Object ref = this.interactGiftInfo_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.interactGiftInfo_ = s;
        return s;
    }

    @Override
    public ByteString getInteractGiftInfoBytes() {
        Object ref = this.interactGiftInfo_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.interactGiftInfo_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public String getDiyItemInfo() {
        Object ref = this.diyItemInfo_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.diyItemInfo_ = s;
        return s;
    }

    @Override
    public ByteString getDiyItemInfoBytes() {
        Object ref = this.diyItemInfo_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.diyItemInfo_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public List<Long> getMinAssetSetListList() {
        return this.minAssetSetList_;
    }

    @Override
    public int getMinAssetSetListCount() {
        return this.minAssetSetList_.size();
    }

    @Override
    public long getMinAssetSetList(int index) {
        return this.minAssetSetList_.getLong(index);
    }

    @Override
    public long getTotalCount() {
        return this.totalCount_;
    }

    @Override
    public int getClientGiftSource() {
        return this.clientGiftSource_;
    }

    @Override
    public List<Long> getToUserIdsListList() {
        return this.toUserIdsList_;
    }

    @Override
    public int getToUserIdsListCount() {
        return this.toUserIdsList_.size();
    }

    @Override
    public long getToUserIdsList(int index) {
        return this.toUserIdsList_.getLong(index);
    }

    @Override
    public long getSendTime() {
        return this.sendTime_;
    }

    @Override
    public long getForceDisplayEffects() {
        return this.forceDisplayEffects_;
    }

    @Override
    public String getTraceId() {
        Object ref = this.traceId_;
        if (ref instanceof String) {
            return (String)ref;
        }
        ByteString bs = (ByteString)ref;
        String s = bs.toStringUtf8();
        this.traceId_ = s;
        return s;
    }

    @Override
    public ByteString getTraceIdBytes() {
        Object ref = this.traceId_;
        if (ref instanceof String) {
            ByteString b = ByteString.copyFromUtf8((String)ref);
            this.traceId_ = b;
            return b;
        }
        return (ByteString)ref;
    }

    @Override
    public long getEffectDisplayTs() {
        return this.effectDisplayTs_;
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
        int i;
        this.getSerializedSize();
        if ((this.bitField0_ & 1) != 0) {
            output.writeMessage(1, this.getCommon());
        }
        if (this.giftId_ != 0L) {
            output.writeUInt64(2, this.giftId_);
        }
        if (this.fanTicketCount_ != 0L) {
            output.writeUInt64(3, this.fanTicketCount_);
        }
        if (this.groupCount_ != 0L) {
            output.writeUInt64(4, this.groupCount_);
        }
        if (this.repeatCount_ != 0L) {
            output.writeUInt64(5, this.repeatCount_);
        }
        if (this.comboCount_ != 0L) {
            output.writeUInt64(6, this.comboCount_);
        }
        if ((this.bitField0_ & 2) != 0) {
            output.writeMessage(7, this.getUser());
        }
        if ((this.bitField0_ & 4) != 0) {
            output.writeMessage(8, this.getToUser());
        }
        if (this.repeatEnd_ != 0) {
            output.writeUInt32(9, this.repeatEnd_);
        }
        if ((this.bitField0_ & 8) != 0) {
            output.writeMessage(10, this.getTextEffect());
        }
        if (this.groupId_ != 0L) {
            output.writeUInt64(11, this.groupId_);
        }
        if (this.incomeTaskgifts_ != 0L) {
            output.writeUInt64(12, this.incomeTaskgifts_);
        }
        if (this.roomFanTicketCount_ != 0L) {
            output.writeUInt64(13, this.roomFanTicketCount_);
        }
        if ((this.bitField0_ & 0x10) != 0) {
            output.writeMessage(14, this.getPriority());
        }
        if ((this.bitField0_ & 0x20) != 0) {
            output.writeMessage(15, this.getGift());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.logId_)) {
            GeneratedMessageV3.writeString(output, 16, this.logId_);
        }
        if (this.sendType_ != 0L) {
            output.writeUInt64(17, this.sendType_);
        }
        if ((this.bitField0_ & 0x40) != 0) {
            output.writeMessage(18, this.getPublicAreaCommon());
        }
        if ((this.bitField0_ & 0x80) != 0) {
            output.writeMessage(19, this.getTrayDisplayText());
        }
        if (this.bannedDisplayEffects_ != 0L) {
            output.writeUInt64(20, this.bannedDisplayEffects_);
        }
        if (this.displayForSelf_) {
            output.writeBool(25, this.displayForSelf_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.interactGiftInfo_)) {
            GeneratedMessageV3.writeString(output, 26, this.interactGiftInfo_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.diyItemInfo_)) {
            GeneratedMessageV3.writeString(output, 27, this.diyItemInfo_);
        }
        if (this.getMinAssetSetListList().size() > 0) {
            output.writeUInt32NoTag(226);
            output.writeUInt32NoTag(this.minAssetSetListMemoizedSerializedSize);
        }
        for (i = 0; i < this.minAssetSetList_.size(); ++i) {
            output.writeUInt64NoTag(this.minAssetSetList_.getLong(i));
        }
        if (this.totalCount_ != 0L) {
            output.writeUInt64(29, this.totalCount_);
        }
        if (this.clientGiftSource_ != 0) {
            output.writeUInt32(30, this.clientGiftSource_);
        }
        if (this.getToUserIdsListList().size() > 0) {
            output.writeUInt32NoTag(258);
            output.writeUInt32NoTag(this.toUserIdsListMemoizedSerializedSize);
        }
        for (i = 0; i < this.toUserIdsList_.size(); ++i) {
            output.writeUInt64NoTag(this.toUserIdsList_.getLong(i));
        }
        if (this.sendTime_ != 0L) {
            output.writeUInt64(33, this.sendTime_);
        }
        if (this.forceDisplayEffects_ != 0L) {
            output.writeUInt64(34, this.forceDisplayEffects_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.traceId_)) {
            GeneratedMessageV3.writeString(output, 35, this.traceId_);
        }
        if (this.effectDisplayTs_ != 0L) {
            output.writeUInt64(36, this.effectDisplayTs_);
        }
        this.getUnknownFields().writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int i;
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        size = 0;
        if ((this.bitField0_ & 1) != 0) {
            size += CodedOutputStream.computeMessageSize(1, this.getCommon());
        }
        if (this.giftId_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(2, this.giftId_);
        }
        if (this.fanTicketCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(3, this.fanTicketCount_);
        }
        if (this.groupCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(4, this.groupCount_);
        }
        if (this.repeatCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(5, this.repeatCount_);
        }
        if (this.comboCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(6, this.comboCount_);
        }
        if ((this.bitField0_ & 2) != 0) {
            size += CodedOutputStream.computeMessageSize(7, this.getUser());
        }
        if ((this.bitField0_ & 4) != 0) {
            size += CodedOutputStream.computeMessageSize(8, this.getToUser());
        }
        if (this.repeatEnd_ != 0) {
            size += CodedOutputStream.computeUInt32Size(9, this.repeatEnd_);
        }
        if ((this.bitField0_ & 8) != 0) {
            size += CodedOutputStream.computeMessageSize(10, this.getTextEffect());
        }
        if (this.groupId_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(11, this.groupId_);
        }
        if (this.incomeTaskgifts_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(12, this.incomeTaskgifts_);
        }
        if (this.roomFanTicketCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(13, this.roomFanTicketCount_);
        }
        if ((this.bitField0_ & 0x10) != 0) {
            size += CodedOutputStream.computeMessageSize(14, this.getPriority());
        }
        if ((this.bitField0_ & 0x20) != 0) {
            size += CodedOutputStream.computeMessageSize(15, this.getGift());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.logId_)) {
            size += GeneratedMessageV3.computeStringSize(16, this.logId_);
        }
        if (this.sendType_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(17, this.sendType_);
        }
        if ((this.bitField0_ & 0x40) != 0) {
            size += CodedOutputStream.computeMessageSize(18, this.getPublicAreaCommon());
        }
        if ((this.bitField0_ & 0x80) != 0) {
            size += CodedOutputStream.computeMessageSize(19, this.getTrayDisplayText());
        }
        if (this.bannedDisplayEffects_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(20, this.bannedDisplayEffects_);
        }
        if (this.displayForSelf_) {
            size += CodedOutputStream.computeBoolSize(25, this.displayForSelf_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.interactGiftInfo_)) {
            size += GeneratedMessageV3.computeStringSize(26, this.interactGiftInfo_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.diyItemInfo_)) {
            size += GeneratedMessageV3.computeStringSize(27, this.diyItemInfo_);
        }
        int dataSize = 0;
        for (i = 0; i < this.minAssetSetList_.size(); ++i) {
            dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.minAssetSetList_.getLong(i));
        }
        size += dataSize;
        if (!this.getMinAssetSetListList().isEmpty()) {
            size += 2;
            size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        this.minAssetSetListMemoizedSerializedSize = dataSize;
        if (this.totalCount_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(29, this.totalCount_);
        }
        if (this.clientGiftSource_ != 0) {
            size += CodedOutputStream.computeUInt32Size(30, this.clientGiftSource_);
        }
        dataSize = 0;
        for (i = 0; i < this.toUserIdsList_.size(); ++i) {
            dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.toUserIdsList_.getLong(i));
        }
        size += dataSize;
        if (!this.getToUserIdsListList().isEmpty()) {
            size += 2;
            size += CodedOutputStream.computeInt32SizeNoTag(dataSize);
        }
        this.toUserIdsListMemoizedSerializedSize = dataSize;
        if (this.sendTime_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(33, this.sendTime_);
        }
        if (this.forceDisplayEffects_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(34, this.forceDisplayEffects_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.traceId_)) {
            size += GeneratedMessageV3.computeStringSize(35, this.traceId_);
        }
        if (this.effectDisplayTs_ != 0L) {
            size += CodedOutputStream.computeUInt64Size(36, this.effectDisplayTs_);
        }
        this.memoizedSize = size += this.getUnknownFields().getSerializedSize();
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftMessage)) {
            return super.equals(obj);
        }
        GiftMessage other = (GiftMessage)obj;
        if (this.hasCommon() != other.hasCommon()) {
            return false;
        }
        if (this.hasCommon() && !this.getCommon().equals(other.getCommon())) {
            return false;
        }
        if (this.getGiftId() != other.getGiftId()) {
            return false;
        }
        if (this.getFanTicketCount() != other.getFanTicketCount()) {
            return false;
        }
        if (this.getGroupCount() != other.getGroupCount()) {
            return false;
        }
        if (this.getRepeatCount() != other.getRepeatCount()) {
            return false;
        }
        if (this.getComboCount() != other.getComboCount()) {
            return false;
        }
        if (this.hasUser() != other.hasUser()) {
            return false;
        }
        if (this.hasUser() && !this.getUser().equals(other.getUser())) {
            return false;
        }
        if (this.hasToUser() != other.hasToUser()) {
            return false;
        }
        if (this.hasToUser() && !this.getToUser().equals(other.getToUser())) {
            return false;
        }
        if (this.getRepeatEnd() != other.getRepeatEnd()) {
            return false;
        }
        if (this.hasTextEffect() != other.hasTextEffect()) {
            return false;
        }
        if (this.hasTextEffect() && !this.getTextEffect().equals(other.getTextEffect())) {
            return false;
        }
        if (this.getGroupId() != other.getGroupId()) {
            return false;
        }
        if (this.getIncomeTaskgifts() != other.getIncomeTaskgifts()) {
            return false;
        }
        if (this.getRoomFanTicketCount() != other.getRoomFanTicketCount()) {
            return false;
        }
        if (this.hasPriority() != other.hasPriority()) {
            return false;
        }
        if (this.hasPriority() && !this.getPriority().equals(other.getPriority())) {
            return false;
        }
        if (this.hasGift() != other.hasGift()) {
            return false;
        }
        if (this.hasGift() && !this.getGift().equals(other.getGift())) {
            return false;
        }
        if (!this.getLogId().equals((Object)other.getLogId())) {
            return false;
        }
        if (this.getSendType() != other.getSendType()) {
            return false;
        }
        if (this.hasPublicAreaCommon() != other.hasPublicAreaCommon()) {
            return false;
        }
        if (this.hasPublicAreaCommon() && !this.getPublicAreaCommon().equals(other.getPublicAreaCommon())) {
            return false;
        }
        if (this.hasTrayDisplayText() != other.hasTrayDisplayText()) {
            return false;
        }
        if (this.hasTrayDisplayText() && !this.getTrayDisplayText().equals(other.getTrayDisplayText())) {
            return false;
        }
        if (this.getBannedDisplayEffects() != other.getBannedDisplayEffects()) {
            return false;
        }
        if (this.getDisplayForSelf() != other.getDisplayForSelf()) {
            return false;
        }
        if (!this.getInteractGiftInfo().equals((Object)other.getInteractGiftInfo())) {
            return false;
        }
        if (!this.getDiyItemInfo().equals((Object)other.getDiyItemInfo())) {
            return false;
        }
        if (!this.getMinAssetSetListList().equals(other.getMinAssetSetListList())) {
            return false;
        }
        if (this.getTotalCount() != other.getTotalCount()) {
            return false;
        }
        if (this.getClientGiftSource() != other.getClientGiftSource()) {
            return false;
        }
        if (!this.getToUserIdsListList().equals(other.getToUserIdsListList())) {
            return false;
        }
        if (this.getSendTime() != other.getSendTime()) {
            return false;
        }
        if (this.getForceDisplayEffects() != other.getForceDisplayEffects()) {
            return false;
        }
        if (!this.getTraceId().equals((Object)other.getTraceId())) {
            return false;
        }
        if (this.getEffectDisplayTs() != other.getEffectDisplayTs()) {
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
        hash = 19 * hash + GiftMessage.getDescriptor().hashCode();
        if (this.hasCommon()) {
            hash = 37 * hash + 1;
            hash = 53 * hash + this.getCommon().hashCode();
        }
        hash = 37 * hash + 2;
        hash = 53 * hash + Internal.hashLong(this.getGiftId());
        hash = 37 * hash + 3;
        hash = 53 * hash + Internal.hashLong(this.getFanTicketCount());
        hash = 37 * hash + 4;
        hash = 53 * hash + Internal.hashLong(this.getGroupCount());
        hash = 37 * hash + 5;
        hash = 53 * hash + Internal.hashLong(this.getRepeatCount());
        hash = 37 * hash + 6;
        hash = 53 * hash + Internal.hashLong(this.getComboCount());
        if (this.hasUser()) {
            hash = 37 * hash + 7;
            hash = 53 * hash + this.getUser().hashCode();
        }
        if (this.hasToUser()) {
            hash = 37 * hash + 8;
            hash = 53 * hash + this.getToUser().hashCode();
        }
        hash = 37 * hash + 9;
        hash = 53 * hash + this.getRepeatEnd();
        if (this.hasTextEffect()) {
            hash = 37 * hash + 10;
            hash = 53 * hash + this.getTextEffect().hashCode();
        }
        hash = 37 * hash + 11;
        hash = 53 * hash + Internal.hashLong(this.getGroupId());
        hash = 37 * hash + 12;
        hash = 53 * hash + Internal.hashLong(this.getIncomeTaskgifts());
        hash = 37 * hash + 13;
        hash = 53 * hash + Internal.hashLong(this.getRoomFanTicketCount());
        if (this.hasPriority()) {
            hash = 37 * hash + 14;
            hash = 53 * hash + this.getPriority().hashCode();
        }
        if (this.hasGift()) {
            hash = 37 * hash + 15;
            hash = 53 * hash + this.getGift().hashCode();
        }
        hash = 37 * hash + 16;
        hash = 53 * hash + this.getLogId().hashCode();
        hash = 37 * hash + 17;
        hash = 53 * hash + Internal.hashLong(this.getSendType());
        if (this.hasPublicAreaCommon()) {
            hash = 37 * hash + 18;
            hash = 53 * hash + this.getPublicAreaCommon().hashCode();
        }
        if (this.hasTrayDisplayText()) {
            hash = 37 * hash + 19;
            hash = 53 * hash + this.getTrayDisplayText().hashCode();
        }
        hash = 37 * hash + 20;
        hash = 53 * hash + Internal.hashLong(this.getBannedDisplayEffects());
        hash = 37 * hash + 25;
        hash = 53 * hash + Internal.hashBoolean(this.getDisplayForSelf());
        hash = 37 * hash + 26;
        hash = 53 * hash + this.getInteractGiftInfo().hashCode();
        hash = 37 * hash + 27;
        hash = 53 * hash + this.getDiyItemInfo().hashCode();
        if (this.getMinAssetSetListCount() > 0) {
            hash = 37 * hash + 28;
            hash = 53 * hash + this.getMinAssetSetListList().hashCode();
        }
        hash = 37 * hash + 29;
        hash = 53 * hash + Internal.hashLong(this.getTotalCount());
        hash = 37 * hash + 30;
        hash = 53 * hash + this.getClientGiftSource();
        if (this.getToUserIdsListCount() > 0) {
            hash = 37 * hash + 32;
            hash = 53 * hash + this.getToUserIdsListList().hashCode();
        }
        hash = 37 * hash + 33;
        hash = 53 * hash + Internal.hashLong(this.getSendTime());
        hash = 37 * hash + 34;
        hash = 53 * hash + Internal.hashLong(this.getForceDisplayEffects());
        hash = 37 * hash + 35;
        hash = 53 * hash + this.getTraceId().hashCode();
        hash = 37 * hash + 36;
        hash = 53 * hash + Internal.hashLong(this.getEffectDisplayTs());
        this.memoizedHashCode = hash = 29 * hash + this.getUnknownFields().hashCode();
        return hash;
    }

    public static GiftMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static GiftMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static GiftMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static GiftMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static GiftMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static GiftMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static GiftMessage parseFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static GiftMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static GiftMessage parseDelimitedFrom(InputStream input) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
    }

    public static GiftMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static GiftMessage parseFrom(CodedInputStream input) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input);
    }

    public static GiftMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return GiftMessage.newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GiftMessage prototype) {
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

    public static GiftMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<GiftMessage> parser() {
        return PARSER;
    }

    public Parser<GiftMessage> getParserForType() {
        return PARSER;
    }

    @Override
    public GiftMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    static /* synthetic */ Internal.LongList access$4100() {
        return GiftMessage.emptyLongList();
    }

    static /* synthetic */ Internal.LongList access$4400() {
        return GiftMessage.emptyLongList();
    }

    public static final class Builder
    extends GeneratedMessageV3.Builder<Builder>
    implements GiftMessageOrBuilder {
        private int bitField0_;
        private Common common_;
        private SingleFieldBuilderV3<Common, Common.Builder, CommonOrBuilder> commonBuilder_;
        private long giftId_;
        private long fanTicketCount_;
        private long groupCount_;
        private long repeatCount_;
        private long comboCount_;
        private User user_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> userBuilder_;
        private User toUser_;
        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> toUserBuilder_;
        private int repeatEnd_;
        private TextEffect textEffect_;
        private SingleFieldBuilderV3<TextEffect, TextEffect.Builder, TextEffectOrBuilder> textEffectBuilder_;
        private long groupId_;
        private long incomeTaskgifts_;
        private long roomFanTicketCount_;
        private GiftIMPriority priority_;
        private SingleFieldBuilderV3<GiftIMPriority, GiftIMPriority.Builder, GiftIMPriorityOrBuilder> priorityBuilder_;
        private GiftStruct gift_;
        private SingleFieldBuilderV3<GiftStruct, GiftStruct.Builder, GiftStructOrBuilder> giftBuilder_;
        private Object logId_ = "";
        private long sendType_;
        private PublicAreaCommon publicAreaCommon_;
        private SingleFieldBuilderV3<PublicAreaCommon, PublicAreaCommon.Builder, PublicAreaCommonOrBuilder> publicAreaCommonBuilder_;
        private Text trayDisplayText_;
        private SingleFieldBuilderV3<Text, Text.Builder, TextOrBuilder> trayDisplayTextBuilder_;
        private long bannedDisplayEffects_;
        private boolean displayForSelf_;
        private Object interactGiftInfo_ = "";
        private Object diyItemInfo_ = "";
        private Internal.LongList minAssetSetList_ = GiftMessage.access$4100();
        private long totalCount_;
        private int clientGiftSource_;
        private Internal.LongList toUserIdsList_ = GiftMessage.access$4400();
        private long sendTime_;
        private long forceDisplayEffects_;
        private Object traceId_ = "";
        private long effectDisplayTs_;

        public static final Descriptors.Descriptor getDescriptor() {
            return Douyin.internal_static_GiftMessage_descriptor;
        }

        @Override
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Douyin.internal_static_GiftMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(GiftMessage.class, Builder.class);
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
                this.getUserFieldBuilder();
                this.getToUserFieldBuilder();
                this.getTextEffectFieldBuilder();
                this.getPriorityFieldBuilder();
                this.getGiftFieldBuilder();
                this.getPublicAreaCommonFieldBuilder();
                this.getTrayDisplayTextFieldBuilder();
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
            this.giftId_ = 0L;
            this.fanTicketCount_ = 0L;
            this.groupCount_ = 0L;
            this.repeatCount_ = 0L;
            this.comboCount_ = 0L;
            this.user_ = null;
            if (this.userBuilder_ != null) {
                this.userBuilder_.dispose();
                this.userBuilder_ = null;
            }
            this.toUser_ = null;
            if (this.toUserBuilder_ != null) {
                this.toUserBuilder_.dispose();
                this.toUserBuilder_ = null;
            }
            this.repeatEnd_ = 0;
            this.textEffect_ = null;
            if (this.textEffectBuilder_ != null) {
                this.textEffectBuilder_.dispose();
                this.textEffectBuilder_ = null;
            }
            this.groupId_ = 0L;
            this.incomeTaskgifts_ = 0L;
            this.roomFanTicketCount_ = 0L;
            this.priority_ = null;
            if (this.priorityBuilder_ != null) {
                this.priorityBuilder_.dispose();
                this.priorityBuilder_ = null;
            }
            this.gift_ = null;
            if (this.giftBuilder_ != null) {
                this.giftBuilder_.dispose();
                this.giftBuilder_ = null;
            }
            this.logId_ = "";
            this.sendType_ = 0L;
            this.publicAreaCommon_ = null;
            if (this.publicAreaCommonBuilder_ != null) {
                this.publicAreaCommonBuilder_.dispose();
                this.publicAreaCommonBuilder_ = null;
            }
            this.trayDisplayText_ = null;
            if (this.trayDisplayTextBuilder_ != null) {
                this.trayDisplayTextBuilder_.dispose();
                this.trayDisplayTextBuilder_ = null;
            }
            this.bannedDisplayEffects_ = 0L;
            this.displayForSelf_ = false;
            this.interactGiftInfo_ = "";
            this.diyItemInfo_ = "";
            this.minAssetSetList_ = GiftMessage.emptyLongList();
            this.totalCount_ = 0L;
            this.clientGiftSource_ = 0;
            this.toUserIdsList_ = GiftMessage.emptyLongList();
            this.sendTime_ = 0L;
            this.forceDisplayEffects_ = 0L;
            this.traceId_ = "";
            this.effectDisplayTs_ = 0L;
            return this;
        }

        @Override
        public Descriptors.Descriptor getDescriptorForType() {
            return Douyin.internal_static_GiftMessage_descriptor;
        }

        @Override
        public GiftMessage getDefaultInstanceForType() {
            return GiftMessage.getDefaultInstance();
        }

        @Override
        public GiftMessage build() {
            GiftMessage result = this.buildPartial();
            if (!result.isInitialized()) {
                throw Builder.newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public GiftMessage buildPartial() {
            GiftMessage result = new GiftMessage(this);
            if (this.bitField0_ != 0) {
                this.buildPartial0(result);
            }
            this.onBuilt();
            return result;
        }

        private void buildPartial0(GiftMessage result) {
            int from_bitField0_ = this.bitField0_;
            int to_bitField0_ = 0;
            if ((from_bitField0_ & 1) != 0) {
                result.common_ = this.commonBuilder_ == null ? this.common_ : this.commonBuilder_.build();
                to_bitField0_ |= 1;
            }
            if ((from_bitField0_ & 2) != 0) {
                result.giftId_ = this.giftId_;
            }
            if ((from_bitField0_ & 4) != 0) {
                result.fanTicketCount_ = this.fanTicketCount_;
            }
            if ((from_bitField0_ & 8) != 0) {
                result.groupCount_ = this.groupCount_;
            }
            if ((from_bitField0_ & 0x10) != 0) {
                result.repeatCount_ = this.repeatCount_;
            }
            if ((from_bitField0_ & 0x20) != 0) {
                result.comboCount_ = this.comboCount_;
            }
            if ((from_bitField0_ & 0x40) != 0) {
                result.user_ = this.userBuilder_ == null ? this.user_ : this.userBuilder_.build();
                to_bitField0_ |= 2;
            }
            if ((from_bitField0_ & 0x80) != 0) {
                result.toUser_ = this.toUserBuilder_ == null ? this.toUser_ : this.toUserBuilder_.build();
                to_bitField0_ |= 4;
            }
            if ((from_bitField0_ & 0x100) != 0) {
                result.repeatEnd_ = this.repeatEnd_;
            }
            if ((from_bitField0_ & 0x200) != 0) {
                result.textEffect_ = this.textEffectBuilder_ == null ? this.textEffect_ : this.textEffectBuilder_.build();
                to_bitField0_ |= 8;
            }
            if ((from_bitField0_ & 0x400) != 0) {
                result.groupId_ = this.groupId_;
            }
            if ((from_bitField0_ & 0x800) != 0) {
                result.incomeTaskgifts_ = this.incomeTaskgifts_;
            }
            if ((from_bitField0_ & 0x1000) != 0) {
                result.roomFanTicketCount_ = this.roomFanTicketCount_;
            }
            if ((from_bitField0_ & 0x2000) != 0) {
                result.priority_ = this.priorityBuilder_ == null ? this.priority_ : this.priorityBuilder_.build();
                to_bitField0_ |= 0x10;
            }
            if ((from_bitField0_ & 0x4000) != 0) {
                result.gift_ = this.giftBuilder_ == null ? this.gift_ : this.giftBuilder_.build();
                to_bitField0_ |= 0x20;
            }
            if ((from_bitField0_ & 0x8000) != 0) {
                result.logId_ = this.logId_;
            }
            if ((from_bitField0_ & 0x10000) != 0) {
                result.sendType_ = this.sendType_;
            }
            if ((from_bitField0_ & 0x20000) != 0) {
                result.publicAreaCommon_ = this.publicAreaCommonBuilder_ == null ? this.publicAreaCommon_ : this.publicAreaCommonBuilder_.build();
                to_bitField0_ |= 0x40;
            }
            if ((from_bitField0_ & 0x40000) != 0) {
                result.trayDisplayText_ = this.trayDisplayTextBuilder_ == null ? this.trayDisplayText_ : this.trayDisplayTextBuilder_.build();
                to_bitField0_ |= 0x80;
            }
            if ((from_bitField0_ & 0x80000) != 0) {
                result.bannedDisplayEffects_ = this.bannedDisplayEffects_;
            }
            if ((from_bitField0_ & 0x100000) != 0) {
                result.displayForSelf_ = this.displayForSelf_;
            }
            if ((from_bitField0_ & 0x200000) != 0) {
                result.interactGiftInfo_ = this.interactGiftInfo_;
            }
            if ((from_bitField0_ & 0x400000) != 0) {
                result.diyItemInfo_ = this.diyItemInfo_;
            }
            if ((from_bitField0_ & 0x800000) != 0) {
                this.minAssetSetList_.makeImmutable();
                result.minAssetSetList_ = this.minAssetSetList_;
            }
            if ((from_bitField0_ & 0x1000000) != 0) {
                result.totalCount_ = this.totalCount_;
            }
            if ((from_bitField0_ & 0x2000000) != 0) {
                result.clientGiftSource_ = this.clientGiftSource_;
            }
            if ((from_bitField0_ & 0x4000000) != 0) {
                this.toUserIdsList_.makeImmutable();
                result.toUserIdsList_ = this.toUserIdsList_;
            }
            if ((from_bitField0_ & 0x8000000) != 0) {
                result.sendTime_ = this.sendTime_;
            }
            if ((from_bitField0_ & 0x10000000) != 0) {
                result.forceDisplayEffects_ = this.forceDisplayEffects_;
            }
            if ((from_bitField0_ & 0x20000000) != 0) {
                result.traceId_ = this.traceId_;
            }
            if ((from_bitField0_ & 0x40000000) != 0) {
                result.effectDisplayTs_ = this.effectDisplayTs_;
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
            if (other instanceof GiftMessage) {
                return this.mergeFrom((GiftMessage)other);
            }
            super.mergeFrom(other);
            return this;
        }

        public Builder mergeFrom(GiftMessage other) {
            if (other == GiftMessage.getDefaultInstance()) {
                return this;
            }
            if (other.hasCommon()) {
                this.mergeCommon(other.getCommon());
            }
            if (other.getGiftId() != 0L) {
                this.setGiftId(other.getGiftId());
            }
            if (other.getFanTicketCount() != 0L) {
                this.setFanTicketCount(other.getFanTicketCount());
            }
            if (other.getGroupCount() != 0L) {
                this.setGroupCount(other.getGroupCount());
            }
            if (other.getRepeatCount() != 0L) {
                this.setRepeatCount(other.getRepeatCount());
            }
            if (other.getComboCount() != 0L) {
                this.setComboCount(other.getComboCount());
            }
            if (other.hasUser()) {
                this.mergeUser(other.getUser());
            }
            if (other.hasToUser()) {
                this.mergeToUser(other.getToUser());
            }
            if (other.getRepeatEnd() != 0) {
                this.setRepeatEnd(other.getRepeatEnd());
            }
            if (other.hasTextEffect()) {
                this.mergeTextEffect(other.getTextEffect());
            }
            if (other.getGroupId() != 0L) {
                this.setGroupId(other.getGroupId());
            }
            if (other.getIncomeTaskgifts() != 0L) {
                this.setIncomeTaskgifts(other.getIncomeTaskgifts());
            }
            if (other.getRoomFanTicketCount() != 0L) {
                this.setRoomFanTicketCount(other.getRoomFanTicketCount());
            }
            if (other.hasPriority()) {
                this.mergePriority(other.getPriority());
            }
            if (other.hasGift()) {
                this.mergeGift(other.getGift());
            }
            if (!other.getLogId().isEmpty()) {
                this.logId_ = other.logId_;
                this.bitField0_ |= 0x8000;
                this.onChanged();
            }
            if (other.getSendType() != 0L) {
                this.setSendType(other.getSendType());
            }
            if (other.hasPublicAreaCommon()) {
                this.mergePublicAreaCommon(other.getPublicAreaCommon());
            }
            if (other.hasTrayDisplayText()) {
                this.mergeTrayDisplayText(other.getTrayDisplayText());
            }
            if (other.getBannedDisplayEffects() != 0L) {
                this.setBannedDisplayEffects(other.getBannedDisplayEffects());
            }
            if (other.getDisplayForSelf()) {
                this.setDisplayForSelf(other.getDisplayForSelf());
            }
            if (!other.getInteractGiftInfo().isEmpty()) {
                this.interactGiftInfo_ = other.interactGiftInfo_;
                this.bitField0_ |= 0x200000;
                this.onChanged();
            }
            if (!other.getDiyItemInfo().isEmpty()) {
                this.diyItemInfo_ = other.diyItemInfo_;
                this.bitField0_ |= 0x400000;
                this.onChanged();
            }
            if (!other.minAssetSetList_.isEmpty()) {
                if (this.minAssetSetList_.isEmpty()) {
                    this.minAssetSetList_ = other.minAssetSetList_;
                    this.minAssetSetList_.makeImmutable();
                    this.bitField0_ |= 0x800000;
                } else {
                    this.ensureMinAssetSetListIsMutable();
                    this.minAssetSetList_.addAll((Collection)other.minAssetSetList_);
                }
                this.onChanged();
            }
            if (other.getTotalCount() != 0L) {
                this.setTotalCount(other.getTotalCount());
            }
            if (other.getClientGiftSource() != 0) {
                this.setClientGiftSource(other.getClientGiftSource());
            }
            if (!other.toUserIdsList_.isEmpty()) {
                if (this.toUserIdsList_.isEmpty()) {
                    this.toUserIdsList_ = other.toUserIdsList_;
                    this.toUserIdsList_.makeImmutable();
                    this.bitField0_ |= 0x4000000;
                } else {
                    this.ensureToUserIdsListIsMutable();
                    this.toUserIdsList_.addAll((Collection)other.toUserIdsList_);
                }
                this.onChanged();
            }
            if (other.getSendTime() != 0L) {
                this.setSendTime(other.getSendTime());
            }
            if (other.getForceDisplayEffects() != 0L) {
                this.setForceDisplayEffects(other.getForceDisplayEffects());
            }
            if (!other.getTraceId().isEmpty()) {
                this.traceId_ = other.traceId_;
                this.bitField0_ |= 0x20000000;
                this.onChanged();
            }
            if (other.getEffectDisplayTs() != 0L) {
                this.setEffectDisplayTs(other.getEffectDisplayTs());
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
                block41: while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0: {
                            done = true;
                            continue block41;
                        }
                        case 10: {
                            input.readMessage(this.getCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 1;
                            continue block41;
                        }
                        case 16: {
                            this.giftId_ = input.readUInt64();
                            this.bitField0_ |= 2;
                            continue block41;
                        }
                        case 24: {
                            this.fanTicketCount_ = input.readUInt64();
                            this.bitField0_ |= 4;
                            continue block41;
                        }
                        case 32: {
                            this.groupCount_ = input.readUInt64();
                            this.bitField0_ |= 8;
                            continue block41;
                        }
                        case 40: {
                            this.repeatCount_ = input.readUInt64();
                            this.bitField0_ |= 0x10;
                            continue block41;
                        }
                        case 48: {
                            this.comboCount_ = input.readUInt64();
                            this.bitField0_ |= 0x20;
                            continue block41;
                        }
                        case 58: {
                            input.readMessage(this.getUserFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x40;
                            continue block41;
                        }
                        case 66: {
                            input.readMessage(this.getToUserFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x80;
                            continue block41;
                        }
                        case 72: {
                            this.repeatEnd_ = input.readUInt32();
                            this.bitField0_ |= 0x100;
                            continue block41;
                        }
                        case 82: {
                            input.readMessage(this.getTextEffectFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x200;
                            continue block41;
                        }
                        case 88: {
                            this.groupId_ = input.readUInt64();
                            this.bitField0_ |= 0x400;
                            continue block41;
                        }
                        case 96: {
                            this.incomeTaskgifts_ = input.readUInt64();
                            this.bitField0_ |= 0x800;
                            continue block41;
                        }
                        case 104: {
                            this.roomFanTicketCount_ = input.readUInt64();
                            this.bitField0_ |= 0x1000;
                            continue block41;
                        }
                        case 114: {
                            input.readMessage(this.getPriorityFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x2000;
                            continue block41;
                        }
                        case 122: {
                            input.readMessage(this.getGiftFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x4000;
                            continue block41;
                        }
                        case 130: {
                            this.logId_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x8000;
                            continue block41;
                        }
                        case 136: {
                            this.sendType_ = input.readUInt64();
                            this.bitField0_ |= 0x10000;
                            continue block41;
                        }
                        case 146: {
                            input.readMessage(this.getPublicAreaCommonFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x20000;
                            continue block41;
                        }
                        case 154: {
                            input.readMessage(this.getTrayDisplayTextFieldBuilder().getBuilder(), extensionRegistry);
                            this.bitField0_ |= 0x40000;
                            continue block41;
                        }
                        case 160: {
                            this.bannedDisplayEffects_ = input.readUInt64();
                            this.bitField0_ |= 0x80000;
                            continue block41;
                        }
                        case 200: {
                            this.displayForSelf_ = input.readBool();
                            this.bitField0_ |= 0x100000;
                            continue block41;
                        }
                        case 210: {
                            this.interactGiftInfo_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x200000;
                            continue block41;
                        }
                        case 218: {
                            this.diyItemInfo_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x400000;
                            continue block41;
                        }
                        case 224: {
                            long v = input.readUInt64();
                            this.ensureMinAssetSetListIsMutable();
                            this.minAssetSetList_.addLong(v);
                            continue block41;
                        }
                        case 226: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            this.ensureMinAssetSetListIsMutable();
                            while (input.getBytesUntilLimit() > 0) {
                                this.minAssetSetList_.addLong(input.readUInt64());
                            }
                            input.popLimit(limit);
                            continue block41;
                        }
                        case 232: {
                            this.totalCount_ = input.readUInt64();
                            this.bitField0_ |= 0x1000000;
                            continue block41;
                        }
                        case 240: {
                            this.clientGiftSource_ = input.readUInt32();
                            this.bitField0_ |= 0x2000000;
                            continue block41;
                        }
                        case 256: {
                            long v = input.readUInt64();
                            this.ensureToUserIdsListIsMutable();
                            this.toUserIdsList_.addLong(v);
                            continue block41;
                        }
                        case 258: {
                            int length = input.readRawVarint32();
                            int limit = input.pushLimit(length);
                            this.ensureToUserIdsListIsMutable();
                            while (input.getBytesUntilLimit() > 0) {
                                this.toUserIdsList_.addLong(input.readUInt64());
                            }
                            input.popLimit(limit);
                            continue block41;
                        }
                        case 264: {
                            this.sendTime_ = input.readUInt64();
                            this.bitField0_ |= 0x8000000;
                            continue block41;
                        }
                        case 272: {
                            this.forceDisplayEffects_ = input.readUInt64();
                            this.bitField0_ |= 0x10000000;
                            continue block41;
                        }
                        case 282: {
                            this.traceId_ = input.readStringRequireUtf8();
                            this.bitField0_ |= 0x20000000;
                            continue block41;
                        }
                        case 288: {
                            this.effectDisplayTs_ = input.readUInt64();
                            this.bitField0_ |= 0x40000000;
                            continue block41;
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
        public long getGiftId() {
            return this.giftId_;
        }

        public Builder setGiftId(long value) {
            this.giftId_ = value;
            this.bitField0_ |= 2;
            this.onChanged();
            return this;
        }

        public Builder clearGiftId() {
            this.bitField0_ &= 0xFFFFFFFD;
            this.giftId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getFanTicketCount() {
            return this.fanTicketCount_;
        }

        public Builder setFanTicketCount(long value) {
            this.fanTicketCount_ = value;
            this.bitField0_ |= 4;
            this.onChanged();
            return this;
        }

        public Builder clearFanTicketCount() {
            this.bitField0_ &= 0xFFFFFFFB;
            this.fanTicketCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getGroupCount() {
            return this.groupCount_;
        }

        public Builder setGroupCount(long value) {
            this.groupCount_ = value;
            this.bitField0_ |= 8;
            this.onChanged();
            return this;
        }

        public Builder clearGroupCount() {
            this.bitField0_ &= 0xFFFFFFF7;
            this.groupCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getRepeatCount() {
            return this.repeatCount_;
        }

        public Builder setRepeatCount(long value) {
            this.repeatCount_ = value;
            this.bitField0_ |= 0x10;
            this.onChanged();
            return this;
        }

        public Builder clearRepeatCount() {
            this.bitField0_ &= 0xFFFFFFEF;
            this.repeatCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getComboCount() {
            return this.comboCount_;
        }

        public Builder setComboCount(long value) {
            this.comboCount_ = value;
            this.bitField0_ |= 0x20;
            this.onChanged();
            return this;
        }

        public Builder clearComboCount() {
            this.bitField0_ &= 0xFFFFFFDF;
            this.comboCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasUser() {
            return (this.bitField0_ & 0x40) != 0;
        }

        @Override
        public User getUser() {
            if (this.userBuilder_ == null) {
                return this.user_ == null ? User.getDefaultInstance() : this.user_;
            }
            return this.userBuilder_.getMessage();
        }

        public Builder setUser(User value) {
            if (this.userBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.user_ = value;
            } else {
                this.userBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder setUser(User.Builder builderForValue) {
            if (this.userBuilder_ == null) {
                this.user_ = builderForValue.build();
            } else {
                this.userBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this;
        }

        public Builder mergeUser(User value) {
            if (this.userBuilder_ == null) {
                if ((this.bitField0_ & 0x40) != 0 && this.user_ != null && this.user_ != User.getDefaultInstance()) {
                    this.getUserBuilder().mergeFrom(value);
                } else {
                    this.user_ = value;
                }
            } else {
                this.userBuilder_.mergeFrom(value);
            }
            if (this.user_ != null) {
                this.bitField0_ |= 0x40;
                this.onChanged();
            }
            return this;
        }

        public Builder clearUser() {
            this.bitField0_ &= 0xFFFFFFBF;
            this.user_ = null;
            if (this.userBuilder_ != null) {
                this.userBuilder_.dispose();
                this.userBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public User.Builder getUserBuilder() {
            this.bitField0_ |= 0x40;
            this.onChanged();
            return this.getUserFieldBuilder().getBuilder();
        }

        @Override
        public UserOrBuilder getUserOrBuilder() {
            if (this.userBuilder_ != null) {
                return this.userBuilder_.getMessageOrBuilder();
            }
            return this.user_ == null ? User.getDefaultInstance() : this.user_;
        }

        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> getUserFieldBuilder() {
            if (this.userBuilder_ == null) {
                this.userBuilder_ = new SingleFieldBuilderV3(this.getUser(), this.getParentForChildren(), this.isClean());
                this.user_ = null;
            }
            return this.userBuilder_;
        }

        @Override
        public boolean hasToUser() {
            return (this.bitField0_ & 0x80) != 0;
        }

        @Override
        public User getToUser() {
            if (this.toUserBuilder_ == null) {
                return this.toUser_ == null ? User.getDefaultInstance() : this.toUser_;
            }
            return this.toUserBuilder_.getMessage();
        }

        public Builder setToUser(User value) {
            if (this.toUserBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.toUser_ = value;
            } else {
                this.toUserBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder setToUser(User.Builder builderForValue) {
            if (this.toUserBuilder_ == null) {
                this.toUser_ = builderForValue.build();
            } else {
                this.toUserBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this;
        }

        public Builder mergeToUser(User value) {
            if (this.toUserBuilder_ == null) {
                if ((this.bitField0_ & 0x80) != 0 && this.toUser_ != null && this.toUser_ != User.getDefaultInstance()) {
                    this.getToUserBuilder().mergeFrom(value);
                } else {
                    this.toUser_ = value;
                }
            } else {
                this.toUserBuilder_.mergeFrom(value);
            }
            if (this.toUser_ != null) {
                this.bitField0_ |= 0x80;
                this.onChanged();
            }
            return this;
        }

        public Builder clearToUser() {
            this.bitField0_ &= 0xFFFFFF7F;
            this.toUser_ = null;
            if (this.toUserBuilder_ != null) {
                this.toUserBuilder_.dispose();
                this.toUserBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public User.Builder getToUserBuilder() {
            this.bitField0_ |= 0x80;
            this.onChanged();
            return this.getToUserFieldBuilder().getBuilder();
        }

        @Override
        public UserOrBuilder getToUserOrBuilder() {
            if (this.toUserBuilder_ != null) {
                return this.toUserBuilder_.getMessageOrBuilder();
            }
            return this.toUser_ == null ? User.getDefaultInstance() : this.toUser_;
        }

        private SingleFieldBuilderV3<User, User.Builder, UserOrBuilder> getToUserFieldBuilder() {
            if (this.toUserBuilder_ == null) {
                this.toUserBuilder_ = new SingleFieldBuilderV3(this.getToUser(), this.getParentForChildren(), this.isClean());
                this.toUser_ = null;
            }
            return this.toUserBuilder_;
        }

        @Override
        public int getRepeatEnd() {
            return this.repeatEnd_;
        }

        public Builder setRepeatEnd(int value) {
            this.repeatEnd_ = value;
            this.bitField0_ |= 0x100;
            this.onChanged();
            return this;
        }

        public Builder clearRepeatEnd() {
            this.bitField0_ &= 0xFFFFFEFF;
            this.repeatEnd_ = 0;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasTextEffect() {
            return (this.bitField0_ & 0x200) != 0;
        }

        @Override
        public TextEffect getTextEffect() {
            if (this.textEffectBuilder_ == null) {
                return this.textEffect_ == null ? TextEffect.getDefaultInstance() : this.textEffect_;
            }
            return this.textEffectBuilder_.getMessage();
        }

        public Builder setTextEffect(TextEffect value) {
            if (this.textEffectBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.textEffect_ = value;
            } else {
                this.textEffectBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder setTextEffect(TextEffect.Builder builderForValue) {
            if (this.textEffectBuilder_ == null) {
                this.textEffect_ = builderForValue.build();
            } else {
                this.textEffectBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this;
        }

        public Builder mergeTextEffect(TextEffect value) {
            if (this.textEffectBuilder_ == null) {
                if ((this.bitField0_ & 0x200) != 0 && this.textEffect_ != null && this.textEffect_ != TextEffect.getDefaultInstance()) {
                    this.getTextEffectBuilder().mergeFrom(value);
                } else {
                    this.textEffect_ = value;
                }
            } else {
                this.textEffectBuilder_.mergeFrom(value);
            }
            if (this.textEffect_ != null) {
                this.bitField0_ |= 0x200;
                this.onChanged();
            }
            return this;
        }

        public Builder clearTextEffect() {
            this.bitField0_ &= 0xFFFFFDFF;
            this.textEffect_ = null;
            if (this.textEffectBuilder_ != null) {
                this.textEffectBuilder_.dispose();
                this.textEffectBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public TextEffect.Builder getTextEffectBuilder() {
            this.bitField0_ |= 0x200;
            this.onChanged();
            return this.getTextEffectFieldBuilder().getBuilder();
        }

        @Override
        public TextEffectOrBuilder getTextEffectOrBuilder() {
            if (this.textEffectBuilder_ != null) {
                return this.textEffectBuilder_.getMessageOrBuilder();
            }
            return this.textEffect_ == null ? TextEffect.getDefaultInstance() : this.textEffect_;
        }

        private SingleFieldBuilderV3<TextEffect, TextEffect.Builder, TextEffectOrBuilder> getTextEffectFieldBuilder() {
            if (this.textEffectBuilder_ == null) {
                this.textEffectBuilder_ = new SingleFieldBuilderV3(this.getTextEffect(), this.getParentForChildren(), this.isClean());
                this.textEffect_ = null;
            }
            return this.textEffectBuilder_;
        }

        @Override
        public long getGroupId() {
            return this.groupId_;
        }

        public Builder setGroupId(long value) {
            this.groupId_ = value;
            this.bitField0_ |= 0x400;
            this.onChanged();
            return this;
        }

        public Builder clearGroupId() {
            this.bitField0_ &= 0xFFFFFBFF;
            this.groupId_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getIncomeTaskgifts() {
            return this.incomeTaskgifts_;
        }

        public Builder setIncomeTaskgifts(long value) {
            this.incomeTaskgifts_ = value;
            this.bitField0_ |= 0x800;
            this.onChanged();
            return this;
        }

        public Builder clearIncomeTaskgifts() {
            this.bitField0_ &= 0xFFFFF7FF;
            this.incomeTaskgifts_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getRoomFanTicketCount() {
            return this.roomFanTicketCount_;
        }

        public Builder setRoomFanTicketCount(long value) {
            this.roomFanTicketCount_ = value;
            this.bitField0_ |= 0x1000;
            this.onChanged();
            return this;
        }

        public Builder clearRoomFanTicketCount() {
            this.bitField0_ &= 0xFFFFEFFF;
            this.roomFanTicketCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasPriority() {
            return (this.bitField0_ & 0x2000) != 0;
        }

        @Override
        public GiftIMPriority getPriority() {
            if (this.priorityBuilder_ == null) {
                return this.priority_ == null ? GiftIMPriority.getDefaultInstance() : this.priority_;
            }
            return this.priorityBuilder_.getMessage();
        }

        public Builder setPriority(GiftIMPriority value) {
            if (this.priorityBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.priority_ = value;
            } else {
                this.priorityBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x2000;
            this.onChanged();
            return this;
        }

        public Builder setPriority(GiftIMPriority.Builder builderForValue) {
            if (this.priorityBuilder_ == null) {
                this.priority_ = builderForValue.build();
            } else {
                this.priorityBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x2000;
            this.onChanged();
            return this;
        }

        public Builder mergePriority(GiftIMPriority value) {
            if (this.priorityBuilder_ == null) {
                if ((this.bitField0_ & 0x2000) != 0 && this.priority_ != null && this.priority_ != GiftIMPriority.getDefaultInstance()) {
                    this.getPriorityBuilder().mergeFrom(value);
                } else {
                    this.priority_ = value;
                }
            } else {
                this.priorityBuilder_.mergeFrom(value);
            }
            if (this.priority_ != null) {
                this.bitField0_ |= 0x2000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearPriority() {
            this.bitField0_ &= 0xFFFFDFFF;
            this.priority_ = null;
            if (this.priorityBuilder_ != null) {
                this.priorityBuilder_.dispose();
                this.priorityBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public GiftIMPriority.Builder getPriorityBuilder() {
            this.bitField0_ |= 0x2000;
            this.onChanged();
            return this.getPriorityFieldBuilder().getBuilder();
        }

        @Override
        public GiftIMPriorityOrBuilder getPriorityOrBuilder() {
            if (this.priorityBuilder_ != null) {
                return this.priorityBuilder_.getMessageOrBuilder();
            }
            return this.priority_ == null ? GiftIMPriority.getDefaultInstance() : this.priority_;
        }

        private SingleFieldBuilderV3<GiftIMPriority, GiftIMPriority.Builder, GiftIMPriorityOrBuilder> getPriorityFieldBuilder() {
            if (this.priorityBuilder_ == null) {
                this.priorityBuilder_ = new SingleFieldBuilderV3(this.getPriority(), this.getParentForChildren(), this.isClean());
                this.priority_ = null;
            }
            return this.priorityBuilder_;
        }

        @Override
        public boolean hasGift() {
            return (this.bitField0_ & 0x4000) != 0;
        }

        @Override
        public GiftStruct getGift() {
            if (this.giftBuilder_ == null) {
                return this.gift_ == null ? GiftStruct.getDefaultInstance() : this.gift_;
            }
            return this.giftBuilder_.getMessage();
        }

        public Builder setGift(GiftStruct value) {
            if (this.giftBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gift_ = value;
            } else {
                this.giftBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x4000;
            this.onChanged();
            return this;
        }

        public Builder setGift(GiftStruct.Builder builderForValue) {
            if (this.giftBuilder_ == null) {
                this.gift_ = builderForValue.build();
            } else {
                this.giftBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x4000;
            this.onChanged();
            return this;
        }

        public Builder mergeGift(GiftStruct value) {
            if (this.giftBuilder_ == null) {
                if ((this.bitField0_ & 0x4000) != 0 && this.gift_ != null && this.gift_ != GiftStruct.getDefaultInstance()) {
                    this.getGiftBuilder().mergeFrom(value);
                } else {
                    this.gift_ = value;
                }
            } else {
                this.giftBuilder_.mergeFrom(value);
            }
            if (this.gift_ != null) {
                this.bitField0_ |= 0x4000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearGift() {
            this.bitField0_ &= 0xFFFFBFFF;
            this.gift_ = null;
            if (this.giftBuilder_ != null) {
                this.giftBuilder_.dispose();
                this.giftBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public GiftStruct.Builder getGiftBuilder() {
            this.bitField0_ |= 0x4000;
            this.onChanged();
            return this.getGiftFieldBuilder().getBuilder();
        }

        @Override
        public GiftStructOrBuilder getGiftOrBuilder() {
            if (this.giftBuilder_ != null) {
                return this.giftBuilder_.getMessageOrBuilder();
            }
            return this.gift_ == null ? GiftStruct.getDefaultInstance() : this.gift_;
        }

        private SingleFieldBuilderV3<GiftStruct, GiftStruct.Builder, GiftStructOrBuilder> getGiftFieldBuilder() {
            if (this.giftBuilder_ == null) {
                this.giftBuilder_ = new SingleFieldBuilderV3(this.getGift(), this.getParentForChildren(), this.isClean());
                this.gift_ = null;
            }
            return this.giftBuilder_;
        }

        @Override
        public String getLogId() {
            Object ref = this.logId_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.logId_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getLogIdBytes() {
            Object ref = this.logId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.logId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setLogId(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.logId_ = value;
            this.bitField0_ |= 0x8000;
            this.onChanged();
            return this;
        }

        public Builder clearLogId() {
            this.logId_ = GiftMessage.getDefaultInstance().getLogId();
            this.bitField0_ &= 0xFFFF7FFF;
            this.onChanged();
            return this;
        }

        public Builder setLogIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            GiftMessage.checkByteStringIsUtf8(value);
            this.logId_ = value;
            this.bitField0_ |= 0x8000;
            this.onChanged();
            return this;
        }

        @Override
        public long getSendType() {
            return this.sendType_;
        }

        public Builder setSendType(long value) {
            this.sendType_ = value;
            this.bitField0_ |= 0x10000;
            this.onChanged();
            return this;
        }

        public Builder clearSendType() {
            this.bitField0_ &= 0xFFFEFFFF;
            this.sendType_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean hasPublicAreaCommon() {
            return (this.bitField0_ & 0x20000) != 0;
        }

        @Override
        public PublicAreaCommon getPublicAreaCommon() {
            if (this.publicAreaCommonBuilder_ == null) {
                return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
            }
            return this.publicAreaCommonBuilder_.getMessage();
        }

        public Builder setPublicAreaCommon(PublicAreaCommon value) {
            if (this.publicAreaCommonBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.publicAreaCommon_ = value;
            } else {
                this.publicAreaCommonBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x20000;
            this.onChanged();
            return this;
        }

        public Builder setPublicAreaCommon(PublicAreaCommon.Builder builderForValue) {
            if (this.publicAreaCommonBuilder_ == null) {
                this.publicAreaCommon_ = builderForValue.build();
            } else {
                this.publicAreaCommonBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x20000;
            this.onChanged();
            return this;
        }

        public Builder mergePublicAreaCommon(PublicAreaCommon value) {
            if (this.publicAreaCommonBuilder_ == null) {
                if ((this.bitField0_ & 0x20000) != 0 && this.publicAreaCommon_ != null && this.publicAreaCommon_ != PublicAreaCommon.getDefaultInstance()) {
                    this.getPublicAreaCommonBuilder().mergeFrom(value);
                } else {
                    this.publicAreaCommon_ = value;
                }
            } else {
                this.publicAreaCommonBuilder_.mergeFrom(value);
            }
            if (this.publicAreaCommon_ != null) {
                this.bitField0_ |= 0x20000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearPublicAreaCommon() {
            this.bitField0_ &= 0xFFFDFFFF;
            this.publicAreaCommon_ = null;
            if (this.publicAreaCommonBuilder_ != null) {
                this.publicAreaCommonBuilder_.dispose();
                this.publicAreaCommonBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public PublicAreaCommon.Builder getPublicAreaCommonBuilder() {
            this.bitField0_ |= 0x20000;
            this.onChanged();
            return this.getPublicAreaCommonFieldBuilder().getBuilder();
        }

        @Override
        public PublicAreaCommonOrBuilder getPublicAreaCommonOrBuilder() {
            if (this.publicAreaCommonBuilder_ != null) {
                return this.publicAreaCommonBuilder_.getMessageOrBuilder();
            }
            return this.publicAreaCommon_ == null ? PublicAreaCommon.getDefaultInstance() : this.publicAreaCommon_;
        }

        private SingleFieldBuilderV3<PublicAreaCommon, PublicAreaCommon.Builder, PublicAreaCommonOrBuilder> getPublicAreaCommonFieldBuilder() {
            if (this.publicAreaCommonBuilder_ == null) {
                this.publicAreaCommonBuilder_ = new SingleFieldBuilderV3(this.getPublicAreaCommon(), this.getParentForChildren(), this.isClean());
                this.publicAreaCommon_ = null;
            }
            return this.publicAreaCommonBuilder_;
        }

        @Override
        public boolean hasTrayDisplayText() {
            return (this.bitField0_ & 0x40000) != 0;
        }

        @Override
        public Text getTrayDisplayText() {
            if (this.trayDisplayTextBuilder_ == null) {
                return this.trayDisplayText_ == null ? Text.getDefaultInstance() : this.trayDisplayText_;
            }
            return this.trayDisplayTextBuilder_.getMessage();
        }

        public Builder setTrayDisplayText(Text value) {
            if (this.trayDisplayTextBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.trayDisplayText_ = value;
            } else {
                this.trayDisplayTextBuilder_.setMessage(value);
            }
            this.bitField0_ |= 0x40000;
            this.onChanged();
            return this;
        }

        public Builder setTrayDisplayText(Text.Builder builderForValue) {
            if (this.trayDisplayTextBuilder_ == null) {
                this.trayDisplayText_ = builderForValue.build();
            } else {
                this.trayDisplayTextBuilder_.setMessage(builderForValue.build());
            }
            this.bitField0_ |= 0x40000;
            this.onChanged();
            return this;
        }

        public Builder mergeTrayDisplayText(Text value) {
            if (this.trayDisplayTextBuilder_ == null) {
                if ((this.bitField0_ & 0x40000) != 0 && this.trayDisplayText_ != null && this.trayDisplayText_ != Text.getDefaultInstance()) {
                    this.getTrayDisplayTextBuilder().mergeFrom(value);
                } else {
                    this.trayDisplayText_ = value;
                }
            } else {
                this.trayDisplayTextBuilder_.mergeFrom(value);
            }
            if (this.trayDisplayText_ != null) {
                this.bitField0_ |= 0x40000;
                this.onChanged();
            }
            return this;
        }

        public Builder clearTrayDisplayText() {
            this.bitField0_ &= 0xFFFBFFFF;
            this.trayDisplayText_ = null;
            if (this.trayDisplayTextBuilder_ != null) {
                this.trayDisplayTextBuilder_.dispose();
                this.trayDisplayTextBuilder_ = null;
            }
            this.onChanged();
            return this;
        }

        public Text.Builder getTrayDisplayTextBuilder() {
            this.bitField0_ |= 0x40000;
            this.onChanged();
            return this.getTrayDisplayTextFieldBuilder().getBuilder();
        }

        @Override
        public TextOrBuilder getTrayDisplayTextOrBuilder() {
            if (this.trayDisplayTextBuilder_ != null) {
                return this.trayDisplayTextBuilder_.getMessageOrBuilder();
            }
            return this.trayDisplayText_ == null ? Text.getDefaultInstance() : this.trayDisplayText_;
        }

        private SingleFieldBuilderV3<Text, Text.Builder, TextOrBuilder> getTrayDisplayTextFieldBuilder() {
            if (this.trayDisplayTextBuilder_ == null) {
                this.trayDisplayTextBuilder_ = new SingleFieldBuilderV3(this.getTrayDisplayText(), this.getParentForChildren(), this.isClean());
                this.trayDisplayText_ = null;
            }
            return this.trayDisplayTextBuilder_;
        }

        @Override
        public long getBannedDisplayEffects() {
            return this.bannedDisplayEffects_;
        }

        public Builder setBannedDisplayEffects(long value) {
            this.bannedDisplayEffects_ = value;
            this.bitField0_ |= 0x80000;
            this.onChanged();
            return this;
        }

        public Builder clearBannedDisplayEffects() {
            this.bitField0_ &= 0xFFF7FFFF;
            this.bannedDisplayEffects_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public boolean getDisplayForSelf() {
            return this.displayForSelf_;
        }

        public Builder setDisplayForSelf(boolean value) {
            this.displayForSelf_ = value;
            this.bitField0_ |= 0x100000;
            this.onChanged();
            return this;
        }

        public Builder clearDisplayForSelf() {
            this.bitField0_ &= 0xFFEFFFFF;
            this.displayForSelf_ = false;
            this.onChanged();
            return this;
        }

        @Override
        public String getInteractGiftInfo() {
            Object ref = this.interactGiftInfo_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.interactGiftInfo_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getInteractGiftInfoBytes() {
            Object ref = this.interactGiftInfo_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.interactGiftInfo_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setInteractGiftInfo(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.interactGiftInfo_ = value;
            this.bitField0_ |= 0x200000;
            this.onChanged();
            return this;
        }

        public Builder clearInteractGiftInfo() {
            this.interactGiftInfo_ = GiftMessage.getDefaultInstance().getInteractGiftInfo();
            this.bitField0_ &= 0xFFDFFFFF;
            this.onChanged();
            return this;
        }

        public Builder setInteractGiftInfoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            GiftMessage.checkByteStringIsUtf8(value);
            this.interactGiftInfo_ = value;
            this.bitField0_ |= 0x200000;
            this.onChanged();
            return this;
        }

        @Override
        public String getDiyItemInfo() {
            Object ref = this.diyItemInfo_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.diyItemInfo_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getDiyItemInfoBytes() {
            Object ref = this.diyItemInfo_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.diyItemInfo_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setDiyItemInfo(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.diyItemInfo_ = value;
            this.bitField0_ |= 0x400000;
            this.onChanged();
            return this;
        }

        public Builder clearDiyItemInfo() {
            this.diyItemInfo_ = GiftMessage.getDefaultInstance().getDiyItemInfo();
            this.bitField0_ &= 0xFFBFFFFF;
            this.onChanged();
            return this;
        }

        public Builder setDiyItemInfoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            GiftMessage.checkByteStringIsUtf8(value);
            this.diyItemInfo_ = value;
            this.bitField0_ |= 0x400000;
            this.onChanged();
            return this;
        }

        private void ensureMinAssetSetListIsMutable() {
            if (!this.minAssetSetList_.isModifiable()) {
                this.minAssetSetList_ = (Internal.LongList)GiftMessage.makeMutableCopy(this.minAssetSetList_);
            }
            this.bitField0_ |= 0x800000;
        }

        @Override
        public List<Long> getMinAssetSetListList() {
            this.minAssetSetList_.makeImmutable();
            return this.minAssetSetList_;
        }

        @Override
        public int getMinAssetSetListCount() {
            return this.minAssetSetList_.size();
        }

        @Override
        public long getMinAssetSetList(int index) {
            return this.minAssetSetList_.getLong(index);
        }

        public Builder setMinAssetSetList(int index, long value) {
            this.ensureMinAssetSetListIsMutable();
            this.minAssetSetList_.setLong(index, value);
            this.bitField0_ |= 0x800000;
            this.onChanged();
            return this;
        }

        public Builder addMinAssetSetList(long value) {
            this.ensureMinAssetSetListIsMutable();
            this.minAssetSetList_.addLong(value);
            this.bitField0_ |= 0x800000;
            this.onChanged();
            return this;
        }

        public Builder addAllMinAssetSetList(Iterable<? extends Long> values) {
            this.ensureMinAssetSetListIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.minAssetSetList_);
            this.bitField0_ |= 0x800000;
            this.onChanged();
            return this;
        }

        public Builder clearMinAssetSetList() {
            this.minAssetSetList_ = GiftMessage.emptyLongList();
            this.bitField0_ &= 0xFF7FFFFF;
            this.onChanged();
            return this;
        }

        @Override
        public long getTotalCount() {
            return this.totalCount_;
        }

        public Builder setTotalCount(long value) {
            this.totalCount_ = value;
            this.bitField0_ |= 0x1000000;
            this.onChanged();
            return this;
        }

        public Builder clearTotalCount() {
            this.bitField0_ &= 0xFEFFFFFF;
            this.totalCount_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public int getClientGiftSource() {
            return this.clientGiftSource_;
        }

        public Builder setClientGiftSource(int value) {
            this.clientGiftSource_ = value;
            this.bitField0_ |= 0x2000000;
            this.onChanged();
            return this;
        }

        public Builder clearClientGiftSource() {
            this.bitField0_ &= 0xFDFFFFFF;
            this.clientGiftSource_ = 0;
            this.onChanged();
            return this;
        }

        private void ensureToUserIdsListIsMutable() {
            if (!this.toUserIdsList_.isModifiable()) {
                this.toUserIdsList_ = (Internal.LongList)GiftMessage.makeMutableCopy(this.toUserIdsList_);
            }
            this.bitField0_ |= 0x4000000;
        }

        @Override
        public List<Long> getToUserIdsListList() {
            this.toUserIdsList_.makeImmutable();
            return this.toUserIdsList_;
        }

        @Override
        public int getToUserIdsListCount() {
            return this.toUserIdsList_.size();
        }

        @Override
        public long getToUserIdsList(int index) {
            return this.toUserIdsList_.getLong(index);
        }

        public Builder setToUserIdsList(int index, long value) {
            this.ensureToUserIdsListIsMutable();
            this.toUserIdsList_.setLong(index, value);
            this.bitField0_ |= 0x4000000;
            this.onChanged();
            return this;
        }

        public Builder addToUserIdsList(long value) {
            this.ensureToUserIdsListIsMutable();
            this.toUserIdsList_.addLong(value);
            this.bitField0_ |= 0x4000000;
            this.onChanged();
            return this;
        }

        public Builder addAllToUserIdsList(Iterable<? extends Long> values) {
            this.ensureToUserIdsListIsMutable();
            AbstractMessageLite.Builder.addAll(values, this.toUserIdsList_);
            this.bitField0_ |= 0x4000000;
            this.onChanged();
            return this;
        }

        public Builder clearToUserIdsList() {
            this.toUserIdsList_ = GiftMessage.emptyLongList();
            this.bitField0_ &= 0xFBFFFFFF;
            this.onChanged();
            return this;
        }

        @Override
        public long getSendTime() {
            return this.sendTime_;
        }

        public Builder setSendTime(long value) {
            this.sendTime_ = value;
            this.bitField0_ |= 0x8000000;
            this.onChanged();
            return this;
        }

        public Builder clearSendTime() {
            this.bitField0_ &= 0xF7FFFFFF;
            this.sendTime_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public long getForceDisplayEffects() {
            return this.forceDisplayEffects_;
        }

        public Builder setForceDisplayEffects(long value) {
            this.forceDisplayEffects_ = value;
            this.bitField0_ |= 0x10000000;
            this.onChanged();
            return this;
        }

        public Builder clearForceDisplayEffects() {
            this.bitField0_ &= 0xEFFFFFFF;
            this.forceDisplayEffects_ = 0L;
            this.onChanged();
            return this;
        }

        @Override
        public String getTraceId() {
            Object ref = this.traceId_;
            if (!(ref instanceof String)) {
                ByteString bs = (ByteString)ref;
                String s = bs.toStringUtf8();
                this.traceId_ = s;
                return s;
            }
            return (String)ref;
        }

        @Override
        public ByteString getTraceIdBytes() {
            Object ref = this.traceId_;
            if (ref instanceof String) {
                ByteString b = ByteString.copyFromUtf8((String)ref);
                this.traceId_ = b;
                return b;
            }
            return (ByteString)ref;
        }

        public Builder setTraceId(String value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.traceId_ = value;
            this.bitField0_ |= 0x20000000;
            this.onChanged();
            return this;
        }

        public Builder clearTraceId() {
            this.traceId_ = GiftMessage.getDefaultInstance().getTraceId();
            this.bitField0_ &= 0xDFFFFFFF;
            this.onChanged();
            return this;
        }

        public Builder setTraceIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            GiftMessage.checkByteStringIsUtf8(value);
            this.traceId_ = value;
            this.bitField0_ |= 0x20000000;
            this.onChanged();
            return this;
        }

        @Override
        public long getEffectDisplayTs() {
            return this.effectDisplayTs_;
        }

        public Builder setEffectDisplayTs(long value) {
            this.effectDisplayTs_ = value;
            this.bitField0_ |= 0x40000000;
            this.onChanged();
            return this;
        }

        public Builder clearEffectDisplayTs() {
            this.bitField0_ &= 0xBFFFFFFF;
            this.effectDisplayTs_ = 0L;
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


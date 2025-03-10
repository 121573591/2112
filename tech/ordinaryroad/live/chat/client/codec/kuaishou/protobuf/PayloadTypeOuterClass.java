/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.kuaishou.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class PayloadTypeOuterClass {
    private static Descriptors.FileDescriptor descriptor;

    private PayloadTypeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        PayloadTypeOuterClass.registerAllExtensions((ExtensionRegistryLite)registry);
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = new String[]{"\nPayloadType.proto*\nPayloadType\nUNKNOWN \n\fCS_HEARTBEAT\f\n\bCS_ERROR\nCS_PING\n\fPS_HOST_INFO3\nSC_HEARTBEAT_ACKe\nSC_ECHOf\f\n\bSC_ERRORg\nSC_PING_ACKh\nSC_INFOi\n\rCS_ENTER_ROOMÈ\n\rCS_USER_PAUSEÉ\n\fCS_USER_EXITÊ \nCS_AUTHOR_PUSH_TRAFFIC_ZEROË\nCS_HORSE_RACINGÌ\n\fCS_RACE_LOSEÍ\nCS_VOIP_SIGNALÎ\nSC_ENTER_ROOM_ACK¬\nSC_AUTHOR_PAUSE­\nSC_AUTHOR_RESUME® \nSC_AUTHOR_PUSH_TRAFFIC_ZERO¯\nSC_AUTHOR_HEARTBEAT_MISS°\nSC_PIP_STARTED±\n\fSC_PIP_ENDED²\nSC_HORSE_RACING_ACK³\nSC_VOIP_SIGNAL´\n\fSC_FEED_PUSH¶\nSC_ASSISTANT_STATUS·\nSC_REFRESH_WALLET¸\nSC_LIVE_CHAT_CALLÀ\nSC_LIVE_CHAT_CALL_ACCEPTEDÁ\nSC_LIVE_CHAT_CALL_REJECTEDÂ\nSC_LIVE_CHAT_READYÃ\nSC_LIVE_CHAT_GUEST_ENDÄ\nSC_LIVE_CHAT_ENDEDÅ$\nSC_RENDERING_MAGIC_FACE_DISABLEÆ#\nSC_RENDERING_MAGIC_FACE_ENABLEÇ\nSC_RED_PACK_FEEDÊ\nSC_LIVE_WATCHING_LISTÔ \nSC_LIVE_QUIZ_QUESTION_ASKEDÞ#\nSC_LIVE_QUIZ_QUESTION_REVIEWEDß\nSC_LIVE_QUIZ_SYNCà\nSC_LIVE_QUIZ_ENDEDá\nSC_LIVE_QUIZ_WINNERSâ\nSC_SUSPECTED_VIOLATIONã\nSC_SHOP_OPENEDè\nSC_SHOP_CLOSEDé\nSC_GUESS_OPENEDò\nSC_GUESS_CLOSEDó\nSC_PK_INVITATIONü\nSC_PK_STATISTICý\nSC_RIDDLE_OPENED\nSC_RIDDLE_CLOESED\nSC_RIDE_CHANGED\nSC_BET_CHANGED¹\n\rSC_BET_CLOSEDº)\n$SC_LIVE_SPECIAL_ACCOUNT_CONFIG_STATE1\n,SC_LIVE_WARNING_MASK_STATUS_CHANGED_AUDIENCEöB<\n:tech.ordinaryroad.live.chat.client.codec.kuaishou.protobufbproto3"};
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0]);
    }

    public static enum PayloadType implements ProtocolMessageEnum
    {
        UNKNOWN(0),
        CS_HEARTBEAT(1),
        CS_ERROR(3),
        CS_PING(4),
        PS_HOST_INFO(51),
        SC_HEARTBEAT_ACK(101),
        SC_ECHO(102),
        SC_ERROR(103),
        SC_PING_ACK(104),
        SC_INFO(105),
        CS_ENTER_ROOM(200),
        CS_USER_PAUSE(201),
        CS_USER_EXIT(202),
        CS_AUTHOR_PUSH_TRAFFIC_ZERO(203),
        CS_HORSE_RACING(204),
        CS_RACE_LOSE(205),
        CS_VOIP_SIGNAL(206),
        SC_ENTER_ROOM_ACK(300),
        SC_AUTHOR_PAUSE(301),
        SC_AUTHOR_RESUME(302),
        SC_AUTHOR_PUSH_TRAFFIC_ZERO(303),
        SC_AUTHOR_HEARTBEAT_MISS(304),
        SC_PIP_STARTED(305),
        SC_PIP_ENDED(306),
        SC_HORSE_RACING_ACK(307),
        SC_VOIP_SIGNAL(308),
        SC_FEED_PUSH(310),
        SC_ASSISTANT_STATUS(311),
        SC_REFRESH_WALLET(312),
        SC_LIVE_CHAT_CALL(320),
        SC_LIVE_CHAT_CALL_ACCEPTED(321),
        SC_LIVE_CHAT_CALL_REJECTED(322),
        SC_LIVE_CHAT_READY(323),
        SC_LIVE_CHAT_GUEST_END(324),
        SC_LIVE_CHAT_ENDED(325),
        SC_RENDERING_MAGIC_FACE_DISABLE(326),
        SC_RENDERING_MAGIC_FACE_ENABLE(327),
        SC_RED_PACK_FEED(330),
        SC_LIVE_WATCHING_LIST(340),
        SC_LIVE_QUIZ_QUESTION_ASKED(350),
        SC_LIVE_QUIZ_QUESTION_REVIEWED(351),
        SC_LIVE_QUIZ_SYNC(352),
        SC_LIVE_QUIZ_ENDED(353),
        SC_LIVE_QUIZ_WINNERS(354),
        SC_SUSPECTED_VIOLATION(355),
        SC_SHOP_OPENED(360),
        SC_SHOP_CLOSED(361),
        SC_GUESS_OPENED(370),
        SC_GUESS_CLOSED(371),
        SC_PK_INVITATION(380),
        SC_PK_STATISTIC(381),
        SC_RIDDLE_OPENED(390),
        SC_RIDDLE_CLOESED(391),
        SC_RIDE_CHANGED(412),
        SC_BET_CHANGED(441),
        SC_BET_CLOSED(442),
        SC_LIVE_SPECIAL_ACCOUNT_CONFIG_STATE(645),
        SC_LIVE_WARNING_MASK_STATUS_CHANGED_AUDIENCE(758),
        UNRECOGNIZED(-1);

        public static final int UNKNOWN_VALUE = 0;
        public static final int CS_HEARTBEAT_VALUE = 1;
        public static final int CS_ERROR_VALUE = 3;
        public static final int CS_PING_VALUE = 4;
        public static final int PS_HOST_INFO_VALUE = 51;
        public static final int SC_HEARTBEAT_ACK_VALUE = 101;
        public static final int SC_ECHO_VALUE = 102;
        public static final int SC_ERROR_VALUE = 103;
        public static final int SC_PING_ACK_VALUE = 104;
        public static final int SC_INFO_VALUE = 105;
        public static final int CS_ENTER_ROOM_VALUE = 200;
        public static final int CS_USER_PAUSE_VALUE = 201;
        public static final int CS_USER_EXIT_VALUE = 202;
        public static final int CS_AUTHOR_PUSH_TRAFFIC_ZERO_VALUE = 203;
        public static final int CS_HORSE_RACING_VALUE = 204;
        public static final int CS_RACE_LOSE_VALUE = 205;
        public static final int CS_VOIP_SIGNAL_VALUE = 206;
        public static final int SC_ENTER_ROOM_ACK_VALUE = 300;
        public static final int SC_AUTHOR_PAUSE_VALUE = 301;
        public static final int SC_AUTHOR_RESUME_VALUE = 302;
        public static final int SC_AUTHOR_PUSH_TRAFFIC_ZERO_VALUE = 303;
        public static final int SC_AUTHOR_HEARTBEAT_MISS_VALUE = 304;
        public static final int SC_PIP_STARTED_VALUE = 305;
        public static final int SC_PIP_ENDED_VALUE = 306;
        public static final int SC_HORSE_RACING_ACK_VALUE = 307;
        public static final int SC_VOIP_SIGNAL_VALUE = 308;
        public static final int SC_FEED_PUSH_VALUE = 310;
        public static final int SC_ASSISTANT_STATUS_VALUE = 311;
        public static final int SC_REFRESH_WALLET_VALUE = 312;
        public static final int SC_LIVE_CHAT_CALL_VALUE = 320;
        public static final int SC_LIVE_CHAT_CALL_ACCEPTED_VALUE = 321;
        public static final int SC_LIVE_CHAT_CALL_REJECTED_VALUE = 322;
        public static final int SC_LIVE_CHAT_READY_VALUE = 323;
        public static final int SC_LIVE_CHAT_GUEST_END_VALUE = 324;
        public static final int SC_LIVE_CHAT_ENDED_VALUE = 325;
        public static final int SC_RENDERING_MAGIC_FACE_DISABLE_VALUE = 326;
        public static final int SC_RENDERING_MAGIC_FACE_ENABLE_VALUE = 327;
        public static final int SC_RED_PACK_FEED_VALUE = 330;
        public static final int SC_LIVE_WATCHING_LIST_VALUE = 340;
        public static final int SC_LIVE_QUIZ_QUESTION_ASKED_VALUE = 350;
        public static final int SC_LIVE_QUIZ_QUESTION_REVIEWED_VALUE = 351;
        public static final int SC_LIVE_QUIZ_SYNC_VALUE = 352;
        public static final int SC_LIVE_QUIZ_ENDED_VALUE = 353;
        public static final int SC_LIVE_QUIZ_WINNERS_VALUE = 354;
        public static final int SC_SUSPECTED_VIOLATION_VALUE = 355;
        public static final int SC_SHOP_OPENED_VALUE = 360;
        public static final int SC_SHOP_CLOSED_VALUE = 361;
        public static final int SC_GUESS_OPENED_VALUE = 370;
        public static final int SC_GUESS_CLOSED_VALUE = 371;
        public static final int SC_PK_INVITATION_VALUE = 380;
        public static final int SC_PK_STATISTIC_VALUE = 381;
        public static final int SC_RIDDLE_OPENED_VALUE = 390;
        public static final int SC_RIDDLE_CLOESED_VALUE = 391;
        public static final int SC_RIDE_CHANGED_VALUE = 412;
        public static final int SC_BET_CHANGED_VALUE = 441;
        public static final int SC_BET_CLOSED_VALUE = 442;
        public static final int SC_LIVE_SPECIAL_ACCOUNT_CONFIG_STATE_VALUE = 645;
        public static final int SC_LIVE_WARNING_MASK_STATUS_CHANGED_AUDIENCE_VALUE = 758;
        private static final Internal.EnumLiteMap<PayloadType> internalValueMap;
        private static final PayloadType[] VALUES;
        private final int value;

        @Override
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static PayloadType valueOf(int value) {
            return PayloadType.forNumber(value);
        }

        public static PayloadType forNumber(int value) {
            switch (value) {
                case 0: {
                    return UNKNOWN;
                }
                case 1: {
                    return CS_HEARTBEAT;
                }
                case 3: {
                    return CS_ERROR;
                }
                case 4: {
                    return CS_PING;
                }
                case 51: {
                    return PS_HOST_INFO;
                }
                case 101: {
                    return SC_HEARTBEAT_ACK;
                }
                case 102: {
                    return SC_ECHO;
                }
                case 103: {
                    return SC_ERROR;
                }
                case 104: {
                    return SC_PING_ACK;
                }
                case 105: {
                    return SC_INFO;
                }
                case 200: {
                    return CS_ENTER_ROOM;
                }
                case 201: {
                    return CS_USER_PAUSE;
                }
                case 202: {
                    return CS_USER_EXIT;
                }
                case 203: {
                    return CS_AUTHOR_PUSH_TRAFFIC_ZERO;
                }
                case 204: {
                    return CS_HORSE_RACING;
                }
                case 205: {
                    return CS_RACE_LOSE;
                }
                case 206: {
                    return CS_VOIP_SIGNAL;
                }
                case 300: {
                    return SC_ENTER_ROOM_ACK;
                }
                case 301: {
                    return SC_AUTHOR_PAUSE;
                }
                case 302: {
                    return SC_AUTHOR_RESUME;
                }
                case 303: {
                    return SC_AUTHOR_PUSH_TRAFFIC_ZERO;
                }
                case 304: {
                    return SC_AUTHOR_HEARTBEAT_MISS;
                }
                case 305: {
                    return SC_PIP_STARTED;
                }
                case 306: {
                    return SC_PIP_ENDED;
                }
                case 307: {
                    return SC_HORSE_RACING_ACK;
                }
                case 308: {
                    return SC_VOIP_SIGNAL;
                }
                case 310: {
                    return SC_FEED_PUSH;
                }
                case 311: {
                    return SC_ASSISTANT_STATUS;
                }
                case 312: {
                    return SC_REFRESH_WALLET;
                }
                case 320: {
                    return SC_LIVE_CHAT_CALL;
                }
                case 321: {
                    return SC_LIVE_CHAT_CALL_ACCEPTED;
                }
                case 322: {
                    return SC_LIVE_CHAT_CALL_REJECTED;
                }
                case 323: {
                    return SC_LIVE_CHAT_READY;
                }
                case 324: {
                    return SC_LIVE_CHAT_GUEST_END;
                }
                case 325: {
                    return SC_LIVE_CHAT_ENDED;
                }
                case 326: {
                    return SC_RENDERING_MAGIC_FACE_DISABLE;
                }
                case 327: {
                    return SC_RENDERING_MAGIC_FACE_ENABLE;
                }
                case 330: {
                    return SC_RED_PACK_FEED;
                }
                case 340: {
                    return SC_LIVE_WATCHING_LIST;
                }
                case 350: {
                    return SC_LIVE_QUIZ_QUESTION_ASKED;
                }
                case 351: {
                    return SC_LIVE_QUIZ_QUESTION_REVIEWED;
                }
                case 352: {
                    return SC_LIVE_QUIZ_SYNC;
                }
                case 353: {
                    return SC_LIVE_QUIZ_ENDED;
                }
                case 354: {
                    return SC_LIVE_QUIZ_WINNERS;
                }
                case 355: {
                    return SC_SUSPECTED_VIOLATION;
                }
                case 360: {
                    return SC_SHOP_OPENED;
                }
                case 361: {
                    return SC_SHOP_CLOSED;
                }
                case 370: {
                    return SC_GUESS_OPENED;
                }
                case 371: {
                    return SC_GUESS_CLOSED;
                }
                case 380: {
                    return SC_PK_INVITATION;
                }
                case 381: {
                    return SC_PK_STATISTIC;
                }
                case 390: {
                    return SC_RIDDLE_OPENED;
                }
                case 391: {
                    return SC_RIDDLE_CLOESED;
                }
                case 412: {
                    return SC_RIDE_CHANGED;
                }
                case 441: {
                    return SC_BET_CHANGED;
                }
                case 442: {
                    return SC_BET_CLOSED;
                }
                case 645: {
                    return SC_LIVE_SPECIAL_ACCOUNT_CONFIG_STATE;
                }
                case 758: {
                    return SC_LIVE_WARNING_MASK_STATUS_CHANGED_AUDIENCE;
                }
            }
            return null;
        }

        public static Internal.EnumLiteMap<PayloadType> internalGetValueMap() {
            return internalValueMap;
        }

        @Override
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this == UNRECOGNIZED) {
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }
            return (Descriptors.EnumValueDescriptor)PayloadType.getDescriptor().getValues().get(this.ordinal());
        }

        @Override
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return PayloadType.getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor)PayloadTypeOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static PayloadType valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != PayloadType.getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }
            if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            }
            return VALUES[desc.getIndex()];
        }

        private PayloadType(int value) {
            this.value = value;
        }

        static {
            internalValueMap = new Internal.EnumLiteMap<PayloadType>(){

                @Override
                public PayloadType findValueByNumber(int number) {
                    return PayloadType.forNumber(number);
                }
            };
            VALUES = PayloadType.values();
        }
    }
}


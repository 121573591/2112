/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.room;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.BilibiliApis;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.response.RoomInfoRes;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.response.RoomPlayInfoResult;
import tech.ordinaryroad.live.chat.client.commons.base.constant.RoomLiveStatusEnum;
import tech.ordinaryroad.live.chat.client.commons.base.room.IRoomInitResult;

public class BilibiliRoomInitResult
implements IRoomInitResult {
    private String buvid3;
    private String uid;
    private BilibiliApis.RoomByIds roomByIds;
    private BilibiliApis.DanmuinfoResult danmuinfoResult = new BilibiliApis.DanmuinfoResult();
    private RoomPlayInfoResult roomPlayInfoResult = new RoomPlayInfoResult();
    private RoomInfoRes roomInfoRes = new RoomInfoRes();

    @Override
    public String getRoomTitle() {
        return this.roomByIds.getTitle();
    }

    @Override
    public RoomLiveStatusEnum getRoomLiveStatus() {
        RoomLiveStatusEnum roomLiveStatus = null;
        switch (this.roomPlayInfoResult.getLive_status()) {
            case LIVING: {
                roomLiveStatus = RoomLiveStatusEnum.LIVING;
                break;
            }
            case STOPPED: {
                roomLiveStatus = RoomLiveStatusEnum.STOPPED;
                break;
            }
        }
        return roomLiveStatus;
    }

    public static BilibiliRoomInitResultBuilder builder() {
        return new BilibiliRoomInitResultBuilder();
    }

    public String getBuvid3() {
        return this.buvid3;
    }

    public String getUid() {
        return this.uid;
    }

    public BilibiliApis.RoomByIds getRoomByIds() {
        return this.roomByIds;
    }

    public BilibiliApis.DanmuinfoResult getDanmuinfoResult() {
        return this.danmuinfoResult;
    }

    public RoomPlayInfoResult getRoomPlayInfoResult() {
        return this.roomPlayInfoResult;
    }

    public RoomInfoRes getRoomInfoRes() {
        return this.roomInfoRes;
    }

    public void setBuvid3(String buvid3) {
        this.buvid3 = buvid3;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setRoomByIds(BilibiliApis.RoomByIds roomByIds) {
        this.roomByIds = roomByIds;
    }

    public void setDanmuinfoResult(BilibiliApis.DanmuinfoResult danmuinfoResult) {
        this.danmuinfoResult = danmuinfoResult;
    }

    public void setRoomPlayInfoResult(RoomPlayInfoResult roomPlayInfoResult) {
        this.roomPlayInfoResult = roomPlayInfoResult;
    }

    public void setRoomInfoRes(RoomInfoRes roomInfoRes) {
        this.roomInfoRes = roomInfoRes;
    }

    public BilibiliRoomInitResult(String buvid3, String uid, BilibiliApis.RoomByIds roomByIds, BilibiliApis.DanmuinfoResult danmuinfoResult, RoomPlayInfoResult roomPlayInfoResult, RoomInfoRes roomInfoRes) {
        this.buvid3 = buvid3;
        this.uid = uid;
        this.roomByIds = roomByIds;
        this.danmuinfoResult = danmuinfoResult;
        this.roomPlayInfoResult = roomPlayInfoResult;
        this.roomInfoRes = roomInfoRes;
    }

    public BilibiliRoomInitResult() {
    }

    public static class BilibiliRoomInitResultBuilder {
        private String buvid3;
        private String uid;
        private BilibiliApis.RoomByIds roomByIds;
        private BilibiliApis.DanmuinfoResult danmuinfoResult;
        private RoomPlayInfoResult roomPlayInfoResult;
        private RoomInfoRes roomInfoRes;

        BilibiliRoomInitResultBuilder() {
        }

        public BilibiliRoomInitResultBuilder buvid3(String buvid3) {
            this.buvid3 = buvid3;
            return this;
        }

        public BilibiliRoomInitResultBuilder uid(String uid) {
            this.uid = uid;
            return this;
        }

        public BilibiliRoomInitResultBuilder roomByIds(BilibiliApis.RoomByIds roomByIds) {
            this.roomByIds = roomByIds;
            return this;
        }

        public BilibiliRoomInitResultBuilder danmuinfoResult(BilibiliApis.DanmuinfoResult danmuinfoResult) {
            this.danmuinfoResult = danmuinfoResult;
            return this;
        }

        public BilibiliRoomInitResultBuilder roomPlayInfoResult(RoomPlayInfoResult roomPlayInfoResult) {
            this.roomPlayInfoResult = roomPlayInfoResult;
            return this;
        }

        public BilibiliRoomInitResultBuilder roomInfoRes(RoomInfoRes roomInfoRes) {
            this.roomInfoRes = roomInfoRes;
            return this;
        }

        public BilibiliRoomInitResult build() {
            return new BilibiliRoomInitResult(this.buvid3, this.uid, this.roomByIds, this.danmuinfoResult, this.roomPlayInfoResult, this.roomInfoRes);
        }

        public String toString() {
            return "BilibiliRoomInitResult.BilibiliRoomInitResultBuilder(buvid3=" + this.buvid3 + ", uid=" + this.uid + ", roomByIds=" + this.roomByIds + ", danmuinfoResult=" + this.danmuinfoResult + ", roomPlayInfoResult=" + this.roomPlayInfoResult + ", roomInfoRes=" + this.roomInfoRes + ")";
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.room;

import com.fasterxml.jackson.databind.JsonNode;
import tech.ordinaryroad.live.chat.client.codec.douyin.constant.DouyinRoomStatusEnum;
import tech.ordinaryroad.live.chat.client.commons.base.constant.RoomLiveStatusEnum;
import tech.ordinaryroad.live.chat.client.commons.base.room.IRoomInitResult;

public class DouyinRoomInitResult
implements IRoomInitResult {
    private String ttwid;
    private String msToken;
    private String acNonce;
    private long realRoomId;
    private String userUniqueId;
    private DouyinRoomStatusEnum roomStatus;
    private JsonNode roomInfoJsonNode;

    @Override
    public String getRoomTitle() {
        String roomTitle = null;
        try {
            roomTitle = this.roomInfoJsonNode.get("room").get("title").asText();
        }
        catch (Exception exception) {
            // empty catch block
        }
        return roomTitle;
    }

    @Override
    public RoomLiveStatusEnum getRoomLiveStatus() {
        RoomLiveStatusEnum roomLiveStatus = null;
        switch (this.roomStatus) {
            case STOPPED: {
                roomLiveStatus = RoomLiveStatusEnum.STOPPED;
                break;
            }
            case LIVING: {
                roomLiveStatus = RoomLiveStatusEnum.LIVING;
                break;
            }
        }
        return roomLiveStatus;
    }

    public static DouyinRoomInitResultBuilder builder() {
        return new DouyinRoomInitResultBuilder();
    }

    public String getTtwid() {
        return this.ttwid;
    }

    public String getMsToken() {
        return this.msToken;
    }

    public String getAcNonce() {
        return this.acNonce;
    }

    public long getRealRoomId() {
        return this.realRoomId;
    }

    public String getUserUniqueId() {
        return this.userUniqueId;
    }

    public DouyinRoomStatusEnum getRoomStatus() {
        return this.roomStatus;
    }

    public JsonNode getRoomInfoJsonNode() {
        return this.roomInfoJsonNode;
    }

    public void setTtwid(String ttwid) {
        this.ttwid = ttwid;
    }

    public void setMsToken(String msToken) {
        this.msToken = msToken;
    }

    public void setAcNonce(String acNonce) {
        this.acNonce = acNonce;
    }

    public void setRealRoomId(long realRoomId) {
        this.realRoomId = realRoomId;
    }

    public void setUserUniqueId(String userUniqueId) {
        this.userUniqueId = userUniqueId;
    }

    public void setRoomStatus(DouyinRoomStatusEnum roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setRoomInfoJsonNode(JsonNode roomInfoJsonNode) {
        this.roomInfoJsonNode = roomInfoJsonNode;
    }

    public DouyinRoomInitResult(String ttwid, String msToken, String acNonce, long realRoomId, String userUniqueId, DouyinRoomStatusEnum roomStatus, JsonNode roomInfoJsonNode) {
        this.ttwid = ttwid;
        this.msToken = msToken;
        this.acNonce = acNonce;
        this.realRoomId = realRoomId;
        this.userUniqueId = userUniqueId;
        this.roomStatus = roomStatus;
        this.roomInfoJsonNode = roomInfoJsonNode;
    }

    public DouyinRoomInitResult() {
    }

    public static class DouyinRoomInitResultBuilder {
        private String ttwid;
        private String msToken;
        private String acNonce;
        private long realRoomId;
        private String userUniqueId;
        private DouyinRoomStatusEnum roomStatus;
        private JsonNode roomInfoJsonNode;

        DouyinRoomInitResultBuilder() {
        }

        public DouyinRoomInitResultBuilder ttwid(String ttwid) {
            this.ttwid = ttwid;
            return this;
        }

        public DouyinRoomInitResultBuilder msToken(String msToken) {
            this.msToken = msToken;
            return this;
        }

        public DouyinRoomInitResultBuilder acNonce(String acNonce) {
            this.acNonce = acNonce;
            return this;
        }

        public DouyinRoomInitResultBuilder realRoomId(long realRoomId) {
            this.realRoomId = realRoomId;
            return this;
        }

        public DouyinRoomInitResultBuilder userUniqueId(String userUniqueId) {
            this.userUniqueId = userUniqueId;
            return this;
        }

        public DouyinRoomInitResultBuilder roomStatus(DouyinRoomStatusEnum roomStatus) {
            this.roomStatus = roomStatus;
            return this;
        }

        public DouyinRoomInitResultBuilder roomInfoJsonNode(JsonNode roomInfoJsonNode) {
            this.roomInfoJsonNode = roomInfoJsonNode;
            return this;
        }

        public DouyinRoomInitResult build() {
            return new DouyinRoomInitResult(this.ttwid, this.msToken, this.acNonce, this.realRoomId, this.userUniqueId, this.roomStatus, this.roomInfoJsonNode);
        }

        public String toString() {
            return "DouyinRoomInitResult.DouyinRoomInitResultBuilder(ttwid=" + this.ttwid + ", msToken=" + this.msToken + ", acNonce=" + this.acNonce + ", realRoomId=" + this.realRoomId + ", userUniqueId=" + this.userUniqueId + ", roomStatus=" + (Object)((Object)this.roomStatus) + ", roomInfoJsonNode=" + this.roomInfoJsonNode + ")";
        }
    }
}


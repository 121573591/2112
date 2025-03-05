/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.tiktok.room;

import com.fasterxml.jackson.databind.JsonNode;
import tech.ordinaryroad.live.chat.client.codec.tiktok.constant.TiktokRoomStatusEnum;
import tech.ordinaryroad.live.chat.client.codec.tiktok.protobuf.Response;
import tech.ordinaryroad.live.chat.client.commons.base.constant.RoomLiveStatusEnum;
import tech.ordinaryroad.live.chat.client.commons.base.room.IRoomInitResult;

public class RoomInitResult
implements IRoomInitResult {
    private String ttwid;
    private String msToken;
    private String acNonce;
    private long realRoomId;
    private String userUniqueId;
    private TiktokRoomStatusEnum roomStatus;
    private Response webcastResponse;
    private JsonNode sigiState;

    @Override
    public String getRoomTitle() {
        return this.sigiState.get("LiveRoom").get("liveRoomUserInfo").get("liveRoom").get("title").asText();
    }

    @Override
    public RoomLiveStatusEnum getRoomLiveStatus() {
        RoomLiveStatusEnum roomLiveStatus = null;
        switch (this.roomStatus) {
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

    public static RoomInitResultBuilder builder() {
        return new RoomInitResultBuilder();
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

    public TiktokRoomStatusEnum getRoomStatus() {
        return this.roomStatus;
    }

    public Response getWebcastResponse() {
        return this.webcastResponse;
    }

    public JsonNode getSigiState() {
        return this.sigiState;
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

    public void setRoomStatus(TiktokRoomStatusEnum roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setWebcastResponse(Response webcastResponse) {
        this.webcastResponse = webcastResponse;
    }

    public void setSigiState(JsonNode sigiState) {
        this.sigiState = sigiState;
    }

    public RoomInitResult(String ttwid, String msToken, String acNonce, long realRoomId, String userUniqueId, TiktokRoomStatusEnum roomStatus, Response webcastResponse, JsonNode sigiState) {
        this.ttwid = ttwid;
        this.msToken = msToken;
        this.acNonce = acNonce;
        this.realRoomId = realRoomId;
        this.userUniqueId = userUniqueId;
        this.roomStatus = roomStatus;
        this.webcastResponse = webcastResponse;
        this.sigiState = sigiState;
    }

    public RoomInitResult() {
    }

    public static class RoomInitResultBuilder {
        private String ttwid;
        private String msToken;
        private String acNonce;
        private long realRoomId;
        private String userUniqueId;
        private TiktokRoomStatusEnum roomStatus;
        private Response webcastResponse;
        private JsonNode sigiState;

        RoomInitResultBuilder() {
        }

        public RoomInitResultBuilder ttwid(String ttwid) {
            this.ttwid = ttwid;
            return this;
        }

        public RoomInitResultBuilder msToken(String msToken) {
            this.msToken = msToken;
            return this;
        }

        public RoomInitResultBuilder acNonce(String acNonce) {
            this.acNonce = acNonce;
            return this;
        }

        public RoomInitResultBuilder realRoomId(long realRoomId) {
            this.realRoomId = realRoomId;
            return this;
        }

        public RoomInitResultBuilder userUniqueId(String userUniqueId) {
            this.userUniqueId = userUniqueId;
            return this;
        }

        public RoomInitResultBuilder roomStatus(TiktokRoomStatusEnum roomStatus) {
            this.roomStatus = roomStatus;
            return this;
        }

        public RoomInitResultBuilder webcastResponse(Response webcastResponse) {
            this.webcastResponse = webcastResponse;
            return this;
        }

        public RoomInitResultBuilder sigiState(JsonNode sigiState) {
            this.sigiState = sigiState;
            return this;
        }

        public RoomInitResult build() {
            return new RoomInitResult(this.ttwid, this.msToken, this.acNonce, this.realRoomId, this.userUniqueId, this.roomStatus, this.webcastResponse, this.sigiState);
        }

        public String toString() {
            return "RoomInitResult.RoomInitResultBuilder(ttwid=" + this.ttwid + ", msToken=" + this.msToken + ", acNonce=" + this.acNonce + ", realRoomId=" + this.realRoomId + ", userUniqueId=" + this.userUniqueId + ", roomStatus=" + (Object)((Object)this.roomStatus) + ", webcastResponse=" + this.webcastResponse + ", sigiState=" + this.sigiState + ")";
        }
    }
}


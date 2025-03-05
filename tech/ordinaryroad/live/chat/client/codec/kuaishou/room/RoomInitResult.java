/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.kuaishou.room;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import tech.ordinaryroad.live.chat.client.commons.base.constant.RoomLiveStatusEnum;
import tech.ordinaryroad.live.chat.client.commons.base.room.IRoomInitResult;

public class RoomInitResult
implements IRoomInitResult {
    private String token;
    private String liveStreamId;
    private List<String> websocketUrls;
    private JsonNode livedetailJsonNode;

    @Override
    public String getRoomTitle() {
        return this.livedetailJsonNode.get("author").get("name").asText();
    }

    @Override
    public String getRoomDescription() {
        return this.livedetailJsonNode.get("author").get("description").asText();
    }

    @Override
    public RoomLiveStatusEnum getRoomLiveStatus() {
        if (this.livedetailJsonNode.has("liveStream") && this.livedetailJsonNode.get("liveStream").has("id")) {
            return RoomLiveStatusEnum.LIVING;
        }
        return RoomLiveStatusEnum.STOPPED;
    }

    public static RoomInitResultBuilder builder() {
        return new RoomInitResultBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public String getLiveStreamId() {
        return this.liveStreamId;
    }

    public List<String> getWebsocketUrls() {
        return this.websocketUrls;
    }

    public JsonNode getLivedetailJsonNode() {
        return this.livedetailJsonNode;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setLiveStreamId(String liveStreamId) {
        this.liveStreamId = liveStreamId;
    }

    public void setWebsocketUrls(List<String> websocketUrls) {
        this.websocketUrls = websocketUrls;
    }

    public void setLivedetailJsonNode(JsonNode livedetailJsonNode) {
        this.livedetailJsonNode = livedetailJsonNode;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RoomInitResult)) {
            return false;
        }
        RoomInitResult other = (RoomInitResult)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$token = this.getToken();
        String other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals((Object)other$token)) {
            return false;
        }
        String this$liveStreamId = this.getLiveStreamId();
        String other$liveStreamId = other.getLiveStreamId();
        if (this$liveStreamId == null ? other$liveStreamId != null : !this$liveStreamId.equals((Object)other$liveStreamId)) {
            return false;
        }
        List<String> this$websocketUrls = this.getWebsocketUrls();
        List<String> other$websocketUrls = other.getWebsocketUrls();
        if (this$websocketUrls == null ? other$websocketUrls != null : !this$websocketUrls.equals(other$websocketUrls)) {
            return false;
        }
        JsonNode this$livedetailJsonNode = this.getLivedetailJsonNode();
        JsonNode other$livedetailJsonNode = other.getLivedetailJsonNode();
        return !(this$livedetailJsonNode == null ? other$livedetailJsonNode != null : !this$livedetailJsonNode.equals(other$livedetailJsonNode));
    }

    protected boolean canEqual(Object other) {
        return other instanceof RoomInitResult;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        String $liveStreamId = this.getLiveStreamId();
        result = result * 59 + ($liveStreamId == null ? 43 : $liveStreamId.hashCode());
        List<String> $websocketUrls = this.getWebsocketUrls();
        result = result * 59 + ($websocketUrls == null ? 43 : $websocketUrls.hashCode());
        JsonNode $livedetailJsonNode = this.getLivedetailJsonNode();
        result = result * 59 + ($livedetailJsonNode == null ? 43 : $livedetailJsonNode.hashCode());
        return result;
    }

    public String toString() {
        return "RoomInitResult(token=" + this.getToken() + ", liveStreamId=" + this.getLiveStreamId() + ", websocketUrls=" + this.getWebsocketUrls() + ", livedetailJsonNode=" + this.getLivedetailJsonNode() + ")";
    }

    public RoomInitResult(String token, String liveStreamId, List<String> websocketUrls, JsonNode livedetailJsonNode) {
        this.token = token;
        this.liveStreamId = liveStreamId;
        this.websocketUrls = websocketUrls;
        this.livedetailJsonNode = livedetailJsonNode;
    }

    public RoomInitResult() {
    }

    public static class RoomInitResultBuilder {
        private String token;
        private String liveStreamId;
        private List<String> websocketUrls;
        private JsonNode livedetailJsonNode;

        RoomInitResultBuilder() {
        }

        public RoomInitResultBuilder token(String token) {
            this.token = token;
            return this;
        }

        public RoomInitResultBuilder liveStreamId(String liveStreamId) {
            this.liveStreamId = liveStreamId;
            return this;
        }

        public RoomInitResultBuilder websocketUrls(List<String> websocketUrls) {
            this.websocketUrls = websocketUrls;
            return this;
        }

        public RoomInitResultBuilder livedetailJsonNode(JsonNode livedetailJsonNode) {
            this.livedetailJsonNode = livedetailJsonNode;
            return this;
        }

        public RoomInitResult build() {
            return new RoomInitResult(this.token, this.liveStreamId, this.websocketUrls, this.livedetailJsonNode);
        }

        public String toString() {
            return "RoomInitResult.RoomInitResultBuilder(token=" + this.token + ", liveStreamId=" + this.liveStreamId + ", websocketUrls=" + this.websocketUrls + ", livedetailJsonNode=" + this.livedetailJsonNode + ")";
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.websocket.room;

import tech.ordinaryroad.live.chat.client.commons.base.constant.RoomLiveStatusEnum;
import tech.ordinaryroad.live.chat.client.commons.base.room.IRoomInitResult;

public class WebSocketRoomInitResult
implements IRoomInitResult {
    @Override
    public String getRoomTitle() {
        return "";
    }

    @Override
    public RoomLiveStatusEnum getRoomLiveStatus() {
        return null;
    }

    WebSocketRoomInitResult() {
    }

    public static WebSocketRoomInitResultBuilder builder() {
        return new WebSocketRoomInitResultBuilder();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof WebSocketRoomInitResult)) {
            return false;
        }
        WebSocketRoomInitResult other = (WebSocketRoomInitResult)o;
        return other.canEqual(this);
    }

    protected boolean canEqual(Object other) {
        return other instanceof WebSocketRoomInitResult;
    }

    public int hashCode() {
        boolean result = true;
        return 1;
    }

    public String toString() {
        return "WebSocketRoomInitResult()";
    }

    public static class WebSocketRoomInitResultBuilder {
        WebSocketRoomInitResultBuilder() {
        }

        public WebSocketRoomInitResult build() {
            return new WebSocketRoomInitResult();
        }

        public String toString() {
            return "WebSocketRoomInitResult.WebSocketRoomInitResultBuilder()";
        }
    }
}


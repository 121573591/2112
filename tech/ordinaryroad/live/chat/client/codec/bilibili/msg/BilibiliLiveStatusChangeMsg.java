/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.msg;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.OperationEnum;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base.BaseBilibiliCmdMsg;
import tech.ordinaryroad.live.chat.client.commons.base.constant.LiveStatusAction;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ILiveStatusChangeMsg;

public class BilibiliLiveStatusChangeMsg
extends BaseBilibiliCmdMsg
implements ILiveStatusChangeMsg {
    private Pair<Object, Object> roomIdPair;
    private JsonNode data;

    @Override
    public OperationEnum getOperationEnum() {
        return OperationEnum.MESSAGE;
    }

    @Override
    public LiveStatusAction getLiveStatusAction() {
        switch (this.getCmdEnum()) {
            case LIVE: {
                return LiveStatusAction.BEGIN;
            }
            case STOP_LIVE_ROOM_LIST: {
                Object roomId = this.roomIdPair.getKey();
                Object shortRoomId = this.roomIdPair.getValue();
                if (this.data == null || !this.data.has("room_id_list")) {
                    return null;
                }
                ArrayNode roomIdList = (ArrayNode)this.data.withArray("room_id_list");
                for (JsonNode jsonNode : roomIdList) {
                    long aLong = jsonNode.asLong();
                    if (aLong != NumberUtil.parseLong(StrUtil.toStringOrNull(roomId)) && aLong != NumberUtil.parseLong(StrUtil.toStringOrNull(shortRoomId))) continue;
                    return LiveStatusAction.END;
                }
                break;
            }
        }
        return null;
    }

    public Pair<Object, Object> getRoomIdPair() {
        return this.roomIdPair;
    }

    public JsonNode getData() {
        return this.data;
    }

    public void setRoomIdPair(Pair<Object, Object> roomIdPair) {
        this.roomIdPair = roomIdPair;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public BilibiliLiveStatusChangeMsg(Pair<Object, Object> roomIdPair, JsonNode data) {
        this.roomIdPair = roomIdPair;
        this.data = data;
    }

    public BilibiliLiveStatusChangeMsg() {
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class Rankdb_info {
    private long roomid;
    private String rank_desc;
    private String color;
    private String h5_url;
    private String web_url;
    private long timestamp;

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public long getRoomid() {
        return this.roomid;
    }

    public void setRank_desc(String rank_desc) {
        this.rank_desc = rank_desc;
    }

    public String getRank_desc() {
        return this.rank_desc;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setH5_url(String h5_url) {
        this.h5_url = h5_url;
    }

    public String getH5_url() {
        return this.h5_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getWeb_url() {
        return this.web_url;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}


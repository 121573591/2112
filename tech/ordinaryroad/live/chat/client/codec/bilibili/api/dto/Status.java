/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class Status {
    private int open;
    private int anchor_open;
    private int status;
    private int uid;
    private String user_name;
    private String head_pic;
    private int guard;
    private int start_at;
    private long current_time;

    public void setOpen(int open) {
        this.open = open;
    }

    public int getOpen() {
        return this.open;
    }

    public void setAnchor_open(int anchor_open) {
        this.anchor_open = anchor_open;
    }

    public int getAnchor_open() {
        return this.anchor_open;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public String getHead_pic() {
        return this.head_pic;
    }

    public void setGuard(int guard) {
        this.guard = guard;
    }

    public int getGuard() {
        return this.guard;
    }

    public void setStart_at(int start_at) {
        this.start_at = start_at;
    }

    public int getStart_at() {
        return this.start_at;
    }

    public void setCurrent_time(long current_time) {
        this.current_time = current_time;
    }

    public long getCurrent_time() {
        return this.current_time;
    }
}


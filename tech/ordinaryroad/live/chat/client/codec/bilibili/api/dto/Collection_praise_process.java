/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class Collection_praise_process {
    private int id;
    private int uid;
    private int target_praise;
    private int current_praise;
    private int start_time;
    private int end_time;
    private String benefit;
    private boolean isSuccess;
    private boolean exist;
    private int audit_status;
    private String jump_url;
    private String current_praise_text;
    private String icon_url;
    private String live_id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return this.uid;
    }

    public void setTarget_praise(int target_praise) {
        this.target_praise = target_praise;
    }

    public int getTarget_praise() {
        return this.target_praise;
    }

    public void setCurrent_praise(int current_praise) {
        this.current_praise = current_praise;
    }

    public int getCurrent_praise() {
        return this.current_praise;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getStart_time() {
        return this.start_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getEnd_time() {
        return this.end_time;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getBenefit() {
        return this.benefit;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return this.isSuccess;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public boolean getExist() {
        return this.exist;
    }

    public void setAudit_status(int audit_status) {
        this.audit_status = audit_status;
    }

    public int getAudit_status() {
        return this.audit_status;
    }

    public void setJump_url(String jump_url) {
        this.jump_url = jump_url;
    }

    public String getJump_url() {
        return this.jump_url;
    }

    public void setCurrent_praise_text(String current_praise_text) {
        this.current_praise_text = current_praise_text;
    }

    public String getCurrent_praise_text() {
        return this.current_praise_text;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getIcon_url() {
        return this.icon_url;
    }

    public void setLive_id(String live_id) {
        this.live_id = live_id;
    }

    public String getLive_id() {
        return this.live_id;
    }
}


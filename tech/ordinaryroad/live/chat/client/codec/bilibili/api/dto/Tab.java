/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Sub_tab;

public class Tab {
    private String type;
    private String title;
    private int status;
    private int defaultShadowed;
    private String comment;
    private String desc_url;
    private String switchShadowed;
    private List<Sub_tab> sub_tab;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    public void setDefaultShadowed(int defaultShadowed) {
        this.defaultShadowed = defaultShadowed;
    }

    public int getDefaultShadowed() {
        return this.defaultShadowed;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setDesc_url(String desc_url) {
        this.desc_url = desc_url;
    }

    public String getDesc_url() {
        return this.desc_url;
    }

    public void setSwitchShadowed(String switchShadowed) {
        this.switchShadowed = switchShadowed;
    }

    public String getSwitchShadowed() {
        return this.switchShadowed;
    }

    public void setSub_tab(List<Sub_tab> sub_tab) {
        this.sub_tab = sub_tab;
    }

    public List<Sub_tab> getSub_tab() {
        return this.sub_tab;
    }
}


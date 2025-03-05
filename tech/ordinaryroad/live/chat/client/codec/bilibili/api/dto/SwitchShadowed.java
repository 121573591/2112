/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Ui_type;

public class SwitchShadowed {
    private String text;
    private String switchShadowed;
    private Ui_type ui_type;
    private String comment;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setSwitchShadowed(String switchShadowed) {
        this.switchShadowed = switchShadowed;
    }

    public String getSwitchShadowed() {
        return this.switchShadowed;
    }

    public void setUi_type(Ui_type ui_type) {
        this.ui_type = ui_type;
    }

    public Ui_type getUi_type() {
        return this.ui_type;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }
}


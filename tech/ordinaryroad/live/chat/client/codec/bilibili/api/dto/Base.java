/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Official_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Origin_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Risk_ctrl_info;

public class Base {
    private String name;
    private String face;
    private int name_color;
    private boolean is_mystery;
    private Risk_ctrl_info risk_ctrl_info;
    private Origin_info origin_info;
    private Official_info official_info;
    private String name_color_str;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFace() {
        return this.face;
    }

    public void setName_color(int name_color) {
        this.name_color = name_color;
    }

    public int getName_color() {
        return this.name_color;
    }

    public void setIs_mystery(boolean is_mystery) {
        this.is_mystery = is_mystery;
    }

    public boolean getIs_mystery() {
        return this.is_mystery;
    }

    public void setRisk_ctrl_info(Risk_ctrl_info risk_ctrl_info) {
        this.risk_ctrl_info = risk_ctrl_info;
    }

    public Risk_ctrl_info getRisk_ctrl_info() {
        return this.risk_ctrl_info;
    }

    public void setOrigin_info(Origin_info origin_info) {
        this.origin_info = origin_info;
    }

    public Origin_info getOrigin_info() {
        return this.origin_info;
    }

    public void setOfficial_info(Official_info official_info) {
        this.official_info = official_info;
    }

    public Official_info getOfficial_info() {
        return this.official_info;
    }

    public void setName_color_str(String name_color_str) {
        this.name_color_str = name_color_str;
    }

    public String getName_color_str() {
        return this.name_color_str;
    }
}


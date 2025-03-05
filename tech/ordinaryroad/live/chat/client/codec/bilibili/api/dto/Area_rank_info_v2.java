/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.User_last_rank_result;

public class Area_rank_info_v2 {
    private String items;
    private int rotation_cycle_time;
    private User_last_rank_result user_last_rank_result;
    private boolean user_ab_flag;

    public void setItems(String items) {
        this.items = items;
    }

    public String getItems() {
        return this.items;
    }

    public void setRotation_cycle_time(int rotation_cycle_time) {
        this.rotation_cycle_time = rotation_cycle_time;
    }

    public int getRotation_cycle_time() {
        return this.rotation_cycle_time;
    }

    public void setUser_last_rank_result(User_last_rank_result user_last_rank_result) {
        this.user_last_rank_result = user_last_rank_result;
    }

    public User_last_rank_result getUser_last_rank_result() {
        return this.user_last_rank_result;
    }

    public void setUser_ab_flag(boolean user_ab_flag) {
        this.user_ab_flag = user_ab_flag;
    }

    public boolean getUser_ab_flag() {
        return this.user_ab_flag;
    }
}


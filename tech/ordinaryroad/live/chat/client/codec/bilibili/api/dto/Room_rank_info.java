/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.User_rank_entry;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.User_rank_tab_list;

public class Room_rank_info {
    private String anchor_rank_entry;
    private User_rank_entry user_rank_entry;
    private User_rank_tab_list user_rank_tab_list;

    public void setAnchor_rank_entry(String anchor_rank_entry) {
        this.anchor_rank_entry = anchor_rank_entry;
    }

    public String getAnchor_rank_entry() {
        return this.anchor_rank_entry;
    }

    public void setUser_rank_entry(User_rank_entry user_rank_entry) {
        this.user_rank_entry = user_rank_entry;
    }

    public User_rank_entry getUser_rank_entry() {
        return this.user_rank_entry;
    }

    public void setUser_rank_tab_list(User_rank_tab_list user_rank_tab_list) {
        this.user_rank_tab_list = user_rank_tab_list;
    }

    public User_rank_tab_list getUser_rank_tab_list() {
        return this.user_rank_tab_list;
    }
}


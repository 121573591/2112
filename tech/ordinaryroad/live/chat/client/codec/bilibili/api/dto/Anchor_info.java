/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Base_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Gift_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Live_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Medal_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Relation_info;

public class Anchor_info {
    private Base_info base_info;
    private Live_info live_info;
    private Relation_info relation_info;
    private Medal_info medal_info;
    private Gift_info gift_info;

    public void setBase_info(Base_info base_info) {
        this.base_info = base_info;
    }

    public Base_info getBase_info() {
        return this.base_info;
    }

    public void setLive_info(Live_info live_info) {
        this.live_info = live_info;
    }

    public Live_info getLive_info() {
        return this.live_info;
    }

    public void setRelation_info(Relation_info relation_info) {
        this.relation_info = relation_info;
    }

    public Relation_info getRelation_info() {
        return this.relation_info;
    }

    public void setMedal_info(Medal_info medal_info) {
        this.medal_info = medal_info;
    }

    public Medal_info getMedal_info() {
        return this.medal_info;
    }

    public void setGift_info(Gift_info gift_info) {
        this.gift_info = gift_info;
    }

    public Gift_info getGift_info() {
        return this.gift_info;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Medal_info;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Uinfo;

public class Item {
    private long uid;
    private String name;
    private String face;
    private int rank;
    private int score;
    private Medal_info medal_info;
    private int guard_level;
    private int wealth_level;
    private boolean is_mystery;
    private Uinfo uinfo;
    private boolean icon_show;

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return this.uid;
    }

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

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setMedal_info(Medal_info medal_info) {
        this.medal_info = medal_info;
    }

    public Medal_info getMedal_info() {
        return this.medal_info;
    }

    public void setGuard_level(int guard_level) {
        this.guard_level = guard_level;
    }

    public int getGuard_level() {
        return this.guard_level;
    }

    public void setWealth_level(int wealth_level) {
        this.wealth_level = wealth_level;
    }

    public int getWealth_level() {
        return this.wealth_level;
    }

    public void setIs_mystery(boolean is_mystery) {
        this.is_mystery = is_mystery;
    }

    public boolean getIs_mystery() {
        return this.is_mystery;
    }

    public void setUinfo(Uinfo uinfo) {
        this.uinfo = uinfo;
    }

    public Uinfo getUinfo() {
        return this.uinfo;
    }

    public void setIcon_show(boolean icon_show) {
        this.icon_show = icon_show;
    }

    public boolean getIcon_show() {
        return this.icon_show;
    }
}


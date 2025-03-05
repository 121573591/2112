/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Uinfo;

public class List {
    private long uid;
    private String face;
    private String uname;
    private String score;
    private int rank;
    private int guard_level;
    private int wealth_level;
    private boolean is_mystery;
    private Uinfo uinfo;

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getUid() {
        return this.uid;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFace() {
        return this.face;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return this.uname;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getScore() {
        return this.score;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
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
}


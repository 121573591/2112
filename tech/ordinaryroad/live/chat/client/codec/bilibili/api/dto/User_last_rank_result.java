/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class User_last_rank_result {
    private boolean show_special;
    private int show_special_count;

    public boolean isShow_special() {
        return this.show_special;
    }

    public int getShow_special_count() {
        return this.show_special_count;
    }

    public void setShow_special(boolean show_special) {
        this.show_special = show_special;
    }

    public void setShow_special_count(int show_special_count) {
        this.show_special_count = show_special_count;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User_last_rank_result)) {
            return false;
        }
        User_last_rank_result other = (User_last_rank_result)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isShow_special() != other.isShow_special()) {
            return false;
        }
        return this.getShow_special_count() == other.getShow_special_count();
    }

    protected boolean canEqual(Object other) {
        return other instanceof User_last_rank_result;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isShow_special() ? 79 : 97);
        result = result * 59 + this.getShow_special_count();
        return result;
    }

    public String toString() {
        return "User_last_rank_result(show_special=" + this.isShow_special() + ", show_special_count=" + this.getShow_special_count() + ")";
    }

    public User_last_rank_result(boolean show_special, int show_special_count) {
        this.show_special = show_special;
        this.show_special_count = show_special_count;
    }

    public User_last_rank_result() {
    }
}


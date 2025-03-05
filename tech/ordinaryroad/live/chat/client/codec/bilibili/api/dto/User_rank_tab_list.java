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
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Tab;

public class User_rank_tab_list {
    private List<Tab> tab;

    public List<Tab> getTab() {
        return this.tab;
    }

    public void setTab(List<Tab> tab) {
        this.tab = tab;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User_rank_tab_list)) {
            return false;
        }
        User_rank_tab_list other = (User_rank_tab_list)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Tab> this$tab = this.getTab();
        List<Tab> other$tab = other.getTab();
        return !(this$tab == null ? other$tab != null : !this$tab.equals(other$tab));
    }

    protected boolean canEqual(Object other) {
        return other instanceof User_rank_tab_list;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Tab> $tab = this.getTab();
        result = result * 59 + ($tab == null ? 43 : $tab.hashCode());
        return result;
    }

    public String toString() {
        return "User_rank_tab_list(tab=" + this.getTab() + ")";
    }

    public User_rank_tab_list(List<Tab> tab) {
        this.tab = tab;
    }

    public User_rank_tab_list() {
    }
}


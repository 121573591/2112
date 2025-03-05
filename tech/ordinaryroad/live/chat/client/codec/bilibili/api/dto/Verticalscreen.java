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
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Guest_config;

public class Verticalscreen {
    private int master_ceiling;
    private int master_count;
    private List<Guest_config> guest_config;
    private int timeout;
    private int unusual_score;

    public int getMaster_ceiling() {
        return this.master_ceiling;
    }

    public int getMaster_count() {
        return this.master_count;
    }

    public List<Guest_config> getGuest_config() {
        return this.guest_config;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getUnusual_score() {
        return this.unusual_score;
    }

    public void setMaster_ceiling(int master_ceiling) {
        this.master_ceiling = master_ceiling;
    }

    public void setMaster_count(int master_count) {
        this.master_count = master_count;
    }

    public void setGuest_config(List<Guest_config> guest_config) {
        this.guest_config = guest_config;
    }

    public void setTimeout(int timeout2) {
        this.timeout = timeout2;
    }

    public void setUnusual_score(int unusual_score) {
        this.unusual_score = unusual_score;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Verticalscreen)) {
            return false;
        }
        Verticalscreen other = (Verticalscreen)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getMaster_ceiling() != other.getMaster_ceiling()) {
            return false;
        }
        if (this.getMaster_count() != other.getMaster_count()) {
            return false;
        }
        if (this.getTimeout() != other.getTimeout()) {
            return false;
        }
        if (this.getUnusual_score() != other.getUnusual_score()) {
            return false;
        }
        List<Guest_config> this$guest_config = this.getGuest_config();
        List<Guest_config> other$guest_config = other.getGuest_config();
        return !(this$guest_config == null ? other$guest_config != null : !this$guest_config.equals(other$guest_config));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Verticalscreen;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getMaster_ceiling();
        result = result * 59 + this.getMaster_count();
        result = result * 59 + this.getTimeout();
        result = result * 59 + this.getUnusual_score();
        List<Guest_config> $guest_config = this.getGuest_config();
        result = result * 59 + ($guest_config == null ? 43 : $guest_config.hashCode());
        return result;
    }

    public String toString() {
        return "Verticalscreen(master_ceiling=" + this.getMaster_ceiling() + ", master_count=" + this.getMaster_count() + ", guest_config=" + this.getGuest_config() + ", timeout=" + this.getTimeout() + ", unusual_score=" + this.getUnusual_score() + ")";
    }

    public Verticalscreen(int master_ceiling, int master_count, List<Guest_config> guest_config, int timeout2, int unusual_score) {
        this.master_ceiling = master_ceiling;
        this.master_count = master_count;
        this.guest_config = guest_config;
        this.timeout = timeout2;
        this.unusual_score = unusual_score;
    }

    public Verticalscreen() {
    }
}


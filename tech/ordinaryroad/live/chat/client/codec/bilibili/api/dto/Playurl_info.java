/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Playurl;

public class Playurl_info {
    private String conf_json;
    private Playurl playurl;

    public String getConf_json() {
        return this.conf_json;
    }

    public Playurl getPlayurl() {
        return this.playurl;
    }

    public void setConf_json(String conf_json) {
        this.conf_json = conf_json;
    }

    public void setPlayurl(Playurl playurl) {
        this.playurl = playurl;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Playurl_info)) {
            return false;
        }
        Playurl_info other = (Playurl_info)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$conf_json = this.getConf_json();
        String other$conf_json = other.getConf_json();
        if (this$conf_json == null ? other$conf_json != null : !this$conf_json.equals((Object)other$conf_json)) {
            return false;
        }
        Playurl this$playurl = this.getPlayurl();
        Playurl other$playurl = other.getPlayurl();
        return !(this$playurl == null ? other$playurl != null : !this$playurl.equals(other$playurl));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Playurl_info;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $conf_json = this.getConf_json();
        result = result * 59 + ($conf_json == null ? 43 : $conf_json.hashCode());
        Playurl $playurl = this.getPlayurl();
        result = result * 59 + ($playurl == null ? 43 : $playurl.hashCode());
        return result;
    }

    public String toString() {
        return "Playurl_info(conf_json=" + this.getConf_json() + ", playurl=" + this.getPlayurl() + ")";
    }

    public Playurl_info(String conf_json, Playurl playurl) {
        this.conf_json = conf_json;
        this.playurl = playurl;
    }

    public Playurl_info() {
    }
}


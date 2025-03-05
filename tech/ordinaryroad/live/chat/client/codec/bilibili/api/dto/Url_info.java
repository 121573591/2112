/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class Url_info {
    private String host;
    private String extra;
    private int stream_ttl;

    public String getHost() {
        return this.host;
    }

    public String getExtra() {
        return this.extra;
    }

    public int getStream_ttl() {
        return this.stream_ttl;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public void setStream_ttl(int stream_ttl) {
        this.stream_ttl = stream_ttl;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Url_info)) {
            return false;
        }
        Url_info other = (Url_info)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getStream_ttl() != other.getStream_ttl()) {
            return false;
        }
        String this$host = this.getHost();
        String other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals((Object)other$host)) {
            return false;
        }
        String this$extra = this.getExtra();
        String other$extra = other.getExtra();
        return !(this$extra == null ? other$extra != null : !this$extra.equals((Object)other$extra));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Url_info;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getStream_ttl();
        String $host = this.getHost();
        result = result * 59 + ($host == null ? 43 : $host.hashCode());
        String $extra = this.getExtra();
        result = result * 59 + ($extra == null ? 43 : $extra.hashCode());
        return result;
    }

    public String toString() {
        return "Url_info(host=" + this.getHost() + ", extra=" + this.getExtra() + ", stream_ttl=" + this.getStream_ttl() + ")";
    }

    public Url_info(String host, String extra, int stream_ttl) {
        this.host = host;
        this.extra = extra;
        this.stream_ttl = stream_ttl;
    }

    public Url_info() {
    }
}


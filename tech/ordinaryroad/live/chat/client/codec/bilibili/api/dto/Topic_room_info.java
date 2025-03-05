/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class Topic_room_info {
    private String interactive_h5_url;
    private int watermark;

    public String getInteractive_h5_url() {
        return this.interactive_h5_url;
    }

    public int getWatermark() {
        return this.watermark;
    }

    public void setInteractive_h5_url(String interactive_h5_url) {
        this.interactive_h5_url = interactive_h5_url;
    }

    public void setWatermark(int watermark) {
        this.watermark = watermark;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Topic_room_info)) {
            return false;
        }
        Topic_room_info other = (Topic_room_info)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getWatermark() != other.getWatermark()) {
            return false;
        }
        String this$interactive_h5_url = this.getInteractive_h5_url();
        String other$interactive_h5_url = other.getInteractive_h5_url();
        return !(this$interactive_h5_url == null ? other$interactive_h5_url != null : !this$interactive_h5_url.equals((Object)other$interactive_h5_url));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Topic_room_info;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getWatermark();
        String $interactive_h5_url = this.getInteractive_h5_url();
        result = result * 59 + ($interactive_h5_url == null ? 43 : $interactive_h5_url.hashCode());
        return result;
    }

    public String toString() {
        return "Topic_room_info(interactive_h5_url=" + this.getInteractive_h5_url() + ", watermark=" + this.getWatermark() + ")";
    }

    public Topic_room_info(String interactive_h5_url, int watermark) {
        this.interactive_h5_url = interactive_h5_url;
        this.watermark = watermark;
    }

    public Topic_room_info() {
    }
}


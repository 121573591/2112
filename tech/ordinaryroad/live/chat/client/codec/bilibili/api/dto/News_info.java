/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class News_info {
    private long uid;
    private String ctime;
    private String content;

    public long getUid() {
        return this.uid;
    }

    public String getCtime() {
        return this.ctime;
    }

    public String getContent() {
        return this.content;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof News_info)) {
            return false;
        }
        News_info other = (News_info)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getUid() != other.getUid()) {
            return false;
        }
        String this$ctime = this.getCtime();
        String other$ctime = other.getCtime();
        if (this$ctime == null ? other$ctime != null : !this$ctime.equals((Object)other$ctime)) {
            return false;
        }
        String this$content = this.getContent();
        String other$content = other.getContent();
        return !(this$content == null ? other$content != null : !this$content.equals((Object)other$content));
    }

    protected boolean canEqual(Object other) {
        return other instanceof News_info;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $uid = this.getUid();
        result = result * 59 + (int)($uid >>> 32 ^ $uid);
        String $ctime = this.getCtime();
        result = result * 59 + ($ctime == null ? 43 : $ctime.hashCode());
        String $content = this.getContent();
        result = result * 59 + ($content == null ? 43 : $content.hashCode());
        return result;
    }

    public String toString() {
        return "News_info(uid=" + this.getUid() + ", ctime=" + this.getCtime() + ", content=" + this.getContent() + ")";
    }

    public News_info(long uid, String ctime, String content) {
        this.uid = uid;
        this.ctime = ctime;
        this.content = content;
    }

    public News_info() {
    }
}


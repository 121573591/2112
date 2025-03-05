/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class Watched_show {
    private boolean switchShadowed;
    private long num;
    private String text_small;
    private String text_large;
    private String icon;
    private int icon_location;
    private String icon_web;

    public boolean isSwitchShadowed() {
        return this.switchShadowed;
    }

    public long getNum() {
        return this.num;
    }

    public String getText_small() {
        return this.text_small;
    }

    public String getText_large() {
        return this.text_large;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getIcon_location() {
        return this.icon_location;
    }

    public String getIcon_web() {
        return this.icon_web;
    }

    public void setSwitchShadowed(boolean switchShadowed) {
        this.switchShadowed = switchShadowed;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setText_small(String text_small) {
        this.text_small = text_small;
    }

    public void setText_large(String text_large) {
        this.text_large = text_large;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setIcon_location(int icon_location) {
        this.icon_location = icon_location;
    }

    public void setIcon_web(String icon_web) {
        this.icon_web = icon_web;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Watched_show)) {
            return false;
        }
        Watched_show other = (Watched_show)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isSwitchShadowed() != other.isSwitchShadowed()) {
            return false;
        }
        if (this.getNum() != other.getNum()) {
            return false;
        }
        if (this.getIcon_location() != other.getIcon_location()) {
            return false;
        }
        String this$text_small = this.getText_small();
        String other$text_small = other.getText_small();
        if (this$text_small == null ? other$text_small != null : !this$text_small.equals((Object)other$text_small)) {
            return false;
        }
        String this$text_large = this.getText_large();
        String other$text_large = other.getText_large();
        if (this$text_large == null ? other$text_large != null : !this$text_large.equals((Object)other$text_large)) {
            return false;
        }
        String this$icon = this.getIcon();
        String other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals((Object)other$icon)) {
            return false;
        }
        String this$icon_web = this.getIcon_web();
        String other$icon_web = other.getIcon_web();
        return !(this$icon_web == null ? other$icon_web != null : !this$icon_web.equals((Object)other$icon_web));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Watched_show;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isSwitchShadowed() ? 79 : 97);
        long $num = this.getNum();
        result = result * 59 + (int)($num >>> 32 ^ $num);
        result = result * 59 + this.getIcon_location();
        String $text_small = this.getText_small();
        result = result * 59 + ($text_small == null ? 43 : $text_small.hashCode());
        String $text_large = this.getText_large();
        result = result * 59 + ($text_large == null ? 43 : $text_large.hashCode());
        String $icon = this.getIcon();
        result = result * 59 + ($icon == null ? 43 : $icon.hashCode());
        String $icon_web = this.getIcon_web();
        result = result * 59 + ($icon_web == null ? 43 : $icon_web.hashCode());
        return result;
    }

    public String toString() {
        return "Watched_show(switchShadowed=" + this.isSwitchShadowed() + ", num=" + this.getNum() + ", text_small=" + this.getText_small() + ", text_large=" + this.getText_large() + ", icon=" + this.getIcon() + ", icon_location=" + this.getIcon_location() + ", icon_web=" + this.getIcon_web() + ")";
    }

    public Watched_show(boolean switchShadowed, long num, String text_small, String text_large, String icon, int icon_location, String icon_web) {
        this.switchShadowed = switchShadowed;
        this.num = num;
        this.text_small = text_small;
        this.text_large = text_large;
        this.icon = icon;
        this.icon_location = icon_location;
        this.icon_web = icon_web;
    }

    public Watched_show() {
    }
}


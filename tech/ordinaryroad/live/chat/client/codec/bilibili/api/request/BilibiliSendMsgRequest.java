/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.request;

public class BilibiliSendMsgRequest {
    private String bubble = "0";
    private String msg;
    private String color = "16777215";
    private String mode = "1";
    private String room_type = "0";
    private String jumpfrom = "0";
    private String fontsize = "25";
    private String rnd;
    private long roomid;
    private String csrf;
    private String csrf_token;

    public BilibiliSendMsgRequest(String msg, String rnd, long roomid, String csrf, String csrf_token) {
        this.msg = msg;
        this.rnd = rnd;
        this.roomid = roomid;
        this.csrf = csrf;
        this.csrf_token = csrf_token;
    }

    public String getBubble() {
        return this.bubble;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getColor() {
        return this.color;
    }

    public String getMode() {
        return this.mode;
    }

    public String getRoom_type() {
        return this.room_type;
    }

    public String getJumpfrom() {
        return this.jumpfrom;
    }

    public String getFontsize() {
        return this.fontsize;
    }

    public String getRnd() {
        return this.rnd;
    }

    public long getRoomid() {
        return this.roomid;
    }

    public String getCsrf() {
        return this.csrf;
    }

    public String getCsrf_token() {
        return this.csrf_token;
    }

    public void setBubble(String bubble) {
        this.bubble = bubble;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setJumpfrom(String jumpfrom) {
        this.jumpfrom = jumpfrom;
    }

    public void setFontsize(String fontsize) {
        this.fontsize = fontsize;
    }

    public void setRnd(String rnd) {
        this.rnd = rnd;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

    public void setCsrf_token(String csrf_token) {
        this.csrf_token = csrf_token;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BilibiliSendMsgRequest)) {
            return false;
        }
        BilibiliSendMsgRequest other = (BilibiliSendMsgRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getRoomid() != other.getRoomid()) {
            return false;
        }
        String this$bubble = this.getBubble();
        String other$bubble = other.getBubble();
        if (this$bubble == null ? other$bubble != null : !this$bubble.equals((Object)other$bubble)) {
            return false;
        }
        String this$msg = this.getMsg();
        String other$msg = other.getMsg();
        if (this$msg == null ? other$msg != null : !this$msg.equals((Object)other$msg)) {
            return false;
        }
        String this$color = this.getColor();
        String other$color = other.getColor();
        if (this$color == null ? other$color != null : !this$color.equals((Object)other$color)) {
            return false;
        }
        String this$mode = this.getMode();
        String other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals((Object)other$mode)) {
            return false;
        }
        String this$room_type = this.getRoom_type();
        String other$room_type = other.getRoom_type();
        if (this$room_type == null ? other$room_type != null : !this$room_type.equals((Object)other$room_type)) {
            return false;
        }
        String this$jumpfrom = this.getJumpfrom();
        String other$jumpfrom = other.getJumpfrom();
        if (this$jumpfrom == null ? other$jumpfrom != null : !this$jumpfrom.equals((Object)other$jumpfrom)) {
            return false;
        }
        String this$fontsize = this.getFontsize();
        String other$fontsize = other.getFontsize();
        if (this$fontsize == null ? other$fontsize != null : !this$fontsize.equals((Object)other$fontsize)) {
            return false;
        }
        String this$rnd = this.getRnd();
        String other$rnd = other.getRnd();
        if (this$rnd == null ? other$rnd != null : !this$rnd.equals((Object)other$rnd)) {
            return false;
        }
        String this$csrf = this.getCsrf();
        String other$csrf = other.getCsrf();
        if (this$csrf == null ? other$csrf != null : !this$csrf.equals((Object)other$csrf)) {
            return false;
        }
        String this$csrf_token = this.getCsrf_token();
        String other$csrf_token = other.getCsrf_token();
        return !(this$csrf_token == null ? other$csrf_token != null : !this$csrf_token.equals((Object)other$csrf_token));
    }

    protected boolean canEqual(Object other) {
        return other instanceof BilibiliSendMsgRequest;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $roomid = this.getRoomid();
        result = result * 59 + (int)($roomid >>> 32 ^ $roomid);
        String $bubble = this.getBubble();
        result = result * 59 + ($bubble == null ? 43 : $bubble.hashCode());
        String $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        String $color = this.getColor();
        result = result * 59 + ($color == null ? 43 : $color.hashCode());
        String $mode = this.getMode();
        result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
        String $room_type = this.getRoom_type();
        result = result * 59 + ($room_type == null ? 43 : $room_type.hashCode());
        String $jumpfrom = this.getJumpfrom();
        result = result * 59 + ($jumpfrom == null ? 43 : $jumpfrom.hashCode());
        String $fontsize = this.getFontsize();
        result = result * 59 + ($fontsize == null ? 43 : $fontsize.hashCode());
        String $rnd = this.getRnd();
        result = result * 59 + ($rnd == null ? 43 : $rnd.hashCode());
        String $csrf = this.getCsrf();
        result = result * 59 + ($csrf == null ? 43 : $csrf.hashCode());
        String $csrf_token = this.getCsrf_token();
        result = result * 59 + ($csrf_token == null ? 43 : $csrf_token.hashCode());
        return result;
    }

    public String toString() {
        return "BilibiliSendMsgRequest(bubble=" + this.getBubble() + ", msg=" + this.getMsg() + ", color=" + this.getColor() + ", mode=" + this.getMode() + ", room_type=" + this.getRoom_type() + ", jumpfrom=" + this.getJumpfrom() + ", fontsize=" + this.getFontsize() + ", rnd=" + this.getRnd() + ", roomid=" + this.getRoomid() + ", csrf=" + this.getCsrf() + ", csrf_token=" + this.getCsrf_token() + ")";
    }

    public BilibiliSendMsgRequest() {
    }
}


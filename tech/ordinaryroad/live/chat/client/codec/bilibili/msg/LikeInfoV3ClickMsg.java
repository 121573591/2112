/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.msg;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.OperationEnum;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.InteractWordMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base.BaseBilibiliMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ILikeMsg;

public class LikeInfoV3ClickMsg
extends BaseBilibiliMsg
implements ILikeMsg {
    private Data data;

    @Override
    public OperationEnum getOperationEnum() {
        return OperationEnum.MESSAGE;
    }

    @Override
    public String getBadgeName() {
        if (this.data == null || this.data.getFans_medal() == null) {
            return null;
        }
        return this.data.getFans_medal().getMedal_name();
    }

    @Override
    public byte getBadgeLevel() {
        if (this.data == null || this.data.getFans_medal() == null) {
            return 0;
        }
        return this.data.getFans_medal().getMedal_level();
    }

    @Override
    public String getUid() {
        if (this.data == null) {
            return null;
        }
        return Long.toString((long)this.data.getUid());
    }

    @Override
    public String getUsername() {
        if (this.data == null) {
            return "";
        }
        return this.data.getUname();
    }

    @Override
    public String getUserAvatar() {
        if (this.data == null || this.data.getUinfo() == null || this.data.getUinfo().getBase() == null) {
            return "";
        }
        return this.data.getUinfo().getBase().getFace();
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public LikeInfoV3ClickMsg(Data data) {
        this.data = data;
    }

    public LikeInfoV3ClickMsg() {
    }

    public static class Data {
        private int show_area;
        private int msg_type;
        private String like_icon;
        private long uid;
        private String like_text;
        private String uname;
        private String uname_color;
        private List<Integer> identities;
        private InteractWordMsg.Fans_medal fans_medal;
        private Contribution_info contribution_info;
        private int dmscore;
        private String group_medal;
        private boolean is_mystery;
        private InteractWordMsg.Uinfo uinfo;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public int getShow_area() {
            return this.show_area;
        }

        public int getMsg_type() {
            return this.msg_type;
        }

        public String getLike_icon() {
            return this.like_icon;
        }

        public long getUid() {
            return this.uid;
        }

        public String getLike_text() {
            return this.like_text;
        }

        public String getUname() {
            return this.uname;
        }

        public String getUname_color() {
            return this.uname_color;
        }

        public List<Integer> getIdentities() {
            return this.identities;
        }

        public InteractWordMsg.Fans_medal getFans_medal() {
            return this.fans_medal;
        }

        public Contribution_info getContribution_info() {
            return this.contribution_info;
        }

        public int getDmscore() {
            return this.dmscore;
        }

        public String getGroup_medal() {
            return this.group_medal;
        }

        public boolean is_mystery() {
            return this.is_mystery;
        }

        public InteractWordMsg.Uinfo getUinfo() {
            return this.uinfo;
        }

        public void setShow_area(int show_area) {
            this.show_area = show_area;
        }

        public void setMsg_type(int msg_type) {
            this.msg_type = msg_type;
        }

        public void setLike_icon(String like_icon) {
            this.like_icon = like_icon;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public void setLike_text(String like_text) {
            this.like_text = like_text;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public void setUname_color(String uname_color) {
            this.uname_color = uname_color;
        }

        public void setIdentities(List<Integer> identities) {
            this.identities = identities;
        }

        public void setFans_medal(InteractWordMsg.Fans_medal fans_medal) {
            this.fans_medal = fans_medal;
        }

        public void setContribution_info(Contribution_info contribution_info) {
            this.contribution_info = contribution_info;
        }

        public void setDmscore(int dmscore) {
            this.dmscore = dmscore;
        }

        public void setGroup_medal(String group_medal) {
            this.group_medal = group_medal;
        }

        public void set_mystery(boolean is_mystery) {
            this.is_mystery = is_mystery;
        }

        public void setUinfo(InteractWordMsg.Uinfo uinfo) {
            this.uinfo = uinfo;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Data)) {
                return false;
            }
            Data other = (Data)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getShow_area() != other.getShow_area()) {
                return false;
            }
            if (this.getMsg_type() != other.getMsg_type()) {
                return false;
            }
            if (this.getUid() != other.getUid()) {
                return false;
            }
            if (this.getDmscore() != other.getDmscore()) {
                return false;
            }
            if (this.is_mystery() != other.is_mystery()) {
                return false;
            }
            String this$like_icon = this.getLike_icon();
            String other$like_icon = other.getLike_icon();
            if (this$like_icon == null ? other$like_icon != null : !this$like_icon.equals((Object)other$like_icon)) {
                return false;
            }
            String this$like_text = this.getLike_text();
            String other$like_text = other.getLike_text();
            if (this$like_text == null ? other$like_text != null : !this$like_text.equals((Object)other$like_text)) {
                return false;
            }
            String this$uname = this.getUname();
            String other$uname = other.getUname();
            if (this$uname == null ? other$uname != null : !this$uname.equals((Object)other$uname)) {
                return false;
            }
            String this$uname_color = this.getUname_color();
            String other$uname_color = other.getUname_color();
            if (this$uname_color == null ? other$uname_color != null : !this$uname_color.equals((Object)other$uname_color)) {
                return false;
            }
            List<Integer> this$identities = this.getIdentities();
            List<Integer> other$identities = other.getIdentities();
            if (this$identities == null ? other$identities != null : !this$identities.equals(other$identities)) {
                return false;
            }
            InteractWordMsg.Fans_medal this$fans_medal = this.getFans_medal();
            InteractWordMsg.Fans_medal other$fans_medal = other.getFans_medal();
            if (this$fans_medal == null ? other$fans_medal != null : !this$fans_medal.equals(other$fans_medal)) {
                return false;
            }
            Contribution_info this$contribution_info = this.getContribution_info();
            Contribution_info other$contribution_info = other.getContribution_info();
            if (this$contribution_info == null ? other$contribution_info != null : !this$contribution_info.equals(other$contribution_info)) {
                return false;
            }
            String this$group_medal = this.getGroup_medal();
            String other$group_medal = other.getGroup_medal();
            if (this$group_medal == null ? other$group_medal != null : !this$group_medal.equals((Object)other$group_medal)) {
                return false;
            }
            InteractWordMsg.Uinfo this$uinfo = this.getUinfo();
            InteractWordMsg.Uinfo other$uinfo = other.getUinfo();
            if (this$uinfo == null ? other$uinfo != null : !this$uinfo.equals(other$uinfo)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Data;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getShow_area();
            result = result * 59 + this.getMsg_type();
            long $uid = this.getUid();
            result = result * 59 + (int)($uid >>> 32 ^ $uid);
            result = result * 59 + this.getDmscore();
            result = result * 59 + (this.is_mystery() ? 79 : 97);
            String $like_icon = this.getLike_icon();
            result = result * 59 + ($like_icon == null ? 43 : $like_icon.hashCode());
            String $like_text = this.getLike_text();
            result = result * 59 + ($like_text == null ? 43 : $like_text.hashCode());
            String $uname = this.getUname();
            result = result * 59 + ($uname == null ? 43 : $uname.hashCode());
            String $uname_color = this.getUname_color();
            result = result * 59 + ($uname_color == null ? 43 : $uname_color.hashCode());
            List<Integer> $identities = this.getIdentities();
            result = result * 59 + ($identities == null ? 43 : $identities.hashCode());
            InteractWordMsg.Fans_medal $fans_medal = this.getFans_medal();
            result = result * 59 + ($fans_medal == null ? 43 : $fans_medal.hashCode());
            Contribution_info $contribution_info = this.getContribution_info();
            result = result * 59 + ($contribution_info == null ? 43 : $contribution_info.hashCode());
            String $group_medal = this.getGroup_medal();
            result = result * 59 + ($group_medal == null ? 43 : $group_medal.hashCode());
            InteractWordMsg.Uinfo $uinfo = this.getUinfo();
            result = result * 59 + ($uinfo == null ? 43 : $uinfo.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "LikeInfoV3ClickMsg.Data(show_area=" + this.getShow_area() + ", msg_type=" + this.getMsg_type() + ", like_icon=" + this.getLike_icon() + ", uid=" + this.getUid() + ", like_text=" + this.getLike_text() + ", uname=" + this.getUname() + ", uname_color=" + this.getUname_color() + ", identities=" + this.getIdentities() + ", fans_medal=" + this.getFans_medal() + ", contribution_info=" + this.getContribution_info() + ", dmscore=" + this.getDmscore() + ", group_medal=" + this.getGroup_medal() + ", is_mystery=" + this.is_mystery() + ", uinfo=" + this.getUinfo() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Contribution_info {
        private int grade;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public int getGrade() {
            return this.grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Contribution_info)) {
                return false;
            }
            Contribution_info other = (Contribution_info)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getGrade() != other.getGrade()) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Contribution_info;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getGrade();
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "LikeInfoV3ClickMsg.Contribution_info(grade=" + this.getGrade() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }
}


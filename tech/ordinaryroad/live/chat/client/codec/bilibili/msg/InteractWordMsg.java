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
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base.BaseBilibiliMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.IEnterRoomMsg;

public class InteractWordMsg
extends BaseBilibiliMsg
implements IEnterRoomMsg {
    private Data data;

    @Override
    public OperationEnum getOperationEnum() {
        return OperationEnum.MESSAGE;
    }

    @Override
    public String getBadgeName() {
        if (this.data == null || this.data.fans_medal == null) {
            return null;
        }
        return this.data.fans_medal.medal_name;
    }

    @Override
    public byte getBadgeLevel() {
        if (this.data == null || this.data.fans_medal == null) {
            return 0;
        }
        return this.data.fans_medal.medal_level;
    }

    @Override
    public String getUid() {
        if (this.data == null) {
            return null;
        }
        return Long.toString((long)this.data.uid);
    }

    @Override
    public String getUsername() {
        if (this.data == null) {
            return null;
        }
        return this.data.uname;
    }

    @Override
    public String getUserAvatar() {
        if (this.data == null || this.data.uinfo == null || this.data.uinfo.base == null) {
            return null;
        }
        return this.data.uinfo.base.face;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public InteractWordMsg(Data data) {
        this.data = data;
    }

    public InteractWordMsg() {
    }

    public static class Data {
        private Contribution contribution;
        private Contribution_v2 contribution_v2;
        private int core_user_type;
        private int dmscore;
        private Fans_medal fans_medal;
        private String group_medal;
        private List<Integer> identities;
        private boolean is_mystery;
        private int is_spread;
        private int msg_type;
        private int privilege_type;
        private long roomid;
        private long score;
        private String spread_desc;
        private String spread_info;
        private int tail_icon;
        private String tail_text;
        private long timestamp;
        private long trigger_time;
        private long uid;
        private Uinfo uinfo;
        private String uname;
        private String uname_color;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public Contribution getContribution() {
            return this.contribution;
        }

        public Contribution_v2 getContribution_v2() {
            return this.contribution_v2;
        }

        public int getCore_user_type() {
            return this.core_user_type;
        }

        public int getDmscore() {
            return this.dmscore;
        }

        public Fans_medal getFans_medal() {
            return this.fans_medal;
        }

        public String getGroup_medal() {
            return this.group_medal;
        }

        public List<Integer> getIdentities() {
            return this.identities;
        }

        public boolean is_mystery() {
            return this.is_mystery;
        }

        public int getIs_spread() {
            return this.is_spread;
        }

        public int getMsg_type() {
            return this.msg_type;
        }

        public int getPrivilege_type() {
            return this.privilege_type;
        }

        public long getRoomid() {
            return this.roomid;
        }

        public long getScore() {
            return this.score;
        }

        public String getSpread_desc() {
            return this.spread_desc;
        }

        public String getSpread_info() {
            return this.spread_info;
        }

        public int getTail_icon() {
            return this.tail_icon;
        }

        public String getTail_text() {
            return this.tail_text;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public long getTrigger_time() {
            return this.trigger_time;
        }

        public long getUid() {
            return this.uid;
        }

        public Uinfo getUinfo() {
            return this.uinfo;
        }

        public String getUname() {
            return this.uname;
        }

        public String getUname_color() {
            return this.uname_color;
        }

        public void setContribution(Contribution contribution) {
            this.contribution = contribution;
        }

        public void setContribution_v2(Contribution_v2 contribution_v2) {
            this.contribution_v2 = contribution_v2;
        }

        public void setCore_user_type(int core_user_type) {
            this.core_user_type = core_user_type;
        }

        public void setDmscore(int dmscore) {
            this.dmscore = dmscore;
        }

        public void setFans_medal(Fans_medal fans_medal) {
            this.fans_medal = fans_medal;
        }

        public void setGroup_medal(String group_medal) {
            this.group_medal = group_medal;
        }

        public void setIdentities(List<Integer> identities) {
            this.identities = identities;
        }

        public void set_mystery(boolean is_mystery) {
            this.is_mystery = is_mystery;
        }

        public void setIs_spread(int is_spread) {
            this.is_spread = is_spread;
        }

        public void setMsg_type(int msg_type) {
            this.msg_type = msg_type;
        }

        public void setPrivilege_type(int privilege_type) {
            this.privilege_type = privilege_type;
        }

        public void setRoomid(long roomid) {
            this.roomid = roomid;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public void setSpread_desc(String spread_desc) {
            this.spread_desc = spread_desc;
        }

        public void setSpread_info(String spread_info) {
            this.spread_info = spread_info;
        }

        public void setTail_icon(int tail_icon) {
            this.tail_icon = tail_icon;
        }

        public void setTail_text(String tail_text) {
            this.tail_text = tail_text;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public void setTrigger_time(long trigger_time) {
            this.trigger_time = trigger_time;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public void setUinfo(Uinfo uinfo) {
            this.uinfo = uinfo;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public void setUname_color(String uname_color) {
            this.uname_color = uname_color;
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
            if (this.getCore_user_type() != other.getCore_user_type()) {
                return false;
            }
            if (this.getDmscore() != other.getDmscore()) {
                return false;
            }
            if (this.is_mystery() != other.is_mystery()) {
                return false;
            }
            if (this.getIs_spread() != other.getIs_spread()) {
                return false;
            }
            if (this.getMsg_type() != other.getMsg_type()) {
                return false;
            }
            if (this.getPrivilege_type() != other.getPrivilege_type()) {
                return false;
            }
            if (this.getRoomid() != other.getRoomid()) {
                return false;
            }
            if (this.getScore() != other.getScore()) {
                return false;
            }
            if (this.getTail_icon() != other.getTail_icon()) {
                return false;
            }
            if (this.getTimestamp() != other.getTimestamp()) {
                return false;
            }
            if (this.getTrigger_time() != other.getTrigger_time()) {
                return false;
            }
            if (this.getUid() != other.getUid()) {
                return false;
            }
            Contribution this$contribution = this.getContribution();
            Contribution other$contribution = other.getContribution();
            if (this$contribution == null ? other$contribution != null : !this$contribution.equals(other$contribution)) {
                return false;
            }
            Contribution_v2 this$contribution_v2 = this.getContribution_v2();
            Contribution_v2 other$contribution_v2 = other.getContribution_v2();
            if (this$contribution_v2 == null ? other$contribution_v2 != null : !this$contribution_v2.equals(other$contribution_v2)) {
                return false;
            }
            Fans_medal this$fans_medal = this.getFans_medal();
            Fans_medal other$fans_medal = other.getFans_medal();
            if (this$fans_medal == null ? other$fans_medal != null : !this$fans_medal.equals(other$fans_medal)) {
                return false;
            }
            String this$group_medal = this.getGroup_medal();
            String other$group_medal = other.getGroup_medal();
            if (this$group_medal == null ? other$group_medal != null : !this$group_medal.equals((Object)other$group_medal)) {
                return false;
            }
            List<Integer> this$identities = this.getIdentities();
            List<Integer> other$identities = other.getIdentities();
            if (this$identities == null ? other$identities != null : !this$identities.equals(other$identities)) {
                return false;
            }
            String this$spread_desc = this.getSpread_desc();
            String other$spread_desc = other.getSpread_desc();
            if (this$spread_desc == null ? other$spread_desc != null : !this$spread_desc.equals((Object)other$spread_desc)) {
                return false;
            }
            String this$spread_info = this.getSpread_info();
            String other$spread_info = other.getSpread_info();
            if (this$spread_info == null ? other$spread_info != null : !this$spread_info.equals((Object)other$spread_info)) {
                return false;
            }
            String this$tail_text = this.getTail_text();
            String other$tail_text = other.getTail_text();
            if (this$tail_text == null ? other$tail_text != null : !this$tail_text.equals((Object)other$tail_text)) {
                return false;
            }
            Uinfo this$uinfo = this.getUinfo();
            Uinfo other$uinfo = other.getUinfo();
            if (this$uinfo == null ? other$uinfo != null : !this$uinfo.equals(other$uinfo)) {
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
            result = result * 59 + this.getCore_user_type();
            result = result * 59 + this.getDmscore();
            result = result * 59 + (this.is_mystery() ? 79 : 97);
            result = result * 59 + this.getIs_spread();
            result = result * 59 + this.getMsg_type();
            result = result * 59 + this.getPrivilege_type();
            long $roomid = this.getRoomid();
            result = result * 59 + (int)($roomid >>> 32 ^ $roomid);
            long $score = this.getScore();
            result = result * 59 + (int)($score >>> 32 ^ $score);
            result = result * 59 + this.getTail_icon();
            long $timestamp = this.getTimestamp();
            result = result * 59 + (int)($timestamp >>> 32 ^ $timestamp);
            long $trigger_time = this.getTrigger_time();
            result = result * 59 + (int)($trigger_time >>> 32 ^ $trigger_time);
            long $uid = this.getUid();
            result = result * 59 + (int)($uid >>> 32 ^ $uid);
            Contribution $contribution = this.getContribution();
            result = result * 59 + ($contribution == null ? 43 : $contribution.hashCode());
            Contribution_v2 $contribution_v2 = this.getContribution_v2();
            result = result * 59 + ($contribution_v2 == null ? 43 : $contribution_v2.hashCode());
            Fans_medal $fans_medal = this.getFans_medal();
            result = result * 59 + ($fans_medal == null ? 43 : $fans_medal.hashCode());
            String $group_medal = this.getGroup_medal();
            result = result * 59 + ($group_medal == null ? 43 : $group_medal.hashCode());
            List<Integer> $identities = this.getIdentities();
            result = result * 59 + ($identities == null ? 43 : $identities.hashCode());
            String $spread_desc = this.getSpread_desc();
            result = result * 59 + ($spread_desc == null ? 43 : $spread_desc.hashCode());
            String $spread_info = this.getSpread_info();
            result = result * 59 + ($spread_info == null ? 43 : $spread_info.hashCode());
            String $tail_text = this.getTail_text();
            result = result * 59 + ($tail_text == null ? 43 : $tail_text.hashCode());
            Uinfo $uinfo = this.getUinfo();
            result = result * 59 + ($uinfo == null ? 43 : $uinfo.hashCode());
            String $uname = this.getUname();
            result = result * 59 + ($uname == null ? 43 : $uname.hashCode());
            String $uname_color = this.getUname_color();
            result = result * 59 + ($uname_color == null ? 43 : $uname_color.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Data(contribution=" + this.getContribution() + ", contribution_v2=" + this.getContribution_v2() + ", core_user_type=" + this.getCore_user_type() + ", dmscore=" + this.getDmscore() + ", fans_medal=" + this.getFans_medal() + ", group_medal=" + this.getGroup_medal() + ", identities=" + this.getIdentities() + ", is_mystery=" + this.is_mystery() + ", is_spread=" + this.getIs_spread() + ", msg_type=" + this.getMsg_type() + ", privilege_type=" + this.getPrivilege_type() + ", roomid=" + this.getRoomid() + ", score=" + this.getScore() + ", spread_desc=" + this.getSpread_desc() + ", spread_info=" + this.getSpread_info() + ", tail_icon=" + this.getTail_icon() + ", tail_text=" + this.getTail_text() + ", timestamp=" + this.getTimestamp() + ", trigger_time=" + this.getTrigger_time() + ", uid=" + this.getUid() + ", uinfo=" + this.getUinfo() + ", uname=" + this.getUname() + ", uname_color=" + this.getUname_color() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Fans_medal {
        private long anchor_roomid;
        private int guard_level;
        private int icon_id;
        private int is_lighted;
        private long medal_color;
        private long medal_color_border;
        private long medal_color_end;
        private long medal_color_start;
        private byte medal_level;
        private String medal_name;
        private long score;
        private String special;
        private long target_id;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public long getAnchor_roomid() {
            return this.anchor_roomid;
        }

        public int getGuard_level() {
            return this.guard_level;
        }

        public int getIcon_id() {
            return this.icon_id;
        }

        public int getIs_lighted() {
            return this.is_lighted;
        }

        public long getMedal_color() {
            return this.medal_color;
        }

        public long getMedal_color_border() {
            return this.medal_color_border;
        }

        public long getMedal_color_end() {
            return this.medal_color_end;
        }

        public long getMedal_color_start() {
            return this.medal_color_start;
        }

        public byte getMedal_level() {
            return this.medal_level;
        }

        public String getMedal_name() {
            return this.medal_name;
        }

        public long getScore() {
            return this.score;
        }

        public String getSpecial() {
            return this.special;
        }

        public long getTarget_id() {
            return this.target_id;
        }

        public void setAnchor_roomid(long anchor_roomid) {
            this.anchor_roomid = anchor_roomid;
        }

        public void setGuard_level(int guard_level) {
            this.guard_level = guard_level;
        }

        public void setIcon_id(int icon_id) {
            this.icon_id = icon_id;
        }

        public void setIs_lighted(int is_lighted) {
            this.is_lighted = is_lighted;
        }

        public void setMedal_color(long medal_color) {
            this.medal_color = medal_color;
        }

        public void setMedal_color_border(long medal_color_border) {
            this.medal_color_border = medal_color_border;
        }

        public void setMedal_color_end(long medal_color_end) {
            this.medal_color_end = medal_color_end;
        }

        public void setMedal_color_start(long medal_color_start) {
            this.medal_color_start = medal_color_start;
        }

        public void setMedal_level(byte medal_level) {
            this.medal_level = medal_level;
        }

        public void setMedal_name(String medal_name) {
            this.medal_name = medal_name;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public void setSpecial(String special) {
            this.special = special;
        }

        public void setTarget_id(long target_id) {
            this.target_id = target_id;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Fans_medal)) {
                return false;
            }
            Fans_medal other = (Fans_medal)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getAnchor_roomid() != other.getAnchor_roomid()) {
                return false;
            }
            if (this.getGuard_level() != other.getGuard_level()) {
                return false;
            }
            if (this.getIcon_id() != other.getIcon_id()) {
                return false;
            }
            if (this.getIs_lighted() != other.getIs_lighted()) {
                return false;
            }
            if (this.getMedal_color() != other.getMedal_color()) {
                return false;
            }
            if (this.getMedal_color_border() != other.getMedal_color_border()) {
                return false;
            }
            if (this.getMedal_color_end() != other.getMedal_color_end()) {
                return false;
            }
            if (this.getMedal_color_start() != other.getMedal_color_start()) {
                return false;
            }
            if (this.getMedal_level() != other.getMedal_level()) {
                return false;
            }
            if (this.getScore() != other.getScore()) {
                return false;
            }
            if (this.getTarget_id() != other.getTarget_id()) {
                return false;
            }
            String this$medal_name = this.getMedal_name();
            String other$medal_name = other.getMedal_name();
            if (this$medal_name == null ? other$medal_name != null : !this$medal_name.equals((Object)other$medal_name)) {
                return false;
            }
            String this$special = this.getSpecial();
            String other$special = other.getSpecial();
            if (this$special == null ? other$special != null : !this$special.equals((Object)other$special)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Fans_medal;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            long $anchor_roomid = this.getAnchor_roomid();
            result = result * 59 + (int)($anchor_roomid >>> 32 ^ $anchor_roomid);
            result = result * 59 + this.getGuard_level();
            result = result * 59 + this.getIcon_id();
            result = result * 59 + this.getIs_lighted();
            long $medal_color = this.getMedal_color();
            result = result * 59 + (int)($medal_color >>> 32 ^ $medal_color);
            long $medal_color_border = this.getMedal_color_border();
            result = result * 59 + (int)($medal_color_border >>> 32 ^ $medal_color_border);
            long $medal_color_end = this.getMedal_color_end();
            result = result * 59 + (int)($medal_color_end >>> 32 ^ $medal_color_end);
            long $medal_color_start = this.getMedal_color_start();
            result = result * 59 + (int)($medal_color_start >>> 32 ^ $medal_color_start);
            result = result * 59 + this.getMedal_level();
            long $score = this.getScore();
            result = result * 59 + (int)($score >>> 32 ^ $score);
            long $target_id = this.getTarget_id();
            result = result * 59 + (int)($target_id >>> 32 ^ $target_id);
            String $medal_name = this.getMedal_name();
            result = result * 59 + ($medal_name == null ? 43 : $medal_name.hashCode());
            String $special = this.getSpecial();
            result = result * 59 + ($special == null ? 43 : $special.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Fans_medal(anchor_roomid=" + this.getAnchor_roomid() + ", guard_level=" + this.getGuard_level() + ", icon_id=" + this.getIcon_id() + ", is_lighted=" + this.getIs_lighted() + ", medal_color=" + this.getMedal_color() + ", medal_color_border=" + this.getMedal_color_border() + ", medal_color_end=" + this.getMedal_color_end() + ", medal_color_start=" + this.getMedal_color_start() + ", medal_level=" + this.getMedal_level() + ", medal_name=" + this.getMedal_name() + ", score=" + this.getScore() + ", special=" + this.getSpecial() + ", target_id=" + this.getTarget_id() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Uinfo {
        private long uid;
        private Base base;
        private Medal medal;
        private JsonNode wealth;
        private String title;
        private Guard guard;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public long getUid() {
            return this.uid;
        }

        public Base getBase() {
            return this.base;
        }

        public Medal getMedal() {
            return this.medal;
        }

        public JsonNode getWealth() {
            return this.wealth;
        }

        public String getTitle() {
            return this.title;
        }

        public Guard getGuard() {
            return this.guard;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public void setBase(Base base) {
            this.base = base;
        }

        public void setMedal(Medal medal) {
            this.medal = medal;
        }

        public void setWealth(JsonNode wealth) {
            this.wealth = wealth;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGuard(Guard guard) {
            this.guard = guard;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Uinfo)) {
                return false;
            }
            Uinfo other = (Uinfo)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getUid() != other.getUid()) {
                return false;
            }
            Base this$base = this.getBase();
            Base other$base = other.getBase();
            if (this$base == null ? other$base != null : !this$base.equals(other$base)) {
                return false;
            }
            Medal this$medal = this.getMedal();
            Medal other$medal = other.getMedal();
            if (this$medal == null ? other$medal != null : !this$medal.equals(other$medal)) {
                return false;
            }
            JsonNode this$wealth = this.getWealth();
            JsonNode other$wealth = other.getWealth();
            if (this$wealth == null ? other$wealth != null : !this$wealth.equals(other$wealth)) {
                return false;
            }
            String this$title = this.getTitle();
            String other$title = other.getTitle();
            if (this$title == null ? other$title != null : !this$title.equals((Object)other$title)) {
                return false;
            }
            Guard this$guard = this.getGuard();
            Guard other$guard = other.getGuard();
            if (this$guard == null ? other$guard != null : !this$guard.equals(other$guard)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Uinfo;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            long $uid = this.getUid();
            result = result * 59 + (int)($uid >>> 32 ^ $uid);
            Base $base = this.getBase();
            result = result * 59 + ($base == null ? 43 : $base.hashCode());
            Medal $medal = this.getMedal();
            result = result * 59 + ($medal == null ? 43 : $medal.hashCode());
            JsonNode $wealth = this.getWealth();
            result = result * 59 + ($wealth == null ? 43 : $wealth.hashCode());
            String $title = this.getTitle();
            result = result * 59 + ($title == null ? 43 : $title.hashCode());
            Guard $guard = this.getGuard();
            result = result * 59 + ($guard == null ? 43 : $guard.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Uinfo(uid=" + this.getUid() + ", base=" + this.getBase() + ", medal=" + this.getMedal() + ", wealth=" + this.getWealth() + ", title=" + this.getTitle() + ", guard=" + this.getGuard() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Base {
        private String face;
        private boolean is_mystery;
        private String name;
        private int name_color;
        private Origin_info origin_info;
        private Risk_ctrl_info risk_ctrl_info;
        private Official_info official_info;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public String getFace() {
            return this.face;
        }

        public boolean is_mystery() {
            return this.is_mystery;
        }

        public String getName() {
            return this.name;
        }

        public int getName_color() {
            return this.name_color;
        }

        public Origin_info getOrigin_info() {
            return this.origin_info;
        }

        public Risk_ctrl_info getRisk_ctrl_info() {
            return this.risk_ctrl_info;
        }

        public Official_info getOfficial_info() {
            return this.official_info;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public void set_mystery(boolean is_mystery) {
            this.is_mystery = is_mystery;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setName_color(int name_color) {
            this.name_color = name_color;
        }

        public void setOrigin_info(Origin_info origin_info) {
            this.origin_info = origin_info;
        }

        public void setRisk_ctrl_info(Risk_ctrl_info risk_ctrl_info) {
            this.risk_ctrl_info = risk_ctrl_info;
        }

        public void setOfficial_info(Official_info official_info) {
            this.official_info = official_info;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Base)) {
                return false;
            }
            Base other = (Base)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.is_mystery() != other.is_mystery()) {
                return false;
            }
            if (this.getName_color() != other.getName_color()) {
                return false;
            }
            String this$face = this.getFace();
            String other$face = other.getFace();
            if (this$face == null ? other$face != null : !this$face.equals((Object)other$face)) {
                return false;
            }
            String this$name = this.getName();
            String other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals((Object)other$name)) {
                return false;
            }
            Origin_info this$origin_info = this.getOrigin_info();
            Origin_info other$origin_info = other.getOrigin_info();
            if (this$origin_info == null ? other$origin_info != null : !this$origin_info.equals(other$origin_info)) {
                return false;
            }
            Risk_ctrl_info this$risk_ctrl_info = this.getRisk_ctrl_info();
            Risk_ctrl_info other$risk_ctrl_info = other.getRisk_ctrl_info();
            if (this$risk_ctrl_info == null ? other$risk_ctrl_info != null : !this$risk_ctrl_info.equals(other$risk_ctrl_info)) {
                return false;
            }
            Official_info this$official_info = this.getOfficial_info();
            Official_info other$official_info = other.getOfficial_info();
            if (this$official_info == null ? other$official_info != null : !this$official_info.equals(other$official_info)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Base;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + (this.is_mystery() ? 79 : 97);
            result = result * 59 + this.getName_color();
            String $face = this.getFace();
            result = result * 59 + ($face == null ? 43 : $face.hashCode());
            String $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Origin_info $origin_info = this.getOrigin_info();
            result = result * 59 + ($origin_info == null ? 43 : $origin_info.hashCode());
            Risk_ctrl_info $risk_ctrl_info = this.getRisk_ctrl_info();
            result = result * 59 + ($risk_ctrl_info == null ? 43 : $risk_ctrl_info.hashCode());
            Official_info $official_info = this.getOfficial_info();
            result = result * 59 + ($official_info == null ? 43 : $official_info.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Base(face=" + this.getFace() + ", is_mystery=" + this.is_mystery() + ", name=" + this.getName() + ", name_color=" + this.getName_color() + ", origin_info=" + this.getOrigin_info() + ", risk_ctrl_info=" + this.getRisk_ctrl_info() + ", official_info=" + this.getOfficial_info() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Guard {
        private int level;
        private String expired_str;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public int getLevel() {
            return this.level;
        }

        public String getExpired_str() {
            return this.expired_str;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setExpired_str(String expired_str) {
            this.expired_str = expired_str;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Guard)) {
                return false;
            }
            Guard other = (Guard)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getLevel() != other.getLevel()) {
                return false;
            }
            String this$expired_str = this.getExpired_str();
            String other$expired_str = other.getExpired_str();
            if (this$expired_str == null ? other$expired_str != null : !this$expired_str.equals((Object)other$expired_str)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Guard;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getLevel();
            String $expired_str = this.getExpired_str();
            result = result * 59 + ($expired_str == null ? 43 : $expired_str.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Guard(level=" + this.getLevel() + ", expired_str=" + this.getExpired_str() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Medal {
        private String name;
        private int level;
        private long color_start;
        private long color_end;
        private long color_border;
        private long color;
        private int id;
        private int typ;
        private int is_light;
        private long ruid;
        private int guard_level;
        private int score;
        private String guard_icon;
        private String honor_icon;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public String getName() {
            return this.name;
        }

        public int getLevel() {
            return this.level;
        }

        public long getColor_start() {
            return this.color_start;
        }

        public long getColor_end() {
            return this.color_end;
        }

        public long getColor_border() {
            return this.color_border;
        }

        public long getColor() {
            return this.color;
        }

        public int getId() {
            return this.id;
        }

        public int getTyp() {
            return this.typ;
        }

        public int getIs_light() {
            return this.is_light;
        }

        public long getRuid() {
            return this.ruid;
        }

        public int getGuard_level() {
            return this.guard_level;
        }

        public int getScore() {
            return this.score;
        }

        public String getGuard_icon() {
            return this.guard_icon;
        }

        public String getHonor_icon() {
            return this.honor_icon;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public void setColor_start(long color_start) {
            this.color_start = color_start;
        }

        public void setColor_end(long color_end) {
            this.color_end = color_end;
        }

        public void setColor_border(long color_border) {
            this.color_border = color_border;
        }

        public void setColor(long color) {
            this.color = color;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTyp(int typ) {
            this.typ = typ;
        }

        public void setIs_light(int is_light) {
            this.is_light = is_light;
        }

        public void setRuid(long ruid) {
            this.ruid = ruid;
        }

        public void setGuard_level(int guard_level) {
            this.guard_level = guard_level;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setGuard_icon(String guard_icon) {
            this.guard_icon = guard_icon;
        }

        public void setHonor_icon(String honor_icon) {
            this.honor_icon = honor_icon;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Medal)) {
                return false;
            }
            Medal other = (Medal)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getLevel() != other.getLevel()) {
                return false;
            }
            if (this.getColor_start() != other.getColor_start()) {
                return false;
            }
            if (this.getColor_end() != other.getColor_end()) {
                return false;
            }
            if (this.getColor_border() != other.getColor_border()) {
                return false;
            }
            if (this.getColor() != other.getColor()) {
                return false;
            }
            if (this.getId() != other.getId()) {
                return false;
            }
            if (this.getTyp() != other.getTyp()) {
                return false;
            }
            if (this.getIs_light() != other.getIs_light()) {
                return false;
            }
            if (this.getRuid() != other.getRuid()) {
                return false;
            }
            if (this.getGuard_level() != other.getGuard_level()) {
                return false;
            }
            if (this.getScore() != other.getScore()) {
                return false;
            }
            String this$name = this.getName();
            String other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals((Object)other$name)) {
                return false;
            }
            String this$guard_icon = this.getGuard_icon();
            String other$guard_icon = other.getGuard_icon();
            if (this$guard_icon == null ? other$guard_icon != null : !this$guard_icon.equals((Object)other$guard_icon)) {
                return false;
            }
            String this$honor_icon = this.getHonor_icon();
            String other$honor_icon = other.getHonor_icon();
            if (this$honor_icon == null ? other$honor_icon != null : !this$honor_icon.equals((Object)other$honor_icon)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Medal;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getLevel();
            long $color_start = this.getColor_start();
            result = result * 59 + (int)($color_start >>> 32 ^ $color_start);
            long $color_end = this.getColor_end();
            result = result * 59 + (int)($color_end >>> 32 ^ $color_end);
            long $color_border = this.getColor_border();
            result = result * 59 + (int)($color_border >>> 32 ^ $color_border);
            long $color = this.getColor();
            result = result * 59 + (int)($color >>> 32 ^ $color);
            result = result * 59 + this.getId();
            result = result * 59 + this.getTyp();
            result = result * 59 + this.getIs_light();
            long $ruid = this.getRuid();
            result = result * 59 + (int)($ruid >>> 32 ^ $ruid);
            result = result * 59 + this.getGuard_level();
            result = result * 59 + this.getScore();
            String $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            String $guard_icon = this.getGuard_icon();
            result = result * 59 + ($guard_icon == null ? 43 : $guard_icon.hashCode());
            String $honor_icon = this.getHonor_icon();
            result = result * 59 + ($honor_icon == null ? 43 : $honor_icon.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Medal(name=" + this.getName() + ", level=" + this.getLevel() + ", color_start=" + this.getColor_start() + ", color_end=" + this.getColor_end() + ", color_border=" + this.getColor_border() + ", color=" + this.getColor() + ", id=" + this.getId() + ", typ=" + this.getTyp() + ", is_light=" + this.getIs_light() + ", ruid=" + this.getRuid() + ", guard_level=" + this.getGuard_level() + ", score=" + this.getScore() + ", guard_icon=" + this.getGuard_icon() + ", honor_icon=" + this.getHonor_icon() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Official_info {
        private int role;
        private String title;
        private String desc;
        private int type;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public int getRole() {
            return this.role;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDesc() {
            return this.desc;
        }

        public int getType() {
            return this.type;
        }

        public void setRole(int role) {
            this.role = role;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setType(int type) {
            this.type = type;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Official_info)) {
                return false;
            }
            Official_info other = (Official_info)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getRole() != other.getRole()) {
                return false;
            }
            if (this.getType() != other.getType()) {
                return false;
            }
            String this$title = this.getTitle();
            String other$title = other.getTitle();
            if (this$title == null ? other$title != null : !this$title.equals((Object)other$title)) {
                return false;
            }
            String this$desc = this.getDesc();
            String other$desc = other.getDesc();
            if (this$desc == null ? other$desc != null : !this$desc.equals((Object)other$desc)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Official_info;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getRole();
            result = result * 59 + this.getType();
            String $title = this.getTitle();
            result = result * 59 + ($title == null ? 43 : $title.hashCode());
            String $desc = this.getDesc();
            result = result * 59 + ($desc == null ? 43 : $desc.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Official_info(role=" + this.getRole() + ", title=" + this.getTitle() + ", desc=" + this.getDesc() + ", type=" + this.getType() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Risk_ctrl_info {
        private String face;
        private String name;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public String getFace() {
            return this.face;
        }

        public String getName() {
            return this.name;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Risk_ctrl_info)) {
                return false;
            }
            Risk_ctrl_info other = (Risk_ctrl_info)o;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$face = this.getFace();
            String other$face = other.getFace();
            if (this$face == null ? other$face != null : !this$face.equals((Object)other$face)) {
                return false;
            }
            String this$name = this.getName();
            String other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals((Object)other$name)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Risk_ctrl_info;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $face = this.getFace();
            result = result * 59 + ($face == null ? 43 : $face.hashCode());
            String $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Risk_ctrl_info(face=" + this.getFace() + ", name=" + this.getName() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Origin_info {
        private String face;
        private String name;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public String getFace() {
            return this.face;
        }

        public String getName() {
            return this.name;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Origin_info)) {
                return false;
            }
            Origin_info other = (Origin_info)o;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$face = this.getFace();
            String other$face = other.getFace();
            if (this$face == null ? other$face != null : !this$face.equals((Object)other$face)) {
                return false;
            }
            String this$name = this.getName();
            String other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals((Object)other$name)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Origin_info;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $face = this.getFace();
            result = result * 59 + ($face == null ? 43 : $face.hashCode());
            String $name = this.getName();
            result = result * 59 + ($name == null ? 43 : $name.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Origin_info(face=" + this.getFace() + ", name=" + this.getName() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Contribution_v2 {
        private int grade;
        private String rank_type;
        private String text;
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

        public String getRank_type() {
            return this.rank_type;
        }

        public String getText() {
            return this.text;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public void setRank_type(String rank_type) {
            this.rank_type = rank_type;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Contribution_v2)) {
                return false;
            }
            Contribution_v2 other = (Contribution_v2)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getGrade() != other.getGrade()) {
                return false;
            }
            String this$rank_type = this.getRank_type();
            String other$rank_type = other.getRank_type();
            if (this$rank_type == null ? other$rank_type != null : !this$rank_type.equals((Object)other$rank_type)) {
                return false;
            }
            String this$text = this.getText();
            String other$text = other.getText();
            if (this$text == null ? other$text != null : !this$text.equals((Object)other$text)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Contribution_v2;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getGrade();
            String $rank_type = this.getRank_type();
            result = result * 59 + ($rank_type == null ? 43 : $rank_type.hashCode());
            String $text = this.getText();
            result = result * 59 + ($text == null ? 43 : $text.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "InteractWordMsg.Contribution_v2(grade=" + this.getGrade() + ", rank_type=" + this.getRank_type() + ", text=" + this.getText() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Contribution {
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
            if (!(o instanceof Contribution)) {
                return false;
            }
            Contribution other = (Contribution)o;
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
            return other instanceof Contribution;
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
            return "InteractWordMsg.Contribution(grade=" + this.getGrade() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.msg;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.bilibili.constant.OperationEnum;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.base.BaseBilibiliMsg;
import tech.ordinaryroad.live.chat.client.codec.bilibili.msg.dto.MedalInfo;
import tech.ordinaryroad.live.chat.client.commons.base.msg.ISuperChatMsg;

public class SuperChatMessageMsg
extends BaseBilibiliMsg
implements ISuperChatMsg {
    private long roomid;
    private Data data;

    @Override
    public OperationEnum getOperationEnum() {
        return OperationEnum.MESSAGE;
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
        if (this.data == null || this.data.getUser_info() == null) {
            return "";
        }
        return this.data.user_info.uname;
    }

    @Override
    public String getUserAvatar() {
        if (this.data == null || this.data.getUser_info() == null) {
            return "";
        }
        return this.data.user_info.face;
    }

    @Override
    public String getContent() {
        if (this.data == null) {
            return "";
        }
        return this.data.message;
    }

    @Override
    public int getDuration() {
        if (this.data == null) {
            return 0;
        }
        return this.data.time;
    }

    public long getRoomid() {
        return this.roomid;
    }

    public Data getData() {
        return this.data;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public SuperChatMessageMsg(long roomid, Data data) {
        this.roomid = roomid;
        this.data = data;
    }

    public SuperChatMessageMsg() {
    }

    public static class Data {
        private String background_bottom_color;
        private String background_color;
        private String background_color_end;
        private String background_color_start;
        private String background_icon;
        private String background_image;
        private String background_price_color;
        private double color_point;
        private int dmscore;
        private long end_time;
        private Gift gift;
        private long id;
        private int is_ranked;
        private int is_send_audit;
        private MedalInfo medal_info;
        private String message;
        private String message_font_color;
        private String message_trans;
        private int price;
        private int rate;
        private long start_time;
        private int time;
        private String token;
        private int trans_mark;
        private long ts;
        private long uid;
        private User_info user_info;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public String getBackground_bottom_color() {
            return this.background_bottom_color;
        }

        public String getBackground_color() {
            return this.background_color;
        }

        public String getBackground_color_end() {
            return this.background_color_end;
        }

        public String getBackground_color_start() {
            return this.background_color_start;
        }

        public String getBackground_icon() {
            return this.background_icon;
        }

        public String getBackground_image() {
            return this.background_image;
        }

        public String getBackground_price_color() {
            return this.background_price_color;
        }

        public double getColor_point() {
            return this.color_point;
        }

        public int getDmscore() {
            return this.dmscore;
        }

        public long getEnd_time() {
            return this.end_time;
        }

        public Gift getGift() {
            return this.gift;
        }

        public long getId() {
            return this.id;
        }

        public int getIs_ranked() {
            return this.is_ranked;
        }

        public int getIs_send_audit() {
            return this.is_send_audit;
        }

        public MedalInfo getMedal_info() {
            return this.medal_info;
        }

        public String getMessage() {
            return this.message;
        }

        public String getMessage_font_color() {
            return this.message_font_color;
        }

        public String getMessage_trans() {
            return this.message_trans;
        }

        public int getPrice() {
            return this.price;
        }

        public int getRate() {
            return this.rate;
        }

        public long getStart_time() {
            return this.start_time;
        }

        public int getTime() {
            return this.time;
        }

        public String getToken() {
            return this.token;
        }

        public int getTrans_mark() {
            return this.trans_mark;
        }

        public long getTs() {
            return this.ts;
        }

        public long getUid() {
            return this.uid;
        }

        public User_info getUser_info() {
            return this.user_info;
        }

        public void setBackground_bottom_color(String background_bottom_color) {
            this.background_bottom_color = background_bottom_color;
        }

        public void setBackground_color(String background_color) {
            this.background_color = background_color;
        }

        public void setBackground_color_end(String background_color_end) {
            this.background_color_end = background_color_end;
        }

        public void setBackground_color_start(String background_color_start) {
            this.background_color_start = background_color_start;
        }

        public void setBackground_icon(String background_icon) {
            this.background_icon = background_icon;
        }

        public void setBackground_image(String background_image) {
            this.background_image = background_image;
        }

        public void setBackground_price_color(String background_price_color) {
            this.background_price_color = background_price_color;
        }

        public void setColor_point(double color_point) {
            this.color_point = color_point;
        }

        public void setDmscore(int dmscore) {
            this.dmscore = dmscore;
        }

        public void setEnd_time(long end_time) {
            this.end_time = end_time;
        }

        public void setGift(Gift gift) {
            this.gift = gift;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setIs_ranked(int is_ranked) {
            this.is_ranked = is_ranked;
        }

        public void setIs_send_audit(int is_send_audit) {
            this.is_send_audit = is_send_audit;
        }

        public void setMedal_info(MedalInfo medal_info) {
            this.medal_info = medal_info;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setMessage_font_color(String message_font_color) {
            this.message_font_color = message_font_color;
        }

        public void setMessage_trans(String message_trans) {
            this.message_trans = message_trans;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public void setStart_time(long start_time) {
            this.start_time = start_time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setTrans_mark(int trans_mark) {
            this.trans_mark = trans_mark;
        }

        public void setTs(long ts) {
            this.ts = ts;
        }

        public void setUid(long uid) {
            this.uid = uid;
        }

        public void setUser_info(User_info user_info) {
            this.user_info = user_info;
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
            if (Double.compare((double)this.getColor_point(), (double)other.getColor_point()) != 0) {
                return false;
            }
            if (this.getDmscore() != other.getDmscore()) {
                return false;
            }
            if (this.getEnd_time() != other.getEnd_time()) {
                return false;
            }
            if (this.getId() != other.getId()) {
                return false;
            }
            if (this.getIs_ranked() != other.getIs_ranked()) {
                return false;
            }
            if (this.getIs_send_audit() != other.getIs_send_audit()) {
                return false;
            }
            if (this.getPrice() != other.getPrice()) {
                return false;
            }
            if (this.getRate() != other.getRate()) {
                return false;
            }
            if (this.getStart_time() != other.getStart_time()) {
                return false;
            }
            if (this.getTime() != other.getTime()) {
                return false;
            }
            if (this.getTrans_mark() != other.getTrans_mark()) {
                return false;
            }
            if (this.getTs() != other.getTs()) {
                return false;
            }
            if (this.getUid() != other.getUid()) {
                return false;
            }
            String this$background_bottom_color = this.getBackground_bottom_color();
            String other$background_bottom_color = other.getBackground_bottom_color();
            if (this$background_bottom_color == null ? other$background_bottom_color != null : !this$background_bottom_color.equals((Object)other$background_bottom_color)) {
                return false;
            }
            String this$background_color = this.getBackground_color();
            String other$background_color = other.getBackground_color();
            if (this$background_color == null ? other$background_color != null : !this$background_color.equals((Object)other$background_color)) {
                return false;
            }
            String this$background_color_end = this.getBackground_color_end();
            String other$background_color_end = other.getBackground_color_end();
            if (this$background_color_end == null ? other$background_color_end != null : !this$background_color_end.equals((Object)other$background_color_end)) {
                return false;
            }
            String this$background_color_start = this.getBackground_color_start();
            String other$background_color_start = other.getBackground_color_start();
            if (this$background_color_start == null ? other$background_color_start != null : !this$background_color_start.equals((Object)other$background_color_start)) {
                return false;
            }
            String this$background_icon = this.getBackground_icon();
            String other$background_icon = other.getBackground_icon();
            if (this$background_icon == null ? other$background_icon != null : !this$background_icon.equals((Object)other$background_icon)) {
                return false;
            }
            String this$background_image = this.getBackground_image();
            String other$background_image = other.getBackground_image();
            if (this$background_image == null ? other$background_image != null : !this$background_image.equals((Object)other$background_image)) {
                return false;
            }
            String this$background_price_color = this.getBackground_price_color();
            String other$background_price_color = other.getBackground_price_color();
            if (this$background_price_color == null ? other$background_price_color != null : !this$background_price_color.equals((Object)other$background_price_color)) {
                return false;
            }
            Gift this$gift = this.getGift();
            Gift other$gift = other.getGift();
            if (this$gift == null ? other$gift != null : !this$gift.equals(other$gift)) {
                return false;
            }
            MedalInfo this$medal_info = this.getMedal_info();
            MedalInfo other$medal_info = other.getMedal_info();
            if (this$medal_info == null ? other$medal_info != null : !this$medal_info.equals(other$medal_info)) {
                return false;
            }
            String this$message = this.getMessage();
            String other$message = other.getMessage();
            if (this$message == null ? other$message != null : !this$message.equals((Object)other$message)) {
                return false;
            }
            String this$message_font_color = this.getMessage_font_color();
            String other$message_font_color = other.getMessage_font_color();
            if (this$message_font_color == null ? other$message_font_color != null : !this$message_font_color.equals((Object)other$message_font_color)) {
                return false;
            }
            String this$message_trans = this.getMessage_trans();
            String other$message_trans = other.getMessage_trans();
            if (this$message_trans == null ? other$message_trans != null : !this$message_trans.equals((Object)other$message_trans)) {
                return false;
            }
            String this$token = this.getToken();
            String other$token = other.getToken();
            if (this$token == null ? other$token != null : !this$token.equals((Object)other$token)) {
                return false;
            }
            User_info this$user_info = this.getUser_info();
            User_info other$user_info = other.getUser_info();
            if (this$user_info == null ? other$user_info != null : !this$user_info.equals(other$user_info)) {
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
            long $color_point = Double.doubleToLongBits((double)this.getColor_point());
            result = result * 59 + (int)($color_point >>> 32 ^ $color_point);
            result = result * 59 + this.getDmscore();
            long $end_time = this.getEnd_time();
            result = result * 59 + (int)($end_time >>> 32 ^ $end_time);
            long $id = this.getId();
            result = result * 59 + (int)($id >>> 32 ^ $id);
            result = result * 59 + this.getIs_ranked();
            result = result * 59 + this.getIs_send_audit();
            result = result * 59 + this.getPrice();
            result = result * 59 + this.getRate();
            long $start_time = this.getStart_time();
            result = result * 59 + (int)($start_time >>> 32 ^ $start_time);
            result = result * 59 + this.getTime();
            result = result * 59 + this.getTrans_mark();
            long $ts = this.getTs();
            result = result * 59 + (int)($ts >>> 32 ^ $ts);
            long $uid = this.getUid();
            result = result * 59 + (int)($uid >>> 32 ^ $uid);
            String $background_bottom_color = this.getBackground_bottom_color();
            result = result * 59 + ($background_bottom_color == null ? 43 : $background_bottom_color.hashCode());
            String $background_color = this.getBackground_color();
            result = result * 59 + ($background_color == null ? 43 : $background_color.hashCode());
            String $background_color_end = this.getBackground_color_end();
            result = result * 59 + ($background_color_end == null ? 43 : $background_color_end.hashCode());
            String $background_color_start = this.getBackground_color_start();
            result = result * 59 + ($background_color_start == null ? 43 : $background_color_start.hashCode());
            String $background_icon = this.getBackground_icon();
            result = result * 59 + ($background_icon == null ? 43 : $background_icon.hashCode());
            String $background_image = this.getBackground_image();
            result = result * 59 + ($background_image == null ? 43 : $background_image.hashCode());
            String $background_price_color = this.getBackground_price_color();
            result = result * 59 + ($background_price_color == null ? 43 : $background_price_color.hashCode());
            Gift $gift = this.getGift();
            result = result * 59 + ($gift == null ? 43 : $gift.hashCode());
            MedalInfo $medal_info = this.getMedal_info();
            result = result * 59 + ($medal_info == null ? 43 : $medal_info.hashCode());
            String $message = this.getMessage();
            result = result * 59 + ($message == null ? 43 : $message.hashCode());
            String $message_font_color = this.getMessage_font_color();
            result = result * 59 + ($message_font_color == null ? 43 : $message_font_color.hashCode());
            String $message_trans = this.getMessage_trans();
            result = result * 59 + ($message_trans == null ? 43 : $message_trans.hashCode());
            String $token = this.getToken();
            result = result * 59 + ($token == null ? 43 : $token.hashCode());
            User_info $user_info = this.getUser_info();
            result = result * 59 + ($user_info == null ? 43 : $user_info.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "SuperChatMessageMsg.Data(background_bottom_color=" + this.getBackground_bottom_color() + ", background_color=" + this.getBackground_color() + ", background_color_end=" + this.getBackground_color_end() + ", background_color_start=" + this.getBackground_color_start() + ", background_icon=" + this.getBackground_icon() + ", background_image=" + this.getBackground_image() + ", background_price_color=" + this.getBackground_price_color() + ", color_point=" + this.getColor_point() + ", dmscore=" + this.getDmscore() + ", end_time=" + this.getEnd_time() + ", gift=" + this.getGift() + ", id=" + this.getId() + ", is_ranked=" + this.getIs_ranked() + ", is_send_audit=" + this.getIs_send_audit() + ", medal_info=" + this.getMedal_info() + ", message=" + this.getMessage() + ", message_font_color=" + this.getMessage_font_color() + ", message_trans=" + this.getMessage_trans() + ", price=" + this.getPrice() + ", rate=" + this.getRate() + ", start_time=" + this.getStart_time() + ", time=" + this.getTime() + ", token=" + this.getToken() + ", trans_mark=" + this.getTrans_mark() + ", ts=" + this.getTs() + ", uid=" + this.getUid() + ", user_info=" + this.getUser_info() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class User_info {
        private String face;
        private String face_frame;
        private int guard_level;
        private int is_main_vip;
        private int is_svip;
        private int is_vip;
        private String level_color;
        private int manager;
        private String name_color;
        private String title;
        private String uname;
        private int user_level;
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

        public String getFace_frame() {
            return this.face_frame;
        }

        public int getGuard_level() {
            return this.guard_level;
        }

        public int getIs_main_vip() {
            return this.is_main_vip;
        }

        public int getIs_svip() {
            return this.is_svip;
        }

        public int getIs_vip() {
            return this.is_vip;
        }

        public String getLevel_color() {
            return this.level_color;
        }

        public int getManager() {
            return this.manager;
        }

        public String getName_color() {
            return this.name_color;
        }

        public String getTitle() {
            return this.title;
        }

        public String getUname() {
            return this.uname;
        }

        public int getUser_level() {
            return this.user_level;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public void setFace_frame(String face_frame) {
            this.face_frame = face_frame;
        }

        public void setGuard_level(int guard_level) {
            this.guard_level = guard_level;
        }

        public void setIs_main_vip(int is_main_vip) {
            this.is_main_vip = is_main_vip;
        }

        public void setIs_svip(int is_svip) {
            this.is_svip = is_svip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public void setLevel_color(String level_color) {
            this.level_color = level_color;
        }

        public void setManager(int manager) {
            this.manager = manager;
        }

        public void setName_color(String name_color) {
            this.name_color = name_color;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public void setUser_level(int user_level) {
            this.user_level = user_level;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof User_info)) {
                return false;
            }
            User_info other = (User_info)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getGuard_level() != other.getGuard_level()) {
                return false;
            }
            if (this.getIs_main_vip() != other.getIs_main_vip()) {
                return false;
            }
            if (this.getIs_svip() != other.getIs_svip()) {
                return false;
            }
            if (this.getIs_vip() != other.getIs_vip()) {
                return false;
            }
            if (this.getManager() != other.getManager()) {
                return false;
            }
            if (this.getUser_level() != other.getUser_level()) {
                return false;
            }
            String this$face = this.getFace();
            String other$face = other.getFace();
            if (this$face == null ? other$face != null : !this$face.equals((Object)other$face)) {
                return false;
            }
            String this$face_frame = this.getFace_frame();
            String other$face_frame = other.getFace_frame();
            if (this$face_frame == null ? other$face_frame != null : !this$face_frame.equals((Object)other$face_frame)) {
                return false;
            }
            String this$level_color = this.getLevel_color();
            String other$level_color = other.getLevel_color();
            if (this$level_color == null ? other$level_color != null : !this$level_color.equals((Object)other$level_color)) {
                return false;
            }
            String this$name_color = this.getName_color();
            String other$name_color = other.getName_color();
            if (this$name_color == null ? other$name_color != null : !this$name_color.equals((Object)other$name_color)) {
                return false;
            }
            String this$title = this.getTitle();
            String other$title = other.getTitle();
            if (this$title == null ? other$title != null : !this$title.equals((Object)other$title)) {
                return false;
            }
            String this$uname = this.getUname();
            String other$uname = other.getUname();
            if (this$uname == null ? other$uname != null : !this$uname.equals((Object)other$uname)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof User_info;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getGuard_level();
            result = result * 59 + this.getIs_main_vip();
            result = result * 59 + this.getIs_svip();
            result = result * 59 + this.getIs_vip();
            result = result * 59 + this.getManager();
            result = result * 59 + this.getUser_level();
            String $face = this.getFace();
            result = result * 59 + ($face == null ? 43 : $face.hashCode());
            String $face_frame = this.getFace_frame();
            result = result * 59 + ($face_frame == null ? 43 : $face_frame.hashCode());
            String $level_color = this.getLevel_color();
            result = result * 59 + ($level_color == null ? 43 : $level_color.hashCode());
            String $name_color = this.getName_color();
            result = result * 59 + ($name_color == null ? 43 : $name_color.hashCode());
            String $title = this.getTitle();
            result = result * 59 + ($title == null ? 43 : $title.hashCode());
            String $uname = this.getUname();
            result = result * 59 + ($uname == null ? 43 : $uname.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "SuperChatMessageMsg.User_info(face=" + this.getFace() + ", face_frame=" + this.getFace_frame() + ", guard_level=" + this.getGuard_level() + ", is_main_vip=" + this.getIs_main_vip() + ", is_svip=" + this.getIs_svip() + ", is_vip=" + this.getIs_vip() + ", level_color=" + this.getLevel_color() + ", manager=" + this.getManager() + ", name_color=" + this.getName_color() + ", title=" + this.getTitle() + ", uname=" + this.getUname() + ", user_level=" + this.getUser_level() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }

    public static class Gift {
        private int gift_id;
        private String gift_name;
        private int num;
        private final Map<String, JsonNode> unknownProperties = new HashMap();

        @JsonAnyGetter
        public Map<String, JsonNode> getUnknownProperties() {
            return this.unknownProperties;
        }

        @JsonAnySetter
        public void setOther(String key, JsonNode value) {
            this.unknownProperties.put((Object)key, (Object)value);
        }

        public int getGift_id() {
            return this.gift_id;
        }

        public String getGift_name() {
            return this.gift_name;
        }

        public int getNum() {
            return this.num;
        }

        public void setGift_id(int gift_id) {
            this.gift_id = gift_id;
        }

        public void setGift_name(String gift_name) {
            this.gift_name = gift_name;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Gift)) {
                return false;
            }
            Gift other = (Gift)o;
            if (!other.canEqual(this)) {
                return false;
            }
            if (this.getGift_id() != other.getGift_id()) {
                return false;
            }
            if (this.getNum() != other.getNum()) {
                return false;
            }
            String this$gift_name = this.getGift_name();
            String other$gift_name = other.getGift_name();
            if (this$gift_name == null ? other$gift_name != null : !this$gift_name.equals((Object)other$gift_name)) {
                return false;
            }
            Map<String, JsonNode> this$unknownProperties = this.getUnknownProperties();
            Map<String, JsonNode> other$unknownProperties = other.getUnknownProperties();
            return !(this$unknownProperties == null ? other$unknownProperties != null : !this$unknownProperties.equals(other$unknownProperties));
        }

        protected boolean canEqual(Object other) {
            return other instanceof Gift;
        }

        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            result = result * 59 + this.getGift_id();
            result = result * 59 + this.getNum();
            String $gift_name = this.getGift_name();
            result = result * 59 + ($gift_name == null ? 43 : $gift_name.hashCode());
            Map<String, JsonNode> $unknownProperties = this.getUnknownProperties();
            result = result * 59 + ($unknownProperties == null ? 43 : $unknownProperties.hashCode());
            return result;
        }

        public String toString() {
            return "SuperChatMessageMsg.Gift(gift_id=" + this.getGift_id() + ", gift_name=" + this.getGift_name() + ", num=" + this.getNum() + ", unknownProperties=" + this.getUnknownProperties() + ")";
        }
    }
}


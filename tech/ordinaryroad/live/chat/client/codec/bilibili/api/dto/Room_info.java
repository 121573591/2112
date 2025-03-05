/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import java.util.Map;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Pendants;

public class Room_info {
    private long uid;
    private long room_id;
    private int short_id;
    private String title;
    private String cover;
    private String tags;
    private String background;
    private String description;
    private int live_status;
    private long live_start_time;
    private int live_screen_type;
    private int lock_status;
    private int lock_time;
    private int hidden_status;
    private int hidden_time;
    private int area_id;
    private String area_name;
    private int parent_area_id;
    private String parent_area_name;
    private String keyframe;
    private int special_type;
    private String up_session;
    private int pk_status;
    private boolean is_studio;
    private Pendants pendants;
    private int on_voice_join;
    private long online;
    private Map<String, Integer> room_type;
    private String sub_session_key;
    private long live_id;
    private String live_id_str;
    private int official_room_id;
    private String official_room_info;
    private String voice_background;

    public long getUid() {
        return this.uid;
    }

    public long getRoom_id() {
        return this.room_id;
    }

    public int getShort_id() {
        return this.short_id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCover() {
        return this.cover;
    }

    public String getTags() {
        return this.tags;
    }

    public String getBackground() {
        return this.background;
    }

    public String getDescription() {
        return this.description;
    }

    public int getLive_status() {
        return this.live_status;
    }

    public long getLive_start_time() {
        return this.live_start_time;
    }

    public int getLive_screen_type() {
        return this.live_screen_type;
    }

    public int getLock_status() {
        return this.lock_status;
    }

    public int getLock_time() {
        return this.lock_time;
    }

    public int getHidden_status() {
        return this.hidden_status;
    }

    public int getHidden_time() {
        return this.hidden_time;
    }

    public int getArea_id() {
        return this.area_id;
    }

    public String getArea_name() {
        return this.area_name;
    }

    public int getParent_area_id() {
        return this.parent_area_id;
    }

    public String getParent_area_name() {
        return this.parent_area_name;
    }

    public String getKeyframe() {
        return this.keyframe;
    }

    public int getSpecial_type() {
        return this.special_type;
    }

    public String getUp_session() {
        return this.up_session;
    }

    public int getPk_status() {
        return this.pk_status;
    }

    public boolean is_studio() {
        return this.is_studio;
    }

    public Pendants getPendants() {
        return this.pendants;
    }

    public int getOn_voice_join() {
        return this.on_voice_join;
    }

    public long getOnline() {
        return this.online;
    }

    public Map<String, Integer> getRoom_type() {
        return this.room_type;
    }

    public String getSub_session_key() {
        return this.sub_session_key;
    }

    public long getLive_id() {
        return this.live_id;
    }

    public String getLive_id_str() {
        return this.live_id_str;
    }

    public int getOfficial_room_id() {
        return this.official_room_id;
    }

    public String getOfficial_room_info() {
        return this.official_room_info;
    }

    public String getVoice_background() {
        return this.voice_background;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setRoom_id(long room_id) {
        this.room_id = room_id;
    }

    public void setShort_id(int short_id) {
        this.short_id = short_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLive_status(int live_status) {
        this.live_status = live_status;
    }

    public void setLive_start_time(long live_start_time) {
        this.live_start_time = live_start_time;
    }

    public void setLive_screen_type(int live_screen_type) {
        this.live_screen_type = live_screen_type;
    }

    public void setLock_status(int lock_status) {
        this.lock_status = lock_status;
    }

    public void setLock_time(int lock_time) {
        this.lock_time = lock_time;
    }

    public void setHidden_status(int hidden_status) {
        this.hidden_status = hidden_status;
    }

    public void setHidden_time(int hidden_time) {
        this.hidden_time = hidden_time;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public void setParent_area_id(int parent_area_id) {
        this.parent_area_id = parent_area_id;
    }

    public void setParent_area_name(String parent_area_name) {
        this.parent_area_name = parent_area_name;
    }

    public void setKeyframe(String keyframe) {
        this.keyframe = keyframe;
    }

    public void setSpecial_type(int special_type) {
        this.special_type = special_type;
    }

    public void setUp_session(String up_session) {
        this.up_session = up_session;
    }

    public void setPk_status(int pk_status) {
        this.pk_status = pk_status;
    }

    public void set_studio(boolean is_studio) {
        this.is_studio = is_studio;
    }

    public void setPendants(Pendants pendants) {
        this.pendants = pendants;
    }

    public void setOn_voice_join(int on_voice_join) {
        this.on_voice_join = on_voice_join;
    }

    public void setOnline(long online) {
        this.online = online;
    }

    public void setRoom_type(Map<String, Integer> room_type) {
        this.room_type = room_type;
    }

    public void setSub_session_key(String sub_session_key) {
        this.sub_session_key = sub_session_key;
    }

    public void setLive_id(long live_id) {
        this.live_id = live_id;
    }

    public void setLive_id_str(String live_id_str) {
        this.live_id_str = live_id_str;
    }

    public void setOfficial_room_id(int official_room_id) {
        this.official_room_id = official_room_id;
    }

    public void setOfficial_room_info(String official_room_info) {
        this.official_room_info = official_room_info;
    }

    public void setVoice_background(String voice_background) {
        this.voice_background = voice_background;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Room_info)) {
            return false;
        }
        Room_info other = (Room_info)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getUid() != other.getUid()) {
            return false;
        }
        if (this.getRoom_id() != other.getRoom_id()) {
            return false;
        }
        if (this.getShort_id() != other.getShort_id()) {
            return false;
        }
        if (this.getLive_status() != other.getLive_status()) {
            return false;
        }
        if (this.getLive_start_time() != other.getLive_start_time()) {
            return false;
        }
        if (this.getLive_screen_type() != other.getLive_screen_type()) {
            return false;
        }
        if (this.getLock_status() != other.getLock_status()) {
            return false;
        }
        if (this.getLock_time() != other.getLock_time()) {
            return false;
        }
        if (this.getHidden_status() != other.getHidden_status()) {
            return false;
        }
        if (this.getHidden_time() != other.getHidden_time()) {
            return false;
        }
        if (this.getArea_id() != other.getArea_id()) {
            return false;
        }
        if (this.getParent_area_id() != other.getParent_area_id()) {
            return false;
        }
        if (this.getSpecial_type() != other.getSpecial_type()) {
            return false;
        }
        if (this.getPk_status() != other.getPk_status()) {
            return false;
        }
        if (this.is_studio() != other.is_studio()) {
            return false;
        }
        if (this.getOn_voice_join() != other.getOn_voice_join()) {
            return false;
        }
        if (this.getOnline() != other.getOnline()) {
            return false;
        }
        if (this.getLive_id() != other.getLive_id()) {
            return false;
        }
        if (this.getOfficial_room_id() != other.getOfficial_room_id()) {
            return false;
        }
        String this$title = this.getTitle();
        String other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals((Object)other$title)) {
            return false;
        }
        String this$cover = this.getCover();
        String other$cover = other.getCover();
        if (this$cover == null ? other$cover != null : !this$cover.equals((Object)other$cover)) {
            return false;
        }
        String this$tags = this.getTags();
        String other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals((Object)other$tags)) {
            return false;
        }
        String this$background = this.getBackground();
        String other$background = other.getBackground();
        if (this$background == null ? other$background != null : !this$background.equals((Object)other$background)) {
            return false;
        }
        String this$description = this.getDescription();
        String other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals((Object)other$description)) {
            return false;
        }
        String this$area_name = this.getArea_name();
        String other$area_name = other.getArea_name();
        if (this$area_name == null ? other$area_name != null : !this$area_name.equals((Object)other$area_name)) {
            return false;
        }
        String this$parent_area_name = this.getParent_area_name();
        String other$parent_area_name = other.getParent_area_name();
        if (this$parent_area_name == null ? other$parent_area_name != null : !this$parent_area_name.equals((Object)other$parent_area_name)) {
            return false;
        }
        String this$keyframe = this.getKeyframe();
        String other$keyframe = other.getKeyframe();
        if (this$keyframe == null ? other$keyframe != null : !this$keyframe.equals((Object)other$keyframe)) {
            return false;
        }
        String this$up_session = this.getUp_session();
        String other$up_session = other.getUp_session();
        if (this$up_session == null ? other$up_session != null : !this$up_session.equals((Object)other$up_session)) {
            return false;
        }
        Pendants this$pendants = this.getPendants();
        Pendants other$pendants = other.getPendants();
        if (this$pendants == null ? other$pendants != null : !this$pendants.equals(other$pendants)) {
            return false;
        }
        Map<String, Integer> this$room_type = this.getRoom_type();
        Map<String, Integer> other$room_type = other.getRoom_type();
        if (this$room_type == null ? other$room_type != null : !this$room_type.equals(other$room_type)) {
            return false;
        }
        String this$sub_session_key = this.getSub_session_key();
        String other$sub_session_key = other.getSub_session_key();
        if (this$sub_session_key == null ? other$sub_session_key != null : !this$sub_session_key.equals((Object)other$sub_session_key)) {
            return false;
        }
        String this$live_id_str = this.getLive_id_str();
        String other$live_id_str = other.getLive_id_str();
        if (this$live_id_str == null ? other$live_id_str != null : !this$live_id_str.equals((Object)other$live_id_str)) {
            return false;
        }
        String this$official_room_info = this.getOfficial_room_info();
        String other$official_room_info = other.getOfficial_room_info();
        if (this$official_room_info == null ? other$official_room_info != null : !this$official_room_info.equals((Object)other$official_room_info)) {
            return false;
        }
        String this$voice_background = this.getVoice_background();
        String other$voice_background = other.getVoice_background();
        return !(this$voice_background == null ? other$voice_background != null : !this$voice_background.equals((Object)other$voice_background));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Room_info;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $uid = this.getUid();
        result = result * 59 + (int)($uid >>> 32 ^ $uid);
        long $room_id = this.getRoom_id();
        result = result * 59 + (int)($room_id >>> 32 ^ $room_id);
        result = result * 59 + this.getShort_id();
        result = result * 59 + this.getLive_status();
        long $live_start_time = this.getLive_start_time();
        result = result * 59 + (int)($live_start_time >>> 32 ^ $live_start_time);
        result = result * 59 + this.getLive_screen_type();
        result = result * 59 + this.getLock_status();
        result = result * 59 + this.getLock_time();
        result = result * 59 + this.getHidden_status();
        result = result * 59 + this.getHidden_time();
        result = result * 59 + this.getArea_id();
        result = result * 59 + this.getParent_area_id();
        result = result * 59 + this.getSpecial_type();
        result = result * 59 + this.getPk_status();
        result = result * 59 + (this.is_studio() ? 79 : 97);
        result = result * 59 + this.getOn_voice_join();
        long $online = this.getOnline();
        result = result * 59 + (int)($online >>> 32 ^ $online);
        long $live_id = this.getLive_id();
        result = result * 59 + (int)($live_id >>> 32 ^ $live_id);
        result = result * 59 + this.getOfficial_room_id();
        String $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        String $cover = this.getCover();
        result = result * 59 + ($cover == null ? 43 : $cover.hashCode());
        String $tags = this.getTags();
        result = result * 59 + ($tags == null ? 43 : $tags.hashCode());
        String $background = this.getBackground();
        result = result * 59 + ($background == null ? 43 : $background.hashCode());
        String $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        String $area_name = this.getArea_name();
        result = result * 59 + ($area_name == null ? 43 : $area_name.hashCode());
        String $parent_area_name = this.getParent_area_name();
        result = result * 59 + ($parent_area_name == null ? 43 : $parent_area_name.hashCode());
        String $keyframe = this.getKeyframe();
        result = result * 59 + ($keyframe == null ? 43 : $keyframe.hashCode());
        String $up_session = this.getUp_session();
        result = result * 59 + ($up_session == null ? 43 : $up_session.hashCode());
        Pendants $pendants = this.getPendants();
        result = result * 59 + ($pendants == null ? 43 : $pendants.hashCode());
        Map<String, Integer> $room_type = this.getRoom_type();
        result = result * 59 + ($room_type == null ? 43 : $room_type.hashCode());
        String $sub_session_key = this.getSub_session_key();
        result = result * 59 + ($sub_session_key == null ? 43 : $sub_session_key.hashCode());
        String $live_id_str = this.getLive_id_str();
        result = result * 59 + ($live_id_str == null ? 43 : $live_id_str.hashCode());
        String $official_room_info = this.getOfficial_room_info();
        result = result * 59 + ($official_room_info == null ? 43 : $official_room_info.hashCode());
        String $voice_background = this.getVoice_background();
        result = result * 59 + ($voice_background == null ? 43 : $voice_background.hashCode());
        return result;
    }

    public String toString() {
        return "Room_info(uid=" + this.getUid() + ", room_id=" + this.getRoom_id() + ", short_id=" + this.getShort_id() + ", title=" + this.getTitle() + ", cover=" + this.getCover() + ", tags=" + this.getTags() + ", background=" + this.getBackground() + ", description=" + this.getDescription() + ", live_status=" + this.getLive_status() + ", live_start_time=" + this.getLive_start_time() + ", live_screen_type=" + this.getLive_screen_type() + ", lock_status=" + this.getLock_status() + ", lock_time=" + this.getLock_time() + ", hidden_status=" + this.getHidden_status() + ", hidden_time=" + this.getHidden_time() + ", area_id=" + this.getArea_id() + ", area_name=" + this.getArea_name() + ", parent_area_id=" + this.getParent_area_id() + ", parent_area_name=" + this.getParent_area_name() + ", keyframe=" + this.getKeyframe() + ", special_type=" + this.getSpecial_type() + ", up_session=" + this.getUp_session() + ", pk_status=" + this.getPk_status() + ", is_studio=" + this.is_studio() + ", pendants=" + this.getPendants() + ", on_voice_join=" + this.getOn_voice_join() + ", online=" + this.getOnline() + ", room_type=" + this.getRoom_type() + ", sub_session_key=" + this.getSub_session_key() + ", live_id=" + this.getLive_id() + ", live_id_str=" + this.getLive_id_str() + ", official_room_id=" + this.getOfficial_room_id() + ", official_room_info=" + this.getOfficial_room_info() + ", voice_background=" + this.getVoice_background() + ")";
    }

    public Room_info(long uid, long room_id, int short_id, String title, String cover, String tags, String background, String description, int live_status, long live_start_time, int live_screen_type, int lock_status, int lock_time, int hidden_status, int hidden_time, int area_id, String area_name, int parent_area_id, String parent_area_name, String keyframe, int special_type, String up_session, int pk_status, boolean is_studio, Pendants pendants, int on_voice_join, long online, Map<String, Integer> room_type, String sub_session_key, long live_id, String live_id_str, int official_room_id, String official_room_info, String voice_background) {
        this.uid = uid;
        this.room_id = room_id;
        this.short_id = short_id;
        this.title = title;
        this.cover = cover;
        this.tags = tags;
        this.background = background;
        this.description = description;
        this.live_status = live_status;
        this.live_start_time = live_start_time;
        this.live_screen_type = live_screen_type;
        this.lock_status = lock_status;
        this.lock_time = lock_time;
        this.hidden_status = hidden_status;
        this.hidden_time = hidden_time;
        this.area_id = area_id;
        this.area_name = area_name;
        this.parent_area_id = parent_area_id;
        this.parent_area_name = parent_area_name;
        this.keyframe = keyframe;
        this.special_type = special_type;
        this.up_session = up_session;
        this.pk_status = pk_status;
        this.is_studio = is_studio;
        this.pendants = pendants;
        this.on_voice_join = on_voice_join;
        this.online = online;
        this.room_type = room_type;
        this.sub_session_key = sub_session_key;
        this.live_id = live_id;
        this.live_id_str = live_id_str;
        this.official_room_id = official_room_id;
        this.official_room_info = official_room_info;
        this.voice_background = voice_background;
    }

    public Room_info() {
    }
}


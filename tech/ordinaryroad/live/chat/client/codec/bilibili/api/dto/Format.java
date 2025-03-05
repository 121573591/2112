/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Codec;

public class Format {
    private String format_name;
    private List<Codec> codec;
    private String master_url;

    public String getFormat_name() {
        return this.format_name;
    }

    public List<Codec> getCodec() {
        return this.codec;
    }

    public String getMaster_url() {
        return this.master_url;
    }

    public void setFormat_name(String format_name) {
        this.format_name = format_name;
    }

    public void setCodec(List<Codec> codec) {
        this.codec = codec;
    }

    public void setMaster_url(String master_url) {
        this.master_url = master_url;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Format)) {
            return false;
        }
        Format other = (Format)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$format_name = this.getFormat_name();
        String other$format_name = other.getFormat_name();
        if (this$format_name == null ? other$format_name != null : !this$format_name.equals((Object)other$format_name)) {
            return false;
        }
        List<Codec> this$codec = this.getCodec();
        List<Codec> other$codec = other.getCodec();
        if (this$codec == null ? other$codec != null : !this$codec.equals(other$codec)) {
            return false;
        }
        String this$master_url = this.getMaster_url();
        String other$master_url = other.getMaster_url();
        return !(this$master_url == null ? other$master_url != null : !this$master_url.equals((Object)other$master_url));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Format;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $format_name = this.getFormat_name();
        result = result * 59 + ($format_name == null ? 43 : $format_name.hashCode());
        List<Codec> $codec = this.getCodec();
        result = result * 59 + ($codec == null ? 43 : $codec.hashCode());
        String $master_url = this.getMaster_url();
        result = result * 59 + ($master_url == null ? 43 : $master_url.hashCode());
        return result;
    }

    public String toString() {
        return "Format(format_name=" + this.getFormat_name() + ", codec=" + this.getCodec() + ", master_url=" + this.getMaster_url() + ")";
    }

    public Format(String format_name, List<Codec> codec, String master_url) {
        this.format_name = format_name;
        this.codec = codec;
        this.master_url = master_url;
    }

    public Format() {
    }
}


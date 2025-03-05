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
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Format;

public class Stream {
    private String protocol_name;
    private List<Format> format;

    public String getProtocol_name() {
        return this.protocol_name;
    }

    public List<Format> getFormat() {
        return this.format;
    }

    public void setProtocol_name(String protocol_name) {
        this.protocol_name = protocol_name;
    }

    public void setFormat(List<Format> format) {
        this.format = format;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Stream)) {
            return false;
        }
        Stream other = (Stream)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$protocol_name = this.getProtocol_name();
        String other$protocol_name = other.getProtocol_name();
        if (this$protocol_name == null ? other$protocol_name != null : !this$protocol_name.equals((Object)other$protocol_name)) {
            return false;
        }
        List<Format> this$format = this.getFormat();
        List<Format> other$format = other.getFormat();
        return !(this$format == null ? other$format != null : !this$format.equals(other$format));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Stream;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $protocol_name = this.getProtocol_name();
        result = result * 59 + ($protocol_name == null ? 43 : $protocol_name.hashCode());
        List<Format> $format = this.getFormat();
        result = result * 59 + ($format == null ? 43 : $format.hashCode());
        return result;
    }

    public String toString() {
        return "Stream(protocol_name=" + this.getProtocol_name() + ", format=" + this.getFormat() + ")";
    }

    public Stream(String protocol_name, List<Format> format) {
        this.protocol_name = protocol_name;
        this.format = format;
    }

    public Stream() {
    }
}


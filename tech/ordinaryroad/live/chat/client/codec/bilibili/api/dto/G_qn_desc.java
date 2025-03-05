/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto;

public class G_qn_desc {
    private int qn;
    private String desc;
    private String hdr_desc;
    private String attr_desc;
    private int hdr_type;

    public int getQn() {
        return this.qn;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getHdr_desc() {
        return this.hdr_desc;
    }

    public String getAttr_desc() {
        return this.attr_desc;
    }

    public int getHdr_type() {
        return this.hdr_type;
    }

    public void setQn(int qn) {
        this.qn = qn;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setHdr_desc(String hdr_desc) {
        this.hdr_desc = hdr_desc;
    }

    public void setAttr_desc(String attr_desc) {
        this.attr_desc = attr_desc;
    }

    public void setHdr_type(int hdr_type) {
        this.hdr_type = hdr_type;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof G_qn_desc)) {
            return false;
        }
        G_qn_desc other = (G_qn_desc)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getQn() != other.getQn()) {
            return false;
        }
        if (this.getHdr_type() != other.getHdr_type()) {
            return false;
        }
        String this$desc = this.getDesc();
        String other$desc = other.getDesc();
        if (this$desc == null ? other$desc != null : !this$desc.equals((Object)other$desc)) {
            return false;
        }
        String this$hdr_desc = this.getHdr_desc();
        String other$hdr_desc = other.getHdr_desc();
        if (this$hdr_desc == null ? other$hdr_desc != null : !this$hdr_desc.equals((Object)other$hdr_desc)) {
            return false;
        }
        String this$attr_desc = this.getAttr_desc();
        String other$attr_desc = other.getAttr_desc();
        return !(this$attr_desc == null ? other$attr_desc != null : !this$attr_desc.equals((Object)other$attr_desc));
    }

    protected boolean canEqual(Object other) {
        return other instanceof G_qn_desc;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQn();
        result = result * 59 + this.getHdr_type();
        String $desc = this.getDesc();
        result = result * 59 + ($desc == null ? 43 : $desc.hashCode());
        String $hdr_desc = this.getHdr_desc();
        result = result * 59 + ($hdr_desc == null ? 43 : $hdr_desc.hashCode());
        String $attr_desc = this.getAttr_desc();
        result = result * 59 + ($attr_desc == null ? 43 : $attr_desc.hashCode());
        return result;
    }

    public String toString() {
        return "G_qn_desc(qn=" + this.getQn() + ", desc=" + this.getDesc() + ", hdr_desc=" + this.getHdr_desc() + ", attr_desc=" + this.getAttr_desc() + ", hdr_type=" + this.getHdr_type() + ")";
    }

    public G_qn_desc(int qn, String desc, String hdr_desc, String attr_desc, int hdr_type) {
        this.qn = qn;
        this.desc = desc;
        this.hdr_desc = hdr_desc;
        this.attr_desc = attr_desc;
        this.hdr_type = hdr_type;
    }

    public G_qn_desc() {
    }
}


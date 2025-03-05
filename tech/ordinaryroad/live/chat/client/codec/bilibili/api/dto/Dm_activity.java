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
import tech.ordinaryroad.live.chat.client.codec.bilibili.api.dto.Material_list;

public class Dm_activity {
    private String activity_list;
    private long ts;
    private List<Material_list> material_list;

    public void setActivity_list(String activity_list) {
        this.activity_list = activity_list;
    }

    public String getActivity_list() {
        return this.activity_list;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public long getTs() {
        return this.ts;
    }

    public void setMaterial_list(List<Material_list> material_list) {
        this.material_list = material_list;
    }

    public List<Material_list> getMaterial_list() {
        return this.material_list;
    }
}


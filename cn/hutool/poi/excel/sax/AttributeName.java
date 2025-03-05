/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.xml.sax.Attributes
 */
package cn.hutool.poi.excel.sax;

import org.xml.sax.Attributes;

public enum AttributeName {
    r,
    s,
    t;


    public boolean match(String attributeName) {
        return this.name().equals((Object)attributeName);
    }

    public String getValue(Attributes attributes) {
        return attributes.getValue(this.name());
    }
}


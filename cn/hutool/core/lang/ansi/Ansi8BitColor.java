/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.lang.ansi;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.ansi.AnsiElement;

public final class Ansi8BitColor
implements AnsiElement {
    private static final String PREFIX_FORE = "38;5;";
    private static final String PREFIX_BACK = "48;5;";
    private final String prefix;
    private final int code;

    public static Ansi8BitColor foreground(int code) {
        return new Ansi8BitColor(PREFIX_FORE, code);
    }

    public static Ansi8BitColor background(int code) {
        return new Ansi8BitColor(PREFIX_BACK, code);
    }

    private Ansi8BitColor(String prefix, int code) {
        Assert.isTrue(code >= 0 && code <= 255, "Code must be between 0 and 255", new Object[0]);
        this.prefix = prefix;
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Ansi8BitColor other = (Ansi8BitColor)obj;
        return this.prefix.equals((Object)other.prefix) && this.code == other.code;
    }

    public int hashCode() {
        return this.prefix.hashCode() * 31 + this.code;
    }

    @Override
    public String toString() {
        return this.prefix + this.code;
    }
}


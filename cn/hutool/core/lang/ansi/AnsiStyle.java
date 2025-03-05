/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.lang.ansi;

import cn.hutool.core.lang.ansi.AnsiElement;
import cn.hutool.core.util.StrUtil;

public enum AnsiStyle implements AnsiElement
{
    NORMAL(0),
    BOLD(1),
    FAINT(2),
    ITALIC(3),
    UNDERLINE(4);

    private final int code;

    private AnsiStyle(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return StrUtil.toString(this.code);
    }
}


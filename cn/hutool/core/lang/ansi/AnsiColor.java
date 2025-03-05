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

public enum AnsiColor implements AnsiElement
{
    DEFAULT(39),
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    WHITE(37),
    BRIGHT_BLACK(90),
    BRIGHT_RED(91),
    BRIGHT_GREEN(92),
    BRIGHT_YELLOW(93),
    BRIGHT_BLUE(94),
    BRIGHT_MAGENTA(95),
    BRIGHT_CYAN(96),
    BRIGHT_WHITE(97);

    private final int code;

    private AnsiColor(int code) {
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


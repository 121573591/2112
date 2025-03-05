/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.core.lang.intern;

import cn.hutool.core.lang.intern.Interner;
import cn.hutool.core.lang.intern.JdkStringInterner;
import cn.hutool.core.lang.intern.WeakInterner;

public class InternUtil {
    public static <T> Interner<T> createWeakInterner() {
        return new WeakInterner();
    }

    public static Interner<String> createJdkInterner() {
        return new JdkStringInterner();
    }

    public static Interner<String> createStringInterner(boolean isWeak) {
        return isWeak ? InternUtil.createWeakInterner() : InternUtil.createJdkInterner();
    }
}


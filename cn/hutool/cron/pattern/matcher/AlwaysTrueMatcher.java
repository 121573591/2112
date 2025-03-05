/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.cron.pattern.matcher;

import cn.hutool.core.util.StrUtil;
import cn.hutool.cron.pattern.matcher.PartMatcher;

public class AlwaysTrueMatcher
implements PartMatcher {
    public static AlwaysTrueMatcher INSTANCE = new AlwaysTrueMatcher();

    @Override
    public boolean match(Integer t) {
        return true;
    }

    @Override
    public int nextAfter(int value) {
        return value;
    }

    public String toString() {
        return StrUtil.format("[Matcher]: always true.", new Object[0]);
    }
}


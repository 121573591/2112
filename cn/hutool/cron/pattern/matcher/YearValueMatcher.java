/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Collection
 *  java.util.LinkedHashSet
 */
package cn.hutool.cron.pattern.matcher;

import cn.hutool.cron.pattern.matcher.PartMatcher;
import java.util.Collection;
import java.util.LinkedHashSet;

public class YearValueMatcher
implements PartMatcher {
    private final LinkedHashSet<Integer> valueList;

    public YearValueMatcher(Collection<Integer> intValueList) {
        this.valueList = new LinkedHashSet(intValueList);
    }

    @Override
    public boolean match(Integer t) {
        return this.valueList.contains((Object)t);
    }

    @Override
    public int nextAfter(int value) {
        for (Integer year : this.valueList) {
            if (year < value) continue;
            return year;
        }
        return -1;
    }
}


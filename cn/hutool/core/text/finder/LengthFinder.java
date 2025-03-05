/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package cn.hutool.core.text.finder;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.finder.TextFinder;

public class LengthFinder
extends TextFinder {
    private static final long serialVersionUID = 1L;
    private final int length;

    public LengthFinder(int length) {
        Assert.isTrue(length > 0, "Length must be great than 0", new Object[0]);
        this.length = length;
    }

    @Override
    public int start(int from) {
        Assert.notNull(this.text, "Text to find must be not null!", new Object[0]);
        int limit = this.getValidEndIndex();
        if (this.negative) {
            int result = from - this.length;
            if (result > limit) {
                return result;
            }
        } else {
            int result = from + this.length;
            if (result < limit) {
                return result;
            }
        }
        return -1;
    }

    @Override
    public int end(int start) {
        return start;
    }
}


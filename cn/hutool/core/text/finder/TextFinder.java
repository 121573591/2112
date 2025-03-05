/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 */
package cn.hutool.core.text.finder;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.finder.Finder;
import java.io.Serializable;

public abstract class TextFinder
implements Finder,
Serializable {
    private static final long serialVersionUID = 1L;
    protected CharSequence text;
    protected int endIndex = -1;
    protected boolean negative;

    public TextFinder setText(CharSequence text) {
        this.text = Assert.notNull(text, "Text must be not null!", new Object[0]);
        return this;
    }

    public TextFinder setEndIndex(int endIndex) {
        this.endIndex = endIndex;
        return this;
    }

    public TextFinder setNegative(boolean negative) {
        this.negative = negative;
        return this;
    }

    protected int getValidEndIndex() {
        if (this.negative && -1 == this.endIndex) {
            return -1;
        }
        int limit = this.endIndex < 0 ? this.endIndex + this.text.length() + 1 : Math.min((int)this.endIndex, (int)this.text.length());
        return limit;
    }
}


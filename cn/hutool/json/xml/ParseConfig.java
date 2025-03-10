/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 */
package cn.hutool.json.xml;

import java.io.Serializable;

public class ParseConfig
implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int DEFAULT_MAXIMUM_NESTING_DEPTH = 512;
    private boolean keepStrings;
    private int maxNestingDepth = -1;

    public static ParseConfig of() {
        return new ParseConfig();
    }

    public boolean isKeepStrings() {
        return this.keepStrings;
    }

    public ParseConfig setKeepStrings(boolean keepStrings) {
        this.keepStrings = keepStrings;
        return this;
    }

    public int getMaxNestingDepth() {
        return this.maxNestingDepth;
    }

    public ParseConfig setMaxNestingDepth(int maxNestingDepth) {
        this.maxNestingDepth = maxNestingDepth;
        return this;
    }
}


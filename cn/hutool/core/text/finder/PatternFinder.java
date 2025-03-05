/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package cn.hutool.core.text.finder;

import cn.hutool.core.text.finder.TextFinder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternFinder
extends TextFinder {
    private static final long serialVersionUID = 1L;
    private final Pattern pattern;
    private Matcher matcher;

    public PatternFinder(String regex, boolean caseInsensitive) {
        this(Pattern.compile((String)regex, (int)(caseInsensitive ? 2 : 0)));
    }

    public PatternFinder(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public TextFinder setText(CharSequence text) {
        this.matcher = this.pattern.matcher(text);
        return super.setText(text);
    }

    @Override
    public TextFinder setNegative(boolean negative) {
        throw new UnsupportedOperationException("Negative is invalid for Pattern!");
    }

    @Override
    public int start(int from) {
        int end;
        if (this.matcher.find(from) && (end = this.matcher.end()) <= this.getValidEndIndex()) {
            int start = this.matcher.start();
            if (start == end) {
                return -1;
            }
            return start;
        }
        return -1;
    }

    @Override
    public int end(int start) {
        int end = this.matcher.end();
        int limit = this.endIndex < 0 ? this.text.length() : Math.min((int)this.endIndex, (int)this.text.length());
        return end <= limit ? end : -1;
    }

    @Override
    public PatternFinder reset() {
        this.matcher.reset();
        return this;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.function.Function
 */
package cn.hutool.core.text.split;

import cn.hutool.core.collection.ComputeIter;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.finder.TextFinder;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SplitIter
extends ComputeIter<String>
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String text;
    private final TextFinder finder;
    private final int limit;
    private final boolean ignoreEmpty;
    private int offset;
    private int count;

    public SplitIter(CharSequence text, TextFinder separatorFinder, int limit, boolean ignoreEmpty) {
        Assert.notNull(text, "Text must be not null!", new Object[0]);
        this.text = text.toString();
        this.finder = separatorFinder.setText(text);
        this.limit = limit > 0 ? limit : Integer.MAX_VALUE;
        this.ignoreEmpty = ignoreEmpty;
    }

    @Override
    protected String computeNext() {
        if (this.count >= this.limit || this.offset > this.text.length()) {
            return null;
        }
        if (this.count == this.limit - 1) {
            if (this.ignoreEmpty && this.offset == this.text.length()) {
                return null;
            }
            ++this.count;
            return this.text.substring(this.offset);
        }
        int start = this.finder.start(this.offset);
        if (start < 0) {
            if (this.offset <= this.text.length()) {
                String result = this.text.substring(this.offset);
                if (!this.ignoreEmpty || !result.isEmpty()) {
                    this.offset = Integer.MAX_VALUE;
                    return result;
                }
            }
            return null;
        }
        String result = this.text.substring(this.offset, start);
        this.offset = this.finder.end(start);
        if (this.ignoreEmpty && result.isEmpty()) {
            return this.computeNext();
        }
        ++this.count;
        return result;
    }

    public void reset() {
        this.finder.reset();
        this.offset = 0;
        this.count = 0;
    }

    public String[] toArray(boolean trim) {
        return (String[])this.toList(trim).toArray((Object[])new String[0]);
    }

    public List<String> toList(boolean trim) {
        return this.toList(str -> trim ? StrUtil.trim(str) : str);
    }

    public <T> List<T> toList(Function<String, T> mapping) {
        ArrayList result = new ArrayList();
        while (this.hasNext()) {
            Object apply = mapping.apply(this.next());
            if (this.ignoreEmpty && StrUtil.isEmptyIfStr(apply)) continue;
            result.add(apply);
        }
        if (result.isEmpty()) {
            return new ArrayList(0);
        }
        return result;
    }
}


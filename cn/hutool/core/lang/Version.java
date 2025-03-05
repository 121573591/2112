/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package cn.hutool.core.lang;

import cn.hutool.core.comparator.CompareUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.CharUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Version
implements Comparable<Version>,
Serializable {
    private static final long serialVersionUID = 1L;
    private final String version;
    private final List<Object> sequence;
    private final List<Object> pre;
    private final List<Object> build;

    public static Version of(String v) {
        return new Version(v);
    }

    public Version(String v) {
        Assert.notNull(v, "Null version string", new Object[0]);
        int n = v.length();
        if (n == 0) {
            throw new IllegalArgumentException("Empty version string");
        }
        this.version = v;
        this.sequence = new ArrayList(4);
        this.pre = new ArrayList(2);
        this.build = new ArrayList(2);
        int i = 0;
        char c = v.charAt(i);
        List<Object> sequence2 = this.sequence;
        List<Object> pre = this.pre;
        List<Object> build = this.build;
        i = Version.takeNumber(v, i, sequence2);
        while (i < n) {
            c = v.charAt(i);
            if (c == '.') {
                ++i;
                continue;
            }
            if (c == '-' || c == '+') {
                ++i;
                break;
            }
            if (CharUtil.isNumber(c)) {
                i = Version.takeNumber(v, i, sequence2);
                continue;
            }
            i = Version.takeString(v, i, sequence2);
        }
        if (c == '-' && i >= n) {
            return;
        }
        while (i < n && (i = (c = v.charAt(i)) >= '0' && c <= '9' ? Version.takeNumber(v, i, pre) : Version.takeString(v, i, pre)) < n) {
            c = v.charAt(i);
            if (c == '.' || c == '-') {
                ++i;
                continue;
            }
            if (c != '+') continue;
            ++i;
            break;
        }
        if (c == '+' && i >= n) {
            return;
        }
        while (i < n && (i = (c = v.charAt(i)) >= '0' && c <= '9' ? Version.takeNumber(v, i, build) : Version.takeString(v, i, build)) < n) {
            c = v.charAt(i);
            if (c != '.' && c != '-' && c != '+') continue;
            ++i;
        }
    }

    public int compareTo(Version that) {
        int c = this.compareTokens(this.sequence, that.sequence);
        if (c != 0) {
            return c;
        }
        if (this.pre.isEmpty()) {
            if (!that.pre.isEmpty()) {
                return 1;
            }
        } else if (that.pre.isEmpty()) {
            return -1;
        }
        if ((c = this.compareTokens(this.pre, that.pre)) != 0) {
            return c;
        }
        return this.compareTokens(this.build, that.build);
    }

    public boolean equals(Object ob) {
        if (!(ob instanceof Version)) {
            return false;
        }
        return this.compareTo((Version)ob) == 0;
    }

    public int hashCode() {
        return this.version.hashCode();
    }

    public String toString() {
        return this.version;
    }

    private static int takeNumber(String s, int i, List<Object> acc) {
        char c = s.charAt(i);
        int d = c - 48;
        int n = s.length();
        while (++i < n && CharUtil.isNumber(c = s.charAt(i))) {
            d = d * 10 + (c - 48);
        }
        acc.add((Object)d);
        return i;
    }

    private static int takeString(String s, int i, List<Object> acc) {
        char c;
        int b = i;
        int n = s.length();
        while (++i < n && (c = s.charAt(i)) != '.' && c != '-' && c != '+' && (c < '0' || c > '9')) {
        }
        acc.add((Object)s.substring(b, i));
        return i;
    }

    private int compareTokens(List<Object> ts1, List<Object> ts2) {
        int n = Math.min((int)ts1.size(), (int)ts2.size());
        for (int i = 0; i < n; ++i) {
            int c;
            Object o1 = ts1.get(i);
            Object o2 = ts2.get(i);
            if (o1 instanceof Integer && o2 instanceof Integer || o1 instanceof String && o2 instanceof String) {
                c = CompareUtil.compare(o1, o2, null);
                if (c == 0) continue;
                return c;
            }
            c = o1.toString().compareTo(o2.toString());
            if (c == 0) continue;
            return c;
        }
        List<Object> rest = ts1.size() > ts2.size() ? ts1 : ts2;
        int e = rest.size();
        for (int i = n; i < e; ++i) {
            Object o = rest.get(i);
            if (o instanceof Integer && (Integer)o == 0) continue;
            return ts1.size() - ts2.size();
        }
        return 0;
    }
}


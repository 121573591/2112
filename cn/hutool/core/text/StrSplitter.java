/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.function.Function
 *  java.util.regex.Pattern
 */
package cn.hutool.core.text;

import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.text.finder.CharFinder;
import cn.hutool.core.text.finder.CharMatcherFinder;
import cn.hutool.core.text.finder.LengthFinder;
import cn.hutool.core.text.finder.PatternFinder;
import cn.hutool.core.text.finder.StrFinder;
import cn.hutool.core.text.split.SplitIter;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class StrSplitter {
    public static List<String> splitPath(CharSequence str) {
        return StrSplitter.splitPath(str, 0);
    }

    public static String[] splitPathToArray(CharSequence str) {
        return StrSplitter.toArray(StrSplitter.splitPath(str));
    }

    public static List<String> splitPath(CharSequence str, int limit) {
        return StrSplitter.split(str, '/', limit, true, true);
    }

    public static String[] splitPathToArray(CharSequence str, int limit) {
        return StrSplitter.toArray(StrSplitter.splitPath(str, limit));
    }

    public static List<String> splitTrim(CharSequence str, char separator, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, 0, true, ignoreEmpty);
    }

    public static List<String> split(CharSequence str, char separator, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, 0, isTrim, ignoreEmpty);
    }

    public static List<String> splitTrim(CharSequence str, char separator, int limit, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, limit, true, ignoreEmpty, false);
    }

    public static List<String> split(CharSequence str, char separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, limit, isTrim, ignoreEmpty, false);
    }

    public static <R> List<R> split(CharSequence str, char separator, int limit, boolean ignoreEmpty, Function<String, R> mapping) {
        return StrSplitter.split(str, separator, limit, ignoreEmpty, false, mapping);
    }

    public static List<String> splitIgnoreCase(CharSequence text, char separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.split(text, separator, limit, isTrim, ignoreEmpty, true);
    }

    public static List<String> split(CharSequence text, char separator, int limit, boolean isTrim, boolean ignoreEmpty, boolean ignoreCase) {
        return StrSplitter.split(text, separator, limit, ignoreEmpty, ignoreCase, StrSplitter.trimFunc(isTrim));
    }

    public static <R> List<R> split(CharSequence text, char separator, int limit, boolean ignoreEmpty, boolean ignoreCase, Function<String, R> mapping) {
        if (null == text) {
            return new ArrayList(0);
        }
        SplitIter splitIter = new SplitIter(text, new CharFinder(separator, ignoreCase), limit, ignoreEmpty);
        return splitIter.toList(mapping);
    }

    public static String[] splitToArray(CharSequence str, char separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.toArray(StrSplitter.split(str, separator, limit, isTrim, ignoreEmpty));
    }

    public static List<String> split(CharSequence str, String separator, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, -1, isTrim, ignoreEmpty, false);
    }

    public static List<String> splitTrim(CharSequence str, String separator, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, true, ignoreEmpty);
    }

    public static List<String> split(CharSequence str, String separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, limit, isTrim, ignoreEmpty, false);
    }

    public static List<String> splitTrim(CharSequence str, String separator, int limit, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, limit, true, ignoreEmpty);
    }

    public static List<String> splitIgnoreCase(CharSequence str, String separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, limit, isTrim, ignoreEmpty, true);
    }

    public static List<String> splitTrimIgnoreCase(CharSequence str, String separator, int limit, boolean ignoreEmpty) {
        return StrSplitter.split(str, separator, limit, true, ignoreEmpty, true);
    }

    public static List<String> split(CharSequence text, String separator, int limit, boolean isTrim, boolean ignoreEmpty, boolean ignoreCase) {
        if (null == text) {
            return new ArrayList(0);
        }
        SplitIter splitIter = new SplitIter(text, new StrFinder(separator, ignoreCase), limit, ignoreEmpty);
        return splitIter.toList(isTrim);
    }

    public static String[] splitToArray(CharSequence str, String separator, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.toArray(StrSplitter.split(str, separator, limit, isTrim, ignoreEmpty));
    }

    public static List<String> split(CharSequence text, int limit) {
        if (null == text) {
            return new ArrayList(0);
        }
        SplitIter splitIter = new SplitIter(text, new CharMatcherFinder(CharUtil::isBlankChar), limit, true);
        return splitIter.toList(false);
    }

    public static String[] splitToArray(String str, int limit) {
        return StrSplitter.toArray(StrSplitter.split(str, limit));
    }

    public static List<String> splitByRegex(String text, String separatorRegex, int limit, boolean isTrim, boolean ignoreEmpty) {
        Pattern pattern = PatternPool.get(separatorRegex);
        return StrSplitter.split(text, pattern, limit, isTrim, ignoreEmpty);
    }

    public static List<String> split(String text, Pattern separatorPattern, int limit, boolean isTrim, boolean ignoreEmpty) {
        if (null == text) {
            return new ArrayList(0);
        }
        SplitIter splitIter = new SplitIter(text, new PatternFinder(separatorPattern), limit, ignoreEmpty);
        return splitIter.toList(isTrim);
    }

    public static String[] splitToArray(String str, Pattern separatorPattern, int limit, boolean isTrim, boolean ignoreEmpty) {
        return StrSplitter.toArray(StrSplitter.split(str, separatorPattern, limit, isTrim, ignoreEmpty));
    }

    public static String[] splitByLength(CharSequence text, int len) {
        if (null == text) {
            return new String[0];
        }
        SplitIter splitIter = new SplitIter(text, new LengthFinder(len), -1, false);
        return splitIter.toArray(false);
    }

    private static String[] toArray(List<String> list) {
        return (String[])list.toArray((Object[])new String[0]);
    }

    private static Function<String, String> trimFunc(boolean isTrim) {
        return str -> isTrim ? StrUtil.trim(str) : str;
    }
}


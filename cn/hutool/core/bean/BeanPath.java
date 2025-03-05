/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package cn.hutool.core.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanPath
implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final char[] EXP_CHARS = new char[]{'.', '[', ']'};
    private boolean isStartWith = false;
    protected List<String> patternParts;

    public static BeanPath create(String expression) {
        return new BeanPath(expression);
    }

    public BeanPath(String expression) {
        this.init(expression);
    }

    public List<String> getPatternParts() {
        return this.patternParts;
    }

    public Object get(Object bean) {
        return this.get(this.patternParts, bean, false);
    }

    public void set(Object bean, Object value) {
        this.set(bean, this.patternParts, BeanPath.lastIsNumber(this.patternParts), value);
    }

    public String toString() {
        return this.patternParts.toString();
    }

    private void set(Object bean, List<String> patternParts, boolean nextNumberPart, Object value) {
        Object newSubBean;
        Object subBean = this.get(patternParts, bean, true);
        if (null == subBean) {
            List<String> parentParts = BeanPath.getParentParts(patternParts);
            this.set(bean, parentParts, BeanPath.lastIsNumber(parentParts), nextNumberPart ? new ArrayList() : new HashMap());
            subBean = this.get(patternParts, bean, true);
        }
        if ((newSubBean = BeanUtil.setFieldValue(subBean, (String)patternParts.get(patternParts.size() - 1), value)) != subBean) {
            this.set(bean, BeanPath.getParentParts(patternParts), nextNumberPart, newSubBean);
        }
    }

    private static boolean lastIsNumber(List<String> patternParts) {
        return NumberUtil.isInteger((String)patternParts.get(patternParts.size() - 1));
    }

    private static List<String> getParentParts(List<String> patternParts) {
        return patternParts.subList(0, patternParts.size() - 1);
    }

    private Object get(List<String> patternParts, Object bean, boolean ignoreLast) {
        int length = patternParts.size();
        if (ignoreLast) {
            --length;
        }
        Object subBean = bean;
        boolean isFirst = true;
        for (int i = 0; i < length; ++i) {
            String patternPart = (String)patternParts.get(i);
            if (null != (subBean = BeanPath.getFieldValue(subBean, patternPart))) continue;
            if (isFirst && !this.isStartWith && BeanUtil.isMatchName(bean, patternPart, true)) {
                subBean = bean;
                isFirst = false;
                continue;
            }
            return null;
        }
        return subBean;
    }

    private static Object getFieldValue(Object bean, String expression) {
        if (StrUtil.isBlank(expression)) {
            return null;
        }
        if (StrUtil.contains((CharSequence)expression, ':')) {
            List<String> parts = StrUtil.splitTrim((CharSequence)expression, ':');
            int start = Integer.parseInt((String)((String)parts.get(0)));
            int end = Integer.parseInt((String)((String)parts.get(1)));
            int step = 1;
            if (3 == parts.size()) {
                step = Integer.parseInt((String)((String)parts.get(2)));
            }
            if (bean instanceof Collection) {
                return CollUtil.sub((Collection)bean, start, end, step);
            }
            if (ArrayUtil.isArray(bean)) {
                return ArrayUtil.sub(bean, start, end, step);
            }
        } else {
            if (StrUtil.contains((CharSequence)expression, ',')) {
                List<String> keys = StrUtil.splitTrim((CharSequence)expression, ',');
                if (bean instanceof Collection) {
                    return CollUtil.getAny((Collection)bean, Convert.convert(int[].class, keys));
                }
                if (ArrayUtil.isArray(bean)) {
                    return ArrayUtil.getAny(bean, Convert.convert(int[].class, keys));
                }
                String[] unWrappedKeys = new String[keys.size()];
                for (int i = 0; i < unWrappedKeys.length; ++i) {
                    unWrappedKeys[i] = StrUtil.unWrap((CharSequence)keys.get(i), '\'');
                }
                if (bean instanceof Map) {
                    return MapUtil.getAny((Map)bean, unWrappedKeys);
                }
                Map<String, Object> map = BeanUtil.beanToMap(bean, new String[0]);
                return MapUtil.getAny(map, unWrappedKeys);
            }
            return BeanUtil.getFieldValue(bean, expression);
        }
        return null;
    }

    private void init(String expression) {
        ArrayList localPatternParts = new ArrayList();
        int length = expression.length();
        StringBuilder builder = new StringBuilder();
        boolean isNumStart = false;
        boolean isInWrap = false;
        for (int i = 0; i < length; ++i) {
            char c = expression.charAt(i);
            if (0 == i && '$' == c) {
                this.isStartWith = true;
                continue;
            }
            if ('\'' == c) {
                isInWrap = false == isInWrap;
                continue;
            }
            if (!isInWrap && ArrayUtil.contains(EXP_CHARS, c)) {
                if (']' == c) {
                    if (!isNumStart) {
                        throw new IllegalArgumentException(StrUtil.format("Bad expression '{}':{}, we find ']' but no '[' !", expression, i));
                    }
                    isNumStart = false;
                } else {
                    if (isNumStart) {
                        throw new IllegalArgumentException(StrUtil.format("Bad expression '{}':{}, we find '[' but no ']' !", expression, i));
                    }
                    if ('[' == c) {
                        isNumStart = true;
                    }
                }
                if (builder.length() > 0) {
                    localPatternParts.add((Object)builder.toString());
                }
                builder.setLength(0);
                continue;
            }
            builder.append(c);
        }
        if (isNumStart) {
            throw new IllegalArgumentException(StrUtil.format("Bad expression '{}':{}, we find '[' but no ']' !", expression, length - 1));
        }
        if (builder.length() > 0) {
            localPatternParts.add((Object)builder.toString());
        }
        this.patternParts = ListUtil.unmodifiable(localPatternParts);
    }
}


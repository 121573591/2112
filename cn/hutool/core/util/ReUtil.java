/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.TreeSet
 *  java.util.function.Consumer
 *  java.util.regex.MatchResult
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package cn.hutool.core.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.comparator.LengthComparator;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.PatternPool;
import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.mutable.Mutable;
import cn.hutool.core.lang.mutable.MutableObj;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReUtil {
    public static final String RE_CHINESE = "[⺀-⻿⼀-⿟㇀-㇯㐀-䶿一-鿿豈-﫿𠀀-𪛟𪜀-𫜿𫝀-𫠟𫠠-𬺯丽-𯨟]";
    public static final String RE_CHINESES = "[⺀-⻿⼀-⿟㇀-㇯㐀-䶿一-鿿豈-﫿𠀀-𪛟𪜀-𫜿𫝀-𫠟𫠠-𬺯丽-𯨟]+";
    public static final Set<Character> RE_KEYS = CollUtil.newHashSet(Character.valueOf((char)'$'), Character.valueOf((char)'('), Character.valueOf((char)')'), Character.valueOf((char)'*'), Character.valueOf((char)'+'), Character.valueOf((char)'.'), Character.valueOf((char)'['), Character.valueOf((char)']'), Character.valueOf((char)'?'), Character.valueOf((char)'\\'), Character.valueOf((char)'^'), Character.valueOf((char)'{'), Character.valueOf((char)'}'), Character.valueOf((char)'|'));

    public static String getGroup0(String regex, CharSequence content) {
        return ReUtil.get(regex, content, 0);
    }

    public static String getGroup1(String regex, CharSequence content) {
        return ReUtil.get(regex, content, 1);
    }

    public static String get(String regex, CharSequence content, int groupIndex) {
        if (null == content || null == regex) {
            return null;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.get(pattern, content, groupIndex);
    }

    public static String get(String regex, CharSequence content, String groupName) {
        if (null == content || null == regex) {
            return null;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.get(pattern, content, groupName);
    }

    public static String getGroup0(Pattern pattern, CharSequence content) {
        return ReUtil.get(pattern, content, 0);
    }

    public static String getGroup1(Pattern pattern, CharSequence content) {
        return ReUtil.get(pattern, content, 1);
    }

    public static String get(Pattern pattern, CharSequence content, int groupIndex) {
        if (null == content || null == pattern) {
            return null;
        }
        MutableObj result = new MutableObj();
        ReUtil.get(pattern, content, (Consumer<Matcher>)((Consumer)matcher -> result.set(matcher.group(groupIndex))));
        return (String)result.get();
    }

    public static String get(Pattern pattern, CharSequence content, String groupName) {
        if (null == content || null == pattern || null == groupName) {
            return null;
        }
        MutableObj result = new MutableObj();
        ReUtil.get(pattern, content, (Consumer<Matcher>)((Consumer)matcher -> result.set(matcher.group(groupName))));
        return (String)result.get();
    }

    public static void get(Pattern pattern, CharSequence content, Consumer<Matcher> consumer) {
        if (null == content || null == pattern || null == consumer) {
            return;
        }
        Matcher m = pattern.matcher(content);
        if (m.find()) {
            consumer.accept((Object)m);
        }
    }

    public static List<String> getAllGroups(Pattern pattern, CharSequence content) {
        return ReUtil.getAllGroups(pattern, content, true);
    }

    public static List<String> getAllGroups(Pattern pattern, CharSequence content, boolean withGroup0) {
        return ReUtil.getAllGroups(pattern, content, withGroup0, false);
    }

    public static List<String> getAllGroups(Pattern pattern, CharSequence content, boolean withGroup0, boolean findAll) {
        if (null == content || null == pattern) {
            return null;
        }
        ArrayList result = new ArrayList();
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            int startGroup = withGroup0 ? 0 : 1;
            int groupCount = matcher.groupCount();
            for (int i = startGroup; i <= groupCount; ++i) {
                result.add((Object)matcher.group(i));
            }
            if (findAll) continue;
            break;
        }
        return result;
    }

    public static Map<String, String> getAllGroupNames(Pattern pattern, CharSequence content) {
        if (null == content || null == pattern) {
            return null;
        }
        Matcher m = pattern.matcher(content);
        HashMap result = MapUtil.newHashMap(m.groupCount());
        if (m.find()) {
            Map map = (Map)ReflectUtil.invoke((Object)pattern, "namedGroups", new Object[0]);
            map.forEach((key, value) -> {
                String cfr_ignored_0 = (String)result.put(key, (Object)m.group(value.intValue()));
            });
        }
        return result;
    }

    public static String extractMulti(Pattern pattern, CharSequence content, String template) {
        if (null == content || null == pattern || null == template) {
            return null;
        }
        TreeSet varNums = new TreeSet((o1, o2) -> ObjectUtil.compare(o2, o1));
        Matcher matcherForTemplate = PatternPool.GROUP_VAR.matcher((CharSequence)template);
        while (matcherForTemplate.find()) {
            varNums.add((Object)Integer.parseInt((String)matcherForTemplate.group(1)));
        }
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            for (Integer group : varNums) {
                template = template.replace((CharSequence)("$" + group), (CharSequence)matcher.group(group.intValue()));
            }
            return template;
        }
        return null;
    }

    public static String extractMulti(String regex, CharSequence content, String template) {
        if (null == content || null == regex || null == template) {
            return null;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.extractMulti(pattern, content, template);
    }

    public static String extractMultiAndDelPre(Pattern pattern, Mutable<CharSequence> contentHolder, String template) {
        if (null == contentHolder || null == pattern || null == template) {
            return null;
        }
        HashSet varNums = ReUtil.findAll(PatternPool.GROUP_VAR, (CharSequence)template, 1, new HashSet());
        CharSequence content = contentHolder.get();
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            for (String var : varNums) {
                int group = Integer.parseInt((String)var);
                template = template.replace((CharSequence)("$" + var), (CharSequence)matcher.group(group));
            }
            contentHolder.set(StrUtil.sub(content, matcher.end(), content.length()));
            return template;
        }
        return null;
    }

    public static String extractMultiAndDelPre(String regex, Mutable<CharSequence> contentHolder, String template) {
        if (null == contentHolder || null == regex || null == template) {
            return null;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.extractMultiAndDelPre(pattern, contentHolder, template);
    }

    public static String delFirst(String regex, CharSequence content) {
        if (StrUtil.hasBlank(regex, content)) {
            return StrUtil.str(content);
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.delFirst(pattern, content);
    }

    public static String delFirst(Pattern pattern, CharSequence content) {
        return ReUtil.replaceFirst(pattern, content, "");
    }

    public static String replaceFirst(Pattern pattern, CharSequence content, String replacement) {
        if (null == pattern || StrUtil.isEmpty(content)) {
            return StrUtil.str(content);
        }
        return pattern.matcher(content).replaceFirst(replacement);
    }

    public static String delLast(String regex, CharSequence str) {
        if (StrUtil.hasBlank(regex, str)) {
            return StrUtil.str(str);
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.delLast(pattern, str);
    }

    public static String delLast(Pattern pattern, CharSequence str) {
        MatchResult matchResult;
        if (null != pattern && StrUtil.isNotEmpty(str) && null != (matchResult = ReUtil.lastIndexOf(pattern, str))) {
            return StrUtil.subPre(str, matchResult.start()) + StrUtil.subSuf(str, matchResult.end());
        }
        return StrUtil.str(str);
    }

    public static String delAll(String regex, CharSequence content) {
        if (StrUtil.hasEmpty(regex, content)) {
            return StrUtil.str(content);
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.delAll(pattern, content);
    }

    public static String delAll(Pattern pattern, CharSequence content) {
        if (null == pattern || StrUtil.isEmpty(content)) {
            return StrUtil.str(content);
        }
        return pattern.matcher(content).replaceAll("");
    }

    public static String delPre(String regex, CharSequence content) {
        if (null == content || null == regex) {
            return StrUtil.str(content);
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.delPre(pattern, content);
    }

    public static String delPre(Pattern pattern, CharSequence content) {
        if (null == content || null == pattern) {
            return StrUtil.str(content);
        }
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return StrUtil.sub(content, matcher.end(), content.length());
        }
        return StrUtil.str(content);
    }

    public static List<String> findAllGroup0(String regex, CharSequence content) {
        return ReUtil.findAll(regex, content, 0);
    }

    public static List<String> findAllGroup1(String regex, CharSequence content) {
        return ReUtil.findAll(regex, content, 1);
    }

    public static List<String> findAll(String regex, CharSequence content, int group) {
        return (List)ReUtil.findAll(regex, content, group, new ArrayList());
    }

    public static <T extends Collection<String>> T findAll(String regex, CharSequence content, int group, T collection) {
        if (null == regex) {
            return collection;
        }
        return ReUtil.findAll(PatternPool.get(regex, 32), content, group, collection);
    }

    public static List<String> findAllGroup0(Pattern pattern, CharSequence content) {
        return ReUtil.findAll(pattern, content, 0);
    }

    public static List<String> findAllGroup1(Pattern pattern, CharSequence content) {
        return ReUtil.findAll(pattern, content, 1);
    }

    public static List<String> findAll(Pattern pattern, CharSequence content, int group) {
        return (List)ReUtil.findAll(pattern, content, group, new ArrayList());
    }

    public static <T extends Collection<String>> T findAll(Pattern pattern, CharSequence content, int group, T collection) {
        if (null == pattern || null == content) {
            return null;
        }
        Assert.notNull(collection, "Collection must be not null !", new Object[0]);
        ReUtil.findAll(pattern, content, (Consumer<Matcher>)((Consumer)matcher -> collection.add((Object)matcher.group(group))));
        return collection;
    }

    public static void findAll(Pattern pattern, CharSequence content, Consumer<Matcher> consumer) {
        if (null == pattern || null == content) {
            return;
        }
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            consumer.accept((Object)matcher);
        }
    }

    public static int count(String regex, CharSequence content) {
        if (null == regex || null == content) {
            return 0;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.count(pattern, content);
    }

    public static int count(Pattern pattern, CharSequence content) {
        if (null == pattern || null == content) {
            return 0;
        }
        int count = 0;
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            ++count;
        }
        return count;
    }

    public static boolean contains(String regex, CharSequence content) {
        if (null == regex || null == content) {
            return false;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.contains(pattern, content);
    }

    public static boolean contains(Pattern pattern, CharSequence content) {
        if (null == pattern || null == content) {
            return false;
        }
        return pattern.matcher(content).find();
    }

    public static MatchResult indexOf(String regex, CharSequence content) {
        if (null == regex || null == content) {
            return null;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.indexOf(pattern, content);
    }

    public static MatchResult indexOf(Pattern pattern, CharSequence content) {
        Matcher matcher;
        if (null != pattern && null != content && (matcher = pattern.matcher(content)).find()) {
            return matcher.toMatchResult();
        }
        return null;
    }

    public static MatchResult lastIndexOf(String regex, CharSequence content) {
        if (null == regex || null == content) {
            return null;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.lastIndexOf(pattern, content);
    }

    public static MatchResult lastIndexOf(Pattern pattern, CharSequence content) {
        MatchResult result = null;
        if (null != pattern && null != content) {
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) {
                result = matcher.toMatchResult();
            }
        }
        return result;
    }

    public static Integer getFirstNumber(CharSequence StringWithNumber) {
        return Convert.toInt(ReUtil.get(PatternPool.NUMBERS, StringWithNumber, 0), null);
    }

    public static boolean isMatch(String regex, CharSequence content) {
        if (content == null) {
            return false;
        }
        if (StrUtil.isEmpty(regex)) {
            return true;
        }
        Pattern pattern = PatternPool.get(regex, 32);
        return ReUtil.isMatch(pattern, content);
    }

    public static boolean isMatch(Pattern pattern, CharSequence content) {
        if (content == null || pattern == null) {
            return false;
        }
        return pattern.matcher(content).matches();
    }

    public static String replaceAll(CharSequence content, String regex, String replacementTemplate) {
        Pattern pattern = Pattern.compile((String)regex, (int)32);
        return ReUtil.replaceAll(content, pattern, replacementTemplate);
    }

    public static String replaceAll(CharSequence content, Pattern pattern, String replacementTemplate) {
        if (StrUtil.isEmpty(content)) {
            return StrUtil.str(content);
        }
        Matcher matcher = pattern.matcher(content);
        boolean result = matcher.find();
        if (result) {
            Set varNums = (Set)ReUtil.findAll(PatternPool.GROUP_VAR, (CharSequence)replacementTemplate, 1, new TreeSet(LengthComparator.INSTANCE.reversed()));
            StringBuffer sb = new StringBuffer();
            do {
                String replacement = replacementTemplate;
                for (String var : varNums) {
                    int group = Integer.parseInt((String)var);
                    replacement = replacement.replace((CharSequence)("$" + var), (CharSequence)matcher.group(group));
                }
                matcher.appendReplacement(sb, ReUtil.escape(replacement));
            } while (result = matcher.find());
            matcher.appendTail(sb);
            return sb.toString();
        }
        return StrUtil.str(content);
    }

    public static String replaceAll(CharSequence str, String regex, Func1<Matcher, String> replaceFun) {
        return ReUtil.replaceAll(str, Pattern.compile((String)regex), replaceFun);
    }

    public static String replaceAll(CharSequence str, Pattern pattern, Func1<Matcher, String> replaceFun) {
        if (StrUtil.isEmpty(str)) {
            return StrUtil.str(str);
        }
        Matcher matcher = pattern.matcher(str);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            try {
                matcher.appendReplacement(buffer, replaceFun.call(matcher));
            }
            catch (Exception e) {
                throw new UtilException(e);
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    public static String escape(char c) {
        StringBuilder builder = new StringBuilder();
        if (RE_KEYS.contains((Object)Character.valueOf((char)c))) {
            builder.append('\\');
        }
        builder.append(c);
        return builder.toString();
    }

    public static String escape(CharSequence content) {
        if (StrUtil.isBlank(content)) {
            return StrUtil.str(content);
        }
        StringBuilder builder = new StringBuilder();
        int len = content.length();
        for (int i = 0; i < len; ++i) {
            char current = content.charAt(i);
            if (RE_KEYS.contains((Object)Character.valueOf((char)current))) {
                builder.append('\\');
            }
            builder.append(current);
        }
        return builder.toString();
    }
}


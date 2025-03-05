/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package cn.hutool.http;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HTMLFilter;

public class HtmlUtil {
    public static final String NBSP = "&nbsp;";
    public static final String AMP = "&amp;";
    public static final String QUOTE = "&quot;";
    public static final String APOS = "&apos;";
    public static final String LT = "&lt;";
    public static final String GT = "&gt;";
    public static final String RE_HTML_MARK = "(<[^<]*?>)|(<[\\s]*?/[^<]*?>)|(<[^<]*?/[\\s]*?>)";
    public static final String RE_SCRIPT = "<[\\s]*?script[^>]*?>.*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
    private static final char[][] TEXT = new char[256][];

    public static String escape(String text) {
        return HtmlUtil.encode(text);
    }

    public static String unescape(String htmlStr) {
        if (StrUtil.isBlank(htmlStr)) {
            return htmlStr;
        }
        return EscapeUtil.unescapeHtml4(htmlStr);
    }

    public static String cleanHtmlTag(String content) {
        return content.replaceAll(RE_HTML_MARK, "");
    }

    public static String removeHtmlTag(String content, String ... tagNames) {
        return HtmlUtil.removeHtmlTag(content, true, tagNames);
    }

    public static String unwrapHtmlTag(String content, String ... tagNames) {
        return HtmlUtil.removeHtmlTag(content, false, tagNames);
    }

    public static String removeHtmlTag(String content, boolean withTagContent, String ... tagNames) {
        for (String tagName : tagNames) {
            if (StrUtil.isBlank(tagName)) continue;
            tagName = tagName.trim();
            String regex = withTagContent ? StrUtil.format("(?i)<{}(\\s+[^>]*?)?/?>(.*?</{}>)?", tagName, tagName) : StrUtil.format("(?i)<{}(\\s+[^>]*?)?/?>|</?{}>", tagName, tagName);
            content = ReUtil.delAll(regex, (CharSequence)content);
        }
        return content;
    }

    public static String removeHtmlAttr(String content, String ... attrs) {
        for (String attr : attrs) {
            String regex = StrUtil.format("(?i)(\\s*{}\\s*=\\s*)(([\"][^\"]+?[\"])|([^>]+?\\s*(?=\\s|>)))", attr);
            content = content.replaceAll(regex, "");
        }
        content = ReUtil.replaceAll((CharSequence)content, "\\s+(>|/>)", "$1");
        return content;
    }

    public static String removeAllHtmlAttr(String content, String ... tagNames) {
        for (String tagName : tagNames) {
            String regex = StrUtil.format("(?i)<{}[^>]*?>", tagName);
            content = content.replaceAll(regex, StrUtil.format("<{}>", tagName));
        }
        return content;
    }

    private static String encode(String text) {
        int len;
        if (text == null || (len = text.length()) == 0) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(len + (len >> 2));
        for (int i = 0; i < len; ++i) {
            char c = text.charAt(i);
            if (c < '\u0100') {
                buffer.append(TEXT[c]);
                continue;
            }
            buffer.append(c);
        }
        return buffer.toString();
    }

    public static String filter(String htmlContent) {
        return new HTMLFilter().filter(htmlContent);
    }

    static {
        for (int i = 0; i < 256; ++i) {
            HtmlUtil.TEXT[i] = new char[]{(char)i};
        }
        HtmlUtil.TEXT[39] = "&#039;".toCharArray();
        HtmlUtil.TEXT[34] = QUOTE.toCharArray();
        HtmlUtil.TEXT[38] = AMP.toCharArray();
        HtmlUtil.TEXT[60] = LT.toCharArray();
        HtmlUtil.TEXT[62] = GT.toCharArray();
        HtmlUtil.TEXT[160] = NBSP.toCharArray();
    }
}


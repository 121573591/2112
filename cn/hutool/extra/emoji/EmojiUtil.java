/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.vdurmont.emoji.Emoji
 *  com.vdurmont.emoji.EmojiManager
 *  com.vdurmont.emoji.EmojiParser
 *  com.vdurmont.emoji.EmojiParser$FitzpatrickAction
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  java.util.Set
 */
package cn.hutool.extra.emoji;

import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import com.vdurmont.emoji.EmojiParser;
import java.util.List;
import java.util.Set;

public class EmojiUtil {
    public static boolean isEmoji(String str) {
        return EmojiManager.isEmoji((String)str);
    }

    public static boolean containsEmoji(String str) {
        return EmojiManager.containsEmoji((String)str);
    }

    public static Set<Emoji> getByTag(String tag) {
        return EmojiManager.getForTag((String)tag);
    }

    public static Emoji get(String alias) {
        return EmojiManager.getForAlias((String)alias);
    }

    public static String toUnicode(String str) {
        return EmojiParser.parseToUnicode((String)str);
    }

    public static String toAlias(String str) {
        return EmojiUtil.toAlias(str, EmojiParser.FitzpatrickAction.PARSE);
    }

    public static String toAlias(String str, EmojiParser.FitzpatrickAction fitzpatrickAction) {
        return EmojiParser.parseToAliases((String)str, (EmojiParser.FitzpatrickAction)fitzpatrickAction);
    }

    public static String toHtmlHex(String str) {
        return EmojiUtil.toHtml(str, true);
    }

    public static String toHtml(String str) {
        return EmojiUtil.toHtml(str, false);
    }

    public static String toHtml(String str, boolean isHex) {
        return isHex ? EmojiParser.parseToHtmlHexadecimal((String)str) : EmojiParser.parseToHtmlDecimal((String)str);
    }

    public static String removeAllEmojis(String str) {
        return EmojiParser.removeAllEmojis((String)str);
    }

    public static List<String> extractEmojis(String str) {
        return EmojiParser.extractEmojis((String)str);
    }
}


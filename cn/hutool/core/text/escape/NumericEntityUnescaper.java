/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.text.escape;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.text.replacer.StrReplacer;
import cn.hutool.core.util.CharUtil;

public class NumericEntityUnescaper
extends StrReplacer {
    private static final long serialVersionUID = 1L;

    @Override
    protected int replace(CharSequence str, int pos, StrBuilder out) {
        int len = str.length();
        if (str.charAt(pos) == '&' && pos < len - 2 && str.charAt(pos + 1) == '#') {
            boolean isSemiNext;
            int end;
            int start = pos + 2;
            boolean isHex = false;
            char firstChar = str.charAt(start);
            if (firstChar == 'x' || firstChar == 'X') {
                ++start;
                isHex = true;
            }
            if (start == len) {
                return 0;
            }
            for (end = start; end < len && CharUtil.isHexChar(str.charAt(end)); ++end) {
            }
            boolean bl = isSemiNext = end != len && str.charAt(end) == ';';
            if (isSemiNext) {
                int entityValue;
                try {
                    entityValue = isHex ? Integer.parseInt((String)str.subSequence(start, end).toString(), (int)16) : Integer.parseInt((String)str.subSequence(start, end).toString(), (int)10);
                }
                catch (NumberFormatException nfe) {
                    return 0;
                }
                out.append((char)entityValue);
                return 2 + end - start + (isHex ? 1 : 0) + 1;
            }
        }
        return 0;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 *  java.util.Set
 */
package cn.hutool.core.text.replacer;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.text.replacer.StrReplacer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LookupReplacer
extends StrReplacer {
    private static final long serialVersionUID = 1L;
    private final Map<String, String> lookupMap = new HashMap();
    private final Set<Character> prefixSet = new HashSet();
    private final int minLength;
    private final int maxLength;

    public LookupReplacer(String[] ... lookup) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;
        for (String[] pair : lookup) {
            String key = pair[0];
            this.lookupMap.put((Object)key, (Object)pair[1]);
            this.prefixSet.add((Object)Character.valueOf((char)key.charAt(0)));
            int keySize = key.length();
            if (keySize > maxLength) {
                maxLength = keySize;
            }
            if (keySize >= minLength) continue;
            minLength = keySize;
        }
        this.maxLength = maxLength;
        this.minLength = minLength;
    }

    @Override
    protected int replace(CharSequence str, int pos, StrBuilder out) {
        if (this.prefixSet.contains((Object)Character.valueOf((char)str.charAt(pos)))) {
            int max = this.maxLength;
            if (pos + this.maxLength > str.length()) {
                max = str.length() - pos;
            }
            for (int i = max; i >= this.minLength; --i) {
                CharSequence subSeq = str.subSequence(pos, pos + i);
                String result = (String)this.lookupMap.get((Object)subSeq.toString());
                if (null == result) continue;
                out.append(result);
                return i;
            }
        }
        return 0;
    }
}


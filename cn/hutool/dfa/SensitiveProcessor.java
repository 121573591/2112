/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package cn.hutool.dfa;

import cn.hutool.dfa.FoundWord;

public interface SensitiveProcessor {
    default public String process(FoundWord foundWord) {
        int length = foundWord.getFoundWord().length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            sb.append("*");
        }
        return sb.toString();
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Deprecated
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.HashSet
 */
package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

@Deprecated
public class LookupTranslator
extends CharSequenceTranslator {
    private final HashMap<String, String> lookupMap = new HashMap();
    private final HashSet<Character> prefixSet = new HashSet();
    private final int shortest;
    private final int longest;

    public LookupTranslator(CharSequence[] ... lookup) {
        int tmpShortest = Integer.MAX_VALUE;
        int tmpLongest = 0;
        if (lookup != null) {
            for (CharSequence[] seq : lookup) {
                this.lookupMap.put((Object)seq[0].toString(), (Object)seq[1].toString());
                this.prefixSet.add((Object)Character.valueOf((char)seq[0].charAt(0)));
                int sz = seq[0].length();
                if (sz < tmpShortest) {
                    tmpShortest = sz;
                }
                if (sz <= tmpLongest) continue;
                tmpLongest = sz;
            }
        }
        this.shortest = tmpShortest;
        this.longest = tmpLongest;
    }

    @Override
    public int translate(CharSequence input, int index, Writer out) throws IOException {
        if (this.prefixSet.contains((Object)Character.valueOf((char)input.charAt(index)))) {
            int max = this.longest;
            if (index + this.longest > input.length()) {
                max = input.length() - index;
            }
            for (int i = max; i >= this.shortest; --i) {
                CharSequence subSeq = input.subSequence(index, index + i);
                String result = (String)this.lookupMap.get((Object)subSeq.toString());
                if (result == null) continue;
                out.write(result);
                return i;
            }
        }
        return 0;
    }
}


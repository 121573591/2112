/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.HashMap
 *  java.util.Map
 */
package org.apache.commons.text.similarity;

import java.util.HashMap;
import java.util.Map;

final class Counter {
    public static Map<CharSequence, Integer> of(CharSequence[] tokens) {
        HashMap innerCounter = new HashMap();
        CharSequence[] charSequenceArray = tokens;
        int n = charSequenceArray.length;
        for (int i = 0; i < n; ++i) {
            CharSequence token;
            Integer integer = (Integer)innerCounter.get((Object)(token = charSequenceArray[i]));
            innerCounter.put((Object)token, (Object)(integer != null ? integer + 1 : 1));
        }
        return innerCounter;
    }

    private Counter() {
    }
}


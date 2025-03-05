/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.EnumSet
 */
package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.text.translate.CharSequenceTranslator;

public class NumericEntityUnescaper
extends CharSequenceTranslator {
    private static final EnumSet<OPTION> DEFAULT_OPTIONS = EnumSet.copyOf((Collection)Collections.singletonList((Object)((Object)OPTION.semiColonRequired)));
    private final EnumSet<OPTION> options;

    public NumericEntityUnescaper(OPTION ... options) {
        this.options = ArrayUtils.isEmpty((Object[])options) ? DEFAULT_OPTIONS : EnumSet.copyOf((Collection)Arrays.asList((Object[])options));
    }

    public boolean isSet(OPTION option) {
        return this.options.contains((Object)option);
    }

    @Override
    public int translate(CharSequence input, int index, Writer writer) throws IOException {
        int seqEnd = input.length();
        if (input.charAt(index) == '&' && index < seqEnd - 2 && input.charAt(index + 1) == '#') {
            int entityValue;
            boolean semiNext;
            int end;
            int start = index + 2;
            boolean isHex = false;
            char firstChar = input.charAt(start);
            if (firstChar == 'x' || firstChar == 'X') {
                isHex = true;
                if (++start == seqEnd) {
                    return 0;
                }
            }
            for (end = start; end < seqEnd && (input.charAt(end) >= '0' && input.charAt(end) <= '9' || input.charAt(end) >= 'a' && input.charAt(end) <= 'f' || input.charAt(end) >= 'A' && input.charAt(end) <= 'F'); ++end) {
            }
            boolean bl = semiNext = end != seqEnd && input.charAt(end) == ';';
            if (!semiNext) {
                if (this.isSet(OPTION.semiColonRequired)) {
                    return 0;
                }
                if (this.isSet(OPTION.errorIfNoSemiColon)) {
                    throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
                }
            }
            try {
                entityValue = isHex ? Integer.parseInt((String)input.subSequence(start, end).toString(), (int)16) : Integer.parseInt((String)input.subSequence(start, end).toString(), (int)10);
            }
            catch (NumberFormatException nfe) {
                return 0;
            }
            if (entityValue > 65535) {
                char[] chrs = Character.toChars((int)entityValue);
                writer.write((int)chrs[0]);
                writer.write((int)chrs[1]);
            } else {
                writer.write(entityValue);
            }
            return 2 + end - start + (isHex ? 1 : 0) + (semiNext ? 1 : 0);
        }
        return 0;
    }

    public static enum OPTION {
        semiColonRequired,
        semiColonOptional,
        errorIfNoSemiColon;

    }
}


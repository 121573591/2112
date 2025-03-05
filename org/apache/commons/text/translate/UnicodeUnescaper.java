/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import org.apache.commons.text.translate.CharSequenceTranslator;

public class UnicodeUnescaper
extends CharSequenceTranslator {
    @Override
    public int translate(CharSequence input, int index, Writer writer) throws IOException {
        if (input.charAt(index) == '\\' && index + 1 < input.length() && input.charAt(index + 1) == 'u') {
            int i = 2;
            while (index + i < input.length() && input.charAt(index + i) == 'u') {
                ++i;
            }
            if (index + i < input.length() && input.charAt(index + i) == '+') {
                ++i;
            }
            if (index + i + 4 <= input.length()) {
                CharSequence unicode = input.subSequence(index + i, index + i + 4);
                try {
                    int value = Integer.parseInt((String)unicode.toString(), (int)16);
                    writer.write((int)((char)value));
                }
                catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("Unable to parse unicode value: " + unicode, (Throwable)nfe);
                }
                return i + 4;
            }
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + input.subSequence(index, input.length()) + "' due to end of CharSequence");
        }
        return 0;
    }
}


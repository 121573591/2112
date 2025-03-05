/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.text.Format
 *  java.text.MessageFormat
 *  java.text.ParsePosition
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Locale$Category
 *  java.util.Map
 *  java.util.Objects
 */
package org.apache.commons.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.FormatFactory;
import org.apache.commons.text.matcher.StringMatcherFactory;

public class ExtendedMessageFormat
extends MessageFormat {
    private static final long serialVersionUID = -2362048321261811743L;
    private static final int HASH_SEED = 31;
    private static final String DUMMY_PATTERN = "";
    private static final char START_FMT = ',';
    private static final char END_FE = '}';
    private static final char START_FE = '{';
    private static final char QUOTE = '\'';
    private String toPattern;
    private final Map<String, ? extends FormatFactory> registry;

    public ExtendedMessageFormat(String pattern) {
        this(pattern, Locale.getDefault((Locale.Category)Locale.Category.FORMAT));
    }

    public ExtendedMessageFormat(String pattern, Locale locale) {
        this(pattern, locale, null);
    }

    public ExtendedMessageFormat(String pattern, Locale locale, Map<String, ? extends FormatFactory> registry) {
        super(DUMMY_PATTERN);
        this.setLocale(locale);
        this.registry = registry != null ? Collections.unmodifiableMap((Map)new HashMap(registry)) : null;
        this.applyPattern(pattern);
    }

    public ExtendedMessageFormat(String pattern, Map<String, ? extends FormatFactory> registry) {
        this(pattern, Locale.getDefault((Locale.Category)Locale.Category.FORMAT), registry);
    }

    private void appendQuotedString(String pattern, ParsePosition pos, StringBuilder appendTo) {
        assert (pattern.toCharArray()[pos.getIndex()] == '\'') : "Quoted string must start with quote character";
        if (appendTo != null) {
            appendTo.append('\'');
        }
        this.next(pos);
        int start = pos.getIndex();
        char[] c = pattern.toCharArray();
        for (int i = pos.getIndex(); i < pattern.length(); ++i) {
            switch (c[pos.getIndex()]) {
                case '\'': {
                    this.next(pos);
                    if (appendTo != null) {
                        appendTo.append(c, start, pos.getIndex() - start);
                    }
                    return;
                }
            }
            this.next(pos);
        }
        throw new IllegalArgumentException("Unterminated quoted string at position " + start);
    }

    public final void applyPattern(String pattern) {
        if (this.registry == null) {
            super.applyPattern(pattern);
            this.toPattern = super.toPattern();
            return;
        }
        ArrayList foundFormats = new ArrayList();
        ArrayList foundDescriptions = new ArrayList();
        StringBuilder stripCustom = new StringBuilder(pattern.length());
        ParsePosition pos = new ParsePosition(0);
        char[] c = pattern.toCharArray();
        int fmtCount = 0;
        block4: while (pos.getIndex() < pattern.length()) {
            switch (c[pos.getIndex()]) {
                case '\'': {
                    this.appendQuotedString(pattern, pos, stripCustom);
                    continue block4;
                }
                case '{': {
                    ++fmtCount;
                    this.seekNonWs(pattern, pos);
                    int start = pos.getIndex();
                    int index = this.readArgumentIndex(pattern, this.next(pos));
                    stripCustom.append('{').append(index);
                    this.seekNonWs(pattern, pos);
                    Format format = null;
                    String formatDescription = null;
                    if (c[pos.getIndex()] == ',' && (format = this.getFormat(formatDescription = this.parseFormatDescription(pattern, this.next(pos)))) == null) {
                        stripCustom.append(',').append(formatDescription);
                    }
                    foundFormats.add(format);
                    foundDescriptions.add((Object)(format == null ? null : formatDescription));
                    if (foundFormats.size() != fmtCount) {
                        throw new IllegalArgumentException("The validated expression is false");
                    }
                    if (foundDescriptions.size() != fmtCount) {
                        throw new IllegalArgumentException("The validated expression is false");
                    }
                    if (c[pos.getIndex()] == '}') break;
                    throw new IllegalArgumentException("Unreadable format element at position " + start);
                }
            }
            stripCustom.append(c[pos.getIndex()]);
            this.next(pos);
        }
        super.applyPattern(stripCustom.toString());
        this.toPattern = this.insertFormats(super.toPattern(), (ArrayList<String>)foundDescriptions);
        if (this.containsElements((Collection<?>)foundFormats)) {
            Format[] origFormats = this.getFormats();
            int i = 0;
            for (Format f : foundFormats) {
                if (f != null) {
                    origFormats[i] = f;
                }
                ++i;
            }
            super.setFormats(origFormats);
        }
    }

    private boolean containsElements(Collection<?> coll) {
        if (coll == null || coll.isEmpty()) {
            return false;
        }
        return coll.stream().anyMatch(Objects::nonNull);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!Objects.equals((Object)this.getClass(), (Object)obj.getClass())) {
            return false;
        }
        ExtendedMessageFormat rhs = (ExtendedMessageFormat)((Object)obj);
        if (!Objects.equals((Object)this.toPattern, (Object)rhs.toPattern)) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.registry, rhs.registry);
    }

    private Format getFormat(String desc) {
        if (this.registry != null) {
            FormatFactory factory2;
            String name = desc;
            String args = null;
            int i = desc.indexOf(44);
            if (i > 0) {
                name = desc.substring(0, i).trim();
                args = desc.substring(i + 1).trim();
            }
            if ((factory2 = (FormatFactory)this.registry.get((Object)name)) != null) {
                return factory2.getFormat(name, args, this.getLocale());
            }
        }
        return null;
    }

    private void getQuotedString(String pattern, ParsePosition pos) {
        this.appendQuotedString(pattern, pos, null);
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(this.registry);
        return 31 * result + Objects.hashCode((Object)this.toPattern);
    }

    private String insertFormats(String pattern, ArrayList<String> customPatterns) {
        if (!this.containsElements((Collection<?>)customPatterns)) {
            return pattern;
        }
        StringBuilder sb = new StringBuilder(pattern.length() * 2);
        ParsePosition pos = new ParsePosition(0);
        int fe = -1;
        int depth = 0;
        block5: while (pos.getIndex() < pattern.length()) {
            char c = pattern.charAt(pos.getIndex());
            switch (c) {
                case '\'': {
                    this.appendQuotedString(pattern, pos, sb);
                    break;
                }
                case '{': {
                    String customPattern;
                    sb.append('{').append(this.readArgumentIndex(pattern, this.next(pos)));
                    if (++depth != 1 || (customPattern = (String)customPatterns.get(++fe)) == null) continue block5;
                    sb.append(',').append(customPattern);
                    break;
                }
                case '}': {
                    --depth;
                }
                default: {
                    sb.append(c);
                    this.next(pos);
                }
            }
        }
        return sb.toString();
    }

    private ParsePosition next(ParsePosition pos) {
        pos.setIndex(pos.getIndex() + 1);
        return pos;
    }

    private String parseFormatDescription(String pattern, ParsePosition pos) {
        int start = pos.getIndex();
        this.seekNonWs(pattern, pos);
        int text = pos.getIndex();
        int depth = 1;
        block5: while (pos.getIndex() < pattern.length()) {
            switch (pattern.charAt(pos.getIndex())) {
                case '{': {
                    ++depth;
                    this.next(pos);
                    continue block5;
                }
                case '}': {
                    if (--depth == 0) {
                        return pattern.substring(text, pos.getIndex());
                    }
                    this.next(pos);
                    continue block5;
                }
                case '\'': {
                    this.getQuotedString(pattern, pos);
                    continue block5;
                }
            }
            this.next(pos);
        }
        throw new IllegalArgumentException("Unterminated format element at position " + start);
    }

    /*
     * Unable to fully structure code
     */
    private int readArgumentIndex(String pattern, ParsePosition pos) {
        start = pos.getIndex();
        this.seekNonWs(pattern, pos);
        result = new StringBuilder();
        error = false;
        while (!error && pos.getIndex() < pattern.length()) {
            c = pattern.charAt(pos.getIndex());
            if (!Character.isWhitespace((char)c)) ** GOTO lbl-1000
            this.seekNonWs(pattern, pos);
            c = pattern.charAt(pos.getIndex());
            if (c != ',' && c != '}') {
                error = true;
            } else lbl-1000:
            // 2 sources

            {
                if ((c == ',' || c == '}') && result.length() > 0) {
                    try {
                        return Integer.parseInt((String)result.toString());
                    }
                    catch (NumberFormatException var7_7) {
                        // empty catch block
                    }
                }
                error = Character.isDigit((char)c) == false;
                result.append(c);
            }
            this.next(pos);
        }
        if (error) {
            throw new IllegalArgumentException("Invalid format argument index at position " + start + ": " + pattern.substring(start, pos.getIndex()));
        }
        throw new IllegalArgumentException("Unterminated format element at position " + start);
    }

    private void seekNonWs(String pattern, ParsePosition pos) {
        int len = 0;
        char[] buffer = pattern.toCharArray();
        do {
            len = StringMatcherFactory.INSTANCE.splitMatcher().isMatch(buffer, pos.getIndex(), 0, buffer.length);
            pos.setIndex(pos.getIndex() + len);
        } while (len > 0 && pos.getIndex() < pattern.length());
    }

    public void setFormat(int formatElementIndex, Format newFormat) {
        throw new UnsupportedOperationException();
    }

    public void setFormatByArgumentIndex(int argumentIndex, Format newFormat) {
        throw new UnsupportedOperationException();
    }

    public void setFormats(Format[] newFormats) {
        throw new UnsupportedOperationException();
    }

    public void setFormatsByArgumentIndex(Format[] newFormats) {
        throw new UnsupportedOperationException();
    }

    public String toPattern() {
        return this.toPattern;
    }
}


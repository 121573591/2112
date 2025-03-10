/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.StackOverflowError
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.regex.Pattern
 *  java.util.regex.PatternSyntaxException
 */
package org.openjdk.nashorn.internal.runtime.regexp;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.openjdk.nashorn.internal.runtime.ParserException;
import org.openjdk.nashorn.internal.runtime.regexp.RegExp;
import org.openjdk.nashorn.internal.runtime.regexp.RegExpFactory;
import org.openjdk.nashorn.internal.runtime.regexp.RegExpMatcher;
import org.openjdk.nashorn.internal.runtime.regexp.RegExpScanner;
import org.openjdk.nashorn.internal.runtime.regexp.joni.Matcher;
import org.openjdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.openjdk.nashorn.internal.runtime.regexp.joni.Region;
import org.openjdk.nashorn.internal.runtime.regexp.joni.Syntax;
import org.openjdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

public class JoniRegExp
extends RegExp {
    private Regex regex;

    public JoniRegExp(String pattern, String flags) throws ParserException {
        super(pattern, flags);
        int option = 8;
        if (this.isIgnoreCase()) {
            option |= 1;
        }
        if (this.isMultiline()) {
            option &= 0xFFFFFFF7;
            option |= 0x40;
        }
        try {
            RegExpScanner parsed;
            try {
                parsed = RegExpScanner.scan(pattern);
            }
            catch (PatternSyntaxException e) {
                Pattern.compile((String)pattern, (int)0);
                throw e;
            }
            if (parsed != null) {
                char[] javaPattern = parsed.getJavaPattern().toCharArray();
                this.regex = new Regex(javaPattern, 0, javaPattern.length, option, Syntax.JAVASCRIPT);
                this.groupsInNegativeLookahead = parsed.getGroupsInNegativeLookahead();
            }
        }
        catch (PatternSyntaxException | JOniException e2) {
            JoniRegExp.throwParserException("syntax", e2.getMessage());
        }
        catch (StackOverflowError e3) {
            throw new RuntimeException((Throwable)e3);
        }
    }

    @Override
    public RegExpMatcher match(String input) {
        if (this.regex == null) {
            return null;
        }
        return new JoniMatcher(input);
    }

    class JoniMatcher
    implements RegExpMatcher {
        final String input;
        final Matcher joniMatcher;

        JoniMatcher(String input) {
            this.input = input;
            this.joniMatcher = JoniRegExp.this.regex.matcher(input.toCharArray());
        }

        @Override
        public boolean search(int start) {
            return this.joniMatcher.search(start, this.input.length(), 0) > -1;
        }

        @Override
        public String getInput() {
            return this.input;
        }

        public int start() {
            return this.joniMatcher.getBegin();
        }

        public int start(int group) {
            return group == 0 ? this.start() : this.joniMatcher.getRegion().beg[group];
        }

        public int end() {
            return this.joniMatcher.getEnd();
        }

        public int end(int group) {
            return group == 0 ? this.end() : this.joniMatcher.getRegion().end[group];
        }

        public String group() {
            return this.input.substring(this.joniMatcher.getBegin(), this.joniMatcher.getEnd());
        }

        public String group(int group) {
            if (group == 0) {
                return this.group();
            }
            Region region = this.joniMatcher.getRegion();
            return this.input.substring(region.beg[group], region.end[group]);
        }

        public int groupCount() {
            Region region = this.joniMatcher.getRegion();
            return region == null ? 0 : region.numRegs - 1;
        }
    }

    public static class Factory
    extends RegExpFactory {
        @Override
        public RegExp compile(String pattern, String flags) throws ParserException {
            return new JoniRegExp(pattern, flags);
        }
    }
}


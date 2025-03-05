/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.text.FieldPosition
 *  java.text.Format
 *  java.text.ParseException
 *  java.text.ParsePosition
 */
package org.apache.commons.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;

public class CompositeFormat
extends Format {
    private static final long serialVersionUID = -4329119827877627683L;
    private final Format parser;
    private final Format formatter;

    public CompositeFormat(Format parser, Format formatter) {
        this.parser = parser;
        this.formatter = formatter;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        return this.formatter.format(obj, toAppendTo, pos);
    }

    public Format getFormatter() {
        return this.formatter;
    }

    public Format getParser() {
        return this.parser;
    }

    public Object parseObject(String source2, ParsePosition pos) {
        return this.parser.parseObject(source2, pos);
    }

    public String reformat(String input) throws ParseException {
        return this.format(this.parseObject(input));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package org.apache.commons.text;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.CsvTranslators;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.JavaUnicodeEscaper;
import org.apache.commons.text.translate.LookupTranslator;
import org.apache.commons.text.translate.NumericEntityEscaper;
import org.apache.commons.text.translate.NumericEntityUnescaper;
import org.apache.commons.text.translate.OctalUnescaper;
import org.apache.commons.text.translate.UnicodeUnescaper;
import org.apache.commons.text.translate.UnicodeUnpairedSurrogateRemover;

public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_JAVA;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator ESCAPE_JSON;
    public static final CharSequenceTranslator ESCAPE_XML10;
    public static final CharSequenceTranslator ESCAPE_XML11;
    public static final CharSequenceTranslator ESCAPE_HTML3;
    public static final CharSequenceTranslator ESCAPE_HTML4;
    public static final CharSequenceTranslator ESCAPE_CSV;
    public static final CharSequenceTranslator ESCAPE_XSI;
    public static final CharSequenceTranslator UNESCAPE_JAVA;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator UNESCAPE_JSON;
    public static final CharSequenceTranslator UNESCAPE_HTML3;
    public static final CharSequenceTranslator UNESCAPE_HTML4;
    public static final CharSequenceTranslator UNESCAPE_XML;
    public static final CharSequenceTranslator UNESCAPE_CSV;
    public static final CharSequenceTranslator UNESCAPE_XSI;

    public static Builder builder(CharSequenceTranslator translator) {
        return new Builder(translator);
    }

    public static final String escapeCsv(String input) {
        return ESCAPE_CSV.translate(input);
    }

    public static final String escapeEcmaScript(String input) {
        return ESCAPE_ECMASCRIPT.translate(input);
    }

    public static final String escapeHtml3(String input) {
        return ESCAPE_HTML3.translate(input);
    }

    public static final String escapeHtml4(String input) {
        return ESCAPE_HTML4.translate(input);
    }

    public static final String escapeJava(String input) {
        return ESCAPE_JAVA.translate(input);
    }

    public static final String escapeJson(String input) {
        return ESCAPE_JSON.translate(input);
    }

    public static String escapeXml10(String input) {
        return ESCAPE_XML10.translate(input);
    }

    public static String escapeXml11(String input) {
        return ESCAPE_XML11.translate(input);
    }

    public static final String escapeXSI(String input) {
        return ESCAPE_XSI.translate(input);
    }

    public static final String unescapeCsv(String input) {
        return UNESCAPE_CSV.translate(input);
    }

    public static final String unescapeEcmaScript(String input) {
        return UNESCAPE_ECMASCRIPT.translate(input);
    }

    public static final String unescapeHtml3(String input) {
        return UNESCAPE_HTML3.translate(input);
    }

    public static final String unescapeHtml4(String input) {
        return UNESCAPE_HTML4.translate(input);
    }

    public static final String unescapeJava(String input) {
        return UNESCAPE_JAVA.translate(input);
    }

    public static final String unescapeJson(String input) {
        return UNESCAPE_JSON.translate(input);
    }

    public static final String unescapeXml(String input) {
        return UNESCAPE_XML.translate(input);
    }

    public static final String unescapeXSI(String input) {
        return UNESCAPE_XSI.translate(input);
    }

    static {
        HashMap escapeJavaMap = new HashMap();
        escapeJavaMap.put((Object)"\"", (Object)"\\\"");
        escapeJavaMap.put((Object)"\\", (Object)"\\\\");
        ESCAPE_JAVA = new AggregateTranslator(new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)escapeJavaMap)), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap escapeEcmaScriptMap = new HashMap();
        escapeEcmaScriptMap.put((Object)"'", (Object)"\\'");
        escapeEcmaScriptMap.put((Object)"\"", (Object)"\\\"");
        escapeEcmaScriptMap.put((Object)"\\", (Object)"\\\\");
        escapeEcmaScriptMap.put((Object)"/", (Object)"\\/");
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)escapeEcmaScriptMap)), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap escapeJsonMap = new HashMap();
        escapeJsonMap.put((Object)"\"", (Object)"\\\"");
        escapeJsonMap.put((Object)"\\", (Object)"\\\\");
        escapeJsonMap.put((Object)"/", (Object)"\\/");
        ESCAPE_JSON = new AggregateTranslator(new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)escapeJsonMap)), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE), JavaUnicodeEscaper.outsideOf(32, 126));
        HashMap escapeXml10Map = new HashMap();
        escapeXml10Map.put((Object)" ", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"\b", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"\f", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"", (Object)"");
        escapeXml10Map.put((Object)"￾", (Object)"");
        escapeXml10Map.put((Object)"￿", (Object)"");
        ESCAPE_XML10 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE), new LookupTranslator(EntityArrays.APOS_ESCAPE), new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)escapeXml10Map)), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        HashMap escapeXml11Map = new HashMap();
        escapeXml11Map.put((Object)" ", (Object)"");
        escapeXml11Map.put((Object)"", (Object)"&#11;");
        escapeXml11Map.put((Object)"\f", (Object)"&#12;");
        escapeXml11Map.put((Object)"￾", (Object)"");
        escapeXml11Map.put((Object)"￿", (Object)"");
        ESCAPE_XML11 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE), new LookupTranslator(EntityArrays.APOS_ESCAPE), new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)escapeXml11Map)), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        ESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE));
        ESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE), new LookupTranslator(EntityArrays.ISO8859_1_ESCAPE), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE));
        ESCAPE_CSV = new CsvTranslators.CsvEscaper();
        HashMap escapeXsiMap = new HashMap();
        escapeXsiMap.put((Object)"|", (Object)"\\|");
        escapeXsiMap.put((Object)"&", (Object)"\\&");
        escapeXsiMap.put((Object)";", (Object)"\\;");
        escapeXsiMap.put((Object)"<", (Object)"\\<");
        escapeXsiMap.put((Object)">", (Object)"\\>");
        escapeXsiMap.put((Object)"(", (Object)"\\(");
        escapeXsiMap.put((Object)")", (Object)"\\)");
        escapeXsiMap.put((Object)"$", (Object)"\\$");
        escapeXsiMap.put((Object)"`", (Object)"\\`");
        escapeXsiMap.put((Object)"\\", (Object)"\\\\");
        escapeXsiMap.put((Object)"\"", (Object)"\\\"");
        escapeXsiMap.put((Object)"'", (Object)"\\'");
        escapeXsiMap.put((Object)" ", (Object)"\\ ");
        escapeXsiMap.put((Object)"\t", (Object)"\\\t");
        escapeXsiMap.put((Object)"\r\n", (Object)"");
        escapeXsiMap.put((Object)"\n", (Object)"");
        escapeXsiMap.put((Object)"*", (Object)"\\*");
        escapeXsiMap.put((Object)"?", (Object)"\\?");
        escapeXsiMap.put((Object)"[", (Object)"\\[");
        escapeXsiMap.put((Object)"#", (Object)"\\#");
        escapeXsiMap.put((Object)"~", (Object)"\\~");
        escapeXsiMap.put((Object)"=", (Object)"\\=");
        escapeXsiMap.put((Object)"%", (Object)"\\%");
        ESCAPE_XSI = new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)escapeXsiMap));
        HashMap unescapeJavaMap = new HashMap();
        unescapeJavaMap.put((Object)"\\\\", (Object)"\\");
        unescapeJavaMap.put((Object)"\\\"", (Object)"\"");
        unescapeJavaMap.put((Object)"\\'", (Object)"'");
        unescapeJavaMap.put((Object)"\\", (Object)"");
        UNESCAPE_ECMASCRIPT = UNESCAPE_JAVA = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE), new LookupTranslator((Map<CharSequence, CharSequence>)Collections.unmodifiableMap((Map)unescapeJavaMap)));
        UNESCAPE_JSON = UNESCAPE_JAVA;
        UNESCAPE_HTML3 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE), new LookupTranslator(EntityArrays.ISO8859_1_UNESCAPE), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_XML = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE), new LookupTranslator(EntityArrays.APOS_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_CSV = new CsvTranslators.CsvUnescaper();
        UNESCAPE_XSI = new XsiUnescaper();
    }

    public static final class Builder {
        private final StringBuilder sb = new StringBuilder();
        private final CharSequenceTranslator translator;

        private Builder(CharSequenceTranslator translator) {
            this.translator = translator;
        }

        public Builder append(String input) {
            this.sb.append(input);
            return this;
        }

        public Builder escape(String input) {
            this.sb.append(this.translator.translate(input));
            return this;
        }

        public String toString() {
            return this.sb.toString();
        }
    }

    static class XsiUnescaper
    extends CharSequenceTranslator {
        private static final char BACKSLASH = '\\';

        XsiUnescaper() {
        }

        @Override
        public int translate(CharSequence input, int index, Writer writer) throws IOException {
            if (index != 0) {
                throw new IllegalStateException("XsiUnescaper should never reach the [1] index");
            }
            String s = input.toString();
            int segmentStart = 0;
            int searchOffset = 0;
            while (true) {
                int pos;
                if ((pos = s.indexOf(92, searchOffset)) == -1) {
                    if (segmentStart >= s.length()) break;
                    writer.write(s.substring(segmentStart));
                    break;
                }
                if (pos > segmentStart) {
                    writer.write(s.substring(segmentStart, pos));
                }
                segmentStart = pos + 1;
                searchOffset = pos + 2;
            }
            return Character.codePointCount((CharSequence)input, (int)0, (int)input.length());
        }
    }
}


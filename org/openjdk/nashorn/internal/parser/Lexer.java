/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Character
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package org.openjdk.nashorn.internal.parser;

import java.io.Serializable;
import org.openjdk.nashorn.internal.parser.Scanner;
import org.openjdk.nashorn.internal.parser.Token;
import org.openjdk.nashorn.internal.parser.TokenLookup;
import org.openjdk.nashorn.internal.parser.TokenStream;
import org.openjdk.nashorn.internal.parser.TokenType;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.ErrorManager;
import org.openjdk.nashorn.internal.runtime.JSErrorType;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.ParserException;
import org.openjdk.nashorn.internal.runtime.Source;
import org.openjdk.nashorn.internal.runtime.options.Options;

public class Lexer
extends Scanner {
    private static final boolean XML_LITERALS = Options.getBooleanProperty("nashorn.lexer.xmlliterals");
    private final Source source;
    private final TokenStream stream;
    private final boolean scripting;
    private final boolean es6;
    private final boolean nested;
    int pendingLine;
    private int linePosition;
    private TokenType last;
    private final boolean pauseOnFunctionBody;
    private boolean pauseOnNextLeftBrace;
    private int templateExpressionOpenBraces;
    private static final String JAVASCRIPT_OTHER_WHITESPACE = "    ᠎             　﻿";
    private static final String JAVASCRIPT_WHITESPACE_IN_REGEXP = "\\u000a\\u000d\\u2028\\u2029\\u0009\\u0020\\u000b\\u000c\\u00a0\\u1680\\u180e\\u2000\\u2001\\u2002\\u2003\\u2004\\u2005\\u2006\\u2007\\u2008\\u2009\\u200a\\u202f\\u205f\\u3000\\ufeff";

    static String unicodeEscape(char ch) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\u");
        String hex = Integer.toHexString((int)ch);
        for (int i = hex.length(); i < 4; ++i) {
            sb.append('0');
        }
        sb.append(hex);
        return sb.toString();
    }

    public Lexer(Source source2, TokenStream stream) {
        this(source2, stream, false, false);
    }

    public Lexer(Source source2, TokenStream stream, boolean scripting, boolean es6) {
        this(source2, 0, source2.getLength(), stream, scripting, es6, false);
    }

    public Lexer(Source source2, int start, int len, TokenStream stream, boolean scripting, boolean es6, boolean pauseOnFunctionBody) {
        super(source2.getContent(), 1, start, len);
        this.source = source2;
        this.stream = stream;
        this.scripting = scripting;
        this.es6 = es6;
        this.nested = false;
        this.pendingLine = 1;
        this.last = TokenType.EOL;
        this.pauseOnFunctionBody = pauseOnFunctionBody;
    }

    private Lexer(Lexer lexer, State state) {
        super(lexer, state);
        this.source = lexer.source;
        this.stream = lexer.stream;
        this.scripting = lexer.scripting;
        this.es6 = lexer.es6;
        this.nested = true;
        this.pendingLine = state.pendingLine;
        this.linePosition = state.linePosition;
        this.last = TokenType.EOL;
        this.pauseOnFunctionBody = false;
    }

    @Override
    State saveState() {
        return new State(this.position, this.limit, this.line, this.pendingLine, this.linePosition, this.last);
    }

    void restoreState(State state) {
        super.restoreState(state);
        this.pendingLine = state.pendingLine;
        this.linePosition = state.linePosition;
        this.last = state.last;
    }

    protected void add(TokenType type, int start, int end) {
        this.last = type;
        if (type == TokenType.EOL) {
            this.pendingLine = end;
            this.linePosition = start;
        } else {
            if (this.pendingLine != -1) {
                this.stream.put(Token.toDesc(TokenType.EOL, this.linePosition, this.pendingLine));
                this.pendingLine = -1;
            }
            this.stream.put(Token.toDesc(type, start, end - start));
        }
    }

    protected void add(TokenType type, int start) {
        this.add(type, start, this.position);
    }

    public static String getWhitespaceRegExp() {
        return JAVASCRIPT_WHITESPACE_IN_REGEXP;
    }

    private void skipEOL(boolean addEOL) {
        if (this.ch0 == '\r') {
            this.skip(1);
            if (this.ch0 == '\n') {
                this.skip(1);
            }
        } else {
            this.skip(1);
        }
        ++this.line;
        if (addEOL) {
            this.add(TokenType.EOL, this.position, this.line);
        }
    }

    private void skipLine(boolean addEOL) {
        while (!this.isEOL(this.ch0) && !this.atEOF()) {
            this.skip(1);
        }
        this.skipEOL(addEOL);
    }

    public static boolean isJSWhitespace(char ch) {
        return ch == ' ' || ch >= '\t' && ch <= '\r' || ch >= ' ' && Lexer.isOtherJSWhitespace(ch);
    }

    private static boolean isOtherJSWhitespace(char ch) {
        return JAVASCRIPT_OTHER_WHITESPACE.indexOf((int)ch) != -1;
    }

    public static boolean isJSEOL(char ch) {
        return ch == '\n' || ch == '\r' || ch == '\u2028' || ch == '\u2029';
    }

    protected boolean isStringDelimiter(char ch) {
        return ch == '\'' || ch == '\"';
    }

    private static boolean isTemplateDelimiter(char ch) {
        return ch == '`';
    }

    protected boolean isWhitespace(char ch) {
        return Lexer.isJSWhitespace(ch);
    }

    protected boolean isEOL(char ch) {
        return Lexer.isJSEOL(ch);
    }

    private void skipWhitespace(boolean addEOL) {
        while (this.isWhitespace(this.ch0)) {
            if (this.isEOL(this.ch0)) {
                this.skipEOL(addEOL);
                continue;
            }
            this.skip(1);
        }
    }

    protected boolean skipComments() {
        int start = this.position;
        if (this.ch0 == '/') {
            if (this.ch1 == '/') {
                this.skip(2);
                boolean directiveComment = false;
                if ((this.ch0 == '#' || this.ch0 == '@') && this.ch1 == ' ') {
                    directiveComment = true;
                }
                while (!this.atEOF() && !this.isEOL(this.ch0)) {
                    this.skip(1);
                }
                this.add(directiveComment ? TokenType.DIRECTIVE_COMMENT : TokenType.COMMENT, start);
                return true;
            }
            if (this.ch1 == '*') {
                this.skip(2);
                while (!(this.atEOF() || this.ch0 == '*' && this.ch1 == '/')) {
                    if (this.isEOL(this.ch0)) {
                        this.skipEOL(true);
                        continue;
                    }
                    this.skip(1);
                }
                if (this.atEOF()) {
                    this.add(TokenType.ERROR, start);
                } else {
                    this.skip(2);
                }
                this.add(TokenType.COMMENT, start);
                return true;
            }
        } else if (this.ch0 == '#') {
            assert (this.scripting);
            this.skip(1);
            while (!this.atEOF() && !this.isEOL(this.ch0)) {
                this.skip(1);
            }
            this.add(TokenType.COMMENT, start);
            return true;
        }
        return false;
    }

    public RegexToken valueOfPattern(int start, int length) {
        int savePosition = this.position;
        this.reset(start);
        StringBuilder sb = new StringBuilder(length);
        this.skip(1);
        boolean inBrackets = false;
        while (!this.atEOF() && this.ch0 != '/' && !this.isEOL(this.ch0) || inBrackets) {
            if (this.ch0 == '\\') {
                sb.append(this.ch0);
                sb.append(this.ch1);
                this.skip(2);
                continue;
            }
            if (this.ch0 == '[') {
                inBrackets = true;
            } else if (this.ch0 == ']') {
                inBrackets = false;
            }
            sb.append(this.ch0);
            this.skip(1);
        }
        String regex = sb.toString();
        this.skip(1);
        String options = this.source.getString(this.position, this.scanIdentifier());
        this.reset(savePosition);
        return new RegexToken(regex, options);
    }

    public boolean canStartLiteral(TokenType token) {
        return token.startsWith('/') || (this.scripting || XML_LITERALS) && token.startsWith('<');
    }

    protected boolean scanLiteral(long token, TokenType startTokenType, LineInfoReceiver lir) {
        if (!this.canStartLiteral(startTokenType)) {
            return false;
        }
        if (this.stream.get(this.stream.last()) != token) {
            return false;
        }
        State state = this.saveState();
        this.reset(Token.descPosition(token));
        if (this.ch0 == '/') {
            return this.scanRegEx();
        }
        if (this.ch0 == '<') {
            if (this.ch1 == '<') {
                return this.scanHereString(lir, state);
            }
            if (Character.isJavaIdentifierStart((char)this.ch1)) {
                return this.scanXMLLiteral();
            }
        }
        return false;
    }

    private boolean scanRegEx() {
        assert (this.ch0 == '/');
        if (this.ch1 != '/' && this.ch1 != '*') {
            int start = this.position;
            this.skip(1);
            boolean inBrackets = false;
            while (!(this.atEOF() || this.ch0 == '/' && !inBrackets || this.isEOL(this.ch0))) {
                if (this.ch0 == '\\') {
                    this.skip(1);
                    if (this.isEOL(this.ch0)) {
                        this.reset(start);
                        return false;
                    }
                } else if (this.ch0 == '[') {
                    inBrackets = true;
                } else if (this.ch0 == ']') {
                    inBrackets = false;
                }
                this.skip(1);
            }
            if (this.ch0 == '/') {
                this.skip(1);
                while (!this.atEOF() && Character.isJavaIdentifierPart((char)this.ch0) || this.ch0 == '\\' && this.ch1 == 'u') {
                    this.skip(1);
                }
                this.add(TokenType.REGEX, start);
                return true;
            }
            this.reset(start);
        }
        return false;
    }

    protected static int convertDigit(char ch, int base) {
        int digit;
        if ('0' <= ch && ch <= '9') {
            digit = ch - 48;
        } else if ('A' <= ch && ch <= 'Z') {
            digit = ch - 65 + 10;
        } else if ('a' <= ch && ch <= 'z') {
            digit = ch - 97 + 10;
        } else {
            return -1;
        }
        return digit < base ? digit : -1;
    }

    private int hexSequence(int length, TokenType type) {
        int value = 0;
        for (int i = 0; i < length; ++i) {
            int digit = Lexer.convertDigit(this.ch0, 16);
            if (digit == -1) {
                this.error(Lexer.message("invalid.hex", new String[0]), type, this.position, this.limit);
                return i == 0 ? -1 : value;
            }
            value = digit | value << 4;
            this.skip(1);
        }
        return value;
    }

    private int octalSequence() {
        int digit;
        int value = 0;
        for (int i = 0; i < 3 && (digit = Lexer.convertDigit(this.ch0, 8)) != -1; ++i) {
            value = digit | value << 3;
            this.skip(1);
            if (i == 1 && value >= 32) break;
        }
        return value;
    }

    private String valueOfIdent(int start, int length) throws RuntimeException {
        int savePosition = this.position;
        int end = start + length;
        this.reset(start);
        StringBuilder sb = new StringBuilder(length);
        while (!this.atEOF() && this.position < end && !this.isEOL(this.ch0)) {
            if (this.ch0 == '\\' && this.ch1 == 'u') {
                this.skip(2);
                int ch = this.hexSequence(4, TokenType.IDENT);
                assert (!this.isWhitespace((char)ch));
                assert (ch >= 0);
                sb.append((char)ch);
                continue;
            }
            sb.append(this.ch0);
            this.skip(1);
        }
        this.reset(savePosition);
        return sb.toString();
    }

    private void scanIdentifierOrKeyword() {
        int start = this.position;
        int length = this.scanIdentifier();
        TokenType type = TokenLookup.lookupKeyword(this.content, start, length);
        if (type == TokenType.FUNCTION && this.pauseOnFunctionBody) {
            this.pauseOnNextLeftBrace = true;
        }
        this.add(type, start);
    }

    private String valueOfString(int start, int length, boolean strict) throws RuntimeException {
        int savePosition = this.position;
        int end = start + length;
        this.reset(start);
        StringBuilder sb = new StringBuilder(length);
        while (this.position < end) {
            if (this.ch0 == '\\') {
                this.skip(1);
                char next = this.ch0;
                int afterSlash = this.position;
                this.skip(1);
                switch (next) {
                    case '0': 
                    case '1': 
                    case '2': 
                    case '3': 
                    case '4': 
                    case '5': 
                    case '6': 
                    case '7': {
                        if (strict && (next != '0' || this.ch0 >= '0' && this.ch0 <= '9')) {
                            this.error(Lexer.message("strict.no.octal", new String[0]), TokenType.STRING, this.position, this.limit);
                        }
                        this.reset(afterSlash);
                        int ch = this.octalSequence();
                        if (ch < 0) {
                            sb.append('\\');
                            sb.append('x');
                            break;
                        }
                        sb.append((char)ch);
                        break;
                    }
                    case 'n': {
                        sb.append('\n');
                        break;
                    }
                    case 't': {
                        sb.append('\t');
                        break;
                    }
                    case 'b': {
                        sb.append('\b');
                        break;
                    }
                    case 'f': {
                        sb.append('\f');
                        break;
                    }
                    case 'r': {
                        sb.append('\r');
                        break;
                    }
                    case '\'': {
                        sb.append('\'');
                        break;
                    }
                    case '\"': {
                        sb.append('\"');
                        break;
                    }
                    case '\\': {
                        sb.append('\\');
                        break;
                    }
                    case '\r': {
                        if (this.ch0 == '\n') {
                            this.skip(1);
                        }
                    }
                    case '\n': 
                    case '\u2028': 
                    case '\u2029': {
                        break;
                    }
                    case 'x': {
                        int ch = this.hexSequence(2, TokenType.STRING);
                        if (ch < 0) {
                            sb.append('\\');
                            sb.append('x');
                            break;
                        }
                        sb.append((char)ch);
                        break;
                    }
                    case 'u': {
                        int ch = this.hexSequence(4, TokenType.STRING);
                        if (ch < 0) {
                            sb.append('\\');
                            sb.append('u');
                            break;
                        }
                        sb.append((char)ch);
                        break;
                    }
                    case 'v': {
                        sb.append('\u000b');
                        break;
                    }
                    default: {
                        sb.append(next);
                    }
                }
                continue;
            }
            if (this.ch0 == '\r') {
                sb.append('\n');
                this.skip(this.ch1 == '\n' ? 2 : 1);
                continue;
            }
            sb.append(this.ch0);
            this.skip(1);
        }
        this.reset(savePosition);
        return sb.toString();
    }

    protected void scanString(boolean add) {
        TokenType type = TokenType.STRING;
        char quote = this.ch0;
        this.skip(1);
        State stringState = this.saveState();
        while (!this.atEOF() && this.ch0 != quote && !this.isEOL(this.ch0)) {
            if (this.ch0 == '\\') {
                type = TokenType.ESCSTRING;
                this.skip(1);
                if (this.isEOL(this.ch0)) {
                    this.skipEOL(false);
                    continue;
                }
            }
            this.skip(1);
        }
        if (this.ch0 == quote) {
            this.skip(1);
        } else {
            this.error(Lexer.message("missing.close.quote", new String[0]), TokenType.STRING, this.position, this.limit);
        }
        if (add) {
            stringState.setLimit(this.position - 1);
            if (this.scripting && !stringState.isEmpty()) {
                switch (quote) {
                    case '`': {
                        this.add(TokenType.EXECSTRING, stringState.position, stringState.limit);
                        this.add(TokenType.LBRACE, stringState.position, stringState.position);
                        this.editString(type, stringState);
                        this.add(TokenType.RBRACE, stringState.limit, stringState.limit);
                        break;
                    }
                    case '\"': {
                        this.editString(type, stringState);
                        break;
                    }
                    case '\'': {
                        this.add(type, stringState.position, stringState.limit);
                        break;
                    }
                }
            } else {
                this.add(type, stringState.position, stringState.limit);
            }
        }
    }

    private void scanTemplate() {
        assert (this.ch0 == '`');
        TokenType type = TokenType.TEMPLATE;
        this.skip(1);
        State stringState = this.saveState();
        while (!this.atEOF()) {
            if (this.ch0 == '`') {
                this.skip(1);
                stringState.setLimit(this.position - 1);
                this.add(type == TokenType.TEMPLATE ? type : TokenType.TEMPLATE_TAIL, stringState.position, stringState.limit);
                return;
            }
            if (this.ch0 == '$' && this.ch1 == '{') {
                this.skip(2);
                stringState.setLimit(this.position - 2);
                this.add(type == TokenType.TEMPLATE ? TokenType.TEMPLATE_HEAD : type, stringState.position, stringState.limit);
                Lexer expressionLexer = new Lexer(this, this.saveState());
                expressionLexer.templateExpressionOpenBraces = 1;
                expressionLexer.lexify();
                this.restoreState(expressionLexer.saveState());
                assert (this.ch0 == '}');
                type = TokenType.TEMPLATE_MIDDLE;
                this.skip(1);
                stringState = this.saveState();
                continue;
            }
            if (this.ch0 == '\\') {
                this.skip(1);
                if (this.isEOL(this.ch0)) {
                    this.skipEOL(false);
                    continue;
                }
            } else if (this.isEOL(this.ch0)) {
                this.skipEOL(false);
                continue;
            }
            this.skip(1);
        }
        this.error(Lexer.message("missing.close.quote", new String[0]), TokenType.TEMPLATE, this.position, this.limit);
    }

    private static Number valueOf(String valueString, int radix) throws NumberFormatException {
        try {
            return Integer.parseInt((String)valueString, (int)radix);
        }
        catch (NumberFormatException e) {
            if (radix == 10) {
                return Double.valueOf((String)valueString);
            }
            double value = 0.0;
            for (int i = 0; i < valueString.length(); ++i) {
                char ch = valueString.charAt(i);
                int digit = Lexer.convertDigit(ch, radix);
                value *= (double)radix;
                value += (double)digit;
            }
            return value;
        }
    }

    protected void scanNumber() {
        int start = this.position;
        TokenType type = TokenType.DECIMAL;
        int digit = Lexer.convertDigit(this.ch0, 10);
        if (digit == 0 && (this.ch1 == 'x' || this.ch1 == 'X') && Lexer.convertDigit(this.ch2, 16) != -1) {
            this.skip(3);
            while (Lexer.convertDigit(this.ch0, 16) != -1) {
                this.skip(1);
            }
            type = TokenType.HEXADECIMAL;
        } else if (digit == 0 && this.es6 && (this.ch1 == 'o' || this.ch1 == 'O') && Lexer.convertDigit(this.ch2, 8) != -1) {
            this.skip(3);
            while (Lexer.convertDigit(this.ch0, 8) != -1) {
                this.skip(1);
            }
            type = TokenType.OCTAL;
        } else if (digit == 0 && this.es6 && (this.ch1 == 'b' || this.ch1 == 'B') && Lexer.convertDigit(this.ch2, 2) != -1) {
            this.skip(3);
            while (Lexer.convertDigit(this.ch0, 2) != -1) {
                this.skip(1);
            }
            type = TokenType.BINARY_NUMBER;
        } else {
            boolean octal;
            boolean bl = octal = digit == 0;
            if (digit != -1) {
                this.skip(1);
            }
            while ((digit = Lexer.convertDigit(this.ch0, 10)) != -1) {
                octal = octal && digit < 8;
                this.skip(1);
            }
            if (octal && this.position - start > 1) {
                type = TokenType.OCTAL_LEGACY;
            } else if (this.ch0 == '.' || this.ch0 == 'E' || this.ch0 == 'e') {
                if (this.ch0 == '.') {
                    this.skip(1);
                    while (Lexer.convertDigit(this.ch0, 10) != -1) {
                        this.skip(1);
                    }
                }
                if (this.ch0 == 'E' || this.ch0 == 'e') {
                    this.skip(1);
                    if (this.ch0 == '+' || this.ch0 == '-') {
                        this.skip(1);
                    }
                    while (Lexer.convertDigit(this.ch0, 10) != -1) {
                        this.skip(1);
                    }
                }
                type = TokenType.FLOATING;
            }
        }
        if (Character.isJavaIdentifierStart((char)this.ch0)) {
            this.error(Lexer.message("missing.space.after.number", new String[0]), type, this.position, 1);
        }
        this.add(type, start);
    }

    XMLToken valueOfXML(int start, int length) {
        return new XMLToken(this.source.getString(start, length));
    }

    private boolean scanXMLLiteral() {
        assert (this.ch0 == '<' && Character.isJavaIdentifierStart((char)this.ch1));
        if (XML_LITERALS) {
            int start = this.position;
            int openCount = 0;
            do {
                if (this.ch0 == '<') {
                    if (this.ch1 == '/' && Character.isJavaIdentifierStart((char)this.ch2)) {
                        this.skip(3);
                        --openCount;
                    } else if (Character.isJavaIdentifierStart((char)this.ch1)) {
                        this.skip(2);
                        ++openCount;
                    } else if (this.ch1 == '?') {
                        this.skip(2);
                    } else if (this.ch1 == '!' && this.ch2 == '-' && this.ch3 == '-') {
                        this.skip(4);
                    } else {
                        this.reset(start);
                        return false;
                    }
                    while (!this.atEOF() && this.ch0 != '>') {
                        if (this.ch0 == '/' && this.ch1 == '>') {
                            --openCount;
                            this.skip(1);
                            break;
                        }
                        if (this.ch0 == '\"' || this.ch0 == '\'') {
                            this.scanString(false);
                            continue;
                        }
                        this.skip(1);
                    }
                    if (this.ch0 != '>') {
                        this.reset(start);
                        return false;
                    }
                    this.skip(1);
                    continue;
                }
                if (this.atEOF()) {
                    this.reset(start);
                    return false;
                }
                this.skip(1);
            } while (openCount > 0);
            this.add(TokenType.XML, start);
            return true;
        }
        return false;
    }

    private int scanIdentifier() {
        int ch;
        int start = this.position;
        if (this.ch0 == '\\' && this.ch1 == 'u') {
            this.skip(2);
            ch = this.hexSequence(4, TokenType.IDENT);
            if (!Character.isJavaIdentifierStart((int)ch)) {
                this.error(Lexer.message("illegal.identifier.character", new String[0]), TokenType.IDENT, start, this.position);
            }
        } else if (!Character.isJavaIdentifierStart((char)this.ch0)) {
            return 0;
        }
        while (!this.atEOF()) {
            if (this.ch0 == '\\' && this.ch1 == 'u') {
                this.skip(2);
                ch = this.hexSequence(4, TokenType.IDENT);
                if (Character.isJavaIdentifierPart((int)ch)) continue;
                this.error(Lexer.message("illegal.identifier.character", new String[0]), TokenType.IDENT, start, this.position);
                continue;
            }
            if (!Character.isJavaIdentifierPart((char)this.ch0)) break;
            this.skip(1);
        }
        return this.position - start;
    }

    private boolean identifierEqual(int aStart, int aLength, int bStart, int bLength) {
        if (aLength == bLength) {
            for (int i = 0; i < aLength; ++i) {
                if (this.content[aStart + i] == this.content[bStart + i]) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean hasHereMarker(int identStart, int identLength) {
        this.skipWhitespace(false);
        return this.identifierEqual(identStart, identLength, this.position, this.scanIdentifier());
    }

    private void editString(TokenType stringType, State stringState) {
        EditStringLexer lexer = new EditStringLexer(this, stringType, stringState);
        lexer.lexify();
        this.last = stringType;
    }

    private boolean scanHereString(LineInfoReceiver lir, State oldState) {
        assert (this.ch0 == '<' && this.ch1 == '<');
        if (this.scripting) {
            boolean noStringEditing;
            boolean excludeLastEOL;
            State saved = this.saveState();
            boolean bl = excludeLastEOL = this.ch2 != '<';
            if (excludeLastEOL) {
                this.skip(2);
            } else {
                this.skip(3);
            }
            char quoteChar = this.ch0;
            boolean bl2 = noStringEditing = quoteChar == '\"' || quoteChar == '\'';
            if (noStringEditing) {
                this.skip(1);
            }
            int identStart = this.position;
            int identLength = this.scanIdentifier();
            if (noStringEditing) {
                if (this.ch0 != quoteChar) {
                    this.error(Lexer.message("here.non.matching.delimiter", new String[0]), this.last, this.position, this.position);
                    this.restoreState(saved);
                    return false;
                }
                this.skip(1);
            }
            if (identLength == 0) {
                this.restoreState(saved);
                return false;
            }
            State restState = this.saveState();
            int lastLine = this.line;
            this.skipLine(false);
            ++lastLine;
            int lastLinePosition = this.position;
            restState.setLimit(this.position);
            if (oldState.position > this.position) {
                this.restoreState(oldState);
                this.skipLine(false);
            }
            State stringState = this.saveState();
            int stringEnd = this.position;
            while (!this.atEOF()) {
                this.skipWhitespace(false);
                lastLinePosition = this.position;
                stringEnd = this.position;
                if (this.hasHereMarker(identStart, identLength)) break;
                this.skipLine(false);
                ++lastLine;
                lastLinePosition = this.position;
                stringEnd = this.position;
            }
            lir.lineInfo(lastLine, lastLinePosition);
            stringState.setLimit(stringEnd);
            if (stringState.isEmpty() || this.atEOF()) {
                this.error(Lexer.message("here.missing.end.marker", this.source.getString(identStart, identLength)), this.last, this.position, this.position);
                this.restoreState(saved);
                return false;
            }
            if (excludeLastEOL) {
                if (this.content[stringEnd - 1] == '\n') {
                    --stringEnd;
                }
                if (this.content[stringEnd - 1] == '\r') {
                    --stringEnd;
                }
                stringState.setLimit(stringEnd);
            }
            if (!noStringEditing && !stringState.isEmpty()) {
                this.editString(TokenType.STRING, stringState);
            } else {
                this.add(TokenType.STRING, stringState.position, stringState.limit);
            }
            Lexer restLexer = new Lexer(this, restState);
            restLexer.lexify();
            return true;
        }
        return false;
    }

    public void lexify() {
        while (!this.stream.isFull() || this.nested) {
            this.skipWhitespace(true);
            if (this.atEOF()) {
                if (this.nested) break;
                this.add(TokenType.EOF, this.position);
                break;
            }
            if (this.ch0 == '/' && this.skipComments() || this.scripting && this.ch0 == '#' && this.skipComments()) continue;
            if (this.ch0 == '.' && Lexer.convertDigit(this.ch1, 10) != -1) {
                this.scanNumber();
                continue;
            }
            TokenType type = TokenLookup.lookupOperator(this.ch0, this.ch1, this.ch2, this.ch3);
            if (type != null) {
                if (this.templateExpressionOpenBraces > 0) {
                    if (type == TokenType.LBRACE) {
                        ++this.templateExpressionOpenBraces;
                    } else if (type == TokenType.RBRACE && --this.templateExpressionOpenBraces == 0) break;
                }
                int typeLength = type.getLength();
                this.skip(typeLength);
                this.add(type, this.position - typeLength);
                if (this.canStartLiteral(type)) break;
                if (type != TokenType.LBRACE || !this.pauseOnNextLeftBrace) continue;
                this.pauseOnNextLeftBrace = false;
                break;
            }
            if (Character.isJavaIdentifierStart((char)this.ch0) || this.ch0 == '\\' && this.ch1 == 'u') {
                this.scanIdentifierOrKeyword();
                continue;
            }
            if (this.isStringDelimiter(this.ch0)) {
                this.scanString(true);
                continue;
            }
            if (Character.isDigit((char)this.ch0)) {
                this.scanNumber();
                continue;
            }
            if (Lexer.isTemplateDelimiter(this.ch0) && this.es6) {
                this.scanTemplate();
                continue;
            }
            if (Lexer.isTemplateDelimiter(this.ch0) && this.scripting) {
                this.scanString(true);
                continue;
            }
            this.skip(1);
            this.add(TokenType.ERROR, this.position - 1);
        }
    }

    Object getValueOf(long token, boolean strict) {
        int start = Token.descPosition(token);
        int len = Token.descLength(token);
        switch (Token.descType(token)) {
            case DECIMAL: {
                return Lexer.valueOf(this.source.getString(start, len), 10);
            }
            case HEXADECIMAL: {
                return Lexer.valueOf(this.source.getString(start + 2, len - 2), 16);
            }
            case OCTAL_LEGACY: {
                return Lexer.valueOf(this.source.getString(start, len), 8);
            }
            case OCTAL: {
                return Lexer.valueOf(this.source.getString(start + 2, len - 2), 8);
            }
            case BINARY_NUMBER: {
                return Lexer.valueOf(this.source.getString(start + 2, len - 2), 2);
            }
            case FLOATING: {
                String str = this.source.getString(start, len);
                double value = Double.parseDouble((String)str);
                if (str.indexOf(46) != -1) {
                    return value;
                }
                if (JSType.isStrictlyRepresentableAsInt(value)) {
                    return (int)value;
                }
                return value;
            }
            case STRING: 
            case DIRECTIVE_COMMENT: {
                return this.source.getString(start, len);
            }
            case ESCSTRING: {
                return this.valueOfString(start, len, strict);
            }
            case IDENT: {
                return this.valueOfIdent(start, len);
            }
            case REGEX: {
                return this.valueOfPattern(start, len);
            }
            case TEMPLATE: 
            case TEMPLATE_HEAD: 
            case TEMPLATE_MIDDLE: 
            case TEMPLATE_TAIL: {
                return this.valueOfString(start, len, true);
            }
            case XML: {
                return this.valueOfXML(start, len);
            }
        }
        return null;
    }

    public String valueOfRawString(long token) {
        int start = Token.descPosition(token);
        int length = Token.descLength(token);
        int savePosition = this.position;
        int end = start + length;
        this.reset(start);
        StringBuilder sb = new StringBuilder(length);
        while (this.position < end) {
            if (this.ch0 == '\r') {
                sb.append('\n');
                this.skip(this.ch1 == '\n' ? 2 : 1);
                continue;
            }
            sb.append(this.ch0);
            this.skip(1);
        }
        this.reset(savePosition);
        return sb.toString();
    }

    protected static String message(String msgId, String ... args) {
        return ECMAErrors.getMessage("lexer.error." + msgId, args);
    }

    protected void error(String message, TokenType type, int start, int length) throws ParserException {
        long token = Token.toDesc(type, start, length);
        int pos = Token.descPosition(token);
        int lineNum = this.source.getLine(pos);
        int columnNum = this.source.getColumn(pos);
        String formatted = ErrorManager.format(message, this.source, lineNum, columnNum, token);
        throw new ParserException(JSErrorType.SYNTAX_ERROR, formatted, this.source, lineNum, columnNum, token);
    }

    public static class XMLToken
    extends LexerToken {
        private static final long serialVersionUID = 1L;

        public XMLToken(String expression) {
            super(expression);
        }
    }

    public static class RegexToken
    extends LexerToken {
        private static final long serialVersionUID = 1L;
        private final String options;

        public RegexToken(String expression, String options) {
            super(expression);
            this.options = options;
        }

        public String getOptions() {
            return this.options;
        }

        public String toString() {
            return "/" + this.getExpression() + "/" + this.options;
        }
    }

    public static abstract class LexerToken
    implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String expression;

        protected LexerToken(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    private static class EditStringLexer
    extends Lexer {
        final TokenType stringType;

        EditStringLexer(Lexer lexer, TokenType stringType, State stringState) {
            super(lexer, stringState);
            this.stringType = stringType;
        }

        @Override
        public void lexify() {
            int stringStart = this.position;
            boolean primed = false;
            while (!this.atEOF()) {
                if (this.ch0 == '\\' && this.stringType == TokenType.ESCSTRING) {
                    this.skip(2);
                    continue;
                }
                if (this.ch0 == '$' && this.ch1 == '{') {
                    if (!primed || stringStart != this.position) {
                        if (primed) {
                            this.add(TokenType.ADD, stringStart, stringStart + 1);
                        }
                        this.add(this.stringType, stringStart, this.position);
                        primed = true;
                    }
                    this.skip(2);
                    Scanner.State expressionState = this.saveState();
                    int braceCount = 1;
                    while (!this.atEOF()) {
                        if (this.ch0 == '}') {
                            if (--braceCount == 0) {
                                break;
                            }
                        } else if (this.ch0 == '{') {
                            ++braceCount;
                        }
                        this.skip(1);
                    }
                    if (braceCount != 0) {
                        this.error(Lexer.message("edit.string.missing.brace", new String[0]), TokenType.LBRACE, ((State)expressionState).position - 1, 1);
                    }
                    expressionState.setLimit(this.position);
                    this.skip(1);
                    stringStart = this.position;
                    this.add(TokenType.ADD, ((State)expressionState).position, ((State)expressionState).position + 1);
                    this.add(TokenType.LPAREN, ((State)expressionState).position, ((State)expressionState).position + 1);
                    Lexer lexer = new Lexer(this, (State)expressionState);
                    lexer.lexify();
                    this.add(TokenType.RPAREN, this.position - 1, this.position);
                    continue;
                }
                this.skip(1);
            }
            if (stringStart != this.limit) {
                if (primed) {
                    this.add(TokenType.ADD, stringStart, 1);
                }
                this.add(this.stringType, stringStart, this.limit);
            }
        }
    }

    protected static interface LineInfoReceiver {
        public void lineInfo(int var1, int var2);
    }

    static class State
    extends Scanner.State {
        public final int pendingLine;
        public final int linePosition;
        public final TokenType last;

        State(int position, int limit, int line, int pendingLine, int linePosition, TokenType last) {
            super(position, limit, line);
            this.pendingLine = pendingLine;
            this.linePosition = linePosition;
            this.last = last;
        }
    }
}


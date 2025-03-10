/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.Deprecated
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.math.BigDecimal
 *  java.math.BigInteger
 */
package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class FilteringParserDelegate
extends JsonParserDelegate {
    protected TokenFilter rootFilter;
    protected boolean _allowMultipleMatches;
    protected TokenFilter.Inclusion _inclusion;
    protected JsonToken _currToken;
    protected JsonToken _lastClearedToken;
    protected TokenFilterContext _headContext;
    protected TokenFilterContext _exposedContext;
    protected TokenFilter _itemFilter;
    protected int _matchCount;

    @Deprecated
    public FilteringParserDelegate(JsonParser p, TokenFilter f, boolean includePath, boolean allowMultipleMatches) {
        this(p, f, includePath ? TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH : TokenFilter.Inclusion.ONLY_INCLUDE_ALL, allowMultipleMatches);
    }

    public FilteringParserDelegate(JsonParser p, TokenFilter f, TokenFilter.Inclusion inclusion, boolean allowMultipleMatches) {
        super(p);
        this.rootFilter = f;
        this._itemFilter = f;
        this._headContext = TokenFilterContext.createRootContext(f);
        this._inclusion = inclusion;
        this._allowMultipleMatches = allowMultipleMatches;
    }

    public TokenFilter getFilter() {
        return this.rootFilter;
    }

    public int getMatchCount() {
        return this._matchCount;
    }

    @Override
    public JsonToken getCurrentToken() {
        return this._currToken;
    }

    @Override
    public JsonToken currentToken() {
        return this._currToken;
    }

    @Override
    @Deprecated
    public final int getCurrentTokenId() {
        return this.currentTokenId();
    }

    @Override
    public final int currentTokenId() {
        JsonToken t = this._currToken;
        return t == null ? 0 : t.id();
    }

    @Override
    public boolean hasCurrentToken() {
        return this._currToken != null;
    }

    @Override
    public boolean hasTokenId(int id) {
        JsonToken t = this._currToken;
        if (t == null) {
            return 0 == id;
        }
        return t.id() == id;
    }

    @Override
    public final boolean hasToken(JsonToken t) {
        return this._currToken == t;
    }

    @Override
    public boolean isExpectedStartArrayToken() {
        return this._currToken == JsonToken.START_ARRAY;
    }

    @Override
    public boolean isExpectedStartObjectToken() {
        return this._currToken == JsonToken.START_OBJECT;
    }

    @Override
    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    @Override
    public JsonStreamContext getParsingContext() {
        return this._filterContext();
    }

    @Override
    public String getCurrentName() throws IOException {
        JsonStreamContext ctxt = this._filterContext();
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            JsonStreamContext parent = ctxt.getParent();
            return parent == null ? null : parent.getCurrentName();
        }
        return ctxt.getCurrentName();
    }

    @Override
    public String currentName() throws IOException {
        JsonStreamContext ctxt = this._filterContext();
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            JsonStreamContext parent = ctxt.getParent();
            return parent == null ? null : parent.getCurrentName();
        }
        return ctxt.getCurrentName();
    }

    @Override
    public void clearCurrentToken() {
        if (this._currToken != null) {
            this._lastClearedToken = this._currToken;
            this._currToken = null;
        }
    }

    @Override
    public JsonToken getLastClearedToken() {
        return this._lastClearedToken;
    }

    @Override
    public void overrideCurrentName(String name) {
        throw new UnsupportedOperationException("Can not currently override name during filtering read");
    }

    @Override
    public JsonToken nextToken() throws IOException {
        JsonToken t;
        block39: {
            if (!this._allowMultipleMatches && this._currToken != null && this._exposedContext == null && this._currToken.isScalarValue() && !this._headContext.isStartHandled() && this._inclusion == TokenFilter.Inclusion.ONLY_INCLUDE_ALL && this._itemFilter == TokenFilter.INCLUDE_ALL) {
                this._currToken = null;
                return null;
            }
            TokenFilterContext ctxt = this._exposedContext;
            if (ctxt != null) {
                do {
                    if ((t = ctxt.nextTokenToRead()) != null) {
                        this._currToken = t;
                        return t;
                    }
                    if (ctxt == this._headContext) {
                        this._exposedContext = null;
                        if (ctxt.inArray()) {
                            this._currToken = t = this.delegate.getCurrentToken();
                            if (this._currToken == JsonToken.END_ARRAY) {
                                this._headContext = this._headContext.getParent();
                                this._itemFilter = this._headContext.getFilter();
                            }
                            return t;
                        }
                        t = this.delegate.currentToken();
                        if (t == JsonToken.END_OBJECT) {
                            this._headContext = this._headContext.getParent();
                            this._itemFilter = this._headContext.getFilter();
                        }
                        if (t != JsonToken.FIELD_NAME) {
                            this._currToken = t;
                            return t;
                        }
                        break block39;
                    }
                    this._exposedContext = ctxt = this._headContext.findChildOf(ctxt);
                } while (ctxt != null);
                throw this._constructError("Unexpected problem: chain of filtered context broken");
            }
        }
        if ((t = this.delegate.nextToken()) == null) {
            this._currToken = t;
            return t;
        }
        switch (t.id()) {
            case 3: {
                TokenFilter f = this._itemFilter;
                if (f == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildArrayContext(f, true);
                    this._currToken = t;
                    return this._currToken;
                }
                if (f == null) {
                    this.delegate.skipChildren();
                    break;
                }
                if ((f = this._headContext.checkValue(f)) == null) {
                    this.delegate.skipChildren();
                    break;
                }
                if (f != TokenFilter.INCLUDE_ALL) {
                    f = f.filterStartArray();
                }
                this._itemFilter = f;
                if (f == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildArrayContext(f, true);
                    this._currToken = t;
                    return this._currToken;
                }
                if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                    this._headContext = this._headContext.createChildArrayContext(f, true);
                    this._currToken = t;
                    return this._currToken;
                }
                this._headContext = this._headContext.createChildArrayContext(f, false);
                if (this._inclusion != TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH || (t = this._nextTokenWithBuffering(this._headContext)) == null) break;
                this._currToken = t;
                return t;
            }
            case 1: {
                TokenFilter f = this._itemFilter;
                if (f == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildObjectContext(f, true);
                    this._currToken = t;
                    return this._currToken;
                }
                if (f == null) {
                    this.delegate.skipChildren();
                    break;
                }
                if ((f = this._headContext.checkValue(f)) == null) {
                    this.delegate.skipChildren();
                    break;
                }
                if (f != TokenFilter.INCLUDE_ALL) {
                    f = f.filterStartObject();
                }
                this._itemFilter = f;
                if (f == TokenFilter.INCLUDE_ALL) {
                    this._headContext = this._headContext.createChildObjectContext(f, true);
                    this._currToken = t;
                    return this._currToken;
                }
                if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                    this._headContext = this._headContext.createChildObjectContext(f, true);
                    this._currToken = t;
                    return this._currToken;
                }
                this._headContext = this._headContext.createChildObjectContext(f, false);
                if (this._inclusion != TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH || (t = this._nextTokenWithBuffering(this._headContext)) == null) break;
                this._currToken = t;
                return t;
            }
            case 2: 
            case 4: {
                boolean returnEnd = this._headContext.isStartHandled();
                TokenFilter f = this._headContext.getFilter();
                if (f != null && f != TokenFilter.INCLUDE_ALL) {
                    if (t.id() == 4) {
                        f.filterFinishArray();
                    } else {
                        f.filterFinishObject();
                    }
                }
                this._headContext = this._headContext.getParent();
                this._itemFilter = this._headContext.getFilter();
                if (!returnEnd) break;
                this._currToken = t;
                return this._currToken;
            }
            case 5: {
                String name = this.delegate.getCurrentName();
                TokenFilter f = this._headContext.setFieldName(name);
                if (f == TokenFilter.INCLUDE_ALL) {
                    this._itemFilter = f;
                    this._currToken = t;
                    return this._currToken;
                }
                if (f == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                    break;
                }
                if ((f = f.includeProperty(name)) == null) {
                    this.delegate.nextToken();
                    this.delegate.skipChildren();
                    break;
                }
                this._itemFilter = f;
                if (f == TokenFilter.INCLUDE_ALL) {
                    if (this._verifyAllowedMatches()) {
                        if (this._inclusion == TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) {
                            this._currToken = t;
                            return this._currToken;
                        }
                    } else {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                    }
                }
                if (this._inclusion == TokenFilter.Inclusion.ONLY_INCLUDE_ALL || (t = this._nextTokenWithBuffering(this._headContext)) == null) break;
                this._currToken = t;
                return t;
            }
            default: {
                TokenFilter f = this._itemFilter;
                if (f == TokenFilter.INCLUDE_ALL) {
                    this._currToken = t;
                    return this._currToken;
                }
                if (f == null || (f = this._headContext.checkValue(f)) != TokenFilter.INCLUDE_ALL && (f == null || !f.includeValue(this.delegate)) || !this._verifyAllowedMatches()) break;
                this._currToken = t;
                return this._currToken;
            }
        }
        return this._nextToken2();
    }

    protected final JsonToken _nextToken2() throws IOException {
        JsonToken t;
        block7: while (true) {
            TokenFilter f;
            if ((t = this.delegate.nextToken()) == null) {
                this._currToken = t;
                return t;
            }
            switch (t.id()) {
                case 3: {
                    f = this._itemFilter;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildArrayContext(f, true);
                        this._currToken = t;
                        return this._currToken;
                    }
                    if (f == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if ((f = this._headContext.checkValue(f)) == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if (f != TokenFilter.INCLUDE_ALL) {
                        f = f.filterStartArray();
                    }
                    this._itemFilter = f;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildArrayContext(f, true);
                        this._currToken = t;
                        return this._currToken;
                    }
                    if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                        this._headContext = this._headContext.createChildArrayContext(f, true);
                        this._currToken = t;
                        return this._currToken;
                    }
                    this._headContext = this._headContext.createChildArrayContext(f, false);
                    if (this._inclusion != TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH || (t = this._nextTokenWithBuffering(this._headContext)) == null) continue block7;
                    this._currToken = t;
                    return t;
                }
                case 1: {
                    f = this._itemFilter;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(f, true);
                        this._currToken = t;
                        return this._currToken;
                    }
                    if (f == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if ((f = this._headContext.checkValue(f)) == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if (f != TokenFilter.INCLUDE_ALL) {
                        f = f.filterStartObject();
                    }
                    this._itemFilter = f;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(f, true);
                        this._currToken = t;
                        return this._currToken;
                    }
                    if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                        this._headContext = this._headContext.createChildObjectContext(f, true);
                        this._currToken = t;
                        return this._currToken;
                    }
                    this._headContext = this._headContext.createChildObjectContext(f, false);
                    if (this._inclusion != TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH || (t = this._nextTokenWithBuffering(this._headContext)) == null) continue block7;
                    this._currToken = t;
                    return t;
                }
                case 4: {
                    boolean includeEmpty;
                    boolean returnEnd = this._headContext.isStartHandled();
                    f = this._headContext.getFilter();
                    if (f != null && f != TokenFilter.INCLUDE_ALL) {
                        includeEmpty = f.includeEmptyArray(this._headContext.hasCurrentIndex());
                        f.filterFinishArray();
                        if (includeEmpty) {
                            return this._nextBuffered(this._headContext);
                        }
                    }
                    this._headContext = this._headContext.getParent();
                    this._itemFilter = this._headContext.getFilter();
                    if (!returnEnd) continue block7;
                    this._currToken = t;
                    return this._currToken;
                }
                case 2: {
                    boolean includeEmpty;
                    boolean returnEnd = this._headContext.isStartHandled();
                    f = this._headContext.getFilter();
                    if (f != null && f != TokenFilter.INCLUDE_ALL) {
                        includeEmpty = f.includeEmptyArray(this._headContext.hasCurrentName());
                        f.filterFinishObject();
                        if (includeEmpty) {
                            return this._nextBuffered(this._headContext);
                        }
                    }
                    this._headContext = this._headContext.getParent();
                    this._itemFilter = this._headContext.getFilter();
                    if (!returnEnd) continue block7;
                    this._currToken = t;
                    return this._currToken;
                }
                case 5: {
                    String name = this.delegate.getCurrentName();
                    f = this._headContext.setFieldName(name);
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._itemFilter = f;
                        this._currToken = t;
                        return this._currToken;
                    }
                    if (f == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if ((f = f.includeProperty(name)) == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    this._itemFilter = f;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        if (this._verifyAllowedMatches()) {
                            if (this._inclusion != TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH) continue block7;
                            this._currToken = t;
                            return this._currToken;
                        }
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if (this._inclusion == TokenFilter.Inclusion.ONLY_INCLUDE_ALL || (t = this._nextTokenWithBuffering(this._headContext)) == null) continue block7;
                    this._currToken = t;
                    return t;
                }
            }
            f = this._itemFilter;
            if (f == TokenFilter.INCLUDE_ALL) {
                this._currToken = t;
                return this._currToken;
            }
            if (f != null && ((f = this._headContext.checkValue(f)) == TokenFilter.INCLUDE_ALL || f != null && f.includeValue(this.delegate)) && this._verifyAllowedMatches()) break;
        }
        this._currToken = t;
        return this._currToken;
    }

    protected final JsonToken _nextTokenWithBuffering(TokenFilterContext buffRoot) throws IOException {
        block7: while (true) {
            TokenFilter f;
            JsonToken t;
            if ((t = this.delegate.nextToken()) == null) {
                return t;
            }
            switch (t.id()) {
                case 3: {
                    f = this._headContext.checkValue(this._itemFilter);
                    if (f == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if (f != TokenFilter.INCLUDE_ALL) {
                        f = f.filterStartArray();
                    }
                    this._itemFilter = f;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildArrayContext(f, true);
                        return this._nextBuffered(buffRoot);
                    }
                    if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                        this._headContext = this._headContext.createChildArrayContext(f, true);
                        return this._nextBuffered(buffRoot);
                    }
                    this._headContext = this._headContext.createChildArrayContext(f, false);
                    continue block7;
                }
                case 1: {
                    f = this._itemFilter;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(f, true);
                        return t;
                    }
                    if (f == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if ((f = this._headContext.checkValue(f)) == null) {
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if (f != TokenFilter.INCLUDE_ALL) {
                        f = f.filterStartObject();
                    }
                    this._itemFilter = f;
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._headContext = this._headContext.createChildObjectContext(f, true);
                        return this._nextBuffered(buffRoot);
                    }
                    if (f != null && this._inclusion == TokenFilter.Inclusion.INCLUDE_NON_NULL) {
                        this._headContext = this._headContext.createChildArrayContext(f, true);
                        return this._nextBuffered(buffRoot);
                    }
                    this._headContext = this._headContext.createChildObjectContext(f, false);
                    continue block7;
                }
                case 4: {
                    f = this._headContext.getFilter();
                    if (f != null && f != TokenFilter.INCLUDE_ALL) {
                        boolean includeEmpty = f.includeEmptyArray(this._headContext.hasCurrentIndex());
                        f.filterFinishArray();
                        if (includeEmpty) {
                            return this._nextBuffered(buffRoot);
                        }
                    }
                    boolean gotEnd = this._headContext == buffRoot;
                    boolean returnEnd = gotEnd && this._headContext.isStartHandled();
                    this._headContext = this._headContext.getParent();
                    this._itemFilter = this._headContext.getFilter();
                    if (returnEnd) {
                        return t;
                    }
                    if (!gotEnd) continue block7;
                    return null;
                }
                case 2: {
                    f = this._headContext.getFilter();
                    if (f != null && f != TokenFilter.INCLUDE_ALL) {
                        boolean includeEmpty = f.includeEmptyObject(this._headContext.hasCurrentName());
                        f.filterFinishObject();
                        if (includeEmpty) {
                            this._headContext._currentName = this._headContext._parent == null ? null : this._headContext._parent._currentName;
                            this._headContext._needToHandleName = false;
                            return this._nextBuffered(buffRoot);
                        }
                    }
                    boolean gotEnd = this._headContext == buffRoot;
                    boolean returnEnd = gotEnd && this._headContext.isStartHandled();
                    this._headContext = this._headContext.getParent();
                    this._itemFilter = this._headContext.getFilter();
                    if (returnEnd) {
                        return t;
                    }
                    if (!gotEnd) continue block7;
                    return null;
                }
                case 5: {
                    String name = this.delegate.getCurrentName();
                    f = this._headContext.setFieldName(name);
                    if (f == TokenFilter.INCLUDE_ALL) {
                        this._itemFilter = f;
                        return this._nextBuffered(buffRoot);
                    }
                    if (f == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    if ((f = f.includeProperty(name)) == null) {
                        this.delegate.nextToken();
                        this.delegate.skipChildren();
                        continue block7;
                    }
                    this._itemFilter = f;
                    if (f != TokenFilter.INCLUDE_ALL) continue block7;
                    if (this._verifyAllowedMatches()) {
                        return this._nextBuffered(buffRoot);
                    }
                    this._itemFilter = this._headContext.setFieldName(name);
                    continue block7;
                }
            }
            f = this._itemFilter;
            if (f == TokenFilter.INCLUDE_ALL) {
                return this._nextBuffered(buffRoot);
            }
            if (f != null && ((f = this._headContext.checkValue(f)) == TokenFilter.INCLUDE_ALL || f != null && f.includeValue(this.delegate)) && this._verifyAllowedMatches()) break;
        }
        return this._nextBuffered(buffRoot);
    }

    private JsonToken _nextBuffered(TokenFilterContext buffRoot) throws IOException {
        this._exposedContext = buffRoot;
        TokenFilterContext ctxt = buffRoot;
        JsonToken t = ctxt.nextTokenToRead();
        if (t != null) {
            return t;
        }
        do {
            if (ctxt == this._headContext) {
                throw this._constructError("Internal error: failed to locate expected buffered tokens");
            }
            this._exposedContext = ctxt = this._exposedContext.findChildOf(ctxt);
            if (ctxt != null) continue;
            throw this._constructError("Unexpected problem: chain of filtered context broken");
        } while ((t = this._exposedContext.nextTokenToRead()) == null);
        return t;
    }

    private final boolean _verifyAllowedMatches() throws IOException {
        if (this._matchCount == 0 || this._allowMultipleMatches) {
            ++this._matchCount;
            return true;
        }
        return false;
    }

    @Override
    public JsonToken nextValue() throws IOException {
        JsonToken t = this.nextToken();
        if (t == JsonToken.FIELD_NAME) {
            t = this.nextToken();
        }
        return t;
    }

    @Override
    public JsonParser skipChildren() throws IOException {
        if (this._currToken != JsonToken.START_OBJECT && this._currToken != JsonToken.START_ARRAY) {
            return this;
        }
        int open = 1;
        while (true) {
            JsonToken t;
            if ((t = this.nextToken()) == null) {
                return this;
            }
            if (t.isStructStart()) {
                ++open;
                continue;
            }
            if (t.isStructEnd() && --open == 0) break;
        }
        return this;
    }

    @Override
    public String getText() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.currentName();
        }
        return this.delegate.getText();
    }

    @Override
    public boolean hasTextCharacters() {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return false;
        }
        return this.delegate.hasTextCharacters();
    }

    @Override
    public char[] getTextCharacters() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.currentName().toCharArray();
        }
        return this.delegate.getTextCharacters();
    }

    @Override
    public int getTextLength() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.currentName().length();
        }
        return this.delegate.getTextLength();
    }

    @Override
    public int getTextOffset() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return 0;
        }
        return this.delegate.getTextOffset();
    }

    @Override
    public BigInteger getBigIntegerValue() throws IOException {
        return this.delegate.getBigIntegerValue();
    }

    @Override
    public boolean getBooleanValue() throws IOException {
        return this.delegate.getBooleanValue();
    }

    @Override
    public byte getByteValue() throws IOException {
        return this.delegate.getByteValue();
    }

    @Override
    public short getShortValue() throws IOException {
        return this.delegate.getShortValue();
    }

    @Override
    public BigDecimal getDecimalValue() throws IOException {
        return this.delegate.getDecimalValue();
    }

    @Override
    public double getDoubleValue() throws IOException {
        return this.delegate.getDoubleValue();
    }

    @Override
    public float getFloatValue() throws IOException {
        return this.delegate.getFloatValue();
    }

    @Override
    public int getIntValue() throws IOException {
        return this.delegate.getIntValue();
    }

    @Override
    public long getLongValue() throws IOException {
        return this.delegate.getLongValue();
    }

    @Override
    public JsonParser.NumberType getNumberType() throws IOException {
        return this.delegate.getNumberType();
    }

    @Override
    public Number getNumberValue() throws IOException {
        return this.delegate.getNumberValue();
    }

    @Override
    public int getValueAsInt() throws IOException {
        return this.delegate.getValueAsInt();
    }

    @Override
    public int getValueAsInt(int defaultValue) throws IOException {
        return this.delegate.getValueAsInt(defaultValue);
    }

    @Override
    public long getValueAsLong() throws IOException {
        return this.delegate.getValueAsLong();
    }

    @Override
    public long getValueAsLong(long defaultValue) throws IOException {
        return this.delegate.getValueAsLong(defaultValue);
    }

    @Override
    public double getValueAsDouble() throws IOException {
        return this.delegate.getValueAsDouble();
    }

    @Override
    public double getValueAsDouble(double defaultValue) throws IOException {
        return this.delegate.getValueAsDouble(defaultValue);
    }

    @Override
    public boolean getValueAsBoolean() throws IOException {
        return this.delegate.getValueAsBoolean();
    }

    @Override
    public boolean getValueAsBoolean(boolean defaultValue) throws IOException {
        return this.delegate.getValueAsBoolean(defaultValue);
    }

    @Override
    public String getValueAsString() throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.currentName();
        }
        return this.delegate.getValueAsString();
    }

    @Override
    public String getValueAsString(String defaultValue) throws IOException {
        if (this._currToken == JsonToken.FIELD_NAME) {
            return this.currentName();
        }
        return this.delegate.getValueAsString(defaultValue);
    }

    @Override
    public Object getEmbeddedObject() throws IOException {
        return this.delegate.getEmbeddedObject();
    }

    @Override
    public byte[] getBinaryValue(Base64Variant b64variant) throws IOException {
        return this.delegate.getBinaryValue(b64variant);
    }

    @Override
    public int readBinaryValue(Base64Variant b64variant, OutputStream out) throws IOException {
        return this.delegate.readBinaryValue(b64variant, out);
    }

    @Override
    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    protected JsonStreamContext _filterContext() {
        if (this._exposedContext != null) {
            return this._exposedContext;
        }
        return this._headContext;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.List
 */
package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserSequence
extends JsonParserDelegate {
    protected final JsonParser[] _parsers;
    protected final boolean _checkForExistingToken;
    protected int _nextParserIndex;
    protected boolean _hasToken;

    @Deprecated
    protected JsonParserSequence(JsonParser[] parsers) {
        this(false, parsers);
    }

    protected JsonParserSequence(boolean checkForExistingToken, JsonParser[] parsers) {
        super(parsers[0]);
        this._checkForExistingToken = checkForExistingToken;
        this._hasToken = checkForExistingToken && this.delegate.hasCurrentToken();
        this._parsers = parsers;
        this._nextParserIndex = 1;
    }

    public static JsonParserSequence createFlattened(boolean checkForExistingToken, JsonParser first, JsonParser second) {
        if (!(first instanceof JsonParserSequence) && !(second instanceof JsonParserSequence)) {
            return new JsonParserSequence(checkForExistingToken, new JsonParser[]{first, second});
        }
        ArrayList p = new ArrayList();
        if (first instanceof JsonParserSequence) {
            ((JsonParserSequence)first).addFlattenedActiveParsers((List<JsonParser>)p);
        } else {
            p.add((Object)first);
        }
        if (second instanceof JsonParserSequence) {
            ((JsonParserSequence)second).addFlattenedActiveParsers((List<JsonParser>)p);
        } else {
            p.add((Object)second);
        }
        return new JsonParserSequence(checkForExistingToken, (JsonParser[])p.toArray((Object[])new JsonParser[p.size()]));
    }

    @Deprecated
    public static JsonParserSequence createFlattened(JsonParser first, JsonParser second) {
        return JsonParserSequence.createFlattened(false, first, second);
    }

    protected void addFlattenedActiveParsers(List<JsonParser> listToAddIn) {
        int len = this._parsers.length;
        for (int i = this._nextParserIndex - 1; i < len; ++i) {
            JsonParser p = this._parsers[i];
            if (p instanceof JsonParserSequence) {
                ((JsonParserSequence)p).addFlattenedActiveParsers(listToAddIn);
                continue;
            }
            listToAddIn.add((Object)p);
        }
    }

    @Override
    public void close() throws IOException {
        do {
            this.delegate.close();
        } while (this.switchToNext());
    }

    @Override
    public JsonToken nextToken() throws IOException {
        if (this.delegate == null) {
            return null;
        }
        if (this._hasToken) {
            this._hasToken = false;
            return this.delegate.currentToken();
        }
        JsonToken t = this.delegate.nextToken();
        if (t == null) {
            return this.switchAndReturnNext();
        }
        return t;
    }

    @Override
    public JsonParser skipChildren() throws IOException {
        if (this.delegate.currentToken() != JsonToken.START_OBJECT && this.delegate.currentToken() != JsonToken.START_ARRAY) {
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

    public int containedParsersCount() {
        return this._parsers.length;
    }

    protected boolean switchToNext() {
        if (this._nextParserIndex < this._parsers.length) {
            this.delegate = this._parsers[this._nextParserIndex++];
            return true;
        }
        return false;
    }

    protected JsonToken switchAndReturnNext() throws IOException {
        while (this._nextParserIndex < this._parsers.length) {
            this.delegate = this._parsers[this._nextParserIndex++];
            if (this._checkForExistingToken && this.delegate.hasCurrentToken()) {
                return this.delegate.getCurrentToken();
            }
            JsonToken t = this.delegate.nextToken();
            if (t == null) continue;
            return t;
        }
        return null;
    }
}


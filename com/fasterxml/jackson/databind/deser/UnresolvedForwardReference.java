/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.UnresolvedId;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnresolvedForwardReference
extends JsonMappingException {
    private static final long serialVersionUID = 1L;
    private ReadableObjectId _roid;
    private List<UnresolvedId> _unresolvedIds;

    public UnresolvedForwardReference(JsonParser p, String msg, JsonLocation loc, ReadableObjectId roid) {
        super((Closeable)p, msg, loc);
        this._roid = roid;
    }

    public UnresolvedForwardReference(JsonParser p, String msg) {
        super(p, msg);
        this._unresolvedIds = new ArrayList();
    }

    public ReadableObjectId getRoid() {
        return this._roid;
    }

    public Object getUnresolvedId() {
        return this._roid.getKey().key;
    }

    public void addUnresolvedId(Object id, Class<?> type, JsonLocation where) {
        this._unresolvedIds.add((Object)new UnresolvedId(id, type, where));
    }

    public List<UnresolvedId> getUnresolvedIds() {
        return this._unresolvedIds;
    }

    @Override
    public String getMessage() {
        String msg = super.getMessage();
        if (this._unresolvedIds == null) {
            return msg;
        }
        StringBuilder sb = new StringBuilder(msg);
        Iterator iterator = this._unresolvedIds.iterator();
        while (iterator.hasNext()) {
            UnresolvedId unresolvedId = (UnresolvedId)iterator.next();
            sb.append(unresolvedId.toString());
            if (!iterator.hasNext()) continue;
            sb.append(", ");
        }
        sb.append('.');
        return sb.toString();
    }

    public synchronized UnresolvedForwardReference fillInStackTrace() {
        return this;
    }

    public UnresolvedForwardReference withStackTrace() {
        super.fillInStackTrace();
        return this;
    }
}


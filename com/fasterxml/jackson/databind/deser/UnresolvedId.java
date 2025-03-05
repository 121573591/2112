/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.util.ClassUtil;

public class UnresolvedId {
    private final Object _id;
    private final JsonLocation _location;
    private final Class<?> _type;

    public UnresolvedId(Object id, Class<?> type, JsonLocation where) {
        this._id = id;
        this._type = type;
        this._location = where;
    }

    public Object getId() {
        return this._id;
    }

    public Class<?> getType() {
        return this._type;
    }

    public JsonLocation getLocation() {
        return this._location;
    }

    public String toString() {
        return String.format((String)"Object id [%s] (for %s) at %s", (Object[])new Object[]{this._id, ClassUtil.nameOf(this._type), this._location});
    }
}


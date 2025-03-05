/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 */
package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import java.util.Collection;

public class IgnoredPropertyException
extends PropertyBindingException {
    private static final long serialVersionUID = 1L;

    public IgnoredPropertyException(JsonParser p, String msg, JsonLocation loc, Class<?> referringClass, String propName, Collection<Object> propertyIds) {
        super(p, msg, loc, referringClass, propName, propertyIds);
    }

    @Deprecated
    public IgnoredPropertyException(String msg, JsonLocation loc, Class<?> referringClass, String propName, Collection<Object> propertyIds) {
        super(msg, loc, referringClass, propName, propertyIds);
    }

    public static IgnoredPropertyException from(JsonParser p, Object fromObjectOrClass, String propertyName, Collection<Object> propertyIds) {
        Class ref = fromObjectOrClass instanceof Class ? (Class)fromObjectOrClass : fromObjectOrClass.getClass();
        String msg = String.format((String)"Ignored field \"%s\" (class %s) encountered; mapper configured not to allow this", (Object[])new Object[]{propertyName, ref.getName()});
        IgnoredPropertyException e = new IgnoredPropertyException(p, msg, p.getCurrentLocation(), ref, propertyName, propertyIds);
        e.prependPath(fromObjectOrClass, propertyName);
        return e;
    }
}


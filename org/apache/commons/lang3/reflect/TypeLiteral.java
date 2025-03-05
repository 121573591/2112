/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 */
package org.apache.commons.lang3.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.reflect.Typed;

public abstract class TypeLiteral<T>
implements Typed<T> {
    private static final TypeVariable<Class<TypeLiteral>> T = TypeLiteral.class.getTypeParameters()[0];
    public final Type value = Validate.notNull((Type)TypeUtils.getTypeArguments((Type)this.getClass(), TypeLiteral.class).get(T), "%s does not assign type parameter %s", this.getClass(), TypeUtils.toLongString(T));
    private final String toString = String.format((String)"%s<%s>", (Object[])new Object[]{TypeLiteral.class.getSimpleName(), TypeUtils.toString(this.value)});

    protected TypeLiteral() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TypeLiteral)) {
            return false;
        }
        TypeLiteral other = (TypeLiteral)obj;
        return TypeUtils.equals(this.value, other.value);
    }

    @Override
    public Type getType() {
        return this.value;
    }

    public int hashCode() {
        return 0x250 | this.value.hashCode();
    }

    public String toString() {
        return this.toString;
    }
}


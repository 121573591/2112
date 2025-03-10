/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.TypeVariable
 *  java.util.AbstractList
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.LinkedHashMap
 *  java.util.List
 *  java.util.Map
 */
package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.IdentityEqualityType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TypeBindings
implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String[] NO_STRINGS = new String[0];
    private static final JavaType[] NO_TYPES = new JavaType[0];
    private static final TypeBindings EMPTY = new TypeBindings(NO_STRINGS, NO_TYPES, null);
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;
    private final int _hashCode;

    private TypeBindings(String[] names, JavaType[] types, String[] uvars) {
        this._names = names == null ? NO_STRINGS : names;
        JavaType[] javaTypeArray = this._types = types == null ? NO_TYPES : types;
        if (this._names.length != this._types.length) {
            throw new IllegalArgumentException("Mismatching names (" + this._names.length + "), types (" + this._types.length + ")");
        }
        this._unboundVariables = uvars;
        this._hashCode = Arrays.hashCode((Object[])this._types);
    }

    public static TypeBindings emptyBindings() {
        return EMPTY;
    }

    protected Object readResolve() {
        if (this._names == null || this._names.length == 0) {
            return EMPTY;
        }
        return this;
    }

    public static TypeBindings create(Class<?> erasedType, List<JavaType> typeList) {
        JavaType[] types = typeList == null || typeList.isEmpty() ? NO_TYPES : (JavaType[])typeList.toArray((Object[])NO_TYPES);
        return TypeBindings.create(erasedType, types);
    }

    public static TypeBindings create(Class<?> erasedType, JavaType[] types) {
        String[] names;
        if (types == null) {
            types = NO_TYPES;
        } else {
            switch (types.length) {
                case 1: {
                    return TypeBindings.create(erasedType, types[0]);
                }
                case 2: {
                    return TypeBindings.create(erasedType, types[0], types[1]);
                }
            }
        }
        TypeVariable[] vars = erasedType.getTypeParameters();
        if (vars == null || vars.length == 0) {
            names = NO_STRINGS;
        } else {
            int len = vars.length;
            names = new String[len];
            for (int i = 0; i < len; ++i) {
                names[i] = vars[i].getName();
            }
        }
        if (names.length != types.length) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with " + types.length + " type parameter" + (types.length == 1 ? "" : "s") + ": class expects " + names.length);
        }
        return new TypeBindings(names, types, null);
    }

    public static TypeBindings create(Class<?> erasedType, JavaType typeArg1) {
        int varLen;
        TypeVariable<?>[] vars = TypeParamStash.paramsFor1(erasedType);
        int n = varLen = vars == null ? 0 : vars.length;
        if (varLen != 1) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with 1 type parameter: class expects " + varLen);
        }
        return new TypeBindings(new String[]{vars[0].getName()}, new JavaType[]{typeArg1}, null);
    }

    public static TypeBindings create(Class<?> erasedType, JavaType typeArg1, JavaType typeArg2) {
        int varLen;
        TypeVariable<?>[] vars = TypeParamStash.paramsFor2(erasedType);
        int n = varLen = vars == null ? 0 : vars.length;
        if (varLen != 2) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with 2 type parameters: class expects " + varLen);
        }
        return new TypeBindings(new String[]{vars[0].getName(), vars[1].getName()}, new JavaType[]{typeArg1, typeArg2}, null);
    }

    public static TypeBindings create(List<String> names, List<JavaType> types) {
        if (names == null || names.isEmpty() || types == null || types.isEmpty()) {
            return EMPTY;
        }
        return new TypeBindings((String[])names.toArray((Object[])NO_STRINGS), (JavaType[])types.toArray((Object[])NO_TYPES), null);
    }

    public static TypeBindings createIfNeeded(Class<?> erasedType, JavaType typeArg1) {
        int varLen;
        TypeVariable[] vars = erasedType.getTypeParameters();
        int n = varLen = vars == null ? 0 : vars.length;
        if (varLen == 0) {
            return EMPTY;
        }
        if (varLen != 1) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with 1 type parameter: class expects " + varLen);
        }
        return new TypeBindings(new String[]{vars[0].getName()}, new JavaType[]{typeArg1}, null);
    }

    public static TypeBindings createIfNeeded(Class<?> erasedType, JavaType[] types) {
        TypeVariable[] vars = erasedType.getTypeParameters();
        if (vars == null || vars.length == 0) {
            return EMPTY;
        }
        if (types == null) {
            types = NO_TYPES;
        }
        int len = vars.length;
        String[] names = new String[len];
        for (int i = 0; i < len; ++i) {
            names[i] = vars[i].getName();
        }
        if (names.length != types.length) {
            throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with " + types.length + " type parameter" + (types.length == 1 ? "" : "s") + ": class expects " + names.length);
        }
        return new TypeBindings(names, types, null);
    }

    public TypeBindings withUnboundVariable(String name) {
        int len = this._unboundVariables == null ? 0 : this._unboundVariables.length;
        String[] names = len == 0 ? new String[1] : (String[])Arrays.copyOf((Object[])this._unboundVariables, (int)(len + 1));
        names[len] = name;
        return new TypeBindings(this._names, this._types, names);
    }

    public TypeBindings withoutVariable(String name) {
        int index = Arrays.asList((Object[])this._names).indexOf((Object)name);
        if (index == -1) {
            return this;
        }
        String[] newNames = (String[])Arrays.copyOf((Object[])this._names, (int)(this._names.length - 1));
        JavaType[] newTypes = (JavaType[])Arrays.copyOf((Object[])this._types, (int)(this._types.length - 1));
        if (index != newNames.length) {
            System.arraycopy((Object)this._names, (int)(index + 1), (Object)newNames, (int)index, (int)(newNames.length - index));
            System.arraycopy((Object)this._types, (int)(index + 1), (Object)newTypes, (int)index, (int)(newTypes.length - index));
        }
        return new TypeBindings(newNames, newTypes, this._unboundVariables);
    }

    public JavaType findBoundType(String name) {
        int len = this._names.length;
        for (int i = 0; i < len; ++i) {
            ResolvedRecursiveType rrt;
            JavaType t2;
            if (!name.equals((Object)this._names[i])) continue;
            JavaType t = this._types[i];
            if (t instanceof ResolvedRecursiveType && (t2 = (rrt = (ResolvedRecursiveType)t).getSelfReferencedType()) != null) {
                t = t2;
            }
            return t;
        }
        return null;
    }

    private boolean invalidCacheKey() {
        for (JavaType type : this._types) {
            if (!(type instanceof IdentityEqualityType)) continue;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this._types.length == 0;
    }

    public int size() {
        return this._types.length;
    }

    public String getBoundName(int index) {
        if (index < 0 || index >= this._names.length) {
            return null;
        }
        return this._names[index];
    }

    public JavaType getBoundType(int index) {
        if (index < 0 || index >= this._types.length) {
            return null;
        }
        return this._types[index];
    }

    public List<JavaType> getTypeParameters() {
        if (this._types.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList((Object[])this._types);
    }

    public boolean hasUnbound(String name) {
        if (this._unboundVariables != null) {
            int i = this._unboundVariables.length;
            while (--i >= 0) {
                if (!name.equals((Object)this._unboundVariables[i])) continue;
                return true;
            }
        }
        return false;
    }

    public Object asKey(Class<?> rawBase) {
        if (this.invalidCacheKey()) {
            return null;
        }
        return new AsKey(rawBase, this._types, this._hashCode);
    }

    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int len = this._types.length;
        for (int i = 0; i < len; ++i) {
            if (i > 0) {
                sb.append(',');
            }
            String sig = this._types[i].getGenericSignature();
            sb.append(sig);
        }
        sb.append('>');
        return sb.toString();
    }

    public int hashCode() {
        return this._hashCode;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, this.getClass())) {
            return false;
        }
        TypeBindings other = (TypeBindings)o;
        return this._hashCode == other._hashCode && Arrays.equals((Object[])this._types, (Object[])other._types);
    }

    protected JavaType[] typeParameterArray() {
        return this._types;
    }

    static final class AsKey {
        private final Class<?> _raw;
        private final JavaType[] _params;
        private final int _hash;

        public AsKey(Class<?> raw, JavaType[] params, int hash) {
            this._raw = raw;
            this._params = params;
            this._hash = 31 * raw.hashCode() + hash;
        }

        public int hashCode() {
            return this._hash;
        }

        public boolean equals(Object o) {
            JavaType[] otherParams;
            int len;
            if (o == this) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (o.getClass() != this.getClass()) {
                return false;
            }
            AsKey other = (AsKey)o;
            if (this._hash == other._hash && this._raw == other._raw && (len = this._params.length) == (otherParams = other._params).length) {
                for (int i = 0; i < len; ++i) {
                    if (this._params[i].equals(otherParams[i])) continue;
                    return false;
                }
                return true;
            }
            return false;
        }

        public String toString() {
            return this._raw.getName() + "<>";
        }
    }

    static class TypeParamStash {
        private static final TypeVariable<?>[] VARS_ABSTRACT_LIST = AbstractList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_COLLECTION = Collection.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ITERABLE = Iterable.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LIST = List.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ARRAY_LIST = ArrayList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_MAP = Map.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_HASH_MAP = HashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LINKED_HASH_MAP = LinkedHashMap.class.getTypeParameters();

        TypeParamStash() {
        }

        public static TypeVariable<?>[] paramsFor1(Class<?> erasedType) {
            if (erasedType == Collection.class) {
                return VARS_COLLECTION;
            }
            if (erasedType == List.class) {
                return VARS_LIST;
            }
            if (erasedType == ArrayList.class) {
                return VARS_ARRAY_LIST;
            }
            if (erasedType == AbstractList.class) {
                return VARS_ABSTRACT_LIST;
            }
            if (erasedType == Iterable.class) {
                return VARS_ITERABLE;
            }
            return erasedType.getTypeParameters();
        }

        public static TypeVariable<?>[] paramsFor2(Class<?> erasedType) {
            if (erasedType == Map.class) {
                return VARS_MAP;
            }
            if (erasedType == HashMap.class) {
                return VARS_HASH_MAP;
            }
            if (erasedType == LinkedHashMap.class) {
                return VARS_LINKED_HASH_MAP;
            }
            return erasedType.getTypeParameters();
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.lang.invoke.MethodType
 *  java.util.Collection
 *  java.util.Collections
 *  jdk.dynalink.linker.GuardedInvocation
 *  jdk.dynalink.linker.LinkRequest
 */
package org.openjdk.nashorn.internal.objects;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Collection;
import java.util.Collections;
import jdk.dynalink.linker.GuardedInvocation;
import jdk.dynalink.linker.LinkRequest;
import org.openjdk.nashorn.internal.lookup.Lookup;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.linker.PrimitiveLookup;

public final class NativeBoolean
extends ScriptObject {
    private final boolean value;
    static final MethodHandle WRAPFILTER = NativeBoolean.findOwnMH("wrapFilter", Lookup.MH.type(NativeBoolean.class, Object.class));
    private static final MethodHandle PROTOFILTER = NativeBoolean.findOwnMH("protoFilter", Lookup.MH.type(Object.class, Object.class));
    private static PropertyMap $nasgenmap$;

    private NativeBoolean(boolean value, ScriptObject proto, PropertyMap map) {
        super(proto, map);
        this.value = value;
    }

    NativeBoolean(boolean flag, Global global) {
        this(flag, global.getBooleanPrototype(), $nasgenmap$);
    }

    NativeBoolean(boolean flag) {
        this(flag, Global.instance());
    }

    @Override
    public String safeToString() {
        return "[Boolean " + this.toString() + "]";
    }

    public String toString() {
        return Boolean.toString((boolean)this.getValue());
    }

    public boolean getValue() {
        return this.booleanValue();
    }

    public boolean booleanValue() {
        return this.value;
    }

    @Override
    public String getClassName() {
        return "Boolean";
    }

    public static String toString(Object self) {
        return NativeBoolean.getBoolean(self).toString();
    }

    public static boolean valueOf(Object self) {
        return NativeBoolean.getBoolean(self);
    }

    public static Object constructor(boolean newObj, Object self, Object value) {
        boolean flag = JSType.toBoolean(value);
        if (newObj) {
            return new NativeBoolean(flag);
        }
        return flag;
    }

    private static Boolean getBoolean(Object self) {
        if (self instanceof Boolean) {
            return (Boolean)self;
        }
        if (self instanceof NativeBoolean) {
            return ((NativeBoolean)self).getValue();
        }
        if (self != null && self == Global.instance().getBooleanPrototype()) {
            return false;
        }
        throw ECMAErrors.typeError("not.a.boolean", ScriptRuntime.safeToString(self));
    }

    public static GuardedInvocation lookupPrimitive(LinkRequest request, Object receiver) {
        return PrimitiveLookup.lookupPrimitive(request, Boolean.class, (ScriptObject)new NativeBoolean((Boolean)receiver), WRAPFILTER, PROTOFILTER);
    }

    private static NativeBoolean wrapFilter(Object receiver) {
        return new NativeBoolean((Boolean)receiver);
    }

    private static Object protoFilter(Object object) {
        return Global.instance().getBooleanPrototype();
    }

    private static MethodHandle findOwnMH(String name, MethodType type) {
        return Lookup.MH.findStatic(MethodHandles.lookup(), NativeBoolean.class, name, type);
    }

    static {
        NativeBoolean.$clinit$();
    }

    public static void $clinit$() {
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)Collections.EMPTY_LIST);
    }
}


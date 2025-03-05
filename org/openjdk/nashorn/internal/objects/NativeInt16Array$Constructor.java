/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.lang.invoke.MethodType
 *  java.util.ArrayList
 *  java.util.Collection
 */
package org.openjdk.nashorn.internal.objects;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Collection;
import org.openjdk.nashorn.internal.objects.NativeInt16Array;
import org.openjdk.nashorn.internal.objects.NativeInt16Array$Prototype;
import org.openjdk.nashorn.internal.runtime.AccessorProperty;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.PrototypeObject;
import org.openjdk.nashorn.internal.runtime.ScriptFunction;

final class NativeInt16Array$Constructor
extends ScriptFunction {
    private static final PropertyMap $nasgenmap$;

    public int G$BYTES_PER_ELEMENT() {
        return NativeInt16Array.BYTES_PER_ELEMENT;
    }

    static {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((Object)AccessorProperty.create("BYTES_PER_ELEMENT", 7, cfr_ldc_0(), null));
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)arrayList);
    }

    NativeInt16Array$Constructor() {
        super("Int16Array", cfr_ldc_1(), $nasgenmap$, null);
        NativeInt16Array$Prototype nativeInt16Array$Prototype = new NativeInt16Array$Prototype();
        PrototypeObject.setConstructor(nativeInt16Array$Prototype, this);
        this.setPrototype(nativeInt16Array$Prototype);
        this.setArity(1);
        this.setDocumentationKey("Int16Array");
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_0() {
        try {
            return MethodHandles.lookup().findVirtual(NativeInt16Array$Constructor.class, "G$BYTES_PER_ELEMENT", MethodType.fromMethodDescriptorString("()I", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_1() {
        try {
            return MethodHandles.lookup().findStatic(NativeInt16Array.class, "constructor", MethodType.fromMethodDescriptorString("(ZLjava/lang/Object;[Ljava/lang/Object;)Lorg/openjdk/nashorn/internal/objects/NativeInt16Array;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }
}


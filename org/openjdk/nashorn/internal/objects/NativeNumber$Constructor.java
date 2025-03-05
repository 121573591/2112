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
import org.openjdk.nashorn.internal.objects.NativeNumber;
import org.openjdk.nashorn.internal.objects.NativeNumber$Prototype;
import org.openjdk.nashorn.internal.runtime.AccessorProperty;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.PrototypeObject;
import org.openjdk.nashorn.internal.runtime.ScriptFunction;

final class NativeNumber$Constructor
extends ScriptFunction {
    private static final PropertyMap $nasgenmap$;

    public double G$MAX_VALUE() {
        return NativeNumber.MAX_VALUE;
    }

    public double G$MIN_VALUE() {
        return NativeNumber.MIN_VALUE;
    }

    public double G$NaN() {
        return NativeNumber.NaN;
    }

    public double G$NEGATIVE_INFINITY() {
        return NativeNumber.NEGATIVE_INFINITY;
    }

    public double G$POSITIVE_INFINITY() {
        return NativeNumber.POSITIVE_INFINITY;
    }

    static {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add((Object)AccessorProperty.create("MAX_VALUE", 7, cfr_ldc_0(), null));
        arrayList.add((Object)AccessorProperty.create("MIN_VALUE", 7, cfr_ldc_1(), null));
        arrayList.add((Object)AccessorProperty.create("NaN", 7, cfr_ldc_2(), null));
        arrayList.add((Object)AccessorProperty.create("NEGATIVE_INFINITY", 7, cfr_ldc_3(), null));
        arrayList.add((Object)AccessorProperty.create("POSITIVE_INFINITY", 7, cfr_ldc_4(), null));
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)arrayList);
    }

    NativeNumber$Constructor() {
        super("Number", cfr_ldc_5(), $nasgenmap$, null);
        NativeNumber$Prototype nativeNumber$Prototype = new NativeNumber$Prototype();
        PrototypeObject.setConstructor(nativeNumber$Prototype, this);
        this.setPrototype(nativeNumber$Prototype);
        this.setArity(1);
        this.setDocumentationKey("Number");
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_0() {
        try {
            return MethodHandles.lookup().findVirtual(NativeNumber$Constructor.class, "G$MAX_VALUE", MethodType.fromMethodDescriptorString("()D", null));
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
            return MethodHandles.lookup().findVirtual(NativeNumber$Constructor.class, "G$MIN_VALUE", MethodType.fromMethodDescriptorString("()D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_2() {
        try {
            return MethodHandles.lookup().findVirtual(NativeNumber$Constructor.class, "G$NaN", MethodType.fromMethodDescriptorString("()D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_3() {
        try {
            return MethodHandles.lookup().findVirtual(NativeNumber$Constructor.class, "G$NEGATIVE_INFINITY", MethodType.fromMethodDescriptorString("()D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_4() {
        try {
            return MethodHandles.lookup().findVirtual(NativeNumber$Constructor.class, "G$POSITIVE_INFINITY", MethodType.fromMethodDescriptorString("()D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_5() {
        try {
            return MethodHandles.lookup().findStatic(NativeNumber.class, "constructor", MethodType.fromMethodDescriptorString("(ZLjava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }
}


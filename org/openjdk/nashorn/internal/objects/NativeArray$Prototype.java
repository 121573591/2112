/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
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
import org.openjdk.nashorn.internal.objects.NativeArray;
import org.openjdk.nashorn.internal.objects.NativeSymbol;
import org.openjdk.nashorn.internal.runtime.AccessorProperty;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.PrototypeObject;
import org.openjdk.nashorn.internal.runtime.ScriptFunction;
import org.openjdk.nashorn.internal.runtime.Specialization;

final class NativeArray$Prototype
extends PrototypeObject {
    private Object toString;
    private Object assertNumeric;
    private Object toLocaleString;
    private Object concat;
    private Object join;
    private Object pop;
    private Object push;
    private Object reverse;
    private Object shift;
    private Object slice;
    private Object sort;
    private Object splice;
    private Object unshift;
    private Object indexOf;
    private Object lastIndexOf;
    private Object every;
    private Object some;
    private Object forEach;
    private Object map;
    private Object filter;
    private Object reduce;
    private Object reduceRight;
    private Object entries;
    private Object keys;
    private Object values;
    private Object getIterator;
    private static final PropertyMap $nasgenmap$;

    public Object G$toString() {
        return this.toString;
    }

    public void S$toString(Object object) {
        this.toString = object;
    }

    public Object G$assertNumeric() {
        return this.assertNumeric;
    }

    public void S$assertNumeric(Object object) {
        this.assertNumeric = object;
    }

    public Object G$toLocaleString() {
        return this.toLocaleString;
    }

    public void S$toLocaleString(Object object) {
        this.toLocaleString = object;
    }

    public Object G$concat() {
        return this.concat;
    }

    public void S$concat(Object object) {
        this.concat = object;
    }

    public Object G$join() {
        return this.join;
    }

    public void S$join(Object object) {
        this.join = object;
    }

    public Object G$pop() {
        return this.pop;
    }

    public void S$pop(Object object) {
        this.pop = object;
    }

    public Object G$push() {
        return this.push;
    }

    public void S$push(Object object) {
        this.push = object;
    }

    public Object G$reverse() {
        return this.reverse;
    }

    public void S$reverse(Object object) {
        this.reverse = object;
    }

    public Object G$shift() {
        return this.shift;
    }

    public void S$shift(Object object) {
        this.shift = object;
    }

    public Object G$slice() {
        return this.slice;
    }

    public void S$slice(Object object) {
        this.slice = object;
    }

    public Object G$sort() {
        return this.sort;
    }

    public void S$sort(Object object) {
        this.sort = object;
    }

    public Object G$splice() {
        return this.splice;
    }

    public void S$splice(Object object) {
        this.splice = object;
    }

    public Object G$unshift() {
        return this.unshift;
    }

    public void S$unshift(Object object) {
        this.unshift = object;
    }

    public Object G$indexOf() {
        return this.indexOf;
    }

    public void S$indexOf(Object object) {
        this.indexOf = object;
    }

    public Object G$lastIndexOf() {
        return this.lastIndexOf;
    }

    public void S$lastIndexOf(Object object) {
        this.lastIndexOf = object;
    }

    public Object G$every() {
        return this.every;
    }

    public void S$every(Object object) {
        this.every = object;
    }

    public Object G$some() {
        return this.some;
    }

    public void S$some(Object object) {
        this.some = object;
    }

    public Object G$forEach() {
        return this.forEach;
    }

    public void S$forEach(Object object) {
        this.forEach = object;
    }

    public Object G$map() {
        return this.map;
    }

    public void S$map(Object object) {
        this.map = object;
    }

    public Object G$filter() {
        return this.filter;
    }

    public void S$filter(Object object) {
        this.filter = object;
    }

    public Object G$reduce() {
        return this.reduce;
    }

    public void S$reduce(Object object) {
        this.reduce = object;
    }

    public Object G$reduceRight() {
        return this.reduceRight;
    }

    public void S$reduceRight(Object object) {
        this.reduceRight = object;
    }

    public Object G$entries() {
        return this.entries;
    }

    public void S$entries(Object object) {
        this.entries = object;
    }

    public Object G$keys() {
        return this.keys;
    }

    public void S$keys(Object object) {
        this.keys = object;
    }

    public Object G$values() {
        return this.values;
    }

    public void S$values(Object object) {
        this.values = object;
    }

    public Object G$getIterator() {
        return this.getIterator;
    }

    public void S$getIterator(Object object) {
        this.getIterator = object;
    }

    static {
        ArrayList arrayList = new ArrayList(27);
        arrayList.add((Object)AccessorProperty.create("length", 6, cfr_ldc_0(), cfr_ldc_1()));
        arrayList.add((Object)AccessorProperty.create("toString", 2, cfr_ldc_2(), cfr_ldc_3()));
        arrayList.add((Object)AccessorProperty.create("assertNumeric", 2, cfr_ldc_4(), cfr_ldc_5()));
        arrayList.add((Object)AccessorProperty.create("toLocaleString", 2, cfr_ldc_6(), cfr_ldc_7()));
        arrayList.add((Object)AccessorProperty.create("concat", 2, cfr_ldc_8(), cfr_ldc_9()));
        arrayList.add((Object)AccessorProperty.create("join", 2, cfr_ldc_10(), cfr_ldc_11()));
        arrayList.add((Object)AccessorProperty.create("pop", 2, cfr_ldc_12(), cfr_ldc_13()));
        arrayList.add((Object)AccessorProperty.create("push", 2, cfr_ldc_14(), cfr_ldc_15()));
        arrayList.add((Object)AccessorProperty.create("reverse", 2, cfr_ldc_16(), cfr_ldc_17()));
        arrayList.add((Object)AccessorProperty.create("shift", 2, cfr_ldc_18(), cfr_ldc_19()));
        arrayList.add((Object)AccessorProperty.create("slice", 2, cfr_ldc_20(), cfr_ldc_21()));
        arrayList.add((Object)AccessorProperty.create("sort", 2, cfr_ldc_22(), cfr_ldc_23()));
        arrayList.add((Object)AccessorProperty.create("splice", 2, cfr_ldc_24(), cfr_ldc_25()));
        arrayList.add((Object)AccessorProperty.create("unshift", 2, cfr_ldc_26(), cfr_ldc_27()));
        arrayList.add((Object)AccessorProperty.create("indexOf", 2, cfr_ldc_28(), cfr_ldc_29()));
        arrayList.add((Object)AccessorProperty.create("lastIndexOf", 2, cfr_ldc_30(), cfr_ldc_31()));
        arrayList.add((Object)AccessorProperty.create("every", 2, cfr_ldc_32(), cfr_ldc_33()));
        arrayList.add((Object)AccessorProperty.create("some", 2, cfr_ldc_34(), cfr_ldc_35()));
        arrayList.add((Object)AccessorProperty.create("forEach", 2, cfr_ldc_36(), cfr_ldc_37()));
        arrayList.add((Object)AccessorProperty.create("map", 2, cfr_ldc_38(), cfr_ldc_39()));
        arrayList.add((Object)AccessorProperty.create("filter", 2, cfr_ldc_40(), cfr_ldc_41()));
        arrayList.add((Object)AccessorProperty.create("reduce", 2, cfr_ldc_42(), cfr_ldc_43()));
        arrayList.add((Object)AccessorProperty.create("reduceRight", 2, cfr_ldc_44(), cfr_ldc_45()));
        arrayList.add((Object)AccessorProperty.create("entries", 2, cfr_ldc_46(), cfr_ldc_47()));
        arrayList.add((Object)AccessorProperty.create("keys", 2, cfr_ldc_48(), cfr_ldc_49()));
        arrayList.add((Object)AccessorProperty.create("values", 2, cfr_ldc_50(), cfr_ldc_51()));
        arrayList.add((Object)AccessorProperty.create(NativeSymbol.iterator, 2, cfr_ldc_52(), cfr_ldc_53()));
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)arrayList);
    }

    NativeArray$Prototype() {
        super($nasgenmap$);
        ScriptFunction scriptFunction = ScriptFunction.createBuiltin("toString", cfr_ldc_54());
        scriptFunction.setDocumentationKey("Array.prototype.toString");
        this.toString = scriptFunction;
        ScriptFunction scriptFunction2 = ScriptFunction.createBuiltin("assertNumeric", cfr_ldc_55());
        scriptFunction2.setDocumentationKey("Array.prototype.assertNumeric");
        this.assertNumeric = scriptFunction2;
        ScriptFunction scriptFunction3 = ScriptFunction.createBuiltin("toLocaleString", cfr_ldc_56());
        scriptFunction3.setDocumentationKey("Array.prototype.toLocaleString");
        this.toLocaleString = scriptFunction3;
        ScriptFunction scriptFunction4 = ScriptFunction.createBuiltin("concat", cfr_ldc_57(), new Specialization[]{new Specialization(cfr_ldc_58(), NativeArray.ConcatLinkLogic.class, false, false), new Specialization(cfr_ldc_59(), NativeArray.ConcatLinkLogic.class, false, false), new Specialization(cfr_ldc_60(), NativeArray.ConcatLinkLogic.class, false, false)});
        scriptFunction4.setArity(1);
        scriptFunction4.setDocumentationKey("Array.prototype.concat");
        this.concat = scriptFunction4;
        ScriptFunction scriptFunction5 = ScriptFunction.createBuiltin("join", cfr_ldc_61());
        scriptFunction5.setDocumentationKey("Array.prototype.join");
        this.join = scriptFunction5;
        ScriptFunction scriptFunction6 = ScriptFunction.createBuiltin("pop", cfr_ldc_62(), new Specialization[]{new Specialization(cfr_ldc_63(), NativeArray.PopLinkLogic.class, false, false), new Specialization(cfr_ldc_64(), NativeArray.PopLinkLogic.class, false, false), new Specialization(cfr_ldc_65(), NativeArray.PopLinkLogic.class, false, false)});
        scriptFunction6.setDocumentationKey("Array.prototype.pop");
        this.pop = scriptFunction6;
        ScriptFunction scriptFunction7 = ScriptFunction.createBuiltin("push", cfr_ldc_66(), new Specialization[]{new Specialization(cfr_ldc_67(), NativeArray.PushLinkLogic.class, false, false), new Specialization(cfr_ldc_68(), NativeArray.PushLinkLogic.class, false, false), new Specialization(cfr_ldc_69(), NativeArray.PushLinkLogic.class, false, false), new Specialization(cfr_ldc_70(), false, false)});
        scriptFunction7.setArity(1);
        scriptFunction7.setDocumentationKey("Array.prototype.push");
        this.push = scriptFunction7;
        ScriptFunction scriptFunction8 = ScriptFunction.createBuiltin("reverse", cfr_ldc_71());
        scriptFunction8.setDocumentationKey("Array.prototype.reverse");
        this.reverse = scriptFunction8;
        ScriptFunction scriptFunction9 = ScriptFunction.createBuiltin("shift", cfr_ldc_72());
        scriptFunction9.setDocumentationKey("Array.prototype.shift");
        this.shift = scriptFunction9;
        ScriptFunction scriptFunction10 = ScriptFunction.createBuiltin("slice", cfr_ldc_73());
        scriptFunction10.setDocumentationKey("Array.prototype.slice");
        this.slice = scriptFunction10;
        ScriptFunction scriptFunction11 = ScriptFunction.createBuiltin("sort", cfr_ldc_74());
        scriptFunction11.setDocumentationKey("Array.prototype.sort");
        this.sort = scriptFunction11;
        ScriptFunction scriptFunction12 = ScriptFunction.createBuiltin("splice", cfr_ldc_75());
        scriptFunction12.setArity(2);
        scriptFunction12.setDocumentationKey("Array.prototype.splice");
        this.splice = scriptFunction12;
        ScriptFunction scriptFunction13 = ScriptFunction.createBuiltin("unshift", cfr_ldc_76());
        scriptFunction13.setArity(1);
        scriptFunction13.setDocumentationKey("Array.prototype.unshift");
        this.unshift = scriptFunction13;
        ScriptFunction scriptFunction14 = ScriptFunction.createBuiltin("indexOf", cfr_ldc_77());
        scriptFunction14.setArity(1);
        scriptFunction14.setDocumentationKey("Array.prototype.indexOf");
        this.indexOf = scriptFunction14;
        ScriptFunction scriptFunction15 = ScriptFunction.createBuiltin("lastIndexOf", cfr_ldc_78());
        scriptFunction15.setArity(1);
        scriptFunction15.setDocumentationKey("Array.prototype.lastIndexOf");
        this.lastIndexOf = scriptFunction15;
        ScriptFunction scriptFunction16 = ScriptFunction.createBuiltin("every", cfr_ldc_79());
        scriptFunction16.setArity(1);
        scriptFunction16.setDocumentationKey("Array.prototype.every");
        this.every = scriptFunction16;
        ScriptFunction scriptFunction17 = ScriptFunction.createBuiltin("some", cfr_ldc_80());
        scriptFunction17.setArity(1);
        scriptFunction17.setDocumentationKey("Array.prototype.some");
        this.some = scriptFunction17;
        ScriptFunction scriptFunction18 = ScriptFunction.createBuiltin("forEach", cfr_ldc_81());
        scriptFunction18.setArity(1);
        scriptFunction18.setDocumentationKey("Array.prototype.forEach");
        this.forEach = scriptFunction18;
        ScriptFunction scriptFunction19 = ScriptFunction.createBuiltin("map", cfr_ldc_82());
        scriptFunction19.setArity(1);
        scriptFunction19.setDocumentationKey("Array.prototype.map");
        this.map = scriptFunction19;
        ScriptFunction scriptFunction20 = ScriptFunction.createBuiltin("filter", cfr_ldc_83());
        scriptFunction20.setArity(1);
        scriptFunction20.setDocumentationKey("Array.prototype.filter");
        this.filter = scriptFunction20;
        ScriptFunction scriptFunction21 = ScriptFunction.createBuiltin("reduce", cfr_ldc_84());
        scriptFunction21.setArity(1);
        scriptFunction21.setDocumentationKey("Array.prototype.reduce");
        this.reduce = scriptFunction21;
        ScriptFunction scriptFunction22 = ScriptFunction.createBuiltin("reduceRight", cfr_ldc_85());
        scriptFunction22.setArity(1);
        scriptFunction22.setDocumentationKey("Array.prototype.reduceRight");
        this.reduceRight = scriptFunction22;
        ScriptFunction scriptFunction23 = ScriptFunction.createBuiltin("entries", cfr_ldc_86());
        scriptFunction23.setDocumentationKey("Array.prototype.entries");
        this.entries = scriptFunction23;
        ScriptFunction scriptFunction24 = ScriptFunction.createBuiltin("keys", cfr_ldc_87());
        scriptFunction24.setDocumentationKey("Array.prototype.keys");
        this.keys = scriptFunction24;
        ScriptFunction scriptFunction25 = ScriptFunction.createBuiltin("values", cfr_ldc_88());
        scriptFunction25.setDocumentationKey("Array.prototype.values");
        this.values = scriptFunction25;
        ScriptFunction scriptFunction26 = ScriptFunction.createBuiltin("Symbol[iterator]", cfr_ldc_89());
        scriptFunction26.setDocumentationKey("Array.prototype.@@iterator");
        this.getIterator = scriptFunction26;
    }

    @Override
    public String getClassName() {
        return "Array";
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_0() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "getProtoLength", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
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
            return MethodHandles.lookup().findStatic(NativeArray.class, "setProtoLength", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;)V", null));
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
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$toString", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
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
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$toString", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
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
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$assertNumeric", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
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
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$assertNumeric", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_6() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$toLocaleString", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_7() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$toLocaleString", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_8() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$concat", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_9() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$concat", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_10() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$join", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_11() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$join", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_12() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$pop", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_13() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$pop", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_14() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$push", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_15() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$push", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_16() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$reverse", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_17() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$reverse", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_18() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$shift", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_19() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$shift", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_20() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$slice", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_21() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$slice", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_22() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$sort", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_23() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$sort", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_24() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$splice", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_25() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$splice", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_26() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$unshift", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_27() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$unshift", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_28() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$indexOf", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_29() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$indexOf", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_30() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$lastIndexOf", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_31() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$lastIndexOf", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_32() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$every", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_33() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$every", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_34() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$some", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_35() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$some", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_36() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$forEach", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_37() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$forEach", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_38() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$map", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_39() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$map", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_40() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$filter", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_41() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$filter", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_42() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$reduce", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_43() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$reduce", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_44() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$reduceRight", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_45() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$reduceRight", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_46() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$entries", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_47() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$entries", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_48() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$keys", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_49() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$keys", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_50() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$values", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_51() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$values", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_52() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "G$getIterator", MethodType.fromMethodDescriptorString("()Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_53() {
        try {
            return MethodHandles.lookup().findVirtual(NativeArray$Prototype.class, "S$getIterator", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)V", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_54() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "toString", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_55() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "assertNumeric", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_56() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "toLocaleString", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/String;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_57() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "concat", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)Lorg/openjdk/nashorn/internal/objects/NativeArray;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_58() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "concat", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;I)Lorg/openjdk/nashorn/internal/objects/NativeArray;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_59() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "concat", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;D)Lorg/openjdk/nashorn/internal/objects/NativeArray;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_60() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "concat", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;)Lorg/openjdk/nashorn/internal/objects/NativeArray;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_61() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "join", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_62() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "pop", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_63() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "popInt", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_64() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "popDouble", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_65() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "popObject", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_66() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "push", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_67() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "push", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;I)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_68() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "push", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;D)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_69() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "pushObject", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_70() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "push", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_71() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "reverse", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_72() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "shift", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_73() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "slice", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_74() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "sort", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;)Lorg/openjdk/nashorn/internal/runtime/ScriptObject;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_75() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "splice", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_76() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "unshift", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_77() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "indexOf", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_78() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "lastIndexOf", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)D", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_79() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "every", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_80() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "some", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_81() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "forEach", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_82() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "map", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/openjdk/nashorn/internal/objects/NativeArray;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_83() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "filter", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/openjdk/nashorn/internal/objects/NativeArray;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_84() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "reduce", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_85() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "reduceRight", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_86() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "entries", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_87() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "keys", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_88() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "values", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_89() {
        try {
            return MethodHandles.lookup().findStatic(NativeArray.class, "getIterator", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)Ljava/lang/Object;", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }
}


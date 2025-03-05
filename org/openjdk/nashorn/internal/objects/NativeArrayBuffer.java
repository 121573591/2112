/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.lang.invoke.MethodType
 *  java.nio.ByteBuffer
 *  java.util.ArrayList
 *  java.util.Collection
 */
package org.openjdk.nashorn.internal.objects;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import org.openjdk.nashorn.internal.objects.ArrayBufferView;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.runtime.AccessorProperty;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.Property;
import org.openjdk.nashorn.internal.runtime.PropertyMap;
import org.openjdk.nashorn.internal.runtime.ScriptObject;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;

public final class NativeArrayBuffer
extends ScriptObject {
    private final ByteBuffer nb;
    private static PropertyMap $nasgenmap$;

    protected NativeArrayBuffer(ByteBuffer nb, Global global) {
        super(global.getArrayBufferPrototype(), $nasgenmap$);
        this.nb = nb;
    }

    protected NativeArrayBuffer(ByteBuffer nb) {
        this(nb, Global.instance());
    }

    protected NativeArrayBuffer(int byteLength) {
        this(ByteBuffer.allocateDirect((int)byteLength));
    }

    protected NativeArrayBuffer(NativeArrayBuffer other, int begin, int end) {
        this(NativeArrayBuffer.cloneBuffer(other.getNioBuffer(), begin, end));
    }

    public static NativeArrayBuffer constructor(boolean newObj, Object self, Object ... args) {
        if (!newObj) {
            throw ECMAErrors.typeError("constructor.requires.new", "ArrayBuffer");
        }
        if (args.length == 0) {
            return new NativeArrayBuffer(0);
        }
        Object arg0 = args[0];
        if (arg0 instanceof ByteBuffer) {
            return new NativeArrayBuffer((ByteBuffer)arg0);
        }
        return new NativeArrayBuffer(JSType.toInt32(arg0));
    }

    private static ByteBuffer cloneBuffer(ByteBuffer original, int begin, int end) {
        ByteBuffer clone = ByteBuffer.allocateDirect((int)original.capacity());
        original.rewind();
        clone.put(original);
        original.rewind();
        clone.flip();
        clone.position(begin);
        clone.limit(end);
        return clone.slice();
    }

    ByteBuffer getNioBuffer() {
        return this.nb;
    }

    @Override
    public String getClassName() {
        return "ArrayBuffer";
    }

    public static int byteLength(Object self) {
        return ((NativeArrayBuffer)self).getByteLength();
    }

    public static boolean isView(Object self, Object obj) {
        return obj instanceof ArrayBufferView;
    }

    public static NativeArrayBuffer slice(Object self, Object begin0, Object end0) {
        NativeArrayBuffer arrayBuffer = (NativeArrayBuffer)self;
        int byteLength = arrayBuffer.getByteLength();
        int begin = NativeArrayBuffer.adjustIndex(JSType.toInt32(begin0), byteLength);
        int end = NativeArrayBuffer.adjustIndex(end0 != ScriptRuntime.UNDEFINED ? JSType.toInt32(end0) : byteLength, byteLength);
        return new NativeArrayBuffer(arrayBuffer, begin, Math.max((int)end, (int)begin));
    }

    public static Object slice(Object self, int begin, int end) {
        NativeArrayBuffer arrayBuffer = (NativeArrayBuffer)self;
        int byteLength = arrayBuffer.getByteLength();
        return new NativeArrayBuffer(arrayBuffer, NativeArrayBuffer.adjustIndex(begin, byteLength), Math.max((int)NativeArrayBuffer.adjustIndex(end, byteLength), (int)begin));
    }

    public static Object slice(Object self, int begin) {
        return NativeArrayBuffer.slice(self, begin, ((NativeArrayBuffer)self).getByteLength());
    }

    static int adjustIndex(int index, int length) {
        return index < 0 ? NativeArrayBuffer.clamp(index + length, length) : NativeArrayBuffer.clamp(index, length);
    }

    private static int clamp(int index, int length) {
        if (index < 0) {
            return 0;
        }
        if (index > length) {
            return length;
        }
        return index;
    }

    int getByteLength() {
        return this.nb.limit();
    }

    ByteBuffer getBuffer() {
        return this.nb;
    }

    ByteBuffer getBuffer(int offset) {
        return this.nb.duplicate().position(offset);
    }

    ByteBuffer getBuffer(int offset, int length) {
        return this.getBuffer(offset).limit(length);
    }

    static {
        NativeArrayBuffer.$clinit$();
    }

    public static void $clinit$() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((Object)AccessorProperty.create("byteLength", 7, cfr_ldc_0(), null));
        $nasgenmap$ = PropertyMap.newMap((Collection<Property>)arrayList);
    }

    /*
     * Works around MethodHandle LDC.
     */
    static MethodHandle cfr_ldc_0() {
        try {
            return MethodHandles.lookup().findStatic(NativeArrayBuffer.class, "byteLength", MethodType.fromMethodDescriptorString("(Ljava/lang/Object;)I", null));
        }
        catch (NoSuchMethodException | IllegalAccessException except) {
            throw new IllegalArgumentException(except);
        }
    }
}


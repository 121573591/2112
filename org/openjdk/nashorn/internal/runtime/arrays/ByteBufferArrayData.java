/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.nio.ByteBuffer
 */
package org.openjdk.nashorn.internal.runtime.arrays;

import java.nio.ByteBuffer;
import org.openjdk.nashorn.internal.objects.Global;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.PropertyDescriptor;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayData;

final class ByteBufferArrayData
extends ArrayData {
    private final ByteBuffer buf;

    ByteBufferArrayData(int length) {
        super(length);
        this.buf = ByteBuffer.allocateDirect((int)length);
    }

    ByteBufferArrayData(ByteBuffer buf) {
        super(buf.capacity());
        this.buf = buf;
    }

    @Override
    public PropertyDescriptor getDescriptor(Global global, int index) {
        return global.newDataDescriptor(this.getObject(index), false, true, true);
    }

    @Override
    public ArrayData copy() {
        throw ByteBufferArrayData.unsupported("copy");
    }

    @Override
    public Object[] asObjectArray() {
        throw ByteBufferArrayData.unsupported("asObjectArray");
    }

    @Override
    public void setLength(long length) {
        throw new UnsupportedOperationException("setLength");
    }

    @Override
    public ArrayData shiftLeft(int by) {
        throw ByteBufferArrayData.unsupported("shiftLeft");
    }

    @Override
    public ArrayData shiftRight(int by) {
        throw ByteBufferArrayData.unsupported("shiftRight");
    }

    @Override
    public ArrayData ensure(long safeIndex) {
        if (safeIndex < (long)this.buf.capacity()) {
            return this;
        }
        throw ByteBufferArrayData.unsupported("ensure");
    }

    @Override
    public ArrayData shrink(long newLength) {
        throw ByteBufferArrayData.unsupported("shrink");
    }

    @Override
    public ArrayData set(int index, Object value, boolean strict) {
        if (value instanceof Number) {
            this.buf.put(index, ((Number)value).byteValue());
            return this;
        }
        throw ECMAErrors.typeError("not.a.number", ScriptRuntime.safeToString(value));
    }

    @Override
    public ArrayData set(int index, int value, boolean strict) {
        this.buf.put(index, (byte)value);
        return this;
    }

    @Override
    public ArrayData set(int index, double value, boolean strict) {
        this.buf.put(index, (byte)value);
        return this;
    }

    @Override
    public int getInt(int index) {
        return 0xFF & this.buf.get(index);
    }

    @Override
    public double getDouble(int index) {
        return 0xFF & this.buf.get(index);
    }

    @Override
    public Object getObject(int index) {
        return 0xFF & this.buf.get(index);
    }

    @Override
    public boolean has(int index) {
        return index > -1 && index < this.buf.capacity();
    }

    @Override
    public boolean canDelete(int index, boolean strict) {
        return false;
    }

    @Override
    public boolean canDelete(long longIndex, boolean strict) {
        return false;
    }

    @Override
    public ArrayData delete(int index) {
        throw ByteBufferArrayData.unsupported("delete");
    }

    @Override
    public ArrayData delete(long fromIndex, long toIndex) {
        throw ByteBufferArrayData.unsupported("delete");
    }

    @Override
    public ArrayData push(boolean strict, Object ... items) {
        throw ByteBufferArrayData.unsupported("push");
    }

    @Override
    public Object pop() {
        throw ByteBufferArrayData.unsupported("pop");
    }

    @Override
    public ArrayData slice(long from, long to) {
        throw ByteBufferArrayData.unsupported("slice");
    }

    @Override
    public ArrayData convert(Class<?> type) {
        throw ByteBufferArrayData.unsupported("convert");
    }

    private static UnsupportedOperationException unsupported(String method) {
        return new UnsupportedOperationException(method);
    }
}


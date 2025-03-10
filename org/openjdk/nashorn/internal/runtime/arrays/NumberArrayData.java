/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.ClassCastException
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.lang.UnsupportedOperationException
 *  java.lang.Void
 *  java.lang.invoke.MethodHandle
 *  java.lang.invoke.MethodHandles
 *  java.util.Arrays
 *  jdk.dynalink.linker.support.TypeUtilities
 */
package org.openjdk.nashorn.internal.runtime.arrays;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import jdk.dynalink.linker.support.TypeUtilities;
import org.openjdk.nashorn.internal.codegen.CompilerConstants;
import org.openjdk.nashorn.internal.lookup.Lookup;
import org.openjdk.nashorn.internal.runtime.JSType;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.ContinuousArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.DeletedRangeArrayFilter;
import org.openjdk.nashorn.internal.runtime.arrays.IntOrLongElements;
import org.openjdk.nashorn.internal.runtime.arrays.NumericElements;
import org.openjdk.nashorn.internal.runtime.arrays.ObjectArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.SparseArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.UndefinedArrayFilter;

final class NumberArrayData
extends ContinuousArrayData
implements NumericElements {
    private double[] array;
    private static final MethodHandle HAS_GET_ELEM = CompilerConstants.specialCall(MethodHandles.lookup(), NumberArrayData.class, "getElem", Double.TYPE, Integer.TYPE).methodHandle();
    private static final MethodHandle SET_ELEM = CompilerConstants.specialCall(MethodHandles.lookup(), NumberArrayData.class, "setElem", Void.TYPE, Integer.TYPE, Double.TYPE).methodHandle();

    NumberArrayData(double[] array, int length) {
        super(length);
        assert (array.length >= length);
        this.array = array;
    }

    @Override
    public final Class<?> getElementType() {
        return Double.TYPE;
    }

    @Override
    public final Class<?> getBoxedElementType() {
        return Double.class;
    }

    @Override
    public final int getElementWeight() {
        return 3;
    }

    @Override
    public final ContinuousArrayData widest(ContinuousArrayData otherData) {
        return otherData instanceof IntOrLongElements ? this : otherData;
    }

    @Override
    public NumberArrayData copy() {
        return new NumberArrayData((double[])this.array.clone(), (int)this.length());
    }

    @Override
    public Object[] asObjectArray() {
        return this.toObjectArray(true);
    }

    private Object[] toObjectArray(boolean trim) {
        assert (this.length() <= (long)this.array.length) : "length exceeds internal array size";
        int len = (int)this.length();
        Object[] oarray = new Object[trim ? len : this.array.length];
        for (int index = 0; index < len; ++index) {
            oarray[index] = this.array[index];
        }
        return oarray;
    }

    @Override
    public Object asArrayOfType(Class<?> componentType) {
        if (componentType == Double.TYPE) {
            int len = (int)this.length();
            return this.array.length == len ? this.array.clone() : (Object)Arrays.copyOf((double[])this.array, (int)len);
        }
        return super.asArrayOfType(componentType);
    }

    private static boolean canWiden(Class<?> type) {
        return TypeUtilities.isWrapperType(type) && type != Boolean.class && type != Character.class;
    }

    @Override
    public ContinuousArrayData convert(Class<?> type) {
        if (!NumberArrayData.canWiden(type)) {
            int len = (int)this.length();
            return new ObjectArrayData(this.toObjectArray(false), len);
        }
        return this;
    }

    @Override
    public ArrayData shiftLeft(int by) {
        if ((long)by >= this.length()) {
            this.shrink(0L);
        } else {
            System.arraycopy((Object)this.array, (int)by, (Object)this.array, (int)0, (int)(this.array.length - by));
        }
        this.setLength(Math.max((long)0L, (long)(this.length() - (long)by)));
        return this;
    }

    @Override
    public ArrayData shiftRight(int by) {
        ArrayData newData = this.ensure((long)by + this.length() - 1L);
        if (newData != this) {
            newData.shiftRight(by);
            return newData;
        }
        System.arraycopy((Object)this.array, (int)0, (Object)this.array, (int)by, (int)(this.array.length - by));
        return this;
    }

    @Override
    public ArrayData ensure(long safeIndex) {
        if (safeIndex >= 131072L) {
            return new SparseArrayData(this, safeIndex + 1L);
        }
        int alen = this.array.length;
        if (safeIndex >= (long)alen) {
            int newLength = ArrayData.nextSize((int)safeIndex);
            this.array = Arrays.copyOf((double[])this.array, (int)newLength);
        }
        if (safeIndex >= this.length()) {
            this.setLength(safeIndex + 1L);
        }
        return this;
    }

    @Override
    public ArrayData shrink(long newLength) {
        Arrays.fill((double[])this.array, (int)((int)newLength), (int)this.array.length, (double)0.0);
        return this;
    }

    @Override
    public ArrayData set(int index, Object value, boolean strict) {
        if (value instanceof Double || value != null && NumberArrayData.canWiden(value.getClass())) {
            return this.set(index, ((Number)value).doubleValue(), strict);
        }
        if (value == ScriptRuntime.UNDEFINED) {
            return new UndefinedArrayFilter(this).set(index, value, strict);
        }
        ArrayData newData = this.convert(value == null ? Object.class : value.getClass());
        return newData.set(index, value, strict);
    }

    @Override
    public ArrayData set(int index, int value, boolean strict) {
        this.array[index] = value;
        this.setLength(Math.max((long)(index + 1), (long)this.length()));
        return this;
    }

    @Override
    public ArrayData set(int index, double value, boolean strict) {
        this.array[index] = value;
        this.setLength(Math.max((long)(index + 1), (long)this.length()));
        return this;
    }

    private double getElem(int index) {
        if (this.has(index)) {
            return this.array[index];
        }
        throw new ClassCastException();
    }

    private void setElem(int index, double elem) {
        if (this.hasRoomFor(index)) {
            this.array[index] = elem;
            return;
        }
        throw new ClassCastException();
    }

    @Override
    public MethodHandle getElementGetter(Class<?> returnType, int programPoint) {
        if (returnType == Integer.TYPE) {
            return null;
        }
        return this.getContinuousElementGetter(HAS_GET_ELEM, returnType, programPoint);
    }

    @Override
    public MethodHandle getElementSetter(Class<?> elementType) {
        return elementType.isPrimitive() ? this.getContinuousElementSetter(Lookup.MH.asType(SET_ELEM, SET_ELEM.type().changeParameterType(2, elementType)), elementType) : null;
    }

    @Override
    public int getInt(int index) {
        return JSType.toInt32(this.array[index]);
    }

    @Override
    public double getDouble(int index) {
        return this.array[index];
    }

    @Override
    public double getDoubleOptimistic(int index, int programPoint) {
        return this.array[index];
    }

    @Override
    public Object getObject(int index) {
        return this.array[index];
    }

    @Override
    public boolean has(int index) {
        return 0 <= index && (long)index < this.length();
    }

    @Override
    public ArrayData delete(int index) {
        return new DeletedRangeArrayFilter(this, index, index);
    }

    @Override
    public ArrayData delete(long fromIndex, long toIndex) {
        return new DeletedRangeArrayFilter(this, fromIndex, toIndex);
    }

    @Override
    public Object pop() {
        int len = (int)this.length();
        if (len == 0) {
            return ScriptRuntime.UNDEFINED;
        }
        int newLength = len - 1;
        double elem = this.array[newLength];
        this.array[newLength] = 0.0;
        this.setLength(newLength);
        return elem;
    }

    @Override
    public ArrayData slice(long from, long to) {
        long start = from < 0L ? from + this.length() : from;
        long newLength = to - start;
        return new NumberArrayData(Arrays.copyOfRange((double[])this.array, (int)((int)from), (int)((int)to)), (int)newLength);
    }

    @Override
    public ArrayData fastSplice(int start, int removed, int added) throws UnsupportedOperationException {
        ArrayData returnValue;
        long oldLength = this.length();
        long newLength = oldLength - (long)removed + (long)added;
        if (newLength > 131072L && newLength > (long)this.array.length) {
            throw new UnsupportedOperationException();
        }
        ArrayData arrayData = returnValue = removed == 0 ? EMPTY_ARRAY : new NumberArrayData(Arrays.copyOfRange((double[])this.array, (int)start, (int)(start + removed)), removed);
        if (newLength != oldLength) {
            double[] newArray;
            if (newLength > (long)this.array.length) {
                newArray = new double[ArrayData.nextSize((int)newLength)];
                System.arraycopy((Object)this.array, (int)0, (Object)newArray, (int)0, (int)start);
            } else {
                newArray = this.array;
            }
            System.arraycopy((Object)this.array, (int)(start + removed), (Object)newArray, (int)(start + added), (int)((int)(oldLength - (long)start - (long)removed)));
            this.array = newArray;
            this.setLength(newLength);
        }
        return returnValue;
    }

    @Override
    public double fastPush(int arg) {
        return this.fastPush((double)arg);
    }

    @Override
    public double fastPush(long arg) {
        return this.fastPush((double)arg);
    }

    @Override
    public double fastPush(double arg) {
        int len = (int)this.length();
        if (len == this.array.length) {
            this.array = Arrays.copyOf((double[])this.array, (int)NumberArrayData.nextSize(len));
        }
        this.array[len] = arg;
        return this.increaseLength();
    }

    @Override
    public double fastPopDouble() {
        if (this.length() == 0L) {
            throw new ClassCastException();
        }
        int newLength = (int)this.decreaseLength();
        double elem = this.array[newLength];
        this.array[newLength] = 0.0;
        return elem;
    }

    @Override
    public Object fastPopObject() {
        return this.fastPopDouble();
    }

    @Override
    public ContinuousArrayData fastConcat(ContinuousArrayData otherData) {
        int otherLength = (int)otherData.length();
        int thisLength = (int)this.length();
        assert (otherLength > 0 && thisLength > 0);
        double[] otherArray = ((NumberArrayData)otherData).array;
        int newLength = otherLength + thisLength;
        double[] newArray = new double[ArrayData.alignUp(newLength)];
        System.arraycopy((Object)this.array, (int)0, (Object)newArray, (int)0, (int)thisLength);
        System.arraycopy((Object)otherArray, (int)0, (Object)newArray, (int)thisLength, (int)otherLength);
        return new NumberArrayData(newArray, newLength);
    }

    public String toString() {
        assert (this.length() <= (long)this.array.length) : this.length() + " > " + this.array.length;
        return this.getClass().getSimpleName() + ":" + Arrays.toString((double[])Arrays.copyOf((double[])this.array, (int)((int)this.length())));
    }
}


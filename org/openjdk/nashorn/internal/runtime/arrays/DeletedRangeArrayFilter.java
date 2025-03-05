/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.reflect.Array
 */
package org.openjdk.nashorn.internal.runtime.arrays;

import java.lang.reflect.Array;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayData;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayFilter;
import org.openjdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.openjdk.nashorn.internal.runtime.arrays.DeletedArrayFilter;
import org.openjdk.nashorn.internal.runtime.arrays.SparseArrayData;

final class DeletedRangeArrayFilter
extends ArrayFilter {
    private long lo;
    private long hi;

    DeletedRangeArrayFilter(ArrayData underlying, long lo, long hi) {
        super(DeletedRangeArrayFilter.maybeSparse(underlying, hi));
        this.lo = lo;
        this.hi = hi;
    }

    private static ArrayData maybeSparse(ArrayData underlying, long hi) {
        if (hi < 131072L || underlying instanceof SparseArrayData) {
            return underlying;
        }
        return new SparseArrayData(underlying, underlying.length());
    }

    private boolean isEmpty() {
        return this.lo > this.hi;
    }

    private boolean isDeleted(int index) {
        long longIndex = ArrayIndex.toLongIndex(index);
        return this.lo <= longIndex && longIndex <= this.hi;
    }

    @Override
    public ArrayData copy() {
        return new DeletedRangeArrayFilter(this.underlying.copy(), this.lo, this.hi);
    }

    @Override
    public Object[] asObjectArray() {
        Object[] value = super.asObjectArray();
        if (this.lo < Integer.MAX_VALUE) {
            int end = (int)Math.min((long)(this.hi + 1L), (long)Integer.MAX_VALUE);
            for (int i = (int)this.lo; i < end; ++i) {
                value[i] = ScriptRuntime.UNDEFINED;
            }
        }
        return value;
    }

    @Override
    public Object asArrayOfType(Class<?> componentType) {
        Object value = super.asArrayOfType(componentType);
        Object undefValue = DeletedRangeArrayFilter.convertUndefinedValue(componentType);
        if (this.lo < Integer.MAX_VALUE) {
            int end = (int)Math.min((long)(this.hi + 1L), (long)Integer.MAX_VALUE);
            for (int i = (int)this.lo; i < end; ++i) {
                Array.set((Object)value, (int)i, (Object)undefValue);
            }
        }
        return value;
    }

    @Override
    public ArrayData ensure(long safeIndex) {
        if (safeIndex >= 131072L && safeIndex >= this.length()) {
            return new SparseArrayData(this, safeIndex + 1L);
        }
        return super.ensure(safeIndex);
    }

    @Override
    public ArrayData shiftLeft(int by) {
        super.shiftLeft(by);
        this.lo = Math.max((long)0L, (long)(this.lo - (long)by));
        this.hi = Math.max((long)-1L, (long)(this.hi - (long)by));
        return this.isEmpty() ? this.getUnderlying() : this;
    }

    @Override
    public ArrayData shiftRight(int by) {
        super.shiftRight(by);
        long len = this.length();
        this.lo = Math.min((long)len, (long)(this.lo + (long)by));
        this.hi = Math.min((long)(len - 1L), (long)(this.hi + (long)by));
        return this.isEmpty() ? this.getUnderlying() : this;
    }

    @Override
    public ArrayData shrink(long newLength) {
        super.shrink(newLength);
        this.lo = Math.min((long)newLength, (long)this.lo);
        this.hi = Math.min((long)(newLength - 1L), (long)this.hi);
        return this.isEmpty() ? this.getUnderlying() : this;
    }

    @Override
    public ArrayData set(int index, Object value, boolean strict) {
        long longIndex = ArrayIndex.toLongIndex(index);
        if (longIndex < this.lo || longIndex > this.hi) {
            return super.set(index, value, strict);
        }
        if (longIndex > this.lo && longIndex < this.hi) {
            return this.getDeletedArrayFilter().set(index, value, strict);
        }
        if (longIndex == this.lo) {
            ++this.lo;
        } else {
            assert (longIndex == this.hi);
            --this.hi;
        }
        return this.isEmpty() ? this.getUnderlying().set(index, value, strict) : super.set(index, value, strict);
    }

    @Override
    public ArrayData set(int index, int value, boolean strict) {
        long longIndex = ArrayIndex.toLongIndex(index);
        if (longIndex < this.lo || longIndex > this.hi) {
            return super.set(index, value, strict);
        }
        if (longIndex > this.lo && longIndex < this.hi) {
            return this.getDeletedArrayFilter().set(index, value, strict);
        }
        if (longIndex == this.lo) {
            ++this.lo;
        } else {
            assert (longIndex == this.hi);
            --this.hi;
        }
        return this.isEmpty() ? this.getUnderlying().set(index, value, strict) : super.set(index, value, strict);
    }

    @Override
    public ArrayData set(int index, double value, boolean strict) {
        long longIndex = ArrayIndex.toLongIndex(index);
        if (longIndex < this.lo || longIndex > this.hi) {
            return super.set(index, value, strict);
        }
        if (longIndex > this.lo && longIndex < this.hi) {
            return this.getDeletedArrayFilter().set(index, value, strict);
        }
        if (longIndex == this.lo) {
            ++this.lo;
        } else {
            assert (longIndex == this.hi);
            --this.hi;
        }
        return this.isEmpty() ? this.getUnderlying().set(index, value, strict) : super.set(index, value, strict);
    }

    @Override
    public boolean has(int index) {
        return super.has(index) && !this.isDeleted(index);
    }

    private ArrayData getDeletedArrayFilter() {
        DeletedArrayFilter deleteFilter = new DeletedArrayFilter(this.getUnderlying());
        ((ArrayData)deleteFilter).delete(this.lo, this.hi);
        return deleteFilter;
    }

    @Override
    public ArrayData delete(int index) {
        long longIndex = ArrayIndex.toLongIndex(index);
        this.underlying.setEmpty(index);
        if (longIndex + 1L == this.lo) {
            this.lo = longIndex;
        } else if (longIndex - 1L == this.hi) {
            this.hi = longIndex;
        } else if (longIndex < this.lo || this.hi < longIndex) {
            return this.getDeletedArrayFilter().delete(index);
        }
        return this;
    }

    @Override
    public ArrayData delete(long fromIndex, long toIndex) {
        if (fromIndex > this.hi + 1L || toIndex < this.lo - 1L) {
            return this.getDeletedArrayFilter().delete(fromIndex, toIndex);
        }
        this.lo = Math.min((long)fromIndex, (long)this.lo);
        this.hi = Math.max((long)toIndex, (long)this.hi);
        this.underlying.setEmpty(this.lo, this.hi);
        return this;
    }

    @Override
    public Object pop() {
        int index = (int)this.length() - 1;
        if (super.has(index)) {
            boolean isDeleted = this.isDeleted(index);
            Object value = super.pop();
            this.lo = Math.min((long)(index + 1), (long)this.lo);
            this.hi = Math.min((long)index, (long)this.hi);
            return isDeleted ? ScriptRuntime.UNDEFINED : value;
        }
        return super.pop();
    }

    @Override
    public ArrayData slice(long from, long to) {
        return new DeletedRangeArrayFilter(this.underlying.slice(from, to), Math.max((long)0L, (long)(this.lo - from)), Math.max((long)0L, (long)(this.hi - from)));
    }
}


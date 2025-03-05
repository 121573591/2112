/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.RandomAccess
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal;
import com.google.protobuf.PrimitiveNonBoxingCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList
extends AbstractProtobufList<Long>
implements Internal.LongList,
RandomAccess,
PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST = new LongArrayList(new long[0], 0, false);
    private long[] array;
    private int size;

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    LongArrayList() {
        this(new long[10], 0, true);
    }

    private LongArrayList(long[] other, int size, boolean isMutable) {
        super(isMutable);
        this.array = other;
        this.size = size;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        this.ensureIsMutable();
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy((Object)this.array, (int)toIndex, (Object)this.array, (int)fromIndex, (int)(this.size - toIndex));
        this.size -= toIndex - fromIndex;
        ++this.modCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LongArrayList)) {
            return super.equals(o);
        }
        LongArrayList other = (LongArrayList)o;
        if (this.size != other.size) {
            return false;
        }
        long[] arr = other.array;
        for (int i = 0; i < this.size; ++i) {
            if (this.array[i] == arr[i]) continue;
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < this.size; ++i) {
            result = 31 * result + Internal.hashLong(this.array[i]);
        }
        return result;
    }

    @Override
    public Internal.LongList mutableCopyWithCapacity(int capacity) {
        if (capacity < this.size) {
            throw new IllegalArgumentException();
        }
        return new LongArrayList(Arrays.copyOf((long[])this.array, (int)capacity), this.size, true);
    }

    public Long get(int index) {
        return this.getLong(index);
    }

    @Override
    public long getLong(int index) {
        this.ensureIndexInRange(index);
        return this.array[index];
    }

    public int indexOf(Object element) {
        if (!(element instanceof Long)) {
            return -1;
        }
        long unboxedElement = (Long)element;
        int numElems = this.size();
        for (int i = 0; i < numElems; ++i) {
            if (this.array[i] != unboxedElement) continue;
            return i;
        }
        return -1;
    }

    public boolean contains(Object element) {
        return this.indexOf(element) != -1;
    }

    public int size() {
        return this.size;
    }

    @Override
    public Long set(int index, Long element) {
        return this.setLong(index, element);
    }

    @Override
    public long setLong(int index, long element) {
        this.ensureIsMutable();
        this.ensureIndexInRange(index);
        long previousValue = this.array[index];
        this.array[index] = element;
        return previousValue;
    }

    @Override
    public boolean add(Long element) {
        this.addLong(element);
        return true;
    }

    @Override
    public void add(int index, Long element) {
        this.addLong(index, element);
    }

    @Override
    public void addLong(long element) {
        this.ensureIsMutable();
        if (this.size == this.array.length) {
            int length = this.size * 3 / 2 + 1;
            long[] newArray = new long[length];
            System.arraycopy((Object)this.array, (int)0, (Object)newArray, (int)0, (int)this.size);
            this.array = newArray;
        }
        this.array[this.size++] = element;
    }

    private void addLong(int index, long element) {
        this.ensureIsMutable();
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(index));
        }
        if (this.size < this.array.length) {
            System.arraycopy((Object)this.array, (int)index, (Object)this.array, (int)(index + 1), (int)(this.size - index));
        } else {
            int length = this.size * 3 / 2 + 1;
            long[] newArray = new long[length];
            System.arraycopy((Object)this.array, (int)0, (Object)newArray, (int)0, (int)index);
            System.arraycopy((Object)this.array, (int)index, (Object)newArray, (int)(index + 1), (int)(this.size - index));
            this.array = newArray;
        }
        this.array[index] = element;
        ++this.size;
        ++this.modCount;
    }

    @Override
    public boolean addAll(Collection<? extends Long> collection) {
        this.ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList list = (LongArrayList)collection;
        if (list.size == 0) {
            return false;
        }
        int overflow = Integer.MAX_VALUE - this.size;
        if (overflow < list.size) {
            throw new OutOfMemoryError();
        }
        int newSize = this.size + list.size;
        if (newSize > this.array.length) {
            this.array = Arrays.copyOf((long[])this.array, (int)newSize);
        }
        System.arraycopy((Object)list.array, (int)0, (Object)this.array, (int)this.size, (int)list.size);
        this.size = newSize;
        ++this.modCount;
        return true;
    }

    @Override
    public Long remove(int index) {
        this.ensureIsMutable();
        this.ensureIndexInRange(index);
        long value = this.array[index];
        if (index < this.size - 1) {
            System.arraycopy((Object)this.array, (int)(index + 1), (Object)this.array, (int)index, (int)(this.size - index - 1));
        }
        --this.size;
        ++this.modCount;
        return value;
    }

    private void ensureIndexInRange(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(this.makeOutOfBoundsExceptionMessage(index));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int index) {
        return "Index:" + index + ", Size:" + this.size;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package cn.hutool.core.collection;

import cn.hutool.core.collection.IterableIter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PartitionIter<T>
implements IterableIter<List<T>>,
Serializable {
    private static final long serialVersionUID = 1L;
    protected final Iterator<T> iterator;
    protected final int partitionSize;

    public PartitionIter(Iterator<T> iterator, int partitionSize) {
        this.iterator = iterator;
        this.partitionSize = partitionSize;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public List<T> next() {
        ArrayList list = new ArrayList(this.partitionSize);
        for (int i = 0; i < this.partitionSize && this.iterator.hasNext(); ++i) {
            list.add(this.iterator.next());
        }
        return list;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.AbstractCollection
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Spliterator
 *  java.util.function.Consumer
 *  java.util.function.Function
 *  java.util.function.Predicate
 */
package cn.hutool.core.collection;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.collection.SpliteratorUtil;
import cn.hutool.core.lang.Assert;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TransCollection<F, T>
extends AbstractCollection<T> {
    private final Collection<F> fromCollection;
    private final Function<? super F, ? extends T> function;

    public TransCollection(Collection<F> fromCollection, Function<? super F, ? extends T> function) {
        this.fromCollection = Assert.notNull(fromCollection);
        this.function = Assert.notNull(function);
    }

    public Iterator<T> iterator() {
        return IterUtil.trans(this.fromCollection.iterator(), this.function);
    }

    public void clear() {
        this.fromCollection.clear();
    }

    public boolean isEmpty() {
        return this.fromCollection.isEmpty();
    }

    public void forEach(Consumer<? super T> action) {
        Assert.notNull(action);
        this.fromCollection.forEach(f -> action.accept(this.function.apply(f)));
    }

    public boolean removeIf(Predicate<? super T> filter) {
        Assert.notNull(filter);
        return this.fromCollection.removeIf(element -> filter.test(this.function.apply(element)));
    }

    public Spliterator<T> spliterator() {
        return SpliteratorUtil.trans(this.fromCollection.spliterator(), this.function);
    }

    public int size() {
        return this.fromCollection.size();
    }
}


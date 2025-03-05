/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.function.Consumer
 *  java.util.function.Supplier
 */
package cn.hutool.core.lang.loader;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.loader.LazyLoader;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LazyFunLoader<T>
extends LazyLoader<T> {
    private static final long serialVersionUID = 1L;
    private Supplier<T> supplier;

    public static <T> LazyFunLoader<T> on(Supplier<T> supplier) {
        Assert.notNull(supplier, "supplier must be not null!", new Object[0]);
        return new LazyFunLoader<T>(supplier);
    }

    public LazyFunLoader(Supplier<T> supplier) {
        Assert.notNull(supplier);
        this.supplier = supplier;
    }

    @Override
    protected T init() {
        Object t = this.supplier.get();
        this.supplier = null;
        return (T)t;
    }

    public boolean isInitialize() {
        return this.supplier == null;
    }

    public void ifInitialized(Consumer<T> consumer) {
        Assert.notNull(consumer);
        if (this.isInitialize()) {
            consumer.accept(this.get());
        }
    }
}


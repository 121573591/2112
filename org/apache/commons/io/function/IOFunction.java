/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  java.util.function.Consumer
 *  java.util.function.Function
 *  java.util.function.Supplier
 */
package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.commons.io.function.IOConsumer;
import org.apache.commons.io.function.IOSupplier;

@FunctionalInterface
public interface IOFunction<T, R> {
    public R apply(T var1) throws IOException;

    default public <V> IOFunction<V, R> compose(IOFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before, (String)"before");
        return v -> this.apply(before.apply((Object)v));
    }

    default public <V> IOFunction<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before, (String)"before");
        return v -> this.apply(before.apply(v));
    }

    default public IOSupplier<R> compose(IOSupplier<? extends T> before) {
        Objects.requireNonNull(before, (String)"before");
        return () -> this.apply(before.get());
    }

    default public IOSupplier<R> compose(Supplier<? extends T> before) {
        Objects.requireNonNull(before, (String)"before");
        return () -> this.apply(before.get());
    }

    default public <V> IOFunction<T, V> andThen(IOFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after, (String)"after");
        return t -> after.apply((R)this.apply(t));
    }

    default public <V> IOFunction<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after, (String)"after");
        return t -> after.apply(this.apply(t));
    }

    default public IOConsumer<T> andThen(IOConsumer<? super R> after) {
        Objects.requireNonNull(after, (String)"after");
        return t -> after.accept((R)this.apply(t));
    }

    default public IOConsumer<T> andThen(Consumer<? super R> after) {
        Objects.requireNonNull(after, (String)"after");
        return t -> after.accept(this.apply(t));
    }

    public static <T> IOFunction<T, T> identity() {
        return t -> t;
    }
}


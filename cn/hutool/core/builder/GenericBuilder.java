/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.function.BiConsumer
 *  java.util.function.Consumer
 *  java.util.function.Supplier
 */
package cn.hutool.core.builder;

import cn.hutool.core.builder.Builder;
import cn.hutool.core.lang.func.Consumer3;
import cn.hutool.core.lang.func.Supplier1;
import cn.hutool.core.lang.func.Supplier2;
import cn.hutool.core.lang.func.Supplier3;
import cn.hutool.core.lang.func.Supplier4;
import cn.hutool.core.lang.func.Supplier5;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class GenericBuilder<T>
implements Builder<T> {
    private static final long serialVersionUID = 1L;
    private final Supplier<T> instant;
    private final List<Consumer<T>> modifiers = new ArrayList();

    public GenericBuilder(Supplier<T> instant) {
        this.instant = instant;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> instant) {
        return new GenericBuilder<T>(instant);
    }

    public static <T, P1> GenericBuilder<T> of(Supplier1<T, P1> instant, P1 p1) {
        return GenericBuilder.of(instant.toSupplier(p1));
    }

    public static <T, P1, P2> GenericBuilder<T> of(Supplier2<T, P1, P2> instant, P1 p1, P2 p2) {
        return GenericBuilder.of(instant.toSupplier(p1, p2));
    }

    public static <T, P1, P2, P3> GenericBuilder<T> of(Supplier3<T, P1, P2, P3> instant, P1 p1, P2 p2, P3 p3) {
        return GenericBuilder.of(instant.toSupplier(p1, p2, p3));
    }

    public static <T, P1, P2, P3, P4> GenericBuilder<T> of(Supplier4<T, P1, P2, P3, P4> instant, P1 p1, P2 p2, P3 p3, P4 p4) {
        return GenericBuilder.of(instant.toSupplier(p1, p2, p3, p4));
    }

    public static <T, P1, P2, P3, P4, P5> GenericBuilder<T> of(Supplier5<T, P1, P2, P3, P4, P5> instant, P1 p1, P2 p2, P3 p3, P4 p4, P5 p5) {
        return GenericBuilder.of(instant.toSupplier(p1, p2, p3, p4, p5));
    }

    public GenericBuilder<T> with(Consumer<T> consumer) {
        this.modifiers.add(consumer);
        return this;
    }

    public <P1> GenericBuilder<T> with(BiConsumer<T, P1> consumer, P1 p1) {
        this.modifiers.add(instant -> consumer.accept(instant, p1));
        return this;
    }

    public <P1, P2> GenericBuilder<T> with(Consumer3<T, P1, P2> consumer, P1 p1, P2 p2) {
        this.modifiers.add(instant -> consumer.accept(instant, p1, p2));
        return this;
    }

    @Override
    public T build() {
        Object value = this.instant.get();
        this.modifiers.forEach(modifier -> modifier.accept(value));
        this.modifiers.clear();
        return (T)value;
    }
}


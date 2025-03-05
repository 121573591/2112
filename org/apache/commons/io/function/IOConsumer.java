/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package org.apache.commons.io.function;

import java.io.IOException;
import java.util.Objects;

@FunctionalInterface
public interface IOConsumer<T> {
    public static final IOConsumer<?> NOOP_IO_CONSUMER = t -> {};

    public static <T> IOConsumer<T> noop() {
        return NOOP_IO_CONSUMER;
    }

    public void accept(T var1) throws IOException;

    default public IOConsumer<T> andThen(IOConsumer<? super T> after) {
        Objects.requireNonNull(after, (String)"after");
        return t -> {
            this.accept(t);
            after.accept(t);
        };
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.UncheckedIOException
 *  java.lang.Deprecated
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.SafeVarargs
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.UndeclaredThrowableException
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Objects
 *  java.util.concurrent.Callable
 *  java.util.function.BiConsumer
 *  java.util.function.BiFunction
 *  java.util.function.BiPredicate
 *  java.util.function.Consumer
 *  java.util.function.Function
 *  java.util.function.Predicate
 *  java.util.function.Supplier
 *  java.util.stream.Stream
 */
package org.apache.commons.lang3;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBooleanSupplier;

@Deprecated
public class Functions {
    public static <O1, O2, T extends Throwable> void accept(FailableBiConsumer<O1, O2, T> consumer, O1 object1, O2 object2) {
        Functions.run(() -> consumer.accept(object1, object2));
    }

    public static <O, T extends Throwable> void accept(FailableConsumer<O, T> consumer, O object) {
        Functions.run(() -> consumer.accept(object));
    }

    public static <O1, O2, O, T extends Throwable> O apply(FailableBiFunction<O1, O2, O, T> function, O1 input1, O2 input2) {
        return (O)Functions.get(() -> function.apply(input1, input2));
    }

    public static <I, O, T extends Throwable> O apply(FailableFunction<I, O, T> function, I input) {
        return (O)Functions.get(() -> function.apply(input));
    }

    public static <O1, O2> BiConsumer<O1, O2> asBiConsumer(FailableBiConsumer<O1, O2, ?> consumer) {
        return (input1, input2) -> Functions.accept(consumer, input1, input2);
    }

    public static <O1, O2, O> BiFunction<O1, O2, O> asBiFunction(FailableBiFunction<O1, O2, O, ?> function) {
        return (input1, input2) -> Functions.apply(function, input1, input2);
    }

    public static <O1, O2> BiPredicate<O1, O2> asBiPredicate(FailableBiPredicate<O1, O2, ?> predicate) {
        return (input1, input2) -> Functions.test(predicate, input1, input2);
    }

    public static <O> Callable<O> asCallable(FailableCallable<O, ?> callable) {
        return () -> Functions.call(callable);
    }

    public static <I> Consumer<I> asConsumer(FailableConsumer<I, ?> consumer) {
        return input -> Functions.accept(consumer, input);
    }

    public static <I, O> Function<I, O> asFunction(FailableFunction<I, O, ?> function) {
        return input -> Functions.apply(function, input);
    }

    public static <I> Predicate<I> asPredicate(FailablePredicate<I, ?> predicate) {
        return input -> Functions.test(predicate, input);
    }

    public static Runnable asRunnable(FailableRunnable<?> runnable2) {
        return () -> Functions.run(runnable2);
    }

    public static <O> Supplier<O> asSupplier(FailableSupplier<O, ?> supplier) {
        return () -> Functions.get(supplier);
    }

    public static <O, T extends Throwable> O call(FailableCallable<O, T> callable) {
        return (O)Functions.get(callable::call);
    }

    public static <O, T extends Throwable> O get(FailableSupplier<O, T> supplier) {
        try {
            return supplier.get();
        }
        catch (Throwable t) {
            throw Functions.rethrow(t);
        }
    }

    private static <T extends Throwable> boolean getAsBoolean(FailableBooleanSupplier<T> supplier) {
        try {
            return supplier.getAsBoolean();
        }
        catch (Throwable t) {
            throw Functions.rethrow(t);
        }
    }

    public static RuntimeException rethrow(Throwable throwable) {
        Objects.requireNonNull((Object)((Object)throwable), (String)"throwable");
        ExceptionUtils.throwUnchecked(throwable);
        if (throwable instanceof IOException) {
            throw new UncheckedIOException((IOException)throwable);
        }
        throw new UndeclaredThrowableException(throwable);
    }

    public static <T extends Throwable> void run(FailableRunnable<T> runnable2) {
        try {
            runnable2.run();
        }
        catch (Throwable t) {
            throw Functions.rethrow(t);
        }
    }

    public static <O> Streams.FailableStream<O> stream(Collection<O> collection) {
        return new Streams.FailableStream(collection.stream());
    }

    public static <O> Streams.FailableStream<O> stream(Stream<O> stream) {
        return new Streams.FailableStream<O>(stream);
    }

    public static <O1, O2, T extends Throwable> boolean test(FailableBiPredicate<O1, O2, T> predicate, O1 object1, O2 object2) {
        return Functions.getAsBoolean(() -> predicate.test(object1, object2));
    }

    public static <O, T extends Throwable> boolean test(FailablePredicate<O, T> predicate, O object) {
        return Functions.getAsBoolean(() -> predicate.test(object));
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> action, FailableConsumer<Throwable, ? extends Throwable> errorHandler, FailableRunnable<? extends Throwable> ... resources) {
        Object[] fr = new org.apache.commons.lang3.function.FailableRunnable[resources.length];
        Arrays.setAll((Object[])fr, i -> () -> resources[i].run());
        Failable.tryWithResources(action::run, errorHandler != null ? errorHandler::accept : null, fr);
    }

    @SafeVarargs
    public static void tryWithResources(FailableRunnable<? extends Throwable> action, FailableRunnable<? extends Throwable> ... resources) {
        Functions.tryWithResources(action, null, resources);
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableBiConsumer<O1, O2, T extends Throwable> {
        public void accept(O1 var1, O2 var2) throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableRunnable<T extends Throwable> {
        public void run() throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableConsumer<O, T extends Throwable> {
        public void accept(O var1) throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableBiFunction<O1, O2, R, T extends Throwable> {
        public R apply(O1 var1, O2 var2) throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableSupplier<R, T extends Throwable> {
        public R get() throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableFunction<I, R, T extends Throwable> {
        public R apply(I var1) throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableBiPredicate<O1, O2, T extends Throwable> {
        public boolean test(O1 var1, O2 var2) throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailableCallable<R, T extends Throwable> {
        public R call() throws T;
    }

    @Deprecated
    @FunctionalInterface
    public static interface FailablePredicate<I, T extends Throwable> {
        public boolean test(I var1) throws T;
    }
}


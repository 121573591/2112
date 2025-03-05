/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Future
 *  java.util.function.Function
 */
package org.apache.commons.lang3.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Function;
import org.apache.commons.lang3.concurrent.Computable;
import org.apache.commons.lang3.concurrent.FutureTasks;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class Memoizer<I, O>
implements Computable<I, O> {
    private final ConcurrentMap<I, Future<O>> cache = new ConcurrentHashMap();
    private final Function<? super I, ? extends Future<O>> mappingFunction;
    private final boolean recalculate;

    public Memoizer(Computable<I, O> computable) {
        this(computable, false);
    }

    public Memoizer(Computable<I, O> computable, boolean recalculate) {
        this.recalculate = recalculate;
        this.mappingFunction = k -> FutureTasks.run(() -> computable.compute(k));
    }

    public Memoizer(Function<I, O> function) {
        this(function, false);
    }

    public Memoizer(Function<I, O> function, boolean recalculate) {
        this.recalculate = recalculate;
        this.mappingFunction = k -> FutureTasks.run(() -> function.apply(k));
    }

    @Override
    public O compute(I arg) throws InterruptedException {
        while (true) {
            Future future = (Future)this.cache.computeIfAbsent(arg, this.mappingFunction);
            try {
                return (O)future.get();
            }
            catch (CancellationException e) {
                this.cache.remove(arg, (Object)future);
                continue;
            }
            catch (ExecutionException e) {
                if (this.recalculate) {
                    this.cache.remove(arg, (Object)future);
                }
                throw this.launderException(e.getCause());
            }
            break;
        }
    }

    private RuntimeException launderException(Throwable throwable) {
        throw new IllegalStateException("Unchecked exception", ExceptionUtils.throwUnchecked(throwable));
    }
}


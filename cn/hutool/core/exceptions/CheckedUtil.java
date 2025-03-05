/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Objects
 */
package cn.hutool.core.exceptions;

import cn.hutool.core.lang.func.Func;
import cn.hutool.core.lang.func.Func0;
import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.func.Supplier1;
import cn.hutool.core.lang.func.VoidFunc;
import cn.hutool.core.lang.func.VoidFunc0;
import cn.hutool.core.lang.func.VoidFunc1;
import java.util.Objects;

public class CheckedUtil {
    public static <P, R> FuncRt<P, R> uncheck(Func<P, R> expression) {
        return CheckedUtil.uncheck(expression, RuntimeException::new);
    }

    public static <R> Func0Rt<R> uncheck(Func0<R> expression) {
        return CheckedUtil.uncheck(expression, RuntimeException::new);
    }

    public static <P, R> Func1Rt<P, R> uncheck(Func1<P, R> expression) {
        return CheckedUtil.uncheck(expression, RuntimeException::new);
    }

    public static <P> VoidFuncRt<P> uncheck(VoidFunc<P> expression) {
        return CheckedUtil.uncheck(expression, RuntimeException::new);
    }

    public static VoidFunc0Rt uncheck(VoidFunc0 expression) {
        return CheckedUtil.uncheck(expression, RuntimeException::new);
    }

    public static <P> VoidFunc1Rt<P> uncheck(VoidFunc1<P> expression) {
        return CheckedUtil.uncheck(expression, RuntimeException::new);
    }

    public static <P, R> FuncRt<P, R> uncheck(Func<P, R> expression, Supplier1<RuntimeException, Exception> rteSupplier) {
        Objects.requireNonNull(expression, (String)"expression can not be null");
        return t -> {
            try {
                return expression.call(t);
            }
            catch (Exception e) {
                if (rteSupplier == null) {
                    throw new RuntimeException((Throwable)e);
                }
                throw (RuntimeException)((Object)((Object)rteSupplier.get(e)));
            }
        };
    }

    public static <R> Func0Rt<R> uncheck(Func0<R> expression, Supplier1<RuntimeException, Exception> rteSupplier) {
        Objects.requireNonNull(expression, (String)"expression can not be null");
        return () -> {
            try {
                return expression.call();
            }
            catch (Exception e) {
                if (rteSupplier == null) {
                    throw new RuntimeException((Throwable)e);
                }
                throw (RuntimeException)((Object)((Object)rteSupplier.get(e)));
            }
        };
    }

    public static <P, R> Func1Rt<P, R> uncheck(Func1<P, R> expression, Supplier1<RuntimeException, Exception> rteSupplier) {
        Objects.requireNonNull(expression, (String)"expression can not be null");
        return t -> {
            try {
                return expression.call(t);
            }
            catch (Exception e) {
                if (rteSupplier == null) {
                    throw new RuntimeException((Throwable)e);
                }
                throw (RuntimeException)((Object)((Object)rteSupplier.get(e)));
            }
        };
    }

    public static <P> VoidFuncRt<P> uncheck(VoidFunc<P> expression, Supplier1<RuntimeException, Exception> rteSupplier) {
        Objects.requireNonNull(expression, (String)"expression can not be null");
        return t -> {
            try {
                expression.call(t);
            }
            catch (Exception e) {
                if (rteSupplier == null) {
                    throw new RuntimeException((Throwable)e);
                }
                throw (RuntimeException)((Object)((Object)rteSupplier.get(e)));
            }
        };
    }

    public static VoidFunc0Rt uncheck(VoidFunc0 expression, RuntimeException rte) {
        Objects.requireNonNull((Object)expression, (String)"expression can not be null");
        return () -> {
            try {
                expression.call();
            }
            catch (Exception e) {
                if (rte == null) {
                    throw new RuntimeException((Throwable)e);
                }
                rte.initCause((Throwable)e);
                throw rte;
            }
        };
    }

    public static VoidFunc0Rt uncheck(VoidFunc0 expression, Supplier1<RuntimeException, Exception> rteSupplier) {
        Objects.requireNonNull((Object)expression, (String)"expression can not be null");
        return () -> {
            try {
                expression.call();
            }
            catch (Exception e) {
                if (rteSupplier == null) {
                    throw new RuntimeException((Throwable)e);
                }
                throw (RuntimeException)((Object)((Object)rteSupplier.get(e)));
            }
        };
    }

    public static <P> VoidFunc1Rt<P> uncheck(VoidFunc1<P> expression, Supplier1<RuntimeException, Exception> rteSupplier) {
        Objects.requireNonNull(expression, (String)"expression can not be null");
        return t -> {
            try {
                expression.call(t);
            }
            catch (Exception e) {
                if (rteSupplier == null) {
                    throw new RuntimeException((Throwable)e);
                }
                throw (RuntimeException)((Object)((Object)rteSupplier.get(e)));
            }
        };
    }

    public static interface VoidFunc1Rt<P>
    extends VoidFunc1<P> {
        @Override
        public void call(P var1) throws RuntimeException;
    }

    public static interface VoidFunc0Rt
    extends VoidFunc0 {
        @Override
        public void call() throws RuntimeException;
    }

    public static interface VoidFuncRt<P>
    extends VoidFunc<P> {
        @Override
        public void call(P ... var1) throws RuntimeException;
    }

    public static interface Func1Rt<P, R>
    extends Func1<P, R> {
        @Override
        public R call(P var1) throws RuntimeException;
    }

    public static interface Func0Rt<R>
    extends Func0<R> {
        @Override
        public R call() throws RuntimeException;
    }

    public static interface FuncRt<P, R>
    extends Func<P, R> {
        @Override
        public R call(P ... var1) throws RuntimeException;
    }
}


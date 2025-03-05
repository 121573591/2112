/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  net.sf.cglib.proxy.MethodInterceptor
 *  net.sf.cglib.proxy.MethodProxy
 */
package cn.hutool.aop.interceptor;

import cn.hutool.aop.aspects.Aspect;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibInterceptor
implements MethodInterceptor,
Serializable {
    private static final long serialVersionUID = 1L;
    private final Object target;
    private final Aspect aspect;

    public CglibInterceptor(Object target, Aspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    public Object getTarget() {
        return this.target;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result;
        Object target;
        block5: {
            target = this.target;
            result = null;
            if (this.aspect.before(target, method, args)) {
                try {
                    result = proxy.invoke(target, args);
                }
                catch (Throwable e) {
                    Throwable throwable = e;
                    if (throwable instanceof InvocationTargetException) {
                        throwable = ((InvocationTargetException)throwable).getTargetException();
                    }
                    if (!this.aspect.afterException(target, method, args, throwable)) break block5;
                    throw throwable;
                }
            }
        }
        if (this.aspect.after(target, method, args, result)) {
            return result;
        }
        return null;
    }
}


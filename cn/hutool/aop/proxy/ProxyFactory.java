/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 */
package cn.hutool.aop.proxy;

import cn.hutool.aop.aspects.Aspect;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.ServiceLoaderUtil;
import java.io.Serializable;

public abstract class ProxyFactory
implements Serializable {
    private static final long serialVersionUID = 1L;

    public <T> T proxy(T target, Class<? extends Aspect> aspectClass) {
        return this.proxy(target, ReflectUtil.newInstanceIfPossible(aspectClass));
    }

    public abstract <T> T proxy(T var1, Aspect var2);

    public static <T> T createProxy(T target, Class<? extends Aspect> aspectClass) {
        return ProxyFactory.createProxy(target, ReflectUtil.newInstance(aspectClass, new Object[0]));
    }

    public static <T> T createProxy(T target, Aspect aspect) {
        return ProxyFactory.create().proxy(target, aspect);
    }

    public static ProxyFactory create() {
        return ServiceLoaderUtil.loadFirstAvailable(ProxyFactory.class);
    }
}


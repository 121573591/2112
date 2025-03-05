/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package cn.hutool.aop.aspects;

import java.lang.reflect.Method;

public interface Aspect {
    public boolean before(Object var1, Method var2, Object[] var3);

    public boolean after(Object var1, Method var2, Object[] var3, Object var4);

    public boolean afterException(Object var1, Method var2, Object[] var3, Throwable var4);
}


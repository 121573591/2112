/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.lang.invoke.MethodHandles
 *  java.lang.invoke.MethodHandles$Lookup
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package cn.hutool.core.lang.reflect;

import cn.hutool.core.exceptions.UtilException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LookupFactory {
    private static final int ALLOWED_MODES = 15;
    private static Constructor<MethodHandles.Lookup> java8LookupConstructor;
    private static Method privateLookupInMethod;

    public static MethodHandles.Lookup lookup(Class<?> callerClass) {
        if (privateLookupInMethod != null) {
            try {
                return (MethodHandles.Lookup)privateLookupInMethod.invoke(MethodHandles.class, new Object[]{callerClass, MethodHandles.lookup()});
            }
            catch (IllegalAccessException | InvocationTargetException e) {
                throw new UtilException(e);
            }
        }
        try {
            return (MethodHandles.Lookup)java8LookupConstructor.newInstance(new Object[]{callerClass, 15});
        }
        catch (Exception e) {
            throw new IllegalStateException("no 'Lookup(Class, int)' method in java.lang.invoke.MethodHandles.", (Throwable)e);
        }
    }

    static {
        try {
            privateLookupInMethod = MethodHandles.class.getMethod("privateLookupIn", new Class[]{Class.class, MethodHandles.Lookup.class});
        }
        catch (NoSuchMethodException noSuchMethodException) {
            // empty catch block
        }
        if (privateLookupInMethod == null) {
            try {
                java8LookupConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
                java8LookupConstructor.setAccessible(true);
            }
            catch (NoSuchMethodException e) {
                throw new IllegalStateException("There is neither 'privateLookupIn(Class, Lookup)' nor 'Lookup(Class, int)' method in java.lang.invoke.MethodHandles.", (Throwable)e);
            }
        }
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Arrays
 */
package org.openjdk.nashorn.internal.runtime.linker;

import java.util.Arrays;
import org.openjdk.nashorn.internal.runtime.ScriptRuntime;

public final class BoundCallable {
    private final Object callable;
    private final Object boundThis;
    private final Object[] boundArgs;

    BoundCallable(Object callable, Object boundThis, Object[] boundArgs) {
        this.callable = callable;
        this.boundThis = boundThis;
        this.boundArgs = BoundCallable.isEmptyArray(boundArgs) ? ScriptRuntime.EMPTY_ARRAY : (Object[])boundArgs.clone();
    }

    private BoundCallable(BoundCallable original, Object[] extraBoundArgs) {
        this.callable = original.callable;
        this.boundThis = original.boundThis;
        this.boundArgs = original.concatenateBoundArgs(extraBoundArgs);
    }

    Object getCallable() {
        return this.callable;
    }

    Object getBoundThis() {
        return this.boundThis;
    }

    Object[] getBoundArgs() {
        return this.boundArgs;
    }

    BoundCallable bind(Object[] extraBoundArgs) {
        if (BoundCallable.isEmptyArray(extraBoundArgs)) {
            return this;
        }
        return new BoundCallable(this, extraBoundArgs);
    }

    private Object[] concatenateBoundArgs(Object[] extraBoundArgs) {
        if (this.boundArgs.length == 0) {
            return (Object[])extraBoundArgs.clone();
        }
        int origBoundArgsLen = this.boundArgs.length;
        int extraBoundArgsLen = extraBoundArgs.length;
        Object[] newBoundArgs = new Object[origBoundArgsLen + extraBoundArgsLen];
        System.arraycopy((Object)this.boundArgs, (int)0, (Object)newBoundArgs, (int)0, (int)origBoundArgsLen);
        System.arraycopy((Object)extraBoundArgs, (int)0, (Object)newBoundArgs, (int)origBoundArgsLen, (int)extraBoundArgsLen);
        return newBoundArgs;
    }

    private static boolean isEmptyArray(Object[] a) {
        return a == null || a.length == 0;
    }

    public String toString() {
        StringBuilder b = new StringBuilder(this.callable.toString()).append(" on ").append(this.boundThis);
        if (this.boundArgs.length != 0) {
            b.append(" with ").append(Arrays.toString((Object[])this.boundArgs));
        }
        return b.toString();
    }
}


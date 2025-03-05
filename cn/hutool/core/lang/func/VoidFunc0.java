/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Exception
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 */
package cn.hutool.core.lang.func;

import cn.hutool.core.exceptions.ExceptionUtil;
import java.io.Serializable;

@FunctionalInterface
public interface VoidFunc0
extends Serializable {
    public void call() throws Exception;

    default public void callWithRuntimeException() {
        try {
            this.call();
        }
        catch (Exception e) {
            throw ExceptionUtil.wrapRuntime(e);
        }
    }
}


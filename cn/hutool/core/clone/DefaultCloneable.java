/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Cloneable
 *  java.lang.Exception
 *  java.lang.Object
 */
package cn.hutool.core.clone;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.util.ReflectUtil;

public interface DefaultCloneable<T>
extends Cloneable {
    default public T clone0() {
        try {
            return ReflectUtil.invoke((Object)this, "clone", new Object[0]);
        }
        catch (Exception e) {
            throw new CloneRuntimeException(e);
        }
    }
}


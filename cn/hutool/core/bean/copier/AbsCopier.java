/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package cn.hutool.core.bean.copier;

import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.copier.Copier;
import cn.hutool.core.util.ObjectUtil;

public abstract class AbsCopier<S, T>
implements Copier<T> {
    protected final S source;
    protected final T target;
    protected final CopyOptions copyOptions;

    public AbsCopier(S source2, T target, CopyOptions copyOptions) {
        this.source = source2;
        this.target = target;
        this.copyOptions = ObjectUtil.defaultIfNull(copyOptions, CopyOptions::create);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.function.Function
 */
package cn.hutool.bloomfilter.filter;

import cn.hutool.bloomfilter.filter.FuncFilter;
import cn.hutool.core.util.HashUtil;
import java.util.function.Function;

public class HfFilter
extends FuncFilter {
    private static final long serialVersionUID = 1L;

    public HfFilter(long maxValue) {
        this(maxValue, DEFAULT_MACHINE_NUM);
    }

    public HfFilter(long maxValue, int machineNum) {
        super(maxValue, machineNum, (Function<String, Number>)((Function)HashUtil::hfHash));
    }
}


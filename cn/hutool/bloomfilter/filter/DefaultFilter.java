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

public class DefaultFilter
extends FuncFilter {
    private static final long serialVersionUID = 1L;

    public DefaultFilter(long maxValue) {
        this(maxValue, DEFAULT_MACHINE_NUM);
    }

    public DefaultFilter(long maxValue, int machineNumber) {
        super(maxValue, machineNumber, (Function<String, Number>)((Function)HashUtil::javaDefaultHash));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.core.comparator;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

public class ComparatorException
extends RuntimeException {
    private static final long serialVersionUID = 4475602435485521971L;

    public ComparatorException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public ComparatorException(String message) {
        super(message);
    }

    public ComparatorException(String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public ComparatorException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ComparatorException(Throwable throwable, String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.core.bean;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

public class BeanException
extends RuntimeException {
    private static final long serialVersionUID = -8096998667745023423L;

    public BeanException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public BeanException(String message) {
        super(message);
    }

    public BeanException(String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public BeanException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BeanException(Throwable throwable, String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}


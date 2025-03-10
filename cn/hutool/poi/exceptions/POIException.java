/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.poi.exceptions;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

public class POIException
extends RuntimeException {
    private static final long serialVersionUID = 2711633732613506552L;

    public POIException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public POIException(String message) {
        super(message);
    }

    public POIException(String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public POIException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public POIException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    public POIException(Throwable throwable, String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}


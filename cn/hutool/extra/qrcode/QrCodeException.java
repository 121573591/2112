/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.extra.qrcode;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

public class QrCodeException
extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public QrCodeException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public QrCodeException(String message) {
        super(message);
    }

    public QrCodeException(String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public QrCodeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public QrCodeException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    public QrCodeException(Throwable throwable, String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}


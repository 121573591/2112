/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.core.exceptions;

import cn.hutool.core.exceptions.StatefulException;
import cn.hutool.core.util.StrUtil;

public class ValidateException
extends StatefulException {
    private static final long serialVersionUID = 6057602589533840889L;

    public ValidateException() {
    }

    public ValidateException(String msg) {
        super(msg);
    }

    public ValidateException(String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public ValidateException(Throwable throwable) {
        super(throwable);
    }

    public ValidateException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public ValidateException(int status, String msg) {
        super(status, msg);
    }

    public ValidateException(int status, Throwable throwable) {
        super(status, throwable);
    }

    public ValidateException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    public ValidateException(int status, String msg, Throwable throwable) {
        super(status, msg, throwable);
    }
}


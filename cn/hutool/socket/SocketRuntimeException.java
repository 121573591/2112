/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package cn.hutool.socket;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;

public class SocketRuntimeException
extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public SocketRuntimeException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public SocketRuntimeException(String message) {
        super(message);
    }

    public SocketRuntimeException(String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params));
    }

    public SocketRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SocketRuntimeException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    public SocketRuntimeException(Throwable throwable, String messageTemplate, Object ... params) {
        super(StrUtil.format(messageTemplate, params), throwable);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;

public class ConcurrentException
extends Exception {
    private static final long serialVersionUID = 6622707671812226130L;

    protected ConcurrentException() {
    }

    public ConcurrentException(String msg, Throwable cause) {
        super(msg, ConcurrentUtils.checkedException(cause));
    }

    public ConcurrentException(Throwable cause) {
        super(ConcurrentUtils.checkedException(cause));
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
package org.apache.commons.lang3.concurrent;

import org.apache.commons.lang3.exception.UncheckedException;

public class UncheckedTimeoutException
extends UncheckedException {
    private static final long serialVersionUID = 1L;

    public UncheckedTimeoutException(Throwable cause) {
        super(cause);
    }
}


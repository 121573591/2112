/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.apache.commons.lang3.concurrent;

public class CircuitBreakingException
extends RuntimeException {
    private static final long serialVersionUID = 1408176654686913340L;

    public CircuitBreakingException() {
    }

    public CircuitBreakingException(String message) {
        super(message);
    }

    public CircuitBreakingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CircuitBreakingException(Throwable cause) {
        super(cause);
    }
}


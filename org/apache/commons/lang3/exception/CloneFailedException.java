/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.apache.commons.lang3.exception;

public class CloneFailedException
extends RuntimeException {
    private static final long serialVersionUID = 20091223L;

    public CloneFailedException(String message) {
        super(message);
    }

    public CloneFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CloneFailedException(Throwable cause) {
        super(cause);
    }
}


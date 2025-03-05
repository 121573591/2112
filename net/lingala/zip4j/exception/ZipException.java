/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package net.lingala.zip4j.exception;

import java.io.IOException;

public class ZipException
extends IOException {
    private static final long serialVersionUID = 1L;
    private Type type = Type.UNKNOWN;

    public ZipException(String message) {
        super(message);
    }

    public ZipException(Exception rootException) {
        super((Throwable)rootException);
    }

    public ZipException(String message, Exception rootException) {
        super(message, (Throwable)rootException);
    }

    public ZipException(String message, Type type) {
        super(message);
        this.type = type;
    }

    public ZipException(String message, Throwable throwable, Type type) {
        super(message, throwable);
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }

    public static enum Type {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN;

    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.openjdk.nashorn.internal.runtime.regexp.joni.exception;

import org.openjdk.nashorn.internal.runtime.regexp.joni.exception.SyntaxException;

public class ValueException
extends SyntaxException {
    private static final long serialVersionUID = -196013852479929134L;

    public ValueException(String message) {
        super(message);
    }

    public ValueException(String message, String str) {
        super(message.replaceAll("%n", str));
    }
}


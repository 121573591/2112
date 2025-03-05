/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package org.apache.commons.text.lookup;

final class IllegalArgumentExceptions {
    static IllegalArgumentException format(String format, Object ... args) {
        return new IllegalArgumentException(String.format((String)format, (Object[])args));
    }

    static IllegalArgumentException format(Throwable t, String format, Object ... args) {
        return new IllegalArgumentException(String.format((String)format, (Object[])args), t);
    }

    private IllegalArgumentExceptions() {
    }
}


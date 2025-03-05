/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.apache.commons.text.diff;

public interface CommandVisitor<T> {
    public void visitDeleteCommand(T var1);

    public void visitInsertCommand(T var1);

    public void visitKeepCommand(T var1);
}


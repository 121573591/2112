/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.apache.commons.text.diff;

import org.apache.commons.text.diff.CommandVisitor;

public abstract class EditCommand<T> {
    private final T object;

    protected EditCommand(T object) {
        this.object = object;
    }

    public abstract void accept(CommandVisitor<T> var1);

    protected T getObject() {
        return this.object;
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.System
 *  java.util.Objects
 */
package org.apache.commons.lang3.concurrent;

import java.util.Objects;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.ConcurrentInitializer;

public class ConstantInitializer<T>
implements ConcurrentInitializer<T> {
    private static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
    private final T object;

    public ConstantInitializer(T obj) {
        this.object = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConstantInitializer)) {
            return false;
        }
        ConstantInitializer c = (ConstantInitializer)obj;
        return Objects.equals(this.getObject(), c.getObject());
    }

    @Override
    public T get() throws ConcurrentException {
        return this.getObject();
    }

    public final T getObject() {
        return this.object;
    }

    public int hashCode() {
        return Objects.hashCode(this.object);
    }

    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.format((String)FMT_TO_STRING, (Object[])new Object[]{System.identityHashCode((Object)this), String.valueOf(this.getObject())});
    }
}


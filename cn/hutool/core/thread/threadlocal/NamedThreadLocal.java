/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ThreadLocal
 */
package cn.hutool.core.thread.threadlocal;

public class NamedThreadLocal<T>
extends ThreadLocal<T> {
    private final String name;

    public NamedThreadLocal(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}


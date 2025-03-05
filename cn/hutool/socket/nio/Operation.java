/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package cn.hutool.socket.nio;

public enum Operation {
    READ(1),
    WRITE(4),
    CONNECT(8),
    ACCEPT(16);

    private final int value;

    private Operation(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}


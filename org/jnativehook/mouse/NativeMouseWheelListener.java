/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.EventListener
 */
package org.jnativehook.mouse;

import java.util.EventListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;

public interface NativeMouseWheelListener
extends EventListener {
    public void nativeMouseWheelMoved(NativeMouseWheelEvent var1);
}


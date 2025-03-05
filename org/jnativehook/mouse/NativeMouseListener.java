/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.EventListener
 */
package org.jnativehook.mouse;

import java.util.EventListener;
import org.jnativehook.mouse.NativeMouseEvent;

public interface NativeMouseListener
extends EventListener {
    public void nativeMouseClicked(NativeMouseEvent var1);

    public void nativeMousePressed(NativeMouseEvent var1);

    public void nativeMouseReleased(NativeMouseEvent var1);
}


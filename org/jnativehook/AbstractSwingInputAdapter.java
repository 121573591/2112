/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Component
 *  java.lang.Object
 */
package org.jnativehook;

import java.awt.Component;

public abstract class AbstractSwingInputAdapter
extends Component {
    protected int getJavaModifiers(int n) {
        int n2 = 0;
        if ((n & 0x11) != 0) {
            n2 |= 1;
            n2 |= 0x40;
        }
        if ((n & 0x44) != 0) {
            n2 |= 4;
            n2 |= 0x100;
        }
        if ((n & 0x44) != 0) {
            n2 |= 2;
            n2 |= 0x80;
        }
        if ((n & 0x88) != 0) {
            n2 |= 8;
            n2 |= 0x200;
        }
        if ((n & 0x100) != 0) {
            n2 |= 0x10;
            n2 |= 0x400;
        }
        if ((n & 0x200) != 0) {
            n2 |= 8;
            n2 |= 0x800;
        }
        if ((n & 0x400) != 0) {
            n2 |= 4;
            n2 |= 0x1000;
        }
        return n2;
    }
}


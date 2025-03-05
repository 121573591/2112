/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.Component
 *  java.awt.event.KeyEvent
 *  java.awt.event.KeyListener
 *  java.lang.Object
 *  java.lang.System
 */
package org.jnativehook.keyboard;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.jnativehook.AbstractSwingInputAdapter;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class SwingKeyAdapter
extends AbstractSwingInputAdapter
implements NativeKeyListener,
KeyListener {
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        this.keyTyped(this.getJavaKeyEvent(nativeKeyEvent));
    }

    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        this.keyPressed(this.getJavaKeyEvent(nativeKeyEvent));
    }

    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        this.keyReleased(this.getJavaKeyEvent(nativeKeyEvent));
    }

    public void keyTyped(KeyEvent keyEvent) {
    }

    public void keyPressed(KeyEvent keyEvent) {
    }

    public void keyReleased(KeyEvent keyEvent) {
    }

    protected KeyEvent getJavaKeyEvent(NativeKeyEvent nativeKeyEvent) {
        int n = 0;
        switch (nativeKeyEvent.getKeyLocation()) {
            case 1: {
                n = 1;
                break;
            }
            case 4: {
                n = 4;
                break;
            }
            case 2: {
                n = 1;
                break;
            }
            case 3: {
                n = 3;
            }
        }
        int n2 = 0;
        switch (nativeKeyEvent.getKeyCode()) {
            case 1: {
                n2 = 27;
                break;
            }
            case 59: {
                n2 = 112;
                break;
            }
            case 60: {
                n2 = 113;
                break;
            }
            case 61: {
                n2 = 114;
                break;
            }
            case 62: {
                n2 = 115;
                break;
            }
            case 63: {
                n2 = 116;
                break;
            }
            case 64: {
                n2 = 117;
                break;
            }
            case 65: {
                n2 = 118;
                break;
            }
            case 66: {
                n2 = 119;
                break;
            }
            case 67: {
                n2 = 120;
                break;
            }
            case 68: {
                n2 = 121;
                break;
            }
            case 87: {
                n2 = 122;
                break;
            }
            case 88: {
                n2 = 123;
                break;
            }
            case 91: {
                n2 = 61440;
                break;
            }
            case 92: {
                n2 = 61441;
                break;
            }
            case 93: {
                n2 = 61442;
                break;
            }
            case 99: {
                n2 = 61443;
                break;
            }
            case 100: {
                n2 = 61444;
                break;
            }
            case 101: {
                n2 = 61445;
                break;
            }
            case 102: {
                n2 = 61446;
                break;
            }
            case 103: {
                n2 = 61447;
                break;
            }
            case 104: {
                n2 = 61448;
                break;
            }
            case 105: {
                n2 = 61449;
                break;
            }
            case 106: {
                n2 = 61450;
                break;
            }
            case 107: {
                n2 = 61451;
                break;
            }
            case 41: {
                n2 = 192;
                break;
            }
            case 2: {
                n2 = 49;
                break;
            }
            case 3: {
                n2 = 50;
                break;
            }
            case 4: {
                n2 = 51;
                break;
            }
            case 5: {
                n2 = 52;
                break;
            }
            case 6: {
                n2 = 53;
                break;
            }
            case 7: {
                n2 = 54;
                break;
            }
            case 8: {
                n2 = 55;
                break;
            }
            case 9: {
                n2 = 56;
                break;
            }
            case 10: {
                n2 = 57;
                break;
            }
            case 11: {
                n2 = 48;
                break;
            }
            case 12: {
                n2 = 45;
                break;
            }
            case 13: {
                n2 = 61;
                break;
            }
            case 14: {
                n2 = 8;
                break;
            }
            case 15: {
                n2 = 9;
                break;
            }
            case 58: {
                n2 = 20;
                break;
            }
            case 30: {
                n2 = 65;
                break;
            }
            case 48: {
                n2 = 66;
                break;
            }
            case 46: {
                n2 = 67;
                break;
            }
            case 32: {
                n2 = 68;
                break;
            }
            case 18: {
                n2 = 69;
                break;
            }
            case 33: {
                n2 = 70;
                break;
            }
            case 34: {
                n2 = 71;
                break;
            }
            case 35: {
                n2 = 72;
                break;
            }
            case 23: {
                n2 = 73;
                break;
            }
            case 36: {
                n2 = 74;
                break;
            }
            case 37: {
                n2 = 75;
                break;
            }
            case 38: {
                n2 = 76;
                break;
            }
            case 50: {
                n2 = 77;
                break;
            }
            case 49: {
                n2 = 78;
                break;
            }
            case 24: {
                n2 = 79;
                break;
            }
            case 25: {
                n2 = 80;
                break;
            }
            case 16: {
                n2 = 81;
                break;
            }
            case 19: {
                n2 = 82;
                break;
            }
            case 31: {
                n2 = 83;
                break;
            }
            case 20: {
                n2 = 84;
                break;
            }
            case 22: {
                n2 = 85;
                break;
            }
            case 47: {
                n2 = 86;
                break;
            }
            case 17: {
                n2 = 87;
                break;
            }
            case 45: {
                n2 = 88;
                break;
            }
            case 21: {
                n2 = 89;
                break;
            }
            case 44: {
                n2 = 90;
                break;
            }
            case 26: {
                n2 = 91;
                break;
            }
            case 27: {
                n2 = 93;
                break;
            }
            case 43: {
                n2 = 92;
                break;
            }
            case 39: {
                n2 = 59;
                break;
            }
            case 40: {
                n2 = 222;
                break;
            }
            case 28: {
                n2 = 10;
                break;
            }
            case 51: {
                n2 = 44;
                break;
            }
            case 52: {
                n2 = 46;
                break;
            }
            case 53: {
                n2 = 47;
                break;
            }
            case 57: {
                n2 = 32;
                break;
            }
            case 3639: {
                n2 = 154;
                break;
            }
            case 70: {
                n2 = 145;
                break;
            }
            case 3653: {
                n2 = 19;
                break;
            }
            case 3666: {
                n2 = 155;
                break;
            }
            case 3667: {
                n2 = 127;
                break;
            }
            case 3655: {
                n2 = 36;
                break;
            }
            case 3663: {
                n2 = 35;
                break;
            }
            case 3657: {
                n2 = 33;
                break;
            }
            case 3665: {
                n2 = 34;
                break;
            }
            case 57416: {
                n2 = 38;
                break;
            }
            case 57419: {
                n2 = 37;
                break;
            }
            case 57420: {
                n2 = 12;
                break;
            }
            case 57421: {
                n2 = 39;
                break;
            }
            case 57424: {
                n2 = 40;
                break;
            }
            case 69: {
                n2 = 144;
                break;
            }
            case 83: {
                n2 = 108;
                break;
            }
            case 42: {
                n2 = 16;
                break;
            }
            case 29: {
                n2 = 17;
                break;
            }
            case 56: {
                n2 = 18;
                break;
            }
            case 3675: {
                n2 = 157;
                break;
            }
            case 3677: {
                n2 = 525;
                break;
            }
            case 112: {
                n2 = 241;
                break;
            }
            case 115: {
                n2 = 523;
                break;
            }
            case 121: {
                n2 = 25;
                break;
            }
            case 123: {
                n2 = 242;
                break;
            }
            case 65397: {
                n2 = 156;
                break;
            }
            case 65400: {
                n2 = 65480;
                break;
            }
            case 65398: {
                n2 = 65482;
                break;
            }
            case 65406: {
                n2 = 65488;
                break;
            }
            case 65401: {
                n2 = 65481;
                break;
            }
            case 65404: {
                n2 = 65485;
                break;
            }
            case 65403: {
                n2 = 65489;
            }
        }
        return new KeyEvent((Component)this, nativeKeyEvent.getID() - 2000, System.currentTimeMillis(), this.getJavaModifiers(nativeKeyEvent.getModifiers()), n2, nativeKeyEvent.getKeyChar(), n);
    }
}


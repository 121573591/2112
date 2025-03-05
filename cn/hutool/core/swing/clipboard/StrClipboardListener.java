/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.awt.datatransfer.Clipboard
 *  java.awt.datatransfer.DataFlavor
 *  java.awt.datatransfer.Transferable
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.swing.clipboard;

import cn.hutool.core.swing.clipboard.ClipboardListener;
import cn.hutool.core.swing.clipboard.ClipboardUtil;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.Serializable;

public abstract class StrClipboardListener
implements ClipboardListener,
Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public Transferable onChange(Clipboard clipboard, Transferable contents) {
        if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return this.onChange(clipboard, ClipboardUtil.getStr(contents));
        }
        return null;
    }

    public abstract Transferable onChange(Clipboard var1, String var2);
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package org.apache.commons.io.input;

import org.apache.commons.io.input.Tailer;

public interface TailerListener {
    public void init(Tailer var1);

    public void fileNotFound();

    public void fileRotated();

    public void handle(String var1);

    public void handle(Exception var1);
}


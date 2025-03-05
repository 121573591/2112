/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 */
package org.openjdk.nashorn.api.tree;

import org.openjdk.nashorn.api.tree.Diagnostic;

@FunctionalInterface
public interface DiagnosticListener {
    public void report(Diagnostic var1);
}


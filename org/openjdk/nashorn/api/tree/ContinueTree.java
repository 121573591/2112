/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package org.openjdk.nashorn.api.tree;

import org.openjdk.nashorn.api.tree.GotoTree;

public interface ContinueTree
extends GotoTree {
    @Override
    public String getLabel();
}


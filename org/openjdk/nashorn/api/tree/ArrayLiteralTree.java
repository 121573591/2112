/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package org.openjdk.nashorn.api.tree;

import java.util.List;
import org.openjdk.nashorn.api.tree.ExpressionTree;

public interface ArrayLiteralTree
extends ExpressionTree {
    public List<? extends ExpressionTree> getElements();
}


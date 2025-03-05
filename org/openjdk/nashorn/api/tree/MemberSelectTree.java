/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package org.openjdk.nashorn.api.tree;

import org.openjdk.nashorn.api.tree.ExpressionTree;

public interface MemberSelectTree
extends ExpressionTree {
    public ExpressionTree getExpression();

    public String getIdentifier();
}


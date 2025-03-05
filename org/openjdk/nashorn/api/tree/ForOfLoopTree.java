/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package org.openjdk.nashorn.api.tree;

import org.openjdk.nashorn.api.tree.ExpressionTree;
import org.openjdk.nashorn.api.tree.LoopTree;
import org.openjdk.nashorn.api.tree.StatementTree;

public interface ForOfLoopTree
extends LoopTree {
    public ExpressionTree getVariable();

    public ExpressionTree getExpression();

    @Override
    public StatementTree getStatement();
}


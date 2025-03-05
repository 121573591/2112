/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.openjdk.nashorn.api.tree;

import org.openjdk.nashorn.api.tree.StatementTree;
import org.openjdk.nashorn.api.tree.TreeImpl;
import org.openjdk.nashorn.internal.ir.Block;
import org.openjdk.nashorn.internal.ir.Statement;

abstract class StatementTreeImpl
extends TreeImpl
implements StatementTree {
    StatementTreeImpl(Statement stat) {
        super(stat);
    }

    StatementTreeImpl(Block stat) {
        super(stat);
    }
}


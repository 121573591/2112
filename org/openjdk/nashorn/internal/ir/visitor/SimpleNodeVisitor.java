/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package org.openjdk.nashorn.internal.ir.visitor;

import org.openjdk.nashorn.internal.ir.LexicalContext;
import org.openjdk.nashorn.internal.ir.visitor.NodeVisitor;

public abstract class SimpleNodeVisitor
extends NodeVisitor<LexicalContext> {
    public SimpleNodeVisitor() {
        super(new LexicalContext());
    }
}


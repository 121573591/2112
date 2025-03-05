/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package org.openjdk.nashorn.api.tree;

import org.openjdk.nashorn.api.tree.ExpressionTreeImpl;
import org.openjdk.nashorn.api.tree.IdentifierTree;
import org.openjdk.nashorn.api.tree.Tree;
import org.openjdk.nashorn.api.tree.TreeVisitor;
import org.openjdk.nashorn.internal.ir.IdentNode;

final class IdentifierTreeImpl
extends ExpressionTreeImpl
implements IdentifierTree {
    private final String name;

    IdentifierTreeImpl(IdentNode node) {
        super(node);
        this.name = node.getName();
    }

    @Override
    public Tree.Kind getKind() {
        return Tree.Kind.IDENTIFIER;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isRestParameter() {
        return ((IdentNode)this.node).isRestParameter();
    }

    @Override
    public boolean isSuper() {
        IdentNode ident = (IdentNode)this.node;
        return ident.isDirectSuper() || "super".equals((Object)ident.getName());
    }

    @Override
    public boolean isThis() {
        return "this".equals((Object)((IdentNode)this.node).getName());
    }

    @Override
    public boolean isStar() {
        return "*".equals((Object)((IdentNode)this.node).getName());
    }

    @Override
    public boolean isDefault() {
        return "default".equals((Object)((IdentNode)this.node).getName());
    }

    @Override
    public boolean isStarDefaultStar() {
        return "*default*".equals((Object)((IdentNode)this.node).getName());
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> visitor, D data) {
        return visitor.visitIdentifier(this, data);
    }
}


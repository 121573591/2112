/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Deque
 *  java.util.List
 */
package org.openjdk.nashorn.internal.ir;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.openjdk.nashorn.internal.ir.Block;
import org.openjdk.nashorn.internal.ir.LexicalContext;
import org.openjdk.nashorn.internal.ir.LexicalContextNode;
import org.openjdk.nashorn.internal.ir.Node;
import org.openjdk.nashorn.internal.ir.Statement;

public class BlockLexicalContext
extends LexicalContext {
    private final Deque<List<Statement>> sstack = new ArrayDeque();
    protected Statement lastStatement;

    @Override
    public <T extends LexicalContextNode> T push(T node) {
        T pushed = super.push(node);
        if (node instanceof Block) {
            this.sstack.push((Object)new ArrayList());
        }
        return pushed;
    }

    protected List<Statement> popStatements() {
        return (List)this.sstack.pop();
    }

    protected Block afterSetStatements(Block block) {
        return block;
    }

    @Override
    public <T extends Node> T pop(T node) {
        Object expected = node;
        if (node instanceof Block) {
            List<Statement> newStatements = this.popStatements();
            expected = ((Block)node).setStatements(this, newStatements);
            expected = this.afterSetStatements((Block)expected);
            if (!this.sstack.isEmpty()) {
                this.lastStatement = BlockLexicalContext.lastStatement((List<Statement>)((List)this.sstack.peek()));
            }
        }
        return super.pop(expected);
    }

    public void appendStatement(Statement statement) {
        assert (statement != null);
        ((List)this.sstack.peek()).add((Object)statement);
        this.lastStatement = statement;
    }

    public Node prependStatement(Statement statement) {
        assert (statement != null);
        ((List)this.sstack.peek()).add(0, (Object)statement);
        return statement;
    }

    public void prependStatements(List<Statement> statements) {
        assert (statements != null);
        ((List)this.sstack.peek()).addAll(0, statements);
    }

    public Statement getLastStatement() {
        return this.lastStatement;
    }

    private static Statement lastStatement(List<Statement> statements) {
        int s = statements.size();
        return s == 0 ? null : (Statement)statements.get(s - 1);
    }
}


/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 */
package org.openjdk.nashorn.internal.ir;

import org.openjdk.nashorn.internal.ir.Expression;
import org.openjdk.nashorn.internal.ir.LexicalContext;
import org.openjdk.nashorn.internal.ir.Node;
import org.openjdk.nashorn.internal.ir.Statement;
import org.openjdk.nashorn.internal.ir.annotations.Immutable;
import org.openjdk.nashorn.internal.ir.visitor.NodeVisitor;
import org.openjdk.nashorn.internal.parser.TokenType;

@Immutable
public class ReturnNode
extends Statement {
    private static final long serialVersionUID = 1L;
    private final Expression expression;

    public ReturnNode(int lineNumber, long token, int finish, Expression expression) {
        super(lineNumber, token, finish);
        this.expression = expression;
    }

    private ReturnNode(ReturnNode returnNode, Expression expression) {
        super(returnNode);
        this.expression = expression;
    }

    @Override
    public boolean isTerminal() {
        return true;
    }

    public boolean isReturn() {
        return this.isTokenType(TokenType.RETURN);
    }

    public boolean isYield() {
        return this.isTokenType(TokenType.YIELD);
    }

    @Override
    public Node accept(NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterReturnNode(this)) {
            if (this.expression != null) {
                return visitor.leaveReturnNode(this.setExpression((Expression)this.expression.accept(visitor)));
            }
            return visitor.leaveReturnNode(this);
        }
        return this;
    }

    @Override
    public void toString(StringBuilder sb, boolean printType) {
        sb.append(this.isYield() ? "yield" : "return");
        if (this.expression != null) {
            sb.append(' ');
            this.expression.toString(sb, printType);
        }
    }

    public Expression getExpression() {
        return this.expression;
    }

    public ReturnNode setExpression(Expression expression) {
        if (this.expression == expression) {
            return this;
        }
        return new ReturnNode(this, expression);
    }
}


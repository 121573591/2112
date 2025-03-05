/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Deque
 *  java.util.List
 */
package org.openjdk.nashorn.internal.ir;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import org.openjdk.nashorn.internal.codegen.types.Type;
import org.openjdk.nashorn.internal.ir.FunctionNode;
import org.openjdk.nashorn.internal.ir.LexicalContext;
import org.openjdk.nashorn.internal.ir.LexicalContextNode;
import org.openjdk.nashorn.internal.ir.Node;
import org.openjdk.nashorn.internal.ir.Symbol;

public class OptimisticLexicalContext
extends LexicalContext {
    private final boolean isEnabled;
    private final Deque<List<Assumption>> optimisticAssumptions = new ArrayDeque();

    public OptimisticLexicalContext(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void logOptimisticAssumption(Symbol symbol, Type type) {
        if (this.isEnabled) {
            List peek = (List)this.optimisticAssumptions.peek();
            peek.add((Object)new Assumption(symbol, type));
        }
    }

    public List<Assumption> getOptimisticAssumptions() {
        return Collections.unmodifiableList((List)((List)this.optimisticAssumptions.peek()));
    }

    public boolean hasOptimisticAssumptions() {
        return !this.optimisticAssumptions.isEmpty() && !this.getOptimisticAssumptions().isEmpty();
    }

    @Override
    public <T extends LexicalContextNode> T push(T node) {
        if (this.isEnabled && node instanceof FunctionNode) {
            this.optimisticAssumptions.push((Object)new ArrayList());
        }
        return super.push(node);
    }

    @Override
    public <T extends Node> T pop(T node) {
        T popped = super.pop(node);
        if (this.isEnabled && node instanceof FunctionNode) {
            this.optimisticAssumptions.pop();
        }
        return popped;
    }

    static class Assumption {
        Symbol symbol;
        Type type;

        Assumption(Symbol symbol, Type type) {
            this.symbol = symbol;
            this.type = type;
        }

        public String toString() {
            return this.symbol.getName() + "=" + this.type;
        }
    }
}


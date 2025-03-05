/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayDeque
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Deque
 *  java.util.HashMap
 *  java.util.Map
 */
package org.openjdk.nashorn.internal.codegen;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import org.openjdk.nashorn.internal.IntDeque;
import org.openjdk.nashorn.internal.codegen.CompileUnit;
import org.openjdk.nashorn.internal.codegen.Label;
import org.openjdk.nashorn.internal.codegen.MethodEmitter;
import org.openjdk.nashorn.internal.codegen.SharedScopeCall;
import org.openjdk.nashorn.internal.codegen.types.Type;
import org.openjdk.nashorn.internal.ir.Block;
import org.openjdk.nashorn.internal.ir.Expression;
import org.openjdk.nashorn.internal.ir.FunctionNode;
import org.openjdk.nashorn.internal.ir.LexicalContext;
import org.openjdk.nashorn.internal.ir.LexicalContextNode;
import org.openjdk.nashorn.internal.ir.Node;
import org.openjdk.nashorn.internal.ir.Symbol;
import org.openjdk.nashorn.internal.ir.WithNode;

final class CodeGeneratorLexicalContext
extends LexicalContext {
    private int dynamicScopeCount;
    private final Map<SharedScopeCall, SharedScopeCall> scopeCalls = new HashMap();
    private final Deque<CompileUnit> compileUnits = new ArrayDeque();
    private final Deque<MethodEmitter> methodEmitters = new ArrayDeque();
    private final Deque<Expression> discard = new ArrayDeque();
    private final Deque<Map<String, Collection<Label>>> unwarrantedOptimismHandlers = new ArrayDeque();
    private final Deque<StringBuilder> slotTypesDescriptors = new ArrayDeque();
    private final IntDeque splitLiterals = new IntDeque();
    private int[] nextFreeSlots = new int[16];
    private int nextFreeSlotsSize;

    CodeGeneratorLexicalContext() {
    }

    private boolean isWithBoundary(Object node) {
        return node instanceof Block && !this.isEmpty() && this.peek() instanceof WithNode;
    }

    @Override
    public <T extends LexicalContextNode> T push(T node) {
        if (this.isWithBoundary(node)) {
            ++this.dynamicScopeCount;
        } else if (node instanceof FunctionNode) {
            if (((FunctionNode)node).inDynamicContext()) {
                ++this.dynamicScopeCount;
            }
            this.splitLiterals.push(0);
        }
        return super.push(node);
    }

    void enterSplitLiteral() {
        this.splitLiterals.getAndIncrement();
        this.pushFreeSlots(((MethodEmitter)this.methodEmitters.peek()).getUsedSlotsWithLiveTemporaries());
    }

    void exitSplitLiteral() {
        int count = this.splitLiterals.decrementAndGet();
        assert (count >= 0);
    }

    @Override
    public <T extends Node> T pop(T node) {
        T popped = super.pop(node);
        if (this.isWithBoundary(node)) {
            --this.dynamicScopeCount;
            assert (this.dynamicScopeCount >= 0);
        } else if (node instanceof FunctionNode) {
            if (((FunctionNode)node).inDynamicContext()) {
                --this.dynamicScopeCount;
                assert (this.dynamicScopeCount >= 0);
            }
            assert (this.splitLiterals.peek() == 0);
            this.splitLiterals.pop();
        }
        return popped;
    }

    boolean inDynamicScope() {
        return this.dynamicScopeCount > 0;
    }

    boolean inSplitLiteral() {
        return !this.splitLiterals.isEmpty() && this.splitLiterals.peek() > 0;
    }

    MethodEmitter pushMethodEmitter(MethodEmitter newMethod) {
        this.methodEmitters.push((Object)newMethod);
        return newMethod;
    }

    MethodEmitter popMethodEmitter(MethodEmitter oldMethod) {
        assert (this.methodEmitters.peek() == oldMethod);
        this.methodEmitters.pop();
        return this.methodEmitters.isEmpty() ? null : (MethodEmitter)this.methodEmitters.peek();
    }

    void pushUnwarrantedOptimismHandlers() {
        this.unwarrantedOptimismHandlers.push((Object)new HashMap());
        this.slotTypesDescriptors.push((Object)new StringBuilder());
    }

    Map<String, Collection<Label>> getUnwarrantedOptimismHandlers() {
        return (Map)this.unwarrantedOptimismHandlers.peek();
    }

    Map<String, Collection<Label>> popUnwarrantedOptimismHandlers() {
        this.slotTypesDescriptors.pop();
        return (Map)this.unwarrantedOptimismHandlers.pop();
    }

    CompileUnit pushCompileUnit(CompileUnit newUnit) {
        this.compileUnits.push((Object)newUnit);
        return newUnit;
    }

    CompileUnit popCompileUnit(CompileUnit oldUnit) {
        assert (this.compileUnits.peek() == oldUnit);
        CompileUnit unit = (CompileUnit)this.compileUnits.pop();
        assert (unit.hasCode()) : "compile unit popped without code";
        unit.setUsed();
        return this.compileUnits.isEmpty() ? null : (CompileUnit)this.compileUnits.peek();
    }

    boolean hasCompileUnits() {
        return !this.compileUnits.isEmpty();
    }

    Collection<SharedScopeCall> getScopeCalls() {
        return Collections.unmodifiableCollection((Collection)this.scopeCalls.values());
    }

    SharedScopeCall getScopeCall(CompileUnit unit, Symbol symbol, Type valueType, Type returnType, Type[] paramTypes, int flags, boolean isOptimistic) {
        SharedScopeCall scopeCall = new SharedScopeCall(symbol, valueType, returnType, paramTypes, flags, isOptimistic);
        if (this.scopeCalls.containsKey((Object)scopeCall)) {
            return (SharedScopeCall)this.scopeCalls.get((Object)scopeCall);
        }
        scopeCall.setClassAndName(unit, this.getCurrentFunction().uniqueName(":scopeCall"));
        this.scopeCalls.put((Object)scopeCall, (Object)scopeCall);
        return scopeCall;
    }

    SharedScopeCall getScopeGet(CompileUnit unit, Symbol symbol, Type valueType, int flags, boolean isOptimistic) {
        return this.getScopeCall(unit, symbol, valueType, valueType, null, flags, isOptimistic);
    }

    void onEnterBlock(Block block) {
        this.pushFreeSlots(this.assignSlots(block, this.isFunctionBody() ? 0 : this.getUsedSlotCount()));
    }

    private void pushFreeSlots(int freeSlots) {
        if (this.nextFreeSlotsSize == this.nextFreeSlots.length) {
            int[] newNextFreeSlots = new int[this.nextFreeSlotsSize * 2];
            System.arraycopy((Object)this.nextFreeSlots, (int)0, (Object)newNextFreeSlots, (int)0, (int)this.nextFreeSlotsSize);
            this.nextFreeSlots = newNextFreeSlots;
        }
        this.nextFreeSlots[this.nextFreeSlotsSize++] = freeSlots;
    }

    int getUsedSlotCount() {
        return this.nextFreeSlots[this.nextFreeSlotsSize - 1];
    }

    void releaseSlots() {
        int undefinedFromSlot;
        --this.nextFreeSlotsSize;
        int n = undefinedFromSlot = this.nextFreeSlotsSize == 0 ? 0 : this.nextFreeSlots[this.nextFreeSlotsSize - 1];
        if (!this.slotTypesDescriptors.isEmpty()) {
            ((StringBuilder)this.slotTypesDescriptors.peek()).setLength(undefinedFromSlot);
        }
        ((MethodEmitter)this.methodEmitters.peek()).undefineLocalVariables(undefinedFromSlot, false);
    }

    private int assignSlots(Block block, int firstSlot) {
        int fromSlot = firstSlot;
        MethodEmitter method = (MethodEmitter)this.methodEmitters.peek();
        for (Symbol symbol : block.getSymbols()) {
            if (!symbol.hasSlot()) continue;
            symbol.setFirstSlot(fromSlot);
            int toSlot = fromSlot + symbol.slotCount();
            method.defineBlockLocalVariable(fromSlot, toSlot);
            fromSlot = toSlot;
        }
        return fromSlot;
    }

    static Type getTypeForSlotDescriptor(char typeDesc) {
        switch (typeDesc) {
            case 'I': 
            case 'i': {
                return Type.INT;
            }
            case 'J': 
            case 'j': {
                return Type.LONG;
            }
            case 'D': 
            case 'd': {
                return Type.NUMBER;
            }
            case 'A': 
            case 'a': {
                return Type.OBJECT;
            }
            case 'U': 
            case 'u': {
                return Type.UNKNOWN;
            }
        }
        throw new AssertionError();
    }

    void pushDiscard(Expression expr) {
        this.discard.push((Object)expr);
    }

    boolean popDiscardIfCurrent(Expression expr) {
        if (this.isCurrentDiscard(expr)) {
            this.discard.pop();
            return true;
        }
        return false;
    }

    boolean isCurrentDiscard(Expression expr) {
        return this.discard.peek() == expr;
    }

    int quickSlot(Type type) {
        return ((MethodEmitter)this.methodEmitters.peek()).defineTemporaryLocalVariable(type.getSlots());
    }
}


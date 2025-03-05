/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Deque
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.ListIterator
 *  java.util.Map
 *  java.util.Set
 */
package org.openjdk.nashorn.internal.codegen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.openjdk.nashorn.internal.codegen.Compiler;
import org.openjdk.nashorn.internal.codegen.CompilerConstants;
import org.openjdk.nashorn.internal.ir.AccessNode;
import org.openjdk.nashorn.internal.ir.BinaryNode;
import org.openjdk.nashorn.internal.ir.Block;
import org.openjdk.nashorn.internal.ir.CatchNode;
import org.openjdk.nashorn.internal.ir.Expression;
import org.openjdk.nashorn.internal.ir.ForNode;
import org.openjdk.nashorn.internal.ir.FunctionNode;
import org.openjdk.nashorn.internal.ir.IdentNode;
import org.openjdk.nashorn.internal.ir.LexicalContextNode;
import org.openjdk.nashorn.internal.ir.LiteralNode;
import org.openjdk.nashorn.internal.ir.Node;
import org.openjdk.nashorn.internal.ir.RuntimeNode;
import org.openjdk.nashorn.internal.ir.Splittable;
import org.openjdk.nashorn.internal.ir.Statement;
import org.openjdk.nashorn.internal.ir.SwitchNode;
import org.openjdk.nashorn.internal.ir.Symbol;
import org.openjdk.nashorn.internal.ir.TryNode;
import org.openjdk.nashorn.internal.ir.UnaryNode;
import org.openjdk.nashorn.internal.ir.VarNode;
import org.openjdk.nashorn.internal.ir.WithNode;
import org.openjdk.nashorn.internal.ir.visitor.SimpleNodeVisitor;
import org.openjdk.nashorn.internal.parser.TokenType;
import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.ECMAErrors;
import org.openjdk.nashorn.internal.runtime.ErrorManager;
import org.openjdk.nashorn.internal.runtime.JSErrorType;
import org.openjdk.nashorn.internal.runtime.ParserException;
import org.openjdk.nashorn.internal.runtime.Source;
import org.openjdk.nashorn.internal.runtime.logging.DebugLogger;
import org.openjdk.nashorn.internal.runtime.logging.Loggable;
import org.openjdk.nashorn.internal.runtime.logging.Logger;

@Logger(name="symbols")
final class AssignSymbols
extends SimpleNodeVisitor
implements Loggable {
    private final DebugLogger log;
    private final boolean debug;
    private final Deque<Set<String>> thisProperties = new ArrayDeque();
    private final Map<String, Symbol> globalSymbols = new HashMap();
    private final Compiler compiler;
    private final boolean isOnDemand;

    private static boolean isParamOrVar(IdentNode identNode) {
        Symbol symbol = identNode.getSymbol();
        return symbol.isParam() || symbol.isVar();
    }

    private static String name(Node node) {
        String cn = node.getClass().getName();
        int lastDot = cn.lastIndexOf(46);
        if (lastDot == -1) {
            return cn;
        }
        return cn.substring(lastDot + 1);
    }

    private static FunctionNode removeUnusedSlots(FunctionNode functionNode) {
        Symbol selfSymbol;
        if (!functionNode.needsCallee()) {
            functionNode.compilerConstant(CompilerConstants.CALLEE).setNeedsSlot(false);
        }
        if (!functionNode.hasScopeBlock() && !functionNode.needsParentScope()) {
            functionNode.compilerConstant(CompilerConstants.SCOPE).setNeedsSlot(false);
        }
        if (functionNode.isNamedFunctionExpression() && !functionNode.usesSelfSymbol() && (selfSymbol = functionNode.getBody().getExistingSymbol(functionNode.getIdent().getName())) != null && selfSymbol.isFunctionSelf()) {
            selfSymbol.setNeedsSlot(false);
            selfSymbol.clearFlag(2);
        }
        return functionNode;
    }

    public AssignSymbols(Compiler compiler) {
        this.compiler = compiler;
        this.log = this.initLogger(compiler.getContext());
        this.debug = this.log.isEnabled();
        this.isOnDemand = compiler.isOnDemandCompilation();
    }

    @Override
    public DebugLogger getLogger() {
        return this.log;
    }

    @Override
    public DebugLogger initLogger(Context context) {
        return context.getLogger((Class<? extends Loggable>)this.getClass());
    }

    private void acceptDeclarations(final Block body) {
        body.accept(new SimpleNodeVisitor(){

            @Override
            protected boolean enterDefault(Node node) {
                return !(node instanceof Expression);
            }

            @Override
            public Node leaveVarNode(VarNode varNode) {
                IdentNode ident = varNode.getName();
                boolean blockScoped = varNode.isBlockScoped();
                if (blockScoped && this.lc.inUnprotectedSwitchContext()) {
                    AssignSymbols.this.throwUnprotectedSwitchError(varNode);
                }
                Block block = blockScoped ? this.lc.getCurrentBlock() : body;
                Symbol symbol = AssignSymbols.this.defineSymbol(block, ident.getName(), ident, varNode.getSymbolFlags());
                if (varNode.isFunctionDeclaration()) {
                    symbol.setIsFunctionDeclaration();
                }
                return varNode.setName(ident.setSymbol(symbol));
            }
        });
    }

    private IdentNode compilerConstantIdentifier(CompilerConstants cc) {
        return this.createImplicitIdentifier(cc.symbolName()).setSymbol(this.lc.getCurrentFunction().compilerConstant(cc));
    }

    private IdentNode createImplicitIdentifier(String name) {
        FunctionNode fn = this.lc.getCurrentFunction();
        return new IdentNode(fn.getToken(), fn.getFinish(), name);
    }

    private Symbol createSymbol(String name, int flags) {
        if ((flags & 3) == 1) {
            Symbol global = (Symbol)this.globalSymbols.get((Object)name);
            if (global == null) {
                global = new Symbol(name, flags);
                this.globalSymbols.put((Object)name, (Object)global);
            }
            return global;
        }
        return new Symbol(name, flags);
    }

    private VarNode createSyntheticInitializer(IdentNode name, CompilerConstants initConstant, FunctionNode fn) {
        IdentNode init = this.compilerConstantIdentifier(initConstant);
        assert (init.getSymbol() != null && init.getSymbol().isBytecodeLocal());
        VarNode synthVar = new VarNode(fn.getLineNumber(), fn.getToken(), fn.getFinish(), name, init);
        Symbol nameSymbol = fn.getBody().getExistingSymbol(name.getName());
        assert (nameSymbol != null);
        return (VarNode)synthVar.setName(name.setSymbol(nameSymbol)).accept(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FunctionNode createSyntheticInitializers(FunctionNode functionNode) {
        ArrayList syntheticInitializers = new ArrayList(2);
        Block body = functionNode.getBody();
        this.lc.push(body);
        try {
            if (functionNode.usesSelfSymbol()) {
                syntheticInitializers.add((Object)this.createSyntheticInitializer(functionNode.getIdent(), CompilerConstants.CALLEE, functionNode));
            }
            if (functionNode.needsArguments()) {
                syntheticInitializers.add((Object)this.createSyntheticInitializer(this.createImplicitIdentifier(CompilerConstants.ARGUMENTS_VAR.symbolName()), CompilerConstants.ARGUMENTS, functionNode));
            }
            if (syntheticInitializers.isEmpty()) {
                FunctionNode functionNode2 = functionNode;
                return functionNode2;
            }
            ListIterator it = syntheticInitializers.listIterator();
            while (it.hasNext()) {
                it.set((Object)((VarNode)((VarNode)it.next()).accept(this)));
            }
        }
        finally {
            this.lc.pop(body);
        }
        List<Statement> stmts = body.getStatements();
        ArrayList newStatements = new ArrayList(stmts.size() + syntheticInitializers.size());
        newStatements.addAll((Collection)syntheticInitializers);
        newStatements.addAll(stmts);
        return functionNode.setBody(this.lc, body.setStatements(this.lc, (List<Statement>)newStatements));
    }

    private Symbol defineSymbol(Block block, String name, Node origin, int symbolFlags) {
        boolean isVar;
        FunctionNode function;
        Symbol symbol;
        boolean isGlobal;
        int flags = symbolFlags;
        boolean isBlockScope = (flags & 0x10) != 0 || (flags & 0x20) != 0;
        boolean bl = isGlobal = (flags & 3) == 1;
        if (isBlockScope) {
            symbol = block.getExistingSymbol(name);
            function = this.lc.getCurrentFunction();
        } else {
            symbol = this.findSymbol(block, name);
            function = this.lc.getFunction(block);
        }
        if (isGlobal) {
            flags |= 4;
        }
        if (this.lc.getCurrentFunction().isProgram()) {
            flags |= 0x200;
        }
        boolean isParam = (flags & 3) == 3;
        boolean bl2 = isVar = (flags & 3) == 2;
        if (symbol != null) {
            if (isParam) {
                if (!this.isLocal(function, symbol)) {
                    symbol = null;
                } else if (symbol.isParam()) {
                    this.throwParserException(ECMAErrors.getMessage("syntax.error.duplicate.parameter", name), origin);
                }
            } else if (isVar) {
                if (isBlockScope) {
                    if (symbol.hasBeenDeclared()) {
                        this.throwParserException(ECMAErrors.getMessage("syntax.error.redeclare.variable", name), origin);
                    } else {
                        symbol.setHasBeenDeclared();
                        if (function.isProgram() && function.getBody() == block) {
                            symbol.setIsScope();
                        }
                    }
                } else if ((flags & 0x40) != 0) {
                    symbol = null;
                } else {
                    if (symbol.isBlockScoped() && this.isLocal(this.lc.getCurrentFunction(), symbol)) {
                        this.throwParserException(ECMAErrors.getMessage("syntax.error.redeclare.variable", name), origin);
                    }
                    if (!this.isLocal(function, symbol) || symbol.less(2)) {
                        symbol = null;
                    }
                }
            }
        }
        if (symbol == null) {
            Block symbolBlock = isVar && ((flags & 0x40) != 0 || isBlockScope) ? block : (isGlobal ? this.lc.getOutermostFunction().getBody() : this.lc.getFunctionBody(function));
            symbol = this.createSymbol(name, flags);
            symbolBlock.putSymbol(symbol);
            if ((flags & 4) == 0) {
                symbol.setNeedsSlot(true);
            }
        } else if (symbol.less(flags)) {
            symbol.setFlags(flags);
        }
        return symbol;
    }

    private <T extends Node> T end(T node) {
        if (this.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("[LEAVE ").append(AssignSymbols.name(node)).append("] ").append(node.toString()).append(" in '").append(this.lc.getCurrentFunction().getName()).append('\'');
            if (node instanceof IdentNode) {
                Symbol symbol = ((IdentNode)node).getSymbol();
                if (symbol == null) {
                    sb.append(" <NO SYMBOL>");
                } else {
                    sb.append(" <symbol=").append((Object)symbol).append('>');
                }
            }
            this.log.unindent();
            this.log.info(sb);
        }
        return node;
    }

    @Override
    public boolean enterBlock(Block block) {
        this.start(block);
        if (this.lc.isFunctionBody()) {
            assert (!block.hasSymbols());
            FunctionNode fn = this.lc.getCurrentFunction();
            if (this.isUnparsedFunction(fn)) {
                for (String name : this.compiler.getScriptFunctionData(fn.getId()).getExternalSymbolNames()) {
                    this.nameIsUsed(name, null);
                }
                assert (block.getStatements().isEmpty());
                return false;
            }
            this.enterFunctionBody();
        }
        return true;
    }

    private boolean isUnparsedFunction(FunctionNode fn) {
        return this.isOnDemand && fn != this.lc.getOutermostFunction();
    }

    @Override
    public boolean enterCatchNode(CatchNode catchNode) {
        IdentNode exception = catchNode.getExceptionIdentifier();
        Block block = this.lc.getCurrentBlock();
        this.start(catchNode);
        String exname = exception.getName();
        boolean isInternal = exname.startsWith(CompilerConstants.EXCEPTION_PREFIX.symbolName());
        Symbol symbol = this.defineSymbol(block, exname, catchNode, 0x12 | (isInternal ? 64 : 0) | 0x2000);
        symbol.clearFlag(16);
        return true;
    }

    private void enterFunctionBody() {
        FunctionNode functionNode = this.lc.getCurrentFunction();
        Block body = this.lc.getCurrentBlock();
        this.initFunctionWideVariables(functionNode, body);
        this.acceptDeclarations(body);
        this.defineFunctionSelfSymbol(functionNode, body);
    }

    private void defineFunctionSelfSymbol(FunctionNode functionNode, Block body) {
        if (!functionNode.isNamedFunctionExpression()) {
            return;
        }
        String name = functionNode.getIdent().getName();
        assert (name != null);
        if (body.getExistingSymbol(name) != null) {
            return;
        }
        this.defineSymbol(body, name, functionNode, 8322);
        if (functionNode.allVarsInScope()) {
            this.lc.setFlag(functionNode, 16384);
        }
    }

    @Override
    public boolean enterFunctionNode(FunctionNode functionNode) {
        this.start(functionNode, false);
        this.thisProperties.push((Object)new HashSet());
        assert (functionNode.getBody() != null);
        return true;
    }

    @Override
    public boolean enterVarNode(VarNode varNode) {
        this.start(varNode);
        if (varNode.isFunctionDeclaration()) {
            this.defineVarIdent(varNode);
        }
        return true;
    }

    @Override
    public Node leaveVarNode(VarNode varNode) {
        if (!varNode.isFunctionDeclaration()) {
            this.defineVarIdent(varNode);
        }
        return super.leaveVarNode(varNode);
    }

    private void defineVarIdent(VarNode varNode) {
        IdentNode ident = varNode.getName();
        int flags = !varNode.isBlockScoped() && this.lc.getCurrentFunction().isProgram() ? 4 : 0;
        this.defineSymbol(this.lc.getCurrentBlock(), ident.getName(), ident, varNode.getSymbolFlags() | flags);
    }

    private Symbol exceptionSymbol() {
        return this.newInternal(CompilerConstants.EXCEPTION_PREFIX);
    }

    private FunctionNode finalizeParameters(FunctionNode functionNode) {
        ArrayList newParams = new ArrayList();
        boolean isVarArg = functionNode.isVarArg();
        Block body = functionNode.getBody();
        for (IdentNode param : functionNode.getParameters()) {
            Symbol paramSymbol = body.getExistingSymbol(param.getName());
            assert (paramSymbol != null);
            assert (paramSymbol.isParam()) : paramSymbol + " " + paramSymbol.getFlags();
            newParams.add((Object)param.setSymbol(paramSymbol));
            if (!isVarArg) continue;
            paramSymbol.setNeedsSlot(false);
        }
        return functionNode.setParameters(this.lc, (List<IdentNode>)newParams);
    }

    private Symbol findSymbol(Block block, String name) {
        Iterator<Block> blocks = this.lc.getBlocks(block);
        while (blocks.hasNext()) {
            Symbol symbol = ((Block)blocks.next()).getExistingSymbol(name);
            if (symbol == null) continue;
            return symbol;
        }
        return null;
    }

    private void functionUsesGlobalSymbol() {
        Iterator<FunctionNode> fns = this.lc.getFunctions();
        while (fns.hasNext()) {
            this.lc.setFlag((LexicalContextNode)fns.next(), 512);
        }
    }

    private void functionUsesScopeSymbol(Symbol symbol) {
        String name = symbol.getName();
        Iterator<LexicalContextNode> contextNodeIter = this.lc.getAllNodes();
        while (contextNodeIter.hasNext()) {
            LexicalContextNode node = (LexicalContextNode)contextNodeIter.next();
            if (node instanceof Block) {
                Block block = (Block)node;
                if (block.getExistingSymbol(name) == null) continue;
                assert (this.lc.contains(block));
                this.lc.setBlockNeedsScope(block);
                break;
            }
            if (!(node instanceof FunctionNode)) continue;
            this.lc.setFlag(node, 512);
        }
    }

    private void functionUsesSymbol(Symbol symbol) {
        assert (symbol != null);
        if (symbol.isScope()) {
            if (symbol.isGlobal()) {
                this.functionUsesGlobalSymbol();
            } else {
                this.functionUsesScopeSymbol(symbol);
            }
        } else assert (!symbol.isGlobal());
    }

    private void initCompileConstant(CompilerConstants cc, Block block, int flags) {
        this.defineSymbol(block, cc.symbolName(), null, flags).setNeedsSlot(true);
    }

    private void initFunctionWideVariables(FunctionNode functionNode, Block body) {
        this.initCompileConstant(CompilerConstants.CALLEE, body, 8259);
        this.initCompileConstant(CompilerConstants.THIS, body, 8203);
        if (functionNode.isVarArg()) {
            this.initCompileConstant(CompilerConstants.VARARGS, body, 8259);
            if (functionNode.needsArguments()) {
                this.initCompileConstant(CompilerConstants.ARGUMENTS, body, 8258);
                this.defineSymbol(body, CompilerConstants.ARGUMENTS_VAR.symbolName(), null, 8194);
            }
        }
        this.initParameters(functionNode, body);
        this.initCompileConstant(CompilerConstants.SCOPE, body, 8258);
        this.initCompileConstant(CompilerConstants.RETURN, body, 66);
    }

    private void initParameters(FunctionNode functionNode, Block body) {
        boolean isVarArg = functionNode.isVarArg();
        boolean scopeParams = functionNode.allVarsInScope() || isVarArg;
        for (IdentNode param : functionNode.getParameters()) {
            Symbol symbol = this.defineSymbol(body, param.getName(), param, 3);
            if (!scopeParams) continue;
            symbol.setIsScope();
            assert (symbol.hasSlot());
            if (!isVarArg) continue;
            symbol.setNeedsSlot(false);
        }
    }

    private boolean isLocal(FunctionNode function, Symbol symbol) {
        FunctionNode definingFn = this.lc.getDefiningFunction(symbol);
        assert (definingFn != null);
        return definingFn == function;
    }

    @Override
    public Node leaveBinaryNode(BinaryNode binaryNode) {
        if (binaryNode.isTokenType(TokenType.ASSIGN)) {
            return this.leaveASSIGN(binaryNode);
        }
        return super.leaveBinaryNode(binaryNode);
    }

    private Node leaveASSIGN(BinaryNode binaryNode) {
        Symbol symbol;
        AccessNode accessNode;
        Expression base;
        Expression lhs = binaryNode.lhs();
        if (lhs instanceof AccessNode && (base = (accessNode = (AccessNode)lhs).getBase()) instanceof IdentNode && (symbol = ((IdentNode)base).getSymbol()).isThis()) {
            ((Set)this.thisProperties.peek()).add((Object)accessNode.getProperty());
        }
        return binaryNode;
    }

    @Override
    public Node leaveUnaryNode(UnaryNode unaryNode) {
        if (unaryNode.tokenType() == TokenType.TYPEOF) {
            return this.leaveTYPEOF(unaryNode);
        }
        return super.leaveUnaryNode(unaryNode);
    }

    @Override
    public Node leaveForNode(ForNode forNode) {
        if (forNode.isForInOrOf()) {
            return forNode.setIterator(this.lc, this.newInternal(CompilerConstants.ITERATOR_PREFIX));
        }
        return this.end(forNode);
    }

    @Override
    public Node leaveFunctionNode(FunctionNode functionNode) {
        FunctionNode finalizedFunction = this.isUnparsedFunction(functionNode) ? functionNode : this.markProgramBlock(AssignSymbols.removeUnusedSlots(this.createSyntheticInitializers(this.finalizeParameters(this.lc.applyTopFlags(functionNode)))).setThisProperties(this.lc, ((Set)this.thisProperties.pop()).size()));
        return finalizedFunction;
    }

    @Override
    public Node leaveIdentNode(IdentNode identNode) {
        if (identNode.isPropertyName()) {
            return identNode;
        }
        Symbol symbol = this.nameIsUsed(identNode.getName(), identNode);
        if (!identNode.isInitializedHere()) {
            symbol.increaseUseCount();
        }
        IdentNode newIdentNode = identNode.setSymbol(symbol);
        if (symbol.isBlockScoped() && !symbol.hasBeenDeclared() && !identNode.isDeclaredHere() && this.isLocal(this.lc.getCurrentFunction(), symbol)) {
            newIdentNode = newIdentNode.markDead();
        }
        return this.end(newIdentNode);
    }

    private Symbol nameIsUsed(String name, IdentNode origin) {
        Block block = this.lc.getCurrentBlock();
        Symbol symbol = this.findSymbol(block, name);
        if (symbol != null) {
            this.log.info("Existing symbol = ", symbol);
            if (symbol.isFunctionSelf()) {
                FunctionNode functionNode = this.lc.getDefiningFunction(symbol);
                assert (functionNode != null);
                assert (this.lc.getFunctionBody(functionNode).getExistingSymbol(CompilerConstants.CALLEE.symbolName()) != null);
                this.lc.setFlag(functionNode, 16384);
            }
            this.maybeForceScope(symbol);
        } else {
            this.log.info("No symbol exists. Declare as global: ", name);
            symbol = this.defineSymbol(block, name, origin, 5);
        }
        this.functionUsesSymbol(symbol);
        return symbol;
    }

    @Override
    public Node leaveSwitchNode(SwitchNode switchNode) {
        if (!switchNode.isUniqueInteger()) {
            return switchNode.setTag(this.lc, this.newInternal(CompilerConstants.SWITCH_TAG_PREFIX));
        }
        return switchNode;
    }

    @Override
    public Node leaveTryNode(TryNode tryNode) {
        assert (tryNode.getFinallyBody() == null);
        this.end(tryNode);
        return tryNode.setException(this.lc, this.exceptionSymbol());
    }

    private Node leaveTYPEOF(UnaryNode unaryNode) {
        Expression rhs = unaryNode.getExpression();
        ArrayList args = new ArrayList();
        if (rhs instanceof IdentNode && !AssignSymbols.isParamOrVar((IdentNode)rhs)) {
            args.add((Object)this.compilerConstantIdentifier(CompilerConstants.SCOPE));
            args.add(LiteralNode.newInstance((Node)rhs, ((IdentNode)rhs).getName()));
        } else {
            args.add((Object)rhs);
            args.add(LiteralNode.newInstance(unaryNode));
        }
        RuntimeNode runtimeNode = new RuntimeNode((Expression)unaryNode, RuntimeNode.Request.TYPEOF, (List<Expression>)args);
        this.end(unaryNode);
        return runtimeNode;
    }

    private FunctionNode markProgramBlock(FunctionNode functionNode) {
        if (this.isOnDemand || !functionNode.isProgram()) {
            return functionNode;
        }
        return functionNode.setBody(this.lc, functionNode.getBody().setFlag(this.lc, 8));
    }

    private void maybeForceScope(Symbol symbol) {
        if (!symbol.isScope() && this.symbolNeedsToBeScope(symbol)) {
            Symbol.setSymbolIsScope(this.lc, symbol);
        }
    }

    private Symbol newInternal(CompilerConstants cc) {
        return this.defineSymbol(this.lc.getCurrentBlock(), this.lc.getCurrentFunction().uniqueName(cc.symbolName()), null, 8258);
    }

    private void start(Node node) {
        this.start(node, true);
    }

    private void start(Node node, boolean printNode) {
        if (this.debug) {
            StringBuilder sb = new StringBuilder();
            sb.append("[ENTER ").append(AssignSymbols.name(node)).append("] ").append(printNode ? node.toString() : "").append(" in '").append(this.lc.getCurrentFunction().getName()).append("'");
            this.log.info(sb);
            this.log.indent();
        }
    }

    private boolean symbolNeedsToBeScope(Symbol symbol) {
        if (symbol.isThis() || symbol.isInternal()) {
            return false;
        }
        FunctionNode func = this.lc.getCurrentFunction();
        if (func.allVarsInScope() || !symbol.isBlockScoped() && func.isProgram()) {
            return true;
        }
        boolean previousWasBlock = false;
        Iterator<LexicalContextNode> it = this.lc.getAllNodes();
        while (it.hasNext()) {
            LexicalContextNode node = (LexicalContextNode)it.next();
            if (node instanceof FunctionNode || AssignSymbols.isSplitLiteral(node)) {
                return true;
            }
            if (node instanceof WithNode) {
                if (previousWasBlock) {
                    return true;
                }
                previousWasBlock = false;
                continue;
            }
            if (node instanceof Block) {
                if (((Block)node).getExistingSymbol(symbol.getName()) == symbol) {
                    return false;
                }
                previousWasBlock = true;
                continue;
            }
            previousWasBlock = false;
        }
        throw new AssertionError();
    }

    private static boolean isSplitLiteral(LexicalContextNode expr) {
        return expr instanceof Splittable && ((Splittable)((Object)expr)).getSplitRanges() != null;
    }

    private void throwUnprotectedSwitchError(VarNode varNode) {
        String msg = ECMAErrors.getMessage("syntax.error.unprotected.switch.declaration", varNode.isLet() ? "let" : "const");
        this.throwParserException(msg, varNode);
    }

    private void throwParserException(String message, Node origin) {
        if (origin == null) {
            throw new ParserException(message);
        }
        Source source2 = this.compiler.getSource();
        long token = origin.getToken();
        int line = source2.getLine(origin.getStart());
        int column = source2.getColumn(origin.getStart());
        String formatted = ErrorManager.format(message, source2, line, column, token);
        throw new ParserException(JSErrorType.SYNTAX_ERROR, formatted, source2, line, column, token);
    }
}


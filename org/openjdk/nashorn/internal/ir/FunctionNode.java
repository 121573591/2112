/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package org.openjdk.nashorn.internal.ir;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.openjdk.nashorn.internal.codegen.CompileUnit;
import org.openjdk.nashorn.internal.codegen.CompilerConstants;
import org.openjdk.nashorn.internal.codegen.Namespace;
import org.openjdk.nashorn.internal.codegen.types.Type;
import org.openjdk.nashorn.internal.ir.Block;
import org.openjdk.nashorn.internal.ir.CompileUnitHolder;
import org.openjdk.nashorn.internal.ir.Expression;
import org.openjdk.nashorn.internal.ir.Flags;
import org.openjdk.nashorn.internal.ir.IdentNode;
import org.openjdk.nashorn.internal.ir.LexicalContext;
import org.openjdk.nashorn.internal.ir.LexicalContextExpression;
import org.openjdk.nashorn.internal.ir.Module;
import org.openjdk.nashorn.internal.ir.Node;
import org.openjdk.nashorn.internal.ir.Symbol;
import org.openjdk.nashorn.internal.ir.annotations.Ignore;
import org.openjdk.nashorn.internal.ir.annotations.Immutable;
import org.openjdk.nashorn.internal.ir.visitor.NodeVisitor;
import org.openjdk.nashorn.internal.parser.Token;
import org.openjdk.nashorn.internal.runtime.ScriptFunction;
import org.openjdk.nashorn.internal.runtime.Source;

@Immutable
public final class FunctionNode
extends LexicalContextExpression
implements Flags<FunctionNode>,
CompileUnitHolder {
    private static final long serialVersionUID = 1L;
    public static final Type FUNCTION_TYPE = Type.typeFor(ScriptFunction.class);
    private final transient Source source;
    private final Object endParserState;
    @Ignore
    private final IdentNode ident;
    private final Block body;
    private final String name;
    private final CompileUnit compileUnit;
    private final Kind kind;
    private final List<IdentNode> parameters;
    private final Map<IdentNode, Expression> parameterExpressions;
    private final long firstToken;
    private final long lastToken;
    private final transient Namespace namespace;
    @Ignore
    private final int thisProperties;
    private final int flags;
    private final int lineNumber;
    private final Class<?> rootClass;
    private final Module module;
    private final int debugFlags;
    public static final int IS_ANONYMOUS = 1;
    public static final int IS_DECLARED = 2;
    public static final int IS_STRICT = 4;
    public static final int USES_ARGUMENTS = 8;
    public static final int IS_SPLIT = 16;
    public static final int HAS_EVAL = 32;
    public static final int HAS_NESTED_EVAL = 64;
    public static final int HAS_SCOPE_BLOCK = 128;
    public static final int DEFINES_ARGUMENTS = 256;
    public static final int USES_ANCESTOR_SCOPE = 512;
    public static final int HAS_FUNCTION_DECLARATIONS = 1024;
    public static final int IS_DEOPTIMIZABLE = 2048;
    public static final int HAS_APPLY_TO_CALL_SPECIALIZATION = 4096;
    public static final int IS_PROGRAM = 8192;
    public static final int USES_SELF_SYMBOL = 16384;
    public static final int USES_THIS = 32768;
    public static final int IN_DYNAMIC_CONTEXT = 65536;
    public static final int NEEDS_CALLEE = 131072;
    public static final int IS_CACHED = 262144;
    public static final int ES6_HAS_DIRECT_SUPER = 524288;
    public static final int ES6_USES_SUPER = 0x100000;
    public static final int ES6_IS_METHOD = 0x200000;
    public static final int ES6_IS_CLASS_CONSTRUCTOR = 0x400000;
    public static final int ES6_IS_SUBCLASS_CONSTRUCTOR = 0x800000;
    public static final int ES6_IS_STRONG = 0x1000000;
    public static final int ES6_USES_NEW_TARGET = 0x2000000;
    public static final int HAS_EXPRESSION_BODY = 0x4000000;
    private static final int HAS_DEEP_EVAL = 96;
    public static final int HAS_ALL_VARS_IN_SCOPE = 96;
    private static final int MAYBE_NEEDS_ARGUMENTS = 40;
    public static final int NEEDS_PARENT_SCOPE = 8800;
    public static final int DEBUG_PRINT_PARSE = 1;
    public static final int DEBUG_PRINT_LOWER_PARSE = 2;
    public static final int DEBUG_PRINT_AST = 4;
    public static final int DEBUG_PRINT_LOWER_AST = 8;
    public static final int DEBUG_PRINT_SYMBOLS = 16;
    public static final int DEBUG_PROFILE = 32;
    public static final int DEBUG_TRACE_ENTEREXIT = 64;
    public static final int DEBUG_TRACE_MISSES = 128;
    public static final int DEBUG_TRACE_VALUES = 256;
    public static final int DEBUG_CALLSITE_FLAGS = 511;
    public Type returnType = Type.UNKNOWN;

    public FunctionNode(Source source2, int lineNumber, long token, int finish, long firstToken, long lastToken, Namespace namespace, IdentNode ident, String name, List<IdentNode> parameters, Map<IdentNode, Expression> paramExprs, Kind kind, int flags, Block body, Object endParserState, Module module, int debugFlags) {
        super(token, finish);
        this.source = source2;
        this.lineNumber = lineNumber;
        this.ident = ident;
        this.name = name;
        this.kind = kind;
        this.parameters = parameters;
        this.parameterExpressions = paramExprs;
        this.firstToken = firstToken;
        this.lastToken = lastToken;
        this.namespace = namespace;
        this.flags = flags;
        this.compileUnit = null;
        this.body = body;
        this.thisProperties = 0;
        this.rootClass = null;
        this.endParserState = endParserState;
        this.module = module;
        this.debugFlags = debugFlags;
    }

    private FunctionNode(FunctionNode functionNode, long lastToken, Object endParserState, int flags, String name, Type returnType, CompileUnit compileUnit, Block body, List<IdentNode> parameters, int thisProperties, Class<?> rootClass, Source source2, Namespace namespace) {
        super(functionNode);
        this.endParserState = endParserState;
        this.lineNumber = functionNode.lineNumber;
        this.flags = flags;
        this.name = name;
        this.returnType = returnType;
        this.compileUnit = compileUnit;
        this.lastToken = lastToken;
        this.body = body;
        this.parameters = parameters;
        this.parameterExpressions = functionNode.parameterExpressions;
        this.thisProperties = thisProperties;
        this.rootClass = rootClass;
        this.source = source2;
        this.namespace = namespace;
        this.ident = functionNode.ident;
        this.kind = functionNode.kind;
        this.firstToken = functionNode.firstToken;
        this.module = functionNode.module;
        this.debugFlags = functionNode.debugFlags;
    }

    @Override
    public Node accept(LexicalContext lc, NodeVisitor<? extends LexicalContext> visitor) {
        if (visitor.enterFunctionNode(this)) {
            return visitor.leaveFunctionNode(this.setBody(lc, (Block)this.body.accept(visitor)));
        }
        return this;
    }

    public List<IdentNode> visitParameters(NodeVisitor<? extends LexicalContext> visitor) {
        return Node.accept(visitor, this.parameters);
    }

    public int getCallSiteFlags() {
        int callsiteFlags = 0;
        if (this.getFlag(4)) {
            callsiteFlags |= 0x20;
        }
        if ((this.debugFlags & 0x1FF) == 0) {
            return callsiteFlags;
        }
        if (this.getDebugFlag(32)) {
            callsiteFlags |= 0x400;
        }
        if (this.getDebugFlag(128)) {
            callsiteFlags |= 0x1800;
        }
        if (this.getDebugFlag(256)) {
            callsiteFlags |= 0x6800;
        }
        if (this.getDebugFlag(64)) {
            callsiteFlags |= 0x2800;
        }
        return callsiteFlags;
    }

    public Source getSource() {
        return this.source;
    }

    public FunctionNode initializeDeserialized(Source source2, Namespace namespace) {
        if (source2 == null || namespace == null) {
            throw new IllegalArgumentException();
        }
        if (this.source == source2 && this.namespace == namespace) {
            return this;
        }
        if (this.source != null || this.namespace != null) {
            throw new IllegalStateException();
        }
        return new FunctionNode(this, this.lastToken, this.endParserState, this.flags, this.name, this.returnType, this.compileUnit, this.body, this.parameters, this.thisProperties, this.rootClass, source2, namespace);
    }

    public int getId() {
        return this.isProgram() ? -1 : Token.descPosition(this.firstToken);
    }

    public String getSourceName() {
        return FunctionNode.getSourceName(this.source);
    }

    public static String getSourceName(Source source2) {
        String explicitURL = source2.getExplicitURL();
        return explicitURL != null ? explicitURL : source2.getName();
    }

    /*
     * Exception decompiling
     */
    public static int getDirectiveFlag(String directive) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getString(Unknown Source:34)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$600(Unknown Source:0)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(Unknown Source:67)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(Unknown Source:12)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(Unknown Source:8)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(Unknown Source:13)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(Unknown Source:2)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(Unknown Source:648)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(Unknown Source:36)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(Unknown Source:1503)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(Unknown Source:6)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(Unknown Source:94)
         *     at android.s.ۥۣۢۧ.ۥ۟۟(Unknown Source:10)
         *     at org.benf.cfr.reader.entities.Method.ۥ۟۟۟(Unknown Source:4)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۤ(Unknown Source:91)
         *     at org.benf.cfr.reader.entities.ۥ.ۥ۟۟ۨ(Unknown Source:0)
         *     at android.s.ۦۦ۟.ۥ۟۟۟(Unknown Source:190)
         *     at android.s.ۦۦ۟.ۥ۟۟(Unknown Source:144)
         *     at android.s.ۥۧۥ۟.ۥ(Unknown Source:107)
         *     at android.s.ۥۦۨۡ.ۥ(Unknown Source:83)
         *     at com.efs.sdk.pa.a.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁣⁠⁠⁤⁠⁠⁣⁣⁣⁣⁣⁠.⁣⁤⁠⁠⁠⁠⁣⁣⁣⁠⁠⁤⁠⁣⁤⁤⁠⁤⁤⁠⁠⁠⁣⁣⁠(Unknown Source:8)
         *     at android.s.ۥۦۨ۠.ۥ۟(Unknown Source:53)
         *     at org.apache.commons.lang3.builder.⁣⁣⁣⁣⁣⁠⁤⁠⁤⁤⁣⁣⁣⁣⁤⁤⁤⁠⁤⁤⁤⁠⁤⁠⁠⁠⁣.⁣⁤⁠⁠⁠⁣⁤⁤⁣⁤⁤⁤⁣⁤⁠⁠⁤⁤⁤⁠⁤⁤⁠⁠⁣⁠⁠⁠⁣⁣⁣(Unknown Source:10)
         *     at android.s.ۥۦۨ۠.ۥ(Unknown Source:99)
         *     at org.apache.xerces.xni.parser.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁣⁤⁤⁠⁤⁤.⁠⁣⁤⁣⁤⁠⁣⁤⁠⁠⁠⁣⁣⁤⁤⁣⁠(Unknown Source:8)
         *     at android.s.go$ۥ۟۟۠$ۥ.run(Unknown Source:92)
         *     at java.lang.Thread.run(Thread.java:1012)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String uniqueName(String base) {
        return this.namespace.uniqueName(base);
    }

    @Override
    public void toString(StringBuilder sb, boolean printTypes) {
        sb.append('[').append((Object)this.returnType).append(']').append(' ');
        sb.append("function");
        if (this.ident != null) {
            sb.append(' ');
            this.ident.toString(sb, printTypes);
        }
        sb.append('(');
        Iterator iter = this.parameters.iterator();
        while (iter.hasNext()) {
            IdentNode parameter = (IdentNode)iter.next();
            if (parameter.getSymbol() != null) {
                sb.append('[').append((Object)parameter.getType()).append(']').append(' ');
            }
            parameter.toString(sb, printTypes);
            if (!iter.hasNext()) continue;
            sb.append(", ");
        }
        sb.append(')');
    }

    @Override
    public int getFlags() {
        return this.flags;
    }

    @Override
    public boolean getFlag(int flag) {
        return (this.flags & flag) != 0;
    }

    @Override
    public FunctionNode setFlags(LexicalContext lc, int flags) {
        if (this.flags == flags) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, flags, this.name, this.returnType, this.compileUnit, this.body, this.parameters, this.thisProperties, this.rootClass, this.source, this.namespace));
    }

    @Override
    public FunctionNode clearFlag(LexicalContext lc, int flag) {
        return this.setFlags(lc, this.flags & ~flag);
    }

    @Override
    public FunctionNode setFlag(LexicalContext lc, int flag) {
        return this.setFlags(lc, this.flags | flag);
    }

    public int getDebugFlags() {
        return this.debugFlags;
    }

    public boolean getDebugFlag(int debugFlag) {
        return (this.debugFlags & debugFlag) != 0;
    }

    public boolean isProgram() {
        return this.getFlag(8192);
    }

    public boolean canBeDeoptimized() {
        return this.getFlag(2048);
    }

    public boolean hasEval() {
        return this.getFlag(32);
    }

    public boolean hasNestedEval() {
        return this.getFlag(64);
    }

    public long getFirstToken() {
        return this.firstToken;
    }

    public boolean hasDeclaredFunctions() {
        return this.getFlag(1024);
    }

    public boolean needsCallee() {
        return this.needsParentScope() || this.usesSelfSymbol() || this.isSplit() || (this.needsArguments() || this.hasApplyToCallSpecialization()) && !this.isStrict();
    }

    public boolean usesThis() {
        return this.getFlag(32768);
    }

    public boolean hasApplyToCallSpecialization() {
        return this.getFlag(4096);
    }

    public IdentNode getIdent() {
        return this.ident;
    }

    public Block getBody() {
        return this.body;
    }

    public FunctionNode setBody(LexicalContext lc, Block body) {
        if (this.body == body) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags | (body.needsScope() ? 128 : 0), this.name, this.returnType, this.compileUnit, body, this.parameters, this.thisProperties, this.rootClass, this.source, this.namespace));
    }

    public boolean isVarArg() {
        return this.needsArguments() || this.parameters.size() > 125;
    }

    public boolean inDynamicContext() {
        return this.getFlag(65536);
    }

    public boolean needsDynamicScope() {
        return this.hasEval() && !this.isStrict();
    }

    public FunctionNode setInDynamicContext(LexicalContext lc) {
        return this.setFlag(lc, 65536);
    }

    public boolean needsArguments() {
        return this.getFlag(40) && !this.getFlag(256) && !this.isProgram();
    }

    public boolean needsParentScope() {
        return this.getFlag(8800);
    }

    public FunctionNode setThisProperties(LexicalContext lc, int thisProperties) {
        if (this.thisProperties == thisProperties) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags, this.name, this.returnType, this.compileUnit, this.body, this.parameters, thisProperties, this.rootClass, this.source, this.namespace));
    }

    public int getThisProperties() {
        return this.thisProperties;
    }

    public boolean hasScopeBlock() {
        return this.getFlag(128);
    }

    public Kind getKind() {
        return this.kind;
    }

    public long getLastToken() {
        return this.lastToken;
    }

    public Object getEndParserState() {
        return this.endParserState;
    }

    public String getName() {
        return this.name;
    }

    public FunctionNode setName(LexicalContext lc, String name) {
        if (this.name.equals((Object)name)) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags, name, this.returnType, this.compileUnit, this.body, this.parameters, this.thisProperties, this.rootClass, this.source, this.namespace));
    }

    public boolean allVarsInScope() {
        return this.getFlag(96);
    }

    public boolean isSplit() {
        return this.getFlag(16);
    }

    public List<IdentNode> getParameters() {
        return Collections.unmodifiableList(this.parameters);
    }

    public Map<IdentNode, Expression> getParameterExpressions() {
        return this.parameterExpressions;
    }

    public int getNumOfParams() {
        return this.parameters.size();
    }

    public IdentNode getParameter(int index) {
        return (IdentNode)this.parameters.get(index);
    }

    public FunctionNode setParameters(LexicalContext lc, List<IdentNode> parameters) {
        if (this.parameters == parameters) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags, this.name, this.returnType, this.compileUnit, this.body, parameters, this.thisProperties, this.rootClass, this.source, this.namespace));
    }

    public boolean isDeclared() {
        return this.getFlag(2);
    }

    public boolean isAnonymous() {
        return this.getFlag(1);
    }

    public boolean usesSelfSymbol() {
        return this.getFlag(16384);
    }

    public boolean isNamedFunctionExpression() {
        return !this.getFlag(8195);
    }

    @Override
    public Type getType() {
        return FUNCTION_TYPE;
    }

    @Override
    public Type getWidestOperationType() {
        return FUNCTION_TYPE;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public FunctionNode setReturnType(LexicalContext lc, Type returnType) {
        Type type;
        Type type2 = type = returnType.isObject() ? Type.OBJECT : returnType;
        if (this.returnType == type) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags, this.name, type, this.compileUnit, this.body, this.parameters, this.thisProperties, this.rootClass, this.source, this.namespace));
    }

    public boolean isStrict() {
        return this.getFlag(4);
    }

    public boolean isCached() {
        return this.getFlag(262144);
    }

    public FunctionNode setCached(LexicalContext lc) {
        return this.setFlag(lc, 262144);
    }

    public boolean isStrong() {
        return this.getFlag(0x1000000);
    }

    public boolean isMethod() {
        return this.getFlag(0x200000);
    }

    public boolean usesSuper() {
        return this.getFlag(0x100000);
    }

    public boolean hasDirectSuper() {
        return this.getFlag(524288);
    }

    public boolean isClassConstructor() {
        return this.getFlag(0x400000);
    }

    public boolean isSubclassConstructor() {
        return this.getFlag(0x800000);
    }

    public boolean usesNewTarget() {
        return this.getFlag(0x2000000);
    }

    public boolean isModule() {
        return this.kind == Kind.MODULE;
    }

    public Module getModule() {
        return this.module;
    }

    @Override
    public CompileUnit getCompileUnit() {
        return this.compileUnit;
    }

    public FunctionNode setCompileUnit(LexicalContext lc, CompileUnit compileUnit) {
        if (this.compileUnit == compileUnit) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags, this.name, this.returnType, compileUnit, this.body, this.parameters, this.thisProperties, this.rootClass, this.source, this.namespace));
    }

    public Symbol compilerConstant(CompilerConstants cc) {
        return this.body.getExistingSymbol(cc.symbolName());
    }

    public Class<?> getRootClass() {
        return this.rootClass;
    }

    public FunctionNode setRootClass(LexicalContext lc, Class<?> rootClass) {
        if (this.rootClass == rootClass) {
            return this;
        }
        return Node.replaceInLexicalContext(lc, this, new FunctionNode(this, this.lastToken, this.endParserState, this.flags, this.name, this.returnType, this.compileUnit, this.body, this.parameters, this.thisProperties, rootClass, this.source, this.namespace));
    }

    public static enum Kind {
        NORMAL,
        SCRIPT,
        GETTER,
        SETTER,
        ARROW,
        GENERATOR,
        MODULE;

    }
}


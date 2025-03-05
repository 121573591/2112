/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.RuntimePermission
 *  java.lang.SecurityManager
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.security.Permission
 *  java.util.List
 *  java.util.Objects
 *  javax.script.ScriptEngine
 *  javax.script.ScriptEngineFactory
 */
package org.openjdk.nashorn.api.scripting;

import java.security.Permission;
import java.util.List;
import java.util.Objects;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import org.openjdk.nashorn.api.scripting.ClassFilter;
import org.openjdk.nashorn.api.scripting.NashornScriptEngine;
import org.openjdk.nashorn.internal.parser.JSONParser;
import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.Version;

public final class NashornScriptEngineFactory
implements ScriptEngineFactory {
    private static final String[] DEFAULT_OPTIONS = new String[]{"-doe"};
    private static final List<String> names = List.of((Object)"nashorn", (Object)"Nashorn", (Object)"js", (Object)"JS", (Object)"JavaScript", (Object)"javascript", (Object)"ECMAScript", (Object)"ecmascript");
    private static final List<String> mimeTypes = List.of((Object)"application/javascript", (Object)"application/ecmascript", (Object)"text/javascript", (Object)"text/ecmascript");
    private static final List<String> extensions = List.of((Object)"js");

    public String getEngineName() {
        return "OpenJDK Nashorn";
    }

    public String getEngineVersion() {
        return Version.version();
    }

    public List<String> getExtensions() {
        return extensions;
    }

    public String getLanguageName() {
        return "ECMAScript";
    }

    public String getLanguageVersion() {
        return "ECMA - 262 Edition 5.1";
    }

    public String getMethodCallSyntax(String obj, String method, String ... args) {
        StringBuilder sb = new StringBuilder().append((String)Objects.requireNonNull((Object)obj)).append('.').append((String)Objects.requireNonNull((Object)method)).append('(');
        int len = args.length;
        if (len > 0) {
            sb.append((String)Objects.requireNonNull((Object)args[0]));
        }
        for (int i = 1; i < len; ++i) {
            sb.append(',').append((String)Objects.requireNonNull((Object)args[i]));
        }
        sb.append(')');
        return sb.toString();
    }

    public List<String> getMimeTypes() {
        return mimeTypes;
    }

    public List<String> getNames() {
        return names;
    }

    public String getOutputStatement(String toDisplay) {
        return "print(" + JSONParser.quote(toDisplay) + ")";
    }

    /*
     * Exception decompiling
     */
    public Object getParameter(String key) {
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

    public String getProgram(String ... statements) {
        Objects.requireNonNull((Object)statements);
        StringBuilder sb = new StringBuilder();
        for (String statement : statements) {
            sb.append((String)Objects.requireNonNull((Object)statement)).append(';');
        }
        return sb.toString();
    }

    public ScriptEngine getScriptEngine() {
        try {
            return new NashornScriptEngine(this, DEFAULT_OPTIONS, NashornScriptEngineFactory.getAppClassLoader(), null);
        }
        catch (RuntimeException e) {
            if (Context.DEBUG) {
                e.printStackTrace();
            }
            throw e;
        }
    }

    public ScriptEngine getScriptEngine(ClassLoader appLoader) {
        return this.newEngine(DEFAULT_OPTIONS, appLoader, null);
    }

    public ScriptEngine getScriptEngine(ClassFilter classFilter) {
        return this.newEngine(DEFAULT_OPTIONS, NashornScriptEngineFactory.getAppClassLoader(), (ClassFilter)Objects.requireNonNull((Object)classFilter));
    }

    public ScriptEngine getScriptEngine(String ... args) {
        return this.newEngine((String[])Objects.requireNonNull((Object)args), NashornScriptEngineFactory.getAppClassLoader(), null);
    }

    public ScriptEngine getScriptEngine(String[] args, ClassLoader appLoader) {
        return this.newEngine((String[])Objects.requireNonNull((Object)args), appLoader, null);
    }

    public ScriptEngine getScriptEngine(String[] args, ClassLoader appLoader, ClassFilter classFilter) {
        return this.newEngine((String[])Objects.requireNonNull((Object)args), appLoader, (ClassFilter)Objects.requireNonNull((Object)classFilter));
    }

    private ScriptEngine newEngine(String[] args, ClassLoader appLoader, ClassFilter classFilter) {
        NashornScriptEngineFactory.checkConfigPermission();
        try {
            return new NashornScriptEngine(this, args, appLoader, classFilter);
        }
        catch (RuntimeException e) {
            if (Context.DEBUG) {
                e.printStackTrace();
            }
            throw e;
        }
    }

    private static void checkConfigPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission((Permission)new RuntimePermission("nashorn.setConfig"));
        }
    }

    private static ClassLoader getAppClassLoader() {
        return (ClassLoader)Objects.requireNonNullElseGet((Object)Thread.currentThread().getContextClassLoader(), () -> NashornScriptEngineFactory.class.getClassLoader());
    }
}


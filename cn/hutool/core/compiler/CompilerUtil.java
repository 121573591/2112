/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  javax.tools.DiagnosticListener
 *  javax.tools.JavaCompiler
 *  javax.tools.JavaCompiler$CompilationTask
 *  javax.tools.JavaFileManager
 *  javax.tools.JavaFileObject
 *  javax.tools.StandardJavaFileManager
 *  javax.tools.ToolProvider
 */
package cn.hutool.core.compiler;

import cn.hutool.core.compiler.JavaSourceCompiler;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class CompilerUtil {
    public static final JavaCompiler SYSTEM_COMPILER = ToolProvider.getSystemJavaCompiler();

    public static boolean compile(String ... sourceFiles) {
        return 0 == SYSTEM_COMPILER.run(null, null, null, sourceFiles);
    }

    public static StandardJavaFileManager getFileManager() {
        return CompilerUtil.getFileManager(null);
    }

    public static StandardJavaFileManager getFileManager(DiagnosticListener<? super JavaFileObject> diagnosticListener) {
        return SYSTEM_COMPILER.getStandardFileManager(diagnosticListener, null, null);
    }

    public static JavaCompiler.CompilationTask getTask(JavaFileManager fileManager, DiagnosticListener<? super JavaFileObject> diagnosticListener, Iterable<String> options, Iterable<? extends JavaFileObject> compilationUnits) {
        return SYSTEM_COMPILER.getTask(null, fileManager, diagnosticListener, options, null, compilationUnits);
    }

    public static JavaSourceCompiler getCompiler(ClassLoader parent) {
        return JavaSourceCompiler.create(parent);
    }
}


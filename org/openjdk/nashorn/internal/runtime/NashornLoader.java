/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.UncheckedIOException
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalArgumentException
 *  java.lang.Module
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.RuntimePermission
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.net.URLClassLoader
 *  java.security.AccessController
 *  java.security.CodeSource
 *  java.security.Permission
 *  java.security.PermissionCollection
 *  java.security.Permissions
 *  java.security.PrivilegedAction
 *  java.security.SecureClassLoader
 *  java.util.Arrays
 */
package org.openjdk.nashorn.internal.runtime;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.SecureClassLoader;
import java.util.Arrays;
import org.openjdk.nashorn.internal.runtime.Context;

abstract class NashornLoader
extends SecureClassLoader {
    protected static final String OBJECTS_PKG = "org.openjdk.nashorn.internal.objects";
    protected static final String RUNTIME_PKG = "org.openjdk.nashorn.internal.runtime";
    protected static final String RUNTIME_ARRAYS_PKG = "org.openjdk.nashorn.internal.runtime.arrays";
    protected static final String RUNTIME_LINKER_PKG = "org.openjdk.nashorn.internal.runtime.linker";
    protected static final String SCRIPTS_PKG = "org.openjdk.nashorn.internal.scripts";
    static final Module NASHORN_MODULE = Context.class.getModule();
    private static final Permission[] SCRIPT_PERMISSIONS;
    private static final String MODULE_MANIPULATOR_NAME = "org.openjdk.nashorn.internal.scripts.ModuleGraphManipulator";
    private static final byte[] MODULE_MANIPULATOR_BYTES;
    private Method addModuleExport;

    NashornLoader(ClassLoader parent) {
        super(parent);
    }

    void loadModuleManipulator() {
        Class clazz = this.defineClass(MODULE_MANIPULATOR_NAME, MODULE_MANIPULATOR_BYTES, 0, MODULE_MANIPULATOR_BYTES.length);
        try {
            Class.forName((String)MODULE_MANIPULATOR_NAME, (boolean)true, (ClassLoader)this);
        }
        catch (Exception ex) {
            throw new RuntimeException((Throwable)ex);
        }
        PrivilegedAction pa = () -> {
            try {
                this.addModuleExport = clazz.getDeclaredMethod("addExport", new Class[]{Module.class});
                this.addModuleExport.setAccessible(true);
            }
            catch (NoSuchMethodException | SecurityException ex) {
                throw new RuntimeException(ex);
            }
            return null;
        };
        AccessController.doPrivileged((PrivilegedAction)pa);
    }

    final void addModuleExport(Module to) {
        try {
            this.addModuleExport.invoke(null, new Object[]{to});
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

    static boolean isInNamedModule() {
        return NASHORN_MODULE.isNamed();
    }

    /*
     * Exception decompiling
     */
    protected static void checkPackageAccess(String name) {
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

    protected PermissionCollection getPermissions(CodeSource codesource) {
        Permissions permCollection = new Permissions();
        for (Permission perm : SCRIPT_PERMISSIONS) {
            permCollection.add(perm);
        }
        return permCollection;
    }

    static ClassLoader createClassLoader(String classPath, ClassLoader parent) {
        URL[] urls2 = NashornLoader.pathToURLs(classPath);
        return URLClassLoader.newInstance((URL[])urls2, (ClassLoader)parent);
    }

    private static URL[] pathToURLs(String path) {
        Object[] components = path.split(File.pathSeparator);
        return (URL[])Arrays.stream((Object[])components).map(File::new).map(NashornLoader::fileToURL).toArray(URL[]::new);
    }

    private static URL fileToURL(File file) {
        String name;
        try {
            name = file.getCanonicalPath();
        }
        catch (IOException e) {
            name = file.getAbsolutePath();
        }
        name = name.replace(File.separatorChar, '/');
        if (!name.startsWith("/")) {
            name = "/" + name;
        }
        if (!file.isFile()) {
            name = name + "/";
        }
        try {
            return new URL("file", "", name);
        }
        catch (MalformedURLException e) {
            throw new IllegalArgumentException("file");
        }
    }

    private static byte[] readModuleManipulatorBytes() {
        PrivilegedAction pa = () -> {
            byte[] byArray;
            block8: {
                String res = "/" + MODULE_MANIPULATOR_NAME.replace('.', '/') + ".class";
                InputStream in = NashornLoader.class.getResourceAsStream(res);
                try {
                    byArray = in.readAllBytes();
                    if (in == null) break block8;
                }
                catch (Throwable throwable) {
                    try {
                        if (in != null) {
                            try {
                                in.close();
                            }
                            catch (Throwable throwable2) {
                                throwable.addSuppressed(throwable2);
                            }
                        }
                        throw throwable;
                    }
                    catch (IOException exp) {
                        throw new UncheckedIOException(exp);
                    }
                }
                in.close();
            }
            return byArray;
        };
        return (byte[])AccessController.doPrivileged((PrivilegedAction)pa);
    }

    static {
        MODULE_MANIPULATOR_BYTES = NashornLoader.readModuleManipulatorBytes();
        SCRIPT_PERMISSIONS = new Permission[]{new RuntimePermission("accessClassInPackage.org.openjdk.nashorn.internal.runtime"), new RuntimePermission("accessClassInPackage.org.openjdk.nashorn.internal.runtime.linker"), new RuntimePermission("accessClassInPackage.org.openjdk.nashorn.internal.objects"), new RuntimePermission("accessClassInPackage.org.openjdk.nashorn.internal.scripts"), new RuntimePermission("accessClassInPackage.org.openjdk.nashorn.internal.runtime.arrays")};
    }
}


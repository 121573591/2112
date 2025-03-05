/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.BufferedOutputStream
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.ObjectInputStream
 *  java.io.ObjectOutputStream
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.AccessController
 *  java.security.PrivilegedActionException
 *  java.util.Map
 */
package org.openjdk.nashorn.internal.runtime;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Map;
import org.openjdk.nashorn.internal.codegen.OptimisticTypesPersistence;
import org.openjdk.nashorn.internal.codegen.types.Type;
import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.FunctionInitializer;
import org.openjdk.nashorn.internal.runtime.ScriptEnvironment;
import org.openjdk.nashorn.internal.runtime.Source;
import org.openjdk.nashorn.internal.runtime.StoredScript;
import org.openjdk.nashorn.internal.runtime.logging.DebugLogger;
import org.openjdk.nashorn.internal.runtime.logging.Loggable;
import org.openjdk.nashorn.internal.runtime.logging.Logger;
import org.openjdk.nashorn.internal.runtime.options.Options;

@Logger(name="codestore")
public abstract class CodeStore
implements Loggable {
    private DebugLogger log;

    protected CodeStore() {
    }

    @Override
    public DebugLogger initLogger(Context context) {
        this.log = context.getLogger((Class<? extends Loggable>)this.getClass());
        return this.log;
    }

    @Override
    public DebugLogger getLogger() {
        return this.log;
    }

    public static CodeStore newCodeStore(Context context) {
        try {
            DirectoryCodeStore store = new DirectoryCodeStore(context);
            store.initLogger(context);
            return store;
        }
        catch (IOException e) {
            context.getLogger(CodeStore.class).warning(new Object[]{"failed to create cache directory ", e});
            return null;
        }
    }

    public StoredScript store(String functionKey, Source source2, String mainClassName, Map<String, byte[]> classBytes, Map<Integer, FunctionInitializer> initializers, Object[] constants, int compilationId) {
        return this.store(functionKey, source2, this.storedScriptFor(source2, mainClassName, classBytes, initializers, constants, compilationId));
    }

    public abstract StoredScript store(String var1, Source var2, StoredScript var3);

    public abstract StoredScript load(Source var1, String var2);

    public StoredScript storedScriptFor(Source source2, String mainClassName, Map<String, byte[]> classBytes, Map<Integer, FunctionInitializer> initializers, Object[] constants, int compilationId) {
        for (Object constant : constants) {
            if (constant instanceof Serializable) continue;
            this.getLogger().warning("cannot store ", source2, " non serializable constant ", constant);
            return null;
        }
        return new StoredScript(compilationId, mainClassName, classBytes, initializers, constants);
    }

    public static String getCacheKey(Object functionId, Type[] paramTypes) {
        StringBuilder b = new StringBuilder().append(functionId);
        if (paramTypes != null && paramTypes.length > 0) {
            b.append('-');
            for (Type t : paramTypes) {
                b.append(Type.getShortSignatureDescriptor(t));
            }
        }
        return b.toString();
    }

    public static class DirectoryCodeStore
    extends CodeStore {
        private static final int DEFAULT_MIN_SIZE = 1000;
        private final File dir;
        private final boolean readOnly;
        private final int minSize;

        public DirectoryCodeStore(Context context) throws IOException {
            this(context, Options.getStringProperty("nashorn.persistent.code.cache", "nashorn_code_cache"), false, 1000);
        }

        public DirectoryCodeStore(Context context, String path, boolean readOnly, int minSize) throws IOException {
            this.dir = DirectoryCodeStore.checkDirectory(path, context.getEnv(), readOnly);
            this.readOnly = readOnly;
            this.minSize = minSize;
        }

        private static File checkDirectory(String path, ScriptEnvironment env, boolean readOnly) throws IOException {
            try {
                return (File)AccessController.doPrivileged(() -> {
                    File dir = new File(path, DirectoryCodeStore.getVersionDir(env)).getAbsoluteFile();
                    if (readOnly) {
                        if (!dir.exists() || !dir.isDirectory()) {
                            throw new IOException("Not a directory: " + dir.getPath());
                        }
                        if (!dir.canRead()) {
                            throw new IOException("Directory not readable: " + dir.getPath());
                        }
                    } else {
                        if (!dir.exists() && !dir.mkdirs()) {
                            throw new IOException("Could not create directory: " + dir.getPath());
                        }
                        if (!dir.isDirectory()) {
                            throw new IOException("Not a directory: " + dir.getPath());
                        }
                        if (!dir.canRead() || !dir.canWrite()) {
                            throw new IOException("Directory not readable or writable: " + dir.getPath());
                        }
                    }
                    return dir;
                });
            }
            catch (PrivilegedActionException e) {
                throw (IOException)((Object)e.getException());
            }
        }

        private static String getVersionDir(ScriptEnvironment env) throws IOException {
            try {
                String versionDir = OptimisticTypesPersistence.getVersionDirName();
                return env._optimistic_types ? versionDir + "_opt" : versionDir;
            }
            catch (Exception e) {
                throw new IOException((Throwable)e);
            }
        }

        @Override
        public StoredScript load(Source source2, String functionKey) {
            if (this.belowThreshold(source2)) {
                return null;
            }
            File file = this.getCacheFile(source2, functionKey);
            try {
                return (StoredScript)AccessController.doPrivileged(() -> {
                    if (!file.exists()) {
                        return null;
                    }
                    try (ObjectInputStream in = new ObjectInputStream((InputStream)new BufferedInputStream((InputStream)new FileInputStream(file)));){
                        StoredScript storedScript = (StoredScript)in.readObject();
                        this.getLogger().info("loaded ", source2, "-", functionKey);
                        StoredScript storedScript2 = storedScript;
                        return storedScript2;
                    }
                });
            }
            catch (PrivilegedActionException e) {
                this.getLogger().warning(new Object[]{"failed to load ", source2, "-", functionKey, ": ", e.getException()});
                return null;
            }
        }

        @Override
        public StoredScript store(String functionKey, Source source2, StoredScript script) {
            if (this.readOnly || script == null || this.belowThreshold(source2)) {
                return null;
            }
            File file = this.getCacheFile(source2, functionKey);
            try {
                return (StoredScript)AccessController.doPrivileged(() -> {
                    try (ObjectOutputStream out = new ObjectOutputStream((OutputStream)new BufferedOutputStream((OutputStream)new FileOutputStream(file)));){
                        out.writeObject((Object)script);
                    }
                    this.getLogger().info("stored ", source2, "-", functionKey);
                    return script;
                });
            }
            catch (PrivilegedActionException e) {
                this.getLogger().warning(new Object[]{"failed to store ", script, "-", functionKey, ": ", e.getException()});
                return null;
            }
        }

        private File getCacheFile(Source source2, String functionKey) {
            return new File(this.dir, source2.getDigest() + "-" + functionKey);
        }

        private boolean belowThreshold(Source source2) {
            if (source2.getLength() < this.minSize) {
                this.getLogger().info("below size threshold ", source2);
                return true;
            }
            return false;
        }
    }
}


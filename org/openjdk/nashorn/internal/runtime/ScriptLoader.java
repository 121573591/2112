/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Module
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.module.ModuleDescriptor
 *  java.lang.module.ModuleDescriptor$Builder
 *  java.lang.module.ModuleDescriptor$Modifier
 *  java.security.CodeSource
 *  java.util.Objects
 *  java.util.Set
 */
package org.openjdk.nashorn.internal.runtime;

import java.lang.module.ModuleDescriptor;
import java.security.CodeSource;
import java.util.Objects;
import java.util.Set;
import org.openjdk.nashorn.internal.runtime.Context;
import org.openjdk.nashorn.internal.runtime.NashornLoader;
import org.openjdk.nashorn.internal.runtime.StructureLoader;

final class ScriptLoader
extends NashornLoader {
    private static final String NASHORN_PKG_PREFIX = "org.openjdk.nashorn.internal.";
    private volatile boolean structureAccessAdded;
    private final Context context;
    private final Module scriptModule;

    Context getContext() {
        return this.context;
    }

    ScriptLoader(Context context) {
        super((ClassLoader)context.getStructLoader());
        this.context = context;
        if (ScriptLoader.isInNamedModule()) {
            this.scriptModule = this.createModule();
            NASHORN_MODULE.addExports("org.openjdk.nashorn.internal.objects", this.scriptModule);
            NASHORN_MODULE.addExports("org.openjdk.nashorn.internal.runtime", this.scriptModule);
            NASHORN_MODULE.addExports("org.openjdk.nashorn.internal.runtime.arrays", this.scriptModule);
            NASHORN_MODULE.addExports("org.openjdk.nashorn.internal.runtime.linker", this.scriptModule);
            NASHORN_MODULE.addExports("org.openjdk.nashorn.internal.scripts", this.scriptModule);
            NASHORN_MODULE.addReads(this.scriptModule);
        } else {
            this.scriptModule = null;
        }
    }

    private Module createModule() {
        Module structMod = this.context.getStructLoader().getModule();
        ModuleDescriptor.Builder builder = ModuleDescriptor.newModule((String)"org.openjdk.nashorn.scripts", (Set)Set.of((Object)ModuleDescriptor.Modifier.SYNTHETIC)).requires("java.logging").requires(NASHORN_MODULE.getName()).requires(structMod.getName()).packages(Set.of((Object)"org.openjdk.nashorn.internal.scripts"));
        if (Context.javaSqlFound) {
            builder.requires("java.sql");
        }
        if (Context.javaSqlRowsetFound) {
            builder.requires("java.sql.rowset");
        }
        ModuleDescriptor descriptor = builder.build();
        Module mod = Context.createModuleTrusted(structMod.getLayer(), descriptor, (ClassLoader)this);
        this.loadModuleManipulator();
        return mod;
    }

    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        ScriptLoader.checkPackageAccess(name);
        Class cl = super.loadClass(name, resolve);
        if (!this.structureAccessAdded && ScriptLoader.isInNamedModule()) {
            StructureLoader structLoader = this.context.getStructLoader();
            if (cl.getClassLoader() == structLoader) {
                this.structureAccessAdded = true;
                structLoader.addModuleExport(this.scriptModule);
            }
        }
        return cl;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        ClassLoader appLoader = this.context.getAppLoader();
        if (appLoader == null || name.startsWith(NASHORN_PKG_PREFIX)) {
            throw new ClassNotFoundException(name);
        }
        return appLoader.loadClass(name);
    }

    synchronized Class<?> installClass(String name, byte[] data, CodeSource cs) {
        return this.defineClass(name, data, 0, data.length, (CodeSource)Objects.requireNonNull((Object)cs));
    }
}


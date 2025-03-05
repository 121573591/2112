/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  javax.tools.FileObject
 *  javax.tools.ForwardingJavaFileManager
 *  javax.tools.JavaFileManager
 *  javax.tools.JavaFileManager$Location
 *  javax.tools.JavaFileObject
 *  javax.tools.JavaFileObject$Kind
 */
package cn.hutool.core.compiler;

import cn.hutool.core.compiler.JavaClassFileObject;
import cn.hutool.core.io.resource.FileObjectResource;
import cn.hutool.core.lang.ResourceClassLoader;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ObjectUtil;
import java.util.HashMap;
import java.util.Map;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

class JavaClassFileManager
extends ForwardingJavaFileManager<JavaFileManager> {
    private final Map<String, FileObjectResource> classFileObjectMap = new HashMap();
    private final ClassLoader parent;

    protected JavaClassFileManager(ClassLoader parent, JavaFileManager fileManager) {
        super(fileManager);
        this.parent = ObjectUtil.defaultIfNull(parent, ClassLoaderUtil::getClassLoader);
    }

    public ClassLoader getClassLoader(JavaFileManager.Location location) {
        return new ResourceClassLoader<FileObjectResource>(this.parent, this.classFileObjectMap);
    }

    public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind, FileObject sibling) {
        JavaClassFileObject javaFileObject = new JavaClassFileObject(className);
        this.classFileObjectMap.put((Object)className, (Object)new FileObjectResource((FileObject)javaFileObject));
        return javaFileObject;
    }
}


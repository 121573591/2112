/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.SecureClassLoader
 *  java.util.HashMap
 *  java.util.Map
 */
package cn.hutool.core.lang;

import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ObjectUtil;
import java.security.SecureClassLoader;
import java.util.HashMap;
import java.util.Map;

public class ResourceClassLoader<T extends Resource>
extends SecureClassLoader {
    private final Map<String, T> resourceMap;
    private final Map<String, Class<?>> cacheClassMap;

    public ResourceClassLoader(ClassLoader parentClassLoader, Map<String, T> resourceMap) {
        super(ObjectUtil.defaultIfNull(parentClassLoader, ClassLoaderUtil::getClassLoader));
        this.resourceMap = (Map)ObjectUtil.defaultIfNull(resourceMap, new HashMap());
        this.cacheClassMap = new HashMap();
    }

    public ResourceClassLoader<T> addResource(T resource) {
        this.resourceMap.put((Object)resource.getName(), resource);
        return this;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = (Class)this.cacheClassMap.computeIfAbsent((Object)name, this::defineByName);
        if (clazz == null) {
            return super.findClass(name);
        }
        return clazz;
    }

    private Class<?> defineByName(String name) {
        Resource resource = (Resource)this.resourceMap.get((Object)name);
        if (null != resource) {
            byte[] bytes = resource.readBytes();
            return this.defineClass(name, bytes, 0, bytes.length);
        }
        return null;
    }
}


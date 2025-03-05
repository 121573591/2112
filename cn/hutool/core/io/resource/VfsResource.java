/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.net.URL
 */
package cn.hutool.core.io.resource;

import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ReflectUtil;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

public class VfsResource
implements Resource {
    private static final String VFS3_PKG = "org.jboss.vfs.";
    private static final Method VIRTUAL_FILE_METHOD_EXISTS;
    private static final Method VIRTUAL_FILE_METHOD_GET_INPUT_STREAM;
    private static final Method VIRTUAL_FILE_METHOD_GET_SIZE;
    private static final Method VIRTUAL_FILE_METHOD_GET_LAST_MODIFIED;
    private static final Method VIRTUAL_FILE_METHOD_TO_URL;
    private static final Method VIRTUAL_FILE_METHOD_GET_NAME;
    private final Object virtualFile;
    private final long lastModified;

    public VfsResource(Object resource) {
        Assert.notNull(resource, "VirtualFile must not be null", new Object[0]);
        this.virtualFile = resource;
        this.lastModified = this.getLastModified();
    }

    public boolean exists() {
        return (Boolean)ReflectUtil.invoke(this.virtualFile, VIRTUAL_FILE_METHOD_EXISTS, new Object[0]);
    }

    @Override
    public String getName() {
        return (String)ReflectUtil.invoke(this.virtualFile, VIRTUAL_FILE_METHOD_GET_NAME, new Object[0]);
    }

    @Override
    public URL getUrl() {
        return (URL)ReflectUtil.invoke(this.virtualFile, VIRTUAL_FILE_METHOD_TO_URL, new Object[0]);
    }

    @Override
    public InputStream getStream() {
        return (InputStream)ReflectUtil.invoke(this.virtualFile, VIRTUAL_FILE_METHOD_GET_INPUT_STREAM, new Object[0]);
    }

    @Override
    public boolean isModified() {
        return this.lastModified != this.getLastModified();
    }

    public long getLastModified() {
        return (Long)ReflectUtil.invoke(this.virtualFile, VIRTUAL_FILE_METHOD_GET_LAST_MODIFIED, new Object[0]);
    }

    public long size() {
        return (Long)ReflectUtil.invoke(this.virtualFile, VIRTUAL_FILE_METHOD_GET_SIZE, new Object[0]);
    }

    static {
        Class<?> virtualFile = ClassLoaderUtil.loadClass("org.jboss.vfs.VirtualFile");
        try {
            VIRTUAL_FILE_METHOD_EXISTS = virtualFile.getMethod("exists", new Class[0]);
            VIRTUAL_FILE_METHOD_GET_INPUT_STREAM = virtualFile.getMethod("openStream", new Class[0]);
            VIRTUAL_FILE_METHOD_GET_SIZE = virtualFile.getMethod("getSize", new Class[0]);
            VIRTUAL_FILE_METHOD_GET_LAST_MODIFIED = virtualFile.getMethod("getLastModified", new Class[0]);
            VIRTUAL_FILE_METHOD_TO_URL = virtualFile.getMethod("toURL", new Class[0]);
            VIRTUAL_FILE_METHOD_GET_NAME = virtualFile.getMethod("getName", new Class[0]);
        }
        catch (NoSuchMethodException ex) {
            throw new IllegalStateException("Could not detect JBoss VFS infrastructure", (Throwable)ex);
        }
    }
}


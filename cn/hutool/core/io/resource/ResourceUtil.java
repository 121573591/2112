/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 *  java.nio.charset.Charset
 *  java.util.Enumeration
 *  java.util.List
 */
package cn.hutool.core.io.resource;

import cn.hutool.core.collection.EnumerationIter;
import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.FileResource;
import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ClassLoaderUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;

public class ResourceUtil {
    public static String readUtf8Str(String resource) {
        return ResourceUtil.getResourceObj(resource).readUtf8Str();
    }

    public static String readStr(String resource, Charset charset) {
        return ResourceUtil.getResourceObj(resource).readStr(charset);
    }

    public static byte[] readBytes(String resource) {
        return ResourceUtil.getResourceObj(resource).readBytes();
    }

    public static InputStream getStream(String resource) throws NoResourceException {
        return ResourceUtil.getResourceObj(resource).getStream();
    }

    public static InputStream getStreamSafe(String resource) {
        try {
            return ResourceUtil.getResourceObj(resource).getStream();
        }
        catch (NoResourceException noResourceException) {
            return null;
        }
    }

    public static BufferedReader getUtf8Reader(String resource) {
        return ResourceUtil.getReader(resource, CharsetUtil.CHARSET_UTF_8);
    }

    public static BufferedReader getReader(String resource, Charset charset) {
        return ResourceUtil.getResourceObj(resource).getReader(charset);
    }

    public static URL getResource(String resource) throws IORuntimeException {
        return ResourceUtil.getResource(resource, null);
    }

    public static List<URL> getResources(String resource) {
        return ResourceUtil.getResources(resource, null);
    }

    public static List<URL> getResources(String resource, Filter<URL> filter) {
        return IterUtil.filterToList(ResourceUtil.getResourceIter(resource), filter);
    }

    public static EnumerationIter<URL> getResourceIter(String resource) {
        return ResourceUtil.getResourceIter(resource, null);
    }

    public static EnumerationIter<URL> getResourceIter(String resource, ClassLoader classLoader) {
        Enumeration resources;
        try {
            resources = ObjUtil.defaultIfNull(classLoader, ClassLoaderUtil::getClassLoader).getResources(resource);
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
        return new EnumerationIter<URL>(resources);
    }

    public static URL getResource(String resource, Class<?> baseClass) {
        resource = StrUtil.nullToEmpty(resource);
        return null != baseClass ? baseClass.getResource(resource) : ClassLoaderUtil.getClassLoader().getResource(resource);
    }

    public static Resource getResourceObj(String path) {
        if (StrUtil.isNotBlank(path) && (path.startsWith("file:") || FileUtil.isAbsolutePath(path))) {
            return new FileResource(path);
        }
        return new ClassPathResource(path);
    }
}


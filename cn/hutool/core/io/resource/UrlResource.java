/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.InputStream
 *  java.io.Serializable
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.URI
 *  java.net.URL
 */
package cn.hutool.core.io.resource;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.URLUtil;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;

public class UrlResource
implements Resource,
Serializable {
    private static final long serialVersionUID = 1L;
    protected URL url;
    private long lastModified = 0L;
    protected String name;

    public UrlResource(URI uri) {
        this(URLUtil.url(uri), null);
    }

    public UrlResource(URL url) {
        this(url, null);
    }

    public UrlResource(URL url, String name) {
        this.url = url;
        if (null != url && "file".equals((Object)url.getProtocol())) {
            this.lastModified = FileUtil.file(url).lastModified();
        }
        this.name = ObjectUtil.defaultIfNull(name, () -> null != url ? FileUtil.getName(url.getPath()) : null);
    }

    @Deprecated
    public UrlResource(File file) {
        this.url = URLUtil.getURL(file);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public URL getUrl() {
        return this.url;
    }

    @Override
    public InputStream getStream() throws NoResourceException {
        if (null == this.url) {
            throw new NoResourceException("Resource URL is null!");
        }
        return URLUtil.getStream(this.url);
    }

    @Override
    public boolean isModified() {
        return 0L != this.lastModified && this.lastModified != this.getFile().lastModified();
    }

    public File getFile() {
        return FileUtil.file(this.url);
    }

    public String toString() {
        return null == this.url ? "null" : this.url.toString();
    }

    public long size() {
        return URLUtil.size(this.url);
    }
}


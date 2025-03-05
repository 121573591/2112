/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.InputStream
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.URL
 *  java.nio.file.Path
 */
package cn.hutool.core.io.resource;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.URLUtil;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Path;

public class FileResource
implements Resource,
Serializable {
    private static final long serialVersionUID = 1L;
    private final File file;
    private final long lastModified;
    private final String name;

    public FileResource(String path) {
        this(FileUtil.file(path));
    }

    public FileResource(Path path) {
        this(path.toFile());
    }

    public FileResource(File file) {
        this(file, null);
    }

    public FileResource(File file, String fileName) {
        Assert.notNull(file, "File must be not null !", new Object[0]);
        this.file = file;
        this.lastModified = file.lastModified();
        this.name = ObjectUtil.defaultIfNull(fileName, () -> ((File)file).getName());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public URL getUrl() {
        return URLUtil.getURL(this.file);
    }

    @Override
    public InputStream getStream() throws NoResourceException {
        return FileUtil.getInputStream(this.file);
    }

    public File getFile() {
        return this.file;
    }

    @Override
    public boolean isModified() {
        return this.lastModified != this.file.lastModified();
    }

    public String toString() {
        return this.file.toString();
    }
}


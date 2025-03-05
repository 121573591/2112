/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.MalformedURLException
 *  java.net.URL
 *  java.nio.charset.Charset
 *  javax.tools.FileObject
 */
package cn.hutool.core.io.resource;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import javax.tools.FileObject;

public class FileObjectResource
implements Resource {
    private final FileObject fileObject;

    public FileObjectResource(FileObject fileObject) {
        this.fileObject = fileObject;
    }

    public FileObject getFileObject() {
        return this.fileObject;
    }

    @Override
    public String getName() {
        return this.fileObject.getName();
    }

    @Override
    public URL getUrl() {
        try {
            return this.fileObject.toUri().toURL();
        }
        catch (MalformedURLException e) {
            return null;
        }
    }

    @Override
    public InputStream getStream() {
        try {
            return this.fileObject.openInputStream();
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    @Override
    public BufferedReader getReader(Charset charset) {
        try {
            return IoUtil.getReader(this.fileObject.openReader(false));
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }
}


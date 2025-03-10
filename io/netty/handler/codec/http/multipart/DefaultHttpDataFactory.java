/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.AbstractReferenceCounted
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.charset.Charset
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.IdentityHashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 */
package io.netty.handler.codec.http.multipart;

import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.DiskAttribute;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import io.netty.handler.codec.http.multipart.FileUpload;
import io.netty.handler.codec.http.multipart.HttpData;
import io.netty.handler.codec.http.multipart.HttpDataFactory;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.handler.codec.http.multipart.MemoryFileUpload;
import io.netty.handler.codec.http.multipart.MixedAttribute;
import io.netty.handler.codec.http.multipart.MixedFileUpload;
import io.netty.util.AbstractReferenceCounted;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultHttpDataFactory
implements HttpDataFactory {
    public static final long MINSIZE = 16384L;
    public static final long MAXSIZE = -1L;
    private final boolean useDisk;
    private final boolean checkSize;
    private long minSize;
    private long maxSize = -1L;
    private Charset charset = HttpConstants.DEFAULT_CHARSET;
    private String baseDir;
    private boolean deleteOnExit;
    private final Map<HttpRequest, List<HttpData>> requestFileDeleteMap = Collections.synchronizedMap((Map)new IdentityHashMap());

    public DefaultHttpDataFactory() {
        this.useDisk = false;
        this.checkSize = true;
        this.minSize = 16384L;
    }

    public DefaultHttpDataFactory(Charset charset) {
        this();
        this.charset = charset;
    }

    public DefaultHttpDataFactory(boolean useDisk) {
        this.useDisk = useDisk;
        this.checkSize = false;
    }

    public DefaultHttpDataFactory(boolean useDisk, Charset charset) {
        this(useDisk);
        this.charset = charset;
    }

    public DefaultHttpDataFactory(long minSize) {
        this.useDisk = false;
        this.checkSize = true;
        this.minSize = minSize;
    }

    public DefaultHttpDataFactory(long minSize, Charset charset) {
        this(minSize);
        this.charset = charset;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public void setDeleteOnExit(boolean deleteOnExit) {
        this.deleteOnExit = deleteOnExit;
    }

    @Override
    public void setMaxLimit(long maxSize) {
        this.maxSize = maxSize;
    }

    private List<HttpData> getList(HttpRequest request) {
        List list = (List)this.requestFileDeleteMap.get((Object)request);
        if (list == null) {
            list = new ArrayList();
            this.requestFileDeleteMap.put((Object)request, (Object)list);
        }
        return list;
    }

    @Override
    public Attribute createAttribute(HttpRequest request, String name) {
        if (this.useDisk) {
            DiskAttribute attribute = new DiskAttribute(name, this.charset, this.baseDir, this.deleteOnExit);
            attribute.setMaxSize(this.maxSize);
            List<HttpData> list = this.getList(request);
            list.add((Object)attribute);
            return attribute;
        }
        if (this.checkSize) {
            MixedAttribute attribute = new MixedAttribute(name, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
            attribute.setMaxSize(this.maxSize);
            List<HttpData> list = this.getList(request);
            list.add((Object)attribute);
            return attribute;
        }
        MemoryAttribute attribute = new MemoryAttribute(name);
        attribute.setMaxSize(this.maxSize);
        return attribute;
    }

    @Override
    public Attribute createAttribute(HttpRequest request, String name, long definedSize) {
        if (this.useDisk) {
            DiskAttribute attribute = new DiskAttribute(name, definedSize, this.charset, this.baseDir, this.deleteOnExit);
            attribute.setMaxSize(this.maxSize);
            List<HttpData> list = this.getList(request);
            list.add((Object)attribute);
            return attribute;
        }
        if (this.checkSize) {
            MixedAttribute attribute = new MixedAttribute(name, definedSize, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
            attribute.setMaxSize(this.maxSize);
            List<HttpData> list = this.getList(request);
            list.add((Object)attribute);
            return attribute;
        }
        MemoryAttribute attribute = new MemoryAttribute(name, definedSize);
        attribute.setMaxSize(this.maxSize);
        return attribute;
    }

    private static void checkHttpDataSize(HttpData data) {
        try {
            data.checkSize(data.length());
        }
        catch (IOException ignored) {
            throw new IllegalArgumentException("Attribute bigger than maxSize allowed");
        }
    }

    @Override
    public Attribute createAttribute(HttpRequest request, String name, String value) {
        if (this.useDisk) {
            AbstractReferenceCounted attribute;
            try {
                attribute = new DiskAttribute(name, value, this.charset, this.baseDir, this.deleteOnExit);
                attribute.setMaxSize(this.maxSize);
            }
            catch (IOException e) {
                attribute = new MixedAttribute(name, value, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
                attribute.setMaxSize(this.maxSize);
            }
            DefaultHttpDataFactory.checkHttpDataSize(attribute);
            List<HttpData> list = this.getList(request);
            list.add((Object)attribute);
            return attribute;
        }
        if (this.checkSize) {
            MixedAttribute attribute = new MixedAttribute(name, value, this.minSize, this.charset, this.baseDir, this.deleteOnExit);
            attribute.setMaxSize(this.maxSize);
            DefaultHttpDataFactory.checkHttpDataSize(attribute);
            List<HttpData> list = this.getList(request);
            list.add((Object)attribute);
            return attribute;
        }
        try {
            MemoryAttribute attribute = new MemoryAttribute(name, value, this.charset);
            attribute.setMaxSize(this.maxSize);
            DefaultHttpDataFactory.checkHttpDataSize(attribute);
            return attribute;
        }
        catch (IOException e) {
            throw new IllegalArgumentException((Throwable)e);
        }
    }

    @Override
    public FileUpload createFileUpload(HttpRequest request, String name, String filename, String contentType, String contentTransferEncoding, Charset charset, long size) {
        if (this.useDisk) {
            DiskFileUpload fileUpload = new DiskFileUpload(name, filename, contentType, contentTransferEncoding, charset, size, this.baseDir, this.deleteOnExit);
            fileUpload.setMaxSize(this.maxSize);
            DefaultHttpDataFactory.checkHttpDataSize(fileUpload);
            List<HttpData> list = this.getList(request);
            list.add((Object)fileUpload);
            return fileUpload;
        }
        if (this.checkSize) {
            MixedFileUpload fileUpload = new MixedFileUpload(name, filename, contentType, contentTransferEncoding, charset, size, this.minSize, this.baseDir, this.deleteOnExit);
            fileUpload.setMaxSize(this.maxSize);
            DefaultHttpDataFactory.checkHttpDataSize(fileUpload);
            List<HttpData> list = this.getList(request);
            list.add((Object)fileUpload);
            return fileUpload;
        }
        MemoryFileUpload fileUpload = new MemoryFileUpload(name, filename, contentType, contentTransferEncoding, charset, size);
        fileUpload.setMaxSize(this.maxSize);
        DefaultHttpDataFactory.checkHttpDataSize(fileUpload);
        return fileUpload;
    }

    @Override
    public void removeHttpDataFromClean(HttpRequest request, InterfaceHttpData data) {
        if (!(data instanceof HttpData)) {
            return;
        }
        List list = (List)this.requestFileDeleteMap.get((Object)request);
        if (list == null) {
            return;
        }
        Iterator i = list.iterator();
        while (i.hasNext()) {
            HttpData n = (HttpData)i.next();
            if (n != data) continue;
            i.remove();
            if (list.isEmpty()) {
                this.requestFileDeleteMap.remove((Object)request);
            }
            return;
        }
    }

    @Override
    public void cleanRequestHttpData(HttpRequest request) {
        List list = (List)this.requestFileDeleteMap.remove((Object)request);
        if (list != null) {
            for (HttpData data : list) {
                data.release();
            }
        }
    }

    @Override
    public void cleanAllHttpData() {
        Iterator i = this.requestFileDeleteMap.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry e = (Map.Entry)i.next();
            List list = (List)e.getValue();
            for (HttpData data : list) {
                data.release();
            }
            i.remove();
        }
    }

    @Override
    public void cleanRequestHttpDatas(HttpRequest request) {
        this.cleanRequestHttpData(request);
    }

    @Override
    public void cleanAllHttpDatas() {
        this.cleanAllHttpData();
    }
}


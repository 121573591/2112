/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.net.URL
 */
package cn.hutool.http;

import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.lang.Assert;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

public class HttpResource
implements Resource,
Serializable {
    private static final long serialVersionUID = 1L;
    private final Resource resource;
    private final String contentType;

    public HttpResource(Resource resource, String contentType) {
        this.resource = Assert.notNull(resource, "Resource must be not null !", new Object[0]);
        this.contentType = contentType;
    }

    @Override
    public String getName() {
        return this.resource.getName();
    }

    @Override
    public URL getUrl() {
        return this.resource.getUrl();
    }

    @Override
    public InputStream getStream() {
        return this.resource.getStream();
    }

    public String getContentType() {
        return this.contentType;
    }
}


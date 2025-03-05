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
package cn.hutool.core.io.resource;

import cn.hutool.core.io.resource.Resource;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

public class InputStreamResource
implements Resource,
Serializable {
    private static final long serialVersionUID = 1L;
    private final InputStream in;
    private final String name;

    public InputStreamResource(InputStream in) {
        this(in, null);
    }

    public InputStreamResource(InputStream in, String name) {
        this.in = in;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public InputStream getStream() {
        return this.in;
    }
}


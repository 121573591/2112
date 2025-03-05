/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.http.body;

import cn.hutool.core.io.resource.Resource;
import cn.hutool.http.body.RequestBody;
import java.io.OutputStream;

public class ResourceBody
implements RequestBody {
    private final Resource resource;

    public static ResourceBody create(Resource resource) {
        return new ResourceBody(resource);
    }

    public ResourceBody(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void write(OutputStream out) {
        if (null != this.resource) {
            this.resource.writeTo(out);
        }
    }

    public String toString() {
        return this.resource.readUtf8Str();
    }
}


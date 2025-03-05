/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.InputStream
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.Object
 *  java.lang.String
 *  org.apache.velocity.exception.ResourceNotFoundException
 *  org.apache.velocity.runtime.resource.Resource
 *  org.apache.velocity.runtime.resource.loader.ResourceLoader
 *  org.apache.velocity.util.ExtProperties
 */
package cn.hutool.extra.template.engine.velocity;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;
import org.apache.velocity.util.ExtProperties;

public class SimpleStringResourceLoader
extends ResourceLoader {
    public void init(ExtProperties configuration) {
    }

    public InputStream getResourceStream(String source2) throws ResourceNotFoundException {
        return IoUtil.toStream(source2, CharsetUtil.CHARSET_UTF_8);
    }

    public Reader getResourceReader(String source2, String encoding) throws ResourceNotFoundException {
        return new StringReader(source2);
    }

    public boolean isSourceModified(Resource resource) {
        return false;
    }

    public long getLastModified(Resource resource) {
        return 0L;
    }
}


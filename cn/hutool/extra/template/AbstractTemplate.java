/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedOutputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.OutputStream
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 */
package cn.hutool.extra.template;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.template.Template;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public abstract class AbstractTemplate
implements Template {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void render(Map<?, ?> bindingMap, File file) {
        BufferedOutputStream out = null;
        try {
            out = FileUtil.getOutputStream(file);
            this.render(bindingMap, (OutputStream)out);
        }
        finally {
            IoUtil.close((Closeable)out);
        }
    }

    @Override
    public String render(Map<?, ?> bindingMap) {
        StringWriter writer = new StringWriter();
        this.render(bindingMap, (Writer)writer);
        return writer.toString();
    }
}


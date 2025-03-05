/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.OutputStream
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package cn.hutool.extra.template;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

public interface Template {
    public void render(Map<?, ?> var1, Writer var2);

    public void render(Map<?, ?> var1, OutputStream var2);

    public void render(Map<?, ?> var1, File var2);

    public String render(Map<?, ?> var1);
}


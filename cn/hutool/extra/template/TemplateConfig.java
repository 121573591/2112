/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 *  java.util.Objects
 */
package cn.hutool.extra.template;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.extra.template.TemplateEngine;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Objects;

public class TemplateConfig
implements Serializable {
    private static final long serialVersionUID = 2933113779920339523L;
    public static final TemplateConfig DEFAULT = new TemplateConfig();
    private Charset charset;
    private String path;
    private ResourceMode resourceMode;
    private Class<? extends TemplateEngine> customEngine;

    public TemplateConfig() {
        this(null);
    }

    public TemplateConfig(String path) {
        this(path, ResourceMode.STRING);
    }

    public TemplateConfig(String path, ResourceMode resourceMode) {
        this(CharsetUtil.CHARSET_UTF_8, path, resourceMode);
    }

    public TemplateConfig(Charset charset, String path, ResourceMode resourceMode) {
        this.charset = charset;
        this.path = path;
        this.resourceMode = resourceMode;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getCharsetStr() {
        if (null == this.charset) {
            return null;
        }
        return this.charset.toString();
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ResourceMode getResourceMode() {
        return this.resourceMode;
    }

    public void setResourceMode(ResourceMode resourceMode) {
        this.resourceMode = resourceMode;
    }

    public Class<? extends TemplateEngine> getCustomEngine() {
        return this.customEngine;
    }

    public TemplateConfig setCustomEngine(Class<? extends TemplateEngine> customEngine) {
        this.customEngine = customEngine;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        TemplateConfig that = (TemplateConfig)o;
        return Objects.equals((Object)this.charset, (Object)that.charset) && Objects.equals((Object)this.path, (Object)that.path) && this.resourceMode == that.resourceMode && Objects.equals(this.customEngine, that.customEngine);
    }

    public int hashCode() {
        return Objects.hash((Object[])new Object[]{this.charset, this.path, this.resourceMode, this.customEngine});
    }

    public static enum ResourceMode {
        CLASSPATH,
        FILE,
        WEB_ROOT,
        STRING,
        COMPOSITE;

    }
}


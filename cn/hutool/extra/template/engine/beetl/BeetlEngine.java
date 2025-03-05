/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  org.beetl.core.Configuration
 *  org.beetl.core.GroupTemplate
 *  org.beetl.core.ResourceLoader
 *  org.beetl.core.resource.ClasspathResourceLoader
 *  org.beetl.core.resource.CompositeResourceLoader
 *  org.beetl.core.resource.FileResourceLoader
 *  org.beetl.core.resource.StringTemplateResourceLoader
 *  org.beetl.core.resource.WebAppResourceLoader
 */
package cn.hutool.extra.template.engine.beetl;

import cn.hutool.core.io.IORuntimeException;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.engine.beetl.BeetlTemplate;
import java.io.IOException;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ResourceLoader;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.CompositeResourceLoader;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;

public class BeetlEngine
implements TemplateEngine {
    private GroupTemplate engine;

    public BeetlEngine() {
    }

    public BeetlEngine(TemplateConfig config) {
        this.init(config);
    }

    public BeetlEngine(GroupTemplate engine) {
        this.init(engine);
    }

    @Override
    public TemplateEngine init(TemplateConfig config) {
        this.init(BeetlEngine.createEngine(config));
        return this;
    }

    private void init(GroupTemplate engine) {
        this.engine = engine;
    }

    @Override
    public Template getTemplate(String resource) {
        if (null == this.engine) {
            this.init(TemplateConfig.DEFAULT);
        }
        return BeetlTemplate.wrap(this.engine.getTemplate((Object)resource));
    }

    public GroupTemplate getRawEngine() {
        return this.engine;
    }

    private static GroupTemplate createEngine(TemplateConfig config) {
        if (null == config) {
            config = TemplateConfig.DEFAULT;
        }
        switch (config.getResourceMode()) {
            case CLASSPATH: {
                return BeetlEngine.createGroupTemplate(new ClasspathResourceLoader(config.getPath(), config.getCharsetStr()));
            }
            case FILE: {
                return BeetlEngine.createGroupTemplate(new FileResourceLoader(config.getPath(), config.getCharsetStr()));
            }
            case WEB_ROOT: {
                return BeetlEngine.createGroupTemplate(new WebAppResourceLoader(config.getPath(), config.getCharsetStr()));
            }
            case STRING: {
                return BeetlEngine.createGroupTemplate(new StringTemplateResourceLoader());
            }
            case COMPOSITE: {
                return BeetlEngine.createGroupTemplate(new CompositeResourceLoader());
            }
        }
        return new GroupTemplate();
    }

    private static GroupTemplate createGroupTemplate(ResourceLoader<?> loader) {
        try {
            return BeetlEngine.createGroupTemplate(loader, Configuration.defaultConfiguration());
        }
        catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    private static GroupTemplate createGroupTemplate(ResourceLoader<?> loader, Configuration conf) {
        return new GroupTemplate(loader, conf);
    }
}


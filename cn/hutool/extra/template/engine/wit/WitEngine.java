/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 *  org.febit.wit.Engine
 *  org.febit.wit.exceptions.ResourceNotFoundException
 *  org.febit.wit.util.Props
 */
package cn.hutool.extra.template.engine.wit;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateException;
import cn.hutool.extra.template.engine.wit.WitTemplate;
import java.io.File;
import java.util.Map;
import org.febit.wit.Engine;
import org.febit.wit.exceptions.ResourceNotFoundException;
import org.febit.wit.util.Props;

public class WitEngine
implements TemplateEngine {
    private Engine engine;

    public WitEngine() {
    }

    public WitEngine(TemplateConfig config) {
        this.init(config);
    }

    public WitEngine(Engine engine) {
        this.init(engine);
    }

    @Override
    public TemplateEngine init(TemplateConfig config) {
        this.init(WitEngine.createEngine(config));
        return this;
    }

    private void init(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Template getTemplate(String resource) {
        if (null == this.engine) {
            this.init(TemplateConfig.DEFAULT);
        }
        try {
            return WitTemplate.wrap(this.engine.getTemplate(resource));
        }
        catch (ResourceNotFoundException e) {
            throw new TemplateException(e);
        }
    }

    public Engine getRawEngine() {
        return this.engine;
    }

    private static Engine createEngine(TemplateConfig config) {
        Props configProps = Engine.createConfigProps((String)"");
        Dict dict = null;
        if (null != config) {
            dict = Dict.create();
            dict.set("DEFAULT_ENCODING", config.getCharset());
            switch (config.getResourceMode()) {
                case CLASSPATH: {
                    configProps.set("pathLoader.root", config.getPath());
                    configProps.set("routeLoader.defaultLoader", "classpathLoader");
                    break;
                }
                case STRING: {
                    configProps.set("routeLoader.defaultLoader", "stringLoader");
                    break;
                }
                case FILE: {
                    configProps.set("pathLoader.root", config.getPath());
                    configProps.set("routeLoader.defaultLoader", "fileLoader");
                    break;
                }
                case WEB_ROOT: {
                    File root = FileUtil.file(FileUtil.getWebRoot(), config.getPath());
                    configProps.set("pathLoader.root", FileUtil.getAbsolutePath(root));
                    configProps.set("routeLoader.defaultLoader", "fileLoader");
                }
            }
        }
        return Engine.create((Props)configProps, (Map)dict);
    }
}


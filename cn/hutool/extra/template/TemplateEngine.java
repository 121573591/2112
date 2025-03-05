/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.extra.template;

import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;

public interface TemplateEngine {
    public TemplateEngine init(TemplateConfig var1);

    public Template getTemplate(String var1);
}


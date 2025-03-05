/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jfinal.template.Template
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Map
 */
package cn.hutool.extra.template.engine.enjoy;

import cn.hutool.extra.template.AbstractTemplate;
import com.jfinal.template.Template;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.Map;

public class EnjoyTemplate
extends AbstractTemplate
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Template rawTemplate;

    public static EnjoyTemplate wrap(Template EnjoyTemplate2) {
        return null == EnjoyTemplate2 ? null : new EnjoyTemplate(EnjoyTemplate2);
    }

    public EnjoyTemplate(Template EnjoyTemplate2) {
        this.rawTemplate = EnjoyTemplate2;
    }

    @Override
    public void render(Map<?, ?> bindingMap, Writer writer) {
        this.rawTemplate.render(bindingMap, writer);
    }

    @Override
    public void render(Map<?, ?> bindingMap, OutputStream out) {
        this.rawTemplate.render(bindingMap, out);
    }
}


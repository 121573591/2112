/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.io.Serializable
 *  java.io.Writer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 *  jetbrick.template.JetTemplate
 */
package cn.hutool.extra.template.engine.jetbrick;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.extra.template.AbstractTemplate;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.Map;
import jetbrick.template.JetTemplate;

public class JetbrickTemplate
extends AbstractTemplate
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final JetTemplate rawTemplate;

    public static JetbrickTemplate wrap(JetTemplate jetTemplate) {
        return null == jetTemplate ? null : new JetbrickTemplate(jetTemplate);
    }

    public JetbrickTemplate(JetTemplate jetTemplate) {
        this.rawTemplate = jetTemplate;
    }

    @Override
    public void render(Map<?, ?> bindingMap, Writer writer) {
        Map<String, Object> map = Convert.convert(new TypeReference<Map<String, Object>>(){}, bindingMap);
        this.rawTemplate.render(map, writer);
    }

    @Override
    public void render(Map<?, ?> bindingMap, OutputStream out) {
        Map<String, Object> map = Convert.convert(new TypeReference<Map<String, Object>>(){}, bindingMap);
        this.rawTemplate.render(map, out);
    }
}


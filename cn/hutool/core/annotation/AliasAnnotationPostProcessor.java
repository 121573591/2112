/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.annotation.AnnotationAttribute;
import cn.hutool.core.annotation.AnnotationSynthesizer;
import cn.hutool.core.annotation.ForceAliasedAnnotationAttribute;
import cn.hutool.core.annotation.SynthesizedAnnotation;
import cn.hutool.core.annotation.SynthesizedAnnotationPostProcessor;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.map.LinkedForestMap;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import java.util.Map;

public class AliasAnnotationPostProcessor
implements SynthesizedAnnotationPostProcessor {
    @Override
    public int order() {
        return Integer.MIN_VALUE;
    }

    @Override
    public void process(SynthesizedAnnotation synthesizedAnnotation, AnnotationSynthesizer synthesizer) {
        Map<String, AnnotationAttribute> attributeMap = synthesizedAnnotation.getAttributes();
        LinkedForestMap attributeAliasMappings = new LinkedForestMap(false);
        attributeMap.forEach((attributeName, attribute) -> {
            String alias = Opt.ofNullable(attribute.getAnnotation(Alias.class)).map(Alias::value).orElse(null);
            if (ObjectUtil.isNull(alias)) {
                return;
            }
            AnnotationAttribute aliasAttribute = (AnnotationAttribute)attributeMap.get((Object)alias);
            Assert.notNull(aliasAttribute, "no method for alias: [{}]", alias);
            attributeAliasMappings.putLinkedNodes(alias, aliasAttribute, attributeName, attribute);
        });
        attributeMap.forEach((attributeName, attribute) -> {
            AnnotationAttribute resolvedAttribute = Opt.ofNullable(attributeName).map(attributeAliasMappings::getRootNode).map(Map.Entry::getValue).orElse(attribute);
            Assert.isTrue(ObjectUtil.isNull(resolvedAttribute) || ClassUtil.isAssignable(attribute.getAttributeType(), resolvedAttribute.getAttributeType()), "return type of the root alias method [{}] is inconsistent with the original [{}]", resolvedAttribute.getClass(), attribute.getAttributeType());
            if (attribute != resolvedAttribute) {
                attributeMap.put(attributeName, (Object)new ForceAliasedAnnotationAttribute((AnnotationAttribute)attribute, resolvedAttribute));
            }
        });
        synthesizedAnnotation.setAttributes(attributeMap);
    }
}


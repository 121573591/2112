/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.function.BinaryOperator
 *  java.util.function.UnaryOperator
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AbstractLinkAnnotationPostProcessor;
import cn.hutool.core.annotation.AbstractWrappedAnnotationAttribute;
import cn.hutool.core.annotation.AliasedAnnotationAttribute;
import cn.hutool.core.annotation.AnnotationAttribute;
import cn.hutool.core.annotation.AnnotationSynthesizer;
import cn.hutool.core.annotation.ForceAliasedAnnotationAttribute;
import cn.hutool.core.annotation.Link;
import cn.hutool.core.annotation.RelationType;
import cn.hutool.core.annotation.SynthesizedAnnotation;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.Opt;
import cn.hutool.core.util.ObjectUtil;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class AliasLinkAnnotationPostProcessor
extends AbstractLinkAnnotationPostProcessor {
    private static final RelationType[] PROCESSED_RELATION_TYPES = new RelationType[]{RelationType.ALIAS_FOR, RelationType.FORCE_ALIAS_FOR};

    @Override
    public int order() {
        return -2147483646;
    }

    @Override
    protected RelationType[] processTypes() {
        return PROCESSED_RELATION_TYPES;
    }

    @Override
    protected void processLinkedAttribute(AnnotationSynthesizer synthesizer, Link annotation, SynthesizedAnnotation originalAnnotation, AnnotationAttribute originalAttribute, SynthesizedAnnotation linkedAnnotation, AnnotationAttribute linkedAttribute) {
        this.checkAliasRelation(annotation, originalAttribute, linkedAttribute);
        if (RelationType.ALIAS_FOR.equals((Object)annotation.type())) {
            this.wrappingLinkedAttribute(synthesizer, originalAttribute, linkedAttribute, (BinaryOperator<AnnotationAttribute>)((BinaryOperator)AliasedAnnotationAttribute::new));
            return;
        }
        this.wrappingLinkedAttribute(synthesizer, originalAttribute, linkedAttribute, (BinaryOperator<AnnotationAttribute>)((BinaryOperator)ForceAliasedAnnotationAttribute::new));
    }

    private void wrappingLinkedAttribute(AnnotationSynthesizer synthesizer, AnnotationAttribute originalAttribute, AnnotationAttribute aliasAttribute, BinaryOperator<AnnotationAttribute> wrapping) {
        if (!aliasAttribute.isWrapped()) {
            this.processAttribute(synthesizer, originalAttribute, aliasAttribute, wrapping);
            return;
        }
        AbstractWrappedAnnotationAttribute wrapper = (AbstractWrappedAnnotationAttribute)aliasAttribute;
        wrapper.getAllLinkedNonWrappedAttributes().forEach(t -> this.processAttribute(synthesizer, originalAttribute, (AnnotationAttribute)t, wrapping));
    }

    private void processAttribute(AnnotationSynthesizer synthesizer, AnnotationAttribute originalAttribute, AnnotationAttribute target, BinaryOperator<AnnotationAttribute> wrapping) {
        Opt.ofNullable(target.getAnnotationType()).map(synthesizer::getSynthesizedAnnotation).ifPresent(t -> t.replaceAttribute(target.getAttributeName(), (UnaryOperator<AnnotationAttribute>)((UnaryOperator)old -> (AnnotationAttribute)wrapping.apply(old, (Object)originalAttribute))));
    }

    private void checkAliasRelation(Link annotation, AnnotationAttribute originalAttribute, AnnotationAttribute linkedAttribute) {
        this.checkLinkedAttributeNotNull(originalAttribute, linkedAttribute, annotation);
        this.checkAttributeType(originalAttribute, linkedAttribute);
        this.checkCircularDependency(originalAttribute, linkedAttribute);
    }

    private void checkCircularDependency(AnnotationAttribute original, AnnotationAttribute alias) {
        this.checkLinkedSelf(original, alias);
        Link annotation = this.getLinkAnnotation(alias, RelationType.ALIAS_FOR, RelationType.FORCE_ALIAS_FOR);
        if (ObjectUtil.isNull(annotation)) {
            return;
        }
        Class<?> aliasAnnotationType = this.getLinkedAnnotationType(annotation, alias.getAnnotationType());
        if (ObjectUtil.notEqual(aliasAnnotationType, original.getAnnotationType())) {
            return;
        }
        Assert.notEquals(annotation.attribute(), original.getAttributeName(), "circular reference between the alias attribute [{}] and the original attribute [{}]", alias.getAttribute(), original.getAttribute());
    }
}


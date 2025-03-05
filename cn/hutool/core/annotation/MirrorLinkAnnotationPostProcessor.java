/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AbstractLinkAnnotationPostProcessor;
import cn.hutool.core.annotation.AnnotationAttribute;
import cn.hutool.core.annotation.AnnotationSynthesizer;
import cn.hutool.core.annotation.Link;
import cn.hutool.core.annotation.MirroredAnnotationAttribute;
import cn.hutool.core.annotation.RelationType;
import cn.hutool.core.annotation.SynthesizedAnnotation;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;

public class MirrorLinkAnnotationPostProcessor
extends AbstractLinkAnnotationPostProcessor {
    private static final RelationType[] PROCESSED_RELATION_TYPES = new RelationType[]{RelationType.MIRROR_FOR};

    @Override
    public int order() {
        return -2147483647;
    }

    @Override
    protected RelationType[] processTypes() {
        return PROCESSED_RELATION_TYPES;
    }

    @Override
    protected void processLinkedAttribute(AnnotationSynthesizer synthesizer, Link annotation, SynthesizedAnnotation originalAnnotation, AnnotationAttribute originalAttribute, SynthesizedAnnotation linkedAnnotation, AnnotationAttribute linkedAttribute) {
        if (originalAttribute instanceof MirroredAnnotationAttribute || linkedAttribute instanceof MirroredAnnotationAttribute) {
            this.checkMirrored(originalAttribute, linkedAttribute);
            return;
        }
        this.checkMirrorRelation(annotation, originalAttribute, linkedAttribute);
        MirroredAnnotationAttribute mirroredOriginalAttribute = new MirroredAnnotationAttribute(originalAttribute, linkedAttribute);
        originalAnnotation.setAttribute(originalAttribute.getAttributeName(), mirroredOriginalAttribute);
        MirroredAnnotationAttribute mirroredTargetAttribute = new MirroredAnnotationAttribute(linkedAttribute, originalAttribute);
        linkedAnnotation.setAttribute(annotation.attribute(), mirroredTargetAttribute);
    }

    private void checkMirrored(AnnotationAttribute original, AnnotationAttribute mirror) {
        boolean passed;
        boolean originalAttributeMirrored = original instanceof MirroredAnnotationAttribute;
        boolean mirrorAttributeMirrored = mirror instanceof MirroredAnnotationAttribute;
        boolean bl = passed = originalAttributeMirrored && mirrorAttributeMirrored && ObjectUtil.equals(((MirroredAnnotationAttribute)original).getLinked(), ((MirroredAnnotationAttribute)mirror).getOriginal());
        if (passed) {
            return;
        }
        String errorMsg = originalAttributeMirrored && !mirrorAttributeMirrored ? CharSequenceUtil.format("attribute [{}] cannot mirror for [{}], because it's already mirrored for [{}]", original.getAttribute(), mirror.getAttribute(), ((MirroredAnnotationAttribute)original).getLinked()) : (!originalAttributeMirrored && mirrorAttributeMirrored ? CharSequenceUtil.format("attribute [{}] cannot mirror for [{}], because it's already mirrored for [{}]", mirror.getAttribute(), original.getAttribute(), ((MirroredAnnotationAttribute)mirror).getLinked()) : CharSequenceUtil.format("attribute [{}] cannot mirror for [{}], because [{}] already mirrored for [{}] and  [{}] already mirrored for [{}]", mirror.getAttribute(), original.getAttribute(), mirror.getAttribute(), ((MirroredAnnotationAttribute)mirror).getLinked(), original.getAttribute(), ((MirroredAnnotationAttribute)original).getLinked()));
        throw new IllegalArgumentException(errorMsg);
    }

    private void checkMirrorRelation(Link annotation, AnnotationAttribute original, AnnotationAttribute mirror) {
        this.checkLinkedAttributeNotNull(original, mirror, annotation);
        this.checkAttributeType(original, mirror);
        Link mirrorAttributeAnnotation = this.getLinkAnnotation(mirror, RelationType.MIRROR_FOR);
        Assert.isTrue(ObjectUtil.isNotNull(mirrorAttributeAnnotation) && RelationType.MIRROR_FOR.equals((Object)mirrorAttributeAnnotation.type()), "mirror attribute [{}] of original attribute [{}] must marked by @Link, and also @LinkType.type() must is [{}]", new Object[]{mirror.getAttribute(), original.getAttribute(), RelationType.MIRROR_FOR});
        this.checkLinkedSelf(original, mirror);
    }
}


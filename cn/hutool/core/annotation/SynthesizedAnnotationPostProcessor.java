/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Comparable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.util.Comparator
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AliasAnnotationPostProcessor;
import cn.hutool.core.annotation.AliasLinkAnnotationPostProcessor;
import cn.hutool.core.annotation.AnnotationSynthesizer;
import cn.hutool.core.annotation.MirrorLinkAnnotationPostProcessor;
import cn.hutool.core.annotation.SynthesizedAnnotation;
import cn.hutool.core.comparator.CompareUtil;
import java.util.Comparator;

public interface SynthesizedAnnotationPostProcessor
extends Comparable<SynthesizedAnnotationPostProcessor> {
    public static final AliasAnnotationPostProcessor ALIAS_ANNOTATION_POST_PROCESSOR = new AliasAnnotationPostProcessor();
    public static final MirrorLinkAnnotationPostProcessor MIRROR_LINK_ANNOTATION_POST_PROCESSOR = new MirrorLinkAnnotationPostProcessor();
    public static final AliasLinkAnnotationPostProcessor ALIAS_LINK_ANNOTATION_POST_PROCESSOR = new AliasLinkAnnotationPostProcessor();

    default public int order() {
        return Integer.MAX_VALUE;
    }

    default public int compareTo(SynthesizedAnnotationPostProcessor o) {
        return CompareUtil.compare(this, o, Comparator.comparing(SynthesizedAnnotationPostProcessor::order));
    }

    public void process(SynthesizedAnnotation var1, AnnotationSynthesizer var2);
}


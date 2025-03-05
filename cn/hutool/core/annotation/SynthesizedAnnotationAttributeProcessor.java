/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.FunctionalInterface
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.SynthesizedAnnotation;
import java.util.Collection;

@FunctionalInterface
public interface SynthesizedAnnotationAttributeProcessor {
    public <R> R getAttributeValue(String var1, Class<R> var2, Collection<? extends SynthesizedAnnotation> var3);
}


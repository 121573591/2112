/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.annotation.Annotation
 *  java.util.Collection
 *  java.util.Comparator
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Objects
 */
package cn.hutool.core.annotation;

import cn.hutool.core.annotation.AnnotationSynthesizer;
import cn.hutool.core.annotation.SynthesizedAnnotation;
import cn.hutool.core.annotation.SynthesizedAnnotationPostProcessor;
import cn.hutool.core.annotation.SynthesizedAnnotationSelector;
import cn.hutool.core.annotation.scanner.AnnotationScanner;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractAnnotationSynthesizer<T>
implements AnnotationSynthesizer {
    protected final T source;
    protected final Map<Class<? extends Annotation>, SynthesizedAnnotation> synthesizedAnnotationMap;
    private final Map<Class<? extends Annotation>, Annotation> synthesizedProxyAnnotations;
    protected final SynthesizedAnnotationSelector annotationSelector;
    protected final Collection<SynthesizedAnnotationPostProcessor> postProcessors;
    protected final AnnotationScanner annotationScanner;

    protected AbstractAnnotationSynthesizer(T source2, SynthesizedAnnotationSelector annotationSelector, Collection<SynthesizedAnnotationPostProcessor> annotationPostProcessors, AnnotationScanner annotationScanner) {
        Assert.notNull(source2, "source must not null", new Object[0]);
        Assert.notNull(annotationSelector, "annotationSelector must not null", new Object[0]);
        Assert.notNull(annotationPostProcessors, "annotationPostProcessors must not null", new Object[0]);
        Assert.notNull(annotationPostProcessors, "annotationScanner must not null", new Object[0]);
        this.source = source2;
        this.annotationSelector = annotationSelector;
        this.annotationScanner = annotationScanner;
        this.postProcessors = CollUtil.unmodifiable(CollUtil.sort(annotationPostProcessors, Comparator.comparing(SynthesizedAnnotationPostProcessor::order)));
        this.synthesizedProxyAnnotations = new LinkedHashMap();
        this.synthesizedAnnotationMap = MapUtil.unmodifiable(this.loadAnnotations());
        annotationPostProcessors.forEach(processor -> this.synthesizedAnnotationMap.values().forEach(synthesized -> processor.process((SynthesizedAnnotation)synthesized, this)));
    }

    protected abstract Map<Class<? extends Annotation>, SynthesizedAnnotation> loadAnnotations();

    protected abstract <A extends Annotation> A synthesize(Class<A> var1, SynthesizedAnnotation var2);

    public T getSource() {
        return this.source;
    }

    @Override
    public SynthesizedAnnotationSelector getAnnotationSelector() {
        return this.annotationSelector;
    }

    @Override
    public Collection<SynthesizedAnnotationPostProcessor> getAnnotationPostProcessors() {
        return this.postProcessors;
    }

    @Override
    public SynthesizedAnnotation getSynthesizedAnnotation(Class<?> annotationType) {
        return (SynthesizedAnnotation)this.synthesizedAnnotationMap.get(annotationType);
    }

    @Override
    public Map<Class<? extends Annotation>, SynthesizedAnnotation> getAllSynthesizedAnnotation() {
        return this.synthesizedAnnotationMap;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <A extends Annotation> A synthesize(Class<A> annotationType) {
        Object annotation = (Annotation)this.synthesizedProxyAnnotations.get(annotationType);
        if (Objects.nonNull((Object)annotation)) {
            return (A)annotation;
        }
        Map<Class<? extends Annotation>, Annotation> map = this.synthesizedProxyAnnotations;
        synchronized (map) {
            annotation = (Annotation)this.synthesizedProxyAnnotations.get(annotationType);
            if (Objects.isNull((Object)annotation)) {
                SynthesizedAnnotation synthesizedAnnotation = (SynthesizedAnnotation)this.synthesizedAnnotationMap.get(annotationType);
                annotation = this.synthesize(annotationType, synthesizedAnnotation);
                this.synthesizedProxyAnnotations.put(annotationType, annotation);
            }
        }
        return (A)annotation;
    }
}


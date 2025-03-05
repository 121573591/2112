/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.util.function.BiConsumer
 *  java.util.function.Predicate
 *  java.util.stream.Stream
 */
package cn.hutool.core.annotation.scanner;

import cn.hutool.core.annotation.scanner.AnnotationScanner;
import cn.hutool.core.util.ObjectUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ElementAnnotationScanner
implements AnnotationScanner {
    @Override
    public boolean support(AnnotatedElement annotatedEle) {
        return ObjectUtil.isNotNull(annotatedEle);
    }

    @Override
    public void scan(BiConsumer<Integer, Annotation> consumer, AnnotatedElement annotatedEle, Predicate<Annotation> filter) {
        filter = ObjectUtil.defaultIfNull(filter, a -> t -> true);
        Stream.of((Object[])annotatedEle.getAnnotations()).filter(filter).forEach(annotation -> consumer.accept((Object)0, annotation));
    }
}


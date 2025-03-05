/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.AnnotatedElement
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.function.BiConsumer
 *  java.util.function.Predicate
 *  java.util.stream.Collectors
 *  java.util.stream.Stream
 */
package cn.hutool.core.annotation.scanner;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.annotation.scanner.EmptyAnnotationScanner;
import cn.hutool.core.annotation.scanner.GenericAnnotationScanner;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface AnnotationScanner {
    public static final AnnotationScanner NOTHING = new EmptyAnnotationScanner();
    public static final AnnotationScanner DIRECTLY = new GenericAnnotationScanner(false, false, false);
    public static final AnnotationScanner DIRECTLY_AND_META_ANNOTATION = new GenericAnnotationScanner(true, false, false);
    public static final AnnotationScanner SUPERCLASS = new GenericAnnotationScanner(false, true, false);
    public static final AnnotationScanner SUPERCLASS_AND_META_ANNOTATION = new GenericAnnotationScanner(true, true, false);
    public static final AnnotationScanner INTERFACE = new GenericAnnotationScanner(false, false, true);
    public static final AnnotationScanner INTERFACE_AND_META_ANNOTATION = new GenericAnnotationScanner(true, false, true);
    public static final AnnotationScanner TYPE_HIERARCHY = new GenericAnnotationScanner(false, true, true);
    public static final AnnotationScanner TYPE_HIERARCHY_AND_META_ANNOTATION = new GenericAnnotationScanner(true, true, true);

    public static List<Annotation> scanByAnySupported(AnnotatedElement annotatedEle, AnnotationScanner ... scanners) {
        if (ObjectUtil.isNull(annotatedEle) && ArrayUtil.isNotEmpty(scanners)) {
            return Collections.emptyList();
        }
        return (List)Stream.of((Object[])scanners).filter(scanner -> scanner.support(annotatedEle)).findFirst().map(scanner -> scanner.getAnnotations(annotatedEle)).orElseGet(Collections::emptyList);
    }

    public static List<Annotation> scanByAllSupported(AnnotatedElement annotatedEle, AnnotationScanner ... scanners) {
        if (ObjectUtil.isNull(annotatedEle) && ArrayUtil.isNotEmpty(scanners)) {
            return Collections.emptyList();
        }
        return (List)Stream.of((Object[])scanners).map(scanner -> scanner.getAnnotationsIfSupport(annotatedEle)).flatMap(Collection::stream).collect(Collectors.toList());
    }

    default public boolean support(AnnotatedElement annotatedEle) {
        return false;
    }

    default public List<Annotation> getAnnotations(AnnotatedElement annotatedEle) {
        ArrayList annotations = new ArrayList();
        this.scan((BiConsumer<Integer, Annotation>)((BiConsumer)(arg_0, arg_1) -> AnnotationScanner.lambda$getAnnotations$3((List)annotations, arg_0, arg_1)), annotatedEle, null);
        return annotations;
    }

    default public List<Annotation> getAnnotationsIfSupport(AnnotatedElement annotatedEle) {
        return this.support(annotatedEle) ? this.getAnnotations(annotatedEle) : Collections.emptyList();
    }

    default public void scan(BiConsumer<Integer, Annotation> consumer, AnnotatedElement annotatedEle, Predicate<Annotation> filter) {
        filter = ObjectUtil.defaultIfNull(filter, a -> annotation -> true);
        for (Annotation annotation : annotatedEle.getAnnotations()) {
            if (!AnnotationUtil.isNotJdkMateAnnotation((Class<? extends Annotation>)annotation.annotationType()) || !filter.test((Object)annotation)) continue;
            consumer.accept((Object)0, (Object)annotation);
        }
    }

    default public void scanIfSupport(BiConsumer<Integer, Annotation> consumer, AnnotatedElement annotatedEle, Predicate<Annotation> filter) {
        if (this.support(annotatedEle)) {
            this.scan(consumer, annotatedEle, filter);
        }
    }

    private static /* synthetic */ void lambda$getAnnotations$3(List annotations, Integer index, Annotation annotation) {
        annotations.add((Object)annotation);
    }
}

